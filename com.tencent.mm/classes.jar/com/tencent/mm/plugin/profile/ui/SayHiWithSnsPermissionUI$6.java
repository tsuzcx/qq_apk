package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class SayHiWithSnsPermissionUI$6
  implements MenuItem.OnMenuItemClickListener
{
  SayHiWithSnsPermissionUI$6(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((SayHiWithSnsPermissionUI.d(this.mZo) != null) && (SayHiWithSnsPermissionUI.d(this.mZo).isShowing())) {
      return false;
    }
    Object localObject1;
    Object localObject2;
    HashMap localHashMap;
    if (SayHiWithSnsPermissionUI.e(this.mZo))
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add(SayHiWithSnsPermissionUI.f(this.mZo));
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(SayHiWithSnsPermissionUI.g(this.mZo)));
      paramMenuItem = SayHiWithSnsPermissionUI.h(this.mZo);
      localHashMap = new HashMap();
      if (!SayHiWithSnsPermissionUI.i(this.mZo).wjS) {
        break label609;
      }
    }
    label609:
    for (int i = 1;; i = 0)
    {
      localHashMap.put(SayHiWithSnsPermissionUI.f(this.mZo), Integer.valueOf(i));
      y.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
      if (ad.aaU(SayHiWithSnsPermissionUI.f(this.mZo)))
      {
        localObject1 = this.mZo.getIntent().getStringExtra(e.a.uHO);
        paramMenuItem = new o(SayHiWithSnsPermissionUI.f(this.mZo), paramMenuItem, (String)localObject1);
        au.Dk().a(paramMenuItem, 0);
        localObject1 = this.mZo;
        localObject2 = this.mZo.mController.uMN;
        this.mZo.getString(R.l.app_tip);
        SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, h.b((Context)localObject2, this.mZo.getString(R.l.sendrequest_sending), true, new SayHiWithSnsPermissionUI.6.1(this, paramMenuItem)));
        return false;
      }
      paramMenuItem = new m((List)localObject1, (List)localObject2, paramMenuItem, "", localHashMap, SayHiWithSnsPermissionUI.j(this.mZo));
      localObject1 = this.mZo.getIntent().getStringExtra("source_from_user_name");
      localObject2 = this.mZo.getIntent().getStringExtra("source_from_nick_name");
      if (!bk.bl((String)localObject1)) {
        paramMenuItem.fP((String)localObject1, (String)localObject2);
      }
      au.Dk().a(paramMenuItem, 0);
      localObject1 = this.mZo;
      localObject2 = this.mZo.mController.uMN;
      this.mZo.getString(R.l.app_tip);
      SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, h.b((Context)localObject2, this.mZo.getString(R.l.sendrequest_sending), true, new SayHiWithSnsPermissionUI.6.2(this, paramMenuItem)));
      return false;
      if (!SayHiWithSnsPermissionUI.k(this.mZo)) {
        break;
      }
      paramMenuItem = this.mZo.getIntent().getStringExtra("Verify_ticket");
      if (ad.aaU(SayHiWithSnsPermissionUI.f(this.mZo)))
      {
        paramMenuItem = new com.tencent.mm.openim.b.p(SayHiWithSnsPermissionUI.f(this.mZo), paramMenuItem);
        au.Dk().a(paramMenuItem, 0);
        localObject1 = this.mZo;
        localObject2 = this.mZo.mController.uMN;
        this.mZo.getString(R.l.app_tip);
        SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, h.b((Context)localObject2, this.mZo.getString(R.l.contact_info_dealing_verify), true, new SayHiWithSnsPermissionUI.6.3(this, paramMenuItem)));
        return false;
      }
      paramMenuItem = new m(SayHiWithSnsPermissionUI.f(this.mZo), paramMenuItem, SayHiWithSnsPermissionUI.g(this.mZo), (byte)0);
      au.Dk().a(paramMenuItem, 0);
      localObject1 = this.mZo;
      localObject2 = this.mZo.mController.uMN;
      this.mZo.getString(R.l.app_tip);
      SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, h.b((Context)localObject2, this.mZo.getString(R.l.contact_info_dealing_verify), true, new SayHiWithSnsPermissionUI.6.4(this, paramMenuItem)));
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.6
 * JD-Core Version:    0.7.0.1
 */