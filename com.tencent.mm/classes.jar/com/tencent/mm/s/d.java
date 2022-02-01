package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.v.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/engine/FunctionMsgTask;", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "(ILcom/tencent/mm/api/FunctionMsgItem;Lcom/tencent/mm/executor/IOpExecutor;)V", "mExecutor", "getMExecutor", "()Lcom/tencent/mm/executor/IOpExecutor;", "mItem", "getMItem", "()Lcom/tencent/mm/api/FunctionMsgItem;", "mOpCode", "getMOpCode", "()I", "equals", "", "other", "toString", "", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  final int hHT;
  public final j mpT;
  public final b mpU;
  
  public d(int paramInt, j paramj, b paramb)
  {
    AppMethodBeat.i(114122);
    this.hHT = paramInt;
    this.mpT = paramj;
    this.mpU = paramb;
    AppMethodBeat.o(114122);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114121);
    if ((paramObject instanceof d))
    {
      boolean bool = s.p(((d)paramObject).mpT.field_functionmsgid, this.mpT.field_functionmsgid);
      AppMethodBeat.o(114121);
      return bool;
    }
    AppMethodBeat.o(114121);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114120);
    String str = "FunctionMsgTask(mOpCode=" + this.hHT + ", mItem=" + this.mpT + ')';
    AppMethodBeat.o(114120);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.s.d
 * JD-Core Version:    0.7.0.1
 */