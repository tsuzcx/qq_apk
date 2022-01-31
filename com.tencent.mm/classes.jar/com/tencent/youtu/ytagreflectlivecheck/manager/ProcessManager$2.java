package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;

final class ProcessManager$2
  implements ProcessManager.ProcessResult
{
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    YTAGReflectLiveCheckInterface.noticeFailed(paramInt + 200, paramString1, paramString2);
    ProcessManager.mProcessState = 0;
  }
  
  public final void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.2
 * JD-Core Version:    0.7.0.1
 */