package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class e$2
  implements x.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(33810);
    ad.i("MicroMsg.AppBrandServiceHelper", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (bcr)paramb.hNL.hNQ;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (paramString.Gzj != null))
    {
      paramb = new StringBuilder();
      paramn = paramString.Gzj.iterator();
      while (paramn.hasNext())
      {
        String str = (String)paramn.next();
        paramb.append(str + "|");
      }
      ad.d("MicroMsg.AppBrandServiceHelper", "block_qr_prefix:%s, size:%d", new Object[] { paramb.toString(), Integer.valueOf(paramString.Gzj.size()) });
      g.ajC().ajl().set(al.a.IvU, paramb.toString());
    }
    AppMethodBeat.o(33810);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e.2
 * JD-Core Version:    0.7.0.1
 */