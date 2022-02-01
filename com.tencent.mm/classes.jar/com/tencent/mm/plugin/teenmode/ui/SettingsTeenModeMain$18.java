package com.tencent.mm.plugin.teenmode.ui;

import android.view.MenuItem;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;

final class SettingsTeenModeMain$18
  implements q.g
{
  SettingsTeenModeMain$18(SettingsTeenModeMain paramSettingsTeenModeMain) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(293024);
    if (paramMenuItem.getItemId() == 0)
    {
      ((b)com.tencent.mm.kernel.h.ae(b.class)).gkq();
      w.cR(this.MtV, this.MtV.getString(a.g.MsW));
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293030);
          c.ad(SettingsTeenModeMain.18.this.MtV, "teenmode", ".ui.SettingsTeenModeIntro");
          SettingsTeenModeMain.18.this.MtV.overridePendingTransition(0, 0);
          com.tencent.e.h.ZvG.p(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(293027);
              SettingsTeenModeMain.18.this.MtV.finish();
              AppMethodBeat.o(293027);
            }
          }, 200L);
          AppMethodBeat.o(293030);
        }
      }, 2000L);
    }
    AppMethodBeat.o(293024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.18
 * JD-Core Version:    0.7.0.1
 */