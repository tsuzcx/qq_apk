package com.tencent.mm.plugin.story.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/gallery/NewestStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "userList", "", "", "queryCondition", "", "(JLjava/util/List;I)V", "getUserList", "()Ljava/util/List;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends p
{
  final List<String> oxE;
  
  public d(long paramLong, List<String> paramList, int paramInt)
  {
    super(paramLong, paramInt);
    AppMethodBeat.i(118909);
    this.oxE = paramList;
    AppMethodBeat.o(118909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.d
 * JD-Core Version:    0.7.0.1
 */