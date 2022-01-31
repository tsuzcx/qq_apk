package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

class YTThreadOperate$3$1
  implements Runnable
{
  YTThreadOperate$3$1(YTThreadOperate.3 param3, Object paramObject) {}
  
  public void run()
  {
    AppMethodBeat.i(118104);
    if (this.this$0.val$uiCallback != null) {
      try
      {
        this.this$0.val$uiCallback.callback(this.val$temp);
        AppMethodBeat.o(118104);
        return;
      }
      catch (Exception localException)
      {
        YTException.report(localException);
      }
    }
    AppMethodBeat.o(118104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTThreadOperate.3.1
 * JD-Core Version:    0.7.0.1
 */