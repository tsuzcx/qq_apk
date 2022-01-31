package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.la;
import com.tencent.mm.plugin.scanner.util.f.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements f.a
{
  b$1(b paramb) {}
  
  public final void q(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80824);
    ab.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramInt) });
    la localla = new la();
    localla.cBj.cBh = paramInt;
    localla.cBj.activity = this.quj.mActivity;
    localla.cBj.cnR = this.quj.qud;
    localla.cBj.cBk = paramBundle;
    a.ymk.l(localla);
    AppMethodBeat.o(80824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.b.1
 * JD-Core Version:    0.7.0.1
 */