package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class HomeUI$b$2
  implements Runnable
{
  HomeUI$b$2(HomeUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(33225);
    HomeUI.c(this.adBr.adBf).supportInvalidateOptionsMenu();
    AppMethodBeat.o(33225);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(33226);
    String str = super.toString() + "|supportInvalidateOptionsMenu";
    AppMethodBeat.o(33226);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.b.2
 * JD-Core Version:    0.7.0.1
 */