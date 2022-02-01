package com.tencent.wxa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashSet;
import java.util.Iterator;

public class d
  implements FlutterPlugin
{
  com.tencent.wxa.a.a aidJ;
  private HashSet<b> aidK;
  private final MethodChannel.MethodCallHandler aidL;
  
  public d()
  {
    AppMethodBeat.i(210477);
    this.aidK = new HashSet();
    this.aidL = new MethodChannel.MethodCallHandler()
    {
      public final void onMethodCall(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(210516);
        HashSet localHashSet = new HashSet();
        localHashSet.addAll(d.a(d.this));
        String str = paramAnonymousMethodCall.method;
        if (!localHashSet.isEmpty())
        {
          Iterator localIterator = localHashSet.iterator();
          boolean bool = false;
          while (localIterator.hasNext())
          {
            Object localObject = (b)localIterator.next();
            if (!bool)
            {
              localObject = ((b)localObject).a(paramAnonymousMethodCall);
              bool = ((b.a)localObject).result;
              if (((b.a)localObject).result)
              {
                com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s success ", new Object[] { str });
                paramAnonymousResult.success(((b.a)localObject).aidk);
                AppMethodBeat.o(210516);
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
            paramAnonymousResult.notImplemented();
          }
          localHashSet.clear();
        }
        AppMethodBeat.o(210516);
      }
    };
    AppMethodBeat.o(210477);
  }
  
  public final void n(HashSet<b> paramHashSet)
  {
    AppMethodBeat.i(210499);
    if (!this.aidK.contains(paramHashSet))
    {
      this.aidK.addAll(paramHashSet);
      AppMethodBeat.o(210499);
      return;
    }
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "had add method call handler %s", new Object[] { Integer.valueOf(paramHashSet.hashCode()) });
    AppMethodBeat.o(210499);
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(210487);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "onAttachedToEngine", new Object[0]);
    this.aidJ = new com.tencent.wxa.a.a(paramFlutterPluginBinding.getBinaryMessenger(), "com.tencent.wxa/wxa_router");
    this.aidJ.aidN = this.aidL;
    AppMethodBeat.o(210487);
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(210494);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "onDetachedFromEngine", new Object[0]);
    if (this.aidJ != null) {
      this.aidJ.aidN = null;
    }
    AppMethodBeat.o(210494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.wxa.d
 * JD-Core Version:    0.7.0.1
 */