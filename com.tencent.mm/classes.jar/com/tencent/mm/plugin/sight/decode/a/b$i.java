package com.tencent.mm.plugin.sight.decode.a;

import android.media.MediaPlayer;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b$i
  implements Runnable
{
  double oeR = -1.0D;
  MediaPlayer ofi;
  public int type;
  
  private b$i(b paramb) {}
  
  private void bnj()
  {
    y.i("MicroMsg.SightPlayController", "stopPlayer");
    try
    {
      if (this.ofi != null)
      {
        this.ofi.stop();
        this.ofi.release();
        this.ofi = null;
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
      this.ofi = null;
    }
  }
  
  public final double bBk()
  {
    if (this.ofi == null) {
      return 0.0D;
    }
    return this.ofi.getCurrentPosition();
  }
  
  public final void run()
  {
    String str;
    switch (this.type)
    {
    default: 
      str = "unknown";
      y.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
      switch (this.type)
      {
      }
      break;
    }
    for (;;)
    {
      return;
      str = "start";
      break;
      str = "stop";
      break;
      str = "pause";
      break;
      str = "resume";
      break;
      str = "seek";
      break;
      bnj();
      if (!bk.bl(b.a(this.oeY)))
      {
        try
        {
          this.ofi = new j();
          this.ofi.setDisplay(null);
          this.ofi.reset();
          this.ofi.setDataSource(b.a(this.oeY));
          this.ofi.setAudioStreamType(3);
          this.ofi.setOnErrorListener(new b.i.1(this));
          this.ofi.prepare();
          this.ofi.start();
          return;
        }
        catch (Exception localException1)
        {
          y.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
          y.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(this.oeY) });
          this.oeY.clear();
        }
        if (b.b(this.oeY) != null)
        {
          b.b(this.oeY).d(this.oeY, -1);
          return;
          bnj();
          return;
          try
          {
            if ((this.ofi == null) || (!this.ofi.isPlaying())) {
              continue;
            }
            this.ofi.pause();
            return;
          }
          catch (Exception localException2)
          {
            y.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            bnj();
            return;
          }
          try
          {
            if (this.ofi != null)
            {
              this.ofi.start();
              return;
            }
          }
          catch (Exception localException3)
          {
            y.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            bnj();
            return;
          }
        }
      }
    }
    try
    {
      y.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.oeR) });
      this.ofi.seekTo((int)(this.oeR * 1000.0D));
      return;
    }
    catch (Exception localException4)
    {
      y.printErrStackTrace("MicroMsg.SightPlayController", localException4, "seek sound error: %s", new Object[] { localException4.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.i
 * JD-Core Version:    0.7.0.1
 */