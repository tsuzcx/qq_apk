package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class ShakeMsgListUI$6
  implements n.d
{
  ShakeMsgListUI$6(ShakeMsgListUI paramShakeMsgListUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24757);
    paramMenuItem = ShakeMsgListUI.a(this.qQa);
    long l = ShakeMsgListUI.i(this.qQa);
    String str = "svrid = '" + String.valueOf(l) + "'";
    ab.i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(paramMenuItem.db.delete(paramMenuItem.getTableName(), str, null))));
    ShakeMsgListUI.b(this.qQa).a(null, null);
    AppMethodBeat.o(24757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.6
 * JD-Core Version:    0.7.0.1
 */