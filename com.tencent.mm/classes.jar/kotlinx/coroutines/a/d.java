package kotlinx.coroutines.a;

import a.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "Lkotlinx/coroutines/internal/OpDescriptor;", "()V", "_consensus", "Lkotlinx/atomicfu/AtomicRef;", "", "isDecided", "", "()Z", "complete", "", "affected", "failure", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decide", "decision", "perform", "prepare", "(Ljava/lang/Object;)Ljava/lang/Object;", "tryDecide", "kotlinx-coroutines-core"})
public abstract class d<T>
  extends k
{
  private static final AtomicReferenceFieldUpdater CIW = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "CIV");
  private volatile Object CIV = c.eqe();
  
  public abstract void J(T paramT, Object paramObject);
  
  public abstract Object ef(T paramT);
  
  public final Object eg(Object paramObject)
  {
    Object localObject2 = this.CIV;
    Object localObject1 = localObject2;
    if (localObject2 == c.eqe())
    {
      localObject1 = ef(paramObject);
      if (localObject1 != c.eqe()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalStateException("Check failed.".toString()));
      }
      if (!CIW.compareAndSet(this, c.eqe(), localObject1)) {
        break label79;
      }
    }
    for (;;)
    {
      J(paramObject, localObject1);
      return localObject1;
      label79:
      localObject1 = this.CIV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlinx.coroutines.a.d
 * JD-Core Version:    0.7.0.1
 */