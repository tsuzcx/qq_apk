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
  public k.c ZZa;
  private LinkedBlockingQueue<b> ZZb;
  private k.c ZZc;
  private k aKT;
  boolean nAV;
  
  public a(c paramc, String paramString)
  {
    AppMethodBeat.i(224814);
    this.nAV = true;
    this.ZZb = new LinkedBlockingQueue();
    this.ZZc = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(224810);
        String str = paramAnonymousj.method;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            if (a.this.ZZa != null) {
              a.this.ZZa.a(paramAnonymousj, paramAnonymousd);
            }
            break;
          }
          break;
        }
        do
        {
          AppMethodBeat.o(224810);
          return;
          if (!str.equals("onDartChannelReady")) {
            break;
          }
          i = 0;
          break;
          com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "onMethodCall onDartChannelReady", new Object[0]);
        } while (a.this.nAV);
        a.this.ivx();
        AppMethodBeat.o(224810);
      }
    };
    this.aKT = new k(paramc, paramString);
    this.aKT.a(this.ZZc);
    this.aKT.a("onCheckDartChannelReady", null, new k.d()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject) {}
      
      public final void bb(Object paramAnonymousObject)
      {
        AppMethodBeat.i(224812);
        if (!a.this.nAV) {
          a.this.ivx();
        }
        AppMethodBeat.o(224812);
      }
      
      public final void epZ() {}
    });
    AppMethodBeat.o(224814);
  }
  
  public final void a(String paramString, Object paramObject, k.d paramd)
  {
    AppMethodBeat.i(224816);
    if (this.nAV)
    {
      this.aKT.a(paramString, paramObject, paramd);
      com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod invoke method %s", new Object[] { paramString });
      AppMethodBeat.o(224816);
      return;
    }
    this.ZZb.offer(new b(paramString, paramObject, paramd));
    com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod add invoke method %s", new Object[] { paramString });
    AppMethodBeat.o(224816);
  }
  
  public final void ivx()
  {
    AppMethodBeat.i(224818);
    this.nAV = true;
    while (!this.ZZb.isEmpty())
    {
      b localb = (b)this.ZZb.poll();
      if (localb != null)
      {
        this.aKT.a(localb.method, localb.ZZe, localb.ZZf);
        com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "notifyChannelReady doing invoke method %s", new Object[] { localb.method });
      }
    }
    AppMethodBeat.o(224818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.a.a
 * JD-Core Version:    0.7.0.1
 */