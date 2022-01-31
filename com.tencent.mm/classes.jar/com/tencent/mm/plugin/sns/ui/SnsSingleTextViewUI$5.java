package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class SnsSingleTextViewUI$5
  implements n.d
{
  SnsSingleTextViewUI$5(SnsSingleTextViewUI paramSnsSingleTextViewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    label396:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while ((SnsSingleTextViewUI.c(this.pdz) == null) || (SnsSingleTextViewUI.c(this.pdz).getText() == null));
              SnsSingleTextViewUI.d(this.pdz).setText(SnsSingleTextViewUI.c(this.pdz).getText());
              h.bC(this.pdz.mController.uMN, this.pdz.mController.uMN.getString(i.j.app_copy_ok));
            } while (SnsSingleTextViewUI.a(this.pdz) == null);
            paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.nQo;
            com.tencent.mm.plugin.secinforeport.a.a.f(2, bk.hu(SnsSingleTextViewUI.a(this.pdz).field_snsId), bk.ZH(SnsSingleTextViewUI.c(this.pdz).getText().toString()));
            return;
          } while ((SnsSingleTextViewUI.c(this.pdz) == null) || (SnsSingleTextViewUI.c(this.pdz).getText() == null));
          paramMenuItem = new cj();
          com.tencent.mm.plugin.sns.i.a.a(paramMenuItem, SnsSingleTextViewUI.e(this.pdz), SnsSingleTextViewUI.c(this.pdz).getText());
          paramMenuItem.bIw.activity = this.pdz;
          paramMenuItem.bIw.bID = 18;
          com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
          return;
        } while ((SnsSingleTextViewUI.c(this.pdz) == null) || (SnsSingleTextViewUI.c(this.pdz).getText() == null));
        Intent localIntent = new Intent();
        n localn = af.bDF().OB(SnsSingleTextViewUI.e(this.pdz));
        if (localn == null)
        {
          paramMenuItem = "";
          localIntent.putExtra("k_username", paramMenuItem);
          if (localn != null) {
            break label396;
          }
        }
        for (paramMenuItem = Integer.valueOf(0);; paramMenuItem = localn.bGk())
        {
          localIntent.putExtra("k_expose_msg_id", paramMenuItem);
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
          d.b(this.pdz, "webview", ".ui.tools.WebViewUI", localIntent);
          return;
          paramMenuItem = localn.field_userName;
          break;
        }
      } while ((SnsSingleTextViewUI.c(this.pdz) == null) || (SnsSingleTextViewUI.c(this.pdz).getText() == null));
      ap.r(af.bDF().OB(SnsSingleTextViewUI.e(this.pdz)));
      return;
    } while ((SnsSingleTextViewUI.c(this.pdz) == null) || (SnsSingleTextViewUI.c(this.pdz).getText() == null));
    ap.s(af.bDF().OB(SnsSingleTextViewUI.e(this.pdz)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI.5
 * JD-Core Version:    0.7.0.1
 */