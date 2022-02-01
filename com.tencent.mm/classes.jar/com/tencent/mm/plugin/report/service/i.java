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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class i
  implements n
{
  public static i wUB;
  public static final long wUC;
  public c cyD;
  public ao hBR;
  private boolean wUD;
  private long wUE;
  private long wUF;
  public int wUG;
  public long wUH;
  private int[] wUI;
  public long[] wUJ;
  public com.tencent.matrix.trace.e.b wUK;
  private long wUL;
  private long wUM;
  private int[] wUN;
  private com.tencent.matrix.trace.e.b wUO;
  
  static
  {
    AppMethodBeat.i(143920);
    wUB = new i();
    wUC = TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.HF().cpI, TimeUnit.NANOSECONDS) + 1L;
    AppMethodBeat.o(143920);
  }
  
  private i()
  {
    AppMethodBeat.i(143913);
    this.wUD = false;
    if (com.tencent.matrix.b.Gp())
    {
      localObject = (a)com.tencent.matrix.b.Gq().V(a.class);
      if ((localObject == null) || (!((a)localObject).isPluginStarted())) {}
    }
    for (Object localObject = ((a)localObject).cyD;; localObject = null)
    {
      this.cyD = ((c)localObject);
      this.hBR = new ao(Looper.getMainLooper());
      this.wUE = 0L;
      this.wUF = 0L;
      this.wUG = 0;
      this.wUH = 0L;
      this.wUI = new int[c.a.values().length];
      this.wUJ = new long[21];
      this.wUK = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143909);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.a(i.this, i.a(i.this) + (paramAnonymousInt + 1) * i.wUC);
          i.b(i.this, i.b(i.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.a.cAE.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.a.cAF.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.a.cAG.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.c(i.this);
            paramAnonymousInt = c.a.cAH.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143909);
            return;
          }
          paramAnonymousString = i.c(i.this);
          paramAnonymousInt = c.a.cAI.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143909);
        }
      };
      this.wUL = 0L;
      this.wUM = 0L;
      this.wUN = new int[c.a.values().length];
      this.wUO = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143911);
          super.a(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt, paramAnonymousBoolean);
          i.c(i.this, i.h(i.this) + (paramAnonymousInt + 1) * i.wUC);
          i.d(i.this, i.i(i.this) + 1L);
          if (paramAnonymousInt >= 42)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.a.cAE.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 24)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.a.cAF.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 9)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.a.cAG.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          if (paramAnonymousInt >= 3)
          {
            paramAnonymousString = i.j(i.this);
            paramAnonymousInt = c.a.cAH.index;
            paramAnonymousString[paramAnonymousInt] += 1;
            AppMethodBeat.o(143911);
            return;
          }
          paramAnonymousString = i.j(i.this);
          paramAnonymousInt = c.a.cAI.index;
          paramAnonymousString[paramAnonymousInt] += 1;
          AppMethodBeat.o(143911);
        }
      };
      AppForegroundDelegate.cHM.a(this);
      AppMethodBeat.o(143913);
      return;
    }
  }
  
  private void dyT()
  {
    AppMethodBeat.i(143917);
    if (this.wUL > 0L) {}
    for (float f = Math.min(60.0F, 1000.0F * (float)this.wUM / (float)this.wUL); f <= 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(143917);
      return;
    }
    ac.i("MicroMsg.SceneFpsReportService", "[reportMainUI] near 5s fps=" + f + " mainUIFrameCost=" + this.wUL + "ms");
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
    localIDKey.SetValue(this.wUN[c.a.cAI.index]);
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
    localIDKey.SetValue(this.wUN[c.a.cAH.index]);
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
    localIDKey.SetValue(this.wUN[c.a.cAG.index]);
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
    localIDKey.SetValue(this.wUN[c.a.cAF.index]);
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
    localIDKey.SetValue(this.wUN[c.a.cAE.index]);
    if (localIDKey.GetValue() > 0L)
    {
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1232);
      localIDKey.SetKey(19);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    e.wTc.b(localArrayList, false);
    this.wUN = new int[c.a.values().length];
    this.wUL = 0L;
    this.wUM = 0L;
    AppMethodBeat.o(143917);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(143916);
    if (this.cyD == null)
    {
      AppMethodBeat.o(143916);
      return;
    }
    this.cyD.b(this.wUO);
    AppMethodBeat.o(143916);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(143915);
    if (this.wUD)
    {
      if (this.cyD == null)
      {
        AppMethodBeat.o(143915);
        return;
      }
      this.cyD.a(this.wUO);
      this.hBR.postDelayed(new Runnable()
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
  
  public final void pQ(boolean paramBoolean)
  {
    AppMethodBeat.i(143914);
    ac.i("MicroMsg.SceneFpsReportService", "[onMainUI] isForce=".concat(String.valueOf(paramBoolean)));
    this.wUD = paramBoolean;
    if (!this.wUD)
    {
      if (this.cyD == null)
      {
        AppMethodBeat.o(143914);
        return;
      }
      this.cyD.b(this.wUO);
      dyT();
    }
    AppMethodBeat.o(143914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.i
 * JD-Core Version:    0.7.0.1
 */