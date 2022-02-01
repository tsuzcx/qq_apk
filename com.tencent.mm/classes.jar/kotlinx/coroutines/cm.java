package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "toString", "", "toStringInternalImpl", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class cm
  extends al
{
  public abstract cm kCK();
  
  protected final String kCL()
  {
    String str = null;
    cm localcm = bg.kCh();
    if (this == localcm) {
      str = "Dispatchers.Main";
    }
    for (;;)
    {
      return str;
      try
      {
        localcm = localcm.kCK();
        if (this != localcm) {
          continue;
        }
        return "Dispatchers.Main.immediate";
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public String toString()
  {
    String str2 = kCL();
    String str1 = str2;
    if (str2 == null) {
      str1 = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cm
 * JD-Core Version:    0.7.0.1
 */