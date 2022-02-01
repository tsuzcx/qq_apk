package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class a<T>
{
  private Object[] NJt;
  private int NJu;
  private int NJv;
  
  public a()
  {
    AppMethodBeat.i(118120);
    this.NJt = new Object[16];
    AppMethodBeat.o(118120);
  }
  
  private final void gvU()
  {
    AppMethodBeat.i(118119);
    int i = this.NJt.length;
    Object[] arrayOfObject = new Object[i << 1];
    e.a(this.NJt, arrayOfObject, 0, this.NJu, 0, 10);
    e.a(this.NJt, arrayOfObject, this.NJt.length - this.NJu, 0, this.NJu, 4);
    this.NJt = arrayOfObject;
    this.NJu = 0;
    this.NJv = i;
    AppMethodBeat.o(118119);
  }
  
  public final void addLast(T paramT)
  {
    AppMethodBeat.i(118117);
    this.NJt[this.NJv] = paramT;
    this.NJv = (this.NJv + 1 & this.NJt.length - 1);
    if (this.NJv == this.NJu) {
      gvU();
    }
    AppMethodBeat.o(118117);
  }
  
  public final T gvT()
  {
    AppMethodBeat.i(118118);
    if (this.NJu == this.NJv)
    {
      AppMethodBeat.o(118118);
      return null;
    }
    Object localObject = this.NJt[this.NJu];
    this.NJt[this.NJu] = null;
    this.NJu = (this.NJu + 1 & this.NJt.length - 1);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type T");
      AppMethodBeat.o(118118);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(118118);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    return this.NJu == this.NJv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.a
 * JD-Core Version:    0.7.0.1
 */