package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.b;
import java.util.HashMap;

final class j$11
  implements n.b
{
  j$11(j paramj) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(7650);
    paramMenuItem = paramMenuItem.getTitle();
    if (paramTextView != null)
    {
      String str = (String)this.vcO.vcF.get(paramMenuItem);
      if (bo.isNullOrNil(str))
      {
        paramTextView.setText(paramMenuItem);
        AppMethodBeat.o(7650);
        return;
      }
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.vcO.ddt(), str, paramTextView.getTextSize()));
    }
    AppMethodBeat.o(7650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.11
 * JD-Core Version:    0.7.0.1
 */