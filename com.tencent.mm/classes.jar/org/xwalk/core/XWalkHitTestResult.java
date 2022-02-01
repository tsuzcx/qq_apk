package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkHitTestResult
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod enumtypeClassValueOfMethod;
  private ReflectMethod getExtraMethod;
  private ReflectMethod getTypeMethod;
  private ReflectMethod postWrapperMethod;
  
  public XWalkHitTestResult(Object paramObject)
  {
    AppMethodBeat.i(154741);
    this.enumtypeClassValueOfMethod = new ReflectMethod();
    this.getTypeMethod = new ReflectMethod(null, "getType", new Class[0]);
    this.getExtraMethod = new ReflectMethod(null, "getExtra", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154741);
  }
  
  private Object Converttype(type paramtype)
  {
    AppMethodBeat.i(154740);
    paramtype = this.enumtypeClassValueOfMethod.invoke(new Object[] { paramtype.toString() });
    AppMethodBeat.o(154740);
    return paramtype;
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getExtra()
  {
    AppMethodBeat.i(154743);
    try
    {
      String str = (String)this.getExtraMethod.invoke(new Object[0]);
      AppMethodBeat.o(154743);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154743);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154743);
    }
    return null;
  }
  
  public type getType()
  {
    AppMethodBeat.i(154742);
    try
    {
      type localtype = type.valueOf(this.getTypeMethod.invoke(new Object[0]).toString());
      AppMethodBeat.o(154742);
      return localtype;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154742);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154742);
    }
    return null;
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154744);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154744);
      return;
    }
    this.enumtypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkHitTestResultInternal$type"), "valueOf", new Class[] { String.class });
    this.getTypeMethod.init(this.bridge, null, "getTypeSuper", new Class[0]);
    this.getExtraMethod.init(this.bridge, null, "getExtraSuper", new Class[0]);
    AppMethodBeat.o(154744);
  }
  
  public static enum type
  {
    static
    {
      AppMethodBeat.i(154739);
      UNKNOWN_TYPE = new type("UNKNOWN_TYPE", 0);
      ANCHOR_TYPE = new type("ANCHOR_TYPE", 1);
      PHONE_TYPE = new type("PHONE_TYPE", 2);
      GEO_TYPE = new type("GEO_TYPE", 3);
      EMAIL_TYPE = new type("EMAIL_TYPE", 4);
      IMAGE_TYPE = new type("IMAGE_TYPE", 5);
      IMAGE_ANCHOR_TYPE = new type("IMAGE_ANCHOR_TYPE", 6);
      SRC_ANCHOR_TYPE = new type("SRC_ANCHOR_TYPE", 7);
      SRC_IMAGE_ANCHOR_TYPE = new type("SRC_IMAGE_ANCHOR_TYPE", 8);
      EDIT_TEXT_TYPE = new type("EDIT_TEXT_TYPE", 9);
      $VALUES = new type[] { UNKNOWN_TYPE, ANCHOR_TYPE, PHONE_TYPE, GEO_TYPE, EMAIL_TYPE, IMAGE_TYPE, IMAGE_ANCHOR_TYPE, SRC_ANCHOR_TYPE, SRC_IMAGE_ANCHOR_TYPE, EDIT_TEXT_TYPE };
      AppMethodBeat.o(154739);
    }
    
    private type() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkHitTestResult
 * JD-Core Version:    0.7.0.1
 */