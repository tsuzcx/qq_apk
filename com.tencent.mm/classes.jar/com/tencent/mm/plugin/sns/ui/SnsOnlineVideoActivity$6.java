package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.qz;
import com.tencent.mm.h.a.qz.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class SnsOnlineVideoActivity$6
  implements n.d
{
  SnsOnlineVideoActivity$6(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    boolean bool = false;
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 2: 
    case 1: 
    case 3: 
    case 4: 
      label264:
      do
      {
        return;
        paramMenuItem = new qz();
        paramMenuItem.cag.bNb = 2;
        paramMenuItem.cag.cah = 17;
        localObject = paramMenuItem.cag;
        if (SnsOnlineVideoActivity.u(this.pbr) == 0) {
          bool = true;
        }
        ((qz.a)localObject).cai = bool;
        paramMenuItem.cag.bMB = SnsOnlineVideoActivity.t(this.pbr);
        a.udP.m(paramMenuItem);
        return;
        localObject = new Intent();
        n localn = af.bDF().OB(SnsOnlineVideoActivity.t(this.pbr));
        if (localn != null) {
          y.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + localn.bGk());
        }
        if (localn == null)
        {
          paramMenuItem = Integer.valueOf(0);
          ((Intent)localObject).putExtra("k_expose_msg_id", paramMenuItem);
          if (localn != null) {
            break label264;
          }
        }
        for (paramMenuItem = "";; paramMenuItem = localn.field_userName)
        {
          ((Intent)localObject).putExtra("k_username", paramMenuItem);
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
          d.b(this.pbr, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          return;
          paramMenuItem = localn.bGk();
          break;
        }
        SnsOnlineVideoActivity.v(this.pbr);
        paramMenuItem = new qz();
        paramMenuItem.cag.bNb = 1;
        paramMenuItem.cag.caj = 4097;
        paramMenuItem.cag.bMB = SnsOnlineVideoActivity.t(this.pbr);
        a.udP.m(paramMenuItem);
        return;
        paramMenuItem = af.bDF().OB(SnsOnlineVideoActivity.t(this.pbr));
      } while (paramMenuItem == null);
      Object localObject = new Intent();
      if ((paramMenuItem.bGe().tNr.sPI == 15) && ((awd)paramMenuItem.bGe().tNr.sPJ.get(0) == null))
      {
        y.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
        return;
      }
      ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
      ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.t(this.pbr));
      ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
      d.e(this.pbr, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
      return;
    }
    paramMenuItem = new qz();
    paramMenuItem.cag.bNb = 3;
    paramMenuItem.cag.bMB = SnsOnlineVideoActivity.t(this.pbr);
    a.udP.m(paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.6
 * JD-Core Version:    0.7.0.1
 */