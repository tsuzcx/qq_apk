package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.a.a.a;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  private static Class[] JHA = { ab.class, v.class, c.class, an.class, bb.class, g.class, ba.class, al.class, ay.class, s.class, e.class, av.class, aj.class, be.class, m.class, ac.class, x.class, o.class, bd.class, as.class, ai.class, az.class, b.class, at.class, ah.class, q.class, am.class, au.class, r.class, bc.class, ar.class, ak.class, t.class, d.class, w.class, ax.class, ap.class, aa.class, z.class, u.class, f.class, y.class, n.class, aq.class, u.class, i.class, j.class, ao.class };
  private static List<a> JHB;
  
  public static List<a> getComponents()
  {
    AppMethodBeat.i(35178);
    if (JHB == null)
    {
      JHB = new LinkedList();
      localObject = JHA;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = localObject[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.fFo() == a.a.class) {
            JHB.add(new a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          JHB.add(new a(locala.fFo(), localClass));
          continue;
          JHB.add(new a(localClass, localClass));
        }
      }
    }
    Object localObject = JHB;
    AppMethodBeat.o(35178);
    return localObject;
  }
  
  public static final class a
  {
    public Class<? extends ad> JHC;
    public Class<? extends ad> aWK;
    
    public a(Class<? extends ad> paramClass1, Class<? extends ad> paramClass2)
    {
      this.aWK = paramClass1;
      this.JHC = paramClass2;
    }
    
    public final ad fDk()
    {
      AppMethodBeat.i(35177);
      try
      {
        ad localad = (ad)this.JHC.newInstance();
        AppMethodBeat.o(35177);
        return localad;
      }
      catch (InstantiationException localInstantiationException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("ChattingComponentFactory", localInstantiationException, "", new Object[0]);
        AppMethodBeat.o(35177);
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("ChattingComponentFactory", localIllegalAccessException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.h
 * JD-Core Version:    0.7.0.1
 */