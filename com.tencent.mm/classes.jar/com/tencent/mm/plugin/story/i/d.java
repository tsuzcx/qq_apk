package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gr;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Lcom/tencent/mm/autogen/table/BaseStoryEditorInfo;", "()V", "value", "", "available", "getAvailable", "()Z", "setAvailable", "(Z)V", "", "baseItemData", "getBaseItemData", "()[B", "setBaseItemData", "([B)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "", "mixFlag", "getMixFlag", "()I", "setMixFlag", "(I)V", "mixRetryTime", "getMixRetryTime", "setMixRetryTime", "storyLocalId", "getStoryLocalId", "setStoryLocalId", "timeStamp", "getTimeStamp", "setTimeStamp", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-story_release"})
public final class d
  extends gr
{
  public static final a Fwa;
  private static final IAutoDBItem.MAutoDBInfo info;
  private long localId;
  
  static
  {
    AppMethodBeat.i(119486);
    Fwa = new a((byte)0);
    info = gr.ajs();
    AppMethodBeat.o(119486);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119483);
    p.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.localId = this.systemRowid;
    AppMethodBeat.o(119483);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119484);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "info");
    AppMethodBeat.o(119484);
    return localMAutoDBInfo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119485);
    String str = this.field_timeStamp + ", " + this.systemRowid + ", " + this.field_mixFlag;
    AppMethodBeat.o(119485);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryEditorData$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.d
 * JD-Core Version:    0.7.0.1
 */