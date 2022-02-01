package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.c.a;

@TargetApi(20)
final class h
{
  VirtualDisplay STJ;
  SingleViewPresentation STK;
  final a accessibilityEventsDelegate;
  final Context context;
  final int densityDpi;
  final View.OnFocusChangeListener focusChangeListener;
  final c.a hgp;
  Surface surface;
  
  h(Context paramContext, a parama, VirtualDisplay paramVirtualDisplay, d paramd, Surface paramSurface, c.a parama1, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(9915);
    this.context = paramContext;
    this.accessibilityEventsDelegate = parama;
    this.hgp = parama1;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.surface = paramSurface;
    this.STJ = paramVirtualDisplay;
    this.densityDpi = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.STK = new SingleViewPresentation(paramContext, this.STJ.getDisplay(), paramd, parama, paramInt, paramObject, paramOnFocusChangeListener);
    this.STK.show();
    AppMethodBeat.o(9915);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(9916);
    this.STK.getView();
    this.STK.cancel();
    this.STK.detachState();
    this.STJ.release();
    this.hgp.release();
    AppMethodBeat.o(9916);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(9917);
    if (this.STK == null)
    {
      AppMethodBeat.o(9917);
      return null;
    }
    View localView = this.STK.getView().getView();
    AppMethodBeat.o(9917);
    return localView;
  }
  
  final void hxu()
  {
    AppMethodBeat.i(214886);
    if ((this.STK == null) || (this.STK.getView() == null))
    {
      AppMethodBeat.o(214886);
      return;
    }
    this.STK.getView();
    AppMethodBeat.o(214886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.platform.h
 * JD-Core Version:    0.7.0.1
 */