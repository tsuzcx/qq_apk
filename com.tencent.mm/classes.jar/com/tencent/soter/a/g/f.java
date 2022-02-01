package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f ahyD = null;
  static volatile SparseArray<d> ahyE = null;
  final Object ahyF;
  
  private f()
  {
    AppMethodBeat.i(35);
    this.ahyF = new Object();
    ahyE = new SparseArray(5);
    AppMethodBeat.o(35);
  }
  
  public static f jYD()
  {
    AppMethodBeat.i(36);
    if (ahyD == null) {
      try
      {
        if (ahyD == null) {
          ahyD = new f();
        }
        f localf1 = ahyD;
        return localf1;
      }
      finally
      {
        AppMethodBeat.o(36);
      }
    }
    f localf2 = ahyD;
    AppMethodBeat.o(36);
    return localf2;
  }
  
  public final boolean a(final d paramd, e arg2)
  {
    AppMethodBeat.i(37);
    if (!paramd.jYA())
    {
      int j = paramd.hashCode();
      if (!paramd.jYB())
      {
        com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: not single instance. directly execute", new Object[0]);
        synchronized (this.ahyF)
        {
          ahyE.put(j, paramd);
          g.jYG().au(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211925);
              paramd.execute();
              AppMethodBeat.o(211925);
            }
          });
          AppMethodBeat.o(37);
          return true;
        }
      }
      Object localObject = this.ahyF;
      int i = 0;
      try
      {
        while (i < ahyE.size())
        {
          int k = ahyE.keyAt(i);
          if ((ahyE.get(k) != null) && (((d)ahyE.get(k)).getClass().getName().equals(paramd.getClass().getName())))
          {
            com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
            ???.errCode = 1023;
            ???.errMsg = "add SOTER task to queue failed. check the logcat for further information";
            paramd.c(???);
            return false;
          }
          i += 1;
        }
        ahyE.put(j, paramd);
        g.jYG().au(new Runnable()
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
  
  public final void jYE()
  {
    int i = 0;
    AppMethodBeat.i(38);
    synchronized (this.ahyF)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (ahyE.size() != 0) {
        while (i < ahyE.size())
        {
          final int j = ahyE.keyAt(i);
          g.jYG().au(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.aYV().get(j);
                if (locald != null) {
                  locald.jYC();
                }
                AppMethodBeat.o(33);
                return;
              }
            }
          });
          i += 1;
        }
      }
      ahyE.clear();
      AppMethodBeat.o(38);
      return;
    }
  }
  
  public final void jYF()
  {
    int i = 0;
    AppMethodBeat.i(39);
    synchronized (this.ahyF)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (ahyE.size() != 0) {
        while (i < ahyE.size())
        {
          final int j = ahyE.keyAt(i);
          g.jYG().au(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.aYV().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).jYy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.g.f
 * JD-Core Version:    0.7.0.1
 */