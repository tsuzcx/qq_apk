package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.q.g;

final class a$16
  implements q.g
{
  a$16(a parama, as paramas, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(285888);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(285888);
      return;
      paramMenuItem = this.jkl;
      Context localContext = this.val$context;
      boolean bool = b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 82, "", "");
      Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), localContext });
      aaq localaaq;
      if (bool)
      {
        localaaq = new aaq();
        localaaq.fZM.fDn = 5;
        localaaq.fZM.talker = paramMenuItem.field_username;
        localaaq.fZM.context = localContext;
        localaaq.fZM.fZI = 4;
        EventCenter.instance.publish(localaaq);
      }
      AppMethodBeat.o(285888);
      return;
      paramMenuItem = this.jkl;
      localContext = this.val$context;
      bool = b.a((Activity)localContext, "android.permission.CAMERA", 19, "", "");
      Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), localContext });
      if (bool)
      {
        bool = b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 19, "", "");
        Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), localContext });
        if (bool)
        {
          localaaq = new aaq();
          localaaq.fZM.fDn = 5;
          localaaq.fZM.talker = paramMenuItem.field_username;
          localaaq.fZM.context = localContext;
          localaaq.fZM.fZI = 2;
          EventCenter.instance.publish(localaaq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.16
 * JD-Core Version:    0.7.0.1
 */