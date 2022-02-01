package com.tencent.mm.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "libmmui_release"})
public final class x
  extends ContextThemeWrapper
{
  private LayoutInflater mYa;
  
  public x(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(213449);
    AppMethodBeat.o(213449);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(213448);
    p.k(paramString, "name");
    if (p.h("layout_inflater", paramString))
    {
      if (this.mYa == null)
      {
        Object localObject = super.getSystemService(paramString);
        paramString = localObject;
        if (!(localObject instanceof LayoutInflater)) {
          paramString = null;
        }
        this.mYa = ad.b((LayoutInflater)paramString);
      }
      paramString = this.mYa;
      AppMethodBeat.o(213448);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(213448);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */