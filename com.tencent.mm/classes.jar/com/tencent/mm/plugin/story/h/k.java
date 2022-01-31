package com.tencent.mm.plugin.story.h;

import a.l;
import a.y;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.model.d;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_POST", "", "CON_SERVER", "CON_TYPE_ERROR", "db", "delList", "", "kotlin.jvm.PlatformType", "", "itemFlagSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "localFlagSet", "sourceTypeSet", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setVdb", "addDelList", "", "localId", "addReadCount", "storyId", "", "count", "conTimestampAfter", "limitTime", "conTimestampBefore", "conUserWhere", "userName", "isSelf", "", "deleteByLocalId", "deleteByStoryId", "deleteByStoryIdWithNotify", "username", "deleteByUsername", "droptable", "dumpinfo", "get", "getAlbumStoryAfterByStoryId", "minId", "limitCount", "getByLocalId", "getByStoryId", "getByUserName", "getByUserNameAfter", "timeStamp", "excludePrivacy", "getDiedStory", "getFavHistoryMinIdByLimit", "maxId", "getFavStoryByUsername", "getForSnsByUserNameAfter", "getHistoryMinIdByLimit", "getInfoBetweenDate", "createTime", "getLastStoryByName", "getLastUpload", "getMinIdByLimit", "baseSql", "conServer", "getStoryAfterByStoryId", "getStoryById", "id", "getStoryReadCount", "getUserMinIdByLimit", "getUserSql", "getBuf", "checkCount", "inDelList", "isPcIdExist", "isStoryIdExist", "removeDelList", "replaceStoryId", "storyInfo", "replaceUserByPcId", "snsInfo", "set", "update", "updateByLocal", "storyinfo", "updateSourceTypeBefore", "sourceType", "updateStoryFavorite", "favorite", "updateStoryVisibility", "visibilitySelf", "Companion", "plugin-story_release"})
public final class k
  extends com.tencent.mm.sdk.e.j<j>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final String TAG = "MicroMsg.StoryInfoStorage";
  public static String rDl;
  private static String rDu;
  private static String rDv;
  public static final String sGE = "MMStoryInfo";
  private static final String sGS = "select count(*) from MMStoryInfo ";
  private static String sGT;
  public static final String sGU = " (storyID != 0  ) ";
  private static String sGV;
  private static String sGW;
  private static String sGX;
  public static final k.a sGY;
  public final e db;
  private String rDq;
  private String rDr;
  private final ArrayList<Integer> rDy;
  private final ArrayList<Integer> rDz;
  private e sGD;
  private final String sGP;
  private final ArrayList<Integer> sGQ;
  private final List<String> sGR;
  
  static
  {
    AppMethodBeat.i(109965);
    sGY = new k.a((byte)0);
    TAG = "MicroMsg.StoryInfoStorage";
    sGS = "select count(*) from MMStoryInfo ";
    sGE = "MMStoryInfo";
    rDl = " order by " + sGE + ".createTime desc";
    sGT = " order by " + sGE + ".favoriteTime asc";
    sGU = " (storyID != 0  ) ";
    Object localObject1 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject2 = j.sGO;
    localObject1 = j.cFg() + " ON " + sGE + " ( storyID )";
    localObject2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject3 = j.sGO;
    localObject2 = j.cFh() + " ON " + sGE + " (userName,storyID, createTime)";
    localObject3 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    j.a locala = j.sGO;
    INDEX_CREATE = new String[] { localObject1, localObject2, j.cFi() + " ON " + sGE + " (userName, createTime)" };
    localObject1 = j.sGO;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(j.cEM(), sGE) };
    AppMethodBeat.o(109965);
  }
  
  public k(e parame)
  {
    super(parame, j.cEM(), sGE, INDEX_CREATE);
    AppMethodBeat.i(109964);
    this.sGD = parame;
    this.sGP = " (storyID != 0 ) ";
    parame = a.d.sGd;
    int i = a.d.cEy();
    parame = a.d.sGd;
    int j = a.d.cEz();
    parame = a.d.sGd;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.d.cEA()) });
    a.f.b.j.p(parame, "Arrays.asList(ConstantsS…lag.LOCAL_FLAG_STATE_MIX)");
    this.rDy = k.a.dh(parame);
    parame = a.sFV;
    i = a.cDO();
    parame = a.sFV;
    j = a.cDP();
    parame = a.sFV;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.cDQ()) });
    a.f.b.j.p(parame, "Arrays.asList(ConstantsS…ORY_SOURCE_ALBUM_HISTORY)");
    this.rDz = k.a.dh(parame);
    parame = a.sFV;
    i = a.cEp();
    parame = a.sFV;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(a.cEq()) });
    a.f.b.j.p(parame, "Arrays.asList(ConstantsS…STORY_ITEM_FAVORITE_FLAG)");
    this.sGQ = k.a.dh(parame);
    this.db = this.sGD;
    this.sGR = Collections.synchronizedList((List)new ArrayList());
    parame = new ArrayList();
    localObject1 = this.rDy.iterator();
    Integer localInteger;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.sGd;
      if ((i & a.d.cEy()) != 0)
      {
        i = localInteger.intValue();
        localObject2 = a.d.sGd;
        if ((i & a.d.cEz()) == 0) {
          parame.add(localInteger);
        }
      }
    }
    this.rDq = k.a.g((List)parame, "localFlag");
    parame.clear();
    localObject1 = this.rDz.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.sFV;
      if ((i & a.cDO()) != 0) {
        parame.add(localInteger);
      }
    }
    rDu = k.a.g((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.rDz.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.sFV;
      if ((i & a.cDP()) != 0) {
        parame.add(localInteger);
      }
    }
    rDv = k.a.g((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.rDy.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.sGd;
      if ((i & a.d.cEz()) != 0) {
        parame.add(localInteger);
      }
    }
    this.rDr = k.a.g((List)parame, "localFlag");
    parame.clear();
    localObject1 = this.rDz.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.sFV;
      if ((i & a.cDQ()) != 0) {
        parame.add(localInteger);
      }
    }
    sGW = k.a.g((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.sGQ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.sFV;
      if ((i & a.cEp()) != 0) {
        parame.add(localInteger);
      }
    }
    sGV = k.a.b((List)parame, "itemStoryFlag", true);
    parame.clear();
    localObject1 = this.sGQ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.sFV;
      if ((i & a.cEq()) != 0) {
        parame.add(localInteger);
      }
    }
    sGX = k.a.g((List)parame, "itemStoryFlag");
    AppMethodBeat.o(109964);
  }
  
  private static String Gc(int paramInt)
  {
    AppMethodBeat.i(109944);
    String str = sGE + ".createTime>" + paramInt;
    AppMethodBeat.o(109944);
    return str;
  }
  
  private static String bB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109945);
    paramString = "select *,rowid from MMStoryInfo " + bs(paramString, paramBoolean);
    AppMethodBeat.o(109945);
    return paramString;
  }
  
  public static String bs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109943);
    if (paramBoolean)
    {
      paramString = " WHERE " + rDu;
      AppMethodBeat.o(109943);
      return paramString;
    }
    paramString = " WHERE " + sGE + ".userName='" + bo.wC(paramString) + "' AND " + rDv;
    AppMethodBeat.o(109943);
    return paramString;
  }
  
  private long l(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(109934);
    a.f.b.j.q(paramString, "baseSql");
    Object localObject = paramString;
    if (paramLong != 0L) {
      localObject = paramString + " AND " + sGE + ".storyID < '" + paramLong + '\'';
    }
    paramString = (String)localObject + rDl + " limit " + paramInt;
    ab.d(TAG, "getMinIdByLimit sql=".concat(String.valueOf(paramString)));
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToLast())
    {
      localObject = new j();
      a.f.b.j.p(paramString, "cu");
      ((j)localObject).convertFrom(paramString);
      paramString.close();
      paramLong = ((j)localObject).field_storyID;
      AppMethodBeat.o(109934);
      return paramLong;
    }
    paramString.close();
    AppMethodBeat.o(109934);
    return 0L;
  }
  
  private boolean mS(long paramLong)
  {
    AppMethodBeat.i(138844);
    Object localObject = "select *,rowid from MMStoryInfo  where " + sGE + ".storyID = " + paramLong;
    localObject = this.db.rawQuery((String)localObject, null);
    a.f.b.j.p(localObject, "cu");
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if (i > 0)
    {
      AppMethodBeat.o(138844);
      return true;
    }
    AppMethodBeat.o(138844);
    return false;
  }
  
  private j mT(long paramLong)
  {
    AppMethodBeat.i(109942);
    if (paramLong >= 0L)
    {
      localj = Gb((int)paramLong);
      AppMethodBeat.o(109942);
      return localj;
    }
    j localj = mV(paramLong);
    AppMethodBeat.o(109942);
    return localj;
  }
  
  private boolean mU(long paramLong)
  {
    AppMethodBeat.i(109956);
    if (this.db.delete(sGE, "storyID=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(109956);
      return true;
    }
    AppMethodBeat.o(109956);
    return false;
  }
  
  public final boolean EA(int paramInt)
  {
    AppMethodBeat.i(109955);
    e locale = this.db;
    String str = sGE;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.sGO;
    if (locale.delete(str, j.cFf() + "=?", new String[] { String.valueOf(paramInt) }) > 0)
    {
      AppMethodBeat.o(109955);
      return true;
    }
    AppMethodBeat.o(109955);
    return false;
  }
  
  public final j Gb(int paramInt)
  {
    AppMethodBeat.i(109941);
    j localj = new j();
    Object localObject = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(sGE).append('.');
    j.a locala = j.sGO;
    localObject = j.cFf() + '=' + paramInt;
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      a.f.b.j.p(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(109941);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(109941);
    return null;
  }
  
  public final long H(long paramLong, int paramInt)
  {
    AppMethodBeat.i(109960);
    paramLong = l("select *,rowid from MMStoryInfo  WHERE " + sGW, paramLong, paramInt);
    AppMethodBeat.o(109960);
    return paramLong;
  }
  
  public final int a(int paramInt, j paramj)
  {
    AppMethodBeat.i(109940);
    a.f.b.j.q(paramj, "storyinfo");
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    if (j.b.cAB().adG(paramInt + '_' + paramj.field_createTime))
    {
      AppMethodBeat.o(109940);
      return -1;
    }
    paramj = paramj.convertTo();
    paramj.remove("rowid");
    localObject = this.db;
    String str = sGE;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.sGO;
    paramInt = ((e)localObject).update(str, paramj, j.cFf() + "=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(109940);
    return paramInt;
  }
  
  public final long a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151119);
    a.f.b.j.q(paramString, "username");
    paramLong = l("select *,rowid from MMStoryInfo  " + bs(paramString, paramBoolean) + " AND " + sGX, paramLong, paramInt);
    AppMethodBeat.o(151119);
    return paramLong;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(109952);
    a.f.b.j.q(paramString, "userName");
    Object localObject1 = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bs(paramString, paramBoolean1) + ' ';
    paramString = paramString + " AND " + Gc(paramInt);
    Object localObject2 = new StringBuilder().append(paramString);
    if (paramBoolean1) {}
    for (paramString = rDl;; paramString = " AND " + sGU + " AND " + sGV + ' ' + rDl)
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
      paramString = d.sut;
      d.FG(((ArrayList)localObject1).size());
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
        if (!((j)localObject2).cFc()) {}
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
      AppMethodBeat.o(109952);
      return paramString;
    }
    paramString = (List)localObject1;
    AppMethodBeat.o(109952);
    return paramString;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(138847);
    a.f.b.j.q(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      Object localObject = "select *,rowid from MMStoryInfo  " + bs(paramString, paramBoolean) + " AND " + sGX + ' ';
      paramString = (String)localObject;
      if (paramLong < 0L) {
        paramString = (String)localObject + " AND storyID >= " + paramLong;
      }
      localObject = paramString + rDl;
      paramString = (String)localObject;
      if (paramInt > 0) {
        paramString = (String)localObject + " limit " + paramInt;
      }
      ab.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(paramString)));
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
    AppMethodBeat.o(138847);
    return paramString;
  }
  
  public final boolean a(long paramLong, j paramj)
  {
    AppMethodBeat.i(138843);
    a.f.b.j.q(paramj, "storyInfo");
    if (mS(paramLong))
    {
      boolean bool = b(paramLong, paramj);
      AppMethodBeat.o(138843);
      return bool;
    }
    if (e(paramj) != -1)
    {
      AppMethodBeat.o(138843);
      return true;
    }
    AppMethodBeat.o(138843);
    return false;
  }
  
  public final void adF(String paramString)
  {
    AppMethodBeat.i(109932);
    a.f.b.j.q(paramString, "localId");
    this.sGR.add(paramString);
    AppMethodBeat.o(109932);
  }
  
  public final boolean adG(String paramString)
  {
    AppMethodBeat.i(109933);
    a.f.b.j.q(paramString, "localId");
    boolean bool = false;
    ??? = this.sGR;
    a.f.b.j.p(???, "delList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        Iterator localIterator = ((Iterable)???).iterator();
        if (localIterator.hasNext())
        {
          if (a.f.b.j.e((String)localIterator.next(), paramString))
          {
            bool = true;
            ab.i(TAG, "wo wo wo ".concat(String.valueOf(paramString)));
          }
        }
        else
        {
          paramString = y.BMg;
          AppMethodBeat.o(109933);
          return bool;
        }
      }
    }
  }
  
  public final long b(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109946);
    a.f.b.j.q(paramString, "username");
    paramLong = l(bB(paramString, paramBoolean), paramLong, paramInt);
    AppMethodBeat.o(109946);
    return paramLong;
  }
  
  public final boolean b(long paramLong, j paramj)
  {
    AppMethodBeat.i(109935);
    a.f.b.j.q(paramj, "storyInfo");
    paramj = paramj.convertTo();
    if (this.db.update(sGE, paramj, "storyID=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(109935);
      return true;
    }
    AppMethodBeat.o(109935);
    return false;
  }
  
  public final List<j> bC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(138845);
    a.f.b.j.q(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bs(paramString, paramBoolean);
    Object localObject = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = rDl;; paramString = " AND " + sGU + rDl)
    {
      paramString = paramString;
      paramString = this.db.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        localObject = new j();
        a.f.b.j.p(paramString, "cu");
        ((j)localObject).convertFrom(paramString);
        localArrayList.add(localObject);
      }
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(138845);
    return paramString;
  }
  
  public final ArrayList<j> bD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109963);
    a.f.b.j.q(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = "select *,rowid from MMStoryInfo  " + bs(paramString, paramBoolean) + " AND " + sGX + ' ' + rDl;
      ab.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(paramString)));
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
    AppMethodBeat.o(109963);
    return localArrayList;
  }
  
  public final boolean c(long paramLong, j paramj)
  {
    AppMethodBeat.i(109947);
    a.f.b.j.q(paramj, "snsInfo");
    if (lR(paramLong))
    {
      boolean bool = b(paramLong, paramj);
      AppMethodBeat.o(109947);
      return bool;
    }
    if (e(paramj) != -1)
    {
      AppMethodBeat.o(109947);
      return true;
    }
    AppMethodBeat.o(109947);
    return false;
  }
  
  public final j cFj()
  {
    AppMethodBeat.i(109939);
    int i = cb.abr();
    Object localObject1 = i.suJ;
    int j = i.cAp();
    localObject1 = new j();
    Object localObject2 = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.rDq).append(" and createTime > ").append(i - j).append(" order by ").append(sGE).append('.');
    Object localObject3 = j.sGO;
    localObject2 = j.cFf() + " asc limit 1";
    localObject3 = this.db.a((String)localObject2, null, 2);
    ab.d(TAG, "getLastUpload ".concat(String.valueOf(localObject2)));
    if (!((Cursor)localObject3).moveToFirst())
    {
      ((Cursor)localObject3).close();
      AppMethodBeat.o(109939);
      return null;
    }
    a.f.b.j.p(localObject3, "cr");
    ((j)localObject1).convertFrom((Cursor)localObject3);
    ((Cursor)localObject3).close();
    AppMethodBeat.o(109939);
    return localObject1;
  }
  
  public final void csu()
  {
    AppMethodBeat.i(109958);
    int i = this.db.delete(sGE, null, null);
    ab.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(109958);
  }
  
  public final List<j> dy(String paramString, int paramInt)
  {
    AppMethodBeat.i(109959);
    a.f.b.j.q(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bs(paramString, true);
    paramString = paramString + " AND createTime BETWEEN " + paramInt + " AND " + (86400 + paramInt - 1);
    paramString = paramString + rDl;
    paramString = this.db.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      j localj = new j();
      a.f.b.j.p(paramString, "cu");
      localj.convertFrom(paramString);
      localArrayList.add(localj);
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(109959);
    return paramString;
  }
  
  public final int e(j paramj)
  {
    AppMethodBeat.i(109937);
    a.f.b.j.q(paramj, "storyInfo");
    ab.d(TAG, "storyInfo Insert");
    paramj = paramj.convertTo();
    int i = (int)this.db.insert(sGE, "", paramj);
    ab.d(TAG, "StoryInfo Insert result ".concat(String.valueOf(i)));
    AppMethodBeat.o(109937);
    return i;
  }
  
  public final List<j> i(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(109954);
    a.f.b.j.q(paramString, "userName");
    Object localObject1 = (Iterable)a(this, paramString, paramBoolean, paramInt);
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label99:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((j)localObject2).cEY().xSM == 0) {}
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
    AppMethodBeat.o(109954);
    return paramString;
  }
  
  public final boolean lR(long paramLong)
  {
    AppMethodBeat.i(109948);
    Object localObject = "select *,rowid from MMStoryInfo  where " + sGE + ".storyID = " + paramLong;
    localObject = this.db.rawQuery((String)localObject, null);
    a.f.b.j.p(localObject, "cu");
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if (i > 0)
    {
      AppMethodBeat.o(109948);
      return true;
    }
    AppMethodBeat.o(109948);
    return false;
  }
  
  public final j mR(long paramLong)
  {
    AppMethodBeat.i(109938);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  where " + sGE + ".storyID=" + paramLong + " limit 1";
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      a.f.b.j.p(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(109938);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(109938);
    return null;
  }
  
  public final j mV(long paramLong)
  {
    AppMethodBeat.i(109957);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  WHERE " + sGE + ".storyID=" + paramLong;
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      a.f.b.j.p(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(109957);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(109957);
    return null;
  }
  
  public final int mW(long paramLong)
  {
    AppMethodBeat.i(109961);
    j localj = mT(paramLong);
    if (localj != null)
    {
      int i = localj.field_readCount;
      AppMethodBeat.o(109961);
      return i;
    }
    AppMethodBeat.o(109961);
    return 0;
  }
  
  public final boolean x(long paramLong, String paramString)
  {
    AppMethodBeat.i(151118);
    a.f.b.j.q(paramString, "username");
    boolean bool = mU(paramLong);
    j localj = new j();
    localj.field_userName = paramString;
    localj.field_storyID = paramLong;
    doNotify("notify_story_info_delete", 1, localj);
    AppMethodBeat.o(151118);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.k
 * JD-Core Version:    0.7.0.1
 */