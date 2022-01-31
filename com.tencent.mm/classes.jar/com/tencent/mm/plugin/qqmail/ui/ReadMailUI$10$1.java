package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.n;

final class ReadMailUI$10$1
  implements Runnable
{
  ReadMailUI$10$1(ReadMailUI.10 param10) {}
  
  public final void run()
  {
    ReadMailUI.g(this.njP.njK).getSettings().setLoadsImagesAutomatically(true);
    ReadMailUI.g(this.njP.njK).getSettings().setSupportZoom(true);
    ReadMailUI.g(this.njP.njK).getSettings().setBuiltInZoomControls(true);
    ((h)ReadMailUI.g(this.njP.njK)).cgN();
    ((h)ReadMailUI.g(this.njP.njK)).cgO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10.1
 * JD-Core Version:    0.7.0.1
 */