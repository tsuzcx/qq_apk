package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.qb;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.a.b.j.d;
import com.tencent.mm.plugin.sns.a.b.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class SnsSightPlayerUI$6
  implements n.d
{
  SnsSightPlayerUI$6(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    label343:
    do
    {
      do
      {
        do
        {
          return;
          paramMenuItem = af.bDF().OB(SnsSightPlayerUI.f(this.pdk));
        } while (paramMenuItem == null);
        localObject = new cj();
        com.tencent.mm.plugin.sns.i.a.a((cj)localObject, paramMenuItem);
        ((cj)localObject).bIw.activity = this.pdk;
        ((cj)localObject).bIw.bID = 17;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject);
        if (SnsSightPlayerUI.j(this.pdk))
        {
          i.a(new SnsAdClick(SnsSightPlayerUI.b(this.pdk), 5, paramMenuItem.field_snsId, 11, 0));
          j.a(j.d.omj, j.c.ome, j.e.omq, 0, paramMenuItem, SnsSightPlayerUI.b(this.pdk));
        }
      } while (SnsSightPlayerUI.b(this.pdk) != 0);
      localObject = new qb();
      ((qb)localObject).bZz.bJQ = paramMenuItem.bGE();
      ((qb)localObject).bZz.bRV = i.j(paramMenuItem);
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      return;
      localObject = new Intent();
      n localn = af.bDF().OB(SnsSightPlayerUI.f(this.pdk));
      if (localn != null) {
        y.i("MicroMsg.SnsSightPlayerUI", "expose id " + localn.bGk());
      }
      if (localn == null)
      {
        paramMenuItem = Integer.valueOf(0);
        ((Intent)localObject).putExtra("k_expose_msg_id", paramMenuItem);
        if (localn != null) {
          break label343;
        }
      }
      for (paramMenuItem = "";; paramMenuItem = localn.field_userName)
      {
        ((Intent)localObject).putExtra("k_username", paramMenuItem);
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
        d.b(this.pdk, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        return;
        paramMenuItem = localn.bGk();
        break;
      }
      SnsSightPlayerUI.v(this.pdk);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("select_is_ret", true);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("image_path", SnsSightPlayerUI.e(this.pdk));
      paramMenuItem.putExtra("Retr_Msg_Type", 11);
      d.c(this.pdk, ".ui.transmit.SelectConversationUI", paramMenuItem, 4097);
      return;
      paramMenuItem = af.bDF().OB(SnsSightPlayerUI.f(this.pdk));
    } while (paramMenuItem == null);
    Object localObject = new Intent();
    if ((paramMenuItem.bGe().tNr.sPI == 15) && ((awd)paramMenuItem.bGe().tNr.sPJ.get(0) == null))
    {
      y.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
      return;
    }
    ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
    ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(this.pdk));
    ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
    d.e(this.pdk, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.6
 * JD-Core Version:    0.7.0.1
 */