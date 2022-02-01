package com.tencent.mm.plugin.report.service;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.c.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class h
  implements o
{
  public static h yxY;
  public static final long yxZ;
  public c cKh;
  public aq hXp;
  private boolean yya;
  private long yyb;
  private long yyc;
  public int yyd;
  public long yye;
  private int[] yyf;
  public long[] yyg;
  public com.tencent.matrix.trace.e.b yyh;
  private long yyi;
  private long yyj;
  private int[] yyk;
  private com.tencent.matrix.trace.e.b yyl;
  
  static
  {
    AppMethodBeat.i(143920);
    yxY = new h();
    yxZ = TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.Ji().cBg, TimeUnit.NANOSECONDS) + 1L;
    AppMethodBeat.o(143920);
  }
  
  private h()
  {
    AppMethodBeat.i(143913);
    this.yya = false;
    if (com.tencent.matrix.b.HS())
    {
      localObject = (a)com.tencent.matrix.b.HT().V(a.class);
      if ((localObject == null) || (!((a)localObject).isPluginStarted())) {}
    }
    for (Object localObject = ((a)localObject).cKh;; localObject = null)
    {
      this.cKh = ((c)localObject);
      this.hXp = new aq(Looper.getMainLooper());
      this.yyb = 0L;
      this.yyc = 0L;
      this.yyd = 0;
      this.yye = 0L;
      this.yyf = new int[c.b.values().length];
      this.yyg = new long[21];
      this.yyh = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143909);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          h.a(h.this, h.a(h.this) + (paramAnonymousInt + 1) * h.yxZ);
          h.b(h.this, h.b(h.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = h.c(h.this);
            paramAnonymousInt = c.b.cMm.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = h.c(h.this);
            paramAnonymousInt = c.b.cMn.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = h.c(h.this);
            paramAnonymousInt = c.b.cMo.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = h.c(h.this);
            paramAnonymousInt = c.b.cMp.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          paramAnonymousString = h.c(h.this);
          paramAnonymousInt = c.b.cMq.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143909);
        }
      };
      this.yyi = 0L;
      this.yyj = 0L;
      this.yyk = new int[c.b.values().length];
      this.yyl = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143911);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          h.c(h.this, h.h(h.this) + (paramAnonymousInt + 1) * h.yxZ);
          h.d(h.this, h.i(h.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = h.j(h.this);
            paramAnonymousInt = c.b.cMm.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = h.j(h.this);
            paramAnonymousInt = c.b.cMn.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = h.j(h.this);
            paramAnonymousInt = c.b.cMo.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = h.j(h.this);
            paramAnonymousInt = c.b.cMp.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          paramAnonymousString = h.j(h.this);
          paramAnonymousInt = c.b.cMq.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143911);
        }
      };
      AppForegroundDelegate.cTA.a(this);
      AppMethodBeat.o(143913);
      return;
    }
  }
  
  private void dNJ()
  {
    AppMethodBeat.i(143917);
    if (this.yyi > 0L) {}
    for (float f = Math.min(60.0F, 1000.0F * (float)this.yyj / (float)this.yyi); f <= 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(143917);
      return;
    }
    ae.i("MicroMsg.SceneFpsReportService", "[reportMainUI] near 5s fps=" + f + " mainUIFrameCost=" + this.yyi + "ms");
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
    localIDKey.SetValue(this.yyk[c.b.cMq.index]);
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
    localIDKey.SetValue(this.yyk[c.b.cMp.index]);
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
    localIDKey.SetValue(this.yyk[c.b.cMo.index]);
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
    localIDKey.SetValue(this.yyk[c.b.cMn.index]);
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
    localIDKey.SetValue(this.yyk[c.b.cMm.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(19);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    e.ywz.b(localArrayList, false);
    this.yyk = new int[c.b.values().length];
    this.yyi = 0L;
    this.yyj = 0L;
    AppMethodBeat.o(143917);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(143916);
    if (this.cKh == null)
    {
      AppMethodBeat.o(143916);
      return;
    }
    this.cKh.b(this.yyl);
    AppMethodBeat.o(143916);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(143915);
    if (this.yya)
    {
      if (this.cKh == null)
      {
        AppMethodBeat.o(143915);
        return;
      }
      this.cKh.a(this.yyl);
      this.hXp.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143912);
          h.e(h.this).b(h.k(h.this));
          h.l(h.this);
          AppMethodBeat.o(143912);
        }
      }, 5000L);
    }
    AppMethodBeat.o(143915);
  }
  
  public final void qw(boolean paramBoolean)
  {
    AppMethodBeat.i(143914);
    ae.i("MicroMsg.SceneFpsReportService", "[onMainUI] isForce=".concat(String.valueOf(paramBoolean)));
    this.yya = paramBoolean;
    if (!this.yya)
    {
      if (this.cKh == null)
      {
        AppMethodBeat.o(143914);
        return;
      }
      this.cKh.b(this.yyl);
      dNJ();
    }
    AppMethodBeat.o(143914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.h
 * JD-Core Version:    0.7.0.1
 */