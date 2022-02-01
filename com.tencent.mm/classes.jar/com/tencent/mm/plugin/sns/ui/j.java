package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public class j
  implements q.a
{
  private ai Epj;
  Activity activity;
  public int source = 0;
  
  public j(Activity paramActivity, int paramInt, ai paramai)
  {
    this.activity = paramActivity;
    this.source = paramInt;
    this.Epj = paramai;
  }
  
  private ADInfo g(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97834);
    if (paramSnsInfo != null)
    {
      if (this.source == 2)
      {
        paramSnsInfo = paramSnsInfo.getAtAdInfo();
        AppMethodBeat.o(97834);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdInfo();
      AppMethodBeat.o(97834);
      return paramSnsInfo;
    }
    AppMethodBeat.o(97834);
    return null;
  }
  
  public void b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(97835);
    Object localObject1 = new Intent();
    if (this.activity == null)
    {
      AppMethodBeat.o(97835);
      return;
    }
    label152:
    label168:
    label214:
    label761:
    long l;
    if ((paramObject instanceof com.tencent.mm.plugin.sns.data.b))
    {
      com.tencent.mm.plugin.sns.data.b localb = (com.tencent.mm.plugin.sns.data.b)paramObject;
      paramObject = new StringBuilder("onClick : ").append(localb.userName).append(" activity: ");
      SnsInfo localSnsInfo;
      String str;
      int j;
      Object localObject2;
      if (this.activity == null)
      {
        bool = true;
        Log.d("Micro.ClickableCallBack", bool + ", source=" + this.source);
        localSnsInfo = aj.faO().aQm(localb.dJX);
        if (!localb.isAd) {
          break label684;
        }
        localObject3 = localSnsInfo.getAdXml();
        str = g(localSnsInfo).viewId;
        if (localb.jkU <= 0) {
          break label410;
        }
        i = localb.jkU;
        int k = this.source;
        if (this.source != 0) {
          break label415;
        }
        j = 1;
        localObject2 = new SnsAdClick(k, j, localSnsInfo.getAdSnsInfo().field_snsId, i, 0);
        paramObject = null;
        if (!(this.activity instanceof SnsTimeLineUI)) {
          break label421;
        }
        paramObject = ((SnsTimeLineUI)this.activity).fjf();
        com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, paramObject, localSnsInfo, i);
        if (localObject3 == null) {
          break label548;
        }
        if ((((ADXml)localObject3).headClickType != 1) || (Util.isNullOrNil(((ADXml)localObject3).headClickParam))) {
          break label451;
        }
        paramObject = ((ADXml)localObject3).headClickParam;
        localObject1 = g(localSnsInfo);
        paramView = paramObject;
        if (localObject1 != null) {
          paramView = r.kb(paramObject, ((ADInfo)localObject1).uxInfo);
        }
        Log.i("Micro.ClickableCallBack", "headClickParam url " + paramView + " " + ((ADXml)localObject3).headClickRightBarShow);
        paramObject = new Intent();
        if (((ADXml)localObject3).headClickRightBarShow != 0) {
          break label445;
        }
      }
      label410:
      label415:
      label421:
      label445:
      for (boolean bool = true;; bool = false)
      {
        paramObject.putExtra("KsnsViewId", str);
        paramObject.putExtra("KRightBtn", bool);
        paramObject.putExtra("jsapiargs", new Bundle());
        paramObject.putExtra("rawUrl", paramView);
        paramObject.putExtra("useJs", true);
        com.tencent.mm.plugin.sns.c.a.jRt.i(paramObject, this.activity);
        r.a((SnsAdClick)localObject2);
        AppMethodBeat.o(97835);
        return;
        bool = false;
        break;
        i = 2;
        break label152;
        j = 2;
        break label168;
        if (!(this.activity instanceof SnsCommentDetailUI)) {
          break label214;
        }
        paramObject = ((SnsCommentDetailUI)this.activity).EBv;
        break label214;
      }
      label451:
      if (h.b(this.activity, (ADXml)localObject3, g(localSnsInfo), localSnsInfo.field_snsId))
      {
        com.tencent.mm.plugin.sns.ad.i.j.a((SnsAdClick)localObject2, 41);
        r.a((SnsAdClick)localObject2);
        AppMethodBeat.o(97835);
        return;
      }
      paramObject = new d();
      paramObject.put("ext_sns_ad_click", localObject2);
      Object localObject3 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(1, this.activity);
      if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject3).a(paramView, this.source, localSnsInfo, paramObject)))
      {
        AppMethodBeat.o(97835);
        return;
      }
      label548:
      this.Epj.fat().e(localSnsInfo, false);
      if (localb.userName.endsWith("@ad"))
      {
        AppMethodBeat.o(97835);
        return;
      }
      com.tencent.mm.plugin.sns.ad.i.j.a((SnsAdClick)localObject2, 40);
      r.a((SnsAdClick)localObject2);
      ((Intent)localObject1).putExtra("Contact_User", localb.userName);
      ((Intent)localObject1).putExtra("KSnsAdTag", (Parcelable)localObject2);
      ((Intent)localObject1).putExtra("Contact_Scene", 79);
      if (this.source == 0) {}
      for (int i = 6;; i = 1)
      {
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", i);
        com.tencent.mm.plugin.sns.c.a.jRt.c((Intent)localObject1, this.activity);
        Log.i("Micro.ClickableCallBack", "startContactInfo, addScene=79");
        AppMethodBeat.o(97835);
        return;
      }
      label684:
      paramObject = localb.userName;
      if (this.source == 0)
      {
        paramView = com.tencent.mm.modelsns.k.tO(719);
        paramView.PH(r.v(localSnsInfo)).tR(localSnsInfo.field_type).fL(localSnsInfo.isAd()).PH(localSnsInfo.getUxinfo()).PH(paramObject);
        paramView.bfK();
        if (this.source != 0) {
          break label900;
        }
        paramView = com.tencent.mm.modelsns.k.tO(746);
        localObject2 = z.aTY();
        paramView.PH(paramObject).fL(paramObject.endsWith((String)localObject2));
        paramView.b((Intent)localObject1, "intent_key_StatisticsOplog");
        paramView = paramObject;
        if (this.source == 0)
        {
          this.Epj.fat().e(localSnsInfo, false);
          paramView = paramObject;
        }
        label816:
        ((Intent)localObject1).putExtra("Contact_User", paramView);
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.source);
        com.tencent.mm.plugin.sns.c.a.jRt.c((Intent)localObject1, this.activity);
        paramObject = (com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class);
        if (this.source != 0) {
          break label1046;
        }
        l = 6L;
      }
    }
    for (;;)
    {
      paramObject.report22210(paramView, l);
      AppMethodBeat.o(97835);
      return;
      paramView = com.tencent.mm.modelsns.k.tP(719);
      break;
      label900:
      paramView = com.tencent.mm.modelsns.k.tP(746);
      break label761;
      paramObject = (String)paramObject;
      g.aAi();
      paramView = ((l)g.af(l.class)).aSN().bjJ(paramObject);
      if ((paramView != null) && (paramView.gBM()))
      {
        ((Intent)localObject1).putExtra("Contact_User", paramObject);
        ((Intent)localObject1).putExtra("Contact_Scene", 37);
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.source);
        com.tencent.mm.plugin.sns.c.a.jRt.c((Intent)localObject1, this.activity);
        AppMethodBeat.o(97835);
        return;
      }
      paramView = paramObject;
      if (this.source != 0) {
        break label816;
      }
      paramView = new SnsInfo();
      paramView.setUserName(paramObject);
      this.Epj.fat().e(paramView, false);
      paramView = paramObject;
      break label816;
      label1046:
      if (this.source == 13) {
        l = 7L;
      } else {
        l = 8L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.j
 * JD-Core Version:    0.7.0.1
 */