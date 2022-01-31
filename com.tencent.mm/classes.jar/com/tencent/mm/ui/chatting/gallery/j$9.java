package com.tencent.mm.ui.chatting.gallery;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bo;

final class j$9
  implements ak.a
{
  j$9(j paramj) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(32324);
    if (paramMessage.what == 1)
    {
      paramMessage = this.zNd.zJI.dJY();
      if ((paramMessage != null) && (!bo.isNullOrNil(j.a(this.zNd))))
      {
        ab.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), j.a(this.zNd) });
        if (!j.b(this.zNd)) {
          u.f(j.a(this.zNd), paramMessage.dKP().zNt.getCurrentPosition(), j.c(this.zNd));
        }
        j.a(this.zNd, paramMessage);
        j.d(this.zNd).cJ(false);
        if (j.c(this.zNd))
        {
          a.ymk.d(j.e(this.zNd));
          j.f(this.zNd).dKR();
          j.a(this.zNd, false);
        }
      }
      j.g(this.zNd);
    }
    AppMethodBeat.o(32324);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.9
 * JD-Core Version:    0.7.0.1
 */