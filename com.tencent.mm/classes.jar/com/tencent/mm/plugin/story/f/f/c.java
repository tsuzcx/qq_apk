package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "storyOwner", "", "createTime", "", "interactTime", "", "storyIds", "Ljava/util/HashMap;", "(Ljava/lang/String;IJLjava/util/HashMap;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "getInteractTime", "()J", "getStoryIds", "()Ljava/util/HashMap;", "getStoryOwner", "()Ljava/lang/String;", "toString", "plugin-story_release"})
public final class c
{
  int hgr;
  final String ygM;
  private final long yiM;
  final HashMap<Long, Integer> yiN;
  
  private c(String paramString, int paramInt, long paramLong, HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(119044);
    this.ygM = paramString;
    this.hgr = paramInt;
    this.yiM = paramLong;
    this.yiN = paramHashMap;
    AppMethodBeat.o(119044);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119043);
    String str = "StoryCommentReply[" + this.ygM + " : " + this.hgr + " : " + this.yiM + " : " + this.yiN + ']';
    AppMethodBeat.o(119043);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.c
 * JD-Core Version:    0.7.0.1
 */