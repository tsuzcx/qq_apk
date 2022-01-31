package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34664);
    paramView = new Intent();
    paramView.putExtra("Invite_friends", 1);
    d.b(this.val$context, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", paramView);
    h.qsU.e(14034, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(34664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.j.1
 * JD-Core Version:    0.7.0.1
 */