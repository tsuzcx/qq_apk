package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.be;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.i;
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

public class c
  implements be
{
  private static final long startTime;
  private IListener Jmz;
  private long LfF;
  private long LfG;
  private long LfH;
  private long LfI;
  private long LfJ;
  private long LfK;
  private long LfL;
  private long LfM;
  private long LfN;
  private long LfO;
  private long LfP;
  private long LfQ;
  private com.tencent.threadpool.i.b LfR;
  private a.a LfS;
  private long LfT;
  private com.tencent.mm.am.h LfU;
  private com.tencent.threadpool.i.b LfV;
  private com.tencent.threadpool.i.b LfW;
  private MTimerHandler LfX;
  private MTimerHandler LfY;
  private boolean eRu;
  private boolean wbn;
  private BroadcastReceiver wbo;
  
  static
  {
    AppMethodBeat.i(51537);
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(51537);
  }
  
  public c()
  {
    AppMethodBeat.i(51518);
    this.LfF = 4096L;
    this.LfG = 30L;
    this.LfH = 1536L;
    this.LfI = 300000L;
    this.LfJ = 1000L;
    this.LfK = 25000L;
    this.LfL = 200L;
    this.LfM = 256L;
    this.LfN = 1440L;
    this.LfO = 20L;
    this.LfP = 1440L;
    this.eRu = false;
    this.wbn = true;
    this.LfQ = 0L;
    this.LfT = 0L;
    this.LfU = new c.1(this);
    this.LfV = new com.tencent.threadpool.i.b()
    {
      public final String getKey()
      {
        return "reportAllRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51509);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        if (!com.tencent.mm.kernel.h.baz())
        {
          Log.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
          AppMethodBeat.o(51509);
          return;
        }
        c.b(c.this);
        c.c(c.this);
        c.d(c.this);
        c.e(c.this);
        c.f(c.this);
        c.g(c.this).cancel();
        com.tencent.threadpool.h.ahAA.p(c.g(c.this), 10000L);
        AppMethodBeat.o(51509);
      }
    };
    this.LfW = new c.11(this);
    this.Jmz = new SubCoreBaseMonitor.5(this, com.tencent.mm.app.f.hfK);
    this.LfX = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new c.12(this), true);
    this.LfY = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new c.13(this), true);
    AppMethodBeat.o(51518);
  }
  
  private a.a a(u paramu, a.a parama, a.b paramb, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(51523);
    if (parama.oLU)
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb });
      AppMethodBeat.o(51523);
      return parama;
    }
    if (parama.aOm < paramInt) {
      parama.aOm += 1;
    }
    Object localObject2;
    if (paramu.isDirectory())
    {
      localObject2 = ah.v(paramu.jKT());
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
          parama.Lfn.add(paramb);
          Log.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject2, parama, paramb });
        }
      }
    }
    label940:
    label943:
    for (Object localObject1 = paramb;; localObject1 = paramb)
    {
      parama.Lfl += 1L;
      if (localObject1 != null) {
        ((a.b)localObject1).Lfl += 1L;
      }
      if (paramc != null) {
        paramc.Lfl += 1L;
      }
      int i;
      if (paramInt > 15)
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), ah.v(paramu.jKT()), parama });
        AppMethodBeat.o(51523);
        return parama;
        localObject1 = paramu.jKO();
        if (com.tencent.mm.loader.i.b.bmz().equals((String)localObject1 + "/")) {
          i = 1;
        }
        for (;;)
        {
          if ((i != 0) && (!aMA((String)localObject2)))
          {
            if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", paramu.getName()))
            {
              paramb = new a.b((String)localObject2, 202);
              break;
              i = 0;
              continue;
            }
            if (Pattern.matches("[a-fA-F0-9]{32}", paramu.getName()))
            {
              paramb = new a.b((String)localObject2, 201);
              break;
            }
            paramb = new a.b((String)localObject2, 203);
            break;
          }
        }
        if (!aMA(paramu.jKO())) {
          break label940;
        }
        paramb = new a.b((String)localObject2, 203);
        break;
      }
      localObject2 = paramu.jKW();
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
                paramc = new a.c(ah.v(paramu.jKT()) + "/" + str);
                parama.Lfo.add(paramc);
              }
            }
            a(new u(ah.v(paramu.mUri) + "/" + str), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
            i += 1;
          }
        }
        int j = localObject2.length;
        i = 0;
        while (i < j)
        {
          paramb = localObject2[i];
          a(new u(ah.v(paramu.jKT()) + "/" + paramb), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
          i += 1;
        }
      }
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { ah.v(paramu.jKT()) });
      AppMethodBeat.o(51523);
      return parama;
      parama.Lfm += 1L;
      if (paramb != null) {
        paramb.Lfm += 1L;
      }
      if (paramc != null) {
        paramc.Lfm += 1L;
      }
      if (!paramu.jKS())
      {
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { ah.v(paramu.jKT()), Long.valueOf(parama.Lfm) });
        AppMethodBeat.o(51523);
        return parama;
      }
      long l = paramu.length();
      if ((l > 0L) && (l < 2147483648L))
      {
        parama.uWn += l;
        if (paramb != null) {
          paramb.uWn += l;
        }
        if (paramc != null) {
          paramc.uWn = (l + paramc.uWn);
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
          paramc.Lfp += 1L;
        }
      }
      break;
    }
  }
  
  private static boolean a(HashMap<String, LinkedList<String>> paramHashMap, Map<String, Integer> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(266696);
    paramHashMap = (LinkedList)paramHashMap.get(paramString);
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.iterator();
      while (paramHashMap.hasNext()) {
        paramMap.put((String)paramHashMap.next(), Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(266696);
      return true;
    }
    AppMethodBeat.o(266696);
    return false;
  }
  
  private static boolean aMA(String paramString)
  {
    AppMethodBeat.i(51522);
    com.tencent.mm.kernel.h.baF();
    if (com.tencent.mm.kernel.h.baE().mCJ.equals(paramString + "/"))
    {
      AppMethodBeat.o(51522);
      return true;
    }
    AppMethodBeat.o(51522);
    return false;
  }
  
  private void p(int paramInt, long paramLong1, long paramLong2)
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
            l = this.LfT | paramInt;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.LfT), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.LfT) {
              break label534;
            }
            if (this.LfT == 0L) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label534;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(509L, 2L, 1L, true);
            break label534;
            this.LfT = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            e.BJ(bool);
            com.tencent.threadpool.h.ahAA.bm(new c.7(this, l, locala, paramLong1));
            AppMethodBeat.o(51524);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        long l = this.LfT & (paramInt ^ 0xFFFFFFFF);
        continue;
        at.a locala = at.a.acPW;
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label615;
        }
        paramLong2 = 3L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = at.a.acPX;
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label623;
        }
        paramLong2 = 5L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = at.a.acPY;
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label631;
        }
        paramLong2 = 7L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = at.a.acPZ;
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label639;
        }
        paramLong2 = 9L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = at.a.acQa;
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label647;
        }
        paramLong2 = 11L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = at.a.acQb;
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label655;
        }
        paramLong2 = 13L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = at.a.acQc;
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label663;
        }
        paramLong2 = 15L;
        localh.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = at.a.acQd;
        localh = com.tencent.mm.plugin.report.service.h.OAn;
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
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(51520);
    this.Jmz.alive();
    Log.i("MicroMsg.SubCoreBaseMonitor", "HeavyUserCfg sd[%d] sdr[%d] db[%d] fdbsize[%d] msg[%d] conv[%d] contact[%d] chatroom[%d] sditv[%d] sdwait[%d] dbitv[%d]", new Object[] { Long.valueOf(this.LfF), Long.valueOf(this.LfG), Long.valueOf(this.LfH), Long.valueOf(this.LfM), Long.valueOf(this.LfI), Long.valueOf(this.LfJ), Long.valueOf(this.LfK), Long.valueOf(this.LfL), Long.valueOf(this.LfN), Long.valueOf(this.LfO), Long.valueOf(this.LfP) });
    com.tencent.mm.kernel.h.baF();
    this.LfT = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPU, Long.valueOf(0L))).longValue();
    CrashReportFactory.setHeavyUserFlag(this.LfT);
    Object localObject1;
    Object localObject2;
    if (this.LfT != 0L)
    {
      paramBoolean = true;
      e.BJ(paramBoolean);
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d]", new Object[] { Long.valueOf(this.LfT) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(989, this.LfU);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(988, this.LfU);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(987, this.LfU);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(986, this.LfU);
      com.tencent.mm.kernel.h.baF();
      this.LfQ = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOP, Long.valueOf(0L))).longValue();
      localObject1 = MMApplicationContext.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label652;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label647;
      }
      paramBoolean = true;
      label373:
      this.eRu = paramBoolean;
      label378:
      this.wbn = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.wbo = new BroadcastReceiver()
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
              boolean bool2 = c.j(c.this);
              boolean bool3 = c.k(c.this);
              long l = c.l(c.this);
              if (c.a(c.this) == null)
              {
                bool1 = true;
                label132:
                Log.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramAnonymousContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
                bool1 = CrashReportFactory.hasDebuger();
                if ((c.a(c.this) != null) || (((!c.k(c.this)) || (c.j(c.this))) && (!(bool1 & false)))) {
                  break label486;
                }
                if (!CrashReportFactory.hasDebuger()) {
                  break label430;
                }
                c.m(c.this);
              }
              break;
            }
            break;
          }
          label430:
          while (System.currentTimeMillis() - c.l(c.this) >= c.n(c.this) * 60000L)
          {
            paramAnonymousContext = new a()
            {
              public final void a(int paramAnonymous2Int, a.a paramAnonymous2a)
              {
                AppMethodBeat.i(163490);
                c.a(c.this, System.currentTimeMillis());
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymous2Int), Long.valueOf(c.l(c.this)), c.o(c.this), paramAnonymous2a });
                c.a(c.this, null);
                if ((paramAnonymous2Int == 0) && (!paramAnonymous2a.oLU))
                {
                  com.tencent.mm.kernel.h.baF();
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acOP, Long.valueOf(c.l(c.this)));
                  com.tencent.mm.kernel.h.baF();
                  com.tencent.mm.kernel.h.baE().ban().iZy();
                  try
                  {
                    c.b(c.this, paramAnonymous2a);
                    AppMethodBeat.o(163490);
                    return;
                  }
                  catch (Exception paramAnonymous2a)
                  {
                    Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymous2a, "doReportSDInfo err!", new Object[0]);
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(418L, 6L, 1L, true);
                  }
                }
                AppMethodBeat.o(163490);
              }
            };
            c.a(c.this, new com.tencent.threadpool.i.b()
            {
              public final String getKey()
              {
                return "autoScanRemove";
              }
              
              public final void run()
              {
                AppMethodBeat.i(163491);
                c.a(c.this, null);
                int i = br.bCK();
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
                if (i > 0) {
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(418L, 8L, 1L, true);
                }
                c.a(c.this, c.a(c.this, paramAnonymousContext));
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { c.o(c.this) });
                AppMethodBeat.o(163491);
              }
            });
            com.tencent.threadpool.h.ahAA.a(c.a(c.this), c.p(c.this) * 60000L, "MicroMsg.SubCoreBaseMonitor");
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(c.p(c.this)) });
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
            c.a(c.this, true);
            break label92;
            c.a(c.this, false);
            break label92;
            c.b(c.this, true);
            break label92;
            c.b(c.this, false);
            break label92;
            bool1 = false;
            break label132;
          }
          Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(c.n(c.this)) });
          AppMethodBeat.o(163492);
          return;
          label486:
          if (c.a(c.this) != null)
          {
            c.a(c.this).cancel();
            c.a(c.this, null);
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { c.o(c.this) });
            AppMethodBeat.o(163492);
            return;
          }
          if (c.o(c.this) != null)
          {
            c.o(c.this).oLU = true;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { c.o(c.this) });
            c.a(c.this, null);
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
      ((Context)localObject1).registerReceiver(this.wbo, (IntentFilter)localObject2);
      if (this.LfS == null) {
        break label660;
      }
      localObject1 = "enabled";
      label486:
      if (!this.wbn) {
        break label667;
      }
      localObject2 = "";
      label498:
      if (!this.eRu) {
        break label675;
      }
    }
    label647:
    label652:
    label660:
    label667:
    label675:
    for (String str = "";; str = " not")
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.LfQ), Long.valueOf(this.LfN * 60000L), Long.valueOf(this.LfO * 60000L) });
      this.LfX.stopTimer();
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        this.LfY.startTimer(3000L, 10800000L);
      }
      if (com.tencent.matrix.c.a.aym())
      {
        localObject1 = new c.9(this);
        if (com.tencent.matrix.a.b.isInit()) {
          com.tencent.matrix.a.b.awt().a((b.c)localObject1);
        }
      }
      AppMethodBeat.o(51520);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label373;
      this.eRu = false;
      break label378;
      localObject1 = "disabled";
      break label486;
      localObject2 = " not";
      break label498;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51521);
    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[] { Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()) });
    if (this.wbo != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(this.wbo);
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.wbo });
      this.wbo = null;
    }
    if (this.LfR != null)
    {
      this.LfR.cancel();
      this.LfR = null;
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.LfS });
    }
    if (this.LfS != null)
    {
      this.LfS.oLU = true;
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.LfS });
      this.LfS = null;
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(989, this.LfU);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(988, this.LfU);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(987, this.LfU);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(986, this.LfU);
    this.Jmz.dead();
    AppMethodBeat.o(51521);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c
 * JD-Core Version:    0.7.0.1
 */