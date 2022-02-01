package com.tencent.mm.plugin.sns.ad.d;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public final class k
  implements com.tencent.mm.ak.g
{
  public static int xKc = 20480;
  public static int xKd = 30720;
  public static int xKe = 51200;
  public static int xKf = 60;
  public static int xKg = 1800;
  public static int xKh = 43200;
  private Random random;
  private int xKb;
  private long xKi;
  private dal xKj;
  private boolean xKk;
  private long xKl;
  private int xKm;
  
  public k()
  {
    AppMethodBeat.i(95031);
    this.xKb = 0;
    this.xKi = 0L;
    this.random = new Random(System.currentTimeMillis());
    this.xKj = new dal();
    this.xKk = false;
    this.xKl = 0L;
    this.xKm = 0;
    AppMethodBeat.o(95031);
  }
  
  private void dFL()
  {
    AppMethodBeat.i(95034);
    af.dHE().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95028);
        if ((System.currentTimeMillis() - k.b(k.this) >= 60000L) || (k.a(k.this).DPo.size() > 1000))
        {
          if ((k.a(k.this) != null) && (k.a(k.this).DPo.size() > 0)) {
            k.d(k.this);
          }
          k.a(k.this, 0L);
        }
        AppMethodBeat.o(95028);
      }
    });
    AppMethodBeat.o(95034);
  }
  
  private void dFM()
  {
    AppMethodBeat.i(95035);
    af.dHE().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95029);
        k.e(k.this);
        AppMethodBeat.o(95029);
      }
    });
    AppMethodBeat.o(95035);
  }
  
  public static String v(Object... paramVarArgs)
  {
    AppMethodBeat.i(95036);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      ac.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramVarArgs = "";; paramVarArgs = localStringBuilder.toString())
    {
      AppMethodBeat.o(95036);
      return paramVarArgs;
      localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
        i += 1;
      }
      localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    }
  }
  
  public final void dFK()
  {
    AppMethodBeat.i(95033);
    if (!af.xTh)
    {
      AppMethodBeat.o(95033);
      return;
    }
    com.tencent.mm.kernel.g.agS();
    int k = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGc, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.agS();
    int j = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGb, Integer.valueOf(-1))).intValue();
    if (j <= xKh)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = xKg;
      j = xKf;
      i = this.random.nextInt(i - j + 1) + xKf;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      dFL();
      ac.d("MicroMsg.SnsLogMgr", "pass report ");
      AppMethodBeat.o(95033);
      return;
    }
    Object localObject = af.dHK();
    ac.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
    localObject = ((s)localObject).hpA.a("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.xKb = i;
      dFM();
      dFL();
      AppMethodBeat.o(95033);
      return;
    }
  }
  
  public final void f(final int paramInt, final Object... paramVarArgs)
  {
    AppMethodBeat.i(95032);
    af.dHE().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95026);
        bnz localbnz = new bnz();
        localbnz.Fdx = paramInt;
        localbnz.FdE = ((int)(System.currentTimeMillis() / 1000L));
        localbnz.ncL = 1;
        String str = k.v(paramVarArgs);
        localbnz.Fdy = new b(str.getBytes());
        k.a(k.this).DPo.add(localbnz);
        ac.i("MicroMsg.SnsLogMgr", "snsadlog " + paramInt + " " + str);
        if (k.b(k.this) == 0L) {
          k.a(k.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(95026);
      }
    });
    if (this.xKk)
    {
      AppMethodBeat.o(95032);
      return;
    }
    this.xKk = true;
    com.tencent.e.h.JZN.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95027);
        af.dHE().execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179066);
            k.c(k.this);
            k.this.dFK();
            AppMethodBeat.o(179066);
          }
        });
        AppMethodBeat.o(95027);
      }
    }, 2000L);
    AppMethodBeat.o(95032);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(95037);
    if ((paramn.getType() == 1802) && ((paramn instanceof g)))
    {
      paramString = (g)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGc, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        dFM();
        AppMethodBeat.o(95037);
        return;
      }
      Object localObject = paramString.mgF;
      paramString = af.dHK();
      paramn = new dal();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bnz localbnz = (bnz)((Iterator)localObject).next();
        paramn.DPo.add(localbnz);
      }
      paramString.a(paramn);
    }
    AppMethodBeat.o(95037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.k
 * JD-Core Version:    0.7.0.1
 */