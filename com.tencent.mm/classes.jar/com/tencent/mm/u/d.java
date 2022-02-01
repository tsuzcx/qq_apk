package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.v.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/engine/FunctionMsgTask;", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "(ILcom/tencent/mm/api/FunctionMsgItem;Lcom/tencent/mm/executor/IOpExecutor;)V", "mExecutor", "getMExecutor", "()Lcom/tencent/mm/executor/IOpExecutor;", "mItem", "getMItem", "()Lcom/tencent/mm/api/FunctionMsgItem;", "mOpCode", "getMOpCode", "()I", "equals", "", "other", "toString", "", "plugin-functionmsg_release"})
public final class d
{
  final int dKp;
  public final i heU;
  public final b heV;
  
  public d(int paramInt, i parami, b paramb)
  {
    AppMethodBeat.i(114122);
    this.dKp = paramInt;
    this.heU = parami;
    this.heV = paramb;
    AppMethodBeat.o(114122);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114121);
    if ((paramObject instanceof d))
    {
      boolean bool = p.j(((d)paramObject).heU.Vk(), this.heU.Vk());
      AppMethodBeat.o(114121);
      return bool;
    }
    AppMethodBeat.o(114121);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114120);
    String str = "FunctionMsgTask(mOpCode=" + this.dKp + ", mItem=" + this.heU + ')';
    AppMethodBeat.o(114120);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.u.d
 * JD-Core Version:    0.7.0.1
 */