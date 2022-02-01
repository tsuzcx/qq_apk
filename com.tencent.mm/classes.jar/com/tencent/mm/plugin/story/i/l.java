package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gt;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.a.m;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/autogen/table/BaseStoryRoomInfo;", "()V", "value", "", "extBuf", "getExtBuf", "()[B", "setExtBuf", "([B)V", "", "", "newStoryList", "getNewStoryList", "()Ljava/util/List;", "setNewStoryList", "(Ljava/util/List;)V", "", "nextSyncTime", "getNextSyncTime", "()J", "setNextSyncTime", "(J)V", "roomName", "getRoomName", "()Ljava/lang/String;", "setRoomName", "(Ljava/lang/String;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-story_release"})
public final class l
  extends gt
{
  public static final a FwD;
  private static final m<Long, Long, Boolean> Fwd;
  private static final String TAG = "MicroMsg.StoryExtInfo";
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(119595);
    FwD = new a((byte)0);
    TAG = "MicroMsg.StoryExtInfo";
    info = gt.ajs();
    Fwd = (m)l.b.FwE;
    AppMethodBeat.o(119595);
  }
  
  public l()
  {
    AppMethodBeat.i(119594);
    p.h("", "value");
    this.field_roomname = "";
    AppMethodBeat.o(119594);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119593);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "StoryRoomInfo.info");
    AppMethodBeat.o(119593);
    return localMAutoDBInfo;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "compareUnsignedLong", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "i", "j", "", "getCompareUnsignedLong", "()Lkotlin/jvm/functions/Function2;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.l
 * JD-Core Version:    0.7.0.1
 */