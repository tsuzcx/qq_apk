package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.charset.Charset;
import java.util.LinkedList;

public enum a
  implements b
{
  static
  {
    AppMethodBeat.i(89142);
    wcr = new a("INSTANCE");
    wcs = new a[] { wcr };
    AppMethodBeat.o(89142);
  }
  
  private a() {}
  
  public final void a(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89141);
    if (paramString == null)
    {
      ad.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
      AppMethodBeat.o(89141);
      return;
    }
    if (!g.afw())
    {
      AppMethodBeat.o(89141);
      return;
    }
    wt localwt = new wt();
    localwt.CYN = paramInt1;
    localwt.CYP = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localwt.CYO = new SKBuiltinBuffer_t().setBuffer(paramString);
    if (!bt.cw(paramArrayOfByte)) {
      localwt.CYQ = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    }
    paramString = new wu();
    paramString.CYS.add(localwt);
    paramString.CYR = paramString.CYS.size();
    ((k)g.ab(k.class)).apL().c(new j.a(211, paramString));
    AppMethodBeat.o(89141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */