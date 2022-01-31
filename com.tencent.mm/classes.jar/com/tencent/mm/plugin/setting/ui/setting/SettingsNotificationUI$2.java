package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.d;
import com.tencent.mm.ui.widget.b.e.c;

final class SettingsNotificationUI$2
  implements e.c
{
  SettingsNotificationUI$2(SettingsNotificationUI paramSettingsNotificationUI) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(127353);
    if (paramBoolean)
    {
      SettingsNotificationUI.a(this.qJo, new d()
      {
        public final void De(int paramAnonymousInt)
        {
          AppMethodBeat.i(127352);
          if (!f.My())
          {
            SettingsNotificationUI.2.this.qJo.initView();
            AppMethodBeat.o(127352);
            return;
          }
          f.bT(true);
          SettingsNotificationUI.2.this.qJo.initView();
          h.qsU.idkeyStat(500L, 0L, 1L, false);
          au.k(true, false);
          AppMethodBeat.o(127352);
        }
      });
      AppMethodBeat.o(127353);
      return;
    }
    this.qJo.initView();
    AppMethodBeat.o(127353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.2
 * JD-Core Version:    0.7.0.1
 */