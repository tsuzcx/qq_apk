package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ak;

final class u$a$1$1
  implements Runnable
{
  u$a$1$1(u.a.1 param1, ud paramud) {}
  
  public final void run()
  {
    AppMethodBeat.i(36301);
    if (!this.rfn.rfl.rfi.a(this.rfm, this.rfn.rfl.mur)) {
      this.rfn.rfl.mur.sendEmptyMessage(0);
    }
    AppMethodBeat.o(36301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.a.1.1
 * JD-Core Version:    0.7.0.1
 */