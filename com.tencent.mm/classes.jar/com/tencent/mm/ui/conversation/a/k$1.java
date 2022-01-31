package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import java.lang.ref.WeakReference;

final class k$1
  implements View.OnClickListener
{
  k$1(k paramk, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    bc.HI().bi(this.bns, this.uJr);
    paramView = (Context)this.vUP.sdy.get();
    if (paramView != null)
    {
      h.nFQ.f(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      au.Hx();
      boolean bool = bk.d((Boolean)c.Dz().get(4103, null));
      new Intent().putExtra("KEnterFromBanner", true);
      if (!bool) {
        d.x(paramView, "nearby", ".ui.NearbyFriendsIntroUI");
      }
    }
    else
    {
      return;
    }
    Object localObject = bn.Ie();
    if (localObject == null)
    {
      d.x(paramView, "nearby", ".ui.NearbyPersonalInfoUI");
      return;
    }
    String str = bk.pm(((bn)localObject).getProvince());
    int i = bk.a(Integer.valueOf(((bn)localObject).sex), 0);
    if ((bk.bl(str)) || (i == 0))
    {
      d.x(paramView, "nearby", ".ui.NearbyPersonalInfoUI");
      return;
    }
    localObject = LauncherUI.cyX();
    if (localObject != null) {
      ((LauncherUI)localObject).uKP.uKi.acW("tab_find_friend");
    }
    a.eF(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k.1
 * JD-Core Version:    0.7.0.1
 */