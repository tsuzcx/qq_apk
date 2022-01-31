package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sl.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class SnsOnlineVideoActivity$6
  implements n.d
{
  SnsOnlineVideoActivity$6(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(39149);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39149);
      return;
      paramMenuItem = new sl();
      paramMenuItem.cIG.cut = 2;
      paramMenuItem.cIG.cIH = 17;
      Object localObject = paramMenuItem.cIG;
      if (SnsOnlineVideoActivity.w(this.rUf) == 0) {
        bool = true;
      }
      ((sl.a)localObject).cII = bool;
      paramMenuItem.cIG.ctV = SnsOnlineVideoActivity.v(this.rUf);
      a.ymk.l(paramMenuItem);
      AppMethodBeat.o(39149);
      return;
      localObject = new Intent();
      n localn = ag.cpf().abv(SnsOnlineVideoActivity.v(this.rUf));
      if (localn != null) {
        ab.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + localn.getSnsId());
      }
      if (localn == null)
      {
        paramMenuItem = Integer.valueOf(0);
        ((Intent)localObject).putExtra("k_expose_msg_id", paramMenuItem);
        if (localn != null) {
          break label283;
        }
      }
      label283:
      for (paramMenuItem = "";; paramMenuItem = localn.field_userName)
      {
        ((Intent)localObject).putExtra("k_username", paramMenuItem);
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
        d.b(this.rUf, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        AppMethodBeat.o(39149);
        return;
        paramMenuItem = localn.getSnsId();
        break;
      }
      SnsOnlineVideoActivity.x(this.rUf);
      paramMenuItem = new sl();
      paramMenuItem.cIG.cut = 1;
      paramMenuItem.cIG.cIJ = 4097;
      paramMenuItem.cIG.ctV = SnsOnlineVideoActivity.v(this.rUf);
      a.ymk.l(paramMenuItem);
      AppMethodBeat.o(39149);
      return;
      paramMenuItem = ag.cpf().abv(SnsOnlineVideoActivity.v(this.rUf));
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(39149);
        return;
      }
      localObject = new Intent();
      if ((paramMenuItem.csh().xTS.wNZ == 15) && ((bcs)paramMenuItem.csh().xTS.wOa.get(0) == null))
      {
        ab.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
        AppMethodBeat.o(39149);
        return;
      }
      ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
      ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.v(this.rUf));
      ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
      d.f(this.rUf, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
      AppMethodBeat.o(39149);
      return;
      paramMenuItem = new sl();
      paramMenuItem.cIG.cut = 3;
      paramMenuItem.cIG.ctV = SnsOnlineVideoActivity.v(this.rUf);
      a.ymk.l(paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.6
 * JD-Core Version:    0.7.0.1
 */