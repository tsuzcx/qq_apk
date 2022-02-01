package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "storyOwner", "", "createTime", "", "interactTime", "", "storyIds", "Ljava/util/HashMap;", "(Ljava/lang/String;IJLjava/util/HashMap;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "getInteractTime", "()J", "getStoryIds", "()Ljava/util/HashMap;", "getStoryOwner", "()Ljava/lang/String;", "toString", "plugin-story_release"})
public final class c
{
  int hGU;
  final String ztM;
  private final long zvL;
  final HashMap<Long, Integer> zvM;
  
  private c(String paramString, int paramInt, long paramLong, HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(119044);
    this.ztM = paramString;
    this.hGU = paramInt;
    this.zvL = paramLong;
    this.zvM = paramHashMap;
    AppMethodBeat.o(119044);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119043);
    String str = "StoryCommentReply[" + this.ztM + " : " + this.hGU + " : " + this.zvL + " : " + this.zvM + ']';
    AppMethodBeat.o(119043);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.c
 * JD-Core Version:    0.7.0.1
 */