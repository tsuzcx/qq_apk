package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gs;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "db", "extLruMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "notifyListener", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "userUpdateMap", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "addStoryStatusNotifyListener", "", "listener", "droptable", "dumpinfo", "get", "userName", "getAllData", "", "getAllUserStatus", "getFavoriteMd5", "getFromCache", "username", "getFromDb", "getMd5", "getStoryStatus", "insertFavMd5", "", "md5", "insertMd5", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "removeStoryStatusNotifyListener", "replace", "", "item", "set", "info", "startNotifyListener", "stopNotifyListener", "updateByLocal", "id", "", "extinfo", "updateCache", "updatePreCache", "updateReadIdWithNotify", "storyId", "updateStoryUserInfo", "storyUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "updateSyncIdWithNotify", "syncId", "createTime", "thumb", "videoUrl", "duration", "Companion", "plugin-story_release"})
public final class g
  extends MAutoStorage<f>
  implements MStorage.IOnStorageChange
{
  private static final String Fwk = "select *, rowid from StoryExtItem ";
  private static final String Fwl = "select * from StoryExtItem";
  public static final a Fwm;
  private static final String[] SQL_CREATE;
  private static final String TABLE = "StoryExtItem";
  private static final String TAG = "MicroMsg.StoryExtInfoStorage";
  public final ArrayList<m> Fwg;
  private final c<String, f> Fwh;
  private c<String, f> Fwi;
  private final ISQLiteDatabase Fwj;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119518);
    Fwm = new a((byte)0);
    TAG = "MicroMsg.StoryExtInfoStorage";
    TABLE = "StoryExtItem";
    f.a locala = f.Fwe;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.access$getInfo$cp(), TABLE) };
    Fwk = "select *, rowid from " + TABLE + ' ';
    Fwl = "select * from " + TABLE;
    AppMethodBeat.o(119518);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.access$getInfo$cp(), TABLE, gs.INDEX_CREATE);
    AppMethodBeat.i(119517);
    this.Fwj = paramISQLiteDatabase;
    this.Fwg = new ArrayList();
    this.Fwh = new c(1000);
    this.Fwi = new c(1000);
    this.db = this.Fwj;
    AppMethodBeat.o(119517);
  }
  
  private final void c(f paramf)
  {
    AppMethodBeat.i(119509);
    if (paramf != null)
    {
      localObject = (CharSequence)paramf.getUserName();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label42;
      }
    }
    label42:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119509);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().bjG(paramf.getUserName()))
    {
      this.Fwh.put(paramf.getUserName(), paramf);
      this.Fwi.remove(paramf.getUserName());
      AppMethodBeat.o(119509);
      return;
    }
    this.Fwh.remove(paramf.getUserName());
    this.Fwi.put(paramf.getUserName(), paramf);
    AppMethodBeat.o(119509);
  }
  
  public final boolean a(long paramLong, f paramf)
  {
    AppMethodBeat.i(119504);
    p.h(paramf, "extinfo");
    if (b(paramLong, paramf) >= 0) {
      doNotify("notify_story_preload", 3, paramf);
    }
    AppMethodBeat.o(119504);
    return true;
  }
  
  public final f aRS(String paramString)
  {
    AppMethodBeat.i(119502);
    p.h(paramString, "userName");
    f localf = aSv(paramString);
    if (localf != null)
    {
      AppMethodBeat.o(119502);
      return localf;
    }
    paramString = aSt(paramString);
    AppMethodBeat.o(119502);
    return paramString;
  }
  
  public final f aSt(String paramString)
  {
    AppMethodBeat.i(119501);
    f localf = new f();
    localf.field_userName = paramString;
    super.get((IAutoDBItem)localf, new String[] { getPrimaryKey() });
    AppMethodBeat.o(119501);
    return localf;
  }
  
  public final String aSu(String paramString)
  {
    AppMethodBeat.i(119505);
    p.h(paramString, "userName");
    paramString = aSt(paramString).field_md5;
    AppMethodBeat.o(119505);
    return paramString;
  }
  
  public final f aSv(String paramString)
  {
    AppMethodBeat.i(119512);
    p.h(paramString, "username");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119512);
      return null;
    }
    f localf2 = (f)this.Fwh.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf2 = (f)this.Fwi.get(paramString);
      localf1 = localf2;
      if (localf2 == null)
      {
        localf1 = aSt(paramString);
        c(localf1);
      }
    }
    AppMethodBeat.o(119512);
    return localf1;
  }
  
  public final f aSw(String paramString)
  {
    AppMethodBeat.i(119513);
    p.h(paramString, "username");
    f localf2 = (f)this.Fwi.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = aSt(paramString);
      c(localf1);
    }
    AppMethodBeat.o(119513);
    return localf1;
  }
  
  public final int b(long paramLong, f paramf)
  {
    AppMethodBeat.i(119514);
    p.h(paramf, "extinfo");
    ContentValues localContentValues = paramf.convertTo();
    localContentValues.remove("rowid");
    c(paramf);
    int i = this.db.update(TABLE, localContentValues, "rowid=?", new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(119514);
    return i;
  }
  
  public final boolean b(f paramf)
  {
    AppMethodBeat.i(119503);
    p.h(paramf, "info");
    c(paramf);
    boolean bool = super.replace((IAutoDBItem)paramf);
    AppMethodBeat.o(119503);
    return bool;
  }
  
  public final void eIQ()
  {
    AppMethodBeat.i(119516);
    int i = this.db.delete(TABLE, null, null);
    Log.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119516);
  }
  
  public final List<f> frC()
  {
    AppMethodBeat.i(119510);
    Object localObject1 = new ArrayList();
    Object localObject2 = Fwk;
    localObject2 = this.db.rawQuery((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      p.g(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119510);
    return localObject1;
  }
  
  public final List<f> frv()
  {
    AppMethodBeat.i(119511);
    Object localObject1 = new ArrayList();
    Object localObject2 = Fwl;
    localObject2 = this.db.rawQuery((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      p.g(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119511);
    return localObject1;
  }
  
  public final int kJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119506);
    p.h(paramString1, "userName");
    p.h(paramString2, "md5");
    paramString1 = aSt(paramString1);
    paramString1.field_md5 = paramString2;
    super.replace((IAutoDBItem)paramString1);
    AppMethodBeat.o(119506);
    return 0;
  }
  
  public final int lb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119507);
    p.h(paramString1, "userName");
    p.h(paramString2, "md5");
    paramString1 = aSt(paramString1);
    paramString1.field_favoriteMd5 = paramString2;
    super.replace((IAutoDBItem)paramString1);
    AppMethodBeat.o(119507);
    return 0;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119515);
    if ((paramString != null) && (paramMStorageEventData != null))
    {
      if ((p.j(paramString, "notify_story_read")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.Fwg).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).cr(paramString, true);
        }
        paramString = b.FlH;
        b.fnD();
        AppMethodBeat.o(119515);
        return;
      }
      if ((p.j(paramString, "notify_story_unread")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.Fwg).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).cr(paramString, false);
        }
        paramString = b.FlH;
        b.fnD();
        AppMethodBeat.o(119515);
        return;
      }
      if ((p.j(paramString, "notify_story_invalid")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.Fwg).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).cr(paramString, true);
        }
        paramString = b.FlH;
        b.fnD();
        AppMethodBeat.o(119515);
        return;
      }
      if ((p.j(paramString, "notify_story_valid")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.Fwg).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).cr(paramString, true);
        }
        paramString = b.FlH;
        b.fnD();
        AppMethodBeat.o(119515);
        return;
      }
      Log.d(TAG, "unknown event ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(119515);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage$Companion;", "", "()V", "EventNotifyStoryInvalid", "", "EventNotifyStoryPreLoad", "EventNotifyStoryRead", "EventNotifyStoryUnread", "EventNotifyStoryValid", "NotifyStoryInvalid", "", "NotifyStoryPreLoad", "NotifyStoryRead", "NotifyStoryUnread", "NotifyStoryValid", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "STORYEXT_SELECT_ALL_STATUS_BEGIN", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.g
 * JD-Core Version:    0.7.0.1
 */