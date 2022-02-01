package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkExtendCanvasClient
{
  private static final String TAG = "XWalkExtendCanvasClient";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod sendAsyncMethodsMethod;
  
  static
  {
    AppMethodBeat.i(154720);
    if (!XWalkExtendCanvasClient.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154720);
      return;
    }
  }
  
  public XWalkExtendCanvasClient(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(154716);
    this.sendAsyncMethodsMethod = new ReflectMethod(null, "sendAsyncMethods", new Class[0]);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
    AppMethodBeat.o(154716);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void onAsycResultCallback(int paramInt1, int paramInt2, String paramString) {}
  
  public void onCanvasTouch(String paramString1, int paramInt, String paramString2) {}
  
  public void onSendJsonMessage(String paramString) {}
  
  void reflectionInit()
  {
    AppMethodBeat.i(154719);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154719);
      return;
    }
    int j = this.constructorTypes.size();
    Object localObject1 = new Class[j + 1];
    int i = 0;
    if (i < j)
    {
      Object localObject2 = this.constructorTypes.get(i);
      if ((localObject2 instanceof String))
      {
        localObject1[i] = this.coreWrapper.getBridgeClass((String)localObject2);
        this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
      }
      label137:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label137;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(154719);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendCanvasClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.sendAsyncMethodsMethod.init(this.bridge, null, "sendAsyncMethods", new Class[] { String.class, Integer.TYPE });
      AppMethodBeat.o(154719);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(154719);
    }
  }
  
  public void sendAsyncMethods(String paramString)
  {
    AppMethodBeat.i(154717);
    sendAsyncMethods(paramString, 0);
    AppMethodBeat.o(154717);
  }
  
  public void sendAsyncMethods(String paramString, int paramInt)
  {
    AppMethodBeat.i(154718);
    Log.d("XWalkExtendCanvasClient", "sendAsyncMethods called! methods:" + paramString + ",reply_id:" + paramInt);
    try
    {
      this.sendAsyncMethodsMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(154718);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154718);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154718);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendCanvasClient
 * JD-Core Version:    0.7.0.1
 */