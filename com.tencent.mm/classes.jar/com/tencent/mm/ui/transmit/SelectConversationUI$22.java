package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import java.util.Iterator;
import java.util.List;

final class SelectConversationUI$22
  implements MenuItem.OnMenuItemClickListener
{
  SelectConversationUI$22(SelectConversationUI paramSelectConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35145);
    if (SelectConversationUI.n(this.AAp))
    {
      AppMethodBeat.o(35145);
      return false;
    }
    paramMenuItem = SelectConversationUI.o(this.AAp).iterator();
    while (paramMenuItem.hasNext())
    {
      localObject = (String)paramMenuItem.next();
      if (this.AAp.ava((String)localObject))
      {
        AppMethodBeat.o(35145);
        return false;
      }
    }
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Select_Conv_User", ah.d(SelectConversationUI.o(this.AAp), ","));
    Object localObject = (Intent)this.AAp.getIntent().getParcelableExtra("Select_Conv_NextStep");
    if (localObject != null) {
      SelectConversationUI.a(this.AAp, paramMenuItem, (Intent)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(35145);
      return true;
      if (SelectConversationUI.p(this.AAp))
      {
        SelectConversationUI.a(this.AAp, -1, paramMenuItem);
        this.AAp.finish();
      }
      else
      {
        SelectConversationUI.a(this.AAp, paramMenuItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.22
 * JD-Core Version:    0.7.0.1
 */