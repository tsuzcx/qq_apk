package com.tencent.mm.plugin.story.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.d;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_POST", "", "CON_SERVER", "CON_TYPE_ERROR", "db", "delList", "", "kotlin.jvm.PlatformType", "", "itemFlagSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "localFlagSet", "sourceTypeSet", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setVdb", "addDelList", "", "localId", "addReadCount", "storyId", "", "count", "conTimestampAfter", "limitTime", "conTimestampBefore", "conUserWhere", "userName", "isSelf", "", "deleteByLocalId", "deleteByStoryId", "deleteByStoryIdWithNotify", "username", "deleteByUsername", "droptable", "dumpinfo", "get", "getAlbumStoryAfterByStoryId", "minId", "limitCount", "getByLocalId", "getByStoryId", "getByUserName", "getByUserNameAfter", "timeStamp", "excludePrivacy", "getDiedStory", "getFavHistoryMinIdByLimit", "maxId", "getFavStoryByUsername", "getForSnsByUserNameAfter", "getHistoryMinIdByLimit", "getInfoBetweenDate", "createTime", "getLastStoryByName", "getLastUpload", "getMinIdByLimit", "baseSql", "conServer", "getStoryAfterByStoryId", "getStoryById", "id", "getStoryReadCount", "getUserMinIdByLimit", "getUserSql", "getBuf", "checkCount", "inDelList", "isStoryIdExist", "removeDelList", "set", "storyInfo", "update", "updateByLocal", "storyinfo", "updateSourceTypeBefore", "sourceType", "updateStoryFavorite", "favorite", "updateStoryLocalFlag", "localFlag", "updateStoryVisibility", "visibilitySelf", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends MAutoStorage<j>
{
  private static final String[] INDEX_CREATE;
  private static String QYW;
  private static String QZe;
  private static String QZf;
  private static final String[] SQL_CREATE;
  public static final k.a Sth;
  private static final String Stl;
  private static String Stm;
  private static final String Stn;
  private static String Sto;
  private static String Stp;
  private static String Stq;
  public static final String TAG;
  public static final String ptT;
  private final ArrayList<Integer> FKI;
  private String QZb;
  private String QZd;
  private final ArrayList<Integer> QZm;
  private ISQLiteDatabase SsW;
  private final String Sti;
  private final ArrayList<Integer> Stj;
  private final List<String> Stk;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119590);
    Sth = new k.a((byte)0);
    TAG = "MicroMsg.StoryInfoStorage";
    Stl = "select count(*) from MMStoryInfo ";
    ptT = "MMStoryInfo";
    QYW = " order by " + ptT + ".createTime desc";
    Stm = " order by " + ptT + ".favoriteTime asc";
    Stn = " (storyID != 0  ) ";
    Object localObject1 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject2 = j.Ste;
    localObject1 = j.eZU() + " ON " + ptT + " ( storyID )";
    localObject2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject3 = j.Ste;
    localObject2 = j.hzA() + " ON " + ptT + " (userName,storyID, createTime)";
    localObject3 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    j.a locala = j.Ste;
    INDEX_CREATE = new String[] { localObject1, localObject2, j.hzB() + " ON " + ptT + " (userName, createTime)" };
    localObject1 = j.Ste;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.access$getInfo$cp(), ptT) };
    AppMethodBeat.o(119590);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.access$getInfo$cp(), ptT, INDEX_CREATE);
    AppMethodBeat.i(119589);
    this.SsW = paramISQLiteDatabase;
    this.Sti = " (storyID != 0 ) ";
    paramISQLiteDatabase = a.d.Ssx;
    int i = a.d.hza();
    paramISQLiteDatabase = a.d.Ssx;
    int j = a.d.hzb();
    paramISQLiteDatabase = a.d.Ssx;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.d.hzc()) });
    s.s(paramISQLiteDatabase, "asList(ConstantsStory.St…lag.LOCAL_FLAG_STATE_MIX)");
    this.FKI = k.a.hA(paramISQLiteDatabase);
    paramISQLiteDatabase = a.Sry;
    i = a.hyu();
    paramISQLiteDatabase = a.Sry;
    j = a.hyv();
    paramISQLiteDatabase = a.Sry;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.hyw()) });
    s.s(paramISQLiteDatabase, "asList(ConstantsStory.ST…ORY_SOURCE_ALBUM_HISTORY)");
    this.QZm = k.a.hA(paramISQLiteDatabase);
    paramISQLiteDatabase = a.Sry;
    i = a.hyT();
    paramISQLiteDatabase = a.Sry;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(a.hyU()) });
    s.s(paramISQLiteDatabase, "asList(ConstantsStory.ST…STORY_ITEM_FAVORITE_FLAG)");
    this.Stj = k.a.hA(paramISQLiteDatabase);
    this.db = this.SsW;
    this.Stk = Collections.synchronizedList((List)new ArrayList());
    paramISQLiteDatabase = new ArrayList();
    localObject1 = this.FKI.iterator();
    Integer localInteger;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.Ssx;
      if ((i & a.d.hza()) != 0)
      {
        i = localInteger.intValue();
        localObject2 = a.d.Ssx;
        if ((i & a.d.hzb()) == 0) {
          paramISQLiteDatabase.add(localInteger);
        }
      }
    }
    this.QZb = k.a.t((List)paramISQLiteDatabase, "localFlag");
    paramISQLiteDatabase.clear();
    localObject1 = this.QZm.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.Sry;
      if ((i & a.hyu()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    QZe = k.a.t((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.QZm.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.Sry;
      if ((i & a.hyv()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    QZf = k.a.t((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.FKI.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.Ssx;
      if ((i & a.d.hzb()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    this.QZd = k.a.t((List)paramISQLiteDatabase, "localFlag");
    paramISQLiteDatabase.clear();
    localObject1 = this.QZm.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.Sry;
      if ((i & a.hyw()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    Stp = k.a.t((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.Stj.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.Sry;
      if ((i & a.hyT()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    Sto = k.a.b((List)paramISQLiteDatabase, "itemStoryFlag", true);
    paramISQLiteDatabase.clear();
    localObject1 = this.Stj.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.Sry;
      if ((i & a.hyU()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    Stq = k.a.t((List)paramISQLiteDatabase, "itemStoryFlag");
    AppMethodBeat.o(119589);
  }
  
  private static String anw(int paramInt)
  {
    AppMethodBeat.i(119566);
    String str = ptT + ".createTime>" + paramInt;
    AppMethodBeat.o(119566);
    return str;
  }
  
  private static String dd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119565);
    if (paramBoolean)
    {
      paramString = s.X(" WHERE ", QZe);
      AppMethodBeat.o(119565);
      return paramString;
    }
    paramString = " WHERE " + ptT + ".userName='" + Util.escapeSqlValue(paramString) + "' AND " + QZf;
    AppMethodBeat.o(119565);
    return paramString;
  }
  
  private static String dp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119567);
    paramString = s.X("select *,rowid from MMStoryInfo ", dd(paramString, paramBoolean));
    AppMethodBeat.o(119567);
    return paramString;
  }
  
  private long s(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119556);
    s.u(paramString, "baseSql");
    Object localObject = paramString;
    if (paramLong != 0L) {
      localObject = paramString + " AND " + ptT + ".storyID < '" + paramLong + '\'';
    }
    paramString = (String)localObject + QYW + " limit " + paramInt;
    Log.d(TAG, s.X("getMinIdByLimit sql=", paramString));
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToLast())
    {
      localObject = new j();
      s.s(paramString, "cu");
      ((j)localObject).convertFrom(paramString);
      paramString.close();
      paramLong = ((j)localObject).field_storyID;
      AppMethodBeat.o(119556);
      return paramLong;
    }
    paramString.close();
    AppMethodBeat.o(119556);
    return 0L;
  }
  
  private j wb(long paramLong)
  {
    AppMethodBeat.i(119564);
    if (paramLong >= 0L)
    {
      localj = anv((int)paramLong);
      AppMethodBeat.o(119564);
      return localj;
    }
    j localj = wd(paramLong);
    AppMethodBeat.o(119564);
    return localj;
  }
  
  public final int a(int paramInt, j paramj)
  {
    AppMethodBeat.i(119562);
    s.u(paramj, "storyinfo");
    Object localObject = StoryCore.SjP;
    if (StoryCore.b.hvR().bcq(paramInt + '_' + paramj.field_createTime))
    {
      AppMethodBeat.o(119562);
      return -1;
    }
    paramj = paramj.convertTo();
    paramj.remove("rowid");
    localObject = this.db;
    String str = ptT;
    j.a locala = j.Ste;
    paramInt = ((ISQLiteDatabase)localObject).update(str, paramj, s.X(j.hzz(), "=?"), new String[] { s.X("", Integer.valueOf(paramInt)) });
    AppMethodBeat.o(119562);
    return paramInt;
  }
  
  public final long a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119582);
    s.u(paramString, "username");
    paramLong = s("select *,rowid from MMStoryInfo  " + dd(paramString, paramBoolean) + " AND " + Stq, paramLong, paramInt);
    AppMethodBeat.o(119582);
    return paramLong;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(119572);
    s.u(paramString, "userName");
    Object localObject1 = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + dd(paramString, paramBoolean1) + ' ';
    Object localObject2 = paramString + " AND " + anw(paramInt);
    if (paramBoolean1) {}
    for (paramString = QYW;; paramString = " AND " + Stn + " AND " + Sto + ' ' + QYW)
    {
      paramString = s.X((String)localObject2, paramString);
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString == null) {
        break label197;
      }
      while (paramString.moveToNext())
      {
        localObject2 = new j();
        ((j)localObject2).convertFrom(paramString);
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramString.close();
    label197:
    if (paramBoolean1)
    {
      paramString = d.Sjy;
      d.anb(((ArrayList)localObject1).size());
    }
    if (paramBoolean2)
    {
      localObject1 = (Iterable)localObject1;
      paramString = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label296:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!((j)localObject2).hzw()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label296;
          }
          paramString.add(localObject2);
          break;
        }
      }
      paramString = (List)paramString;
      AppMethodBeat.o(119572);
      return paramString;
    }
    paramString = (List)localObject1;
    AppMethodBeat.o(119572);
    return paramString;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119587);
    s.u(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      Object localObject = "select *,rowid from MMStoryInfo  " + dd(paramString, paramBoolean) + " AND " + Stq + ' ';
      paramString = (String)localObject;
      if (paramLong < 0L) {
        paramString = (String)localObject + " AND storyID >= " + paramLong;
      }
      localObject = s.X(paramString, QYW);
      paramString = (String)localObject;
      if (paramInt > 0) {
        paramString = (String)localObject + " limit " + paramInt;
      }
      Log.d(TAG, s.X("getFavStoryByUsername sql:", paramString));
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString != null)
      {
        for (;;)
        {
          if (paramString.moveToNext())
          {
            localObject = new j();
            ((j)localObject).convertFrom(paramString);
            localArrayList.add(localObject);
            continue;
            i = 0;
            break;
          }
        }
        paramString.close();
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(119587);
    return paramString;
  }
  
  public final long aC(long paramLong, int paramInt)
  {
    AppMethodBeat.i(119581);
    paramLong = s(s.X("select *,rowid from MMStoryInfo  WHERE ", Stp), paramLong, paramInt);
    AppMethodBeat.o(119581);
    return paramLong;
  }
  
  public final boolean aj(long paramLong, String paramString)
  {
    AppMethodBeat.i(119577);
    s.u(paramString, "username");
    boolean bool = wc(paramLong);
    j localj = new j();
    localj.field_userName = paramString;
    localj.field_storyID = paramLong;
    doNotify("notify_story_info_delete", 1, localj);
    AppMethodBeat.o(119577);
    return bool;
  }
  
  public final boolean alC(int paramInt)
  {
    AppMethodBeat.i(119575);
    ISQLiteDatabase localISQLiteDatabase = this.db;
    String str = ptT;
    j.a locala = j.Ste;
    if (localISQLiteDatabase.delete(str, s.X(j.hzz(), "=?"), new String[] { s.X("", Integer.valueOf(paramInt)) }) > 0)
    {
      AppMethodBeat.o(119575);
      return true;
    }
    AppMethodBeat.o(119575);
    return false;
  }
  
  public final j anv(int paramInt)
  {
    AppMethodBeat.i(119563);
    j localj = new j();
    Object localObject = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(ptT).append('.');
    j.a locala = j.Ste;
    localObject = j.hzz() + '=' + paramInt;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      s.s(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119563);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119563);
    return null;
  }
  
  public final long b(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119568);
    s.u(paramString, "username");
    paramLong = s(dp(paramString, paramBoolean), paramLong, paramInt);
    AppMethodBeat.o(119568);
    return paramLong;
  }
  
  public final void bcp(String paramString)
  {
    AppMethodBeat.i(119554);
    s.u(paramString, "localId");
    this.Stk.add(paramString);
    AppMethodBeat.o(119554);
  }
  
  public final boolean bcq(String paramString)
  {
    AppMethodBeat.i(119555);
    s.u(paramString, "localId");
    ??? = this.Stk;
    s.s(???, "delList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      boolean bool = false;
      while (localIterator.hasNext()) {
        if (s.p((String)localIterator.next(), paramString))
        {
          Log.i(TAG, s.X("wo wo wo ", paramString));
          bool = true;
        }
      }
      paramString = ah.aiuX;
      AppMethodBeat.o(119555);
      return bool;
    }
  }
  
  public final List<j> dq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119569);
    s.u(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    Object localObject = s.X("select *,rowid from MMStoryInfo ", dd(paramString, paramBoolean));
    if (paramBoolean) {}
    for (paramString = QYW;; paramString = " AND " + Stn + QYW)
    {
      paramString = s.X((String)localObject, paramString);
      paramString = this.db.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        localObject = new j();
        s.s(paramString, "cu");
        ((j)localObject).convertFrom(paramString);
        localArrayList.add(localObject);
      }
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(119569);
    return paramString;
  }
  
  public final j dr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119583);
    s.u(paramString, "userName");
    j localj = new j();
    String str = s.X("select *,rowid from MMStoryInfo ", dd(paramString, paramBoolean));
    if (paramBoolean) {}
    for (paramString = QYW;; paramString = " AND " + Stn + QYW)
    {
      paramString = s.X(s.X(str, paramString), " limit 1");
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString.moveToFirst())
      {
        s.s(paramString, "cu");
        localj.convertFrom(paramString);
      }
      paramString.close();
      AppMethodBeat.o(119583);
      return localj;
    }
  }
  
  public final ArrayList<j> ds(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119586);
    s.u(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = "select *,rowid from MMStoryInfo  " + dd(paramString, paramBoolean) + " AND " + Stq + ' ' + QYW;
      Log.d(TAG, s.X("getFavStoryByUsername sql:", paramString));
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString != null)
      {
        for (;;)
        {
          if (paramString.moveToNext())
          {
            j localj = new j();
            localj.convertFrom(paramString);
            localArrayList.add(localj);
            continue;
            i = 0;
            break;
          }
        }
        paramString.close();
      }
    }
    AppMethodBeat.o(119586);
    return localArrayList;
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(119557);
    s.u(paramj, "storyInfo");
    boolean bool = replace((IAutoDBItem)paramj);
    AppMethodBeat.o(119557);
    return bool;
  }
  
  public final int f(j paramj)
  {
    AppMethodBeat.i(119559);
    s.u(paramj, "storyInfo");
    Log.d(TAG, "storyInfo Insert");
    paramj = paramj.convertTo();
    int i = (int)this.db.insert(ptT, "", paramj);
    Log.d(TAG, s.X("StoryInfo Insert result ", Integer.valueOf(i)));
    AppMethodBeat.o(119559);
    return i;
  }
  
  public final void gGK()
  {
    AppMethodBeat.i(119579);
    int i = this.db.delete(ptT, null, null);
    Log.i(TAG, s.X("dropTable ", Integer.valueOf(i)));
    AppMethodBeat.o(119579);
  }
  
  public final List<j> hl(String paramString, int paramInt)
  {
    AppMethodBeat.i(119580);
    s.u(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = s.X("select *,rowid from MMStoryInfo ", dd(paramString, true));
    paramString = s.X(paramString + " AND createTime BETWEEN " + paramInt + " AND " + (86400 + paramInt - 1), QYW);
    paramString = this.db.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      j localj = new j();
      s.s(paramString, "cu");
      localj.convertFrom(paramString);
      localArrayList.add(localj);
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(119580);
    return paramString;
  }
  
  public final j hzC()
  {
    AppMethodBeat.i(119561);
    int i = cn.getSyncServerTimeSecond();
    Object localObject1 = i.SjL;
    int j = i.hvz();
    localObject1 = new j();
    Object localObject2 = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.QZb).append(" and createTime > ").append(i - j).append(" order by ").append(ptT).append('.');
    Object localObject3 = j.Ste;
    localObject2 = j.hzz() + " asc limit 1";
    localObject3 = this.db.rawQuery((String)localObject2, null, 2);
    Log.d(TAG, s.X("getLastUpload ", localObject2));
    if (!((Cursor)localObject3).moveToFirst())
    {
      ((Cursor)localObject3).close();
      AppMethodBeat.o(119561);
      return null;
    }
    s.s(localObject3, "cr");
    ((j)localObject1).convertFrom((Cursor)localObject3);
    ((Cursor)localObject3).close();
    AppMethodBeat.o(119561);
    return localObject1;
  }
  
  public final List<j> l(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119574);
    s.u(paramString, "userName");
    Object localObject1 = (Iterable)a(this, paramString, paramBoolean, paramInt);
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label99:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((j)localObject2).hzt().abKb == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label99;
        }
        paramString.add(localObject2);
        break;
      }
    }
    paramString = (List)paramString;
    AppMethodBeat.o(119574);
    return paramString;
  }
  
  public final j wa(long paramLong)
  {
    AppMethodBeat.i(119560);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  where " + ptT + ".storyID=" + paramLong + " limit 1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      s.s(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119560);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119560);
    return null;
  }
  
  public final boolean wc(long paramLong)
  {
    AppMethodBeat.i(119576);
    if (this.db.delete(ptT, "storyID=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0)
    {
      AppMethodBeat.o(119576);
      return true;
    }
    AppMethodBeat.o(119576);
    return false;
  }
  
  public final j wd(long paramLong)
  {
    AppMethodBeat.i(119578);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  WHERE " + ptT + ".storyID=" + paramLong;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      s.s(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119578);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119578);
    return null;
  }
  
  public final int we(long paramLong)
  {
    AppMethodBeat.i(119584);
    j localj = wb(paramLong);
    if (localj == null)
    {
      AppMethodBeat.o(119584);
      return 0;
    }
    int i = localj.field_readCount;
    AppMethodBeat.o(119584);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.k
 * JD-Core Version:    0.7.0.1
 */