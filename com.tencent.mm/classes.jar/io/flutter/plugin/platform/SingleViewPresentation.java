package io.flutter.plugin.platform;

import android.app.Presentation;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SingleViewPresentation
  extends Presentation
{
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private FrameLayout container;
  private Object createParams;
  private final View.OnFocusChangeListener focusChangeListener;
  private final Context outerContext;
  private AccessibilityDelegatingFrameLayout rootView;
  private boolean startFocused;
  private PresentationState state;
  private final PlatformViewFactory viewFactory;
  private int viewId;
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, PresentationState paramPresentationState, View.OnFocusChangeListener paramOnFocusChangeListener, boolean paramBoolean)
  {
    super(new SingleViewPresentation.ImmContext(paramContext), paramDisplay);
    AppMethodBeat.i(9919);
    this.startFocused = false;
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.viewFactory = null;
    this.state = paramPresentationState;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.outerContext = paramContext;
    getWindow().setFlags(8, 8);
    this.startFocused = paramBoolean;
    AppMethodBeat.o(9919);
  }
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, PlatformViewFactory paramPlatformViewFactory, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, int paramInt, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super(new SingleViewPresentation.ImmContext(paramContext), paramDisplay);
    AppMethodBeat.i(9918);
    this.startFocused = false;
    this.viewFactory = paramPlatformViewFactory;
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.viewId = paramInt;
    this.createParams = paramObject;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.outerContext = paramContext;
    this.state = new PresentationState();
    getWindow().setFlags(8, 8);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().setType(2030);
    }
    AppMethodBeat.o(9918);
  }
  
  public PresentationState detachState()
  {
    AppMethodBeat.i(9921);
    this.container.removeAllViews();
    this.rootView.removeAllViews();
    PresentationState localPresentationState = this.state;
    AppMethodBeat.o(9921);
    return localPresentationState;
  }
  
  public PlatformView getView()
  {
    AppMethodBeat.i(189932);
    if (this.state.platformView == null)
    {
      AppMethodBeat.o(189932);
      return null;
    }
    PlatformView localPlatformView = this.state.platformView;
    AppMethodBeat.o(189932);
    return localPlatformView;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9920);
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (this.state.fakeWindowViewGroup == null) {
      PresentationState.access$002(this.state, new SingleViewPresentation.FakeWindowViewGroup(getContext()));
    }
    if (this.state.windowManagerHandler == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      PresentationState.access$102(this.state, new SingleViewPresentation.WindowManagerHandler(paramBundle, this.state.fakeWindowViewGroup));
    }
    this.container = new FrameLayout(getContext());
    paramBundle = new SingleViewPresentation.PresentationContext(getContext(), this.state.windowManagerHandler, this.outerContext);
    if (this.state.platformView == null) {
      PresentationState.access$202(this.state, this.viewFactory.create(paramBundle, this.viewId, this.createParams));
    }
    paramBundle = this.state.platformView.getView();
    this.container.addView(paramBundle);
    this.rootView = new AccessibilityDelegatingFrameLayout(getContext(), this.accessibilityEventsDelegate, paramBundle);
    this.rootView.addView(this.container);
    this.rootView.addView(this.state.fakeWindowViewGroup);
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
  
  static class AccessibilityDelegatingFrameLayout
    extends FrameLayout
  {
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private final View embeddedView;
    
    public AccessibilityDelegatingFrameLayout(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, View paramView)
    {
      super();
      this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
      this.embeddedView = paramView;
    }
    
    public boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(9888);
      boolean bool = this.accessibilityEventsDelegate.requestSendAccessibilityEvent(this.embeddedView, paramView, paramAccessibilityEvent);
      AppMethodBeat.o(9888);
      return bool;
    }
  }
  
  static class PresentationState
  {
    private SingleViewPresentation.FakeWindowViewGroup fakeWindowViewGroup;
    private PlatformView platformView;
    private SingleViewPresentation.WindowManagerHandler windowManagerHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation
 * JD-Core Version:    0.7.0.1
 */