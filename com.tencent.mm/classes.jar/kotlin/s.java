package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class s<T>
  implements Serializable, j<T>
{
  public static final a aiuM;
  private static final AtomicReferenceFieldUpdater<s<?>, Object> bfS;
  private volatile a<? extends T> aiuJ;
  private volatile Object aiuK;
  private final Object aiuL;
  
  static
  {
    AppMethodBeat.i(129580);
    aiuM = new a((byte)0);
    bfS = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "aiuK");
    AppMethodBeat.o(129580);
  }
  
  public s(a<? extends T> parama)
  {
    AppMethodBeat.i(129579);
    this.aiuJ = parama;
    this.aiuK = ad.aiuU;
    this.aiuL = ad.aiuU;
    AppMethodBeat.o(129579);
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(129576);
    Object localObject = this.aiuK;
    if (localObject != ad.aiuU)
    {
      AppMethodBeat.o(129576);
      return localObject;
    }
    localObject = this.aiuJ;
    if (localObject != null)
    {
      localObject = ((a)localObject).invoke();
      if (bfS.compareAndSet(this, ad.aiuU, localObject))
      {
        this.aiuJ = null;
        AppMethodBeat.o(129576);
        return localObject;
      }
    }
    localObject = this.aiuK;
    AppMethodBeat.o(129576);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129577);
    if (this.aiuK != ad.aiuU) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(129577);
      return str;
    }
    AppMethodBeat.o(129577);
    return "Lazy value not initialized yet.";
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.s
 * JD-Core Version:    0.7.0.1
 */