package com.tencent.mm.plugin.report.b;

import com.tencent.b.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.sdk.platformtools.ad;

final class d$1
  implements f
{
  public final void ei(String paramString)
  {
    AppMethodBeat.i(134229);
    ad.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[] { paramString, Integer.valueOf(d.access$000()) });
    if (d.bJL() <= 0)
    {
      ad.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[] { Integer.valueOf(d.access$000()) });
      AppMethodBeat.o(134229);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cpe();
    ((b.a)localObject).hNN = new cpf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/querymid";
    ((b.a)localObject).funcId = 684;
    localObject = ((b.a)localObject).aDC();
    ((cpe)((b)localObject).hNK.hNQ).rjM = paramString;
    ((cpe)((b)localObject).hNK.hNQ).gsV = 1;
    x.a((b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(134228);
        ad.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
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