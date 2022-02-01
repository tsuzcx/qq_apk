package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.sy;
import com.tencent.mm.autogen.a.sy.b;
import com.tencent.mm.plugin.product.model.b;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class f$2
  implements Runnable
{
  f$2(f paramf, sy paramsy) {}
  
  public final void run()
  {
    AppMethodBeat.i(66963);
    Log.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(this.MSu.hWs.errCode), Boolean.valueOf(this.MSu.hWs.hWt) });
    if (this.MSu.hWs.errCode == 0)
    {
      b localb = f.c(this.MSt);
      sy localsy = this.MSu;
      ee localee = new ee();
      localee.UserName = localsy.hWs.userName;
      localee.YGl = localsy.hWs.hWv;
      localee.YGm = localsy.hWs.hWw;
      localee.pSg = localsy.hWs.hWx;
      localee.pSh = localsy.hWs.hWy;
      localee.pSo = localsy.hWs.hWz;
      localee.IIu = localsy.hWs.hWB;
      if ((!Util.isNullOrNil(localee.UserName)) && (!Util.isNullOrNil(localee.YGl))) {
        localb.MQF = localee;
      }
    }
    f.d(this.MSt);
    AppMethodBeat.o(66963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f.2
 * JD-Core Version:    0.7.0.1
 */