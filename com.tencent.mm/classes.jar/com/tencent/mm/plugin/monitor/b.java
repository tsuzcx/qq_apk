package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class b
  implements at
{
  private static final long startTime;
  private k.a foV;
  private boolean kkm;
  private boolean kkn;
  private BroadcastReceiver kko;
  private Runnable kkp;
  private com.tencent.mm.sdk.b.c nGN;
  private long oRE;
  private long oRF;
  private long oRG;
  private long oRH;
  private long oRI;
  private long oRJ;
  private long oRK;
  private long oRL;
  private long oRM;
  private long oRN;
  private long oRO;
  private long oRP;
  private a.a oRQ;
  private long oRR;
  private f oRS;
  private Runnable oRT;
  private Runnable oRU;
  private ap oRV;
  
  static
  {
    AppMethodBeat.i(84555);
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(84555);
  }
  
  public b()
  {
    AppMethodBeat.i(84536);
    this.oRE = 1024L;
    this.oRF = 10L;
    this.oRG = 1800L;
    this.oRH = 3000000L;
    this.oRI = 15000L;
    this.oRJ = 100000L;
    this.oRK = 10000L;
    this.oRL = 1024L;
    this.oRM = 1440L;
    this.oRN = 20L;
    this.oRO = 1440L;
    this.kkm = false;
    this.kkn = true;
    this.oRP = 0L;
    this.oRR = 0L;
    this.oRS = new b.1(this);
    this.foV = new b.8(this);
    this.oRT = new b.9(this);
    this.oRU = new b.10(this);
    this.nGN = new b.11(this);
    this.oRV = new ap(g.RO().oNc.getLooper(), new b.12(this), true);
    AppMethodBeat.o(84536);
  }
  
  private static boolean Ud(String paramString)
  {
    AppMethodBeat.i(84540);
    g.RM();
    if (g.RL().eHR.equals(paramString + "/"))
    {
      AppMethodBeat.o(84540);
      return true;
    }
    AppMethodBeat.o(84540);
    return false;
  }
  
  private a.a a(com.tencent.mm.vfs.b paramb, a.a parama, a.b paramb1, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(84541);
    if (parama.fIp)
    {
      ab.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb1 });
      AppMethodBeat.o(84541);
      return parama;
    }
    if (parama.aVH < paramInt) {
      parama.aVH += 1;
    }
    Object localObject2;
    if (paramb.isDirectory())
    {
      localObject2 = j.p(paramb.dQJ());
      if (paramb1 != null) {
        break label1035;
      }
      if ((paramMap != null) && (paramMap.size() > 0) && (paramMap.get(localObject2) != null))
      {
        paramb1 = new a.b((String)localObject2, ((Integer)paramMap.get(localObject2)).intValue());
        paramMap.remove(localObject2);
        localObject1 = paramb1;
        if (paramb1 != null)
        {
          parama.oRB.add(paramb1);
          ab.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject2, parama, paramb1 });
        }
      }
    }
    label1029:
    label1032:
    label1035:
    for (Object localObject1 = paramb1;; localObject1 = paramb1)
    {
      parama.oRz += 1L;
      if (localObject1 != null) {
        ((a.b)localObject1).oRz += 1L;
      }
      if (paramc != null) {
        paramc.oRz += 1L;
      }
      int i;
      if (paramInt > 15)
      {
        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), j.p(paramb.dQJ()), parama });
        AppMethodBeat.o(84541);
        return parama;
        localObject1 = paramb.getParent();
        if (com.tencent.mm.compatible.util.e.eQz.equals((String)localObject1 + "/")) {
          i = 1;
        }
        for (;;)
        {
          if ((i != 0) && (!Ud((String)localObject2)))
          {
            if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", paramb.getName()))
            {
              paramb1 = new a.b((String)localObject2, 202);
              break;
              i = 0;
              continue;
            }
            if (Pattern.matches("[a-fA-F0-9]{32}", paramb.getName()))
            {
              paramb1 = new a.b((String)localObject2, 201);
              break;
            }
            paramb1 = new a.b((String)localObject2, 203);
            break;
          }
        }
        if (!Ud(paramb.getParent())) {
          break label1032;
        }
        paramb1 = new a.b((String)localObject2, 203);
        break;
      }
      localObject2 = paramb.list();
      int j;
      if (localObject2 != null)
      {
        if (paramBoolean)
        {
          j = localObject2.length;
          i = 0;
          for (paramb1 = paramc; i < j; paramb1 = paramc)
          {
            String str = localObject2[i];
            paramc = paramb1;
            if (!bo.isNullOrNil(str))
            {
              paramc = paramb1;
              if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str))
              {
                paramc = new a.c(j.p(paramb.dQJ()) + "/" + str);
                parama.oRC.add(paramc);
              }
            }
            a(new com.tencent.mm.vfs.b(j.p(paramb.mUri) + "/" + str), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
            i += 1;
          }
        }
        i = 1;
        int k = localObject2.length;
        j = 0;
        if (j >= k) {
          break label977;
        }
        paramb1 = localObject2[j];
        a(new com.tencent.mm.vfs.b(j.p(paramb.dQJ()) + "/" + paramb1), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
        if ((i == 0) || (parama.aVH <= 15)) {
          break label1029;
        }
        h.qsU.idkeyStat(418L, 7L, 1L, true);
        h.qsU.e(13778, new Object[] { Integer.valueOf(2), Integer.valueOf(2), j.p(paramb.dQJ()) + "/" + paramb1 });
        i = 0;
      }
      for (;;)
      {
        j += 1;
        break;
        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { j.p(paramb.dQJ()) });
        AppMethodBeat.o(84541);
        return parama;
        parama.oRA += 1L;
        if (paramb1 != null) {
          paramb1.oRA += 1L;
        }
        if (paramc != null) {
          paramc.oRA += 1L;
        }
        if (!paramb.exists())
        {
          ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { j.p(paramb.dQJ()), Long.valueOf(parama.oRA) });
          AppMethodBeat.o(84541);
          return parama;
        }
        long l = paramb.length();
        if ((l > 0L) && (l < 2147483648L))
        {
          parama.jyU += l;
          if (paramb1 != null) {
            paramb1.jyU += l;
          }
          if (paramc != null) {
            paramc.jyU = (l + paramc.jyU);
          }
        }
        for (;;)
        {
          label977:
          AppMethodBeat.o(84541);
          return parama;
          parama.fileLenInvalidCount += 1L;
          if (paramb1 != null) {
            paramb1.fileLenInvalidCount += 1L;
          }
          if (paramc != null) {
            paramc.oRD += 1L;
          }
        }
      }
      break;
    }
  }
  
  private boolean jv(boolean paramBoolean)
  {
    AppMethodBeat.i(84537);
    Object localObject = com.tencent.mm.model.c.c.abU().me("100212");
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((com.tencent.mm.storage.c)localObject).isValid()), ((com.tencent.mm.storage.c)localObject).dvN(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(20L), Long.valueOf(1440L) });
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((com.tencent.mm.storage.c)localObject).dvN();
      long l1 = bo.getLong((String)((Map)localObject).get("sdsize"), 1024L);
      long l2 = bo.getLong((String)((Map)localObject).get("sdratio"), 10L);
      long l3 = bo.getLong((String)((Map)localObject).get("dbsize"), 1800L);
      long l4 = bo.getLong((String)((Map)localObject).get("fdbsize"), 1024L);
      long l5 = bo.getLong((String)((Map)localObject).get("msg"), 3000000L);
      long l6 = bo.getLong((String)((Map)localObject).get("conv"), 15000L);
      long l7 = bo.getLong((String)((Map)localObject).get("contact"), 100000L);
      long l8 = bo.getLong((String)((Map)localObject).get("chatroom"), 10000L);
      long l9 = bo.getLong((String)((Map)localObject).get("sditv"), 1440L);
      long l10 = bo.getLong((String)((Map)localObject).get("sdwait"), 20L);
      long l11 = bo.getLong((String)((Map)localObject).get("dbitv"), 1440L);
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.oRE), Long.valueOf(l1), Long.valueOf(this.oRF), Long.valueOf(l2), Long.valueOf(this.oRG), Long.valueOf(l3), Long.valueOf(this.oRL), Long.valueOf(l4), Long.valueOf(this.oRH), Long.valueOf(l5), Long.valueOf(this.oRI), Long.valueOf(l6), Long.valueOf(this.oRJ), Long.valueOf(l7), Long.valueOf(this.oRK), Long.valueOf(l8), Long.valueOf(this.oRM), Long.valueOf(l9), Long.valueOf(this.oRN), Long.valueOf(l10), Long.valueOf(this.oRO), Long.valueOf(l11) });
      if (this.oRE != l1)
      {
        this.oRE = l1;
        bool = true;
        if (this.oRF != l2)
        {
          this.oRF = l2;
          bool = true;
        }
        if (this.oRG != l3)
        {
          this.oRG = l3;
          bool = true;
        }
        if (this.oRL != l4)
        {
          this.oRL = l4;
          bool = true;
        }
        if (this.oRH != l5)
        {
          this.oRH = l5;
          bool = true;
        }
        if (this.oRI != l6)
        {
          this.oRI = l6;
          bool = true;
        }
        if (this.oRJ != l7)
        {
          this.oRJ = l7;
          bool = true;
        }
        if (this.oRK != l8)
        {
          this.oRK = l8;
          bool = true;
        }
        if (this.oRM != l9)
        {
          this.oRM = l9;
          bool = true;
        }
        if (this.oRN != l10)
        {
          this.oRN = l10;
          bool = true;
        }
        if (this.oRO != l11) {
          this.oRO = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        h.qsU.idkeyStat(509L, 0L, 1L, true);
        if (paramBoolean) {
          h.qsU.idkeyStat(509L, 18L, 1L, true);
        }
      }
      if (this.oRE <= 0L)
      {
        h.qsU.idkeyStat(509L, 30L, 1L, true);
        this.oRE = 1024L;
      }
      if (this.oRF <= 0L)
      {
        h.qsU.idkeyStat(509L, 31L, 1L, true);
        this.oRF = 10L;
      }
      if (this.oRG <= 0L)
      {
        h.qsU.idkeyStat(509L, 32L, 1L, true);
        this.oRG = 1800L;
      }
      if (this.oRH <= 0L)
      {
        h.qsU.idkeyStat(509L, 33L, 1L, true);
        this.oRH = 3000000L;
      }
      if (this.oRI <= 0L)
      {
        h.qsU.idkeyStat(509L, 34L, 1L, true);
        this.oRI = 15000L;
      }
      if (this.oRJ <= 0L)
      {
        h.qsU.idkeyStat(509L, 35L, 1L, true);
        this.oRJ = 100000L;
      }
      if (this.oRK <= 0L)
      {
        h.qsU.idkeyStat(509L, 36L, 1L, true);
        this.oRK = 10000L;
      }
      if (this.oRM <= 0L)
      {
        h.qsU.idkeyStat(509L, 37L, 1L, true);
        this.oRM = 1440L;
      }
      if (this.oRN <= 0L)
      {
        h.qsU.idkeyStat(509L, 38L, 1L, true);
        this.oRN = 20L;
      }
      if (this.oRO <= 0L)
      {
        h.qsU.idkeyStat(509L, 39L, 1L, true);
        this.oRO = 1440L;
      }
      if (this.oRL <= 0L)
      {
        h.qsU.idkeyStat(509L, 40L, 1L, true);
        this.oRL = 1024L;
      }
      AppMethodBeat.o(84537);
      return bool;
      bool = false;
      break;
    }
  }
  
  private void k(int paramInt, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(84542);
        if (paramLong1 > paramLong2)
        {
          bool = true;
          if (bool)
          {
            l = this.oRR | paramInt;
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.oRR), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.oRR) {
              break label533;
            }
            if (this.oRR == 0L) {
              h.qsU.idkeyStat(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label533;
            }
            h.qsU.idkeyStat(509L, 2L, 1L, true);
            break label533;
            this.oRR = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            com.tencent.mm.plugin.report.service.e.kz(bool);
            com.tencent.mm.sdk.g.d.ysn.aj(new b.6(this, l, locala, paramLong1));
            AppMethodBeat.o(84542);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        long l = this.oRR & (paramInt ^ 0xFFFFFFFF);
        continue;
        ac.a locala = ac.a.yFi;
        h localh = h.qsU;
        if (!bool) {
          break label615;
        }
        paramLong2 = 3L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.yFj;
        localh = h.qsU;
        if (!bool) {
          break label623;
        }
        paramLong2 = 5L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.yFk;
        localh = h.qsU;
        if (!bool) {
          break label631;
        }
        paramLong2 = 7L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.yFl;
        localh = h.qsU;
        if (!bool) {
          break label639;
        }
        paramLong2 = 9L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.yFm;
        localh = h.qsU;
        if (!bool) {
          break label647;
        }
        paramLong2 = 11L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.yFn;
        localh = h.qsU;
        if (!bool) {
          break label655;
        }
        paramLong2 = 13L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.yFo;
        localh = h.qsU;
        if (!bool) {
          break label663;
        }
        paramLong2 = 15L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.yFp;
        localh = h.qsU;
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
      label533:
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
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(84538);
    a.ymk.b(this.nGN);
    com.tencent.mm.model.c.c.abU().add(this.foV);
    boolean bool = jv(false);
    g.RM();
    this.oRR = ((Long)g.RL().Ru().get(ac.a.yFg, Long.valueOf(0L))).longValue();
    Object localObject1;
    Object localObject2;
    if (this.oRR != 0L)
    {
      paramBoolean = true;
      com.tencent.mm.plugin.report.service.e.kz(paramBoolean);
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.oRR), Boolean.valueOf(bool), this.foV });
      g.RM();
      g.RK().eHt.a(989, this.oRS);
      g.RM();
      g.RK().eHt.a(988, this.oRS);
      g.RM();
      g.RK().eHt.a(987, this.oRS);
      g.RM();
      g.RK().eHt.a(986, this.oRS);
      g.RM();
      this.oRP = ((Long)g.RL().Ru().get(ac.a.yEh, Long.valueOf(0L))).longValue();
      localObject1 = ah.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label504;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label499;
      }
      paramBoolean = true;
      label274:
      this.kkm = paramBoolean;
      label279:
      this.kkn = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.kko = new b.13(this);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.TIME_SET");
      ((IntentFilter)localObject2).addAction("android.intent.action.DATE_CHANGED");
      ((Context)localObject1).registerReceiver(this.kko, (IntentFilter)localObject2);
      if (this.oRQ == null) {
        break label512;
      }
      localObject1 = "enabled";
      label390:
      if (!this.kkn) {
        break label520;
      }
      localObject2 = "";
      label402:
      if (!this.kkm) {
        break label528;
      }
    }
    label512:
    label520:
    label528:
    for (String str = "";; str = " not")
    {
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.oRP), Long.valueOf(this.oRM * 60000L), Long.valueOf(this.oRN * 60000L) });
      this.oRV.stopTimer();
      AppMethodBeat.o(84538);
      return;
      paramBoolean = false;
      break;
      label499:
      paramBoolean = false;
      break label274;
      label504:
      this.kkm = false;
      break label279;
      localObject1 = "disabled";
      break label390;
      localObject2 = " not";
      break label402;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(84539);
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[] { Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()) });
    if (this.kko != null)
    {
      ah.getContext().unregisterReceiver(this.kko);
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.kko });
      this.kko = null;
    }
    if (this.kkp != null)
    {
      com.tencent.mm.sdk.g.d.ysn.ak(this.kkp);
      this.kkp = null;
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.oRQ });
    }
    if (this.oRQ != null)
    {
      this.oRQ.fIp = true;
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.oRQ });
      this.oRQ = null;
    }
    g.RM();
    g.RK().eHt.b(989, this.oRS);
    g.RM();
    g.RK().eHt.b(988, this.oRS);
    g.RM();
    g.RK().eHt.b(987, this.oRS);
    g.RM();
    g.RK().eHt.b(986, this.oRS);
    com.tencent.mm.model.c.c.abU().remove(this.foV);
    a.ymk.d(this.nGN);
    AppMethodBeat.o(84539);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b
 * JD-Core Version:    0.7.0.1
 */