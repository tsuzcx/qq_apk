package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.a.a.a;
import java.util.LinkedList;
import java.util.List;

public final class g
{
  private static Class[] vpk = { t.class, q.class, c.class, ad.class, an.class, f.class, am.class, ab.class, ak.class, o.class, e.class, ai.class, z.class, aq.class, j.class, u.class, s.class, k.class, ap.class, af.class, y.class, al.class, b.class, ag.class, x.class, m.class, ac.class, ah.class, n.class, ao.class, ae.class, aa.class, p.class, d.class, r.class };
  private static List<g.a> vpl;
  
  public static List<g.a> cEd()
  {
    if (vpl == null)
    {
      vpl = new LinkedList();
      Class[] arrayOfClass = vpk;
      int j = arrayOfClass.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.cFA() == a.a.class) {
            vpl.add(new g.a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          vpl.add(new g.a(locala.cFA(), localClass));
          continue;
          vpl.add(new g.a(localClass, localClass));
        }
      }
    }
    return vpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.g
 * JD-Core Version:    0.7.0.1
 */