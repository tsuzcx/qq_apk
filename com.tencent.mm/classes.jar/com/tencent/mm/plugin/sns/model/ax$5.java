package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.sdk.platformtools.ab;

final class ax$5
  implements Runnable
{
  ax$5(ax paramax, int paramInt1, String paramString, boolean paramBoolean, bct parambct, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(36686);
    if (ag.coN())
    {
      ab.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
      AppMethodBeat.o(36686);
      return;
    }
    z localz = new z(this.rje, this.rjf, this.rjg, this.rjh);
    ag.cpe().fv(this.rje, localz.hashCode());
    g.RM();
    g.RK().eHt.a(localz, 0);
    AppMethodBeat.o(36686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax.5
 * JD-Core Version:    0.7.0.1
 */