package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.e;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class a<T>
{
  private Object[] abyO;
  private int abyP;
  private int abyp;
  
  public a()
  {
    AppMethodBeat.i(118120);
    this.abyO = new Object[16];
    AppMethodBeat.o(118120);
  }
  
  private final void iSE()
  {
    AppMethodBeat.i(118119);
    int i = this.abyO.length;
    Object[] arrayOfObject = new Object[i << 1];
    e.a(this.abyO, arrayOfObject, 0, this.abyp, 0, 10);
    e.a(this.abyO, arrayOfObject, this.abyO.length - this.abyp, 0, this.abyp, 4);
    this.abyO = arrayOfObject;
    this.abyp = 0;
    this.abyP = i;
    AppMethodBeat.o(118119);
  }
  
  public final void gv(T paramT)
  {
    AppMethodBeat.i(118117);
    this.abyO[this.abyP] = paramT;
    this.abyP = (this.abyP + 1 & this.abyO.length - 1);
    if (this.abyP == this.abyp) {
      iSE();
    }
    AppMethodBeat.o(118117);
  }
  
  public final T iSD()
  {
    AppMethodBeat.i(118118);
    if (this.abyp == this.abyP)
    {
      AppMethodBeat.o(118118);
      return null;
    }
    Object localObject = this.abyO[this.abyp];
    this.abyO[this.abyp] = null;
    this.abyp = (this.abyp + 1 & this.abyO.length - 1);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type T");
      AppMethodBeat.o(118118);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(118118);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    return this.abyp == this.abyP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.a
 * JD-Core Version:    0.7.0.1
 */