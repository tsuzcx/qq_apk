package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.d;

final class bc
  extends Handler
{
  public bc(bb parambb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (paramMessage.what == 1) {}
    for (;;)
    {
      d.w(bool);
      this.Pb.b((be)paramMessage.obj);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bc
 * JD-Core Version:    0.7.0.1
 */