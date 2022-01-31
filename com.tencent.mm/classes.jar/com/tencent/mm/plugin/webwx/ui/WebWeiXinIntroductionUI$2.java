package com.tencent.mm.plugin.webwx.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebWeiXinIntroductionUI$2
  implements MenuItem.OnMenuItemClickListener
{
  WebWeiXinIntroductionUI$2(WebWeiXinIntroductionUI paramWebWeiXinIntroductionUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26572);
    this.vuO.finish();
    AppMethodBeat.o(26572);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI.2
 * JD-Core Version:    0.7.0.1
 */