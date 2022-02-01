package com.tencent.mm.plugin.story.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ff;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByDate", "", "date", "", "getStoryHistoryByDate", "isDateExist", "onNotifyChange", "", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "replaceHistoryInfoByDate", "storyHistoryInfo", "set", "info", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends MAutoStorage<h>
  implements MStorage.IOnStorageChange
{
  private static final String[] SQL_CREATE;
  private static final String Stb;
  public static final i.a Std;
  private static final String TAG;
  public static final String ptT;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119529);
    Std = new i.a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfoStorage";
    ptT = "MMStoryHistoryItem";
    h.a locala = h.Stc;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(h.access$getInfo$cp(), ptT) };
    Stb = "select * from " + ptT + ' ';
    AppMethodBeat.o(119529);
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, h.access$getInfo$cp(), ptT, ff.INDEX_CREATE);
    AppMethodBeat.i(119528);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(119528);
  }
  
  private boolean b(h paramh)
  {
    AppMethodBeat.i(119527);
    s.u(paramh, "info");
    boolean bool = super.replace((IAutoDBItem)paramh);
    AppMethodBeat.o(119527);
    return bool;
  }
  
  private boolean bcn(String paramString)
  {
    AppMethodBeat.i(119525);
    s.u(paramString, "date");
    paramString = Stb + " WHERE " + ptT + ".date = '" + paramString + '\'';
    paramString = this.db.rawQuery(paramString, null);
    int i = paramString.getCount();
    paramString.close();
    if (i > 0)
    {
      AppMethodBeat.o(119525);
      return true;
    }
    AppMethodBeat.o(119525);
    return false;
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(119524);
    s.u(paramh, "storyHistoryInfo");
    if (bcn(paramh.hzq()))
    {
      bool = update((IAutoDBItem)paramh, new String[] { "date" });
      AppMethodBeat.o(119524);
      return bool;
    }
    boolean bool = b(paramh);
    AppMethodBeat.o(119524);
    return bool;
  }
  
  public final h bco(String paramString)
  {
    AppMethodBeat.i(119526);
    s.u(paramString, "date");
    paramString = Stb + " WHERE " + ptT + ".date = '" + paramString + '\'';
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToFirst())
    {
      h localh = new h();
      localh.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(119526);
      return localh;
    }
    paramString.close();
    AppMethodBeat.o(119526);
    return null;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.i
 * JD-Core Version:    0.7.0.1
 */