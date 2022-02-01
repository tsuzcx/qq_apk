package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.d.b;
import com.tencent.mm.plugin.patmsg.d.f;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class a$4
  implements q.f
{
  a$4(a parama, Context paramContext) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(186420);
    paramo.a(547, this.val$context.getResources().getColor(d.b.red_text_color), this.val$context.getString(d.f.app_revoke));
    AppMethodBeat.o(186420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.a.4
 * JD-Core Version:    0.7.0.1
 */