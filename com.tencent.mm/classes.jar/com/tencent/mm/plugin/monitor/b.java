package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bl;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
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
  implements az
{
  private static final long startTime;
  private k.a hMo;
  private boolean oCl;
  private boolean oCm;
  private BroadcastReceiver oCn;
  private com.tencent.mm.sdk.b.c uQE;
  private long wkA;
  private long wkB;
  private long wkC;
  private long wkD;
  private com.tencent.e.i.b wkE;
  private a.a wkF;
  private long wkG;
  private f wkH;
  private com.tencent.e.i.b wkI;
  private com.tencent.e.i.b wkJ;
  private aw wkK;
  private aw wkL;
  private long wks;
  private long wkt;
  private long wku;
  private long wkv;
  private long wkw;
  private long wkx;
  private long wky;
  private long wkz;
  
  static
  {
    AppMethodBeat.i(51537);
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(51537);
  }
  
  public b()
  {
    AppMethodBeat.i(51518);
    this.wks = 1024L;
    this.wkt = 10L;
    this.wku = 1800L;
    this.wkv = 3000000L;
    this.wkw = 15000L;
    this.wkx = 100000L;
    this.wky = 10000L;
    this.wkz = 1024L;
    this.wkA = 1440L;
    this.wkB = 15L;
    this.wkC = 1440L;
    this.oCl = false;
    this.oCm = true;
    this.wkD = 0L;
    this.wkG = 0L;
    this.wkH = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(51500);
        if (paramAnonymousn == null) {}
        for (int i = -1;; i = paramAnonymousn.getType())
        {
          ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            h.MqF.aO(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(51499);
                com.tencent.mm.plugin.report.service.d.dNE();
                AppMethodBeat.o(51499);
              }
            });
          }
          AppMethodBeat.o(51500);
          return;
        }
      }
    };
    this.hMo = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(51508);
        ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { bu.fpN() });
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
          h.MqF.r(new Runnable()
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
    this.wkI = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "reportAllRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51509);
        ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        if (!com.tencent.mm.kernel.g.ajM())
        {
          ae.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
          AppMethodBeat.o(51509);
          return;
        }
        b.b(b.this);
        b.c(b.this);
        b.d(b.this);
        b.e(b.this);
        b.f(b.this);
        b.g(b.this).cancel();
        h.MqF.r(b.g(b.this), 10000L);
        AppMethodBeat.o(51509);
      }
    };
    this.wkJ = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "reportHeavyUser";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51510);
        ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
        if (com.tencent.mm.kernel.g.ajM()) {
          b.h(b.this);
        }
        AppMethodBeat.o(51510);
      }
    };
    this.uQE = new b.12(this);
    this.wkK = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new b.13(this), true);
    this.wkL = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new b.14(this), true);
    AppMethodBeat.o(51518);
  }
  
  private a.a a(k paramk, a.a parama, a.b paramb, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(51523);
    if (parama.ihH)
    {
      ae.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb });
      AppMethodBeat.o(51523);
      return parama;
    }
    if (parama.bCc < paramInt) {
      parama.bCc += 1;
    }
    Object localObject2;
    if (paramk.isDirectory())
    {
      localObject2 = w.B(paramk.fTh());
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
          parama.wkp.add(paramb);
          ae.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject2, parama, paramb });
        }
      }
    }
    label940:
    label943:
    for (Object localObject1 = paramb;; localObject1 = paramb)
    {
      parama.wkn += 1L;
      if (localObject1 != null) {
        ((a.b)localObject1).wkn += 1L;
      }
      if (paramc != null) {
        paramc.wkn += 1L;
      }
      int i;
      if (paramInt > 15)
      {
        ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), w.B(paramk.fTh()), parama });
        AppMethodBeat.o(51523);
        return parama;
        localObject1 = paramk.getParent();
        if (com.tencent.mm.loader.j.b.asj().equals((String)localObject1 + "/")) {
          i = 1;
        }
        for (;;)
        {
          if ((i != 0) && (!arY((String)localObject2)))
          {
            if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", paramk.getName()))
            {
              paramb = new a.b((String)localObject2, 202);
              break;
              i = 0;
              continue;
            }
            if (Pattern.matches("[a-fA-F0-9]{32}", paramk.getName()))
            {
              paramb = new a.b((String)localObject2, 201);
              break;
            }
            paramb = new a.b((String)localObject2, 203);
            break;
          }
        }
        if (!arY(paramk.getParent())) {
          break label940;
        }
        paramb = new a.b((String)localObject2, 203);
        break;
      }
      localObject2 = paramk.list();
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
            if (!bu.isNullOrNil(str))
            {
              paramc = paramb;
              if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str))
              {
                paramc = new a.c(w.B(paramk.fTh()) + "/" + str);
                parama.wkq.add(paramc);
              }
            }
            a(new k(w.B(paramk.mUri) + "/" + str), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
            i += 1;
          }
        }
        int j = localObject2.length;
        i = 0;
        while (i < j)
        {
          paramb = localObject2[i];
          a(new k(w.B(paramk.fTh()) + "/" + paramb), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
          i += 1;
        }
      }
      ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { w.B(paramk.fTh()) });
      AppMethodBeat.o(51523);
      return parama;
      parama.wko += 1L;
      if (paramb != null) {
        paramb.wko += 1L;
      }
      if (paramc != null) {
        paramc.wko += 1L;
      }
      if (!paramk.exists())
      {
        ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { w.B(paramk.fTh()), Long.valueOf(parama.wko) });
        AppMethodBeat.o(51523);
        return parama;
      }
      long l = paramk.length();
      if ((l > 0L) && (l < 2147483648L))
      {
        parama.nyl += l;
        if (paramb != null) {
          paramb.nyl += l;
        }
        if (paramc != null) {
          paramc.nyl = (l + paramc.nyl);
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
          paramc.wkr += 1L;
        }
      }
      break;
    }
  }
  
  private static boolean a(HashMap<String, LinkedList<String>> paramHashMap, Map<String, Integer> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(221758);
    paramHashMap = (LinkedList)paramHashMap.get(paramString);
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.iterator();
      while (paramHashMap.hasNext()) {
        paramMap.put((String)paramHashMap.next(), Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(221758);
      return true;
    }
    AppMethodBeat.o(221758);
    return false;
  }
  
  private static boolean arY(String paramString)
  {
    AppMethodBeat.i(51522);
    com.tencent.mm.kernel.g.ajS();
    if (com.tencent.mm.kernel.g.ajR().gDT.equals(paramString + "/"))
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
            l = this.wkG | paramInt;
            ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.wkG), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.wkG) {
              break label534;
            }
            if (this.wkG == 0L) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label534;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 2L, 1L, true);
            break label534;
            this.wkG = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            com.tencent.mm.plugin.report.service.d.qv(bool);
            h.MqF.aO(new b.7(this, l, locala, paramLong1));
            AppMethodBeat.o(51524);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        long l = this.wkG & (paramInt ^ 0xFFFFFFFF);
        continue;
        am.a locala = am.a.ISw;
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label615;
        }
        paramLong2 = 3L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = am.a.ISx;
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label623;
        }
        paramLong2 = 5L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = am.a.ISy;
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label631;
        }
        paramLong2 = 7L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = am.a.ISz;
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label639;
        }
        paramLong2 = 9L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = am.a.ISA;
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label647;
        }
        paramLong2 = 11L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = am.a.ISB;
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label655;
        }
        paramLong2 = 13L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = am.a.ISC;
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label663;
        }
        paramLong2 = 15L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = am.a.ISD;
        localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (bool)
        {
          paramLong2 = 19L;
          localg.idkeyStat(509L, paramLong2, 1L, true);
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
  
  private boolean oI(boolean paramBoolean)
  {
    AppMethodBeat.i(51519);
    Object localObject = com.tencent.mm.model.c.d.aDI().xi("100212");
    ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((com.tencent.mm.storage.c)localObject).isValid()), ((com.tencent.mm.storage.c)localObject).fsy(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(15L), Long.valueOf(1440L) });
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((com.tencent.mm.storage.c)localObject).fsy();
      long l1 = bu.getLong((String)((Map)localObject).get("sdsize"), 1024L);
      long l2 = bu.getLong((String)((Map)localObject).get("sdratio"), 10L);
      long l3 = bu.getLong((String)((Map)localObject).get("dbsize"), 1800L);
      long l4 = bu.getLong((String)((Map)localObject).get("fdbsize"), 1024L);
      long l5 = bu.getLong((String)((Map)localObject).get("msg"), 3000000L);
      long l6 = bu.getLong((String)((Map)localObject).get("conv"), 15000L);
      long l7 = bu.getLong((String)((Map)localObject).get("contact"), 100000L);
      long l8 = bu.getLong((String)((Map)localObject).get("chatroom"), 10000L);
      long l9 = bu.getLong((String)((Map)localObject).get("sditv"), 1440L);
      long l10 = bu.getLong((String)((Map)localObject).get("sdwait"), 15L);
      long l11 = bu.getLong((String)((Map)localObject).get("dbitv"), 1440L);
      ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.wks), Long.valueOf(l1), Long.valueOf(this.wkt), Long.valueOf(l2), Long.valueOf(this.wku), Long.valueOf(l3), Long.valueOf(this.wkz), Long.valueOf(l4), Long.valueOf(this.wkv), Long.valueOf(l5), Long.valueOf(this.wkw), Long.valueOf(l6), Long.valueOf(this.wkx), Long.valueOf(l7), Long.valueOf(this.wky), Long.valueOf(l8), Long.valueOf(this.wkA), Long.valueOf(l9), Long.valueOf(this.wkB), Long.valueOf(l10), Long.valueOf(this.wkC), Long.valueOf(l11) });
      if (this.wks != l1)
      {
        this.wks = l1;
        bool = true;
        if (this.wkt != l2)
        {
          this.wkt = l2;
          bool = true;
        }
        if (this.wku != l3)
        {
          this.wku = l3;
          bool = true;
        }
        if (this.wkz != l4)
        {
          this.wkz = l4;
          bool = true;
        }
        if (this.wkv != l5)
        {
          this.wkv = l5;
          bool = true;
        }
        if (this.wkw != l6)
        {
          this.wkw = l6;
          bool = true;
        }
        if (this.wkx != l7)
        {
          this.wkx = l7;
          bool = true;
        }
        if (this.wky != l8)
        {
          this.wky = l8;
          bool = true;
        }
        if (this.wkA != l9)
        {
          this.wkA = l9;
          bool = true;
        }
        if (this.wkB != l10)
        {
          this.wkB = l10;
          bool = true;
        }
        if (this.wkC != l11) {
          this.wkC = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 0L, 1L, true);
        if (paramBoolean) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 18L, 1L, true);
        }
      }
      if (this.wks <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 30L, 1L, true);
        this.wks = 1024L;
      }
      if (this.wkt <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 31L, 1L, true);
        this.wkt = 10L;
      }
      if (this.wku <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 32L, 1L, true);
        this.wku = 1800L;
      }
      if (this.wkv <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 33L, 1L, true);
        this.wkv = 3000000L;
      }
      if (this.wkw <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 34L, 1L, true);
        this.wkw = 15000L;
      }
      if (this.wkx <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 35L, 1L, true);
        this.wkx = 100000L;
      }
      if (this.wky <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 36L, 1L, true);
        this.wky = 10000L;
      }
      if (this.wkA <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 37L, 1L, true);
        this.wkA = 1440L;
      }
      if (this.wkB <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 38L, 1L, true);
        this.wkB = 15L;
      }
      if (this.wkC <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 39L, 1L, true);
        this.wkC = 1440L;
      }
      if (this.wkz <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(509L, 40L, 1L, true);
        this.wkz = 1024L;
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
    com.tencent.mm.sdk.b.a.IvT.b(this.uQE);
    com.tencent.mm.model.c.d.aDI().add(this.hMo);
    boolean bool = oI(false);
    com.tencent.mm.kernel.g.ajS();
    this.wkG = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISu, Long.valueOf(0L))).longValue();
    Object localObject1;
    Object localObject2;
    if (this.wkG != 0L)
    {
      paramBoolean = true;
      com.tencent.mm.plugin.report.service.d.qv(paramBoolean);
      ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.wkG), Boolean.valueOf(bool), this.hMo });
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(989, this.wkH);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(988, this.wkH);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(987, this.wkH);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(986, this.wkH);
      com.tencent.mm.kernel.g.ajS();
      this.wkD = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRs, Long.valueOf(0L))).longValue();
      localObject1 = ak.getContext();
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
      this.oCl = paramBoolean;
      label279:
      this.oCm = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.oCn = new BroadcastReceiver()
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
                ae.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramAnonymousContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
                bool1 = com.tencent.mm.sdk.a.b.fnF();
                if ((b.m(b.this) != null) || (((!b.k(b.this)) || (b.j(b.this))) && (!(bool1 & false)))) {
                  break label486;
                }
                if (!com.tencent.mm.sdk.a.b.fnF()) {
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
                ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymous2Int), Long.valueOf(b.l(b.this)), b.p(b.this), paramAnonymous2a });
                b.a(b.this, null);
                if ((paramAnonymous2Int == 0) && (!paramAnonymous2a.ihH))
                {
                  com.tencent.mm.kernel.g.ajS();
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IRs, Long.valueOf(b.l(b.this)));
                  com.tencent.mm.kernel.g.ajS();
                  com.tencent.mm.kernel.g.ajR().ajA().fuc();
                  try
                  {
                    b.b(b.this, paramAnonymous2a);
                    AppMethodBeat.o(163490);
                    return;
                  }
                  catch (Exception paramAnonymous2a)
                  {
                    ae.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymous2a, "doReportSDInfo err!", new Object[0]);
                    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(418L, 6L, 1L, true);
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
                int i = bl.aCs();
                ae.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
                if (i > 0) {
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(418L, 8L, 1L, true);
                }
                b.a(b.this, b.a(b.this, paramAnonymousContext));
                ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { b.p(b.this) });
                AppMethodBeat.o(163491);
              }
            });
            h.MqF.a(b.m(b.this), b.q(b.this) * 60000L, "MicroMsg.SubCoreBaseMonitor");
            ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(b.q(b.this)) });
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
          ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(b.o(b.this)) });
          AppMethodBeat.o(163492);
          return;
          label486:
          if (b.m(b.this) != null)
          {
            b.m(b.this).cancel();
            b.a(b.this, null);
            ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { b.p(b.this) });
            AppMethodBeat.o(163492);
            return;
          }
          if (b.p(b.this) != null)
          {
            b.p(b.this).ihH = true;
            ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { b.p(b.this) });
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
      ((Context)localObject1).registerReceiver(this.oCn, (IntentFilter)localObject2);
      if (this.wkF == null) {
        break label537;
      }
      localObject1 = "enabled";
      label390:
      if (!this.oCm) {
        break label545;
      }
      localObject2 = "";
      label402:
      if (!this.oCl) {
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
      ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.wkD), Long.valueOf(this.wkA * 60000L), Long.valueOf(this.wkB * 60000L) });
      this.wkK.stopTimer();
      if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {
        this.wkL.ay(3000L, 10800000L);
      }
      AppMethodBeat.o(51520);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label274;
      this.oCl = false;
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
    ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[] { Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()) });
    if (this.oCn != null)
    {
      ak.getContext().unregisterReceiver(this.oCn);
      ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.oCn });
      this.oCn = null;
    }
    if (this.wkE != null)
    {
      this.wkE.cancel();
      this.wkE = null;
      ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.wkF });
    }
    if (this.wkF != null)
    {
      this.wkF.ihH = true;
      ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.wkF });
      this.wkF = null;
    }
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(989, this.wkH);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(988, this.wkH);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(987, this.wkH);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(986, this.wkH);
    com.tencent.mm.model.c.d.aDI().remove(this.hMo);
    com.tencent.mm.sdk.b.a.IvT.d(this.uQE);
    AppMethodBeat.o(51521);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b
 * JD-Core Version:    0.7.0.1
 */