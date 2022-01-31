package com.tencent.youtu.ytfacetrace;

final class YTFaceTraceInterface$4
  implements Runnable
{
  YTFaceTraceInterface$4(int paramInt, String paramString1, String paramString2) {}
  
  public final void run()
  {
    YTFaceTraceInterface.access$400().onFailed(this.val$resultCode, this.val$message, this.val$tips);
    YTFaceTraceInterface.access$402(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.4
 * JD-Core Version:    0.7.0.1
 */