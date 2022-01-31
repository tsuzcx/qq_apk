package com.tencent.mm.ui.chatting.gallery;

import android.os.Message;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class j$11
  implements ah.a
{
  j$11(j paramj) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = this.vwT.vtH.cFV();
      if ((paramMessage != null) && (!bk.bl(j.a(this.vwT))))
      {
        y.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), j.a(this.vwT) });
        if (!j.b(this.vwT)) {
          u.f(j.a(this.vwT), paramMessage.cGH().vxj.getCurrentPosition(), j.c(this.vwT));
        }
        j.a(this.vwT, paramMessage);
        j.d(this.vwT).bH(false);
        if (j.c(this.vwT))
        {
          a.udP.d(j.e(this.vwT));
          j.f(this.vwT).cGJ();
          j.a(this.vwT, false);
        }
      }
      j.g(this.vwT);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.11
 * JD-Core Version:    0.7.0.1
 */