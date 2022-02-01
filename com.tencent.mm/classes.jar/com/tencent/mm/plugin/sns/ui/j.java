package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.c.d;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public class j
  implements p.a
{
  private ag AgN;
  Activity activity;
  public int doj = 0;
  
  public j(Activity paramActivity, int paramInt, ag paramag)
  {
    this.activity = paramActivity;
    this.doj = paramInt;
    this.AgN = paramag;
  }
  
  private com.tencent.mm.plugin.sns.storage.a g(p paramp)
  {
    AppMethodBeat.i(97834);
    if (paramp != null)
    {
      if (this.doj == 2)
      {
        paramp = paramp.ebM();
        AppMethodBeat.o(97834);
        return paramp;
      }
      paramp = paramp.dVi();
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
        ae.d("Micro.ClickableCallBack", bool + ", source=" + this.doj);
        localp = ah.dXE().aBr(paramObject.dsN);
        if (!paramObject.isAd) {
          break label593;
        }
        localObject2 = localp.dVj();
        str = g(localp).aQj;
        if (paramObject.ipN <= 0) {
          break label404;
        }
        i = paramObject.ipN;
        int k = this.doj;
        if (this.doj != 0) {
          break label409;
        }
        j = 1;
        localSnsAdClick = new SnsAdClick(k, j, localp.ecy().field_snsId, i, 0);
        paramView = null;
        if (!(this.activity instanceof SnsTimeLineUI)) {
          break label415;
        }
        paramView = ((SnsTimeLineUI)this.activity).egD();
        label208:
        k.a(localSnsAdClick, paramView, localp, i);
        r.a(localSnsAdClick);
        if (localObject2 == null) {
          break label474;
        }
        if ((((com.tencent.mm.plugin.sns.storage.b)localObject2).zNc != 1) || (bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject2).zNd))) {
          break label445;
        }
        paramObject = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zNd;
        localObject1 = g(localp);
        paramView = paramObject;
        if (localObject1 != null) {
          paramView = r.jo(paramObject, ((com.tencent.mm.plugin.sns.storage.a)localObject1).dGD);
        }
        ae.i("Micro.ClickableCallBack", "headClickParam url " + paramView + " " + ((com.tencent.mm.plugin.sns.storage.b)localObject2).zNe);
        paramObject = new Intent();
        if (((com.tencent.mm.plugin.sns.storage.b)localObject2).zNe != 0) {
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
        com.tencent.mm.plugin.sns.c.a.iUz.i(paramObject, this.activity);
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
        paramView = ((SnsCommentDetailUI)this.activity).Asq;
        break label208;
      }
      label445:
      if (d.b(this.activity, (com.tencent.mm.plugin.sns.storage.b)localObject2, g(localp), localp.field_snsId))
      {
        AppMethodBeat.o(97835);
        return;
      }
      label474:
      this.AgN.dXi().a(localp, false);
      if (paramObject.userName.endsWith("@ad"))
      {
        AppMethodBeat.o(97835);
        return;
      }
      ((Intent)localObject1).putExtra("Contact_User", paramObject.userName);
      ((Intent)localObject1).putExtra("KSnsAdTag", localSnsAdClick);
      ((Intent)localObject1).putExtra("Contact_Scene", 79);
      if (this.doj == 0) {}
      for (int i = 6;; i = 1)
      {
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", i);
        com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject1, this.activity);
        ae.i("Micro.ClickableCallBack", "startContactInfo, addScene=79");
        AppMethodBeat.o(97835);
        return;
      }
      label593:
      paramObject = paramObject.userName;
      if (this.doj == 0)
      {
        paramView = com.tencent.mm.modelsns.e.pY(719);
        paramView.GU(r.o(localp)).qb(localp.field_type).eV(localp.Rt(32)).GU(localp.ecx()).GU(paramObject);
        paramView.aLH();
        if (this.doj != 0) {
          break label778;
        }
        paramView = com.tencent.mm.modelsns.e.pY(746);
        label671:
        localObject2 = v.aAC();
        paramView.GU(paramObject).eV(paramObject.endsWith((String)localObject2));
        paramView.b((Intent)localObject1, "intent_key_StatisticsOplog");
        paramView = paramObject;
        if (this.doj == 0)
        {
          this.AgN.dXi().a(localp, false);
          paramView = paramObject;
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("Contact_User", paramView);
      ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.doj);
      com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject1, this.activity);
      AppMethodBeat.o(97835);
      return;
      paramView = com.tencent.mm.modelsns.e.pZ(719);
      break;
      label778:
      paramView = com.tencent.mm.modelsns.e.pZ(746);
      break label671;
      paramObject = (String)paramObject;
      g.ajS();
      paramView = ((l)g.ab(l.class)).azF().aUK(paramObject);
      if ((paramView != null) && (paramView.fug()))
      {
        ((Intent)localObject1).putExtra("Contact_User", paramObject);
        ((Intent)localObject1).putExtra("Contact_Scene", 37);
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.doj);
        com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject1, this.activity);
        AppMethodBeat.o(97835);
        return;
      }
      paramView = paramObject;
      if (this.doj == 0)
      {
        paramView = new p();
        paramView.field_userName = paramObject;
        this.AgN.dXi().a(paramView, false);
        paramView = paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.j
 * JD-Core Version:    0.7.0.1
 */