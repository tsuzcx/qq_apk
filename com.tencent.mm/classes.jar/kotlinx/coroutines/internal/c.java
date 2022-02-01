package kotlinx.coroutines.internal;

import d.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.am;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"})
public abstract class c<T>
  extends p
{
  private static final AtomicReferenceFieldUpdater OgE = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
  private volatile Object _consensus = b.gAx();
  
  public abstract void W(T paramT, Object paramObject);
  
  public final Object fZ(Object paramObject)
  {
    Object localObject2 = this._consensus;
    Object localObject1 = localObject2;
    if (localObject2 == b.gAx())
    {
      localObject1 = gAl();
      if (am.gzF())
      {
        if (localObject1 != b.gAx()) {}
        for (int i = 1; i == 0; i = 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      localObject2 = this._consensus;
      if (localObject2 == b.gAx()) {
        break label82;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      W(paramObject, localObject1);
      return localObject1;
      label82:
      if (!OgE.compareAndSet(this, b.gAx(), localObject1)) {
        localObject1 = this._consensus;
      }
    }
  }
  
  public abstract Object gAl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.c
 * JD-Core Version:    0.7.0.1
 */