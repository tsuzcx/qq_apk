package com.tencent.wework.api;

import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.utils.Log;
import java.util.Map;

class WWAPIImpl$1$1
  implements Runnable
{
  WWAPIImpl$1$1(WWAPIImpl.1 param1, BaseMessage paramBaseMessage) {}
  
  public void run()
  {
    try
    {
      WWAPIImpl.b(this.xgb.xfZ).get(((WWBaseRespMessage)this.xga).transaction);
      WWAPIImpl.b(this.xgb.xfZ).remove(((WWBaseRespMessage)this.xga).transaction);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("WWAPIImpl", "handle message failed", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl.1.1
 * JD-Core Version:    0.7.0.1
 */