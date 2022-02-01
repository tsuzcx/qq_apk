package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryHistoryItem;", "()V", "value", "", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "", "storyCount", "getStoryCount", "()I", "setStoryCount", "(I)V", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "Companion", "plugin-story_release"})
public final class h
  extends eg
{
  public static final a ATZ;
  private static final String TAG = "MicroMsg.StoryHistoryInfo";
  private static final c.a info;
  public j ANZ;
  
  static
  {
    AppMethodBeat.i(119523);
    ATZ = new a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfo";
    info = eg.Vv();
    AppMethodBeat.o(119523);
  }
  
  public h()
  {
    AppMethodBeat.i(119522);
    this.ANZ = new j();
    AppMethodBeat.o(119522);
  }
  
  public final String elu()
  {
    AppMethodBeat.i(119519);
    String str = this.field_date;
    p.g(str, "field_date");
    AppMethodBeat.o(119519);
    return str;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119520);
    c.a locala = info;
    p.g(locala, "StoryHistoryInfo.info");
    AppMethodBeat.o(119520);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119521);
    StringBuilder localStringBuilder = new StringBuilder("StoryHistoryInfo[localId:");
    Object localObject = this.ANZ;
    if (localObject != null) {}
    for (localObject = Integer.valueOf((int)((j)localObject).systemRowid);; localObject = null)
    {
      localObject = ((Integer)localObject).intValue() + " date:" + elu() + " count:" + this.field_count + ']';
      AppMethodBeat.o(119521);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "fromItem", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryItem;", "fromStoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.h
 * JD-Core Version:    0.7.0.1
 */