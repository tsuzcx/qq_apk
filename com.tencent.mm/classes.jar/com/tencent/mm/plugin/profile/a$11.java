package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.n.d;

final class a$11
  implements n.d
{
  a$11(a parama, ad paramad, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(23216);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23216);
      return;
      paramMenuItem = this.ejm;
      Context localContext = this.val$context;
      boolean bool = b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 82, "", "");
      ab.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), localContext });
      ux localux;
      if (bool)
      {
        localux = new ux();
        localux.cLs.cut = 5;
        localux.cLs.talker = paramMenuItem.field_username;
        localux.cLs.context = localContext;
        localux.cLs.cLm = 4;
        com.tencent.mm.sdk.b.a.ymk.l(localux);
      }
      AppMethodBeat.o(23216);
      return;
      paramMenuItem = this.ejm;
      localContext = this.val$context;
      bool = b.a((Activity)localContext, "android.permission.CAMERA", 19, "", "");
      ab.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), localContext });
      if (bool)
      {
        bool = b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 19, "", "");
        ab.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), localContext });
        if (bool)
        {
          localux = new ux();
          localux.cLs.cut = 5;
          localux.cLs.talker = paramMenuItem.field_username;
          localux.cLs.context = localContext;
          localux.cLs.cLm = 2;
          com.tencent.mm.sdk.b.a.ymk.l(localux);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.11
 * JD-Core Version:    0.7.0.1
 */