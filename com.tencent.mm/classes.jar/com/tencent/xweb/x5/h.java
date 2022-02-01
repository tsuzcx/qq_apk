package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.n;
import org.xwalk.core.Log;

public final class h
  implements IJsRuntime
{
  private JsContext MSd;
  private h.a MSe;
  private n MSf;
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
    this.MSd = new JsContext(this.mContext);
    this.MSe = new h.a();
    this.MSd.addJavascriptInterface(this.MSe, "nativeBufferCompat");
    this.MSd.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new ValueCallback() {}));
    this.MSd.setExceptionHandler(new JsContext.ExceptionHandler()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.h
 * JD-Core Version:    0.7.0.1
 */