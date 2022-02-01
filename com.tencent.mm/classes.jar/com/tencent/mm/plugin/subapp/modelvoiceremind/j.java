package com.tencent.mm.plugin.subapp.modelvoiceremind;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class j
  implements h
{
  private static int pae = 0;
  Queue<String> hxE;
  Queue<String> hxF;
  Map<String, f.a> hxG;
  private boolean hxH;
  private boolean hxI;
  int hxJ;
  private long hxK;
  f.a hxM;
  private MTimerHandler hxN;
  private boolean running;
  
  public j()
  {
    AppMethodBeat.i(28989);
    this.hxE = new LinkedList();
    this.hxF = new LinkedList();
    this.hxG = new HashMap();
    this.hxH = false;
    this.hxI = false;
    this.running = false;
    this.hxJ = 0;
    this.hxK = 0L;
    this.hxM = new f.a();
    this.hxN = new MTimerHandler(bh.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28988);
        Log.d("MicroMsg.VoiceRemindService", "onTimerExpired");
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
            Log.printErrStackTrace("MicroMsg.VoiceRemindService", localException, "", new Object[0]);
          }
        }
      }
    }, false);
    bh.aZW().a(329, this);
    AppMethodBeat.o(28989);
  }
  
  private void aHh()
  {
    AppMethodBeat.i(28991);
    this.hxG.clear();
    this.hxE.clear();
    this.hxF.clear();
    this.hxI = false;
    this.hxH = false;
    this.running = false;
    Log.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.hxM.aPY());
    AppMethodBeat.o(28991);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(28990);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28986);
        j.access$008();
        String str;
        int i;
        if (paramp.getType() == 128)
        {
          j.a(j.this);
          str = ((e)paramp).fileName;
          i = ((e)paramp).retCode;
          long l2 = 0L;
          long l1 = l2;
          if (str != null)
          {
            l1 = l2;
            if (j.this.hxG.get(str) != null)
            {
              l1 = ((f.a)j.this.hxG.get(str)).aPY();
              j.this.hxG.remove(str);
            }
          }
          Log.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + paramp.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
          if ((paramInt1 != 3) || (i == 0)) {
            break label416;
          }
          j.c(j.this);
          label220:
          Log.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.pae + " stop:" + j.d(j.this) + " running:" + j.e(j.this) + " recving:" + j.f(j.this) + " sending:" + j.g(j.this));
          if (j.d(j.this) <= 0) {
            break label435;
          }
          j.h(j.this);
        }
        for (;;)
        {
          j.cXx();
          AppMethodBeat.o(28986);
          return;
          if (paramp.getType() == 329)
          {
            j.b(j.this);
            str = ((b)paramp).fileName;
            i = ((b)paramp).retCode;
            break;
          }
          Log.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + paramp.getType());
          j.cXx();
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
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28987);
        long l = System.currentTimeMillis() - j.j(j.this);
        Log.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.e(j.this) + " timeWait:" + l + " sending:" + j.g(j.this) + " recving:" + j.f(j.this));
        if (j.e(j.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(28987);
            return;
          }
          Log.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.e(j.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + j.g(j.this) + " recving:" + j.f(j.this));
        }
        j.k(j.this);
        j.b(j.this);
        j.a(j.this, 3);
        j.a(j.this);
        j.this.hxM.lYS = SystemClock.elapsedRealtime();
        j.l(j.this).startTimer(10L);
        AppMethodBeat.o(28987);
      }
    });
    AppMethodBeat.o(28992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.j
 * JD-Core Version:    0.7.0.1
 */