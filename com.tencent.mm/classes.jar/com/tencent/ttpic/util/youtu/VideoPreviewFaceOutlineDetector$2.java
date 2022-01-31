package com.tencent.ttpic.util.youtu;

import com.tencent.ttpic.util.BenchUtil;

class VideoPreviewFaceOutlineDetector$2
  implements Runnable
{
  VideoPreviewFaceOutlineDetector$2(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    BenchUtil.benchStart("FaceDetect");
    this.this$0.doFaceDetect(this.val$rgba, this.val$w, this.val$h);
    BenchUtil.benchEnd("FaceDetect");
    VideoPreviewFaceOutlineDetector.access$002(this.this$0, false);
    VideoPreviewFaceOutlineDetector.access$102(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector.2
 * JD-Core Version:    0.7.0.1
 */