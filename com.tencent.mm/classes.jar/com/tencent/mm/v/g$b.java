package com.tencent.mm.v;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/executor/OpUpdateExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
public final class g$b
  implements b.a
{
  g$b(e parame, d paramd, f paramf, com.tencent.mm.api.l paraml) {}
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(35493);
    j.q(paramf, "item");
    ab.i("FunctionMsg.OpUpdateExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramf)));
    if (paramf.Ai() > cb.abp() / 1000L)
    {
      this.eyW.a(0, paramf, this.eyX.eyQ);
      AppMethodBeat.o(35493);
      return;
    }
    ab.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] to show! id:" + this.eyY.Ad());
    this.eyZ.a(paramf.Ad(), paramf, paramf.Ag());
    AppMethodBeat.o(35493);
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(35492);
    j.q(paramf, "item");
    ab.w("FunctionMsg.OpUpdateExecutor", "[onFailFetch] item:".concat(String.valueOf(paramf)));
    if (paramf.getStatus() == -1) {
      this.eyW.a(-1, paramf, this.eyX.eyQ);
    }
    AppMethodBeat.o(35492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.v.g.b
 * JD-Core Version:    0.7.0.1
 */