package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.e;

public abstract class d
{
  boolean wPH = false;
  public b wPW;
  
  final void b(e parame)
  {
    f localf;
    for (;;)
    {
      try
      {
        if (this.wPH)
        {
          com.tencent.soter.core.c.d.w("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
          return;
        }
        localf = f.cPH();
        if (this != null)
        {
          ??? = Integer.valueOf(hashCode());
          com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: removing task: %d", new Object[] { ??? });
          if (this != null) {
            break;
          }
          com.tencent.soter.core.c.d.e("Soter.SoterTaskManager", "soter: task is null", new Object[0]);
          g.cPK().d(new d.1(this, parame));
        }
        else
        {
          ??? = "null";
        }
      }
      finally {}
    }
    for (;;)
    {
      synchronized (localf.wQh)
      {
        if (f.wQg.get(hashCode()) == null) {
          com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", new Object[] { Integer.valueOf(hashCode()) });
        }
      }
      f.wQg.remove(hashCode());
    }
  }
  
  abstract boolean cPF();
  
  abstract void cPG();
  
  abstract void execute();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.d
 * JD-Core Version:    0.7.0.1
 */