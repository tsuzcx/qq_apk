package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public class f
  extends j<e>
{
  public static final String[] SQL_CREATE;
  private static volatile f vEO;
  private final h fnw;
  public final boolean hsO;
  
  static
  {
    AppMethodBeat.i(63417);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.fkk, "WepkgVersion") };
    vEO = null;
    AppMethodBeat.o(63417);
  }
  
  private f(h paramh)
  {
    super(paramh, e.fkk, "WepkgVersion", e.INDEX_CREATE);
    AppMethodBeat.i(63401);
    this.fnw = paramh;
    if (paramh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.hsO = bool;
      if (!this.hsO) {
        ab.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(63401);
      return;
    }
  }
  
  public static f dkq()
  {
    AppMethodBeat.i(63400);
    f localf;
    if (!g.RG())
    {
      localf = new f(null);
      AppMethodBeat.o(63400);
      return localf;
    }
    if (vEO == null) {}
    try
    {
      if ((vEO == null) || (!vEO.hsO)) {
        vEO = new f(g.RL().eHS);
      }
      localf = vEO;
      AppMethodBeat.o(63400);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(63400);
    }
  }
  
  public final boolean B(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63411);
    if ((!this.hsO) || (bo.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(63411);
      return false;
    }
    e locale = ako(paramString1);
    if (locale == null)
    {
      AppMethodBeat.o(63411);
      return false;
    }
    locale.field_bigPackageReady = paramBoolean;
    locale.field_pkgPath = paramString2;
    boolean bool = super.update(locale, new String[0]);
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    AppMethodBeat.o(63411);
    return bool;
  }
  
  public final boolean a(e parame, WePkgDiffInfo paramWePkgDiffInfo)
  {
    AppMethodBeat.i(63410);
    if ((!this.hsO) || (bo.isNullOrNil(parame.field_pkgId)))
    {
      AppMethodBeat.o(63410);
      return false;
    }
    Object localObject = ako(parame.field_pkgId);
    if (localObject == null) {}
    for (long l = com.tencent.mm.plugin.wepkg.utils.d.aNY();; l = ((e)localObject).field_accessTime)
    {
      if ((paramWePkgDiffInfo != null) && (!bo.isNullOrNil(paramWePkgDiffInfo.downloadUrl)))
      {
        localObject = dkq().ako(parame.field_pkgId);
        if ((localObject != null) && (com.tencent.mm.vfs.e.cN(((e)localObject).field_pkgPath)))
        {
          paramWePkgDiffInfo.ezY = ((e)localObject).field_pkgId;
          paramWePkgDiffInfo.vFR = ((e)localObject).field_version;
          paramWePkgDiffInfo.vFS = ((e)localObject).field_pkgPath;
          b.dko().qD(paramWePkgDiffInfo.ezY);
          localObject = b.dko();
          a locala = new a();
          locala.field_pkgId = paramWePkgDiffInfo.ezY;
          locala.field_oldVersion = paramWePkgDiffInfo.vFR;
          locala.field_oldPath = paramWePkgDiffInfo.vFS;
          locala.field_version = paramWePkgDiffInfo.version;
          locala.field_downloadUrl = paramWePkgDiffInfo.downloadUrl;
          locala.field_md5 = paramWePkgDiffInfo.cqq;
          locala.field_pkgSize = paramWePkgDiffInfo.fileSize;
          locala.field_downloadNetType = paramWePkgDiffInfo.vFT;
          ((b)localObject).insert(locala);
          ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertDiffPkg");
        }
      }
      dkq().akn(parame.field_pkgId);
      d.dkp().akn(parame.field_pkgId);
      parame.field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.aNY() + parame.field_checkIntervalTime);
      parame.field_createTime = com.tencent.mm.plugin.wepkg.utils.d.aNY();
      parame.field_accessTime = l;
      boolean bool = insert(parame);
      ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertPkgVersion pkgid:%s, version:%s, ret:%s", new Object[] { parame.field_pkgId, parame.field_version, Boolean.valueOf(bool) });
      AppMethodBeat.o(63410);
      return bool;
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(63409);
    if (!this.hsO)
    {
      AppMethodBeat.o(63409);
      return false;
    }
    e locale = ako(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(63409);
      return false;
    }
    locale.field_disableWvCache = paramBoolean;
    locale.field_clearPkgTime = paramLong1;
    locale.field_nextCheckTime = (locale.field_nextCheckTime - locale.field_checkIntervalTime + paramLong2);
    locale.field_checkIntervalTime = paramLong2;
    locale.field_disable = false;
    boolean bool = super.update(locale, new String[0]);
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool) });
    AppMethodBeat.o(63409);
    return bool;
  }
  
  public final boolean akn(String paramString)
  {
    AppMethodBeat.i(63407);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63407);
      return false;
    }
    e locale = new e();
    locale.field_pkgId = paramString;
    boolean bool = super.delete(locale, new String[0]);
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(63407);
    return bool;
  }
  
  public final e ako(String paramString)
  {
    AppMethodBeat.i(63402);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63402);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WepkgVersion", "pkgId" }), new String[] { paramString });
    if (localCursor.moveToFirst())
    {
      paramString = new e();
      paramString.convertFrom(localCursor);
      localCursor.close();
      ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", new Object[] { paramString.field_pkgId, paramString.field_version });
      AppMethodBeat.o(63402);
      return paramString;
    }
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(63402);
    return null;
  }
  
  public final e akp(String paramString)
  {
    AppMethodBeat.i(63403);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63403);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[] { "WepkgVersion", "pkgId", "disable" }), new String[] { paramString });
    if (localCursor.moveToFirst())
    {
      paramString = new e();
      paramString.convertFrom(localCursor);
      localCursor.close();
      ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", new Object[] { paramString.field_pkgId, paramString.field_version, Boolean.valueOf(paramString.field_disableWvCache), Long.valueOf(paramString.field_clearPkgTime), Long.valueOf(paramString.field_checkIntervalTime), paramString.field_domain, Boolean.valueOf(paramString.field_bigPackageReady), Boolean.valueOf(paramString.field_preloadFilesReady), Boolean.valueOf(paramString.field_preloadFilesAtomic), Boolean.valueOf(paramString.field_disable) });
      paramString.field_accessTime = com.tencent.mm.plugin.wepkg.utils.d.aNY();
      super.update(paramString, new String[0]);
      AppMethodBeat.o(63403);
      return paramString;
    }
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(63403);
    return null;
  }
  
  public final boolean akq(String paramString)
  {
    AppMethodBeat.i(63408);
    if (!this.hsO)
    {
      AppMethodBeat.o(63408);
      return false;
    }
    e locale = ako(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(63408);
      return false;
    }
    locale.field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.aNY() + locale.field_checkIntervalTime);
    boolean bool = super.update(locale, new String[0]);
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(63408);
    return bool;
  }
  
  public final boolean akr(String paramString)
  {
    AppMethodBeat.i(63413);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63413);
      return false;
    }
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", paramString }))) });
    AppMethodBeat.o(63413);
    return true;
  }
  
  public final boolean aks(String paramString)
  {
    AppMethodBeat.i(63414);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63414);
      return false;
    }
    e locale = ako(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(63414);
      return true;
    }
    locale.field_disable = true;
    boolean bool = super.update(locale, new String[0]);
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(63414);
    return bool;
  }
  
  public final boolean akt(String paramString)
  {
    AppMethodBeat.i(63415);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63415);
      return false;
    }
    e locale = ako(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(63415);
      return false;
    }
    locale.field_createTime = 0L;
    boolean bool = super.update(locale, new String[0]);
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(63415);
    return bool;
  }
  
  public final boolean bW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63412);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63412);
      return false;
    }
    e locale = ako(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(63412);
      return false;
    }
    locale.field_preloadFilesReady = paramBoolean;
    boolean bool = super.update(locale, new String[0]);
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    AppMethodBeat.o(63412);
    return bool;
  }
  
  public final List<String> dkr()
  {
    AppMethodBeat.i(63404);
    if (!this.hsO)
    {
      AppMethodBeat.o(63404);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select %s from %s where %s < ?", new Object[] { "pkgId", "WepkgVersion", "nextCheckTime" }), new String[] { String.valueOf(com.tencent.mm.plugin.wepkg.utils.d.aNY()) });
    ArrayList localArrayList = new ArrayList();
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        do
        {
          String str = localCursor.getString(0);
          if (!bo.isNullOrNil(str)) {
            localArrayList.add(str);
          }
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    AppMethodBeat.o(63404);
    return localArrayList;
  }
  
  public final List<String> dks()
  {
    AppMethodBeat.i(63405);
    if (!this.hsO)
    {
      AppMethodBeat.o(63405);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select %s from %s order by %s asc", new Object[] { "pkgId", "WepkgVersion", "accessTime" }), new String[0]);
    ArrayList localArrayList = new ArrayList();
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        do
        {
          String str = localCursor.getString(0);
          if (!bo.isNullOrNil(str)) {
            localArrayList.add(str);
          }
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    AppMethodBeat.o(63405);
    return localArrayList;
  }
  
  public final List<WepkgVersion> dkt()
  {
    AppMethodBeat.i(63406);
    if (!this.hsO)
    {
      AppMethodBeat.o(63406);
      return null;
    }
    Object localObject = String.format("select * from %s where %s < ? - %s", new Object[] { "WepkgVersion", "accessTime", "clearPkgTime" });
    Cursor localCursor = rawQuery((String)localObject, new String[] { String.valueOf(com.tencent.mm.plugin.wepkg.utils.d.aNY()) });
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", new Object[] { localObject });
    if (localCursor == null)
    {
      ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
      AppMethodBeat.o(63406);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = new ArrayList();
      do
      {
        WepkgVersion localWepkgVersion = new WepkgVersion();
        e locale = new e();
        locale.convertFrom(localCursor);
        localWepkgVersion.a(locale);
        ((List)localObject).add(localWepkgVersion);
      } while (localCursor.moveToNext());
      localCursor.close();
      ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      AppMethodBeat.o(63406);
      return localObject;
    }
    localCursor.close();
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
    AppMethodBeat.o(63406);
    return null;
  }
  
  public final boolean dku()
  {
    AppMethodBeat.i(63416);
    if (!this.hsO)
    {
      AppMethodBeat.o(63416);
      return false;
    }
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord clearWepkg ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgVersion", String.format("delete from %s", new Object[] { "WepkgVersion" }))) });
    ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord clearWepkg ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgPreloadFiles", String.format("delete from %s", new Object[] { "WepkgPreloadFiles" }))) });
    AppMethodBeat.o(63416);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.f
 * JD-Core Version:    0.7.0.1
 */