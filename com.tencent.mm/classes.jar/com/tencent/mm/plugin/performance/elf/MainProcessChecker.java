package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.TrafficStats;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MainProcessChecker
  extends AbstractProcessChecker
{
  private static final long[] MLm = { 0L, 86400000L };
  private static String MLt = "";
  private long MLd;
  private long MLe;
  private long MLf;
  private long MLg;
  private int MLh;
  private float MLi;
  private int MLj;
  private float MLk;
  private boolean MLl;
  private long MLn;
  private int MLo;
  private long MLp;
  private StringBuilder MLq;
  private boolean MLr;
  private long MLs;
  private boolean egk;
  private boolean isHardMode;
  private long wxMobileRx;
  private long wxMobileTx;
  private long wxWifiRx;
  private long wxWifiTx;
  
  public MainProcessChecker()
  {
    AppMethodBeat.i(124985);
    this.MLd = 1048576L;
    this.MLe = 6000L;
    this.MLf = 734003200L;
    this.MLg = this.MLf;
    this.MLh = 92;
    this.MLi = (this.MLh * 0.01F);
    this.MLj = 85;
    this.MLk = (this.MLj * 0.01F);
    this.egk = false;
    this.isHardMode = true;
    this.MLl = false;
    this.MLo = 1;
    this.MLq = new StringBuilder();
    this.MLr = false;
    this.MLs = 0L;
    AppMethodBeat.o(124985);
  }
  
  public static void aRB(String paramString)
  {
    MLt = paramString;
  }
  
  private void gyZ()
  {
    AppMethodBeat.i(124993);
    this.wxMobileTx = TrafficStats.getWxMobileTx(0L);
    this.wxMobileRx = TrafficStats.getWxMobileRx(0L);
    this.wxWifiTx = TrafficStats.getWxWifiTx(0L);
    this.wxWifiRx = TrafficStats.getWxWifiRx(0L);
    this.MLn = axC();
    AppMethodBeat.o(124993);
  }
  
  private void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(124992);
    if ((!MMApplicationContext.isMMProcess()) || (!this.egk))
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
      if (kv(this.MLo, 64))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (kv(this.MLo, 256))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(4);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (kv(this.MLo, 128))
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
      if (!kv(this.MLo, 4)) {
        break label475;
      }
      localIDKey.SetKey(106);
    }
    for (;;)
    {
      f.Ozc.b(localArrayList, false);
      AppMethodBeat.o(124992);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (kv(this.MLo, 8))
      {
        localIDKey.SetKey(100);
        break;
      }
      if (kv(this.MLo, 16))
      {
        localIDKey.SetKey(101);
        break;
      }
      if (kv(this.MLo, 32))
      {
        localIDKey.SetKey(102);
        break;
      }
      if (kv(this.MLo, 512))
      {
        localIDKey.SetKey(103);
        break;
      }
      if (kv(this.MLo, 1024))
      {
        localIDKey.SetKey(104);
        break;
      }
      if ((kv(this.MLo, 64)) || (kv(this.MLo, 128)) || (kv(this.MLo, 256)))
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
  
  private static boolean kv(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public final boolean aX(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(124989);
    this.egk = true;
    Log.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.ffv) });
    label1077:
    for (;;)
    {
      try
      {
        if (!this.egk)
        {
          this.MLo |= 0x0;
          return false;
        }
        if (Util.isNullOrNil(this.MKR.MKU))
        {
          Log.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
          this.MLo |= 0x2;
          return false;
        }
        if (this.ffv)
        {
          Log.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
          this.MLo |= 0x4;
          return false;
        }
        if (SystemClock.uptimeMillis() - this.MLs >= paramLong2)
        {
          i = 1;
          if (i == 0)
          {
            Log.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", new Object[] { Long.valueOf(paramLong2) });
            this.MLo |= 0x4;
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
          if ((MLm[0] <= paramLong1) && (paramLong1 <= MLm[1]))
          {
            break label1077;
            if (i == 0)
            {
              Log.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", new Object[] { Long.valueOf(MLm[0]), Long.valueOf(MLm[1]) });
              this.MLo |= 0x8;
              return false;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.MLl) {
            if ((!this.ffv) && (MLt.equalsIgnoreCase(this.MKR.MKU)))
            {
              i = 1;
              if (i == 0)
              {
                Log.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                this.MLo |= 0x10;
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (gyY())
          {
            this.MLo |= 0x20;
            return false;
          }
          if (this.isHardMode)
          {
            paramLong1 = TrafficStats.getWxMobileTx(this.wxMobileTx) + TrafficStats.getWxMobileRx(this.wxMobileRx) + TrafficStats.getWxWifiTx(this.wxWifiTx) + TrafficStats.getWxMobileRx(this.wxWifiRx);
            Log.i(getTag(), "[isTraffic] diff:%s byte", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 > 1.0F * (float)paramLong2 / 60000.0F * (float)this.MLd)
            {
              i = 1;
              if (i != 0)
              {
                this.MLo |= 0x200;
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
            paramLong1 = axC() - this.MLn;
            Log.i(getTag(), "[isCpuBusy] diff:%s Jiffies", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 >= 1.0F * (float)paramLong2 / 60000.0F * (float)this.MLe)
            {
              i = 1;
              if (i != 0)
              {
                this.MLo |= 0x400;
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
          Log.i(getTag(), "[isOverMemory] java[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong2 / (float)paramLong1), Float.valueOf(this.MLk) });
          if (1.0F * (float)paramLong2 / (float)paramLong1 >= this.MLk)
          {
            this.MLo |= 0x40;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (!this.MLr)
          {
            paramLong1 = aAm();
            Log.i(getTag(), "[isOverMemory] vm[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong1 / 4.294967E+009F), Float.valueOf(this.MLi) });
            bool2 = bool1;
            if (1.0F * (float)paramLong1 / 4.294967E+009F >= this.MLi)
            {
              this.MLo |= 0x100;
              bool2 = true;
            }
          }
          paramLong1 = Debug.getNativeHeapSize();
          Log.w(getTag(), "[isOverMemory] native[%s:%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.MLg) });
          if (paramLong1 > this.MLg)
          {
            i = 1;
            if (i != 0)
            {
              this.MLo |= 0x80;
              bool2 = true;
            }
            gyZ();
            iT(bool2);
            this.MLo = 1;
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
        gyZ();
        iT(false);
        this.MLo = 1;
        AppMethodBeat.o(124989);
      }
    }
  }
  
  public final void du(boolean paramBoolean)
  {
    AppMethodBeat.i(124990);
    super.du(paramBoolean);
    Log.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.MLs = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(124990);
  }
  
  protected String getTag()
  {
    return "MicroMsg.MainProcessChecker";
  }
  
  protected final String gyV()
  {
    AppMethodBeat.i(124987);
    Object localObject = new StringBuilder(this.MLq);
    ((StringBuilder)localObject).append(super.gyV());
    HashMap localHashMap = new HashMap();
    int i = aN(localHashMap);
    if (i >= 300)
    {
      ((StringBuilder)localObject).append("threadCount:").append(i).append("\n");
      ((StringBuilder)localObject).append(localHashMap.toString()).append("\n");
      f.Ozc.idkeyStat(959L, 8L, 1L, true);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(124987);
    return localObject;
  }
  
  protected final long gyW()
  {
    return this.MLp;
  }
  
  protected final boolean isEnable()
  {
    return this.egk;
  }
  
  protected final void ku(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124991);
    super.ku(paramInt1, paramInt2);
    Log.w(getTag(), "[onCallUp] %s -> %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (MMApplicationContext.isMMProcess())
    {
      f.Ozc.idkeyStat(959L, 1L, 1L, true);
      getWorkerHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300847);
          if (MainProcessChecker.this.MKR.MKV)
          {
            Log.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
            f.Ozc.idkeyStat(959L, 7L, 1L, true);
            AppMethodBeat.o(300847);
            return;
          }
          Log.w(MainProcessChecker.this.getTag(), "[onCallUp] you can't see me, perry!");
          AppMethodBeat.o(300847);
        }
      }, 30000L);
    }
    AppMethodBeat.o(124991);
  }
  
  protected final void onScreenOff()
  {
    AppMethodBeat.i(124988);
    Log.i(getTag(), "onScreenOff enable:%s", new Object[] { Boolean.valueOf(this.egk) });
    if (!this.egk)
    {
      AppMethodBeat.o(124988);
      return;
    }
    if ((b.DEBUG) || ((!this.MLr) && (!gyY()) && (aAm() >= 3994319585.2800002D))) {
      com.tencent.threadpool.h.ahAA.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124984);
          if ((MainProcessChecker.this.ffv) || (MainProcessChecker.this.gyY()))
          {
            Log.e("MicroMsg.MainProcessChecker", "escaped killing");
            AppMethodBeat.o(124984);
            return;
          }
          MainProcessChecker.a(MainProcessChecker.this);
          MainProcessChecker.b(MainProcessChecker.this);
          MainProcessChecker.this.gyU();
          AppMethodBeat.o(124984);
        }
      }, TimeUnit.MINUTES.toMillis(1L), "TAG_KILLING_DELAY");
    }
    AppMethodBeat.o(124988);
  }
  
  protected final void onScreenOn()
  {
    AppMethodBeat.i(300934);
    com.tencent.threadpool.h.ahAA.bFQ("TAG_KILLING_DELAY");
    AppMethodBeat.o(300934);
  }
  
  public final void start()
  {
    AppMethodBeat.i(124986);
    super.start();
    try
    {
      if (com.tencent.mm.kernel.h.ax(c.class) == null)
      {
        Log.w("MicroMsg.MainProcessChecker", "IExptService is null!");
        AppMethodBeat.o(124986);
        return;
      }
      this.MLr = q.awm();
      this.MLg = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLn, this.MLf);
      this.MLi = (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLo, this.MLh) * 0.01F);
      this.MLk = (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLp, this.MLj) * 0.01F);
      MLm[0] = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLq, 0);
      MLm[1] = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLr, 86400000L);
      this.MLd = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLx, 1048576L);
      this.MLe = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLw, 6000L);
      this.isHardMode = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLt, true);
      this.MLl = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLu, false);
      this.MLp = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yLv, 1200000L);
      this.MLq.append(" \n***************ProcessElf Config****************\n| is64BitRuntime:").append(this.MLr).append("\n| isHardMode:").append(this.isHardMode).append("\n| workTime:").append(MLm[0]).append("-").append(MLm[1]).append("ms\n| NATIVE_SIZE:").append(this.MLg).append("B\n| MEMORY_VM_TOP:").append(this.MLi).append("%\n| MEMORY_JAVA_TOP:").append(this.MLk).append("%\n| TRAFFIC_PER_MIN:").append(this.MLd).append("B\n| JIFFIES_PER_MIN:").append(this.MLe).append("jiffy\n| CHECK_TIME:").append(this.MLp).append("ms\n************************************************\n");
      Log.i("MicroMsg.MainProcessChecker", this.MLq.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.MainProcessChecker
 * JD-Core Version:    0.7.0.1
 */