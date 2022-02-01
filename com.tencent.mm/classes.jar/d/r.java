package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
final class r<T>
  implements f<T>, Serializable
{
  private static final AtomicReferenceFieldUpdater<r<?>, Object> KTl;
  public static final a KTm;
  private volatile a<? extends T> KTi;
  private volatile Object KTj;
  private final Object KTk;
  
  static
  {
    AppMethodBeat.i(129580);
    KTm = new a((byte)0);
    KTl = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "KTj");
    AppMethodBeat.o(129580);
  }
  
  public r(a<? extends T> parama)
  {
    AppMethodBeat.i(129579);
    this.KTi = parama;
    this.KTj = w.KTo;
    this.KTk = w.KTo;
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
    Object localObject = this.KTj;
    if (localObject != w.KTo)
    {
      AppMethodBeat.o(129576);
      return localObject;
    }
    localObject = this.KTi;
    if (localObject != null)
    {
      localObject = ((a)localObject).invoke();
      if (KTl.compareAndSet(this, w.KTo, localObject))
      {
        this.KTi = null;
        AppMethodBeat.o(129576);
        return localObject;
      }
    }
    localObject = this.KTj;
    AppMethodBeat.o(129576);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129577);
    if (this.KTj != w.KTo) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(129577);
      return str;
    }
    AppMethodBeat.o(129577);
    return "Lazy value not initialized yet.";
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.r
 * JD-Core Version:    0.7.0.1
 */