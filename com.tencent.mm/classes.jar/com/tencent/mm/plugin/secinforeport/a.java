package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.eae;
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
    JbW = new a("INSTANCE");
    JbX = new a[] { JbW };
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
    if (!h.aHB())
    {
      AppMethodBeat.o(89141);
      return;
    }
    abe localabe = new abe();
    localabe.Snt = paramInt1;
    localabe.Snv = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localabe.Snu = new eae().dc(paramString);
    if (!Util.isNullOrNil(paramArrayOfByte)) {
      localabe.Snw = new eae().dc(paramArrayOfByte);
    }
    paramString = new abf();
    paramString.Sny.add(localabe);
    paramString.Snx = paramString.Sny.size();
    ((n)h.ae(n.class)).bbK().d(new k.a(211, paramString));
    AppMethodBeat.o(89141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */