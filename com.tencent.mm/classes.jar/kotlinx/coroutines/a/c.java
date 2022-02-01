package kotlinx.coroutines.a;

import d.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ah;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"})
public abstract class c<T>
  extends j
{
  private static final AtomicReferenceFieldUpdater Kfc = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
  private volatile Object _consensus = b.fLL();
  
  public abstract void U(T paramT, Object paramObject);
  
  public final Object fL(Object paramObject)
  {
    Object localObject2 = this._consensus;
    Object localObject1 = localObject2;
    if (localObject2 == b.fLL())
    {
      localObject1 = fLz();
      if (ah.fKW())
      {
        if (localObject1 != b.fLL()) {}
        for (int i = 1; i == 0; i = 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      localObject2 = this._consensus;
      if (localObject2 == b.fLL()) {
        break label82;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      U(paramObject, localObject1);
      return localObject1;
      label82:
      if (!Kfc.compareAndSet(this, b.fLL(), localObject1)) {
        localObject1 = this._consensus;
      }
    }
  }
  
  public abstract Object fLz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.c
 * JD-Core Version:    0.7.0.1
 */