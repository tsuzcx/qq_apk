package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.widget.b.d;

final class j$5
  implements View.OnClickListener
{
  j$5(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31313);
    if (((h)this.zET.caz.ay(h.class)).ces() == 0)
    {
      ab.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
      AppMethodBeat.o(31313);
      return;
    }
    if (((t.nU(j.e(this.zET).field_username)) && (!f.lg(j.e(this.zET).field_username))) || (t.oE(j.e(this.zET).field_username)))
    {
      j.a(this.zET, true);
      k.a(this.zET.caz.zJz.getContext(), j.c(this.zET), j.d(this.zET), j.e(this.zET).field_username, this.zET);
      AppMethodBeat.o(31313);
      return;
    }
    paramView = new d(this.zET.caz.zJz.getContext(), 1, false);
    paramView.sao = new j.5.1(this);
    paramView.sap = new j.5.2(this);
    paramView.crd();
    AppMethodBeat.o(31313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.5
 * JD-Core Version:    0.7.0.1
 */