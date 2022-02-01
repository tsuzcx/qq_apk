package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.textstatus.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion;", "", "()V", "KEY_CUSTOM_TITLE", "", "KEY_DEFAULT_BACKGROUND_ID", "KEY_IS_ENTER", "TAG", "start", "", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "requestCode", "", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Integer;)V", "startForResultInEdit", "Landroid/app/Activity;", "defaultBackgroundId", "customTitle", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusDoWhatActivity$a
{
  public static void a(Activity paramActivity, int paramInt, String paramString)
  {
    AppMethodBeat.i(291203);
    s.u(paramActivity, "context");
    Intent localIntent = new Intent((Context)paramActivity, TextStatusDoWhatActivity.class);
    localIntent.putExtra("KEY_DEFAULT_BACKGROUND_ID", paramInt);
    localIntent.putExtra("KEY_CUSTOM_TITLE", paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(3, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "startForResultInEdit", "(Landroid/app/Activity;ILjava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    }
    AppMethodBeat.o(291203);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, Integer paramInteger)
  {
    AppMethodBeat.i(291196);
    s.u(paramContext, "context");
    Intent localIntent = new Intent(paramContext, TextStatusDoWhatActivity.class);
    paramBundle.putBoolean("KEY_IS_ENTER", true);
    localIntent.putExtras(paramBundle);
    if ((paramInteger != null) && ((paramContext instanceof Activity)))
    {
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(paramInteger.intValue(), new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Integer;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      if (!(paramContext instanceof Activity)) {
        break label196;
      }
    }
    label196:
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      if (paramContext != null) {
        paramContext.overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
      }
      AppMethodBeat.o(291196);
      return;
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramBundle.aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Integer;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramBundle.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Integer;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.a
 * JD-Core Version:    0.7.0.1
 */