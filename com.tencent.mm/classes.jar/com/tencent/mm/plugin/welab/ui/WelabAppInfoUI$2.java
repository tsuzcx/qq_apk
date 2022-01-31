package com.tencent.mm.plugin.welab.ui;

import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WelabAppInfoUI$2
  implements MMSwitchBtn.a
{
  WelabAppInfoUI$2(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void cr(boolean paramBoolean)
  {
    if (WelabAppInfoUI.a(this.rEL).field_Switch == 2) {
      WelabAppInfoUI.a(this.rEL).field_Switch = 1;
    }
    while (WelabAppInfoUI.a(this.rEL).field_Switch != 1) {
      return;
    }
    WelabAppInfoUI.a(this.rEL).field_Switch = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.2
 * JD-Core Version:    0.7.0.1
 */