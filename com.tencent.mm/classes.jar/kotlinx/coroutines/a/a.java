package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class a<T>
{
  private Object[] KeX;
  private int KeY;
  private int KeZ;
  
  public a()
  {
    AppMethodBeat.i(118120);
    this.KeX = new Object[16];
    AppMethodBeat.o(118120);
  }
  
  private final void fLK()
  {
    AppMethodBeat.i(118119);
    int i = this.KeX.length;
    Object[] arrayOfObject = new Object[i << 1];
    e.a(this.KeX, arrayOfObject, 0, this.KeY, 0, 10);
    e.a(this.KeX, arrayOfObject, this.KeX.length - this.KeY, 0, this.KeY, 4);
    this.KeX = arrayOfObject;
    this.KeY = 0;
    this.KeZ = i;
    AppMethodBeat.o(118119);
  }
  
  public final void addLast(T paramT)
  {
    AppMethodBeat.i(118117);
    this.KeX[this.KeZ] = paramT;
    this.KeZ = (this.KeZ + 1 & this.KeX.length - 1);
    if (this.KeZ == this.KeY) {
      fLK();
    }
    AppMethodBeat.o(118117);
  }
  
  public final T fLJ()
  {
    AppMethodBeat.i(118118);
    if (this.KeY == this.KeZ)
    {
      AppMethodBeat.o(118118);
      return null;
    }
    Object localObject = this.KeX[this.KeY];
    this.KeX[this.KeY] = null;
    this.KeY = (this.KeY + 1 & this.KeX.length - 1);
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
    return this.KeY == this.KeZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.a
 * JD-Core Version:    0.7.0.1
 */