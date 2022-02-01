package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class a<T>
{
  private int OgA;
  private int OgB;
  private Object[] Ogz;
  
  public a()
  {
    AppMethodBeat.i(118120);
    this.Ogz = new Object[16];
    AppMethodBeat.o(118120);
  }
  
  private final void gAw()
  {
    AppMethodBeat.i(118119);
    int i = this.Ogz.length;
    Object[] arrayOfObject = new Object[i << 1];
    e.a(this.Ogz, arrayOfObject, 0, this.OgA, 0, 10);
    e.a(this.Ogz, arrayOfObject, this.Ogz.length - this.OgA, 0, this.OgA, 4);
    this.Ogz = arrayOfObject;
    this.OgA = 0;
    this.OgB = i;
    AppMethodBeat.o(118119);
  }
  
  public final void addLast(T paramT)
  {
    AppMethodBeat.i(118117);
    this.Ogz[this.OgB] = paramT;
    this.OgB = (this.OgB + 1 & this.Ogz.length - 1);
    if (this.OgB == this.OgA) {
      gAw();
    }
    AppMethodBeat.o(118117);
  }
  
  public final T gAv()
  {
    AppMethodBeat.i(118118);
    if (this.OgA == this.OgB)
    {
      AppMethodBeat.o(118118);
      return null;
    }
    Object localObject = this.Ogz[this.OgA];
    this.Ogz[this.OgA] = null;
    this.OgA = (this.OgA + 1 & this.Ogz.length - 1);
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
    return this.OgA == this.OgB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.a
 * JD-Core Version:    0.7.0.1
 */