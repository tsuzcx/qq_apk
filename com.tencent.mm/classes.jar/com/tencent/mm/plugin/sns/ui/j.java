package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public class j
  implements p.a
{
  Activity activity;
  public int dbL = 0;
  private ae yyv;
  
  public j(Activity paramActivity, int paramInt, ae paramae)
  {
    this.activity = paramActivity;
    this.dbL = paramInt;
    this.yyv = paramae;
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(p paramp)
  {
    AppMethodBeat.i(97834);
    if (paramp != null)
    {
      if (this.dbL == 2)
      {
        paramp = paramp.dLS();
        AppMethodBeat.o(97834);
        return paramp;
      }
      paramp = paramp.dFQ();
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
        ac.d("Micro.ClickableCallBack", bool + ", source=" + this.dbL);
        localp = af.dHR().auT(paramObject.dgl);
        if (!paramObject.isAd) {
          break label563;
        }
        localObject2 = localp.dFR();
        str = f(localp).dyy;
        if (paramObject.hTz <= 0) {
          break label404;
        }
        i = paramObject.hTz;
        int k = this.dbL;
        if (this.dbL != 0) {
          break label409;
        }
        j = 1;
        localSnsAdClick = new SnsAdClick(k, j, localp.dME().field_snsId, i, 0);
        paramView = null;
        if (!(this.activity instanceof SnsTimeLineUI)) {
          break label415;
        }
        paramView = ((SnsTimeLineUI)this.activity).dQE();
        label208:
        com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, paramView, localp, i);
        com.tencent.mm.plugin.sns.data.q.a(localSnsAdClick);
        if ((localObject2 == null) || (((b)localObject2).yfF != 1) || (bs.isNullOrNil(((b)localObject2).yfG))) {
          break label445;
        }
        paramObject = ((b)localObject2).yfG;
        localObject1 = f(localp);
        paramView = paramObject;
        if (localObject1 != null) {
          paramView = com.tencent.mm.plugin.sns.data.q.iV(paramObject, ((com.tencent.mm.plugin.sns.storage.a)localObject1).dtx);
        }
        ac.i("Micro.ClickableCallBack", "headClickParam url " + paramView + " " + ((b)localObject2).yfH);
        paramObject = new Intent();
        if (((b)localObject2).yfH != 0) {
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
        com.tencent.mm.plugin.sns.c.a.iyx.i(paramObject, this.activity);
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
        paramView = ((SnsCommentDetailUI)this.activity).yJJ;
        break label208;
      }
      label445:
      this.yyv.dHw().a(localp, false);
      if (paramObject.userName.endsWith("@ad"))
      {
        AppMethodBeat.o(97835);
        return;
      }
      ((Intent)localObject1).putExtra("Contact_User", paramObject.userName);
      ((Intent)localObject1).putExtra("KSnsAdTag", localSnsAdClick);
      ((Intent)localObject1).putExtra("Contact_Scene", 79);
      if (this.dbL == 0) {}
      for (int i = 6;; i = 1)
      {
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", i);
        com.tencent.mm.plugin.sns.c.a.iyx.c((Intent)localObject1, this.activity);
        ac.i("Micro.ClickableCallBack", "startContactInfo, addScene=79");
        AppMethodBeat.o(97835);
        return;
      }
      label563:
      paramObject = paramObject.userName;
      if (this.dbL == 0)
      {
        paramView = d.ps(719);
        paramView.Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32)).Dn(localp.dMD()).Dn(paramObject);
        paramView.aHZ();
        if (this.dbL != 0) {
          break label748;
        }
        paramView = d.ps(746);
        label641:
        localObject2 = u.axw();
        paramView.Dn(paramObject).eQ(paramObject.endsWith((String)localObject2));
        paramView.b((Intent)localObject1, "intent_key_StatisticsOplog");
        paramView = paramObject;
        if (this.dbL == 0)
        {
          this.yyv.dHw().a(localp, false);
          paramView = paramObject;
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("Contact_User", paramView);
      ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.dbL);
      com.tencent.mm.plugin.sns.c.a.iyx.c((Intent)localObject1, this.activity);
      AppMethodBeat.o(97835);
      return;
      paramView = d.pt(719);
      break;
      label748:
      paramView = d.pt(746);
      break label641;
      paramObject = (String)paramObject;
      g.agS();
      paramView = ((k)g.ab(k.class)).awB().aNr(paramObject);
      if ((paramView != null) && (paramView.fad()))
      {
        ((Intent)localObject1).putExtra("Contact_User", paramObject);
        ((Intent)localObject1).putExtra("Contact_Scene", 37);
        ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.dbL);
        com.tencent.mm.plugin.sns.c.a.iyx.c((Intent)localObject1, this.activity);
        AppMethodBeat.o(97835);
        return;
      }
      paramView = paramObject;
      if (this.dbL == 0)
      {
        paramView = new p();
        paramView.field_userName = paramObject;
        this.yyv.dHw().a(paramView, false);
        paramView = paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.j
 * JD-Core Version:    0.7.0.1
 */