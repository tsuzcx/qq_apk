package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, csu paramcsu) {}
  
  public final void run()
  {
    AppMethodBeat.i(4697);
    com.tencent.mm.plugin.voip.b.cLC().cNZ();
    a.Logi(this.tzK.tzJ.TAG, "steve:doublelink timer started!");
    this.tzK.tzJ.tvE.a(this.tzH.ybp, this.tzH.ybq, this.tzH.ybx, this.tzH.ybQ);
    if (this.tzH.xZX.wtq.getBuffer() != null)
    {
      this.tzK.tzJ.tvE.br(this.tzH.xZX.wtq.getBuffer().toByteArray());
      if ((this.tzH.ybv != null) && (this.tzH.ybv.getBuffer() != null) && (this.tzH.ybH != null) && (this.tzH.ybH.getBuffer() != null)) {
        this.tzK.tzJ.tvE.a(this.tzH.ybv.getBuffer().toByteArray(), this.tzH.ybu, this.tzH.nNv, this.tzH.ybH.getBuffer().toByteArray());
      }
      this.tzK.tzJ.tvE.i(this.tzH.yby, this.tzH.ybz, this.tzH.ybA, this.tzH.ybB, this.tzH.ybC);
      this.tzK.tzJ.tvE.Ho(this.tzH.ybG);
      if ((this.tzH.ybE != null) && (this.tzH.ybF != null) && (this.tzH.ybE.getBuffer() != null) && (this.tzH.ybF.getBuffer() != null)) {
        this.tzK.tzJ.tvE.c(this.tzH.ybD, this.tzH.ybE.getBuffer().toByteArray(), this.tzH.ybF.getBuffer().toByteArray());
      }
      if (this.tzH.xZY.wtq.getBuffer() == null) {
        break label638;
      }
      this.tzK.tzJ.tvE.bs(this.tzH.xZY.wtq.getBuffer().toByteArray());
      label417:
      this.tzK.tzJ.tvE.Hn(this.tzH.ybJ);
      this.tzK.tzJ.tvE.tvj.tBh = this.tzH.ybK;
      if ((this.tzH.ybM != null) && (this.tzH.ybM.getBuffer() != null)) {
        this.tzK.tzJ.tvE.tvj.tAl = this.tzH.ybM.getBuffer().toByteArray();
      }
      if (!this.tzK.tzJ.tvE.tuL) {
        break label732;
      }
      this.tzK.tzJ.tvE.tuL = false;
      if (this.tzK.tzJ.tvE.tuH != true) {
        break label656;
      }
      a.Logi(this.tzK.tzJ.TAG, "channel pre-connect already success, start talk");
      this.tzK.tzJ.tvE.cMf();
    }
    for (;;)
    {
      this.tzK.tzJ.tvE.cMm();
      this.tzK.tzJ.tvE.cMk();
      AppMethodBeat.o(4697);
      return;
      ab.e(this.tzK.tzJ.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
      break;
      label638:
      ab.e(this.tzK.tzJ.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
      break label417;
      label656:
      if (this.tzK.tzJ.tvE.tuK == true)
      {
        a.Logi(this.tzK.tzJ.TAG, "channel pre-connect already failed");
        this.tzK.tzJ.tvE.y(1, -9000, "");
        AppMethodBeat.o(4697);
        return;
      }
      a.Logi(this.tzK.tzJ.TAG, "channel pre-connect still connecting...");
      continue;
      label732:
      ab.i(this.tzK.tzJ.TAG, "isPreConnect is false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b.1.1
 * JD-Core Version:    0.7.0.1
 */