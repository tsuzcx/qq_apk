package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public class j
  implements p.a
{
  Activity activity;
  public int dnh = 0;
  private af zPG;
  
  public j(Activity paramActivity, int paramInt, af paramaf)
  {
    this.activity = paramActivity;
    this.dnh = paramInt;
    this.zPG = paramaf;
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(p paramp)
  {
    AppMethodBeat.i(97834);
    if (paramp != null)
    {
      if (this.dnh == 2)
      {
        paramp = paramp.dYi();
        AppMethodBeat.o(97834);
        return paramp;
      }
      paramp = paramp.dRK();
      AppMethodBeat.o(97834);
      return paramp;
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
    if ((paramObject instanceof com.tencent.mm.plugin.sns.data.a))
    {
      paramObject = (com.tencent.mm.plugin.sns.data.a)paramObject;
      paramView = new StringBuilder("onClick : ").append(paramObject.userName).append(" activity: ");
      p localp;
      Object localObject2;
      String str;
      label146:
      int j;
      label162:
      SnsAdClick localSnsAdClick;
      if (this.activity == null)
      {
        bool = true;
        ad.d("Micro.ClickableCallBack", bool + ", source=" + this.dnh);
        localp = ag.dUe().aAa(paramObject.drH);
        if (!paramObject.isAd) {
          break label563;
        }
        localObject2 = localp.dRL();
        str = f(localp).aQj;
        if (paramObject.imT <= 0) {
          break label404;
        }
        i = paramObject.imT;
        int k = this.dnh;
        if (this.dnh != 0) {
          break label409;
        }
        j = 1;
        localSnsAdClick = new SnsAdClick(k, j, localp.dYU().field_snsId, i, 0);
        paramView = null;
        if (!(this.activity instanceof SnsTimeLineUI)) {
          break label415;
        }
        paramView = ((SnsTimeLineUI)this.activity).ecW();
        label208:
        com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, paramView, localp, i);
        com.tencent.mm.plugin.sns.data.q.a(localSnsAdClick);
        if ((localObject2 == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject2).zvH != 1) || (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject2).zvI))) {
          break label445;
        }
        paramObject = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zvI;
        localObject1 = f(localp);
        paramView = paramObject;
        if (localObject1 != null) {
          paramView = com.tencent.mm.plugin.sns.data.q.jh(paramObject, ((com.tencent.mm.plugin.sns.storage.a)localObject1).dFy);
        }
        ad.i("Micro.ClickableCallBack", "headClickParam url " + paramView + " " + ((com.tencent.mm.plugin.sns.storage.b)localObject2).zvJ);
        paramObject = new Intent();
        if (((com.tencent.mm.plugin.sns.storage.b)localObject2).zvJ != 0) {
          break label439;
        }
      }
      label404:
      label409:
      label415:
      label439:
      for (boolean bool = true;; bool = false)
      {
        paramObject.putExtra("KsnsViewId", str);
        paramObject.putExtra("KRightBtn", bool);
        paramObject.putExtra("jsapiargs", new Bundle());
        paramObject.putExtra("rawUrl", paramView);
        paramObject.putExtra("useJs", true);
        com.tencent.mm.plugin.sns.c.a.iRG.i(paramObject, this.activity);
        AppMethodBeat.o(97835);
        return;
        bool = false;
        break;
        i = 2;
        break label146;
        j = 2;
        break label162;
        if (!(this.activity instanceof SnsCommentDetailUI)) {
          break label208;
        }
        paramView = ((SnsCommentDetailUI)this.activity).Abd;
        break label208;
      }
      label445:
      this.zPG.dTI().a(localp, false);
      if (paramObject.userName.endsWith("@ad"))
      {
        AppMethodBeat.o(97835);
        return;
      }
      ((Intent)localObject1).putExtra("Contact_User", paramObject.userName);
      ((Intent)localObject1).putExtra("KSnsAdTag", localSnsAdClick);
      ((Intent)localObject1).putExtra("Contact_Scene", 79);
      if (this.dnh == 0) {}
      for (int i = 6;; i = 1)
      {
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", i);
        com.tencent.mm.plugin.sns.c.a.iRG.c((Intent)localObject1, this.activity);
        ad.i("Micro.ClickableCallBack", "startContactInfo, addScene=79");
        AppMethodBeat.o(97835);
        return;
      }
      label563:
      paramObject = paramObject.userName;
      if (this.dnh == 0)
      {
        paramView = com.tencent.mm.modelsns.e.pV(719);
        paramView.Gs(com.tencent.mm.plugin.sns.data.q.n(localp)).pY(localp.field_type).eS(localp.QM(32)).Gs(localp.dYT()).Gs(paramObject);
        paramView.aLk();
        if (this.dnh != 0) {
          break label748;
        }
        paramView = com.tencent.mm.modelsns.e.pV(746);
        label641:
        localObject2 = u.aAm();
        paramView.Gs(paramObject).eS(paramObject.endsWith((String)localObject2));
        paramView.b((Intent)localObject1, "intent_key_StatisticsOplog");
        paramView = paramObject;
        if (this.dnh == 0)
        {
          this.zPG.dTI().a(localp, false);
          paramView = paramObject;
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("Contact_User", paramView);
      ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.dnh);
      com.tencent.mm.plugin.sns.c.a.iRG.c((Intent)localObject1, this.activity);
      AppMethodBeat.o(97835);
      return;
      paramView = com.tencent.mm.modelsns.e.pW(719);
      break;
      label748:
      paramView = com.tencent.mm.modelsns.e.pW(746);
      break label641;
      paramObject = (String)paramObject;
      g.ajD();
      paramView = ((l)g.ab(l.class)).azp().aTj(paramObject);
      if ((paramView != null) && (paramView.fqg()))
      {
        ((Intent)localObject1).putExtra("Contact_User", paramObject);
        ((Intent)localObject1).putExtra("Contact_Scene", 37);
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.dnh);
        com.tencent.mm.plugin.sns.c.a.iRG.c((Intent)localObject1, this.activity);
        AppMethodBeat.o(97835);
        return;
      }
      paramView = paramObject;
      if (this.dnh == 0)
      {
        paramView = new p();
        paramView.field_userName = paramObject;
        this.zPG.dTI().a(paramView, false);
        paramView = paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.j
 * JD-Core Version:    0.7.0.1
 */