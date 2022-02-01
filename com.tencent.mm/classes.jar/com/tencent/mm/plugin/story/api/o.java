package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
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
      paramList = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramList.axQ(), "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramList.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(118427);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.printErrStackTrace("LaunchStory", paramContext, "startStoryBrowse failed", new Object[0]);
      AppMethodBeat.o(118427);
    }
  }
  
  public static void bB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(118423);
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
      localIntent.putExtra("username", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/story/api/LaunchStory", "startStoryBrowse", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(118423);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.printErrStackTrace("LaunchStory", paramContext, "startStoryBrowse failed", new Object[0]);
      AppMethodBeat.o(118423);
    }
  }
  
  public static boolean fnq()
  {
    AppMethodBeat.i(118421);
    if (((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("StoryOpenRoomSync", 1) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("LaunchStory", "isOpenRoomSync %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(118421);
      return true;
    }
    AppMethodBeat.o(118421);
    return false;
  }
  
  public static boolean fnr()
  {
    AppMethodBeat.i(118422);
    if (((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("StoryOpenStrangerUserPage", 1) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("LaunchStory", "isOpenRoomSync %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(118422);
      return true;
    }
    AppMethodBeat.o(118422);
    return false;
  }
  
  public static boolean isShowStoryCheck()
  {
    AppMethodBeat.i(118420);
    boolean bool = ((e)g.ah(e.class)).isShowStoryCheck();
    AppMethodBeat.o(118420);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.o
 * JD-Core Version:    0.7.0.1
 */