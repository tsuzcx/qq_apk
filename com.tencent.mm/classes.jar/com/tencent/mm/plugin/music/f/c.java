package com.tencent.mm.plugin.music.f;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import com.tencent.mm.plugin.music.f.a.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(16)
public final class c
  extends com.tencent.mm.plugin.music.f.a.b
{
  MediaCodec aFW;
  AudioTrack awx;
  int channels = 0;
  int dUg = 0;
  long duration = 0L;
  MediaExtractor eIP;
  String jkV = null;
  private Runnable mAA = new c.1(this);
  String mAz;
  long presentationTimeUs = 0L;
  int sampleRate = 0;
  private boolean stop = true;
  
  /* Error */
  private void bnH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: ldc 88
    //   6: invokestatic 92	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 95	java/lang/Object:notify	()V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: ldc 65
    //   19: aload_1
    //   20: ldc 97
    //   22: iconst_0
    //   23: anewarray 69	java/lang/Object
    //   26: invokestatic 75	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: goto -16 -> 13
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	c
    //   16	4	1	localException	Exception
    //   32	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	13	16	java/lang/Exception
    //   2	9	32	finally
    //   9	13	32	finally
    //   17	29	32	finally
  }
  
  public final void JG(String paramString)
  {
    this.mAz = paramString;
  }
  
  public final boolean bnE()
  {
    return !this.stop;
  }
  
  public final int bnF()
  {
    return (int)(this.presentationTimeUs / 1000L);
  }
  
  public final String bnG()
  {
    return this.jkV;
  }
  
  public final void bnI()
  {
    try
    {
      while (bnE())
      {
        boolean bool = this.mAS.bnM();
        if (!bool) {
          break;
        }
        try
        {
          y.i("MicroMsg.Music.MMPlayer", "wait play");
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          y.printErrStackTrace("MicroMsg.Music.MMPlayer", localInterruptedException, "waitPlay", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  final boolean createAudioTrack()
  {
    boolean bool = true;
    y.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
    int i;
    if (this.channels == 1) {
      i = 4;
    }
    for (;;)
    {
      int j = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
      com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.b.class);
      if (localb != null)
      {
        this.awx = localb.Q(this.sampleRate, i, j);
        if (this.awx == null)
        {
          y.e("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
          this.awx = new AudioTrack(3, this.sampleRate, i, 2, j, 1);
        }
        if ((this.awx == null) || (this.awx.getState() != 1))
        {
          y.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
          if (this.awx == null) {}
        }
      }
      try
      {
        this.awx.release();
        label134:
        bool = false;
        return bool;
        i = 12;
        continue;
        y.e("MicroMsg.Music.MMPlayer", "mediaResService null");
      }
      catch (Exception localException)
      {
        break label134;
      }
    }
  }
  
  public final int getDuration()
  {
    return (int)(this.duration / 1000L);
  }
  
  protected final void hS(boolean paramBoolean)
  {
    this.mAS.mAW = 4;
    this.stop = true;
    super.hS(paramBoolean);
  }
  
  protected final void hT(boolean paramBoolean)
  {
    this.mAS.mAW = 4;
    this.stop = true;
    super.hT(paramBoolean);
  }
  
  public final boolean isPlaying()
  {
    return this.mAS.isPlaying();
  }
  
  public final void pause()
  {
    y.i("MicroMsg.Music.MMPlayer", "pause");
    if (!bnE()) {
      return;
    }
    this.mAS.mAW = 2;
  }
  
  public final void play()
  {
    y.i("MicroMsg.Music.MMPlayer", "play");
    if (!bnE())
    {
      this.stop = false;
      e.post(this.mAA, "music_player");
    }
    while ((!bnE()) || (!this.mAS.bnM())) {
      return;
    }
    this.mAS.mAW = 3;
    bnH();
  }
  
  public final void seek(long paramLong)
  {
    this.eIP.seekTo(1000L * paramLong, 2);
  }
  
  public final void stop()
  {
    y.i("MicroMsg.Music.MMPlayer", "stop");
    this.stop = true;
    if (this.mAS.bnM()) {
      bnH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.c
 * JD-Core Version:    0.7.0.1
 */