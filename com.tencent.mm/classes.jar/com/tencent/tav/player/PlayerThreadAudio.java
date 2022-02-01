package com.tencent.tav.player;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;

public class PlayerThreadAudio
  implements Handler.Callback
{
  private static final String TAG = "PlayerThreadAudio";
  private AudioCompositionDecoderTrack audioDecoderTrack;
  public volatile CMSampleState currentPlayingState;
  public volatile long lastSyncMessgeId;
  private AudioTrackWrapper mAudioTrack;
  private boolean mLooper;
  private Handler mMainHandler;
  private Handler mPlayHandler;
  private int mStatus;
  private HandlerThread mThread;
  private Handler mVideoHandler;
  private float rate;
  private float volume;
  
  public PlayerThreadAudio(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack, Handler paramHandler1, Handler paramHandler2)
  {
    AppMethodBeat.i(215967);
    this.currentPlayingState = new CMSampleState();
    this.lastSyncMessgeId = -1L;
    this.mStatus = 1;
    this.rate = 1.0F;
    this.volume = 1.0F;
    this.audioDecoderTrack = paramAudioCompositionDecoderTrack;
    this.mMainHandler = paramHandler1;
    this.mVideoHandler = paramHandler2;
    initThread();
    AppMethodBeat.o(215967);
  }
  
  private void actionPrepare()
  {
    AppMethodBeat.i(216007);
    if (this.audioDecoderTrack != null)
    {
      updateStatus(2);
      releaseAudioTrack();
    }
    AppMethodBeat.o(216007);
  }
  
  private String catLog(int paramInt)
  {
    AppMethodBeat.i(216157);
    String str = (String)PlayerThread.map.d(paramInt, null);
    AppMethodBeat.o(216157);
    return str;
  }
  
  private void initThread()
  {
    AppMethodBeat.i(215972);
    this.mThread = new HandlerThread("PlayerAudioThread");
    this.mThread.start();
    this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
    AppMethodBeat.o(215972);
  }
  
  private void pause()
  {
    AppMethodBeat.i(216042);
    if (this.mStatus == 2)
    {
      this.mLooper = false;
      this.currentPlayingState = new CMSampleState();
      removePendingMessage(new int[] { 12 });
    }
    AppMethodBeat.o(216042);
  }
  
  private void play(Object paramObject)
  {
    AppMethodBeat.i(216059);
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(216059);
      return;
    }
    this.mLooper = true;
    if (((paramObject instanceof CMTime)) && (Math.abs(((CMTime)paramObject).getTimeUs() - this.currentPlayingState.getTime().getTimeUs()) > 100000L)) {
      seekTo(paramObject);
    }
    if (this.mStatus == 3) {
      updateStatus(2);
    }
    sendMessage(12, "play", System.currentTimeMillis());
    AppMethodBeat.o(216059);
  }
  
  private void playerFinish()
  {
    AppMethodBeat.i(216073);
    this.currentPlayingState = new CMSampleState();
    this.audioDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
    this.mLooper = false;
    updateStatus(3);
    removePendingMessage(new int[] { 12 });
    AppMethodBeat.o(216073);
  }
  
  private void readSample()
  {
    Object localObject4 = null;
    AppMethodBeat.i(216111);
    if ((this.audioDecoderTrack == null) || (!this.mLooper))
    {
      AppMethodBeat.o(216111);
      return;
    }
    this.audioDecoderTrack.setRate(this.rate);
    Object localObject3 = CMSampleState.fromError(-2L);
    v("PlayerThreadAudio", "readSample start");
    for (;;)
    {
      try
      {
        localObject1 = this.audioDecoderTrack.readSample();
        Logger.e("PlayerThreadAudio", "java.lang.IllegalStateException: buffer was freed", localException2);
      }
      catch (Exception localException2)
      {
        try
        {
          localObject2 = ((CMSampleBuffer)localObject1).getState();
          localObject3 = localObject2;
          v("PlayerThreadAudio", "readSample finish ".concat(String.valueOf(localObject2)));
          localObject3 = localObject1;
          v("PlayerThreadAudio", "processFrame() called sampleState--> ".concat(String.valueOf(localObject2)));
          if (this.mAudioTrack == null)
          {
            v("PlayerThreadAudio", "processFrame() called new mediaFormat");
            this.mAudioTrack = new AudioTrackWrapper(44100, 1);
            this.mAudioTrack.setVolume(this.volume);
          }
          if ((!((CMSampleState)localObject2).stateMatchingTo(new long[] { -1L, -3L, -100L })) && (!((CMSampleState)localObject2).getTime().bigThan(this.audioDecoderTrack.getDuration()))) {
            break;
          }
          v("PlayerThreadAudio", "processFrame() called end of stream");
          playerFinish();
          this.currentPlayingState = ((CMSampleState)localObject2);
          AppMethodBeat.o(216111);
          return;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            ByteBuffer localByteBuffer;
            byte[] arrayOfByte;
            Object localObject2 = localObject1;
            Object localObject1 = localException1;
            continue;
            localObject1 = null;
          }
        }
        localException2 = localException2;
        localObject2 = null;
        localObject1 = localObject3;
      }
      localObject3 = localObject2;
      localObject2 = localObject1;
    }
    if ((((CMSampleState)localObject2).getStateCode() >= 0L) && (localObject3 != null)) {
      localObject1 = localObject4;
    }
    try
    {
      localByteBuffer = ((CMSampleBuffer)localObject3).getSampleByteBuffer();
      if (localByteBuffer == null) {
        break label492;
      }
      localObject1 = localObject4;
      localByteBuffer.position(0);
      localObject1 = localObject4;
      arrayOfByte = new byte[localByteBuffer.limit()];
      localObject1 = arrayOfByte;
      Logger.v("PlayerThreadAudio", "read sample thread: " + Thread.currentThread().getId() + " " + ((CMSampleBuffer)localObject3).getTime());
      localObject1 = arrayOfByte;
      localByteBuffer.get(arrayOfByte);
      localObject1 = arrayOfByte;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Logger.e("PlayerThreadAudio", "readSample: ", localException1);
        continue;
        v("PlayerThreadAudio", "processFrame() called run audioData length exception");
      }
      v("PlayerThreadAudio", "processFrame() not run looper");
      AppMethodBeat.o(216111);
      return;
    }
    if (localObject1 != null)
    {
      v("PlayerThreadAudio", "processFrame() called run audioData length audioData--" + localObject1.length);
      this.audioDecoderTrack.asyncReadNextSample(CMTime.CMTimeInvalid);
      this.mAudioTrack.writeData((byte[])localObject1, 0, localObject1.length);
      this.currentPlayingState = ((CMSampleState)localObject2);
      if ((!this.mLooper) || (this.rate <= 0.0F)) {
        break label468;
      }
      v("PlayerThreadAudio", "processFrame() called run looper " + this.currentPlayingState);
      scheduleNextWork();
      AppMethodBeat.o(216111);
    }
  }
  
  /* Error */
  private void release()
  {
    // Byte code:
    //   0: ldc_w 336
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 79	com/tencent/tav/player/PlayerThreadAudio:releaseAudioTrack	()V
    //   10: aload_0
    //   11: iconst_0
    //   12: newarray int
    //   14: invokespecial 128	com/tencent/tav/player/PlayerThreadAudio:removePendingMessage	([I)V
    //   17: aload_0
    //   18: iconst_1
    //   19: invokespecial 76	com/tencent/tav/player/PlayerThreadAudio:updateStatus	(I)V
    //   22: ldc 10
    //   24: ldc_w 338
    //   27: aload_0
    //   28: invokestatic 208	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokevirtual 212	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokestatic 340	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 106	com/tencent/tav/player/PlayerThreadAudio:mThread	Landroid/os/HandlerThread;
    //   41: invokevirtual 344	android/os/HandlerThread:quit	()Z
    //   44: pop
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 106	com/tencent/tav/player/PlayerThreadAudio:mThread	Landroid/os/HandlerThread;
    //   50: aload_0
    //   51: getfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   54: astore_1
    //   55: aload_1
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   61: sipush 850
    //   64: invokevirtual 348	android/os/Handler:sendEmptyMessage	(I)Z
    //   67: pop
    //   68: aload_1
    //   69: monitorexit
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 120	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   80: ldc_w 336
    //   83: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: astore_2
    //   88: aload_1
    //   89: monitorexit
    //   90: ldc_w 336
    //   93: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: ldc 10
    //   101: ldc_w 350
    //   104: aload_1
    //   105: invokestatic 254	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: getfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   112: astore_1
    //   113: aload_1
    //   114: monitorenter
    //   115: aload_0
    //   116: getfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   119: sipush 850
    //   122: invokevirtual 348	android/os/Handler:sendEmptyMessage	(I)Z
    //   125: pop
    //   126: aload_1
    //   127: monitorexit
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 120	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   138: ldc_w 336
    //   141: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: return
    //   145: astore_2
    //   146: aload_1
    //   147: monitorexit
    //   148: ldc_w 336
    //   151: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_2
    //   155: athrow
    //   156: astore_2
    //   157: aload_0
    //   158: getfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   161: astore_1
    //   162: aload_1
    //   163: monitorenter
    //   164: aload_0
    //   165: getfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   168: sipush 850
    //   171: invokevirtual 348	android/os/Handler:sendEmptyMessage	(I)Z
    //   174: pop
    //   175: aload_1
    //   176: monitorexit
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 120	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 64	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   187: ldc_w 336
    //   190: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_2
    //   194: athrow
    //   195: astore_2
    //   196: aload_1
    //   197: monitorexit
    //   198: ldc_w 336
    //   201: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_2
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	PlayerThreadAudio
    //   98	7	1	localException	Exception
    //   87	10	2	localObject1	Object
    //   145	10	2	localObject2	Object
    //   156	38	2	localObject3	Object
    //   195	10	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   57	70	87	finally
    //   22	50	98	java/lang/Exception
    //   115	128	145	finally
    //   22	50	156	finally
    //   99	108	156	finally
    //   164	177	195	finally
  }
  
  private void releaseAudioTrack()
  {
    AppMethodBeat.i(216032);
    if (this.mAudioTrack != null)
    {
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
    AppMethodBeat.o(216032);
  }
  
  private void removePendingMessage(int... paramVarArgs)
  {
    AppMethodBeat.i(216084);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      this.mPlayHandler.removeCallbacksAndMessages(null);
      AppMethodBeat.o(216084);
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      int k = paramVarArgs[i];
      this.mPlayHandler.removeMessages(k);
      i += 1;
    }
    AppMethodBeat.o(216084);
  }
  
  private void scheduleNextWork()
  {
    AppMethodBeat.i(216120);
    sendMessage(12, "schedule next", System.currentTimeMillis());
    AppMethodBeat.o(216120);
  }
  
  private void seekTo(Object paramObject)
  {
    AppMethodBeat.i(215981);
    if ((paramObject instanceof PlayerMessage)) {
      paramObject = ((PlayerMessage)paramObject).bizMsg1;
    }
    for (;;)
    {
      if ((paramObject instanceof CMTime))
      {
        this.currentPlayingState = new CMSampleState((CMTime)paramObject);
        this.audioDecoderTrack.seekTo((CMTime)paramObject, false, true);
      }
      if (this.mAudioTrack != null) {
        this.mAudioTrack.flush();
      }
      AppMethodBeat.o(215981);
      return;
    }
  }
  
  private void setVolume(Object paramObject)
  {
    AppMethodBeat.i(215991);
    float f;
    if ((paramObject instanceof PlayerMessage)) {
      f = ((Float)((PlayerMessage)paramObject).bizMsg1).floatValue();
    }
    for (;;)
    {
      if ((f >= 0.0F) && (f <= 1.0F)) {
        setVolumeToAudioTrack(f);
      }
      AppMethodBeat.o(215991);
      return;
      if ((paramObject instanceof Float)) {
        f = ((Float)paramObject).floatValue();
      } else {
        f = 1.0F;
      }
    }
  }
  
  private void setVolumeToAudioTrack(float paramFloat)
  {
    AppMethodBeat.i(215997);
    this.volume = paramFloat;
    if (this.mAudioTrack != null) {
      this.mAudioTrack.setVolume(paramFloat);
    }
    AppMethodBeat.o(215997);
  }
  
  private void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(216022);
    if (paramBoolean)
    {
      removePendingMessage(new int[] { 12 });
      this.mLooper = false;
      this.currentPlayingState = new CMSampleState();
    }
    updateStatus(1);
    releaseAudioTrack();
    AppMethodBeat.o(216022);
  }
  
  private void updateStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  private void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216166);
    Logger.v(paramString1, paramString2);
    AppMethodBeat.o(216166);
  }
  
  public CMTime getCurrentPlayingState()
  {
    AppMethodBeat.i(216292);
    CMTime localCMTime = this.currentPlayingState.getTime();
    AppMethodBeat.o(216292);
    return localCMTime;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject4 = null;
    AppMethodBeat.i(216267);
    PlayerMessage localPlayerMessage;
    if (paramMessage.obj == null)
    {
      localPlayerMessage = null;
      if (localPlayerMessage == null) {
        break label529;
      }
    }
    label81:
    Object localObject3;
    label529:
    for (Object localObject1 = localPlayerMessage.bizMsg1;; localObject3 = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("handleMessage() called with: msg = [").append(catLog(paramMessage.what)).append(paramMessage.what).append("]--status-->").append(this.mStatus).append("--from-->");
      if (localPlayerMessage == null) {
        v("PlayerThreadAudio", localObject4 + " targetObj = " + localObject1);
      }
      for (;;)
      {
        try
        {
          int i = paramMessage.what;
          switch (i)
          {
          }
        }
        catch (Exception localException)
        {
          Logger.e("PlayerThreadAudio", "handleMessage: error", localException);
          return false;
          play(localException);
          continue;
        }
        finally
        {
          if ((localPlayerMessage == null) || (TextUtils.isEmpty(localPlayerMessage.form)) || (!localPlayerMessage.form.startsWith("syncAudioStatus"))) {
            continue;
          }
          Logger.d("PlayerThreadAudio", "handleMessage:  SyncMessageId = " + localPlayerMessage.msgId + ", what = " + paramMessage.what);
          this.lastSyncMessgeId = localPlayerMessage.msgId;
          AppMethodBeat.o(216267);
        }
        if ((localPlayerMessage != null) && (!TextUtils.isEmpty(localPlayerMessage.form)) && (localPlayerMessage.form.startsWith("syncAudioStatus")))
        {
          Logger.d("PlayerThreadAudio", "handleMessage:  SyncMessageId = " + localPlayerMessage.msgId + ", what = " + paramMessage.what);
          this.lastSyncMessgeId = localPlayerMessage.msgId;
        }
        AppMethodBeat.o(216267);
        return true;
        localPlayerMessage = (PlayerMessage)paramMessage.obj;
        break;
        localObject4 = localPlayerMessage;
        break label81;
        actionPrepare();
        continue;
        readSample();
        continue;
        pause();
        continue;
        stop(false);
        continue;
        playerFinish();
        continue;
        setVolume(localObject2);
        continue;
        release();
        continue;
        seekTo(localObject2);
      }
    }
  }
  
  public boolean isFinished()
  {
    AppMethodBeat.i(216281);
    if ((3 == this.mStatus) && (this.currentPlayingState.isInvalid()))
    {
      AppMethodBeat.o(216281);
      return true;
    }
    AppMethodBeat.o(216281);
    return false;
  }
  
  public void sendMessage(int paramInt, Object paramObject, String paramString, long paramLong)
  {
    AppMethodBeat.i(216214);
    v("PlayerThreadAudio", "sendMessage() called with: what = [" + catLog(paramInt) + "], obj = [" + paramObject + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null))
    {
      if (((paramInt == 3) || (paramInt == -1) || (paramInt == 5) || (paramInt == 6)) && (this.mPlayHandler.hasMessages(12)))
      {
        this.mPlayHandler.removeMessages(12);
        sendMessage(12, "schedule next", System.currentTimeMillis());
      }
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, paramLong)).sendToTarget();
    }
    AppMethodBeat.o(216214);
  }
  
  public void sendMessage(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(216226);
    v("PlayerThreadAudio", "sendMessage() called with: what = [" + catLog(paramInt) + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(null, paramString, paramLong)).sendToTarget();
    }
    AppMethodBeat.o(216226);
  }
  
  public void sendMessageDelay(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(216243);
    v("PlayerThreadAudio", "sendMessageDelay() called with: what = [" + catLog(paramInt) + "], delay = [" + paramLong1 + "], from = [" + paramString + "]");
    if (this.mPlayHandler != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = new PlayerMessage(null, paramString, paramLong2);
      this.mPlayHandler.sendMessageDelayed(localMessage, paramLong1);
    }
    AppMethodBeat.o(216243);
  }
  
  public void setRate(float paramFloat)
  {
    AppMethodBeat.i(216185);
    this.rate = Math.abs(paramFloat);
    AppMethodBeat.o(216185);
  }
  
  public void update(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    this.audioDecoderTrack = paramAudioCompositionDecoderTrack;
  }
  
  @Deprecated
  public void updateComposition(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    AppMethodBeat.i(216197);
    sendMessage(4, "updateComposition", System.currentTimeMillis());
    sendMessage(1, paramAudioCompositionDecoderTrack, "updateComposition", System.currentTimeMillis());
    AppMethodBeat.o(216197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.player.PlayerThreadAudio
 * JD-Core Version:    0.7.0.1
 */