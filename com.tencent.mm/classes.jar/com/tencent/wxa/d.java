package com.tencent.wxa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.HashSet;
import java.util.Iterator;

public final class d
  implements io.flutter.embedding.engine.plugins.a
{
  private static com.tencent.wxa.a.a SxP;
  private static HashSet<a> SxQ;
  private final k.c SxR;
  
  static
  {
    AppMethodBeat.i(206309);
    SxQ = new HashSet();
    AppMethodBeat.o(206309);
  }
  
  public d()
  {
    AppMethodBeat.i(206303);
    this.SxR = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(206302);
        HashSet localHashSet = new HashSet();
        localHashSet.addAll(d.fcc());
        String str = paramAnonymousj.method;
        if (!localHashSet.isEmpty())
        {
          Iterator localIterator = localHashSet.iterator();
          boolean bool = false;
          while (localIterator.hasNext())
          {
            Object localObject = (a)localIterator.next();
            if (!bool)
            {
              localObject = ((a)localObject).a(paramAnonymousj);
              bool = ((a.a)localObject).result;
              if (((a.a)localObject).result)
              {
                com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s success ", new Object[] { str });
                paramAnonymousd.ba(((a.a)localObject).SxC);
                AppMethodBeat.o(206302);
              }
            }
            else
            {
              com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s had been consumed", new Object[] { str });
            }
          }
          if (!bool)
          {
            com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s had no ", new Object[] { str });
            paramAnonymousd.dLv();
          }
          localHashSet.clear();
        }
        AppMethodBeat.o(206302);
      }
    };
    AppMethodBeat.o(206303);
  }
  
  public static void G(String paramString, Object paramObject)
  {
    AppMethodBeat.i(206307);
    SxP.a(paramString, paramObject, null);
    AppMethodBeat.o(206307);
  }
  
  public static void a(String paramString, k.d paramd)
  {
    AppMethodBeat.i(206308);
    SxP.a(paramString, null, paramd);
    AppMethodBeat.o(206308);
  }
  
  public static void k(HashSet<a> paramHashSet)
  {
    AppMethodBeat.i(206306);
    if (!SxQ.contains(paramHashSet))
    {
      SxQ.addAll(paramHashSet);
      AppMethodBeat.o(206306);
      return;
    }
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "had add method call handler %s", new Object[] { Integer.valueOf(paramHashSet.hashCode()) });
    AppMethodBeat.o(206306);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(206304);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "onAttachedToEngine", new Object[0]);
    paramb = new com.tencent.wxa.a.a(paramb.SOH, "com.tencent.wxa/wxa_router");
    SxP = paramb;
    paramb.SxT = this.SxR;
    AppMethodBeat.o(206304);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(206305);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "onDetachedFromEngine", new Object[0]);
    if (SxP != null) {
      SxP.SxT = null;
    }
    AppMethodBeat.o(206305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.d
 * JD-Core Version:    0.7.0.1
 */