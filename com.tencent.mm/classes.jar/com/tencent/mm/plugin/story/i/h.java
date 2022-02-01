package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryHistoryItem;", "()V", "value", "", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "", "storyCount", "getStoryCount", "()I", "setStoryCount", "(I)V", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "Companion", "plugin-story_release"})
public final class h
  extends eg
{
  public static final h.a Blx;
  private static final String TAG = "MicroMsg.StoryHistoryInfo";
  private static final c.a info;
  public j BfA;
  
  static
  {
    AppMethodBeat.i(119523);
    Blx = new h.a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfo";
    info = eg.VD();
    AppMethodBeat.o(119523);
  }
  
  public h()
  {
    AppMethodBeat.i(119522);
    this.BfA = new j();
    AppMethodBeat.o(119522);
  }
  
  public final String epd()
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
    Object localObject = this.BfA;
    if (localObject != null) {}
    for (localObject = Integer.valueOf((int)((j)localObject).systemRowid);; localObject = null)
    {
      localObject = ((Integer)localObject).intValue() + " date:" + epd() + " count:" + this.field_count + ']';
      AppMethodBeat.o(119521);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.h
 * JD-Core Version:    0.7.0.1
 */