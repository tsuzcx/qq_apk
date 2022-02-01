package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.v.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/engine/FunctionMsgTask;", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "(ILcom/tencent/mm/api/FunctionMsgItem;Lcom/tencent/mm/executor/IOpExecutor;)V", "mExecutor", "getMExecutor", "()Lcom/tencent/mm/executor/IOpExecutor;", "mItem", "getMItem", "()Lcom/tencent/mm/api/FunctionMsgItem;", "mOpCode", "getMOpCode", "()I", "equals", "", "other", "toString", "", "plugin-functionmsg_release"})
public final class d
{
  final int dji;
  public final h fTu;
  public final b fTv;
  
  public d(int paramInt, h paramh, b paramb)
  {
    AppMethodBeat.i(114122);
    this.dji = paramInt;
    this.fTu = paramh;
    this.fTv = paramb;
    AppMethodBeat.o(114122);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114121);
    if ((paramObject instanceof d))
    {
      boolean bool = k.g(((d)paramObject).fTu.JK(), this.fTu.JK());
      AppMethodBeat.o(114121);
      return bool;
    }
    AppMethodBeat.o(114121);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114120);
    String str = "FunctionMsgTask(mOpCode=" + this.dji + ", mItem=" + this.fTu + ')';
    AppMethodBeat.o(114120);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.u.d
 * JD-Core Version:    0.7.0.1
 */