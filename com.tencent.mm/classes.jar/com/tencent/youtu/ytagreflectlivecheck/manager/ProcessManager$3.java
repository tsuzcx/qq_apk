package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;

final class ProcessManager$3
  implements YTAGReflectLiveCheckInterface.LightLiveCheckResult
{
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123187);
    YTAGReflectLiveCheckInterface.noticeFailed(paramInt + 300, paramString1, paramString2);
    ProcessManager.mProcessState = 0;
    AppMethodBeat.o(123187);
  }
  
  public final void onSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse)
  {
    AppMethodBeat.i(123186);
    YTAGReflectLiveCheckInterface.noticeSuccess(paramBoolean, paramLightDiffResponse);
    ProcessManager.mProcessState = 0;
    AppMethodBeat.o(123186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.3
 * JD-Core Version:    0.7.0.1
 */