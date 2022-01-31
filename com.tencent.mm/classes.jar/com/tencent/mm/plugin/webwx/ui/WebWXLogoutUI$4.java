package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webwx.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;

final class WebWXLogoutUI$4
  implements View.OnClickListener
{
  WebWXLogoutUI$4(WebWXLogoutUI paramWebWXLogoutUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("Chat_User", "filehelper");
    paramView.putExtra("key_show_bottom_app_panel", true);
    a.eUR.e(paramView, this.rEh);
    y.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
    this.rEh.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.4
 * JD-Core Version:    0.7.0.1
 */