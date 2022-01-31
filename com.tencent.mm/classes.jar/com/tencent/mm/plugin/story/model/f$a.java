package com.tencent.mm.plugin.story.model;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryAvatarLogic$Companion;", "", "()V", "AVATAR_FLAG_DEFAULT", "", "AVATAR_FLAG_READ", "AVATAR_FLAG_UNREAD", "isStoryUnread", "", "userName", "", "updateStoryStatus", "", "storyId", "", "plugin-story_release"})
public final class f$a
{
  public static boolean isStoryUnread(String paramString)
  {
    AppMethodBeat.i(109022);
    if (paramString == null)
    {
      AppMethodBeat.o(109022);
      return false;
    }
    if (!n.isShowStoryCheck())
    {
      AppMethodBeat.o(109022);
      return false;
    }
    j.b localb = j.svi;
    paramString = j.b.cAC().acU(paramString);
    if ((paramString.isValid()) && (paramString.cEU()))
    {
      AppMethodBeat.o(109022);
      return true;
    }
    AppMethodBeat.o(109022);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.a
 * JD-Core Version:    0.7.0.1
 */