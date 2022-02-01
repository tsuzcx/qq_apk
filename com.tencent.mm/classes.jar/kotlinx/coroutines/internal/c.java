package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.ap;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"})
public abstract class c<T>
  extends r
{
  private static final AtomicReferenceFieldUpdater abyS = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
  volatile Object _consensus = b.iSF();
  
  public abstract void R(T paramT, Object paramObject);
  
  public final Object gw(Object paramObject)
  {
    Object localObject2 = this._consensus;
    Object localObject1 = localObject2;
    if (localObject2 == b.iSF())
    {
      localObject1 = iRO();
      if (ap.iRg())
      {
        if (localObject1 != b.iSF()) {}
        for (int i = 1; i == 0; i = 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      localObject2 = this._consensus;
      if (localObject2 == b.iSF()) {
        break label82;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      R(paramObject, localObject1);
      return localObject1;
      label82:
      if (!abyS.compareAndSet(this, b.iSF(), localObject1)) {
        localObject1 = this._consensus;
      }
    }
  }
  
  public abstract Object iRO();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.c
 * JD-Core Version:    0.7.0.1
 */