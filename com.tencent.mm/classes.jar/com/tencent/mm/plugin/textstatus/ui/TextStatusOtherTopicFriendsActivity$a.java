package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$Companion;", "", "()V", "KEY_EXCLUDE_TOPIC_ID", "", "KEY_SOURCE", "SOURCE_ME", "", "SOURCE_SAME_RECOMMEND", "SOURCE_UNKNOWN", "TAG", "start", "", "context", "Landroid/content/Context;", "excludeTopicId", "source", "plugin-textstatus_release"})
public final class TextStatusOtherTopicFriendsActivity$a
{
  public static void p(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(233882);
    p.k(paramContext, "context");
    Intent localIntent = new Intent(paramContext, TextStatusOtherTopicFriendsActivity.class);
    localIntent.putExtra("exclude_topic_id", paramString);
    localIntent.putExtra("key_source", paramInt);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(233882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity.a
 * JD-Core Version:    0.7.0.1
 */