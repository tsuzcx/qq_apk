package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class HomeUI$12
  implements Runnable
{
  HomeUI$12(HomeUI paramHomeUI)
  {
    AppMethodBeat.i(163255);
    AppMethodBeat.o(163255);
  }
  
  public final void run()
  {
    AppMethodBeat.i(33190);
    HomeUI.c(this.adBf).supportInvalidateOptionsMenu();
    AppMethodBeat.o(33190);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(249442);
    String str = super.toString() + "|supportInvalidateOptionsMenu";
    AppMethodBeat.o(249442);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.12
 * JD-Core Version:    0.7.0.1
 */