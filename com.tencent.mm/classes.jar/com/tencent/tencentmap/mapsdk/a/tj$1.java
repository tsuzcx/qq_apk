package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class tj$1
  extends Handler
{
  tj$1(tj paramtj) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 11: 
      do
      {
        return;
        paramMessage = tj.a(this.a).iterator();
        while (paramMessage.hasNext()) {
          ((Runnable)paramMessage.next()).run();
        }
        tj.a(this.a).clear();
      } while (tj.b(this.a) == null);
      tj.b(this.a).a();
      return;
    }
    tj.c(this.a).o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tj.1
 * JD-Core Version:    0.7.0.1
 */