package com.tencent.wxa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c;
import com.tencent.wxa.d.b.a;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.concurrent.LinkedBlockingQueue;

public final class a
{
  public MethodChannel.MethodCallHandler aidN;
  private LinkedBlockingQueue<b> aidO;
  private MethodChannel.MethodCallHandler aidP;
  private MethodChannel channel;
  boolean ewf;
  
  public a(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    AppMethodBeat.i(210513);
    this.ewf = true;
    this.aidO = new LinkedBlockingQueue();
    this.aidP = new MethodChannel.MethodCallHandler()
    {
      public final void onMethodCall(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(210540);
        String str = paramAnonymousMethodCall.method;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            if (a.this.aidN != null) {
              a.this.aidN.onMethodCall(paramAnonymousMethodCall, paramAnonymousResult);
            }
            break;
          }
          break;
        }
        do
        {
          AppMethodBeat.o(210540);
          return;
          if (!str.equals("onDartChannelReady")) {
            break;
          }
          i = 0;
          break;
          com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "onMethodCall onDartChannelReady", new Object[0]);
          paramAnonymousMethodCall = com.tencent.wxa.d.b.aiee;
          com.tencent.wxa.c.a.i("WxaRouter.SafeMethodChannel", "TimeRecord createFlutterEngine channel:%d", new Object[] { Long.valueOf(b.a.bHc(String.valueOf(c.keQ().keR().hashCode()))) });
        } while (a.this.ewf);
        a.this.keS();
        AppMethodBeat.o(210540);
      }
    };
    this.channel = new MethodChannel(paramBinaryMessenger, paramString);
    this.channel.setMethodCallHandler(this.aidP);
    this.channel.invokeMethod("onCheckDartChannelReady", null, new MethodChannel.Result()
    {
      public final void error(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(210534);
        com.tencent.wxa.c.a.i("WxaRouter.SafeMethodChannel", "invokeMethod error %s", new Object[] { paramAnonymousString1 });
        AppMethodBeat.o(210534);
      }
      
      public final void notImplemented()
      {
        AppMethodBeat.i(210537);
        com.tencent.wxa.c.a.i("WxaRouter.SafeMethodChannel", "invokeMethod notImplemented", new Object[0]);
        AppMethodBeat.o(210537);
      }
      
      public final void success(Object paramAnonymousObject)
      {
        AppMethodBeat.i(210526);
        if (!a.this.ewf) {
          a.this.keS();
        }
        AppMethodBeat.o(210526);
      }
    });
    AppMethodBeat.o(210513);
  }
  
  public final void invokeMethod(String paramString, Object paramObject, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(210521);
    if (this.ewf)
    {
      this.channel.invokeMethod(paramString, paramObject, paramResult);
      com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod invoke method %s", new Object[] { paramString });
      AppMethodBeat.o(210521);
      return;
    }
    this.aidO.offer(new b(paramString, paramObject, paramResult));
    com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod add invoke method %s", new Object[] { paramString });
    AppMethodBeat.o(210521);
  }
  
  public final void keS()
  {
    AppMethodBeat.i(210525);
    this.ewf = true;
    while (!this.aidO.isEmpty())
    {
      b localb = (b)this.aidO.poll();
      if (localb != null)
      {
        this.channel.invokeMethod(localb.method, localb.arguments, localb.callback);
        com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "notifyChannelReady doing invoke method %s", new Object[] { localb.method });
      }
    }
    AppMethodBeat.o(210525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.wxa.a.a
 * JD-Core Version:    0.7.0.1
 */