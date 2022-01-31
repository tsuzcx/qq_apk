package com.tencent.youtu.ytcommon.tools;

import android.os.Handler;
import java.util.concurrent.Callable;

final class YTThreadOperate$3
  implements Runnable
{
  YTThreadOperate$3(Callable paramCallable, YTThreadOperate.UiThreadCallback paramUiThreadCallback) {}
  
  public final void run()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = this.val$callable.call();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    YTThreadOperate.access$000().post(new YTThreadOperate.3.1(this, localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTThreadOperate.3
 * JD-Core Version:    0.7.0.1
 */