package com.tencent.mm.plugin.story.h;

import a.v;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ew;
import com.tencent.mm.plugin.story.model.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "db", "extLruMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "notifyListener", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "userUpdateMap", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "addStoryStatusNotifyListener", "", "listener", "droptable", "dumpinfo", "get", "userName", "getAllData", "", "getAllUserStatus", "getFavoriteMd5", "getFromCache", "username", "getFromDb", "getMd5", "getStoryStatus", "insertFavMd5", "", "md5", "insertMd5", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "removeStoryStatusNotifyListener", "replace", "", "item", "set", "info", "startNotifyListener", "stopNotifyListener", "updateByLocal", "id", "", "extinfo", "updateCache", "updatePreCache", "updateReadIdWithNotify", "updateStoryUserInfo", "storyUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "updateSyncIdWithNotify", "syncId", "createTime", "thumb", "videoUrl", "duration", "Companion", "plugin-story_release"})
public final class g
  extends com.tencent.mm.sdk.e.j<f>
  implements k.a
{
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryExtInfoStorage";
  private static final String sGE = "StoryExtItem";
  private static final String sGF = "select *, rowid from StoryExtItem ";
  private static final String sGG = "select * from StoryExtItem";
  public static final g.a sGH;
  private final e db;
  public final ArrayList<com.tencent.mm.plugin.story.api.l> sGA;
  private final com.tencent.mm.memory.a.c<String, f> sGB;
  private com.tencent.mm.memory.a.c<String, f> sGC;
  private final e sGD;
  
  static
  {
    AppMethodBeat.i(109900);
    sGH = new g.a((byte)0);
    TAG = "MicroMsg.StoryExtInfoStorage";
    sGE = "StoryExtItem";
    f.a locala = f.sGy;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(f.cEM(), sGE) };
    sGF = "select *, rowid from " + sGE + ' ';
    sGG = "select * from " + sGE;
    AppMethodBeat.o(109900);
  }
  
  public g(e parame)
  {
    super(parame, f.cEM(), sGE, ew.INDEX_CREATE);
    AppMethodBeat.i(109899);
    this.sGD = parame;
    this.sGA = new ArrayList();
    this.sGB = new com.tencent.mm.memory.a.c(1000);
    this.sGC = new com.tencent.mm.memory.a.c(1000);
    this.db = this.sGD;
    AppMethodBeat.o(109899);
  }
  
  private final void c(f paramf)
  {
    AppMethodBeat.i(109891);
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
      AppMethodBeat.o(109891);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().arr(paramf.getUserName()))
    {
      this.sGB.put(paramf.getUserName(), paramf);
      this.sGC.remove(paramf.getUserName());
      AppMethodBeat.o(109891);
      return;
    }
    this.sGB.remove(paramf.getUserName());
    this.sGC.put(paramf.getUserName(), paramf);
    AppMethodBeat.o(109891);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(109897);
    if ((paramString != null) && (paramm != null))
    {
      if ((a.f.b.j.e(paramString, "notify_story_read")) && ((paramm.obj instanceof f)))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(109897);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramm = ((Iterable)this.sGA).iterator();
        while (paramm.hasNext()) {
          ((com.tencent.mm.plugin.story.api.l)paramm.next()).bx(paramString, true);
        }
        paramString = b.sun;
        b.czZ();
        AppMethodBeat.o(109897);
        return;
      }
      if ((a.f.b.j.e(paramString, "notify_story_unread")) && ((paramm.obj instanceof f)))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(109897);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramm = ((Iterable)this.sGA).iterator();
        while (paramm.hasNext()) {
          ((com.tencent.mm.plugin.story.api.l)paramm.next()).bx(paramString, false);
        }
        paramString = b.sun;
        b.czZ();
        AppMethodBeat.o(109897);
        return;
      }
      if ((a.f.b.j.e(paramString, "notify_story_invalid")) && ((paramm.obj instanceof f)))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(109897);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramm = ((Iterable)this.sGA).iterator();
        while (paramm.hasNext()) {
          ((com.tencent.mm.plugin.story.api.l)paramm.next()).bx(paramString, true);
        }
        paramString = b.sun;
        b.czZ();
        AppMethodBeat.o(109897);
        return;
      }
      if ((a.f.b.j.e(paramString, "notify_story_valid")) && ((paramm.obj instanceof f)))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(109897);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramm = ((Iterable)this.sGA).iterator();
        while (paramm.hasNext()) {
          ((com.tencent.mm.plugin.story.api.l)paramm.next()).bx(paramString, true);
        }
        paramString = b.sun;
        b.czZ();
        AppMethodBeat.o(109897);
        return;
      }
      ab.d(TAG, "unknown event ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(109897);
  }
  
  public final boolean a(long paramLong, f paramf)
  {
    AppMethodBeat.i(109886);
    a.f.b.j.q(paramf, "extinfo");
    if (b(paramLong, paramf) >= 0) {
      doNotify("notify_story_preload", 3, paramf);
    }
    AppMethodBeat.o(109886);
    return true;
  }
  
  public final f acU(String paramString)
  {
    AppMethodBeat.i(109884);
    a.f.b.j.q(paramString, "userName");
    f localf = adB(paramString);
    if (localf != null)
    {
      AppMethodBeat.o(109884);
      return localf;
    }
    paramString = adz(paramString);
    AppMethodBeat.o(109884);
    return paramString;
  }
  
  public final String adA(String paramString)
  {
    AppMethodBeat.i(109887);
    a.f.b.j.q(paramString, "userName");
    paramString = adz(paramString).field_md5;
    AppMethodBeat.o(109887);
    return paramString;
  }
  
  public final f adB(String paramString)
  {
    AppMethodBeat.i(109894);
    a.f.b.j.q(paramString, "username");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(109894);
      return null;
    }
    f localf2 = (f)this.sGB.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf2 = (f)this.sGC.get(paramString);
      localf1 = localf2;
      if (localf2 == null)
      {
        localf1 = adz(paramString);
        c(localf1);
      }
    }
    AppMethodBeat.o(109894);
    return localf1;
  }
  
  public final f adC(String paramString)
  {
    AppMethodBeat.i(109895);
    a.f.b.j.q(paramString, "username");
    f localf2 = (f)this.sGC.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = adz(paramString);
      c(localf1);
    }
    AppMethodBeat.o(109895);
    return localf1;
  }
  
  public final f adz(String paramString)
  {
    AppMethodBeat.i(109883);
    f localf = new f();
    localf.field_userName = paramString;
    super.get((com.tencent.mm.sdk.e.c)localf, new String[] { getPrimaryKey() });
    AppMethodBeat.o(109883);
    return localf;
  }
  
  public final int b(long paramLong, f paramf)
  {
    AppMethodBeat.i(109896);
    a.f.b.j.q(paramf, "extinfo");
    ContentValues localContentValues = paramf.convertTo();
    localContentValues.remove("rowid");
    c(paramf);
    int i = this.db.update(sGE, localContentValues, "rowid=?", new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(109896);
    return i;
  }
  
  public final boolean b(f paramf)
  {
    AppMethodBeat.i(109885);
    a.f.b.j.q(paramf, "info");
    c(paramf);
    boolean bool = super.replace((com.tencent.mm.sdk.e.c)paramf);
    AppMethodBeat.o(109885);
    return bool;
  }
  
  public final List<f> cEJ()
  {
    AppMethodBeat.i(109893);
    Object localObject1 = new ArrayList();
    Object localObject2 = sGG;
    localObject2 = this.db.a((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      a.f.b.j.p(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(109893);
    return localObject1;
  }
  
  public final List<f> cEW()
  {
    AppMethodBeat.i(109892);
    Object localObject1 = new ArrayList();
    Object localObject2 = sGF;
    localObject2 = this.db.a((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      a.f.b.j.p(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(109892);
    return localObject1;
  }
  
  public final void csu()
  {
    AppMethodBeat.i(109898);
    int i = this.db.delete(sGE, null, null);
    ab.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(109898);
  }
  
  public final int gQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109888);
    a.f.b.j.q(paramString1, "userName");
    a.f.b.j.q(paramString2, "md5");
    paramString1 = adz(paramString1);
    paramString1.field_md5 = paramString2;
    super.replace((com.tencent.mm.sdk.e.c)paramString1);
    AppMethodBeat.o(109888);
    return 0;
  }
  
  public final int gR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109889);
    a.f.b.j.q(paramString1, "userName");
    a.f.b.j.q(paramString2, "md5");
    paramString1 = adz(paramString1);
    paramString1.field_favoriteMd5 = paramString2;
    super.replace((com.tencent.mm.sdk.e.c)paramString1);
    AppMethodBeat.o(109889);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.g
 * JD-Core Version:    0.7.0.1
 */