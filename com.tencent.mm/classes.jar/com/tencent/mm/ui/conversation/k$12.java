package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.a.f.c;

final class k$12
  implements f.c
{
  k$12(k paramk, Activity paramActivity) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(38608);
    if (paramBoolean)
    {
      g.yxI.f(15181, new Object[] { Integer.valueOf(3) });
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(ak.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
      paramString = this.val$activity;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/conversation/InitHelper$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/conversation/InitHelper$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(38608);
      return;
    }
    g.yxI.f(15181, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(38608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.12
 * JD-Core Version:    0.7.0.1
 */