package com.tencent.mm.ui;

import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class Sort3rdAppUI$a$1
  implements MMSwitchBtn.a
{
  Sort3rdAppUI$a$1(Sort3rdAppUI.a parama, f paramf) {}
  
  public final void cr(boolean paramBoolean)
  {
    f localf;
    if (paramBoolean) {
      localf = this.uQX;
    }
    for (localf.field_appInfoFlag &= 0xFFFFBFFF;; localf.field_appInfoFlag |= 0x4000)
    {
      ap.brn().a(this.uQX, new String[0]);
      return;
      localf = this.uQX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.a.1
 * JD-Core Version:    0.7.0.1
 */