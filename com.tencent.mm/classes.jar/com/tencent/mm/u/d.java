package com.tencent.mm.u;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.v.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/engine/FunctionMsgTask;", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "(ILcom/tencent/mm/api/FunctionMsgItem;Lcom/tencent/mm/executor/IOpExecutor;)V", "mExecutor", "getMExecutor", "()Lcom/tencent/mm/executor/IOpExecutor;", "mItem", "getMItem", "()Lcom/tencent/mm/api/FunctionMsgItem;", "mOpCode", "getMOpCode", "()I", "equals", "", "other", "toString", "", "plugin-functionmsg_release"})
public final class d
{
  final int cuo;
  public final f eyP;
  public final b eyQ;
  
  public d(int paramInt, f paramf, b paramb)
  {
    AppMethodBeat.i(35470);
    this.cuo = paramInt;
    this.eyP = paramf;
    this.eyQ = paramb;
    AppMethodBeat.o(35470);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(35469);
    if ((paramObject instanceof d))
    {
      boolean bool = j.e(((d)paramObject).eyP.Ad(), this.eyP.Ad());
      AppMethodBeat.o(35469);
      return bool;
    }
    AppMethodBeat.o(35469);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(35468);
    String str = "FunctionMsgTask(mOpCode=" + this.cuo + ", mItem=" + this.eyP + ')';
    AppMethodBeat.o(35468);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.u.d
 * JD-Core Version:    0.7.0.1
 */