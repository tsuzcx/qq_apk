package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.TrafficStats;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainProcessChecker
  extends AbstractProcessChecker
{
  private static final long[] AUC = { 0L, 86400000L };
  private static String AUJ = "";
  private float AUA;
  private boolean AUB;
  private long AUD;
  private int AUE;
  private long AUF;
  private StringBuilder AUG;
  private boolean AUH;
  private long AUI;
  private long AUt;
  private long AUu;
  private long AUv;
  private long AUw;
  private int AUx;
  private float AUy;
  private int AUz;
  private boolean ded;
  private boolean isHardMode;
  private long wxMobileRx;
  private long wxMobileTx;
  private long wxWifiRx;
  private long wxWifiTx;
  
  public MainProcessChecker()
  {
    AppMethodBeat.i(124985);
    this.AUt = 1048576L;
    this.AUu = 6000L;
    this.AUv = 734003200L;
    this.AUw = this.AUv;
    this.AUx = 92;
    this.AUy = (this.AUx * 0.01F);
    this.AUz = 85;
    this.AUA = (this.AUz * 0.01F);
    this.ded = false;
    this.isHardMode = true;
    this.AUB = false;
    this.AUE = 1;
    this.AUG = new StringBuilder();
    this.AUH = false;
    this.AUI = 0L;
    AppMethodBeat.o(124985);
  }
  
  public static void aJX(String paramString)
  {
    AUJ = paramString;
  }
  
  private void eCu()
  {
    AppMethodBeat.i(124993);
    this.wxMobileTx = TrafficStats.getWxMobileTx(0L);
    this.wxMobileRx = TrafficStats.getWxMobileRx(0L);
    this.wxWifiTx = TrafficStats.getWxWifiTx(0L);
    this.wxWifiRx = TrafficStats.getWxWifiRx(0L);
    this.AUD = Sr();
    AppMethodBeat.o(124993);
  }
  
  private static boolean hK(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  private void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(124992);
    if ((!MMApplicationContext.isMMProcess()) || (!this.ded))
    {
      AppMethodBeat.o(124992);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey;
    if (paramBoolean)
    {
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetKey(0);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetKey(2);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (hK(this.AUE, 64))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (hK(this.AUE, 256))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(4);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (hK(this.AUE, 128))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(5);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (!hK(this.AUE, 4)) {
        break label475;
      }
      localIDKey.SetKey(106);
    }
    for (;;)
    {
      e.Cxv.b(localArrayList, false);
      AppMethodBeat.o(124992);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (hK(this.AUE, 8))
      {
        localIDKey.SetKey(100);
        break;
      }
      if (hK(this.AUE, 16))
      {
        localIDKey.SetKey(101);
        break;
      }
      if (hK(this.AUE, 32))
      {
        localIDKey.SetKey(102);
        break;
      }
      if (hK(this.AUE, 512))
      {
        localIDKey.SetKey(103);
        break;
      }
      if (hK(this.AUE, 1024))
      {
        localIDKey.SetKey(104);
        break;
      }
      if ((hK(this.AUE, 64)) || (hK(this.AUE, 128)) || (hK(this.AUE, 256)))
      {
        localIDKey.SetKey(105);
        break;
      }
      localArrayList.remove(localIDKey);
      break;
      label475:
      localIDKey.SetKey(107);
    }
  }
  
  public final boolean af(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(124989);
    this.ded = true;
    Log.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.cQp) });
    label1077:
    for (;;)
    {
      try
      {
        if (!this.ded)
        {
          this.AUE |= 0x0;
          return false;
        }
        if (Util.isNullOrNil(this.AUh.AUk))
        {
          Log.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
          this.AUE |= 0x2;
          return false;
        }
        if (this.cQp)
        {
          Log.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
          this.AUE |= 0x4;
          return false;
        }
        if (SystemClock.uptimeMillis() - this.AUI >= paramLong2)
        {
          i = 1;
          if (i == 0)
          {
            Log.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", new Object[] { Long.valueOf(paramLong2) });
            this.AUE |= 0x4;
            return false;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        paramLong1 = System.currentTimeMillis();
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(11, 0);
        localCalendar.set(13, 0);
        localCalendar.set(12, 0);
        localCalendar.set(14, 0);
        paramLong1 -= localCalendar.getTimeInMillis();
        if (!b.DEBUG)
        {
          if ((AUC[0] <= paramLong1) && (paramLong1 <= AUC[1]))
          {
            break label1077;
            if (i == 0)
            {
              Log.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", new Object[] { Long.valueOf(AUC[0]), Long.valueOf(AUC[1]) });
              this.AUE |= 0x8;
              return false;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.AUB) {
            if ((!this.cQp) && (AUJ.equalsIgnoreCase(this.AUh.AUk)))
            {
              i = 1;
              if (i == 0)
              {
                Log.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                this.AUE |= 0x10;
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (eCt())
          {
            this.AUE |= 0x20;
            return false;
          }
          if (this.isHardMode)
          {
            paramLong1 = TrafficStats.getWxMobileTx(this.wxMobileTx) + TrafficStats.getWxMobileRx(this.wxMobileRx) + TrafficStats.getWxWifiTx(this.wxWifiTx) + TrafficStats.getWxMobileRx(this.wxWifiRx);
            Log.i(getTag(), "[isTraffic] diff:%s byte", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 > 1.0F * (float)paramLong2 / 60000.0F * (float)this.AUt)
            {
              i = 1;
              if (i != 0)
              {
                this.AUE |= 0x200;
                Log.i(getTag(), "is over Traffic, just return");
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (this.isHardMode)
          {
            paramLong1 = Sr() - this.AUD;
            Log.i(getTag(), "[isCpuBusy] diff:%s Jiffies", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 >= 1.0F * (float)paramLong2 / 60000.0F * (float)this.AUu)
            {
              i = 1;
              if (i != 0)
              {
                this.AUE |= 0x400;
                Log.i(getTag(), "is cpu busy, just return");
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          paramLong1 = Runtime.getRuntime().maxMemory();
          paramLong2 = Runtime.getRuntime().totalMemory();
          boolean bool1 = false;
          Log.i(getTag(), "[isOverMemory] java[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong2 / (float)paramLong1), Float.valueOf(this.AUA) });
          if (1.0F * (float)paramLong2 / (float)paramLong1 >= this.AUA)
          {
            this.AUE |= 0x40;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (!this.AUH)
          {
            paramLong1 = TN();
            Log.i(getTag(), "[isOverMemory] vm[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong1 / 4.294967E+009F), Float.valueOf(this.AUy) });
            bool2 = bool1;
            if (1.0F * (float)paramLong1 / 4.294967E+009F >= this.AUy)
            {
              this.AUE |= 0x100;
              bool2 = true;
            }
          }
          paramLong1 = Debug.getNativeHeapSize();
          Log.w(getTag(), "[isOverMemory] native[%s:%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.AUw) });
          if (paramLong1 > this.AUw)
          {
            i = 1;
            if (i != 0)
            {
              this.AUE |= 0x80;
              bool2 = true;
            }
            eCu();
            hd(bool2);
            this.AUE = 1;
            AppMethodBeat.o(124989);
            return bool2;
          }
          i = 0;
          continue;
        }
        int i = 1;
      }
      finally
      {
        eCu();
        hd(false);
        this.AUE = 1;
        AppMethodBeat.o(124989);
      }
    }
  }
  
  public final void cy(boolean paramBoolean)
  {
    AppMethodBeat.i(124990);
    super.cy(paramBoolean);
    Log.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.AUI = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(124990);
  }
  
  protected final String eCq()
  {
    AppMethodBeat.i(124987);
    Object localObject = new StringBuilder(this.AUG);
    ((StringBuilder)localObject).append(super.eCq());
    HashMap localHashMap = new HashMap();
    int i = aD(localHashMap);
    if (i >= 300)
    {
      ((StringBuilder)localObject).append("threadCount:").append(i).append("\n");
      ((StringBuilder)localObject).append(localHashMap.toString()).append("\n");
      e.Cxv.idkeyStat(959L, 8L, 1L, true);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(124987);
    return localObject;
  }
  
  protected final long eCr()
  {
    return this.AUF;
  }
  
  protected String getTag()
  {
    return "MicroMsg.MainProcessChecker";
  }
  
  protected final void hJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124991);
    super.hJ(paramInt1, paramInt2);
    Log.w(getTag(), "[onCallUp] %s -> %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (MMApplicationContext.isMMProcess())
    {
      e.Cxv.idkeyStat(959L, 1L, 1L, true);
      getWorkerHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124984);
          if (MainProcessChecker.this.AUh.AUl)
          {
            Log.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
            e.Cxv.idkeyStat(959L, 7L, 1L, true);
            AppMethodBeat.o(124984);
            return;
          }
          Log.w(MainProcessChecker.this.getTag(), "[onCallUp] you can't see me, perry!");
          AppMethodBeat.o(124984);
        }
      }, 30000L);
    }
    AppMethodBeat.o(124991);
  }
  
  protected final boolean isEnable()
  {
    return this.ded;
  }
  
  protected final void onScreenOff()
  {
    AppMethodBeat.i(124988);
    Log.i(getTag(), "onScreenOff enable:%s", new Object[] { Boolean.valueOf(this.ded) });
    if (!this.ded)
    {
      AppMethodBeat.o(124988);
      return;
    }
    if ((b.DEBUG) || ((!this.AUH) && (TN() >= 3994319585.2800002D)))
    {
      this.AUE |= 0x100;
      hd(true);
      eCp();
    }
    AppMethodBeat.o(124988);
  }
  
  public final void start()
  {
    AppMethodBeat.i(124986);
    super.start();
    try
    {
      if (g.af(com.tencent.mm.plugin.expt.b.b.class) == null)
      {
        Log.w("MicroMsg.MainProcessChecker", "IExptService is null!");
        AppMethodBeat.o(124986);
        return;
      }
      this.AUH = q.is64BitRuntime();
      this.AUw = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRq, this.AUv);
      this.AUy = (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRr, this.AUx) * 0.01F);
      this.AUA = (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRs, this.AUz) * 0.01F);
      AUC[0] = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRt, 0);
      AUC[1] = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRu, 86400000L);
      this.AUt = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRA, 1048576L);
      this.AUu = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRz, 6000L);
      this.isHardMode = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRw, true);
      this.AUB = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRx, false);
      this.AUF = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRy, 1200000L);
      this.AUG.append(" \n***************ProcessElf Config****************\n| is64BitRuntime:").append(this.AUH).append("\n| isHardMode:").append(this.isHardMode).append("\n| workTime:").append(AUC[0]).append("-").append(AUC[1]).append("ms\n| NATIVE_SIZE:").append(this.AUw).append("B\n| MEMORY_VM_TOP:").append(this.AUy).append("%\n| MEMORY_JAVA_TOP:").append(this.AUA).append("%\n| TRAFFIC_PER_MIN:").append(this.AUt).append("B\n| JIFFIES_PER_MIN:").append(this.AUu).append("jiffy\n| CHECK_TIME:").append(this.AUF).append("ms\n************************************************\n");
      Log.i("MicroMsg.MainProcessChecker", this.AUG.toString());
      AppMethodBeat.o(124986);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MainProcessChecker", "[resetConfig] ERROR!!! %s", new Object[] { localException });
      AppMethodBeat.o(124986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.MainProcessChecker
 * JD-Core Version:    0.7.0.1
 */