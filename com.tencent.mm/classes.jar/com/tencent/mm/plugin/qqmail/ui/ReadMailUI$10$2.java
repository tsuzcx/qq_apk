package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

final class ReadMailUI$10$2
  implements Runnable
{
  ReadMailUI$10$2(ReadMailUI.10 param10) {}
  
  public final void run()
  {
    int i = (int)(ReadMailUI.g(this.njP.njK).getContentHeight() * ReadMailUI.g(this.njP.njK).getScale());
    y.d("MicroMsg.ReadMailUI", ReadMailUI.g(this.njP.njK).getContentHeight() + "," + ReadMailUI.g(this.njP.njK).getHeight() + "," + ReadMailUI.g(this.njP.njK).getScale());
    if (Math.abs(i - ReadMailUI.g(this.njP.njK).getHeight()) < 10) {
      ((h)ReadMailUI.g(this.njP.njK)).lx(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10.2
 * JD-Core Version:    0.7.0.1
 */