package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;

public final class a
  implements m.b
{
  private final int DELAY_TIME = 50;
  private final String TAG = "MicroMsg.NotificationObserver";
  private ah mHandler = new a.1(this, Looper.getMainLooper());
  public boolean mIk = false;
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    y.i("MicroMsg.NotificationObserver", "event: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((!(paramObject instanceof String)) || (bk.bl((String)paramObject)))
    {
      y.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      return;
    }
    if (!au.Hp()) {
      au.Hx();
    }
    for (paramInt = (int)c.Fw().abj((String)paramObject).dBe;; paramInt = 0)
    {
      this.mHandler.removeMessages(paramInt);
      paramm = Message.obtain();
      Bundle localBundle = new Bundle();
      localBundle.putString("com.tencent.mm.notification.observer", (String)paramObject);
      paramm.setData(localBundle);
      paramm.what = paramInt;
      this.mHandler.sendMessageDelayed(paramm, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a
 * JD-Core Version:    0.7.0.1
 */