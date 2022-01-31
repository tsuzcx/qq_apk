package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.soter.a.b.e;

public class f
{
  private static volatile f wQf = null;
  static volatile SparseArray<d> wQg = null;
  final Object wQh = new Object();
  
  private f()
  {
    wQg = new SparseArray(5);
  }
  
  public static f cPH()
  {
    if (wQf == null) {
      try
      {
        if (wQf == null) {
          wQf = new f();
        }
        f localf = wQf;
        return localf;
      }
      finally {}
    }
    return wQf;
  }
  
  public final boolean a(d paramd, e parame)
  {
    int j;
    Object localObject;
    int i;
    if (!paramd.cPF())
    {
      j = paramd.hashCode();
      localObject = this.wQh;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < wQg.size())
        {
          int k = wQg.keyAt(i);
          if ((wQg.get(k) == null) || (!((d)wQg.get(k)).getClass().getName().equals(paramd.getClass().getName()))) {
            break label165;
          }
          com.tencent.soter.core.c.d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
          parame.errCode = 26;
          parame.aox = "add SOTER task to queue failed. check the logcat for further information";
          paramd.b(parame);
          return false;
        }
        wQg.put(j, paramd);
        g.cPK().H(new f.1(this, paramd));
        return true;
      }
      finally {}
      com.tencent.soter.core.c.d.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
      return false;
      label165:
      i += 1;
    }
  }
  
  public final void cPI()
  {
    int i = 0;
    synchronized (this.wQh)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
      if (wQg.size() != 0) {
        while (i < wQg.size())
        {
          int j = wQg.keyAt(i);
          g.cPK().H(new f.2(this, j));
          i += 1;
        }
      }
      wQg.clear();
      return;
    }
  }
  
  public final void cPJ()
  {
    int i = 0;
    synchronized (this.wQh)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
      if (wQg.size() != 0) {
        while (i < wQg.size())
        {
          final int j = wQg.keyAt(i);
          g.cPK().H(new Runnable()
          {
            public final void run()
            {
              synchronized (f.a(f.this))
              {
                d locald = (d)f.Cq().get(j);
                if ((locald != null) && ((locald instanceof a)) && (!((a)locald).isCancelled())) {
                  ((a)locald).cPE();
                }
                return;
              }
            }
          });
          i += 1;
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.a.g.f
 * JD-Core Version:    0.7.0.1
 */