package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$Companion;", "", "()V", "KEY_EXCLUDE_TOPIC_ID", "", "KEY_SOURCE", "REQUEST_CODE_GO_CARD_FEEDS", "", "REQUEST_CODE_SET_TEXT_STATUS", "SOURCE_ICON_ME", "SOURCE_ICON_OTHERS", "SOURCE_ME_NO_STATUS", "SOURCE_SAME_RECOMMEND", "SOURCE_UNKNOWN", "TAG", "start", "", "context", "Landroid/content/Context;", "excludeTopicId", "source", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusOtherTopicFriendsActivity$a
{
  private static void r(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(291708);
    s.u(paramContext, "context");
    Intent localIntent = new Intent(paramContext, TextStatusOtherTopicFriendsActivity.class);
    localIntent.putExtra("exclude_topic_id", paramString);
    localIntent.putExtra("key_source", paramInt);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(291708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity.a
 * JD-Core Version:    0.7.0.1
 */