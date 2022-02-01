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
  private static e MHM;
  public com.tencent.wax.a.a MHN;
  private HashSet<a> MHO;
  private final k.c MHP;
  
  public e()
  {
    AppMethodBeat.i(195492);
    this.MHO = new HashSet();
    this.MHP = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(195491);
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
                paramAnonymousd.df(((a.a)localObject).MHy);
                AppMethodBeat.o(195491);
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
            paramAnonymousd.dmQ();
          }
          localHashSet.clear();
        }
        AppMethodBeat.o(195491);
      }
    };
    AppMethodBeat.o(195492);
  }
  
  public static void a(m.c paramc)
  {
    AppMethodBeat.i(195496);
    e locale = gdt();
    locale.MHN = new com.tencent.wax.a.a(paramc.Ka(), "com.tencent.wxa/wxa_router");
    locale.MHN.MHR = locale.MHP;
    AppMethodBeat.o(195496);
  }
  
  public static e gdt()
  {
    AppMethodBeat.i(195493);
    if (MHM == null) {}
    try
    {
      MHM = new e();
      e locale = MHM;
      AppMethodBeat.o(195493);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(195493);
    }
  }
  
  public final void A(String paramString, Object paramObject)
  {
    AppMethodBeat.i(195495);
    this.MHN.a(paramString, paramObject, null);
    AppMethodBeat.o(195495);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(195494);
    if (!this.MHO.contains(parama))
    {
      this.MHO.add(parama);
      AppMethodBeat.o(195494);
      return;
    }
    com.tencent.wax.c.a.i("WxaRouter.WxaRouterPlugin", "had add method call handler %s", new Object[] { Integer.valueOf(parama.hashCode()) });
    AppMethodBeat.o(195494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.e
 * JD-Core Version:    0.7.0.1
 */