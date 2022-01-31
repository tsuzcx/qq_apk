package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class SelectContactUI$b
  implements Runnable
{
  private WeakReference<SelectContactUI> bJz;
  
  private SelectContactUI$b(SelectContactUI paramSelectContactUI)
  {
    AppMethodBeat.i(153970);
    this.bJz = new WeakReference(paramSelectContactUI);
    AppMethodBeat.o(153970);
  }
  
  public final void run()
  {
    AppMethodBeat.i(153971);
    SelectContactUI localSelectContactUI = (SelectContactUI)this.bJz.get();
    if (localSelectContactUI == null)
    {
      AppMethodBeat.o(153971);
      return;
    }
    localSelectContactUI.moveTaskToBack(true);
    AppMethodBeat.o(153971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.b
 * JD-Core Version:    0.7.0.1
 */