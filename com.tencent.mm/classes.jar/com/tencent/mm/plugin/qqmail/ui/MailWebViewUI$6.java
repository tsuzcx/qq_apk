package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import com.tencent.mm.ui.widget.MMWebView;

final class MailWebViewUI$6
  implements Runnable
{
  MailWebViewUI$6(MailWebViewUI paramMailWebViewUI, int paramInt) {}
  
  public final void run()
  {
    View localView = (View)MailWebViewUI.c(this.niS).getParent();
    if (localView != null)
    {
      int j = localView.getWidth();
      if (this.niV > j)
      {
        int i = 10;
        float f = j / this.niV;
        while (f < MailWebViewUI.c(this.niS).getScale())
        {
          i -= 1;
          if (i <= 0) {
            break;
          }
          MailWebViewUI.c(this.niS).zoomOut();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */