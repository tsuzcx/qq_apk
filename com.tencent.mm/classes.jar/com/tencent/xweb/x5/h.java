package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.xweb.c.g;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public final class h
  implements g
{
  private Context mContext;
  d xkA;
  private JsContext xky;
  private a xkz;
  
  public h(Context paramContext)
  {
    this.mContext = paramContext;
    Log.i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
  }
  
  public final void a(d paramd)
  {
    this.xkA = paramd;
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.xky.addJavascriptInterface(paramObject, paramString);
  }
  
  public final boolean cSJ()
  {
    return true;
  }
  
  public final boolean cSj()
  {
    return true;
  }
  
  public final void cleanup()
  {
    this.xky.destroy();
    this.xkz.bzz.clear();
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.xky.evaluateJavascript(paramString, new a.d(paramValueCallback));
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    Log.i("MicroMsg.X5V8JsRuntime", String.format("evaluateJavascriptWithURL(%s)", new Object[] { paramURL }));
    this.xky.evaluateJavascript(paramString, new a.d(paramValueCallback), paramURL);
  }
  
  public final ByteBuffer getNativeBuffer(int paramInt)
  {
    byte[] arrayOfByte = this.xkz.getNativeBuffer(paramInt);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      return ByteBuffer.wrap(arrayOfByte);
    }
    return null;
  }
  
  public final int getNativeBufferId()
  {
    return this.xkz.getNativeBufferId();
  }
  
  public final void init(int paramInt)
  {
    this.xky = new JsContext(this.mContext);
    this.xkz = new a();
    this.xky.addJavascriptInterface(this.xkz, "nativeBufferCompat");
    this.xky.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new h.1(this)));
    this.xky.setExceptionHandler(new h.2(this));
  }
  
  public final void pause()
  {
    this.xky.virtualMachine().onPause();
  }
  
  public final void resume()
  {
    this.xky.virtualMachine().onResume();
  }
  
  public final void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    a locala = this.xkz;
    if (paramByteBuffer == null) {
      paramByteBuffer = new byte[0];
    }
    for (;;)
    {
      locala.setNativeBuffer(paramInt, paramByteBuffer);
      return;
      if (!paramByteBuffer.isDirect())
      {
        paramByteBuffer = paramByteBuffer.array();
      }
      else
      {
        int i = paramByteBuffer.position();
        paramByteBuffer.position(0);
        byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(arrayOfByte);
        paramByteBuffer.position(i);
        paramByteBuffer = arrayOfByte;
      }
    }
  }
  
  public static final class a
  {
    private static final AtomicInteger Gl = new AtomicInteger(1);
    HashMap<Integer, byte[]> bzz = new HashMap();
    
    @JavascriptInterface
    public final byte[] getNativeBuffer(int paramInt)
    {
      return (byte[])this.bzz.remove(Integer.valueOf(paramInt));
    }
    
    @JavascriptInterface
    public final int getNativeBufferId()
    {
      int k;
      int i;
      do
      {
        k = Gl.get();
        int j = k + 1;
        i = j;
        if (j > 16777215) {
          i = 1;
        }
      } while (!Gl.compareAndSet(k, i));
      return k;
    }
    
    @JavascriptInterface
    public final void setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
    {
      this.bzz.put(Integer.valueOf(paramInt), paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.h
 * JD-Core Version:    0.7.0.1
 */