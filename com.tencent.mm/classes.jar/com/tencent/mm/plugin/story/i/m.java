package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "droptable", "", "dumpinfo", "", "get", "roomName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "set", "", "info", "Companion", "plugin-story_release"})
public final class m
  extends j<l>
  implements k.a
{
  private static final String[] SQL_CREATE;
  private static final String TABLE = "StoryRoomInfo";
  private static final String TAG = "MicroMsg.StoryRoomInfoStorage";
  public static final m.a zCS;
  private static final String zCy = "select * from StoryRoomInfo";
  private final e db;
  
  static
  {
    AppMethodBeat.i(119599);
    zCS = new m.a((byte)0);
    TAG = "MicroMsg.StoryRoomInfoStorage";
    TABLE = "StoryRoomInfo";
    l.a locala = l.zCQ;
    SQL_CREATE = new String[] { j.getCreateSQLs(l.access$getInfo$cp(), TABLE) };
    zCy = "select * from " + TABLE;
    AppMethodBeat.o(119599);
  }
  
  public m(e parame)
  {
    super(parame, l.access$getInfo$cp(), TABLE, fx.INDEX_CREATE);
    AppMethodBeat.i(119598);
    this.db = parame;
    AppMethodBeat.o(119598);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm) {}
  
  public final l axj(String paramString)
  {
    AppMethodBeat.i(119596);
    k.h(paramString, "roomName");
    l locall = new l();
    locall.field_roomname = paramString;
    super.get((c)locall, new String[0]);
    AppMethodBeat.o(119596);
    return locall;
  }
  
  public final void duq()
  {
    AppMethodBeat.i(119597);
    int i = this.db.delete(TABLE, null, null);
    ac.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.m
 * JD-Core Version:    0.7.0.1
 */