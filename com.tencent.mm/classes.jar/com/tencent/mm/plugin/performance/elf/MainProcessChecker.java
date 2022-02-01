package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
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
  private static final long[] usB = { 0L, 86400000L };
  private static String usM = "";
  private boolean cEP;
  private boolean isHardMode;
  private boolean usA;
  private long usC;
  private long usD;
  private long usE;
  private long usF;
  private long usG;
  private int usH;
  private long usI;
  private StringBuilder usJ;
  private boolean usK;
  private long usL;
  private long usr;
  private long uss;
  private long ust;
  private long usu;
  private int usv;
  private float usw;
  private int usx;
  private float usy;
  
  public MainProcessChecker()
  {
    AppMethodBeat.i(124985);
    this.usr = 1048576L;
    this.uss = 6000L;
    this.ust = 734003200L;
    this.usu = this.ust;
    this.usv = 92;
    this.usw = (this.usv * 0.01F);
    this.usx = 85;
    this.usy = (this.usx * 0.01F);
    this.cEP = false;
    this.isHardMode = true;
    this.usA = false;
    this.usH = 1;
    this.usJ = new StringBuilder();
    this.usK = false;
    this.usL = 0L;
    AppMethodBeat.o(124985);
  }
  
  public static void ako(String paramString)
  {
    usM = paramString;
  }
  
  private void daK()
  {
    AppMethodBeat.i(124993);
    this.usC = bs.vG(0L);
    this.usD = bs.vH(0L);
    this.usE = bs.vF(0L);
    this.usF = bs.eGD();
    this.usG = daI();
    AppMethodBeat.o(124993);
  }
  
  private void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(124992);
    if ((!aj.cbv()) || (!this.cEP))
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
      if (gz(this.usH, 64))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (gz(this.usH, 256))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(4);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (gz(this.usH, 128))
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
      if (!gz(this.usH, 4)) {
        break label475;
      }
      localIDKey.SetKey(106);
    }
    for (;;)
    {
      e.vIY.b(localArrayList, false);
      AppMethodBeat.o(124992);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (gz(this.usH, 8))
      {
        localIDKey.SetKey(100);
        break;
      }
      if (gz(this.usH, 16))
      {
        localIDKey.SetKey(101);
        break;
      }
      if (gz(this.usH, 32))
      {
        localIDKey.SetKey(102);
        break;
      }
      if (gz(this.usH, 512))
      {
        localIDKey.SetKey(103);
        break;
      }
      if (gz(this.usH, 1024))
      {
        localIDKey.SetKey(104);
        break;
      }
      if ((gz(this.usH, 64)) || (gz(this.usH, 128)) || (gz(this.usH, 256)))
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
  
  private static boolean gz(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public final boolean ad(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(124989);
    this.cEP = true;
    ad.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.ctF) });
    label1077:
    for (;;)
    {
      try
      {
        if (!this.cEP)
        {
          this.usH |= 0x0;
          return false;
        }
        if (bt.isNullOrNil(this.usf.usi))
        {
          ad.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
          this.usH |= 0x2;
          return false;
        }
        if (this.ctF)
        {
          ad.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
          this.usH |= 0x4;
          return false;
        }
        if (SystemClock.uptimeMillis() - this.usL >= paramLong2)
        {
          i = 1;
          if (i == 0)
          {
            ad.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", new Object[] { Long.valueOf(paramLong2) });
            this.usH |= 0x4;
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
          if ((usB[0] <= paramLong1) && (paramLong1 <= usB[1]))
          {
            break label1077;
            if (i == 0)
            {
              ad.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", new Object[] { Long.valueOf(usB[0]), Long.valueOf(usB[1]) });
              this.usH |= 0x8;
              return false;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.usA) {
            if ((!this.ctF) && (usM.equalsIgnoreCase(this.usf.usi)))
            {
              i = 1;
              if (i == 0)
              {
                ad.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                this.usH |= 0x10;
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (daJ())
          {
            this.usH |= 0x20;
            return false;
          }
          if (this.isHardMode)
          {
            paramLong1 = bs.vG(this.usC) + bs.vH(this.usD) + bs.vF(this.usE) + bs.vH(this.usF);
            ad.i(getTag(), "[isTraffic] diff:%s byte", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 > 1.0F * (float)paramLong2 / 60000.0F * (float)this.usr)
            {
              i = 1;
              if (i != 0)
              {
                this.usH |= 0x200;
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
            paramLong1 = daI() - this.usG;
            ad.i(getTag(), "[isCpuBusy] diff:%s Jiffies", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 >= 1.0F * (float)paramLong2 / 60000.0F * (float)this.uss)
            {
              i = 1;
              if (i != 0)
              {
                this.usH |= 0x400;
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
          ad.i(getTag(), "[isOverMemory] java[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong2 / (float)paramLong1), Float.valueOf(this.usy) });
          if (1.0F * (float)paramLong2 / (float)paramLong1 >= this.usy)
          {
            this.usH |= 0x40;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (!this.usK)
          {
            paramLong1 = In();
            ad.i(getTag(), "[isOverMemory] vm[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong1 / 4.294967E+009F), Float.valueOf(this.usw) });
            bool2 = bool1;
            if (1.0F * (float)paramLong1 / 4.294967E+009F >= this.usw)
            {
              this.usH |= 0x100;
              bool2 = true;
            }
          }
          paramLong1 = Debug.getNativeHeapSize();
          ad.w(getTag(), "[isOverMemory] native[%s:%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.usu) });
          if (paramLong1 > this.usu)
          {
            i = 1;
            if (i != 0)
            {
              this.usH |= 0x80;
              bool2 = true;
            }
            daK();
            fH(bool2);
            this.usH = 1;
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
        daK();
        fH(false);
        this.usH = 1;
        AppMethodBeat.o(124989);
      }
    }
  }
  
  public final void bS(boolean paramBoolean)
  {
    AppMethodBeat.i(124990);
    super.bS(paramBoolean);
    ad.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.usL = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(124990);
  }
  
  protected final void daE()
  {
    AppMethodBeat.i(124988);
    ad.i(getTag(), "onScreenOff enable:%s", new Object[] { Boolean.valueOf(this.cEP) });
    if (!this.cEP)
    {
      AppMethodBeat.o(124988);
      return;
    }
    if ((b.DEBUG) || ((!this.usK) && (In() >= 3994319585.2800002D)))
    {
      this.usH |= 0x100;
      fH(true);
      daD();
    }
    AppMethodBeat.o(124988);
  }
  
  protected final String daF()
  {
    AppMethodBeat.i(124987);
    Object localObject = new StringBuilder(this.usJ);
    ((StringBuilder)localObject).append(super.daF());
    HashMap localHashMap = new HashMap();
    int i = aq(localHashMap);
    if (i >= 300)
    {
      ((StringBuilder)localObject).append("threadCount:").append(i).append("\n");
      ((StringBuilder)localObject).append(localHashMap.toString()).append("\n");
      e.vIY.idkeyStat(959L, 8L, 1L, true);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(124987);
    return localObject;
  }
  
  protected final long daG()
  {
    return this.usI;
  }
  
  protected String getTag()
  {
    return "MicroMsg.MainProcessChecker";
  }
  
  protected final void gy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124991);
    super.gy(paramInt1, paramInt2);
    ad.w(getTag(), "[onCallUp] %s -> %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (aj.cbv())
    {
      e.vIY.idkeyStat(959L, 1L, 1L, true);
      cBt().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124984);
          if (MainProcessChecker.this.usf.usj)
          {
            ad.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
            e.vIY.idkeyStat(959L, 7L, 1L, true);
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
  
  protected final boolean isEnable()
  {
    return this.cEP;
  }
  
  public final void start()
  {
    AppMethodBeat.i(124986);
    super.start();
    try
    {
      if (g.ab(com.tencent.mm.plugin.expt.a.b.class) == null)
      {
        ad.w("MicroMsg.MainProcessChecker", "IExptService is null!");
        AppMethodBeat.o(124986);
        return;
      }
      this.usK = q.is64BitRuntime();
      this.usu = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pld, this.ust);
      this.usw = (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ple, this.usv) * 0.01F);
      this.usy = (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plf, this.usx) * 0.01F);
      usB[0] = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plg, 0);
      usB[1] = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plh, 86400000L);
      this.usr = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pln, 1048576L);
      this.uss = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plm, 6000L);
      this.isHardMode = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plj, true);
      this.usA = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plk, false);
      this.usI = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pll, 1200000L);
      this.usJ.append(" \n***************ProcessElf Config****************\n| is64BitRuntime:").append(this.usK).append("\n| isHardMode:").append(this.isHardMode).append("\n| workTime:").append(usB[0]).append("-").append(usB[1]).append("ms\n| NATIVE_SIZE:").append(this.usu).append("B\n| MEMORY_VM_TOP:").append(this.usw).append("%\n| MEMORY_JAVA_TOP:").append(this.usy).append("%\n| TRAFFIC_PER_MIN:").append(this.usr).append("B\n| JIFFIES_PER_MIN:").append(this.uss).append("jiffy\n| CHECK_TIME:").append(this.usI).append("ms\n************************************************\n");
      ad.i("MicroMsg.MainProcessChecker", this.usJ.toString());
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