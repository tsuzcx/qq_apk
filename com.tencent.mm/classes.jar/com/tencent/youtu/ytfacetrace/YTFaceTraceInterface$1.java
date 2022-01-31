package com.tencent.youtu.ytfacetrace;

final class YTFaceTraceInterface$1
  implements YTFaceTraceInterface.FaceDetectResult
{
  YTFaceTraceInterface$1(YTFaceTraceInterface.FaceTraceingNotice paramFaceTraceingNotice) {}
  
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    YTFaceTraceInterface.access$200(paramInt, paramString1, paramString2);
  }
  
  public final void onSuccess()
  {
    YTFaceTraceInterface.access$002(this.val$facePreviewingNotice);
    YTFaceTraceInterface.access$100();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.1
 * JD-Core Version:    0.7.0.1
 */