package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.e;

final class ar$a
  extends s.e
{
  public ar$a(ar paramar, a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(33402);
    paramView = (az)paramView.getTag();
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(this.zzP.zJz.getContext());
      AppMethodBeat.o(33402);
      return;
    }
    ((aj)this.zzP.ay(aj.class)).dJv().a(paramView.position, paramView.cEE);
    AppMethodBeat.o(33402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar.a
 * JD-Core Version:    0.7.0.1
 */