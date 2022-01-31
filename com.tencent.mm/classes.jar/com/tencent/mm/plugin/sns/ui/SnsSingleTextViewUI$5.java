package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class SnsSingleTextViewUI$5
  implements n.d
{
  SnsSingleTextViewUI$5(SnsSingleTextViewUI paramSnsSingleTextViewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(39305);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(39305);
      return;
    case 0: 
      if ((SnsSingleTextViewUI.e(this.rWm) != null) && (SnsSingleTextViewUI.e(this.rWm).getText() != null))
      {
        SnsSingleTextViewUI.f(this.rWm).setText(SnsSingleTextViewUI.e(this.rWm).getText());
        h.bO(this.rWm.getContext(), this.rWm.getContext().getString(2131296896));
        if (SnsSingleTextViewUI.a(this.rWm) != null)
        {
          paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.qEl;
          com.tencent.mm.plugin.secinforeport.a.a.i(2, bo.nW(SnsSingleTextViewUI.a(this.rWm).field_snsId), bo.apL(SnsSingleTextViewUI.e(this.rWm).getText().toString()));
        }
      }
      AppMethodBeat.o(39305);
      return;
    case 1: 
      if ((SnsSingleTextViewUI.e(this.rWm) != null) && (SnsSingleTextViewUI.e(this.rWm).getText() != null))
      {
        paramMenuItem = new cm();
        com.tencent.mm.plugin.sns.j.a.a(paramMenuItem, SnsSingleTextViewUI.g(this.rWm), SnsSingleTextViewUI.e(this.rWm).getText());
        paramMenuItem.cpR.activity = this.rWm;
        paramMenuItem.cpR.cpY = 18;
        com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
      }
      AppMethodBeat.o(39305);
      return;
    case 6: 
      Intent localIntent;
      n localn;
      if ((SnsSingleTextViewUI.e(this.rWm) != null) && (SnsSingleTextViewUI.e(this.rWm).getText() != null))
      {
        localIntent = new Intent();
        localn = ag.cpf().abv(SnsSingleTextViewUI.g(this.rWm));
        if (localn != null) {
          break label420;
        }
        paramMenuItem = "";
        localIntent.putExtra("k_username", paramMenuItem);
        if (localn != null) {
          break label429;
        }
      }
      for (paramMenuItem = Integer.valueOf(0);; paramMenuItem = localn.getSnsId())
      {
        localIntent.putExtra("k_expose_msg_id", paramMenuItem);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
        d.b(this.rWm, "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(39305);
        return;
        paramMenuItem = localn.field_userName;
        break;
      }
    case 14: 
      if ((SnsSingleTextViewUI.e(this.rWm) != null) && (SnsSingleTextViewUI.e(this.rWm).getText() != null)) {
        aq.r(ag.cpf().abv(SnsSingleTextViewUI.g(this.rWm)));
      }
      AppMethodBeat.o(39305);
      return;
    case 16: 
      if ((SnsSingleTextViewUI.e(this.rWm) != null) && (SnsSingleTextViewUI.e(this.rWm).getText() != null)) {
        aq.s(ag.cpf().abv(SnsSingleTextViewUI.g(this.rWm)));
      }
      AppMethodBeat.o(39305);
      return;
    case 15: 
      label420:
      label429:
      if ((SnsSingleTextViewUI.e(this.rWm) != null) && (SnsSingleTextViewUI.e(this.rWm).getText() != null)) {
        aq.a(new l(null, SnsSingleTextViewUI.a(this.rWm).getSnsId(), SnsSingleTextViewUI.h(this.rWm), null, SnsSingleTextViewUI.h(this.rWm).ntu, null, 1));
      }
      AppMethodBeat.o(39305);
      return;
    }
    if ((SnsSingleTextViewUI.e(this.rWm) != null) && (SnsSingleTextViewUI.e(this.rWm).getText() != null)) {
      aq.b(new l(null, SnsSingleTextViewUI.a(this.rWm).getSnsId(), SnsSingleTextViewUI.h(this.rWm), null, SnsSingleTextViewUI.h(this.rWm).ntu, null, 1));
    }
    AppMethodBeat.o(39305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI.5
 * JD-Core Version:    0.7.0.1
 */