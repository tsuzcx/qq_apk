package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanDirtyData", "", "cleanNullData", "timeStamp", "", "getAllDataIfNoMix", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getByLocalId", "localId", "getByTimeStamp", "getLastDataIfNoMix", "updateByLocal", "id", "editorData", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends MAutoStorage<d>
{
  public static final a SsQ;
  private static final String[] SsR;
  
  static
  {
    AppMethodBeat.i(119487);
    SsQ = new a((byte)0);
    d.a locala = d.SsP;
    SsR = new String[] { MAutoStorage.getCreateSQLs(d.access$getInfo$cp(), "StoryEditorInfo") };
    AppMethodBeat.o(119487);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "Table", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.e
 * JD-Core Version:    0.7.0.1
 */