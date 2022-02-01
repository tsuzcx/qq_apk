package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.a.a.a;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  private static Class[] PnN = { ad.class, x.class, c.class, aq.class, bf.class, g.class, be.class, ao.class, bc.class, t.class, e.class, az.class, al.class, bi.class, m.class, ae.class, z.class, bh.class, aw.class, ak.class, bd.class, b.class, ax.class, aj.class, r.class, o.class, ap.class, ay.class, s.class, bg.class, au.class, am.class, v.class, d.class, y.class, bb.class, as.class, ac.class, ab.class, w.class, f.class, aa.class, n.class, at.class, i.class, j.class, ar.class, av.class, q.class, u.class, an.class };
  private static List<a> PnO;
  
  public static List<a> getComponents()
  {
    AppMethodBeat.i(35178);
    if (PnO == null)
    {
      PnO = new LinkedList();
      localObject = PnN;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = localObject[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.gRF() == a.a.class) {
            PnO.add(new a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          PnO.add(new a(locala.gRF(), localClass));
          continue;
          PnO.add(new a(localClass, localClass));
        }
      }
    }
    Object localObject = PnO;
    AppMethodBeat.o(35178);
    return localObject;
  }
  
  public static final class a
  {
    public Class<? extends af> PnP;
    public Class<? extends af> aWC;
    
    public a(Class<? extends af> paramClass1, Class<? extends af> paramClass2)
    {
      this.aWC = paramClass1;
      this.PnP = paramClass2;
    }
    
    public final af gPt()
    {
      AppMethodBeat.i(35177);
      try
      {
        af localaf = (af)this.PnP.newInstance();
        AppMethodBeat.o(35177);
        return localaf;
      }
      catch (InstantiationException localInstantiationException)
      {
        Log.printErrStackTrace("ChattingComponentFactory", localInstantiationException, "", new Object[0]);
        AppMethodBeat.o(35177);
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.printErrStackTrace("ChattingComponentFactory", localIllegalAccessException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.h
 * JD-Core Version:    0.7.0.1
 */