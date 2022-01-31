package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

final class ax$4
  implements Runnable
{
  ax$4(ax paramax, String paramString1, bct parambct, List paramList, TimeLineObject paramTimeLineObject, int paramInt, boolean paramBoolean, LinkedList paramLinkedList, com.tencent.mm.bv.b paramb, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(36685);
    if (ag.coN())
    {
      ab.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
      AppMethodBeat.o(36685);
      return;
    }
    ax.a(this.riW, new s(this.fOX, this.riY.xrU, this.riY.xsp, this.riZ, this.rja, this.riX, this.riY.pIw, this.riY.xsu, this.riY.xsv, this.riY.xsw, this.riY, this.rjb, this.rjc, this.riY.xsA, this.rjd, this.cbK));
    g.RM();
    g.RK().eHt.a(ax.d(this.riW), 0);
    AppMethodBeat.o(36685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax.4
 * JD-Core Version:    0.7.0.1
 */