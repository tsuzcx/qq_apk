package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bj;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
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
  implements ax
{
  private static final long startTime;
  private k.a hJv;
  private boolean ovK;
  private boolean ovL;
  private BroadcastReceiver ovM;
  private com.tencent.mm.sdk.b.c uER;
  private com.tencent.e.i.b vYA;
  private a.a vYB;
  private long vYC;
  private f vYD;
  private com.tencent.e.i.b vYE;
  private com.tencent.e.i.b vYF;
  private av vYG;
  private av vYH;
  private long vYo;
  private long vYp;
  private long vYq;
  private long vYr;
  private long vYs;
  private long vYt;
  private long vYu;
  private long vYv;
  private long vYw;
  private long vYx;
  private long vYy;
  private long vYz;
  
  static
  {
    AppMethodBeat.i(51537);
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(51537);
  }
  
  public b()
  {
    AppMethodBeat.i(51518);
    this.vYo = 1024L;
    this.vYp = 10L;
    this.vYq = 1800L;
    this.vYr = 3000000L;
    this.vYs = 15000L;
    this.vYt = 100000L;
    this.vYu = 10000L;
    this.vYv = 1024L;
    this.vYw = 1440L;
    this.vYx = 15L;
    this.vYy = 1440L;
    this.ovK = false;
    this.ovL = true;
    this.vYz = 0L;
    this.vYC = 0L;
    this.vYD = new b.1(this);
    this.hJv = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(51508);
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { bt.flS() });
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
          h.LTJ.r(new Runnable()
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
    this.vYE = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "reportAllRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(51509);
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        if (!com.tencent.mm.kernel.g.ajx())
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
        h.LTJ.r(b.g(b.this), 10000L);
        AppMethodBeat.o(51509);
      }
    };
    this.vYF = new b.11(this);
    this.uER = new b.12(this);
    this.vYG = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new b.13(this), true);
    this.vYH = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new b.14(this), true);
    AppMethodBeat.o(51518);
  }
  
  private a.a a(com.tencent.mm.vfs.e parame, a.a parama, a.b paramb, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(51523);
    if (parama.ieP)
    {
      ad.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb });
      AppMethodBeat.o(51523);
      return parama;
    }
    if (parama.bCc < paramInt) {
      parama.bCc += 1;
    }
    Object localObject2;
    if (parame.isDirectory())
    {
      localObject2 = com.tencent.mm.vfs.q.B(parame.fOK());
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
          parama.vYl.add(paramb);
          ad.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject2, parama, paramb });
        }
      }
    }
    label940:
    label943:
    for (Object localObject1 = paramb;; localObject1 = paramb)
    {
      parama.vYj += 1L;
      if (localObject1 != null) {
        ((a.b)localObject1).vYj += 1L;
      }
      if (paramc != null) {
        paramc.vYj += 1L;
      }
      int i;
      if (paramInt > 15)
      {
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.vfs.q.B(parame.fOK()), parama });
        AppMethodBeat.o(51523);
        return parama;
        localObject1 = parame.getParent();
        if (com.tencent.mm.loader.j.b.arU().equals((String)localObject1 + "/")) {
          i = 1;
        }
        for (;;)
        {
          if ((i != 0) && (!aqT((String)localObject2)))
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
        if (!aqT(parame.getParent())) {
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
                paramc = new a.c(com.tencent.mm.vfs.q.B(parame.fOK()) + "/" + str);
                parama.vYm.add(paramc);
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
          a(new com.tencent.mm.vfs.e(com.tencent.mm.vfs.q.B(parame.fOK()) + "/" + paramb), parama, (a.b)localObject1, paramc, paramMap, false, paramInt + 1);
          i += 1;
        }
      }
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { com.tencent.mm.vfs.q.B(parame.fOK()) });
      AppMethodBeat.o(51523);
      return parama;
      parama.vYk += 1L;
      if (paramb != null) {
        paramb.vYk += 1L;
      }
      if (paramc != null) {
        paramc.vYk += 1L;
      }
      if (!parame.exists())
      {
        ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { com.tencent.mm.vfs.q.B(parame.fOK()), Long.valueOf(parama.vYk) });
        AppMethodBeat.o(51523);
        return parama;
      }
      long l = parame.length();
      if ((l > 0L) && (l < 2147483648L))
      {
        parama.nsQ += l;
        if (paramb != null) {
          paramb.nsQ += l;
        }
        if (paramc != null) {
          paramc.nsQ = (l + paramc.nsQ);
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
          paramc.vYn += 1L;
        }
      }
      break;
    }
  }
  
  private static boolean a(HashMap<String, LinkedList<String>> paramHashMap, Map<String, Integer> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(192883);
    paramHashMap = (LinkedList)paramHashMap.get(paramString);
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.iterator();
      while (paramHashMap.hasNext()) {
        paramMap.put((String)paramHashMap.next(), Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(192883);
      return true;
    }
    AppMethodBeat.o(192883);
    return false;
  }
  
  private static boolean aqT(String paramString)
  {
    AppMethodBeat.i(51522);
    com.tencent.mm.kernel.g.ajD();
    if (com.tencent.mm.kernel.g.ajC().gBm.equals(paramString + "/"))
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
            l = this.vYC | paramInt;
            ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.vYC), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            if (l == this.vYC) {
              break label534;
            }
            if (this.vYC == 0L) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 1L, 1L, true);
            }
            if (l != 0L) {
              break label534;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 2L, 1L, true);
            break label534;
            this.vYC = l;
            if (l == 0L) {
              continue;
            }
            bool = true;
            com.tencent.mm.plugin.report.service.d.qo(bool);
            h.LTJ.aR(new b.7(this, l, locala, paramLong1));
            AppMethodBeat.o(51524);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        long l = this.vYC & (paramInt ^ 0xFFFFFFFF);
        continue;
        al.a locala = al.a.IxY;
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label615;
        }
        paramLong2 = 3L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = al.a.IxZ;
        localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label623;
        }
        paramLong2 = 5L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = al.a.Iya;
        localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label631;
        }
        paramLong2 = 7L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = al.a.Iyb;
        localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label639;
        }
        paramLong2 = 9L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = al.a.Iyc;
        localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label647;
        }
        paramLong2 = 11L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = al.a.Iyd;
        localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label655;
        }
        paramLong2 = 13L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = al.a.Iye;
        localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label663;
        }
        paramLong2 = 15L;
        localg.idkeyStat(509L, paramLong2, 1L, true);
        continue;
        locala = al.a.Iyf;
        localg = com.tencent.mm.plugin.report.service.g.yhR;
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
  
  private boolean oD(boolean paramBoolean)
  {
    AppMethodBeat.i(51519);
    Object localObject = com.tencent.mm.model.c.d.aDs().wz("100212");
    ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((com.tencent.mm.storage.c)localObject).isValid()), ((com.tencent.mm.storage.c)localObject).foF(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(15L), Long.valueOf(1440L) });
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((com.tencent.mm.storage.c)localObject).foF();
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
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.vYo), Long.valueOf(l1), Long.valueOf(this.vYp), Long.valueOf(l2), Long.valueOf(this.vYq), Long.valueOf(l3), Long.valueOf(this.vYv), Long.valueOf(l4), Long.valueOf(this.vYr), Long.valueOf(l5), Long.valueOf(this.vYs), Long.valueOf(l6), Long.valueOf(this.vYt), Long.valueOf(l7), Long.valueOf(this.vYu), Long.valueOf(l8), Long.valueOf(this.vYw), Long.valueOf(l9), Long.valueOf(this.vYx), Long.valueOf(l10), Long.valueOf(this.vYy), Long.valueOf(l11) });
      if (this.vYo != l1)
      {
        this.vYo = l1;
        bool = true;
        if (this.vYp != l2)
        {
          this.vYp = l2;
          bool = true;
        }
        if (this.vYq != l3)
        {
          this.vYq = l3;
          bool = true;
        }
        if (this.vYv != l4)
        {
          this.vYv = l4;
          bool = true;
        }
        if (this.vYr != l5)
        {
          this.vYr = l5;
          bool = true;
        }
        if (this.vYs != l6)
        {
          this.vYs = l6;
          bool = true;
        }
        if (this.vYt != l7)
        {
          this.vYt = l7;
          bool = true;
        }
        if (this.vYu != l8)
        {
          this.vYu = l8;
          bool = true;
        }
        if (this.vYw != l9)
        {
          this.vYw = l9;
          bool = true;
        }
        if (this.vYx != l10)
        {
          this.vYx = l10;
          bool = true;
        }
        if (this.vYy != l11) {
          this.vYy = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 0L, 1L, true);
        if (paramBoolean) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 18L, 1L, true);
        }
      }
      if (this.vYo <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 30L, 1L, true);
        this.vYo = 1024L;
      }
      if (this.vYp <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 31L, 1L, true);
        this.vYp = 10L;
      }
      if (this.vYq <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 32L, 1L, true);
        this.vYq = 1800L;
      }
      if (this.vYr <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 33L, 1L, true);
        this.vYr = 3000000L;
      }
      if (this.vYs <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 34L, 1L, true);
        this.vYs = 15000L;
      }
      if (this.vYt <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 35L, 1L, true);
        this.vYt = 100000L;
      }
      if (this.vYu <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 36L, 1L, true);
        this.vYu = 10000L;
      }
      if (this.vYw <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 37L, 1L, true);
        this.vYw = 1440L;
      }
      if (this.vYx <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 38L, 1L, true);
        this.vYx = 15L;
      }
      if (this.vYy <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 39L, 1L, true);
        this.vYy = 1440L;
      }
      if (this.vYv <= 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(509L, 40L, 1L, true);
        this.vYv = 1024L;
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
    com.tencent.mm.sdk.b.a.IbL.b(this.uER);
    com.tencent.mm.model.c.d.aDs().add(this.hJv);
    boolean bool = oD(false);
    com.tencent.mm.kernel.g.ajD();
    this.vYC = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxW, Long.valueOf(0L))).longValue();
    Object localObject1;
    Object localObject2;
    if (this.vYC != 0L)
    {
      paramBoolean = true;
      com.tencent.mm.plugin.report.service.d.qo(paramBoolean);
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.vYC), Boolean.valueOf(bool), this.hJv });
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(989, this.vYD);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(988, this.vYD);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(987, this.vYD);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(986, this.vYD);
      com.tencent.mm.kernel.g.ajD();
      this.vYz = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IwU, Long.valueOf(0L))).longValue();
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
      this.ovK = paramBoolean;
      label279:
      this.ovL = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.ovM = new BroadcastReceiver()
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
                ad.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramAnonymousContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
                bool1 = com.tencent.mm.sdk.a.b.fjN();
                if ((b.m(b.this) != null) || (((!b.k(b.this)) || (b.j(b.this))) && (!(bool1 & false)))) {
                  break label486;
                }
                if (!com.tencent.mm.sdk.a.b.fjN()) {
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
                ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymous2Int), Long.valueOf(b.l(b.this)), b.p(b.this), paramAnonymous2a });
                b.a(b.this, null);
                if ((paramAnonymous2Int == 0) && (!paramAnonymous2a.ieP))
                {
                  com.tencent.mm.kernel.g.ajD();
                  com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IwU, Long.valueOf(b.l(b.this)));
                  com.tencent.mm.kernel.g.ajD();
                  com.tencent.mm.kernel.g.ajC().ajl().fqc();
                  try
                  {
                    b.b(b.this, paramAnonymous2a);
                    AppMethodBeat.o(163490);
                    return;
                  }
                  catch (Exception paramAnonymous2a)
                  {
                    ad.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymous2a, "doReportSDInfo err!", new Object[0]);
                    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(418L, 6L, 1L, true);
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
                int i = bj.aCc();
                ad.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
                if (i > 0) {
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(418L, 8L, 1L, true);
                }
                b.a(b.this, b.a(b.this, paramAnonymousContext));
                ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { b.p(b.this) });
                AppMethodBeat.o(163491);
              }
            });
            h.LTJ.a(b.m(b.this), b.q(b.this) * 60000L, "MicroMsg.SubCoreBaseMonitor");
            ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(b.q(b.this)) });
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
          ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(b.o(b.this)) });
          AppMethodBeat.o(163492);
          return;
          label486:
          if (b.m(b.this) != null)
          {
            b.m(b.this).cancel();
            b.a(b.this, null);
            ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { b.p(b.this) });
            AppMethodBeat.o(163492);
            return;
          }
          if (b.p(b.this) != null)
          {
            b.p(b.this).ieP = true;
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
      ((Context)localObject1).registerReceiver(this.ovM, (IntentFilter)localObject2);
      if (this.vYB == null) {
        break label537;
      }
      localObject1 = "enabled";
      label390:
      if (!this.ovL) {
        break label545;
      }
      localObject2 = "";
      label402:
      if (!this.ovK) {
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
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.vYz), Long.valueOf(this.vYw * 60000L), Long.valueOf(this.vYx * 60000L) });
      this.vYG.stopTimer();
      if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
        this.vYH.az(3000L, 10800000L);
      }
      AppMethodBeat.o(51520);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label274;
      this.ovK = false;
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
    if (this.ovM != null)
    {
      aj.getContext().unregisterReceiver(this.ovM);
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.ovM });
      this.ovM = null;
    }
    if (this.vYA != null)
    {
      this.vYA.cancel();
      this.vYA = null;
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.vYB });
    }
    if (this.vYB != null)
    {
      this.vYB.ieP = true;
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.vYB });
      this.vYB = null;
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(989, this.vYD);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(988, this.vYD);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(987, this.vYD);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(986, this.vYD);
    com.tencent.mm.model.c.d.aDs().remove(this.hJv);
    com.tencent.mm.sdk.b.a.IbL.d(this.uER);
    AppMethodBeat.o(51521);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b
 * JD-Core Version:    0.7.0.1
 */