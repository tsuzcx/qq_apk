package com.tencent.mm.plugin.subapp.d;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
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
  implements i
{
  private static int mgU = 0;
  Queue<String> ftp;
  Queue<String> ftq;
  Map<String, f.a> ftr;
  private boolean fts;
  private boolean ftt;
  int ftu;
  private long ftv;
  f.a ftx;
  private MTimerHandler fty;
  private boolean running;
  
  public j()
  {
    AppMethodBeat.i(28989);
    this.ftp = new LinkedList();
    this.ftq = new LinkedList();
    this.ftr = new HashMap();
    this.fts = false;
    this.ftt = false;
    this.running = false;
    this.ftu = 0;
    this.ftv = 0L;
    this.ftx = new f.a();
    this.fty = new MTimerHandler(bh.aHJ().getLooper(), new MTimerHandler.CallBack()
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
    bh.aGY().a(329, this);
    AppMethodBeat.o(28989);
  }
  
  private void afk()
  {
    AppMethodBeat.i(28991);
    this.ftr.clear();
    this.ftp.clear();
    this.ftq.clear();
    this.ftt = false;
    this.fts = false;
    this.running = false;
    Log.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.ftx.avE());
    AppMethodBeat.o(28991);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(28990);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28986);
        j.access$008();
        String str;
        int i;
        if (paramq.getType() == 128)
        {
          j.a(j.this);
          str = ((e)paramq).fileName;
          i = ((e)paramq).retCode;
          long l2 = 0L;
          long l1 = l2;
          if (str != null)
          {
            l1 = l2;
            if (j.this.ftr.get(str) != null)
            {
              l1 = ((f.a)j.this.ftr.get(str)).avE();
              j.this.ftr.remove(str);
            }
          }
          Log.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + paramq.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
          if ((paramInt1 != 3) || (i == 0)) {
            break label416;
          }
          j.c(j.this);
          label220:
          Log.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.mgU + " stop:" + j.d(j.this) + " running:" + j.e(j.this) + " recving:" + j.f(j.this) + " sending:" + j.g(j.this));
          if (j.d(j.this) <= 0) {
            break label435;
          }
          j.h(j.this);
        }
        for (;;)
        {
          j.cuN();
          AppMethodBeat.o(28986);
          return;
          if (paramq.getType() == 329)
          {
            j.b(j.this);
            str = ((b)paramq).fileName;
            i = ((b)paramq).retCode;
            break;
          }
          Log.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + paramq.getType());
          j.cuN();
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
    bh.aHJ().postToWorker(new Runnable()
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
        j.this.ftx.jvB = SystemClock.elapsedRealtime();
        j.l(j.this).startTimer(10L);
        AppMethodBeat.o(28987);
      }
    });
    AppMethodBeat.o(28992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.j
 * JD-Core Version:    0.7.0.1
 */