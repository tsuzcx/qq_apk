package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import java.io.Serializable;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
final class s<T>
  implements f<T>, Serializable
{
  private a<? extends T> JfO;
  private volatile Object JfP;
  private final Object lock;
  
  private s(a<? extends T> parama)
  {
    AppMethodBeat.i(129585);
    this.JfO = parama;
    this.JfP = w.JfU;
    this.lock = this;
    AppMethodBeat.o(129585);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129584);
    d locald = new d(getValue());
    AppMethodBeat.o(129584);
    return locald;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(129582);
    Object localObject1 = this.JfP;
    if (localObject1 != w.JfU)
    {
      AppMethodBeat.o(129582);
      return localObject1;
    }
    synchronized (this.lock)
    {
      localObject1 = this.JfP;
      w localw = w.JfU;
      if (localObject1 != localw)
      {
        AppMethodBeat.o(129582);
        return localObject1;
      }
      localObject1 = this.JfO;
      if (localObject1 == null) {
        k.fvU();
      }
      localObject1 = ((a)localObject1).invoke();
      this.JfP = localObject1;
      this.JfO = null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129583);
    if (this.JfP != w.JfU) {}
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
 * Qualified Name:     d.s
 * JD-Core Version:    0.7.0.1
 */