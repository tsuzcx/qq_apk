package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cix;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class bf$4
  implements View.OnClickListener
{
  bf$4(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
    if (!(paramView.getTag() instanceof bxk)) {
      return;
    }
    paramView = (bxk)paramView.getTag();
    if (paramView.tNx == null)
    {
      y.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
      return;
    }
    String str = paramView.tNx.username;
    rc localrc = new rc();
    y.i("MicroMsg.TimeLineClickEvent", "username: " + str);
    localrc.caq.userName = str;
    localrc.caq.scene = 1009;
    localrc.caq.bFv = (paramView.lsK + ":" + paramView.hPY);
    a.udP.m(localrc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.4
 * JD-Core Version:    0.7.0.1
 */