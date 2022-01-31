package com.tencent.ttpic.util.youtu.bodydetector;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.thread.FaceGestureDetGLThread.OnBodyDetListener;
import com.tencent.ttpic.util.BenchUtil;
import java.util.ArrayList;
import java.util.List;

class BodyDetector$2
  implements Runnable
{
  BodyDetector$2(BodyDetector paramBodyDetector, byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceGestureDetGLThread.OnBodyDetListener paramOnBodyDetListener) {}
  
  public void run()
  {
    AppMethodBeat.i(84419);
    if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = new int[1];
      localObject[0] = 0;
      int i;
      if (!BodyDetector.access$700(this.this$0))
      {
        if (!this.this$0.nativeBodyDetect(this.val$image, this.val$width, this.val$height, 2, BodyDetector.access$800(this.this$0), BodyDetector.access$900(this.this$0), BodyDetector.access$1000(this.this$0), BodyDetector.access$1100(this.this$0), BodyDetector.access$1200(this.this$0), (int[])localObject)) {
          break label641;
        }
        float f1 = 0.0F;
        float f2 = 0.0F;
        float f3 = 0.0F;
        float f5 = 0.0F;
        float f4 = 0.0F;
        i = 0;
        while (i < localObject[0])
        {
          float f6 = f4;
          if (f4 < BodyDetector.access$1200(this.this$0)[i])
          {
            f6 = BodyDetector.access$1200(this.this$0)[i];
            f1 = BodyDetector.access$800(this.this$0)[i];
            f2 = BodyDetector.access$900(this.this$0)[i];
            f3 = BodyDetector.access$1000(this.this$0)[i];
            f5 = BodyDetector.access$1100(this.this$0)[i];
          }
          i += 1;
          f4 = f6;
        }
        if ((localObject[0] > 0) && (f4 > 0.7D))
        {
          BodyDetector.access$1302(this.this$0, f1);
          BodyDetector.access$1402(this.this$0, f2);
          BodyDetector.access$1502(this.this$0, f3);
          BodyDetector.access$1602(this.this$0, f5);
          BodyDetector.access$1702(this.this$0, f4);
          BodyDetector.access$702(this.this$0, true);
        }
      }
      else
      {
        if ((!BodyDetector.access$700(this.this$0)) || (!this.this$0.nativeBodyKeypoint(this.val$image, this.val$width, this.val$height, 59, 2, BodyDetector.access$1300(this.this$0), BodyDetector.access$1400(this.this$0), BodyDetector.access$1500(this.this$0), BodyDetector.access$1600(this.this$0), BodyDetector.access$1700(this.this$0), BodyDetector.access$400(this.this$0), BodyDetector.access$500(this.this$0), BodyDetector.access$600(this.this$0)))) {
          break label669;
        }
        localObject = this.this$0;
        if (((BodyDetector.access$600(this.this$0)[17] <= 0.7D) || (BodyDetector.access$600(this.this$0)[15] <= 0.7D)) && ((BodyDetector.access$600(this.this$0)[43] <= 0.7D) || (BodyDetector.access$600(this.this$0)[41] <= 0.7D))) {
          break label653;
        }
      }
      label641:
      label653:
      for (boolean bool = true;; bool = false)
      {
        ((BodyDetector)localObject).bodyDetected = bool;
        if (!this.this$0.bodyDetected) {
          break label720;
        }
        BodyDetector.access$702(this.this$0, true);
        BodyDetector.access$1800(this.this$0, BodyDetector.access$400(this.this$0), BodyDetector.access$500(this.this$0));
        localObject = new BodyDetectResult();
        ((BodyDetectResult)localObject).bodyPoints = new ArrayList();
        ((BodyDetectResult)localObject).bodyPointScores = new ArrayList();
        i = 0;
        while (i < 59)
        {
          PointF localPointF = new PointF(BodyDetector.access$400(this.this$0)[i], BodyDetector.access$500(this.this$0)[i]);
          ((BodyDetectResult)localObject).bodyPoints.add(localPointF);
          ((BodyDetectResult)localObject).bodyPointScores.add(Float.valueOf(BodyDetector.access$600(this.this$0)[i]));
          i += 1;
        }
        BodyDetector.access$702(this.this$0, false);
        break;
        BodyDetector.access$702(this.this$0, false);
        break;
      }
      localArrayList.add(localObject);
      for (;;)
      {
        label669:
        this.val$listener.onBodyDataReady(localArrayList);
        if (BenchUtil.ENABLE_PERFORMANCE_RECORD)
        {
          long l2 = System.currentTimeMillis();
          new StringBuilder("人体检测耗时： ").append(l2 - l1).append(" ms.");
        }
        AppMethodBeat.o(84419);
        return;
        label720:
        BodyDetector.access$702(this.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.bodydetector.BodyDetector.2
 * JD-Core Version:    0.7.0.1
 */