package com.tencent.tav.player;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.e.o;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;

public class PlayerThreadAudio
  implements Handler.Callback
{
  public static boolean LOG_VERBOSE = false;
  private static final String TAG = "PlayerThreadAudio";
  private AudioCompositionDecoderTrack audioDecoderTrack;
  public volatile CMTime currentPlayingTime;
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
    AppMethodBeat.i(198283);
    this.currentPlayingTime = CMTime.CMTimeInvalid;
    this.lastSyncMessgeId = -1L;
    this.mStatus = 1;
    this.rate = 1.0F;
    this.volume = 1.0F;
    this.audioDecoderTrack = paramAudioCompositionDecoderTrack;
    this.mMainHandler = paramHandler1;
    this.mVideoHandler = paramHandler2;
    initThread();
    AppMethodBeat.o(198283);
  }
  
  private void actionPrepare()
  {
    AppMethodBeat.i(198294);
    if (this.audioDecoderTrack != null)
    {
      updateStatus(2);
      releaseAudioTrack();
    }
    AppMethodBeat.o(198294);
  }
  
  private String catLog(int paramInt)
  {
    AppMethodBeat.i(198305);
    String str = (String)PlayerThread.map.get(paramInt, null);
    AppMethodBeat.o(198305);
    return str;
  }
  
  private void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198306);
    Logger.d(paramString1, paramString2);
    AppMethodBeat.o(198306);
  }
  
  private void initThread()
  {
    AppMethodBeat.i(198285);
    this.mThread = new HandlerThread("PlayerAudioThread");
    this.mThread.start();
    this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
    AppMethodBeat.o(198285);
  }
  
  private void pause()
  {
    AppMethodBeat.i(198297);
    if (this.mStatus == 2)
    {
      this.mLooper = false;
      this.currentPlayingTime = CMTime.CMTimeInvalid;
      removePendingMessage(new int[] { 12 });
    }
    AppMethodBeat.o(198297);
  }
  
  private void play(Object paramObject)
  {
    AppMethodBeat.i(198298);
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(198298);
      return;
    }
    this.mLooper = true;
    if (((paramObject instanceof CMTime)) && (Math.abs(((CMTime)paramObject).getTimeUs() - this.currentPlayingTime.getTimeUs()) > 100000L)) {
      seekTo(paramObject);
    }
    if (this.mStatus == 3) {
      updateStatus(2);
    }
    sendMessage(12, "play", System.currentTimeMillis());
    AppMethodBeat.o(198298);
  }
  
  private void playerFinish()
  {
    AppMethodBeat.i(198299);
    this.currentPlayingTime = CMTime.CMTimeInvalid;
    this.audioDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
    this.mLooper = false;
    updateStatus(3);
    removePendingMessage(new int[] { 12 });
    AppMethodBeat.o(198299);
  }
  
  private void readSample()
  {
    Object localObject7 = null;
    AppMethodBeat.i(198302);
    if ((this.audioDecoderTrack == null) || (!this.mLooper))
    {
      AppMethodBeat.o(198302);
      return;
    }
    this.audioDecoderTrack.setRate(this.rate);
    Object localObject2 = IDecoder.SAMPLE_TIME_FAILED;
    if (LOG_VERBOSE) {
      d("PlayerThreadAudio", "readSample start");
    }
    for (;;)
    {
      try
      {
        localObject1 = this.audioDecoderTrack.readSample();
        Object localObject3;
        Logger.e("PlayerThreadAudio", "java.lang.IllegalStateException: buffer was freed", localException2);
      }
      catch (Exception localException2)
      {
        try
        {
          localObject6 = ((CMSampleBuffer)localObject1).getTime();
          localObject5 = localObject1;
          localObject3 = localObject6;
          localObject2 = localObject6;
          if (LOG_VERBOSE)
          {
            localObject2 = localObject6;
            d("PlayerThreadAudio", "readSample finish ".concat(String.valueOf(localObject6)));
            localObject3 = localObject6;
            localObject5 = localObject1;
          }
          if (LOG_VERBOSE) {
            d("PlayerThreadAudio", "processFrame() called audioTime--> ".concat(String.valueOf(localObject3)));
          }
          if (this.mAudioTrack == null)
          {
            if (LOG_VERBOSE) {
              d("PlayerThreadAudio", "processFrame() called new mediaFormat");
            }
            this.mAudioTrack = new AudioTrackWrapper(44100, 1);
            this.mAudioTrack.setVolume(this.volume);
          }
          if ((localObject3 != IDecoder.SAMPLE_TIME_FINISH) && (localObject3 != IDecoder.SAMPLE_TIME_ERROR) && (localObject3 != IDecoder.SAMPLE_TIME_UNSTART) && (!localObject3.bigThan(this.audioDecoderTrack.getDuration()))) {
            break;
          }
          d("PlayerThreadAudio", "processFrame() called end of stream");
          playerFinish();
          this.currentPlayingTime = localObject3;
          AppMethodBeat.o(198302);
          return;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Object localObject6;
            Object localObject5;
            Object localObject4;
            continue;
            Object localObject1 = null;
          }
        }
        localException2 = localException2;
        localObject1 = null;
      }
      localObject5 = localObject1;
      localObject4 = localObject2;
    }
    if ((localObject4.getValue() >= 0L) && (localObject5 != null)) {
      localObject1 = localObject7;
    }
    try
    {
      localObject6 = localObject5.getSampleByteBuffer();
      if (localObject6 == null) {
        break label541;
      }
      localObject1 = localObject7;
      ((ByteBuffer)localObject6).position(0);
      localObject1 = localObject7;
      localObject2 = new byte[((ByteBuffer)localObject6).limit()];
      localObject1 = localObject2;
      if (LOG_VERBOSE)
      {
        localObject1 = localObject2;
        Logger.d("PlayerThreadAudio", "read sample thread: " + Thread.currentThread().getId() + " " + localObject5.getTime());
      }
      localObject1 = localObject2;
      ((ByteBuffer)localObject6).get((byte[])localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Logger.e("PlayerThreadAudio", localException1.toString());
        continue;
        if (LOG_VERBOSE) {
          d("PlayerThreadAudio", "processFrame() called run audioData length exception");
        }
      }
      if (!LOG_VERBOSE) {
        break label531;
      }
      d("PlayerThreadAudio", "processFrame() not run looper");
      AppMethodBeat.o(198302);
      return;
    }
    if (localObject1 != null)
    {
      if (LOG_VERBOSE) {
        d("PlayerThreadAudio", "processFrame() called run audioData length audioData--" + localObject1.length);
      }
      this.audioDecoderTrack.asyncReadNextSample(CMTime.CMTimeInvalid);
      this.mAudioTrack.writeData((byte[])localObject1, 0, localObject1.length);
      this.currentPlayingTime = localObject4;
      if ((!this.mLooper) || (this.rate <= 0.0F)) {
        break label516;
      }
      if (LOG_VERBOSE) {
        d("PlayerThreadAudio", "processFrame() called run looper " + this.currentPlayingTime);
      }
      scheduleNextWork();
      AppMethodBeat.o(198302);
    }
  }
  
  /* Error */
  private void release()
  {
    // Byte code:
    //   0: ldc_w 333
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 86	com/tencent/tav/player/PlayerThreadAudio:releaseAudioTrack	()V
    //   10: aload_0
    //   11: iconst_0
    //   12: newarray int
    //   14: invokespecial 142	com/tencent/tav/player/PlayerThreadAudio:removePendingMessage	([I)V
    //   17: aload_0
    //   18: iconst_1
    //   19: invokespecial 83	com/tencent/tav/player/PlayerThreadAudio:updateStatus	(I)V
    //   22: new 275	java/lang/StringBuilder
    //   25: dup
    //   26: ldc_w 335
    //   29: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_0
    //   38: getfield 120	com/tencent/tav/player/PlayerThreadAudio:mThread	Landroid/os/HandlerThread;
    //   41: invokevirtual 339	android/os/HandlerThread:quit	()Z
    //   44: pop
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 120	com/tencent/tav/player/PlayerThreadAudio:mThread	Landroid/os/HandlerThread;
    //   50: aload_0
    //   51: getfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   54: astore_1
    //   55: aload_1
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   61: sipush 850
    //   64: invokevirtual 343	android/os/Handler:sendEmptyMessage	(I)Z
    //   67: pop
    //   68: aload_1
    //   69: monitorexit
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 134	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   80: ldc_w 333
    //   83: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: astore_2
    //   88: aload_1
    //   89: monitorexit
    //   90: ldc_w 333
    //   93: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: ldc 13
    //   101: ldc_w 345
    //   104: aload_1
    //   105: invokestatic 256	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: getfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   112: astore_1
    //   113: aload_1
    //   114: monitorenter
    //   115: aload_0
    //   116: getfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   119: sipush 850
    //   122: invokevirtual 343	android/os/Handler:sendEmptyMessage	(I)Z
    //   125: pop
    //   126: aload_1
    //   127: monitorexit
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 134	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   138: ldc_w 333
    //   141: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: return
    //   145: astore_2
    //   146: aload_1
    //   147: monitorexit
    //   148: ldc_w 333
    //   151: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_2
    //   155: athrow
    //   156: astore_2
    //   157: aload_0
    //   158: getfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   161: astore_1
    //   162: aload_1
    //   163: monitorenter
    //   164: aload_0
    //   165: getfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   168: sipush 850
    //   171: invokevirtual 343	android/os/Handler:sendEmptyMessage	(I)Z
    //   174: pop
    //   175: aload_1
    //   176: monitorexit
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 134	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 72	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   187: ldc_w 333
    //   190: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_2
    //   194: athrow
    //   195: astore_2
    //   196: aload_1
    //   197: monitorexit
    //   198: ldc_w 333
    //   201: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   88	90	87	finally
    //   22	50	98	java/lang/Exception
    //   115	128	145	finally
    //   146	148	145	finally
    //   22	50	156	finally
    //   99	108	156	finally
    //   164	177	195	finally
    //   196	198	195	finally
  }
  
  private void releaseAudioTrack()
  {
    AppMethodBeat.i(198296);
    if (this.mAudioTrack != null)
    {
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
    AppMethodBeat.o(198296);
  }
  
  private void removePendingMessage(int... paramVarArgs)
  {
    AppMethodBeat.i(198301);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      this.mPlayHandler.removeCallbacksAndMessages(null);
      AppMethodBeat.o(198301);
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
    AppMethodBeat.o(198301);
  }
  
  private void scheduleNextWork()
  {
    AppMethodBeat.i(198303);
    sendMessage(12, "schedule next", System.currentTimeMillis());
    AppMethodBeat.o(198303);
  }
  
  private void seekTo(Object paramObject)
  {
    AppMethodBeat.i(198291);
    if ((paramObject instanceof PlayerMessage)) {
      paramObject = ((PlayerMessage)paramObject).bizMsg1;
    }
    for (;;)
    {
      if ((paramObject instanceof CMTime))
      {
        this.currentPlayingTime = ((CMTime)paramObject);
        this.audioDecoderTrack.seekTo((CMTime)paramObject, false, true);
      }
      if (this.mAudioTrack != null) {
        this.mAudioTrack.flush();
      }
      AppMethodBeat.o(198291);
      return;
    }
  }
  
  private void setVolume(Object paramObject)
  {
    AppMethodBeat.i(198292);
    float f;
    if ((paramObject instanceof PlayerMessage)) {
      f = ((Float)((PlayerMessage)paramObject).bizMsg1).floatValue();
    }
    for (;;)
    {
      if ((f >= 0.0F) && (f <= 1.0F)) {
        setVolumeToAudioTrack(f);
      }
      AppMethodBeat.o(198292);
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
    AppMethodBeat.i(198293);
    this.volume = paramFloat;
    if (this.mAudioTrack != null) {
      this.mAudioTrack.setVolume(paramFloat);
    }
    AppMethodBeat.o(198293);
  }
  
  private void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(198295);
    if (paramBoolean)
    {
      removePendingMessage(new int[] { 12 });
      this.mLooper = false;
      this.currentPlayingTime = CMTime.CMTimeInvalid;
    }
    updateStatus(1);
    releaseAudioTrack();
    AppMethodBeat.o(198295);
  }
  
  private void updateStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  public CMTime getCurrentPlayingTime()
  {
    return this.currentPlayingTime;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject4 = null;
    AppMethodBeat.i(198290);
    PlayerMessage localPlayerMessage;
    if (paramMessage.obj == null)
    {
      localPlayerMessage = null;
      if (localPlayerMessage == null) {
        break label516;
      }
    }
    label87:
    Object localObject3;
    label516:
    for (Object localObject1 = localPlayerMessage.bizMsg1;; localObject3 = null)
    {
      if (LOG_VERBOSE)
      {
        StringBuilder localStringBuilder = new StringBuilder("handleMessage() called with: msg = [").append(catLog(paramMessage.what)).append(paramMessage.what).append("]--status-->").append(this.mStatus).append("--from-->");
        if (localPlayerMessage != null) {
          break label277;
        }
        d("PlayerThreadAudio", localObject4 + " targetObj = " + localObject1);
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
          label277:
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
          new StringBuilder("handleMessage:  SyncMessageId = ").append(localPlayerMessage.msgId).append(", what = ").append(paramMessage.what);
          this.lastSyncMessgeId = localPlayerMessage.msgId;
          AppMethodBeat.o(198290);
        }
        if ((localPlayerMessage != null) && (!TextUtils.isEmpty(localPlayerMessage.form)) && (localPlayerMessage.form.startsWith("syncAudioStatus")))
        {
          new StringBuilder("handleMessage:  SyncMessageId = ").append(localPlayerMessage.msgId).append(", what = ").append(paramMessage.what);
          this.lastSyncMessgeId = localPlayerMessage.msgId;
        }
        AppMethodBeat.o(198290);
        return true;
        localPlayerMessage = (PlayerMessage)paramMessage.obj;
        break;
        localObject4 = localPlayerMessage;
        break label87;
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
    AppMethodBeat.i(198300);
    if ((3 == this.mStatus) && (this.currentPlayingTime.equalsTo(CMTime.CMTimeInvalid)))
    {
      AppMethodBeat.o(198300);
      return true;
    }
    AppMethodBeat.o(198300);
    return false;
  }
  
  public void sendMessage(int paramInt, Object paramObject, String paramString, long paramLong)
  {
    AppMethodBeat.i(198287);
    if (LOG_VERBOSE) {
      d("PlayerThreadAudio", "sendMessage() called with: what = [" + catLog(paramInt) + "], obj = [" + paramObject + "], from = [" + paramString + "]");
    }
    if ((this.mPlayHandler != null) && (this.mThread != null))
    {
      if (((paramInt == 3) || (paramInt == -1) || (paramInt == 5) || (paramInt == 6)) && (this.mPlayHandler.hasMessages(12)))
      {
        this.mPlayHandler.removeMessages(12);
        sendMessage(12, "schedule next", System.currentTimeMillis());
      }
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, paramLong)).sendToTarget();
    }
    AppMethodBeat.o(198287);
  }
  
  public void sendMessage(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(198288);
    if (LOG_VERBOSE) {
      d("PlayerThreadAudio", "sendMessage() called with: what = [" + catLog(paramInt) + "], from = [" + paramString + "]");
    }
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(null, paramString, paramLong)).sendToTarget();
    }
    AppMethodBeat.o(198288);
  }
  
  public void sendMessageDelay(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(198289);
    if (LOG_VERBOSE) {
      d("PlayerThreadAudio", "sendMessageDelay() called with: what = [" + catLog(paramInt) + "], delay = [" + paramLong1 + "], from = [" + paramString + "]");
    }
    if (this.mPlayHandler != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = new PlayerMessage(null, paramString, paramLong2);
      this.mPlayHandler.sendMessageDelayed(localMessage, paramLong1);
    }
    AppMethodBeat.o(198289);
  }
  
  public void setRate(float paramFloat)
  {
    AppMethodBeat.i(198284);
    this.rate = Math.abs(paramFloat);
    AppMethodBeat.o(198284);
  }
  
  public void update(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    this.audioDecoderTrack = paramAudioCompositionDecoderTrack;
  }
  
  @Deprecated
  public void updateComposition(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    AppMethodBeat.i(198286);
    sendMessage(4, "updateComposition", System.currentTimeMillis());
    sendMessage(1, paramAudioCompositionDecoderTrack, "updateComposition", System.currentTimeMillis());
    AppMethodBeat.o(198286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.player.PlayerThreadAudio
 * JD-Core Version:    0.7.0.1
 */