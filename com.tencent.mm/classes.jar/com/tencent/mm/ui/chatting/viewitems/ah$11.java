package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class ah$11
  implements n.c
{
  ah$11(ah paramah, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(169887);
    if (this.InG)
    {
      paraml.a(1, ah.b(this.Inu).HZF.getMMResources().getColor(2131100035), ah.b(this.Inu).HZF.getMMResources().getString(2131761764));
      AppMethodBeat.o(169887);
      return;
    }
    int j = ah.b(this.Inu).HZF.getMMResources().getColor(2131100800);
    Resources localResources = ah.b(this.Inu).HZF.getMMResources();
    if (this.InI) {}
    for (int i = 2131761743;; i = 2131761744)
    {
      paraml.a(0, j, localResources.getString(i));
      AppMethodBeat.o(169887);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.11
 * JD-Core Version:    0.7.0.1
 */