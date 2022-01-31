package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.TimerTask;

class ReflectController$2$1
  extends TimerTask
{
  ReflectController$2$1(ReflectController.2 param2) {}
  
  public void run()
  {
    AppMethodBeat.i(123151);
    YTLogger.i("mCountDownTimer", "current thread2: " + Thread.currentThread());
    YTLogger.i("mCountDownTimer", "change to main:" + (System.currentTimeMillis() - ReflectController.access$800(this.this$1.this$0)));
    ReflectController.access$900(this.this$1.this$0, 2);
    AppMethodBeat.o(123151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController.2.1
 * JD-Core Version:    0.7.0.1
 */