package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f ZtK = null;
  static volatile SparseArray<d> ZtL = null;
  final Object ZtM;
  
  private f()
  {
    AppMethodBeat.i(35);
    this.ZtM = new Object();
    ZtL = new SparseArray(5);
    AppMethodBeat.o(35);
  }
  
  public static f ipn()
  {
    AppMethodBeat.i(36);
    if (ZtK == null) {
      try
      {
        if (ZtK == null) {
          ZtK = new f();
        }
        f localf1 = ZtK;
        return localf1;
      }
      finally
      {
        AppMethodBeat.o(36);
      }
    }
    f localf2 = ZtK;
    AppMethodBeat.o(36);
    return localf2;
  }
  
  public final boolean a(final d paramd, e parame)
  {
    AppMethodBeat.i(37);
    if (!paramd.ipl())
    {
      int j = paramd.hashCode();
      Object localObject = this.ZtM;
      int i = 0;
      try
      {
        while (i < ZtL.size())
        {
          int k = ZtL.keyAt(i);
          if ((ZtL.get(k) != null) && (((d)ZtL.get(k)).getClass().getName().equals(paramd.getClass().getName())))
          {
            com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
            parame.errCode = 1023;
            parame.errMsg = "add SOTER task to queue failed. check the logcat for further information";
            paramd.c(parame);
            return false;
          }
          i += 1;
        }
        ZtL.put(j, paramd);
        g.ipq().am(new Runnable()
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
  
  public final void ipo()
  {
    int i = 0;
    AppMethodBeat.i(38);
    synchronized (this.ZtM)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (ZtL.size() != 0) {
        while (i < ZtL.size())
        {
          final int j = ZtL.keyAt(i);
          g.ipq().am(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.aFW().get(j);
                if (locald != null) {
                  locald.ipm();
                }
                AppMethodBeat.o(33);
                return;
              }
            }
          });
          i += 1;
        }
      }
      ZtL.clear();
      AppMethodBeat.o(38);
      return;
    }
  }
  
  public final void ipp()
  {
    int i = 0;
    AppMethodBeat.i(39);
    synchronized (this.ZtM)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (ZtL.size() != 0) {
        while (i < ZtL.size())
        {
          final int j = ZtL.keyAt(i);
          g.ipq().am(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.aFW().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).ipk();
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