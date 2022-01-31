package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.a;

final class WebViewUI$35
  implements n.a
{
  WebViewUI$35(WebViewUI paramWebViewUI) {}
  
  public final void a(ImageView paramImageView, MenuItem paramMenuItem)
  {
    if (WebViewUI.g(paramMenuItem)) {
      paramImageView.setVisibility(8);
    }
    for (;;)
    {
      return;
      paramMenuItem = paramMenuItem.getTitle();
      if ((WebViewUI.Q(this.rpH).get(paramMenuItem) != null) && (!((Bitmap)WebViewUI.Q(this.rpH).get(paramMenuItem)).isRecycled()))
      {
        paramImageView.setImageBitmap((Bitmap)WebViewUI.Q(this.rpH).get(paramMenuItem));
        return;
      }
      y.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
      try
      {
        Object localObject = this.rpH.gGn.SL(paramMenuItem);
        if (!bk.bl((String)localObject))
        {
          localObject = e.Td((String)localObject);
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            paramImageView.setImageBitmap((Bitmap)localObject);
            WebViewUI.Q(this.rpH).put(paramMenuItem, localObject);
            return;
          }
        }
      }
      catch (Exception paramImageView)
      {
        y.w("MicroMsg.WebViewUI", "getheadimg, ex = " + paramImageView.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.35
 * JD-Core Version:    0.7.0.1
 */