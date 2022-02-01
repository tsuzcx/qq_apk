package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import java.io.Serializable;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
final class s<T>
  implements f<T>, Serializable
{
  private a<? extends T> MKg;
  private volatile Object MKh;
  private final Object lock;
  
  private s(a<? extends T> parama)
  {
    AppMethodBeat.i(129585);
    this.MKg = parama;
    this.MKh = x.MKn;
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
    Object localObject1 = this.MKh;
    if (localObject1 != x.MKn)
    {
      AppMethodBeat.o(129582);
      return localObject1;
    }
    synchronized (this.lock)
    {
      localObject1 = this.MKh;
      x localx = x.MKn;
      if (localObject1 != localx)
      {
        AppMethodBeat.o(129582);
        return localObject1;
      }
      localObject1 = this.MKg;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = ((a)localObject1).invoke();
      this.MKh = localObject1;
      this.MKg = null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129583);
    if (this.MKh != x.MKn) {}
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