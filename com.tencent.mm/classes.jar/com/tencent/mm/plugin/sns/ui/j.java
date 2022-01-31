package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.d.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public class j
  implements o.a
{
  Activity activity;
  public int cpt = 0;
  private af rFN;
  
  public j(Activity paramActivity, int paramInt, af paramaf)
  {
    this.activity = paramActivity;
    this.cpt = paramInt;
    this.rFN = paramaf;
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    AppMethodBeat.i(145449);
    if (paramn != null)
    {
      if (this.cpt == 2)
      {
        paramn = paramn.cse();
        AppMethodBeat.o(145449);
        return paramn;
      }
      paramn = paramn.csd();
      AppMethodBeat.o(145449);
      return paramn;
    }
    AppMethodBeat.o(145449);
    return null;
  }
  
  public void a(View paramView, Object paramObject)
  {
    AppMethodBeat.i(38198);
    Object localObject2 = new Intent();
    if (this.activity == null)
    {
      AppMethodBeat.o(38198);
      return;
    }
    if ((paramObject instanceof com.tencent.mm.plugin.sns.data.a))
    {
      paramView = (com.tencent.mm.plugin.sns.data.a)paramObject;
      paramObject = new StringBuilder("onClick : ").append(paramView.userName).append(" activity: ");
      com.tencent.mm.plugin.sns.storage.n localn;
      String str;
      if (this.activity == null)
      {
        bool = true;
        ab.d("Micro.ClickableCallBack", bool);
        localn = ag.cpf().abv(paramView.ctV);
        if (!paramView.raZ) {
          break label496;
        }
        localObject1 = localn.csb();
        str = f(localn).hpq;
        int j = this.cpt;
        if (this.cpt != 0) {
          break label377;
        }
        i = 1;
        label137:
        paramObject = new SnsAdClick(j, i, localn.csQ().field_snsId, 2, 0);
        if ((this.activity instanceof SnsTimeLineUI)) {
          paramObject.fQA = ((SnsTimeLineUI)this.activity).cwf().di(localn.csH(), 2);
        }
        i.a(paramObject);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqa != 1) || (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject1).rqb))) {
          break label388;
        }
        paramObject = ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqb;
        localObject2 = f(localn);
        paramView = paramObject;
        if (localObject2 != null) {
          paramView = i.gg(paramObject, ((com.tencent.mm.plugin.sns.storage.a)localObject2).cFe);
        }
        ab.i("Micro.ClickableCallBack", "headClickParam url " + paramView + " " + ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqc);
        paramObject = new Intent();
        if (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqc != 0) {
          break label382;
        }
      }
      label377:
      label382:
      for (boolean bool = true;; bool = false)
      {
        paramObject.putExtra("KsnsViewId", str);
        paramObject.putExtra("KRightBtn", bool);
        paramObject.putExtra("jsapiargs", new Bundle());
        paramObject.putExtra("rawUrl", paramView);
        paramObject.putExtra("useJs", true);
        com.tencent.mm.plugin.sns.c.a.gmO.i(paramObject, this.activity);
        AppMethodBeat.o(38198);
        return;
        bool = false;
        break;
        i = 2;
        break label137;
      }
      label388:
      this.rFN.coJ().a(localn, false);
      if (paramView.userName.endsWith("@ad"))
      {
        AppMethodBeat.o(38198);
        return;
      }
      ((Intent)localObject2).putExtra("Contact_User", paramView.userName);
      ((Intent)localObject2).putExtra("KSnsAdTag", paramObject);
      ((Intent)localObject2).putExtra("Contact_Scene", 37);
      if (this.cpt == 0) {}
      for (int i = 6;; i = 1)
      {
        ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", i);
        com.tencent.mm.plugin.sns.c.a.gmO.c((Intent)localObject2, this.activity);
        AppMethodBeat.o(38198);
        return;
      }
      label496:
      Object localObject1 = paramView.userName;
      if (this.cpt == 0)
      {
        paramView = com.tencent.mm.modelsns.b.lV(719);
        paramView.uv(i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv((String)localObject1);
        paramView.ake();
        if (this.cpt != 0) {
          break label684;
        }
        paramView = com.tencent.mm.modelsns.b.lV(746);
        label576:
        paramObject = r.Zn();
        paramView.uv((String)localObject1).de(((String)localObject1).endsWith(paramObject));
        paramView.b((Intent)localObject2, "intent_key_StatisticsOplog");
        paramObject = localObject1;
        if (this.cpt == 0)
        {
          this.rFN.coJ().a(localn, false);
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("Contact_User", paramObject);
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.cpt);
      com.tencent.mm.plugin.sns.c.a.gmO.c((Intent)localObject2, this.activity);
      AppMethodBeat.o(38198);
      return;
      paramView = com.tencent.mm.modelsns.b.lW(719);
      break;
      label684:
      paramView = com.tencent.mm.modelsns.b.lW(746);
      break label576;
      paramObject = (String)paramObject;
      paramView = paramObject;
      if (paramObject.contains("@")) {
        paramView = paramObject.replace("@", "");
      }
      com.tencent.mm.kernel.g.RM();
      paramObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(paramView);
      if ((paramObject != null) && (paramObject.dwz()))
      {
        ((Intent)localObject2).putExtra("Contact_User", paramView);
        ((Intent)localObject2).putExtra("Contact_Scene", 37);
        ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.cpt);
        com.tencent.mm.plugin.sns.c.a.gmO.c((Intent)localObject2, this.activity);
        AppMethodBeat.o(38198);
        return;
      }
      paramObject = paramView;
      if (this.cpt == 0)
      {
        paramObject = new com.tencent.mm.plugin.sns.storage.n();
        paramObject.field_userName = paramView;
        this.rFN.coJ().a(paramObject, false);
        paramObject = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.j
 * JD-Core Version:    0.7.0.1
 */