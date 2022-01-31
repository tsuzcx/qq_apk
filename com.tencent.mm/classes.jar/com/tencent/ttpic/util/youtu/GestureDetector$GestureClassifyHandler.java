package com.tencent.ttpic.util.youtu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ttpic.util.BenchUtil;

class GestureDetector$GestureClassifyHandler
  extends Handler
{
  public GestureDetector$GestureClassifyHandler(GestureDetector paramGestureDetector, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    BenchUtil.benchStart("GestureTrack");
    paramMessage = (YtHandBox)paramMessage.obj;
    YtHandLabel localYtHandLabel = new YtHandLabel();
    if (paramMessage.confidence >= 0.5F) {
      GestureDetector.access$500(this.this$0).value = localYtHandLabel.value;
    }
    for (GestureDetector.access$500(this.this$0).name = localYtHandLabel.name;; GestureDetector.access$500(this.this$0).name = "")
    {
      BenchUtil.benchEnd("GestureTrack");
      return;
      GestureDetector.access$500(this.this$0).value = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GestureDetector.GestureClassifyHandler
 * JD-Core Version:    0.7.0.1
 */