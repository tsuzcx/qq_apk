package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.c.a;

@TargetApi(20)
final class h
{
  final int aawv;
  VirtualDisplay aaww;
  SingleViewPresentation aawx;
  final a accessibilityEventsDelegate;
  final Context context;
  final View.OnFocusChangeListener focusChangeListener;
  final c.a jSi;
  Surface surface;
  
  h(Context paramContext, a parama, VirtualDisplay paramVirtualDisplay, d paramd, Surface paramSurface, c.a parama1, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(9915);
    this.context = paramContext;
    this.accessibilityEventsDelegate = parama;
    this.jSi = parama1;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.surface = paramSurface;
    this.aaww = paramVirtualDisplay;
    this.aawv = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.aawx = new SingleViewPresentation(paramContext, this.aaww.getDisplay(), paramd, parama, paramInt, paramObject, paramOnFocusChangeListener);
    this.aawx.show();
    AppMethodBeat.o(9915);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(9916);
    this.aawx.getView();
    this.aawx.cancel();
    this.aawx.detachState();
    this.aaww.release();
    this.jSi.release();
    AppMethodBeat.o(9916);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(9917);
    if (this.aawx == null)
    {
      AppMethodBeat.o(9917);
      return null;
    }
    View localView = this.aawx.getView().getView();
    AppMethodBeat.o(9917);
    return localView;
  }
  
  final void iBy()
  {
    AppMethodBeat.i(255465);
    if ((this.aawx == null) || (this.aawx.getView() == null))
    {
      AppMethodBeat.o(255465);
      return;
    }
    this.aawx.getView();
    AppMethodBeat.o(255465);
  }
  
  @TargetApi(16)
  static final class a
    implements ViewTreeObserver.OnDrawListener
  {
    Runnable aawC;
    final View mView;
    
    private a(View paramView, Runnable paramRunnable)
    {
      this.mView = paramView;
      this.aawC = paramRunnable;
    }
    
    static void h(View paramView, Runnable paramRunnable)
    {
      AppMethodBeat.i(9890);
      paramRunnable = new a(paramView, paramRunnable);
      paramView.getViewTreeObserver().addOnDrawListener(paramRunnable);
      AppMethodBeat.o(9890);
    }
    
    public final void onDraw()
    {
      AppMethodBeat.i(9891);
      if (this.aawC == null)
      {
        AppMethodBeat.o(9891);
        return;
      }
      this.aawC.run();
      this.aawC = null;
      this.mView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9887);
          h.a.this.mView.getViewTreeObserver().removeOnDrawListener(h.a.this);
          AppMethodBeat.o(9887);
        }
      });
      AppMethodBeat.o(9891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.platform.h
 * JD-Core Version:    0.7.0.1
 */