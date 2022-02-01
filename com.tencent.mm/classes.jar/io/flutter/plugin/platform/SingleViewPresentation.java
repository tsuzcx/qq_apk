package io.flutter.plugin.platform;

import android.annotation.TargetApi;
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
import androidx.annotation.Keep;
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
  private final Context outerContext;
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
    this.outerContext = paramContext;
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
    this.outerContext = paramContext;
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
    AppMethodBeat.i(255611);
    if (e.c(this.state) == null)
    {
      AppMethodBeat.o(255611);
      return null;
    }
    c localc = e.c(this.state);
    AppMethodBeat.o(255611);
    return localc;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9920);
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (e.a(this.state) == null) {
      e.a(this.state, new SingleViewPresentation.b(getContext()));
    }
    if (e.b(this.state) == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      e.a(this.state, new SingleViewPresentation.f(paramBundle, e.a(this.state)));
    }
    this.container = new FrameLayout(getContext());
    new SingleViewPresentation.d(getContext(), e.b(this.state), this.outerContext);
    if (e.c(this.state) == null) {
      e.a(this.state, this.viewFactory.iBt());
    }
    paramBundle = e.c(this.state).getView();
    this.container.addView(paramBundle);
    this.rootView = new a(getContext(), this.accessibilityEventsDelegate, paramBundle);
    this.rootView.addView(this.container);
    this.rootView.addView(e.a(this.state));
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
  
  static class a
    extends FrameLayout
  {
    private final View aawn;
    private final a accessibilityEventsDelegate;
    
    public a(Context paramContext, a parama, View paramView)
    {
      super();
      this.accessibilityEventsDelegate = parama;
      this.aawn = paramView;
    }
    
    public boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(9888);
      Object localObject = this.accessibilityEventsDelegate;
      View localView = this.aawn;
      if (((a)localObject).aapq == null)
      {
        AppMethodBeat.o(9888);
        return false;
      }
      localObject = ((a)localObject).aapq;
      if (!((io.flutter.view.a)localObject).aawF.requestSendAccessibilityEvent(localView, paramView, paramAccessibilityEvent))
      {
        AppMethodBeat.o(9888);
        return false;
      }
      paramView = ((io.flutter.view.a)localObject).aawF.getRecordFlutterId(localView, paramAccessibilityEvent);
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
        ((io.flutter.view.a)localObject).aawQ = null;
        continue;
        ((io.flutter.view.a)localObject).aawL = paramView;
        ((io.flutter.view.a)localObject).aawK = null;
        continue;
        ((io.flutter.view.a)localObject).aawM = null;
        ((io.flutter.view.a)localObject).aawL = null;
        continue;
        ((io.flutter.view.a)localObject).aawM = paramView;
        ((io.flutter.view.a)localObject).aawO = null;
      }
    }
  }
  
  static class e
  {
    private SingleViewPresentation.f aawp;
    private c aawr;
    private SingleViewPresentation.b aaws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation
 * JD-Core Version:    0.7.0.1
 */