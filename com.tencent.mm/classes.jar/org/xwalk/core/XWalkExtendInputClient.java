package org.xwalk.core;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkExtendInputClient
{
  private static final String TAG = "XWalkExtendInputClient";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private XWalkView mXWalkView;
  private ReflectMethod onKeyboardHeightChangedbooleanintbooleanMethod;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    AppMethodBeat.i(187588);
    if (!XWalkExtendInputClient.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(187588);
      return;
    }
  }
  
  public XWalkExtendInputClient(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(187578);
    this.onKeyboardHeightChangedbooleanintbooleanMethod = new ReflectMethod(null, "onKeyboardHeightChanged", new Class[0]);
    this.mXWalkView = paramXWalkView;
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
    AppMethodBeat.o(187578);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(187586);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(187586);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
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
      label133:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label133;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(187586);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendInputClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.onKeyboardHeightChangedbooleanintbooleanMethod.init(this.bridge, null, "onKeyboardHeightChanged", new Class[] { Boolean.TYPE, Integer.TYPE, Boolean.TYPE });
      AppMethodBeat.o(187586);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Log.e("XWalkExtendInputClient", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
      AppMethodBeat.o(187586);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public int getToolBarHeight(int paramInt)
  {
    return 0;
  }
  
  public boolean onHideKeyboard(String paramString, InputConnection paramInputConnection)
  {
    return false;
  }
  
  public void onKeyboardHeightChanged(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(187599);
    try
    {
      Log.i("XWalkExtendInputClient", "onKeyboardHeightChanged isKeyboardShowing:" + paramBoolean1 + ",keyboardHeight:" + paramInt + ",usingDefaultKeyboard:" + paramBoolean2);
      this.onKeyboardHeightChangedbooleanintbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(187599);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(187599);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(187599);
    }
  }
  
  public boolean onShowKeyboard(String paramString, InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    return false;
  }
  
  public boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    return false;
  }
  
  public boolean performEditorAction(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendInputClient
 * JD-Core Version:    0.7.0.1
 */