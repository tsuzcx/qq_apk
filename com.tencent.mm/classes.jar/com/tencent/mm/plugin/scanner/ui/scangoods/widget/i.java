package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanDotsAnimationControllerFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "type", "", "context", "Landroid/content/Context;", "dotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "Type", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i Ped;
  
  static
  {
    AppMethodBeat.i(52288);
    Ped = new i();
    AppMethodBeat.o(52288);
  }
  
  public static final e a(int paramInt, Context paramContext, d paramd)
  {
    AppMethodBeat.i(52287);
    s.u(paramContext, "context");
    s.u(paramd, "dotsView");
    switch (paramInt)
    {
    default: 
      paramContext = (e)new f(paramContext, paramd);
      AppMethodBeat.o(52287);
      return paramContext;
    case 1: 
      paramContext = (e)new b(paramContext, paramd);
      AppMethodBeat.o(52287);
      return paramContext;
    }
    paramContext = (e)new f(paramContext, paramd);
    AppMethodBeat.o(52287);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.i
 * JD-Core Version:    0.7.0.1
 */