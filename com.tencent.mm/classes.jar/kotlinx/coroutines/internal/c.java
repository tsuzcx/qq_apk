package kotlinx.coroutines.internal;

import d.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.am;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"})
public abstract class c<T>
  extends p
{
  private static final AtomicReferenceFieldUpdater NJy = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
  private volatile Object _consensus = b.gvV();
  
  public abstract void X(T paramT, Object paramObject);
  
  public final Object fW(Object paramObject)
  {
    Object localObject2 = this._consensus;
    Object localObject1 = localObject2;
    if (localObject2 == b.gvV())
    {
      localObject1 = gvJ();
      if (am.gvd())
      {
        if (localObject1 != b.gvV()) {}
        for (int i = 1; i == 0; i = 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      localObject2 = this._consensus;
      if (localObject2 == b.gvV()) {
        break label82;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      X(paramObject, localObject1);
      return localObject1;
      label82:
      if (!NJy.compareAndSet(this, b.gvV(), localObject1)) {
        localObject1 = this._consensus;
      }
    }
  }
  
  public abstract Object gvJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.c
 * JD-Core Version:    0.7.0.1
 */