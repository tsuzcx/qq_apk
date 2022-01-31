package com.tencent.mm.plugin.radar.b;

import a.d.b.p;
import a.k;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c$f
  implements c.d
{
  c$f(String paramString, long paramLong) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    Object localObject;
    if (paramBoolean1)
    {
      localObject = com.tencent.mm.kernel.g.r(j.class);
      a.d.b.g.j(localObject, "service(IMessengerStorage::class.java)");
      localObject = ((j)localObject).Fw().abl(paramString1);
      a.d.b.g.j(localObject, "contact");
      if (((ad)localObject).Bo() > 0) {
        s.q((ad)localObject);
      }
      c.cj(paramString1, 1);
      localObject = (Iterable)c.a(this.nkD);
      a.d.b.g.k(localObject, "$receiver");
      boolean bool;
      if ((localObject instanceof Collection)) {
        bool = ((Collection)localObject).contains(paramString1);
      }
      while (bool)
      {
        localObject = (Collection)c.a(this.nkD);
        if (localObject == null)
        {
          throw new k("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          a.d.b.g.k(localObject, "$receiver");
          int i;
          if ((localObject instanceof List)) {
            i = ((List)localObject).indexOf(paramString1);
          }
          for (;;)
          {
            if (i < 0) {
              break label227;
            }
            bool = true;
            break;
            localObject = ((Iterable)localObject).iterator();
            int j = 0;
            for (;;)
            {
              if (!((Iterator)localObject).hasNext()) {
                break label221;
              }
              i = j;
              if (a.d.b.g.e(paramString1, ((Iterator)localObject).next())) {
                break;
              }
              j += 1;
            }
            label221:
            i = -1;
          }
          label227:
          bool = false;
        }
        else
        {
          p.cx(localObject).remove(paramString1);
        }
      }
      localObject = c.nkz;
      y.d(c.access$getTAG$cp(), "addContact %s return ok", new Object[] { this.ghe });
    }
    for (;;)
    {
      c.a(this.nkD, paramBoolean1, paramBoolean2, paramString2, paramString1, this.nkJ);
      return;
      if (paramBoolean2)
      {
        if ((paramString1 != null) && (!c.a(this.nkD).contains(paramString1))) {
          c.a(this.nkD).add(paramString1);
        }
        c.cj(paramString1, 2);
        localObject = c.nkz;
        y.d(c.access$getTAG$cp(), "addContact has sent verify to %s", new Object[] { this.ghe });
      }
      else
      {
        localObject = c.nkz;
        y.d(c.access$getTAG$cp(), "addContact return not ok, user canceled or error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c.f
 * JD-Core Version:    0.7.0.1
 */