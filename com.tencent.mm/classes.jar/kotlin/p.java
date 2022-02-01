package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.g.a.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
final class p<T>
  implements Serializable, f<T>
{
  private static final AtomicReferenceFieldUpdater<p<?>, Object> SWW;
  public static final a SWX;
  private volatile a<? extends T> SWT;
  private volatile Object SWU;
  private final Object SWV;
  
  static
  {
    AppMethodBeat.i(129580);
    SWX = new a((byte)0);
    SWW = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "SWU");
    AppMethodBeat.o(129580);
  }
  
  public p(a<? extends T> parama)
  {
    AppMethodBeat.i(129579);
    this.SWT = parama;
    this.SWU = v.SXa;
    this.SWV = v.SXa;
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
    Object localObject = this.SWU;
    if (localObject != v.SXa)
    {
      AppMethodBeat.o(129576);
      return localObject;
    }
    localObject = this.SWT;
    if (localObject != null)
    {
      localObject = ((a)localObject).invoke();
      if (SWW.compareAndSet(this, v.SXa, localObject))
      {
        this.SWT = null;
        AppMethodBeat.o(129576);
        return localObject;
      }
    }
    localObject = this.SWU;
    AppMethodBeat.o(129576);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129577);
    if (this.SWU != v.SXa) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(129577);
      return str;
    }
    AppMethodBeat.o(129577);
    return "Lazy value not initialized yet.";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.p
 * JD-Core Version:    0.7.0.1
 */