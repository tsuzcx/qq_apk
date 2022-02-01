package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.component.annotation.a;
import com.tencent.mm.ui.chatting.component.annotation.a.a;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  private static Class[] aeqf = { ah.class, ab.class, BizComponent.class, ax.class, bp.class, g.class, bo.class, au.class, bm.class, x.class, e.class, bj.class, ar.class, bt.class, o.class, ai.class, ad.class, bs.class, bg.class, ap.class, bn.class, b.class, bh.class, ao.class, v.class, r.class, av.class, bi.class, w.class, br.class, be.class, as.class, z.class, d.class, ac.class, bl.class, bb.class, aq.class, ag.class, af.class, bq.class, aa.class, f.class, ae.class, p.class, bd.class, ay.class, bc.class, i.class, l.class, u.class, ba.class, bf.class, az.class, t.class, y.class, at.class, j.class, aw.class, OpenIMArchiveComponent.class, c.class, q.class, com.tencent.mm.ui.chatting.m.b.class };
  private static List<a> aeqg;
  
  public static List<a> getComponents()
  {
    AppMethodBeat.i(35178);
    if (aeqg == null)
    {
      aeqg = new LinkedList();
      localObject = aeqf;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Class localClass = localObject[i];
        a locala;
        if (localClass.isAnnotationPresent(a.class))
        {
          locala = (a)localClass.getAnnotation(a.class);
          if (locala.juB() == a.a.class) {
            aeqg.add(new a(localClass, localClass));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          aeqg.add(new a(locala.juB(), localClass));
          continue;
          aeqg.add(new a(localClass, localClass));
        }
      }
    }
    Object localObject = aeqg;
    AppMethodBeat.o(35178);
    return localObject;
  }
  
  public static final class a
  {
    public Class<? extends aj> aeqh;
    public Class<? extends aj> clazz;
    
    public a(Class<? extends aj> paramClass1, Class<? extends aj> paramClass2)
    {
      this.clazz = paramClass1;
      this.aeqh = paramClass2;
    }
    
    public final aj jrz()
    {
      AppMethodBeat.i(35177);
      try
      {
        aj localaj = (aj)this.aeqh.newInstance();
        AppMethodBeat.o(35177);
        return localaj;
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
 * Qualified Name:     com.tencent.mm.ui.chatting.component.h
 * JD-Core Version:    0.7.0.1
 */