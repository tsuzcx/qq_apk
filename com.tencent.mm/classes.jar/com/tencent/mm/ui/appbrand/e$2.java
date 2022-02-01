package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class e$2
  implements z.a
{
  public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(33810);
    Log.i("MicroMsg.AppBrandServiceHelper", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (clt)c.c.b(paramc.otC);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (paramString.aatJ != null))
    {
      paramc = new StringBuilder();
      paramp = paramString.aatJ.iterator();
      while (paramp.hasNext())
      {
        String str = (String)paramp.next();
        paramc.append(str + "|");
      }
      Log.d("MicroMsg.AppBrandServiceHelper", "block_qr_prefix:%s, size:%d", new Object[] { paramc.toString(), Integer.valueOf(paramString.aatJ.size()) });
      h.baE().ban().set(at.a.acNO, paramc.toString());
    }
    AppMethodBeat.o(33810);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e.2
 * JD-Core Version:    0.7.0.1
 */