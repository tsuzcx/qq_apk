package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f RRg = null;
  static volatile SparseArray<d> RRh = null;
  final Object RRi;
  
  private f()
  {
    AppMethodBeat.i(35);
    this.RRi = new Object();
    RRh = new SparseArray(5);
    AppMethodBeat.o(35);
  }
  
  public static f hlO()
  {
    AppMethodBeat.i(36);
    if (RRg == null) {
      try
      {
        if (RRg == null) {
          RRg = new f();
        }
        f localf1 = RRg;
        return localf1;
      }
      finally
      {
        AppMethodBeat.o(36);
      }
    }
    f localf2 = RRg;
    AppMethodBeat.o(36);
    return localf2;
  }
  
  public final boolean a(final d paramd, e parame)
  {
    AppMethodBeat.i(37);
    if (!paramd.hlM())
    {
      int j = paramd.hashCode();
      Object localObject = this.RRi;
      int i = 0;
      try
      {
        while (i < RRh.size())
        {
          int k = RRh.keyAt(i);
          if ((RRh.get(k) != null) && (((d)RRh.get(k)).getClass().getName().equals(paramd.getClass().getName())))
          {
            com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
            parame.errCode = 1023;
            parame.errMsg = "add SOTER task to queue failed. check the logcat for further information";
            paramd.c(parame);
            return false;
          }
          i += 1;
        }
        RRh.put(j, paramd);
        g.hlR().aj(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32);
            paramd.execute();
            AppMethodBeat.o(32);
          }
        });
        AppMethodBeat.o(37);
        return true;
      }
      finally
      {
        AppMethodBeat.o(37);
      }
    }
    com.tencent.soter.core.c.d.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
    AppMethodBeat.o(37);
    return false;
  }
  
  public final void hlP()
  {
    int i = 0;
    AppMethodBeat.i(38);
    synchronized (this.RRi)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (RRh.size() != 0) {
        while (i < RRh.size())
        {
          final int j = RRh.keyAt(i);
          g.hlR().aj(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.ayD().get(j);
                if (locald != null) {
                  locald.hlN();
                }
                AppMethodBeat.o(33);
                return;
              }
            }
          });
          i += 1;
        }
      }
      RRh.clear();
      AppMethodBeat.o(38);
      return;
    }
  }
  
  public final void hlQ()
  {
    int i = 0;
    AppMethodBeat.i(39);
    synchronized (this.RRi)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (RRh.size() != 0) {
        while (i < RRh.size())
        {
          final int j = RRh.keyAt(i);
          g.hlR().aj(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.ayD().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).hlL();
                }
                AppMethodBeat.o(34);
                return;
              }
            }
          });
          i += 1;
        }
      }
      AppMethodBeat.o(39);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.f
 * JD-Core Version:    0.7.0.1
 */