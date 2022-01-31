package com.tencent.ttpic.thread;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FaceGestureDetGLThread$8
  implements Runnable
{
  FaceGestureDetGLThread$8(FaceGestureDetGLThread paramFaceGestureDetGLThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    AppMethodBeat.i(83752);
    Object localObject = FaceGestureDetGLThread.access$500(this.this$0).getAllFaces();
    if ((localObject != null) && (((List)localObject).size() > 0) && (((List)((List)localObject).get(0)).size() > 0))
    {
      localObject = new ArrayList((Collection)((List)localObject).get(0));
      int i = (int)((PointF)((List)localObject).get(4)).x;
      int j = (int)((PointF)((List)localObject).get(14)).x;
      int k = (int)((PointF)((List)localObject).get(0)).y;
      int m = (int)((PointF)((List)localObject).get(3)).y;
      FaceGestureDetGLThread.access$1800(this.this$0, i, j, k, m, this.val$width, this.val$height, FaceGestureDetGLThread.access$1700(this.this$0));
    }
    AppMethodBeat.o(83752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.8
 * JD-Core Version:    0.7.0.1
 */