package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.protocal.protobuf.mj;

final class RemittanceBusiResultUI$1
  implements Runnable
{
  RemittanceBusiResultUI$1(RemittanceBusiResultUI paramRemittanceBusiResultUI)
  {
    AppMethodBeat.i(44868);
    AppMethodBeat.o(44868);
  }
  
  public final void run()
  {
    AppMethodBeat.i(142163);
    RemittanceBusiResultUI.a(this.qnm);
    j localj = new j(RemittanceBusiResultUI.b(this.qnm), RemittanceBusiResultUI.c(this.qnm), RemittanceBusiResultUI.d(this.qnm).bsY, RemittanceBusiResultUI.e(this.qnm) - 1, System.currentTimeMillis());
    this.qnm.doSceneProgress(localj);
    RemittanceBusiResultUI.f(this.qnm);
    AppMethodBeat.o(142163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.1
 * JD-Core Version:    0.7.0.1
 */