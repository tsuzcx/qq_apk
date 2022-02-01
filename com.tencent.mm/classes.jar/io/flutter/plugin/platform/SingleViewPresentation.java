package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.Display;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
  private SingleViewPresentation.a rootView;
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
    if (this.state.STF == null) {
      return null;
    }
    return this.state.STF;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9920);
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (this.state.STG == null) {
      this.state.STG = new SingleViewPresentation.b(getContext());
    }
    if (this.state.STD == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      this.state.STD = new SingleViewPresentation.f(paramBundle, this.state.STG);
    }
    this.container = new FrameLayout(getContext());
    paramBundle = new SingleViewPresentation.d(getContext(), this.state.STD, this.outerContext);
    if (this.state.STF == null) {
      this.state.STF = this.viewFactory.a(paramBundle, this.viewId, this.createParams);
    }
    paramBundle = this.state.STF.getView();
    this.container.addView(paramBundle);
    this.rootView = new SingleViewPresentation.a(getContext(), this.accessibilityEventsDelegate, paramBundle);
    this.rootView.addView(this.container);
    this.rootView.addView(this.state.STG);
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
  
  static final class e
  {
    SingleViewPresentation.f STD;
    c STF;
    SingleViewPresentation.b STG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation
 * JD-Core Version:    0.7.0.1
 */