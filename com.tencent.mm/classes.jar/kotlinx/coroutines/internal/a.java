package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.e;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class a<T>
{
  private Object[] TVw;
  private int TVx;
  private int TVy;
  
  public a()
  {
    AppMethodBeat.i(118120);
    this.TVw = new Object[16];
    AppMethodBeat.o(118120);
  }
  
  private final void hND()
  {
    AppMethodBeat.i(118119);
    int i = this.TVw.length;
    Object[] arrayOfObject = new Object[i << 1];
    e.a(this.TVw, arrayOfObject, 0, this.TVx, 0, 10);
    e.a(this.TVw, arrayOfObject, this.TVw.length - this.TVx, 0, this.TVx, 4);
    this.TVw = arrayOfObject;
    this.TVx = 0;
    this.TVy = i;
    AppMethodBeat.o(118119);
  }
  
  public final void addLast(T paramT)
  {
    AppMethodBeat.i(118117);
    this.TVw[this.TVy] = paramT;
    this.TVy = (this.TVy + 1 & this.TVw.length - 1);
    if (this.TVy == this.TVx) {
      hND();
    }
    AppMethodBeat.o(118117);
  }
  
  public final T hNC()
  {
    AppMethodBeat.i(118118);
    if (this.TVx == this.TVy)
    {
      AppMethodBeat.o(118118);
      return null;
    }
    Object localObject = this.TVw[this.TVx];
    this.TVw[this.TVx] = null;
    this.TVx = (this.TVx + 1 & this.TVw.length - 1);
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
    return this.TVx == this.TVy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.a
 * JD-Core Version:    0.7.0.1
 */