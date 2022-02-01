package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class MailAddrListUI$7
  implements MenuItem.OnMenuItemClickListener
{
  MailAddrListUI$7(MailAddrListUI paramMailAddrListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(123043);
    paramMenuItem = MailAddrListUI.e(this.BvT);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMenuItem.BvU.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(paramMenuItem.BvU.get(str));
    }
    ComposeUI.fW(localArrayList);
    this.BvT.setResult(-1);
    this.BvT.finish();
    AppMethodBeat.o(123043);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.7
 * JD-Core Version:    0.7.0.1
 */