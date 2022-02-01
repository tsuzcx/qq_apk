package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f JXQ = null;
  static volatile SparseArray<d> JXR = null;
  final Object JXS;
  
  private f()
  {
    AppMethodBeat.i(35);
    this.JXS = new Object();
    JXR = new SparseArray(5);
    AppMethodBeat.o(35);
  }
  
  public static f fDM()
  {
    AppMethodBeat.i(36);
    if (JXQ == null) {
      try
      {
        if (JXQ == null) {
          JXQ = new f();
        }
        f localf1 = JXQ;
        return localf1;
      }
      finally
      {
        AppMethodBeat.o(36);
      }
    }
    f localf2 = JXQ;
    AppMethodBeat.o(36);
    return localf2;
  }
  
  public final boolean a(final d paramd, e parame)
  {
    AppMethodBeat.i(37);
    if (!paramd.fDK())
    {
      int j = paramd.hashCode();
      Object localObject = this.JXS;
      int i = 0;
      try
      {
        while (i < JXR.size())
        {
          int k = JXR.keyAt(i);
          if ((JXR.get(k) != null) && (((d)JXR.get(k)).getClass().getName().equals(paramd.getClass().getName())))
          {
            com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
            parame.errCode = 1023;
            parame.errMsg = "add SOTER task to queue failed. check the logcat for further information";
            paramd.c(parame);
            return false;
          }
          i += 1;
        }
        JXR.put(j, paramd);
        g.fDP().ag(new Runnable()
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
  
  public final void fDN()
  {
    int i = 0;
    AppMethodBeat.i(38);
    synchronized (this.JXS)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (JXR.size() != 0) {
        while (i < JXR.size())
        {
          final int j = JXR.keyAt(i);
          g.fDP().ag(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.afm().get(j);
                if (locald != null) {
                  locald.fDL();
                }
                AppMethodBeat.o(33);
                return;
              }
            }
          });
          i += 1;
        }
      }
      JXR.clear();
      AppMethodBeat.o(38);
      return;
    }
  }
  
  public final void fDO()
  {
    int i = 0;
    AppMethodBeat.i(39);
    synchronized (this.JXS)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (JXR.size() != 0) {
        while (i < JXR.size())
        {
          final int j = JXR.keyAt(i);
          g.fDP().ag(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.afm().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).fDJ();
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