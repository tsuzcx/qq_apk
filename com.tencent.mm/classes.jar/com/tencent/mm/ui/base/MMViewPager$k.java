package com.tencent.mm.ui.base;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

public final class MMViewPager$k
  extends ah
{
  long kLr;
  WeakReference<MMViewPager> uZt;
  
  public MMViewPager$k(WeakReference<MMViewPager> paramWeakReference)
  {
    this.uZt = paramWeakReference;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    removeMessages(paramMessage.what);
    MMViewPager localMMViewPager;
    if (this.uZt != null)
    {
      localMMViewPager = (MMViewPager)this.uZt.get();
      if ((localMMViewPager != null) && (paramMessage.what == 1))
      {
        if ((MMViewPager.x(localMMViewPager) == null) || (MMViewPager.x(localMMViewPager).aXY())) {
          break label81;
        }
        MMViewPager.x(localMMViewPager).play();
        sendEmptyMessageDelayed(paramMessage.what, this.kLr);
      }
    }
    return;
    label81:
    MMViewPager.y(localMMViewPager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.k
 * JD-Core Version:    0.7.0.1
 */