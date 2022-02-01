package com.tencent.mm.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends ContextThemeWrapper
{
  private LayoutInflater pUI;
  
  public z(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(249243);
    AppMethodBeat.o(249243);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(249246);
    s.u(paramString, "name");
    if (s.p("layout_inflater", paramString))
    {
      if (this.pUI == null)
      {
        paramString = super.getSystemService(paramString);
        if (!(paramString instanceof LayoutInflater)) {
          break label65;
        }
      }
      label65:
      for (paramString = (LayoutInflater)paramString;; paramString = null)
      {
        this.pUI = af.b(paramString);
        paramString = this.pUI;
        AppMethodBeat.o(249246);
        return paramString;
      }
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(249246);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.z
 * JD-Core Version:    0.7.0.1
 */