package com.tencent.mm.ui.chatting;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

final class ao$6
  implements n.d
{
  ao$6(bi parambi, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = paramMenuItem.getTitle();
    s locals = u.oe(this.dUy.field_imgPath);
    y.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[] { paramMenuItem, this.dUy.field_imgPath });
    MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    Object localObject = this.val$context;
    this.val$context.getResources().getString(R.l.app_tip);
    localObject = h.b((Context)localObject, this.val$context.getResources().getString(R.l.app_sending), true, new ao.6.1(this, locala));
    locala.context = this.val$context;
    locala.fileName = this.dUy.field_imgPath;
    locala.ftk = ((Dialog)localObject);
    locala.userName = paramMenuItem;
    locala.wgl = locals.eHL;
    locala.eHH = locals.eHH;
    locala.execute(new Object[0]);
    bt.If().d(bt.dXE, null);
    h.bC(this.val$context, this.val$context.getString(R.l.app_saved));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao.6
 * JD-Core Version:    0.7.0.1
 */