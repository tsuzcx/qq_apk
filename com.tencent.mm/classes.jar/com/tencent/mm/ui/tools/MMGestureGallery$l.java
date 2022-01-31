package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class MMGestureGallery$l
  extends ah
{
  private boolean cbg;
  private long kLr;
  WeakReference<MMGestureGallery> uZt;
  
  public MMGestureGallery$l(WeakReference<MMGestureGallery> paramWeakReference)
  {
    this.uZt = paramWeakReference;
  }
  
  public final void h(int paramInt, long paramLong1, long paramLong2)
  {
    this.kLr = paramLong2;
    sendEmptyMessageDelayed(paramInt, paramLong1);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    removeMessages(paramMessage.what);
    MMGestureGallery localMMGestureGallery;
    if (this.uZt != null)
    {
      localMMGestureGallery = (MMGestureGallery)this.uZt.get();
      if (localMMGestureGallery != null)
      {
        if (paramMessage.what != 0) {
          break label95;
        }
        if ((MMGestureGallery.o(localMMGestureGallery) == 1) || (this.cbg))
        {
          y.d("MicroMsg.MMGestureGallery", "single click over!");
          if (MMGestureGallery.h(localMMGestureGallery) != null) {
            MMGestureGallery.c(localMMGestureGallery).post(new MMGestureGallery.l.1(this, localMMGestureGallery));
          }
        }
        MMGestureGallery.a(localMMGestureGallery, 0);
      }
    }
    label95:
    do
    {
      return;
      if (paramMessage.what == 1)
      {
        if ((MMGestureGallery.R(localMMGestureGallery) != null) && (!MMGestureGallery.R(localMMGestureGallery).aXY()))
        {
          MMGestureGallery.R(localMMGestureGallery).play();
          sendEmptyMessageDelayed(paramMessage.what, this.kLr);
          return;
        }
        MMGestureGallery.S(localMMGestureGallery);
        return;
      }
      removeMessages(2);
    } while (MMGestureGallery.T(localMMGestureGallery) == null);
    MMGestureGallery.c(localMMGestureGallery).post(new MMGestureGallery.l.2(this, localMMGestureGallery));
  }
  
  public final void release()
  {
    removeMessages(0);
    removeMessages(1);
    removeMessages(2);
  }
  
  public final void x(long paramLong, boolean paramBoolean)
  {
    this.cbg = paramBoolean;
    h(0, paramLong, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.l
 * JD-Core Version:    0.7.0.1
 */