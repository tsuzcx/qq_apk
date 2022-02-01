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
  public k.c MkT;
  private LinkedBlockingQueue<b> MkU;
  private k.c MkV;
  boolean bWM;
  private k vCn;
  
  public a(c paramc, String paramString)
  {
    AppMethodBeat.i(217491);
    this.bWM = true;
    this.MkU = new LinkedBlockingQueue();
    this.MkV = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(217489);
        String str = paramAnonymousj.method;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            if (a.this.MkT != null) {
              a.this.MkT.a(paramAnonymousj, paramAnonymousd);
            }
            break;
          }
          break;
        }
        do
        {
          AppMethodBeat.o(217489);
          return;
          if (!str.equals("onDartChannelReady")) {
            break;
          }
          i = 0;
          break;
          com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "onMethodCall onDartChannelReady", new Object[0]);
        } while (a.this.bWM);
        a.this.fYU();
        AppMethodBeat.o(217489);
      }
    };
    this.vCn = new k(paramc, paramString);
    this.vCn.a(this.MkV);
    this.vCn.a("onCheckDartChannelReady", null, new k.d()
    {
      public final void de(Object paramAnonymousObject)
      {
        AppMethodBeat.i(217490);
        if (!a.this.bWM) {
          a.this.fYU();
        }
        AppMethodBeat.o(217490);
      }
      
      public final void djR() {}
      
      public final void f(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject) {}
    });
    AppMethodBeat.o(217491);
  }
  
  public final void a(String paramString, Object paramObject, k.d paramd)
  {
    AppMethodBeat.i(217492);
    if (this.bWM)
    {
      this.vCn.a(paramString, paramObject, paramd);
      com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod invoke method %s", new Object[] { paramString });
      AppMethodBeat.o(217492);
      return;
    }
    this.MkU.offer(new b(paramString, paramObject, paramd));
    com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod add invoke method %s", new Object[] { paramString });
    AppMethodBeat.o(217492);
  }
  
  public final void fYU()
  {
    AppMethodBeat.i(217493);
    this.bWM = true;
    while (!this.MkU.isEmpty())
    {
      b localb = (b)this.MkU.poll();
      if (localb != null)
      {
        this.vCn.a(localb.method, localb.grf, localb.vCo);
        com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "notifyChannelReady doing invoke method %s", new Object[] { localb.method });
      }
    }
    AppMethodBeat.o(217493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.a.a
 * JD-Core Version:    0.7.0.1
 */