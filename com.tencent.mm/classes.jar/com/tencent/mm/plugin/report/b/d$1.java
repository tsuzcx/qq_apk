package com.tencent.mm.plugin.report.b;

import com.tencent.c.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements f
{
  public final void cG(String paramString)
  {
    AppMethodBeat.i(123497);
    ab.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[] { paramString, Integer.valueOf(d.access$000()) });
    if (d.EV() <= 0)
    {
      ab.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[] { Integer.valueOf(d.access$000()) });
      AppMethodBeat.o(123497);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bqg();
    ((b.a)localObject).fsY = new bqh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/querymid";
    ((b.a)localObject).funcId = 684;
    localObject = ((b.a)localObject).ado();
    ((bqg)((b)localObject).fsV.fta).mkE = paramString;
    ((bqg)((b)localObject).fsV.fta).nrS = 1;
    w.a((b)localObject, new d.1.1(this), true);
    AppMethodBeat.o(123497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d.1
 * JD-Core Version:    0.7.0.1
 */