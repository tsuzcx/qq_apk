package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class b$2$2
  implements n.d
{
  b$2$2(b.2 param2, n paramn, String paramString1, String paramString2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    long l = 0L;
    AppMethodBeat.i(40241);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(40241);
      return;
    case 0: 
      paramMenuItem = new Intent();
      if (this.skf == null) {}
      for (;;)
      {
        paramMenuItem.putExtra("sns_permission_snsinfo_svr_id", l);
        paramMenuItem.putExtra("sns_permission_userName", this.efI);
        paramMenuItem.putExtra("sns_permission_anim", true);
        paramMenuItem.putExtra("sns_permission_block_scene", 5);
        paramMenuItem.setClass(this.ske.skd.activity, SnsPermissionUI.class);
        this.ske.skd.activity.startActivityForResult(paramMenuItem, 11);
        AppMethodBeat.o(40241);
        return;
        l = this.skf.field_snsId;
      }
    }
    Intent localIntent = new Intent();
    paramMenuItem = ag.cpf().abv(this.skg);
    if (paramMenuItem == null)
    {
      ab.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.skg);
      AppMethodBeat.o(40241);
      return;
    }
    ab.i("MicroMsg.TimelineClickListener", "expose id " + paramMenuItem.getSnsId() + " " + paramMenuItem.field_userName);
    if (paramMenuItem == null)
    {
      label236:
      localIntent.putExtra("k_expose_msg_id", l);
      if (paramMenuItem != null) {
        break label325;
      }
    }
    label325:
    for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_userName)
    {
      localIntent.putExtra("k_username", paramMenuItem);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
      d.b(this.ske.skd.activity, "webview", ".ui.tools.WebViewUI", localIntent);
      break;
      l = paramMenuItem.field_snsId;
      break label236;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.2.2
 * JD-Core Version:    0.7.0.1
 */