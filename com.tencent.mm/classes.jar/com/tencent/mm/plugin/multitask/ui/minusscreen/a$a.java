package com.tencent.mm.plugin.multitask.ui.minusscreen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig$Companion;", "", "()V", "space", "", "getSpace", "()I", "ui-multitask_release"})
public final class a$a
{
  private static final int space;
  
  static
  {
    AppMethodBeat.i(196454);
    FKl = new a();
    space = a.fromDPToPix(MMApplicationContext.getContext(), 12.0F);
    AppMethodBeat.o(196454);
  }
  
  public static int fbH()
  {
    return space;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.a.a
 * JD-Core Version:    0.7.0.1
 */