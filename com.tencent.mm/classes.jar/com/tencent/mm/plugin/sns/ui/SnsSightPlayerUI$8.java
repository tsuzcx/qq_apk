package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsSightPlayerUI$8
  implements View.OnClickListener
{
  SnsSightPlayerUI$8(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39257);
    if (SnsSightPlayerUI.c(this.rVT).Ex(32)) {
      k.a(k.b.ram, k.a.raf, SnsSightPlayerUI.c(this.rVT), SnsSightPlayerUI.b(this.rVT));
    }
    Intent localIntent = new Intent();
    paramView = ao.gl(ag.getAccSnsPath(), SnsSightPlayerUI.d(this.rVT).Id);
    Object localObject = i.k(SnsSightPlayerUI.d(this.rVT));
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRW, 0) > 0)
    {
      localIntent.setClass(this.rVT, SnsAdStreamVideoPlayUI.class);
      ab.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
      localIntent.putExtra("KFullVideoPath", paramView + (String)localObject);
      localIntent.putExtra("KThumbPath", SnsSightPlayerUI.e(this.rVT));
      localIntent.putExtra("KFromTimeLine", true);
      localIntent.putExtra("KStremVideoUrl", SnsSightPlayerUI.d(this.rVT).xrZ);
      if (!bo.isNullOrNil(SnsSightPlayerUI.d(this.rVT).xsc)) {
        break label683;
      }
      paramView = SnsSightPlayerUI.d(this.rVT).xrS;
      label208:
      localIntent.putExtra("KThumUrl", paramView);
      localIntent.putExtra("KMediaId", SnsSightPlayerUI.d(this.rVT).Id);
      localIntent.putExtra("KUrl", SnsSightPlayerUI.d(this.rVT).Url);
      localIntent.putExtra("KViewId", SnsSightPlayerUI.a(this.rVT).hpq);
      localObject = SnsSightPlayerUI.c(this.rVT).csh();
      if (SnsSightPlayerUI.a(this.rVT) != null) {
        break label697;
      }
      paramView = "";
      label291:
      localIntent.putExtra("KSta_StremVideoAduxInfo", paramView);
      localIntent.putExtra("KSta_StremVideoPublishId", ((TimeLineObject)localObject).Id);
      localIntent.putExtra("KSta_SourceType", 1);
      localIntent.putExtra("KSta_Scene", k.b.ram.value);
      localIntent.putExtra("KSta_FromUserName", ((TimeLineObject)localObject).jJA);
      localIntent.putExtra("KSta_SnSId", ((TimeLineObject)localObject).Id);
      localIntent.putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject).rHA);
      localIntent.putExtra("KMediaVideoTime", SnsSightPlayerUI.d(this.rVT).sdf);
      if (!bo.isNullOrNil(SnsSightPlayerUI.d(this.rVT).xsd)) {
        break label711;
      }
      paramView = ((TimeLineObject)localObject).xTP;
      label402:
      localIntent.putExtra("KMediaTitle", paramView);
      paramView = SnsSightPlayerUI.c(this.rVT).csb();
      if ((paramView != null) && (paramView.rpX == 0))
      {
        localIntent.putExtra("StreamWording", paramView.rpY);
        localIntent.putExtra("StremWebUrl", paramView.rpZ);
      }
      localObject = ag.cpf().abv(SnsSightPlayerUI.f(this.rVT));
      if (SnsSightPlayerUI.b(this.rVT) != 0) {
        break label725;
      }
      paramView = com.tencent.mm.modelsns.b.lV(747);
      label485:
      paramView.uv(i.j((n)localObject)).lY(((n)localObject).field_type).de(true).uv(((n)localObject).csP()).lY(SnsSightPlayerUI.d(this.rVT).sdf);
      paramView.ake();
      if (SnsSightPlayerUI.b(this.rVT) != 0) {
        break label735;
      }
    }
    label683:
    label697:
    label711:
    label725:
    label735:
    for (paramView = com.tencent.mm.modelsns.b.lV(748);; paramView = com.tencent.mm.modelsns.b.lW(748))
    {
      paramView.uv(i.j((n)localObject)).lY(((n)localObject).field_type).de(true).uv(((n)localObject).csP()).lY(SnsSightPlayerUI.d(this.rVT).sdf);
      paramView.b(localIntent, "intent_key_StatisticsOplog");
      this.rVT.startActivity(localIntent);
      i.a(new SnsAdClick(SnsSightPlayerUI.b(this.rVT), 5, ((n)localObject).field_snsId, 14, 0));
      if (SnsSightPlayerUI.b(this.rVT) == 0)
      {
        paramView = new rh();
        paramView.cHO.isStart = true;
        com.tencent.mm.sdk.b.a.ymk.l(paramView);
      }
      AppMethodBeat.o(39257);
      return;
      localIntent.setClass(this.rVT, VideoAdPlayerUI.class);
      break;
      paramView = SnsSightPlayerUI.d(this.rVT).xsc;
      break label208;
      paramView = SnsSightPlayerUI.a(this.rVT).cFe;
      break label291;
      paramView = SnsSightPlayerUI.d(this.rVT).xsd;
      break label402;
      paramView = com.tencent.mm.modelsns.b.lW(747);
      break label485;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.8
 * JD-Core Version:    0.7.0.1
 */