package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.subapp.jdbiz.b;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class FindMoreFriendsUI$25
  implements DialogInterface.OnClickListener
{
  FindMoreFriendsUI$25(FindMoreFriendsUI paramFindMoreFriendsUI, b paramb, AppBrandStatObject paramAppBrandStatObject) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(250069);
    ((t)h.ax(t.class)).a(this.adyF.getContext(), this.adyJ.username, "", 0, this.adyJ.version, this.adyJ.path, this.STg);
    h.baE().ban().set(at.a.acZx, Boolean.TRUE);
    AppMethodBeat.o(250069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.25
 * JD-Core Version:    0.7.0.1
 */