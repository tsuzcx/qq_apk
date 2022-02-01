package com.tencent.wxa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.HashSet;
import java.util.Iterator;

public class d
  implements io.flutter.embedding.engine.plugins.a
{
  public final String ZYU;
  private final String ZYV;
  public com.tencent.wxa.a.a ZYW;
  private HashSet<b> ZYX;
  private final k.c ZYY;
  
  public d()
  {
    AppMethodBeat.i(224799);
    this.ZYU = "WxaRouterPlugin";
    this.ZYV = "com.tencent.wxa/wxa_router";
    this.ZYX = new HashSet();
    this.ZYY = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(224798);
        HashSet localHashSet = new HashSet();
        localHashSet.addAll(d.a(d.this));
        String str = paramAnonymousj.method;
        if (!localHashSet.isEmpty())
        {
          Iterator localIterator = localHashSet.iterator();
          boolean bool = false;
          while (localIterator.hasNext())
          {
            Object localObject = (b)localIterator.next();
            if (!bool)
            {
              localObject = ((b)localObject).a(paramAnonymousj);
              bool = ((b.a)localObject).result;
              if (((b.a)localObject).result)
              {
                com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s success ", new Object[] { str });
                paramAnonymousd.bb(((b.a)localObject).ZYG);
                AppMethodBeat.o(224798);
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
            paramAnonymousd.epZ();
          }
          localHashSet.clear();
        }
        AppMethodBeat.o(224798);
      }
    };
    AppMethodBeat.o(224799);
  }
  
  public final void G(String paramString, Object paramObject)
  {
    AppMethodBeat.i(224807);
    this.ZYW.a(paramString, paramObject, null);
    AppMethodBeat.o(224807);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(224802);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "onAttachedToEngine", new Object[0]);
    this.ZYW = new com.tencent.wxa.a.a(paramb.aaqF, "com.tencent.wxa/wxa_router");
    this.ZYW.ZZa = this.ZYY;
    AppMethodBeat.o(224802);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(224803);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "onDetachedFromEngine", new Object[0]);
    if (this.ZYW != null) {
      this.ZYW.ZZa = null;
    }
    AppMethodBeat.o(224803);
  }
  
  public final void l(HashSet<b> paramHashSet)
  {
    AppMethodBeat.i(224805);
    if (!this.ZYX.contains(paramHashSet))
    {
      this.ZYX.addAll(paramHashSet);
      AppMethodBeat.o(224805);
      return;
    }
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "had add method call handler %s", new Object[] { Integer.valueOf(paramHashSet.hashCode()) });
    AppMethodBeat.o(224805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.d
 * JD-Core Version:    0.7.0.1
 */