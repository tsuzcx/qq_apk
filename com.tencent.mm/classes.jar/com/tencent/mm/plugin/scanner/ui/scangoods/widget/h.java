package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanDotsAnimationControllerFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "type", "", "context", "Landroid/content/Context;", "dotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "Type", "plugin-scan_release"})
public final class h
{
  public static final h vXe;
  
  static
  {
    AppMethodBeat.i(52288);
    vXe = new h();
    AppMethodBeat.o(52288);
  }
  
  public static e a(int paramInt, Context paramContext, d paramd)
  {
    AppMethodBeat.i(52287);
    k.h(paramContext, "context");
    k.h(paramd, "dotsView");
    if (paramInt == 1)
    {
      paramContext = (e)new b(paramContext, paramd);
      AppMethodBeat.o(52287);
      return paramContext;
    }
    if (paramInt == 2)
    {
      paramContext = (e)new f(paramContext, paramd);
      AppMethodBeat.o(52287);
      return paramContext;
    }
    paramContext = (e)new f(paramContext, paramd);
    AppMethodBeat.o(52287);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.h
 * JD-Core Version:    0.7.0.1
 */