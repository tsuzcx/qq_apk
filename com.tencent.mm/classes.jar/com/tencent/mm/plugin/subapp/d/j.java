package com.tencent.mm.plugin.subapp.d;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class j
  implements f
{
  private static int djw = 0;
  Queue<String> djp;
  Queue<String> djq;
  Map<String, f.a> djr;
  private boolean djs;
  private boolean djt;
  int dju;
  private long djv;
  f.a djy;
  private aw djz;
  private boolean running;
  
  public j()
  {
    AppMethodBeat.i(28989);
    this.djp = new LinkedList();
    this.djq = new LinkedList();
    this.djr = new HashMap();
    this.djs = false;
    this.djt = false;
    this.running = false;
    this.dju = 0;
    this.djv = 0L;
    this.djy = new f.a();
    this.djz = new aw(bc.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28988);
        ae.d("MicroMsg.VoiceRemindService", "onTimerExpired");
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
            ae.printErrStackTrace("MicroMsg.VoiceRemindService", localException, "", new Object[0]);
          }
        }
      }
    }, false);
    bc.ajj().a(329, this);
    AppMethodBeat.o(28989);
  }
  
  private void Qd()
  {
    AppMethodBeat.i(28991);
    this.djr.clear();
    this.djp.clear();
    this.djq.clear();
    this.djt = false;
    this.djs = false;
    this.running = false;
    ae.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.djy.abs());
    AppMethodBeat.o(28991);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(28990);
    bc.ajU().aw(new Runnable()
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
            if (j.this.djr.get(str) != null)
            {
              l1 = ((f.a)j.this.djr.get(str)).abs();
              j.this.djr.remove(str);
            }
          }
          ae.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
          if ((paramInt1 != 3) || (i == 0)) {
            break label416;
          }
          j.c(j.this);
          label220:
          ae.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.djw + " stop:" + j.d(j.this) + " running:" + j.e(j.this) + " recving:" + j.f(j.this) + " sending:" + j.g(j.this));
          if (j.d(j.this) <= 0) {
            break label435;
          }
          j.h(j.this);
        }
        for (;;)
        {
          j.bKJ();
          AppMethodBeat.o(28986);
          return;
          if (paramn.getType() == 329)
          {
            j.b(j.this);
            str = ((b)paramn).fileName;
            i = ((b)paramn).retCode;
            break;
          }
          ae.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + paramn.getType());
          j.bKJ();
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
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28987);
        long l = System.currentTimeMillis() - j.j(j.this);
        ae.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.e(j.this) + " timeWait:" + l + " sending:" + j.g(j.this) + " recving:" + j.f(j.this));
        if (j.e(j.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(28987);
            return;
          }
          ae.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.e(j.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + j.g(j.this) + " recving:" + j.f(j.this));
        }
        j.k(j.this);
        j.b(j.this);
        j.a(j.this, 3);
        j.a(j.this);
        j.this.djy.gfF = SystemClock.elapsedRealtime();
        j.l(j.this).ay(10L, 10L);
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