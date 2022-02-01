package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.charset.Charset;
import java.util.LinkedList;

public enum a
  implements b
{
  static
  {
    AppMethodBeat.i(89142);
    yRD = new a("INSTANCE");
    yRE = new a[] { yRD };
    AppMethodBeat.o(89142);
  }
  
  private a() {}
  
  public final void a(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89141);
    if (paramString == null)
    {
      ae.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
      AppMethodBeat.o(89141);
      return;
    }
    if (!g.ajM())
    {
      AppMethodBeat.o(89141);
      return;
    }
    zh localzh = new zh();
    localzh.Grh = paramInt1;
    localzh.Grj = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localzh.Gri = new SKBuiltinBuffer_t().setBuffer(paramString);
    if (!bu.cF(paramArrayOfByte)) {
      localzh.Grk = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    }
    paramString = new zi();
    paramString.Grm.add(localzh);
    paramString.Grl = paramString.Grm.size();
    ((l)g.ab(l.class)).azE().d(new k.a(211, paramString));
    AppMethodBeat.o(89141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */