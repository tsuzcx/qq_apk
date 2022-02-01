package com.tencent.mm.plugin.story.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ht;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Lcom/tencent/mm/autogen/table/BaseStoryEditorInfo;", "()V", "value", "", "available", "getAvailable", "()Z", "setAvailable", "(Z)V", "", "baseItemData", "getBaseItemData", "()[B", "setBaseItemData", "([B)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "", "mixFlag", "getMixFlag", "()I", "setMixFlag", "(I)V", "mixRetryTime", "getMixRetryTime", "setMixRetryTime", "storyLocalId", "getStoryLocalId", "setStoryLocalId", "timeStamp", "getTimeStamp", "setTimeStamp", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends ht
{
  public static final a SsP;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(119486);
    SsP = new a((byte)0);
    info = ht.aJm();
    AppMethodBeat.o(119486);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119483);
    s.u(paramCursor, "cu");
    AppMethodBeat.o(119483);
    throw null;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119484);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(119484);
    return localMAutoDBInfo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119485);
    new StringBuilder();
    AppMethodBeat.o(119485);
    throw null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryEditorData$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.d
 * JD-Core Version:    0.7.0.1
 */