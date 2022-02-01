package com.tencent.wax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m.c;
import java.util.HashSet;
import java.util.Iterator;

public class e
{
  private static e KuN;
  public com.tencent.wax.a.a KuO;
  HashSet<a> KuP;
  private final k.c KuQ;
  
  public e()
  {
    AppMethodBeat.i(191688);
    this.KuP = new HashSet();
    this.KuQ = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(191687);
        HashSet localHashSet = new HashSet();
        localHashSet.addAll(e.a(e.this));
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
                com.tencent.wax.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s success ", new Object[] { str });
                paramAnonymousd.db(((a.a)localObject).KuA);
                AppMethodBeat.o(191687);
              }
            }
            else
            {
              com.tencent.wax.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s had been consumed", new Object[] { str });
            }
          }
          if (!bool)
          {
            com.tencent.wax.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s had no ", new Object[] { str });
            paramAnonymousd.daE();
          }
          localHashSet.clear();
        }
        AppMethodBeat.o(191687);
      }
    };
    AppMethodBeat.o(191688);
  }
  
  public static void a(m.c paramc)
  {
    AppMethodBeat.i(191691);
    e locale = fHC();
    locale.KuO = new com.tencent.wax.a.a(paramc.Is(), "com.tencent.wxa/wxa_router");
    locale.KuO.KuS = locale.KuQ;
    AppMethodBeat.o(191691);
  }
  
  public static e fHC()
  {
    AppMethodBeat.i(191689);
    if (KuN == null) {}
    try
    {
      KuN = new e();
      e locale = KuN;
      AppMethodBeat.o(191689);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(191689);
    }
  }
  
  public final void C(String paramString, Object paramObject)
  {
    AppMethodBeat.i(191690);
    this.KuO.a(paramString, paramObject, null);
    AppMethodBeat.o(191690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.e
 * JD-Core Version:    0.7.0.1
 */