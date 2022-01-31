package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ex;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "droptable", "", "dumpinfo", "", "get", "roomName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "set", "", "info", "Companion", "plugin-story_release"})
public final class m
  extends com.tencent.mm.sdk.e.j<l>
  implements k.a
{
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryRoomInfoStorage";
  private static final String sGE = "StoryRoomInfo";
  private static final String sGG = "select * from StoryRoomInfo";
  public static final m.a sHb;
  private final e db;
  
  static
  {
    AppMethodBeat.i(109974);
    sHb = new m.a((byte)0);
    TAG = "MicroMsg.StoryRoomInfoStorage";
    sGE = "StoryRoomInfo";
    l.a locala = l.sGZ;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(l.cEM(), sGE) };
    sGG = "select * from " + sGE;
    AppMethodBeat.o(109974);
  }
  
  public m(e parame)
  {
    super(parame, l.cEM(), sGE, ex.INDEX_CREATE);
    AppMethodBeat.i(109973);
    this.db = parame;
    AppMethodBeat.o(109973);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm) {}
  
  public final l adH(String paramString)
  {
    AppMethodBeat.i(109971);
    a.f.b.j.q(paramString, "roomName");
    l locall = new l();
    locall.field_roomname = paramString;
    super.get((c)locall, new String[0]);
    AppMethodBeat.o(109971);
    return locall;
  }
  
  public final void csu()
  {
    AppMethodBeat.i(109972);
    int i = this.db.delete(sGE, null, null);
    ab.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(109972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.m
 * JD-Core Version:    0.7.0.1
 */