package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkNavigationHistory
{
  private Object bridge;
  private ReflectMethod canGoBackMethod;
  private ReflectMethod canGoForwardMethod;
  private ReflectMethod clearMethod;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod enumDirectionClassValueOfMethod;
  private ReflectMethod getCurrentIndexMethod;
  private ReflectMethod getCurrentItemMethod;
  private ReflectMethod getItemAtintMethod;
  private ReflectMethod hasItemAtintMethod;
  private ReflectMethod navigateDirectionInternalintMethod;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod sizeMethod;
  
  public XWalkNavigationHistory(Object paramObject)
  {
    AppMethodBeat.i(154813);
    this.enumDirectionClassValueOfMethod = new ReflectMethod();
    this.sizeMethod = new ReflectMethod(null, "size", new Class[0]);
    this.hasItemAtintMethod = new ReflectMethod(null, "hasItemAt", new Class[0]);
    this.getItemAtintMethod = new ReflectMethod(null, "getItemAt", new Class[0]);
    this.getCurrentItemMethod = new ReflectMethod(null, "getCurrentItem", new Class[0]);
    this.canGoBackMethod = new ReflectMethod(null, "canGoBack", new Class[0]);
    this.canGoForwardMethod = new ReflectMethod(null, "canGoForward", new Class[0]);
    this.navigateDirectionInternalintMethod = new ReflectMethod(null, "navigate", new Class[0]);
    this.getCurrentIndexMethod = new ReflectMethod(null, "getCurrentIndex", new Class[0]);
    this.clearMethod = new ReflectMethod(null, "clear", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154813);
  }
  
  private Object ConvertDirection(XWalkNavigationHistory.Direction paramDirection)
  {
    AppMethodBeat.i(154812);
    paramDirection = this.enumDirectionClassValueOfMethod.invoke(new Object[] { paramDirection.toString() });
    AppMethodBeat.o(154812);
    return paramDirection;
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(154818);
    try
    {
      boolean bool = ((Boolean)this.canGoBackMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154818);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154818);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154818);
    }
    return false;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(154819);
    try
    {
      boolean bool = ((Boolean)this.canGoForwardMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154819);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154819);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154819);
    }
    return false;
  }
  
  public void clear()
  {
    AppMethodBeat.i(154822);
    try
    {
      this.clearMethod.invoke(new Object[0]);
      AppMethodBeat.o(154822);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154822);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154822);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public int getCurrentIndex()
  {
    AppMethodBeat.i(154821);
    try
    {
      int i = ((Integer)this.getCurrentIndexMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154821);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154821);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154821);
    }
    return 0;
  }
  
  public XWalkNavigationItem getCurrentItem()
  {
    AppMethodBeat.i(154817);
    try
    {
      XWalkNavigationItem localXWalkNavigationItem = (XWalkNavigationItem)this.coreWrapper.getWrapperObject(this.getCurrentItemMethod.invoke(new Object[0]));
      AppMethodBeat.o(154817);
      return localXWalkNavigationItem;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154817);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154817);
    }
    return null;
  }
  
  public XWalkNavigationItem getItemAt(int paramInt)
  {
    AppMethodBeat.i(154816);
    try
    {
      XWalkNavigationItem localXWalkNavigationItem = (XWalkNavigationItem)this.coreWrapper.getWrapperObject(this.getItemAtintMethod.invoke(new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(154816);
      return localXWalkNavigationItem;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154816);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154816);
    }
    return null;
  }
  
  public boolean hasItemAt(int paramInt)
  {
    AppMethodBeat.i(154815);
    try
    {
      boolean bool = ((Boolean)this.hasItemAtintMethod.invoke(new Object[] { Integer.valueOf(paramInt) })).booleanValue();
      AppMethodBeat.o(154815);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154815);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154815);
    }
    return false;
  }
  
  public void navigate(XWalkNavigationHistory.Direction paramDirection, int paramInt)
  {
    AppMethodBeat.i(154820);
    try
    {
      this.navigateDirectionInternalintMethod.invoke(new Object[] { ConvertDirection(paramDirection), Integer.valueOf(paramInt) });
      AppMethodBeat.o(154820);
      return;
    }
    catch (UnsupportedOperationException paramDirection)
    {
      if (this.coreWrapper == null)
      {
        paramDirection = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154820);
        throw paramDirection;
      }
      XWalkCoreWrapper.handleRuntimeError(paramDirection);
      AppMethodBeat.o(154820);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154823);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154823);
      return;
    }
    this.enumDirectionClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkNavigationHistoryInternal$DirectionInternal"), "valueOf", new Class[] { String.class });
    this.sizeMethod.init(this.bridge, null, "sizeSuper", new Class[0]);
    this.hasItemAtintMethod.init(this.bridge, null, "hasItemAtSuper", new Class[] { Integer.TYPE });
    this.getItemAtintMethod.init(this.bridge, null, "getItemAtSuper", new Class[] { Integer.TYPE });
    this.getCurrentItemMethod.init(this.bridge, null, "getCurrentItemSuper", new Class[0]);
    this.canGoBackMethod.init(this.bridge, null, "canGoBackSuper", new Class[0]);
    this.canGoForwardMethod.init(this.bridge, null, "canGoForwardSuper", new Class[0]);
    this.navigateDirectionInternalintMethod.init(this.bridge, null, "navigateSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkNavigationHistoryInternal$DirectionInternal"), Integer.TYPE });
    this.getCurrentIndexMethod.init(this.bridge, null, "getCurrentIndexSuper", new Class[0]);
    this.clearMethod.init(this.bridge, null, "clearSuper", new Class[0]);
    AppMethodBeat.o(154823);
  }
  
  public int size()
  {
    AppMethodBeat.i(154814);
    try
    {
      int i = ((Integer)this.sizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154814);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154814);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154814);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkNavigationHistory
 * JD-Core Version:    0.7.0.1
 */