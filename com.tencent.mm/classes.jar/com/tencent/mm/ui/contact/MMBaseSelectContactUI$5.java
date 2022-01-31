package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.ui.tools.q;

final class MMBaseSelectContactUI$5
  implements LabelContainerView.a
{
  MMBaseSelectContactUI$5(MMBaseSelectContactUI paramMMBaseSelectContactUI) {}
  
  public final void bno()
  {
    AppMethodBeat.i(105219);
    if (MMBaseSelectContactUI.d(this.Adz) != null) {
      MMBaseSelectContactUI.d(this.Adz).clearFocus();
    }
    if (MMBaseSelectContactUI.h(this.Adz) != null)
    {
      MMBaseSelectContactUI.h(this.Adz).clearFocus();
      MMBaseSelectContactUI.h(this.Adz).dNV();
    }
    MMBaseSelectContactUI.i(this.Adz).requestFocus();
    MMBaseSelectContactUI.i(this.Adz).setVisibility(8);
    AppMethodBeat.o(105219);
  }
  
  public final void bnp()
  {
    AppMethodBeat.i(105220);
    this.Adz.hideVKB();
    AppMethodBeat.o(105220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI.5
 * JD-Core Version:    0.7.0.1
 */