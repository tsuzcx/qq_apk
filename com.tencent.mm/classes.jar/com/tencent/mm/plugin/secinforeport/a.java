package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.protocal.protobuf.zf;
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
    yBD = new a("INSTANCE");
    yBE = new a[] { yBD };
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
    if (!g.ajx())
    {
      AppMethodBeat.o(89141);
      return;
    }
    ze localze = new ze();
    localze.FYI = paramInt1;
    localze.FYK = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localze.FYJ = new SKBuiltinBuffer_t().setBuffer(paramString);
    if (!bt.cC(paramArrayOfByte)) {
      localze.FYL = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    }
    paramString = new zf();
    paramString.FYN.add(localze);
    paramString.FYM = paramString.FYN.size();
    ((l)g.ab(l.class)).azo().c(new k.a(211, paramString));
    AppMethodBeat.o(89141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */