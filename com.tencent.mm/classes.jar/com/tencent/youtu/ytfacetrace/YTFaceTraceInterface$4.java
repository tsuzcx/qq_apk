package com.tencent.youtu.ytfacetrace;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class YTFaceTraceInterface$4
  implements Runnable
{
  YTFaceTraceInterface$4(int paramInt, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(117792);
    YTFaceTraceInterface.access$400().onFailed(this.val$resultCode, this.val$message, this.val$tips);
    YTFaceTraceInterface.access$402(null);
    AppMethodBeat.o(117792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.4
 * JD-Core Version:    0.7.0.1
 */