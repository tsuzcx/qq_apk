package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WelabMainUI$1
  implements View.OnClickListener
{
  WelabMainUI$1(WelabMainUI paramWelabMainUI) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("title", paramView.getResources().getString(a.d.welab_privacy_tip));
    localIntent.putExtra("rawUrl", this.rEW.mController.uMN.getString(a.d.welab_agreement_url, new Object[] { x.cqJ(), Integer.valueOf(com.tencent.mm.protocal.d.spa) }));
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.d.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI.1
 * JD-Core Version:    0.7.0.1
 */