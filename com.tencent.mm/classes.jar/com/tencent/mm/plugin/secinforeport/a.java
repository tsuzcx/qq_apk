package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.charset.Charset;
import java.util.LinkedList;

public enum a
  implements b
{
  static
  {
    AppMethodBeat.i(89142);
    xnC = new a("INSTANCE");
    xnD = new a[] { xnC };
    AppMethodBeat.o(89142);
  }
  
  private a() {}
  
  public final void a(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89141);
    if (paramString == null)
    {
      ac.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
      AppMethodBeat.o(89141);
      return;
    }
    if (!g.agM())
    {
      AppMethodBeat.o(89141);
      return;
    }
    xf localxf = new xf();
    localxf.Ery = paramInt1;
    localxf.ErA = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localxf.Erz = new SKBuiltinBuffer_t().setBuffer(paramString);
    if (!bs.cv(paramArrayOfByte)) {
      localxf.ErB = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    }
    paramString = new xg();
    paramString.ErD.add(localxf);
    paramString.ErC = paramString.ErD.size();
    ((k)g.ab(k.class)).awA().c(new j.a(211, paramString));
    AppMethodBeat.o(89141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */