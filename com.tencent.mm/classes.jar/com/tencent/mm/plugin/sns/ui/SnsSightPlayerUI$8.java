package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.px;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.bk;

final class SnsSightPlayerUI$8
  implements View.OnClickListener
{
  SnsSightPlayerUI$8(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onClick(View paramView)
  {
    if (SnsSightPlayerUI.c(this.pdk).yr(32)) {
      j.a(j.b.olY, j.a.olR, SnsSightPlayerUI.c(this.pdk), SnsSightPlayerUI.b(this.pdk));
    }
    Intent localIntent = new Intent();
    paramView = an.eJ(af.getAccSnsPath(), SnsSightPlayerUI.d(this.pdk).lsK);
    Object localObject = i.k(SnsSightPlayerUI.d(this.pdk));
    localIntent.setClass(this.pdk, VideoAdPlayerUI.class);
    localIntent.putExtra("KFullVideoPath", paramView + (String)localObject);
    localIntent.putExtra("KThumbPath", SnsSightPlayerUI.e(this.pdk));
    localIntent.putExtra("IsAd", true);
    localIntent.putExtra("KStremVideoUrl", SnsSightPlayerUI.d(this.pdk).trW);
    if (bk.bl(SnsSightPlayerUI.d(this.pdk).trZ))
    {
      paramView = SnsSightPlayerUI.d(this.pdk).trP;
      localIntent.putExtra("KThumUrl", paramView);
      localIntent.putExtra("KMediaId", SnsSightPlayerUI.d(this.pdk).lsK);
      localIntent.putExtra("KUrl", SnsSightPlayerUI.d(this.pdk).kSC);
      localIntent.putExtra("KViewId", SnsSightPlayerUI.a(this.pdk).fVM);
      localObject = SnsSightPlayerUI.c(this.pdk).bGe();
      if (SnsSightPlayerUI.a(this.pdk) != null) {
        break label645;
      }
      paramView = "";
      label259:
      localIntent.putExtra("KSta_StremVideoAduxInfo", paramView);
      localIntent.putExtra("KSta_StremVideoPublishId", ((bxk)localObject).lsK);
      localIntent.putExtra("KSta_SourceType", 1);
      localIntent.putExtra("KSta_Scene", j.b.olY.value);
      localIntent.putExtra("KSta_FromUserName", ((bxk)localObject).hPY);
      localIntent.putExtra("KSta_SnSId", ((bxk)localObject).lsK);
      localIntent.putExtra("KSta_SnsStatExtStr", ((bxk)localObject).oPO);
      localIntent.putExtra("KMediaVideoTime", SnsSightPlayerUI.d(this.pdk).pkD);
      if (!bk.bl(SnsSightPlayerUI.d(this.pdk).tsa)) {
        break label659;
      }
      paramView = ((bxk)localObject).tNo;
      label370:
      localIntent.putExtra("KMediaTitle", paramView);
      paramView = SnsSightPlayerUI.c(this.pdk).bFZ();
      if ((paramView != null) && (paramView.oAN == 0))
      {
        localIntent.putExtra("StreamWording", paramView.oAO);
        localIntent.putExtra("StremWebUrl", paramView.oAP);
      }
      localObject = af.bDF().OB(SnsSightPlayerUI.f(this.pdk));
      if (SnsSightPlayerUI.b(this.pdk) != 0) {
        break label673;
      }
      paramView = com.tencent.mm.modelsns.b.jd(747);
      label453:
      paramView.ni(i.j((n)localObject)).jg(((n)localObject).field_type).cb(true).ni(((n)localObject).bGM()).jg(SnsSightPlayerUI.d(this.pdk).pkD);
      paramView.QX();
      if (SnsSightPlayerUI.b(this.pdk) != 0) {
        break label683;
      }
    }
    label645:
    label659:
    label673:
    label683:
    for (paramView = com.tencent.mm.modelsns.b.jd(748);; paramView = com.tencent.mm.modelsns.b.je(748))
    {
      paramView.ni(i.j((n)localObject)).jg(((n)localObject).field_type).cb(true).ni(((n)localObject).bGM()).jg(SnsSightPlayerUI.d(this.pdk).pkD);
      paramView.b(localIntent, "intent_key_StatisticsOplog");
      this.pdk.startActivity(localIntent);
      i.a(new SnsAdClick(SnsSightPlayerUI.b(this.pdk), 5, ((n)localObject).field_snsId, 14, 0));
      if (SnsSightPlayerUI.b(this.pdk) == 0)
      {
        paramView = new px();
        paramView.bZw.bSr = true;
        com.tencent.mm.sdk.b.a.udP.m(paramView);
      }
      return;
      paramView = SnsSightPlayerUI.d(this.pdk).trZ;
      break;
      paramView = SnsSightPlayerUI.a(this.pdk).ovV;
      break label259;
      paramView = SnsSightPlayerUI.d(this.pdk).tsa;
      break label370;
      paramView = com.tencent.mm.modelsns.b.je(747);
      break label453;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.8
 * JD-Core Version:    0.7.0.1
 */