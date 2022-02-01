package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cf;

final class b$2
  implements Runnable
{
  b$2(b paramb, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(151911);
    cf localcf = new cf();
    localcf.hCo.hAf = this.XVm;
    localcf.hCo.hCh = this.Kry;
    localcf.hCo.subType = this.rxn;
    localcf.hCo.hCn = this.XVn;
    localcf.publish();
    AppMethodBeat.o(151911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.2
 * JD-Core Version:    0.7.0.1
 */