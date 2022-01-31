package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainProcessChecker
  extends AbstractProcessChecker
{
  private static final long[] psH = { 0L, 86400000L };
  private static String psR = "";
  private boolean bTy;
  private long psA;
  private int psB;
  private float psC;
  private int psD;
  private float psE;
  private boolean psF;
  private boolean psG;
  private long psI;
  private long psJ;
  private long psK;
  private long psL;
  private long psM;
  private int psN;
  private long psO;
  private StringBuilder psP;
  private long psQ;
  private long psx;
  private long psy;
  private long psz;
  
  public MainProcessChecker()
  {
    AppMethodBeat.i(111058);
    this.psx = 1048576L;
    this.psy = 6000L;
    this.psz = 734003200L;
    this.psA = this.psz;
    this.psB = 92;
    this.psC = (this.psB * 0.01F);
    this.psD = 85;
    this.psE = (this.psD * 0.01F);
    this.bTy = false;
    this.psF = true;
    this.psG = false;
    this.psN = 1;
    this.psP = new StringBuilder();
    this.psQ = 0L;
    AppMethodBeat.o(111058);
  }
  
  public static void WQ(String paramString)
  {
    psR = paramString;
  }
  
  private void caI()
  {
    AppMethodBeat.i(111066);
    this.psI = bn.nR(0L);
    this.psJ = bn.nS(0L);
    this.psK = bn.nQ(0L);
    this.psL = bn.dtP();
    this.psM = caG();
    AppMethodBeat.o(111066);
  }
  
  private void dV(boolean paramBoolean)
  {
    AppMethodBeat.i(111065);
    if ((!ah.brt()) || (!this.bTy))
    {
      AppMethodBeat.o(111065);
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
      if (fe(this.psN, 64))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (fe(this.psN, 256))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(4);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (fe(this.psN, 128))
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
      if (!fe(this.psN, 4)) {
        break label475;
      }
      localIDKey.SetKey(106);
    }
    for (;;)
    {
      e.qrI.b(localArrayList, false);
      AppMethodBeat.o(111065);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (fe(this.psN, 8))
      {
        localIDKey.SetKey(100);
        break;
      }
      if (fe(this.psN, 16))
      {
        localIDKey.SetKey(101);
        break;
      }
      if (fe(this.psN, 32))
      {
        localIDKey.SetKey(102);
        break;
      }
      if (fe(this.psN, 512))
      {
        localIDKey.SetKey(103);
        break;
      }
      if (fe(this.psN, 1024))
      {
        localIDKey.SetKey(104);
        break;
      }
      if ((fe(this.psN, 64)) || (fe(this.psN, 128)) || (fe(this.psN, 256)))
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
  
  private static boolean fe(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public final boolean S(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(111062);
    this.bTy = true;
    ab.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.bSe) });
    label1062:
    for (;;)
    {
      try
      {
        if (!this.bTy)
        {
          this.psN |= 0x0;
          return false;
        }
        if (bo.isNullOrNil(this.psl.pso))
        {
          ab.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
          this.psN |= 0x2;
          return false;
        }
        if (this.bSe)
        {
          ab.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
          this.psN |= 0x4;
          return false;
        }
        if (SystemClock.uptimeMillis() - this.psQ >= paramLong2)
        {
          i = 1;
          if (i == 0)
          {
            ab.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", new Object[] { Long.valueOf(paramLong2) });
            this.psN |= 0x4;
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
          if ((psH[0] <= paramLong1) && (paramLong1 <= psH[1]))
          {
            break label1062;
            if (i == 0)
            {
              ab.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", new Object[] { Long.valueOf(psH[0]), Long.valueOf(psH[1]) });
              this.psN |= 0x8;
              return false;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.psG) {
            if ((!this.bSe) && (psR.equalsIgnoreCase(this.psl.pso)))
            {
              i = 1;
              if (i == 0)
              {
                ab.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                this.psN |= 0x10;
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (caH())
          {
            this.psN |= 0x20;
            return false;
          }
          if (this.psF)
          {
            paramLong1 = bn.nR(this.psI) + bn.nS(this.psJ) + bn.nQ(this.psK) + bn.nS(this.psL);
            ab.i(getTag(), "[isTraffic] diff:%s byte", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 > 1.0F * (float)paramLong2 / 60000.0F * (float)this.psx)
            {
              i = 1;
              if (i != 0)
              {
                this.psN |= 0x200;
                ab.i(getTag(), "is over Traffic, just return");
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (this.psF)
          {
            paramLong1 = caG() - this.psM;
            ab.i(getTag(), "[isCpuBusy] diff:%s Jiffies", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 >= 1.0F * (float)paramLong2 / 60000.0F * (float)this.psy)
            {
              i = 1;
              if (i != 0)
              {
                this.psN |= 0x400;
                ab.i(getTag(), "is cpu busy, just return");
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
          boolean bool = false;
          ab.i(getTag(), "[isOverMemory] java[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong2 / (float)paramLong1), Float.valueOf(this.psE) });
          if (1.0F * (float)paramLong2 / (float)paramLong1 >= this.psE)
          {
            this.psN |= 0x40;
            bool = true;
          }
          paramLong1 = zG();
          ab.i(getTag(), "[isOverMemory] vm[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong1 / 4.294967E+009F), Float.valueOf(this.psC) });
          if (1.0F * (float)paramLong1 / 4.294967E+009F >= this.psC)
          {
            this.psN |= 0x100;
            bool = true;
          }
          paramLong1 = Debug.getNativeHeapSize();
          ab.w(getTag(), "[isOverMemory] native[%s:%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.psA) });
          if (paramLong1 > this.psA)
          {
            i = 1;
            if (i != 0)
            {
              this.psN |= 0x100;
              bool = true;
            }
            caI();
            dV(bool);
            this.psN = 1;
            AppMethodBeat.o(111062);
            return bool;
          }
          i = 0;
          continue;
        }
        int i = 1;
      }
      finally
      {
        caI();
        dV(false);
        this.psN = 1;
        AppMethodBeat.o(111062);
      }
    }
  }
  
  protected final void awv()
  {
    AppMethodBeat.i(111061);
    ab.i(getTag(), "onScreenOff enable:%s", new Object[] { Boolean.valueOf(this.bTy) });
    if (!this.bTy)
    {
      AppMethodBeat.o(111061);
      return;
    }
    if ((b.DEBUG) || (zG() >= 4209067950.0799999D))
    {
      this.psN |= 0x100;
      dV(true);
      caC();
    }
    AppMethodBeat.o(111061);
  }
  
  protected final String caD()
  {
    AppMethodBeat.i(111060);
    Object localObject = new StringBuilder(this.psP);
    ((StringBuilder)localObject).append(super.caD());
    HashMap localHashMap = new HashMap();
    int i = U(localHashMap);
    if (i >= 300)
    {
      ((StringBuilder)localObject).append("threadCount:").append(i).append("\n");
      ((StringBuilder)localObject).append(localHashMap.toString()).append("\n");
      e.qrI.idkeyStat(959L, 8L, 1L, true);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(111060);
    return localObject;
  }
  
  protected final long caE()
  {
    return this.psO;
  }
  
  protected final void fd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111064);
    super.fd(paramInt1, paramInt2);
    ab.w(getTag(), "[onCallUp] %s -> %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (ah.brt())
    {
      e.qrI.idkeyStat(959L, 1L, 1L, true);
      caB().postDelayed(new MainProcessChecker.1(this), 30000L);
    }
    AppMethodBeat.o(111064);
  }
  
  protected String getTag()
  {
    return "MicroMsg.MainProcessChecker";
  }
  
  protected final boolean isEnable()
  {
    return this.bTy;
  }
  
  public final void jY(boolean paramBoolean)
  {
    AppMethodBeat.i(111063);
    super.jY(paramBoolean);
    ab.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.psQ = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(111063);
  }
  
  public final void start()
  {
    AppMethodBeat.i(111059);
    super.start();
    try
    {
      if (g.E(a.class) == null)
      {
        ab.w("MicroMsg.MainProcessChecker", "IExptService is null!");
        AppMethodBeat.o(111059);
        return;
      }
      this.psA = ((a)g.E(a.class)).a(a.a.lTF, this.psz);
      this.psC = (((a)g.E(a.class)).a(a.a.lTG, this.psB) * 0.01F);
      this.psE = (((a)g.E(a.class)).a(a.a.lTH, this.psD) * 0.01F);
      psH[0] = ((a)g.E(a.class)).a(a.a.lTI, 0);
      psH[1] = ((a)g.E(a.class)).a(a.a.lTJ, 86400000L);
      this.psx = ((a)g.E(a.class)).a(a.a.lTP, 1048576L);
      this.psy = ((a)g.E(a.class)).a(a.a.lTO, 6000L);
      this.psF = ((a)g.E(a.class)).a(a.a.lTL, true);
      this.psG = ((a)g.E(a.class)).a(a.a.lTM, false);
      this.psO = ((a)g.E(a.class)).a(a.a.lTN, 1200000L);
      this.psP.append(" \n***************ProcessElf Config****************\n| isHardMode:").append(this.psF).append("\n| workTime:").append(psH[0]).append("-").append(psH[1]).append("ms\n| NATIVE_SIZE:").append(this.psA).append("B\n| MEMORY_VM_TOP:").append(this.psC).append("%\n| MEMORY_JAVA_TOP:").append(this.psE).append("%\n| TRAFFIC_PER_MIN:").append(this.psx).append("B\n| JIFFIES_PER_MIN:").append(this.psy).append("jiffy\n| CHECK_TIME:").append(this.psO).append("ms\n************************************************\n");
      ab.i("MicroMsg.MainProcessChecker", this.psP.toString());
      AppMethodBeat.o(111059);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MainProcessChecker", "[resetConfig] ERROR!!! %s", new Object[] { localException });
      AppMethodBeat.o(111059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.MainProcessChecker
 * JD-Core Version:    0.7.0.1
 */