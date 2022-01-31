package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class ShakeMsgListUI$6
  implements n.d
{
  ShakeMsgListUI$6(ShakeMsgListUI paramShakeMsgListUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = ShakeMsgListUI.a(this.obT);
    long l = ShakeMsgListUI.i(this.obT);
    String str = "svrid = '" + String.valueOf(l) + "'";
    paramInt = paramMenuItem.dXw.delete(paramMenuItem.getTableName(), str, null);
    y.i("MicroMsg.ShakeMessageStorage", "delBySvrId = " + paramInt);
    ShakeMsgListUI.b(this.obT).a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.6
 * JD-Core Version:    0.7.0.1
 */