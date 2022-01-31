package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.protobuf.cko;

final class d$2
  implements Runnable
{
  d$2(cko paramcko, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(1530);
    ((b)g.G(b.class)).getWebViewMgr().a(this.tfF, this.tfH);
    AppMethodBeat.o(1530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.2
 * JD-Core Version:    0.7.0.1
 */