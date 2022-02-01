package com.tencent.mm.plugin.ringtone.l;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/utils/RingtoneUIHelper;", "", "()V", "getColorDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawableRes", "", "colorRes", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b OFS;
  
  static
  {
    AppMethodBeat.i(272989);
    OFS = new b();
    AppMethodBeat.o(272989);
  }
  
  public static Drawable m(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272982);
    s.u(paramContext, "context");
    paramInt2 = a.w(paramContext, paramInt2);
    paramContext = a.m(paramContext, paramInt1).mutate();
    s.s(paramContext, "getDrawable(context, drawableRes).mutate()");
    paramContext.setColorFilter((ColorFilter)new PorterDuffColorFilter(Color.argb(Color.alpha(paramInt2), Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2)), PorterDuff.Mode.SRC_ATOP));
    paramContext.setAlpha(Color.alpha(paramInt2));
    AppMethodBeat.o(272982);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.l.b
 * JD-Core Version:    0.7.0.1
 */