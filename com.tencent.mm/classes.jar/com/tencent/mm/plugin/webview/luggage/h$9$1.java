package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.c;

final class h$9$1
  implements Runnable
{
  h$9$1(h.9 param9, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(6131);
    c.a(this.cax.getInt("fav_simple_img_result"), (Activity)h.a(this.uSh.uSc).mContext, h.c(this.uSh.uSc));
    AppMethodBeat.o(6131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.9.1
 * JD-Core Version:    0.7.0.1
 */