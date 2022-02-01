package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.g.c;

final class y$19
  implements g.c
{
  y$19(y paramy) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(141349);
    if (paramBoolean)
    {
      h.OAn.b(15181, new Object[] { Integer.valueOf(3) });
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
      ((Intent)localObject).addFlags(268435456);
      paramString = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/ui/MMActivityController$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(141349);
      return;
    }
    h.OAn.b(15181, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(141349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.y.19
 * JD-Core Version:    0.7.0.1
 */