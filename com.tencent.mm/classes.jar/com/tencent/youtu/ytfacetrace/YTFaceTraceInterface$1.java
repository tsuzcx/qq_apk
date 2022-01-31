package com.tencent.youtu.ytfacetrace;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class YTFaceTraceInterface$1
  implements YTFaceTraceInterface.FaceDetectResult
{
  YTFaceTraceInterface$1(YTFaceTraceInterface.FaceTraceingNotice paramFaceTraceingNotice) {}
  
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(117789);
    YTFaceTraceInterface.access$200(paramInt, paramString1, paramString2);
    AppMethodBeat.o(117789);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(117788);
    YTFaceTraceInterface.access$002(this.val$facePreviewingNotice);
    YTFaceTraceInterface.access$100();
    AppMethodBeat.o(117788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.1
 * JD-Core Version:    0.7.0.1
 */