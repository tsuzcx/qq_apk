package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.n;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public final class h
  implements IJsRuntime
{
  private JsContext aagu;
  private a aagv;
  private n aagw;
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
    this.aagu = new JsContext(this.mContext);
    this.aagv = new a();
    this.aagu.addJavascriptInterface(this.aagv, "nativeBufferCompat");
    this.aagu.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new ValueCallback() {}));
    this.aagu.setExceptionHandler(new JsContext.ExceptionHandler()
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
  
  public static final class a
  {
    private static final AtomicInteger Nu;
    private HashMap<Integer, byte[]> aagy;
    
    static
    {
      AppMethodBeat.i(153865);
      Nu = new AtomicInteger(1);
      AppMethodBeat.o(153865);
    }
    
    public a()
    {
      AppMethodBeat.i(153861);
      this.aagy = new HashMap();
      AppMethodBeat.o(153861);
    }
    
    @JavascriptInterface
    public final byte[] getNativeBuffer(int paramInt)
    {
      AppMethodBeat.i(153864);
      byte[] arrayOfByte = (byte[])this.aagy.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(153864);
      return arrayOfByte;
    }
    
    @JavascriptInterface
    public final int getNativeBufferId()
    {
      AppMethodBeat.i(153862);
      int k;
      int i;
      do
      {
        k = Nu.get();
        int j = k + 1;
        i = j;
        if (j > 16777215) {
          i = 1;
        }
      } while (!Nu.compareAndSet(k, i));
      AppMethodBeat.o(153862);
      return k;
    }
    
    @JavascriptInterface
    public final void setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(153863);
      this.aagy.put(Integer.valueOf(paramInt), paramArrayOfByte);
      AppMethodBeat.o(153863);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.h
 * JD-Core Version:    0.7.0.1
 */