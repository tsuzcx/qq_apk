package io.flutter.a.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.f.a;

@TargetApi(20)
final class i
{
  h JcA;
  final a Jcd;
  final View.OnFocusChangeListener Jcn;
  VirtualDisplay Jcz;
  final Context context;
  final int densityDpi;
  final f.a rdW;
  Surface surface;
  
  i(Context paramContext, a parama, VirtualDisplay paramVirtualDisplay, d paramd, Surface paramSurface, f.a parama1, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(9915);
    this.context = paramContext;
    this.Jcd = parama;
    this.rdW = parama1;
    this.Jcn = paramOnFocusChangeListener;
    this.surface = paramSurface;
    this.Jcz = paramVirtualDisplay;
    this.densityDpi = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.JcA = new h(paramContext, this.Jcz.getDisplay(), paramd, parama, paramInt, paramObject, paramOnFocusChangeListener);
    this.JcA.show();
    AppMethodBeat.o(9915);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(9916);
    this.JcA.cancel();
    this.JcA.fvj();
    this.Jcz.release();
    this.rdW.release();
    AppMethodBeat.o(9916);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(9917);
    if (this.JcA == null)
    {
      AppMethodBeat.o(9917);
      return null;
    }
    View localView = this.JcA.fvk().getView();
    AppMethodBeat.o(9917);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.c.i
 * JD-Core Version:    0.7.0.1
 */