package com.tencent.mm.ui.contact;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.ui.tools.n;

final class MMBaseSelectContactUI$5
  implements LabelContainerView.a
{
  MMBaseSelectContactUI$5(MMBaseSelectContactUI paramMMBaseSelectContactUI) {}
  
  public final void aJG()
  {
    if (MMBaseSelectContactUI.d(this.vLX) != null) {
      MMBaseSelectContactUI.d(this.vLX).clearFocus();
    }
    if (MMBaseSelectContactUI.h(this.vLX) != null)
    {
      MMBaseSelectContactUI.h(this.vLX).clearFocus();
      MMBaseSelectContactUI.h(this.vLX).cJg();
    }
    MMBaseSelectContactUI.i(this.vLX).requestFocus();
    MMBaseSelectContactUI.i(this.vLX).setVisibility(8);
  }
  
  public final void aJH()
  {
    this.vLX.XM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI.5
 * JD-Core Version:    0.7.0.1
 */