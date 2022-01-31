package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.qb;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class FlipView$4
  implements n.d
{
  FlipView$4(FlipView paramFlipView, String paramString1, String paramString2, String paramString3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject1 = af.bDF().OB(this.oOY);
    if (localObject1 == null) {
      y.i("MicroMsg.FlipView", "error beacause info null");
    }
    label1052:
    do
    {
      Object localObject2;
      do
      {
        return;
        switch (paramMenuItem.getItemId())
        {
        default: 
          return;
        case 0: 
          if (((n)localObject1).field_type != 15)
          {
            l.i(this.gBs, FlipView.e(this.oOW));
            return;
          }
          FlipView.Pb(this.oOY);
          return;
        case 1: 
          if (((n)localObject1).field_type != 15)
          {
            paramMenuItem = new Intent();
            paramMenuItem.putExtra("Retr_File_Name", this.gBs);
            paramMenuItem.putExtra("Retr_Compress_Type", 0);
            paramMenuItem.putExtra("Retr_Msg_Type", 0);
            if (localObject1 != null)
            {
              paramMenuItem.putExtra("Retr_FromMainTimeline", this.oOW.bHt());
              paramMenuItem.putExtra("Retr_KSnsId", i.j((n)localObject1));
            }
            com.tencent.mm.plugin.sns.c.a.eUR.l(paramMenuItem, FlipView.e(this.oOW));
            return;
          }
          new StringBuilder().append(an.eJ(af.getAccSnsPath(), this.BF)).append(i.e((awd)((n)localObject1).bGe().tNr.sPJ.get(0)));
          FlipView.Pc(this.oOY);
          return;
        case 2: 
          if (((n)localObject1).field_type != 15)
          {
            paramMenuItem = new cj();
            Object localObject3 = this.oOY;
            localObject2 = this.BF;
            if ((localObject2 == null) || (bk.bl((String)localObject3)))
            {
              y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
              paramMenuItem.bIw.bIC = i.j.favorite_fail_argument_error;
            }
            for (;;)
            {
              paramMenuItem.bIw.bID = 13;
              paramMenuItem.bIw.activity = ((Activity)FlipView.e(this.oOW));
              com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
              if (!this.oOW.bHt()) {
                break;
              }
              paramMenuItem = new qb();
              paramMenuItem.bZz.bRV = i.j((n)localObject1);
              paramMenuItem.bZz.bJQ = ((n)localObject1).bGE();
              com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
              return;
              if (af.bDo())
              {
                y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                paramMenuItem.bIw.bIC = i.j.favorite_fail_system_error;
              }
              else
              {
                localObject3 = af.bDF().OB((String)localObject3);
                if (localObject3 == null)
                {
                  y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                  paramMenuItem.bIw.bIC = i.j.favorite_fail_attachment_not_exists;
                }
                else
                {
                  com.tencent.mm.plugin.sns.i.a.a(paramMenuItem, (n)localObject3, (String)localObject2);
                }
              }
            }
          }
          break;
        }
      } while (localObject1 == null);
      if (!((n)localObject1).yr(32)) {
        FlipView.n(this.oOW.bHt(), ((n)localObject1).bGE());
      }
      while (this.oOW.bHt())
      {
        paramMenuItem = new qb();
        paramMenuItem.bZz.bRV = i.j((n)localObject1);
        paramMenuItem.bZz.bJQ = ((n)localObject1).bGE();
        com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
        return;
        paramMenuItem = new cj();
        com.tencent.mm.plugin.sns.i.a.a(paramMenuItem, (n)localObject1);
        paramMenuItem.bIw.bID = 14;
        paramMenuItem.bIw.activity = ((Activity)FlipView.e(this.oOW));
        com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("k_expose_msg_id", this.oOW.getSnsId());
      paramMenuItem = af.bDF().gt(this.oOW.getSnsId());
      if (paramMenuItem == null) {}
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_userName)
      {
        ((Intent)localObject1).putExtra("k_username", paramMenuItem);
        ((Intent)localObject1).putExtra("showShare", false);
        ((Intent)localObject1).putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
        ((Intent)localObject1).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
        d.b(FlipView.e(this.oOW), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        return;
      }
      y.i("MicroMsg.FlipView", "request deal QBAR string");
      paramMenuItem = new cd();
      paramMenuItem.bIi.activity = ((Activity)FlipView.e(this.oOW));
      paramMenuItem.bIi.bGE = FlipView.f(this.oOW);
      paramMenuItem.bIi.bIj = FlipView.g(this.oOW);
      paramMenuItem.bIi.bIk = FlipView.h(this.oOW);
      localObject1 = aj.a((n)localObject1, this.BF);
      if (localObject1 != null)
      {
        paramMenuItem.bIi.imagePath = ((awd)localObject1).kSC;
        paramMenuItem.bIi.bIn = ((awd)localObject1).tsg;
      }
      paramMenuItem.bIi.scene = 38;
      if ((FlipView.e(this.oOW) instanceof Activity)) {
        paramMenuItem.bIi.bIo = ((Activity)FlipView.e(this.oOW)).getIntent().getBundleExtra("_stat_obj");
      }
      if ((this.oOW instanceof SnsInfoFlip))
      {
        localObject1 = (SnsInfoFlip)this.oOW;
        localObject2 = ((SnsInfoFlip)localObject1).getFromScene();
        y.d("MicroMsg.FlipView", "from Scene: %s", new Object[] { ((az)localObject2).tag });
        if ((!((az)localObject2).tag.equals(az.uBD.tag)) && (!((az)localObject2).tag.equals(az.uBE.tag)) && (!((az)localObject2).tag.equals(az.uBF.tag))) {
          break label1052;
        }
        paramMenuItem.bIi.bIl = 5;
        if (bk.bl(((SnsInfoFlip)localObject1).username))
        {
          y.i("MicroMsg.FlipView", "empty username");
          ((SnsInfoFlip)localObject1).username = "";
        }
        paramMenuItem.bIi.aWf = ((SnsInfoFlip)localObject1).username;
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
        return;
        if (((az)localObject2).tag.equals(az.uBC.tag)) {
          paramMenuItem.bIi.bIl = 3;
        } else {
          y.i("MicroMsg.FlipView", "other scene_from: %s", new Object[] { ((az)localObject2).tag });
        }
      }
    } while (((n)localObject1).bGe().tNr.sPJ.size() == 0);
    paramMenuItem = new Intent();
    if (((n)localObject1).field_type == 1)
    {
      paramInt = this.oOW.getPosition();
      int i = ((n)localObject1).bGe().tNr.sPJ.size();
      if ((i <= 1) || (paramInt <= 1) || (paramInt > i)) {
        break label1255;
      }
      paramInt -= 1;
    }
    for (;;)
    {
      localObject1 = FlipView.g(this.gBs, FlipView.e(this.oOW));
      if (localObject1 == null) {
        break;
      }
      paramMenuItem.putExtra("sns_send_data_ui_image_path", (String)localObject1);
      paramMenuItem.putExtra("sns_send_data_ui_image_position", paramInt);
      paramMenuItem.putExtra("sns_send_data_ui_activity", true);
      paramMenuItem.putExtra("sns_local_id", this.oOY);
      d.e(FlipView.e(this.oOW), ".ui.chatting.ChattingSendDataToDeviceUI", paramMenuItem);
      return;
      label1255:
      paramInt = 0;
    }
    this.oOW.Pa(this.gBs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView.4
 * JD-Core Version:    0.7.0.1
 */