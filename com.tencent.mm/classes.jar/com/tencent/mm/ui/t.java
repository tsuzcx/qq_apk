package com.tencent.mm.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "libmmui_release"})
public final class t
  extends ContextThemeWrapper
{
  private LayoutInflater iMw;
  
  public t(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(197251);
    AppMethodBeat.o(197251);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(197250);
    k.h(paramString, "name");
    if (k.g("layout_inflater", paramString))
    {
      if (this.iMw == null)
      {
        Object localObject = super.getSystemService(paramString);
        paramString = localObject;
        if (!(localObject instanceof LayoutInflater)) {
          paramString = null;
        }
        this.iMw = z.b((LayoutInflater)paramString);
      }
      paramString = this.iMw;
      AppMethodBeat.o(197250);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(197250);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.t
 * JD-Core Version:    0.7.0.1
 */