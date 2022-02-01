package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.subapp.jdbiz.b;

final class FindMoreFriendsUI$16
  implements Runnable
{
  FindMoreFriendsUI$16(FindMoreFriendsUI paramFindMoreFriendsUI, b paramb, AppBrandStatObject paramAppBrandStatObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(33049);
    ((n)g.ab(n.class)).a(this.FJN.getContext(), this.FJR.username, "", 0, this.FJR.version, this.FJR.path, this.lVo);
    AppMethodBeat.o(33049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.16
 * JD-Core Version:    0.7.0.1
 */