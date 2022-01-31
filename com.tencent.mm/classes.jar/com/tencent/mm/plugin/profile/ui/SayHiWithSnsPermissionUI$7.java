package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.openim.b.q;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class SayHiWithSnsPermissionUI$7
  implements MenuItem.OnMenuItemClickListener
{
  SayHiWithSnsPermissionUI$7(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(23776);
    if ((SayHiWithSnsPermissionUI.d(this.pCR) != null) && (SayHiWithSnsPermissionUI.d(this.pCR).isShowing()))
    {
      AppMethodBeat.o(23776);
      return false;
    }
    Object localObject2;
    LinkedList localLinkedList;
    Object localObject1;
    HashMap localHashMap;
    if (this.pCR.pCQ[0] != 0)
    {
      this.pCR.pCQ[0] = false;
      if (!SayHiWithSnsPermissionUI.e(this.pCR)) {
        break label479;
      }
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(SayHiWithSnsPermissionUI.f(this.pCR));
      localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(SayHiWithSnsPermissionUI.g(this.pCR)));
      localObject1 = SayHiWithSnsPermissionUI.h(this.pCR);
      localHashMap = new HashMap();
      if (!SayHiWithSnsPermissionUI.i(this.pCR).ADA) {
        break label691;
      }
    }
    label691:
    for (int i = 1;; i = 0)
    {
      localHashMap.put(SayHiWithSnsPermissionUI.f(this.pCR), Integer.valueOf(i));
      ab.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
      if (ad.arf(SayHiWithSnsPermissionUI.f(this.pCR)))
      {
        paramMenuItem = this.pCR.getIntent().getStringExtra(e.b.yUZ);
        paramMenuItem = new o(SayHiWithSnsPermissionUI.f(this.pCR), (String)localObject1, paramMenuItem);
        aw.Rc().a(paramMenuItem, 0);
        localObject1 = this.pCR;
        localObject2 = this.pCR.getContext();
        this.pCR.getString(2131297087);
        SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, h.b((Context)localObject2, this.pCR.getString(2131303128), true, new SayHiWithSnsPermissionUI.7.1(this, paramMenuItem)));
      }
      for (;;)
      {
        AppMethodBeat.o(23776);
        return false;
        b.pgQ.fD("ce_ver_usr", "<VerifyUsr>");
        paramMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
        b.pgQ.a("ce_ver_usr", paramMenuItem);
        b.pgQ.Wa("ce_ver_usr");
        break;
        String str1 = this.pCR.getIntent().getStringExtra("source_from_user_name");
        String str2 = this.pCR.getIntent().getStringExtra("source_from_nick_name");
        paramMenuItem = new s(this.pCR, null);
        paramMenuItem.content = ((String)localObject1);
        paramMenuItem.scg = str1;
        paramMenuItem.sch = str2;
        paramMenuItem.vUt = localHashMap;
        paramMenuItem.chatroomName = SayHiWithSnsPermissionUI.j(this.pCR);
        paramMenuItem.r((List)localObject2, localLinkedList);
        localObject1 = this.pCR;
        localObject2 = this.pCR.getContext();
        this.pCR.getString(2131297087);
        SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, h.b((Context)localObject2, this.pCR.getString(2131303128), true, new SayHiWithSnsPermissionUI.7.2(this, paramMenuItem)));
        continue;
        label479:
        if (SayHiWithSnsPermissionUI.k(this.pCR))
        {
          paramMenuItem = this.pCR.getIntent().getStringExtra("Verify_ticket");
          if (ad.arf(SayHiWithSnsPermissionUI.f(this.pCR)))
          {
            paramMenuItem = new q(SayHiWithSnsPermissionUI.f(this.pCR), paramMenuItem);
            aw.Rc().a(paramMenuItem, 0);
            localObject1 = this.pCR;
            localObject2 = this.pCR.getContext();
            this.pCR.getString(2131297087);
            SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, h.b((Context)localObject2, this.pCR.getString(2131298581), true, new SayHiWithSnsPermissionUI.7.3(this, paramMenuItem)));
          }
          else
          {
            paramMenuItem = new m(SayHiWithSnsPermissionUI.f(this.pCR), paramMenuItem, SayHiWithSnsPermissionUI.g(this.pCR), SayHiWithSnsPermissionUI.j(this.pCR));
            aw.Rc().a(paramMenuItem, 0);
            localObject1 = this.pCR;
            localObject2 = this.pCR.getContext();
            this.pCR.getString(2131297087);
            SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, h.b((Context)localObject2, this.pCR.getString(2131298581), true, new SayHiWithSnsPermissionUI.7.4(this, paramMenuItem)));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.7
 * JD-Core Version:    0.7.0.1
 */