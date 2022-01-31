package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaticDecodeDataComponent
  extends BaseDecodeDataComponent
{
  private static final String TAG = "StaticDecodeDataComponent";
  private int mAllBufferSize;
  private List<BufferInfo> mAllPcmBufferList;
  private int mBitDept = 2;
  private boolean mHasTerminal = false;
  private boolean mIsfirstStarted;
  
  StaticDecodeDataComponent(CorePlayer paramCorePlayer, StateRunner<Integer> paramStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt)
  {
    super(paramCorePlayer, paramStateRunner, paramAudioInformation, paramPlayerCallback, paramHandleDecodeDataCallback, paramHandler, paramInt);
    this.mBuffSize = 8192;
  }
  
  private boolean createAudioTrack()
  {
    int j = 3;
    Logger.d("StaticDecodeDataComponent", axiliary("createAudioTrack"));
    if (this.mInformation == null)
    {
      Logger.e("StaticDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
      this.mStateRunner.transfer(Integer.valueOf(9));
      callExceptionCallback(91, 63);
      return false;
    }
    if (!this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(3) }))
    {
      Logger.e("StaticDecodeDataComponent", axiliary("mState is not preparing"));
      callExceptionCallback(91, 54);
      return false;
    }
    if (this.mInformation.getSampleRate() <= 0L)
    {
      Logger.e("StaticDecodeDataComponent", axiliary("mInformation.getSampleRate() failed"));
      callExceptionCallback(91, 64);
      return false;
    }
    int i = 12;
    int k = this.mInformation.getChannels();
    if (k == 1) {
      i = 4;
    }
    for (;;)
    {
      this.mPlaySample = this.mInformation.getSampleRate();
      this.mBitDept = this.mInformation.getBitDept();
      while (this.mPlaySample > MAX_PLAY_SAMPLE_RATE) {
        this.mPlaySample /= 2L;
      }
      if (k == 2) {
        i = 12;
      } else if (k == 6) {
        i = 252;
      } else if (k == 8) {
        i = 1020;
      }
    }
    if ((CAN_USE_FLOAT_IN_HI_RES) && (this.mBitDept >= 3))
    {
      this.mPlayBitDepth = this.mBitDept;
      this.isUseFloatInHiRes = true;
      if (this.mPlaySample != this.mInformation.getSampleRate())
      {
        Logger.i("StaticDecodeDataComponent", axiliary("will use float resampled pcm for Hi-Res, bitDept: " + this.mBitDept + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
        if (this.mBitDept != 1) {
          break label768;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        Logger.d("StaticDecodeDataComponent", axiliary(String.format("mPlaySample: %d, playChannel: %d", new Object[] { Long.valueOf(this.mPlaySample), Integer.valueOf(k) })));
        try
        {
          this.mAudioTrack = new AudioTrack(3, (int)this.mPlaySample, i, j, this.mAllBufferSize, 0);
          if (this.mAudioTrack.getState() == 2) {
            Logger.d("StaticDecodeDataComponent", axiliary("new AudioTrack succeed"));
          }
          if ((this.mAudioTrack != null) && (this.mAudioTrack.getState() == 2))
          {
            Logger.d("StaticDecodeDataComponent", axiliary("create audioTrack success"));
            return true;
            Logger.i("StaticDecodeDataComponent", axiliary("will use float pcm for Hi-Res, bitDept: " + this.mBitDept + ", sample rate: " + this.mPlaySample));
            break;
            if ((!CAN_USE_FLOAT_IN_HI_RES) && (this.mBitDept >= 3))
            {
              this.mPlayBitDepth = 2;
              if (this.mPlaySample != this.mInformation.getSampleRate())
              {
                Logger.i("StaticDecodeDataComponent", axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + this.mBitDept + ", target bitDept: " + this.mPlayBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
                break;
              }
              Logger.i("StaticDecodeDataComponent", axiliary("will use byte pcm with bitDept converted, origin bitDept: " + this.mBitDept + ", target bitDept: " + this.mPlayBitDepth));
              break;
            }
            if (this.mPlaySample != this.mInformation.getSampleRate())
            {
              this.mPlayBitDepth = this.mBitDept;
              Logger.i("StaticDecodeDataComponent", axiliary("will use byte pcm resampled, bitDept: " + this.mBitDept + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
              break;
            }
            this.mPlayBitDepth = 2;
            Logger.i("StaticDecodeDataComponent", axiliary("will use normal byte pcm, bitDept: " + this.mBitDept + ", sample rate: " + this.mPlaySample));
            break;
            label768:
            if (this.mBitDept == 2)
            {
              j = 2;
              continue;
            }
            if (!this.isUseFloatInHiRes) {
              break label849;
            }
            j = 4;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Logger.e("StaticDecodeDataComponent", localThrowable);
          }
          this.mCreateAudioTrackFail = true;
          Logger.e("StaticDecodeDataComponent", axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
          this.mAudioTrack = null;
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 66);
          return false;
        }
      }
      label849:
      j = 2;
    }
  }
  
  private boolean decodeAllData()
  {
    this.mAllPcmBufferList = new ArrayList();
    for (;;)
    {
      BufferInfo localBufferInfo1;
      if (!this.mCorePlayer.mIsExit)
      {
        localBufferInfo1 = new BufferInfo();
        localBufferInfo1.setByteBufferCapacity(this.mBuffSize);
      }
      try
      {
        i = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, localBufferInfo1.byteBuffer);
        this.mHasDecode = true;
        if (i > 0)
        {
          localBufferInfo1.bufferSize = i;
          this.mAllPcmBufferList.add(localBufferInfo1);
          if (this.mHasDecodeSuccess) {
            continue;
          }
          this.mHasDecodeSuccess = true;
        }
      }
      catch (SoNotFindException localSoNotFindException)
      {
        Logger.e("StaticDecodeDataComponent", localSoNotFindException);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(91, 62);
        return false;
        if (i == 0)
        {
          localSoNotFindException.bufferSize = this.mBuffSize;
          this.mAllPcmBufferList.add(localSoNotFindException);
          Logger.i("StaticDecodeDataComponent", "static decode end");
          if (this.mAllPcmBufferList.isEmpty()) {
            break label383;
          }
          Iterator localIterator1 = this.mAllPcmBufferList.iterator();
          for (i = 0; localIterator1.hasNext(); i = ((BufferInfo)localIterator1.next()).bufferSize + i) {}
        }
        this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(i, 91);
        return false;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("StaticDecodeDataComponent", localThrowable);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(91, 67);
        return false;
      }
    }
    Logger.i("StaticDecodeDataComponent", "static totalBufferSize = " + i);
    this.mDecodeBufferInfo.setByteBufferCapacity(i);
    Iterator localIterator2 = this.mAllPcmBufferList.iterator();
    int i = 0;
    while (localIterator2.hasNext())
    {
      BufferInfo localBufferInfo2 = (BufferInfo)localIterator2.next();
      System.arraycopy(localBufferInfo2.byteBuffer, 0, this.mDecodeBufferInfo.byteBuffer, i, localBufferInfo2.bufferSize);
      i += localBufferInfo2.bufferSize;
      BufferInfo localBufferInfo3 = this.mDecodeBufferInfo;
      localBufferInfo3.bufferSize += localBufferInfo2.bufferSize;
      int j = this.mAllBufferSize;
      this.mAllBufferSize = (localBufferInfo2.bufferSize + j);
    }
    label383:
    return true;
  }
  
  private boolean writeAudioTrack()
  {
    if ((this.mDecodeBufferInfo.byteBuffer != null) && (this.mAudioTrack != null))
    {
      handleHighBitDept(this.mDecodeBufferInfo, this.mNewBitDepthBufferInfo);
      handleHighSample(this.mNewBitDepthBufferInfo, this.mReSampleBufferInfo);
      int i;
      if (this.isUseFloatInHiRes)
      {
        convertBytePcmToFloatPcm(this.mReSampleBufferInfo, this.mFloatBufferInfo);
        processAudioListeners(this.mFloatBufferInfo, this.mFloatBufferInfo);
        this.mHasTerminal = false;
        i = this.mTerminalAudioEffectList.size() - 1;
      }
      for (;;)
      {
        IAudioListener localIAudioListener;
        if (i >= 0)
        {
          localIAudioListener = (IAudioListener)this.mTerminalAudioEffectList.get(i);
          if (!localIAudioListener.isEnabled()) {
            break label283;
          }
          if (!this.isUseFloatInHiRes) {
            break label265;
          }
          localIAudioListener.onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo);
        }
        for (;;)
        {
          this.mHasTerminal = true;
          if (this.mHasTerminal) {
            break label493;
          }
          if (!this.isUseFloatInHiRes) {
            break label345;
          }
          i = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
          if (i >= 0) {
            break label290;
          }
          Logger.e("StaticDecodeDataComponent", axiliary("mAudioTrack write float failed: " + i + ", expect: " + this.mFloatBufferInfo.bufferSize));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 102);
          return false;
          processAudioListeners(this.mReSampleBufferInfo, this.mDTSBufferInfo);
          break;
          label265:
          localIAudioListener.onPcm(this.mDTSBufferInfo, this.mDTSBufferInfo);
        }
        label283:
        i -= 1;
      }
      label290:
      if (i != this.mFloatBufferInfo.bufferSize) {
        Logger.w("StaticDecodeDataComponent", axiliary("mAudioTrack write float not equal: " + i + ", expect: " + this.mFloatBufferInfo.bufferSize));
      }
      for (;;)
      {
        return true;
        label345:
        i = this.mAudioTrack.write(this.mDTSBufferInfo.byteBuffer, 0, this.mDTSBufferInfo.bufferSize);
        if (i < 0)
        {
          Logger.e("StaticDecodeDataComponent", axiliary("mAudioTrack write bytes failed: " + i + ", expect: " + this.mDTSBufferInfo.bufferSize));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 102);
          return false;
        }
        if (i != this.mDTSBufferInfo.bufferSize) {
          Logger.w("StaticDecodeDataComponent", axiliary("mAudioTrack write bytes not equal: " + i + ", expect: " + this.mDTSBufferInfo.bufferSize));
        }
      }
      label493:
      Logger.i("StaticDecodeDataComponent", "mTerminalAudioEffectList has blocked");
      return false;
    }
    return false;
  }
  
  int getAudioStreamType()
  {
    return 0;
  }
  
  long getCurPosition()
  {
    AudioTrack localAudioTrack = this.mAudioTrack;
    if ((localAudioTrack == null) || (localAudioTrack.getState() == 0)) {
      return this.mCurPosition;
    }
    this.mCurPosition = getAudioTrackPosition(0L, localAudioTrack);
    return this.mCurPosition;
  }
  
  void handleDecodeData()
  {
    if (this.mInformation != null)
    {
      try
      {
        if (0L == this.mInformation.getSampleRate())
        {
          Logger.e("StaticDecodeDataComponent", "failed to getSampleRate");
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 63);
          return;
        }
        this.mHasInit = true;
        if (!decodeAllData())
        {
          Logger.e("StaticDecodeDataComponent", "failed to decodeAllData");
          this.mStateRunner.transfer(Integer.valueOf(9));
          return;
        }
      }
      catch (SoNotFindException localSoNotFindException)
      {
        Logger.e("StaticDecodeDataComponent", localSoNotFindException);
      }
      for (;;)
      {
        Logger.i("StaticDecodeDataComponent", axiliary("prepared. waiting..."));
        this.mSignalControl.doWait();
        Logger.i("StaticDecodeDataComponent", axiliary("woke after preparing"));
        playAudioTrack();
        return;
        if (!createAudioTrack())
        {
          Logger.e("StaticDecodeDataComponent", "failed to createAudioTrack");
          this.mStateRunner.transfer(Integer.valueOf(9));
          return;
        }
        if ((!writeAudioTrack()) && (!this.mHasTerminal))
        {
          Logger.e("StaticDecodeDataComponent", "failed to writeAudioTrack");
          this.mStateRunner.transfer(Integer.valueOf(9));
          return;
        }
        if (this.mHasTerminal)
        {
          this.mStateRunner.transfer(Integer.valueOf(7));
          return;
        }
        this.mStateRunner.transfer(Integer.valueOf(2));
        this.mIsfirstStarted = false;
        initAudioListeners(this.mInformation.getPlaySample(), getBytesPerSampleInPlay(this.mInformation.getBitDept()), this.mInformation.getChannels());
        postRunnable(new StaticDecodeDataComponent.1(this), 20);
      }
    }
    Logger.e("StaticDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
    this.mStateRunner.transfer(Integer.valueOf(9));
    callExceptionCallback(91, 63);
  }
  
  public void playAudioTrack()
  {
    this.mAudioTrack.reloadStaticData();
    for (;;)
    {
      if (!this.mCorePlayer.mIsExit)
      {
        if (isPaused())
        {
          if (this.mAudioTrack.getPlayState() != 2) {
            this.mAudioTrack.pause();
          }
          postRunnable(new StaticDecodeDataComponent.2(this), 20);
          continue;
        }
        if (!isIdle())
        {
          if (!isError()) {
            break label83;
          }
          Logger.e("StaticDecodeDataComponent", "static play error");
        }
      }
      return;
      label83:
      if (isStopped())
      {
        if (this.mAudioTrack.getPlayState() != 1) {
          this.mAudioTrack.stop();
        }
        postRunnable(new StaticDecodeDataComponent.3(this), 20);
        return;
      }
      if (isCompleted())
      {
        this.mCorePlayer.mIsExit = true;
        return;
      }
      if (isPlaying()) {
        if (this.mAudioTrack.getPlayState() == 2)
        {
          this.mAudioTrack.play();
        }
        else if (this.mAudioTrack.getPlayState() == 1)
        {
          if (!this.mIsfirstStarted)
          {
            this.mIsfirstStarted = true;
            this.mAudioTrack.play();
            this.mCallback.playerStarted(this.mCorePlayer);
          }
        }
        else if (AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack) * this.mInformation.getChannels() * getBytesPerSampleInPlay(this.mInformation.getBitDept()) >= this.mAllBufferSize)
        {
          this.mStateRunner.transfer(Integer.valueOf(7));
          Logger.i("StaticDecodeDataComponent", "static play completed");
          postRunnable(new StaticDecodeDataComponent.4(this), 20);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */