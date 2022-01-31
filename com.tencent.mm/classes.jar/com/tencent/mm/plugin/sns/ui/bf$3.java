package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cix;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class bf$3
  implements View.OnClickListener
{
  bf$3(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
    if (!(paramView.getTag() instanceof q)) {
      return;
    }
    Object localObject = (q)paramView.getTag();
    paramView = ((q)localObject).oOz;
    localObject = af.bDF().OB(((q)localObject).bJQ);
    if (this.pkg.oOe != null) {
      this.pkg.oOe.bDk().y((n)localObject);
    }
    if (paramView.tNx == null)
    {
      y.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
      return;
    }
    String str1 = paramView.tNx.username;
    String str2 = paramView.tNx.path;
    y.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
    rc localrc = new rc();
    localrc.caq.userName = str1;
    localrc.caq.cas = str2;
    localrc.caq.scene = 1009;
    localrc.caq.bFv = (paramView.lsK + ":" + paramView.hPY);
    paramView = new Bundle();
    paramView.putString("stat_send_msg_user", ((n)localObject).field_userName);
    paramView.putString("stat_msg_id", "sns_" + i.fN(((n)localObject).field_snsId));
    a.udP.m(localrc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.3
 * JD-Core Version:    0.7.0.1
 */