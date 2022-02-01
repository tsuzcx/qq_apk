package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.Display;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@TargetApi(17)
@Keep
class SingleViewPresentation
  extends Presentation
{
  private final a accessibilityEventsDelegate;
  private FrameLayout container;
  private Object createParams;
  private final View.OnFocusChangeListener focusChangeListener;
  private SingleViewPresentation.a rootView;
  private boolean startFocused;
  private e state;
  private final d viewFactory;
  private int viewId;
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, a parama, e parame, View.OnFocusChangeListener paramOnFocusChangeListener, boolean paramBoolean)
  {
    super(new c(paramContext), paramDisplay);
    AppMethodBeat.i(9919);
    this.startFocused = false;
    this.accessibilityEventsDelegate = parama;
    this.viewFactory = null;
    this.state = parame;
    this.focusChangeListener = paramOnFocusChangeListener;
    getWindow().setFlags(8, 8);
    this.startFocused = paramBoolean;
    AppMethodBeat.o(9919);
  }
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, d paramd, a parama, int paramInt, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super(new c(paramContext), paramDisplay);
    AppMethodBeat.i(9918);
    this.startFocused = false;
    this.viewFactory = paramd;
    this.accessibilityEventsDelegate = parama;
    this.viewId = paramInt;
    this.createParams = paramObject;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.state = new e();
    getWindow().setFlags(8, 8);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().setType(2030);
    }
    AppMethodBeat.o(9918);
  }
  
  public e detachState()
  {
    AppMethodBeat.i(9921);
    this.container.removeAllViews();
    this.rootView.removeAllViews();
    e locale = this.state;
    AppMethodBeat.o(9921);
    return locale;
  }
  
  public c getView()
  {
    if (this.state.MGS == null) {
      return null;
    }
    return this.state.MGS;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9920);
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (this.state.MGT == null) {
      this.state.MGT = new SingleViewPresentation.b(getContext());
    }
    if (this.state.MGR == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      this.state.MGR = new f(paramBundle, this.state.MGT);
    }
    this.container = new FrameLayout(getContext());
    new d(getContext(), this.state.MGR);
    if (this.state.MGS == null) {
      this.state.MGS = this.viewFactory.gfk();
    }
    paramBundle = this.state.MGS.getView();
    this.container.addView(paramBundle);
    this.rootView = new SingleViewPresentation.a(getContext(), this.accessibilityEventsDelegate, paramBundle);
    this.rootView.addView(this.container);
    this.rootView.addView(this.state.MGT);
    paramBundle.setOnFocusChangeListener(this.focusChangeListener);
    this.rootView.setFocusableInTouchMode(true);
    if (this.startFocused) {
      paramBundle.requestFocus();
    }
    for (;;)
    {
      setContentView(this.rootView);
      AppMethodBeat.o(9920);
      return;
      this.rootView.requestFocus();
    }
  }
  
  static final class c
    extends ContextWrapper
  {
    private final InputMethodManager EZz;
    
    c(Context paramContext)
    {
      this(paramContext, null);
    }
    
    private c(Context paramContext, InputMethodManager paramInputMethodManager)
    {
      super();
      AppMethodBeat.i(213216);
      if (paramInputMethodManager != null) {}
      for (;;)
      {
        this.EZz = paramInputMethodManager;
        AppMethodBeat.o(213216);
        return;
        paramInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      }
    }
    
    public final Context createDisplayContext(Display paramDisplay)
    {
      AppMethodBeat.i(213218);
      paramDisplay = new c(super.createDisplayContext(paramDisplay), this.EZz);
      AppMethodBeat.o(213218);
      return paramDisplay;
    }
    
    public final Object getSystemService(String paramString)
    {
      AppMethodBeat.i(213217);
      if ("input_method".equals(paramString))
      {
        paramString = this.EZz;
        AppMethodBeat.o(213217);
        return paramString;
      }
      paramString = super.getSystemService(paramString);
      AppMethodBeat.o(213217);
      return paramString;
    }
  }
  
  static final class d
    extends ContextWrapper
  {
    private final SingleViewPresentation.f MGR;
    private WindowManager windowManager;
    
    d(Context paramContext, SingleViewPresentation.f paramf)
    {
      super();
      this.MGR = paramf;
    }
    
    public final Object getSystemService(String paramString)
    {
      AppMethodBeat.i(9933);
      if ("window".equals(paramString))
      {
        if (this.windowManager == null)
        {
          paramString = this.MGR;
          this.windowManager = ((WindowManager)Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[] { WindowManager.class }, paramString));
        }
        paramString = this.windowManager;
        AppMethodBeat.o(9933);
        return paramString;
      }
      paramString = super.getSystemService(paramString);
      AppMethodBeat.o(9933);
      return paramString;
    }
  }
  
  static final class e
  {
    SingleViewPresentation.f MGR;
    c MGS;
    SingleViewPresentation.b MGT;
  }
  
  static final class f
    implements InvocationHandler
  {
    private final WindowManager MGU;
    SingleViewPresentation.b MGV;
    
    f(WindowManager paramWindowManager, SingleViewPresentation.b paramb)
    {
      this.MGU = paramWindowManager;
      this.MGV = paramb;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(9922);
      paramObject = paramMethod.getName();
      int i = -1;
      switch (paramObject.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        }
        try
        {
          paramObject = paramMethod.invoke(this.MGU, paramArrayOfObject);
          AppMethodBeat.o(9922);
          return paramObject;
        }
        catch (InvocationTargetException paramObject)
        {
          paramObject = paramObject.getCause();
          AppMethodBeat.o(9922);
          throw paramObject;
        }
        if (paramObject.equals("addView"))
        {
          i = 0;
          continue;
          if (paramObject.equals("removeView"))
          {
            i = 1;
            continue;
            if (paramObject.equals("removeViewImmediate"))
            {
              i = 2;
              continue;
              if (paramObject.equals("updateViewLayout")) {
                i = 3;
              }
            }
          }
        }
      }
      if (this.MGV != null)
      {
        paramObject = (View)paramArrayOfObject[0];
        paramMethod = (WindowManager.LayoutParams)paramArrayOfObject[1];
        this.MGV.addView(paramObject, paramMethod);
      }
      AppMethodBeat.o(9922);
      return null;
      if (this.MGV != null)
      {
        paramObject = (View)paramArrayOfObject[0];
        this.MGV.removeView(paramObject);
      }
      AppMethodBeat.o(9922);
      return null;
      if (this.MGV != null)
      {
        paramObject = (View)paramArrayOfObject[0];
        paramObject.clearAnimation();
        this.MGV.removeView(paramObject);
      }
      AppMethodBeat.o(9922);
      return null;
      if (this.MGV != null)
      {
        paramObject = (View)paramArrayOfObject[0];
        paramMethod = (WindowManager.LayoutParams)paramArrayOfObject[1];
        this.MGV.updateViewLayout(paramObject, paramMethod);
      }
      AppMethodBeat.o(9922);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation
 * JD-Core Version:    0.7.0.1
 */