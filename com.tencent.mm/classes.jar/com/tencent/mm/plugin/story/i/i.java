package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.em;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByDate", "", "date", "", "getStoryHistoryByDate", "isDateExist", "onNotifyChange", "", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "replaceHistoryInfoByDate", "storyHistoryInfo", "set", "info", "Companion", "plugin-story_release"})
public final class i
  extends MAutoStorage<h>
  implements MStorage.IOnStorageChange
{
  private static final String Fwl = "select * from MMStoryHistoryItem ";
  public static final a Fwo;
  private static final String[] SQL_CREATE;
  public static final String TABLE = "MMStoryHistoryItem";
  private static final String TAG = "MicroMsg.StoryHistoryInfoStorage";
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119529);
    Fwo = new a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfoStorage";
    TABLE = "MMStoryHistoryItem";
    h.a locala = h.Fwn;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(h.access$getInfo$cp(), TABLE) };
    Fwl = "select * from " + TABLE + ' ';
    AppMethodBeat.o(119529);
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, h.access$getInfo$cp(), TABLE, em.INDEX_CREATE);
    AppMethodBeat.i(119528);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(119528);
  }
  
  private boolean aSx(String paramString)
  {
    AppMethodBeat.i(119525);
    p.h(paramString, "date");
    paramString = Fwl + " WHERE " + TABLE + ".date = '" + paramString + '\'';
    paramString = this.db.rawQuery(paramString, null);
    p.g(paramString, "cu");
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
  
  private boolean b(h paramh)
  {
    AppMethodBeat.i(119527);
    p.h(paramh, "info");
    boolean bool = super.replace((IAutoDBItem)paramh);
    AppMethodBeat.o(119527);
    return bool;
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(119524);
    p.h(paramh, "storyHistoryInfo");
    if (aSx(paramh.frD()))
    {
      bool = update((IAutoDBItem)paramh, new String[] { "date" });
      AppMethodBeat.o(119524);
      return bool;
    }
    boolean bool = b(paramh);
    AppMethodBeat.o(119524);
    return bool;
  }
  
  public final h aSy(String paramString)
  {
    AppMethodBeat.i(119526);
    p.h(paramString, "date");
    paramString = Fwl + " WHERE " + TABLE + ".date = '" + paramString + '\'';
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.i
 * JD-Core Version:    0.7.0.1
 */