package com.tencent.mm.wear.app.d.a.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.b.h;
import java.io.File;

public final class k
  extends a
{
  private long ahd;
  private String ahe;
  private int ahg;
  private MediaPlayer ahp = new MediaPlayer();
  
  public k()
  {
    this.ahp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        k.this.h(k.a(k.this));
        try
        {
          k.b(k.this).release();
          k.a(k.this, f.agV);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          d.b("MicroMsg.VoicePlayer", paramAnonymousMediaPlayer, "filePath=%s", new Object[] { k.c(k.this) });
        }
      }
    });
    this.ahp.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        k.this.h(k.a(k.this));
        try
        {
          k.b(k.this).release();
          k.a(k.this, f.agV);
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
  
  public final boolean isPlaying()
  {
    return this.ahp.isPlaying();
  }
  
  public final void k(long paramLong)
  {
    String str = new File(h.mU(), paramLong + ".amr").getAbsolutePath();
    if (q.D(str))
    {
      d.a("MicroMsg.VoicePlayer", "file path is null, occur error", new Object[0]);
      return;
    }
    if (this.ahg != f.agV)
    {
      d.a("MicroMsg.VoicePlayer", "status is stop, occur error", new Object[0]);
      return;
    }
    this.ahd = paramLong;
    this.ahe = str;
    d.c("MicroMsg.VoicePlayer", "startPlay %s", new Object[] { str });
    g(this.ahd);
    this.ahp.setAudioStreamType(3);
    try
    {
      this.ahp.setDataSource(str);
      this.ahp.prepare();
      this.ahp.start();
      return;
    }
    catch (Exception localException)
    {
      d.b("MicroMsg.VoicePlayer", localException, "filePath=%s", new Object[] { this.ahe });
    }
  }
  
  public final void ns()
  {
    try
    {
      this.ahp.stop();
      this.ahp.release();
      this.ahg = f.agV;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.b("MicroMsg.VoicePlayer", localException, "filePath=%s", new Object[] { this.ahe });
      }
    }
  }
  
  public final long nt()
  {
    return this.ahd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.k
 * JD-Core Version:    0.7.0.1
 */