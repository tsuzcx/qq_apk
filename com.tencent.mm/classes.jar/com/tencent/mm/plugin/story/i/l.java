package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.sdk.e.c.a;
import d.g.a.m;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryRoomInfo;", "()V", "value", "", "extBuf", "getExtBuf", "()[B", "setExtBuf", "([B)V", "", "", "newStoryList", "getNewStoryList", "()Ljava/util/List;", "setNewStoryList", "(Ljava/util/List;)V", "", "nextSyncTime", "getNextSyncTime", "()J", "setNextSyncTime", "(J)V", "roomName", "getRoomName", "()Ljava/lang/String;", "setRoomName", "(Ljava/lang/String;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-story_release"})
public final class l
  extends fx
{
  private static final String TAG = "MicroMsg.StoryExtInfo";
  private static final c.a info;
  public static final l.a zCQ;
  private static final m<Long, Long, Boolean> zCq;
  
  static
  {
    AppMethodBeat.i(119595);
    zCQ = new l.a((byte)0);
    TAG = "MicroMsg.StoryExtInfo";
    info = fx.Th();
    zCq = (m)l.b.zCR;
    AppMethodBeat.o(119595);
  }
  
  public l()
  {
    AppMethodBeat.i(119594);
    k.h("", "value");
    this.field_roomname = "";
    AppMethodBeat.o(119594);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119593);
    c.a locala = info;
    k.g(locala, "StoryRoomInfo.info");
    AppMethodBeat.o(119593);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.l
 * JD-Core Version:    0.7.0.1
 */