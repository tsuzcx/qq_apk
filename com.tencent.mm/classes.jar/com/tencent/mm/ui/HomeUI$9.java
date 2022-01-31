package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class HomeUI$9
  implements Runnable
{
  HomeUI$9(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29351);
    HomeUI.b(this.yYw).supportInvalidateOptionsMenu();
    AppMethodBeat.o(29351);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153767);
    String str = super.toString() + "|supportInvalidateOptionsMenu";
    AppMethodBeat.o(153767);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.9
 * JD-Core Version:    0.7.0.1
 */