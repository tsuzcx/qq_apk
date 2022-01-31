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
  private final Map<j, ab> NJ;
  
  public ac(Map<j, ab> paramMap)
  {
    super(paramMap, (byte)0);
    Object localObject;
    this.NJ = localObject;
  }
  
  public final void iu()
  {
    int m = 0;
    Object localObject = this.NJ.keySet().iterator();
    int i = 1;
    int j = 0;
    j localj;
    if (((Iterator)localObject).hasNext())
    {
      localj = (j)((Iterator)localObject).next();
      if (localj.gt())
      {
        if (ab.a((ab)this.NJ.get(localj))) {
          break label286;
        }
        j = 1;
      }
    }
    for (int k = 1;; k = 0)
    {
      if (j != 0) {
        m = aa.b(this.NH).d(aa.a(this.NH));
      }
      if ((m != 0) && ((k != 0) || (i != 0)))
      {
        localObject = new ConnectionResult(m, null);
        aa.d(this.NH).a(new an(this.NH)
        {
          public final void iu()
          {
            aa.a(ac.this.NH, this.NK);
          }
        });
        label151:
        return;
        i = 0;
      }
      for (;;)
      {
        break;
        if (aa.e(this.NH)) {
          aa.f(this.NH).connect();
        }
        localObject = this.NJ.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localj = (j)((Iterator)localObject).next();
          final r localr = (r)this.NJ.get(localj);
          if ((localj.gt()) && (m != 0)) {
            aa.d(this.NH).a(new an(this.NH)
            {
              public final void iu()
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