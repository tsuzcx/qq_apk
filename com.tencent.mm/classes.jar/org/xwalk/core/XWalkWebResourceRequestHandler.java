package org.xwalk.core;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class XWalkWebResourceRequestHandler
  implements XWalkWebResourceRequest
{
  private static final String TAG = "XWalkWebResourceRequestHandler";
  private Object bridge;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getMethodMethod;
  private ReflectMethod getRequestHeadersMethod;
  private ReflectMethod getUrlMethod;
  private ReflectMethod hasGestureMethod;
  private ReflectMethod isForMainFrameMethod;
  
  public XWalkWebResourceRequestHandler(Object paramObject)
  {
    AppMethodBeat.i(155163);
    this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    this.isForMainFrameMethod = new ReflectMethod(null, "isForMainFrame", new Class[0]);
    this.hasGestureMethod = new ReflectMethod(null, "hasGesture", new Class[0]);
    this.getMethodMethod = new ReflectMethod(null, "getMethod", new Class[0]);
    this.getRequestHeadersMethod = new ReflectMethod(null, "getRequestHeaders", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(155163);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(155169);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(155169);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
    this.isForMainFrameMethod.init(this.bridge, null, "isForMainFrameSuper", new Class[0]);
    this.hasGestureMethod.init(this.bridge, null, "hasGestureSuper", new Class[0]);
    this.getMethodMethod.init(this.bridge, null, "getMethodSuper", new Class[0]);
    this.getRequestHeadersMethod.init(this.bridge, null, "getRequestHeadersSuper", new Class[0]);
    AppMethodBeat.o(155169);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getMethod()
  {
    AppMethodBeat.i(155167);
    try
    {
      String str = (String)this.getMethodMethod.invoke(new Object[0]);
      AppMethodBeat.o(155167);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155167);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155167);
    }
    return null;
  }
  
  public Map<String, String> getRequestHeaders()
  {
    AppMethodBeat.i(155168);
    try
    {
      Map localMap = (Map)this.getRequestHeadersMethod.invoke(new Object[0]);
      AppMethodBeat.o(155168);
      return localMap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155168);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155168);
    }
    return null;
  }
  
  public Uri getUrl()
  {
    AppMethodBeat.i(155164);
    try
    {
      Uri localUri = (Uri)this.getUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(155164);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155164);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155164);
    }
    return null;
  }
  
  public boolean hasGesture()
  {
    AppMethodBeat.i(155166);
    try
    {
      boolean bool = ((Boolean)this.hasGestureMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(155166);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155166);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155166);
    }
    return false;
  }
  
  public boolean isForMainFrame()
  {
    AppMethodBeat.i(155165);
    try
    {
      boolean bool = ((Boolean)this.isForMainFrameMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(155165);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155165);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155165);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkWebResourceRequestHandler
 * JD-Core Version:    0.7.0.1
 */