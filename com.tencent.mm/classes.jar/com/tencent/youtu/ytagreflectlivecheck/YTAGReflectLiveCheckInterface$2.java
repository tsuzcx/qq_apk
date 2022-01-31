package com.tencent.youtu.ytagreflectlivecheck;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class YTAGReflectLiveCheckInterface$2
  implements Runnable
{
  YTAGReflectLiveCheckInterface$2(int paramInt, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(123134);
    YTAGReflectLiveCheckInterface.access$000().onFailed(this.val$resultCode, this.val$message, this.val$tips);
    YTAGReflectLiveCheckInterface.access$002(null);
    AppMethodBeat.o(123134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.2
 * JD-Core Version:    0.7.0.1
 */