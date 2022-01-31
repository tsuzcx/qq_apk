package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsChatRoomMemberUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SnsChatRoomMemberUI$3(SnsChatRoomMemberUI paramSnsChatRoomMemberUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(145528);
    this.rOn.setResult(0);
    this.rOn.finish();
    AppMethodBeat.o(145528);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI.3
 * JD-Core Version:    0.7.0.1
 */