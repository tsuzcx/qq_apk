package com.tencent.mm.plugin.subapp.d;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class j
  implements g
{
  private static int cZH = 0;
  Queue<String> cZA;
  Queue<String> cZB;
  Map<String, f.a> cZC;
  private boolean cZD;
  private boolean cZE;
  int cZF;
  private long cZG;
  f.a cZJ;
  private av cZK;
  private boolean running;
  
  public j()
  {
    AppMethodBeat.i(28989);
    this.cZA = new LinkedList();
    this.cZB = new LinkedList();
    this.cZC = new HashMap();
    this.cZD = false;
    this.cZE = false;
    this.running = false;
    this.cZF = 0;
    this.cZG = 0L;
    this.cZJ = new f.a();
    this.cZK = new av(az.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28988);
        ad.d("MicroMsg.VoiceRemindService", "onTimerExpired");
        try
        {
          j.h(j.this);
          AppMethodBeat.o(28988);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.VoiceRemindService", localException, "", new Object[0]);
          }
        }
      }
    }, false);
    az.aeS().a(329, this);
    AppMethodBeat.o(28989);
  }
  
  private void Oy()
  {
    AppMethodBeat.i(28991);
    this.cZC.clear();
    this.cZA.clear();
    this.cZB.clear();
    this.cZE = false;
    this.cZD = false;
    this.running = false;
    ad.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.cZJ.XK());
    AppMethodBeat.o(28991);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(28990);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28986);
        j.access$008();
        String str;
        int i;
        if (paramn.getType() == 128)
        {
          j.a(j.this);
          str = ((e)paramn).fileName;
          i = ((e)paramn).retCode;
          long l2 = 0L;
          long l1 = l2;
          if (str != null)
          {
            l1 = l2;
            if (j.this.cZC.get(str) != null)
            {
              l1 = ((f.a)j.this.cZC.get(str)).XK();
              j.this.cZC.remove(str);
            }
          }
          ad.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
          if ((paramInt1 != 3) || (i == 0)) {
            break label416;
          }
          j.c(j.this);
          label220:
          ad.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.cZH + " stop:" + j.d(j.this) + " running:" + j.e(j.this) + " recving:" + j.f(j.this) + " sending:" + j.g(j.this));
          if (j.d(j.this) <= 0) {
            break label435;
          }
          j.h(j.this);
        }
        for (;;)
        {
          j.Oz();
          AppMethodBeat.o(28986);
          return;
          if (paramn.getType() == 329)
          {
            j.b(j.this);
            str = ((b)paramn).fileName;
            i = ((b)paramn).retCode;
            break;
          }
          ad.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + paramn.getType());
          j.Oz();
          AppMethodBeat.o(28986);
          return;
          label416:
          if (paramInt1 == 0) {
            break label220;
          }
          j.a(j.this, 0);
          break label220;
          label435:
          if ((!j.g(j.this)) && (!j.f(j.this))) {
            j.i(j.this);
          }
        }
      }
    });
    AppMethodBeat.o(28990);
  }
  
  public final void run()
  {
    AppMethodBeat.i(28992);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28987);
        long l = System.currentTimeMillis() - j.j(j.this);
        ad.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.e(j.this) + " timeWait:" + l + " sending:" + j.g(j.this) + " recving:" + j.f(j.this));
        if (j.e(j.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(28987);
            return;
          }
          ad.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.e(j.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + j.g(j.this) + " recving:" + j.f(j.this));
        }
        j.k(j.this);
        j.b(j.this);
        j.a(j.this, 3);
        j.a(j.this);
        j.this.cZJ.fGp = SystemClock.elapsedRealtime();
        j.l(j.this).av(10L, 10L);
        AppMethodBeat.o(28987);
      }
    });
    AppMethodBeat.o(28992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.j
 * JD-Core Version:    0.7.0.1
 */