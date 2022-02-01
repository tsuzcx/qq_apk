package com.tencent.mm.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "libmmui_release"})
public final class s
  extends ContextThemeWrapper
{
  private LayoutInflater imq;
  
  public s(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(190960);
    AppMethodBeat.o(190960);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(190959);
    k.h(paramString, "name");
    if (k.g("layout_inflater", paramString))
    {
      if (this.imq == null)
      {
        Object localObject = super.getSystemService(paramString);
        paramString = localObject;
        if (!(localObject instanceof LayoutInflater)) {
          paramString = null;
        }
        this.imq = y.b((LayoutInflater)paramString);
      }
      paramString = this.imq;
      AppMethodBeat.o(190959);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(190959);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */