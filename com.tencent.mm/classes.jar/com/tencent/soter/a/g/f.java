package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f MoI = null;
  static volatile SparseArray<d> MoJ = null;
  final Object MoK;
  
  private f()
  {
    AppMethodBeat.i(35);
    this.MoK = new Object();
    MoJ = new SparseArray(5);
    AppMethodBeat.o(35);
  }
  
  public static f fZD()
  {
    AppMethodBeat.i(36);
    if (MoI == null) {
      try
      {
        if (MoI == null) {
          MoI = new f();
        }
        f localf1 = MoI;
        return localf1;
      }
      finally
      {
        AppMethodBeat.o(36);
      }
    }
    f localf2 = MoI;
    AppMethodBeat.o(36);
    return localf2;
  }
  
  public final boolean a(final d paramd, e parame)
  {
    AppMethodBeat.i(37);
    if (!paramd.fZB())
    {
      int j = paramd.hashCode();
      Object localObject = this.MoK;
      int i = 0;
      try
      {
        while (i < MoJ.size())
        {
          int k = MoJ.keyAt(i);
          if ((MoJ.get(k) != null) && (((d)MoJ.get(k)).getClass().getName().equals(paramd.getClass().getName())))
          {
            com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
            parame.errCode = 1023;
            parame.errMsg = "add SOTER task to queue failed. check the logcat for further information";
            paramd.c(parame);
            return false;
          }
          i += 1;
        }
        MoJ.put(j, paramd);
        g.fZG().ad(new Runnable()
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
  
  public final void fZE()
  {
    int i = 0;
    AppMethodBeat.i(38);
    synchronized (this.MoK)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (MoJ.size() != 0) {
        while (i < MoJ.size())
        {
          final int j = MoJ.keyAt(i);
          g.fZG().ad(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.ain().get(j);
                if (locald != null) {
                  locald.fZC();
                }
                AppMethodBeat.o(33);
                return;
              }
            }
          });
          i += 1;
        }
      }
      MoJ.clear();
      AppMethodBeat.o(38);
      return;
    }
  }
  
  public final void fZF()
  {
    int i = 0;
    AppMethodBeat.i(39);
    synchronized (this.MoK)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (MoJ.size() != 0) {
        while (i < MoJ.size())
        {
          final int j = MoJ.keyAt(i);
          g.fZG().ad(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.ain().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).fZA();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.f
 * JD-Core Version:    0.7.0.1
 */