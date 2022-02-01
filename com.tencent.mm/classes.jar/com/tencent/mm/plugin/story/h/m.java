package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "droptable", "", "dumpinfo", "", "get", "roomName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "set", "", "info", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends MAutoStorage<l>
  implements MStorage.IOnStorageChange
{
  private static final String[] SQL_CREATE;
  private static final String Stb;
  public static final m.a Stt;
  private static final String TAG;
  private static final String ptT;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119599);
    Stt = new m.a((byte)0);
    TAG = "MicroMsg.StoryRoomInfoStorage";
    ptT = "StoryRoomInfo";
    l.a locala = l.Str;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(l.access$getInfo$cp(), ptT) };
    Stb = s.X("select * from ", ptT);
    AppMethodBeat.o(119599);
  }
  
  public m(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, l.access$getInfo$cp(), ptT, hv.INDEX_CREATE);
    AppMethodBeat.i(119598);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(119598);
  }
  
  public final l bcr(String paramString)
  {
    AppMethodBeat.i(119596);
    s.u(paramString, "roomName");
    l locall = new l();
    locall.field_roomname = paramString;
    super.get((IAutoDBItem)locall, new String[0]);
    AppMethodBeat.o(119596);
    return locall;
  }
  
  public final void gGK()
  {
    AppMethodBeat.i(119597);
    int i = this.db.delete(ptT, null, null);
    Log.i(TAG, s.X("dropTable ", Integer.valueOf(i)));
    AppMethodBeat.o(119597);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.m
 * JD-Core Version:    0.7.0.1
 */