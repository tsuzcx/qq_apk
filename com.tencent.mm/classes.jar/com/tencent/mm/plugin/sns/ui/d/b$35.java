package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$35
  implements View.OnClickListener
{
  b$35(b paramb) {}
  
  public final void onClick(View paramView)
  {
    int i = 2;
    if (!(paramView.getTag() instanceof String)) {}
    n localn;
    do
    {
      return;
      paramView = (String)paramView.getTag();
      localn = af.bDF().OB(paramView);
    } while (localn == null);
    if (localn.yr(32))
    {
      y.i("MicroMsg.TimelineClickListener", "click the ad poi button");
      localObject1 = b.a(this.ppl, localn);
      if (localObject1 == null)
      {
        y.e("MicroMsg.TimelineClickListener", "the adInfo is null");
        return;
      }
      int j = this.ppl.source;
      if (this.ppl.source == 0) {
        i = 1;
      }
      localObject2 = new SnsAdClick(j, i, localn.field_snsId, 19, 0);
      i.a((SnsAdClick)localObject2);
      if (bk.bl(((com.tencent.mm.plugin.sns.storage.a)localObject1).oAe))
      {
        y.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
        return;
      }
      if (this.ppl.source == 0) {}
      for (paramView = com.tencent.mm.modelsns.b.jd(724);; paramView = com.tencent.mm.modelsns.b.je(724))
      {
        paramView.ni(i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni("").ni("").ni("").ni("").ni(((com.tencent.mm.plugin.sns.storage.a)localObject1).oAd).ni("").ni("");
        paramView.QX();
        y.i("MicroMsg.TimelineClickListener", "open webview url : " + ((com.tencent.mm.plugin.sns.storage.a)localObject1).oAe);
        paramView = new Intent();
        if ((localn != null) && (localn.yr(32)))
        {
          localObject3 = b.a(this.ppl, localn);
          if (localObject3 != null) {
            paramView.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject3).fVM);
          }
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putParcelable("KSnsAdTag", (Parcelable)localObject2);
        paramView.putExtra("jsapiargs", (Bundle)localObject3);
        paramView.putExtra("useJs", true);
        paramView.putExtra("KPublisherId", "sns_" + i.fN(localn.field_snsId));
        paramView.putExtra("pre_username", localn.field_userName);
        paramView.putExtra("prePublishId", "sns_" + i.fN(localn.field_snsId));
        paramView.putExtra("preUsername", localn.field_userName);
        paramView.putExtra("rawUrl", ((com.tencent.mm.plugin.sns.storage.a)localObject1).oAe);
        com.tencent.mm.plugin.sns.c.a.eUR.j(paramView, this.ppl.activity);
        return;
      }
    }
    Object localObject2 = localn.bGe();
    Object localObject3 = ((bxk)localObject2).tNp;
    Object localObject1 = new Intent();
    if (this.ppl.source == 0) {}
    for (paramView = com.tencent.mm.modelsns.b.jd(724);; paramView = com.tencent.mm.modelsns.b.je(724))
    {
      paramView.ni(i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(((aui)localObject3).tpQ).jg(((aui)localObject3).oQu).ni(((aui)localObject3).sGK).ni(((aui)localObject3).sGJ).ni(((aui)localObject3).lFn).ni(((aui)localObject3).oQs).ni(((aui)localObject3).ffj);
      paramView.QX();
      if (!bk.bl(((aui)localObject3).tpQ)) {
        break;
      }
      ((Intent)localObject1).putExtra("map_view_type", 7);
      ((Intent)localObject1).putExtra("kwebmap_slat", ((aui)localObject3).sGK);
      ((Intent)localObject1).putExtra("kwebmap_lng", ((aui)localObject3).sGJ);
      ((Intent)localObject1).putExtra("kPoiName", ((aui)localObject3).lFn);
      ((Intent)localObject1).putExtra("Kwebmap_locaion", ((aui)localObject3).oQs);
      d.b(this.ppl.activity, "location", ".ui.RedirectUI", (Intent)localObject1);
      return;
    }
    if (this.ppl.pph == 0) {}
    for (paramView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[] { ((aui)localObject3).tpQ });; paramView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[] { ((aui)localObject3).tpQ, ((bxk)localObject2).lsK }))
    {
      ((Intent)localObject1).putExtra("rawUrl", paramView);
      com.tencent.mm.plugin.sns.c.a.eUR.j((Intent)localObject1, this.ppl.activity);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.35
 * JD-Core Version:    0.7.0.1
 */