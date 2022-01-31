package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.liteav.audio.TXCAudioUGCRecorder;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.c.a;
import com.tencent.liteav.f;
import com.tencent.liteav.m;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class TXLivePusher
  implements com.tencent.liteav.basic.c.a, c.a, m, com.tencent.liteav.qos.a
{
  public static final int RGB_BGRA = 4;
  public static final int RGB_RGBA = 5;
  private static final byte SEI_MSG_TYPE = -14;
  private static final String TAG = TXLivePusher.class.getSimpleName();
  public static final int YUV_420P = 3;
  public static final int YUV_420SP = 1;
  public static final int YUV_420YpCbCr = 2;
  private TXLivePusher.AudioCustomProcessListener mAudioProcessListener;
  private float mBgmPitch = 0.0F;
  private com.tencent.liteav.c mCaptureAndEnc = null;
  private TXLivePushConfig mConfig = null;
  private Context mContext = null;
  private com.tencent.liteav.d mDataReport = null;
  private String mID = "";
  private boolean mIsRecording = false;
  private ITXLivePushListener mListener = null;
  private com.tencent.liteav.muxer.c mMP4Muxer = null;
  private Handler mMainHandler = null;
  private ArrayList<TXLivePusher.MsgInfo> mMsgArray = new ArrayList();
  private f mNewConfig = null;
  private boolean mNotifyStatus = false;
  private TXLivePusher.VideoCustomProcessListener mPreprocessListener;
  private String mPushUrl = "";
  private TXCQoS mQos = null;
  private TXRecordCommon.ITXVideoRecordListener mRecordListener;
  private long mRecordStartTime = 0L;
  private Runnable mSnapShotTimeOutRunnable = new TXLivePusher.2(this);
  private boolean mSnapshotRunning = false;
  private boolean mStartMuxer = false;
  private TXCStreamUploader mStreamUploader = null;
  private TXCloudVideoView mTXCloudVideoView;
  private String mVideoFilePath = "";
  private int mVideoQuality = -1;
  private int mVoiceEnvironment = -1;
  private int mVoiceKind = -1;
  
  public TXLivePusher(Context paramContext)
  {
    TXCLog.init();
    this.mNewConfig = new f();
    this.mContext = paramContext.getApplicationContext();
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.mCaptureAndEnc = new com.tencent.liteav.c(this.mContext);
    this.mCaptureAndEnc.a(this);
  }
  
  @TargetApi(16)
  private void addAudioTrack()
  {
    MediaFormat localMediaFormat = com.tencent.liteav.basic.util.a.a(TXCAudioUGCRecorder.getInstance().getSampleRate(), TXCAudioUGCRecorder.getInstance().getChannels(), 2);
    if (this.mMP4Muxer != null) {
      this.mMP4Muxer.b(localMediaFormat);
    }
  }
  
  private byte[] add_emulation_prevention_three_byte(byte[] paramArrayOfByte)
  {
    int n = paramArrayOfByte.length * 4 / 3 + 2;
    byte[] arrayOfByte = new byte[n];
    int i = 0;
    int k;
    for (int j = 0; (i < paramArrayOfByte.length) && (j < n); j = k + 1)
    {
      int m = i;
      k = j;
      if (i + 3 < paramArrayOfByte.length)
      {
        m = i;
        k = j;
        if (paramArrayOfByte[i] == 0)
        {
          m = i;
          k = j;
          if (paramArrayOfByte[(i + 1)] == 0)
          {
            m = i;
            k = j;
            if (paramArrayOfByte[(i + 2)] >= 0)
            {
              m = i;
              k = j;
              if (paramArrayOfByte[(i + 2)] <= 3)
              {
                k = j + 1;
                int i1 = i + 1;
                arrayOfByte[j] = paramArrayOfByte[i];
                i = k + 1;
                m = i1 + 1;
                arrayOfByte[k] = paramArrayOfByte[i1];
                k = i + 1;
                arrayOfByte[i] = 3;
              }
            }
          }
        }
      }
      arrayOfByte[k] = paramArrayOfByte[m];
      i = m + 1;
    }
    paramArrayOfByte = new byte[j];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, j);
    return paramArrayOfByte;
  }
  
  private byte[] appendSEIBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = intToBytes(paramInt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1 + paramArrayOfByte.length + 1];
    arrayOfByte2[0] = -14;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
    paramInt = arrayOfByte1.length + 1;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, paramInt, paramArrayOfByte.length);
    arrayOfByte2[(paramInt + paramArrayOfByte.length)] = -128;
    return arrayOfByte2;
  }
  
  private void applyConfig()
  {
    int i = 5;
    int j = 1;
    if (this.mCaptureAndEnc == null) {}
    label73:
    label78:
    label238:
    label244:
    label249:
    do
    {
      do
      {
        return;
        this.mCaptureAndEnc.a(this.mNewConfig);
        if (this.mCaptureAndEnc.i())
        {
          int m;
          int k;
          if (this.mStreamUploader != null)
          {
            if (!this.mNewConfig.I) {
              break label249;
            }
            m = this.mNewConfig.o;
            k = this.mNewConfig.p;
            if (m >= 5) {
              break label238;
            }
            if (k <= 1) {
              break label244;
            }
            this.mStreamUploader.setRetryInterval(j);
            this.mStreamUploader.setRetryTimes(i);
            this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, 1000);
          }
          for (;;)
          {
            this.mStreamUploader.setSendStrategy(this.mNewConfig.I, this.mNewConfig.J);
            if (this.mQos == null) {
              break;
            }
            this.mQos.stop();
            this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
            this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
            this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
            this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
            if (!this.mNewConfig.g) {
              break;
            }
            this.mQos.start(2000L);
            return;
            i = m;
            break label73;
            j = k;
            break label78;
            this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
            this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
            this.mStreamUploader.setVideoDropParams(true, 40, 3000);
          }
        }
        if ((this.mNewConfig.K & 0x1) == 0) {
          break;
        }
      } while (this.mStreamUploader == null);
      this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
      return;
    } while (this.mStreamUploader == null);
    this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
  }
  
  private void callbackRecordFail()
  {
    this.mMainHandler.post(new TXLivePusher.5(this));
  }
  
  private void callbackRecordSuccess(String paramString1, String paramString2)
  {
    this.mMainHandler.post(new TXLivePusher.6(this, paramString1, paramString2));
  }
  
  private int getAdjustStrategy(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == true)
    {
      if (paramBoolean2 == true) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  private byte[] intToBytes(int paramInt)
  {
    int j = paramInt / 255 + 1;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j - 1)
    {
      arrayOfByte[i] = -1;
      i += 1;
    }
    arrayOfByte[(j - 1)] = ((byte)(paramInt % 255 & 0xFF));
    return arrayOfByte;
  }
  
  private void postBitmapToMainThread(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap)
  {
    if (paramITXSnapshotListener == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new TXLivePusher.8(this, paramITXSnapshotListener, paramBitmap));
  }
  
  private void recordVideoData(b paramb, byte[] paramArrayOfByte)
  {
    if (this.mRecordStartTime == 0L) {
      this.mRecordStartTime = paramb.g;
    }
    long l1 = paramb.g;
    long l2 = this.mRecordStartTime;
    int i;
    if (paramb.k == null)
    {
      if (paramb.b != 0) {
        break label98;
      }
      i = 1;
    }
    for (;;)
    {
      this.mMP4Muxer.b(paramArrayOfByte, 0, paramArrayOfByte.length, paramb.g * 1000L, i);
      this.mMainHandler.post(new Runnable()
      {
        public void run()
        {
          if (TXLivePusher.this.mRecordListener != null) {
            TXLivePusher.this.mRecordListener.onRecordProgress(this.val$progress);
          }
        }
      });
      return;
      i = paramb.k.flags;
      continue;
      label98:
      i = 0;
    }
  }
  
  private void setAdjustStrategy(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = getAdjustStrategy(paramBoolean1, paramBoolean2);
    if (i == -1)
    {
      this.mConfig.setAutoAdjustBitrate(false);
      this.mConfig.setAutoAdjustStrategy(-1);
      return;
    }
    this.mConfig.setAutoAdjustBitrate(true);
    this.mConfig.setAutoAdjustStrategy(i);
  }
  
  private void startDataReportModule()
  {
    this.mDataReport = new com.tencent.liteav.d(this.mContext);
    this.mDataReport.b(this.mID);
    this.mDataReport.a(this.mNewConfig.c);
    this.mDataReport.b(this.mNewConfig.q);
    this.mDataReport.a(this.mNewConfig.a, this.mNewConfig.b);
    this.mDataReport.a(this.mPushUrl);
    this.mDataReport.a();
  }
  
  private void startEncoder()
  {
    if (this.mCaptureAndEnc != null)
    {
      this.mCaptureAndEnc.setID(this.mID);
      this.mCaptureAndEnc.a(this);
      this.mCaptureAndEnc.a(this.mVoiceKind, this.mVoiceEnvironment);
      this.mCaptureAndEnc.b(this.mBgmPitch);
      this.mCaptureAndEnc.e();
    }
  }
  
  private void startNetworkModule()
  {
    int i = 5;
    int j = 1;
    h localh = new h();
    localh.d = com.tencent.liteav.audio.c.a().d();
    localh.e = com.tencent.liteav.audio.c.a().e();
    localh.a = 0;
    localh.c = 20;
    localh.b = 0;
    localh.f = 3;
    localh.j = true;
    localh.l = true;
    localh.k = false;
    localh.h = 40;
    localh.i = 5000;
    localh.m = this.mNewConfig.I;
    localh.n = this.mNewConfig.J;
    this.mStreamUploader = new TXCStreamUploader(this.mContext, localh);
    this.mStreamUploader.setID(this.mID);
    int m;
    int k;
    if ((this.mNewConfig.K & 0x1) != 0)
    {
      if (this.mStreamUploader != null) {
        this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
      }
      this.mStreamUploader.setNotifyListener(this);
      this.mPushUrl = this.mStreamUploader.start(this.mPushUrl, this.mNewConfig.G, this.mNewConfig.H);
      if (this.mNewConfig.F) {
        this.mStreamUploader.setMode(1);
      }
      if (!this.mNewConfig.I) {
        break label370;
      }
      m = this.mNewConfig.o;
      k = this.mNewConfig.p;
      if (m >= 5) {
        break label359;
      }
      label273:
      if (k <= 1) {
        break label365;
      }
      label278:
      this.mStreamUploader.setRetryInterval(j);
      this.mStreamUploader.setRetryTimes(i);
      this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, 1000);
    }
    for (;;)
    {
      this.mStreamUploader.setSendStrategy(this.mNewConfig.I, this.mNewConfig.J);
      return;
      if (this.mStreamUploader == null) {
        break;
      }
      this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
      break;
      label359:
      i = m;
      break label273;
      label365:
      j = k;
      break label278;
      label370:
      this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
      this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
      this.mStreamUploader.setVideoDropParams(true, 40, 3000);
    }
  }
  
  private void startQosModule()
  {
    this.mQos = new TXCQoS(true);
    this.mQos.setListener(this);
    this.mQos.setNotifyListener(this);
    this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
    this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
    this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
    this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
    if (this.mNewConfig.g) {
      this.mQos.start(2000L);
    }
  }
  
  private void startStatusNotify()
  {
    this.mNotifyStatus = true;
    if (this.mMainHandler != null) {
      this.mMainHandler.postDelayed(new TXLivePusher.9(this), 2000L);
    }
  }
  
  private void statusNotify()
  {
    Object localObject = com.tencent.liteav.basic.util.a.a();
    int i = localObject[0] / 10;
    int j = localObject[1] / 10;
    localObject = i + "/" + j + "%";
    i = TXCStatus.d(this.mID, 7004);
    j = TXCStatus.d(this.mID, 7003);
    int k = TXCStatus.d(this.mID, 7002);
    int m = TXCStatus.d(this.mID, 7001);
    int n = TXCStatus.d(this.mID, 7007);
    int i1 = TXCStatus.d(this.mID, 7005);
    int i2 = TXCStatus.d(this.mID, 7006);
    String str = TXCStatus.c(this.mID, 7012);
    double d2 = TXCStatus.e(this.mID, 4001);
    int i3 = TXCStatus.d(this.mID, 4003);
    Bundle localBundle = new Bundle();
    localBundle.putInt("NET_SPEED", i + j);
    localBundle.putInt("VIDEO_FPS", (int)d2);
    double d1 = d2;
    if (d2 < 1.0D) {
      d1 = 15.0D;
    }
    localBundle.putInt("VIDEO_GOP", (int)(i3 * 10 / (int)d1 / 10.0F + 0.5D));
    localBundle.putInt("DROP_SIZE", n);
    localBundle.putInt("VIDEO_BITRATE", m);
    localBundle.putInt("AUDIO_BITRATE", k);
    localBundle.putInt("CODEC_CACHE", i2);
    localBundle.putInt("CACHE_SIZE", i1);
    localBundle.putCharSequence("SERVER_IP", str);
    localBundle.putCharSequence("CPU_USAGE", (CharSequence)localObject);
    if (this.mCaptureAndEnc != null)
    {
      localBundle.putString("AUDIO_PLAY_INFO", this.mCaptureAndEnc.d());
      localBundle.putInt("VIDEO_WIDTH", this.mCaptureAndEnc.b());
      localBundle.putInt("VIDEO_HEIGHT", this.mCaptureAndEnc.c());
    }
    if (this.mTXCloudVideoView != null) {
      this.mTXCloudVideoView.setLogText(localBundle, null, 0);
    }
    if (this.mListener != null) {
      this.mListener.onNetStatus(localBundle);
    }
    if (this.mDataReport != null) {
      this.mDataReport.d();
    }
    if ((this.mMainHandler != null) && (this.mNotifyStatus)) {
      this.mMainHandler.postDelayed(new TXLivePusher.10(this), 2000L);
    }
  }
  
  private void stopDataReportModule()
  {
    if (this.mDataReport != null)
    {
      this.mDataReport.b();
      this.mDataReport = null;
    }
  }
  
  private void stopEncoder()
  {
    if (this.mCaptureAndEnc != null)
    {
      this.mCaptureAndEnc.a(null);
      this.mCaptureAndEnc.f();
      this.mCaptureAndEnc.a(null);
    }
  }
  
  private void stopNetworkModule()
  {
    if (this.mStreamUploader != null)
    {
      this.mStreamUploader.stop();
      this.mStreamUploader.setNotifyListener(null);
      this.mStreamUploader = null;
    }
  }
  
  private void stopQosModule()
  {
    if (this.mQos != null)
    {
      this.mQos.stop();
      this.mQos.setListener(null);
      this.mQos.setNotifyListener(null);
      this.mQos = null;
    }
  }
  
  private void stopStatusNotify()
  {
    this.mNotifyStatus = false;
  }
  
  private byte[] transferAvccToAnnexb(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, j);
    int k;
    for (int i = 0; i + 4 < j; i = i + k + 4)
    {
      k = ByteBuffer.wrap(paramArrayOfByte, i, 4).getInt();
      if (i + 4 + k <= j)
      {
        arrayOfByte[i] = 0;
        arrayOfByte[(i + 1)] = 0;
        arrayOfByte[(i + 2)] = 0;
        arrayOfByte[(i + 3)] = 1;
      }
    }
    return arrayOfByte;
  }
  
  private void transferConfig(TXLivePushConfig paramTXLivePushConfig)
  {
    f localf = this.mNewConfig;
    localf.c = paramTXLivePushConfig.mVideoBitrate;
    localf.e = paramTXLivePushConfig.mMinVideoBitrate;
    localf.d = paramTXLivePushConfig.mMaxVideoBitrate;
    localf.f = paramTXLivePushConfig.mAutoAdjustStrategy;
    localf.g = paramTXLivePushConfig.mAutoAdjustBitrate;
    localf.h = paramTXLivePushConfig.mVideoFPS;
    localf.i = paramTXLivePushConfig.mVideoEncodeGop;
    localf.j = paramTXLivePushConfig.mHardwareAccel;
    localf.k = paramTXLivePushConfig.mVideoResolution;
    localf.n = paramTXLivePushConfig.mEnableVideoHardEncoderMainProfile;
    localf.q = paramTXLivePushConfig.mAudioSample;
    localf.r = paramTXLivePushConfig.mAudioChannels;
    localf.s = paramTXLivePushConfig.mEnableAec;
    localf.w = paramTXLivePushConfig.mPauseFlag;
    localf.v = paramTXLivePushConfig.mPauseFps;
    localf.t = paramTXLivePushConfig.mPauseImg;
    localf.u = paramTXLivePushConfig.mPauseTime;
    localf.F = paramTXLivePushConfig.mEnablePureAudioPush;
    localf.D = paramTXLivePushConfig.mTouchFocus;
    localf.E = paramTXLivePushConfig.mEnableZoom;
    localf.x = paramTXLivePushConfig.mWatermark;
    localf.y = paramTXLivePushConfig.mWatermarkX;
    localf.z = paramTXLivePushConfig.mWatermarkY;
    localf.A = paramTXLivePushConfig.mWatermarkXF;
    localf.B = paramTXLivePushConfig.mWatermarkYF;
    localf.C = paramTXLivePushConfig.mWatermarkWidth;
    localf.l = paramTXLivePushConfig.mHomeOrientation;
    localf.G = paramTXLivePushConfig.mEnableNearestIP;
    localf.H = paramTXLivePushConfig.mRtmpChannelType;
    localf.o = paramTXLivePushConfig.mConnectRetryCount;
    localf.p = paramTXLivePushConfig.mConnectRetryInterval;
    localf.m = paramTXLivePushConfig.mFrontCamera;
    localf.K = paramTXLivePushConfig.mCustomModeType;
    localf.L = paramTXLivePushConfig.mVideoEncoderXMirror;
    localf.M = paramTXLivePushConfig.mEnableHighResolutionCapture;
    localf.a();
  }
  
  private void transferPushEvent(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      TXCLog.w(TAG, "unhandled event : " + paramInt);
      return;
    case 1107: 
      paramInt = 1107;
    }
    while (this.mMainHandler != null)
    {
      this.mMainHandler.post(new TXLivePusher.11(this, paramInt, paramBundle));
      return;
      paramInt = 1008;
      continue;
      paramInt = 1103;
      continue;
      paramInt = -1303;
      continue;
      paramInt = 3002;
      continue;
      paramInt = 3005;
      continue;
      paramInt = -1307;
      continue;
      paramInt = 1001;
      continue;
      paramInt = 3003;
      continue;
      paramInt = 1101;
      continue;
      paramInt = 1002;
      continue;
      paramInt = 3004;
      continue;
      paramInt = 1102;
      continue;
      paramInt = 1005;
      continue;
      paramInt = 1006;
      continue;
      paramInt = 1004;
      continue;
      paramInt = -1309;
      continue;
      paramInt = -1308;
      continue;
      paramInt = 1003;
      continue;
      paramInt = -1301;
      continue;
      paramInt = 1007;
      continue;
      paramInt = -1302;
      continue;
      paramInt = 1018;
      continue;
      paramInt = 1019;
      continue;
      paramInt = 1020;
      continue;
      paramInt = 1021;
    }
  }
  
  private void updateId(String paramString)
  {
    paramString = String.format("%s-%d", new Object[] { paramString, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000L) });
    if (this.mStreamUploader != null) {
      this.mStreamUploader.setID(paramString);
    }
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.setID(paramString);
    }
    if (this.mDataReport != null) {
      this.mDataReport.b(paramString);
    }
    this.mID = paramString;
  }
  
  public TXLivePushConfig getConfig()
  {
    return this.mConfig;
  }
  
  public int getMaxZoom()
  {
    if (this.mCaptureAndEnc == null) {
      return 0;
    }
    return this.mCaptureAndEnc.m();
  }
  
  public int getMusicDuration(String paramString)
  {
    return this.mCaptureAndEnc.d(paramString);
  }
  
  public boolean isPushing()
  {
    if (this.mCaptureAndEnc != null) {
      return this.mCaptureAndEnc.i();
    }
    return false;
  }
  
  public void onDetectFacePoints(float[] paramArrayOfFloat)
  {
    if (this.mPreprocessListener != null) {
      this.mPreprocessListener.onDetectFacePoints(paramArrayOfFloat);
    }
  }
  
  public void onEnableDropStatusChanged(boolean paramBoolean)
  {
    if (this.mStreamUploader != null) {
      this.mStreamUploader.setDropEanble(paramBoolean);
    }
  }
  
  public void onEncAudio(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.mStreamUploader != null) && (paramArrayOfByte != null)) {
      this.mStreamUploader.pushAAC(paramArrayOfByte, paramLong);
    }
    if ((this.mIsRecording) && (this.mMP4Muxer != null) && (this.mStartMuxer) && (paramArrayOfByte != null)) {
      this.mMP4Muxer.a(paramArrayOfByte, 0, paramArrayOfByte.length, 1000L * paramLong, 0);
    }
  }
  
  public void onEncVideo(b paramb)
  {
    if (this.mQos != null) {
      this.mQos.setHasVideo(true);
    }
    if ((this.mStreamUploader != null) && (paramb != null) && (paramb.a != null)) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject1;
        Object localObject2;
        if ((this.mMsgArray != null) && (!this.mMsgArray.isEmpty()))
        {
          localObject1 = this.mMsgArray.iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TXLivePusher.MsgInfo)((Iterator)localObject1).next();
            if (((TXLivePusher.MsgInfo)localObject2).ts <= paramb.g)
            {
              if (((TXLivePusher.MsgInfo)localObject2).msg.length > 10240) {
                break label493;
              }
              j = ((TXLivePusher.MsgInfo)localObject2).msg.length;
              break label484;
            }
          }
          if (i != 0)
          {
            localObject1 = new byte[paramb.a.length + i];
            localObject2 = new byte[5];
            Iterator localIterator = this.mMsgArray.iterator();
            i = 0;
            j = 0;
            if (!localIterator.hasNext()) {
              break label508;
            }
            TXLivePusher.MsgInfo localMsgInfo = (TXLivePusher.MsgInfo)localIterator.next();
            if (localMsgInfo.ts > paramb.g) {
              break label508;
            }
            if (localMsgInfo.msg.length > 10240) {
              break label500;
            }
            k = localMsgInfo.msg.length;
            int m = k + 1;
            localObject2[0] = ((byte)(m >> 24 & 0xFF));
            localObject2[1] = ((byte)(m >> 16 & 0xFF));
            localObject2[2] = ((byte)(m >> 8 & 0xFF));
            localObject2[3] = ((byte)(m & 0xFF));
            localObject2[4] = 6;
            System.arraycopy(localObject2, 0, localObject1, j, 5);
            j += 5;
            System.arraycopy(localMsgInfo.msg, 0, localObject1, j, k);
            i += 1;
            j += k;
            continue;
            if (k < i)
            {
              this.mMsgArray.remove(0);
              k += 1;
              continue;
            }
            System.arraycopy(paramb.a, 0, localObject1, j, paramb.a.length);
            paramb.a = ((byte[])localObject1);
          }
        }
        this.mStreamUploader.pushNAL(paramb);
        if ((this.mIsRecording) && (this.mMP4Muxer != null) && (paramb != null) && (paramb.a != null))
        {
          localObject1 = transferAvccToAnnexb(paramb.a);
          if (!this.mStartMuxer)
          {
            if (paramb.b != 0) {
              continue;
            }
            localObject2 = com.tencent.liteav.basic.util.a.a((byte[])localObject1, this.mCaptureAndEnc.b(), this.mCaptureAndEnc.c());
            if (localObject2 != null)
            {
              this.mMP4Muxer.a((MediaFormat)localObject2);
              this.mMP4Muxer.a();
              this.mStartMuxer = true;
              this.mRecordStartTime = 0L;
            }
          }
          recordVideoData(paramb, (byte[])localObject1);
        }
        return;
      }
      finally {}
      for (;;)
      {
        label484:
        i = j + 5 + i;
        break;
        label493:
        j = 10240;
      }
      label500:
      int k = 10240;
      continue;
      label508:
      k = 0;
    }
  }
  
  public void onEncVideoFormat(MediaFormat paramMediaFormat)
  {
    if ((this.mIsRecording) && (this.mMP4Muxer != null))
    {
      this.mMP4Muxer.a(paramMediaFormat);
      if (!this.mStartMuxer)
      {
        this.mMP4Muxer.a();
        this.mStartMuxer = true;
        this.mRecordStartTime = 0L;
      }
    }
  }
  
  public void onEncoderParamsChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.mNewConfig.a = paramInt2;
      this.mNewConfig.b = paramInt3;
    }
    if (paramInt1 != 0)
    {
      this.mNewConfig.c = paramInt1;
      TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.N, "Qos Result", "mode:" + this.mNewConfig.f + " bitrate:" + paramInt1 + " videosize:" + this.mNewConfig.a + " * " + this.mNewConfig.b);
    }
  }
  
  public int onGetEncoderRealBitrate()
  {
    return TXCStatus.d(this.mID, 4002);
  }
  
  public int onGetQueueInputSize()
  {
    int i = TXCStatus.d(this.mID, 7002);
    if (this.mNewConfig.I) {
      return i + TXCStatus.d(this.mID, 7001);
    }
    return i + TXCStatus.d(this.mID, 4002);
  }
  
  public int onGetQueueOutputSize()
  {
    if (this.mStreamUploader == null) {
      return 0;
    }
    return TXCStatus.d(this.mID, 7004) + TXCStatus.d(this.mID, 7003);
  }
  
  public int onGetVideoDropCount()
  {
    return TXCStatus.d(this.mID, 7007);
  }
  
  public int onGetVideoQueueCurrentCount()
  {
    return TXCStatus.d(this.mID, 7005);
  }
  
  public int onGetVideoQueueMaxCount()
  {
    return 5;
  }
  
  public void onLogRecord(String paramString)
  {
    TXCLog.d("User", paramString);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if (this.mMainHandler != null) {
      this.mMainHandler.post(new TXLivePusher.4(this, paramBundle, paramInt));
    }
    transferPushEvent(paramInt, paramBundle);
  }
  
  public void onRecordPcm(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.mAudioProcessListener;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onRecordRawPcm(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.mAudioProcessListener;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
  }
  
  public int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mPreprocessListener != null) {
      return this.mPreprocessListener.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
    }
    return 0;
  }
  
  public void onTextureDestoryed()
  {
    if (this.mPreprocessListener != null) {
      this.mPreprocessListener.onTextureDestoryed();
    }
  }
  
  public boolean pauseBGM()
  {
    TXCLog.d(TAG, "liteav_api pauseBGM ");
    return this.mCaptureAndEnc.o();
  }
  
  public void pausePusher()
  {
    TXCLog.d(TAG, "liteav_api pausePusher " + this);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.g();
    }
  }
  
  public boolean playBGM(String paramString)
  {
    TXCLog.d(TAG, "liteav_api playBGM " + paramString);
    return this.mCaptureAndEnc.c(paramString);
  }
  
  public boolean resumeBGM()
  {
    TXCLog.d(TAG, "liteav_api resumeBGM ");
    return this.mCaptureAndEnc.p();
  }
  
  public void resumePusher()
  {
    TXCLog.d(TAG, "liteav_api resumePusher " + this);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.h();
    }
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte)
  {
    this.mCaptureAndEnc.a(paramArrayOfByte);
  }
  
  public int sendCustomVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mCaptureAndEnc != null) {}
    switch (paramInt1)
    {
    case 4: 
    default: 
      return -1000;
    }
    for (paramInt1 = 1;; paramInt1 = 2) {
      return this.mCaptureAndEnc.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public int sendCustomVideoTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mCaptureAndEnc != null) {
      return this.mCaptureAndEnc.c(paramInt1, paramInt2, paramInt3);
    }
    return -1000;
  }
  
  @Deprecated
  public void sendMessage(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.mMsgArray != null)
      {
        TXLivePusher.MsgInfo localMsgInfo = new TXLivePusher.MsgInfo(this, null);
        localMsgInfo.ts = TXCTimeUtil.getTimeTick();
        localMsgInfo.msg = add_emulation_prevention_three_byte(paramArrayOfByte);
        this.mMsgArray.add(localMsgInfo);
      }
      return;
    }
    finally {}
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length <= 0) || (paramArrayOfByte.length > 2048)) {
      return false;
    }
    try
    {
      if (this.mMsgArray != null)
      {
        TXLivePusher.MsgInfo localMsgInfo = new TXLivePusher.MsgInfo(this, null);
        localMsgInfo.ts = TXCTimeUtil.getTimeTick();
        byte[] arrayOfByte = add_emulation_prevention_three_byte(paramArrayOfByte);
        localMsgInfo.msg = appendSEIBuffer(paramArrayOfByte.length, arrayOfByte);
        this.mMsgArray.add(localMsgInfo);
      }
      return true;
    }
    finally {}
  }
  
  public void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener paramAudioCustomProcessListener)
  {
    TXCLog.d(TAG, "liteav_api setAudioProcessListener " + paramAudioCustomProcessListener);
    this.mAudioProcessListener = paramAudioCustomProcessListener;
  }
  
  public void setBGMNofify(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    TXCLog.d(TAG, "liteav_api setBGMNofify " + paramOnBGMNotify);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramOnBGMNotify);
    }
  }
  
  public boolean setBGMVolume(float paramFloat)
  {
    TXCLog.d(TAG, "liteav_api setBGMVolume " + paramFloat);
    return this.mCaptureAndEnc.e(paramFloat);
  }
  
  public boolean setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TXCLog.d(TAG, "liteav_api setBeautyFilter " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4);
    if (this.mCaptureAndEnc != null)
    {
      this.mCaptureAndEnc.b(paramInt1);
      this.mCaptureAndEnc.b(paramInt2, paramInt3, paramInt4);
    }
    if (this.mConfig != null)
    {
      this.mConfig.mBeautyLevel = paramInt2;
      this.mConfig.mWhiteningLevel = paramInt3;
      this.mConfig.mRuddyLevel = paramInt4;
    }
    return true;
  }
  
  public void setBgmPitch(float paramFloat)
  {
    this.mBgmPitch = paramFloat;
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.b(paramFloat);
    }
  }
  
  public void setChinLevel(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setChinLevel " + paramInt);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.g(paramInt);
    }
  }
  
  public void setConfig(TXLivePushConfig paramTXLivePushConfig)
  {
    TXCLog.d(TAG, "liteav_api setConfig " + paramTXLivePushConfig + ", " + this);
    TXLivePushConfig localTXLivePushConfig = paramTXLivePushConfig;
    if (paramTXLivePushConfig == null) {
      localTXLivePushConfig = new TXLivePushConfig();
    }
    this.mConfig = localTXLivePushConfig;
    transferConfig(localTXLivePushConfig);
    applyConfig();
  }
  
  public void setExposureCompensation(float paramFloat)
  {
    TXCLog.d(TAG, "liteav_api setExposureCompensation " + paramFloat);
    if (this.mCaptureAndEnc == null) {
      return;
    }
    this.mCaptureAndEnc.c(paramFloat);
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setEyeScaleLevel " + paramInt);
    if (this.mConfig != null) {
      this.mConfig.setEyeScaleLevel(paramInt);
    }
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.c(paramInt);
    }
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setFaceShortLevel " + paramInt);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.f(paramInt);
    }
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setFaceSlimLevel " + paramInt);
    if (this.mConfig != null) {
      this.mConfig.setFaceSlimLevel(paramInt);
    }
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.d(paramInt);
    }
  }
  
  public void setFaceVLevel(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setFaceVLevel " + paramInt);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.e(paramInt);
    }
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    TXCLog.d(TAG, "liteav_api setFilter " + paramBitmap);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramBitmap);
    }
  }
  
  @TargetApi(18)
  public boolean setGreenScreenFile(String paramString)
  {
    TXCLog.d(TAG, "liteav_api setGreenScreenFile " + paramString);
    if (this.mCaptureAndEnc != null) {
      return this.mCaptureAndEnc.b(paramString);
    }
    return false;
  }
  
  public boolean setMicVolume(float paramFloat)
  {
    TXCLog.d(TAG, "liteav_api setMicVolume " + paramFloat);
    return this.mCaptureAndEnc.d(paramFloat);
  }
  
  public boolean setMirror(boolean paramBoolean)
  {
    TXCLog.d(TAG, "liteav_api setMirror " + paramBoolean);
    if (this.mConfig != null) {
      this.mConfig.setVideoEncoderXMirror(paramBoolean);
    }
    if (this.mCaptureAndEnc == null) {
      return false;
    }
    this.mCaptureAndEnc.d(paramBoolean);
    return true;
  }
  
  public void setMotionTmpl(String paramString)
  {
    TXCLog.d(TAG, "liteav_api motionPath " + paramString);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramString);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    TXCLog.d(TAG, "liteav_api setMute " + paramBoolean);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.c(paramBoolean);
    }
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setNoseSlimLevel " + paramInt);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.h(paramInt);
    }
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    TXCLog.d(TAG, "liteav_api setPushListener " + paramITXLivePushListener);
    this.mListener = paramITXLivePushListener;
  }
  
  public void setRenderRotation(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setRenderRotation ");
    if (this.mCaptureAndEnc == null) {
      return;
    }
    this.mCaptureAndEnc.a(paramInt);
  }
  
  public void setReverb(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setReverb " + paramInt);
    if (this.mCaptureAndEnc == null) {
      return;
    }
    this.mCaptureAndEnc.j(paramInt);
  }
  
  public void setSpecialRatio(float paramFloat)
  {
    TXCLog.d(TAG, "liteav_api setSpecialRatio " + paramFloat);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramFloat);
    }
  }
  
  public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    TXCLog.d(TAG, "liteav_api setVideoProcessListener " + paramVideoCustomProcessListener);
    this.mPreprocessListener = paramVideoCustomProcessListener;
    if (this.mPreprocessListener == null) {
      if (this.mCaptureAndEnc != null) {
        this.mCaptureAndEnc.a(null);
      }
    }
    while (this.mCaptureAndEnc == null) {
      return;
    }
    this.mCaptureAndEnc.a(this);
  }
  
  public void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    int j = 1;
    TXCLog.d(TAG, "liteav_api setVideoQuality " + paramInt + ", " + paramBoolean1 + ", " + paramBoolean2);
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 18) {
      if (paramInt != 2)
      {
        i = paramInt;
        if (paramInt != 3) {}
      }
      else
      {
        i = 1;
      }
    }
    if (this.mConfig == null) {
      this.mConfig = new TXLivePushConfig();
    }
    this.mConfig.setVideoFPS(18);
    TXLivePushConfig localTXLivePushConfig;
    switch (i)
    {
    default: 
      this.mConfig.setHardwareAcceleration(2);
      TXCLog.e(TAG, "setVideoPushQuality: invalid quality " + i);
      return;
    case 1: 
      this.mConfig.enableAEC(false);
      this.mConfig.setHardwareAcceleration(2);
      this.mConfig.setVideoResolution(0);
      this.mConfig.setAudioSampleRate(48000);
      setAdjustStrategy(paramBoolean1, paramBoolean2);
      this.mConfig.setMinVideoBitrate(301);
      this.mConfig.setVideoBitrate(800);
      this.mConfig.setMaxVideoBitrate(800);
      paramBoolean1 = false;
      paramBoolean2 = false;
      this.mVideoQuality = i;
      localTXLivePushConfig = this.mConfig;
      if (paramBoolean2)
      {
        label267:
        localTXLivePushConfig.enableVideoHardEncoderMainProfile(bool);
        localTXLivePushConfig = this.mConfig;
        if (!paramBoolean2) {
          break label962;
        }
      }
      break;
    }
    label962:
    for (paramInt = j;; paramInt = 3)
    {
      localTXLivePushConfig.setVideoEncodeGop(paramInt);
      if (this.mNewConfig != null)
      {
        this.mNewConfig.I = paramBoolean2;
        this.mNewConfig.J = paramBoolean1;
      }
      setConfig(this.mConfig);
      return;
      this.mConfig.enableAEC(false);
      this.mConfig.setHardwareAcceleration(2);
      this.mConfig.setVideoResolution(1);
      this.mConfig.setAudioSampleRate(48000);
      setAdjustStrategy(paramBoolean1, paramBoolean2);
      this.mConfig.setMinVideoBitrate(600);
      this.mConfig.setVideoBitrate(1200);
      this.mConfig.setMaxVideoBitrate(1500);
      paramBoolean1 = false;
      paramBoolean2 = false;
      break;
      this.mConfig.enableAEC(false);
      this.mConfig.setHardwareAcceleration(1);
      this.mConfig.setVideoResolution(2);
      this.mConfig.setAudioSampleRate(48000);
      setAdjustStrategy(paramBoolean1, paramBoolean2);
      this.mConfig.setMinVideoBitrate(600);
      this.mConfig.setVideoBitrate(1800);
      this.mConfig.setMaxVideoBitrate(1800);
      paramBoolean1 = false;
      paramBoolean2 = false;
      break;
      this.mConfig.enableAEC(true);
      this.mConfig.setHardwareAcceleration(1);
      this.mConfig.setVideoResolution(0);
      this.mConfig.setAudioSampleRate(48000);
      this.mConfig.setAutoAdjustBitrate(true);
      this.mConfig.setAutoAdjustStrategy(5);
      this.mConfig.setMinVideoBitrate(190);
      this.mConfig.setVideoBitrate(400);
      this.mConfig.setMaxVideoBitrate(810);
      paramBoolean1 = true;
      paramBoolean2 = true;
      break;
      if (Build.VERSION.SDK_INT < 18)
      {
        this.mConfig.enableAEC(true);
        this.mConfig.setHardwareAcceleration(0);
        this.mConfig.setVideoResolution(0);
        this.mConfig.setAutoAdjustBitrate(true);
        this.mConfig.setAutoAdjustStrategy(4);
        this.mConfig.setMinVideoBitrate(301);
        this.mConfig.setVideoBitrate(800);
        this.mConfig.setMaxVideoBitrate(800);
      }
      for (;;)
      {
        this.mConfig.setAudioSampleRate(48000);
        paramBoolean1 = false;
        paramBoolean2 = true;
        break;
        if (this.mVideoQuality == 1)
        {
          this.mConfig.enableAEC(true);
          this.mConfig.setHardwareAcceleration(1);
          this.mConfig.setVideoResolution(0);
          this.mConfig.setAutoAdjustBitrate(true);
          this.mConfig.setAutoAdjustStrategy(4);
          this.mConfig.setMinVideoBitrate(301);
          this.mConfig.setVideoBitrate(800);
          this.mConfig.setMaxVideoBitrate(800);
        }
        else if (this.mVideoQuality == 3)
        {
          this.mConfig.enableAEC(true);
          this.mConfig.setHardwareAcceleration(1);
          this.mConfig.setVideoResolution(2);
          this.mConfig.setAutoAdjustBitrate(true);
          this.mConfig.setAutoAdjustStrategy(4);
          this.mConfig.setMinVideoBitrate(600);
          this.mConfig.setVideoBitrate(1800);
          this.mConfig.setMaxVideoBitrate(1800);
        }
        else
        {
          this.mConfig.enableAEC(true);
          this.mConfig.setHardwareAcceleration(1);
          this.mConfig.setVideoResolution(1);
          this.mConfig.setAutoAdjustBitrate(true);
          this.mConfig.setAutoAdjustStrategy(4);
          this.mConfig.setMinVideoBitrate(600);
          this.mConfig.setVideoBitrate(1200);
          this.mConfig.setMaxVideoBitrate(1200);
        }
      }
      this.mConfig.enableAEC(true);
      this.mConfig.setHardwareAcceleration(1);
      this.mConfig.setVideoResolution(6);
      this.mConfig.setAutoAdjustBitrate(false);
      this.mConfig.setVideoBitrate(350);
      this.mConfig.setAudioSampleRate(48000);
      paramBoolean1 = false;
      paramBoolean2 = true;
      break;
      bool = true;
      break label267;
    }
  }
  
  public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    TXCLog.d(TAG, "liteav_api setVideoRecordListener " + paramITXVideoRecordListener);
    this.mRecordListener = paramITXVideoRecordListener;
  }
  
  public void setVoiceChangerType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.mVoiceKind = -1;
      this.mVoiceEnvironment = -1;
    }
    for (;;)
    {
      if (this.mCaptureAndEnc != null) {
        this.mCaptureAndEnc.a(this.mVoiceKind, this.mVoiceEnvironment);
      }
      return;
      this.mVoiceKind = 6;
      this.mVoiceEnvironment = -1;
      continue;
      this.mVoiceKind = 4;
      this.mVoiceEnvironment = -1;
      continue;
      this.mVoiceKind = 5;
      this.mVoiceEnvironment = -1;
      continue;
      this.mVoiceKind = -1;
      this.mVoiceEnvironment = 9;
      continue;
      this.mVoiceKind = 536936433;
      this.mVoiceEnvironment = 50;
      continue;
      this.mVoiceKind = -1;
      this.mVoiceEnvironment = 5;
      continue;
      this.mVoiceKind = 13;
      this.mVoiceEnvironment = 1;
      continue;
      this.mVoiceKind = 13;
      this.mVoiceEnvironment = -1;
      continue;
      this.mVoiceKind = 10;
      this.mVoiceEnvironment = 4;
      continue;
      this.mVoiceKind = 10;
      this.mVoiceEnvironment = 20;
      continue;
      this.mVoiceKind = -1;
      this.mVoiceEnvironment = 2;
    }
  }
  
  public boolean setZoom(int paramInt)
  {
    TXCLog.d(TAG, "liteav_api setZoom " + paramInt);
    if (this.mCaptureAndEnc == null) {
      return false;
    }
    return this.mCaptureAndEnc.i(paramInt);
  }
  
  public void snapshot(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    TXCLog.d(TAG, "liteav_api snapshot " + paramITXSnapshotListener);
    if ((this.mSnapshotRunning) || (paramITXSnapshotListener == null)) {
      return;
    }
    com.tencent.liteav.renderer.d locald = null;
    if (this.mTXCloudVideoView != null) {
      locald = this.mTXCloudVideoView.getGLSurfaceView();
    }
    if (locald != null)
    {
      this.mSnapshotRunning = true;
      locald.a(new TXLivePusher.1(this, paramITXSnapshotListener));
      this.mMainHandler.postDelayed(this.mSnapShotTimeOutRunnable, 2000L);
      return;
    }
    this.mSnapshotRunning = false;
  }
  
  public void startCameraPreview(TXCloudVideoView paramTXCloudVideoView)
  {
    TXCLog.d(TAG, "liteav_api startCameraPreview " + paramTXCloudVideoView + ", " + this);
    if (paramTXCloudVideoView == null) {
      return;
    }
    setConfig(this.mConfig);
    if (this.mNewConfig.F)
    {
      TXCLog.e(TAG, "enable pure audio push , so can not start preview!");
      return;
    }
    if ((this.mTXCloudVideoView != paramTXCloudVideoView) && (this.mTXCloudVideoView != null)) {
      this.mTXCloudVideoView.removeVideoView();
    }
    this.mTXCloudVideoView = paramTXCloudVideoView;
    if (this.mCaptureAndEnc == null) {
      this.mCaptureAndEnc = new com.tencent.liteav.c(this.mContext);
    }
    this.mCaptureAndEnc.a(this);
    this.mCaptureAndEnc.a(this);
    this.mCaptureAndEnc.a(paramTXCloudVideoView);
    this.mCaptureAndEnc.b(this.mConfig.mBeautyLevel, this.mConfig.mWhiteningLevel, this.mConfig.mRuddyLevel);
  }
  
  public int startPusher(String paramString)
  {
    TXCLog.d(TAG, "liteav_api startPusher " + this);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e(TAG, "start push error when url is empty " + this);
      return -1;
    }
    if ((!TextUtils.isEmpty(this.mPushUrl)) && (isPushing()))
    {
      if (this.mPushUrl.equalsIgnoreCase(paramString))
      {
        TXCLog.w(TAG, "ignore start push when new url is the same with old url  " + this);
        return -1;
      }
      TXCLog.w(TAG, " stop old push when new url is not the same with old url  " + this);
      stopPusher();
    }
    TXCLog.d(TAG, "================================================================================================================================================");
    TXCLog.d(TAG, "================================================================================================================================================");
    TXCLog.d(TAG, "============= startPush pushUrl = " + paramString + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
    TXCLog.d(TAG, "================================================================================================================================================");
    TXCLog.d(TAG, "================================================================================================================================================");
    this.mPushUrl = paramString;
    updateId(this.mPushUrl);
    startNetworkModule();
    startEncoder();
    startQosModule();
    startDataReportModule();
    startStatusNotify();
    if (this.mTXCloudVideoView != null) {
      this.mTXCloudVideoView.clearLog();
    }
    return 0;
  }
  
  public int startRecord(String paramString)
  {
    int i = 0;
    TXCLog.d(TAG, "liteav_api startRecord " + paramString);
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e(TAG, "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
      i = -3;
    }
    do
    {
      return i;
      if (this.mIsRecording)
      {
        TXCLog.w(TAG, "ignore start record when recording");
        return -1;
      }
      if ((this.mCaptureAndEnc == null) || (!this.mCaptureAndEnc.i()))
      {
        TXCLog.w(TAG, "ignore start record when not pushing");
        return -2;
      }
      TXCLog.w(TAG, "start record ");
      this.mIsRecording = true;
      this.mVideoFilePath = paramString;
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      this.mMP4Muxer = new com.tencent.liteav.muxer.c(this.mContext, 1);
      this.mStartMuxer = false;
      this.mMP4Muxer.a(this.mVideoFilePath);
      addAudioTrack();
      TXCDRApi.txReportDAU(this.mContext.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aH);
    } while (this.mCaptureAndEnc == null);
    this.mCaptureAndEnc.r();
    return 0;
  }
  
  public void startScreenCapture()
  {
    TXCLog.d(TAG, "liteav_api startScreenCapture ");
    if (this.mCaptureAndEnc == null) {
      return;
    }
    this.mCaptureAndEnc.k();
  }
  
  public boolean stopBGM()
  {
    TXCLog.d(TAG, "liteav_api stopBGM ");
    return this.mCaptureAndEnc.n();
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    TXCLog.d(TAG, "liteav_api stopCameraPreview " + paramBoolean + ", " + this);
    if (this.mCaptureAndEnc == null) {
      return;
    }
    this.mCaptureAndEnc.a(paramBoolean);
  }
  
  public void stopPusher()
  {
    TXCLog.d(TAG, "liteav_api stopPusher " + this);
    stopRecord();
    stopStatusNotify();
    stopDataReportModule();
    stopQosModule();
    stopEncoder();
    this.mNewConfig.I = false;
    stopNetworkModule();
  }
  
  public void stopRecord()
  {
    TXCLog.d(TAG, "liteav_api stopRecord ");
    if ((this.mIsRecording) && (this.mMP4Muxer != null))
    {
      int i = this.mMP4Muxer.b();
      TXCLog.w(TAG, "start record ");
      this.mIsRecording = false;
      if (i == 0) {
        AsyncTask.execute(new TXLivePusher.3(this, this.mVideoFilePath));
      }
    }
    else
    {
      return;
    }
    callbackRecordFail();
  }
  
  public void stopScreenCapture()
  {
    TXCLog.d(TAG, "liteav_api stopScreenCapture ");
    if (this.mCaptureAndEnc == null) {
      return;
    }
    this.mCaptureAndEnc.l();
  }
  
  public void switchCamera()
  {
    TXCLog.d(TAG, "liteav_api switchCamera ");
    if (this.mCaptureAndEnc == null) {
      return;
    }
    this.mCaptureAndEnc.j();
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    TXCLog.d(TAG, "liteav_api turnOnFlashLight " + paramBoolean);
    if (this.mCaptureAndEnc == null) {
      return false;
    }
    return this.mCaptureAndEnc.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher
 * JD-Core Version:    0.7.0.1
 */