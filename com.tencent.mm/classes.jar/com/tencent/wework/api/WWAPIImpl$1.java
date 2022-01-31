package com.tencent.wework.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.utils.Log;

class WWAPIImpl$1
  extends BroadcastReceiver
{
  WWAPIImpl$1(WWAPIImpl paramWWAPIImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (!WWAPIImpl.a(this.xfZ).equals(paramIntent.getScheme()))
      {
        Log.w("WWAPIImpl", "invalid schema: " + paramIntent.getScheme());
        return;
      }
      paramContext = BaseMessage.o(paramIntent.getData());
      if ((paramContext instanceof WWBaseRespMessage))
      {
        new Handler(Looper.getMainLooper()).post(new WWAPIImpl.1.1(this, paramContext));
        return;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("WWAPIImpl", "handle broadcast failed", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl.1
 * JD-Core Version:    0.7.0.1
 */