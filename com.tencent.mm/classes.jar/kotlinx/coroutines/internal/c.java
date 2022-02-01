package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "getConsensus", "()Ljava/lang/Object;", "consensus", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c<T>
  extends w
{
  public abstract void af(T paramT, Object paramObject);
  
  public final Object jj(Object paramObject)
  {
    Object localObject2 = this._consensus;
    Object localObject1 = localObject2;
    if (localObject2 == b.ajAf)
    {
      localObject1 = kCD();
      if (au.ASSERTIONS_ENABLED)
      {
        if (localObject1 != b.ajAf) {}
        for (int i = 1; i == 0; i = 0) {
          throw new AssertionError();
        }
      }
      localObject2 = this._consensus;
      if (localObject2 == b.ajAf) {
        break label79;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      af(paramObject, localObject1);
      return localObject1;
      label79:
      if (!ajAh.compareAndSet(this, b.ajAf, localObject1)) {
        localObject1 = this._consensus;
      }
    }
  }
  
  public abstract Object kCD();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.c
 * JD-Core Version:    0.7.0.1
 */