package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

final class YTThreadOperate$2
  implements Callable<T>
{
  YTThreadOperate$2(Callable paramCallable) {}
  
  public final T call()
  {
    AppMethodBeat.i(118103);
    try
    {
      Object localObject = this.val$runnable.call();
      AppMethodBeat.o(118103);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(118103);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTThreadOperate.2
 * JD-Core Version:    0.7.0.1
 */