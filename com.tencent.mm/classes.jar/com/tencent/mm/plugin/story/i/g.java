package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fw;
import com.tencent.mm.plugin.story.f.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "db", "extLruMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "notifyListener", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "userUpdateMap", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "addStoryStatusNotifyListener", "", "listener", "droptable", "dumpinfo", "get", "userName", "getAllData", "", "getAllUserStatus", "getFavoriteMd5", "getFromCache", "username", "getFromDb", "getMd5", "getStoryStatus", "insertFavMd5", "", "md5", "insertMd5", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "removeStoryStatusNotifyListener", "replace", "", "item", "set", "info", "startNotifyListener", "stopNotifyListener", "updateByLocal", "id", "", "extinfo", "updateCache", "updatePreCache", "updateReadIdWithNotify", "storyId", "updateStoryUserInfo", "storyUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "updateSyncIdWithNotify", "syncId", "createTime", "thumb", "videoUrl", "duration", "Companion", "plugin-story_release"})
public final class g
  extends j<f>
  implements k.a
{
  private static final String[] SQL_CREATE;
  private static final String TABLE = "StoryExtItem";
  private static final String TAG = "MicroMsg.StoryExtInfoStorage";
  private static final String zCx = "select *, rowid from StoryExtItem ";
  private static final String zCy = "select * from StoryExtItem";
  public static final g.a zCz;
  private final e db;
  public final ArrayList<com.tencent.mm.plugin.story.api.m> zCt;
  private final com.tencent.mm.memory.a.c<String, f> zCu;
  private com.tencent.mm.memory.a.c<String, f> zCv;
  private final e zCw;
  
  static
  {
    AppMethodBeat.i(119518);
    zCz = new g.a((byte)0);
    TAG = "MicroMsg.StoryExtInfoStorage";
    TABLE = "StoryExtItem";
    f.a locala = f.zCr;
    SQL_CREATE = new String[] { j.getCreateSQLs(f.access$getInfo$cp(), TABLE) };
    zCx = "select *, rowid from " + TABLE + ' ';
    zCy = "select * from " + TABLE;
    AppMethodBeat.o(119518);
  }
  
  public g(e parame)
  {
    super(parame, f.access$getInfo$cp(), TABLE, fw.INDEX_CREATE);
    AppMethodBeat.i(119517);
    this.zCw = parame;
    this.zCt = new ArrayList();
    this.zCu = new com.tencent.mm.memory.a.c(1000);
    this.zCv = new com.tencent.mm.memory.a.c(1000);
    this.db = this.zCw;
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
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNo(paramf.getUserName()))
    {
      this.zCu.put(paramf.getUserName(), paramf);
      this.zCv.remove(paramf.getUserName());
      AppMethodBeat.o(119509);
      return;
    }
    this.zCu.remove(paramf.getUserName());
    this.zCv.put(paramf.getUserName(), paramf);
    AppMethodBeat.o(119509);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(119515);
    if ((paramString != null) && (paramm != null))
    {
      if ((d.g.b.k.g(paramString, "notify_story_read")) && ((paramm.obj instanceof f)))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramm = ((Iterable)this.zCt).iterator();
        while (paramm.hasNext()) {
          ((com.tencent.mm.plugin.story.api.m)paramm.next()).bO(paramString, true);
        }
        paramString = b.zrq;
        b.dVf();
        AppMethodBeat.o(119515);
        return;
      }
      if ((d.g.b.k.g(paramString, "notify_story_unread")) && ((paramm.obj instanceof f)))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramm = ((Iterable)this.zCt).iterator();
        while (paramm.hasNext()) {
          ((com.tencent.mm.plugin.story.api.m)paramm.next()).bO(paramString, false);
        }
        paramString = b.zrq;
        b.dVf();
        AppMethodBeat.o(119515);
        return;
      }
      if ((d.g.b.k.g(paramString, "notify_story_invalid")) && ((paramm.obj instanceof f)))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramm = ((Iterable)this.zCt).iterator();
        while (paramm.hasNext()) {
          ((com.tencent.mm.plugin.story.api.m)paramm.next()).bO(paramString, true);
        }
        paramString = b.zrq;
        b.dVf();
        AppMethodBeat.o(119515);
        return;
      }
      if ((d.g.b.k.g(paramString, "notify_story_valid")) && ((paramm.obj instanceof f)))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramm = ((Iterable)this.zCt).iterator();
        while (paramm.hasNext()) {
          ((com.tencent.mm.plugin.story.api.m)paramm.next()).bO(paramString, true);
        }
        paramString = b.zrq;
        b.dVf();
        AppMethodBeat.o(119515);
        return;
      }
      ac.d(TAG, "unknown event ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(119515);
  }
  
  public final boolean a(long paramLong, f paramf)
  {
    AppMethodBeat.i(119504);
    d.g.b.k.h(paramf, "extinfo");
    if (b(paramLong, paramf) >= 0) {
      doNotify("notify_story_preload", 3, paramf);
    }
    AppMethodBeat.o(119504);
    return true;
  }
  
  public final f awy(String paramString)
  {
    AppMethodBeat.i(119502);
    d.g.b.k.h(paramString, "userName");
    f localf = axd(paramString);
    if (localf != null)
    {
      AppMethodBeat.o(119502);
      return localf;
    }
    paramString = axb(paramString);
    AppMethodBeat.o(119502);
    return paramString;
  }
  
  public final f axb(String paramString)
  {
    AppMethodBeat.i(119501);
    f localf = new f();
    localf.field_userName = paramString;
    super.get((com.tencent.mm.sdk.e.c)localf, new String[] { getPrimaryKey() });
    AppMethodBeat.o(119501);
    return localf;
  }
  
  public final String axc(String paramString)
  {
    AppMethodBeat.i(119505);
    d.g.b.k.h(paramString, "userName");
    paramString = axb(paramString).field_md5;
    AppMethodBeat.o(119505);
    return paramString;
  }
  
  public final f axd(String paramString)
  {
    AppMethodBeat.i(119512);
    d.g.b.k.h(paramString, "username");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119512);
      return null;
    }
    f localf2 = (f)this.zCu.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf2 = (f)this.zCv.get(paramString);
      localf1 = localf2;
      if (localf2 == null)
      {
        localf1 = axb(paramString);
        c(localf1);
      }
    }
    AppMethodBeat.o(119512);
    return localf1;
  }
  
  public final f axe(String paramString)
  {
    AppMethodBeat.i(119513);
    d.g.b.k.h(paramString, "username");
    f localf2 = (f)this.zCv.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = axb(paramString);
      c(localf1);
    }
    AppMethodBeat.o(119513);
    return localf1;
  }
  
  public final int b(long paramLong, f paramf)
  {
    AppMethodBeat.i(119514);
    d.g.b.k.h(paramf, "extinfo");
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
    d.g.b.k.h(paramf, "info");
    c(paramf);
    boolean bool = super.replace((com.tencent.mm.sdk.e.c)paramf);
    AppMethodBeat.o(119503);
    return bool;
  }
  
  public final List<f> dYX()
  {
    AppMethodBeat.i(119511);
    Object localObject1 = new ArrayList();
    Object localObject2 = zCy;
    localObject2 = this.db.a((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      d.g.b.k.g(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119511);
    return localObject1;
  }
  
  public final List<f> dZe()
  {
    AppMethodBeat.i(119510);
    Object localObject1 = new ArrayList();
    Object localObject2 = zCx;
    localObject2 = this.db.a((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      d.g.b.k.g(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119510);
    return localObject1;
  }
  
  public final void duq()
  {
    AppMethodBeat.i(119516);
    int i = this.db.delete(TABLE, null, null);
    ac.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119516);
  }
  
  public final int jR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119506);
    d.g.b.k.h(paramString1, "userName");
    d.g.b.k.h(paramString2, "md5");
    paramString1 = axb(paramString1);
    paramString1.field_md5 = paramString2;
    super.replace((com.tencent.mm.sdk.e.c)paramString1);
    AppMethodBeat.o(119506);
    return 0;
  }
  
  public final int jS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119507);
    d.g.b.k.h(paramString1, "userName");
    d.g.b.k.h(paramString2, "md5");
    paramString1 = axb(paramString1);
    paramString1.field_favoriteMd5 = paramString2;
    super.replace((com.tencent.mm.sdk.e.c)paramString1);
    AppMethodBeat.o(119507);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.g
 * JD-Core Version:    0.7.0.1
 */