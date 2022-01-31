package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class WebWeiXinIntroductionUI$1
  implements View.OnClickListener
{
  WebWeiXinIntroductionUI$1(WebWeiXinIntroductionUI paramWebWeiXinIntroductionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26571);
    paramView = new Intent();
    paramView.putExtra("BaseScanUI_select_scan_mode", 1);
    paramView.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
    paramView.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
    paramView.putExtra("from_album", false);
    paramView.putExtra("show_intro", false);
    paramView.setFlags(65536);
    d.b(this.vuO, "scanner", ".ui.BaseScanUI", paramView);
    AppMethodBeat.o(26571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI.1
 * JD-Core Version:    0.7.0.1
 */