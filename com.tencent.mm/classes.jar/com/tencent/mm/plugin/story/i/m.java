package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "droptable", "", "dumpinfo", "", "get", "roomName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "set", "", "info", "Companion", "plugin-story_release"})
public final class m
  extends MAutoStorage<l>
  implements MStorage.IOnStorageChange
{
  private static final String Alf = "StoryRoomInfo";
  public static final a LQH;
  private static final String LQo = "select * from StoryRoomInfo";
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryRoomInfoStorage";
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119599);
    LQH = new a((byte)0);
    TAG = "MicroMsg.StoryRoomInfoStorage";
    Alf = "StoryRoomInfo";
    l.a locala = l.LQF;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(l.access$getInfo$cp(), Alf) };
    LQo = "select * from " + Alf;
    AppMethodBeat.o(119599);
  }
  
  public m(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, l.access$getInfo$cp(), Alf, ha.INDEX_CREATE);
    AppMethodBeat.i(119598);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(119598);
  }
  
  public final l bdF(String paramString)
  {
    AppMethodBeat.i(119596);
    p.k(paramString, "roomName");
    l locall = new l();
    locall.field_roomname = paramString;
    super.get((IAutoDBItem)locall, new String[0]);
    AppMethodBeat.o(119596);
    return locall;
  }
  
  public final void fuU()
  {
    AppMethodBeat.i(119597);
    int i = this.db.delete(Alf, null, null);
    Log.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119597);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.m
 * JD-Core Version:    0.7.0.1
 */