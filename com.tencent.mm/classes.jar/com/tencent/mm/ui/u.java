package com.tencent.mm.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "libmmui_release"})
public final class u
  extends ContextThemeWrapper
{
  private LayoutInflater kgB;
  
  public u(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(204790);
    AppMethodBeat.o(204790);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(204789);
    p.h(paramString, "name");
    if (p.j("layout_inflater", paramString))
    {
      if (this.kgB == null)
      {
        Object localObject = super.getSystemService(paramString);
        paramString = localObject;
        if (!(localObject instanceof LayoutInflater)) {
          paramString = null;
        }
        this.kgB = aa.b((LayoutInflater)paramString);
      }
      paramString = this.kgB;
      AppMethodBeat.o(204789);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(204789);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.u
 * JD-Core Version:    0.7.0.1
 */