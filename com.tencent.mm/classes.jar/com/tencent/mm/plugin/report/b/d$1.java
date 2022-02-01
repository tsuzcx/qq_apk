package com.tencent.mm.plugin.report.b;

import com.tencent.b.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.sdk.platformtools.Log;

final class d$1
  implements f
{
  public final void eW(String paramString)
  {
    AppMethodBeat.i(134229);
    Log.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[] { paramString, Integer.valueOf(d.access$000()) });
    if (d.chC() <= 0)
    {
      Log.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[] { Integer.valueOf(d.access$000()) });
      AppMethodBeat.o(134229);
      return;
    }
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dhx();
    ((d.a)localObject).iLO = new dhy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/querymid";
    ((d.a)localObject).funcId = 684;
    localObject = ((d.a)localObject).aXF();
    ((dhx)((com.tencent.mm.ak.d)localObject).iLK.iLR).sTh = paramString;
    ((dhx)((com.tencent.mm.ak.d)localObject).iLK.iLR).him = 1;
    aa.a((com.tencent.mm.ak.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(134228);
        Log.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        AppMethodBeat.o(134228);
        return 0;
      }
    }, true);
    AppMethodBeat.o(134229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d.1
 * JD-Core Version:    0.7.0.1
 */