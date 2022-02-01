package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"toColor", "", "context", "Landroid/content/Context;", "toDrawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class r
{
  static final Drawable g(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(82749);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramContext = a.m(paramContext, localTypedValue.resourceId);
    AppMethodBeat.o(82749);
    return paramContext;
  }
  
  static final int h(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(82750);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = a.w(paramContext, localTypedValue.resourceId);
    AppMethodBeat.o(82750);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.r
 * JD-Core Version:    0.7.0.1
 */