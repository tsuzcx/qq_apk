package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

final class OfflineVideoView$3
  implements Runnable
{
  OfflineVideoView$3(OfflineVideoView paramOfflineVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(38362);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    k.a(this.rJb.getContext(), localIntent, e.avH(this.mED), "video/*");
    try
    {
      this.rJb.getContext().startActivity(localIntent);
      AppMethodBeat.o(38362);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
      h.h(this.rJb.getContext(), 2131299759, 2131299760);
      AppMethodBeat.o(38362);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.3
 * JD-Core Version:    0.7.0.1
 */