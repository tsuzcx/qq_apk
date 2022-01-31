package com.tencent.mm.plugin.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1$1$1
  implements Runnable
{
  a$1$1$1(a.1.1 param1, int paramInt1, boolean paramBoolean, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(23092);
    aw.getNotification().ih(this.piv);
    if (!this.kLR) {
      aw.getNotification().y(this.pix.pit, this.piw);
    }
    ab.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[] { Integer.valueOf(this.piv), Integer.valueOf(this.piw), Boolean.valueOf(this.kLR) });
    d.post(new a.1.1.1.1(this), "NotificationObserver");
    AppMethodBeat.o(23092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a.1.1.1
 * JD-Core Version:    0.7.0.1
 */