package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
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
    if (this.state.NdW == null) {
      return null;
    }
    return this.state.NdW;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9920);
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (this.state.NdX == null) {
      this.state.NdX = new b(getContext());
    }
    if (this.state.NdV == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      this.state.NdV = new f(paramBundle, this.state.NdX);
    }
    this.container = new FrameLayout(getContext());
    new d(getContext(), this.state.NdV);
    if (this.state.NdW == null) {
      this.state.NdW = this.viewFactory.gjM();
    }
    paramBundle = this.state.NdW.getView();
    this.container.addView(paramBundle);
    this.rootView = new SingleViewPresentation.a(getContext(), this.accessibilityEventsDelegate, paramBundle);
    this.rootView.addView(this.container);
    this.rootView.addView(this.state.NdX);
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
  
  static final class b
    extends ViewGroup
  {
    private final Rect NdU;
    private final Rect bWs;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(9894);
      this.bWs = new Rect();
      this.NdU = new Rect();
      AppMethodBeat.o(9894);
    }
    
    private static int ajN(int paramInt)
    {
      AppMethodBeat.i(9897);
      paramInt = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt), -2147483648);
      AppMethodBeat.o(9897);
      return paramInt;
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(9895);
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localView.getLayoutParams();
        this.bWs.set(paramInt1, paramInt2, paramInt3, paramInt4);
        Gravity.apply(localLayoutParams.gravity, localView.getMeasuredWidth(), localView.getMeasuredHeight(), this.bWs, localLayoutParams.x, localLayoutParams.y, this.NdU);
        localView.layout(this.NdU.left, this.NdU.top, this.NdU.right, this.NdU.bottom);
        i += 1;
      }
      AppMethodBeat.o(9895);
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(9896);
      int i = 0;
      while (i < getChildCount())
      {
        getChildAt(i).measure(ajN(paramInt1), ajN(paramInt2));
        i += 1;
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(9896);
    }
  }
  
  static final class c
    extends ContextWrapper
  {
    private final InputMethodManager FrX;
    
    c(Context paramContext)
    {
      this(paramContext, null);
    }
    
    private c(Context paramContext, InputMethodManager paramInputMethodManager)
    {
      super();
      AppMethodBeat.i(197798);
      if (paramInputMethodManager != null) {}
      for (;;)
      {
        this.FrX = paramInputMethodManager;
        AppMethodBeat.o(197798);
        return;
        paramInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      }
    }
    
    public final Context createDisplayContext(Display paramDisplay)
    {
      AppMethodBeat.i(197800);
      paramDisplay = new c(super.createDisplayContext(paramDisplay), this.FrX);
      AppMethodBeat.o(197800);
      return paramDisplay;
    }
    
    public final Object getSystemService(String paramString)
    {
      AppMethodBeat.i(197799);
      if ("input_method".equals(paramString))
      {
        paramString = this.FrX;
        AppMethodBeat.o(197799);
        return paramString;
      }
      paramString = super.getSystemService(paramString);
      AppMethodBeat.o(197799);
      return paramString;
    }
  }
  
  static final class d
    extends ContextWrapper
  {
    private final SingleViewPresentation.f NdV;
    private WindowManager windowManager;
    
    d(Context paramContext, SingleViewPresentation.f paramf)
    {
      super();
      this.NdV = paramf;
    }
    
    public final Object getSystemService(String paramString)
    {
      AppMethodBeat.i(9933);
      if ("window".equals(paramString))
      {
        if (this.windowManager == null)
        {
          paramString = this.NdV;
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
    SingleViewPresentation.f NdV;
    c NdW;
    SingleViewPresentation.b NdX;
  }
  
  static final class f
    implements InvocationHandler
  {
    private final WindowManager NdY;
    SingleViewPresentation.b NdZ;
    
    f(WindowManager paramWindowManager, SingleViewPresentation.b paramb)
    {
      this.NdY = paramWindowManager;
      this.NdZ = paramb;
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
          paramObject = paramMethod.invoke(this.NdY, paramArrayOfObject);
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
      if (this.NdZ != null)
      {
        paramObject = (View)paramArrayOfObject[0];
        paramMethod = (WindowManager.LayoutParams)paramArrayOfObject[1];
        this.NdZ.addView(paramObject, paramMethod);
      }
      AppMethodBeat.o(9922);
      return null;
      if (this.NdZ != null)
      {
        paramObject = (View)paramArrayOfObject[0];
        this.NdZ.removeView(paramObject);
      }
      AppMethodBeat.o(9922);
      return null;
      if (this.NdZ != null)
      {
        paramObject = (View)paramArrayOfObject[0];
        paramObject.clearAnimation();
        this.NdZ.removeView(paramObject);
      }
      AppMethodBeat.o(9922);
      return null;
      if (this.NdZ != null)
      {
        paramObject = (View)paramArrayOfObject[0];
        paramMethod = (WindowManager.LayoutParams)paramArrayOfObject[1];
        this.NdZ.updateViewLayout(paramObject, paramMethod);
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