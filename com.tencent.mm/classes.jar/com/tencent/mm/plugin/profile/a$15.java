package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.o.g;

final class a$15
  implements o.g
{
  a$15(a parama, as paramas, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(231792);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(231792);
      return;
      paramMenuItem = this.gAi;
      Context localContext = this.val$context;
      boolean bool = b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 82, "", "");
      Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), localContext });
      zj localzj;
      if (bool)
      {
        localzj = new zj();
        localzj.efx.dKy = 5;
        localzj.efx.talker = paramMenuItem.field_username;
        localzj.efx.context = localContext;
        localzj.efx.eft = 4;
        EventCenter.instance.publish(localzj);
      }
      AppMethodBeat.o(231792);
      return;
      paramMenuItem = this.gAi;
      localContext = this.val$context;
      bool = b.a((Activity)localContext, "android.permission.CAMERA", 19, "", "");
      Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), localContext });
      if (bool)
      {
        bool = b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 19, "", "");
        Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), localContext });
        if (bool)
        {
          localzj = new zj();
          localzj.efx.dKy = 5;
          localzj.efx.talker = paramMenuItem.field_username;
          localzj.efx.context = localContext;
          localzj.efx.eft = 2;
          EventCenter.instance.publish(localzj);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.15
 * JD-Core Version:    0.7.0.1
 */