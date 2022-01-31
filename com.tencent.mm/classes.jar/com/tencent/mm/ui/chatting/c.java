package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.aw;
import com.tencent.mm.ui.w.a;

public final class c
  implements View.OnClickListener, f, t
{
  private ProgressDialog dnm;
  private a vhq;
  
  public c(a parama)
  {
    this.vhq = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    y.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    ap.brq().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      h.bC(this.vhq.vtz.getContext(), this.vhq.vtz.getMMResources().getString(R.l.game_refuse_message_ok));
    }
    while (w.a.a(this.vhq.vtz.getContext(), paramInt1, paramInt2, paramString, 4)) {
      return;
    }
    Toast.makeText(this.vhq.vtz.getContext(), this.vhq.vtz.getMMResources().getString(R.l.game_liset_set_refuse_msg_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    int i = 0;
    if (paramView.getTag() == null)
    {
      y.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      return;
    }
    Object localObject1;
    if ((paramView.getTag() instanceof aw))
    {
      localObject1 = (aw)paramView.getTag();
      if (localObject1 == null)
      {
        y.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        return;
      }
      paramView = ((aw)localObject1).bWy.appId;
      if (bk.bl(paramView))
      {
        y.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
        label74:
        if (i == 0) {
          break label271;
        }
        ap.brq().a(2, this);
        if (!this.vhq.cFE()) {
          break label273;
        }
        i = 2;
        label98:
        paramView = this.vhq.getTalkerUserName();
        if (!s.fn(paramView)) {
          break label472;
        }
        paramView = bd.iI(((aw)localObject1).bWO.field_content);
      }
    }
    label271:
    label273:
    label472:
    for (;;)
    {
      localObject1 = ((aw)localObject1).bWy;
      h.a(this.vhq.vtz.getContext(), this.vhq.vtz.getMMResources().getString(R.l.app_message_setting_confirm), this.vhq.vtz.getMMResources().getString(R.l.app_message_setting_title), this.vhq.vtz.getMMResources().getString(R.l.ac_app_message_btn_tip), this.vhq.vtz.getMMResources().getString(R.l.refuse_app_message_btn_tip), new c.2(this, (g.a)localObject1, paramView, i), new c.3(this, (g.a)localObject1, paramView, i));
      return;
      if (g.by(paramView, false) == null)
      {
        y.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = " + paramView);
        break label74;
      }
      i = 1;
      break label74;
      break;
      i = 1;
      break label98;
      if (!(paramView.getTag() instanceof t.n)) {
        break;
      }
      Object localObject2 = (t.n)paramView.getTag();
      if (localObject2 == null)
      {
        y.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
        return;
      }
      if ((localObject2 == null) || (bk.bl(((t.n)localObject2).dRD)) || (((t.n)localObject2).bWO == null))
      {
        if (localObject2 == null) {}
        for (;;)
        {
          y.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
          return;
          bool = false;
        }
      }
      paramView = this.vhq.vtz.getMMResources().getString(R.l.template_msg_btn_expose);
      localObject1 = this.vhq.vtz.getMMResources().getString(R.l.template_msg_btn_refuse);
      String str = this.vhq.vtz.getMMResources().getString(R.l.app_cancel);
      Activity localActivity = this.vhq.vtz.getContext();
      localObject2 = new c.1(this, (t.n)localObject2);
      h.a(localActivity, null, new String[] { paramView, localObject1, str }, null, true, (h.c)localObject2);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    au.Dk().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.bC(this.vhq.vtz.getContext(), this.vhq.vtz.getMMResources().getString(R.l.game_refuse_message_ok));
      return;
    }
    Toast.makeText(this.vhq.vtz.getContext(), this.vhq.vtz.getMMResources().getString(R.l.template_msg_refuse_success, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c
 * JD-Core Version:    0.7.0.1
 */