package com.tencent.youtu.ytagreflectlivecheck.manager;

import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;

final class ProcessManager$1
  implements ProcessManager.ProcessResult
{
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    YTAGReflectLiveCheckInterface.noticeFailed(paramInt + 100, paramString1, paramString2);
    ProcessManager.mProcessState = 0;
  }
  
  public final void onSuccess()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ProcessManager.access$000();
      return;
    }
    new Handler(Looper.getMainLooper()).post(new ProcessManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.1
 * JD-Core Version:    0.7.0.1
 */