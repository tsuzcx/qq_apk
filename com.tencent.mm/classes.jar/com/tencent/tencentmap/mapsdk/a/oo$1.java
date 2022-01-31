package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;

class oo$1
  extends Handler
{
  oo$1(oo paramoo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramMessage = (mt)paramMessage.obj;
      if (paramMessage.a != 0) {
        break label75;
      }
      if (oo.a(this.a) != null) {
        oo.a(this.a).a(paramMessage.b, paramMessage.c);
      }
      if (oo.b(this.a) != null) {
        oo.b(this.a).e();
      }
    }
    label75:
    do
    {
      do
      {
        return;
        if (paramMessage.a != 1) {
          break;
        }
      } while (oo.b(this.a) == null);
      oo.b(this.a).a(paramMessage.d, paramMessage.e);
      return;
    } while ((paramMessage.a != 3) || (lq.e != 1) || (oo.c(this.a) == null));
    if (oo.d(this.a) == null) {
      oo.a(this.a, new mo(oo.c(this.a).getContext().getApplicationContext()));
    }
    oo.d(this.a).a(oo.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.oo.1
 * JD-Core Version:    0.7.0.1
 */