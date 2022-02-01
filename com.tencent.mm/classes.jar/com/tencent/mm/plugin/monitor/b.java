package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class b
  implements aw
{
  private static final long startTime;
  private k.a gQD;
  private boolean npp;
  private boolean npq;
  private BroadcastReceiver npr;
  private com.tencent.mm.sdk.b.c sut;
  private long tMD;
  private long tME;
  private long tMF;
  private long tMG;
  private long tMH;
  private long tMI;
  private long tMJ;
  private long tMK;
  private long tML;
  private long tMM;
  private long tMN;
  private long tMO;
  private com.tencent.e.i.b tMP;
  private a.a tMQ;
  private long tMR;
  private com.tencent.mm.al.g tMS;
  private com.tencent.e.i.b tMT;
  private com.tencent.e.i.b tMU;
  private av tMV;
  private av tMW;
  
  static
  {
    AppMethodBeat.i(51537);
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(51537);
  }
  
  public b()
  {
    AppMethodBeat.i(51518);
    this.tMD = 1024L;
    this.tME = 10L;
    this.tMF = 1800L;
    this.tMG = 3000000L;
    this.tMH = 15000L;
    this.tMI = 100000L;
    this.tMJ = 10000L;
    this.tMK = 1024L;
    this.tML = 1440L;
    this.tMM = 15L;
    this.tMN = 1440L;
    this.npp = false;
    this.npq = true;
    this.tMO = 0L;
    this.tMR = 0L;
    this.tMS = new b.1(this);
    this.gQD = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(51508);
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { bt.eGN() });
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
          com.tencent.e.h.Iye.q(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(51507);
              b.a(b.this);
              AppMethodBeat.o(51507);
            }
          }, 100L);
        }
        AppMethodBeat.o(51508);
      }
    };
    this.tMT = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "reportAllRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51509);
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        if (!com.tencent.mm.kernel.g.afw())
        {
          ad.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
          AppMethodBeat.o(51509);
          return;
        }
        b.b(b.this);
        b.c(b.this);
        b.d(b.this);
        b.e(b.this);
        b.f(b.this);
        b.g(b.this).cancel();
        com.tencent.e.h.Iye.q(b.g(b.this), 10000L);
        AppMethodBeat.o(51509);
      }
    };
    this.tMU = new b.11(this);
    this.sut = new b.12(this);
    this.tMV = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(51512);
        b.e(b.this);
        AppMethodBeat.o(51512);
        return true;
      }
    }, true);
    this.tMW = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new b.14(this), true);
    AppMethodBeat.o(51518);
  }
  
  private a.a a(com.tencent.mm.vfs.e parame, a.a parama, a.b paramb, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(51523);
    if (parama.hls)
    {
      ad.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb });
      AppMethodBeat.o(51523);
      return parama;
    }
    if (parama.btK < paramInt) {
      parama.btK += 1;
    }
    Object localObject2;
    if (parame.isDirectory())
    {
      localObject2 = com.tencent.mm.vfs.q.B(parame.fhU());
      if (paramb != null) {
        break label943;
      }
      if ((paramMap != null) && (paramMap.size() > 0) && (paramMap.get(localObject2) != null))
      {
        paramb = new a.b((String)localObject2, ((Integer)paramMap.get(localObject2)).intValue());
        paramMap.remove(localObject2);
        localObject1 = paramb;
        if (paramb != null)
        {
          parama.tMA.add(paramb);
          ad.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject2, parama, paramb });
        }
      }
    }
    label940:
    label943:
    for (Object localObject1 = paramb;; localObject1 = paramb)
    {
      parama.tMy += 1L;
      if (localObject1 != null) {
        ((a.b)localObject1).tMy += 1L;
      }
      if (paramc != null) {
        paramc.tMy += 1L;
      }
      int i;
      if (paramInt > 15)
      {
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.vfs.q.B(parame.fhU()), parama });
        AppMethodBeat.o(51523);
        return parama;
        localObject1 = parame.getParent();
        if (com.tencent.mm.loader.j.b.aih().equals((String)localObject1 + "/")) {
          i = 1;
        }
        for (;;)
        {
          if ((i != 0) && (!ahj((String)localObject2)))
          {
            if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", parame.getName()))
            {
              paramb = new a.b((String)localObject2, 202);
              break;
              i = 0;
              continue;
            }
            if (Pattern.matches("[a-fA-F0-9]{32}", parame.getName()))
            {
              paramb = new a.b((String)localObject2, 201);
              break;
            }
            paramb = new a.b((String)localObject2, 203);
            break;
          }
        }
        if (!ahj(parame.getParent())) {
          break label940;
        }
        paramb = new a.b((String)localObject2, 203);
        break;
      }
      localObject2 = parame.list();
      if (localObject2 != null)
      {
        if (paramBoolean)
        {
          j = localObject2.length;
          i = 0;
          for (paramb = paramc; i < j; paramb = paramc)
          {
            String str = localObject2[i];
            paramc = paramb;
            if (!bt.isNullOrNil(str))
            {
              paramc = paramb;
              if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str))
              {
                paramc = new a.c(com.tencent.mm.vfs.q.B(parame.fhU()) + "/" + str);
                parama.tMB.add(paramc);
              }
            }
            a(new com.tencent.mm.vfs.e(com.tencent.mm.vfs.q.B(parame.mUri) + "/" + str), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
            i += 1;
          }
        }
        int j = localObject2.length;
        i = 0;
        while (i < j)
        {
          paramb = localObject2[i];
          a(new com.tencent.mm.vfs.e(com.tencent.mm.vfs.q.B(parame.fhU()) + "/" + paramb), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
          i += 1;
        }
      }
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { com.tencent.mm.vfs.q.B(parame.fhU()) });
      AppMethodBeat.o(51523);
      return parama;
      parama.tMz += 1L;
      if (paramb != null) {
        paramb.tMz += 1L;
      }
      if (paramc != null) {
        paramc.tMz += 1L;
      }
      if (!parame.exists())
      {
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { com.tencent.mm.vfs.q.B(parame.fhU()), Long.valueOf(parama.tMz) });
        AppMethodBeat.o(51523);
        return parama;
      }
      long l = parame.length();
      if ((l > 0L) && (l < 2147483648L))
      {
        parama.mqq += l;
        if (paramb != null) {
          paramb.mqq += l;
        }
        if (paramc != null) {
          paramc.mqq = (l + paramc.mqq);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(51523);
        return parama;
        parama.fileLenInvalidCount += 1L;
        if (paramb != null) {
          paramb.fileLenInvalidCount += 1L;
        }
        if (paramc != null) {
          paramc.tMC += 1L;
        }
      }
      break;
    }
  }
  
  private static boolean ahj(String paramString)
  {
    AppMethodBeat.i(51522);
    com.tencent.mm.kernel.g.afC();
    if (com.tencent.mm.kernel.g.afB().gcW.equals(paramString + "/"))
    {
      AppMethodBeat.o(51522);
      return true;
    }
    AppMethodBeat.o(51522);
    return false;
  }
  
  private void k(int paramInt, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(51524);
        if (paramLong1 > paramLong2)
        {
          bool = true;
          if (bool)
          {
            l = this.tMR | paramInt;
            ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.tMR), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.tMR) {
              break label534;
            }
            if (this.tMR == 0L) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label534;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 2L, 1L, true);
            break label534;
            this.tMR = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            com.tencent.mm.plugin.report.service.e.oR(bool);
            com.tencent.e.h.Iye.aP(new b.7(this, l, locala, paramLong1));
            AppMethodBeat.o(51524);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        long l = this.tMR & (paramInt ^ 0xFFFFFFFF);
        continue;
        ae.a locala = ae.a.FnR;
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label615;
        }
        paramLong2 = 3L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ae.a.FnS;
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label623;
        }
        paramLong2 = 5L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ae.a.FnT;
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label631;
        }
        paramLong2 = 7L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ae.a.FnU;
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label639;
        }
        paramLong2 = 9L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ae.a.FnV;
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label647;
        }
        paramLong2 = 11L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ae.a.FnW;
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label655;
        }
        paramLong2 = 13L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ae.a.FnX;
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label663;
        }
        paramLong2 = 15L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ae.a.FnY;
        localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (bool)
        {
          paramLong2 = 19L;
          localh.idkeyStat(509L, paramLong2, 1L, true);
          continue;
        }
        paramLong2 = 20L;
        continue;
        boolean bool = false;
        continue;
        Object localObject2 = null;
      }
      finally {}
      label534:
      switch (paramInt)
      {
      }
      continue;
      label615:
      paramLong2 = 4L;
      continue;
      label623:
      paramLong2 = 6L;
      continue;
      label631:
      paramLong2 = 8L;
      continue;
      label639:
      paramLong2 = 10L;
      continue;
      label647:
      paramLong2 = 12L;
      continue;
      label655:
      paramLong2 = 14L;
      continue;
      label663:
      paramLong2 = 16L;
    }
  }
  
  private boolean np(boolean paramBoolean)
  {
    AppMethodBeat.i(51519);
    Object localObject = com.tencent.mm.model.c.d.aty().qu("100212");
    ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((com.tencent.mm.storage.c)localObject).isValid()), ((com.tencent.mm.storage.c)localObject).eJy(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(15L), Long.valueOf(1440L) });
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((com.tencent.mm.storage.c)localObject).eJy();
      long l1 = bt.getLong((String)((Map)localObject).get("sdsize"), 1024L);
      long l2 = bt.getLong((String)((Map)localObject).get("sdratio"), 10L);
      long l3 = bt.getLong((String)((Map)localObject).get("dbsize"), 1800L);
      long l4 = bt.getLong((String)((Map)localObject).get("fdbsize"), 1024L);
      long l5 = bt.getLong((String)((Map)localObject).get("msg"), 3000000L);
      long l6 = bt.getLong((String)((Map)localObject).get("conv"), 15000L);
      long l7 = bt.getLong((String)((Map)localObject).get("contact"), 100000L);
      long l8 = bt.getLong((String)((Map)localObject).get("chatroom"), 10000L);
      long l9 = bt.getLong((String)((Map)localObject).get("sditv"), 1440L);
      long l10 = bt.getLong((String)((Map)localObject).get("sdwait"), 15L);
      long l11 = bt.getLong((String)((Map)localObject).get("dbitv"), 1440L);
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.tMD), Long.valueOf(l1), Long.valueOf(this.tME), Long.valueOf(l2), Long.valueOf(this.tMF), Long.valueOf(l3), Long.valueOf(this.tMK), Long.valueOf(l4), Long.valueOf(this.tMG), Long.valueOf(l5), Long.valueOf(this.tMH), Long.valueOf(l6), Long.valueOf(this.tMI), Long.valueOf(l7), Long.valueOf(this.tMJ), Long.valueOf(l8), Long.valueOf(this.tML), Long.valueOf(l9), Long.valueOf(this.tMM), Long.valueOf(l10), Long.valueOf(this.tMN), Long.valueOf(l11) });
      if (this.tMD != l1)
      {
        this.tMD = l1;
        bool = true;
        if (this.tME != l2)
        {
          this.tME = l2;
          bool = true;
        }
        if (this.tMF != l3)
        {
          this.tMF = l3;
          bool = true;
        }
        if (this.tMK != l4)
        {
          this.tMK = l4;
          bool = true;
        }
        if (this.tMG != l5)
        {
          this.tMG = l5;
          bool = true;
        }
        if (this.tMH != l6)
        {
          this.tMH = l6;
          bool = true;
        }
        if (this.tMI != l7)
        {
          this.tMI = l7;
          bool = true;
        }
        if (this.tMJ != l8)
        {
          this.tMJ = l8;
          bool = true;
        }
        if (this.tML != l9)
        {
          this.tML = l9;
          bool = true;
        }
        if (this.tMM != l10)
        {
          this.tMM = l10;
          bool = true;
        }
        if (this.tMN != l11) {
          this.tMN = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 0L, 1L, true);
        if (paramBoolean) {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 18L, 1L, true);
        }
      }
      if (this.tMD <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 30L, 1L, true);
        this.tMD = 1024L;
      }
      if (this.tME <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 31L, 1L, true);
        this.tME = 10L;
      }
      if (this.tMF <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 32L, 1L, true);
        this.tMF = 1800L;
      }
      if (this.tMG <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 33L, 1L, true);
        this.tMG = 3000000L;
      }
      if (this.tMH <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 34L, 1L, true);
        this.tMH = 15000L;
      }
      if (this.tMI <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 35L, 1L, true);
        this.tMI = 100000L;
      }
      if (this.tMJ <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 36L, 1L, true);
        this.tMJ = 10000L;
      }
      if (this.tML <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 37L, 1L, true);
        this.tML = 1440L;
      }
      if (this.tMM <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 38L, 1L, true);
        this.tMM = 15L;
      }
      if (this.tMN <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 39L, 1L, true);
        this.tMN = 1440L;
      }
      if (this.tMK <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(509L, 40L, 1L, true);
        this.tMK = 1024L;
      }
      AppMethodBeat.o(51519);
      return bool;
      bool = false;
      break;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51520);
    com.tencent.mm.sdk.b.a.ESL.b(this.sut);
    com.tencent.mm.model.c.d.aty().add(this.gQD);
    boolean bool = np(false);
    com.tencent.mm.kernel.g.afC();
    this.tMR = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FnP, Long.valueOf(0L))).longValue();
    Object localObject1;
    Object localObject2;
    if (this.tMR != 0L)
    {
      paramBoolean = true;
      com.tencent.mm.plugin.report.service.e.oR(paramBoolean);
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.tMR), Boolean.valueOf(bool), this.gQD });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(989, this.tMS);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(988, this.tMS);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(987, this.tMS);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(986, this.tMS);
      com.tencent.mm.kernel.g.afC();
      this.tMO = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FmN, Long.valueOf(0L))).longValue();
      localObject1 = aj.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label529;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label524;
      }
      paramBoolean = true;
      label274:
      this.npp = paramBoolean;
      label279:
      this.npq = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.npr = new BroadcastReceiver()
      {
        public final void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(163492);
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i = -1;
          label92:
          boolean bool2;
          boolean bool3;
          long l;
          switch (paramAnonymousContext.hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              bool2 = b.j(b.this);
              bool3 = b.k(b.this);
              l = b.l(b.this);
              if (b.m(b.this) != null) {}
              break;
            }
            break;
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            ad.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramAnonymousContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
            if ((b.m(b.this) == null) && (b.k(b.this)) && (!b.j(b.this))) {
              break label376;
            }
            if (b.m(b.this) == null) {
              break label531;
            }
            b.m(b.this).cancel();
            b.a(b.this, null);
            ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { b.p(b.this) });
            AppMethodBeat.o(163492);
            return;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_ON")) {
              break;
            }
            i = 0;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_OFF")) {
              break;
            }
            i = 1;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
              break;
            }
            i = 2;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
              break;
            }
            i = 3;
            break;
            b.a(b.this, true);
            break label92;
            b.a(b.this, false);
            break label92;
            b.b(b.this, true);
            break label92;
            b.b(b.this, false);
            break label92;
          }
          label376:
          if (com.tencent.mm.sdk.a.b.eEQ()) {
            b.n(b.this);
          }
          while (System.currentTimeMillis() - b.l(b.this) >= b.o(b.this) * 60000L)
          {
            paramAnonymousContext = new a()
            {
              public final void a(int paramAnonymous2Int, a.a paramAnonymous2a)
              {
                AppMethodBeat.i(163490);
                b.a(b.this, System.currentTimeMillis());
                ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymous2Int), Long.valueOf(b.l(b.this)), b.p(b.this), paramAnonymous2a });
                b.a(b.this, null);
                if ((paramAnonymous2Int == 0) && (!paramAnonymous2a.hls))
                {
                  com.tencent.mm.kernel.g.afC();
                  com.tencent.mm.kernel.g.afB().afk().set(ae.a.FmN, Long.valueOf(b.l(b.this)));
                  com.tencent.mm.kernel.g.afC();
                  com.tencent.mm.kernel.g.afB().afk().eKy();
                  try
                  {
                    b.b(b.this, paramAnonymous2a);
                    AppMethodBeat.o(163490);
                    return;
                  }
                  catch (Exception paramAnonymous2a)
                  {
                    ad.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymous2a, "doReportSDInfo err!", new Object[0]);
                    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(418L, 6L, 1L, true);
                  }
                }
                AppMethodBeat.o(163490);
              }
            };
            b.a(b.this, new com.tencent.e.i.b()
            {
              public final String getKey()
              {
                return "autoScanRemove";
              }
              
              public final void run()
              {
                AppMethodBeat.i(163491);
                b.a(b.this, null);
                int i = bi.ash();
                ad.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
                if (i > 0) {
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(418L, 8L, 1L, true);
                }
                b.a(b.this, b.a(b.this, paramAnonymousContext));
                ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { b.p(b.this) });
                AppMethodBeat.o(163491);
              }
            });
            com.tencent.e.h.Iye.a(b.m(b.this), b.q(b.this) * 60000L, "MicroMsg.SubCoreBaseMonitor");
            ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(b.q(b.this)) });
            AppMethodBeat.o(163492);
            return;
          }
          ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(b.o(b.this)) });
          AppMethodBeat.o(163492);
          return;
          label531:
          if (b.p(b.this) != null)
          {
            b.p(b.this).hls = true;
            ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { b.p(b.this) });
            b.a(b.this, null);
          }
          AppMethodBeat.o(163492);
        }
      };
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.TIME_SET");
      ((IntentFilter)localObject2).addAction("android.intent.action.DATE_CHANGED");
      ((Context)localObject1).registerReceiver(this.npr, (IntentFilter)localObject2);
      if (this.tMQ == null) {
        break label537;
      }
      localObject1 = "enabled";
      label390:
      if (!this.npq) {
        break label545;
      }
      localObject2 = "";
      label402:
      if (!this.npp) {
        break label553;
      }
    }
    label524:
    label529:
    label537:
    label545:
    label553:
    for (String str = "";; str = " not")
    {
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.tMO), Long.valueOf(this.tML * 60000L), Long.valueOf(this.tMM * 60000L) });
      this.tMV.stopTimer();
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
        this.tMW.av(3000L, 10800000L);
      }
      AppMethodBeat.o(51520);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label274;
      this.npp = false;
      break label279;
      localObject1 = "disabled";
      break label390;
      localObject2 = " not";
      break label402;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51521);
    ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[] { Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()) });
    if (this.npr != null)
    {
      aj.getContext().unregisterReceiver(this.npr);
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.npr });
      this.npr = null;
    }
    if (this.tMP != null)
    {
      this.tMP.cancel();
      this.tMP = null;
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.tMQ });
    }
    if (this.tMQ != null)
    {
      this.tMQ.hls = true;
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.tMQ });
      this.tMQ = null;
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(989, this.tMS);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(988, this.tMS);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(987, this.tMS);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(986, this.tMS);
    com.tencent.mm.model.c.d.aty().remove(this.gQD);
    com.tencent.mm.sdk.b.a.ESL.d(this.sut);
    AppMethodBeat.o(51521);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b
 * JD-Core Version:    0.7.0.1
 */