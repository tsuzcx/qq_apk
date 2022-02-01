package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "storyOwner", "", "createTime", "", "interactTime", "", "storyIds", "Ljava/util/HashMap;", "(Ljava/lang/String;IJLjava/util/HashMap;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "getInteractTime", "()J", "getStoryIds", "()Ljava/util/HashMap;", "getStoryOwner", "()Ljava/lang/String;", "toString", "plugin-story_release"})
public final class c
{
  final String ALG;
  private final long ANH;
  final HashMap<Long, Integer> ANI;
  int hZE;
  
  private c(String paramString, int paramInt, long paramLong, HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(119044);
    this.ALG = paramString;
    this.hZE = paramInt;
    this.ANH = paramLong;
    this.ANI = paramHashMap;
    AppMethodBeat.o(119044);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119043);
    String str = "StoryCommentReply[" + this.ALG + " : " + this.hZE + " : " + this.ANH + " : " + this.ANI + ']';
    AppMethodBeat.o(119043);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.c
 * JD-Core Version:    0.7.0.1
 */