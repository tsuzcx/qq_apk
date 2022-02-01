package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion;", "", "()V", "KEY_DEFAULT_BACKGROUND_ID", "", "KEY_IS_ENTER", "TAG", "start", "", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "startForResult", "Landroid/app/Activity;", "defaultBackgroundId", "", "plugin-textstatus_release"})
public final class TextStatusDoWhatActivity$a
{
  public static void g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(216467);
    p.h(paramContext, "context");
    Intent localIntent = new Intent(paramContext, TextStatusDoWhatActivity.class);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("KEY_IS_ENTER", true);
    localIntent.putExtras(localBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (!(paramContext instanceof Activity)) {
      paramContext = null;
    }
    for (;;)
    {
      paramContext = (Activity)paramContext;
      if (paramContext != null)
      {
        paramContext.overridePendingTransition(2130772132, 2130771986);
        AppMethodBeat.o(216467);
        return;
      }
      AppMethodBeat.o(216467);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.a
 * JD-Core Version:    0.7.0.1
 */