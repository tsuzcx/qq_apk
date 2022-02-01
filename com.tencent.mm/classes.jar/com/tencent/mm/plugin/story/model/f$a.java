package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic$Companion;", "", "()V", "AVATAR_FLAG_DEFAULT", "", "AVATAR_FLAG_READ", "AVATAR_FLAG_UNREAD", "isStoryUnread", "", "userName", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$a
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
    StoryCore.b localb = StoryCore.SjP;
    paramString = StoryCore.b.hvS().bbJ(paramString);
    if ((paramString.isValid()) && (paramString.hzn()))
    {
      AppMethodBeat.o(118652);
      return true;
    }
    AppMethodBeat.o(118652);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.a
 * JD-Core Version:    0.7.0.1
 */