package com.tencent.mm.plugin.sns.ad.e;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public final class l
  implements f
{
  public static int zpS = 20480;
  public static int zpT = 30720;
  public static int zpU = 51200;
  public static int zpV = 60;
  public static int zpW = 1800;
  public static int zpX = 43200;
  private Random random;
  private int zpR;
  private long zpY;
  private dgs zpZ;
  private boolean zqa;
  private long zqb;
  private int zqc;
  
  public l()
  {
    AppMethodBeat.i(95031);
    this.zpR = 0;
    this.zpY = 0L;
    this.random = new Random(System.currentTimeMillis());
    this.zpZ = new dgs();
    this.zqa = false;
    this.zqb = 0L;
    this.zqc = 0;
    AppMethodBeat.o(95031);
  }
  
  private void dVb()
  {
    AppMethodBeat.i(95034);
    ah.dXr().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95028);
        if ((System.currentTimeMillis() - l.b(l.this) >= 60000L) || (l.a(l.this).FMW.size() > 1000))
        {
          if ((l.a(l.this) != null) && (l.a(l.this).FMW.size() > 0)) {
            l.d(l.this);
          }
          l.a(l.this, 0L);
        }
        AppMethodBeat.o(95028);
      }
    });
    AppMethodBeat.o(95034);
  }
  
  private void dVc()
  {
    AppMethodBeat.i(95035);
    ah.dXr().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95029);
        l.e(l.this);
        AppMethodBeat.o(95029);
      }
    });
    AppMethodBeat.o(95035);
  }
  
  public static String u(Object... paramVarArgs)
  {
    AppMethodBeat.i(95036);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      ae.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
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
  
  public final void dVa()
  {
    AppMethodBeat.i(95033);
    if (!ah.zAr)
    {
      AppMethodBeat.o(95033);
      return;
    }
    com.tencent.mm.kernel.g.ajS();
    int k = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMQ, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.ajS();
    int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMP, Integer.valueOf(-1))).intValue();
    if (j <= zpX)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = zpW;
      j = zpV;
      i = this.random.nextInt(i - j + 1) + zpV;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      dVb();
      ae.d("MicroMsg.SnsLogMgr", "pass report ");
      AppMethodBeat.o(95033);
      return;
    }
    Object localObject = ah.dXx();
    ae.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
    localObject = ((s)localObject).hKK.a("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.zpR = i;
      dVc();
      dVb();
      AppMethodBeat.o(95033);
      return;
    }
  }
  
  public final void f(final int paramInt, final Object... paramVarArgs)
  {
    AppMethodBeat.i(95032);
    ah.dXr().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95026);
        btf localbtf = new btf();
        localbtf.HgA = paramInt;
        localbtf.HgH = ((int)(System.currentTimeMillis() / 1000L));
        localbtf.nID = 1;
        String str = l.u(paramVarArgs);
        localbtf.HgB = new b(str.getBytes());
        l.a(l.this).FMW.add(localbtf);
        ae.i("MicroMsg.SnsLogMgr", "snsadlog " + paramInt + " " + str);
        if (l.b(l.this) == 0L) {
          l.a(l.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(95026);
      }
    });
    if (this.zqa)
    {
      AppMethodBeat.o(95032);
      return;
    }
    this.zqa = true;
    com.tencent.e.h.MqF.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95027);
        ah.dXr().execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179066);
            l.c(l.this);
            l.this.dVa();
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
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMQ, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        dVc();
        AppMethodBeat.o(95037);
        return;
      }
      Object localObject = paramString.mMj;
      paramString = ah.dXx();
      paramn = new dgs();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        btf localbtf = (btf)((Iterator)localObject).next();
        paramn.FMW.add(localbtf);
      }
      paramString.a(paramn);
    }
    AppMethodBeat.o(95037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.l
 * JD-Core Version:    0.7.0.1
 */