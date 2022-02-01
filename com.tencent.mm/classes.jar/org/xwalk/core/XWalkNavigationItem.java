package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkNavigationItem
{
  private static final String TAG = "XWalkNavigationItem";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getOriginalUrlMethod;
  private ReflectMethod getTitleMethod;
  private ReflectMethod getUrlMethod;
  private ReflectMethod postWrapperMethod;
  
  public XWalkNavigationItem(Object paramObject)
  {
    AppMethodBeat.i(154824);
    this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
    this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154824);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(154828);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(154828);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
    this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
    this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
    AppMethodBeat.o(154828);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getOriginalUrl()
  {
    AppMethodBeat.i(154826);
    try
    {
      String str = (String)this.getOriginalUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(154826);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154826);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154826);
    }
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(154827);
    try
    {
      String str = (String)this.getTitleMethod.invoke(new Object[0]);
      AppMethodBeat.o(154827);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154827);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154827);
    }
    return null;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(154825);
    try
    {
      String str = (String)this.getUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(154825);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154825);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154825);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkNavigationItem
 * JD-Core Version:    0.7.0.1
 */