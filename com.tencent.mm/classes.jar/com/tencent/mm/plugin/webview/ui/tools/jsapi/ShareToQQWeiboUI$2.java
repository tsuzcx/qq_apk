package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class ShareToQQWeiboUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShareToQQWeiboUI$2(ShareToQQWeiboUI paramShareToQQWeiboUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new w(this.rBc.getIntent().getIntExtra("type", 0), this.rBc.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.a(this.rBc).getText().toString());
    au.Dk().a(paramMenuItem, 0);
    ShareToQQWeiboUI localShareToQQWeiboUI = this.rBc;
    AppCompatActivity localAppCompatActivity = this.rBc.mController.uMN;
    this.rBc.getString(R.l.app_tip);
    ShareToQQWeiboUI.a(localShareToQQWeiboUI, h.b(localAppCompatActivity, this.rBc.getString(R.l.main_sending), true, new ShareToQQWeiboUI.2.1(this, paramMenuItem)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI.2
 * JD-Core Version:    0.7.0.1
 */