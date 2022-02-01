package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.Display;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.AccessibilityViewEmbedder;

@TargetApi(17)
@Keep
class SingleViewPresentation
  extends Presentation
{
  private final a accessibilityEventsDelegate;
  private FrameLayout container;
  private Object createParams;
  private final View.OnFocusChangeListener focusChangeListener;
  private a rootView;
  private boolean startFocused;
  private e state;
  private final d viewFactory;
  private int viewId;
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, a parama, e parame, View.OnFocusChangeListener paramOnFocusChangeListener, boolean paramBoolean)
  {
    super(new SingleViewPresentation.c(paramContext), paramDisplay);
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
    super(new SingleViewPresentation.c(paramContext), paramDisplay);
    AppMethodBeat.i(9918);
    this.startFocused = false;
    this.viewFactory = paramd;
    this.accessibilityEventsDelegate = parama;
    this.viewId = paramInt;
    this.createParams = paramObject;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.state = new e();
    getWindow().setFlags(8, 8);
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
    if (this.state.KPT == null) {
      return null;
    }
    return this.state.KPT;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9920);
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (this.state.KPU == null) {
      this.state.KPU = new SingleViewPresentation.b(getContext());
    }
    if (this.state.KPS == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      this.state.KPS = new SingleViewPresentation.f(paramBundle, this.state.KPU);
    }
    this.container = new FrameLayout(getContext());
    new SingleViewPresentation.d(getContext(), this.state.KPS);
    if (this.state.KPT == null) {
      this.state.KPT = this.viewFactory.fNL();
    }
    paramBundle = this.state.KPT.getView();
    this.container.addView(paramBundle);
    this.rootView = new a(getContext(), this.accessibilityEventsDelegate, paramBundle);
    this.rootView.addView(this.container);
    this.rootView.addView(this.state.KPU);
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
  
  static final class a
    extends FrameLayout
  {
    private final View KPQ;
    private final a accessibilityEventsDelegate;
    
    public a(Context paramContext, a parama, View paramView)
    {
      super();
      this.accessibilityEventsDelegate = parama;
      this.KPQ = paramView;
    }
    
    public final boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(9888);
      Object localObject = this.accessibilityEventsDelegate;
      View localView = this.KPQ;
      if (((a)localObject).KKY == null)
      {
        AppMethodBeat.o(9888);
        return false;
      }
      localObject = ((a)localObject).KKY;
      if (!((io.flutter.view.a)localObject).KQg.requestSendAccessibilityEvent(localView, paramView, paramAccessibilityEvent))
      {
        AppMethodBeat.o(9888);
        return false;
      }
      paramView = ((io.flutter.view.a)localObject).KQg.getRecordFlutterId(localView, paramAccessibilityEvent);
      if (paramView == null)
      {
        AppMethodBeat.o(9888);
        return false;
      }
      switch (paramAccessibilityEvent.getEventType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(9888);
        return true;
        ((io.flutter.view.a)localObject).KQq = null;
        continue;
        ((io.flutter.view.a)localObject).KQl = paramView;
        ((io.flutter.view.a)localObject).KQk = null;
        continue;
        ((io.flutter.view.a)localObject).KQm = null;
        ((io.flutter.view.a)localObject).KQl = null;
        continue;
        ((io.flutter.view.a)localObject).KQm = paramView;
        ((io.flutter.view.a)localObject).KQo = null;
      }
    }
  }
  
  static final class e
  {
    SingleViewPresentation.f KPS;
    c KPT;
    SingleViewPresentation.b KPU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation
 * JD-Core Version:    0.7.0.1
 */