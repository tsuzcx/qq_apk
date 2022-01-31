package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class t$6$1
  implements Runnable
{
  t$6$1(t.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(30740);
    if ((!bo.isNullOrNil(this.zAn.zAm.pOI)) && (!bo.isNullOrNil(this.zAn.zAm.pOJ)))
    {
      t localt = this.zAn.zAm;
      ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[downloadQQMail]");
      g.a locala = new g.a();
      locala.JJ(localt.pOI);
      locala.JL(localt.mContext.getResources().getString(2131299014));
      locala.JM(localt.pOJ);
      locala.gr(true);
      locala.tV(1);
      localt.lIf = f.bjl().a(locala.kYR);
      if (localt.lIf > 0L)
      {
        localt.sp = localt.mContext.getSharedPreferences("QQMAIL", h.Mp());
        localt.sp.edit().putLong("qqmail_downloadid", localt.lIf).apply();
        localt.dGD();
      }
      AppMethodBeat.o(30740);
      return;
    }
    t.a(this.zAn.zAm);
    AppMethodBeat.o(30740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.6.1
 * JD-Core Version:    0.7.0.1
 */