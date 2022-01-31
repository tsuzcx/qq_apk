package com.tencent.mm.plugin.scanner.a;

import android.os.Bundle;
import com.tencent.mm.h.a.km;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements e.a
{
  b$1(b paramb) {}
  
  public final void n(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramInt) });
    km localkm = new km();
    localkm.bTC.bTA = paramInt;
    localkm.bTC.activity = this.nGS.mActivity;
    localkm.bTC.bGE = this.nGS.nGM;
    localkm.bTC.bTD = paramBundle;
    a.udP.m(localkm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.b.1
 * JD-Core Version:    0.7.0.1
 */