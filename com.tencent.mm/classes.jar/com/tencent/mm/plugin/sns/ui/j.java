package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.i.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public class j
  implements q.a
{
  private ai KCs;
  Activity activity;
  public int source = 0;
  
  public j(Activity paramActivity, int paramInt, ai paramai)
  {
    this.activity = paramActivity;
    this.source = paramInt;
    this.KCs = paramai;
  }
  
  private ADInfo h(SnsInfo paramSnsInfo)
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
    label204:
    label250:
    long l;
    if ((paramObject instanceof com.tencent.mm.plugin.sns.data.d))
    {
      com.tencent.mm.plugin.sns.data.d locald = (com.tencent.mm.plugin.sns.data.d)paramObject;
      paramObject = new StringBuilder("onClick : ").append(locald.userName).append(" activity: ");
      if (this.activity == null) {}
      SnsInfo localSnsInfo;
      for (boolean bool = true;; bool = false)
      {
        Log.d("Micro.ClickableCallBack", bool + ", source=" + this.source);
        localSnsInfo = aj.fOI().bbl(locald.fCM);
        if (localSnsInfo != null) {
          break;
        }
        Log.e("Micro.ClickableCallBack", "onclick info is null. localId:%s", new Object[] { locald.fCM });
        AppMethodBeat.o(97835);
        return;
      }
      Object localObject2;
      if (locald.isAd)
      {
        Object localObject3 = localSnsInfo.getAdXml();
        String str = h(localSnsInfo).viewId;
        int j;
        if (locald.maV > 0)
        {
          i = locald.maV;
          int k = this.source;
          if (this.source != 0) {
            break label445;
          }
          j = 1;
          localObject2 = new SnsAdClick(k, j, localSnsInfo.getAdSnsInfo().field_snsId, i, 0);
          paramObject = null;
          if (!(this.activity instanceof SnsTimeLineUI)) {
            break label451;
          }
          paramObject = ((SnsTimeLineUI)this.activity).fXs();
          com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, paramObject, localSnsInfo, i);
          if (localObject3 == null) {
            break label579;
          }
          if ((((ADXml)localObject3).headClickType != 1) || (Util.isNullOrNil(((ADXml)localObject3).headClickParam))) {
            break label481;
          }
          paramObject = ((ADXml)localObject3).headClickParam;
          localObject1 = h(localSnsInfo);
          paramView = paramObject;
          if (localObject1 != null) {
            paramView = t.kw(paramObject, ((ADInfo)localObject1).uxInfo);
          }
          Log.i("Micro.ClickableCallBack", "headClickParam url " + paramView + " " + ((ADXml)localObject3).headClickRightBarShow);
          paramObject = new Intent();
          if (((ADXml)localObject3).headClickRightBarShow != 0) {
            break label475;
          }
        }
        label445:
        label451:
        label475:
        for (bool = true;; bool = false)
        {
          paramObject.putExtra("KsnsViewId", str);
          paramObject.putExtra("KRightBtn", bool);
          paramObject.putExtra("jsapiargs", new Bundle());
          paramObject.putExtra("rawUrl", paramView);
          paramObject.putExtra("useJs", true);
          com.tencent.mm.plugin.sns.c.a.mIG.h(paramObject, this.activity);
          t.a((SnsAdClick)localObject2);
          AppMethodBeat.o(97835);
          return;
          i = 2;
          break;
          j = 2;
          break label204;
          if (!(this.activity instanceof SnsCommentDetailUI)) {
            break label250;
          }
          paramObject = ((SnsCommentDetailUI)this.activity).KPn;
          break label250;
        }
        label481:
        if (com.tencent.mm.plugin.sns.ad.d.l.a(this.activity, (ADXml)localObject3, h(localSnsInfo), localSnsInfo.field_snsId, 1))
        {
          k.a((SnsAdClick)localObject2, 41);
          t.a((SnsAdClick)localObject2);
          AppMethodBeat.o(97835);
          return;
        }
        paramObject = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
        paramObject.put("ext_sns_ad_click", localObject2);
        localObject3 = com.tencent.mm.plugin.sns.ad.timeline.a.a.e(1, this.activity);
        if ((localObject3 != null) && (((c)localObject3).a(paramView, this.source, localSnsInfo, paramObject)))
        {
          AppMethodBeat.o(97835);
          return;
        }
        label579:
        this.KCs.fOn().e(localSnsInfo, false);
        if (locald.userName.endsWith("@ad"))
        {
          AppMethodBeat.o(97835);
          return;
        }
        k.a((SnsAdClick)localObject2, 40);
        t.a((SnsAdClick)localObject2);
        ((Intent)localObject1).putExtra("Contact_User", locald.userName);
        ((Intent)localObject1).putExtra("KSnsAdTag", (Parcelable)localObject2);
        ((Intent)localObject1).putExtra("Contact_Scene", 79);
        if (this.source == 0) {}
        for (int i = 6;; i = 1)
        {
          ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", i);
          com.tencent.mm.plugin.sns.c.a.mIG.c((Intent)localObject1, this.activity);
          Log.i("Micro.ClickableCallBack", "startContactInfo, addScene=79");
          AppMethodBeat.o(97835);
          return;
        }
      }
      paramObject = locald.userName;
      if (this.source == 0)
      {
        paramView = com.tencent.mm.modelsns.l.wO(719);
        paramView.Xf(t.w(localSnsInfo)).wR(localSnsInfo.field_type).gx(localSnsInfo.isAd()).Xf(localSnsInfo.getUxinfo()).Xf(paramObject);
        paramView.bpa();
        if (this.source != 0) {
          break label931;
        }
        paramView = com.tencent.mm.modelsns.l.wO(746);
        label792:
        localObject2 = z.bcZ();
        paramView.Xf(paramObject).gx(paramObject.endsWith((String)localObject2));
        paramView.b((Intent)localObject1, "intent_key_StatisticsOplog");
        paramView = paramObject;
        if (this.source == 0)
        {
          this.KCs.fOn().e(localSnsInfo, false);
          paramView = paramObject;
        }
        label847:
        ((Intent)localObject1).putExtra("Contact_User", paramView);
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.source);
        com.tencent.mm.plugin.sns.c.a.mIG.c((Intent)localObject1, this.activity);
        paramObject = (com.tencent.mm.plugin.textstatus.a.d)h.ag(com.tencent.mm.plugin.textstatus.a.d.class);
        if (this.source != 0) {
          break label1077;
        }
        l = 6L;
      }
    }
    for (;;)
    {
      paramObject.report22210(paramView, l);
      AppMethodBeat.o(97835);
      return;
      paramView = com.tencent.mm.modelsns.l.wP(719);
      break;
      label931:
      paramView = com.tencent.mm.modelsns.l.wP(746);
      break label792;
      paramObject = (String)paramObject;
      h.aHH();
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(paramObject);
      if ((paramView != null) && (paramView.hxX()))
      {
        ((Intent)localObject1).putExtra("Contact_User", paramObject);
        ((Intent)localObject1).putExtra("Contact_Scene", 37);
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.source);
        com.tencent.mm.plugin.sns.c.a.mIG.c((Intent)localObject1, this.activity);
        AppMethodBeat.o(97835);
        return;
      }
      paramView = paramObject;
      if (this.source != 0) {
        break label847;
      }
      paramView = new SnsInfo();
      paramView.setUserName(paramObject);
      this.KCs.fOn().e(paramView, false);
      paramView = paramObject;
      break label847;
      label1077:
      if (this.source == 13) {
        l = 7L;
      } else {
        l = 8L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.j
 * JD-Core Version:    0.7.0.1
 */