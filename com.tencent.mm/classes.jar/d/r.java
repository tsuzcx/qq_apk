package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
final class r<T>
  implements f<T>, Serializable
{
  private static final AtomicReferenceFieldUpdater<r<?>, Object> Nhm;
  public static final a Nhn;
  private volatile a<? extends T> Nhj;
  private volatile Object Nhk;
  private final Object Nhl;
  
  static
  {
    AppMethodBeat.i(129580);
    Nhn = new a((byte)0);
    Nhm = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "Nhk");
    AppMethodBeat.o(129580);
  }
  
  public r(a<? extends T> parama)
  {
    AppMethodBeat.i(129579);
    this.Nhj = parama;
    this.Nhk = x.Nhq;
    this.Nhl = x.Nhq;
    AppMethodBeat.o(129579);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129578);
    d locald = new d(getValue());
    AppMethodBeat.o(129578);
    return locald;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(129576);
    Object localObject = this.Nhk;
    if (localObject != x.Nhq)
    {
      AppMethodBeat.o(129576);
      return localObject;
    }
    localObject = this.Nhj;
    if (localObject != null)
    {
      localObject = ((a)localObject).invoke();
      if (Nhm.compareAndSet(this, x.Nhq, localObject))
      {
        this.Nhj = null;
        AppMethodBeat.o(129576);
        return localObject;
      }
    }
    localObject = this.Nhk;
    AppMethodBeat.o(129576);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129577);
    if (this.Nhk != x.Nhq) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(129577);
      return str;
    }
    AppMethodBeat.o(129577);
    return "Lazy value not initialized yet.";
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.r
 * JD-Core Version:    0.7.0.1
 */