package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion;", "", "()V", "EDIT_TEXT_MAX_NUM", "", "SMILEY_PANEL_DEFAULT", "SMILEY_PANEL_LEVEL_1", "SMILEY_PANEL_LEVEL_2", "SMILEY_PANEL_LEVEL_3", "TAG", "", "lastThumbBlurBitmap", "Landroid/graphics/Bitmap;", "getLastThumbBlurBitmap", "()Landroid/graphics/Bitmap;", "setLastThumbBlurBitmap", "(Landroid/graphics/Bitmap;)V", "start", "", "context", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "isForward", "", "callback", "Landroid/os/ResultReceiver;", "startForResult", "Landroid/app/Activity;", "reqCode", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditActivity$a
{
  public static void a(Context paramContext, w paramw, boolean paramBoolean, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(291202);
    s.u(paramContext, "context");
    s.u(paramw, "params");
    Intent localIntent = new Intent(paramContext, TextStatusEditActivity.class);
    if (paramBoolean) {
      localIntent.addFlags(33554432);
    }
    localIntent.putExtra("SET_TEXT_PARAMS", paramw.toByteArray());
    localIntent.putExtra("CALLBACK", (Parcelable)paramResultReceiver);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramw = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramw.aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;ZLandroid/os/ResultReceiver;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramw.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;ZLandroid/os/ResultReceiver;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      if (paramContext != null) {
        paramContext.overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
      }
      AppMethodBeat.o(291202);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.a
 * JD-Core Version:    0.7.0.1
 */