package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.c;
import d.d.b.a.e;
import d.d.d;
import d.l;

@e(c="com.tencent.mm.plugin.vlog.model.MultiMediaModel", f="MultiMediaModel.kt", l={277}, m="asyncCreateCompositionFromSource")
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"asyncCreateCompositionFromSource", "", "maxDurationMs", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
final class k$a
  extends c
{
  long Any;
  int label;
  Object nIC;
  Object nvt;
  
  k$a(k paramk, d paramd)
  {
    super(paramd);
  }
  
  public final Object cO(Object paramObject)
  {
    AppMethodBeat.i(207518);
    this.result = paramObject;
    this.label |= 0x80000000;
    paramObject = this.Anx.a(0L, this);
    AppMethodBeat.o(207518);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.k.a
 * JD-Core Version:    0.7.0.1
 */