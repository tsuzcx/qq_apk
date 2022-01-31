package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.b.e.c;

final class j$12
  implements e.c
{
  j$12(j paramj, Activity paramActivity) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(34481);
    if (paramBoolean)
    {
      h.qsU.e(15181, new Object[] { Integer.valueOf(3) });
      paramString = new Intent();
      paramString.setClassName(ah.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
      this.val$activity.startActivity(paramString);
      AppMethodBeat.o(34481);
      return;
    }
    h.qsU.e(15181, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(34481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.12
 * JD-Core Version:    0.7.0.1
 */