package com.tencent.mm.plugin.performance.elf;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainProcessChecker
  extends AbstractProcessChecker
{
  private static String vBF = "";
  private static final long[] vBu = { 0L, 86400000L };
  private boolean cBX;
  private boolean isHardMode;
  private int vBA;
  private long vBB;
  private StringBuilder vBC;
  private boolean vBD;
  private long vBE;
  private long vBl;
  private long vBm;
  private long vBn;
  private long vBo;
  private int vBp;
  private float vBq;
  private int vBr;
  private float vBs;
  private boolean vBt;
  private long vBv;
  private long vBw;
  private long vBx;
  private long vBy;
  private long vBz;
  
  public MainProcessChecker()
  {
    AppMethodBeat.i(124985);
    this.vBl = 1048576L;
    this.vBm = 6000L;
    this.vBn = 734003200L;
    this.vBo = this.vBn;
    this.vBp = 92;
    this.vBq = (this.vBp * 0.01F);
    this.vBr = 85;
    this.vBs = (this.vBr * 0.01F);
    this.cBX = false;
    this.isHardMode = true;
    this.vBt = false;
    this.vBA = 1;
    this.vBC = new StringBuilder();
    this.vBD = false;
    this.vBE = 0L;
    AppMethodBeat.o(124985);
  }
  
  public static void apn(String paramString)
  {
    vBF = paramString;
  }
  
  private void dos()
  {
    AppMethodBeat.i(124993);
    this.vBv = br.Aj(0L);
    this.vBw = br.Ak(0L);
    this.vBx = br.Ai(0L);
    this.vBy = br.eVY();
    this.vBz = doq();
    AppMethodBeat.o(124993);
  }
  
  private static boolean gG(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  private void gd(boolean paramBoolean)
  {
    AppMethodBeat.i(124992);
    if ((!ai.ciE()) || (!this.cBX))
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
      if (gG(this.vBA, 64))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (gG(this.vBA, 256))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetKey(4);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      if (gG(this.vBA, 128))
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
      if (!gG(this.vBA, 4)) {
        break label475;
      }
      localIDKey.SetKey(106);
    }
    for (;;)
    {
      e.wTc.b(localArrayList, false);
      AppMethodBeat.o(124992);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(959);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (gG(this.vBA, 8))
      {
        localIDKey.SetKey(100);
        break;
      }
      if (gG(this.vBA, 16))
      {
        localIDKey.SetKey(101);
        break;
      }
      if (gG(this.vBA, 32))
      {
        localIDKey.SetKey(102);
        break;
      }
      if (gG(this.vBA, 512))
      {
        localIDKey.SetKey(103);
        break;
      }
      if (gG(this.vBA, 1024))
      {
        localIDKey.SetKey(104);
        break;
      }
      if ((gG(this.vBA, 64)) || (gG(this.vBA, 128)) || (gG(this.vBA, 256)))
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
  
  public final boolean aa(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(124989);
    this.cBX = true;
    ac.i(getTag(), "[onCheck] processId:%s loopCheckTime:%sms isForeground:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.cqM) });
    label1077:
    for (;;)
    {
      try
      {
        if (!this.cBX)
        {
          this.vBA |= 0x0;
          return false;
        }
        if (bs.isNullOrNil(this.vAZ.vBc))
        {
          ac.w("MicroMsg.MainProcessChecker", "it's never start activity! just return.");
          this.vBA |= 0x2;
          return false;
        }
        if (this.cqM)
        {
          ac.w("MicroMsg.MainProcessChecker", "isForeground true! just return.");
          this.vBA |= 0x4;
          return false;
        }
        if (SystemClock.uptimeMillis() - this.vBE >= paramLong2)
        {
          i = 1;
          if (i == 0)
          {
            ac.w("MicroMsg.MainProcessChecker", "it's not enough loopCheckTime[%s], just return.", new Object[] { Long.valueOf(paramLong2) });
            this.vBA |= 0x4;
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
          if ((vBu[0] <= paramLong1) && (paramLong1 <= vBu[1]))
          {
            break label1077;
            if (i == 0)
            {
              ac.w("MicroMsg.MainProcessChecker", "it's not at workTime[%s-%s], just return.", new Object[] { Long.valueOf(vBu[0]), Long.valueOf(vBu[1]) });
              this.vBA |= 0x8;
              return false;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (this.vBt) {
            if ((!this.cqM) && (vBF.equalsIgnoreCase(this.vAZ.vBc)))
            {
              i = 1;
              if (i == 0)
              {
                ac.w("MicroMsg.MainProcessChecker", "it cares if it whether LauncherUI to back but it's not, just return.");
                this.vBA |= 0x10;
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          if (dor())
          {
            this.vBA |= 0x20;
            return false;
          }
          if (this.isHardMode)
          {
            paramLong1 = br.Aj(this.vBv) + br.Ak(this.vBw) + br.Ai(this.vBx) + br.Ak(this.vBy);
            ac.i(getTag(), "[isTraffic] diff:%s byte", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 > 1.0F * (float)paramLong2 / 60000.0F * (float)this.vBl)
            {
              i = 1;
              if (i != 0)
              {
                this.vBA |= 0x200;
                ac.i(getTag(), "is over Traffic, just return");
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
            paramLong1 = doq() - this.vBz;
            ac.i(getTag(), "[isCpuBusy] diff:%s Jiffies", new Object[] { Long.valueOf(paramLong1) });
            if ((float)paramLong1 >= 1.0F * (float)paramLong2 / 60000.0F * (float)this.vBm)
            {
              i = 1;
              if (i != 0)
              {
                this.vBA |= 0x400;
                ac.i(getTag(), "is cpu busy, just return");
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
          ac.i(getTag(), "[isOverMemory] java[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong2 / (float)paramLong1), Float.valueOf(this.vBs) });
          if (1.0F * (float)paramLong2 / (float)paramLong1 >= this.vBs)
          {
            this.vBA |= 0x40;
            bool1 = true;
          }
          boolean bool2 = bool1;
          if (!this.vBD)
          {
            paramLong1 = HW();
            ac.i(getTag(), "[isOverMemory] vm[%s:%s]", new Object[] { Float.valueOf(1.0F * (float)paramLong1 / 4.294967E+009F), Float.valueOf(this.vBq) });
            bool2 = bool1;
            if (1.0F * (float)paramLong1 / 4.294967E+009F >= this.vBq)
            {
              this.vBA |= 0x100;
              bool2 = true;
            }
          }
          paramLong1 = Debug.getNativeHeapSize();
          ac.w(getTag(), "[isOverMemory] native[%s:%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.vBo) });
          if (paramLong1 > this.vBo)
          {
            i = 1;
            if (i != 0)
            {
              this.vBA |= 0x80;
              bool2 = true;
            }
            dos();
            gd(bool2);
            this.vBA = 1;
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
        dos();
        gd(false);
        this.vBA = 1;
        AppMethodBeat.o(124989);
      }
    }
  }
  
  public final void bT(boolean paramBoolean)
  {
    AppMethodBeat.i(124990);
    super.bT(paramBoolean);
    ac.i("MicroMsg.MainProcessChecker", "[onAppForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.vBE = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(124990);
  }
  
  protected final void dom()
  {
    AppMethodBeat.i(124988);
    ac.i(getTag(), "onScreenOff enable:%s", new Object[] { Boolean.valueOf(this.cBX) });
    if (!this.cBX)
    {
      AppMethodBeat.o(124988);
      return;
    }
    if ((b.DEBUG) || ((!this.vBD) && (HW() >= 3994319585.2800002D)))
    {
      this.vBA |= 0x100;
      gd(true);
      dol();
    }
    AppMethodBeat.o(124988);
  }
  
  protected final String don()
  {
    AppMethodBeat.i(124987);
    Object localObject = new StringBuilder(this.vBC);
    ((StringBuilder)localObject).append(super.don());
    HashMap localHashMap = new HashMap();
    int i = as(localHashMap);
    if (i >= 300)
    {
      ((StringBuilder)localObject).append("threadCount:").append(i).append("\n");
      ((StringBuilder)localObject).append(localHashMap.toString()).append("\n");
      e.wTc.idkeyStat(959L, 8L, 1L, true);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(124987);
    return localObject;
  }
  
  protected final long doo()
  {
    return this.vBB;
  }
  
  protected final void gF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124991);
    super.gF(paramInt1, paramInt2);
    ac.w(getTag(), "[onCallUp] %s -> %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (ai.ciE())
    {
      e.wTc.idkeyStat(959L, 1L, 1L, true);
      cOC().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124984);
          if (MainProcessChecker.this.vAZ.vBd)
          {
            ac.w(MainProcessChecker.this.getTag(), "[onCallUp] My God, you saw me!");
            e.wTc.idkeyStat(959L, 7L, 1L, true);
            AppMethodBeat.o(124984);
            return;
          }
          ac.w(MainProcessChecker.this.getTag(), "[onCallUp] you can't see me, perry!");
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
    return this.cBX;
  }
  
  public final void start()
  {
    AppMethodBeat.i(124986);
    super.start();
    try
    {
      if (g.ab(com.tencent.mm.plugin.expt.a.b.class) == null)
      {
        ac.w("MicroMsg.MainProcessChecker", "IExptService is null!");
        AppMethodBeat.o(124986);
        return;
      }
      this.vBD = q.is64BitRuntime();
      this.vBo = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOu, this.vBn);
      this.vBq = (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOv, this.vBp) * 0.01F);
      this.vBs = (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOw, this.vBr) * 0.01F);
      vBu[0] = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOx, 0);
      vBu[1] = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOy, 86400000L);
      this.vBl = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOE, 1048576L);
      this.vBm = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOD, 6000L);
      this.isHardMode = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOA, true);
      this.vBt = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOB, false);
      this.vBB = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOC, 1200000L);
      this.vBC.append(" \n***************ProcessElf Config****************\n| is64BitRuntime:").append(this.vBD).append("\n| isHardMode:").append(this.isHardMode).append("\n| workTime:").append(vBu[0]).append("-").append(vBu[1]).append("ms\n| NATIVE_SIZE:").append(this.vBo).append("B\n| MEMORY_VM_TOP:").append(this.vBq).append("%\n| MEMORY_JAVA_TOP:").append(this.vBs).append("%\n| TRAFFIC_PER_MIN:").append(this.vBl).append("B\n| JIFFIES_PER_MIN:").append(this.vBm).append("jiffy\n| CHECK_TIME:").append(this.vBB).append("ms\n************************************************\n");
      ac.i("MicroMsg.MainProcessChecker", this.vBC.toString());
      AppMethodBeat.o(124986);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MainProcessChecker", "[resetConfig] ERROR!!! %s", new Object[] { localException });
      AppMethodBeat.o(124986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.MainProcessChecker
 * JD-Core Version:    0.7.0.1
 */