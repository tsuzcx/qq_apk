package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.m;
import org.xwalk.core.Log;

public final class h
  implements IJsRuntime
{
  private JsContext ISc;
  private h.a ISd;
  private m ISe;
  private Context mContext;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(153866);
    this.mContext = paramContext;
    Log.i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
    AppMethodBeat.o(153866);
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(153867);
    this.ISc = new JsContext(this.mContext);
    this.ISd = new h.a();
    this.ISc.addJavascriptInterface(this.ISd, "nativeBufferCompat");
    this.ISc.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new ValueCallback() {}));
    this.ISc.setExceptionHandler(new JsContext.ExceptionHandler()
    {
      public final void handleException(JsContext paramAnonymousJsContext, JsError paramAnonymousJsError)
      {
        AppMethodBeat.i(153860);
        if (paramAnonymousJsError == null)
        {
          Log.i("MicroMsg.X5V8JsRuntime", "jsError is null.");
          AppMethodBeat.o(153860);
          return;
        }
        Log.e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", new Object[] { paramAnonymousJsError.getMessage() }));
        if (h.a(h.this) != null) {
          h.a(h.this);
        }
        AppMethodBeat.o(153860);
      }
    });
    AppMethodBeat.o(153867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.h
 * JD-Core Version:    0.7.0.1
 */