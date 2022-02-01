package com.tencent.mm.plugin.multitask.ui.minusscreen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig$Companion;", "", "()V", "space", "", "getSpace", "()I", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  private static final int space;
  
  static
  {
    AppMethodBeat.i(304331);
    LFA = new a();
    space = a.fromDPToPix(MMApplicationContext.getContext(), 12.0F);
    AppMethodBeat.o(304331);
  }
  
  public static int gkL()
  {
    return space;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.a.a
 * JD-Core Version:    0.7.0.1
 */