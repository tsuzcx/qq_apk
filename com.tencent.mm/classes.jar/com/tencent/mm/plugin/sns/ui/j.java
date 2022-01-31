package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.d.o.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class j
  implements o.a
{
  Activity activity;
  private ae oOe;
  private int source = 0;
  
  public j(Activity paramActivity, int paramInt, ae paramae)
  {
    this.activity = paramActivity;
    this.source = paramInt;
    this.oOe = paramae;
  }
  
  public final void bC(Object paramObject)
  {
    int i = 6;
    boolean bool2 = false;
    int j = 1;
    Intent localIntent = new Intent();
    if (this.activity == null) {}
    n localn;
    Object localObject1;
    label132:
    SnsAdClick localSnsAdClick;
    label344:
    label353:
    label358:
    label363:
    do
    {
      return;
      if (!(paramObject instanceof com.tencent.mm.plugin.sns.data.a)) {
        break label663;
      }
      localObject2 = (com.tencent.mm.plugin.sns.data.a)paramObject;
      paramObject = new StringBuilder("onClick : ").append(((com.tencent.mm.plugin.sns.data.a)localObject2).userName).append(" activity: ");
      boolean bool1;
      int k;
      if (this.activity == null)
      {
        bool1 = true;
        y.d("Micro.ClickableCallBack", bool1);
        localn = af.bDF().OB(((com.tencent.mm.plugin.sns.data.a)localObject2).bMB);
        if (!((com.tencent.mm.plugin.sns.data.a)localObject2).omL) {
          break;
        }
        localObject1 = localn.bFZ();
        if (localn == null) {
          break label353;
        }
        if (this.source != 2) {
          break label344;
        }
        paramObject = localn.bGc();
        paramObject = paramObject.fVM;
        k = this.source;
        if (this.source != 0) {
          break label358;
        }
      }
      for (i = 1;; i = 2)
      {
        localSnsAdClick = new SnsAdClick(k, i, localn.bGN().field_snsId, 2, 0);
        i.a(localSnsAdClick);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject1).oAQ != 1) || (bk.bl(((com.tencent.mm.plugin.sns.storage.b)localObject1).oAR))) {
          break label363;
        }
        localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).oAR;
        y.i("Micro.ClickableCallBack", "headClickParam url " + (String)localObject2 + " " + ((com.tencent.mm.plugin.sns.storage.b)localObject1).oAS);
        localIntent = new Intent();
        bool1 = bool2;
        if (((com.tencent.mm.plugin.sns.storage.b)localObject1).oAS == 0) {
          bool1 = true;
        }
        localIntent.putExtra("KsnsViewId", paramObject);
        localIntent.putExtra("KRightBtn", bool1);
        localIntent.putExtra("jsapiargs", new Bundle());
        localIntent.putExtra("rawUrl", (String)localObject2);
        localIntent.putExtra("useJs", true);
        com.tencent.mm.plugin.sns.c.a.eUR.j(localIntent, this.activity);
        return;
        bool1 = false;
        break;
        paramObject = localn.bGb();
        break label132;
        paramObject = null;
        break label132;
      }
      this.oOe.bDk().a(localn, false);
    } while (((com.tencent.mm.plugin.sns.data.a)localObject2).userName.endsWith("@ad"));
    localIntent.putExtra("Contact_User", ((com.tencent.mm.plugin.sns.data.a)localObject2).userName);
    localIntent.putExtra("KSnsAdTag", localSnsAdClick);
    localIntent.putExtra("Contact_Scene", 37);
    i = j;
    if (this.source == 0) {
      i = 6;
    }
    localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
    com.tencent.mm.plugin.sns.c.a.eUR.d(localIntent, this.activity);
    return;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.a)localObject2).userName;
    if (this.source == 0)
    {
      paramObject = com.tencent.mm.modelsns.b.jd(719);
      paramObject.ni(i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni((String)localObject2);
      paramObject.QX();
      if (this.source != 0) {
        break label653;
      }
      paramObject = com.tencent.mm.modelsns.b.jd(746);
      label541:
      localObject1 = q.Gj();
      paramObject.ni((String)localObject2).cb(((String)localObject2).endsWith((String)localObject1));
      paramObject.b(localIntent, "intent_key_StatisticsOplog");
      localObject1 = localObject2;
      if (this.source == 0)
      {
        this.oOe.bDk().a(localn, false);
        localObject1 = localObject2;
      }
      label602:
      localIntent.putExtra("Contact_User", (String)localObject1);
      if (this.source != 0) {
        break label835;
      }
    }
    for (;;)
    {
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.plugin.sns.c.a.eUR.d(localIntent, this.activity);
      return;
      paramObject = com.tencent.mm.modelsns.b.je(719);
      break;
      label653:
      paramObject = com.tencent.mm.modelsns.b.je(746);
      break label541;
      label663:
      localObject1 = (String)paramObject;
      paramObject = localObject1;
      if (((String)localObject1).contains("@")) {
        paramObject = ((String)localObject1).replace("@", "");
      }
      g.DQ();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(paramObject);
      if ((localObject1 != null) && (((ad)localObject1).cua()))
      {
        localIntent.putExtra("Contact_User", paramObject);
        localIntent.putExtra("Contact_Scene", 37);
        if (this.source == 0) {}
        for (;;)
        {
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
          com.tencent.mm.plugin.sns.c.a.eUR.d(localIntent, this.activity);
          return;
          i = 1;
        }
      }
      localObject1 = paramObject;
      if (this.source != 0) {
        break label602;
      }
      localObject1 = new n();
      ((n)localObject1).field_userName = paramObject;
      this.oOe.bDk().a((n)localObject1, false);
      localObject1 = paramObject;
      break label602;
      label835:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.j
 * JD-Core Version:    0.7.0.1
 */