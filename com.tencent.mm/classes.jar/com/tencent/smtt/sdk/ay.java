package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ay
  extends Handler
{
  ay(TbsLogReport paramTbsLogReport, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(139352);
    if (paramMessage.what == 600)
    {
      if ((paramMessage.obj instanceof TbsLogReport.TbsLogInfo)) {
        try
        {
          TbsLogReport.TbsLogInfo localTbsLogInfo = (TbsLogReport.TbsLogInfo)paramMessage.obj;
          int i = paramMessage.arg1;
          TbsLogReport.a(this.a, i, localTbsLogInfo);
          AppMethodBeat.o(139352);
          return;
        }
        catch (Exception paramMessage) {}
      }
      AppMethodBeat.o(139352);
      return;
    }
    if (paramMessage.what == 601) {
      TbsLogReport.a(this.a);
    }
    AppMethodBeat.o(139352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.ay
 * JD-Core Version:    0.7.0.1
 */