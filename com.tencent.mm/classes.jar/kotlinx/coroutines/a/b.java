package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class b<T>
{
  private Object[] CIS;
  private int CIT;
  private int vlh;
  
  public b()
  {
    AppMethodBeat.i(118440);
    this.CIS = new Object[16];
    AppMethodBeat.o(118440);
  }
  
  private final void eqd()
  {
    AppMethodBeat.i(118439);
    int i = this.CIS.length;
    Object[] arrayOfObject = new Object[i << 1];
    int j = this.CIS.length - this.CIT;
    a.a(this.CIS, this.CIT, arrayOfObject, 0, j);
    a.a(this.CIS, 0, arrayOfObject, j, this.CIT);
    this.CIS = arrayOfObject;
    this.CIT = 0;
    this.vlh = i;
    AppMethodBeat.o(118439);
  }
  
  public final void addLast(T paramT)
  {
    AppMethodBeat.i(118437);
    j.q(paramT, "element");
    this.CIS[this.vlh] = paramT;
    this.vlh = (this.vlh + 1 & this.CIS.length - 1);
    if (this.vlh == this.CIT) {
      eqd();
    }
    AppMethodBeat.o(118437);
  }
  
  public final void clear()
  {
    this.CIT = 0;
    this.vlh = 0;
    this.CIS = new Object[this.CIS.length];
  }
  
  public final T eqc()
  {
    AppMethodBeat.i(118438);
    if (this.CIT == this.vlh)
    {
      AppMethodBeat.o(118438);
      return null;
    }
    Object localObject = this.CIS[this.CIT];
    this.CIS[this.CIT] = null;
    this.CIT = (this.CIT + 1 & this.CIS.length - 1);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type T");
      AppMethodBeat.o(118438);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(118438);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a.b
 * JD-Core Version:    0.7.0.1
 */