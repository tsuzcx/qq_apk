package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.f;
import d.l;

@f(c="kotlinx.coroutines.DeferredCoroutine", f="Builders.common.kt", l={99}, m="await$suspendImpl")
@l(fvt={1, 1, 16}, fvu={""}, fvv={"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"})
final class am$a
  extends d.d.b.a.d
{
  int label;
  Object mTb;
  
  am$a(am paramam, d.d.d paramd)
  {
    super(paramd);
  }
  
  public final Object cP(Object paramObject)
  {
    AppMethodBeat.i(118042);
    this.result = paramObject;
    this.label |= 0x80000000;
    paramObject = am.a(this.KdL, this);
    AppMethodBeat.o(118042);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.am.a
 * JD-Core Version:    0.7.0.1
 */