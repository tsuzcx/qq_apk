package com.tencent.mm.plugin.story.h;

import a.f.a.m;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ex;
import com.tencent.mm.sdk.e.c.a;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryRoomInfo;", "()V", "value", "", "extBuf", "getExtBuf", "()[B", "setExtBuf", "([B)V", "", "", "newStoryList", "getNewStoryList", "()Ljava/util/List;", "setNewStoryList", "(Ljava/util/List;)V", "", "nextSyncTime", "getNextSyncTime", "()J", "setNextSyncTime", "(J)V", "roomName", "getRoomName", "()Ljava/lang/String;", "setRoomName", "(Ljava/lang/String;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-story_release"})
public final class l
  extends ex
{
  private static final String TAG = "MicroMsg.StoryExtInfo";
  private static final c.a info;
  public static final a sGZ;
  private static final m<Long, Long, Boolean> sGx;
  
  static
  {
    AppMethodBeat.i(109970);
    sGZ = new a((byte)0);
    TAG = "MicroMsg.StoryExtInfo";
    info = ex.Hm();
    sGx = (m)l.b.sHa;
    AppMethodBeat.o(109970);
  }
  
  public l()
  {
    AppMethodBeat.i(109969);
    j.q("", "value");
    this.field_roomname = "";
    AppMethodBeat.o(109969);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(109968);
    c.a locala = info;
    j.p(locala, "StoryRoomInfo.info");
    AppMethodBeat.o(109968);
    return locala;
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "compareUnsignedLong", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "i", "j", "", "getCompareUnsignedLong", "()Lkotlin/jvm/functions/Function2;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.l
 * JD-Core Version:    0.7.0.1
 */