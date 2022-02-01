package com.tencent.mm.plugin.sns.ad.d;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.protocal.protobuf.dfy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public final class k
  implements f
{
  public static int yZr = 20480;
  public static int yZs = 30720;
  public static int yZt = 51200;
  public static int yZu = 60;
  public static int yZv = 1800;
  public static int yZw = 43200;
  private Random random;
  private long yZA;
  private int yZB;
  private int yZq;
  private long yZx;
  private dfy yZy;
  private boolean yZz;
  
  public k()
  {
    AppMethodBeat.i(95031);
    this.yZq = 0;
    this.yZx = 0L;
    this.random = new Random(System.currentTimeMillis());
    this.yZy = new dfy();
    this.yZz = false;
    this.yZA = 0L;
    this.yZB = 0;
    AppMethodBeat.o(95031);
  }
  
  private void dRD()
  {
    AppMethodBeat.i(95034);
    ag.dTR().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95028);
        if ((System.currentTimeMillis() - k.b(k.this) >= 60000L) || (k.a(k.this).Fuy.size() > 1000))
        {
          if ((k.a(k.this) != null) && (k.a(k.this).Fuy.size() > 0)) {
            k.d(k.this);
          }
          k.a(k.this, 0L);
        }
        AppMethodBeat.o(95028);
      }
    });
    AppMethodBeat.o(95034);
  }
  
  private void dRE()
  {
    AppMethodBeat.i(95035);
    ag.dTR().execute(new Runnable()
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
      ad.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
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
  
  public final void dRC()
  {
    AppMethodBeat.i(95033);
    if (!ag.zjc)
    {
      AppMethodBeat.o(95033);
      return;
    }
    com.tencent.mm.kernel.g.ajD();
    int k = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Isu, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.ajD();
    int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ist, Integer.valueOf(-1))).intValue();
    if (j <= yZw)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = yZv;
      j = yZu;
      i = this.random.nextInt(i - j + 1) + yZu;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      dRD();
      ad.d("MicroMsg.SnsLogMgr", "pass report ");
      AppMethodBeat.o(95033);
      return;
    }
    Object localObject = ag.dTX();
    ad.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
    localObject = ((s)localObject).hHS.a("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.yZq = i;
      dRE();
      dRD();
      AppMethodBeat.o(95033);
      return;
    }
  }
  
  public final void f(final int paramInt, final Object... paramVarArgs)
  {
    AppMethodBeat.i(95032);
    ag.dTR().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95026);
        bsl localbsl = new bsl();
        localbsl.GNa = paramInt;
        localbsl.GNh = ((int)(System.currentTimeMillis() / 1000L));
        localbsl.nDi = 1;
        String str = k.v(paramVarArgs);
        localbsl.GNb = new b(str.getBytes());
        k.a(k.this).Fuy.add(localbsl);
        ad.i("MicroMsg.SnsLogMgr", "snsadlog " + paramInt + " " + str);
        if (k.b(k.this) == 0L) {
          k.a(k.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(95026);
      }
    });
    if (this.yZz)
    {
      AppMethodBeat.o(95032);
      return;
    }
    this.yZz = true;
    com.tencent.e.h.LTJ.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95027);
        ag.dTR().execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179066);
            k.c(k.this);
            k.this.dRC();
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
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Isu, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        dRE();
        AppMethodBeat.o(95037);
        return;
      }
      Object localObject = paramString.mHf;
      paramString = ag.dTX();
      paramn = new dfy();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bsl localbsl = (bsl)((Iterator)localObject).next();
        paramn.Fuy.add(localbsl);
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