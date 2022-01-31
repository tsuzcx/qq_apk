package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class la$1
  implements Runnable
{
  la$1(la paramla) {}
  
  public void run()
  {
    AppMethodBeat.i(149115);
    la.a(this.a).clear();
    la.b(this.a).clear();
    la.c(this.a).clear();
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (la.d(this.a) != null)
    {
      localObject1 = la.d(this.a).U();
      localObject3 = la.d(this.a).V();
      if (localObject1 == null) {
        break label337;
      }
      Iterator localIterator = ((List)localObject1).iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = (jv)localIterator.next();
        String str = ((jv)localObject2).m();
        if (!StringUtil.isEmpty(str)) {
          if (str.startsWith("我的位置")) {
            localObject1 = localObject2;
          } else {
            la.b(this.a).add(new lb(la.d(this.a), (jv)localObject2));
          }
        }
      }
      Collections.sort(la.b(this.a));
      la.a(this.a).addAll(la.b(this.a));
    }
    for (;;)
    {
      if (localObject3 != null)
      {
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MapPoi)((Iterator)localObject2).next();
          if (!StringUtil.isEmpty(((MapPoi)localObject3).getPoiName())) {
            la.c(this.a).add(new lc(la.d(this.a), (MapPoi)localObject3));
          }
        }
        Collections.sort(la.c(this.a));
        la.a(this.a).addAll(la.c(this.a));
      }
      if (localObject1 != null) {
        la.a(this.a).add(new lb(la.d(this.a), (jv)localObject1));
      }
      AppMethodBeat.o(149115);
      return;
      label337:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.la.1
 * JD-Core Version:    0.7.0.1
 */