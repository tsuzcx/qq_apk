package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$46
  implements KeyboardLinearLayout.a
{
  WebViewUI$46(WebViewUI paramWebViewUI, WebViewKeyboardLinearLayout paramWebViewKeyboardLinearLayout) {}
  
  public final void rD(int paramInt)
  {
    boolean bool = true;
    y.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = " + paramInt);
    WebViewUI.a(this.rpH, this.rqj, paramInt);
    WebViewUI localWebViewUI;
    if (paramInt == -3)
    {
      this.rpH.rfg.cch().rgR = 1;
      int i = this.rqj.getKeyBoardHeight();
      if (i > 0)
      {
        WebViewUI.c(this.rpH, i);
        WebViewUI.b(this.rpH, i);
      }
      if ((this.rpH.niQ.getIsX5Kernel()) || (Build.VERSION.SDK_INT >= 19)) {
        WebViewUI.a(this.rpH).post(new WebViewUI.46.1(this, i));
      }
      if (WebViewUI.ap(this.rpH)) {
        WebViewUI.aq(this.rpH).cgV();
      }
      localWebViewUI = this.rpH;
      if ((paramInt == -3) && (localWebViewUI.rnX != null))
      {
        if ((localWebViewUI.gGo.cdJ().spl & 0x1) <= 0) {
          break label255;
        }
        label180:
        y.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = " + bool);
        if ((bool) && (localWebViewUI.rnX.getVisibility() != 0) && (!localWebViewUI.rnD.isShown())) {
          break label260;
        }
      }
    }
    for (;;)
    {
      this.rpH.rpG = paramInt;
      return;
      WebViewUI.c(this.rpH, 0);
      WebViewUI.b(this.rpH, 0);
      break;
      label255:
      bool = false;
      break label180;
      label260:
      if (localWebViewUI.rnY == null) {
        localWebViewUI.rnY = new am(Looper.getMainLooper(), new WebViewUI.49(localWebViewUI), false);
      }
      localWebViewUI.rnY.S(4000L, 4000L);
      View localView = localWebViewUI.rnX;
      ((ImageView)localView.findViewById(R.h.listen_model_notify_imageview)).setImageResource(R.k.net_warn_icon);
      TextView localTextView = (TextView)localView.findViewById(R.h.listen_model_notify_text);
      localTextView.setTextSize(14.0F);
      localTextView.setText(R.l.wv_alert_input_tips);
      ((ImageButton)localView.findViewById(R.h.listen_model_notify_btn)).setOnClickListener(new WebViewUI.50(localWebViewUI));
      localWebViewUI.rnX.setVisibility(0);
      h.nFQ.aC(13125, localWebViewUI.caV());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.46
 * JD-Core Version:    0.7.0.1
 */