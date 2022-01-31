package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.a.a.a;
import java.util.LinkedList;
import java.util.List;

public final class g
{
  private static Class[] zEM = { t.class, q.class, c.class, ae.class, ap.class, f.class, ao.class, ac.class, am.class, o.class, e.class, aj.class, aa.class, as.class, j.class, u.class, s.class, k.class, ar.class, ag.class, z.class, an.class, b.class, ah.class, y.class, m.class, ad.class, ai.class, n.class, aq.class, af.class, ab.class, p.class, d.class, r.class, al.class };
  private static List<g.a> zEN;
  
  public static List<g.a> getComponents()
  {
    AppMethodBeat.i(31288);
    if (zEN == null)
    {
      zEN = new LinkedList();
      localObject = zEM;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = localObject[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.dJy() == a.a.class) {
            zEN.add(new g.a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          zEN.add(new g.a(locala.dJy(), localClass));
          continue;
          zEN.add(new g.a(localClass, localClass));
        }
      }
    }
    Object localObject = zEN;
    AppMethodBeat.o(31288);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.g
 * JD-Core Version:    0.7.0.1
 */