package com.tencent.mm.wear.app.d.a.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.wear.a.c.d;

public final class k
  extends a
{
  private long adB;
  private String adC;
  private int adE;
  private MediaPlayer adN = new MediaPlayer();
  
  public k()
  {
    this.adN.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        k.this.g(k.a(k.this));
        try
        {
          k.b(k.this).release();
          k.a(k.this, f.adt);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          d.b("MicroMsg.VoicePlayer", paramAnonymousMediaPlayer, "filePath=%s", new Object[] { k.c(k.this) });
        }
      }
    });
    this.adN.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        k.this.g(k.a(k.this));
        try
        {
          k.b(k.this).release();
          k.a(k.this, f.adt);
          return false;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          d.b("MicroMsg.VoicePlayer", paramAnonymousMediaPlayer, "filePath=%s", new Object[] { k.c(k.this) });
        }
        return false;
      }
    });
  }
  
  public final void a(String paramString, long paramLong)
  {
    if (q.D(paramString))
    {
      d.a("MicroMsg.VoicePlayer", "file path is null, occur error", new Object[0]);
      return;
    }
    if (this.adE != f.adt)
    {
      d.a("MicroMsg.VoicePlayer", "status is stop, occur error", new Object[0]);
      return;
    }
    this.adB = paramLong;
    this.adC = paramString;
    d.c("MicroMsg.VoicePlayer", "startPlay %s", new Object[] { paramString });
    f(this.adB);
    this.adN.setAudioStreamType(3);
    try
    {
      this.adN.setDataSource(paramString);
      this.adN.prepare();
      this.adN.start();
      return;
    }
    catch (Exception paramString)
    {
      d.b("MicroMsg.VoicePlayer", paramString, "filePath=%s", new Object[] { this.adC });
    }
  }
  
  public final boolean isPlaying()
  {
    return this.adN.isPlaying();
  }
  
  public final void mG()
  {
    try
    {
      this.adN.stop();
      this.adN.release();
      this.adE = f.adt;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.b("MicroMsg.VoicePlayer", localException, "filePath=%s", new Object[] { this.adC });
      }
    }
  }
  
  public final long mH()
  {
    return this.adB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.k
 * JD-Core Version:    0.7.0.1
 */