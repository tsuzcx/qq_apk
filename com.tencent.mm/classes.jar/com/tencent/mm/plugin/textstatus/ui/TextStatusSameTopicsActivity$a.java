package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion;", "", "()V", "KEY_ENTER_USER_NAME", "", "KEY_IS_SHOW_OTHER_TOPICS", "KEY_SAME_FRIEND_PAGE_SOURCE", "KEY_TOPIC_ID", "PAGE_SOURCE_MY_PROFILE", "", "PAGE_SOURCE_OTHER_FRIEND_STATUS", "PAGE_SOURCE_OTHER_PROFILE", "PAGE_SOURCE_UNKNOWN", "TAG", "start", "", "context", "Landroid/content/Context;", "topicId", "isShowOtherTopicsEntry", "", "sameFriendPageSource", "enterUserName", "plugin-textstatus_release"})
public final class TextStatusSameTopicsActivity$a
{
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    AppMethodBeat.i(235686);
    p.k(paramContext, "context");
    Intent localIntent = new Intent(paramContext, TextStatusSameTopicsActivity.class);
    localIntent.putExtra("topic_id", paramString1);
    localIntent.putExtra("is_show_other_topics", paramBoolean);
    localIntent.putExtra("same_friend_page_source", paramInt);
    localIntent.putExtra("enter_username", paramString2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;ZILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;ZILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(235686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity.a
 * JD-Core Version:    0.7.0.1
 */