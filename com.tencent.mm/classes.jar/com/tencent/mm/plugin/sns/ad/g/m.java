package com.tencent.mm.plugin.sns.ad.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public final class m
  implements com.tencent.mm.ak.i
{
  public static int Dwb = 20480;
  public static int Dwc = 30720;
  public static int Dwd = 51200;
  public static int Dwe = 60;
  public static int Dwf = 1800;
  public static int Dwg = 43200;
  private int Dwa;
  private long Dwh;
  private dzz Dwi;
  private boolean Dwj;
  private long Dwk;
  private int Dwl;
  private Random random;
  
  public m()
  {
    AppMethodBeat.i(95031);
    this.Dwa = 0;
    this.Dwh = 0L;
    this.random = new Random(System.currentTimeMillis());
    this.Dwi = new dzz();
    this.Dwj = false;
    this.Dwk = 0L;
    this.Dwl = 0;
    AppMethodBeat.o(95031);
  }
  
  private void eXv()
  {
    AppMethodBeat.i(95034);
    aj.faB().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95028);
        if ((System.currentTimeMillis() - m.b(m.this) >= 60000L) || (m.a(m.this).KGB.size() > 1000))
        {
          if ((m.a(m.this) != null) && (m.a(m.this).KGB.size() > 0)) {
            m.d(m.this);
          }
          m.a(m.this, 0L);
        }
        AppMethodBeat.o(95028);
      }
    });
    AppMethodBeat.o(95034);
  }
  
  private void eXw()
  {
    AppMethodBeat.i(95035);
    aj.faB().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95029);
        m.e(m.this);
        AppMethodBeat.o(95029);
      }
    });
    AppMethodBeat.o(95035);
  }
  
  public static String u(Object... paramVarArgs)
  {
    AppMethodBeat.i(95036);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      Log.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
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
  
  public final void a(final int paramInt, final Object... paramVarArgs)
  {
    AppMethodBeat.i(95032);
    aj.faB().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95026);
        cfy localcfy = new cfy();
        localcfy.MlF = paramInt;
        localcfy.MlM = ((int)(System.currentTimeMillis() / 1000L));
        localcfy.oTz = 1;
        String str = m.u(paramVarArgs);
        localcfy.MlG = new b(str.getBytes());
        m.a(m.this).KGB.add(localcfy);
        Log.i("MicroMsg.SnsLogMgr", "snsadlog " + paramInt + " " + str);
        if (m.b(m.this) == 0L) {
          m.a(m.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(95026);
      }
    });
    if (this.Dwj)
    {
      AppMethodBeat.o(95032);
      return;
    }
    this.Dwj = true;
    com.tencent.f.h.RTc.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95027);
        aj.faB().execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179066);
            m.c(m.this);
            m.this.eXu();
            AppMethodBeat.o(179066);
          }
        });
        AppMethodBeat.o(95027);
      }
    }, 2000L);
    AppMethodBeat.o(95032);
  }
  
  public final void eXu()
  {
    AppMethodBeat.i(95033);
    if (!aj.DKh)
    {
      AppMethodBeat.o(95033);
      return;
    }
    g.aAi();
    int k = ((Integer)g.aAh().azQ().get(ar.a.NUT, Integer.valueOf(0))).intValue();
    g.aAi();
    int j = ((Integer)g.aAh().azQ().get(ar.a.NUS, Integer.valueOf(-1))).intValue();
    if (j <= Dwg)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = Dwf;
      j = Dwe;
      i = this.random.nextInt(i - j + 1) + Dwe;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      eXv();
      Log.d("MicroMsg.SnsLogMgr", "pass report ");
      AppMethodBeat.o(95033);
      return;
    }
    Object localObject = aj.faH();
    Log.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
    localObject = ((p)localObject).iFy.rawQuery("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.Dwa = i;
      eXw();
      eXv();
      AppMethodBeat.o(95033);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(95037);
    if ((paramq.getType() == 1802) && ((paramq instanceof h)))
    {
      paramString = (h)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        g.aAi();
        g.aAh().azQ().set(ar.a.NUT, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        eXw();
        AppMethodBeat.o(95037);
        return;
      }
      Object localObject = paramString.nZr;
      paramString = aj.faH();
      paramq = new dzz();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cfy localcfy = (cfy)((Iterator)localObject).next();
        paramq.KGB.add(localcfy);
      }
      paramString.a(paramq);
    }
    AppMethodBeat.o(95037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.m
 * JD-Core Version:    0.7.0.1
 */