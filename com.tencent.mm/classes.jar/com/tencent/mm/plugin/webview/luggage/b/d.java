package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.l;

public final class d
  extends a
{
  public d()
  {
    super(9);
  }
  
  public final void a(Context paramContext, final f paramf)
  {
    AppMethodBeat.i(78687);
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131755709), null, null, paramContext.getString(2131755707), new h.d()
    {
      public final void ct(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78685);
        switch (paramAnonymousInt2)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(78685);
          return;
          Bundle localBundle = new Bundle();
          localBundle.putLong("fav_local_id", paramf.mParams.getLong("fav_local_id", -1L));
          FavUrlTask localFavUrlTask = new FavUrlTask();
          localFavUrlTask.actionType = 4;
          localFavUrlTask.dmf = localBundle;
          AppBrandMainProcessService.b(localFavUrlTask);
          if (localFavUrlTask.result) {
            paramf.gb(true);
          }
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.wUl.dB(982, 3);
    AppMethodBeat.o(78687);
  }
  
  public final void a(Context paramContext, f paramf, l paraml)
  {
    AppMethodBeat.i(78686);
    boolean bool1 = paramf.mParams.getBoolean("is_favorite_item", false);
    boolean bool2 = paramf.mParams.getBoolean("key_detail_can_delete", true);
    if ((bool1) && (bool2)) {
      paraml.a(9, paramContext.getString(2131755707), 2131689802);
    }
    AppMethodBeat.o(78686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */