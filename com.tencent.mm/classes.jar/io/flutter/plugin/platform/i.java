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
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.c.a;

@TargetApi(20)
final class i
{
  VirtualDisplay KPX;
  SingleViewPresentation KPY;
  final a accessibilityEventsDelegate;
  final Context context;
  final int densityDpi;
  final View.OnFocusChangeListener focusChangeListener;
  final c.a smR;
  Surface surface;
  
  i(Context paramContext, a parama, VirtualDisplay paramVirtualDisplay, d paramd, Surface paramSurface, c.a parama1, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(9915);
    this.context = paramContext;
    this.accessibilityEventsDelegate = parama;
    this.smR = parama1;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.surface = paramSurface;
    this.KPX = paramVirtualDisplay;
    this.densityDpi = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.KPY = new SingleViewPresentation(paramContext, this.KPX.getDisplay(), paramd, parama, paramInt, paramObject, paramOnFocusChangeListener);
    this.KPY.show();
    AppMethodBeat.o(9915);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(9916);
    this.KPY.getView();
    this.KPY.cancel();
    this.KPY.detachState();
    this.KPX.release();
    this.smR.release();
    AppMethodBeat.o(9916);
  }
  
  final void fNQ()
  {
    AppMethodBeat.i(192779);
    if ((this.KPY == null) || (this.KPY.getView() == null))
    {
      AppMethodBeat.o(192779);
      return;
    }
    this.KPY.getView();
    AppMethodBeat.o(192779);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(9917);
    if (this.KPY == null)
    {
      AppMethodBeat.o(9917);
      return null;
    }
    View localView = this.KPY.getView().getView();
    AppMethodBeat.o(9917);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.i
 * JD-Core Version:    0.7.0.1
 */