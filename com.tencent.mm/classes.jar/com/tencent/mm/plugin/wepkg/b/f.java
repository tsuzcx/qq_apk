package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public class f
  extends j<e>
{
  private static volatile f EDH;
  public static final String[] SQL_CREATE;
  private final h hHS;
  public final boolean kld;
  
  static
  {
    AppMethodBeat.i(110588);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.hEe, "WepkgVersion") };
    EDH = null;
    AppMethodBeat.o(110588);
  }
  
  private f(h paramh)
  {
    super(paramh, e.hEe, "WepkgVersion", e.INDEX_CREATE);
    AppMethodBeat.i(110572);
    this.hHS = paramh;
    if (paramh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.kld = bool;
      if (!this.kld) {
        ad.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(110572);
      return;
    }
  }
  
  public static f eXN()
  {
    AppMethodBeat.i(110571);
    f localf;
    if ((!g.ajx()) || (!com.tencent.mm.plugin.wepkg.utils.b.EFS))
    {
      localf = new f(null);
      AppMethodBeat.o(110571);
      return localf;
    }
    if (EDH == null) {}
    try
    {
      if ((EDH == null) || (!EDH.kld)) {
        EDH = new f(g.ajC().gBq);
      }
      localf = EDH;
      AppMethodBeat.o(110571);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(110571);
    }
  }
  
  public final boolean A(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(110582);
    if ((!this.kld) || (bt.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(110582);
      return false;
    }
    e locale = aKy(paramString1);
    if (locale == null)
    {
      AppMethodBeat.o(110582);
      return false;
    }
    locale.field_bigPackageReady = paramBoolean;
    locale.field_pkgPath = paramString2;
    boolean bool = super.update(locale, new String[0]);
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    AppMethodBeat.o(110582);
    return bool;
  }
  
  public final boolean a(e parame, WePkgDiffInfo paramWePkgDiffInfo)
  {
    AppMethodBeat.i(110581);
    if ((!this.kld) || (bt.isNullOrNil(parame.field_pkgId)))
    {
      AppMethodBeat.o(110581);
      return false;
    }
    Object localObject = aKy(parame.field_pkgId);
    if (localObject == null) {}
    for (long l = com.tencent.mm.plugin.wepkg.utils.d.currentTime();; l = ((e)localObject).field_accessTime)
    {
      if ((paramWePkgDiffInfo != null) && (!bt.isNullOrNil(paramWePkgDiffInfo.downloadUrl)))
      {
        localObject = eXN().aKy(parame.field_pkgId);
        if ((localObject != null) && (i.fv(((e)localObject).field_pkgPath)))
        {
          paramWePkgDiffInfo.gsn = ((e)localObject).field_pkgId;
          paramWePkgDiffInfo.oldVersion = ((e)localObject).field_version;
          paramWePkgDiffInfo.EEK = ((e)localObject).field_pkgPath;
          b.eXL().CA(paramWePkgDiffInfo.gsn);
          localObject = b.eXL();
          a locala = new a();
          locala.field_pkgId = paramWePkgDiffInfo.gsn;
          locala.field_oldVersion = paramWePkgDiffInfo.oldVersion;
          locala.field_oldPath = paramWePkgDiffInfo.EEK;
          locala.field_version = paramWePkgDiffInfo.version;
          locala.field_downloadUrl = paramWePkgDiffInfo.downloadUrl;
          locala.field_md5 = paramWePkgDiffInfo.md5;
          locala.field_pkgSize = paramWePkgDiffInfo.fileSize;
          locala.field_downloadNetType = paramWePkgDiffInfo.EEL;
          ((b)localObject).insert(locala);
          ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertDiffPkg");
        }
      }
      eXN().aKx(parame.field_pkgId);
      d.eXM().aKx(parame.field_pkgId);
      parame.field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.currentTime() + parame.field_checkIntervalTime);
      parame.field_createTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
      parame.field_accessTime = l;
      boolean bool = insert(parame);
      ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertPkgVersion pkgid:%s, version:%s, ret:%s", new Object[] { parame.field_pkgId, parame.field_version, Boolean.valueOf(bool) });
      AppMethodBeat.o(110581);
      return bool;
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110580);
    if (!this.kld)
    {
      AppMethodBeat.o(110580);
      return false;
    }
    e locale = aKy(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110580);
      return false;
    }
    locale.field_disableWvCache = paramBoolean;
    locale.field_clearPkgTime = paramLong1;
    locale.field_nextCheckTime = (locale.field_nextCheckTime - locale.field_checkIntervalTime + paramLong2);
    locale.field_checkIntervalTime = paramLong2;
    locale.field_disable = false;
    boolean bool = super.update(locale, new String[0]);
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool) });
    AppMethodBeat.o(110580);
    return bool;
  }
  
  public final boolean aKA(String paramString)
  {
    AppMethodBeat.i(110579);
    if (!this.kld)
    {
      AppMethodBeat.o(110579);
      return false;
    }
    e locale = aKy(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110579);
      return false;
    }
    locale.field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.currentTime() + locale.field_checkIntervalTime);
    boolean bool = super.update(locale, new String[0]);
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110579);
    return bool;
  }
  
  public final boolean aKB(String paramString)
  {
    AppMethodBeat.i(110584);
    if ((!this.kld) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110584);
      return false;
    }
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", paramString }))) });
    AppMethodBeat.o(110584);
    return true;
  }
  
  public final boolean aKC(String paramString)
  {
    AppMethodBeat.i(110585);
    if ((!this.kld) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110585);
      return false;
    }
    e locale = aKy(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110585);
      return true;
    }
    locale.field_disable = true;
    boolean bool = super.update(locale, new String[0]);
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110585);
    return bool;
  }
  
  public final boolean aKD(String paramString)
  {
    AppMethodBeat.i(110586);
    if ((!this.kld) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110586);
      return false;
    }
    e locale = aKy(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110586);
      return false;
    }
    locale.field_createTime = 0L;
    boolean bool = super.update(locale, new String[0]);
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110586);
    return bool;
  }
  
  public final boolean aKx(String paramString)
  {
    AppMethodBeat.i(110578);
    if ((!this.kld) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110578);
      return false;
    }
    e locale = new e();
    locale.field_pkgId = paramString;
    boolean bool = super.delete(locale, new String[0]);
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110578);
    return bool;
  }
  
  public final e aKy(String paramString)
  {
    AppMethodBeat.i(110573);
    if ((!this.kld) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110573);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WepkgVersion", "pkgId" }), new String[] { paramString });
    if (localCursor.moveToFirst())
    {
      paramString = new e();
      paramString.convertFrom(localCursor);
      localCursor.close();
      ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", new Object[] { paramString.field_pkgId, paramString.field_version });
      AppMethodBeat.o(110573);
      return paramString;
    }
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(110573);
    return null;
  }
  
  public final e aKz(String paramString)
  {
    AppMethodBeat.i(110574);
    if ((!this.kld) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110574);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[] { "WepkgVersion", "pkgId", "disable" }), new String[] { paramString });
    if (localCursor.moveToFirst())
    {
      paramString = new e();
      paramString.convertFrom(localCursor);
      localCursor.close();
      ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", new Object[] { paramString.field_pkgId, paramString.field_version, Boolean.valueOf(paramString.field_disableWvCache), Long.valueOf(paramString.field_clearPkgTime), Long.valueOf(paramString.field_checkIntervalTime), paramString.field_domain, Boolean.valueOf(paramString.field_bigPackageReady), Boolean.valueOf(paramString.field_preloadFilesReady), Boolean.valueOf(paramString.field_preloadFilesAtomic), Boolean.valueOf(paramString.field_disable) });
      paramString.field_accessTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
      super.update(paramString, new String[0]);
      AppMethodBeat.o(110574);
      return paramString;
    }
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(110574);
    return null;
  }
  
  public final boolean cw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110583);
    if ((!this.kld) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110583);
      return false;
    }
    e locale = aKy(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110583);
      return false;
    }
    locale.field_preloadFilesReady = paramBoolean;
    boolean bool = super.update(locale, new String[0]);
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    AppMethodBeat.o(110583);
    return bool;
  }
  
  public final List<String> eXO()
  {
    AppMethodBeat.i(110575);
    if (!this.kld)
    {
      AppMethodBeat.o(110575);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select %s from %s where %s < ?", new Object[] { "pkgId", "WepkgVersion", "nextCheckTime" }), new String[] { String.valueOf(com.tencent.mm.plugin.wepkg.utils.d.currentTime()) });
    ArrayList localArrayList = new ArrayList();
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        do
        {
          String str = localCursor.getString(0);
          if (!bt.isNullOrNil(str)) {
            localArrayList.add(str);
          }
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    AppMethodBeat.o(110575);
    return localArrayList;
  }
  
  public final List<WepkgVersion> eXP()
  {
    AppMethodBeat.i(110577);
    if (!this.kld)
    {
      AppMethodBeat.o(110577);
      return null;
    }
    Object localObject = String.format("select * from %s where %s < ? - %s", new Object[] { "WepkgVersion", "accessTime", "clearPkgTime" });
    Cursor localCursor = rawQuery((String)localObject, new String[] { String.valueOf(com.tencent.mm.plugin.wepkg.utils.d.currentTime()) });
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", new Object[] { localObject });
    if (localCursor == null)
    {
      ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
      AppMethodBeat.o(110577);
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
      ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      AppMethodBeat.o(110577);
      return localObject;
    }
    localCursor.close();
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
    AppMethodBeat.o(110577);
    return null;
  }
  
  public final boolean eXQ()
  {
    AppMethodBeat.i(110587);
    if (!this.kld)
    {
      AppMethodBeat.o(110587);
      return false;
    }
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord clearWepkg ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgVersion", String.format("delete from %s", new Object[] { "WepkgVersion" }))) });
    ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord clearWepkg ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgPreloadFiles", String.format("delete from %s", new Object[] { "WepkgPreloadFiles" }))) });
    AppMethodBeat.o(110587);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.f
 * JD-Core Version:    0.7.0.1
 */