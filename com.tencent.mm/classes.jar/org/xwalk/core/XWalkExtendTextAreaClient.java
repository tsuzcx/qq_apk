package org.xwalk.core;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.pinus.sdk.WebView;
import java.util.ArrayList;
import org.xwalk.core.compatible.PinusAdaptClient;

public class XWalkExtendTextAreaClient
  extends PinusAdaptClient
{
  private static final String TAG = "XWalkExtendTextAreaClient";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod onKeyboardHeightChangedbooleanintbooleanMethod;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    AppMethodBeat.i(154728);
    if (!XWalkExtendTextAreaClient.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154728);
      return;
    }
  }
  
  public XWalkExtendTextAreaClient(XWebExtendInterface paramXWebExtendInterface)
  {
    AppMethodBeat.i(187575);
    this.onKeyboardHeightChangedbooleanintbooleanMethod = new ReflectMethod(null, "onKeyboardHeightChanged", new Class[0]);
    super.init(paramXWebExtendInterface);
    AppMethodBeat.o(187575);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(154727);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(154727);
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
      AppMethodBeat.o(154727);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendTextAreaClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.onKeyboardHeightChangedbooleanintbooleanMethod.init(this.bridge, null, "onKeyboardHeightChanged", new Class[] { Boolean.TYPE, Integer.TYPE, Boolean.TYPE });
      AppMethodBeat.o(154727);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Log.e("XWalkExtendTextAreaClient", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
      AppMethodBeat.o(154727);
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(187598);
    if (this.xwebType == 0)
    {
      this.xwalkView.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(187598);
      return;
    }
    if (this.xwebType == 1) {
      this.psWebview.evaluateJavascript(paramString, paramValueCallback);
    }
    AppMethodBeat.o(187598);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public int getToolBarHeight(int paramInt)
  {
    return 0;
  }
  
  public void initPSWebView(WebView paramWebView)
  {
    AppMethodBeat.i(187593);
    super.initPSWebView(paramWebView);
    AppMethodBeat.o(187593);
  }
  
  public void initXWalkView(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(187591);
    super.initXWalkView(paramXWalkView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
    AppMethodBeat.o(187591);
  }
  
  public boolean onHideKeyboard(String paramString, InputConnection paramInputConnection)
  {
    return false;
  }
  
  public void onKeyboardHeightChanged(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(154726);
    if (this.xwebType == 0) {
      try
      {
        Log.i("XWalkExtendTextAreaClient", "onKeyboardHeightChanged, isKeyboardShowing:" + paramBoolean1 + ",keyboardHeight:" + paramInt + ",usingDefaultKeyboard:" + paramBoolean2);
        this.onKeyboardHeightChangedbooleanintbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
        AppMethodBeat.o(154726);
        return;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        RuntimeException localRuntimeException;
        if (this.coreWrapper == null)
        {
          localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
          AppMethodBeat.o(154726);
          throw localRuntimeException;
        }
        XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
        AppMethodBeat.o(154726);
        return;
      }
    }
    if (this.xwebType == 1) {
      this.psWebview.onExtendTextAreaKeyboardHeightChanged(paramBoolean1, paramInt, paramBoolean2);
    }
    AppMethodBeat.o(154726);
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
 * Qualified Name:     org.xwalk.core.XWalkExtendTextAreaClient
 * JD-Core Version:    0.7.0.1
 */