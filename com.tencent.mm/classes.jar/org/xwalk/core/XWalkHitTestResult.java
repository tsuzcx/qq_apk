package org.xwalk.core;

import java.util.ArrayList;

public class XWalkHitTestResult
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod enumtypeClassValueOfMethod = new ReflectMethod();
  private ReflectMethod getExtraMethod = new ReflectMethod(null, "getExtra", new Class[0]);
  private ReflectMethod getTypeMethod = new ReflectMethod(null, "getType", new Class[0]);
  private ReflectMethod postWrapperMethod;
  
  public XWalkHitTestResult(Object paramObject)
  {
    this.bridge = paramObject;
    reflectionInit();
  }
  
  private Object Converttype(XWalkHitTestResult.type paramtype)
  {
    return this.enumtypeClassValueOfMethod.invoke(new Object[] { paramtype.toString() });
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getExtra()
  {
    try
    {
      String str = (String)this.getExtraMethod.invoke(new Object[0]);
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
  
  public XWalkHitTestResult.type getType()
  {
    try
    {
      XWalkHitTestResult.type localtype = XWalkHitTestResult.type.valueOf(this.getTypeMethod.invoke(new Object[0]).toString());
      return localtype;
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
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      return;
    }
    this.enumtypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkHitTestResultInternal$type"), "valueOf", new Class[] { String.class });
    this.getTypeMethod.init(this.bridge, null, "getTypeSuper", new Class[0]);
    this.getExtraMethod.init(this.bridge, null, "getExtraSuper", new Class[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.XWalkHitTestResult
 * JD-Core Version:    0.7.0.1
 */