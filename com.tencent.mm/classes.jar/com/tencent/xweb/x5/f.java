package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.c.g;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.Log;

public final class f
  implements g
{
  private Context mContext;
  private X5JsCore xkq;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    Log.i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
  }
  
  public final void a(d paramd) {}
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.xkq.addJavascriptInterface(paramObject, paramString);
  }
  
  public final boolean cSJ()
  {
    return X5JsCore.canX5JsCoreUseNativeBuffer(this.mContext);
  }
  
  public final boolean cSj()
  {
    return (X5JsCore.canUseX5JsCore(this.mContext)) && (QbSdk.getTbsVersion(this.mContext) >= 43600);
  }
  
  public final void cleanup()
  {
    this.xkq.destroy();
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.xkq.evaluateJavascript(paramString, new a.d(paramValueCallback));
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    this.xkq.evaluateJavascript(paramString, new a.d(paramValueCallback));
  }
  
  public final ByteBuffer getNativeBuffer(int paramInt)
  {
    return this.xkq.getNativeBuffer(paramInt);
  }
  
  public final int getNativeBufferId()
  {
    return this.xkq.getNativeBufferId();
  }
  
  public final void init(int paramInt)
  {
    this.xkq = new X5JsCore(this.mContext);
  }
  
  public final void pause()
  {
    this.xkq.pause();
  }
  
  public final void resume()
  {
    this.xkq.resume();
  }
  
  public final void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.xkq.setNativeBuffer(paramInt, paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.f
 * JD-Core Version:    0.7.0.1
 */