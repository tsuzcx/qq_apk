package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class StaticDecodeDataComponent
  extends BaseDecodeDataComponent
{
  private static final String TAG = "StaticDecodeDataComponent";
  private int mAllBufferSize;
  private List<BufferInfo> mAllPcmBufferList;
  private boolean mHasTerminal = false;
  private boolean mIsfirstStarted;
  
  StaticDecodeDataComponent(CorePlayer paramCorePlayer, PlayerStateRunner paramPlayerStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt, IAudioListener paramIAudioListener1, IAudioListener paramIAudioListener2)
  {
    super(paramCorePlayer, paramPlayerStateRunner, paramAudioInformation, paramPlayerCallback, paramHandleDecodeDataCallback, paramHandler, paramInt, paramIAudioListener1, paramIAudioListener2);
    this.mBuffSize = 8192;
  }
  
  private boolean createAudioTrack()
  {
    int j = 3;
    AppMethodBeat.i(76744);
    Logger.d("StaticDecodeDataComponent", axiliary("createAudioTrack"));
    if (this.mInformation == null)
    {
      Logger.e("StaticDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
      this.mStateRunner.transfer(Integer.valueOf(9));
      callExceptionCallback(91, 63);
      AppMethodBeat.o(76744);
      return false;
    }
    if (!this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(3) }))
    {
      Logger.e("StaticDecodeDataComponent", axiliary("mState is not preparing"));
      callExceptionCallback(91, 54);
      AppMethodBeat.o(76744);
      return false;
    }
    if (this.mInformation.getSampleRate() <= 0L)
    {
      Logger.e("StaticDecodeDataComponent", axiliary("mInformation.getSampleRate() failed"));
      callExceptionCallback(91, 64);
      AppMethodBeat.o(76744);
      return false;
    }
    int i = 12;
    int k = this.mInformation.getChannels();
    if (k == 1) {
      i = 4;
    }
    int m;
    for (;;)
    {
      this.mTargetPlaySample = this.mInformation.getSampleRate();
      m = this.mInformation.getBitDepth();
      while (this.mTargetPlaySample > getMaxSupportSampleRate()) {
        this.mTargetPlaySample /= 2L;
      }
      if (k == 2) {
        i = 12;
      } else if (k == 6) {
        i = 252;
      } else if (k == 8) {
        i = 1020;
      }
    }
    if ((isSupportHighBitDepth()) && (m >= 3))
    {
      this.mTargetBitDepth = m;
      this.isUseFloatForHighDepth = true;
      if (this.mTargetPlaySample != this.mInformation.getSampleRate())
      {
        Logger.i("StaticDecodeDataComponent", axiliary("will use float resampled pcm for Hi-Res, bitDept: " + m + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
        if (m != 1) {
          break label790;
        }
      }
    }
    for (;;)
    {
      Logger.d("StaticDecodeDataComponent", axiliary(String.format("mTargetPlaySample: %d, playChannel: %d", new Object[] { Long.valueOf(this.mTargetPlaySample), Integer.valueOf(k) })));
      try
      {
        setAudioTrack(instantiateAudioTrackCompat(this.mAudioStreamType, (int)this.mTargetPlaySample, i, j, this.mAllBufferSize, 0));
        if ((this.mSpeedToSet != null) && (Build.VERSION.SDK_INT >= 23))
        {
          Logger.i("StaticDecodeDataComponent", axiliary("setSpeed:" + this.mSpeedToSet));
          PlaybackParams localPlaybackParams = this.mAudioTrack.getPlaybackParams();
          localPlaybackParams.setSpeed(this.mSpeedToSet.floatValue());
          this.mSpeedToSet = null;
          this.mAudioTrack.setPlaybackParams(localPlaybackParams);
        }
        if (this.mAudioTrack.getState() == 2) {
          Logger.d("StaticDecodeDataComponent", axiliary("new AudioTrack succeed"));
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label790:
          Logger.e("StaticDecodeDataComponent", localThrowable);
        }
        this.mCreateAudioTrackFail = true;
        Logger.e("StaticDecodeDataComponent", axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
        setAudioTrack(null);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(91, 66);
        AppMethodBeat.o(76744);
        return false;
      }
      if ((this.mAudioTrack != null) && (this.mAudioTrack.getState() == 2))
      {
        Logger.d("StaticDecodeDataComponent", axiliary("create audioTrack success"));
        AppMethodBeat.o(76744);
        return true;
        Logger.i("StaticDecodeDataComponent", axiliary("will use float pcm for Hi-Res, bitDept: " + m + ", sample rate: " + this.mTargetPlaySample));
        break;
        if ((!isSupportHighBitDepth()) && (m >= 3))
        {
          this.mTargetBitDepth = 2;
          if (this.mTargetPlaySample != this.mInformation.getSampleRate())
          {
            Logger.i("StaticDecodeDataComponent", axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + m + ", target bitDept: " + this.mTargetBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
            break;
          }
          Logger.i("StaticDecodeDataComponent", axiliary("will use byte pcm with bitDept converted, origin bitDept: " + m + ", target bitDept: " + this.mTargetBitDepth));
          break;
        }
        this.mTargetBitDepth = m;
        Logger.i("StaticDecodeDataComponent", axiliary("will use byte pcm resampled, bitDept: " + m + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
        break;
        if (m == 2)
        {
          j = 2;
          continue;
        }
        if (!this.isUseFloatForHighDepth) {
          break label874;
        }
        j = 4;
        continue;
      }
      label874:
      j = 2;
    }
  }
  
  private boolean decodeAllData()
  {
    AppMethodBeat.i(76743);
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
        AppMethodBeat.o(76743);
        return false;
        if (i == 0)
        {
          localSoNotFindException.bufferSize = this.mBuffSize;
          this.mAllPcmBufferList.add(localSoNotFindException);
          Logger.i("StaticDecodeDataComponent", "static decode end");
          if (this.mAllPcmBufferList.isEmpty()) {
            break label397;
          }
          Iterator localIterator1 = this.mAllPcmBufferList.iterator();
          for (i = 0; localIterator1.hasNext(); i = ((BufferInfo)localIterator1.next()).bufferSize + i) {}
        }
        this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(i, 91);
        AppMethodBeat.o(76743);
        return false;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("StaticDecodeDataComponent", localThrowable);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(91, 67);
        AppMethodBeat.o(76743);
        return false;
      }
    }
    Logger.i("StaticDecodeDataComponent", "static totalBufferSize = ".concat(String.valueOf(i)));
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
    label397:
    AppMethodBeat.o(76743);
    return true;
  }
  
  private void playAudioTrack()
  {
    AppMethodBeat.i(76746);
    this.mAudioTrack.reloadStaticData();
    while (!this.mCorePlayer.mIsExit) {
      if (isPaused())
      {
        if (this.mAudioTrack.getPlayState() != 2) {
          this.mAudioTrack.pause();
        }
        postRunnable(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(76712);
            StaticDecodeDataComponent.this.mCallback.playerPaused(StaticDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.o(76712);
          }
        }, 20);
        doWaitForPaused();
      }
      else
      {
        if (isIdle()) {
          break;
        }
        if (isError())
        {
          Logger.e("StaticDecodeDataComponent", "static play error");
          AppMethodBeat.o(76746);
          return;
        }
        if (isStopped())
        {
          if (this.mAudioTrack.getPlayState() != 1) {
            this.mAudioTrack.stop();
          }
          postRunnable(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(76724);
              StaticDecodeDataComponent.this.mCallback.playerStopped(StaticDecodeDataComponent.this.mCorePlayer);
              AppMethodBeat.o(76724);
            }
          }, 20);
          AppMethodBeat.o(76746);
          return;
        }
        if (isCompleted())
        {
          this.mCorePlayer.mIsExit = true;
          AppMethodBeat.o(76746);
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
          else if (AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack) * this.mInformation.getChannels() * this.mTargetBitDepth >= this.mAllBufferSize)
          {
            this.mStateRunner.transfer(Integer.valueOf(7));
            Logger.i("StaticDecodeDataComponent", "static play completed");
            postRunnable(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(245399);
                StaticDecodeDataComponent.this.mCallback.playerEnded(StaticDecodeDataComponent.this.mCorePlayer);
                AppMethodBeat.o(245399);
              }
            }, 20);
          }
        }
      }
    }
    AppMethodBeat.o(76746);
  }
  
  private boolean writeAudioTrack()
  {
    AppMethodBeat.i(76745);
    BufferInfo localBufferInfo = new BufferInfo();
    if ((this.mDecodeBufferInfo.byteBuffer != null) && (this.mAudioTrack != null))
    {
      if (this.mTargetBitDepth != this.mInformation.getBitDepth())
      {
        handleHighBitDepth(this.mDecodeBufferInfo, localBufferInfo);
        this.mDecodeBufferInfo.fillInto(localBufferInfo);
      }
      if (this.mTargetPlaySample != this.mInformation.getSampleRate())
      {
        handleHighSample(this.mDecodeBufferInfo, localBufferInfo);
        this.mDecodeBufferInfo.fillInto(localBufferInfo);
      }
      if (this.isUseFloatForHighDepth)
      {
        convertBytePcmToFloatPcm(this.mDecodeBufferInfo, this.mFloatBufferInfo);
        this.mAudioEffectListener.onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
        this.mHasTerminal = false;
        if (this.mTerminalAudioEffectListener.isEnabled())
        {
          if (!this.isUseFloatForHighDepth) {
            break label349;
          }
          this.mTerminalAudioEffectListener.onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
        }
      }
      int i;
      for (;;)
      {
        this.mHasTerminal = true;
        if (this.mHasTerminal) {
          break label592;
        }
        if ((!this.isUseFloatForHighDepth) || (Build.VERSION.SDK_INT < 21)) {
          break label438;
        }
        i = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
        if (i >= 0) {
          break label377;
        }
        Logger.e("StaticDecodeDataComponent", axiliary("mAudioTrack write float failed: " + i + ", expect: " + this.mFloatBufferInfo.bufferSize));
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(91, 102);
        AppMethodBeat.o(76745);
        return false;
        this.mAudioEffectListener.onPcm(this.mDecodeBufferInfo, localBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
        this.mDecodeBufferInfo.fillInto(localBufferInfo);
        break;
        label349:
        this.mTerminalAudioEffectListener.onPcm(this.mDecodeBufferInfo, this.mDecodeBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
      }
      label377:
      if (i != this.mFloatBufferInfo.bufferSize) {
        Logger.w("StaticDecodeDataComponent", axiliary("mAudioTrack write float not equal: " + i + ", expect: " + this.mFloatBufferInfo.bufferSize));
      }
      for (;;)
      {
        AppMethodBeat.o(76745);
        return true;
        label438:
        i = this.mAudioTrack.write(this.mDecodeBufferInfo.byteBuffer, 0, this.mDecodeBufferInfo.bufferSize);
        if (i < 0)
        {
          Logger.e("StaticDecodeDataComponent", axiliary("mAudioTrack write bytes failed: " + i + ", expect: " + this.mDecodeBufferInfo.bufferSize));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 102);
          AppMethodBeat.o(76745);
          return false;
        }
        if (i != this.mDecodeBufferInfo.bufferSize) {
          Logger.w("StaticDecodeDataComponent", axiliary("mAudioTrack write bytes not equal: " + i + ", expect: " + this.mDecodeBufferInfo.bufferSize));
        }
      }
      label592:
      Logger.i("StaticDecodeDataComponent", "mTerminalAudioEffectList has blocked");
      AppMethodBeat.o(76745);
      return false;
    }
    AppMethodBeat.o(76745);
    return false;
  }
  
  int getAudioStreamType()
  {
    return 3;
  }
  
  long getCurPosition()
  {
    AppMethodBeat.i(76741);
    AudioTrack localAudioTrack = this.mAudioTrack;
    if ((localAudioTrack == null) || (localAudioTrack.getState() == 0))
    {
      l = this.mCurPosition;
      AppMethodBeat.o(76741);
      return l;
    }
    this.mCurPosition = getAudioTrackPosition(0L, localAudioTrack);
    long l = this.mCurPosition;
    AppMethodBeat.o(76741);
    return l;
  }
  
  void handleDecodeData()
  {
    AppMethodBeat.i(76742);
    if (this.mInformation != null)
    {
      try
      {
        if (0L >= this.mInformation.getSampleRate())
        {
          Logger.e("StaticDecodeDataComponent", "failed to getSampleRate");
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 63);
          AppMethodBeat.o(76742);
          return;
        }
        if (this.mInformation.getChannels() <= 0)
        {
          Logger.e("StaticDecodeDataComponent", "failed to getChannels");
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 63);
          AppMethodBeat.o(76742);
          return;
        }
        this.mHasInit = true;
        if (!decodeAllData())
        {
          Logger.e("StaticDecodeDataComponent", "failed to decodeAllData");
          this.mStateRunner.transfer(Integer.valueOf(9));
          AppMethodBeat.o(76742);
          return;
        }
        if (!createAudioTrack())
        {
          Logger.e("StaticDecodeDataComponent", "failed to createAudioTrack");
          this.mStateRunner.transfer(Integer.valueOf(9));
          AppMethodBeat.o(76742);
          return;
        }
        initAudioListeners(this.mTargetBitDepth, this.mInformation, getCurPosition());
        if ((!writeAudioTrack()) && (!this.mHasTerminal))
        {
          Logger.e("StaticDecodeDataComponent", "failed to writeAudioTrack");
          this.mStateRunner.transfer(Integer.valueOf(9));
          AppMethodBeat.o(76742);
          return;
        }
        if (this.mHasTerminal)
        {
          this.mStateRunner.transfer(Integer.valueOf(7));
          AppMethodBeat.o(76742);
          return;
        }
        if (!this.mStateRunner.transfer(Integer.valueOf(2), new Integer[] { Integer.valueOf(3) }))
        {
          Logger.e("StaticDecodeDataComponent", "failed to transfer to PREPARED because cur State is NOT PREPARING!!");
          AppMethodBeat.o(76742);
          return;
        }
        this.mIsfirstStarted = false;
        postRunnable(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(76481);
            if (StaticDecodeDataComponent.this.getPlayerState() == 8)
            {
              Logger.w("StaticDecodeDataComponent", "[run] state changed to END during postRunnable!");
              AppMethodBeat.o(76481);
              return;
            }
            StaticDecodeDataComponent.this.mCallback.playerPrepared(StaticDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.o(76481);
          }
        }, 0);
      }
      catch (SoNotFindException localSoNotFindException)
      {
        for (;;)
        {
          Logger.e("StaticDecodeDataComponent", localSoNotFindException);
        }
      }
      Logger.i("StaticDecodeDataComponent", axiliary("prepared. waiting..."));
      this.mSignalControl.doWait(20L, 100, new WaitNotify.WaitListener()
      {
        public boolean keepWaiting()
        {
          AppMethodBeat.i(245346);
          if (StaticDecodeDataComponent.this.getPlayerState() == 2)
          {
            AppMethodBeat.o(245346);
            return true;
          }
          AppMethodBeat.o(245346);
          return false;
        }
      });
      Logger.i("StaticDecodeDataComponent", axiliary("woke after preparing"));
      playAudioTrack();
      AppMethodBeat.o(76742);
      return;
    }
    Logger.e("StaticDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
    this.mStateRunner.transfer(Integer.valueOf(9));
    callExceptionCallback(91, 63);
    AppMethodBeat.o(76742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */