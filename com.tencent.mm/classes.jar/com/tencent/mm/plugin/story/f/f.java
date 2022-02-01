package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.i.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class f
{
  public static final a LFY;
  
  static
  {
    AppMethodBeat.i(118653);
    LFY = new a((byte)0);
    AppMethodBeat.o(118653);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic$Companion;", "", "()V", "AVATAR_FLAG_DEFAULT", "", "AVATAR_FLAG_READ", "AVATAR_FLAG_UNREAD", "isStoryUnread", "", "userName", "", "plugin-story_release"})
  public static final class a
  {
    public static boolean isStoryUnread(String paramString)
    {
      AppMethodBeat.i(118652);
      if (paramString == null)
      {
        AppMethodBeat.o(118652);
        return false;
      }
      if (!o.isShowStoryCheck())
      {
        AppMethodBeat.o(118652);
        return false;
      }
      j.b localb = j.LGA;
      paramString = j.b.gcx().bcW(paramString);
      if ((paramString.isValid()) && (paramString.gfW()))
      {
        AppMethodBeat.o(118652);
        return true;
      }
      AppMethodBeat.o(118652);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f
 * JD-Core Version:    0.7.0.1
 */