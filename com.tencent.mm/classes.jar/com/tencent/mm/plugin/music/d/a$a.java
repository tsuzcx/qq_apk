package com.tencent.mm.plugin.music.d;

import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class a$a
  implements f.a
{
  private a$a(a parama) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(137479);
    ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + this.oYW.bVl() + "]", new Object[0]);
    a locala = this.oYW;
    Object localObject;
    if (parame != null)
    {
      localObject = parame.getCause();
      if (localObject == null) {
        break label356;
      }
      if (!(localObject instanceof s.c)) {
        break label288;
      }
      if (((Throwable)localObject).toString().contains("Unable to connect"))
      {
        boolean bool = at.isNetworkConnected(ah.getContext());
        ab.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + bool + " caused by:\n" + ((Throwable)localObject).toString());
        if (!bool)
        {
          locala.eO(-4000, -2);
          AppMethodBeat.o(137479);
          return;
        }
        locala.eO(-4000, -3);
        AppMethodBeat.o(137479);
        return;
      }
      if ((localObject instanceof s.e))
      {
        localObject = ((Throwable)localObject).toString();
        if (!((String)localObject).contains("403")) {
          break label210;
        }
        locala.eO(-4000, -10);
      }
    }
    label288:
    for (;;)
    {
      ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "ExoPlaybackException", new Object[0]);
      AppMethodBeat.o(137479);
      return;
      label210:
      if (((String)localObject).contains("404"))
      {
        locala.eO(-4000, -11);
      }
      else if (((String)localObject).contains("500"))
      {
        locala.eO(-4000, -12);
      }
      else if (((String)localObject).contains("502"))
      {
        locala.eO(-4000, -13);
      }
      else
      {
        locala.eO(-4000, -30);
        continue;
        if ((localObject instanceof q))
        {
          locala.eO(-4001, -1);
        }
        else if ((localObject instanceof IllegalStateException))
        {
          locala.eO(-4002, -1);
        }
        else if ((localObject instanceof b.a))
        {
          locala.eO(-4003, -1);
        }
        else
        {
          locala.eO(-4999, -1);
          continue;
          label356:
          locala.eO(-4999, -1);
        }
      }
    }
  }
  
  public final void aF(boolean paramBoolean)
  {
    AppMethodBeat.i(137477);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
    AppMethodBeat.o(137477);
  }
  
  public final void ai(int paramInt) {}
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(137481);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.speed), Float.valueOf(paramp.pitch) }));
    AppMethodBeat.o(137481);
  }
  
  public final void b(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137478);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "state [" + this.oYW.bVl() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.f.b.a.Ax(paramInt) + "]");
    a locala = this.oYW;
    if (locala.oYL != null)
    {
      paramBoolean = locala.oYL.mK();
      paramInt = locala.oYL.mJ();
      if ((paramBoolean) && (paramInt == 3))
      {
        ab.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
        if (locala.oYU != null) {
          locala.oYU.bVn();
        }
      }
      for (;;)
      {
        int i = a.f.e(paramBoolean, paramInt);
        if (i == locala.oYQ.bIR[3]) {
          break label615;
        }
        ab.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
        locala.oYQ.d(paramBoolean, paramInt);
        if (i != a.f.e(true, 4)) {
          break;
        }
        ab.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
        if (locala.oYU != null) {
          locala.oYU.bVr();
        }
        AppMethodBeat.o(137478);
        return;
        if ((!paramBoolean) && (paramInt == 3) && (locala.oYK == 2))
        {
          ab.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
          if (locala.oYU != null) {
            locala.oYU.bVo();
          }
        }
        else if ((!paramBoolean) && (paramInt == 3) && (locala.oYK == 3))
        {
          ab.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
          if (locala.oYU != null) {
            locala.oYU.bVp();
          }
        }
      }
      if (locala.oYQ.b(new int[] { a.f.e(false, 1), a.f.e(false, 2), a.f.e(false, 3) }, false))
      {
        ab.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
        if (locala.oYU != null) {
          locala.oYU.bVm();
        }
        AppMethodBeat.o(137478);
        return;
      }
      if ((locala.oYQ.b(new int[] { 100, 2, 3 }, true) | locala.oYQ.b(new int[] { 2, 100, 3 }, true) | locala.oYQ.b(new int[] { 100, 3, 2, 3 }, true)))
      {
        ab.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
        if (locala.oYU != null) {
          locala.oYU.bVq();
        }
        AppMethodBeat.o(137478);
        return;
      }
      if (locala.oYQ.b(new int[] { a.f.e(true, 3), a.f.e(true, 2) }, false))
      {
        ab.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
        locala.eP(701, locala.getDownloadPercent());
        AppMethodBeat.o(137478);
        return;
      }
      if (locala.oYQ.b(new int[] { a.f.e(true, 2), a.f.e(true, 3) }, false))
      {
        ab.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
        locala.eP(702, locala.getDownloadPercent());
      }
    }
    label615:
    AppMethodBeat.o(137478);
  }
  
  public final void na() {}
  
  public final void nb() {}
  
  public final void nc()
  {
    AppMethodBeat.i(137480);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
    AppMethodBeat.o(137480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a.a
 * JD-Core Version:    0.7.0.1
 */