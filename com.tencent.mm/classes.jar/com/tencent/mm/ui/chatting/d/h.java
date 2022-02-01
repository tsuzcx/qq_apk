package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.a.a.a;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  private static Class[] WHZ = { ae.class, y.class, c.class, as.class, bi.class, g.class, bh.class, aq.class, bf.class, u.class, e.class, bc.class, an.class, bl.class, n.class, af.class, aa.class, bk.class, az.class, al.class, bg.class, b.class, ba.class, ak.class, s.class, p.class, ar.class, bb.class, t.class, bj.class, ax.class, ao.class, w.class, d.class, z.class, be.class, au.class, am.class, ad.class, ac.class, x.class, f.class, ab.class, o.class, aw.class, av.class, i.class, k.class, at.class, ay.class, r.class, v.class, ap.class, j.class };
  private static List<a> WIa;
  
  public static List<a> getComponents()
  {
    AppMethodBeat.i(35178);
    if (WIa == null)
    {
      WIa = new LinkedList();
      localObject = WHZ;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = localObject[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.hRc() == a.a.class) {
            WIa.add(new a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          WIa.add(new a(locala.hRc(), localClass));
          continue;
          WIa.add(new a(localClass, localClass));
        }
      }
    }
    Object localObject = WIa;
    AppMethodBeat.o(35178);
    return localObject;
  }
  
  public static final class a
  {
    public Class<? extends ag> WIb;
    public Class<? extends ag> aFS;
    
    public a(Class<? extends ag> paramClass1, Class<? extends ag> paramClass2)
    {
      this.aFS = paramClass1;
      this.WIb = paramClass2;
    }
    
    public final ag hOJ()
    {
      AppMethodBeat.i(35177);
      try
      {
        ag localag = (ag)this.WIb.newInstance();
        AppMethodBeat.o(35177);
        return localag;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.h
 * JD-Core Version:    0.7.0.1
 */