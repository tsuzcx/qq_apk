package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ff;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryHistoryItem;", "()V", "value", "", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "", "storyCount", "getStoryCount", "()I", "setStoryCount", "(I)V", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends ff
{
  public static final h.a Stc;
  private static final String TAG;
  private static final IAutoDBItem.MAutoDBInfo info;
  public j SnL;
  
  static
  {
    AppMethodBeat.i(119523);
    Stc = new h.a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfo";
    info = ff.aJm();
    AppMethodBeat.o(119523);
  }
  
  public h()
  {
    AppMethodBeat.i(119522);
    this.SnL = new j();
    AppMethodBeat.o(119522);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119520);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(119520);
    return localMAutoDBInfo;
  }
  
  public final String hzq()
  {
    AppMethodBeat.i(119519);
    String str = this.field_date;
    s.s(str, "field_date");
    AppMethodBeat.o(119519);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119521);
    StringBuilder localStringBuilder = new StringBuilder("StoryHistoryInfo[localId:");
    Object localObject = this.SnL;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf((int)((j)localObject).systemRowid))
    {
      localObject = localObject + " date:" + hzq() + " count:" + this.field_count + ']';
      AppMethodBeat.o(119521);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.h
 * JD-Core Version:    0.7.0.1
 */