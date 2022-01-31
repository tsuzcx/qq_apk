package com.tencent.mm.ui.chatting;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

final class al$6
  implements n.d
{
  al$6(bi parambi, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31015);
    paramMenuItem = paramMenuItem.getTitle();
    s locals = u.vr(this.fkH.field_imgPath);
    ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramMenuItem, this.fkH.field_imgPath });
    MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    Object localObject = this.val$context;
    this.val$context.getResources().getString(2131297087);
    localObject = h.b((Context)localObject, this.val$context.getResources().getString(2131297069), true, new al.6.1(this, locala));
    locala.context = this.val$context;
    locala.fileName = this.fkH.field_imgPath;
    locala.gKM = ((Dialog)localObject);
    locala.userName = paramMenuItem;
    locala.Azc = locals.fXB;
    locala.fXx = locals.fXx;
    locala.execute(new Object[0]);
    bv.abc().c(bv.fnJ, null);
    h.bO(this.val$context, this.val$context.getString(2131297064));
    AppMethodBeat.o(31015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.6
 * JD-Core Version:    0.7.0.1
 */