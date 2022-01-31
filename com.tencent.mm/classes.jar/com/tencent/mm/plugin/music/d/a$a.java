package com.tencent.mm.plugin.music.d;

import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.h.q.c;
import com.google.android.exoplayer2.h.q.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class a$a
  implements f.a
{
  private a$a(a parama) {}
  
  public final void a(e parame)
  {
    y.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + this.myP.bmP() + "]", new Object[0]);
    a locala = this.myP;
    Object localObject;
    if (parame != null)
    {
      localObject = parame.getCause();
      if (localObject == null) {
        break label336;
      }
      if (!(localObject instanceof q.c)) {
        break label268;
      }
      if (((Throwable)localObject).toString().contains("Unable to connect"))
      {
        boolean bool = aq.isNetworkConnected(ae.getContext());
        y.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + bool + " caused by:\n" + ((Throwable)localObject).toString());
        if (!bool)
        {
          locala.jdMethod_do(-4000, -2);
          return;
        }
        locala.jdMethod_do(-4000, -3);
        return;
      }
      if ((localObject instanceof q.e))
      {
        localObject = ((Throwable)localObject).toString();
        if (!((String)localObject).contains("403")) {
          break label190;
        }
        locala.jdMethod_do(-4000, -10);
      }
    }
    label268:
    for (;;)
    {
      y.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "ExoPlaybackException", new Object[0]);
      return;
      label190:
      if (((String)localObject).contains("404"))
      {
        locala.jdMethod_do(-4000, -11);
      }
      else if (((String)localObject).contains("500"))
      {
        locala.jdMethod_do(-4000, -12);
      }
      else if (((String)localObject).contains("502"))
      {
        locala.jdMethod_do(-4000, -13);
      }
      else
      {
        locala.jdMethod_do(-4000, -30);
        continue;
        if ((localObject instanceof n))
        {
          locala.jdMethod_do(-4001, -1);
        }
        else if ((localObject instanceof IllegalStateException))
        {
          locala.jdMethod_do(-4002, -1);
        }
        else if ((localObject instanceof b.a))
        {
          locala.jdMethod_do(-4003, -1);
        }
        else
        {
          locala.jdMethod_do(-4999, -1);
          continue;
          label336:
          locala.jdMethod_do(-4999, -1);
        }
      }
    }
  }
  
  public final void a(p paramp)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.auT), Float.valueOf(paramp.pitch) }));
  }
  
  public final void aw(boolean paramBoolean)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
  }
  
  public final void b(boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "state [" + this.myP.bmP() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.f.b.a.uX(paramInt) + "]");
    a locala = this.myP;
    if (locala.myE != null)
    {
      paramBoolean = locala.myE.kE();
      paramInt = locala.myE.kD();
      if ((!paramBoolean) || (paramInt != 3)) {
        break label219;
      }
      y.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
      if (locala.myN != null) {
        locala.myN.bmR();
      }
      int i = a.f.t(paramBoolean, paramInt);
      if (i != locala.myJ.myQ[3])
      {
        y.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
        locala.myJ.s(paramBoolean, paramInt);
        if (i != a.f.t(true, 4)) {
          break label311;
        }
        y.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
        if (locala.myN != null) {
          locala.myN.bmV();
        }
      }
    }
    label219:
    label376:
    do
    {
      do
      {
        do
        {
          return;
          if ((!paramBoolean) && (paramInt == 3) && (locala.myD == 2))
          {
            y.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (locala.myN == null) {
              break;
            }
            locala.myN.bmS();
            break;
          }
          if ((paramBoolean) || (paramInt != 3) || (locala.myD != 3)) {
            break;
          }
          y.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
          if (locala.myN == null) {
            break;
          }
          locala.myN.bmT();
          break;
          if (!locala.myJ.b(new int[] { a.f.t(false, 1), a.f.t(false, 2), a.f.t(false, 3) }, false)) {
            break label376;
          }
          y.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
        } while (locala.myN == null);
        locala.myN.bmQ();
        return;
        if (!(locala.myJ.b(new int[] { 100, 2, 3 }, true) | locala.myJ.b(new int[] { 2, 100, 3 }, true) | locala.myJ.b(new int[] { 100, 3, 2, 3 }, true))) {
          break label486;
        }
        y.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
      } while (locala.myN == null);
      locala.myN.bmU();
      return;
      if (locala.myJ.b(new int[] { a.f.t(true, 3), a.f.t(true, 2) }, false))
      {
        y.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
        locala.dp(701, locala.getDownloadPercent());
        return;
      }
    } while (!locala.myJ.b(new int[] { a.f.t(true, 2), a.f.t(true, 3) }, false));
    label311:
    label486:
    y.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
    locala.dp(702, locala.getDownloadPercent());
  }
  
  public final void kT()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a.a
 * JD-Core Version:    0.7.0.1
 */