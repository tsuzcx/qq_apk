package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.protobuf.cko;

final class d$1
  implements Runnable
{
  d$1(cko paramcko, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(1529);
    ((b)g.G(b.class)).getWebViewMgr().a(this.tfF, this.tfG);
    AppMethodBeat.o(1529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.1
 * JD-Core Version:    0.7.0.1
 */