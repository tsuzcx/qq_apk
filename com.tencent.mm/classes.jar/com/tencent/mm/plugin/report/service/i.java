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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class i
  implements o
{
  public static i CyW;
  public static final long CyX;
  private boolean CyY;
  private long CyZ;
  private long Cza;
  public int Czb;
  public long Czc;
  private int[] Czd;
  public long[] Cze;
  public com.tencent.matrix.trace.e.b Czf;
  private long Czg;
  private long Czh;
  private int[] Czi;
  private com.tencent.matrix.trace.e.b Czj;
  public c daF;
  public MMHandler mainHandler;
  
  static
  {
    AppMethodBeat.i(143920);
    CyW = new i();
    CyX = TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.Tw().cPm, TimeUnit.NANOSECONDS) + 1L;
    AppMethodBeat.o(143920);
  }
  
  private i()
  {
    AppMethodBeat.i(143913);
    this.CyY = false;
    if (com.tencent.matrix.b.isInstalled())
    {
      localObject = (a)com.tencent.matrix.b.RG().Y(a.class);
      if ((localObject == null) || (!((a)localObject).isPluginStarted())) {}
    }
    for (Object localObject = ((a)localObject).daF;; localObject = null)
    {
      this.daF = ((c)localObject);
      this.mainHandler = new MMHandler(Looper.getMainLooper());
      this.CyZ = 0L;
      this.Cza = 0L;
      this.Czb = 0;
      this.Czc = 0L;
      this.Czd = new int[c.b.values().length];
      this.Cze = new long[21];
      this.Czf = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143909);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.a(i.this, i.a(i.this) + (paramAnonymousInt + 1) * i.CyX);
          i.b(i.this, i.b(i.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.b.dcK.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.b.dcL.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.b.dcM.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.b.dcN.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          paramAnonymousString = i.c(i.this);
          paramAnonymousInt = c.b.dcO.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143909);
        }
      };
      this.Czg = 0L;
      this.Czh = 0L;
      this.Czi = new int[c.b.values().length];
      this.Czj = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143911);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.c(i.this, i.h(i.this) + (paramAnonymousInt + 1) * i.CyX);
          i.d(i.this, i.i(i.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.b.dcK.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.b.dcL.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.b.dcM.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.b.dcN.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          paramAnonymousString = i.j(i.this);
          paramAnonymousInt = c.b.dcO.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143911);
        }
      };
      AppForegroundDelegate.djR.a(this);
      AppMethodBeat.o(143913);
      return;
    }
  }
  
  private void eOJ()
  {
    AppMethodBeat.i(143917);
    if (this.Czg > 0L) {}
    for (float f = Math.min(60.0F, 1000.0F * (float)this.Czh / (float)this.Czg); f <= 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(143917);
      return;
    }
    Log.i("MicroMsg.SceneFpsReportService", "[reportMainUI] near 5s fps=" + f + " mainUIFrameCost=" + this.Czg + "ms");
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
    localIDKey.SetValue(this.Czi[c.b.dcO.index]);
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
    localIDKey.SetValue(this.Czi[c.b.dcN.index]);
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
    localIDKey.SetValue(this.Czi[c.b.dcM.index]);
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
    localIDKey.SetValue(this.Czi[c.b.dcL.index]);
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
    localIDKey.SetValue(this.Czi[c.b.dcK.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(19);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    e.Cxv.b(localArrayList, false);
    this.Czi = new int[c.b.values().length];
    this.Czg = 0L;
    this.Czh = 0L;
    AppMethodBeat.o(143917);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(143916);
    if (this.daF == null)
    {
      AppMethodBeat.o(143916);
      return;
    }
    this.daF.b(this.Czj);
    AppMethodBeat.o(143916);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(143915);
    if (this.CyY)
    {
      if (this.daF == null)
      {
        AppMethodBeat.o(143915);
        return;
      }
      this.daF.a(this.Czj);
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
  
  public final void tN(boolean paramBoolean)
  {
    AppMethodBeat.i(143914);
    Log.i("MicroMsg.SceneFpsReportService", "[onMainUI] isForce=".concat(String.valueOf(paramBoolean)));
    this.CyY = paramBoolean;
    if (!this.CyY)
    {
      if (this.daF == null)
      {
        AppMethodBeat.o(143914);
        return;
      }
      this.daF.b(this.Czj);
      eOJ();
    }
    AppMethodBeat.o(143914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.i
 * JD-Core Version:    0.7.0.1
 */