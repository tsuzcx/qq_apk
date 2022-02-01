package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/OpDescriptor;", "", "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "isEarlierThan", "", "that", "perform", "affected", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class w
{
  public abstract Object jj(Object paramObject);
  
  public String toString()
  {
    return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.w
 * JD-Core Version:    0.7.0.1
 */