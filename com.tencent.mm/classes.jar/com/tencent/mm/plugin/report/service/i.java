package com.tencent.mm.plugin.report.service;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.tracer.b.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class i
  implements q
{
  public static i OAE;
  public static final long OAF;
  private boolean OAG;
  private long OAH;
  private long OAI;
  public int OAJ;
  public long OAK;
  private int[] OAL;
  public long[] OAM;
  public com.tencent.matrix.trace.e.b OAN;
  private long OAO;
  private long OAP;
  private int[] OAQ;
  private com.tencent.matrix.trace.e.b OAR;
  public com.tencent.matrix.trace.tracer.b fdr;
  public MMHandler mainHandler;
  
  static
  {
    AppMethodBeat.i(143920);
    OAE = new i();
    OAF = TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.azL().eLi, TimeUnit.NANOSECONDS) + 1L;
    AppMethodBeat.o(143920);
  }
  
  private i()
  {
    AppMethodBeat.i(143913);
    this.OAG = false;
    if (c.isInstalled())
    {
      localObject = (com.tencent.matrix.trace.b)c.avW().ai(com.tencent.matrix.trace.b.class);
      if ((localObject == null) || (!((com.tencent.matrix.trace.b)localObject).isPluginStarted())) {}
    }
    for (Object localObject = ((com.tencent.matrix.trace.b)localObject).fdr;; localObject = null)
    {
      this.fdr = ((com.tencent.matrix.trace.tracer.b)localObject);
      this.mainHandler = new MMHandler(Looper.getMainLooper());
      this.OAH = 0L;
      this.OAI = 0L;
      this.OAJ = 0;
      this.OAK = 0L;
      this.OAL = new int[b.b.values().length];
      this.OAM = new long[21];
      this.OAN = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143909);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.a(i.this, (paramAnonymousInt + 1) * i.OAF);
          i.a(i.this);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.b(i.this);
            paramAnonymousInt = b.b.ffW.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.b(i.this);
            paramAnonymousInt = b.b.ffX.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.b(i.this);
            paramAnonymousInt = b.b.ffY.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.b(i.this);
            paramAnonymousInt = b.b.ffZ.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          paramAnonymousString = i.b(i.this);
          paramAnonymousInt = b.b.fga.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143909);
        }
      };
      this.OAO = 0L;
      this.OAP = 0L;
      this.OAQ = new int[b.b.values().length];
      this.OAR = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143911);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.b(i.this, (paramAnonymousInt + 1) * i.OAF);
          i.g(i.this);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.h(i.this);
            paramAnonymousInt = b.b.ffW.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.h(i.this);
            paramAnonymousInt = b.b.ffX.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.h(i.this);
            paramAnonymousInt = b.b.ffY.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.h(i.this);
            paramAnonymousInt = b.b.ffZ.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          paramAnonymousString = i.h(i.this);
          paramAnonymousInt = b.b.fga.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143911);
        }
      };
      AppForegroundDelegate.heY.a(this);
      AppMethodBeat.o(143913);
      return;
    }
  }
  
  private void gNX()
  {
    AppMethodBeat.i(143917);
    if (this.OAO > 0L) {}
    for (float f = Math.min(60.0F, 1000.0F * (float)this.OAP / (float)this.OAO); f <= 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(143917);
      return;
    }
    Log.i("MicroMsg.SceneFpsReportService", "[reportMainUI] near 5s fps=" + f + " mainUIFrameCost=" + this.OAO + "ms");
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
    localIDKey.SetValue(this.OAQ[b.b.fga.index]);
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
    localIDKey.SetValue(this.OAQ[b.b.ffZ.index]);
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
    localIDKey.SetValue(this.OAQ[b.b.ffY.index]);
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
    localIDKey.SetValue(this.OAQ[b.b.ffX.index]);
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
    localIDKey.SetValue(this.OAQ[b.b.ffW.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(19);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    f.Ozc.b(localArrayList, false);
    this.OAQ = new int[b.b.values().length];
    this.OAO = 0L;
    this.OAP = 0L;
    AppMethodBeat.o(143917);
  }
  
  public final void BK(boolean paramBoolean)
  {
    AppMethodBeat.i(143914);
    Log.i("MicroMsg.SceneFpsReportService", "[onMainUI] isForce=".concat(String.valueOf(paramBoolean)));
    this.OAG = paramBoolean;
    if (!this.OAG)
    {
      if (this.fdr == null)
      {
        AppMethodBeat.o(143914);
        return;
      }
      this.fdr.b(this.OAR);
      gNX();
    }
    AppMethodBeat.o(143914);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(143916);
    if (this.fdr == null)
    {
      AppMethodBeat.o(143916);
      return;
    }
    this.fdr.b(this.OAR);
    AppMethodBeat.o(143916);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(143915);
    if (this.OAG)
    {
      if (this.fdr == null)
      {
        AppMethodBeat.o(143915);
        return;
      }
      this.fdr.a(this.OAR);
      this.mainHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143912);
          i.d(i.this).b(i.i(i.this));
          i.j(i.this);
          AppMethodBeat.o(143912);
        }
      }, 5000L);
    }
    AppMethodBeat.o(143915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.i
 * JD-Core Version:    0.7.0.1
 */