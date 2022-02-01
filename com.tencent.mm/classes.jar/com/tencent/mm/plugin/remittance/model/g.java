package com.tencent.mm.plugin.remittance.model;

import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.tj;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.remittance.app.c;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.protocal.protobuf.drl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public static g Oie;
  public drl Oid;
  
  static
  {
    AppMethodBeat.i(288822);
    Oie = new g();
    AppMethodBeat.o(288822);
  }
  
  private g()
  {
    AppMethodBeat.i(288817);
    this.Oid = new drl();
    AppMethodBeat.o(288817);
  }
  
  public final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(288834);
    dri localdri = new dri();
    localdri.aaXh = paramString1;
    localdri.aaXg = paramString2;
    localdri.Okt = paramString3;
    localdri.ihV = paramLong2;
    localdri.aaXf = (br.bCJ() + 1000L * paramLong1);
    this.Oid.aaXj.add(localdri);
    gMa();
    new a(paramLong1, localdri).start();
    AppMethodBeat.o(288834);
  }
  
  public final void gMa()
  {
    AppMethodBeat.i(288826);
    try
    {
      String str = Base64.encodeToString(this.Oid.toByteArray(), 0);
      ((a)com.tencent.mm.kernel.h.az(a.class)).getWalletCacheStg().set(at.a.adhK, str);
      AppMethodBeat.o(288826);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MsgCheckTaskMgr", localException, "", new Object[0]);
      this.Oid.aaXj.clear();
      AppMethodBeat.o(288826);
    }
  }
  
  public static final class a
    implements com.tencent.mm.am.h, MTimerHandler.CallBack
  {
    private boolean NdK;
    private long Oif;
    private boolean Oig;
    private dri Oih;
    private int Oii;
    private IListener<tj> Oij;
    private MTimerHandler timer;
    
    public a(long paramLong, dri paramdri)
    {
      AppMethodBeat.i(288775);
      this.Oih = null;
      this.timer = null;
      this.Oij = new MsgCheckTaskMgr.MsgCheckTask.1(this, f.hfK);
      this.Oif = paramLong;
      this.Oig = false;
      this.NdK = false;
      this.Oih = paramdri;
      AppMethodBeat.o(288775);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(288790);
      if ((paramp instanceof ab))
      {
        paramString = (ab)paramp;
        if (paramString.Ojx.equals(this.Oih.Okt))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.i("MicroMsg.MsgCheckTaskMgr", "MsgCheck retCode:%s retMsg:%s transferID:%s", new Object[] { Integer.valueOf(paramString.Ojw.wuz), paramString.Ojw.wuA, this.Oih.Okt });
            if (paramString.Ojw.wuz == 0)
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(23016, new Object[] { Integer.valueOf(1), this.Oih.Okt });
              c.gLv().gLy();
              am.ly(this.Oih.aaXh, paramString.Ojw.aaXi);
            }
          }
          stop();
          AppMethodBeat.o(288790);
          return;
        }
        AppMethodBeat.o(288790);
        return;
      }
      AppMethodBeat.o(288790);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(288786);
      if (this.Oii == 1)
      {
        Log.i("MicroMsg.MsgCheckTaskMgr", "onTimerExpired, do MsgCheck scene, transferID:%s", new Object[] { this.Oih.Okt });
        this.NdK = true;
        ab localab = new ab(this.Oih.Okt, this.Oih.ihV, this.Oih.aaXg);
        com.tencent.mm.kernel.h.aZW().a(localab, 0);
        this.Oii = 2;
        this.timer.startTimer(18000L);
      }
      for (;;)
      {
        AppMethodBeat.o(288786);
        return true;
        if (this.Oii == 2) {
          stop();
        }
      }
    }
    
    public final void start()
    {
      AppMethodBeat.i(288780);
      com.tencent.mm.kernel.h.aZW().a(6230, this);
      this.Oij.alive();
      this.Oig = true;
      Log.i("MicroMsg.MsgCheckTaskMgr", "start MsgCheckTask %s after %s", new Object[] { this.Oih.Okt, Long.valueOf(this.Oif) });
      this.Oii = 1;
      if (this.timer == null) {
        this.timer = new MTimerHandler(Looper.getMainLooper(), this, false);
      }
      this.timer.startTimer(this.Oif * 1000L);
      AppMethodBeat.o(288780);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(288784);
      com.tencent.mm.kernel.h.aZW().b(6230, this);
      this.Oij.dead();
      if ((this.timer != null) && (!this.timer.stopped()))
      {
        this.timer.stopTimer();
        this.Oig = false;
        this.NdK = false;
      }
      g localg = g.Oie;
      String str = this.Oih.Okt;
      Iterator localIterator = localg.Oid.aaXj.iterator();
      dri localdri;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localdri = (dri)localIterator.next();
      } while (!str.equals(localdri.Okt));
      for (;;)
      {
        localg.Oid.aaXj.remove(localdri);
        localg.gMa();
        AppMethodBeat.o(288784);
        return;
        localdri = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.g
 * JD-Core Version:    0.7.0.1
 */