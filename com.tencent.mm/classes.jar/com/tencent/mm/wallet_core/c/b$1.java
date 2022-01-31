package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.ndk.CertUtil.EventListener;

final class b$1
  implements CertUtil.EventListener
{
  b$1(b paramb) {}
  
  public final String getUniqueID()
  {
    AppMethodBeat.i(142651);
    String str = q.bP(false);
    if (bo.isNullOrNil(str))
    {
      str = q.LK();
      AppMethodBeat.o(142651);
      return str;
    }
    AppMethodBeat.o(142651);
    return str;
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(142650);
    ab.i("MicroMsg.CertUtilWx", "code ret: %s %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(142650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.b.1
 * JD-Core Version:    0.7.0.1
 */