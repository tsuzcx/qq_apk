package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f LRL = null;
  static volatile SparseArray<d> LRM = null;
  final Object LRN;
  
  private f()
  {
    AppMethodBeat.i(35);
    this.LRN = new Object();
    LRM = new SparseArray(5);
    AppMethodBeat.o(35);
  }
  
  public static f fVe()
  {
    AppMethodBeat.i(36);
    if (LRL == null) {
      try
      {
        if (LRL == null) {
          LRL = new f();
        }
        f localf1 = LRL;
        return localf1;
      }
      finally
      {
        AppMethodBeat.o(36);
      }
    }
    f localf2 = LRL;
    AppMethodBeat.o(36);
    return localf2;
  }
  
  public final boolean a(final d paramd, e parame)
  {
    AppMethodBeat.i(37);
    if (!paramd.fVc())
    {
      int j = paramd.hashCode();
      Object localObject = this.LRN;
      int i = 0;
      try
      {
        while (i < LRM.size())
        {
          int k = LRM.keyAt(i);
          if ((LRM.get(k) != null) && (((d)LRM.get(k)).getClass().getName().equals(paramd.getClass().getName())))
          {
            com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
            parame.errCode = 1023;
            parame.errMsg = "add SOTER task to queue failed. check the logcat for further information";
            paramd.c(parame);
            return false;
          }
          i += 1;
        }
        LRM.put(j, paramd);
        g.fVh().af(new Runnable()
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
  
  public final void fVf()
  {
    int i = 0;
    AppMethodBeat.i(38);
    synchronized (this.LRN)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (LRM.size() != 0) {
        while (i < LRM.size())
        {
          final int j = LRM.keyAt(i);
          g.fVh().af(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.ahY().get(j);
                if (locald != null) {
                  locald.fVd();
                }
                AppMethodBeat.o(33);
                return;
              }
            }
          });
          i += 1;
        }
      }
      LRM.clear();
      AppMethodBeat.o(38);
      return;
    }
  }
  
  public final void fVg()
  {
    int i = 0;
    AppMethodBeat.i(39);
    synchronized (this.LRN)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (LRM.size() != 0) {
        while (i < LRM.size())
        {
          final int j = LRM.keyAt(i);
          g.fVh().af(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.ahY().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).fVb();
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