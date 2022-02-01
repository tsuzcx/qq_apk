package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainProcessChecker
  extends AbstractProcessChecker
{
  private static final long[] wXE = { 0L, 86400000L };
  private static String wXP = "";
  private boolean cNF;
  private boolean isHardMode;
  private float wXA;
  private int wXB;
  private float wXC;
  private boolean wXD;
  private long wXF;
  private long wXG;
  private long wXH;
  private long wXI;
  private long wXJ;
  private int wXK;
  private long wXL;
  private StringBuilder wXM;
  private boolean wXN;
  private long wXO;
  private long wXv;
  private long wXw;
  private long wXx;
  private long wXy;
  private int wXz;
  
  public MainProcessChecker()
  {
    AppMethodBeat.i(124985);
    this.wXv = 1048576L;
    this.wXw = 6000L;
    this.wXx = 734003200L;
    this.wXy = this.wXx;
    this.wXz = 92;
    this.wXA = (this.wXz * 0.01F);
    this.wXB = 85;
    this.wXC = (this.wXB * 0.01F);
    this.cNF = false;
    this.isHardMode = true;
    this.wXD = false;
    this.wXK = 1;
    this.wXM = new StringBuilder();
    this.wXN = false;
    this.wXO = 0L;
    AppMethodBeat.o(124985);
  }
  
  public static void avH(String paramString)
  {
    wXP = paramString;
  }
  
  private void dCg()
  {
    AppMethodBeat.i(124993);
    this.wXF = bt.Dx(0L);
    this.wXG = bt.Dy(0L);
    this.wXH = bt.Dw(0L);
    this.wXI = bt.fpD();
    this.wXJ = dCe();
    AppMethodBeat.o(124993);
  }
  
  private static boolean gZ(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  private void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(124992);
    if ((!ak.cpe()) || (!this.cNF))
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
      if (gZ(this.wXK, 64))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (gZ(this.wXK, 256))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(4);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (gZ(this.wXK, 128))
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
      if (!gZ(this.wXK, 4)) {
        break label475;
      }
      localIDKey.SetKey(106);
    }
    for (;;)
    {
      e.ywz.b(localArrayList, false);
      AppMethodBeat.o(124992);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (gZ(this.wXK, 8))
      {
        localIDKey.SetKey(100);
        break;
      }
      if (gZ(this.wXK, 16))
      {
        localIDKey.SetKey(101);
        break;
      }
      if (gZ(this.wXK, 32))
      {
        localIDKey.SetKey(102);
        break;
      }
      if (gZ(this.wXK, 512))
      {
        localIDKey.SetKey(103);
        break;
      }
      if (gZ(this.wXK, 1024))
      {
        localIDKey.SetKey(104);
        break;
      }
      if ((gZ(this.wXK, 64)) || (gZ(this.wXK, 128)) || (gZ(this.wXK, 256)))
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
  
  public final boolean ab(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(124989);
    this.cNF = true;
    ae.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.cCq) });
    label1077:
    for (;;)
    {
      try
      {
        if (!this.cNF)
        {
          this.wXK |= 0x0;
          return false;
        }
        if (bu.isNullOrNil(this.wXj.wXm))
        {
          ae.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
          this.wXK |= 0x2;
          return false;
        }
        if (this.cCq)
        {
          ae.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
          this.wXK |= 0x4;
          return false;
        }
        if (SystemClock.uptimeMillis() - this.wXO >= paramLong2)
        {
          i = 1;
          if (i == 0)
          {
            ae.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", new Object[] { Long.valueOf(paramLong2) });
            this.wXK |= 0x4;
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
          if ((wXE[0] <= paramLong1) && (paramLong1 <= wXE[1]))
          {
            break label1077;
            if (i == 0)
            {
              ae.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", new Object[] { Long.valueOf(wXE[0]), Long.valueOf(wXE[1]) });
              this.wXK |= 0x8;
              return false;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.wXD) {
            if ((!this.cCq) && (wXP.equalsIgnoreCase(this.wXj.wXm)))
            {
              i = 1;
              if (i == 0)
              {
                ae.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                this.wXK |= 0x10;
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (dCf())
          {
            this.wXK |= 0x20;
            return false;
          }
          if (this.isHardMode)
          {
            paramLong1 = bt.Dx(this.wXF) + bt.Dy(this.wXG) + bt.Dw(this.wXH) + bt.Dy(this.wXI);
            ae.i(getTag(), "[isTraffic] diff:%s byte", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 > 1.0F * (float)paramLong2 / 60000.0F * (float)this.wXv)
            {
              i = 1;
              if (i != 0)
              {
                this.wXK |= 0x200;
                ae.i(getTag(), "is over Traffic, just return");
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
            paramLong1 = dCe() - this.wXJ;
            ae.i(getTag(), "[isCpuBusy] diff:%s Jiffies", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 >= 1.0F * (float)paramLong2 / 60000.0F * (float)this.wXw)
            {
              i = 1;
              if (i != 0)
              {
                this.wXK |= 0x400;
                ae.i(getTag(), "is cpu busy, just return");
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
          ae.i(getTag(), "[isOverMemory] java[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong2 / (float)paramLong1), Float.valueOf(this.wXC) });
          if (1.0F * (float)paramLong2 / (float)paramLong1 >= this.wXC)
          {
            this.wXK |= 0x40;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (!this.wXN)
          {
            paramLong1 = Jz();
            ae.i(getTag(), "[isOverMemory] vm[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong1 / 4.294967E+009F), Float.valueOf(this.wXA) });
            bool2 = bool1;
            if (1.0F * (float)paramLong1 / 4.294967E+009F >= this.wXA)
            {
              this.wXK |= 0x100;
              bool2 = true;
            }
          }
          paramLong1 = Debug.getNativeHeapSize();
          ae.w(getTag(), "[isOverMemory] native[%s:%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.wXy) });
          if (paramLong1 > this.wXy)
          {
            i = 1;
            if (i != 0)
            {
              this.wXK |= 0x80;
              bool2 = true;
            }
            dCg();
            gg(bool2);
            this.wXK = 1;
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
        dCg();
        gg(false);
        this.wXK = 1;
        AppMethodBeat.o(124989);
      }
    }
  }
  
  public final void bV(boolean paramBoolean)
  {
    AppMethodBeat.i(124990);
    super.bV(paramBoolean);
    ae.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.wXO = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(124990);
  }
  
  protected final String dCb()
  {
    AppMethodBeat.i(124987);
    Object localObject = new StringBuilder(this.wXM);
    ((StringBuilder)localObject).append(super.dCb());
    HashMap localHashMap = new HashMap();
    int i = aD(localHashMap);
    if (i >= 300)
    {
      ((StringBuilder)localObject).append("threadCount:").append(i).append("\n");
      ((StringBuilder)localObject).append(localHashMap.toString()).append("\n");
      e.ywz.idkeyStat(959L, 8L, 1L, true);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(124987);
    return localObject;
  }
  
  protected final long dCc()
  {
    return this.wXL;
  }
  
  protected final void gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124991);
    super.gY(paramInt1, paramInt2);
    ae.w(getTag(), "[onCallUp] %s -> %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (ak.cpe())
    {
      e.ywz.idkeyStat(959L, 1L, 1L, true);
      cZF().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124984);
          if (MainProcessChecker.this.wXj.wXn)
          {
            ae.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
            e.ywz.idkeyStat(959L, 7L, 1L, true);
            AppMethodBeat.o(124984);
            return;
          }
          ae.w(MainProcessChecker.this.getTag(), "[onCallUp] you can't see me, perry!");
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
    return this.cNF;
  }
  
  protected final void onScreenOff()
  {
    AppMethodBeat.i(124988);
    ae.i(getTag(), "onScreenOff enable:%s", new Object[] { Boolean.valueOf(this.cNF) });
    if (!this.cNF)
    {
      AppMethodBeat.o(124988);
      return;
    }
    if ((b.DEBUG) || ((!this.wXN) && (Jz() >= 3994319585.2800002D)))
    {
      this.wXK |= 0x100;
      gg(true);
      dCa();
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
        ae.w("MicroMsg.MainProcessChecker", "IExptService is null!");
        AppMethodBeat.o(124986);
        return;
      }
      this.wXN = q.is64BitRuntime();
      this.wXy = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzi, this.wXx);
      this.wXA = (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzj, this.wXz) * 0.01F);
      this.wXC = (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzk, this.wXB) * 0.01F);
      wXE[0] = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzl, 0);
      wXE[1] = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzm, 86400000L);
      this.wXv = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzs, 1048576L);
      this.wXw = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzr, 6000L);
      this.isHardMode = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzo, true);
      this.wXD = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzp, false);
      this.wXL = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzq, 1200000L);
      this.wXM.append(" \n***************ProcessElf Config****************\n| is64BitRuntime:").append(this.wXN).append("\n| isHardMode:").append(this.isHardMode).append("\n| workTime:").append(wXE[0]).append("-").append(wXE[1]).append("ms\n| NATIVE_SIZE:").append(this.wXy).append("B\n| MEMORY_VM_TOP:").append(this.wXA).append("%\n| MEMORY_JAVA_TOP:").append(this.wXC).append("%\n| TRAFFIC_PER_MIN:").append(this.wXv).append("B\n| JIFFIES_PER_MIN:").append(this.wXw).append("jiffy\n| CHECK_TIME:").append(this.wXL).append("ms\n************************************************\n");
      ae.i("MicroMsg.MainProcessChecker", this.wXM.toString());
      AppMethodBeat.o(124986);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MainProcessChecker", "[resetConfig] ERROR!!! %s", new Object[] { localException });
      AppMethodBeat.o(124986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.MainProcessChecker
 * JD-Core Version:    0.7.0.1
 */