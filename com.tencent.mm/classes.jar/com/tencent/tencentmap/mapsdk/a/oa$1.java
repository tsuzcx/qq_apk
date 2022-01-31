package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;

class oa$1
  extends Handler
{
  oa$1(oa paramoa) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (oa.a(this.a) == true) {}
    do
    {
      return;
      localObject = paramMessage.obj;
    } while (localObject == null);
    Object localObject = (oa.b)localObject;
    oa.a(this.a, (oa.b)localObject);
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.oa.1
 * JD-Core Version:    0.7.0.1
 */