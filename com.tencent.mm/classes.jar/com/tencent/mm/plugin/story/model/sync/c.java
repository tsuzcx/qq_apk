package com.tencent.mm.plugin.story.model.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "storyOwner", "", "createTime", "", "interactTime", "", "storyIds", "Ljava/util/HashMap;", "(Ljava/lang/String;IJLjava/util/HashMap;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "getInteractTime", "()J", "getStoryIds", "()Ljava/util/HashMap;", "getStoryOwner", "()Ljava/lang/String;", "toString", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final String SlC;
  private final long Snv;
  final HashMap<Long, Integer> Snw;
  int createTime;
  
  private c(String paramString, int paramInt, long paramLong, HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(119044);
    this.SlC = paramString;
    this.createTime = paramInt;
    this.Snv = paramLong;
    this.Snw = paramHashMap;
    AppMethodBeat.o(119044);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119043);
    String str = "StoryCommentReply[" + this.SlC + " : " + this.createTime + " : " + this.Snv + " : " + this.Snw + ']';
    AppMethodBeat.o(119043);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.sync.c
 * JD-Core Version:    0.7.0.1
 */