package com.tencent.mm.ui;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class f$1
  implements f.d
{
  f$1(f paramf) {}
  
  public final void dBg()
  {
    AppMethodBeat.i(29171);
    Object localObject1;
    Object localObject2;
    if (f.a(this.yVK, f.b(this.yVK)))
    {
      localObject1 = new HashSet(f.b(this.yVK).size());
      localObject2 = f.b(this.yVK).values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(((f.b)((Iterator)localObject2).next()).object);
      }
      ab.i(this.yVK.TAG, "newcursor all event is delete");
      f.c(this.yVK).c(((HashSet)localObject1).toArray(), null);
    }
    for (;;)
    {
      f.b(this.yVK).clear();
      AppMethodBeat.o(29171);
      return;
      long l;
      if (!f.b(this.yVK).containsKey(this.yVK.yVJ))
      {
        l = System.currentTimeMillis();
        localObject2 = this.yVK.dBa();
        localObject1 = this.yVK.a(new HashSet(f.b(this.yVK).values()), (SparseArray[])localObject2);
        int j = localObject2.length;
        if (j > 1)
        {
          int i = 0;
          while (i < j)
          {
            ab.i(this.yVK.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[i].size()), Integer.valueOf(localObject1[i].size()) });
            i += 1;
          }
        }
        ab.i(this.yVK.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[0].size()), Integer.valueOf(localObject1[0].size()) });
        localObject2 = f.b(this.yVK).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          f.b localb = (f.b)((Iterator)localObject2).next();
          if (localb != null)
          {
            if (localb.yVN != null) {
              ab.i(this.yVK.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
            }
            f.c(this.yVK).c(localb.object, (a)localb.yVN);
          }
          else
          {
            ab.e(this.yVK.TAG, "newcursor event is null ! ");
          }
        }
        this.yVK.a((SparseArray[])localObject1);
        ab.i(this.yVK.TAG, "newcursor after resort new pos size :%d  ", new Object[] { Integer.valueOf(f.c(this.yVK).dzK()[0].size()) });
      }
      else
      {
        l = System.currentTimeMillis();
        f.a(this.yVK, new f.c(this.yVK, this.yVK.dAZ()), true, false);
        ab.i(this.yVK.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.f.1
 * JD-Core Version:    0.7.0.1
 */