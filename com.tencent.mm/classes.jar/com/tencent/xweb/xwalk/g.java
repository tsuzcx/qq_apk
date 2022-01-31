package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.XWalkV8;

public final class g
  implements com.tencent.xweb.c.g
{
  HandlerThread xlH = new HandlerThread("j2v8");
  private Handler xlI;
  XWalkV8 xlX;
  
  public g()
  {
    this.xlH.start();
    this.xlI = new Handler(this.xlH.getLooper());
  }
  
  public final void a(d paramd) {}
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.xlI.post(new g.4(this, paramObject, paramString));
  }
  
  public final boolean cSJ()
  {
    return false;
  }
  
  public final boolean cSj()
  {
    return false;
  }
  
  public final void cleanup()
  {
    this.xlI.post(new g.2(this));
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.xlI.post(new g.3(this, paramString, paramValueCallback));
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    evaluateJavascript(paramString, paramValueCallback);
  }
  
  public final ByteBuffer getNativeBuffer(int paramInt)
  {
    return null;
  }
  
  public final int getNativeBufferId()
  {
    return 0;
  }
  
  public final void init(int paramInt)
  {
    this.xlI.post(new g.1(this, paramInt));
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g
 * JD-Core Version:    0.7.0.1
 */