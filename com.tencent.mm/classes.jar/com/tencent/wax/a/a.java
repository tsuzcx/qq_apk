package com.tencent.wax.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.concurrent.LinkedBlockingQueue;

public final class a
{
  public k.c MHR;
  private LinkedBlockingQueue<b> MHS;
  private k.c MHT;
  boolean bWM;
  private k vOr;
  
  public a(c paramc, String paramString)
  {
    AppMethodBeat.i(195499);
    this.bWM = true;
    this.MHS = new LinkedBlockingQueue();
    this.MHT = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(195497);
        String str = paramAnonymousj.method;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            if (a.this.MHR != null) {
              a.this.MHR.a(paramAnonymousj, paramAnonymousd);
            }
            break;
          }
          break;
        }
        do
        {
          AppMethodBeat.o(195497);
          return;
          if (!str.equals("onDartChannelReady")) {
            break;
          }
          i = 0;
          break;
          com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "onMethodCall onDartChannelReady", new Object[0]);
        } while (a.this.bWM);
        a.this.gdu();
        AppMethodBeat.o(195497);
      }
    };
    this.vOr = new k(paramc, paramString);
    this.vOr.a(this.MHT);
    this.vOr.a("onCheckDartChannelReady", null, new k.d()
    {
      public final void df(Object paramAnonymousObject)
      {
        AppMethodBeat.i(195498);
        if (!a.this.bWM) {
          a.this.gdu();
        }
        AppMethodBeat.o(195498);
      }
      
      public final void dmQ() {}
      
      public final void f(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject) {}
    });
    AppMethodBeat.o(195499);
  }
  
  public final void a(String paramString, Object paramObject, k.d paramd)
  {
    AppMethodBeat.i(195500);
    if (this.bWM)
    {
      this.vOr.a(paramString, paramObject, paramd);
      com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod invoke method %s", new Object[] { paramString });
      AppMethodBeat.o(195500);
      return;
    }
    this.MHS.offer(new b(paramString, paramObject, paramd));
    com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod add invoke method %s", new Object[] { paramString });
    AppMethodBeat.o(195500);
  }
  
  public final void gdu()
  {
    AppMethodBeat.i(195501);
    this.bWM = true;
    while (!this.MHS.isEmpty())
    {
      b localb = (b)this.MHS.poll();
      if (localb != null)
      {
        this.vOr.a(localb.method, localb.gtF, localb.vOs);
        com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "notifyChannelReady doing invoke method %s", new Object[] { localb.method });
      }
    }
    AppMethodBeat.o(195501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.a.a
 * JD-Core Version:    0.7.0.1
 */