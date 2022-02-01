package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class SelectContactUI$b
  implements Runnable
{
  private WeakReference<SelectContactUI> eIW;
  
  private SelectContactUI$b(SelectContactUI paramSelectContactUI)
  {
    AppMethodBeat.i(37990);
    this.eIW = new WeakReference(paramSelectContactUI);
    AppMethodBeat.o(37990);
  }
  
  public final void run()
  {
    AppMethodBeat.i(37991);
    SelectContactUI localSelectContactUI = (SelectContactUI)this.eIW.get();
    if (localSelectContactUI == null)
    {
      AppMethodBeat.o(37991);
      return;
    }
    localSelectContactUI.moveTaskToBack(true);
    AppMethodBeat.o(37991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.b
 * JD-Core Version:    0.7.0.1
 */