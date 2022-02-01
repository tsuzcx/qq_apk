package com.tencent.mm.plugin.report.service;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.c.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class i
  implements n
{
  public static i vKx;
  public static final long vKy;
  public c cBu;
  public ap hbq;
  private long vKA;
  private long vKB;
  public int vKC;
  public long vKD;
  private int[] vKE;
  public long[] vKF;
  public com.tencent.matrix.trace.e.b vKG;
  private long vKH;
  private long vKI;
  private int[] vKJ;
  private com.tencent.matrix.trace.e.b vKK;
  private boolean vKz;
  
  static
  {
    AppMethodBeat.i(143920);
    vKx = new i();
    vKy = TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.HU().csA, TimeUnit.NANOSECONDS) + 1L;
    AppMethodBeat.o(143920);
  }
  
  private i()
  {
    AppMethodBeat.i(143913);
    this.vKz = false;
    if (com.tencent.matrix.b.GE())
    {
      localObject = (a)com.tencent.matrix.b.GF().V(a.class);
      if ((localObject == null) || (!((a)localObject).isPluginStarted())) {}
    }
    for (Object localObject = ((a)localObject).cBu;; localObject = null)
    {
      this.cBu = ((c)localObject);
      this.hbq = new ap(Looper.getMainLooper());
      this.vKA = 0L;
      this.vKB = 0L;
      this.vKC = 0;
      this.vKD = 0L;
      this.vKE = new int[c.a.values().length];
      this.vKF = new long[21];
      this.vKG = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143909);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.a(i.this, i.a(i.this) + (paramAnonymousInt + 1) * i.vKy);
          i.b(i.this, i.b(i.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.a.cDw.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.a.cDx.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.a.cDy.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.a.cDz.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          paramAnonymousString = i.c(i.this);
          paramAnonymousInt = c.a.cDA.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143909);
        }
      };
      this.vKH = 0L;
      this.vKI = 0L;
      this.vKJ = new int[c.a.values().length];
      this.vKK = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143911);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.c(i.this, i.h(i.this) + (paramAnonymousInt + 1) * i.vKy);
          i.d(i.this, i.i(i.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.a.cDw.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.a.cDx.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.a.cDy.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.a.cDz.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          paramAnonymousString = i.j(i.this);
          paramAnonymousInt = c.a.cDA.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143911);
        }
      };
      AppForegroundDelegate.cKE.a(this);
      AppMethodBeat.o(143913);
      return;
    }
  }
  
  private void dkQ()
  {
    AppMethodBeat.i(143917);
    if (this.vKH > 0L) {}
    for (float f = Math.min(60.0F, 1000.0F * (float)this.vKI / (float)this.vKH); f <= 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(143917);
      return;
    }
    ad.i("MicroMsg.SceneFpsReportService", "[reportMainUI] near 5s fps=" + f + " mainUIFrameCost=" + this.vKH + "ms");
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1232);
    localIDKey.SetKey(0);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    localIDKey = new IDKey();
    localIDKey.SetID(1232);
    localIDKey.SetKey(1);
    localIDKey.SetValue(f);
    if (localIDKey.GetValue() > 0L) {
      localArrayList.add(localIDKey);
    }
    localIDKey = new IDKey();
    localIDKey.SetID(1232);
    localIDKey.SetKey(10);
    localIDKey.SetValue(this.vKJ[c.a.cDA.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(11);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    localIDKey = new IDKey();
    localIDKey.SetID(1232);
    localIDKey.SetKey(12);
    localIDKey.SetValue(this.vKJ[c.a.cDz.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(13);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    localIDKey = new IDKey();
    localIDKey.SetID(1232);
    localIDKey.SetKey(14);
    localIDKey.SetValue(this.vKJ[c.a.cDy.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(15);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    localIDKey = new IDKey();
    localIDKey.SetID(1232);
    localIDKey.SetKey(16);
    localIDKey.SetValue(this.vKJ[c.a.cDx.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(17);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    localIDKey = new IDKey();
    localIDKey.SetID(1232);
    localIDKey.SetKey(18);
    localIDKey.SetValue(this.vKJ[c.a.cDw.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(19);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    e.vIY.b(localArrayList, false);
    this.vKJ = new int[c.a.values().length];
    this.vKH = 0L;
    this.vKI = 0L;
    AppMethodBeat.o(143917);
  }
  
  public final void oS(boolean paramBoolean)
  {
    AppMethodBeat.i(143914);
    ad.i("MicroMsg.SceneFpsReportService", "[onMainUI] isForce=".concat(String.valueOf(paramBoolean)));
    this.vKz = paramBoolean;
    if (!this.vKz)
    {
      if (this.cBu == null)
      {
        AppMethodBeat.o(143914);
        return;
      }
      this.cBu.b(this.vKK);
      dkQ();
    }
    AppMethodBeat.o(143914);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(143916);
    if (this.cBu == null)
    {
      AppMethodBeat.o(143916);
      return;
    }
    this.cBu.b(this.vKK);
    AppMethodBeat.o(143916);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(143915);
    if (this.vKz)
    {
      if (this.cBu == null)
      {
        AppMethodBeat.o(143915);
        return;
      }
      this.cBu.a(this.vKK);
      this.hbq.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143912);
          i.e(i.this).b(i.k(i.this));
          i.l(i.this);
          AppMethodBeat.o(143912);
        }
      }, 5000L);
    }
    AppMethodBeat.o(143915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.i
 * JD-Core Version:    0.7.0.1
 */