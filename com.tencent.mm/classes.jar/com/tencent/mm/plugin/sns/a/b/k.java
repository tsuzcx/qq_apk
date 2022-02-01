package com.tencent.mm.plugin.sns.a.b;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public final class k
  implements com.tencent.mm.al.g
{
  public static int wyB = 20480;
  public static int wyC = 30720;
  public static int wyD = 51200;
  public static int wyE = 60;
  public static int wyF = 1800;
  public static int wyG = 43200;
  private Random random;
  private int wyA;
  private long wyH;
  private cuz wyI;
  private boolean wyJ;
  private long wyK;
  private int wyL;
  
  public k()
  {
    AppMethodBeat.i(95031);
    this.wyA = 0;
    this.wyH = 0L;
    this.random = new Random(System.currentTimeMillis());
    this.wyI = new cuz();
    this.wyJ = false;
    this.wyK = 0L;
    this.wyL = 0;
    AppMethodBeat.o(95031);
  }
  
  private void drA()
  {
    AppMethodBeat.i(95035);
    af.dth().execute(new Runnable()
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
  
  private void drz()
  {
    AppMethodBeat.i(95034);
    af.dth().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95028);
        if ((System.currentTimeMillis() - k.b(k.this) >= 60000L) || (k.a(k.this).CwS.size() > 1000))
        {
          if ((k.a(k.this) != null) && (k.a(k.this).CwS.size() > 0)) {
            k.d(k.this);
          }
          k.a(k.this, 0L);
        }
        AppMethodBeat.o(95028);
      }
    });
    AppMethodBeat.o(95034);
  }
  
  public static String t(Object... paramVarArgs)
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
  
  public final void dry()
  {
    AppMethodBeat.i(95033);
    if (!af.wGN)
    {
      AppMethodBeat.o(95033);
      return;
    }
    com.tencent.mm.kernel.g.afC();
    int k = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fin, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.g.afC();
    int j = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fim, Integer.valueOf(-1))).intValue();
    if (j <= wyG)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = wyF;
      j = wyE;
      i = this.random.nextInt(i - j + 1) + wyE;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      drz();
      ad.d("MicroMsg.SnsLogMgr", "pass report ");
      AppMethodBeat.o(95033);
      return;
    }
    Object localObject = af.dtn();
    ad.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
    localObject = ((s)localObject).gPa.a("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.wyA = i;
      drA();
      drz();
      AppMethodBeat.o(95033);
      return;
    }
  }
  
  public final void f(final int paramInt, final Object... paramVarArgs)
  {
    AppMethodBeat.i(95032);
    af.dth().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95026);
        bkf localbkf = new bkf();
        localbkf.DIc = paramInt;
        localbkf.DIj = ((int)(System.currentTimeMillis() / 1000L));
        localbkf.mAK = 1;
        String str = k.t(paramVarArgs);
        localbkf.DId = new b(str.getBytes());
        k.a(k.this).CwS.add(localbkf);
        ad.i("MicroMsg.SnsLogMgr", "snsadlog " + paramInt + " " + str);
        if (k.b(k.this) == 0L) {
          k.a(k.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(95026);
      }
    });
    if (this.wyJ)
    {
      AppMethodBeat.o(95032);
      return;
    }
    this.wyJ = true;
    com.tencent.e.h.Iye.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95027);
        af.dth().execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179066);
            k.c(k.this);
            k.this.dry();
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
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fin, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        drA();
        AppMethodBeat.o(95037);
        return;
      }
      Object localObject = paramString.lEL;
      paramString = af.dtn();
      paramn = new cuz();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkf localbkf = (bkf)((Iterator)localObject).next();
        paramn.CwS.add(localbkf);
      }
      paramString.a(paramn);
    }
    AppMethodBeat.o(95037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.k
 * JD-Core Version:    0.7.0.1
 */