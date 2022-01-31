package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import java.lang.ref.WeakReference;

final class l$1
  implements View.OnClickListener
{
  l$1(l paraml, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34676);
    be.aaG().cs(this.bHS, this.yWR);
    paramView = (Context)this.AmR.vUD.get();
    if (paramView != null)
    {
      h.qsU.e(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      aw.aaz();
      boolean bool = bo.e((Boolean)c.Ru().get(4103, null));
      new Intent().putExtra("KEnterFromBanner", true);
      if (!bool)
      {
        d.H(paramView, "nearby", ".ui.NearbyFriendsIntroUI");
        AppMethodBeat.o(34676);
        return;
      }
      Object localObject = bp.abb();
      if (localObject == null)
      {
        d.H(paramView, "nearby", ".ui.NearbyPersonalInfoUI");
        AppMethodBeat.o(34676);
        return;
      }
      String str = bo.nullAsNil(((bp)localObject).getProvince());
      int i = bo.a(Integer.valueOf(((bp)localObject).dqC), 0);
      if ((bo.isNullOrNil(str)) || (i == 0))
      {
        d.H(paramView, "nearby", ".ui.NearbyPersonalInfoUI");
        AppMethodBeat.o(34676);
        return;
      }
      localObject = LauncherUI.getInstance();
      if (localObject != null) {
        ((LauncherUI)localObject).yYT.getMainTabUI().atp("tab_find_friend");
      }
      a.fF(paramView);
    }
    AppMethodBeat.o(34676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.1
 * JD-Core Version:    0.7.0.1
 */