package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.xweb.c.g;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;

public final class b
  implements g
{
  XWAppBrandEngine xlG;
  HandlerThread xlH = new HandlerThread("v8_worker");
  private Handler xlI;
  boolean xlJ = false;
  
  public b()
  {
    this.xlH.start();
    this.xlI = new Handler(this.xlH.getLooper());
  }
  
  public final void a(d paramd) {}
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.xlI.post(new b.5(this, paramObject, paramString));
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
    this.xlI.post(new b.3(this));
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.xlI.post(new b.4(this, paramString, paramValueCallback));
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    evaluateJavascript(paramString, paramValueCallback);
  }
  
  public final ByteBuffer getNativeBuffer(int paramInt)
  {
    Object localObject = this.xlG;
    ByteBuffer localByteBuffer = ((XWAppBrandEngine)localObject).getNativeBuffer(((XWAppBrandEngine)localObject).mInstance, paramInt);
    localObject = localByteBuffer;
    if (localByteBuffer == null) {
      localObject = ByteBuffer.allocate(0);
    }
    return localObject;
  }
  
  public final int getNativeBufferId()
  {
    if (this.xlG == null) {
      return 0;
    }
    XWAppBrandEngine localXWAppBrandEngine = this.xlG;
    return localXWAppBrandEngine.getNativeBufferId(localXWAppBrandEngine.mInstance);
  }
  
  public final void init(int paramInt)
  {
    this.xlI.post(new b.1(this));
  }
  
  public final void pause()
  {
    if (this.xlJ) {
      return;
    }
    this.xlJ = true;
    this.xlI.post(new b.2(this));
  }
  
  public final void resume()
  {
    this.xlJ = false;
  }
  
  public final void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    XWAppBrandEngine localXWAppBrandEngine = this.xlG;
    if (paramByteBuffer != null)
    {
      ByteBuffer localByteBuffer = paramByteBuffer;
      if (!paramByteBuffer.isDirect())
      {
        localByteBuffer = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
        paramByteBuffer.rewind();
        localByteBuffer.put(paramByteBuffer);
      }
      localXWAppBrandEngine.setNativeBuffer(localXWAppBrandEngine.mInstance, paramInt, localByteBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b
 * JD-Core Version:    0.7.0.1
 */