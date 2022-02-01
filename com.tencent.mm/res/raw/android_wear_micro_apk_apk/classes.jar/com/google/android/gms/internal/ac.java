package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.r;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class ac
  extends ag
{
  private final Map<j, ab> Py;
  
  public ac(Map<j, ab> paramMap)
  {
    super(paramMap, (byte)0);
    Object localObject;
    this.Py = localObject;
  }
  
  public final void iC()
  {
    int m = 0;
    Object localObject = this.Py.keySet().iterator();
    int i = 1;
    int j = 0;
    j localj;
    if (((Iterator)localObject).hasNext())
    {
      localj = (j)((Iterator)localObject).next();
      if (localj.gD())
      {
        if (ab.a((ab)this.Py.get(localj))) {
          break label286;
        }
        j = 1;
      }
    }
    for (int k = 1;; k = 0)
    {
      if (j != 0) {
        m = aa.b(this.Pw).d(aa.a(this.Pw));
      }
      if ((m != 0) && ((k != 0) || (i != 0)))
      {
        localObject = new ConnectionResult(m, null);
        aa.d(this.Pw).a(new an(this.Pw)
        {
          public final void iC()
          {
            aa.a(ac.this.Pw, this.Pz);
          }
        });
        label151:
        return;
        i = 0;
      }
      for (;;)
      {
        break;
        if (aa.e(this.Pw)) {
          aa.f(this.Pw).connect();
        }
        localObject = this.Py.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localj = (j)((Iterator)localObject).next();
          final r localr = (r)this.Py.get(localj);
          if ((localj.gD()) && (m != 0)) {
            aa.d(this.Pw).a(new an(this.Pw)
            {
              public final void iC()
              {
                localr.c(new ConnectionResult(16, null));
              }
            });
          } else {
            localj.a(localr);
          }
        }
        break label151;
        label286:
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ac
 * JD-Core Version:    0.7.0.1
 */