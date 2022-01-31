package com.tencent.mm.plugin.story.h;

import a.f.b.j;
import a.l;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ev;
import com.tencent.mm.sdk.e.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Lcom/tencent/mm/autogen/table/BaseStoryEditorInfo;", "()V", "value", "", "available", "getAvailable", "()Z", "setAvailable", "(Z)V", "", "baseItemData", "getBaseItemData", "()[B", "setBaseItemData", "([B)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "", "mixFlag", "getMixFlag", "()I", "setMixFlag", "(I)V", "mixRetryTime", "getMixRetryTime", "setMixRetryTime", "storyLocalId", "getStoryLocalId", "setStoryLocalId", "timeStamp", "getTimeStamp", "setTimeStamp", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-story_release"})
public final class d
  extends ev
{
  private static final c.a info;
  public static final d.a sGu;
  private long fDL;
  
  static
  {
    AppMethodBeat.i(109864);
    sGu = new d.a((byte)0);
    info = ev.Hm();
    AppMethodBeat.o(109864);
  }
  
  public final boolean cEN()
  {
    return this.field_available != 0;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(109861);
    j.q(paramCursor, "cu");
    super.convertFrom(paramCursor);
    this.fDL = this.systemRowid;
    AppMethodBeat.o(109861);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(109862);
    c.a locala = info;
    j.p(locala, "info");
    AppMethodBeat.o(109862);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109863);
    String str = this.field_timeStamp + ", " + this.systemRowid + ", " + this.field_mixFlag;
    AppMethodBeat.o(109863);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.d
 * JD-Core Version:    0.7.0.1
 */