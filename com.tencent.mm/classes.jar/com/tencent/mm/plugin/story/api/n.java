package com.tencent.mm.plugin.story.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class n
{
  public static void a(Context paramContext, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(56487);
    if ((com.tencent.mm.r.a.bN(paramContext)) || (com.tencent.mm.r.a.bO(paramContext)) || (com.tencent.mm.r.a.bM(paramContext)))
    {
      ab.i("LaunchStory", "startStoryCapture, voip or multitalk running");
      AppMethodBeat.o(56487);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      if (!b.a((Activity)paramContext, "android.permission.CAMERA", 24, "", ""))
      {
        AppMethodBeat.o(56487);
        return;
      }
      if (!b.a((Activity)paramContext, "android.permission.RECORD_AUDIO", 24, "", ""))
      {
        AppMethodBeat.o(56487);
        return;
      }
      if (!b.a((Activity)paramContext, "android.permission.ACCESS_COARSE_LOCATION", 78, "", ""))
      {
        AppMethodBeat.o(56487);
        return;
      }
    }
    ab.i("LaunchStory", "startStoryCapture %s", new Object[] { bo.dtY().toString() });
    Intent localIntent;
    try
    {
      localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.story.ui.StoryCaptureUI"));
      localIntent.putExtra("jump_page_from", paramInt1);
      localIntent.putExtra("video_object_id", paramLong);
      if (((paramContext instanceof Activity)) && (paramInt2 >= 0))
      {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
        AppMethodBeat.o(56487);
        return;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      ab.printErrStackTrace("LaunchStory", paramContext, "startStoryCapture failed", new Object[0]);
      AppMethodBeat.o(56487);
      return;
    }
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(56487);
  }
  
  public static void a(Context paramContext, List<String> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(56492);
    try
    {
      paramList = new ArrayList(paramList);
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
      localIntent.putExtra("user_list", paramList);
      localIntent.putExtra("delete_when_first_empty", false);
      localIntent.putExtra("gallery_chat_room", paramString1);
      localIntent.putExtra("gallery_session_id", paramString2);
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(56492);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      ab.printErrStackTrace("LaunchStory", paramContext, "startStoryBrowse failed", new Object[0]);
      AppMethodBeat.o(56492);
    }
  }
  
  public static void aS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(56488);
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
      localIntent.putExtra("username", paramString);
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(56488);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      ab.printErrStackTrace("LaunchStory", paramContext, "startStoryBrowse failed", new Object[0]);
      AppMethodBeat.o(56488);
    }
  }
  
  public static void acB(String paramString)
  {
    AppMethodBeat.i(56489);
    ((e)g.G(e.class)).preLoadVideoViewMgr(paramString);
    AppMethodBeat.o(56489);
  }
  
  public static void bj(int paramInt, String paramString)
  {
    AppMethodBeat.i(56490);
    ((e)g.G(e.class)).checkReportFromChatting(paramInt, paramString);
    AppMethodBeat.o(56490);
  }
  
  public static boolean czA()
  {
    AppMethodBeat.i(56485);
    if (((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("StoryOpenRoomSync", 1) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("LaunchStory", "isOpenRoomSync %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(56485);
      return true;
    }
    AppMethodBeat.o(56485);
    return false;
  }
  
  public static boolean czB()
  {
    AppMethodBeat.i(56486);
    if (((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("StoryOpenStrangerUserPage", 1) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("LaunchStory", "isOpenRoomSync %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(56486);
      return true;
    }
    AppMethodBeat.o(56486);
    return false;
  }
  
  public static void enterGallery(List<String> paramList)
  {
    AppMethodBeat.i(56491);
    ((e)g.G(e.class)).enterGallery(paramList);
    AppMethodBeat.o(56491);
  }
  
  public static boolean isShowStoryCheck()
  {
    AppMethodBeat.i(56484);
    boolean bool = ((e)g.G(e.class)).isShowStoryCheck();
    AppMethodBeat.o(56484);
    return bool;
  }
  
  public static void n(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(56483);
    a(paramContext, 1, paramLong, -1);
    AppMethodBeat.o(56483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.n
 * JD-Core Version:    0.7.0.1
 */