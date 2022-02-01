package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.f;
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
  private static final long[] GNX = { 0L, 86400000L };
  private static String GOe = "";
  private long GNO;
  private long GNP;
  private long GNQ;
  private long GNR;
  private int GNS;
  private float GNT;
  private int GNU;
  private float GNV;
  private boolean GNW;
  private long GNY;
  private int GNZ;
  private long GOa;
  private StringBuilder GOb;
  private boolean GOc;
  private long GOd;
  private boolean dih;
  private boolean isHardMode;
  private long wxMobileRx;
  private long wxMobileTx;
  private long wxWifiRx;
  private long wxWifiTx;
  
  public MainProcessChecker()
  {
    AppMethodBeat.i(124985);
    this.GNO = 1048576L;
    this.GNP = 6000L;
    this.GNQ = 734003200L;
    this.GNR = this.GNQ;
    this.GNS = 92;
    this.GNT = (this.GNS * 0.01F);
    this.GNU = 85;
    this.GNV = (this.GNU * 0.01F);
    this.dih = false;
    this.isHardMode = true;
    this.GNW = false;
    this.GNZ = 1;
    this.GOb = new StringBuilder();
    this.GOc = false;
    this.GOd = 0L;
    AppMethodBeat.o(124985);
  }
  
  public static void aUt(String paramString)
  {
    GOe = paramString;
  }
  
  private void foe()
  {
    AppMethodBeat.i(124993);
    this.wxMobileTx = TrafficStats.getWxMobileTx(0L);
    this.wxMobileRx = TrafficStats.getWxMobileRx(0L);
    this.wxWifiTx = TrafficStats.getWxWifiTx(0L);
    this.wxWifiRx = TrafficStats.getWxWifiRx(0L);
    this.GNY = WF();
    AppMethodBeat.o(124993);
  }
  
  private void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(124992);
    if ((!MMApplicationContext.isMMProcess()) || (!this.dih))
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
      if (iP(this.GNZ, 64))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (iP(this.GNZ, 256))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(4);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (iP(this.GNZ, 128))
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
      if (!iP(this.GNZ, 4)) {
        break label475;
      }
      localIDKey.SetKey(106);
    }
    for (;;)
    {
      f.Iyx.b(localArrayList, false);
      AppMethodBeat.o(124992);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (iP(this.GNZ, 8))
      {
        localIDKey.SetKey(100);
        break;
      }
      if (iP(this.GNZ, 16))
      {
        localIDKey.SetKey(101);
        break;
      }
      if (iP(this.GNZ, 32))
      {
        localIDKey.SetKey(102);
        break;
      }
      if (iP(this.GNZ, 512))
      {
        localIDKey.SetKey(103);
        break;
      }
      if (iP(this.GNZ, 1024))
      {
        localIDKey.SetKey(104);
        break;
      }
      if ((iP(this.GNZ, 64)) || (iP(this.GNZ, 128)) || (iP(this.GNZ, 256)))
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
  
  private static boolean iP(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public final boolean an(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(124989);
    this.dih = true;
    Log.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(aax()) });
    label1077:
    for (;;)
    {
      try
      {
        if (!this.dih)
        {
          this.GNZ |= 0x0;
          return false;
        }
        if (Util.isNullOrNil(this.GNC.GNF))
        {
          Log.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
          this.GNZ |= 0x2;
          return false;
        }
        if (aax())
        {
          Log.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
          this.GNZ |= 0x4;
          return false;
        }
        if (SystemClock.uptimeMillis() - this.GOd >= paramLong2)
        {
          i = 1;
          if (i == 0)
          {
            Log.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", new Object[] { Long.valueOf(paramLong2) });
            this.GNZ |= 0x4;
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
          if ((GNX[0] <= paramLong1) && (paramLong1 <= GNX[1]))
          {
            break label1077;
            if (i == 0)
            {
              Log.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", new Object[] { Long.valueOf(GNX[0]), Long.valueOf(GNX[1]) });
              this.GNZ |= 0x8;
              return false;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.GNW) {
            if ((!aax()) && (GOe.equalsIgnoreCase(this.GNC.GNF)))
            {
              i = 1;
              if (i == 0)
              {
                Log.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                this.GNZ |= 0x10;
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (fod())
          {
            this.GNZ |= 0x20;
            return false;
          }
          if (this.isHardMode)
          {
            paramLong1 = TrafficStats.getWxMobileTx(this.wxMobileTx) + TrafficStats.getWxMobileRx(this.wxMobileRx) + TrafficStats.getWxWifiTx(this.wxWifiTx) + TrafficStats.getWxMobileRx(this.wxWifiRx);
            Log.i(getTag(), "[isTraffic] diff:%s byte", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 > 1.0F * (float)paramLong2 / 60000.0F * (float)this.GNO)
            {
              i = 1;
              if (i != 0)
              {
                this.GNZ |= 0x200;
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
            paramLong1 = WF() - this.GNY;
            Log.i(getTag(), "[isCpuBusy] diff:%s Jiffies", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 >= 1.0F * (float)paramLong2 / 60000.0F * (float)this.GNP)
            {
              i = 1;
              if (i != 0)
              {
                this.GNZ |= 0x400;
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
          Log.i(getTag(), "[isOverMemory] java[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong2 / (float)paramLong1), Float.valueOf(this.GNV) });
          if (1.0F * (float)paramLong2 / (float)paramLong1 >= this.GNV)
          {
            this.GNZ |= 0x40;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (!this.GOc)
          {
            paramLong1 = Yr();
            Log.i(getTag(), "[isOverMemory] vm[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong1 / 4.294967E+009F), Float.valueOf(this.GNT) });
            bool2 = bool1;
            if (1.0F * (float)paramLong1 / 4.294967E+009F >= this.GNT)
            {
              this.GNZ |= 0x100;
              bool2 = true;
            }
          }
          paramLong1 = Debug.getNativeHeapSize();
          Log.w(getTag(), "[isOverMemory] native[%s:%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.GNR) });
          if (paramLong1 > this.GNR)
          {
            i = 1;
            if (i != 0)
            {
              this.GNZ |= 0x80;
              bool2 = true;
            }
            foe();
            hU(bool2);
            this.GNZ = 1;
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
        foe();
        hU(false);
        this.GNZ = 1;
        AppMethodBeat.o(124989);
      }
    }
  }
  
  public final void cN(boolean paramBoolean)
  {
    AppMethodBeat.i(124990);
    super.cN(paramBoolean);
    Log.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.GOd = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(124990);
  }
  
  protected final String foa()
  {
    AppMethodBeat.i(124987);
    Object localObject = new StringBuilder(this.GOb);
    ((StringBuilder)localObject).append(super.foa());
    HashMap localHashMap = new HashMap();
    int i = ax(localHashMap);
    if (i >= 300)
    {
      ((StringBuilder)localObject).append("threadCount:").append(i).append("\n");
      ((StringBuilder)localObject).append(localHashMap.toString()).append("\n");
      f.Iyx.idkeyStat(959L, 8L, 1L, true);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(124987);
    return localObject;
  }
  
  protected final long fob()
  {
    return this.GOa;
  }
  
  protected String getTag()
  {
    return "MicroMsg.MainProcessChecker";
  }
  
  protected final void iO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124991);
    super.iO(paramInt1, paramInt2);
    Log.w(getTag(), "[onCallUp] %s -> %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (MMApplicationContext.isMMProcess())
    {
      f.Iyx.idkeyStat(959L, 1L, 1L, true);
      getWorkerHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124984);
          if (MainProcessChecker.this.GNC.GNG)
          {
            Log.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
            f.Iyx.idkeyStat(959L, 7L, 1L, true);
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
    return this.dih;
  }
  
  protected final void onScreenOff()
  {
    AppMethodBeat.i(124988);
    Log.i(getTag(), "onScreenOff enable:%s", new Object[] { Boolean.valueOf(this.dih) });
    if (!this.dih)
    {
      AppMethodBeat.o(124988);
      return;
    }
    if ((b.DEBUG) || ((!this.GOc) && (Yr() >= 3994319585.2800002D)))
    {
      this.GNZ |= 0x100;
      hU(true);
      fnZ();
    }
    AppMethodBeat.o(124988);
  }
  
  public final void start()
  {
    AppMethodBeat.i(124986);
    super.start();
    try
    {
      if (h.ae(com.tencent.mm.plugin.expt.b.b.class) == null)
      {
        Log.w("MicroMsg.MainProcessChecker", "IExptService is null!");
        AppMethodBeat.o(124986);
        return;
      }
      this.GOc = q.is64BitRuntime();
      this.GNR = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxM, this.GNQ);
      this.GNT = (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxN, this.GNS) * 0.01F);
      this.GNV = (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxO, this.GNU) * 0.01F);
      GNX[0] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxP, 0);
      GNX[1] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxQ, 86400000L);
      this.GNO = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxW, 1048576L);
      this.GNP = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxV, 6000L);
      this.isHardMode = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxS, true);
      this.GNW = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxT, false);
      this.GOa = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxU, 1200000L);
      this.GOb.append(" \n***************ProcessElf Config****************\n| is64BitRuntime:").append(this.GOc).append("\n| isHardMode:").append(this.isHardMode).append("\n| workTime:").append(GNX[0]).append("-").append(GNX[1]).append("ms\n| NATIVE_SIZE:").append(this.GNR).append("B\n| MEMORY_VM_TOP:").append(this.GNT).append("%\n| MEMORY_JAVA_TOP:").append(this.GNV).append("%\n| TRAFFIC_PER_MIN:").append(this.GNO).append("B\n| JIFFIES_PER_MIN:").append(this.GNP).append("jiffy\n| CHECK_TIME:").append(this.GOa).append("ms\n************************************************\n");
      Log.i("MicroMsg.MainProcessChecker", this.GOb.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.MainProcessChecker
 * JD-Core Version:    0.7.0.1
 */