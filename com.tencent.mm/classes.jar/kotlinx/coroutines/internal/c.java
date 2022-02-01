package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.an;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"})
public abstract class c<T>
  extends q
{
  private static final AtomicReferenceFieldUpdater TVB = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
  private volatile Object _consensus = b.hNE();
  
  public abstract void Z(T paramT, Object paramObject);
  
  public final Object ge(Object paramObject)
  {
    Object localObject2 = this._consensus;
    Object localObject1 = localObject2;
    if (localObject2 == b.hNE())
    {
      localObject1 = hNr();
      if (an.hMK())
      {
        if (localObject1 != b.hNE()) {}
        for (int i = 1; i == 0; i = 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      localObject2 = this._consensus;
      if (localObject2 == b.hNE()) {
        break label82;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Z(paramObject, localObject1);
      return localObject1;
      label82:
      if (!TVB.compareAndSet(this, b.hNE(), localObject1)) {
        localObject1 = this._consensus;
      }
    }
  }
  
  public abstract Object hNr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.c
 * JD-Core Version:    0.7.0.1
 */