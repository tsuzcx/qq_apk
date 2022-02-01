package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class b
  implements be
{
  private static final long startTime;
  private IListener Dti;
  private long FjT;
  private long FjU;
  private long FjV;
  private long FjW;
  private long FjX;
  private long FjY;
  private long FjZ;
  private long Fka;
  private long Fkb;
  private long Fkc;
  private long Fkd;
  private long Fke;
  private com.tencent.e.i.b Fkf;
  private a.a Fkg;
  private long Fkh;
  private com.tencent.mm.an.i Fki;
  private com.tencent.e.i.b Fkj;
  private com.tencent.e.i.b Fkk;
  private MTimerHandler Fkl;
  private MTimerHandler Fkm;
  private boolean cVD;
  private MStorage.IOnStorageChange lxt;
  private boolean sWW;
  private BroadcastReceiver sWX;
  
  static
  {
    AppMethodBeat.i(51537);
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(51537);
  }
  
  public b()
  {
    AppMethodBeat.i(51518);
    this.FjT = 1024L;
    this.FjU = 10L;
    this.FjV = 1800L;
    this.FjW = 3000000L;
    this.FjX = 15000L;
    this.FjY = 100000L;
    this.FjZ = 10000L;
    this.Fka = 1024L;
    this.Fkb = 1440L;
    this.Fkc = 15L;
    this.Fkd = 1440L;
    this.cVD = false;
    this.sWW = true;
    this.Fke = 0L;
    this.Fkh = 0L;
    this.Fki = new b.1(this);
    this.lxt = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(51508);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { Util.getStack() });
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
          com.tencent.e.h.ZvG.o(new Runnable()
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
    this.Fkj = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "reportAllRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51510);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        if (!com.tencent.mm.kernel.h.aHB())
        {
          Log.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
          AppMethodBeat.o(51510);
          return;
        }
        b.c(b.this);
        b.d(b.this);
        b.e(b.this);
        b.f(b.this);
        b.g(b.this);
        b.h(b.this).cancel();
        com.tencent.e.h.ZvG.o(b.h(b.this), 10000L);
        AppMethodBeat.o(51510);
      }
    };
    this.Fkk = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "reportHeavyUser";
      }
      
      public final void run()
      {
        AppMethodBeat.i(193764);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
        if (com.tencent.mm.kernel.h.aHB()) {
          b.i(b.this);
        }
        AppMethodBeat.o(193764);
      }
    };
    this.Dti = new IListener() {};
    this.Fkl = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(163489);
        b.f(b.this);
        AppMethodBeat.o(163489);
        return true;
      }
    }, true);
    this.Fkm = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(193836);
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193821);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCE, "");
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCG, Boolean.FALSE);
            AppMethodBeat.o(193821);
          }
        };
        com.tencent.e.h.ZvG.d(local1, "name_thread_get_newer_flavor_red");
        AppMethodBeat.o(193836);
        return true;
      }
    }, true);
    AppMethodBeat.o(51518);
  }
  
  private a.a a(q paramq, a.a parama, a.b paramb, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(51523);
    if (parama.lTb)
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb });
      AppMethodBeat.o(51523);
      return parama;
    }
    if (parama.blG < paramInt) {
      parama.blG += 1;
    }
    Object localObject2;
    if (paramq.isDirectory())
    {
      localObject2 = paramq.bOF();
      if (paramb != null) {
        break label922;
      }
      if ((paramMap != null) && (paramMap.size() > 0) && (paramMap.get(localObject2) != null))
      {
        paramb = new a.b((String)localObject2, ((Integer)paramMap.get(localObject2)).intValue());
        paramMap.remove(localObject2);
        localObject1 = paramb;
        if (paramb != null)
        {
          parama.FjQ.add(paramb);
          Log.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject2, parama, paramb });
        }
      }
    }
    label919:
    label922:
    for (Object localObject1 = paramb;; localObject1 = paramb)
    {
      parama.FjO += 1L;
      if (localObject1 != null) {
        ((a.b)localObject1).FjO += 1L;
      }
      if (paramc != null) {
        paramc.FjO += 1L;
      }
      int i;
      if (paramInt > 15)
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), paramq.bOF(), parama });
        AppMethodBeat.o(51523);
        return parama;
        localObject1 = paramq.ifA();
        if (com.tencent.mm.loader.j.b.aSL().equals((String)localObject1 + "/")) {
          i = 1;
        }
        for (;;)
        {
          if ((i != 0) && (!aPC((String)localObject2)))
          {
            if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", paramq.getName()))
            {
              paramb = new a.b((String)localObject2, 202);
              break;
              i = 0;
              continue;
            }
            if (Pattern.matches("[a-fA-F0-9]{32}", paramq.getName()))
            {
              paramb = new a.b((String)localObject2, 201);
              break;
            }
            paramb = new a.b((String)localObject2, 203);
            break;
          }
        }
        if (!aPC(paramq.ifA())) {
          break label919;
        }
        paramb = new a.b((String)localObject2, 203);
        break;
      }
      localObject2 = paramq.ifI();
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
            if (!Util.isNullOrNil(str))
            {
              paramc = paramb;
              if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str))
              {
                paramc = new a.c(paramq.bOF() + "/" + str);
                parama.FjR.add(paramc);
              }
            }
            a(new q(paramq.getPath() + "/" + str), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
            i += 1;
          }
        }
        int j = localObject2.length;
        i = 0;
        while (i < j)
        {
          paramb = localObject2[i];
          a(new q(paramq.bOF() + "/" + paramb), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
          i += 1;
        }
      }
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { paramq.bOF() });
      AppMethodBeat.o(51523);
      return parama;
      parama.FjP += 1L;
      if (paramb != null) {
        paramb.FjP += 1L;
      }
      if (paramc != null) {
        paramc.FjP += 1L;
      }
      if (!paramq.ifE())
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { paramq.bOF(), Long.valueOf(parama.FjP) });
        AppMethodBeat.o(51523);
        return parama;
      }
      long l = paramq.length();
      if ((l > 0L) && (l < 2147483648L))
      {
        parama.rKZ += l;
        if (paramb != null) {
          paramb.rKZ += l;
        }
        if (paramc != null) {
          paramc.rKZ = (l + paramc.rKZ);
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
          paramc.FjS += 1L;
        }
      }
      break;
    }
  }
  
  private static boolean a(HashMap<String, LinkedList<String>> paramHashMap, Map<String, Integer> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(193786);
    paramHashMap = (LinkedList)paramHashMap.get(paramString);
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.iterator();
      while (paramHashMap.hasNext()) {
        paramMap.put((String)paramHashMap.next(), Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(193786);
      return true;
    }
    AppMethodBeat.o(193786);
    return false;
  }
  
  private static boolean aPC(String paramString)
  {
    AppMethodBeat.i(51522);
    com.tencent.mm.kernel.h.aHH();
    if (com.tencent.mm.kernel.h.aHG().kcB.equals(paramString + "/"))
    {
      AppMethodBeat.o(51522);
      return true;
    }
    AppMethodBeat.o(51522);
    return false;
  }
  
  private void q(int paramInt, final long paramLong1, long paramLong2)
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
            l = this.Fkh | paramInt;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.Fkh), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.Fkh) {
              break label534;
            }
            if (this.Fkh == 0L) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label534;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 2L, 1L, true);
            break label534;
            this.Fkh = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            e.xi(bool);
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163487);
                if (!com.tencent.mm.kernel.h.aHB())
                {
                  AppMethodBeat.o(163487);
                  return;
                }
                CrashReportFactory.setHeavyUserFlag(l);
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Voy, Long.valueOf(l));
                if (paramLong1 != null)
                {
                  com.tencent.mm.kernel.h.aHH();
                  com.tencent.mm.kernel.h.aHG().aHp().set(paramLong1, Long.valueOf(this.uiH));
                }
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(l), Long.valueOf(b.s(b.this)), paramLong1, Long.valueOf(this.uiH) });
                AppMethodBeat.o(163487);
              }
            });
            AppMethodBeat.o(51524);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        final long l = this.Fkh & (paramInt ^ 0xFFFFFFFF);
        continue;
        ar.a locala = ar.a.VoA;
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label615;
        }
        paramLong2 = 3L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.VoB;
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label623;
        }
        paramLong2 = 5L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.VoC;
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label631;
        }
        paramLong2 = 7L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.VoD;
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label639;
        }
        paramLong2 = 9L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.VoE;
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label647;
        }
        paramLong2 = 11L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.VoF;
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label655;
        }
        paramLong2 = 13L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.VoG;
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool) {
          break label663;
        }
        paramLong2 = 15L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.VoH;
        localh = com.tencent.mm.plugin.report.service.h.IzE;
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
  
  private boolean uu(boolean paramBoolean)
  {
    AppMethodBeat.i(51519);
    Object localObject = com.tencent.mm.model.c.d.bgB().Mu("100212");
    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((com.tencent.mm.storage.c)localObject).isValid()), ((com.tencent.mm.storage.c)localObject).hvz(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(15L), Long.valueOf(1440L) });
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((com.tencent.mm.storage.c)localObject).hvz();
      long l1 = Util.getLong((String)((Map)localObject).get("sdsize"), 1024L);
      long l2 = Util.getLong((String)((Map)localObject).get("sdratio"), 10L);
      long l3 = Util.getLong((String)((Map)localObject).get("dbsize"), 1800L);
      long l4 = Util.getLong((String)((Map)localObject).get("fdbsize"), 1024L);
      long l5 = Util.getLong((String)((Map)localObject).get("msg"), 3000000L);
      long l6 = Util.getLong((String)((Map)localObject).get("conv"), 15000L);
      long l7 = Util.getLong((String)((Map)localObject).get("contact"), 100000L);
      long l8 = Util.getLong((String)((Map)localObject).get("chatroom"), 10000L);
      long l9 = Util.getLong((String)((Map)localObject).get("sditv"), 1440L);
      long l10 = Util.getLong((String)((Map)localObject).get("sdwait"), 15L);
      long l11 = Util.getLong((String)((Map)localObject).get("dbitv"), 1440L);
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.FjT), Long.valueOf(l1), Long.valueOf(this.FjU), Long.valueOf(l2), Long.valueOf(this.FjV), Long.valueOf(l3), Long.valueOf(this.Fka), Long.valueOf(l4), Long.valueOf(this.FjW), Long.valueOf(l5), Long.valueOf(this.FjX), Long.valueOf(l6), Long.valueOf(this.FjY), Long.valueOf(l7), Long.valueOf(this.FjZ), Long.valueOf(l8), Long.valueOf(this.Fkb), Long.valueOf(l9), Long.valueOf(this.Fkc), Long.valueOf(l10), Long.valueOf(this.Fkd), Long.valueOf(l11) });
      if (this.FjT != l1)
      {
        this.FjT = l1;
        bool = true;
        if (this.FjU != l2)
        {
          this.FjU = l2;
          bool = true;
        }
        if (this.FjV != l3)
        {
          this.FjV = l3;
          bool = true;
        }
        if (this.Fka != l4)
        {
          this.Fka = l4;
          bool = true;
        }
        if (this.FjW != l5)
        {
          this.FjW = l5;
          bool = true;
        }
        if (this.FjX != l6)
        {
          this.FjX = l6;
          bool = true;
        }
        if (this.FjY != l7)
        {
          this.FjY = l7;
          bool = true;
        }
        if (this.FjZ != l8)
        {
          this.FjZ = l8;
          bool = true;
        }
        if (this.Fkb != l9)
        {
          this.Fkb = l9;
          bool = true;
        }
        if (this.Fkc != l10)
        {
          this.Fkc = l10;
          bool = true;
        }
        if (this.Fkd != l11) {
          this.Fkd = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 0L, 1L, true);
        if (paramBoolean) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 18L, 1L, true);
        }
      }
      if (this.FjT <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 30L, 1L, true);
        this.FjT = 1024L;
      }
      if (this.FjU <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 31L, 1L, true);
        this.FjU = 10L;
      }
      if (this.FjV <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 32L, 1L, true);
        this.FjV = 1800L;
      }
      if (this.FjW <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 33L, 1L, true);
        this.FjW = 3000000L;
      }
      if (this.FjX <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 34L, 1L, true);
        this.FjX = 15000L;
      }
      if (this.FjY <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 35L, 1L, true);
        this.FjY = 100000L;
      }
      if (this.FjZ <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 36L, 1L, true);
        this.FjZ = 10000L;
      }
      if (this.Fkb <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 37L, 1L, true);
        this.Fkb = 1440L;
      }
      if (this.Fkc <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 38L, 1L, true);
        this.Fkc = 15L;
      }
      if (this.Fkd <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 39L, 1L, true);
        this.Fkd = 1440L;
      }
      if (this.Fka <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(509L, 40L, 1L, true);
        this.Fka = 1024L;
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
    EventCenter.instance.add(this.Dti);
    com.tencent.mm.model.c.d.bgB().add(this.lxt);
    boolean bool = uu(false);
    com.tencent.mm.kernel.h.aHH();
    this.Fkh = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Voy, Long.valueOf(0L))).longValue();
    CrashReportFactory.setHeavyUserFlag(this.Fkh);
    Object localObject1;
    Object localObject2;
    if (this.Fkh != 0L)
    {
      paramBoolean = true;
      e.xi(paramBoolean);
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.Fkh), Boolean.valueOf(bool), this.lxt });
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(989, this.Fki);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(988, this.Fki);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(987, this.Fki);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(986, this.Fki);
      com.tencent.mm.kernel.h.aHH();
      this.Fke = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vnu, Long.valueOf(0L))).longValue();
      localObject1 = MMApplicationContext.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label540;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label535;
      }
      paramBoolean = true;
      label281:
      this.cVD = paramBoolean;
      label286:
      this.sWW = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.sWX = new BroadcastReceiver()
      {
        public final void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(193817);
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i = -1;
          label92:
          boolean bool1;
          switch (paramAnonymousContext.hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              boolean bool2 = b.k(b.this);
              boolean bool3 = b.l(b.this);
              long l = b.m(b.this);
              if (b.b(b.this) == null)
              {
                bool1 = true;
                label132:
                Log.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramAnonymousContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
                bool1 = CrashReportFactory.hasDebuger();
                if ((b.b(b.this) != null) || (((!b.l(b.this)) || (b.k(b.this))) && (!(bool1 & false)))) {
                  break label486;
                }
                if (!CrashReportFactory.hasDebuger()) {
                  break label430;
                }
                b.n(b.this);
              }
              break;
            }
            break;
          }
          label430:
          while (System.currentTimeMillis() - b.m(b.this) >= b.o(b.this) * 60000L)
          {
            paramAnonymousContext = new a()
            {
              public final void a(int paramAnonymous2Int, a.a paramAnonymous2a)
              {
                AppMethodBeat.i(193818);
                b.a(b.this, System.currentTimeMillis());
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymous2Int), Long.valueOf(b.m(b.this)), b.p(b.this), paramAnonymous2a });
                b.a(b.this, null);
                if ((paramAnonymous2Int == 0) && (!paramAnonymous2a.lTb))
                {
                  com.tencent.mm.kernel.h.aHH();
                  com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vnu, Long.valueOf(b.m(b.this)));
                  com.tencent.mm.kernel.h.aHH();
                  com.tencent.mm.kernel.h.aHG().aHp().hxT();
                  try
                  {
                    b.b(b.this, paramAnonymous2a);
                    AppMethodBeat.o(193818);
                    return;
                  }
                  catch (Exception paramAnonymous2a)
                  {
                    Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymous2a, "doReportSDInfo err!", new Object[0]);
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(418L, 6L, 1L, true);
                  }
                }
                AppMethodBeat.o(193818);
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
                AppMethodBeat.i(193820);
                b.a(b.this, null);
                int i = bq.beT();
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
                if (i > 0) {
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(418L, 8L, 1L, true);
                }
                b.a(b.this, b.a(b.this, paramAnonymousContext));
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { b.p(b.this) });
                AppMethodBeat.o(193820);
              }
            });
            com.tencent.e.h.ZvG.a(b.b(b.this), b.q(b.this) * 60000L, "MicroMsg.SubCoreBaseMonitor");
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(b.q(b.this)) });
            AppMethodBeat.o(193817);
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
            bool1 = false;
            break label132;
          }
          Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(b.o(b.this)) });
          AppMethodBeat.o(193817);
          return;
          label486:
          if (b.b(b.this) != null)
          {
            b.b(b.this).cancel();
            b.a(b.this, null);
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { b.p(b.this) });
            AppMethodBeat.o(193817);
            return;
          }
          if (b.p(b.this) != null)
          {
            b.p(b.this).lTb = true;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { b.p(b.this) });
            b.a(b.this, null);
          }
          AppMethodBeat.o(193817);
        }
      };
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.TIME_SET");
      ((IntentFilter)localObject2).addAction("android.intent.action.DATE_CHANGED");
      ((Context)localObject1).registerReceiver(this.sWX, (IntentFilter)localObject2);
      if (this.Fkg == null) {
        break label548;
      }
      localObject1 = "enabled";
      label397:
      if (!this.sWW) {
        break label556;
      }
      localObject2 = "";
      label409:
      if (!this.cVD) {
        break label564;
      }
    }
    label535:
    label540:
    label548:
    label556:
    label564:
    for (String str = "";; str = " not")
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.Fke), Long.valueOf(this.Fkb * 60000L), Long.valueOf(this.Fkc * 60000L) });
      this.Fkl.stopTimer();
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        this.Fkm.startTimer(3000L, 10800000L);
      }
      com.tencent.matrix.c.a.Xf();
      AppMethodBeat.o(51520);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label281;
      this.cVD = false;
      break label286;
      localObject1 = "disabled";
      break label397;
      localObject2 = " not";
      break label409;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51521);
    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[] { Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()) });
    if (this.sWX != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(this.sWX);
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.sWX });
      this.sWX = null;
    }
    if (this.Fkf != null)
    {
      this.Fkf.cancel();
      this.Fkf = null;
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.Fkg });
    }
    if (this.Fkg != null)
    {
      this.Fkg.lTb = true;
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.Fkg });
      this.Fkg = null;
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(989, this.Fki);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(988, this.Fki);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(987, this.Fki);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(986, this.Fki);
    com.tencent.mm.model.c.d.bgB().remove(this.lxt);
    EventCenter.instance.removeListener(this.Dti);
    AppMethodBeat.o(51521);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b
 * JD-Core Version:    0.7.0.1
 */