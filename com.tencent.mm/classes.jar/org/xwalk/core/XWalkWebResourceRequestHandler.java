package org.xwalk.core;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceRequestHandler
  implements XWalkWebResourceRequest
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getMethodMethod = new ReflectMethod(null, "getMethod", new Class[0]);
  private ReflectMethod getRequestHeadersMethod = new ReflectMethod(null, "getRequestHeaders", new Class[0]);
  private ReflectMethod getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
  private ReflectMethod hasGestureMethod = new ReflectMethod(null, "hasGesture", new Class[0]);
  private ReflectMethod isForMainFrameMethod = new ReflectMethod(null, "isForMainFrame", new Class[0]);
  private ReflectMethod postWrapperMethod;
  
  public XWalkWebResourceRequestHandler(Object paramObject)
  {
    this.bridge = paramObject;
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getMethod()
  {
    try
    {
      String str = (String)this.getMethodMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public Map<String, String> getRequestHeaders()
  {
    try
    {
      Map localMap = (Map)this.getRequestHeadersMethod.invoke(new Object[0]);
      return localMap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public Uri getUrl()
  {
    try
    {
      Uri localUri = (Uri)this.getUrlMethod.invoke(new Object[0]);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public boolean hasGesture()
  {
    try
    {
      boolean bool = ((Boolean)this.hasGestureMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return false;
  }
  
  public boolean isForMainFrame()
  {
    try
    {
      boolean bool = ((Boolean)this.isForMainFrameMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return false;
  }
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      return;
    }
    this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
    this.isForMainFrameMethod.init(this.bridge, null, "isForMainFrameSuper", new Class[0]);
    this.hasGestureMethod.init(this.bridge, null, "hasGestureSuper", new Class[0]);
    this.getMethodMethod.init(this.bridge, null, "getMethodSuper", new Class[0]);
    this.getRequestHeadersMethod.init(this.bridge, null, "getRequestHeadersSuper", new Class[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkWebResourceRequestHandler
 * JD-Core Version:    0.7.0.1
 */