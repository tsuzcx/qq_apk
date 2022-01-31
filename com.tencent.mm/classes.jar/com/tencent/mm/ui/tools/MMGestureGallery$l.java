package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public final class MMGestureGallery$l
  extends ak
{
  private boolean cJJ;
  private long nhU;
  WeakReference<MMGestureGallery> znK;
  
  public MMGestureGallery$l(WeakReference<MMGestureGallery> paramWeakReference)
  {
    this.znK = paramWeakReference;
  }
  
  public final void E(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(107681);
    this.cJJ = paramBoolean;
    j(0, paramLong, 0L);
    AppMethodBeat.o(107681);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(107679);
    super.handleMessage(paramMessage);
    removeMessages(paramMessage.what);
    if (this.znK != null)
    {
      MMGestureGallery localMMGestureGallery = (MMGestureGallery)this.znK.get();
      if (localMMGestureGallery != null)
      {
        if (paramMessage.what == 0)
        {
          if ((MMGestureGallery.o(localMMGestureGallery) == 1) || (this.cJJ))
          {
            ab.d("MicroMsg.MMGestureGallery", "single click over!");
            if (MMGestureGallery.h(localMMGestureGallery) != null) {
              MMGestureGallery.c(localMMGestureGallery).post(new MMGestureGallery.l.1(this, localMMGestureGallery));
            }
          }
          MMGestureGallery.a(localMMGestureGallery, 0);
          AppMethodBeat.o(107679);
          return;
        }
        if (paramMessage.what == 1)
        {
          if ((MMGestureGallery.R(localMMGestureGallery) != null) && (!MMGestureGallery.R(localMMGestureGallery).bEL()))
          {
            MMGestureGallery.R(localMMGestureGallery).play();
            sendEmptyMessageDelayed(paramMessage.what, this.nhU);
            AppMethodBeat.o(107679);
            return;
          }
          MMGestureGallery.S(localMMGestureGallery);
          AppMethodBeat.o(107679);
          return;
        }
        removeMessages(2);
        if (MMGestureGallery.T(localMMGestureGallery) != null) {
          MMGestureGallery.c(localMMGestureGallery).post(new MMGestureGallery.l.2(this, localMMGestureGallery));
        }
      }
    }
    AppMethodBeat.o(107679);
  }
  
  public final void j(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107680);
    this.nhU = paramLong2;
    sendEmptyMessageDelayed(paramInt, paramLong1);
    AppMethodBeat.o(107680);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107682);
    removeMessages(0);
    removeMessages(1);
    removeMessages(2);
    AppMethodBeat.o(107682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.l
 * JD-Core Version:    0.7.0.1
 */