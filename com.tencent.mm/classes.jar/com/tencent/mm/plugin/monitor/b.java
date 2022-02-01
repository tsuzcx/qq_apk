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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private k.a hrd;
  private boolean nSp;
  private boolean nSq;
  private BroadcastReceiver nSr;
  private com.tencent.mm.sdk.b.c tCi;
  private long uVg;
  private long uVh;
  private long uVi;
  private long uVj;
  private long uVk;
  private long uVl;
  private long uVm;
  private long uVn;
  private long uVo;
  private long uVp;
  private long uVq;
  private long uVr;
  private com.tencent.e.i.b uVs;
  private a.a uVt;
  private long uVu;
  private com.tencent.mm.ak.g uVv;
  private com.tencent.e.i.b uVw;
  private com.tencent.e.i.b uVx;
  private au uVy;
  private au uVz;
  
  static
  {
    AppMethodBeat.i(51537);
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(51537);
  }
  
  public b()
  {
    AppMethodBeat.i(51518);
    this.uVg = 1024L;
    this.uVh = 10L;
    this.uVi = 1800L;
    this.uVj = 3000000L;
    this.uVk = 15000L;
    this.uVl = 100000L;
    this.uVm = 10000L;
    this.uVn = 1024L;
    this.uVo = 1440L;
    this.uVp = 15L;
    this.uVq = 1440L;
    this.nSp = false;
    this.nSq = true;
    this.uVr = 0L;
    this.uVu = 0L;
    this.uVv = new b.1(this);
    this.hrd = new b.9(this);
    this.uVw = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "reportAllRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51509);
        ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        if (!com.tencent.mm.kernel.g.agM())
        {
          ac.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
          AppMethodBeat.o(51509);
          return;
        }
        b.b(b.this);
        b.c(b.this);
        b.d(b.this);
        b.e(b.this);
        b.f(b.this);
        b.g(b.this).cancel();
        com.tencent.e.h.JZN.q(b.g(b.this), 10000L);
        AppMethodBeat.o(51509);
      }
    };
    this.uVx = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "reportHeavyUser";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51510);
        ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
        if (com.tencent.mm.kernel.g.agM()) {
          b.h(b.this);
        }
        AppMethodBeat.o(51510);
      }
    };
    this.tCi = new b.12(this);
    this.uVy = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(51512);
        b.e(b.this);
        AppMethodBeat.o(51512);
        return true;
      }
    }, true);
    this.uVz = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new b.14(this), true);
    AppMethodBeat.o(51518);
  }
  
  private a.a a(com.tencent.mm.vfs.e parame, a.a parama, a.b paramb, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(51523);
    if (parama.hLV)
    {
      ac.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb });
      AppMethodBeat.o(51523);
      return parama;
    }
    if (parama.brJ < paramInt) {
      parama.brJ += 1;
    }
    Object localObject2;
    if (parame.isDirectory())
    {
      localObject2 = com.tencent.mm.vfs.q.B(parame.fxV());
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
          parama.uVd.add(paramb);
          ac.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject2, parama, paramb });
        }
      }
    }
    label940:
    label943:
    for (Object localObject1 = paramb;; localObject1 = paramb)
    {
      parama.uVb += 1L;
      if (localObject1 != null) {
        ((a.b)localObject1).uVb += 1L;
      }
      if (paramc != null) {
        paramc.uVb += 1L;
      }
      int i;
      if (paramInt > 15)
      {
        ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.vfs.q.B(parame.fxV()), parama });
        AppMethodBeat.o(51523);
        return parama;
        localObject1 = parame.getParent();
        if (com.tencent.mm.loader.j.b.aph().equals((String)localObject1 + "/")) {
          i = 1;
        }
        for (;;)
        {
          if ((i != 0) && (!ame((String)localObject2)))
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
        if (!ame(parame.getParent())) {
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
            if (!bs.isNullOrNil(str))
            {
              paramc = paramb;
              if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str))
              {
                paramc = new a.c(com.tencent.mm.vfs.q.B(parame.fxV()) + "/" + str);
                parama.uVe.add(paramc);
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
          a(new com.tencent.mm.vfs.e(com.tencent.mm.vfs.q.B(parame.fxV()) + "/" + paramb), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
          i += 1;
        }
      }
      ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { com.tencent.mm.vfs.q.B(parame.fxV()) });
      AppMethodBeat.o(51523);
      return parama;
      parama.uVc += 1L;
      if (paramb != null) {
        paramb.uVc += 1L;
      }
      if (paramc != null) {
        paramc.uVc += 1L;
      }
      if (!parame.exists())
      {
        ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { com.tencent.mm.vfs.q.B(parame.fxV()), Long.valueOf(parama.uVc) });
        AppMethodBeat.o(51523);
        return parama;
      }
      long l = parame.length();
      if ((l > 0L) && (l < 2147483648L))
      {
        parama.mSs += l;
        if (paramb != null) {
          paramb.mSs += l;
        }
        if (paramc != null) {
          paramc.mSs = (l + paramc.mSs);
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
          paramc.uVf += 1L;
        }
      }
      break;
    }
  }
  
  private static boolean ame(String paramString)
  {
    AppMethodBeat.i(51522);
    com.tencent.mm.kernel.g.agS();
    if (com.tencent.mm.kernel.g.agR().ghC.equals(paramString + "/"))
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
            l = this.uVu | paramInt;
            ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.uVu), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.uVu) {
              break label534;
            }
            if (this.uVu == 0L) {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label534;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 2L, 1L, true);
            break label534;
            this.uVu = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            com.tencent.mm.plugin.report.service.e.pP(bool);
            com.tencent.e.h.JZN.aS(new b.7(this, l, locala, paramLong1));
            AppMethodBeat.o(51524);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        long l = this.uVu & (paramInt ^ 0xFFFFFFFF);
        continue;
        ah.a locala = ah.a.GLG;
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label615;
        }
        paramLong2 = 3L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ah.a.GLH;
        localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label623;
        }
        paramLong2 = 5L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ah.a.GLI;
        localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label631;
        }
        paramLong2 = 7L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ah.a.GLJ;
        localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label639;
        }
        paramLong2 = 9L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ah.a.GLK;
        localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label647;
        }
        paramLong2 = 11L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ah.a.GLL;
        localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label655;
        }
        paramLong2 = 13L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ah.a.GLM;
        localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label663;
        }
        paramLong2 = 15L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ah.a.GLN;
        localh = com.tencent.mm.plugin.report.service.h.wUl;
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
  
  private boolean oj(boolean paramBoolean)
  {
    AppMethodBeat.i(51519);
    Object localObject = com.tencent.mm.model.c.d.aAp().tJ("100212");
    ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((com.tencent.mm.storage.c)localObject).isValid()), ((com.tencent.mm.storage.c)localObject).eYV(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(15L), Long.valueOf(1440L) });
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((com.tencent.mm.storage.c)localObject).eYV();
      long l1 = bs.getLong((String)((Map)localObject).get("sdsize"), 1024L);
      long l2 = bs.getLong((String)((Map)localObject).get("sdratio"), 10L);
      long l3 = bs.getLong((String)((Map)localObject).get("dbsize"), 1800L);
      long l4 = bs.getLong((String)((Map)localObject).get("fdbsize"), 1024L);
      long l5 = bs.getLong((String)((Map)localObject).get("msg"), 3000000L);
      long l6 = bs.getLong((String)((Map)localObject).get("conv"), 15000L);
      long l7 = bs.getLong((String)((Map)localObject).get("contact"), 100000L);
      long l8 = bs.getLong((String)((Map)localObject).get("chatroom"), 10000L);
      long l9 = bs.getLong((String)((Map)localObject).get("sditv"), 1440L);
      long l10 = bs.getLong((String)((Map)localObject).get("sdwait"), 15L);
      long l11 = bs.getLong((String)((Map)localObject).get("dbitv"), 1440L);
      ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.uVg), Long.valueOf(l1), Long.valueOf(this.uVh), Long.valueOf(l2), Long.valueOf(this.uVi), Long.valueOf(l3), Long.valueOf(this.uVn), Long.valueOf(l4), Long.valueOf(this.uVj), Long.valueOf(l5), Long.valueOf(this.uVk), Long.valueOf(l6), Long.valueOf(this.uVl), Long.valueOf(l7), Long.valueOf(this.uVm), Long.valueOf(l8), Long.valueOf(this.uVo), Long.valueOf(l9), Long.valueOf(this.uVp), Long.valueOf(l10), Long.valueOf(this.uVq), Long.valueOf(l11) });
      if (this.uVg != l1)
      {
        this.uVg = l1;
        bool = true;
        if (this.uVh != l2)
        {
          this.uVh = l2;
          bool = true;
        }
        if (this.uVi != l3)
        {
          this.uVi = l3;
          bool = true;
        }
        if (this.uVn != l4)
        {
          this.uVn = l4;
          bool = true;
        }
        if (this.uVj != l5)
        {
          this.uVj = l5;
          bool = true;
        }
        if (this.uVk != l6)
        {
          this.uVk = l6;
          bool = true;
        }
        if (this.uVl != l7)
        {
          this.uVl = l7;
          bool = true;
        }
        if (this.uVm != l8)
        {
          this.uVm = l8;
          bool = true;
        }
        if (this.uVo != l9)
        {
          this.uVo = l9;
          bool = true;
        }
        if (this.uVp != l10)
        {
          this.uVp = l10;
          bool = true;
        }
        if (this.uVq != l11) {
          this.uVq = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 0L, 1L, true);
        if (paramBoolean) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 18L, 1L, true);
        }
      }
      if (this.uVg <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 30L, 1L, true);
        this.uVg = 1024L;
      }
      if (this.uVh <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 31L, 1L, true);
        this.uVh = 10L;
      }
      if (this.uVi <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 32L, 1L, true);
        this.uVi = 1800L;
      }
      if (this.uVj <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 33L, 1L, true);
        this.uVj = 3000000L;
      }
      if (this.uVk <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 34L, 1L, true);
        this.uVk = 15000L;
      }
      if (this.uVl <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 35L, 1L, true);
        this.uVl = 100000L;
      }
      if (this.uVm <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 36L, 1L, true);
        this.uVm = 10000L;
      }
      if (this.uVo <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 37L, 1L, true);
        this.uVo = 1440L;
      }
      if (this.uVp <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 38L, 1L, true);
        this.uVp = 15L;
      }
      if (this.uVq <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 39L, 1L, true);
        this.uVq = 1440L;
      }
      if (this.uVn <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(509L, 40L, 1L, true);
        this.uVn = 1024L;
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
    com.tencent.mm.sdk.b.a.GpY.b(this.tCi);
    com.tencent.mm.model.c.d.aAp().add(this.hrd);
    boolean bool = oj(false);
    com.tencent.mm.kernel.g.agS();
    this.uVu = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLE, Long.valueOf(0L))).longValue();
    Object localObject1;
    Object localObject2;
    if (this.uVu != 0L)
    {
      paramBoolean = true;
      com.tencent.mm.plugin.report.service.e.pP(paramBoolean);
      ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.uVu), Boolean.valueOf(bool), this.hrd });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(989, this.uVv);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(988, this.uVv);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(987, this.uVv);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(986, this.uVv);
      com.tencent.mm.kernel.g.agS();
      this.uVr = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GKC, Long.valueOf(0L))).longValue();
      localObject1 = ai.getContext();
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
      this.nSp = paramBoolean;
      label279:
      this.nSq = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.nSr = new BroadcastReceiver()
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
            ac.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramAnonymousContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
            if ((b.m(b.this) == null) && (b.k(b.this)) && (!b.j(b.this))) {
              break label376;
            }
            if (b.m(b.this) == null) {
              break label531;
            }
            b.m(b.this).cancel();
            b.a(b.this, null);
            ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { b.p(b.this) });
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
          if (com.tencent.mm.sdk.a.b.eUk()) {
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
                ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymous2Int), Long.valueOf(b.l(b.this)), b.p(b.this), paramAnonymous2a });
                b.a(b.this, null);
                if ((paramAnonymous2Int == 0) && (!paramAnonymous2a.hLV))
                {
                  com.tencent.mm.kernel.g.agS();
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GKC, Long.valueOf(b.l(b.this)));
                  com.tencent.mm.kernel.g.agS();
                  com.tencent.mm.kernel.g.agR().agA().faa();
                  try
                  {
                    b.b(b.this, paramAnonymous2a);
                    AppMethodBeat.o(163490);
                    return;
                  }
                  catch (Exception paramAnonymous2a)
                  {
                    ac.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymous2a, "doReportSDInfo err!", new Object[0]);
                    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(418L, 6L, 1L, true);
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
                int i = bi.ayY();
                ac.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
                if (i > 0) {
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(418L, 8L, 1L, true);
                }
                b.a(b.this, b.a(b.this, paramAnonymousContext));
                ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { b.p(b.this) });
                AppMethodBeat.o(163491);
              }
            });
            com.tencent.e.h.JZN.a(b.m(b.this), b.q(b.this) * 60000L, "MicroMsg.SubCoreBaseMonitor");
            ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(b.q(b.this)) });
            AppMethodBeat.o(163492);
            return;
          }
          ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(b.o(b.this)) });
          AppMethodBeat.o(163492);
          return;
          label531:
          if (b.p(b.this) != null)
          {
            b.p(b.this).hLV = true;
            ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { b.p(b.this) });
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
      ((Context)localObject1).registerReceiver(this.nSr, (IntentFilter)localObject2);
      if (this.uVt == null) {
        break label537;
      }
      localObject1 = "enabled";
      label390:
      if (!this.nSq) {
        break label545;
      }
      localObject2 = "";
      label402:
      if (!this.nSp) {
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
      ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.uVr), Long.valueOf(this.uVo * 60000L), Long.valueOf(this.uVp * 60000L) });
      this.uVy.stopTimer();
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
        this.uVz.au(3000L, 10800000L);
      }
      AppMethodBeat.o(51520);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label274;
      this.nSp = false;
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
    ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[] { Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()) });
    if (this.nSr != null)
    {
      ai.getContext().unregisterReceiver(this.nSr);
      ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.nSr });
      this.nSr = null;
    }
    if (this.uVs != null)
    {
      this.uVs.cancel();
      this.uVs = null;
      ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.uVt });
    }
    if (this.uVt != null)
    {
      this.uVt.hLV = true;
      ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.uVt });
      this.uVt = null;
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(989, this.uVv);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(988, this.uVv);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(987, this.uVv);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(986, this.uVv);
    com.tencent.mm.model.c.d.aAp().remove(this.hrd);
    com.tencent.mm.sdk.b.a.GpY.d(this.tCi);
    AppMethodBeat.o(51521);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b
 * JD-Core Version:    0.7.0.1
 */