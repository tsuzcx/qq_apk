package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;

final class ContactWidgetNewBizInfo$3
  implements MenuItem.OnMenuItemClickListener
{
  ContactWidgetNewBizInfo$3(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo)
  {
    AppMethodBeat.i(161412);
    AppMethodBeat.o(161412);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(231938);
    ContactWidgetNewBizInfo.b(this.Bjh).onBackPressed();
    AppMethodBeat.o(231938);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.3
 * JD-Core Version:    0.7.0.1
 */