package kotlinx.coroutines.a;

import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"})
public final class j$a
{
  public static long N(long paramLong, int paramInt)
  {
    return 0xC0000000 & paramLong | paramInt << 0;
  }
  
  public static long O(long paramLong, int paramInt)
  {
    return 0x3FFFFFFF & paramLong | paramInt << 30;
  }
  
  public static int py(long paramLong)
  {
    if ((0x0 & paramLong) != 0L) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.j.a
 * JD-Core Version:    0.7.0.1
 */