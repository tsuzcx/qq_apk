package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion;", "", "()V", "KEY_TOPIC_ID", "", "TAG", "start", "", "context", "Landroid/content/Context;", "topicId", "plugin-textstatus_release"})
public final class TextStatusSameTopicsActivity$a
{
  public static void bE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(216651);
    p.h(paramContext, "context");
    Intent localIntent = new Intent(paramContext, TextStatusSameTopicsActivity.class);
    localIntent.putExtra("topic_id", paramString);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(216651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity.a
 * JD-Core Version:    0.7.0.1
 */