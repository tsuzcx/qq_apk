package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;

class XWalkCoreWrapper$2
  extends XWalkNotifyChannelListener
{
  XWalkCoreWrapper$2(XWalkCoreWrapper paramXWalkCoreWrapper) {}
  
  public void onNotifyCallBackChannel(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(85554);
    Log.i("XWalkLib", "XWalkNotifyChannelListener called  funid = " + paramInt + " para size = " + paramArrayOfObject.length);
    switch (paramInt)
    {
    default: 
    case 50001: 
      try
      {
        Log.i("XWalkLib", "XWalkNotifyChannelListener called  funid = " + paramInt + " do not match");
        AppMethodBeat.o(85554);
        return;
      }
      catch (RuntimeException paramArrayOfObject)
      {
        Log.e("XWalkLib", "XWalkNotifyChannelListener error:" + paramArrayOfObject.getLocalizedMessage());
        AppMethodBeat.o(85554);
        return;
      }
      f.m(Long.parseLong((String)paramArrayOfObject[0]), Long.parseLong((String)paramArrayOfObject[1]), Integer.parseInt((String)paramArrayOfObject[2]));
      AppMethodBeat.o(85554);
      return;
    }
    f.bW(Integer.parseInt((String)paramArrayOfObject[0]), (String)paramArrayOfObject[1]);
    AppMethodBeat.o(85554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper.2
 * JD-Core Version:    0.7.0.1
 */