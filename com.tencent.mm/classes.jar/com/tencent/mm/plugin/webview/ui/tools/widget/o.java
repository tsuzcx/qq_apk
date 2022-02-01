package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"toColor", "", "context", "Landroid/content/Context;", "toDrawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
public final class o
{
  static final int c(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(82750);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = b.n(paramContext, localTypedValue.resourceId);
    AppMethodBeat.o(82750);
    return paramInt;
  }
  
  static final Drawable ha(Context paramContext)
  {
    AppMethodBeat.i(175713);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(2130968841, localTypedValue, true);
    paramContext = b.l(paramContext, localTypedValue.resourceId);
    AppMethodBeat.o(175713);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.o
 * JD-Core Version:    0.7.0.1
 */