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
import com.tencent.liteav.j;
import com.tencent.liteav.n;
import com.tencent.liteav.p;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

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
  private int mAudioRoute = 0;
  private boolean mAutoPlay = true;
  private TXLivePlayConfig mConfig;
  private Context mContext;
  private boolean mEnableHWDec = false;
  private boolean mIsNeedClearLastImg = true;
  private boolean mIsShiftPlaying;
  private ITXLivePlayListener mListener;
  private String mLivePlayUrl;
  private boolean mMute = false;
  private String mPlayUrl = "";
  private n mPlayer;
  private long mProgressStartTime;
  private float mRate = 1.0F;
  private int mRenderMode;
  private int mRenderRotation;
  private boolean mSnapshotRunning = false;
  private Surface mSurface;
  private TXCloudVideoView mTXCloudVideoView;
  private j mTimeShiftUtil;
  private TXLivePlayer.ITXVideoRawDataListener mVideoRawDataListener = null;
  
  public TXLivePlayer(Context paramContext)
  {
    TXCLog.init();
    this.mListener = null;
    this.mContext = paramContext.getApplicationContext();
  }
  
  private String checkPlayUrl(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramInt != 6) {}
    label57:
    label82:
    label214:
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
          break label104;
        }
        if (localObject[paramInt] >= 0) {
          break label208;
        }
        i = localObject[paramInt] + 256;
      }
      catch (Exception localException)
      {
        str = paramString;
      }
      localStringBuilder.append(String.format("%%%02X", new Object[] { Integer.valueOf(i) }));
      break label201;
      localStringBuilder.append((char)i);
      break label201;
      String str;
      for (;;)
      {
        return str.trim();
        label104:
        str = localStringBuilder.toString();
      }
      for (;;)
      {
        if ((i <= 32) || (i >= 127) || (i == 34) || (i == 37) || (i == 60) || (i == 62) || (i == 91) || (i == 125) || (i == 92) || (i == 93) || (i == 94) || (i == 96) || (i == 123)) {
          break label214;
        }
        if (i != 124) {
          break label82;
        }
        break label57;
        paramInt += 1;
        break;
        i = str[paramInt];
      }
    }
  }
  
  private boolean isAVCDecBlacklistDevices()
  {
    return (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) && (Build.MODEL.equalsIgnoreCase("Che2-TL00"));
  }
  
  private void postBitmapToMainThread(ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap)
  {
    if (paramITXSnapshotListener == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new TXLivePlayer.3(this, paramITXSnapshotListener, paramBitmap));
  }
  
  public boolean addVideoRawData(byte[] paramArrayOfByte)
  {
    TXCLog.d("TXLivePlayer", "liteav_api addVideoRawData " + paramArrayOfByte);
    if ((this.mPlayUrl == null) || (this.mPlayUrl.isEmpty())) {
      return false;
    }
    if (this.mEnableHWDec)
    {
      TXLog.e("TXLivePlayer", "can not addVideoRawData because of hw decode has set!");
      return false;
    }
    if (this.mPlayer == null)
    {
      TXCLog.e("TXLivePlayer", "player hasn't created or not instanceof live player");
      return false;
    }
    this.mPlayer.a(paramArrayOfByte);
    return true;
  }
  
  public boolean enableHardwareDecode(boolean paramBoolean)
  {
    TXCLog.d("TXLivePlayer", "liteav_api enableHardwareDecode " + paramBoolean);
    if ((!paramBoolean) && (this.mSurface != null)) {
      return false;
    }
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT < 18)
      {
        TXCLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + Build.VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
        return false;
      }
      if (isAVCDecBlacklistDevices())
      {
        TXCLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
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
    return true;
  }
  
  public boolean isPlaying()
  {
    if (this.mPlayer != null) {
      return this.mPlayer.c();
    }
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 15001)
    {
      if (this.mTXCloudVideoView != null) {
        this.mTXCloudVideoView.setLogText(paramBundle, null, 0);
      }
      if (this.mListener != null) {
        this.mListener.onNetStatus(paramBundle);
      }
    }
    do
    {
      do
      {
        long l;
        do
        {
          return;
          if (paramInt != 2005) {
            break;
          }
          l = paramBundle.getInt("EVT_PLAY_PROGRESS_MS") + this.mProgressStartTime;
        } while (l <= 0L);
        paramBundle.putInt("EVT_PLAY_PROGRESS", (int)(l / 1000L));
        paramBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)l);
      } while (this.mListener == null);
      this.mListener.onPlayEvent(paramInt, paramBundle);
      return;
      if (this.mTXCloudVideoView != null) {
        this.mTXCloudVideoView.setLogText(null, paramBundle, paramInt);
      }
    } while (this.mListener == null);
    this.mListener.onPlayEvent(paramInt, paramBundle);
  }
  
  public void pause()
  {
    TXCLog.d("TXLivePlayer", "liteav_api pause " + this);
    if (this.mPlayer != null)
    {
      TXCLog.w("TXLivePlayer", "pause play");
      this.mPlayer.a();
    }
  }
  
  public int prepareLiveSeek()
  {
    TXCLog.d("TXLivePlayer", "liteav_api prepareLiveSeek " + this);
    if (this.mTimeShiftUtil == null) {
      this.mTimeShiftUtil = new j(this.mContext);
    }
    if (this.mTimeShiftUtil != null) {
      return this.mTimeShiftUtil.a(this.mPlayUrl, new TXLivePlayer.1(this));
    }
    return -1;
  }
  
  public void resume()
  {
    TXCLog.d("TXLivePlayer", "liteav_api resume " + this);
    if (this.mPlayer != null)
    {
      TXCLog.w("TXLivePlayer", "resume play");
      this.mPlayer.b();
      setAudioRoute(this.mAudioRoute);
    }
  }
  
  public int resumeLive()
  {
    TXCLog.d("TXLivePlayer", "liteav_api resumeLive " + this);
    if (this.mIsShiftPlaying)
    {
      this.mIsShiftPlaying = false;
      return startPlay(this.mLivePlayUrl, 1);
    }
    return -1;
  }
  
  public void seek(int paramInt)
  {
    TXCLog.d("TXLivePlayer", "liteav_api ");
    String str;
    if (this.mPlayer != null)
    {
      if ((!this.mPlayer.f()) && (!this.mIsShiftPlaying)) {
        break label101;
      }
      if (this.mTimeShiftUtil == null) {
        break label90;
      }
      str = this.mTimeShiftUtil.a(paramInt);
      if (!TextUtils.isEmpty(str)) {
        if (startPlay(str, 3) != 0) {
          break label96;
        }
      }
    }
    label90:
    label96:
    for (boolean bool = true;; bool = false)
    {
      this.mIsShiftPlaying = bool;
      if (this.mIsShiftPlaying) {
        this.mProgressStartTime = (paramInt * 1000);
      }
      return;
      str = "";
      break;
    }
    label101:
    this.mPlayer.e(paramInt);
  }
  
  public void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setAudioRawDataListener " + paramITXAudioRawDataListener);
    this.mAudioRawDataListener = paramITXAudioRawDataListener;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramITXAudioRawDataListener);
    }
  }
  
  public void setAudioRoute(int paramInt)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setAudioRoute " + paramInt);
    this.mAudioRoute = paramInt;
    if (this.mPlayer != null) {
      this.mPlayer.a(this.mContext, this.mAudioRoute);
    }
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setAutoPlay " + paramBoolean);
    this.mAutoPlay = paramBoolean;
  }
  
  public void setConfig(TXLivePlayConfig paramTXLivePlayConfig)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setConfig " + this);
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
  }
  
  public void setMute(boolean paramBoolean)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setMute " + paramBoolean);
    this.mMute = paramBoolean;
    if (this.mPlayer != null) {
      this.mPlayer.b(paramBoolean);
    }
  }
  
  public void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setPlayListener " + this);
    this.mListener = paramITXLivePlayListener;
  }
  
  public void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setPlayerView old view : " + this.mTXCloudVideoView + ", new view : " + paramTXCloudVideoView + ", " + this);
    this.mTXCloudVideoView = paramTXCloudVideoView;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramTXCloudVideoView);
    }
  }
  
  public void setRate(float paramFloat)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setRate " + paramFloat);
    this.mRate = paramFloat;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramFloat);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setRenderMode " + paramInt);
    this.mRenderMode = paramInt;
    if (this.mPlayer != null) {
      this.mPlayer.a(paramInt);
    }
  }
  
  public void setRenderRotation(int paramInt)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setRenderRotation " + paramInt);
    this.mRenderRotation = paramInt;
    if (this.mPlayer != null) {
      this.mPlayer.b(paramInt);
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setSurface old : " + this.mSurface + ", new : " + paramSurface + ", " + this);
    this.mSurface = paramSurface;
    if (this.mSurface != null) {
      enableHardwareDecode(true);
    }
    if (this.mPlayer != null) {
      this.mPlayer.a(this.mSurface);
    }
  }
  
  public void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener paramITXVideoRawDataListener)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setVideoRawDataListener " + paramITXVideoRawDataListener);
    this.mVideoRawDataListener = paramITXVideoRawDataListener;
    if (this.mPlayer == null) {
      return;
    }
    if (paramITXVideoRawDataListener != null)
    {
      this.mPlayer.a(new TXLivePlayer.2(this, paramITXVideoRawDataListener));
      return;
    }
    this.mPlayer.a(null);
  }
  
  public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    TXCLog.d("TXLivePlayer", "liteav_api setVideoRecordListener");
    if (this.mPlayer != null) {
      this.mPlayer.a(paramITXVideoRecordListener);
    }
  }
  
  public void snapshot(ITXSnapshotListener paramITXSnapshotListener)
  {
    TXCLog.d("TXLivePlayer", "liteav_api snapshot " + paramITXSnapshotListener);
    if ((this.mSnapshotRunning) || (paramITXSnapshotListener == null)) {
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
      return;
    }
  }
  
  public int startPlay(String paramString, int paramInt)
  {
    TXCLog.d("TXLivePlayer", "liteav_api startPlay " + this);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("TXLivePlayer", "start play error when url is empty " + this);
      return -1;
    }
    if ((!TextUtils.isEmpty(this.mPlayUrl)) && (isPlaying()))
    {
      if (this.mPlayUrl.equalsIgnoreCase(paramString))
      {
        TXCLog.e("TXLivePlayer", "start play error when new url is the same with old url  " + this);
        return -1;
      }
      TXCLog.w("TXLivePlayer", " stop old play when new url is not the same with old url  " + this);
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
    this.mPlayer = p.a(this.mContext, paramInt);
    if (this.mPlayer == null) {
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
    if (this.mSurface != null) {
      this.mPlayer.a(this.mSurface);
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
        break label500;
      }
    }
    label500:
    for (long l = this.mTimeShiftUtil.a();; l = 0L)
    {
      this.mProgressStartTime = l;
      if (this.mProgressStartTime > 0L) {
        this.mPlayer.g();
      }
      return 0;
    }
  }
  
  public int startRecord(int paramInt)
  {
    int i = -1;
    TXCLog.d("TXLivePlayer", "liteav_api startRecord " + this);
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXLivePlayer", "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
      i = -3;
    }
    do
    {
      return i;
      if (!isPlaying())
      {
        TXCLog.e("TXLivePlayer", "startRecord: there is no playing stream");
        return -1;
      }
    } while (this.mPlayer == null);
    return this.mPlayer.c(paramInt);
  }
  
  public int stopPlay(boolean paramBoolean)
  {
    TXCLog.d("TXLivePlayer", "liteav_api stopPlay " + paramBoolean + ", " + this);
    if ((paramBoolean) && (this.mTXCloudVideoView != null)) {
      this.mTXCloudVideoView.setVisibility(8);
    }
    if (this.mPlayer != null) {
      this.mPlayer.a(paramBoolean);
    }
    this.mPlayUrl = "";
    this.mProgressStartTime = 0L;
    this.mTimeShiftUtil = null;
    this.mIsShiftPlaying = false;
    return 0;
  }
  
  public int stopRecord()
  {
    TXCLog.d("TXLivePlayer", "liteav_api stopRecord " + this);
    if (this.mPlayer != null) {
      return this.mPlayer.e();
    }
    return -1;
  }
  
  public int switchStream(String paramString)
  {
    if (this.mPlayer != null) {
      return this.mPlayer.a(paramString);
    }
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