package com.tencent.mm.plugin.report.service;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.c.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class i
  implements o
{
  public static i IzV;
  public static final long IzW;
  public int IAa;
  public long IAb;
  private int[] IAc;
  public long[] IAd;
  public com.tencent.matrix.trace.e.b IAe;
  private long IAf;
  private long IAg;
  private int[] IAh;
  private com.tencent.matrix.trace.e.b IAi;
  private boolean IzX;
  private long IzY;
  private long IzZ;
  public c deH;
  public MMHandler mainHandler;
  
  static
  {
    AppMethodBeat.i(143920);
    IzV = new i();
    IzW = TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.Ya().cQd, TimeUnit.NANOSECONDS) + 1L;
    AppMethodBeat.o(143920);
  }
  
  private i()
  {
    AppMethodBeat.i(143913);
    this.IzX = false;
    if (com.tencent.matrix.b.Vt())
    {
      localObject = (com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class);
      if ((localObject == null) || (!((com.tencent.matrix.trace.b)localObject).isPluginStarted())) {}
    }
    for (Object localObject = ((com.tencent.matrix.trace.b)localObject).deH;; localObject = null)
    {
      this.deH = ((c)localObject);
      this.mainHandler = new MMHandler(Looper.getMainLooper());
      this.IzY = 0L;
      this.IzZ = 0L;
      this.IAa = 0;
      this.IAb = 0L;
      this.IAc = new int[c.b.values().length];
      this.IAd = new long[21];
      this.IAe = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143909);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.a(i.this, i.a(i.this) + (paramAnonymousInt + 1) * i.IzW);
          i.b(i.this, i.b(i.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.b.dgN.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.b.dgO.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.b.dgP.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.b.dgQ.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          paramAnonymousString = i.c(i.this);
          paramAnonymousInt = c.b.dgR.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143909);
        }
      };
      this.IAf = 0L;
      this.IAg = 0L;
      this.IAh = new int[c.b.values().length];
      this.IAi = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143911);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.c(i.this, i.h(i.this) + (paramAnonymousInt + 1) * i.IzW);
          i.d(i.this, i.i(i.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.b.dgN.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.b.dgO.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.b.dgP.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.b.dgQ.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          paramAnonymousString = i.j(i.this);
          paramAnonymousInt = c.b.dgR.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143911);
        }
      };
      AppForegroundDelegate.fby.a(this);
      AppMethodBeat.o(143913);
      return;
    }
  }
  
  private void fBE()
  {
    AppMethodBeat.i(143917);
    if (this.IAf > 0L) {}
    for (float f = Math.min(60.0F, 1000.0F * (float)this.IAg / (float)this.IAf); f <= 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(143917);
      return;
    }
    Log.i("MicroMsg.SceneFpsReportService", "[reportMainUI] near 5s fps=" + f + " mainUIFrameCost=" + this.IAf + "ms");
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
    localIDKey.SetValue(this.IAh[c.b.dgR.index]);
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
    localIDKey.SetValue(this.IAh[c.b.dgQ.index]);
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
    localIDKey.SetValue(this.IAh[c.b.dgP.index]);
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
    localIDKey.SetValue(this.IAh[c.b.dgO.index]);
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
    localIDKey.SetValue(this.IAh[c.b.dgN.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(19);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    f.Iyx.b(localArrayList, false);
    this.IAh = new int[c.b.values().length];
    this.IAf = 0L;
    this.IAg = 0L;
    AppMethodBeat.o(143917);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(143916);
    if (this.deH == null)
    {
      AppMethodBeat.o(143916);
      return;
    }
    this.deH.b(this.IAi);
    AppMethodBeat.o(143916);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(143915);
    if (this.IzX)
    {
      if (this.deH == null)
      {
        AppMethodBeat.o(143915);
        return;
      }
      this.deH.a(this.IAi);
      this.mainHandler.postDelayed(new Runnable()
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
  
  public final void xj(boolean paramBoolean)
  {
    AppMethodBeat.i(143914);
    Log.i("MicroMsg.SceneFpsReportService", "[onMainUI] isForce=".concat(String.valueOf(paramBoolean)));
    this.IzX = paramBoolean;
    if (!this.IzX)
    {
      if (this.deH == null)
      {
        AppMethodBeat.o(143914);
        return;
      }
      this.deH.b(this.IAi);
      fBE();
    }
    AppMethodBeat.o(143914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.i
 * JD-Core Version:    0.7.0.1
 */