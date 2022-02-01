package com.tencent.mm.plugin.sns.ad.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public final class n
  implements com.tencent.mm.an.i
{
  public static int JFA = 30720;
  public static int JFB = 51200;
  public static int JFC = 60;
  public static int JFD = 1800;
  public static int JFE = 43200;
  public static int JFz = 20480;
  private long JFF;
  private ejz JFG;
  private boolean JFH;
  private long JFI;
  private int JFJ;
  private int JFy;
  private Random random;
  
  public n()
  {
    AppMethodBeat.i(95031);
    this.JFy = 0;
    this.JFF = 0L;
    this.random = new Random(System.currentTimeMillis());
    this.JFG = new ejz();
    this.JFH = false;
    this.JFI = 0L;
    this.JFJ = 0;
    AppMethodBeat.o(95031);
  }
  
  private void fKW()
  {
    AppMethodBeat.i(95034);
    aj.fOv().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95028);
        if ((System.currentTimeMillis() - n.b(n.this) >= 60000L) || (n.a(n.this).RHT.size() > 1000))
        {
          if ((n.a(n.this) != null) && (n.a(n.this).RHT.size() > 0)) {
            n.d(n.this);
          }
          n.a(n.this, 0L);
        }
        AppMethodBeat.o(95028);
      }
    });
    AppMethodBeat.o(95034);
  }
  
  private void fKX()
  {
    AppMethodBeat.i(95035);
    aj.fOv().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95029);
        n.e(n.this);
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
    aj.fOv().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95026);
        cou localcou = new cou();
        localcou.Twy = paramInt;
        localcou.TwG = ((int)(System.currentTimeMillis() / 1000L));
        localcou.rVx = 1;
        String str = n.u(paramVarArgs);
        localcou.Twz = new b(str.getBytes());
        n.a(n.this).RHT.add(localcou);
        Log.i("MicroMsg.SnsLogMgr", "snsadlog " + paramInt + " " + str);
        if (n.b(n.this) == 0L) {
          n.a(n.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(95026);
      }
    });
    if (this.JFH)
    {
      AppMethodBeat.o(95032);
      return;
    }
    this.JFH = true;
    com.tencent.e.h.ZvG.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95027);
        aj.fOv().execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179066);
            n.c(n.this);
            n.this.fKV();
            AppMethodBeat.o(179066);
          }
        });
        AppMethodBeat.o(95027);
      }
    }, 2000L);
    AppMethodBeat.o(95032);
  }
  
  public final void fKV()
  {
    AppMethodBeat.i(95033);
    if (!aj.JXk)
    {
      AppMethodBeat.o(95033);
      return;
    }
    com.tencent.mm.kernel.h.aHH();
    int k = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViS, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.h.aHH();
    int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViR, Integer.valueOf(-1))).intValue();
    if (j <= JFE)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = JFD;
      j = JFC;
      i = this.random.nextInt(i - j + 1) + JFC;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      fKW();
      Log.d("MicroMsg.SnsLogMgr", "pass report ");
      AppMethodBeat.o(95033);
      return;
    }
    Object localObject = aj.fOB();
    Log.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
    localObject = ((p)localObject).lvy.rawQuery("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.JFy = i;
      fKX();
      fKW();
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
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViS, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        fKX();
        AppMethodBeat.o(95037);
        return;
      }
      Object localObject = paramString.rbc;
      paramString = aj.fOB();
      paramq = new ejz();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cou localcou = (cou)((Iterator)localObject).next();
        paramq.RHT.add(localcou);
      }
      paramString.a(paramq);
    }
    AppMethodBeat.o(95037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.n
 * JD-Core Version:    0.7.0.1
 */