package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.i.g;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class f
{
  public static final a AJz;
  
  static
  {
    AppMethodBeat.i(118653);
    AJz = new a((byte)0);
    AppMethodBeat.o(118653);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic$Companion;", "", "()V", "AVATAR_FLAG_DEFAULT", "", "AVATAR_FLAG_READ", "AVATAR_FLAG_UNREAD", "isStoryUnread", "", "userName", "", "plugin-story_release"})
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
      j.b localb = j.AKb;
      paramString = j.b.ehU().aBD(paramString);
      if ((paramString.isValid()) && (paramString.elr()))
      {
        AppMethodBeat.o(118652);
        return true;
      }
      AppMethodBeat.o(118652);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f
 * JD-Core Version:    0.7.0.1
 */