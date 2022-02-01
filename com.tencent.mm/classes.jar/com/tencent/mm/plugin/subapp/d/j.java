package com.tencent.mm.plugin.subapp.d;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class j
  implements g
{
  private static int cXd = 0;
  Queue<String> cWW;
  Queue<String> cWX;
  Map<String, f.a> cWY;
  private boolean cWZ;
  private boolean cXa;
  int cXb;
  private long cXc;
  f.a cXf;
  private au cXg;
  private boolean running;
  
  public j()
  {
    AppMethodBeat.i(28989);
    this.cWW = new LinkedList();
    this.cWX = new LinkedList();
    this.cWY = new HashMap();
    this.cWZ = false;
    this.cXa = false;
    this.running = false;
    this.cXb = 0;
    this.cXc = 0L;
    this.cXf = new f.a();
    this.cXg = new au(az.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28988);
        ac.d("MicroMsg.VoiceRemindService", "onTimerExpired");
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
            ac.printErrStackTrace("MicroMsg.VoiceRemindService", localException, "", new Object[0]);
          }
        }
      }
    }, false);
    az.agi().a(329, this);
    AppMethodBeat.o(28989);
  }
  
  private void Ou()
  {
    AppMethodBeat.i(28991);
    this.cWY.clear();
    this.cWW.clear();
    this.cWX.clear();
    this.cXa = false;
    this.cWZ = false;
    this.running = false;
    ac.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.cXf.YH());
    AppMethodBeat.o(28991);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(28990);
    az.agU().az(new Runnable()
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
            if (j.this.cWY.get(str) != null)
            {
              l1 = ((f.a)j.this.cWY.get(str)).YH();
              j.this.cWY.remove(str);
            }
          }
          ac.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
          if ((paramInt1 != 3) || (i == 0)) {
            break label416;
          }
          j.c(j.this);
          label220:
          ac.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.cXd + " stop:" + j.d(j.this) + " running:" + j.e(j.this) + " recving:" + j.f(j.this) + " sending:" + j.g(j.this));
          if (j.d(j.this) <= 0) {
            break label435;
          }
          j.h(j.this);
        }
        for (;;)
        {
          j.Ov();
          AppMethodBeat.o(28986);
          return;
          if (paramn.getType() == 329)
          {
            j.b(j.this);
            str = ((b)paramn).fileName;
            i = ((b)paramn).retCode;
            break;
          }
          ac.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + paramn.getType());
          j.Ov();
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
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28987);
        long l = System.currentTimeMillis() - j.j(j.this);
        ac.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.e(j.this) + " timeWait:" + l + " sending:" + j.g(j.this) + " recving:" + j.f(j.this));
        if (j.e(j.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(28987);
            return;
          }
          ac.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.e(j.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + j.g(j.this) + " recving:" + j.f(j.this));
        }
        j.k(j.this);
        j.b(j.this);
        j.a(j.this, 3);
        j.a(j.this);
        j.this.cXf.fJW = SystemClock.elapsedRealtime();
        j.l(j.this).au(10L, 10L);
        AppMethodBeat.o(28987);
      }
    });
    AppMethodBeat.o(28992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.j
 * JD-Core Version:    0.7.0.1
 */