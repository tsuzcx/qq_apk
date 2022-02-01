package com.tencent.mm.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "libmmui_release"})
public final class t
  extends ContextThemeWrapper
{
  private LayoutInflater jfG;
  
  public t(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(186567);
    AppMethodBeat.o(186567);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(186566);
    p.h(paramString, "name");
    if (p.i("layout_inflater", paramString))
    {
      if (this.jfG == null)
      {
        Object localObject = super.getSystemService(paramString);
        paramString = localObject;
        if (!(localObject instanceof LayoutInflater)) {
          paramString = null;
        }
        this.jfG = z.b((LayoutInflater)paramString);
      }
      paramString = this.jfG;
      AppMethodBeat.o(186566);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(186566);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.t
 * JD-Core Version:    0.7.0.1
 */