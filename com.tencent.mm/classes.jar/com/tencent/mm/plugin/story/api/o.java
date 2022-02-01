package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class o
{
  public static void a(Context paramContext, List<String> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(118427);
    try
    {
      paramList = new ArrayList(paramList);
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
      localIntent.putExtra("user_list", paramList);
      localIntent.putExtra("delete_when_first_empty", false);
      localIntent.putExtra("gallery_chat_room", paramString1);
      localIntent.putExtra("gallery_session_id", paramString2);
      paramList = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramList.aYi(), "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramList.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(118427);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.printErrStackTrace("LaunchStory", paramContext, "startStoryBrowse failed", new Object[0]);
      AppMethodBeat.o(118427);
    }
  }
  
  public static void bT(Context paramContext, String paramString)
  {
    AppMethodBeat.i(118423);
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
      localIntent.putExtra("username", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(118423);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.printErrStackTrace("LaunchStory", paramContext, "startStoryBrowse failed", new Object[0]);
      AppMethodBeat.o(118423);
    }
  }
  
  public static boolean isShowStoryCheck()
  {
    AppMethodBeat.i(118420);
    boolean bool = ((e)h.az(e.class)).isShowStoryCheck();
    AppMethodBeat.o(118420);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.o
 * JD-Core Version:    0.7.0.1
 */