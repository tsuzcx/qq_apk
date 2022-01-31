package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class b$2$2
  implements n.d
{
  b$2$2(b.2 param2, n paramn, String paramString1, String paramString2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    long l = 0L;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      paramMenuItem = new Intent();
      if (this.ppn == null) {}
      for (;;)
      {
        paramMenuItem.putExtra("sns_permission_snsinfo_svr_id", l);
        paramMenuItem.putExtra("sns_permission_userName", this.dol);
        paramMenuItem.putExtra("sns_permission_anim", true);
        paramMenuItem.putExtra("sns_permission_block_scene", 5);
        paramMenuItem.setClass(this.ppm.ppl.activity, SnsPermissionUI.class);
        this.ppm.ppl.activity.startActivityForResult(paramMenuItem, 11);
        return;
        l = this.ppn.field_snsId;
      }
    }
    Intent localIntent = new Intent();
    paramMenuItem = af.bDF().OB(this.ppo);
    if (paramMenuItem == null)
    {
      y.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.ppo);
      return;
    }
    y.i("MicroMsg.TimelineClickListener", "expose id " + paramMenuItem.bGk() + " " + paramMenuItem.field_userName);
    if (paramMenuItem == null)
    {
      localIntent.putExtra("k_expose_msg_id", l);
      if (paramMenuItem != null) {
        break label304;
      }
    }
    label304:
    for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_userName)
    {
      localIntent.putExtra("k_username", paramMenuItem);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
      d.b(this.ppm.ppl.activity, "webview", ".ui.tools.WebViewUI", localIntent);
      return;
      l = paramMenuItem.field_snsId;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.2.2
 * JD-Core Version:    0.7.0.1
 */