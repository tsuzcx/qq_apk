package com.tencent.mm.plugin.story.model.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "storyOwner", "", "storyIds", "Ljava/util/HashMap;", "", "", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getStoryIds", "()Ljava/util/HashMap;", "getStoryOwner", "()Ljava/lang/String;", "toString", "plugin-story_release"})
public final class c
{
  private final String sxC;
  final HashMap<Long, Integer> szz;
  
  private c(String paramString, HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(138795);
    this.sxC = paramString;
    this.szz = paramHashMap;
    AppMethodBeat.o(138795);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(138794);
    String str = "StoryCommentReply[" + this.sxC + " : " + this.szz + ']';
    AppMethodBeat.o(138794);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.c
 * JD-Core Version:    0.7.0.1
 */