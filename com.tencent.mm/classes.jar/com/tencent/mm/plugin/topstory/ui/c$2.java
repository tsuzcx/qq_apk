package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.protobuf.eii;

final class c$2
  implements Runnable
{
  c$2(eii parameii, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(125866);
    ((b)g.ah(b.class)).getWebViewMgr().a(this.GjW, this.GjY);
    AppMethodBeat.o(125866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.2
 * JD-Core Version:    0.7.0.1
 */