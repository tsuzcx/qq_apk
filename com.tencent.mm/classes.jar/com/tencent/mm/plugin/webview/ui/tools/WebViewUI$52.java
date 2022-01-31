package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.s;
import java.util.HashMap;

final class WebViewUI$52
  implements n.b
{
  WebViewUI$52(WebViewUI paramWebViewUI) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    paramMenuItem = paramMenuItem.getTitle();
    String str;
    if (paramTextView != null)
    {
      str = (String)WebViewUI.R(this.rpH).get(paramMenuItem);
      if (bk.bl(str)) {
        WebViewUI.d(paramTextView, paramMenuItem);
      }
    }
    else
    {
      return;
    }
    paramTextView.setText(j.a(this.rpH.mController.uMN, str, paramTextView.getTextSize()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.52
 * JD-Core Version:    0.7.0.1
 */