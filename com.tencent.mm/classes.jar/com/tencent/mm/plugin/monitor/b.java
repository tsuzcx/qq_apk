package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class b
  implements ar
{
  private static final long startTime = ;
  private j.a dYS = new j.a()
  {
    public final void a(String paramAnonymousString, l paramAnonymousl)
    {
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { bk.csb() });
      if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
        g.DS().k(new b.8.1(this), 100L);
      }
    }
  };
  private boolean ijm = false;
  private boolean ijn = true;
  private BroadcastReceiver ijo;
  private Runnable ijp;
  private long mrR = 1024L;
  private long mrS = 10L;
  private long mrT = 1800L;
  private long mrU = 3000000L;
  private long mrV = 15000L;
  private long mrW = 100000L;
  private long mrX = 10000L;
  private long mrY = 1024L;
  private long mrZ = 1440L;
  private long msa = 20L;
  private long msb = 1440L;
  private long msc = 0L;
  private a.a msd;
  private long mse = 0L;
  private f msf = new b.1(this);
  private Runnable msh = new b.9(this);
  private Runnable msi = new b.10(this);
  private com.tencent.mm.sdk.b.c msj = new b.11(this);
  private am msk = new am(g.DS().mnU.getLooper(), new b.12(this), true);
  
  private a.a a(com.tencent.mm.vfs.b paramb, a.a parama, a.b paramb1, a.c paramc, Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    if (parama.esC)
    {
      y.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[] { parama, paramb1 });
      return parama;
    }
    if (parama.aOn < paramInt) {
      parama.aOn += 1;
    }
    Object localObject;
    if (paramb.isDirectory())
    {
      localObject = j.n(paramb.cLr());
      if ((paramb1 != null) || (paramMap == null) || (paramMap.size() <= 0) || (paramMap.get(localObject) == null)) {
        break label830;
      }
      paramb1 = new a.b((String)localObject, ((Integer)paramMap.get(localObject)).intValue());
      paramMap.remove(localObject);
      parama.mrO.add(paramb1);
      y.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[] { localObject, parama, paramb1 });
    }
    label441:
    label827:
    label830:
    for (;;)
    {
      parama.mrL += 1L;
      if (paramb1 != null) {
        paramb1.mrL += 1L;
      }
      if (paramc != null) {
        paramc.mrL += 1L;
      }
      if (paramInt > 15)
      {
        y.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[] { Integer.valueOf(paramInt), j.n(paramb.cLr()), parama });
        return parama;
      }
      String[] arrayOfString = paramb.list();
      int j;
      if (arrayOfString != null)
      {
        if (paramBoolean)
        {
          j = arrayOfString.length;
          i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            localObject = paramc;
            if (!bk.bl(str))
            {
              localObject = paramc;
              if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str))
              {
                localObject = new a.c(j.n(paramb.cLr()) + "/" + str);
                parama.mrP.add(localObject);
              }
            }
            a(new com.tencent.mm.vfs.b(j.n(paramb.mUri) + "/" + str), parama, paramb1, (a.c)localObject, paramMap, false, paramInt + 1);
            i += 1;
            paramc = (a.c)localObject;
          }
          break;
        }
        int i = 1;
        int k = arrayOfString.length;
        j = 0;
        if (j < k)
        {
          localObject = arrayOfString[j];
          a(new com.tencent.mm.vfs.b(j.n(paramb.cLr()) + "/" + (String)localObject), parama, paramb1, paramc, paramMap, false, paramInt + 1);
          if ((i == 0) || (parama.aOn <= 15)) {
            break label827;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.a(418L, 7L, 1L, true);
          com.tencent.mm.plugin.report.service.h.nFQ.f(13778, new Object[] { Integer.valueOf(2), Integer.valueOf(2), j.n(paramb.cLr()) + "/" + (String)localObject });
          i = 0;
        }
      }
      for (;;)
      {
        j += 1;
        break label441;
        break;
        y.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", new Object[] { j.n(paramb.cLr()) });
        return parama;
        parama.mrM += 1L;
        if (paramb1 != null) {
          paramb1.mrM += 1L;
        }
        if (paramc != null) {
          paramc.mrM += 1L;
        }
        if (!paramb.exists())
        {
          y.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", new Object[] { j.n(paramb.cLr()), Long.valueOf(parama.mrM) });
          return parama;
        }
        long l = paramb.length();
        if ((l > 0L) && (l < 2147483648L))
        {
          parama.hFz += l;
          if (paramb1 != null) {
            paramb1.hFz += l;
          }
          if (paramc == null) {
            break;
          }
          paramc.hFz = (l + paramc.hFz);
          return parama;
        }
        parama.fileLenInvalidCount += 1L;
        if (paramb1 != null) {
          paramb1.fileLenInvalidCount += 1L;
        }
        if (paramc == null) {
          break;
        }
        paramc.mrQ += 1L;
        return parama;
      }
    }
  }
  
  private boolean hC(boolean paramBoolean)
  {
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100212");
    y.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(((com.tencent.mm.storage.c)localObject).isValid()), ((com.tencent.mm.storage.c)localObject).ctr(), Long.valueOf(1024L), Long.valueOf(10L), Long.valueOf(1800L), Long.valueOf(3000000L), Long.valueOf(15000L), Long.valueOf(15000L), Long.valueOf(100000L), Long.valueOf(10000L), Long.valueOf(1440L), Long.valueOf(20L), Long.valueOf(1440L) });
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
      localObject = ((com.tencent.mm.storage.c)localObject).ctr();
      long l1 = bk.getLong((String)((Map)localObject).get("sdsize"), 1024L);
      long l2 = bk.getLong((String)((Map)localObject).get("sdratio"), 10L);
      long l3 = bk.getLong((String)((Map)localObject).get("dbsize"), 1800L);
      long l4 = bk.getLong((String)((Map)localObject).get("fdbsize"), 1024L);
      long l5 = bk.getLong((String)((Map)localObject).get("msg"), 3000000L);
      long l6 = bk.getLong((String)((Map)localObject).get("conv"), 15000L);
      long l7 = bk.getLong((String)((Map)localObject).get("contact"), 100000L);
      long l8 = bk.getLong((String)((Map)localObject).get("chatroom"), 10000L);
      long l9 = bk.getLong((String)((Map)localObject).get("sditv"), 1440L);
      long l10 = bk.getLong((String)((Map)localObject).get("sdwait"), 20L);
      long l11 = bk.getLong((String)((Map)localObject).get("dbitv"), 1440L);
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", new Object[] { Long.valueOf(this.mrR), Long.valueOf(l1), Long.valueOf(this.mrS), Long.valueOf(l2), Long.valueOf(this.mrT), Long.valueOf(l3), Long.valueOf(this.mrY), Long.valueOf(l4), Long.valueOf(this.mrU), Long.valueOf(l5), Long.valueOf(this.mrV), Long.valueOf(l6), Long.valueOf(this.mrW), Long.valueOf(l7), Long.valueOf(this.mrX), Long.valueOf(l8), Long.valueOf(this.mrZ), Long.valueOf(l9), Long.valueOf(this.msa), Long.valueOf(l10), Long.valueOf(this.msb), Long.valueOf(l11) });
      if (this.mrR != l1)
      {
        this.mrR = l1;
        bool = true;
        if (this.mrS != l2)
        {
          this.mrS = l2;
          bool = true;
        }
        if (this.mrT != l3)
        {
          this.mrT = l3;
          bool = true;
        }
        if (this.mrY != l4)
        {
          this.mrY = l4;
          bool = true;
        }
        if (this.mrU != l5)
        {
          this.mrU = l5;
          bool = true;
        }
        if (this.mrV != l6)
        {
          this.mrV = l6;
          bool = true;
        }
        if (this.mrW != l7)
        {
          this.mrW = l7;
          bool = true;
        }
        if (this.mrX != l8)
        {
          this.mrX = l8;
          bool = true;
        }
        if (this.mrZ != l9)
        {
          this.mrZ = l9;
          bool = true;
        }
        if (this.msa != l10)
        {
          this.msa = l10;
          bool = true;
        }
        if (this.msb != l11) {
          this.msb = l11;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 0L, 1L, true);
        if (paramBoolean) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 18L, 1L, true);
        }
      }
      if (this.mrR <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 30L, 1L, true);
        this.mrR = 1024L;
      }
      if (this.mrS <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 31L, 1L, true);
        this.mrS = 10L;
      }
      if (this.mrT <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 32L, 1L, true);
        this.mrT = 1800L;
      }
      if (this.mrU <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 33L, 1L, true);
        this.mrU = 3000000L;
      }
      if (this.mrV <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 34L, 1L, true);
        this.mrV = 15000L;
      }
      if (this.mrW <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 35L, 1L, true);
        this.mrW = 100000L;
      }
      if (this.mrX <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 36L, 1L, true);
        this.mrX = 10000L;
      }
      if (this.mrZ <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 37L, 1L, true);
        this.mrZ = 1440L;
      }
      if (this.msa <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 38L, 1L, true);
        this.msa = 20L;
      }
      if (this.msb <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 39L, 1L, true);
        this.msb = 1440L;
      }
      if (this.mrY <= 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 40L, 1L, true);
        this.mrY = 1024L;
      }
      return bool;
      bool = false;
      break;
    }
  }
  
  private void i(int paramInt, long paramLong1, long paramLong2)
  {
    boolean bool;
    if (paramLong1 > paramLong2)
    {
      bool = true;
      if (!bool) {
        break label205;
      }
    }
    label171:
    ac.a locala;
    label205:
    com.tencent.mm.plugin.report.service.h localh;
    for (;;)
    {
      long l;
      label239:
      label379:
      try
      {
        l = this.mse | paramInt;
        y.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool), Long.valueOf(this.mse), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
        if (l == this.mse) {
          break label520;
        }
        if (this.mse == 0L) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 1L, 1L, true);
        }
        if (l != 0L) {
          break label520;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(509L, 2L, 1L, true);
      }
      finally {}
      this.mse = l;
      if (l != 0L)
      {
        bool = true;
        com.tencent.mm.plugin.report.service.e.iw(bool);
        g.DS().O(new b.6(this, l, locala, paramLong1));
        return;
        bool = false;
        break;
        l = this.mse & (paramInt ^ 0xFFFFFFFF);
        continue;
        locala = ac.a.uvb;
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label603;
        }
        paramLong2 = 3L;
        localh.a(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.uvc;
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label611;
        }
        paramLong2 = 5L;
        label274:
        localh.a(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.uvd;
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label619;
        }
        paramLong2 = 7L;
        label309:
        localh.a(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.uve;
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label627;
        }
        paramLong2 = 9L;
        label344:
        localh.a(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.uvf;
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label635;
        }
        paramLong2 = 11L;
        localh.a(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.uvg;
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label643;
        }
        paramLong2 = 13L;
        label414:
        localh.a(509L, paramLong2, 1L, true);
        continue;
        locala = ac.a.uvh;
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label651;
        }
      }
    }
    label520:
    label651:
    for (paramLong2 = 15L;; paramLong2 = 16L)
    {
      localh.a(509L, paramLong2, 1L, true);
      break;
      locala = ac.a.uvi;
      localh = com.tencent.mm.plugin.report.service.h.nFQ;
      if (bool) {}
      for (paramLong2 = 19L;; paramLong2 = 20L)
      {
        localh.a(509L, paramLong2, 1L, true);
        break;
      }
      bool = false;
      break label171;
      Object localObject2 = null;
      switch (paramInt)
      {
      }
      break;
      label603:
      paramLong2 = 4L;
      break label239;
      label611:
      paramLong2 = 6L;
      break label274;
      label619:
      paramLong2 = 8L;
      break label309;
      label627:
      paramLong2 = 10L;
      break label344;
      label635:
      paramLong2 = 12L;
      break label379;
      paramLong2 = 14L;
      break label414;
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a.udP.b(this.msj);
    com.tencent.mm.model.c.c.IX().c(this.dYS);
    boolean bool = hC(false);
    g.DQ();
    this.mse = ((Long)g.DP().Dz().get(ac.a.uuZ, Long.valueOf(0L))).longValue();
    Object localObject1;
    Object localObject2;
    if (this.mse != 0L)
    {
      paramBoolean = true;
      com.tencent.mm.plugin.report.service.e.iw(paramBoolean);
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", new Object[] { Long.valueOf(this.mse), Boolean.valueOf(bool), this.dYS });
      localObject1 = ae.getContext().getSharedPreferences("hardcoder_setting", 0);
      g.DQ();
      g.DN();
      int i = com.tencent.mm.kernel.a.CK();
      if (i != 0)
      {
        g.DQ();
        g.DN();
        int j = com.tencent.mm.a.h.aT(com.tencent.mm.kernel.a.CK(), 100);
        if (j != ((SharedPreferences)localObject1).getInt("KEY_HC_UIN_HASH", 0))
        {
          y.i("MicroMsg.SubCoreBaseMonitor", "summerhv hardcoder uin[%d, %d] reloadSPConfig", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((SharedPreferences)localObject1).edit().putInt("KEY_HC_UIN_HASH", j).apply();
          WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_POST_RESET);
        }
      }
      g.DQ();
      g.DO().dJT.a(989, this.msf);
      g.DQ();
      g.DO().dJT.a(988, this.msf);
      g.DQ();
      g.DO().dJT.a(987, this.msf);
      g.DQ();
      g.DO().dJT.a(986, this.msf);
      g.DQ();
      this.msc = ((Long)g.DP().Dz().get(ac.a.uue, Long.valueOf(0L))).longValue();
      localObject1 = ae.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label607;
      }
      i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label602;
      }
      paramBoolean = true;
      label383:
      this.ijm = paramBoolean;
      label388:
      this.ijn = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.ijo = new b.13(this);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.TIME_SET");
      ((IntentFilter)localObject2).addAction("android.intent.action.DATE_CHANGED");
      ((Context)localObject1).registerReceiver(this.ijo, (IntentFilter)localObject2);
      if (this.msd == null) {
        break label615;
      }
      localObject1 = "enabled";
      label499:
      if (!this.ijn) {
        break label623;
      }
      localObject2 = "";
      label511:
      if (!this.ijm) {
        break label631;
      }
    }
    label602:
    label607:
    label615:
    label623:
    label631:
    for (String str = "";; str = " not")
    {
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", new Object[] { localObject1, localObject2, str, Long.valueOf(this.msc), Long.valueOf(this.mrZ * 60000L), Long.valueOf(this.msa * 60000L) });
      this.msk.stopTimer();
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label383;
      this.ijm = false;
      break label388;
      localObject1 = "disabled";
      break label499;
      localObject2 = " not";
      break label511;
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", new Object[] { Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()) });
    if (this.ijo != null)
    {
      ae.getContext().unregisterReceiver(this.ijo);
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[] { this.ijo });
      this.ijo = null;
    }
    if (this.ijp != null)
    {
      g.DS().crf().removeCallbacks(this.ijp);
      this.ijp = null;
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", new Object[] { this.msd });
    }
    if (this.msd != null)
    {
      this.msd.esC = true;
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", new Object[] { this.msd });
      this.msd = null;
    }
    g.DQ();
    g.DO().dJT.b(989, this.msf);
    g.DQ();
    g.DO().dJT.b(988, this.msf);
    g.DQ();
    g.DO().dJT.b(987, this.msf);
    g.DQ();
    g.DO().dJT.b(986, this.msf);
    com.tencent.mm.model.c.c.IX().d(this.dYS);
    com.tencent.mm.sdk.b.a.udP.d(this.msj);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b
 * JD-Core Version:    0.7.0.1
 */