package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class x$18$1
  implements n.c
{
  x$18$1(x.18 param18) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(33148);
    if (this.zVC.zVA)
    {
      paraml.a(1, x.b(this.zVC.zVk).zJz.getMMResources().getColor(2131689778), x.b(this.zVC.zVk).zJz.getMMResources().getString(2131301987));
      AppMethodBeat.o(33148);
      return;
    }
    paraml.a(0, x.b(this.zVC.zVk).zJz.getMMResources().getColor(2131690393), x.b(this.zVC.zVk).zJz.getMMResources().getString(2131301972));
    AppMethodBeat.o(33148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.18.1
 * JD-Core Version:    0.7.0.1
 */