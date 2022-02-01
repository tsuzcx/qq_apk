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
  VirtualDisplay Nea;
  SingleViewPresentation Neb;
  final a accessibilityEventsDelegate;
  final Context context;
  final int densityDpi;
  final View.OnFocusChangeListener focusChangeListener;
  Surface surface;
  final c.a tun;
  
  i(Context paramContext, a parama, VirtualDisplay paramVirtualDisplay, d paramd, Surface paramSurface, c.a parama1, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(9915);
    this.context = paramContext;
    this.accessibilityEventsDelegate = parama;
    this.tun = parama1;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.surface = paramSurface;
    this.Nea = paramVirtualDisplay;
    this.densityDpi = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.Neb = new SingleViewPresentation(paramContext, this.Nea.getDisplay(), paramd, parama, paramInt, paramObject, paramOnFocusChangeListener);
    this.Neb.show();
    AppMethodBeat.o(9915);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(9916);
    this.Neb.getView();
    this.Neb.cancel();
    this.Neb.detachState();
    this.Nea.release();
    this.tun.release();
    AppMethodBeat.o(9916);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(9917);
    if (this.Neb == null)
    {
      AppMethodBeat.o(9917);
      return null;
    }
    View localView = this.Neb.getView().getView();
    AppMethodBeat.o(9917);
    return localView;
  }
  
  final void gjR()
  {
    AppMethodBeat.i(197805);
    if ((this.Neb == null) || (this.Neb.getView() == null))
    {
      AppMethodBeat.o(197805);
      return;
    }
    this.Neb.getView();
    AppMethodBeat.o(197805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.platform.i
 * JD-Core Version:    0.7.0.1
 */