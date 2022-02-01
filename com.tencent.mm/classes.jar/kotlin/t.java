package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class t<T>
  implements Serializable, j<T>
{
  private a<? extends T> aiuJ;
  private volatile Object aiuK;
  private final Object lock;
  
  private t(a<? extends T> parama)
  {
    AppMethodBeat.i(129585);
    this.aiuJ = parama;
    this.aiuK = ad.aiuU;
    this.lock = this;
    AppMethodBeat.o(129585);
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(129582);
    Object localObject1 = this.aiuK;
    if (localObject1 != ad.aiuU)
    {
      AppMethodBeat.o(129582);
      return localObject1;
    }
    synchronized (this.lock)
    {
      localObject1 = this.aiuK;
      ad localad = ad.aiuU;
      if (localObject1 != localad)
      {
        AppMethodBeat.o(129582);
        return localObject1;
      }
      localObject1 = this.aiuJ;
      s.checkNotNull(localObject1);
      localObject1 = ((a)localObject1).invoke();
      this.aiuK = localObject1;
      this.aiuJ = null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129583);
    if (this.aiuK != ad.aiuU) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(129583);
      return str;
    }
    AppMethodBeat.o(129583);
    return "Lazy value not initialized yet.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.t
 * JD-Core Version:    0.7.0.1
 */