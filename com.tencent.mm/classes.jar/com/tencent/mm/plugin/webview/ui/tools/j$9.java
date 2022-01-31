package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class j$9
  implements n.c
{
  j$9(j paramj, JsapiPermissionWrapper paramJsapiPermissionWrapper) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(153213);
    if (this.vcO.a(this.vcR, 23, 2)) {
      paraml.a(2, this.vcO.ddt().getString(2131302283), 2131231024, false);
    }
    if (this.vcO.a(this.vcR, 21, 1)) {
      paraml.a(1, this.vcO.ddt().getString(2131302282), 2131231038, false);
    }
    AppMethodBeat.o(153213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.9
 * JD-Core Version:    0.7.0.1
 */