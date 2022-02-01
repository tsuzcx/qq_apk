package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"toColor", "", "context", "Landroid/content/Context;", "toDrawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
public final class o
{
  static final Drawable f(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(82749);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramContext = a.m(paramContext, localTypedValue.resourceId);
    AppMethodBeat.o(82749);
    return paramContext;
  }
  
  static final int g(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(82750);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = a.w(paramContext, localTypedValue.resourceId);
    AppMethodBeat.o(82750);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.o
 * JD-Core Version:    0.7.0.1
 */