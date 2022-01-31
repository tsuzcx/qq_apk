package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;

final class ProcessManager$2
  implements ProcessManager.ProcessResult
{
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123185);
    YTAGReflectLiveCheckInterface.noticeFailed(paramInt + 200, paramString1, paramString2);
    ProcessManager.mProcessState = 0;
    AppMethodBeat.o(123185);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(123184);
    ProcessManager.access$100();
    AppMethodBeat.o(123184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.2
 * JD-Core Version:    0.7.0.1
 */