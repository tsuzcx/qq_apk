package com.tencent.mm.z.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.d.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  private volatile boolean ajS;
  public e.a eGA;
  public c eGw;
  public f eGx;
  public com.tencent.mm.z.b.d eGy;
  private volatile boolean eGz;
  public String equ;
  
  public final v.b Qx()
  {
    return this.eGw.eGo.eGu;
  }
  
  public final boolean V(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115310);
    f localf = this.eGx;
    Object localObject = localf.eGB.mi(paramString1);
    if (localObject == null)
    {
      ab.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      AppMethodBeat.o(115310);
      return false;
    }
    if (!localf.eGp.jy(((com.tencent.mm.z.b.e)localObject).getIndex()))
    {
      ab.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramString1 });
      AppMethodBeat.o(115310);
      return false;
    }
    localObject = paramString2;
    if (bo.isNullOrNil(paramString2)) {
      localObject = "{}";
    }
    ab.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.eGy.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", f.Qy() }), null);
    AppMethodBeat.o(115310);
    return true;
  }
  
  public final void a(com.tencent.mm.z.b.c paramc)
  {
    AppMethodBeat.i(142699);
    if (this.eGz)
    {
      AppMethodBeat.o(142699);
      return;
    }
    ab.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.equ });
    this.eGz = true;
    if (this.eGy.Qw()) {
      this.eGy.pause();
    }
    for (;;)
    {
      if (this.eGA != null) {
        this.eGA.I(this.equ, 3);
      }
      AppMethodBeat.o(142699);
      return;
      a(paramc, null);
    }
  }
  
  public final void a(com.tencent.mm.z.b.d paramd)
  {
    AppMethodBeat.i(115316);
    if (this.eGy != null)
    {
      ab.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      AppMethodBeat.o(115316);
      return;
    }
    this.eGy = paramd;
    AppMethodBeat.o(115316);
  }
  
  public final boolean a(com.tencent.mm.z.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(115311);
    f localf = this.eGx;
    if (paramc == null)
    {
      ab.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
      AppMethodBeat.o(115311);
      return false;
    }
    Object localObject = localf.eGB.mi(paramc.name);
    if (localObject == null)
    {
      ab.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      AppMethodBeat.o(115311);
      return false;
    }
    if (!localf.eGp.jy(((com.tencent.mm.z.b.e)localObject).getIndex()))
    {
      ab.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      AppMethodBeat.o(115311);
      return false;
    }
    localObject = paramc.toJSONObject().toString();
    ab.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.eGy.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.Qy() }), paramValueCallback);
    AppMethodBeat.o(115311);
    return true;
  }
  
  public final void b(com.tencent.mm.z.b.c paramc)
  {
    AppMethodBeat.i(142700);
    if (!this.eGz)
    {
      AppMethodBeat.o(142700);
      return;
    }
    ab.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.equ });
    if (this.eGy.Qw()) {
      this.eGy.resume();
    }
    for (;;)
    {
      this.eGz = false;
      if (this.eGA != null) {
        this.eGA.I(this.equ, 2);
      }
      AppMethodBeat.o(142700);
      return;
      a(paramc, null);
    }
  }
  
  @JavascriptInterface
  public final String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(115309);
    if (!this.ajS)
    {
      paramString1 = this.eGw.eGr.U(paramString1, "fail:JsApi core not started");
      AppMethodBeat.o(115309);
      return paramString1;
    }
    paramString1 = this.eGw.f(paramString1, paramString2, paramInt);
    AppMethodBeat.o(115309);
    return paramString1;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(115315);
    if (this.ajS)
    {
      AppMethodBeat.o(115315);
      return;
    }
    ab.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.equ });
    this.ajS = true;
    if (this.eGA != null) {
      this.eGA.I(this.equ, 1);
    }
    Iterator localIterator = this.eGw.eGq.eGv.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(115315);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(115312);
    ab.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { this.equ });
    this.ajS = false;
    this.eGy.destroy();
    c localc = this.eGw;
    localc.eGr.quit();
    localc.eGo.eGu.recycle();
    if (this.eGA != null)
    {
      this.eGA.I(this.equ, 4);
      this.eGA = null;
    }
    AppMethodBeat.o(115312);
  }
  
  @JavascriptInterface
  public final void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    AppMethodBeat.i(115308);
    if (paramString2 == null) {}
    for (;;)
    {
      ab.d("MicroMsg.MiniJsBridge", "publishHandler, event: %s, data size: %d", new Object[] { paramString1, Integer.valueOf(i) });
      AppMethodBeat.o(115308);
      return;
      i = paramString2.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.z.c.e
 * JD-Core Version:    0.7.0.1
 */