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
  public k.c KuS;
  private LinkedBlockingQueue<b> KuT;
  private k.c KuU;
  boolean bMz;
  private k uzK;
  
  public a(c paramc, String paramString)
  {
    AppMethodBeat.i(191694);
    this.bMz = true;
    this.KuT = new LinkedBlockingQueue();
    this.KuU = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(191692);
        String str = paramAnonymousj.method;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            if (a.this.KuS != null) {
              a.this.KuS.a(paramAnonymousj, paramAnonymousd);
            }
            break;
          }
          break;
        }
        do
        {
          AppMethodBeat.o(191692);
          return;
          if (!str.equals("onDartChannelReady")) {
            break;
          }
          i = 0;
          break;
          com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "onMethodCall onDartChannelReady", new Object[0]);
        } while (a.this.bMz);
        a.this.fHD();
        AppMethodBeat.o(191692);
      }
    };
    this.uzK = new k(paramc, paramString);
    this.uzK.a(this.KuU);
    this.uzK.a("onCheckDartChannelReady", null, new k.d()
    {
      public final void daE() {}
      
      public final void db(Object paramAnonymousObject)
      {
        AppMethodBeat.i(191693);
        if (!a.this.bMz) {
          a.this.fHD();
        }
        AppMethodBeat.o(191693);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject) {}
    });
    AppMethodBeat.o(191694);
  }
  
  public final void a(String paramString, Object paramObject, k.d paramd)
  {
    AppMethodBeat.i(191695);
    if (this.bMz)
    {
      this.uzK.a(paramString, paramObject, paramd);
      com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod invoke method %s", new Object[] { paramString });
      AppMethodBeat.o(191695);
      return;
    }
    this.KuT.offer(new b(paramString, paramObject, paramd));
    com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod add invoke method %s", new Object[] { paramString });
    AppMethodBeat.o(191695);
  }
  
  public final void fHD()
  {
    AppMethodBeat.i(191696);
    this.bMz = true;
    while (!this.KuT.isEmpty())
    {
      b localb = (b)this.KuT.poll();
      if (localb != null)
      {
        this.uzK.a(localb.method, localb.fXJ, localb.uzL);
        com.tencent.wax.c.a.d("WxaRouter.SafeMethodChannel", "notifyChannelReady doing invoke method %s", new Object[] { localb.method });
      }
    }
    AppMethodBeat.o(191696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.a.a
 * JD-Core Version:    0.7.0.1
 */