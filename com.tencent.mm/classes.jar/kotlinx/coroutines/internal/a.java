package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class a<T>
{
  private Object[] LSx;
  private int LSy;
  private int LSz;
  
  public a()
  {
    AppMethodBeat.i(118120);
    this.LSx = new Object[16];
    AppMethodBeat.o(118120);
  }
  
  private final void gev()
  {
    AppMethodBeat.i(118119);
    int i = this.LSx.length;
    Object[] arrayOfObject = new Object[i << 1];
    e.a(this.LSx, arrayOfObject, 0, this.LSy, 0, 10);
    e.a(this.LSx, arrayOfObject, this.LSx.length - this.LSy, 0, this.LSy, 4);
    this.LSx = arrayOfObject;
    this.LSy = 0;
    this.LSz = i;
    AppMethodBeat.o(118119);
  }
  
  public final void addLast(T paramT)
  {
    AppMethodBeat.i(118117);
    this.LSx[this.LSz] = paramT;
    this.LSz = (this.LSz + 1 & this.LSx.length - 1);
    if (this.LSz == this.LSy) {
      gev();
    }
    AppMethodBeat.o(118117);
  }
  
  public final T geu()
  {
    AppMethodBeat.i(118118);
    if (this.LSy == this.LSz)
    {
      AppMethodBeat.o(118118);
      return null;
    }
    Object localObject = this.LSx[this.LSy];
    this.LSx[this.LSy] = null;
    this.LSy = (this.LSy + 1 & this.LSx.length - 1);
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
    return this.LSy == this.LSz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.a
 * JD-Core Version:    0.7.0.1
 */