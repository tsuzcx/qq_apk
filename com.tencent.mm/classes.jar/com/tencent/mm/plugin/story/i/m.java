package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "droptable", "", "dumpinfo", "", "get", "roomName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "set", "", "info", "Companion", "plugin-story_release"})
public final class m
  extends MAutoStorage<l>
  implements MStorage.IOnStorageChange
{
  public static final a FwF;
  private static final String Fwl = "select * from StoryRoomInfo";
  private static final String[] SQL_CREATE;
  private static final String TABLE = "StoryRoomInfo";
  private static final String TAG = "MicroMsg.StoryRoomInfoStorage";
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119599);
    FwF = new a((byte)0);
    TAG = "MicroMsg.StoryRoomInfoStorage";
    TABLE = "StoryRoomInfo";
    l.a locala = l.FwD;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(l.access$getInfo$cp(), TABLE) };
    Fwl = "select * from " + TABLE;
    AppMethodBeat.o(119599);
  }
  
  public m(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, l.access$getInfo$cp(), TABLE, gt.INDEX_CREATE);
    AppMethodBeat.i(119598);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(119598);
  }
  
  public final l aSB(String paramString)
  {
    AppMethodBeat.i(119596);
    p.h(paramString, "roomName");
    l locall = new l();
    locall.field_roomname = paramString;
    super.get((IAutoDBItem)locall, new String[0]);
    AppMethodBeat.o(119596);
    return locall;
  }
  
  public final void eIQ()
  {
    AppMethodBeat.i(119597);
    int i = this.db.delete(TABLE, null, null);
    Log.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119597);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData) {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.m
 * JD-Core Version:    0.7.0.1
 */