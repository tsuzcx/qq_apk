package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.a.a.a;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  private static Class[] Gtn = { z.class, t.class, c.class, al.class, ax.class, g.class, aw.class, aj.class, au.class, q.class, e.class, ar.class, ah.class, ba.class, k.class, aa.class, v.class, m.class, az.class, ao.class, ag.class, av.class, b.class, ap.class, af.class, o.class, ak.class, aq.class, p.class, ay.class, an.class, ai.class, r.class, d.class, u.class, at.class, am.class, y.class, x.class, s.class, f.class, w.class, l.class };
  private static List<a> Gto;
  
  public static List<a> getComponents()
  {
    AppMethodBeat.i(35178);
    if (Gto == null)
    {
      Gto = new LinkedList();
      localObject = Gtn;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = localObject[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.eYT() == a.a.class) {
            Gto.add(new a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          Gto.add(new a(locala.eYT(), localClass));
          continue;
          Gto.add(new a(localClass, localClass));
        }
      }
    }
    Object localObject = Gto;
    AppMethodBeat.o(35178);
    return localObject;
  }
  
  public static final class a
  {
    public Class<? extends ab> Gtp;
    public Class<? extends ab> aLD;
    
    public a(Class<? extends ab> paramClass1, Class<? extends ab> paramClass2)
    {
      this.aLD = paramClass1;
      this.Gtp = paramClass2;
    }
    
    public final ab eXe()
    {
      AppMethodBeat.i(35177);
      try
      {
        ab localab = (ab)this.Gtp.newInstance();
        AppMethodBeat.o(35177);
        return localab;
      }
      catch (InstantiationException localInstantiationException)
      {
        ad.printErrStackTrace("ChattingComponentFactory", localInstantiationException, "", new Object[0]);
        AppMethodBeat.o(35177);
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          ad.printErrStackTrace("ChattingComponentFactory", localIllegalAccessException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.h
 * JD-Core Version:    0.7.0.1
 */