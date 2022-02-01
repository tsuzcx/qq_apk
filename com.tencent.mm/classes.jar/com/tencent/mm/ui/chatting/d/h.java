package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.a.a.a;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  private static Class[] Kcr = { ab.class, v.class, c.class, an.class, bc.class, g.class, bb.class, al.class, az.class, s.class, e.class, aw.class, aj.class, bf.class, m.class, ac.class, x.class, o.class, be.class, at.class, ai.class, ba.class, b.class, au.class, ah.class, q.class, am.class, av.class, r.class, bd.class, ar.class, ak.class, t.class, d.class, w.class, ay.class, ap.class, aa.class, z.class, u.class, f.class, y.class, n.class, aq.class, u.class, i.class, j.class, ao.class, as.class };
  private static List<a> Kcs;
  
  public static List<a> getComponents()
  {
    AppMethodBeat.i(35178);
    if (Kcs == null)
    {
      Kcs = new LinkedList();
      localObject = Kcr;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = localObject[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.fJv() == a.a.class) {
            Kcs.add(new a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          Kcs.add(new a(locala.fJv(), localClass));
          continue;
          Kcs.add(new a(localClass, localClass));
        }
      }
    }
    Object localObject = Kcs;
    AppMethodBeat.o(35178);
    return localObject;
  }
  
  public static final class a
  {
    public Class<? extends ad> Kct;
    public Class<? extends ad> aWK;
    
    public a(Class<? extends ad> paramClass1, Class<? extends ad> paramClass2)
    {
      this.aWK = paramClass1;
      this.Kct = paramClass2;
    }
    
    public final ad fHn()
    {
      AppMethodBeat.i(35177);
      try
      {
        ad localad = (ad)this.Kct.newInstance();
        AppMethodBeat.o(35177);
        return localad;
      }
      catch (InstantiationException localInstantiationException)
      {
        ae.printErrStackTrace("ChattingComponentFactory", localInstantiationException, "", new Object[0]);
        AppMethodBeat.o(35177);
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          ae.printErrStackTrace("ChattingComponentFactory", localIllegalAccessException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.h
 * JD-Core Version:    0.7.0.1
 */