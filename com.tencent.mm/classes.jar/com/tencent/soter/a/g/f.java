package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f BnF = null;
  static volatile SparseArray<d> BnG = null;
  final Object BnH;
  
  private f()
  {
    AppMethodBeat.i(10484);
    this.BnH = new Object();
    BnG = new SparseArray(5);
    AppMethodBeat.o(10484);
  }
  
  public static f dVD()
  {
    AppMethodBeat.i(10485);
    if (BnF == null) {
      try
      {
        if (BnF == null) {
          BnF = new f();
        }
        f localf1 = BnF;
        return localf1;
      }
      finally
      {
        AppMethodBeat.o(10485);
      }
    }
    f localf2 = BnF;
    AppMethodBeat.o(10485);
    return localf2;
  }
  
  public final boolean a(d paramd, e parame)
  {
    AppMethodBeat.i(10486);
    if (!paramd.dVB())
    {
      int j = paramd.hashCode();
      Object localObject = this.BnH;
      int i = 0;
      try
      {
        while (i < BnG.size())
        {
          int k = BnG.keyAt(i);
          if ((BnG.get(k) != null) && (((d)BnG.get(k)).getClass().getName().equals(paramd.getClass().getName())))
          {
            com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
            parame.errCode = 26;
            parame.errMsg = "add SOTER task to queue failed. check the logcat for further information";
            paramd.b(parame);
            return false;
          }
          i += 1;
        }
        BnG.put(j, paramd);
        g.dVG().O(new f.1(this, paramd));
        AppMethodBeat.o(10486);
        return true;
      }
      finally
      {
        AppMethodBeat.o(10486);
      }
    }
    com.tencent.soter.core.c.d.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
    AppMethodBeat.o(10486);
    return false;
  }
  
  public final void dVE()
  {
    int i = 0;
    AppMethodBeat.i(10487);
    synchronized (this.BnH)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (BnG.size() != 0) {
        while (i < BnG.size())
        {
          int j = BnG.keyAt(i);
          g.dVG().O(new f.2(this, j));
          i += 1;
        }
      }
      BnG.clear();
      AppMethodBeat.o(10487);
      return;
    }
  }
  
  public final void dVF()
  {
    int i = 0;
    AppMethodBeat.i(10488);
    synchronized (this.BnH)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (BnG.size() != 0) {
        while (i < BnG.size())
        {
          final int j = BnG.keyAt(i);
          g.dVG().O(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(10483);
              synchronized (f.a(f.this))
              {
                d locald = (d)f.Qk().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).dVA();
                }
                AppMethodBeat.o(10483);
                return;
              }
            }
          });
          i += 1;
        }
      }
      AppMethodBeat.o(10488);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.a.g.f
 * JD-Core Version:    0.7.0.1
 */