package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class FlipView$4
  implements n.d
{
  FlipView$4(FlipView paramFlipView, String paramString1, String paramString2, String paramString3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(38229);
    Object localObject1 = ag.cpf().abv(this.nlv);
    if (localObject1 == null)
    {
      ab.i("MicroMsg.FlipView", "error beacause info null");
      AppMethodBeat.o(38229);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38229);
      return;
      if (((com.tencent.mm.plugin.sns.storage.n)localObject1).field_type != 15)
      {
        com.tencent.mm.pluginsdk.ui.tools.n.k(this.hZn, FlipView.f(this.rGJ));
        AppMethodBeat.o(38229);
        return;
      }
      FlipView.abV(this.nlv);
      AppMethodBeat.o(38229);
      return;
      if (((com.tencent.mm.plugin.sns.storage.n)localObject1).field_type != 15)
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_File_Name", this.hZn);
        paramMenuItem.putExtra("Retr_Compress_Type", 0);
        paramMenuItem.putExtra("Retr_Msg_Type", 0);
        if (localObject1 != null)
        {
          paramMenuItem.putExtra("Retr_FromMainTimeline", this.rGJ.cty());
          paramMenuItem.putExtra("Retr_KSnsId", i.j((com.tencent.mm.plugin.sns.storage.n)localObject1));
        }
        com.tencent.mm.plugin.sns.c.a.gmO.k(paramMenuItem, FlipView.f(this.rGJ));
        AppMethodBeat.o(38229);
        return;
      }
      new StringBuilder().append(ao.gl(ag.getAccSnsPath(), this.Cq)).append(i.e((bcs)((com.tencent.mm.plugin.sns.storage.n)localObject1).csh().xTS.wOa.get(0)));
      FlipView.abW(this.nlv);
      AppMethodBeat.o(38229);
      return;
      if (((com.tencent.mm.plugin.sns.storage.n)localObject1).field_type != 15)
      {
        paramMenuItem = new cm();
        Object localObject2 = this.nlv;
        String str = this.Cq;
        if ((str == null) || (bo.isNullOrNil((String)localObject2)))
        {
          ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
          paramMenuItem.cpR.cpX = 2131299713;
        }
        for (;;)
        {
          paramMenuItem.cpR.cpY = 13;
          paramMenuItem.cpR.activity = ((Activity)FlipView.f(this.rGJ));
          com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
          if (this.rGJ.cty())
          {
            paramMenuItem = new rl();
            paramMenuItem.cHR.czw = i.j((com.tencent.mm.plugin.sns.storage.n)localObject1);
            paramMenuItem.cHR.crk = ((com.tencent.mm.plugin.sns.storage.n)localObject1).csH();
            com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
          }
          AppMethodBeat.o(38229);
          return;
          if (ag.coN())
          {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            paramMenuItem.cpR.cpX = 2131299731;
          }
          else
          {
            localObject2 = ag.cpf().abv((String)localObject2);
            if (localObject2 == null)
            {
              ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
              paramMenuItem.cpR.cpX = 2131299714;
            }
            else
            {
              com.tencent.mm.plugin.sns.j.a.a(paramMenuItem, (com.tencent.mm.plugin.sns.storage.n)localObject2, str);
            }
          }
        }
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(38229);
        return;
      }
      if (!((com.tencent.mm.plugin.sns.storage.n)localObject1).Ex(32)) {
        FlipView.t(this.rGJ.cty(), ((com.tencent.mm.plugin.sns.storage.n)localObject1).csH());
      }
      for (;;)
      {
        if (this.rGJ.cty())
        {
          paramMenuItem = new rl();
          paramMenuItem.cHR.czw = i.j((com.tencent.mm.plugin.sns.storage.n)localObject1);
          paramMenuItem.cHR.crk = ((com.tencent.mm.plugin.sns.storage.n)localObject1).csH();
          com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
        }
        AppMethodBeat.o(38229);
        return;
        paramMenuItem = new cm();
        com.tencent.mm.plugin.sns.j.a.a(paramMenuItem, (com.tencent.mm.plugin.sns.storage.n)localObject1);
        paramMenuItem.cpR.cpY = 14;
        paramMenuItem.cpR.activity = ((Activity)FlipView.f(this.rGJ));
        com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("k_expose_msg_id", this.rGJ.getSnsId());
      paramMenuItem = ag.cpf().lZ(this.rGJ.getSnsId());
      if (paramMenuItem == null) {}
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_userName)
      {
        ((Intent)localObject1).putExtra("k_username", paramMenuItem);
        ((Intent)localObject1).putExtra("showShare", false);
        ((Intent)localObject1).putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
        ((Intent)localObject1).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
        d.b(FlipView.f(this.rGJ), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        AppMethodBeat.o(38229);
        return;
      }
      if (((com.tencent.mm.plugin.sns.storage.n)localObject1).csh().xTS.wOa.size() == 0)
      {
        AppMethodBeat.o(38229);
        return;
      }
      paramMenuItem = new Intent();
      if (((com.tencent.mm.plugin.sns.storage.n)localObject1).field_type == 1)
      {
        paramInt = this.rGJ.getPosition();
        int i = ((com.tencent.mm.plugin.sns.storage.n)localObject1).csh().xTS.wOa.size();
        if ((i > 1) && (paramInt > 1) && (paramInt <= i)) {
          paramInt -= 1;
        }
        for (;;)
        {
          localObject1 = FlipView.h(this.hZn, FlipView.f(this.rGJ));
          if (localObject1 != null) {
            break;
          }
          AppMethodBeat.o(38229);
          return;
          paramInt = 0;
        }
        paramMenuItem.putExtra("sns_send_data_ui_image_path", (String)localObject1);
        paramMenuItem.putExtra("sns_send_data_ui_image_position", paramInt);
      }
      paramMenuItem.putExtra("sns_send_data_ui_activity", true);
      paramMenuItem.putExtra("sns_local_id", this.nlv);
      d.f(FlipView.f(this.rGJ), ".ui.chatting.ChattingSendDataToDeviceUI", paramMenuItem);
      AppMethodBeat.o(38229);
      return;
      this.rGJ.abU(this.hZn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView.4
 * JD-Core Version:    0.7.0.1
 */