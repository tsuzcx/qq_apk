package com.tencent.mm.ui.base;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public final class MMViewPager$k
  extends ak
{
  long nhU;
  WeakReference<MMViewPager> znK;
  
  public MMViewPager$k(WeakReference<MMViewPager> paramWeakReference)
  {
    this.znK = paramWeakReference;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(106920);
    super.handleMessage(paramMessage);
    removeMessages(paramMessage.what);
    if (this.znK != null)
    {
      MMViewPager localMMViewPager = (MMViewPager)this.znK.get();
      if ((localMMViewPager != null) && (paramMessage.what == 1))
      {
        if ((MMViewPager.v(localMMViewPager) != null) && (!MMViewPager.v(localMMViewPager).bEL()))
        {
          MMViewPager.v(localMMViewPager).play();
          sendEmptyMessageDelayed(paramMessage.what, this.nhU);
          AppMethodBeat.o(106920);
          return;
        }
        MMViewPager.w(localMMViewPager);
      }
    }
    AppMethodBeat.o(106920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.k
 * JD-Core Version:    0.7.0.1
 */