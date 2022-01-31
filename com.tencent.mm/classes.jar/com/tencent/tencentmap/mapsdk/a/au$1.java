package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class au$1
  extends Handler
{
  au$1(au paramau) {}
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(149744);
    if (au.a(this.a) == true)
    {
      AppMethodBeat.o(149744);
      return;
    }
    Object localObject = paramMessage.obj;
    if (localObject == null)
    {
      AppMethodBeat.o(149744);
      return;
    }
    localObject = (au.b)localObject;
    au.a(this.a, (au.b)localObject);
    super.handleMessage(paramMessage);
    AppMethodBeat.o(149744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.au.1
 * JD-Core Version:    0.7.0.1
 */