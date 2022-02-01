package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.a.a.a;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  private static Class[] HTg = { z.class, t.class, c.class, al.class, ax.class, g.class, aw.class, aj.class, au.class, q.class, e.class, ar.class, ah.class, ba.class, k.class, aa.class, v.class, m.class, az.class, ao.class, ag.class, av.class, b.class, ap.class, af.class, o.class, ak.class, aq.class, p.class, ay.class, an.class, ai.class, r.class, d.class, u.class, at.class, am.class, y.class, x.class, s.class, f.class, w.class, l.class };
  private static List<a> HTh;
  
  public static List<a> getComponents()
  {
    AppMethodBeat.i(35178);
    if (HTh == null)
    {
      HTh = new LinkedList();
      localObject = HTg;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = localObject[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.foJ() == a.a.class) {
            HTh.add(new a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          HTh.add(new a(locala.foJ(), localClass));
          continue;
          HTh.add(new a(localClass, localClass));
        }
      }
    }
    Object localObject = HTh;
    AppMethodBeat.o(35178);
    return localObject;
  }
  
  public static final class a
  {
    public Class<? extends ab> HTi;
    public Class<? extends ab> aMt;
    
    public a(Class<? extends ab> paramClass1, Class<? extends ab> paramClass2)
    {
      this.aMt = paramClass1;
      this.HTi = paramClass2;
    }
    
    public final ab fmQ()
    {
      AppMethodBeat.i(35177);
      try
      {
        ab localab = (ab)this.HTi.newInstance();
        AppMethodBeat.o(35177);
        return localab;
      }
      catch (InstantiationException localInstantiationException)
      {
        ac.printErrStackTrace("ChattingComponentFactory", localInstantiationException, "", new Object[0]);
        AppMethodBeat.o(35177);
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          ac.printErrStackTrace("ChattingComponentFactory", localIllegalAccessException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.h
 * JD-Core Version:    0.7.0.1
 */