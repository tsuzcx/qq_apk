package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.i.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class ah$1$3
  implements af.a
{
  ah$1$3(ah.1 param1, d paramd) {}
  
  public final void cG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27374);
    ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      aw.RO().ac(new ah.1.3.1(this));
      AppMethodBeat.o(27374);
      return;
    }
    new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(this.vLN.vLM.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(c.cb(com.tencent.mm.sdk.platformtools.ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(this.fyV.field_fileLength), this.fyV.field_transInfo, "", "", "", "", "", "", "", this.fyV.edb })).ake();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.vLN.vLM.d(this.fyV);
    }
    this.vLN.vLM.callback.onSceneEnd(paramInt1, paramInt2, "", this.vLN.vLM);
    AppMethodBeat.o(27374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah.1.3
 * JD-Core Version:    0.7.0.1
 */