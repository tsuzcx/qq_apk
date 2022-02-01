package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.f.d;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_POST", "", "CON_SERVER", "CON_TYPE_ERROR", "db", "delList", "", "kotlin.jvm.PlatformType", "", "itemFlagSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "localFlagSet", "sourceTypeSet", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setVdb", "addDelList", "", "localId", "addReadCount", "storyId", "", "count", "conTimestampAfter", "limitTime", "conTimestampBefore", "conUserWhere", "userName", "isSelf", "", "deleteByLocalId", "deleteByStoryId", "deleteByStoryIdWithNotify", "username", "deleteByUsername", "droptable", "dumpinfo", "get", "getAlbumStoryAfterByStoryId", "minId", "limitCount", "getByLocalId", "getByStoryId", "getByUserName", "getByUserNameAfter", "timeStamp", "excludePrivacy", "getDiedStory", "getFavHistoryMinIdByLimit", "maxId", "getFavStoryByUsername", "getForSnsByUserNameAfter", "getHistoryMinIdByLimit", "getInfoBetweenDate", "createTime", "getLastStoryByName", "getLastUpload", "getMinIdByLimit", "baseSql", "conServer", "getStoryAfterByStoryId", "getStoryById", "id", "getStoryReadCount", "getUserMinIdByLimit", "getUserSql", "getBuf", "checkCount", "inDelList", "isStoryIdExist", "removeDelList", "set", "storyInfo", "update", "updateByLocal", "storyinfo", "updateSourceTypeBefore", "sourceType", "updateStoryFavorite", "favorite", "updateStoryLocalFlag", "localFlag", "updateStoryVisibility", "visibilitySelf", "Companion", "plugin-story_release"})
public final class k
  extends com.tencent.mm.sdk.e.j<j>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final String TABLE = "MMStoryInfo";
  public static final String TAG = "MicroMsg.StoryInfoStorage";
  private static String xiR;
  private static String xja;
  private static String xjc;
  private static final String ypk = "select count(*) from MMStoryInfo ";
  private static String ypl;
  private static final String ypm = " (storyID != 0  ) ";
  private static String ypn;
  private static String ypo;
  private static String ypp;
  public static final k.a ypq;
  public final e db;
  private final ArrayList<Integer> qJN;
  private String xiW;
  private String xiX;
  private final ArrayList<Integer> xjg;
  private e yoX;
  private final String yph;
  private final ArrayList<Integer> ypi;
  private final List<String> ypj;
  
  static
  {
    AppMethodBeat.i(119590);
    ypq = new k.a((byte)0);
    TAG = "MicroMsg.StoryInfoStorage";
    ypk = "select count(*) from MMStoryInfo ";
    TABLE = "MMStoryInfo";
    xiR = " order by " + TABLE + ".createTime desc";
    ypl = " order by " + TABLE + ".favoriteTime asc";
    ypm = " (storyID != 0  ) ";
    Object localObject1 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject2 = j.ypg;
    localObject1 = j.cqD() + " ON " + TABLE + " ( storyID )";
    localObject2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject3 = j.ypg;
    localObject2 = j.dKO() + " ON " + TABLE + " (userName,storyID, createTime)";
    localObject3 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    j.a locala = j.ypg;
    INDEX_CREATE = new String[] { localObject1, localObject2, j.dKP() + " ON " + TABLE + " (userName, createTime)" };
    localObject1 = j.ypg;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(j.access$getInfo$cp(), TABLE) };
    AppMethodBeat.o(119590);
  }
  
  public k(e parame)
  {
    super(parame, j.access$getInfo$cp(), TABLE, INDEX_CREATE);
    AppMethodBeat.i(119589);
    this.yoX = parame;
    this.yph = " (storyID != 0 ) ";
    parame = a.d.yoA;
    int i = a.d.dKn();
    parame = a.d.yoA;
    int j = a.d.dKo();
    parame = a.d.yoA;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.d.dKp()) });
    d.g.b.k.g(parame, "Arrays.asList(ConstantsS…lag.LOCAL_FLAG_STATE_MIX)");
    this.qJN = k.a.fx(parame);
    parame = a.yor;
    i = a.dJH();
    parame = a.yor;
    j = a.dJI();
    parame = a.yor;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.dJJ()) });
    d.g.b.k.g(parame, "Arrays.asList(ConstantsS…ORY_SOURCE_ALBUM_HISTORY)");
    this.xjg = k.a.fx(parame);
    parame = a.yor;
    i = a.dKg();
    parame = a.yor;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(a.dKh()) });
    d.g.b.k.g(parame, "Arrays.asList(ConstantsS…STORY_ITEM_FAVORITE_FLAG)");
    this.ypi = k.a.fx(parame);
    this.db = this.yoX;
    this.ypj = Collections.synchronizedList((List)new ArrayList());
    parame = new ArrayList();
    localObject1 = this.qJN.iterator();
    Integer localInteger;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.yoA;
      if ((i & a.d.dKn()) != 0)
      {
        i = localInteger.intValue();
        localObject2 = a.d.yoA;
        if ((i & a.d.dKo()) == 0) {
          parame.add(localInteger);
        }
      }
    }
    this.xiW = k.a.j((List)parame, "localFlag");
    parame.clear();
    localObject1 = this.xjg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.yor;
      if ((i & a.dJH()) != 0) {
        parame.add(localInteger);
      }
    }
    xja = k.a.j((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.xjg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.yor;
      if ((i & a.dJI()) != 0) {
        parame.add(localInteger);
      }
    }
    xjc = k.a.j((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.qJN.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.yoA;
      if ((i & a.d.dKo()) != 0) {
        parame.add(localInteger);
      }
    }
    this.xiX = k.a.j((List)parame, "localFlag");
    parame.clear();
    localObject1 = this.xjg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.yor;
      if ((i & a.dJJ()) != 0) {
        parame.add(localInteger);
      }
    }
    ypo = k.a.j((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.ypi.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.yor;
      if ((i & a.dKg()) != 0) {
        parame.add(localInteger);
      }
    }
    ypn = k.a.b((List)parame, "itemStoryFlag", true);
    parame.clear();
    localObject1 = this.ypi.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.yor;
      if ((i & a.dKh()) != 0) {
        parame.add(localInteger);
      }
    }
    ypp = k.a.j((List)parame, "itemStoryFlag");
    AppMethodBeat.o(119589);
  }
  
  private static String OJ(int paramInt)
  {
    AppMethodBeat.i(119566);
    String str = TABLE + ".createTime>" + paramInt;
    AppMethodBeat.o(119566);
    return str;
  }
  
  private static String bD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119565);
    if (paramBoolean)
    {
      paramString = " WHERE " + xja;
      AppMethodBeat.o(119565);
      return paramString;
    }
    paramString = " WHERE " + TABLE + ".userName='" + bt.aFQ(paramString) + "' AND " + xjc;
    AppMethodBeat.o(119565);
    return paramString;
  }
  
  private static String bL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119567);
    paramString = "select *,rowid from MMStoryInfo " + bD(paramString, paramBoolean);
    AppMethodBeat.o(119567);
    return paramString;
  }
  
  private long m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119556);
    d.g.b.k.h(paramString, "baseSql");
    Object localObject = paramString;
    if (paramLong != 0L) {
      localObject = paramString + " AND " + TABLE + ".storyID < '" + paramLong + '\'';
    }
    paramString = (String)localObject + xiR + " limit " + paramInt;
    ad.d(TAG, "getMinIdByLimit sql=".concat(String.valueOf(paramString)));
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToLast())
    {
      localObject = new j();
      d.g.b.k.g(paramString, "cu");
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
  
  private j tU(long paramLong)
  {
    AppMethodBeat.i(119564);
    if (paramLong >= 0L)
    {
      localj = OI((int)paramLong);
      AppMethodBeat.o(119564);
      return localj;
    }
    j localj = tW(paramLong);
    AppMethodBeat.o(119564);
    return localj;
  }
  
  public final boolean D(long paramLong, String paramString)
  {
    AppMethodBeat.i(119577);
    d.g.b.k.h(paramString, "username");
    boolean bool = tV(paramLong);
    j localj = new j();
    localj.field_userName = paramString;
    localj.field_storyID = paramLong;
    doNotify("notify_story_info_delete", 1, localj);
    AppMethodBeat.o(119577);
    return bool;
  }
  
  public final boolean Nf(int paramInt)
  {
    AppMethodBeat.i(119575);
    e locale = this.db;
    String str = TABLE;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.ypg;
    if (locale.delete(str, j.dKN() + "=?", new String[] { String.valueOf(paramInt) }) > 0)
    {
      AppMethodBeat.o(119575);
      return true;
    }
    AppMethodBeat.o(119575);
    return false;
  }
  
  public final j OI(int paramInt)
  {
    AppMethodBeat.i(119563);
    j localj = new j();
    Object localObject = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(TABLE).append('.');
    j.a locala = j.ypg;
    localObject = j.dKN() + '=' + paramInt;
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      d.g.b.k.g(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119563);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119563);
    return null;
  }
  
  public final long S(long paramLong, int paramInt)
  {
    AppMethodBeat.i(119581);
    paramLong = m("select *,rowid from MMStoryInfo  WHERE " + ypo, paramLong, paramInt);
    AppMethodBeat.o(119581);
    return paramLong;
  }
  
  public final int a(int paramInt, j paramj)
  {
    AppMethodBeat.i(119562);
    d.g.b.k.h(paramj, "storyinfo");
    Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
    if (j.b.dHd().arZ(paramInt + '_' + paramj.field_createTime))
    {
      AppMethodBeat.o(119562);
      return -1;
    }
    paramj = paramj.convertTo();
    paramj.remove("rowid");
    localObject = this.db;
    String str = TABLE;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.ypg;
    paramInt = ((e)localObject).update(str, paramj, j.dKN() + "=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(119562);
    return paramInt;
  }
  
  public final long a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119582);
    d.g.b.k.h(paramString, "username");
    paramLong = m("select *,rowid from MMStoryInfo  " + bD(paramString, paramBoolean) + " AND " + ypp, paramLong, paramInt);
    AppMethodBeat.o(119582);
    return paramLong;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(119572);
    d.g.b.k.h(paramString, "userName");
    Object localObject1 = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bD(paramString, paramBoolean1) + ' ';
    paramString = paramString + " AND " + OJ(paramInt);
    Object localObject2 = new StringBuilder().append(paramString);
    if (paramBoolean1) {}
    for (paramString = xiR;; paramString = " AND " + ypm + " AND " + ypn + ' ' + xiR)
    {
      paramString = paramString;
      paramString = this.db.a(paramString, null, 2);
      if (paramString == null) {
        break label212;
      }
      while (paramString.moveToNext())
      {
        localObject2 = new j();
        ((j)localObject2).convertFrom(paramString);
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramString.close();
    label212:
    if (paramBoolean1)
    {
      paramString = d.yew;
      d.Oo(((ArrayList)localObject1).size());
    }
    if (paramBoolean2)
    {
      localObject1 = (Iterable)localObject1;
      paramString = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label311:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!((j)localObject2).dKK()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label311;
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
    d.g.b.k.h(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      Object localObject = "select *,rowid from MMStoryInfo  " + bD(paramString, paramBoolean) + " AND " + ypp + ' ';
      paramString = (String)localObject;
      if (paramLong < 0L) {
        paramString = (String)localObject + " AND storyID >= " + paramLong;
      }
      localObject = paramString + xiR;
      paramString = (String)localObject;
      if (paramInt > 0) {
        paramString = (String)localObject + " limit " + paramInt;
      }
      ad.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(paramString)));
      paramString = this.db.a(paramString, null, 2);
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
  
  public final void arY(String paramString)
  {
    AppMethodBeat.i(119554);
    d.g.b.k.h(paramString, "localId");
    this.ypj.add(paramString);
    AppMethodBeat.o(119554);
  }
  
  public final boolean arZ(String paramString)
  {
    AppMethodBeat.i(119555);
    d.g.b.k.h(paramString, "localId");
    boolean bool = false;
    ??? = this.ypj;
    d.g.b.k.g(???, "delList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        Iterator localIterator = ((Iterable)???).iterator();
        if (localIterator.hasNext())
        {
          if (d.g.b.k.g((String)localIterator.next(), paramString))
          {
            bool = true;
            ad.i(TAG, "wo wo wo ".concat(String.valueOf(paramString)));
          }
        }
        else
        {
          paramString = y.JfV;
          AppMethodBeat.o(119555);
          return bool;
        }
      }
    }
  }
  
  public final long b(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119568);
    d.g.b.k.h(paramString, "username");
    paramLong = m(bL(paramString, paramBoolean), paramLong, paramInt);
    AppMethodBeat.o(119568);
    return paramLong;
  }
  
  public final List<j> bM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119569);
    d.g.b.k.h(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bD(paramString, paramBoolean);
    Object localObject = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = xiR;; paramString = " AND " + ypm + xiR)
    {
      paramString = paramString;
      paramString = this.db.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        localObject = new j();
        d.g.b.k.g(paramString, "cu");
        ((j)localObject).convertFrom(paramString);
        localArrayList.add(localObject);
      }
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(119569);
    return paramString;
  }
  
  public final j bN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119583);
    d.g.b.k.h(paramString, "userName");
    j localj = new j();
    paramString = "select *,rowid from MMStoryInfo " + bD(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = xiR;; paramString = " AND " + ypm + xiR)
    {
      paramString = paramString;
      paramString = paramString + " limit 1";
      paramString = this.db.a(paramString, null, 2);
      if (paramString.moveToFirst())
      {
        d.g.b.k.g(paramString, "cu");
        localj.convertFrom(paramString);
      }
      paramString.close();
      AppMethodBeat.o(119583);
      return localj;
    }
  }
  
  public final ArrayList<j> bO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119586);
    d.g.b.k.h(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = "select *,rowid from MMStoryInfo  " + bD(paramString, paramBoolean) + " AND " + ypp + ' ' + xiR;
      ad.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(paramString)));
      paramString = this.db.a(paramString, null, 2);
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
  
  public final j dKQ()
  {
    AppMethodBeat.i(119561);
    int i = ce.asT();
    Object localObject1 = i.yeK;
    int j = i.dGU();
    localObject1 = new j();
    Object localObject2 = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.xiW).append(" and createTime > ").append(i - j).append(" order by ").append(TABLE).append('.');
    Object localObject3 = j.ypg;
    localObject2 = j.dKN() + " asc limit 1";
    localObject3 = this.db.a((String)localObject2, null, 2);
    ad.d(TAG, "getLastUpload ".concat(String.valueOf(localObject2)));
    if (!((Cursor)localObject3).moveToFirst())
    {
      ((Cursor)localObject3).close();
      AppMethodBeat.o(119561);
      return null;
    }
    d.g.b.k.g(localObject3, "cr");
    ((j)localObject1).convertFrom((Cursor)localObject3);
    ((Cursor)localObject3).close();
    AppMethodBeat.o(119561);
    return localObject1;
  }
  
  public final void dgI()
  {
    AppMethodBeat.i(119579);
    int i = this.db.delete(TABLE, null, null);
    ad.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119579);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(119557);
    d.g.b.k.h(paramj, "storyInfo");
    boolean bool = replace((c)paramj);
    AppMethodBeat.o(119557);
    return bool;
  }
  
  public final List<j> eG(String paramString, int paramInt)
  {
    AppMethodBeat.i(119580);
    d.g.b.k.h(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bD(paramString, true);
    paramString = paramString + " AND createTime BETWEEN " + paramInt + " AND " + (86400 + paramInt - 1);
    paramString = paramString + xiR;
    paramString = this.db.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      j localj = new j();
      d.g.b.k.g(paramString, "cu");
      localj.convertFrom(paramString);
      localArrayList.add(localj);
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(119580);
    return paramString;
  }
  
  public final int f(j paramj)
  {
    AppMethodBeat.i(119559);
    d.g.b.k.h(paramj, "storyInfo");
    ad.d(TAG, "storyInfo Insert");
    paramj = paramj.convertTo();
    int i = (int)this.db.insert(TABLE, "", paramj);
    ad.d(TAG, "StoryInfo Insert result ".concat(String.valueOf(i)));
    AppMethodBeat.o(119559);
    return i;
  }
  
  public final List<j> j(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119574);
    d.g.b.k.h(paramString, "userName");
    Object localObject1 = (Iterable)a(this, paramString, paramBoolean, paramInt);
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label99:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((j)localObject2).dKH().Erc == 0) {}
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
  
  public final j tT(long paramLong)
  {
    AppMethodBeat.i(119560);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  where " + TABLE + ".storyID=" + paramLong + " limit 1";
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      d.g.b.k.g(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119560);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119560);
    return null;
  }
  
  public final boolean tV(long paramLong)
  {
    AppMethodBeat.i(119576);
    if (this.db.delete(TABLE, "storyID=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(119576);
      return true;
    }
    AppMethodBeat.o(119576);
    return false;
  }
  
  public final j tW(long paramLong)
  {
    AppMethodBeat.i(119578);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  WHERE " + TABLE + ".storyID=" + paramLong;
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      d.g.b.k.g(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119578);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119578);
    return null;
  }
  
  public final int tX(long paramLong)
  {
    AppMethodBeat.i(119584);
    j localj = tU(paramLong);
    if (localj != null)
    {
      int i = localj.field_readCount;
      AppMethodBeat.o(119584);
      return i;
    }
    AppMethodBeat.o(119584);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.k
 * JD-Core Version:    0.7.0.1
 */