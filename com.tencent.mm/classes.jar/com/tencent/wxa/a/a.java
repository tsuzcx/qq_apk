package com.tencent.wxa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.concurrent.LinkedBlockingQueue;

public final class a
{
  public k.c SxT;
  private LinkedBlockingQueue<b> SxU;
  private k.c SxV;
  private k bbv;
  boolean chu;
  
  public a(c paramc, String paramString)
  {
    AppMethodBeat.i(206312);
    this.chu = true;
    this.SxU = new LinkedBlockingQueue();
    this.SxV = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(206310);
        String str = paramAnonymousj.method;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            if (a.this.SxT != null) {
              a.this.SxT.a(paramAnonymousj, paramAnonymousd);
            }
            break;
          }
          break;
        }
        do
        {
          AppMethodBeat.o(206310);
          return;
          if (!str.equals("onDartChannelReady")) {
            break;
          }
          i = 0;
          break;
          com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "onMethodCall onDartChannelReady", new Object[0]);
        } while (a.this.chu);
        a.this.hrL();
        AppMethodBeat.o(206310);
      }
    };
    this.bbv = new k(paramc, paramString);
    this.bbv.a(this.SxV);
    this.bbv.a("onCheckDartChannelReady", null, new k.d()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject) {}
      
      public final void ba(Object paramAnonymousObject)
      {
        AppMethodBeat.i(206311);
        if (!a.this.chu) {
          a.this.hrL();
        }
        AppMethodBeat.o(206311);
      }
      
      public final void dLv() {}
    });
    AppMethodBeat.o(206312);
  }
  
  public final void a(String paramString, Object paramObject, k.d paramd)
  {
    AppMethodBeat.i(206313);
    if (this.chu)
    {
      this.bbv.a(paramString, paramObject, paramd);
      com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod invoke method %s", new Object[] { paramString });
      AppMethodBeat.o(206313);
      return;
    }
    this.SxU.offer(new b(paramString, paramObject, paramd));
    com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod add invoke method %s", new Object[] { paramString });
    AppMethodBeat.o(206313);
  }
  
  public final void hrL()
  {
    AppMethodBeat.i(206314);
    this.chu = true;
    while (!this.SxU.isEmpty())
    {
      b localb = (b)this.SxU.poll();
      if (localb != null)
      {
        this.bbv.a(localb.method, localb.SxX, localb.SxY);
        com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "notifyChannelReady doing invoke method %s", new Object[] { localb.method });
      }
    }
    AppMethodBeat.o(206314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.a.a
 * JD-Core Version:    0.7.0.1
 */