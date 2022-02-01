package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import java.util.LinkedList;

public enum a
  implements b
{
  static
  {
    AppMethodBeat.i(89142);
    CWr = new a("INSTANCE");
    CWs = new a[] { CWr };
    AppMethodBeat.o(89142);
  }
  
  private a() {}
  
  public final void a(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89141);
    if (paramString == null)
    {
      Log.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
      AppMethodBeat.o(89141);
      return;
    }
    if (!g.aAc())
    {
      AppMethodBeat.o(89141);
      return;
    }
    aax localaax = new aax();
    localaax.Lmf = paramInt1;
    localaax.Lmh = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localaax.Lmg = new SKBuiltinBuffer_t().setBuffer(paramString);
    if (!Util.isNullOrNil(paramArrayOfByte)) {
      localaax.Lmi = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    }
    paramString = new aay();
    paramString.Lmk.add(localaax);
    paramString.Lmj = paramString.Lmk.size();
    ((l)g.af(l.class)).aSM().d(new k.a(211, paramString));
    AppMethodBeat.o(89141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */