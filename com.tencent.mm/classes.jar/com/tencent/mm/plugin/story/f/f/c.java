package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "storyOwner", "", "createTime", "", "interactTime", "", "storyIds", "Ljava/util/HashMap;", "(Ljava/lang/String;IJLjava/util/HashMap;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "getInteractTime", "()J", "getStoryIds", "()Ljava/util/HashMap;", "getStoryOwner", "()Ljava/lang/String;", "toString", "plugin-story_release"})
public final class c
{
  final String Foa;
  private final long FpZ;
  final HashMap<Long, Integer> Fqa;
  int iXu;
  
  private c(String paramString, int paramInt, long paramLong, HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(119044);
    this.Foa = paramString;
    this.iXu = paramInt;
    this.FpZ = paramLong;
    this.Fqa = paramHashMap;
    AppMethodBeat.o(119044);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119043);
    String str = "StoryCommentReply[" + this.Foa + " : " + this.iXu + " : " + this.FpZ + " : " + this.Fqa + ']';
    AppMethodBeat.o(119043);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.c
 * JD-Core Version:    0.7.0.1
 */