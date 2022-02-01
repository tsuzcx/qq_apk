package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

public class XWalkWebResourceResponse
{
  public static final String TAG = "XWalkWebResourceResponse";
  private Object bridge;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getDataMethod;
  private ReflectMethod getEncodingMethod;
  private ReflectMethod getMimeTypeMethod;
  private ReflectMethod getReasonPhraseMethod;
  private ReflectMethod getResponseHeadersMethod;
  private ReflectMethod getStatusCodeMethod;
  private ReflectMethod setDataInputStreamMethod;
  private ReflectMethod setEncodingStringMethod;
  private ReflectMethod setMimeTypeStringMethod;
  private ReflectMethod setResponseHeadersMapMethod;
  private ReflectMethod setStatusCodeAndReasonPhraseintStringMethod;
  
  public XWalkWebResourceResponse(Object paramObject)
  {
    AppMethodBeat.i(155170);
    this.setMimeTypeStringMethod = new ReflectMethod(null, "setMimeType", new Class[0]);
    this.getMimeTypeMethod = new ReflectMethod(null, "getMimeType", new Class[0]);
    this.setEncodingStringMethod = new ReflectMethod(null, "setEncoding", new Class[0]);
    this.getEncodingMethod = new ReflectMethod(null, "getEncoding", new Class[0]);
    this.setDataInputStreamMethod = new ReflectMethod(null, "setData", new Class[0]);
    this.getDataMethod = new ReflectMethod(null, "getData", new Class[0]);
    this.setStatusCodeAndReasonPhraseintStringMethod = new ReflectMethod(null, "setStatusCodeAndReasonPhrase", new Class[0]);
    this.getStatusCodeMethod = new ReflectMethod(null, "getStatusCode", new Class[0]);
    this.getReasonPhraseMethod = new ReflectMethod(null, "getReasonPhrase", new Class[0]);
    this.setResponseHeadersMapMethod = new ReflectMethod(null, "setResponseHeaders", new Class[0]);
    this.getResponseHeadersMethod = new ReflectMethod(null, "getResponseHeaders", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(155170);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(155182);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(155182);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
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
    AppMethodBeat.o(155182);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public InputStream getData()
  {
    AppMethodBeat.i(155176);
    try
    {
      InputStream localInputStream = (InputStream)this.getDataMethod.invoke(new Object[0]);
      AppMethodBeat.o(155176);
      return localInputStream;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155176);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155176);
    }
    return null;
  }
  
  public String getEncoding()
  {
    AppMethodBeat.i(155174);
    try
    {
      String str = (String)this.getEncodingMethod.invoke(new Object[0]);
      AppMethodBeat.o(155174);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155174);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155174);
    }
    return null;
  }
  
  public String getMimeType()
  {
    AppMethodBeat.i(155172);
    try
    {
      String str = (String)this.getMimeTypeMethod.invoke(new Object[0]);
      AppMethodBeat.o(155172);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155172);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155172);
    }
    return null;
  }
  
  public String getReasonPhrase()
  {
    AppMethodBeat.i(155179);
    try
    {
      String str = (String)this.getReasonPhraseMethod.invoke(new Object[0]);
      AppMethodBeat.o(155179);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155179);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155179);
    }
    return null;
  }
  
  public Map<String, String> getResponseHeaders()
  {
    AppMethodBeat.i(155181);
    try
    {
      Map localMap = (Map)this.getResponseHeadersMethod.invoke(new Object[0]);
      AppMethodBeat.o(155181);
      return localMap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155181);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155181);
    }
    return null;
  }
  
  public int getStatusCode()
  {
    AppMethodBeat.i(155178);
    try
    {
      int i = ((Integer)this.getStatusCodeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(155178);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155178);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155178);
    }
    return 0;
  }
  
  public void setData(InputStream paramInputStream)
  {
    AppMethodBeat.i(155175);
    try
    {
      this.setDataInputStreamMethod.invoke(new Object[] { paramInputStream });
      AppMethodBeat.o(155175);
      return;
    }
    catch (UnsupportedOperationException paramInputStream)
    {
      if (this.coreWrapper == null)
      {
        paramInputStream = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155175);
        throw paramInputStream;
      }
      XWalkCoreWrapper.handleRuntimeError(paramInputStream);
      AppMethodBeat.o(155175);
    }
  }
  
  public void setEncoding(String paramString)
  {
    AppMethodBeat.i(155173);
    try
    {
      this.setEncodingStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(155173);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155173);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155173);
    }
  }
  
  public void setMimeType(String paramString)
  {
    AppMethodBeat.i(155171);
    try
    {
      this.setMimeTypeStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(155171);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155171);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155171);
    }
  }
  
  public void setResponseHeaders(Map<String, String> paramMap)
  {
    AppMethodBeat.i(155180);
    try
    {
      this.setResponseHeadersMapMethod.invoke(new Object[] { paramMap });
      AppMethodBeat.o(155180);
      return;
    }
    catch (UnsupportedOperationException paramMap)
    {
      if (this.coreWrapper == null)
      {
        paramMap = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155180);
        throw paramMap;
      }
      XWalkCoreWrapper.handleRuntimeError(paramMap);
      AppMethodBeat.o(155180);
    }
  }
  
  public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
  {
    AppMethodBeat.i(155177);
    try
    {
      this.setStatusCodeAndReasonPhraseintStringMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(155177);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155177);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkWebResourceResponse
 * JD-Core Version:    0.7.0.1
 */