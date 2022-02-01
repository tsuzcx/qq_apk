package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanDirtyData", "", "cleanNullData", "timeStamp", "", "getAllDataIfNoMix", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getByLocalId", "localId", "getByTimeStamp", "getLastDataIfNoMix", "updateByLocal", "id", "editorData", "Companion", "plugin-story_release"})
public final class e
  extends j<d>
{
  private static final String[] ATN;
  public static final a ATO;
  
  static
  {
    AppMethodBeat.i(119487);
    ATO = new a((byte)0);
    d.a locala = d.ATM;
    ATN = new String[] { j.getCreateSQLs(d.access$getInfo$cp(), "StoryEditorInfo") };
    AppMethodBeat.o(119487);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "Table", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.e
 * JD-Core Version:    0.7.0.1
 */