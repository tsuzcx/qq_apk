package com.tencent.xweb.c;

import android.webkit.ValueCallback;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;

public abstract interface g
{
  public abstract void a(d paramd);
  
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract boolean cSJ();
  
  public abstract boolean cSj();
  
  public abstract void cleanup();
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL);
  
  public abstract ByteBuffer getNativeBuffer(int paramInt);
  
  public abstract int getNativeBufferId();
  
  public abstract void init(int paramInt);
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.c.g
 * JD-Core Version:    0.7.0.1
 */