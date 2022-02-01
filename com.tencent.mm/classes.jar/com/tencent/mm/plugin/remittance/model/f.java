package com.tencent.mm.plugin.remittance.model;

import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ru;
import com.tencent.mm.f.a.ru.a;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.a.c;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  public static f Iln;
  public dae Ilm;
  
  static
  {
    AppMethodBeat.i(252625);
    Iln = new f();
    AppMethodBeat.o(252625);
  }
  
  private f()
  {
    AppMethodBeat.i(252617);
    this.Ilm = new dae();
    AppMethodBeat.o(252617);
  }
  
  public final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(252622);
    dab localdab = new dab();
    localdab.THy = paramString1;
    localdab.THx = paramString2;
    localdab.Inf = paramString3;
    localdab.gbJ = paramLong2;
    localdab.THw = (bq.beS() + 1000L * paramLong1);
    this.Ilm.THA.add(localdab);
    fAo();
    new a(paramLong1, localdab).start();
    AppMethodBeat.o(252622);
  }
  
  public final void fAo()
  {
    AppMethodBeat.i(252619);
    try
    {
      String str = Base64.encodeToString(this.Ilm.toByteArray(), 0);
      ((a)com.tencent.mm.kernel.h.ag(a.class)).getWalletCacheStg().set(ar.a.VEn, str);
      AppMethodBeat.o(252619);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MsgCheckTaskMgr", localException, "", new Object[0]);
      this.Ilm.THA.clear();
      AppMethodBeat.o(252619);
    }
  }
  
  public static final class a
    implements com.tencent.mm.an.i, MTimerHandler.CallBack
  {
    private boolean HdD;
    private long Ilo;
    private boolean Ilp;
    private dab Ilq;
    private int Ilr;
    private IListener<ru> Ils;
    private MTimerHandler timer;
    
    public a(long paramLong, dab paramdab)
    {
      AppMethodBeat.i(275152);
      this.Ilq = null;
      this.timer = null;
      this.Ils = new IListener()
      {
        private boolean a(ru paramAnonymousru)
        {
          AppMethodBeat.i(277402);
          if ((paramAnonymousru.fQX.fQY == null) || (!f.a.a(f.a.this).Inf.equals(paramAnonymousru.fQX.fJG)))
          {
            AppMethodBeat.o(277402);
            return false;
          }
          if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramAnonymousru.fQX.msgId).getType() != 419430449)
          {
            AppMethodBeat.o(277402);
            return false;
          }
          int i = paramAnonymousru.fQX.fQY.lnc;
          Log.i("MicroMsg.MsgCheckTaskMgr", "MsgCheck msgID:%s transeferID:%s paySubType:%s", new Object[] { Long.valueOf(paramAnonymousru.fQX.msgId), paramAnonymousru.fQX.fJG, Integer.valueOf(i) });
          if (((i == 3) || (i == 4) || (i == 5) || (i == 6)) && (!f.a.b(f.a.this))) {
            f.a.this.stop();
          }
          AppMethodBeat.o(277402);
          return false;
        }
      };
      this.Ilo = paramLong;
      this.Ilp = false;
      this.HdD = false;
      this.Ilq = paramdab;
      AppMethodBeat.o(275152);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(275156);
      if ((paramq instanceof aa))
      {
        paramString = (aa)paramq;
        if (paramString.Img.equals(this.Ilq.Inf))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.i("MicroMsg.MsgCheckTaskMgr", "MsgCheck retCode:%s retMsg:%s transferID:%s", new Object[] { Integer.valueOf(paramString.Imf.tqa), paramString.Imf.tqb, this.Ilq.Inf });
            if (paramString.Imf.tqa == 0)
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(23016, new Object[] { Integer.valueOf(1), this.Ilq.Inf });
              c.fzJ().fzM();
              ak.kc(this.Ilq.THy, paramString.Imf.THz);
            }
          }
          stop();
          AppMethodBeat.o(275156);
          return;
        }
        AppMethodBeat.o(275156);
        return;
      }
      AppMethodBeat.o(275156);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(275155);
      if (this.Ilr == 1)
      {
        Log.i("MicroMsg.MsgCheckTaskMgr", "onTimerExpired, do MsgCheck scene, transferID:%s", new Object[] { this.Ilq.Inf });
        this.HdD = true;
        aa localaa = new aa(this.Ilq.Inf, this.Ilq.gbJ, this.Ilq.THx);
        com.tencent.mm.kernel.h.aGY().a(localaa, 0);
        this.Ilr = 2;
        this.timer.startTimer(18000L);
      }
      for (;;)
      {
        AppMethodBeat.o(275155);
        return true;
        if (this.Ilr == 2) {
          stop();
        }
      }
    }
    
    public final void start()
    {
      AppMethodBeat.i(275153);
      com.tencent.mm.kernel.h.aGY().a(6230, this);
      this.Ils.alive();
      this.Ilp = true;
      Log.i("MicroMsg.MsgCheckTaskMgr", "start MsgCheckTask %s after %s", new Object[] { this.Ilq.Inf, Long.valueOf(this.Ilo) });
      this.Ilr = 1;
      if (this.timer == null) {
        this.timer = new MTimerHandler(Looper.getMainLooper(), this, false);
      }
      this.timer.startTimer(this.Ilo * 1000L);
      AppMethodBeat.o(275153);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(275154);
      com.tencent.mm.kernel.h.aGY().b(6230, this);
      this.Ils.dead();
      if ((this.timer != null) && (!this.timer.stopped()))
      {
        this.timer.stopTimer();
        this.Ilp = false;
        this.HdD = false;
      }
      f localf = f.Iln;
      String str = this.Ilq.Inf;
      Iterator localIterator = localf.Ilm.THA.iterator();
      dab localdab;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localdab = (dab)localIterator.next();
      } while (!str.equals(localdab.Inf));
      for (;;)
      {
        localf.Ilm.THA.remove(localdab);
        localf.fAo();
        AppMethodBeat.o(275154);
        return;
        localdab = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.f
 * JD-Core Version:    0.7.0.1
 */