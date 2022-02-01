package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cd;

final class b$8
  implements Runnable
{
  b$8(b paramb, int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(151919);
    cd localcd = new cd();
    localcd.hCg.hCh = this.Kry;
    localcd.hCg.subType = this.rxn;
    localcd.hCg.filePath = this.val$filePath;
    localcd.hCg.hCi = this.XVw;
    localcd.hCg.hCj = this.XVx;
    localcd.hCg.hCk = this.oJE;
    localcd.publish();
    AppMethodBeat.o(151919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.8
 * JD-Core Version:    0.7.0.1
 */