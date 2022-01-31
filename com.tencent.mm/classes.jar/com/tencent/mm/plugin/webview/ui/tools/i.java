package com.tencent.mm.plugin.webview.ui.tools;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.MMWebView;

public final class i
{
  String gZO;
  MMWebView nja;
  boolean rqY = false;
  WebViewUI rqZ;
  
  public i(WebViewUI paramWebViewUI)
  {
    this.rqZ = paramWebViewUI;
  }
  
  private boolean ceQ()
  {
    if (this.rqZ == null) {
      return false;
    }
    String str2 = this.gZO;
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = this.rqZ.caV();
    }
    if ((!bk.bl(str1)) && ((str1.startsWith("http://mp.weixin.qq.com/s?")) || (str1.startsWith("https://mp.weixin.qq.com/s?")))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  final void ceO()
  {
    int i = ceR();
    this.rqZ.ta(i);
    this.rqZ.czp();
    View localView = this.rqZ.findViewById(R.h.webview_logo_container);
    if (localView != null) {
      localView.setBackgroundColor(ceR());
    }
    i = this.rqZ.getResources().getColor(R.e.webview_x5logo_text_color);
    localView = this.rqZ.findViewById(R.h.x5_logo_url);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.rqZ.findViewById(R.h.info_txt);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.rqZ.findViewById(R.h.x5_logo_img);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(R.k.webview_logo_qqbrowser_light);
    }
    ceP();
  }
  
  final void ceP()
  {
    if (!ceQ())
    {
      this.rqZ.czp();
      return;
    }
    if ((this.nja != null) && (this.nja.getWebScrollY() > 0))
    {
      this.rqZ.czp();
      return;
    }
    this.rqZ.czo();
  }
  
  public final int ceR()
  {
    if (ceQ()) {
      return this.rqZ.getResources().getColor(R.e.webview_mp_actionbar_color);
    }
    return this.rqZ.getResources().getColor(R.e.webview_actionbar_color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */