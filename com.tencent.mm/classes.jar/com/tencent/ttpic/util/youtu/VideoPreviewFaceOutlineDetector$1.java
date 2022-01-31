package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;

class VideoPreviewFaceOutlineDetector$1
  implements Runnable
{
  VideoPreviewFaceOutlineDetector$1(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    AppMethodBeat.i(84380);
    BenchUtil.benchStart("only faceDetect");
    this.this$0.doFaceDetect(this.val$data, this.val$w, this.val$h);
    BenchUtil.benchEnd("only faceDetect");
    AppMethodBeat.o(84380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector.1
 * JD-Core Version:    0.7.0.1
 */