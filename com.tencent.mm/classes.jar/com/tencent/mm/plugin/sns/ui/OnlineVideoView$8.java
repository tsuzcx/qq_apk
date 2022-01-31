package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.vfs.e;

final class OnlineVideoView$8
  implements Runnable
{
  OnlineVideoView$8(OnlineVideoView paramOnlineVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(38397);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    k.a(this.rJD.getContext(), localIntent, e.avH(this.mED), "video/*");
    try
    {
      this.rJD.getContext().startActivity(localIntent);
      AppMethodBeat.o(38397);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
      try
      {
        e.a locala = new e.a(this.rJD.getContext());
        locala.avu(this.rJD.getContext().getString(2131299759));
        locala.aj(this.rJD.getContext().getString(2131299760)).c(new OnlineVideoView.8.1(this)).show();
        AppMethodBeat.o(38397);
        return;
      }
      catch (Throwable localThrowable)
      {
        ab.e("MicroMsg.OnlineVideoView", "showAlert fail");
        AppMethodBeat.o(38397);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.8
 * JD-Core Version:    0.7.0.1
 */