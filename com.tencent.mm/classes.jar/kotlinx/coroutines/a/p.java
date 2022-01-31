package kotlinx.coroutines.a;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/internal/ThreadLocalWithInitialValue;", "T", "Ljava/lang/ThreadLocal;", "supplier", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "initialValue", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class p<T>
  extends ThreadLocal<T>
{
  private final a<T> CJE;
  
  public p(a<? extends T> parama)
  {
    AppMethodBeat.i(118383);
    this.CJE = parama;
    AppMethodBeat.o(118383);
  }
  
  protected final T initialValue()
  {
    AppMethodBeat.i(118382);
    Object localObject = this.CJE.invoke();
    AppMethodBeat.o(118382);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.a.p
 * JD-Core Version:    0.7.0.1
 */