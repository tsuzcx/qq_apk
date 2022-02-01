package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<T>
{
  private int aivl;
  private Object[] ajAd;
  private int ajAe;
  
  public a()
  {
    AppMethodBeat.i(118120);
    this.ajAd = new Object[16];
    AppMethodBeat.o(118120);
  }
  
  private final void kDN()
  {
    AppMethodBeat.i(118119);
    int i = this.ajAd.length;
    Object[] arrayOfObject = new Object[i << 1];
    k.a(this.ajAd, arrayOfObject, 0, this.aivl, 0, 10);
    k.a(this.ajAd, arrayOfObject, this.ajAd.length - this.aivl, 0, this.aivl, 4);
    this.ajAd = arrayOfObject;
    this.aivl = 0;
    this.ajAe = i;
    AppMethodBeat.o(118119);
  }
  
  public final void hr(T paramT)
  {
    AppMethodBeat.i(118117);
    this.ajAd[this.ajAe] = paramT;
    this.ajAe = (this.ajAe + 1 & this.ajAd.length - 1);
    if (this.ajAe == this.aivl) {
      kDN();
    }
    AppMethodBeat.o(118117);
  }
  
  public final boolean isEmpty()
  {
    return this.aivl == this.ajAe;
  }
  
  public final T kkV()
  {
    AppMethodBeat.i(118118);
    if (this.aivl == this.ajAe)
    {
      AppMethodBeat.o(118118);
      return null;
    }
    Object localObject = this.ajAd[this.aivl];
    this.ajAd[this.aivl] = null;
    this.aivl = (this.aivl + 1 & this.ajAd.length - 1);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
      AppMethodBeat.o(118118);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(118118);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.a
 * JD-Core Version:    0.7.0.1
 */