package com.tencent.mm.plugin.music.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;

final class d$1
  implements f
{
  long paK;
  
  d$1(d paramd) {}
  
  public final void I(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(137579);
    com.tencent.mm.aw.e locale = k.bVH().bVs();
    if (locale == null)
    {
      AppMethodBeat.o(137579);
      return;
    }
    int j;
    int k;
    float f2;
    float f1;
    label235:
    int i;
    if ((locale.e(parame)) && (this.paL.paG != null) && (this.paL.paG.isPlaying()))
    {
      j = this.paL.paG.bWc();
      k = this.paL.paG.getDuration();
      if ((j > 0) && (k > 0))
      {
        f2 = j / k;
        if (this.paL.pao != null)
        {
          parame = this.paL.pao;
          parame.oYD = f2;
          boolean bool = at.isNetworkConnected(ah.getContext());
          if ((parame.isStop) && (bool))
          {
            if (!parame.muY) {
              break label363;
            }
            if (parame.oYC.oYz != 0L)
            {
              f1 = (float)parame.oYC.oYx / (float)parame.oYC.oYz;
              if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
              {
                ab.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
                parame.start();
              }
            }
          }
          if ((this.paL.pao != null) && (this.paL.pao.isStop))
          {
            parame = this.paL.pao;
            if (!parame.muY) {
              break label396;
            }
            if (parame.oYC.oYz == 0L) {
              break label444;
            }
            f1 = (float)parame.oYC.oYx / (float)parame.oYC.oYz;
            label303:
            if (f1 < 1.0F) {
              break label429;
            }
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ab.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
        this.paL.stopPlay();
      }
      if (this.paL.oXk != null) {
        this.paL.oXk.dW(j, k);
      }
      AppMethodBeat.o(137579);
      return;
      label363:
      if (parame.oYC.oYw == 0L) {
        break label235;
      }
      f1 = (float)parame.oYC.oYv / (float)parame.oYC.oYw;
      break;
      label396:
      if (parame.oYC.oYw != 0L)
      {
        f1 = (float)parame.oYC.oYv / (float)parame.oYC.oYw;
        break label303;
        label429:
        if (f1 - f2 > 0.05F)
        {
          i = 1;
          continue;
        }
      }
      label444:
      i = 0;
    }
  }
  
  public final void c(com.tencent.mm.aw.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(137580);
    ab.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
    com.tencent.mm.aw.e locale = k.bVH().bVs();
    if (locale == null)
    {
      AppMethodBeat.o(137580);
      return;
    }
    if (locale.e(parame)) {
      this.paL.stopPlay();
    }
    this.paL.D(this.paL.oYI);
    if (paramBoolean) {
      this.paL.G(this.paL.oYI);
    }
    AppMethodBeat.o(137580);
  }
  
  public final void d(com.tencent.mm.aw.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(137581);
    com.tencent.mm.aw.e locale = k.bVH().bVs();
    if (locale == null)
    {
      AppMethodBeat.o(137581);
      return;
    }
    ab.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      d.a(this.paL, parame, 20);
    }
    while (locale.e(parame))
    {
      ab.i("MicroMsg.Music.MusicPlayer", "stop");
      this.paL.stopPlay();
      if (paramBoolean)
      {
        ab.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
        this.paL.b(locale, true);
        this.paL.pao = new com.tencent.mm.plugin.music.c.b(parame, com.tencent.mm.plugin.music.cache.e.Vh(parame.fKj));
        this.paL.pao.oYG = this.paL.paJ;
        this.paL.pao.start();
        if (this.paL.paA == null) {
          break label245;
        }
        this.paL.paA.a(this.paL.pao);
        AppMethodBeat.o(137581);
        return;
        d.a(this.paL, parame, 21);
      }
      else
      {
        al.d(new d.1.1(this));
        this.paL.D(this.paL.oYI);
        AppMethodBeat.o(137581);
        return;
      }
    }
    ab.i("MicroMsg.Music.MusicPlayer", "send stop event");
    this.paL.D(this.paL.oYI);
    label245:
    AppMethodBeat.o(137581);
  }
  
  public final void k(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(137578);
    ab.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
    this.paL.A(parame);
    AppMethodBeat.o(137578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.1
 * JD-Core Version:    0.7.0.1
 */