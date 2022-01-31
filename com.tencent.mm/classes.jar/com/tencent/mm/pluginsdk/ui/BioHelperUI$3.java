package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class BioHelperUI$3
  implements View.OnClickListener
{
  BioHelperUI$3(BioHelperUI paramBioHelperUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", BioHelperUI.b(this.rZi));
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    paramView.putExtra("needRedirect", false);
    paramView.putExtra("neverGetA8Key", true);
    paramView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    paramView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    d.b(this.rZi, "webview", ".ui.tools.WebViewUI", paramView);
    this.rZi.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.BioHelperUI.3
 * JD-Core Version:    0.7.0.1
 */