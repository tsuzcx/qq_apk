package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.o;

public final class d
  extends a
{
  public d()
  {
    super(9);
  }
  
  public final void a(Context paramContext, final g paramg)
  {
    AppMethodBeat.i(78687);
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(c.i.app_delete_tips), null, null, paramContext.getString(c.i.app_delete), new h.e()
    {
      public final void cS(int paramAnonymousInt1, int paramAnonymousInt2)
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
          localBundle.putLong("fav_local_id", paramg.mParams.getLong("fav_local_id", -1L));
          FavUrlTask localFavUrlTask = new FavUrlTask();
          localFavUrlTask.actionType = 4;
          localFavUrlTask.fKb = localBundle;
          localFavUrlTask.bPu();
          if (localFavUrlTask.result) {
            paramg.hS(true);
          }
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.IzE.el(982, 3);
    AppMethodBeat.o(78687);
  }
  
  public final void a(Context paramContext, g paramg, o paramo)
  {
    AppMethodBeat.i(78686);
    boolean bool1 = paramg.mParams.getBoolean("is_favorite_item", false);
    boolean bool2 = paramg.mParams.getBoolean("key_detail_can_delete", true);
    if ((bool1) && (bool2)) {
      paramo.b(9, paramContext.getString(c.i.app_delete), c.h.bottomsheet_icon_del);
    }
    AppMethodBeat.o(78686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */