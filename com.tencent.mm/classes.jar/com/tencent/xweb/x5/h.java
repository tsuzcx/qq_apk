package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.xweb.c.g;
import org.xwalk.core.Log;

public final class h
  implements g
{
  private JsContext BId;
  private h.a BIe;
  private Context mContext;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(84842);
    this.mContext = paramContext;
    Log.i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
    AppMethodBeat.o(84842);
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(84843);
    this.BId = new JsContext(this.mContext);
    this.BIe = new h.a();
    this.BId.addJavascriptInterface(this.BIe, "nativeBufferCompat");
    this.BId.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new h.1(this)));
    this.BId.setExceptionHandler(new h.2(this));
    AppMethodBeat.o(84843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.h
 * JD-Core Version:    0.7.0.1
 */