package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fr;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Lcom/tencent/mm/autogen/table/BaseStoryEditorInfo;", "()V", "value", "", "available", "getAvailable", "()Z", "setAvailable", "(Z)V", "", "baseItemData", "getBaseItemData", "()[B", "setBaseItemData", "([B)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "", "mixFlag", "getMixFlag", "()I", "setMixFlag", "(I)V", "mixRetryTime", "getMixRetryTime", "setMixRetryTime", "storyLocalId", "getStoryLocalId", "setStoryLocalId", "timeStamp", "getTimeStamp", "setTimeStamp", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-story_release"})
public final class d
  extends fr
{
  private static final c.a info;
  public static final a yoO;
  private long deI;
  
  static
  {
    AppMethodBeat.i(119486);
    yoO = new a((byte)0);
    info = fr.So();
    AppMethodBeat.o(119486);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(119483);
    k.h(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.deI = this.systemRowid;
    AppMethodBeat.o(119483);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119484);
    c.a locala = info;
    k.g(locala, "info");
    AppMethodBeat.o(119484);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119485);
    String str = this.field_timeStamp + ", " + this.systemRowid + ", " + this.field_mixFlag;
    AppMethodBeat.o(119485);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryEditorData$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.d
 * JD-Core Version:    0.7.0.1
 */