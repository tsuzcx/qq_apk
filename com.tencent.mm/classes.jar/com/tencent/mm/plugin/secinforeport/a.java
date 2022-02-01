package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.gol;
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
    PlM = new a("INSTANCE");
    PlN = new a[] { PlM };
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
    if (!h.baz())
    {
      AppMethodBeat.o(89141);
      return;
    }
    adg localadg = new adg();
    localadg.ZlP = paramInt1;
    localadg.ZlR = paramInt2;
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    localadg.ZlQ = new gol().df(paramString);
    if (!Util.isNullOrNil(paramArrayOfByte)) {
      localadg.ZlS = new gol().df(paramArrayOfByte);
    }
    paramString = new adh();
    paramString.ZlU.add(localadg);
    paramString.ZlT = paramString.ZlU.size();
    ((n)h.ax(n.class)).bzz().d(new k.a(211, paramString));
    AppMethodBeat.o(89141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a
 * JD-Core Version:    0.7.0.1
 */