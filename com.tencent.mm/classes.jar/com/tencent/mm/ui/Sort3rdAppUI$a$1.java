package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class Sort3rdAppUI$a$1
  implements MMSwitchBtn.a
{
  Sort3rdAppUI$a$1(Sort3rdAppUI.a parama, f paramf) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(29900);
    f localf;
    if (paramBoolean) {
      localf = this.zfj;
    }
    for (localf.field_appInfoFlag &= 0xFFFFBFFF;; localf.field_appInfoFlag |= 0x4000)
    {
      al.cac().a(this.zfj, new String[0]);
      AppMethodBeat.o(29900);
      return;
      localf = this.zfj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.a.1
 * JD-Core Version:    0.7.0.1
 */