package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$35
  implements View.OnClickListener
{
  b$35(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40297);
    if (!(paramView.getTag() instanceof String))
    {
      AppMethodBeat.o(40297);
      return;
    }
    paramView = (String)paramView.getTag();
    com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().abv(paramView);
    if (localn == null)
    {
      AppMethodBeat.o(40297);
      return;
    }
    if (localn.Ex(32))
    {
      ab.i("MicroMsg.TimelineClickListener", "click the ad poi button");
      localObject1 = b.a(this.skd, localn);
      if (localObject1 == null)
      {
        ab.e("MicroMsg.TimelineClickListener", "the adInfo is null");
        AppMethodBeat.o(40297);
        return;
      }
      int j = this.skd.cpt;
      int i;
      if (this.skd.cpt == 0)
      {
        i = 1;
        localObject2 = new SnsAdClick(j, i, localn.field_snsId, 19, 0);
        if (this.skd.rOU != null) {
          break label188;
        }
      }
      label188:
      for (long l = 0L;; l = this.skd.rOU.di(localn.csH(), 19))
      {
        ((SnsAdClick)localObject2).fQA = l;
        i.a((SnsAdClick)localObject2);
        if (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject1).rpo)) {
          break label210;
        }
        ab.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
        AppMethodBeat.o(40297);
        return;
        i = 2;
        break;
      }
      label210:
      if (this.skd.cpt == 0) {}
      for (paramView = com.tencent.mm.modelsns.b.lV(724);; paramView = com.tencent.mm.modelsns.b.lW(724))
      {
        paramView.uv(i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv("").uv("").uv("").uv("").uv(((com.tencent.mm.plugin.sns.storage.a)localObject1).rpn).uv("").uv("");
        paramView.ake();
        ab.i("MicroMsg.TimelineClickListener", "open webview url : " + ((com.tencent.mm.plugin.sns.storage.a)localObject1).rpo);
        paramView = new Intent();
        if ((localn != null) && (localn.Ex(32)))
        {
          localObject3 = b.a(this.skd, localn);
          if (localObject3 != null) {
            paramView.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject3).hpq);
          }
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putParcelable("KSnsAdTag", (Parcelable)localObject2);
        paramView.putExtra("jsapiargs", (Bundle)localObject3);
        paramView.putExtra("useJs", true);
        paramView.putExtra("KPublisherId", "sns_" + i.lq(localn.field_snsId));
        paramView.putExtra("pre_username", localn.field_userName);
        paramView.putExtra("prePublishId", "sns_" + i.lq(localn.field_snsId));
        paramView.putExtra("preUsername", localn.field_userName);
        paramView.putExtra("rawUrl", i.gg(((com.tencent.mm.plugin.sns.storage.a)localObject1).rpo, ((com.tencent.mm.plugin.sns.storage.a)localObject1).cFe));
        com.tencent.mm.plugin.sns.c.a.gmO.i(paramView, this.skd.activity);
        AppMethodBeat.o(40297);
        return;
      }
    }
    Object localObject2 = localn.csh();
    Object localObject3 = ((TimeLineObject)localObject2).xTQ;
    Object localObject1 = new Intent();
    if (this.skd.cpt == 0) {}
    for (paramView = com.tencent.mm.modelsns.b.lV(724);; paramView = com.tencent.mm.modelsns.b.lW(724))
    {
      paramView.uv(i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(((bap)localObject3).xpN).lY(((bap)localObject3).rIg).uv(((bap)localObject3).wDi).uv(((bap)localObject3).wDh).uv(((bap)localObject3).eSM).uv(((bap)localObject3).rIe).uv(((bap)localObject3).gwR);
      paramView.ake();
      if (!bo.isNullOrNil(((bap)localObject3).xpN)) {
        break;
      }
      ((Intent)localObject1).putExtra("map_view_type", 7);
      ((Intent)localObject1).putExtra("kwebmap_slat", ((bap)localObject3).wDi);
      ((Intent)localObject1).putExtra("kwebmap_lng", ((bap)localObject3).wDh);
      ((Intent)localObject1).putExtra("kPoiName", ((bap)localObject3).eSM);
      ((Intent)localObject1).putExtra("Kwebmap_locaion", ((bap)localObject3).rIe);
      d.b(this.skd.activity, "location", ".ui.RedirectUI", (Intent)localObject1);
      AppMethodBeat.o(40297);
      return;
    }
    if (this.skd.sjZ == 0) {}
    for (paramView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[] { ((bap)localObject3).xpN });; paramView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[] { ((bap)localObject3).xpN, ((TimeLineObject)localObject2).Id }))
    {
      ((Intent)localObject1).putExtra("rawUrl", paramView);
      com.tencent.mm.plugin.sns.c.a.gmO.i((Intent)localObject1, this.skd.activity);
      AppMethodBeat.o(40297);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.35
 * JD-Core Version:    0.7.0.1
 */