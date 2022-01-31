package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.b.d;
import java.util.Map;

final class x$18
  implements View.OnClickListener
{
  x$18(x paramx, Map paramMap, boolean paramBoolean, be parambe, bi parambi) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33150);
    paramView = bo.nullAsNil((String)this.oCN.get(".msg.fromusername"));
    d locald = new d(x.b(this.zVk).zJz.getContext(), 1, true);
    if (this.zVA) {
      locald.r(x.b(this.zVk).zJz.getMMResources().getString(2131301989), 3);
    }
    for (;;)
    {
      locald.sao = new x.18.1(this);
      locald.sap = new x.18.2(this, paramView);
      locald.crd();
      AppMethodBeat.o(33150);
      return;
      locald.r(x.b(this.zVk).zJz.getMMResources().getString(2131301973), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.18
 * JD-Core Version:    0.7.0.1
 */