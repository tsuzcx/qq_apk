package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;

final class j
  extends Handler
{
  j(Looper paramLooper, QbSdk.PreInitCallback paramPreInitCallback, Context paramContext)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (this.a != null) {
        this.a.onViewInitFinished(false);
      }
      TbsLog.writeLogToDisk();
      return;
      QbSdk.a(TbsExtensionFunctionManager.getInstance().canUseFunction(this.b, "disable_unpreinit.txt"));
      if (QbSdk.j)
      {
        paramMessage = bv.a().c();
        if (paramMessage != null) {
          paramMessage.a(this.b);
        }
      }
      if (this.a != null) {
        this.a.onViewInitFinished(true);
      }
      TbsLog.writeLogToDisk();
      return;
    } while (this.a == null);
    this.a.onCoreInitFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.j
 * JD-Core Version:    0.7.0.1
 */