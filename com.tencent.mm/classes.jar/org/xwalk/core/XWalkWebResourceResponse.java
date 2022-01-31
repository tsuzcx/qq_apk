package org.xwalk.core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceResponse
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getDataMethod = new ReflectMethod(null, "getData", new Class[0]);
  private ReflectMethod getEncodingMethod = new ReflectMethod(null, "getEncoding", new Class[0]);
  private ReflectMethod getMimeTypeMethod = new ReflectMethod(null, "getMimeType", new Class[0]);
  private ReflectMethod getReasonPhraseMethod = new ReflectMethod(null, "getReasonPhrase", new Class[0]);
  private ReflectMethod getResponseHeadersMethod = new ReflectMethod(null, "getResponseHeaders", new Class[0]);
  private ReflectMethod getStatusCodeMethod = new ReflectMethod(null, "getStatusCode", new Class[0]);
  private ReflectMethod postWrapperMethod;
  private ReflectMethod setDataInputStreamMethod = new ReflectMethod(null, "setData", new Class[0]);
  private ReflectMethod setEncodingStringMethod = new ReflectMethod(null, "setEncoding", new Class[0]);
  private ReflectMethod setMimeTypeStringMethod = new ReflectMethod(null, "setMimeType", new Class[0]);
  private ReflectMethod setResponseHeadersMapMethod = new ReflectMethod(null, "setResponseHeaders", new Class[0]);
  private ReflectMethod setStatusCodeAndReasonPhraseintStringMethod = new ReflectMethod(null, "setStatusCodeAndReasonPhrase", new Class[0]);
  
  public XWalkWebResourceResponse(Object paramObject)
  {
    this.bridge = paramObject;
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public InputStream getData()
  {
    try
    {
      InputStream localInputStream = (InputStream)this.getDataMethod.invoke(new Object[0]);
      return localInputStream;
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
  
  public String getEncoding()
  {
    try
    {
      String str = (String)this.getEncodingMethod.invoke(new Object[0]);
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
  
  public String getMimeType()
  {
    try
    {
      String str = (String)this.getMimeTypeMethod.invoke(new Object[0]);
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
  
  public String getReasonPhrase()
  {
    try
    {
      String str = (String)this.getReasonPhraseMethod.invoke(new Object[0]);
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
  
  public Map<String, String> getResponseHeaders()
  {
    try
    {
      Map localMap = (Map)this.getResponseHeadersMethod.invoke(new Object[0]);
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
  
  public int getStatusCode()
  {
    try
    {
      int i = ((Integer)this.getStatusCodeMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return 0;
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
    this.setMimeTypeStringMethod.init(this.bridge, null, "setMimeTypeSuper", new Class[] { String.class });
    this.getMimeTypeMethod.init(this.bridge, null, "getMimeTypeSuper", new Class[0]);
    this.setEncodingStringMethod.init(this.bridge, null, "setEncodingSuper", new Class[] { String.class });
    this.getEncodingMethod.init(this.bridge, null, "getEncodingSuper", new Class[0]);
    this.setDataInputStreamMethod.init(this.bridge, null, "setDataSuper", new Class[] { InputStream.class });
    this.getDataMethod.init(this.bridge, null, "getDataSuper", new Class[0]);
    this.setStatusCodeAndReasonPhraseintStringMethod.init(this.bridge, null, "setStatusCodeAndReasonPhraseSuper", new Class[] { Integer.TYPE, String.class });
    this.getStatusCodeMethod.init(this.bridge, null, "getStatusCodeSuper", new Class[0]);
    this.getReasonPhraseMethod.init(this.bridge, null, "getReasonPhraseSuper", new Class[0]);
    this.setResponseHeadersMapMethod.init(this.bridge, null, "setResponseHeadersSuper", new Class[] { Map.class });
    this.getResponseHeadersMethod.init(this.bridge, null, "getResponseHeadersSuper", new Class[0]);
  }
  
  public void setData(InputStream paramInputStream)
  {
    try
    {
      this.setDataInputStreamMethod.invoke(new Object[] { paramInputStream });
      return;
    }
    catch (UnsupportedOperationException paramInputStream)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramInputStream);
    }
  }
  
  public void setEncoding(String paramString)
  {
    try
    {
      this.setEncodingStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void setMimeType(String paramString)
  {
    try
    {
      this.setMimeTypeStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void setResponseHeaders(Map<String, String> paramMap)
  {
    try
    {
      this.setResponseHeadersMapMethod.invoke(new Object[] { paramMap });
      return;
    }
    catch (UnsupportedOperationException paramMap)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramMap);
    }
  }
  
  public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
  {
    try
    {
      this.setStatusCodeAndReasonPhraseintStringMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkWebResourceResponse
 * JD-Core Version:    0.7.0.1
 */