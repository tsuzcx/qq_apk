package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.g;
import com.tencent.liteav.i;
import com.tencent.liteav.i.a;
import com.tencent.liteav.m;
import com.tencent.liteav.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.util.Iterator;
import java.util.Vector;

public class TXLivePlayer
  implements a
{
  public static final int PLAY_TYPE_LIVE_FLV = 1;
  public static final int PLAY_TYPE_LIVE_RTMP = 0;
  public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
  public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
  public static final int PLAY_TYPE_VOD_FLV = 2;
  public static final int PLAY_TYPE_VOD_HLS = 3;
  public static final int PLAY_TYPE_VOD_MP4 = 4;
  public static final String TAG = "TXLivePlayer";
  private TXLivePlayer.ITXAudioRawDataListener mAudioRawDataListener;
  private int mAudioRoute;
  private boolean mAutoPlay;
  private Vector<String> mCallFuncBeforeStartPlay;
  private TXLivePlayConfig mConfig;
  private Context mContext;
  private int mCurrentPlayType;
  private boolean mEnableHWDec;
  private boolean mIsNeedClearLastImg;
  private boolean mIsShiftPlaying;
  private long mLastReportTime;
  private ITXLivePlayListener mListener;
  private String mLivePlayUrl;
  private boolean mMute;
  private String mPlayUrl;
  private m mPlayer;
  private long mProgressStartTime;
  private float mRate;
  private int mRenderMode;
  private int mRenderRotation;
  private boolean mSnapshotRunning;
  private Surface mSurface;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private TXCloudVideoView mTXCloudVideoView;
  private i mTimeShiftUtil;
  private byte[] mVideoRawBuf;
  private TXLivePlayer.ITXVideoRawDataListener mVideoRawDataListener;
  
  public TXLivePlayer(Context paramContext)
  {
    AppMethodBeat.i(65938);
    this.mEnableHWDec = false;
    this.mIsNeedClearLastImg = true;
    this.mPlayUrl = "";
    this.mMute = false;
    this.mVideoRawDataListener = null;
    this.mVideoRawBuf = null;
    this.mAutoPlay = true;
    this.mRate = 1.0F;
    this.mSnapshotRunning = false;
    this.mAudioRoute = 0;
    this.mCurrentPlayType = -1;
    this.mCallFuncBeforeStartPlay = new Vector();
    this.mLastReportTime = 0L;
    TXCLog.init();
    this.mListener = null;
    this.mContext = paramContext.getApplicationContext();
    AppMethodBeat.o(65938);
  }
  
  private String checkPlayUrl(String paramString, int paramInt)
  {
    AppMethodBeat.i(65969);
    Object localObject = paramString;
    if (paramInt != 6) {}
    label62:
    label87:
    label220:
    label226:
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i;
      try
      {
        localObject = paramString.getBytes("UTF-8");
        localStringBuilder = new StringBuilder(localObject.length);
        paramInt = 0;
        if (paramInt >= localObject.length) {
          break label116;
        }
        if (localObject[paramInt] >= 0) {
          break label220;
        }
        i = localObject[paramInt] + 256;
      }
      catch (Exception localException)
      {
        str = paramString;
      }
      localStringBuilder.append(String.format("%%%02X", new Object[] { Integer.valueOf(i) }));
      break label213;
      localStringBuilder.append((char)i);
      break label213;
      String str;
      for (;;)
      {
        paramString = str.trim();
        AppMethodBeat.o(65969);
        return paramString;
        label116:
        str = localStringBuilder.toString();
      }
      for (;;)
      {
        if ((i <= 32) || (i >= 127) || (i == 34) || (i == 37) || (i == 60) || (i == 62) || (i == 91) || (i == 125) || (i == 92) || (i == 93) || (i == 94) || (i == 96) || (i == 123)) {
          break label226;
        }
        if (i != 124) {
          break label87;
        }
        break label62;
        paramInt += 1;
        break;
        i = str[paramInt];
      }
    }
  }
  
  private boolean isAVCDecBlacklistDevices()
  {
    AppMethodBeat.i(65968);
    if ((Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) && (Build.MODEL.equalsIgnoreCase("Che2-TL00")))
    {
      AppMethodBeat.o(65968);
      return true;
    }
    AppMethodBeat.o(65968);
    return false;
  }
  
  private void postBitmapToMainThread(final ITXSnapshotListener paramITXSnapshotListener, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(65970);
    if (paramITXSnapshotListener == null)
    {
      AppMethodBeat.o(65970);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(65608);
        if (paramITXSnapshotListener != null) {
          paramITXSnapshotListener.onSnapshot(paramBitmap);
        }
        TXLivePlayer.access$402(TXLivePlayer.this, false);
        AppMethodBeat.o(65608);
      }
    });
    AppMethodBeat.o(65970);
  }
  
  public boolean addVideoRawData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65964);
    if ((this.mPlayUrl == null) || (this.mPlayUrl.isEmpty()))
    {
      AppMethodBeat.o(65964);
      return false;
    }
    if (this.mEnableHWDec)
    {
      TXLog.e("TXLivePlayer", "can not addVideoRawData because of hw decode has set!");
      AppMethodBeat.o(65964);
      return false;
    }
    if (this.mPlayer == null)
    {
      TXCLog.e("TXLivePlayer", "player hasn't created or not instanceof live player");
      AppMethodBeat.o(65964);
      return false;
    }
    this.mVideoRawBuf = paramArrayOfByte;
    AppMethodBeat.o(65964);
    return true;
  }
  
  public boolean enableHardwareDecode(boolean paramBoolean)
  {
    AppMethodBeat.i(65958);
    TXCLog.d("TXLivePlayer", "liteav_api enableHardwareDecode ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT < 18)
      {
        TXCLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + Build.VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
        AppMethodBeat.o(65958);
        return false;
      }
      if (isAVCDecBlacklistDevices())
      {
        TXCLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
        AppMethodBeat.o(65958);
        return false;
      }
    }
    this.mEnableHWDec = paramBoolean;
    if (this.mPlayer != null)
    {
      g localg2 = this.mPlayer.h();
      g localg1 = localg2;
      if (localg2 == null) {
        localg1 = new g();
      }
      localg1.i = this.mEnableHWDec;
      this.mPlayer.a(localg1);
    }
    AppMethodBeat.o(65958);
    return true;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(65946);
    if (this.mPlayer != null)
    {
      boolean bool = this.mPlayer.c();
      AppMethodBeat.o(65946);
      return bool;
    }
    AppMethodBeat.o(65946);
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(65963);
    int i;
    if (paramInt == 15001)
    {
      if (this.mTXCloudVideoView != null) {
        this.mTXCloudVideoView.setLogText(paramBundle, null, 0);
      }
      if (this.mListener != null)
      {
        this.mListener.onNetStatus(paramBundle);
        AppMethodBeat.o(65963);
      }
    }
    else
    {
      long l;
      if (paramInt == 2005)
      {
        l = paramBundle.getInt("EVT_PLAY_PROGRESS_MS") + this.mProgressStartTime;
        if (l > 0L)
        {
          paramBundle.putInt("EVT_PLAY_PROGRESS", (int)(l / 1000L));
          paramBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)l);
          if (this.mListener != null) {
            this.mListener.onPlayEvent(paramInt, paramBundle);
          }
        }
        AppMethodBeat.o(65963);
        return;
      }
      if (paramInt != 2026)
      {
        l = System.currentTimeMillis();
        if (paramInt == 2101)
        {
          if (l - this.mLastReportTime < 5000L)
          {
            AppMethodBeat.o(65963);
            return;
          }
          this.mLastReportTime = l;
        }
        if ((paramInt != 2005) && (paramInt != 2012) && (this.mPlayUrl != null) && (this.mPlayUrl.length() > 0))
        {
          String str2 = paramBundle.getString("EVT_MSG");
          String str3 = this.mPlayUrl;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          TXCDRApi.reportEvent40003(str3, 92008, paramInt, str1, "");
        }
        i = paramInt;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(65963);
          return;
        case 2007: 
          i = 2007;
        }
      }
    }
    for (;;)
    {
      if (this.mTXCloudVideoView != null) {
        this.mTXCloudVideoView.setLogText(null, paramBundle, i);
      }
      if (this.mListener != null) {
        this.mListener.onPlayEvent(i, paramBundle);
      }
      AppMethodBeat.o(65963);
      return;
      i = 2004;
      continue;
      i = 2008;
      continue;
      i = 2106;
      continue;
      AppMethodBeat.o(65963);
      return;
      i = 2101;
      continue;
      i = -2304;
      continue;
      i = 2001;
      continue;
      i = 3003;
      continue;
      i = 3002;
      continue;
      i = 2103;
      continue;
      i = 2002;
      continue;
      i = 3002;
      continue;
      i = -2301;
      continue;
      i = -2302;
      continue;
      i = -2301;
      continue;
      i = 3005;
      continue;
      i = 2012;
      continue;
      i = 2015;
      continue;
      i = -2307;
      continue;
      i = 2005;
      continue;
      i = 2009;
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(65947);
    TXCLog.d("TXLivePlayer", "liteav_api pause ".concat(String.valueOf(this)));
    if ((this.mPlayUrl != null) && (this.mPlayUrl.length() > 0)) {
      TXCDRApi.reportEvent40003(this.mPlayUrl, 92007, 0, "pause", "");
    }
    if (this.mPlayer != null)
    {
      TXCLog.w("TXLivePlayer", "pause play");
      this.mPlayer.a();
    }
    AppMethodBeat.o(65947);
  }
  
  public int prepareLiveSeek(String paramString, int paramInt)
  {
    AppMethodBeat.i(65950);
    TXCLog.d("TXLivePlayer", "liteav_api prepareLiveSeek ".concat(String.valueOf(this)));
    if (this.mTimeShiftUtil == null) {
      this.mTimeShiftUtil = new i(this.mContext);
    }
    if (this.mTimeShiftUtil != null)
    {
      paramInt = this.mTimeShiftUtil.a(this.mPlayUrl, paramString, paramInt, new i.a()
      {
        public void onLiveTime(long paramAnonymousLong)
        {
          AppMethodBeat.i(65990);
          TXLivePlayer.access$002(TXLivePlayer.this, paramAnonymousLong);
          if (TXLivePlayer.this.mPlayer != null) {
            TXLivePlayer.this.mPlayer.g();
          }
          AppMethodBeat.o(65990);
        }
      });
      AppMethodBeat.o(65950);
      return paramInt;
    }
    AppMethodBeat.o(65950);
    return -1;
  }
  
  public void resume()
  {
    AppMethodBeat.i(65948);
    TXCLog.d("TXLivePlayer", "liteav_api resume ".concat(String.valueOf(this)));
    if ((this.mPlayUrl != null) && (this.mPlayUrl.length() > 0)) {
      TXCDRApi.reportEvent40003(this.mPlayUrl, 92007, 0, "resume", "");
    }
    if (this.mPlayer != null)
    {
      TXCLog.w("TXLivePlayer", "resume play");
      this.mPlayer.b();
      setAudioRoute(this.mAudioRoute);
    }
    AppMethodBeat.o(65948);
  }
  
  public int resumeLive()
  {
    AppMethodBeat.i(65951);
    TXCLog.d("TXLivePlayer", "liteav_api resumeLive ".concat(String.valueOf(this)));
    if (this.mIsShiftPlaying)
    {
      this.mIsShiftPlaying = false;
      int i = startPlay(this.mLivePlayUrl, 1);
      AppMethodBeat.o(65951);
      return i;
    }
    AppMethodBeat.o(65951);
    return -1;
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(65949);
    TXCLog.d("TXLivePlayer", "liteav_api ");
    if (this.mPlayer != null)
    {
      if ((this.mPlayer.f()) || (this.mIsShiftPlaying))
      {
        String str;
        if (this.mTimeShiftUtil != null)
        {
          str = this.mTimeShiftUtil.a(paramInt);
          if (TextUtils.isEmpty(str)) {
            break label113;
          }
          if (startPlay(str, 3) != 0) {
            break label108;
          }
        }
        label108:
        for (boolean bool = true;; bool = false)
        {
          this.mIsShiftPlaying = bool;
          if (!this.mIsShiftPlaying) {
            break label139;
          }
          this.mProgressStartTime = (paramInt * 1000);
          AppMethodBeat.o(65949);
          return;
          str = "";
          break;
        }
        label113:
        if (this.mListener != null) {
          this.mListener.onPlayEvent(-2301, new Bundle());
        }
        label139:
        AppMethodBeat.o(65949);
        return;
      }
      this.mPlayer.d(paramInt);
    }
    AppMethodBeat.o(65949);
  }
  
  public void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    AppMethodBeat.i(65967);
    TXCLog.d("TXLivePlayer", "liteav_api setAudioRawDataListener ".concat(String.valueOf(paramITXAudioRawDataListener)));
    this.mAudioRawDataListener = paramITXAudioRawDataListener;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramITXAudioRawDataListener);
    }
    AppMethodBeat.o(65967);
  }
  
  public void setAudioRoute(int paramInt)
  {
    AppMethodBeat.i(65962);
    TXCLog.d("TXLivePlayer", "liteav_api setAudioRoute ".concat(String.valueOf(paramInt)));
    this.mAudioRoute = paramInt;
    if (this.mPlayer != null) {
      this.mPlayer.a(this.mContext, this.mAudioRoute);
    }
    AppMethodBeat.o(65962);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(65960);
    TXCLog.d("TXLivePlayer", "liteav_api setAutoPlay ".concat(String.valueOf(paramBoolean)));
    this.mAutoPlay = paramBoolean;
    AppMethodBeat.o(65960);
  }
  
  public void setConfig(TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(65939);
    TXCLog.d("TXLivePlayer", "liteav_api setConfig ".concat(String.valueOf(this)));
    this.mConfig = paramTXLivePlayConfig;
    if (this.mConfig == null) {
      this.mConfig = new TXLivePlayConfig();
    }
    if (this.mPlayer != null)
    {
      g localg = this.mPlayer.h();
      paramTXLivePlayConfig = localg;
      if (localg == null) {
        paramTXLivePlayConfig = new g();
      }
      paramTXLivePlayConfig.a = this.mConfig.mCacheTime;
      paramTXLivePlayConfig.g = this.mConfig.mAutoAdjustCacheTime;
      paramTXLivePlayConfig.c = this.mConfig.mMinAutoAdjustCacheTime;
      paramTXLivePlayConfig.b = this.mConfig.mMaxAutoAdjustCacheTime;
      paramTXLivePlayConfig.d = this.mConfig.mVideoBlockThreshold;
      paramTXLivePlayConfig.e = this.mConfig.mConnectRetryCount;
      paramTXLivePlayConfig.f = this.mConfig.mConnectRetryInterval;
      paramTXLivePlayConfig.h = this.mConfig.mEnableAec;
      paramTXLivePlayConfig.j = this.mConfig.mEnableNearestIP;
      paramTXLivePlayConfig.l = this.mConfig.mRtmpChannelType;
      paramTXLivePlayConfig.i = this.mEnableHWDec;
      paramTXLivePlayConfig.m = this.mConfig.mCacheFolderPath;
      paramTXLivePlayConfig.n = this.mConfig.mMaxCacheItems;
      paramTXLivePlayConfig.k = this.mConfig.mEnableMessage;
      paramTXLivePlayConfig.o = this.mConfig.mHeaders;
      this.mPlayer.a(paramTXLivePlayConfig);
    }
    paramTXLivePlayConfig = "setConfig:" + this.mConfig.mCacheTime + ":" + this.mConfig.mAutoAdjustCacheTime + ":" + this.mConfig.mMinAutoAdjustCacheTime + ":" + this.mConfig.mMaxAutoAdjustCacheTime;
    if ((this.mPlayUrl != null) && (this.mPlayUrl.length() > 0))
    {
      TXCDRApi.reportEvent40003(this.mPlayUrl, 92007, 0, paramTXLivePlayConfig, "");
      AppMethodBeat.o(65939);
      return;
    }
    this.mCallFuncBeforeStartPlay.add(paramTXLivePlayConfig);
    AppMethodBeat.o(65939);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(65959);
    TXCLog.d("TXLivePlayer", "liteav_api setMute ".concat(String.valueOf(paramBoolean)));
    this.mMute = paramBoolean;
    if ((this.mPlayUrl != null) && (this.mPlayUrl.length() > 0)) {
      TXCDRApi.reportEvent40003(this.mPlayUrl, 92007, 0, "setMute:".concat(String.valueOf(paramBoolean)), "");
    }
    for (;;)
    {
      if (this.mPlayer != null) {
        this.mPlayer.b(paramBoolean);
      }
      AppMethodBeat.o(65959);
      return;
      this.mCallFuncBeforeStartPlay.add("setMute:".concat(String.valueOf(paramBoolean)));
    }
  }
  
  public void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(65952);
    TXCLog.d("TXLivePlayer", "liteav_api setPlayListener ".concat(String.valueOf(this)));
    this.mListener = paramITXLivePlayListener;
    AppMethodBeat.o(65952);
  }
  
  public void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(65940);
    TXCLog.d("TXLivePlayer", "liteav_api setPlayerView old view : " + this.mTXCloudVideoView + ", new view : " + paramTXCloudVideoView + ", " + this);
    this.mTXCloudVideoView = paramTXCloudVideoView;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramTXCloudVideoView);
    }
    AppMethodBeat.o(65940);
  }
  
  public void setRate(float paramFloat)
  {
    AppMethodBeat.i(65961);
    TXCLog.d("TXLivePlayer", "liteav_api setRate ".concat(String.valueOf(paramFloat)));
    this.mRate = paramFloat;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramFloat);
    }
    AppMethodBeat.o(65961);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(65956);
    TXCLog.d("TXLivePlayer", "liteav_api setRenderMode ".concat(String.valueOf(paramInt)));
    this.mRenderMode = paramInt;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramInt);
    }
    AppMethodBeat.o(65956);
  }
  
  public void setRenderRotation(int paramInt)
  {
    AppMethodBeat.i(65957);
    TXCLog.d("TXLivePlayer", "liteav_api setRenderRotation ".concat(String.valueOf(paramInt)));
    this.mRenderRotation = paramInt;
    if (this.mPlayer != null) {
      this.mPlayer.b(paramInt);
    }
    AppMethodBeat.o(65957);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(65941);
    TXCLog.d("TXLivePlayer", "liteav_api setSurface old : " + this.mSurface + ", new : " + paramSurface + ", " + this);
    this.mSurface = paramSurface;
    if (this.mPlayer != null) {
      this.mPlayer.a(this.mSurface);
    }
    AppMethodBeat.o(65941);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65942);
    TXCLog.d("TXLivePlayer", "liteav_api setSurfaceSize " + paramInt1 + "x" + paramInt2 + ", " + this);
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(65942);
  }
  
  public void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener paramITXVideoRawDataListener)
  {
    AppMethodBeat.i(65965);
    TXCLog.d("TXLivePlayer", "liteav_api setVideoRawDataListener ".concat(String.valueOf(paramITXVideoRawDataListener)));
    this.mVideoRawDataListener = paramITXVideoRawDataListener;
    if (this.mPlayer == null)
    {
      AppMethodBeat.o(65965);
      return;
    }
    if (paramITXVideoRawDataListener != null)
    {
      this.mPlayer.a(new TXLivePlayer.2(this));
      AppMethodBeat.o(65965);
      return;
    }
    this.mPlayer.a(null);
    AppMethodBeat.o(65965);
  }
  
  public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(65953);
    TXCLog.d("TXLivePlayer", "liteav_api setVideoRecordListener");
    if (this.mPlayer != null) {
      this.mPlayer.a(paramITXVideoRecordListener);
    }
    AppMethodBeat.o(65953);
  }
  
  public void snapshot(ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(65966);
    TXCLog.d("TXLivePlayer", "liteav_api snapshot ".concat(String.valueOf(paramITXSnapshotListener)));
    if ((this.mSnapshotRunning) || (paramITXSnapshotListener == null))
    {
      AppMethodBeat.o(65966);
      return;
    }
    this.mSnapshotRunning = true;
    if (this.mPlayer != null) {}
    for (Object localObject2 = this.mPlayer.d();; localObject2 = null)
    {
      if (localObject2 != null) {
        try
        {
          Bitmap localBitmap1 = ((TextureView)localObject2).getBitmap();
          Bitmap localBitmap2 = localBitmap1;
          if (localBitmap1 != null)
          {
            localObject2 = ((TextureView)localObject2).getTransform(null);
            localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), (Matrix)localObject2, true);
            localBitmap1.recycle();
          }
          postBitmapToMainThread(paramITXSnapshotListener, localBitmap2);
          AppMethodBeat.o(65966);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Object localObject1 = null;
          }
        }
      }
      this.mSnapshotRunning = false;
      AppMethodBeat.o(65966);
      return;
    }
  }
  
  public int startPlay(String paramString, int paramInt)
  {
    AppMethodBeat.i(65943);
    TXCLog.d("TXLivePlayer", "liteav_api startPlay ".concat(String.valueOf(this)));
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("TXLivePlayer", "start play error when url is empty ".concat(String.valueOf(this)));
      AppMethodBeat.o(65943);
      return -1;
    }
    if ((!TextUtils.isEmpty(this.mPlayUrl)) && (isPlaying()))
    {
      if (this.mPlayUrl.equalsIgnoreCase(paramString))
      {
        TXCLog.e("TXLivePlayer", "start play error when new url is the same with old url  ".concat(String.valueOf(this)));
        AppMethodBeat.o(65943);
        return -1;
      }
      TXCLog.w("TXLivePlayer", " stop old play when new url is not the same with old url  ".concat(String.valueOf(this)));
      if (this.mPlayer != null) {
        this.mPlayer.a(false);
      }
      this.mPlayUrl = "";
    }
    TXCDRApi.initCrashReport(this.mContext);
    TXCLog.d("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.d("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.d("TXLivePlayer", "=====  StartPlay url = " + paramString + " playType = " + paramInt + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "    ======");
    TXCLog.d("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.d("TXLivePlayer", "===========================================================================================================================================================");
    if ((this.mCurrentPlayType == -1) || (this.mCurrentPlayType != paramInt)) {
      this.mPlayer = o.a(this.mContext, paramInt);
    }
    this.mCurrentPlayType = paramInt;
    if (this.mPlayer == null)
    {
      AppMethodBeat.o(65943);
      return -2;
    }
    this.mPlayUrl = checkPlayUrl(paramString, paramInt);
    setConfig(this.mConfig);
    if (this.mTXCloudVideoView != null)
    {
      this.mTXCloudVideoView.clearLog();
      this.mTXCloudVideoView.setVisibility(0);
    }
    this.mPlayer.a(this.mTXCloudVideoView);
    this.mPlayer.a(this);
    this.mPlayer.c(this.mAutoPlay);
    if (this.mSurface != null)
    {
      this.mPlayer.a(this.mSurface);
      this.mPlayer.a(this.mSurfaceWidth, this.mSurfaceHeight);
    }
    this.mPlayer.a(this.mPlayUrl, paramInt);
    this.mPlayer.b(this.mMute);
    this.mPlayer.a(this.mRate);
    this.mPlayer.b(this.mRenderRotation);
    this.mPlayer.a(this.mRenderMode);
    setAudioRoute(this.mAudioRoute);
    this.mPlayer.a(this.mAudioRawDataListener);
    setVideoRawDataListener(this.mVideoRawDataListener);
    if (this.mPlayer.f())
    {
      this.mLivePlayUrl = this.mPlayUrl;
      if (this.mTimeShiftUtil == null) {
        break label576;
      }
    }
    label576:
    for (long l = this.mTimeShiftUtil.a();; l = 0L)
    {
      this.mProgressStartTime = l;
      if (this.mProgressStartTime > 0L) {
        this.mPlayer.g();
      }
      paramString = this.mCallFuncBeforeStartPlay.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        TXCDRApi.reportEvent40003(this.mPlayUrl, 92007, 0, str, "");
      }
    }
    this.mCallFuncBeforeStartPlay.clear();
    TXCDRApi.reportEvent40003(this.mPlayUrl, 92007, 0, "startPlay:".concat(String.valueOf(paramInt)), "");
    AppMethodBeat.o(65943);
    return 0;
  }
  
  public int startRecord(int paramInt)
  {
    AppMethodBeat.i(65954);
    TXCLog.d("TXLivePlayer", "liteav_api startRecord ".concat(String.valueOf(this)));
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXLivePlayer", "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
      AppMethodBeat.o(65954);
      return -3;
    }
    if (!isPlaying())
    {
      TXCLog.e("TXLivePlayer", "startRecord: there is no playing stream");
      AppMethodBeat.o(65954);
      return -1;
    }
    if (this.mPlayer != null)
    {
      paramInt = this.mPlayer.c(paramInt);
      AppMethodBeat.o(65954);
      return paramInt;
    }
    AppMethodBeat.o(65954);
    return -1;
  }
  
  public int stopPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(65945);
    TXCLog.d("TXLivePlayer", "liteav_api stopPlay " + paramBoolean + ", " + this);
    if ((this.mPlayUrl != null) && (this.mPlayUrl.length() > 0)) {
      TXCDRApi.reportEvent40003(this.mPlayUrl, 92007, 0, "stopPlay", "");
    }
    if ((paramBoolean) && (this.mTXCloudVideoView != null)) {
      this.mTXCloudVideoView.setVisibility(8);
    }
    if (this.mPlayer != null)
    {
      this.mPlayer.a(null);
      this.mPlayer.a(paramBoolean);
    }
    this.mPlayUrl = "";
    this.mProgressStartTime = 0L;
    this.mTimeShiftUtil = null;
    this.mIsShiftPlaying = false;
    AppMethodBeat.o(65945);
    return 0;
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(65955);
    TXCLog.d("TXLivePlayer", "liteav_api stopRecord ".concat(String.valueOf(this)));
    if (this.mPlayer != null)
    {
      int i = this.mPlayer.e();
      AppMethodBeat.o(65955);
      return i;
    }
    AppMethodBeat.o(65955);
    return -1;
  }
  
  public int switchStream(String paramString)
  {
    AppMethodBeat.i(65944);
    if (this.mPlayer != null)
    {
      int i = this.mPlayer.a(paramString);
      AppMethodBeat.o(65944);
      return i;
    }
    AppMethodBeat.o(65944);
    return -1;
  }
  
  public static abstract interface ITXSnapshotListener
  {
    public abstract void onSnapshot(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayer
 * JD-Core Version:    0.7.0.1
 */