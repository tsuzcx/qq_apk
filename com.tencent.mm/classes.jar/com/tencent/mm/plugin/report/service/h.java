package com.tencent.mm.plugin.report.service;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.c.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class h
  implements n
{
  public static h yih;
  public static final long yii;
  public c cJy;
  public ap hUx;
  private boolean yij;
  private long yik;
  private long yil;
  public int yim;
  public long yin;
  private int[] yio;
  public long[] yip;
  public com.tencent.matrix.trace.e.b yiq;
  private long yir;
  private long yis;
  private int[] yit;
  private com.tencent.matrix.trace.e.b yiu;
  
  static
  {
    AppMethodBeat.i(143920);
    yih = new h();
    yii = TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.Ja().cAz, TimeUnit.NANOSECONDS) + 1L;
    AppMethodBeat.o(143920);
  }
  
  private h()
  {
    AppMethodBeat.i(143913);
    this.yij = false;
    if (com.tencent.matrix.b.HK())
    {
      localObject = (a)com.tencent.matrix.b.HL().V(a.class);
      if ((localObject == null) || (!((a)localObject).isPluginStarted())) {}
    }
    for (Object localObject = ((a)localObject).cJy;; localObject = null)
    {
      this.cJy = ((c)localObject);
      this.hUx = new ap(Looper.getMainLooper());
      this.yik = 0L;
      this.yil = 0L;
      this.yim = 0;
      this.yin = 0L;
      this.yio = new int[c.b.values().length];
      this.yip = new long[21];
      this.yiq = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143909);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          h.a(h.this, h.a(h.this) + (paramAnonymousInt + 1) * h.yii);
          h.b(h.this, h.b(h.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = h.c(h.this);
            paramAnonymousInt = c.b.cLD.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = h.c(h.this);
            paramAnonymousInt = c.b.cLE.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = h.c(h.this);
            paramAnonymousInt = c.b.cLF.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = h.c(h.this);
            paramAnonymousInt = c.b.cLG.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          paramAnonymousString = h.c(h.this);
          paramAnonymousInt = c.b.cLH.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143909);
        }
      };
      this.yir = 0L;
      this.yis = 0L;
      this.yit = new int[c.b.values().length];
      this.yiu = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143911);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          h.c(h.this, h.h(h.this) + (paramAnonymousInt + 1) * h.yii);
          h.d(h.this, h.i(h.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = h.j(h.this);
            paramAnonymousInt = c.b.cLD.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = h.j(h.this);
            paramAnonymousInt = c.b.cLE.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = h.j(h.this);
            paramAnonymousInt = c.b.cLF.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = h.j(h.this);
            paramAnonymousInt = c.b.cLG.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          paramAnonymousString = h.j(h.this);
          paramAnonymousInt = c.b.cLH.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143911);
        }
      };
      AppForegroundDelegate.cSQ.a(this);
      AppMethodBeat.o(143913);
      return;
    }
  }
  
  private void dKr()
  {
    AppMethodBeat.i(143917);
    if (this.yir > 0L) {}
    for (float f = Math.min(60.0F, 1000.0F * (float)this.yis / (float)this.yir); f <= 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(143917);
      return;
    }
    ad.i("MicroMsg.SceneFpsReportService", "[reportMainUI] near 5s fps=" + f + " mainUIFrameCost=" + this.yir + "ms");
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
    localIDKey.SetValue(this.yit[c.b.cLH.index]);
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
    localIDKey.SetValue(this.yit[c.b.cLG.index]);
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
    localIDKey.SetValue(this.yit[c.b.cLF.index]);
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
    localIDKey.SetValue(this.yit[c.b.cLE.index]);
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
    localIDKey.SetValue(this.yit[c.b.cLD.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(19);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    e.ygI.b(localArrayList, false);
    this.yit = new int[c.b.values().length];
    this.yir = 0L;
    this.yis = 0L;
    AppMethodBeat.o(143917);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(143916);
    if (this.cJy == null)
    {
      AppMethodBeat.o(143916);
      return;
    }
    this.cJy.b(this.yiu);
    AppMethodBeat.o(143916);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(143915);
    if (this.yij)
    {
      if (this.cJy == null)
      {
        AppMethodBeat.o(143915);
        return;
      }
      this.cJy.a(this.yiu);
      this.hUx.postDelayed(new Runnable()
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
  
  public final void qp(boolean paramBoolean)
  {
    AppMethodBeat.i(143914);
    ad.i("MicroMsg.SceneFpsReportService", "[onMainUI] isForce=".concat(String.valueOf(paramBoolean)));
    this.yij = paramBoolean;
    if (!this.yij)
    {
      if (this.cJy == null)
      {
        AppMethodBeat.o(143914);
        return;
      }
      this.cJy.b(this.yiu);
      dKr();
    }
    AppMethodBeat.o(143914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.h
 * JD-Core Version:    0.7.0.1
 */