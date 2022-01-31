package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class AllRemindMsgUI$c$3$2
  implements n.d
{
  AllRemindMsgUI$c$3$2(AllRemindMsgUI.c.3 param3, View paramView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = (AllRemindMsgUI.d)this.hdG.getTag();
    y.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", new Object[] { paramMenuItem });
    paramMenuItem = new x(2, paramMenuItem.uGI);
    au.Dk().a(paramMenuItem, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c.3.2
 * JD-Core Version:    0.7.0.1
 */