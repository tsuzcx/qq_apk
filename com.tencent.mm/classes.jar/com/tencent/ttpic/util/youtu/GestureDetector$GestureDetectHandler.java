package com.tencent.ttpic.util.youtu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.util.g;

class GestureDetector$GestureDetectHandler
  extends Handler
{
  public GestureDetector$GestureDetectHandler(GestureDetector paramGestureDetector, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    long l = System.currentTimeMillis();
    if (GestureDetector.access$000(this.this$0).confidence < 0.5F)
    {
      GestureDetector.access$100(this.this$0);
      if (l - GestureDetector.access$200(this.this$0) >= 500L)
      {
        GestureDetector.access$202(this.this$0, l);
        BenchUtil.benchStart("doHandDetection");
        g.i(GestureDetector.access$300(), "doHandDetection, box.confidence = " + GestureDetector.access$000(this.this$0).confidence);
        BenchUtil.benchEnd("doHandDetection");
        g.i(GestureDetector.access$300(), "ret == 0");
      }
    }
    GestureDetector.access$402(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GestureDetector.GestureDetectHandler
 * JD-Core Version:    0.7.0.1
 */