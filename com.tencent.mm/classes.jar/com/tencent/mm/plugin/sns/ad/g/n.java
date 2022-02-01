package com.tencent.mm.plugin.sns.ad.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.feh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public final class n
  implements com.tencent.mm.am.h
{
  public static int PWA = 20480;
  public static int PWB = 30720;
  public static int PWC = 51200;
  public static int PWD = 60;
  public static int PWE = 1800;
  public static int PWF = 43200;
  private long PWG;
  private feh PWH;
  private boolean PWI;
  private long PWJ;
  private int PWK;
  private int PWz;
  private Random random;
  
  public n()
  {
    AppMethodBeat.i(95031);
    this.PWz = 0;
    this.PWG = 0L;
    this.random = new Random(System.currentTimeMillis());
    this.PWH = new feh();
    this.PWI = false;
    this.PWJ = 0L;
    this.PWK = 0;
    AppMethodBeat.o(95031);
  }
  
  private void hbn()
  {
    AppMethodBeat.i(95034);
    al.hgo().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95028);
        if ((System.currentTimeMillis() - n.b(n.this) >= 60000L) || (n.a(n.this).YEW.size() > 1000))
        {
          if ((n.a(n.this) != null) && (n.a(n.this).YEW.size() > 0)) {
            n.d(n.this);
          }
          n.a(n.this, 0L);
        }
        AppMethodBeat.o(95028);
      }
    });
    AppMethodBeat.o(95034);
  }
  
  private void hbo()
  {
    AppMethodBeat.i(95035);
    al.hgo().execute(new Runnable()
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
  
  public static String w(Object... paramVarArgs)
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
  
  public final void b(final int paramInt, final Object... paramVarArgs)
  {
    AppMethodBeat.i(95032);
    al.hgo().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95026);
        dfo localdfo = new dfo();
        localdfo.aaLf = paramInt;
        localdfo.aaLn = ((int)(System.currentTimeMillis() / 1000L));
        localdfo.vgN = 1;
        String str = n.w(paramVarArgs);
        localdfo.aaLg = new b(str.getBytes());
        n.a(n.this).YEW.add(localdfo);
        Log.i("MicroMsg.SnsLogMgr", "snsadlog " + paramInt + " " + str);
        if (n.b(n.this) == 0L) {
          n.a(n.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(95026);
      }
    });
    if (this.PWI)
    {
      AppMethodBeat.o(95032);
      return;
    }
    this.PWI = true;
    com.tencent.threadpool.h.ahAA.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95027);
        al.hgo().execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179066);
            n.c(n.this);
            n.this.hbm();
            AppMethodBeat.o(179066);
          }
        });
        AppMethodBeat.o(95027);
      }
    }, 2000L);
    AppMethodBeat.o(95032);
  }
  
  public final void hbm()
  {
    AppMethodBeat.i(95033);
    if (!al.Qus)
    {
      AppMethodBeat.o(95033);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    int k = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKm, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.h.baF();
    int j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKl, Integer.valueOf(-1))).intValue();
    if (j <= PWF)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = PWE;
      j = PWD;
      i = this.random.nextInt(i - j + 1) + PWD;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      hbn();
      Log.d("MicroMsg.SnsLogMgr", "pass report ");
      AppMethodBeat.o(95033);
      return;
    }
    Object localObject = al.hgu();
    Log.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
    localObject = ((y)localObject).omV.rawQuery("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.PWz = i;
      hbo();
      hbn();
      AppMethodBeat.o(95033);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(95037);
    if ((paramp.getType() == 1802) && ((paramp instanceof h)))
    {
      paramString = (h)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acKm, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        hbo();
        AppMethodBeat.o(95037);
        return;
      }
      Object localObject = paramString.eXW;
      paramString = al.hgu();
      paramp = new feh();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dfo localdfo = (dfo)((Iterator)localObject).next();
        paramp.YEW.add(localdfo);
      }
      paramString.a(paramp);
    }
    AppMethodBeat.o(95037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.n
 * JD-Core Version:    0.7.0.1
 */