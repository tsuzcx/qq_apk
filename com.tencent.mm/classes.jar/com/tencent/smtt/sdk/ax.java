package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ax
  extends Handler
{
  ax(TbsLogReport paramTbsLogReport, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 600) {
      if ((paramMessage.obj instanceof TbsLogReport.TbsLogInfo))
      {
        localTbsLogInfo = (TbsLogReport.TbsLogInfo)paramMessage.obj;
        i = paramMessage.arg1;
        TbsLogReport.a(this.a, i, localTbsLogInfo);
      }
    }
    while (paramMessage.what != 601)
    {
      TbsLogReport.TbsLogInfo localTbsLogInfo;
      int i;
      return;
    }
    TbsLogReport.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ax
 * JD-Core Version:    0.7.0.1
 */