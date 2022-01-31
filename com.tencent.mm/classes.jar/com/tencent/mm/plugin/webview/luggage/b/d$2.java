package com.tencent.mm.plugin.webview.luggage.b;

import android.os.Bundle;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.ui.base.h.d;

final class d$2
  implements h.d
{
  d$2(d paramd, e parame) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6426);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6426);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putLong("fav_local_id", this.nka.bzu.getLong("fav_local_id", -1L));
      FavUrlTask localFavUrlTask = new FavUrlTask();
      localFavUrlTask.actionType = 4;
      localFavUrlTask.mEJ = localBundle;
      AppBrandMainProcessService.b(localFavUrlTask);
      if (localFavUrlTask.cmX) {
        this.nka.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.d.2
 * JD-Core Version:    0.7.0.1
 */