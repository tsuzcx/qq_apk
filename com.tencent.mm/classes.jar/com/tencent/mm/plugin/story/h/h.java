package com.tencent.mm.plugin.story.h;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.db;
import com.tencent.mm.sdk.e.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryHistoryItem;", "()V", "value", "", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "", "storyCount", "getStoryCount", "()I", "setStoryCount", "(I)V", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "Companion", "plugin-story_release"})
public final class h
  extends db
{
  private static final String TAG = "MicroMsg.StoryHistoryInfo";
  private static final c.a info;
  public static final h.a sGI;
  public j szQ;
  
  static
  {
    AppMethodBeat.i(109906);
    sGI = new h.a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfo";
    info = db.Hm();
    AppMethodBeat.o(109906);
  }
  
  public h()
  {
    AppMethodBeat.i(109905);
    this.szQ = new j();
    AppMethodBeat.o(109905);
  }
  
  public final String cEX()
  {
    AppMethodBeat.i(109902);
    String str = this.field_date;
    a.f.b.j.p(str, "field_date");
    AppMethodBeat.o(109902);
    return str;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(109903);
    c.a locala = info;
    a.f.b.j.p(locala, "StoryHistoryInfo.info");
    AppMethodBeat.o(109903);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109904);
    StringBuilder localStringBuilder = new StringBuilder("StoryHistoryInfo[localId:");
    Object localObject = this.szQ;
    if (localObject != null) {}
    for (localObject = Integer.valueOf((int)((j)localObject).systemRowid);; localObject = null)
    {
      localObject = ((Integer)localObject).intValue() + " date:" + cEX() + " count:" + this.field_count + ']';
      AppMethodBeat.o(109904);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.h
 * JD-Core Version:    0.7.0.1
 */