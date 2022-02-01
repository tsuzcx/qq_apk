package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.f;
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
import com.tencent.mm.storage.c;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
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
  implements bd
{
  private static final long startTime;
  private boolean cSX;
  private MStorage.IOnStorageChange iHr;
  private boolean pPV;
  private BroadcastReceiver pPW;
  private IListener yjg;
  private long zEU;
  private long zEV;
  private long zEW;
  private long zEX;
  private long zEY;
  private long zEZ;
  private long zFa;
  private long zFb;
  private long zFc;
  private long zFd;
  private long zFe;
  private long zFf;
  private com.tencent.f.i.b zFg;
  private a.a zFh;
  private long zFi;
  private com.tencent.mm.ak.i zFj;
  private com.tencent.f.i.b zFk;
  private com.tencent.f.i.b zFl;
  private MTimerHandler zFm;
  private MTimerHandler zFn;
  
  static
  {
    AppMethodBeat.i(51537);
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(51537);
  }
  
  public b()
  {
    AppMethodBeat.i(51518);
    this.zEU = 1024L;
    this.zEV = 10L;
    this.zEW = 1800L;
    this.zEX = 3000000L;
    this.zEY = 15000L;
    this.zEZ = 100000L;
    this.zFa = 10000L;
    this.zFb = 1024L;
    this.zFc = 1440L;
    this.zFd = 15L;
    this.zFe = 1440L;
    this.cSX = false;
    this.pPV = true;
    this.zFf = 0L;
    this.zFi = 0L;
    this.zFj = new b.1(this);
    this.iHr = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(51508);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { Util.getStack() });
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
          com.tencent.f.h.RTc.o(new Runnable()
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
    this.zFk = new com.tencent.f.i.b()
    {
      public final String getKey()
      {
        return "reportAllRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51509);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        if (!com.tencent.mm.kernel.g.aAc())
        {
          Log.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
          AppMethodBeat.o(51509);
          return;
        }
        b.b(b.this);
        b.c(b.this);
        b.d(b.this);
        b.e(b.this);
        b.f(b.this);
        b.g(b.this).cancel();
        com.tencent.f.h.RTc.o(b.g(b.this), 10000L);
        AppMethodBeat.o(51509);
      }
    };
    this.zFl = new com.tencent.f.i.b()
    {
      public final String getKey()
      {
        return "reportHeavyUser";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51510);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
        if (com.tencent.mm.kernel.g.aAc()) {
          b.h(b.this);
        }
        AppMethodBeat.o(51510);
      }
    };
    this.yjg = new IListener() {};
    this.zFm = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(51512);
        b.e(b.this);
        AppMethodBeat.o(51512);
        return true;
      }
    }, true);
    this.zFn = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new b.14(this), true);
    AppMethodBeat.o(51518);
  }
  
  private a.a a(o paramo, a.a parama, a.b paramb, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(51523);
    if (parama.jcC)
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb });
      AppMethodBeat.o(51523);
      return parama;
    }
    if (parama.bCe < paramInt) {
      parama.bCe += 1;
    }
    Object localObject2;
    if (paramo.isDirectory())
    {
      localObject2 = aa.z(paramo.her());
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
          parama.zER.add(paramb);
          Log.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject2, parama, paramb });
        }
      }
    }
    label940:
    label943:
    for (Object localObject1 = paramb;; localObject1 = paramb)
    {
      parama.zEP += 1L;
      if (localObject1 != null) {
        ((a.b)localObject1).zEP += 1L;
      }
      if (paramc != null) {
        paramc.zEP += 1L;
      }
      int i;
      if (paramInt > 15)
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), aa.z(paramo.her()), parama });
        AppMethodBeat.o(51523);
        return parama;
        localObject1 = paramo.getParent();
        if (com.tencent.mm.loader.j.b.aKJ().equals((String)localObject1 + "/")) {
          i = 1;
        }
        for (;;)
        {
          if ((i != 0) && (!aFs((String)localObject2)))
          {
            if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", paramo.getName()))
            {
              paramb = new a.b((String)localObject2, 202);
              break;
              i = 0;
              continue;
            }
            if (Pattern.matches("[a-fA-F0-9]{32}", paramo.getName()))
            {
              paramb = new a.b((String)localObject2, 201);
              break;
            }
            paramb = new a.b((String)localObject2, 203);
            break;
          }
        }
        if (!aFs(paramo.getParent())) {
          break label940;
        }
        paramb = new a.b((String)localObject2, 203);
        break;
      }
      localObject2 = paramo.list();
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
                paramc = new a.c(aa.z(paramo.her()) + "/" + str);
                parama.zES.add(paramc);
              }
            }
            a(new o(aa.z(paramo.mUri) + "/" + str), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
            i += 1;
          }
        }
        int j = localObject2.length;
        i = 0;
        while (i < j)
        {
          paramb = localObject2[i];
          a(new o(aa.z(paramo.her()) + "/" + paramb), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
          i += 1;
        }
      }
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { aa.z(paramo.her()) });
      AppMethodBeat.o(51523);
      return parama;
      parama.zEQ += 1L;
      if (paramb != null) {
        paramb.zEQ += 1L;
      }
      if (paramc != null) {
        paramc.zEQ += 1L;
      }
      if (!paramo.exists())
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { aa.z(paramo.her()), Long.valueOf(parama.zEQ) });
        AppMethodBeat.o(51523);
        return parama;
      }
      long l = paramo.length();
      if ((l > 0L) && (l < 2147483648L))
      {
        parama.oJj += l;
        if (paramb != null) {
          paramb.oJj += l;
        }
        if (paramc != null) {
          paramc.oJj = (l + paramc.oJj);
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
          paramc.zET += 1L;
        }
      }
      break;
    }
  }
  
  private static boolean a(HashMap<String, LinkedList<String>> paramHashMap, Map<String, Integer> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(214356);
    paramHashMap = (LinkedList)paramHashMap.get(paramString);
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.iterator();
      while (paramHashMap.hasNext()) {
        paramMap.put((String)paramHashMap.next(), Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(214356);
      return true;
    }
    AppMethodBeat.o(214356);
    return false;
  }
  
  private static boolean aFs(String paramString)
  {
    AppMethodBeat.i(51522);
    com.tencent.mm.kernel.g.aAi();
    if (com.tencent.mm.kernel.g.aAh().hqG.equals(paramString + "/"))
    {
      AppMethodBeat.o(51522);
      return true;
    }
    AppMethodBeat.o(51522);
    return false;
  }
  
  private void n(int paramInt, final long paramLong1, long paramLong2)
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
            l = this.zFi | paramInt;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.zFi), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.zFi) {
              break label534;
            }
            if (this.zFi == 0L) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label534;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 2L, 1L, true);
            break label534;
            this.zFi = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            com.tencent.mm.plugin.report.service.e.tM(bool);
            com.tencent.f.h.RTc.aX(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(51506);
                if (!com.tencent.mm.kernel.g.aAc())
                {
                  AppMethodBeat.o(51506);
                  return;
                }
                CrashReportFactory.setHeavyUserFlag(l);
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oaw, Long.valueOf(l));
                if (paramLong1 != null)
                {
                  com.tencent.mm.kernel.g.aAi();
                  com.tencent.mm.kernel.g.aAh().azQ().set(paramLong1, Long.valueOf(this.qJC));
                }
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(l), Long.valueOf(b.s(b.this)), paramLong1, Long.valueOf(this.qJC) });
                AppMethodBeat.o(51506);
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
        final long l = this.zFi & (paramInt ^ 0xFFFFFFFF);
        continue;
        ar.a locala = ar.a.Oay;
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label615;
        }
        paramLong2 = 3L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.Oaz;
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label623;
        }
        paramLong2 = 5L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.OaA;
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label631;
        }
        paramLong2 = 7L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.OaB;
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label639;
        }
        paramLong2 = 9L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.OaC;
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label647;
        }
        paramLong2 = 11L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.OaD;
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label655;
        }
        paramLong2 = 13L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.OaE;
        localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool) {
          break label663;
        }
        paramLong2 = 15L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = ar.a.OaF;
        localh = com.tencent.mm.plugin.report.service.h.CyF;
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
  
  private boolean rq(boolean paramBoolean)
  {
    AppMethodBeat.i(51519);
    Object localObject = com.tencent.mm.model.c.d.aXu().Fu("100212");
    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((c)localObject).isValid()), ((c)localObject).gzz(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(15L), Long.valueOf(1440L) });
    if (((c)localObject).isValid())
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((c)localObject).gzz();
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
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.zEU), Long.valueOf(l1), Long.valueOf(this.zEV), Long.valueOf(l2), Long.valueOf(this.zEW), Long.valueOf(l3), Long.valueOf(this.zFb), Long.valueOf(l4), Long.valueOf(this.zEX), Long.valueOf(l5), Long.valueOf(this.zEY), Long.valueOf(l6), Long.valueOf(this.zEZ), Long.valueOf(l7), Long.valueOf(this.zFa), Long.valueOf(l8), Long.valueOf(this.zFc), Long.valueOf(l9), Long.valueOf(this.zFd), Long.valueOf(l10), Long.valueOf(this.zFe), Long.valueOf(l11) });
      if (this.zEU != l1)
      {
        this.zEU = l1;
        bool = true;
        if (this.zEV != l2)
        {
          this.zEV = l2;
          bool = true;
        }
        if (this.zEW != l3)
        {
          this.zEW = l3;
          bool = true;
        }
        if (this.zFb != l4)
        {
          this.zFb = l4;
          bool = true;
        }
        if (this.zEX != l5)
        {
          this.zEX = l5;
          bool = true;
        }
        if (this.zEY != l6)
        {
          this.zEY = l6;
          bool = true;
        }
        if (this.zEZ != l7)
        {
          this.zEZ = l7;
          bool = true;
        }
        if (this.zFa != l8)
        {
          this.zFa = l8;
          bool = true;
        }
        if (this.zFc != l9)
        {
          this.zFc = l9;
          bool = true;
        }
        if (this.zFd != l10)
        {
          this.zFd = l10;
          bool = true;
        }
        if (this.zFe != l11) {
          this.zFe = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 0L, 1L, true);
        if (paramBoolean) {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 18L, 1L, true);
        }
      }
      if (this.zEU <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 30L, 1L, true);
        this.zEU = 1024L;
      }
      if (this.zEV <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 31L, 1L, true);
        this.zEV = 10L;
      }
      if (this.zEW <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 32L, 1L, true);
        this.zEW = 1800L;
      }
      if (this.zEX <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 33L, 1L, true);
        this.zEX = 3000000L;
      }
      if (this.zEY <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 34L, 1L, true);
        this.zEY = 15000L;
      }
      if (this.zEZ <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 35L, 1L, true);
        this.zEZ = 100000L;
      }
      if (this.zFa <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 36L, 1L, true);
        this.zFa = 10000L;
      }
      if (this.zFc <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 37L, 1L, true);
        this.zFc = 1440L;
      }
      if (this.zFd <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 38L, 1L, true);
        this.zFd = 15L;
      }
      if (this.zFe <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 39L, 1L, true);
        this.zFe = 1440L;
      }
      if (this.zFb <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(509L, 40L, 1L, true);
        this.zFb = 1024L;
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
    EventCenter.instance.add(this.yjg);
    com.tencent.mm.model.c.d.aXu().add(this.iHr);
    boolean bool = rq(false);
    com.tencent.mm.kernel.g.aAi();
    this.zFi = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oaw, Long.valueOf(0L))).longValue();
    CrashReportFactory.setHeavyUserFlag(this.zFi);
    Object localObject1;
    Object localObject2;
    if (this.zFi != 0L)
    {
      paramBoolean = true;
      com.tencent.mm.plugin.report.service.e.tM(paramBoolean);
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.zFi), Boolean.valueOf(bool), this.iHr });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(989, this.zFj);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(988, this.zFj);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(987, this.zFj);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(986, this.zFj);
      com.tencent.mm.kernel.g.aAi();
      this.zFf = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NZu, Long.valueOf(0L))).longValue();
      localObject1 = MMApplicationContext.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label536;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label531;
      }
      paramBoolean = true;
      label281:
      this.cSX = paramBoolean;
      label286:
      this.pPV = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.pPW = new BroadcastReceiver()
      {
        public final void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(163492);
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
              boolean bool2 = b.j(b.this);
              boolean bool3 = b.k(b.this);
              long l = b.l(b.this);
              if (b.m(b.this) == null)
              {
                bool1 = true;
                label132:
                Log.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramAnonymousContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
                bool1 = CrashReportFactory.hasDebuger();
                if ((b.m(b.this) != null) || (((!b.k(b.this)) || (b.j(b.this))) && (!(bool1 & false)))) {
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
          while (System.currentTimeMillis() - b.l(b.this) >= b.o(b.this) * 60000L)
          {
            paramAnonymousContext = new a()
            {
              public final void a(int paramAnonymous2Int, a.a paramAnonymous2a)
              {
                AppMethodBeat.i(163490);
                b.a(b.this, System.currentTimeMillis());
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymous2Int), Long.valueOf(b.l(b.this)), b.p(b.this), paramAnonymous2a });
                b.a(b.this, null);
                if ((paramAnonymous2Int == 0) && (!paramAnonymous2a.jcC))
                {
                  com.tencent.mm.kernel.g.aAi();
                  com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NZu, Long.valueOf(b.l(b.this)));
                  com.tencent.mm.kernel.g.aAi();
                  com.tencent.mm.kernel.g.aAh().azQ().gBI();
                  try
                  {
                    b.b(b.this, paramAnonymous2a);
                    AppMethodBeat.o(163490);
                    return;
                  }
                  catch (Exception paramAnonymous2a)
                  {
                    Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymous2a, "doReportSDInfo err!", new Object[0]);
                    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(418L, 6L, 1L, true);
                  }
                }
                AppMethodBeat.o(163490);
              }
            };
            b.a(b.this, new com.tencent.f.i.b()
            {
              public final String getKey()
              {
                return "autoScanRemove";
              }
              
              public final void run()
              {
                AppMethodBeat.i(163491);
                b.a(b.this, null);
                int i = bp.aVQ();
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
                if (i > 0) {
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(418L, 8L, 1L, true);
                }
                b.a(b.this, b.a(b.this, paramAnonymousContext));
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { b.p(b.this) });
                AppMethodBeat.o(163491);
              }
            });
            com.tencent.f.h.RTc.a(b.m(b.this), b.q(b.this) * 60000L, "MicroMsg.SubCoreBaseMonitor");
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(b.q(b.this)) });
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
            bool1 = false;
            break label132;
          }
          Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(b.o(b.this)) });
          AppMethodBeat.o(163492);
          return;
          label486:
          if (b.m(b.this) != null)
          {
            b.m(b.this).cancel();
            b.a(b.this, null);
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { b.p(b.this) });
            AppMethodBeat.o(163492);
            return;
          }
          if (b.p(b.this) != null)
          {
            b.p(b.this).jcC = true;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { b.p(b.this) });
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
      ((Context)localObject1).registerReceiver(this.pPW, (IntentFilter)localObject2);
      if (this.zFh == null) {
        break label544;
      }
      localObject1 = "enabled";
      label397:
      if (!this.pPV) {
        break label552;
      }
      localObject2 = "";
      label409:
      if (!this.cSX) {
        break label560;
      }
    }
    label531:
    label536:
    label544:
    label552:
    label560:
    for (String str = "";; str = " not")
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.zFf), Long.valueOf(this.zFc * 60000L), Long.valueOf(this.zFd * 60000L) });
      this.zFm.stopTimer();
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        this.zFn.startTimer(3000L, 10800000L);
      }
      AppMethodBeat.o(51520);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label281;
      this.cSX = false;
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
    if (this.pPW != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(this.pPW);
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.pPW });
      this.pPW = null;
    }
    if (this.zFg != null)
    {
      this.zFg.cancel();
      this.zFg = null;
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.zFh });
    }
    if (this.zFh != null)
    {
      this.zFh.jcC = true;
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.zFh });
      this.zFh = null;
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(989, this.zFj);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(988, this.zFj);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(987, this.zFj);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(986, this.zFj);
    com.tencent.mm.model.c.d.aXu().remove(this.iHr);
    EventCenter.instance.removeListener(this.yjg);
    AppMethodBeat.o(51521);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b
 * JD-Core Version:    0.7.0.1
 */