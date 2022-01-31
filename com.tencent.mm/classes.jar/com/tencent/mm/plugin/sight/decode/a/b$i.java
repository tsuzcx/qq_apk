package com.tencent.mm.plugin.sight.decode.a;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b$i
  implements Runnable
{
  double qTg = -1.0D;
  MediaPlayer qTw;
  public int type;
  
  private b$i(b paramb) {}
  
  private void bVF()
  {
    AppMethodBeat.i(70243);
    ab.i("MicroMsg.SightPlayController", "stopPlayer");
    try
    {
      if (this.qTw != null)
      {
        this.qTw.stop();
        this.qTw.release();
        this.qTw = null;
      }
      AppMethodBeat.o(70243);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
      this.qTw = null;
      AppMethodBeat.o(70243);
    }
  }
  
  public final double cmK()
  {
    AppMethodBeat.i(70244);
    if (this.qTw == null)
    {
      AppMethodBeat.o(70244);
      return 0.0D;
    }
    double d = this.qTw.getCurrentPosition();
    AppMethodBeat.o(70244);
    return d;
  }
  
  public final void run()
  {
    AppMethodBeat.i(70245);
    String str;
    switch (this.type)
    {
    default: 
      str = "unknown";
      ab.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
      switch (this.type)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(70245);
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
      bVF();
      if (!bo.isNullOrNil(b.a(this.qTn)))
      {
        try
        {
          this.qTw = new k();
          this.qTw.setDisplay(null);
          this.qTw.reset();
          this.qTw.setDataSource(b.a(this.qTn));
          this.qTw.setAudioStreamType(3);
          this.qTw.setOnErrorListener(new b.i.1(this));
          this.qTw.prepare();
          this.qTw.start();
          AppMethodBeat.o(70245);
          return;
        }
        catch (Exception localException1)
        {
          ab.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
          ab.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(this.qTn) });
          this.qTn.clear();
          if (b.b(this.qTn) != null) {
            b.b(this.qTn).c(this.qTn, -1);
          }
          AppMethodBeat.o(70245);
          return;
        }
        bVF();
        AppMethodBeat.o(70245);
        return;
        try
        {
          if ((this.qTw != null) && (this.qTw.isPlaying())) {
            this.qTw.pause();
          }
          AppMethodBeat.o(70245);
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
          bVF();
          AppMethodBeat.o(70245);
          return;
        }
        try
        {
          if (this.qTw != null) {
            this.qTw.start();
          }
          AppMethodBeat.o(70245);
          return;
        }
        catch (Exception localException3)
        {
          ab.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
          bVF();
          AppMethodBeat.o(70245);
          return;
        }
        try
        {
          ab.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.qTg) });
          this.qTw.seekTo((int)(this.qTg * 1000.0D));
          AppMethodBeat.o(70245);
          return;
        }
        catch (Exception localException4)
        {
          ab.printErrStackTrace("MicroMsg.SightPlayController", localException4, "seek sound error: %s", new Object[] { localException4.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.i
 * JD-Core Version:    0.7.0.1
 */