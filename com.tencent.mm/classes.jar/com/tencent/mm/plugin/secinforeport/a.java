package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.charset.Charset;
import java.util.LinkedList;

public enum a
  implements b
{
  static
  {
    AppMethodBeat.i(57474);
    qEa = new a("INSTANCE");
    qEb = new a[] { qEa };
    AppMethodBeat.o(57474);
  }
  
  private a() {}
  
  public final void a(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(57473);
    if (paramString == null)
    {
      ab.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
      AppMethodBeat.o(57473);
      return;
    }
    if (!g.RG())
    {
      AppMethodBeat.o(57473);
      return;
    }
    tv localtv = new tv();
    localtv.wMq = paramInt1;
    localtv.wMs = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localtv.wMr = new SKBuiltinBuffer_t().setBuffer(paramString);
    if (!bo.ce(paramArrayOfByte)) {
      localtv.wMt = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    }
    paramString = new tw();
    paramString.wMv.add(localtv);
    paramString.wMu = paramString.wMv.size();
    ((j)g.E(j.class)).Yz().c(new j.a(211, paramString));
    AppMethodBeat.o(57473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */