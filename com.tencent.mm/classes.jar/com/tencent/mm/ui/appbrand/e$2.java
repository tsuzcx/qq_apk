package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class e$2
  implements aa.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(33810);
    Log.i("MicroMsg.AppBrandServiceHelper", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (bov)paramd.iLL.iLR;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (paramString.LWV != null))
    {
      paramd = new StringBuilder();
      paramq = paramString.LWV.iterator();
      while (paramq.hasNext())
      {
        String str = (String)paramq.next();
        paramd.append(str + "|");
      }
      Log.d("MicroMsg.AppBrandServiceHelper", "block_qr_prefix:%s, size:%d", new Object[] { paramd.toString(), Integer.valueOf(paramString.LWV.size()) });
      g.aAh().azQ().set(ar.a.NYt, paramd.toString());
    }
    AppMethodBeat.o(33810);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e.2
 * JD-Core Version:    0.7.0.1
 */