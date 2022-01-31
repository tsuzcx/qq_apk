package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.c;
import com.tencent.mm.plugin.sns.a.b.k.d;
import com.tencent.mm.plugin.sns.a.b.k.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class SnsSightPlayerUI$6
  implements n.d
{
  SnsSightPlayerUI$6(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(39254);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39254);
      return;
      paramMenuItem = ag.cpf().abv(SnsSightPlayerUI.f(this.rVT));
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(39254);
        return;
      }
      Object localObject = new cm();
      com.tencent.mm.plugin.sns.j.a.a((cm)localObject, paramMenuItem);
      ((cm)localObject).cpR.activity = this.rVT;
      ((cm)localObject).cpR.cpY = 17;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      if (SnsSightPlayerUI.j(this.rVT))
      {
        i.a(new SnsAdClick(SnsSightPlayerUI.b(this.rVT), 5, paramMenuItem.field_snsId, 11, 0));
        k.a(k.d.rax, k.c.ras, k.e.raE, 0, paramMenuItem, SnsSightPlayerUI.b(this.rVT));
      }
      if (SnsSightPlayerUI.b(this.rVT) == 0)
      {
        localObject = new rl();
        ((rl)localObject).cHR.crk = paramMenuItem.csH();
        ((rl)localObject).cHR.czw = i.j(paramMenuItem);
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      }
      AppMethodBeat.o(39254);
      return;
      localObject = new Intent();
      n localn = ag.cpf().abv(SnsSightPlayerUI.f(this.rVT));
      if (localn != null) {
        ab.i("MicroMsg.SnsSightPlayerUI", "expose id " + localn.getSnsId());
      }
      if (localn == null)
      {
        paramMenuItem = Integer.valueOf(0);
        ((Intent)localObject).putExtra("k_expose_msg_id", paramMenuItem);
        if (localn != null) {
          break label368;
        }
      }
      label368:
      for (paramMenuItem = "";; paramMenuItem = localn.field_userName)
      {
        ((Intent)localObject).putExtra("k_username", paramMenuItem);
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
        d.b(this.rVT, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        AppMethodBeat.o(39254);
        return;
        paramMenuItem = localn.getSnsId();
        break;
      }
      SnsSightPlayerUI.v(this.rVT);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("select_is_ret", true);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("image_path", SnsSightPlayerUI.e(this.rVT));
      paramMenuItem.putExtra("Retr_Msg_Type", 11);
      d.b(this.rVT, ".ui.transmit.SelectConversationUI", paramMenuItem, 4097);
      AppMethodBeat.o(39254);
      return;
      paramMenuItem = ag.cpf().abv(SnsSightPlayerUI.f(this.rVT));
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(39254);
        return;
      }
      localObject = new Intent();
      if ((paramMenuItem.csh().xTS.wNZ == 15) && ((bcs)paramMenuItem.csh().xTS.wOa.get(0) == null))
      {
        ab.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
        AppMethodBeat.o(39254);
        return;
      }
      ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
      ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(this.rVT));
      ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
      d.f(this.rVT, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.6
 * JD-Core Version:    0.7.0.1
 */