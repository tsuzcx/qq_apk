package com.tencent.mm.v;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
public final class e$b
  implements b.a
{
  e$b(e parame, d paramd) {}
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(35485);
    j.q(paramf, "item");
    ab.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramf)));
    if (paramf.Ai() > cb.abp() / 1000L) {
      this.eyW.a(2, paramf, this.eyX.eyQ);
    }
    AppMethodBeat.o(35485);
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(35484);
    j.q(paramf, "item");
    ab.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:".concat(String.valueOf(paramf)));
    if (paramf.getStatus() == -1) {
      this.eyW.a(-1, paramf, this.eyX.eyQ);
    }
    AppMethodBeat.o(35484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.e.b
 * JD-Core Version:    0.7.0.1
 */