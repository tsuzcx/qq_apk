package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f Iwh = null;
  static volatile SparseArray<d> Iwi = null;
  final Object Iwj;
  
  private f()
  {
    AppMethodBeat.i(35);
    this.Iwj = new Object();
    Iwi = new SparseArray(5);
    AppMethodBeat.o(35);
  }
  
  public static f fnw()
  {
    AppMethodBeat.i(36);
    if (Iwh == null) {
      try
      {
        if (Iwh == null) {
          Iwh = new f();
        }
        f localf1 = Iwh;
        return localf1;
      }
      finally
      {
        AppMethodBeat.o(36);
      }
    }
    f localf2 = Iwh;
    AppMethodBeat.o(36);
    return localf2;
  }
  
  public final boolean a(final d paramd, e parame)
  {
    AppMethodBeat.i(37);
    if (!paramd.fnu())
    {
      int j = paramd.hashCode();
      Object localObject = this.Iwj;
      int i = 0;
      try
      {
        while (i < Iwi.size())
        {
          int k = Iwi.keyAt(i);
          if ((Iwi.get(k) != null) && (((d)Iwi.get(k)).getClass().getName().equals(paramd.getClass().getName())))
          {
            com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
            parame.errCode = 1023;
            parame.errMsg = "add SOTER task to queue failed. check the logcat for further information";
            paramd.c(parame);
            return false;
          }
          i += 1;
        }
        Iwi.put(j, paramd);
        g.fnz().ae(new Runnable()
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
  
  public final void fnx()
  {
    int i = 0;
    AppMethodBeat.i(38);
    synchronized (this.Iwj)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (Iwi.size() != 0) {
        while (i < Iwi.size())
        {
          final int j = Iwi.keyAt(i);
          g.fnz().ae(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.adW().get(j);
                if (locald != null) {
                  locald.fnv();
                }
                AppMethodBeat.o(33);
                return;
              }
            }
          });
          i += 1;
        }
      }
      Iwi.clear();
      AppMethodBeat.o(38);
      return;
    }
  }
  
  public final void fny()
  {
    int i = 0;
    AppMethodBeat.i(39);
    synchronized (this.Iwj)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (Iwi.size() != 0) {
        while (i < Iwi.size())
        {
          final int j = Iwi.keyAt(i);
          g.fnz().ae(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.adW().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).fnt();
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