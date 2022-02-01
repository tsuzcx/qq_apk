package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class AudioTrackMonitor
{
  private static final boolean ENABLE = false;
  private static final String TAG = "AudioTrackMonitor";
  private WeakReference<AudioTrack> mAudioTrackRef;
  private StringBuilder mBuilder;
  private long mLastPosition;
  private long mLastTime;
  private int mLooperTime;
  private Thread mMonitorThread;
  private boolean mStop;
  
  public AudioTrackMonitor(AudioTrack paramAudioTrack)
  {
    AppMethodBeat.i(114163);
    this.mLastTime = System.nanoTime();
    this.mLastPosition = 0L;
    this.mLooperTime = 200;
    this.mAudioTrackRef = null;
    this.mStop = false;
    this.mBuilder = new StringBuilder(100);
    this.mMonitorThread = new Thread("Monitor-AudioTrack")
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: ldc 19
        //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: invokespecial 27	java/lang/Thread:run	()V
        //   9: aload_0
        //   10: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   13: invokestatic 31	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$000	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Z
        //   16: ifne +238 -> 254
        //   19: invokestatic 35	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   22: pop
        //   23: aload_0
        //   24: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   27: invokestatic 39	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$100	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)I
        //   30: i2l
        //   31: invokestatic 43	java/lang/Thread:sleep	(J)V
        //   34: aload_0
        //   35: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   38: invokestatic 47	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$200	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Ljava/lang/ref/WeakReference;
        //   41: ifnull +207 -> 248
        //   44: aload_0
        //   45: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   48: invokestatic 47	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$200	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Ljava/lang/ref/WeakReference;
        //   51: invokevirtual 53	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   54: ifnull +194 -> 248
        //   57: aload_0
        //   58: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   61: invokestatic 47	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$200	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Ljava/lang/ref/WeakReference;
        //   64: invokevirtual 53	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   67: checkcast 55	android/media/AudioTrack
        //   70: astore 10
        //   72: aload 10
        //   74: ifnull -65 -> 9
        //   77: aload 10
        //   79: invokevirtual 59	android/media/AudioTrack:getPlaybackHeadPosition	()I
        //   82: istore_1
        //   83: iload_1
        //   84: i2l
        //   85: lstore_2
        //   86: aload_0
        //   87: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   90: invokestatic 63	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$300	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)J
        //   93: lstore 4
        //   95: aload_0
        //   96: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   99: iload_1
        //   100: i2l
        //   101: invokestatic 67	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$302	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;J)J
        //   104: pop2
        //   105: invokestatic 73	java/lang/System:nanoTime	()J
        //   108: lstore 6
        //   110: aload_0
        //   111: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   114: invokestatic 76	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$400	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)J
        //   117: lstore 8
        //   119: aload_0
        //   120: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   123: invokestatic 73	java/lang/System:nanoTime	()J
        //   126: invokestatic 79	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$402	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;J)J
        //   129: pop2
        //   130: aload_0
        //   131: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   134: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$500	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Ljava/lang/StringBuilder;
        //   137: ldc 85
        //   139: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: lload 6
        //   144: lload 8
        //   146: lsub
        //   147: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   150: ldc 96
        //   152: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: lload_2
        //   156: lload 4
        //   158: lsub
        //   159: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   162: pop
        //   163: aload_0
        //   164: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   167: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$500	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Ljava/lang/StringBuilder;
        //   170: ldc 98
        //   172: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   175: aload 10
        //   177: invokevirtual 101	android/media/AudioTrack:getPlayState	()I
        //   180: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   183: pop
        //   184: ldc 106
        //   186: aload_0
        //   187: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   190: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$500	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Ljava/lang/StringBuilder;
        //   193: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   196: invokestatic 116	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   199: aload_0
        //   200: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   203: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$500	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Ljava/lang/StringBuilder;
        //   206: iconst_0
        //   207: aload_0
        //   208: getfield 12	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor$1:this$0	Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;
        //   211: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor:access$500	(Lcom/tencent/qqmusic/mediaplayer/util/AudioTrackMonitor;)Ljava/lang/StringBuilder;
        //   214: invokevirtual 119	java/lang/StringBuilder:length	()I
        //   217: invokevirtual 123	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
        //   220: pop
        //   221: goto -212 -> 9
        //   224: astore 10
        //   226: ldc 106
        //   228: aload 10
        //   230: invokestatic 126	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   233: goto -224 -> 9
        //   236: astore 10
        //   238: ldc 106
        //   240: aload 10
        //   242: invokestatic 126	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   245: goto -211 -> 34
        //   248: ldc 19
        //   250: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   253: return
        //   254: ldc 19
        //   256: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   259: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	260	0	this	1
        //   82	18	1	i	int
        //   85	71	2	l1	long
        //   93	64	4	l2	long
        //   108	35	6	l3	long
        //   117	28	8	l4	long
        //   70	106	10	localAudioTrack	AudioTrack
        //   224	5	10	localThrowable1	java.lang.Throwable
        //   236	5	10	localThrowable2	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   34	72	224	finally
        //   77	83	224	finally
        //   86	221	224	finally
        //   19	34	236	finally
      }
    };
    this.mAudioTrackRef = new WeakReference(paramAudioTrack);
    AppMethodBeat.o(114163);
  }
  
  public void start() {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.AudioTrackMonitor
 * JD-Core Version:    0.7.0.1
 */