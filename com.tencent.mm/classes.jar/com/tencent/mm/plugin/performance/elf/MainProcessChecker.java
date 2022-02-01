package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainProcessChecker
  extends AbstractProcessChecker
{
  private static final long[] wHT = { 0L, 86400000L };
  private static String wIe = "";
  private boolean cMW;
  private boolean isHardMode;
  private long wHK;
  private long wHL;
  private long wHM;
  private long wHN;
  private int wHO;
  private float wHP;
  private int wHQ;
  private float wHR;
  private boolean wHS;
  private long wHU;
  private long wHV;
  private long wHW;
  private long wHX;
  private long wHY;
  private int wHZ;
  private long wIa;
  private StringBuilder wIb;
  private boolean wIc;
  private long wId;
  
  public MainProcessChecker()
  {
    AppMethodBeat.i(124985);
    this.wHK = 1048576L;
    this.wHL = 6000L;
    this.wHM = 734003200L;
    this.wHN = this.wHM;
    this.wHO = 92;
    this.wHP = (this.wHO * 0.01F);
    this.wHQ = 85;
    this.wHR = (this.wHQ * 0.01F);
    this.cMW = false;
    this.isHardMode = true;
    this.wHS = false;
    this.wHZ = 1;
    this.wIb = new StringBuilder();
    this.wIc = false;
    this.wId = 0L;
    AppMethodBeat.o(124985);
  }
  
  public static void aus(String paramString)
  {
    wIe = paramString;
  }
  
  private void dyP()
  {
    AppMethodBeat.i(124993);
    this.wHU = bs.CZ(0L);
    this.wHV = bs.Da(0L);
    this.wHW = bs.CY(0L);
    this.wHX = bs.flI();
    this.wHY = dyN();
    AppMethodBeat.o(124993);
  }
  
  private static boolean gY(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  private void gi(boolean paramBoolean)
  {
    AppMethodBeat.i(124992);
    if ((!aj.cnC()) || (!this.cMW))
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
      if (gY(this.wHZ, 64))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (gY(this.wHZ, 256))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(4);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (gY(this.wHZ, 128))
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
      if (!gY(this.wHZ, 4)) {
        break label475;
      }
      localIDKey.SetKey(106);
    }
    for (;;)
    {
      e.ygI.b(localArrayList, false);
      AppMethodBeat.o(124992);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (gY(this.wHZ, 8))
      {
        localIDKey.SetKey(100);
        break;
      }
      if (gY(this.wHZ, 16))
      {
        localIDKey.SetKey(101);
        break;
      }
      if (gY(this.wHZ, 32))
      {
        localIDKey.SetKey(102);
        break;
      }
      if (gY(this.wHZ, 512))
      {
        localIDKey.SetKey(103);
        break;
      }
      if (gY(this.wHZ, 1024))
      {
        localIDKey.SetKey(104);
        break;
      }
      if ((gY(this.wHZ, 64)) || (gY(this.wHZ, 128)) || (gY(this.wHZ, 256)))
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
  
  public final boolean ac(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(124989);
    this.cMW = true;
    ad.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.cBJ) });
    label1077:
    for (;;)
    {
      try
      {
        if (!this.cMW)
        {
          this.wHZ |= 0x0;
          return false;
        }
        if (bt.isNullOrNil(this.wHy.wHB))
        {
          ad.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
          this.wHZ |= 0x2;
          return false;
        }
        if (this.cBJ)
        {
          ad.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
          this.wHZ |= 0x4;
          return false;
        }
        if (SystemClock.uptimeMillis() - this.wId >= paramLong2)
        {
          i = 1;
          if (i == 0)
          {
            ad.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", new Object[] { Long.valueOf(paramLong2) });
            this.wHZ |= 0x4;
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
          if ((wHT[0] <= paramLong1) && (paramLong1 <= wHT[1]))
          {
            break label1077;
            if (i == 0)
            {
              ad.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", new Object[] { Long.valueOf(wHT[0]), Long.valueOf(wHT[1]) });
              this.wHZ |= 0x8;
              return false;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.wHS) {
            if ((!this.cBJ) && (wIe.equalsIgnoreCase(this.wHy.wHB)))
            {
              i = 1;
              if (i == 0)
              {
                ad.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                this.wHZ |= 0x10;
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (dyO())
          {
            this.wHZ |= 0x20;
            return false;
          }
          if (this.isHardMode)
          {
            paramLong1 = bs.CZ(this.wHU) + bs.Da(this.wHV) + bs.CY(this.wHW) + bs.Da(this.wHX);
            ad.i(getTag(), "[isTraffic] diff:%s byte", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 > 1.0F * (float)paramLong2 / 60000.0F * (float)this.wHK)
            {
              i = 1;
              if (i != 0)
              {
                this.wHZ |= 0x200;
                ad.i(getTag(), "is over Traffic, just return");
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
            paramLong1 = dyN() - this.wHY;
            ad.i(getTag(), "[isCpuBusy] diff:%s Jiffies", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 >= 1.0F * (float)paramLong2 / 60000.0F * (float)this.wHL)
            {
              i = 1;
              if (i != 0)
              {
                this.wHZ |= 0x400;
                ad.i(getTag(), "is cpu busy, just return");
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
          ad.i(getTag(), "[isOverMemory] java[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong2 / (float)paramLong1), Float.valueOf(this.wHR) });
          if (1.0F * (float)paramLong2 / (float)paramLong1 >= this.wHR)
          {
            this.wHZ |= 0x40;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (!this.wIc)
          {
            paramLong1 = Jr();
            ad.i(getTag(), "[isOverMemory] vm[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong1 / 4.294967E+009F), Float.valueOf(this.wHP) });
            bool2 = bool1;
            if (1.0F * (float)paramLong1 / 4.294967E+009F >= this.wHP)
            {
              this.wHZ |= 0x100;
              bool2 = true;
            }
          }
          paramLong1 = Debug.getNativeHeapSize();
          ad.w(getTag(), "[isOverMemory] native[%s:%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.wHN) });
          if (paramLong1 > this.wHN)
          {
            i = 1;
            if (i != 0)
            {
              this.wHZ |= 0x80;
              bool2 = true;
            }
            dyP();
            gi(bool2);
            this.wHZ = 1;
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
        dyP();
        gi(false);
        this.wHZ = 1;
        AppMethodBeat.o(124989);
      }
    }
  }
  
  public final void bV(boolean paramBoolean)
  {
    AppMethodBeat.i(124990);
    super.bV(paramBoolean);
    ad.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.wId = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(124990);
  }
  
  protected final String dyK()
  {
    AppMethodBeat.i(124987);
    Object localObject = new StringBuilder(this.wIb);
    ((StringBuilder)localObject).append(super.dyK());
    HashMap localHashMap = new HashMap();
    int i = ax(localHashMap);
    if (i >= 300)
    {
      ((StringBuilder)localObject).append("threadCount:").append(i).append("\n");
      ((StringBuilder)localObject).append(localHashMap.toString()).append("\n");
      e.ygI.idkeyStat(959L, 8L, 1L, true);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(124987);
    return localObject;
  }
  
  protected final long dyL()
  {
    return this.wIa;
  }
  
  protected final void gX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124991);
    super.gX(paramInt1, paramInt2);
    ad.w(getTag(), "[onCallUp] %s -> %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (aj.cnC())
    {
      e.ygI.idkeyStat(959L, 1L, 1L, true);
      cWY().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124984);
          if (MainProcessChecker.this.wHy.wHC)
          {
            ad.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
            e.ygI.idkeyStat(959L, 7L, 1L, true);
            AppMethodBeat.o(124984);
            return;
          }
          ad.w(MainProcessChecker.this.getTag(), "[onCallUp] you can't see me, perry!");
          AppMethodBeat.o(124984);
        }
      }, 30000L);
    }
    AppMethodBeat.o(124991);
  }
  
  protected String getTag()
  {
    return "MicroMsg.MainProcessChecker";
  }
  
  protected final boolean isEnable()
  {
    return this.cMW;
  }
  
  protected final void onScreenOff()
  {
    AppMethodBeat.i(124988);
    ad.i(getTag(), "onScreenOff enable:%s", new Object[] { Boolean.valueOf(this.cMW) });
    if (!this.cMW)
    {
      AppMethodBeat.o(124988);
      return;
    }
    if ((b.DEBUG) || ((!this.wIc) && (Jr() >= 3994319585.2800002D)))
    {
      this.wHZ |= 0x100;
      gi(true);
      dyJ();
    }
    AppMethodBeat.o(124988);
  }
  
  public final void start()
  {
    AppMethodBeat.i(124986);
    super.start();
    try
    {
      if (g.ab(com.tencent.mm.plugin.expt.b.b.class) == null)
      {
        ad.w("MicroMsg.MainProcessChecker", "IExptService is null!");
        AppMethodBeat.o(124986);
        return;
      }
      this.wIc = q.is64BitRuntime();
      this.wHN = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qst, this.wHM);
      this.wHP = (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsu, this.wHO) * 0.01F);
      this.wHR = (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsv, this.wHQ) * 0.01F);
      wHT[0] = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsw, 0);
      wHT[1] = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsx, 86400000L);
      this.wHK = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsD, 1048576L);
      this.wHL = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsC, 6000L);
      this.isHardMode = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsz, true);
      this.wHS = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsA, false);
      this.wIa = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsB, 1200000L);
      this.wIb.append(" \n***************ProcessElf Config****************\n| is64BitRuntime:").append(this.wIc).append("\n| isHardMode:").append(this.isHardMode).append("\n| workTime:").append(wHT[0]).append("-").append(wHT[1]).append("ms\n| NATIVE_SIZE:").append(this.wHN).append("B\n| MEMORY_VM_TOP:").append(this.wHP).append("%\n| MEMORY_JAVA_TOP:").append(this.wHR).append("%\n| TRAFFIC_PER_MIN:").append(this.wHK).append("B\n| JIFFIES_PER_MIN:").append(this.wHL).append("jiffy\n| CHECK_TIME:").append(this.wIa).append("ms\n************************************************\n");
      ad.i("MicroMsg.MainProcessChecker", this.wIb.toString());
      AppMethodBeat.o(124986);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MainProcessChecker", "[resetConfig] ERROR!!! %s", new Object[] { localException });
      AppMethodBeat.o(124986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.MainProcessChecker
 * JD-Core Version:    0.7.0.1
 */