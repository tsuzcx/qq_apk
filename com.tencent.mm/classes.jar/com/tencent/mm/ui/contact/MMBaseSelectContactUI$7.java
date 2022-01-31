package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.ai;

final class MMBaseSelectContactUI$7
  implements Runnable
{
  MMBaseSelectContactUI$7(MMBaseSelectContactUI paramMMBaseSelectContactUI) {}
  
  public final void run()
  {
    MMBaseSelectContactUI.a(this.vLX, a.bdA().bdv());
    MMBaseSelectContactUI.j(this.vLX);
    ai.d(new MMBaseSelectContactUI.7.1(this));
  }
  
  public final String toString()
  {
    return super.toString() + "|updateLabelList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI.7
 * JD-Core Version:    0.7.0.1
 */