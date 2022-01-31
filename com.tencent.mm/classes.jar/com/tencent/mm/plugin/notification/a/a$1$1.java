package com.tencent.mm.plugin.notification.a;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, String paramString) {}
  
  public final void run()
  {
    final int i = 0;
    if (!g.DN().Dc())
    {
      y.w("MicroMsg.NotificationObserver", "account not init.");
      return;
    }
    final int j = f.Ax();
    au.Hx();
    ad localad = c.Fw().abl(this.mIm);
    final boolean bool;
    if (localad == null)
    {
      bool = false;
      if (!bool) {
        break label76;
      }
    }
    for (;;)
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          au.getNotification().fT(j);
          if (!bool) {
            au.getNotification().t(a.1.1.this.mIm, i);
          }
          y.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
          e.post(new a.1.1.1.1(this), "NotificationObserver");
        }
      });
      return;
      bool = localad.Bj();
      break;
      label76:
      i = f.fl(this.mIm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a.1.1
 * JD-Core Version:    0.7.0.1
 */