package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class e$2
  implements x.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(33810);
    ae.i("MicroMsg.AppBrandServiceHelper", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (bdh)paramb.hQE.hQJ;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (paramString.GSJ != null))
    {
      paramb = new StringBuilder();
      paramn = paramString.GSJ.iterator();
      while (paramn.hasNext())
      {
        String str = (String)paramn.next();
        paramb.append(str + "|");
      }
      ae.d("MicroMsg.AppBrandServiceHelper", "block_qr_prefix:%s, size:%d", new Object[] { paramb.toString(), Integer.valueOf(paramString.GSJ.size()) });
      g.ajR().ajA().set(am.a.IQs, paramb.toString());
    }
    AppMethodBeat.o(33810);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e.2
 * JD-Core Version:    0.7.0.1
 */