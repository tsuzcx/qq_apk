package com.tencent.youtu.ytcommon.tools;

import java.util.concurrent.Callable;

final class YTThreadOperate$2
  implements Callable<T>
{
  YTThreadOperate$2(Callable paramCallable) {}
  
  public final T call()
  {
    try
    {
      Object localObject = this.val$runnable.call();
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTThreadOperate.2
 * JD-Core Version:    0.7.0.1
 */