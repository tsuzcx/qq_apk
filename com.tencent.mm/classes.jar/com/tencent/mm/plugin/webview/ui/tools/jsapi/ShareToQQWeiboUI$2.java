package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.ui.base.h;

final class ShareToQQWeiboUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShareToQQWeiboUI$2(ShareToQQWeiboUI paramShareToQQWeiboUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(9842);
    paramMenuItem = new x(this.vsf.getIntent().getIntExtra("type", 0), this.vsf.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.a(this.vsf).getText().toString());
    g.Rc().a(paramMenuItem, 0);
    ShareToQQWeiboUI localShareToQQWeiboUI = this.vsf;
    AppCompatActivity localAppCompatActivity = this.vsf.getContext();
    this.vsf.getString(2131297087);
    ShareToQQWeiboUI.a(localShareToQQWeiboUI, h.b(localAppCompatActivity, this.vsf.getString(2131306038), true, new ShareToQQWeiboUI.2.1(this, paramMenuItem)));
    AppMethodBeat.o(9842);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI.2
 * JD-Core Version:    0.7.0.1
 */