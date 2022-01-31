package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;

class VideoPreviewFaceOutlineDetector$2
  implements Runnable
{
  VideoPreviewFaceOutlineDetector$2(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    AppMethodBeat.i(84381);
    BenchUtil.benchStart("only faceDetect");
    long l1 = 0L;
    if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
      l1 = System.currentTimeMillis();
    }
    this.this$0.doFaceDetect(this.val$rgba, this.val$w, this.val$h);
    if (BenchUtil.ENABLE_PERFORMANCE_RECORD)
    {
      long l2 = System.currentTimeMillis();
      new StringBuilder("人脸追踪耗时： ").append(l2 - l1).append(" ms.");
    }
    BenchUtil.benchEnd("only faceDetect");
    VideoPreviewFaceOutlineDetector.access$002(this.this$0, false);
    VideoPreviewFaceOutlineDetector.access$102(this.this$0, 0);
    AppMethodBeat.o(84381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector.2
 * JD-Core Version:    0.7.0.1
 */