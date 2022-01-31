package com.tencent.mm.ui;

import android.util.SparseArray;
import com.tencent.mm.cf.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class f$1
  implements f.d
{
  f$1(f paramf) {}
  
  public final void cyg()
  {
    Object localObject1;
    Object localObject2;
    if (f.a(this.uIr, f.b(this.uIr)))
    {
      localObject1 = new HashSet(f.b(this.uIr).size());
      localObject2 = f.b(this.uIr).values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(((f.b)((Iterator)localObject2).next()).object);
      }
      y.i(this.uIr.TAG, "newcursor all event is delete");
      f.c(this.uIr).c(((HashSet)localObject1).toArray(), null);
    }
    for (;;)
    {
      f.b(this.uIr).clear();
      return;
      long l;
      if (!f.b(this.uIr).containsKey(this.uIr.uIq))
      {
        l = System.currentTimeMillis();
        localObject2 = this.uIr.cyd();
        localObject1 = this.uIr.a(new HashSet(f.b(this.uIr).values()), (SparseArray[])localObject2);
        int j = localObject2.length;
        if (j > 1)
        {
          int i = 0;
          while (i < j)
          {
            y.i(this.uIr.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[i].size()), Integer.valueOf(localObject1[i].size()) });
            i += 1;
          }
        }
        y.i(this.uIr.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[0].size()), Integer.valueOf(localObject1[0].size()) });
        localObject2 = f.b(this.uIr).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          f.b localb = (f.b)((Iterator)localObject2).next();
          if (localb != null)
          {
            if (localb.uIu != null) {
              y.i(this.uIr.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
            }
            f.c(this.uIr).c(localb.object, (a)localb.uIu);
          }
          else
          {
            y.e(this.uIr.TAG, "newcursor event is null ! ");
          }
        }
        this.uIr.a((SparseArray[])localObject1);
        y.i(this.uIr.TAG, "newcursor after resort new pos size :%d  ", new Object[] { Integer.valueOf(f.c(this.uIr).cwY()[0].size()) });
      }
      else
      {
        l = System.currentTimeMillis();
        f.a(this.uIr, new f.c(this.uIr, this.uIr.cyc()), true, false);
        y.i(this.uIr.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.f.1
 * JD-Core Version:    0.7.0.1
 */