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
  private static e MkO;
  public com.tencent.wax.a.a MkP;
  HashSet<a> MkQ;
  private final k.c MkR;
  
  public e()
  {
    AppMethodBeat.i(217485);
    this.MkQ = new HashSet();
    this.MkR = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(217484);
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
                paramAnonymousd.de(((a.a)localObject).MkB);
                AppMethodBeat.o(217484);
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
            paramAnonymousd.djR();
          }
          localHashSet.clear();
        }
        AppMethodBeat.o(217484);
      }
    };
    AppMethodBeat.o(217485);
  }
  
  public static void a(m.c paramc)
  {
    AppMethodBeat.i(217488);
    e locale = fYT();
    locale.MkP = new com.tencent.wax.a.a(paramc.JS(), "com.tencent.wxa/wxa_router");
    locale.MkP.MkT = locale.MkR;
    AppMethodBeat.o(217488);
  }
  
  public static e fYT()
  {
    AppMethodBeat.i(217486);
    if (MkO == null) {}
    try
    {
      MkO = new e();
      e locale = MkO;
      AppMethodBeat.o(217486);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(217486);
    }
  }
  
  public final void A(String paramString, Object paramObject)
  {
    AppMethodBeat.i(217487);
    this.MkP.a(paramString, paramObject, null);
    AppMethodBeat.o(217487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.e
 * JD-Core Version:    0.7.0.1
 */