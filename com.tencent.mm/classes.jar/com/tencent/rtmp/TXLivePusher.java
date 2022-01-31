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
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioUGCRecorder;
import com.tencent.liteav.basic.b.e;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.c.a;
import com.tencent.liteav.d;
import com.tencent.liteav.f;
import com.tencent.liteav.l;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TXLivePusher
  implements com.tencent.liteav.basic.c.a, c.a, l, com.tencent.liteav.qos.a
{
  public static final int RGB_BGRA = 4;
  public static final int RGB_RGBA = 5;
  private static final byte SEI_MSG_TYPE = -14;
  private static final String TAG;
  public static final int YUV_420P = 3;
  public static final int YUV_420SP = 1;
  public static final int YUV_420YpCbCr = 2;
  private TXLivePusher.AudioCustomProcessListener mAudioProcessListener;
  TXLivePusher.OnBGMNotify mBGMNotify;
  private int mBackground;
  private float mBgmPitch;
  private Vector<String> mCallFuncBeforeStartPush;
  private com.tencent.liteav.c mCaptureAndEnc;
  private TXLivePushConfig mConfig;
  private Context mContext;
  private d mDataReport;
  private TXCEventRecorderProxy mEventRecorderProxy;
  private String mID;
  private boolean mIsRecording;
  private HashMap<Integer, Long> mLastReportTime;
  private ITXLivePushListener mListener;
  private com.tencent.liteav.muxer.c mMP4Muxer;
  private Handler mMainHandler;
  private ArrayList<TXLivePusher.MsgInfo> mMsgArray;
  private int mNetType;
  private f mNewConfig;
  private boolean mNotifyStatus;
  private TXLivePusher.VideoCustomProcessListener mPreprocessListener;
  private String mPushUrl;
  private TXCQoS mQos;
  private TXRecordCommon.ITXVideoRecordListener mRecordListener;
  private long mRecordStartTime;
  private Runnable mSnapShotTimeOutRunnable;
  private boolean mSnapshotRunning;
  private boolean mStartMuxer;
  private TXCStreamUploader mStreamUploader;
  private TXCloudVideoView mTXCloudVideoView;
  private HashSet<String> mUserList;
  private String mVideoFilePath;
  private int mVideoQuality;
  private int mVoiceEnvironment;
  private int mVoiceKind;
  
  static
  {
    AppMethodBeat.i(65927);
    TAG = TXLivePusher.class.getSimpleName();
    AppMethodBeat.o(65927);
  }
  
  public TXLivePusher(Context paramContext)
  {
    AppMethodBeat.i(65825);
    this.mConfig = null;
    this.mListener = null;
    this.mVideoQuality = -1;
    this.mNewConfig = null;
    this.mCaptureAndEnc = null;
    this.mStreamUploader = null;
    this.mContext = null;
    this.mMainHandler = null;
    this.mQos = null;
    this.mDataReport = null;
    this.mPushUrl = "";
    this.mID = "";
    this.mSnapshotRunning = false;
    this.mVoiceKind = -1;
    this.mVoiceEnvironment = -1;
    this.mBgmPitch = 0.0F;
    this.mEventRecorderProxy = null;
    this.mNetType = -1;
    this.mBackground = -1;
    this.mCallFuncBeforeStartPush = new Vector();
    this.mUserList = new HashSet();
    this.mLastReportTime = new HashMap();
    this.mMsgArray = new ArrayList();
    this.mSnapShotTimeOutRunnable = new TXLivePusher.3(this);
    this.mMP4Muxer = null;
    this.mStartMuxer = false;
    this.mVideoFilePath = "";
    this.mRecordStartTime = 0L;
    this.mIsRecording = false;
    this.mNotifyStatus = false;
    TXCLog.init();
    this.mNewConfig = new f();
    this.mContext = paramContext.getApplicationContext();
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.mCaptureAndEnc = new com.tencent.liteav.c(this.mContext);
    this.mCaptureAndEnc.a(this);
    e.a().a(null, this.mContext);
    TXCTimeUtil.initAppStartTime();
    this.mLastReportTime.put(Integer.valueOf(-1303), Long.valueOf(0L));
    this.mLastReportTime.put(Integer.valueOf(1101), Long.valueOf(0L));
    this.mLastReportTime.put(Integer.valueOf(1006), Long.valueOf(0L));
    AppMethodBeat.o(65825);
  }
  
  @TargetApi(16)
  private void addAudioTrack()
  {
    AppMethodBeat.i(65900);
    MediaFormat localMediaFormat = com.tencent.liteav.basic.util.b.a(TXCAudioUGCRecorder.getInstance().getSampleRate(), TXCAudioUGCRecorder.getInstance().getChannels(), 2);
    if (this.mMP4Muxer != null) {
      this.mMP4Muxer.b(localMediaFormat);
    }
    AppMethodBeat.o(65900);
  }
  
  private byte[] add_emulation_prevention_three_byte(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65919);
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
    AppMethodBeat.o(65919);
    return paramArrayOfByte;
  }
  
  private byte[] appendSEIBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65922);
    byte[] arrayOfByte1 = intToBytes(paramInt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1 + paramArrayOfByte.length + 1];
    arrayOfByte2[0] = -14;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
    paramInt = arrayOfByte1.length + 1;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, paramInt, paramArrayOfByte.length);
    arrayOfByte2[(paramInt + paramArrayOfByte.length)] = -128;
    AppMethodBeat.o(65922);
    return arrayOfByte2;
  }
  
  private void applyConfig()
  {
    int i = 5;
    int j = 1;
    AppMethodBeat.i(65916);
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65916);
      return;
    }
    this.mCaptureAndEnc.a(this.mNewConfig);
    if (this.mCaptureAndEnc.l())
    {
      int m;
      int k;
      if (this.mStreamUploader != null)
      {
        if (!this.mNewConfig.J) {
          break label267;
        }
        m = this.mNewConfig.o;
        k = this.mNewConfig.p;
        if (m >= 5) {
          break label256;
        }
        if (k <= 1) {
          break label262;
        }
        label90:
        this.mStreamUploader.setRetryInterval(j);
        this.mStreamUploader.setRetryTimes(i);
        this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, 1000);
      }
      for (;;)
      {
        this.mStreamUploader.setSendStrategy(this.mNewConfig.J, this.mNewConfig.K);
        if (this.mQos == null) {
          break label380;
        }
        this.mQos.stop();
        this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
        this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
        this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
        this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
        if (!this.mNewConfig.g) {
          break label380;
        }
        this.mQos.start(2000L);
        AppMethodBeat.o(65916);
        return;
        label256:
        i = m;
        break;
        label262:
        j = k;
        break label90;
        label267:
        this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
        this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
        this.mStreamUploader.setVideoDropParams(true, 40, 3000);
      }
    }
    if ((this.mNewConfig.L & 0x1) != 0)
    {
      if (this.mStreamUploader != null)
      {
        this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
        AppMethodBeat.o(65916);
      }
    }
    else if (this.mStreamUploader != null) {
      this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
    }
    label380:
    AppMethodBeat.o(65916);
  }
  
  private void callbackRecordFail()
  {
    AppMethodBeat.i(65898);
    this.mMainHandler.post(new TXLivePusher.6(this));
    AppMethodBeat.o(65898);
  }
  
  private void callbackRecordSuccess(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(65899);
    this.mMainHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(65592);
        TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
        localTXRecordResult.retCode = 0;
        localTXRecordResult.descMsg = "record success";
        localTXRecordResult.videoPath = paramString1;
        localTXRecordResult.coverPath = paramString2;
        if (TXLivePusher.this.mRecordListener != null) {
          TXLivePusher.this.mRecordListener.onRecordComplete(localTXRecordResult);
        }
        TXCLog.w(TXLivePusher.TAG, "record complete success");
        AppMethodBeat.o(65592);
      }
    });
    AppMethodBeat.o(65899);
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
  
  private int getQuicMode(int paramInt)
  {
    AppMethodBeat.i(65923);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(65923);
      return paramInt;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "RTC");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "LinkMain");
      continue;
      paramInt = (int)com.tencent.liteav.basic.e.b.a().a("QUICMode", "LinkSub");
    }
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
    AppMethodBeat.i(65902);
    if (paramITXSnapshotListener == null)
    {
      AppMethodBeat.o(65902);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new TXLivePusher.9(this, paramITXSnapshotListener, paramBitmap));
    AppMethodBeat.o(65902);
  }
  
  private void recordVideoData(TXSNALPacket paramTXSNALPacket, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146871);
    if (this.mRecordStartTime == 0L) {
      this.mRecordStartTime = paramTXSNALPacket.pts;
    }
    long l1 = paramTXSNALPacket.pts;
    long l2 = this.mRecordStartTime;
    int i;
    if (paramTXSNALPacket.info == null)
    {
      if (paramTXSNALPacket.nalType != 0) {
        break label110;
      }
      i = 1;
    }
    for (;;)
    {
      this.mMP4Muxer.b(paramArrayOfByte, 0, paramArrayOfByte.length, paramTXSNALPacket.pts * 1000L, i);
      this.mMainHandler.post(new TXLivePusher.8(this, l1 - l2));
      AppMethodBeat.o(146871);
      return;
      i = paramTXSNALPacket.info.flags;
      continue;
      label110:
      i = 0;
    }
  }
  
  private void setAdjustStrategy(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(65903);
    int i = getAdjustStrategy(paramBoolean1, paramBoolean2);
    if (i == -1)
    {
      this.mConfig.setAutoAdjustBitrate(false);
      this.mConfig.setAutoAdjustStrategy(-1);
      AppMethodBeat.o(65903);
      return;
    }
    this.mConfig.setAutoAdjustBitrate(true);
    this.mConfig.setAutoAdjustStrategy(i);
    AppMethodBeat.o(65903);
  }
  
  private void startDataReportModule()
  {
    AppMethodBeat.i(65911);
    this.mDataReport = new d(this.mContext);
    this.mDataReport.d(this.mID);
    this.mDataReport.a(this.mNewConfig.c);
    this.mDataReport.b(this.mNewConfig.q);
    this.mDataReport.a(this.mNewConfig.a, this.mNewConfig.b);
    this.mDataReport.a(this.mPushUrl);
    this.mDataReport.a();
    AppMethodBeat.o(65911);
  }
  
  private void startEncoder()
  {
    AppMethodBeat.i(65913);
    if (this.mCaptureAndEnc != null)
    {
      this.mCaptureAndEnc.setID(this.mID);
      this.mCaptureAndEnc.a(this);
      this.mCaptureAndEnc.b(this.mVoiceKind, this.mVoiceEnvironment);
      this.mCaptureAndEnc.b(this.mBgmPitch);
      this.mCaptureAndEnc.e();
    }
    AppMethodBeat.o(65913);
  }
  
  private void startNetworkModule()
  {
    int i = 5;
    int j = 1;
    AppMethodBeat.i(65907);
    h localh = new h();
    localh.d = com.tencent.liteav.audio.b.a().d();
    localh.e = com.tencent.liteav.audio.b.a().e();
    localh.a = 0;
    localh.c = 20;
    localh.b = 0;
    localh.f = 3;
    localh.j = true;
    localh.l = true;
    localh.k = false;
    localh.h = 40;
    localh.i = 5000;
    localh.m = this.mNewConfig.J;
    localh.n = this.mNewConfig.K;
    localh.o = getQuicMode(this.mVideoQuality);
    this.mStreamUploader = new TXCStreamUploader(this.mContext, localh);
    this.mStreamUploader.setID(this.mID);
    int m;
    int k;
    if ((this.mNewConfig.L & 0x1) != 0)
    {
      if (this.mStreamUploader != null) {
        this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
      }
      this.mStreamUploader.setNotifyListener(this);
      if ((this.mConfig.mEnablePureAudioPush) && (this.mCaptureAndEnc != null)) {
        this.mStreamUploader.setAudioMute(this.mCaptureAndEnc.p());
      }
      this.mPushUrl = this.mStreamUploader.start(this.mPushUrl, this.mNewConfig.H, this.mNewConfig.I);
      if (this.mNewConfig.G) {
        this.mStreamUploader.setMode(1);
      }
      if (!this.mNewConfig.J) {
        break label426;
      }
      m = this.mNewConfig.o;
      k = this.mNewConfig.p;
      if (m >= 5) {
        break label415;
      }
      label323:
      if (k <= 1) {
        break label421;
      }
      label328:
      this.mStreamUploader.setRetryInterval(j);
      this.mStreamUploader.setRetryTimes(i);
      this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, 1000);
    }
    for (;;)
    {
      this.mStreamUploader.setSendStrategy(this.mNewConfig.J, this.mNewConfig.K);
      AppMethodBeat.o(65907);
      return;
      if (this.mStreamUploader == null) {
        break;
      }
      this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
      break;
      label415:
      i = m;
      break label323;
      label421:
      j = k;
      break label328;
      label426:
      this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
      this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
      this.mStreamUploader.setVideoDropParams(true, 40, 3000);
    }
  }
  
  private void startQosModule()
  {
    AppMethodBeat.i(65909);
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
    AppMethodBeat.o(65909);
  }
  
  private void startStatusNotify()
  {
    AppMethodBeat.i(65905);
    this.mNotifyStatus = true;
    if (this.mMainHandler != null) {
      this.mMainHandler.postDelayed(new TXLivePusher.10(this), 2000L);
    }
    AppMethodBeat.o(65905);
  }
  
  private void statusNotify()
  {
    AppMethodBeat.i(65906);
    Object localObject = com.tencent.liteav.basic.util.b.a();
    int i = localObject[0] / 10;
    int j = localObject[1] / 10;
    localObject = i + "/" + j + "%";
    i = TXCStatus.c(this.mID, 7004);
    j = TXCStatus.c(this.mID, 7003);
    int k = TXCStatus.c(this.mID, 7002);
    int m = TXCStatus.c(this.mID, 7001);
    int n = TXCStatus.c(this.mID, 7007);
    int i1 = TXCStatus.c(this.mID, 7005);
    int i2 = TXCStatus.c(this.mID, 7006);
    String str = TXCStatus.b(this.mID, 7012);
    double d2 = TXCStatus.d(this.mID, 4001);
    int i3 = TXCStatus.c(this.mID, 4006);
    Bundle localBundle = new Bundle();
    localBundle.putInt("NET_SPEED", i + j);
    localBundle.putInt("VIDEO_FPS", (int)d2);
    double d1 = d2;
    if (d2 < 1.0D) {
      d1 = 15.0D;
    }
    localBundle.putInt("VIDEO_GOP", (int)(i3 * 10 / (int)d1 / 10.0F + 0.5D));
    localBundle.putInt("VIDEO_DROP", n);
    localBundle.putInt("VIDEO_BITRATE", m);
    localBundle.putInt("AUDIO_BITRATE", k);
    localBundle.putInt("AUDIO_CACHE", i2);
    localBundle.putInt("VIDEO_CACHE", i1);
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
      this.mDataReport.e();
    }
    j = com.tencent.liteav.basic.util.b.d(this.mContext);
    if (com.tencent.liteav.basic.util.b.a(this.mContext)) {}
    for (i = 1;; i = 0)
    {
      if (this.mNetType != j)
      {
        TXCEventRecorderProxy.a(this.mPushUrl, 1003, j, -1, "", 0);
        this.mNetType = j;
      }
      if (this.mBackground != i)
      {
        TXCEventRecorderProxy.a(this.mPushUrl, 2001, i, -1, "", 0);
        this.mBackground = i;
      }
      if ((this.mMainHandler != null) && (this.mNotifyStatus)) {
        this.mMainHandler.postDelayed(new TXLivePusher.11(this), 2000L);
      }
      AppMethodBeat.o(65906);
      return;
    }
  }
  
  private void stopDataReportModule()
  {
    AppMethodBeat.i(65912);
    if (this.mDataReport != null)
    {
      this.mDataReport.b();
      this.mDataReport = null;
    }
    AppMethodBeat.o(65912);
  }
  
  private void stopEncoder()
  {
    AppMethodBeat.i(65914);
    if (this.mCaptureAndEnc != null)
    {
      this.mCaptureAndEnc.a(null);
      this.mCaptureAndEnc.g();
      this.mCaptureAndEnc.a(null);
    }
    AppMethodBeat.o(65914);
  }
  
  private void stopNetworkModule()
  {
    AppMethodBeat.i(65908);
    if (this.mStreamUploader != null)
    {
      this.mStreamUploader.stop();
      this.mStreamUploader.setNotifyListener(null);
      this.mStreamUploader = null;
    }
    AppMethodBeat.o(65908);
  }
  
  private void stopQosModule()
  {
    AppMethodBeat.i(65910);
    if (this.mQos != null)
    {
      this.mQos.stop();
      this.mQos.setListener(null);
      this.mQos.setNotifyListener(null);
      this.mQos = null;
    }
    AppMethodBeat.o(65910);
  }
  
  private void stopStatusNotify()
  {
    this.mNotifyStatus = false;
  }
  
  private byte[] transferAvccToAnnexb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65918);
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
    AppMethodBeat.o(65918);
    return arrayOfByte;
  }
  
  private void transferConfig(TXLivePushConfig paramTXLivePushConfig)
  {
    AppMethodBeat.i(65915);
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
    localf.x = paramTXLivePushConfig.mPauseFlag;
    localf.w = paramTXLivePushConfig.mPauseFps;
    localf.u = paramTXLivePushConfig.mPauseImg;
    localf.v = paramTXLivePushConfig.mPauseTime;
    localf.G = paramTXLivePushConfig.mEnablePureAudioPush;
    localf.E = paramTXLivePushConfig.mTouchFocus;
    localf.F = paramTXLivePushConfig.mEnableZoom;
    localf.y = paramTXLivePushConfig.mWatermark;
    localf.z = paramTXLivePushConfig.mWatermarkX;
    localf.A = paramTXLivePushConfig.mWatermarkY;
    localf.B = paramTXLivePushConfig.mWatermarkXF;
    localf.C = paramTXLivePushConfig.mWatermarkYF;
    localf.D = paramTXLivePushConfig.mWatermarkWidth;
    localf.l = paramTXLivePushConfig.mHomeOrientation;
    localf.H = paramTXLivePushConfig.mEnableNearestIP;
    localf.I = paramTXLivePushConfig.mRtmpChannelType;
    localf.o = paramTXLivePushConfig.mConnectRetryCount;
    localf.p = paramTXLivePushConfig.mConnectRetryInterval;
    localf.m = paramTXLivePushConfig.mFrontCamera;
    localf.L = paramTXLivePushConfig.mCustomModeType;
    localf.M = paramTXLivePushConfig.mVideoEncoderXMirror;
    localf.N = paramTXLivePushConfig.mEnableHighResolutionCapture;
    localf.O = paramTXLivePushConfig.mEnableScreenCaptureAutoRotate;
    localf.a();
    AppMethodBeat.o(65915);
  }
  
  private void transferPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(65917);
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(65917);
      return;
    case -1315: 
    case -1314: 
    case -1301: 
      i = -1301;
    }
    for (;;)
    {
      if (this.mMainHandler != null) {
        this.mMainHandler.post(new TXLivePusher.12(this, i, paramBundle));
      }
      AppMethodBeat.o(65917);
      return;
      AppMethodBeat.o(65917);
      return;
      i = -1302;
      continue;
      AppMethodBeat.o(65917);
      return;
      AppMethodBeat.o(65917);
      return;
      i = 1008;
      continue;
      i = 1103;
      continue;
      AppMethodBeat.o(65917);
      return;
      i = -1303;
      continue;
      i = 1001;
      continue;
      i = 1002;
      continue;
      i = 1101;
      continue;
      i = 3003;
      continue;
      i = 3002;
      continue;
      i = 3004;
      continue;
      i = -1307;
      continue;
      i = -1307;
      continue;
      i = -1307;
      continue;
      i = -1307;
      continue;
      i = 1102;
      continue;
      i = 3005;
      continue;
      i = -1313;
      continue;
      i = 1020;
      continue;
      i = 1018;
      continue;
      i = 1019;
      continue;
      i = 1021;
    }
  }
  
  private void updateId(String paramString)
  {
    AppMethodBeat.i(65904);
    if (this.mStreamUploader != null) {
      this.mStreamUploader.setID(paramString);
    }
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.setID(paramString);
    }
    if (this.mDataReport != null) {
      this.mDataReport.d(paramString);
    }
    if (this.mEventRecorderProxy == null) {
      this.mEventRecorderProxy = new TXCEventRecorderProxy();
    }
    this.mEventRecorderProxy.a(paramString, com.tencent.liteav.basic.util.b.e(this.mContext));
    this.mEventRecorderProxy.a("18446744073709551615", com.tencent.liteav.basic.util.b.e(this.mContext));
    this.mID = paramString;
    AppMethodBeat.o(65904);
  }
  
  public TXLivePushConfig getConfig()
  {
    return this.mConfig;
  }
  
  public int getMaxZoom()
  {
    AppMethodBeat.i(65844);
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65844);
      return 0;
    }
    int i = this.mCaptureAndEnc.q();
    AppMethodBeat.o(65844);
    return i;
  }
  
  public int getMusicDuration(String paramString)
  {
    AppMethodBeat.i(65857);
    int i = this.mCaptureAndEnc.d(paramString);
    AppMethodBeat.o(65857);
    return i;
  }
  
  public boolean isPushing()
  {
    AppMethodBeat.i(65832);
    if (this.mCaptureAndEnc != null)
    {
      boolean bool = this.mCaptureAndEnc.l();
      AppMethodBeat.o(65832);
      return bool;
    }
    AppMethodBeat.o(65832);
    return false;
  }
  
  public void onDetectFacePoints(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(65884);
    if (this.mPreprocessListener != null) {
      this.mPreprocessListener.onDetectFacePoints(paramArrayOfFloat);
    }
    AppMethodBeat.o(65884);
  }
  
  public void onEnableDropStatusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(65892);
    if (this.mStreamUploader != null) {
      this.mStreamUploader.setDropEanble(paramBoolean);
    }
    AppMethodBeat.o(65892);
  }
  
  public void onEncAudio(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65893);
    if ((this.mStreamUploader != null) && (paramArrayOfByte != null)) {
      this.mStreamUploader.pushAAC(paramArrayOfByte, paramLong);
    }
    if ((this.mIsRecording) && (this.mMP4Muxer != null) && (this.mStartMuxer) && (paramArrayOfByte != null)) {
      this.mMP4Muxer.a(paramArrayOfByte, 0, paramArrayOfByte.length, 1000L * paramLong, 0);
    }
    AppMethodBeat.o(65893);
  }
  
  public void onEncVideo(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(146870);
    if (this.mQos != null) {
      this.mQos.setHasVideo(true);
    }
    if ((this.mStreamUploader != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null)) {}
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
            if (((TXLivePusher.MsgInfo)localObject2).ts <= paramTXSNALPacket.pts)
            {
              if (((TXLivePusher.MsgInfo)localObject2).msg.length > 10240) {
                break label511;
              }
              j = ((TXLivePusher.MsgInfo)localObject2).msg.length;
              break label502;
            }
          }
          if (i != 0)
          {
            localObject1 = new byte[paramTXSNALPacket.nalData.length + i];
            localObject2 = new byte[5];
            Iterator localIterator = this.mMsgArray.iterator();
            i = 0;
            j = 0;
            if (!localIterator.hasNext()) {
              break label526;
            }
            TXLivePusher.MsgInfo localMsgInfo = (TXLivePusher.MsgInfo)localIterator.next();
            if (localMsgInfo.ts > paramTXSNALPacket.pts) {
              break label526;
            }
            if (localMsgInfo.msg.length > 10240) {
              break label518;
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
            System.arraycopy(paramTXSNALPacket.nalData, 0, localObject1, j, paramTXSNALPacket.nalData.length);
            paramTXSNALPacket.nalData = ((byte[])localObject1);
          }
        }
        this.mStreamUploader.pushNAL(paramTXSNALPacket);
        if ((this.mIsRecording) && (this.mMP4Muxer != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null))
        {
          localObject1 = transferAvccToAnnexb(paramTXSNALPacket.nalData);
          if (!this.mStartMuxer)
          {
            if (paramTXSNALPacket.nalType != 0) {
              continue;
            }
            localObject2 = com.tencent.liteav.basic.util.b.a((byte[])localObject1, this.mCaptureAndEnc.b(), this.mCaptureAndEnc.c());
            if (localObject2 != null)
            {
              this.mMP4Muxer.a((MediaFormat)localObject2);
              this.mMP4Muxer.a();
              this.mStartMuxer = true;
              this.mRecordStartTime = 0L;
            }
          }
          recordVideoData(paramTXSNALPacket, (byte[])localObject1);
        }
        AppMethodBeat.o(146870);
        return;
      }
      finally
      {
        AppMethodBeat.o(146870);
      }
      for (;;)
      {
        label502:
        i = j + 5 + i;
        break;
        label511:
        j = 10240;
      }
      label518:
      int k = 10240;
      continue;
      label526:
      k = 0;
    }
  }
  
  public void onEncVideoFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(65897);
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
    AppMethodBeat.o(65897);
  }
  
  public void onEncoderParamsChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(65891);
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
      TXCEventRecorderProxy.a(this.mPushUrl, 91006, -1, -1, "Qos Change(mode:" + this.mNewConfig.f + " bitrate:" + paramInt1 + " videosize:" + this.mNewConfig.a + " * " + this.mNewConfig.b + ")", 0);
    }
    AppMethodBeat.o(65891);
  }
  
  public int onGetEncoderRealBitrate()
  {
    AppMethodBeat.i(65886);
    int i = TXCStatus.c(this.mID, 4002);
    AppMethodBeat.o(65886);
    return i;
  }
  
  public int onGetQueueInputSize()
  {
    AppMethodBeat.i(65887);
    int i = TXCStatus.c(this.mID, 7002);
    if (this.mNewConfig.J) {
      i += TXCStatus.c(this.mID, 7001);
    }
    for (;;)
    {
      AppMethodBeat.o(65887);
      return i;
      i += TXCStatus.c(this.mID, 4002);
    }
  }
  
  public int onGetQueueOutputSize()
  {
    AppMethodBeat.i(65888);
    if (this.mStreamUploader == null)
    {
      AppMethodBeat.o(65888);
      return 0;
    }
    int i = TXCStatus.c(this.mID, 7004);
    int j = TXCStatus.c(this.mID, 7003);
    AppMethodBeat.o(65888);
    return i + j;
  }
  
  public int onGetVideoDropCount()
  {
    AppMethodBeat.i(65890);
    int i = TXCStatus.c(this.mID, 7007);
    AppMethodBeat.o(65890);
    return i;
  }
  
  public int onGetVideoQueueCurrentCount()
  {
    AppMethodBeat.i(65889);
    int i = TXCStatus.c(this.mID, 7005);
    AppMethodBeat.o(65889);
    return i;
  }
  
  public int onGetVideoQueueMaxCount()
  {
    return 5;
  }
  
  public void onLogRecord(String paramString)
  {
    AppMethodBeat.i(65840);
    TXCLog.d("User", paramString);
    AppMethodBeat.o(65840);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(65882);
    if (this.mMainHandler != null) {
      this.mMainHandler.post(new TXLivePusher.5(this, paramBundle, paramInt));
    }
    transferPushEvent(paramInt, paramBundle);
    String str1 = this.mPushUrl;
    if ((str1 != null) && (str1.length() > 0)) {
      if ((paramInt == 1018) || (paramInt == 1019) || (paramInt == 1021) || (paramInt == 1020))
      {
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(65882);
          return;
        case 1018: 
          TXCEventRecorderProxy.a(str1, 91009, -1, -1, "enter", 0);
          AppMethodBeat.o(65882);
          return;
        case 1019: 
          TXCEventRecorderProxy.a(str1, 91009, -1, -1, "exit", 0);
          AppMethodBeat.o(65882);
          return;
        case 1021: 
          TXCEventRecorderProxy.a(str1, 91009, -1, -1, "reenter", 0);
          AppMethodBeat.o(65882);
          return;
        }
        paramBundle = paramBundle.getString("EVT_MSG");
      }
    }
    for (;;)
    {
      HashSet localHashSet;
      StringBuilder localStringBuilder;
      try
      {
        paramBundle = new JSONObject(paramBundle).getJSONArray("userlist");
        localHashSet = new HashSet();
        localStringBuilder = new StringBuilder();
        if (((paramBundle == null) || (paramBundle.length() == 0)) && (this.mUserList.size() > 0))
        {
          i = j;
          if (i == 0) {
            break label480;
          }
          if (localHashSet.size() != 0) {
            break label431;
          }
          this.mUserList.clear();
          TXCEventRecorderProxy.a(str1, 91009, -1, -1, "userlist:", 0);
          AppMethodBeat.o(65882);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        AppMethodBeat.o(65882);
        return;
      }
      if (paramBundle != null)
      {
        i = 0;
        paramInt = 0;
      }
      for (;;)
      {
        if (i < paramBundle.length())
        {
          String str2 = paramBundle.getJSONObject(i).getString("userid");
          localHashSet.add(str2);
          if (i == 0) {
            localStringBuilder.append(str2);
          }
          while ((this.mUserList != null) && (this.mUserList.size() > 0))
          {
            if (this.mUserList.contains(str2)) {
              break label624;
            }
            break;
            localStringBuilder.append(":".concat(String.valueOf(str2)));
          }
        }
        if (this.mUserList == null) {
          break label631;
        }
        i = j;
        if (paramBundle.length() != this.mUserList.size()) {
          break;
        }
        break label631;
        label431:
        this.mUserList.clear();
        this.mUserList.addAll(localHashSet);
        TXCEventRecorderProxy.a(str1, 91009, -1, -1, "userlist:" + localStringBuilder.toString(), 0);
        label480:
        AppMethodBeat.o(65882);
        return;
        long l = System.currentTimeMillis();
        if ((paramInt == -1303) || (paramInt == 1101) || (paramInt == 1006))
        {
          if (l - ((Long)this.mLastReportTime.get(Integer.valueOf(paramInt))).longValue() < 5000L)
          {
            AppMethodBeat.o(65882);
            return;
          }
          this.mLastReportTime.put(Integer.valueOf(paramInt), Long.valueOf(l));
        }
        if ((paramInt != 1018) && (paramInt != 1019) && (paramInt != 1021) && (paramInt != 1020)) {
          TXCEventRecorderProxy.a(str1, 91008, -1, -1, paramBundle.getString("EVT_MSG"), 0);
        }
        AppMethodBeat.o(65882);
        return;
        i = 0;
        break;
        paramInt = 1;
        label624:
        i += 1;
      }
      label631:
      int i = paramInt;
    }
  }
  
  public void onRecordPcm(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(65896);
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.mAudioProcessListener;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(65896);
  }
  
  public void onRecordRawPcm(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(65895);
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.mAudioProcessListener;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
    AppMethodBeat.o(65895);
  }
  
  public int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(65883);
    if (this.mPreprocessListener != null)
    {
      paramInt1 = this.mPreprocessListener.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(65883);
      return paramInt1;
    }
    AppMethodBeat.o(65883);
    return 0;
  }
  
  public void onTextureDestoryed()
  {
    AppMethodBeat.i(65885);
    if (this.mPreprocessListener != null) {
      this.mPreprocessListener.onTextureDestoryed();
    }
    AppMethodBeat.o(65885);
  }
  
  public boolean pauseBGM()
  {
    AppMethodBeat.i(65852);
    TXCLog.d(TAG, "liteav_api pauseBGM ");
    boolean bool = this.mCaptureAndEnc.s();
    AppMethodBeat.o(65852);
    return bool;
  }
  
  public void pausePusher()
  {
    AppMethodBeat.i(65830);
    TXCLog.d(TAG, "liteav_api pausePusher ".concat(String.valueOf(this)));
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.j();
    }
    if ((this.mPushUrl != null) && (this.mPushUrl.length() > 0))
    {
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, "pausePusher", 0);
      AppMethodBeat.o(65830);
      return;
    }
    this.mCallFuncBeforeStartPush.add("pausePusher");
    AppMethodBeat.o(65830);
  }
  
  public boolean playBGM(String paramString)
  {
    AppMethodBeat.i(65850);
    TXCLog.d(TAG, "liteav_api playBGM ".concat(String.valueOf(paramString)));
    boolean bool = this.mCaptureAndEnc.c(paramString);
    AppMethodBeat.o(65850);
    return bool;
  }
  
  public boolean resumeBGM()
  {
    AppMethodBeat.i(65853);
    TXCLog.d(TAG, "liteav_api resumeBGM ");
    boolean bool = this.mCaptureAndEnc.t();
    AppMethodBeat.o(65853);
    return bool;
  }
  
  public void resumePusher()
  {
    AppMethodBeat.i(65831);
    TXCLog.d(TAG, "liteav_api resumePusher ".concat(String.valueOf(this)));
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.k();
    }
    if ((this.mPushUrl != null) && (this.mPushUrl.length() > 0))
    {
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, "resumePusher", 0);
      AppMethodBeat.o(65831);
      return;
    }
    this.mCallFuncBeforeStartPush.add("resumePusher");
    AppMethodBeat.o(65831);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65843);
    this.mCaptureAndEnc.a(paramArrayOfByte);
    AppMethodBeat.o(65843);
  }
  
  public int sendCustomVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(65841);
    if (this.mCaptureAndEnc != null)
    {
      switch (paramInt1)
      {
      case 4: 
      default: 
        AppMethodBeat.o(65841);
        return -1000;
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        paramInt1 = this.mCaptureAndEnc.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, 0L);
        AppMethodBeat.o(65841);
        return paramInt1;
      }
    }
    AppMethodBeat.o(65841);
    return -1000;
  }
  
  public int sendCustomVideoTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(65842);
    if (this.mCaptureAndEnc != null)
    {
      paramInt1 = this.mCaptureAndEnc.c(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(65842);
      return paramInt1;
    }
    AppMethodBeat.o(65842);
    return -1000;
  }
  
  @Deprecated
  public void sendMessage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65920);
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
    finally
    {
      AppMethodBeat.o(65920);
    }
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65921);
    if ((paramArrayOfByte.length <= 0) || (paramArrayOfByte.length > 2048))
    {
      AppMethodBeat.o(65921);
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
    finally
    {
      AppMethodBeat.o(65921);
    }
  }
  
  public void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener paramAudioCustomProcessListener)
  {
    AppMethodBeat.i(65862);
    TXCLog.d(TAG, "liteav_api setAudioProcessListener ".concat(String.valueOf(paramAudioCustomProcessListener)));
    this.mAudioProcessListener = paramAudioCustomProcessListener;
    AppMethodBeat.o(65862);
  }
  
  public void setBGMNofify(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(65849);
    TXCLog.d(TAG, "liteav_api setBGMNofify ".concat(String.valueOf(paramOnBGMNotify)));
    this.mBGMNotify = paramOnBGMNotify;
    if (this.mBGMNotify != null)
    {
      this.mCaptureAndEnc.a(new TXLivePusher.1(this));
      AppMethodBeat.o(65849);
      return;
    }
    this.mCaptureAndEnc.a(null);
    AppMethodBeat.o(65849);
  }
  
  public boolean setBGMVolume(float paramFloat)
  {
    AppMethodBeat.i(65855);
    TXCLog.d(TAG, "liteav_api setBGMVolume ".concat(String.valueOf(paramFloat)));
    boolean bool = this.mCaptureAndEnc.e(paramFloat);
    AppMethodBeat.o(65855);
    return bool;
  }
  
  public boolean setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65867);
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
    AppMethodBeat.o(65867);
    return true;
  }
  
  public void setBgmPitch(float paramFloat)
  {
    AppMethodBeat.i(65856);
    this.mBgmPitch = paramFloat;
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.b(paramFloat);
    }
    AppMethodBeat.o(65856);
  }
  
  public void setChinLevel(int paramInt)
  {
    AppMethodBeat.i(65877);
    TXCLog.d(TAG, "liteav_api setChinLevel ".concat(String.valueOf(paramInt)));
    e.a().a(null, this.mContext);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.g(paramInt);
    }
    AppMethodBeat.o(65877);
  }
  
  public void setConfig(TXLivePushConfig paramTXLivePushConfig)
  {
    AppMethodBeat.i(65826);
    TXCLog.d(TAG, "liteav_api setConfig " + paramTXLivePushConfig + ", " + this);
    TXLivePushConfig localTXLivePushConfig = paramTXLivePushConfig;
    if (paramTXLivePushConfig == null) {
      localTXLivePushConfig = new TXLivePushConfig();
    }
    this.mConfig = localTXLivePushConfig;
    transferConfig(localTXLivePushConfig);
    applyConfig();
    paramTXLivePushConfig = "setConfig:" + this.mNewConfig.h + ":" + this.mNewConfig.a + "*" + this.mNewConfig.b + ":" + this.mNewConfig.c + ":" + this.mNewConfig.e + ":" + this.mNewConfig.d;
    if ((this.mPushUrl != null) && (this.mPushUrl.length() > 0))
    {
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, paramTXLivePushConfig, 0);
      AppMethodBeat.o(65826);
      return;
    }
    this.mCallFuncBeforeStartPush.add(paramTXLivePushConfig);
    AppMethodBeat.o(65826);
  }
  
  public void setExposureCompensation(float paramFloat)
  {
    AppMethodBeat.i(65848);
    TXCLog.d(TAG, "liteav_api setExposureCompensation ".concat(String.valueOf(paramFloat)));
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65848);
      return;
    }
    this.mCaptureAndEnc.c(paramFloat);
    AppMethodBeat.o(65848);
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    AppMethodBeat.i(65872);
    TXCLog.d(TAG, "liteav_api setEyeScaleLevel ".concat(String.valueOf(paramInt)));
    e.a().a(null, this.mContext);
    if (this.mConfig != null) {
      this.mConfig.setEyeScaleLevel(paramInt);
    }
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.c(paramInt);
    }
    AppMethodBeat.o(65872);
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    AppMethodBeat.i(65876);
    TXCLog.d(TAG, "liteav_api setFaceShortLevel ".concat(String.valueOf(paramInt)));
    e.a().a(null, this.mContext);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.f(paramInt);
    }
    AppMethodBeat.o(65876);
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    AppMethodBeat.i(65873);
    TXCLog.d(TAG, "liteav_api setFaceSlimLevel ".concat(String.valueOf(paramInt)));
    e.a().a(null, this.mContext);
    if (this.mConfig != null) {
      this.mConfig.setFaceSlimLevel(paramInt);
    }
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.d(paramInt);
    }
    AppMethodBeat.o(65873);
  }
  
  public void setFaceVLevel(int paramInt)
  {
    AppMethodBeat.i(65874);
    TXCLog.d(TAG, "liteav_api setFaceVLevel ".concat(String.valueOf(paramInt)));
    e.a().a(null, this.mContext);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.e(paramInt);
    }
    AppMethodBeat.o(65874);
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    AppMethodBeat.i(65868);
    TXCLog.d(TAG, "liteav_api setFilter ".concat(String.valueOf(paramBitmap)));
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramBitmap);
    }
    AppMethodBeat.o(65868);
  }
  
  public void setFocusPosition(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(65846);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(65846);
  }
  
  @TargetApi(18)
  public boolean setGreenScreenFile(String paramString)
  {
    AppMethodBeat.i(65871);
    TXCLog.d(TAG, "liteav_api setGreenScreenFile ".concat(String.valueOf(paramString)));
    e.a().a(null, this.mContext);
    if (this.mCaptureAndEnc != null)
    {
      boolean bool = this.mCaptureAndEnc.b(paramString);
      AppMethodBeat.o(65871);
      return bool;
    }
    AppMethodBeat.o(65871);
    return false;
  }
  
  public boolean setMicVolume(float paramFloat)
  {
    AppMethodBeat.i(65854);
    TXCLog.d(TAG, "liteav_api setMicVolume ".concat(String.valueOf(paramFloat)));
    boolean bool = this.mCaptureAndEnc.d(paramFloat);
    AppMethodBeat.o(65854);
    return bool;
  }
  
  public boolean setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(65847);
    TXCLog.d(TAG, "liteav_api setMirror ".concat(String.valueOf(paramBoolean)));
    if (this.mConfig != null) {
      this.mConfig.setVideoEncoderXMirror(paramBoolean);
    }
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65847);
      return false;
    }
    this.mCaptureAndEnc.e(paramBoolean);
    AppMethodBeat.o(65847);
    return true;
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    AppMethodBeat.i(65870);
    TXCLog.d(TAG, "liteav_api setMotionMute ".concat(String.valueOf(paramBoolean)));
    e.a().a(null, this.mContext);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.c(paramBoolean);
    }
    AppMethodBeat.o(65870);
  }
  
  public void setMotionTmpl(String paramString)
  {
    AppMethodBeat.i(65869);
    TXCLog.d(TAG, "liteav_api motionPath ".concat(String.valueOf(paramString)));
    e.a().a(null, this.mContext);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramString);
    }
    AppMethodBeat.o(65869);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(65839);
    TXCLog.d(TAG, "liteav_api setMute ".concat(String.valueOf(paramBoolean)));
    if ((this.mPushUrl != null) && (this.mPushUrl.length() > 0)) {
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, "setMute:".concat(String.valueOf(paramBoolean)), 0);
    }
    for (;;)
    {
      if (this.mCaptureAndEnc != null) {
        this.mCaptureAndEnc.d(paramBoolean);
      }
      if ((this.mConfig.mEnablePureAudioPush) && (this.mStreamUploader != null)) {
        this.mStreamUploader.setAudioMute(paramBoolean);
      }
      AppMethodBeat.o(65839);
      return;
      this.mCallFuncBeforeStartPush.add("setMute:".concat(String.valueOf(paramBoolean)));
    }
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    AppMethodBeat.i(65878);
    TXCLog.d(TAG, "liteav_api setNoseSlimLevel ".concat(String.valueOf(paramInt)));
    e.a().a(null, this.mContext);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.h(paramInt);
    }
    AppMethodBeat.o(65878);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(65827);
    TXCLog.d(TAG, "liteav_api setPushListener ".concat(String.valueOf(paramITXLivePushListener)));
    this.mListener = paramITXLivePushListener;
    AppMethodBeat.o(65827);
  }
  
  public void setRenderRotation(int paramInt)
  {
    AppMethodBeat.i(65860);
    TXCLog.d(TAG, "liteav_api setRenderRotation ");
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65860);
      return;
    }
    this.mCaptureAndEnc.a(paramInt);
    AppMethodBeat.o(65860);
  }
  
  public void setReverb(int paramInt)
  {
    AppMethodBeat.i(65880);
    TXCLog.d(TAG, "liteav_api setReverb ".concat(String.valueOf(paramInt)));
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65880);
      return;
    }
    this.mCaptureAndEnc.j(paramInt);
    AppMethodBeat.o(65880);
  }
  
  public void setSpecialRatio(float paramFloat)
  {
    AppMethodBeat.i(65875);
    TXCLog.d(TAG, "liteav_api setSpecialRatio ".concat(String.valueOf(paramFloat)));
    e.a().a(null, this.mContext);
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(paramFloat);
    }
    AppMethodBeat.o(65875);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(65835);
    TXCLog.d(TAG, "liteav_api setSurface ".concat(String.valueOf(paramSurface)));
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65835);
      return;
    }
    this.mCaptureAndEnc.a(paramSurface);
    AppMethodBeat.o(65835);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65836);
    TXCLog.d(TAG, "liteav_api setSurfaceSize " + paramInt1 + "," + paramInt2);
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65836);
      return;
    }
    this.mCaptureAndEnc.a(paramInt1, paramInt2);
    AppMethodBeat.o(65836);
  }
  
  public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    AppMethodBeat.i(65861);
    TXCLog.d(TAG, "liteav_api setVideoProcessListener ".concat(String.valueOf(paramVideoCustomProcessListener)));
    this.mPreprocessListener = paramVideoCustomProcessListener;
    if (this.mPreprocessListener == null)
    {
      if (this.mCaptureAndEnc != null)
      {
        this.mCaptureAndEnc.a(null);
        AppMethodBeat.o(65861);
      }
    }
    else if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.a(this);
    }
    AppMethodBeat.o(65861);
  }
  
  public void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    int j = 1;
    AppMethodBeat.i(65879);
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
    Object localObject = "setVideoQuality:" + i + ":" + paramBoolean1 + ":" + paramBoolean2;
    if ((this.mPushUrl != null) && (this.mPushUrl.length() > 0)) {
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, (String)localObject, 0);
    }
    for (;;)
    {
      if (this.mConfig == null) {
        this.mConfig = new TXLivePushConfig();
      }
      this.mConfig.setVideoFPS(18);
      switch (i)
      {
      default: 
        this.mConfig.setHardwareAcceleration(2);
        TXCLog.e(TAG, "setVideoPushQuality: invalid quality ".concat(String.valueOf(i)));
        AppMethodBeat.o(65879);
        return;
        this.mCallFuncBeforeStartPush.add(localObject);
      }
    }
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
    localObject = this.mConfig;
    if (paramBoolean2)
    {
      label355:
      ((TXLivePushConfig)localObject).enableVideoHardEncoderMainProfile(bool);
      localObject = this.mConfig;
      if (!paramBoolean2) {
        break label1056;
      }
    }
    label1056:
    for (paramInt = j;; paramInt = 3)
    {
      ((TXLivePushConfig)localObject).setVideoEncodeGop(paramInt);
      if (this.mNewConfig != null)
      {
        this.mNewConfig.J = paramBoolean2;
        this.mNewConfig.K = paramBoolean1;
      }
      setConfig(this.mConfig);
      AppMethodBeat.o(65879);
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
      break label355;
    }
  }
  
  public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(65866);
    TXCLog.d(TAG, "liteav_api setVideoRecordListener ".concat(String.valueOf(paramITXVideoRecordListener)));
    this.mRecordListener = paramITXVideoRecordListener;
    AppMethodBeat.o(65866);
  }
  
  public void setVoiceChangerType(int paramInt)
  {
    AppMethodBeat.i(65881);
    switch (paramInt)
    {
    default: 
      this.mVoiceKind = -1;
      this.mVoiceEnvironment = -1;
    }
    for (;;)
    {
      if (this.mCaptureAndEnc != null) {
        this.mCaptureAndEnc.b(this.mVoiceKind, this.mVoiceEnvironment);
      }
      AppMethodBeat.o(65881);
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
    AppMethodBeat.i(65845);
    TXCLog.d(TAG, "liteav_api setZoom ".concat(String.valueOf(paramInt)));
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65845);
      return false;
    }
    boolean bool = this.mCaptureAndEnc.i(paramInt);
    AppMethodBeat.o(65845);
    return bool;
  }
  
  public void snapshot(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(65863);
    TXCLog.d(TAG, "liteav_api snapshot ".concat(String.valueOf(paramITXSnapshotListener)));
    if ((this.mSnapshotRunning) || (paramITXSnapshotListener == null) || (this.mCaptureAndEnc == null))
    {
      AppMethodBeat.o(65863);
      return;
    }
    if (this.mCaptureAndEnc != null)
    {
      this.mSnapshotRunning = true;
      this.mCaptureAndEnc.a(new TXLivePusher.2(this, paramITXSnapshotListener));
      this.mMainHandler.postDelayed(this.mSnapShotTimeOutRunnable, 2000L);
      AppMethodBeat.o(65863);
      return;
    }
    this.mSnapshotRunning = false;
    AppMethodBeat.o(65863);
  }
  
  public void startCameraPreview(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(65833);
    TXCLog.d(TAG, "liteav_api startCameraPreview " + paramTXCloudVideoView + ", " + this);
    if ((this.mPushUrl != null) && (this.mPushUrl.length() > 0)) {
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, "startPreview", 0);
    }
    for (;;)
    {
      setConfig(this.mConfig);
      if (!this.mNewConfig.G) {
        break;
      }
      TXCLog.e(TAG, "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(65833);
      return;
      this.mCallFuncBeforeStartPush.add("startPreview");
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
    e.a().a(null, this.mContext);
    AppMethodBeat.o(65833);
  }
  
  public int startPusher(String paramString)
  {
    AppMethodBeat.i(65828);
    TXCLog.d(TAG, "liteav_api startPusher ".concat(String.valueOf(this)));
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e(TAG, "start push error when url is empty ".concat(String.valueOf(this)));
      AppMethodBeat.o(65828);
      return -1;
    }
    if ((!TextUtils.isEmpty(this.mPushUrl)) && (isPushing()))
    {
      if (this.mPushUrl.equalsIgnoreCase(paramString))
      {
        TXCLog.w(TAG, "ignore start push when new url is the same with old url  ".concat(String.valueOf(this)));
        AppMethodBeat.o(65828);
        return -1;
      }
      TXCLog.w(TAG, " stop old push when new url is not the same with old url  ".concat(String.valueOf(this)));
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
    paramString = this.mCallFuncBeforeStartPush.iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, str, 0);
    }
    this.mCallFuncBeforeStartPush.clear();
    TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, "startPush", 0);
    startStatusNotify();
    if (this.mTXCloudVideoView != null) {
      this.mTXCloudVideoView.clearLog();
    }
    AppMethodBeat.o(65828);
    return 0;
  }
  
  public int startRecord(String paramString)
  {
    AppMethodBeat.i(65864);
    TXCLog.d(TAG, "liteav_api startRecord ".concat(String.valueOf(paramString)));
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e(TAG, "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
      AppMethodBeat.o(65864);
      return -3;
    }
    if (this.mIsRecording)
    {
      TXCLog.w(TAG, "ignore start record when recording");
      AppMethodBeat.o(65864);
      return -1;
    }
    if ((this.mCaptureAndEnc == null) || (!this.mCaptureAndEnc.l()))
    {
      TXCLog.w(TAG, "ignore start record when not pushing");
      AppMethodBeat.o(65864);
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
    if (this.mCaptureAndEnc != null) {
      this.mCaptureAndEnc.v();
    }
    AppMethodBeat.o(65864);
    return 0;
  }
  
  public void startScreenCapture()
  {
    AppMethodBeat.i(65858);
    TXCLog.d(TAG, "liteav_api startScreenCapture ");
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65858);
      return;
    }
    this.mCaptureAndEnc.n();
    AppMethodBeat.o(65858);
  }
  
  public boolean stopBGM()
  {
    AppMethodBeat.i(65851);
    TXCLog.d(TAG, "liteav_api stopBGM ");
    boolean bool = this.mCaptureAndEnc.r();
    AppMethodBeat.o(65851);
    return bool;
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(65834);
    TXCLog.d(TAG, "liteav_api stopCameraPreview " + paramBoolean + ", " + this);
    if ((this.mPushUrl != null) && (this.mPushUrl.length() > 0)) {
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, "stopPreview", 0);
    }
    while (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65834);
      return;
      this.mCallFuncBeforeStartPush.add("stopPreview");
    }
    this.mCaptureAndEnc.a(paramBoolean);
    AppMethodBeat.o(65834);
  }
  
  public void stopPusher()
  {
    AppMethodBeat.i(65829);
    TXCLog.d(TAG, "liteav_api stopPusher ".concat(String.valueOf(this)));
    if ((this.mPushUrl != null) && (this.mPushUrl.length() > 0)) {
      TXCEventRecorderProxy.a(this.mPushUrl, 91007, -1, -1, "stopPush", 0);
    }
    stopRecord();
    stopStatusNotify();
    stopDataReportModule();
    stopQosModule();
    stopEncoder();
    this.mNewConfig.J = false;
    stopNetworkModule();
    this.mPushUrl = "";
    this.mUserList.clear();
    AppMethodBeat.o(65829);
  }
  
  public void stopRecord()
  {
    AppMethodBeat.i(65865);
    TXCLog.d(TAG, "liteav_api stopRecord ");
    if ((this.mIsRecording) && (this.mMP4Muxer != null))
    {
      int i = this.mMP4Muxer.b();
      TXCLog.w(TAG, "start record ");
      this.mIsRecording = false;
      if (i == 0)
      {
        AsyncTask.execute(new TXLivePusher.4(this, this.mVideoFilePath));
        AppMethodBeat.o(65865);
        return;
      }
      callbackRecordFail();
    }
    AppMethodBeat.o(65865);
  }
  
  public void stopScreenCapture()
  {
    AppMethodBeat.i(65859);
    TXCLog.d(TAG, "liteav_api stopScreenCapture ");
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65859);
      return;
    }
    this.mCaptureAndEnc.o();
    AppMethodBeat.o(65859);
  }
  
  public void switchCamera()
  {
    AppMethodBeat.i(65837);
    TXCLog.d(TAG, "liteav_api switchCamera ");
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65837);
      return;
    }
    this.mCaptureAndEnc.m();
    AppMethodBeat.o(65837);
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    AppMethodBeat.i(65838);
    TXCLog.d(TAG, "liteav_api turnOnFlashLight ".concat(String.valueOf(paramBoolean)));
    if (this.mCaptureAndEnc == null)
    {
      AppMethodBeat.o(65838);
      return false;
    }
    paramBoolean = this.mCaptureAndEnc.b(paramBoolean);
    AppMethodBeat.o(65838);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher
 * JD-Core Version:    0.7.0.1
 */