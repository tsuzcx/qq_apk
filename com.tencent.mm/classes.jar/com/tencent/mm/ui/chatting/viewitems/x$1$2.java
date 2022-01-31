package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class x$1$2
  implements n.d
{
  x$1$2(x.1 param1, View paramView, String paramString, int paramInt1, int paramInt2, bi parambi) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(33126);
    ab.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramMenuItem.getItemId()), Integer.valueOf(paramInt) });
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33126);
      return;
      aw.Rc().a(1198, new x.1.2.1(this));
      paramMenuItem = new s(this.fkH.field_content);
      x localx = this.zVl.zVk;
      Context localContext = this.bTJ.getContext();
      this.bTJ.getResources().getString(2131297087);
      x.a(localx, h.b(localContext, this.bTJ.getResources().getString(2131297112), true, new x.1.2.2(this, paramMenuItem)));
      aw.Rc().a(paramMenuItem, 0);
      x.K(4, x.c(this.zVl.zVk), x.d(this.zVl.zVk));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.1.2
 * JD-Core Version:    0.7.0.1
 */