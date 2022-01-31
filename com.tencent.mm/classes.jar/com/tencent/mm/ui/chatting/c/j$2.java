package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class j$2
  implements View.OnClickListener
{
  j$2(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31308);
    paramView = (com.tencent.mm.ui.chatting.c.b.h)this.zET.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    if (paramView.ces() == 0)
    {
      ab.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
      AppMethodBeat.o(31308);
      return;
    }
    Activity localActivity = this.zET.caz.zJz.getContext();
    com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(2131298494), "", localActivity.getString(2131298950), localActivity.getString(2131296888), new j.2.1(this, localActivity, paramView), null, 2131689667);
    AppMethodBeat.o(31308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.2
 * JD-Core Version:    0.7.0.1
 */