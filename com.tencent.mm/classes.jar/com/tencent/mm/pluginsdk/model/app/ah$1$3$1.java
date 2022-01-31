package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ah$1$3$1
  implements Runnable
{
  ah$1$3$1(ah.1.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(27373);
    this.vLP.vLN.vLM.fFG = false;
    this.vLP.vLN.vLM.pYg.field_createTime = bo.aoy();
    this.vLP.vLN.vLM.pYg.field_lastModifyTime = bo.aox();
    this.vLP.vLN.vLM.pYg.field_offset = 0L;
    this.vLP.vLN.vLM.pYg.field_status = 101L;
    boolean bool = al.aUJ().a(this.vLP.vLN.vLM.pYg, new String[0]);
    ab.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(this.vLP.vLN.vLM.fFG), Boolean.valueOf(bool), Long.valueOf(this.vLP.vLN.vLM.pYg.field_createTime) });
    this.vLP.vLN.vLM.doScene(this.vLP.vLN.vLM.dispatcher(), this.vLP.vLN.vLM.callback);
    AppMethodBeat.o(27373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah.1.3.1
 * JD-Core Version:    0.7.0.1
 */