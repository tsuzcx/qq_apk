package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class HomeUI$7
  implements Runnable
{
  HomeUI$7(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(153764);
    HomeUI.b(this.yYw).supportInvalidateOptionsMenu();
    AppMethodBeat.o(153764);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153765);
    String str = super.toString() + "|supportInvalidateOptionsMenu";
    AppMethodBeat.o(153765);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.7
 * JD-Core Version:    0.7.0.1
 */