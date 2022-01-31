package com.tencent.mm.plugin.music.f;

import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements f
{
  long mAG;
  
  d$1(d paramd) {}
  
  public final void I(com.tencent.mm.av.e parame)
  {
    com.tencent.mm.av.e locale = k.bnl().bmW();
    if (locale == null) {}
    int j;
    int k;
    do
    {
      do
      {
        return;
      } while ((!locale.e(parame)) || (this.mAH.mAC == null) || (!this.mAH.mAC.isPlaying()));
      j = this.mAH.mAC.bnF();
      k = this.mAH.mAC.getDuration();
    } while ((j <= 0) || (k <= 0));
    float f2 = j / k;
    float f1;
    label168:
    label225:
    int i;
    if (this.mAH.mAi != null)
    {
      parame = this.mAH.mAi;
      parame.myw = f2;
      boolean bool = aq.isNetworkConnected(ae.getContext());
      if ((parame.isStop) && (bool))
      {
        if (!parame.kaC) {
          break label348;
        }
        if (parame.myv.mys != 0L)
        {
          f1 = (float)parame.myv.myq / (float)parame.myv.mys;
          if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
          {
            y.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
            parame.start();
          }
        }
      }
      if ((this.mAH.mAi != null) && (this.mAH.mAi.isStop))
      {
        parame = this.mAH.mAi;
        if (!parame.kaC) {
          break label381;
        }
        if (parame.myv.mys == 0L) {
          break label429;
        }
        f1 = (float)parame.myv.myq / (float)parame.myv.mys;
        label293:
        if (f1 < 1.0F) {
          break label414;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        y.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
        this.mAH.stopPlay();
      }
      if (this.mAH.mxn == null) {
        break;
      }
      this.mAH.mxn.cy(j, k);
      return;
      label348:
      if (parame.myv.myp == 0L) {
        break label225;
      }
      f1 = (float)parame.myv.myo / (float)parame.myv.myp;
      break label168;
      label381:
      if (parame.myv.myp != 0L)
      {
        f1 = (float)parame.myv.myo / (float)parame.myv.myp;
        break label293;
        if (f1 - f2 > 0.05F)
        {
          i = 1;
          continue;
        }
      }
      label414:
      label429:
      i = 0;
    }
  }
  
  public final void b(com.tencent.mm.av.e parame, boolean paramBoolean)
  {
    y.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
    com.tencent.mm.av.e locale = k.bnl().bmW();
    if (locale == null) {}
    do
    {
      return;
      if (locale.e(parame)) {
        this.mAH.stopPlay();
      }
      this.mAH.D(this.mAH.myB);
    } while (!paramBoolean);
    this.mAH.G(this.mAH.myB);
  }
  
  public final void c(com.tencent.mm.av.e parame, boolean paramBoolean)
  {
    com.tencent.mm.av.e locale = k.bnl().bmW();
    if (locale == null) {
      return;
    }
    y.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      d.a(this.mAH, parame, 20);
    }
    for (;;)
    {
      if (locale.e(parame))
      {
        y.i("MicroMsg.Music.MusicPlayer", "stop");
        this.mAH.stopPlay();
        if (paramBoolean)
        {
          y.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
          this.mAH.a(locale, true);
          this.mAH.mAi = new com.tencent.mm.plugin.music.c.b(parame, com.tencent.mm.plugin.music.cache.e.Jk(parame.eux));
          this.mAH.mAi.myz = this.mAH.mAF;
          this.mAH.mAi.start();
          if (this.mAH.mAu == null) {
            break;
          }
          this.mAH.mAu.a(this.mAH.mAi);
          return;
          d.a(this.mAH, parame, 21);
          continue;
        }
        ai.d(new d.1.1(this));
        this.mAH.D(this.mAH.myB);
        return;
      }
    }
    y.i("MicroMsg.Music.MusicPlayer", "send stop event");
    this.mAH.D(this.mAH.myB);
  }
  
  public final void k(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
    this.mAH.A(parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.1
 * JD-Core Version:    0.7.0.1
 */