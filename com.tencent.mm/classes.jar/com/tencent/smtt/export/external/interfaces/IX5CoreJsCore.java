package com.tencent.smtt.export.external.interfaces;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public abstract interface IX5CoreJsCore
{
  public abstract void addJavascriptInterface(Object paramObject1, String paramString, Object paramObject2);
  
  public abstract boolean canUseX5JsCore(Context paramContext);
  
  public abstract boolean canUseX5JsCoreNewAPI(Context paramContext);
  
  public abstract boolean canX5JsCoreUseBuffer(Context paramContext);
  
  public abstract Object createX5JavaBridge(Context paramContext);
  
  public abstract IX5JsVirtualMachine createX5JsVirtualMachine(Context paramContext, Looper paramLooper);
  
  public abstract Object currentContextData();
  
  public abstract void destroyX5JsCore(Object paramObject);
  
  public abstract void evaluateJavaScript(String paramString, ValueCallback<String> paramValueCallback, Object paramObject);
  
  public abstract ByteBuffer getNativeBuffer(Object paramObject, int paramInt);
  
  public abstract int getNativeBufferId(Object paramObject);
  
  public abstract void pause(Object paramObject);
  
  public abstract void pauseTimers(Object paramObject);
  
  public abstract void removeJavascriptInterface(String paramString, Object paramObject);
  
  public abstract void resume(Object paramObject);
  
  public abstract void resumeTimers(Object paramObject);
  
  public abstract void setJsValueFactory(Object paramObject);
  
  public abstract void setNativeBuffer(Object paramObject, int paramInt, ByteBuffer paramByteBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
 * JD-Core Version:    0.7.0.1
 */