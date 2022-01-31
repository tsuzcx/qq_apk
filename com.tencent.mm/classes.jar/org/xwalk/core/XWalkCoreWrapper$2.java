package org.xwalk.core;

import com.tencent.xweb.util.e;

class XWalkCoreWrapper$2
  extends XWalkNotifyChannelListener
{
  XWalkCoreWrapper$2(XWalkCoreWrapper paramXWalkCoreWrapper) {}
  
  public void onNotifyCallBackChannel(int paramInt, Object[] paramArrayOfObject)
  {
    Log.i("XWalkLib", "XWalkNotifyChannelListener called  funid = " + paramInt + " para size = " + paramArrayOfObject.length);
    switch (paramInt)
    {
    default: 
    case 50001: 
      try
      {
        Log.i("XWalkLib", "XWalkNotifyChannelListener called  funid = " + paramInt + " do not match");
        return;
      }
      catch (RuntimeException paramArrayOfObject)
      {
        Log.e("XWalkLib", "XWalkNotifyChannelListener error:" + paramArrayOfObject.getLocalizedMessage());
        return;
      }
      e.f(Long.parseLong((String)paramArrayOfObject[0]), Long.parseLong((String)paramArrayOfObject[1]), Integer.parseInt((String)paramArrayOfObject[2]));
      return;
    }
    e.bp(Integer.parseInt((String)paramArrayOfObject[0]), (String)paramArrayOfObject[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper.2
 * JD-Core Version:    0.7.0.1
 */