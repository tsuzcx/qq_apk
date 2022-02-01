package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

public class f
  extends MAutoStorage<e>
{
  public static final String[] SQL_CREATE;
  private static volatile f XEO;
  private final com.tencent.mm.storagebase.h omV;
  public final boolean rqI;
  
  static
  {
    AppMethodBeat.i(110588);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(e.nVV, "WepkgVersion") };
    XEO = null;
    AppMethodBeat.o(110588);
  }
  
  private f(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, e.nVV, "WepkgVersion", e.INDEX_CREATE);
    AppMethodBeat.i(110572);
    this.omV = paramh;
    if (paramh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.rqI = bool;
      if (!this.rqI) {
        Log.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(110572);
      return;
    }
  }
  
  public static f iFe()
  {
    AppMethodBeat.i(110571);
    f localf;
    if ((!com.tencent.mm.kernel.h.baz()) || (!com.tencent.mm.plugin.wepkg.utils.b.XGV))
    {
      localf = new f(null);
      AppMethodBeat.o(110571);
      return localf;
    }
    if (XEO == null) {}
    try
    {
      if ((XEO == null) || (!XEO.rqI)) {
        XEO = new f(com.tencent.mm.kernel.h.baE().mCN);
      }
      localf = XEO;
      AppMethodBeat.o(110571);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(110571);
    }
  }
  
  public final boolean K(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(110582);
    if ((!this.rqI) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(110582);
      return false;
    }
    e locale = boa(paramString1);
    if (locale == null)
    {
      AppMethodBeat.o(110582);
      return false;
    }
    locale.field_bigPackageReady = paramBoolean;
    locale.field_pkgPath = paramString2;
    boolean bool = super.update(locale, new String[0]);
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    AppMethodBeat.o(110582);
    return bool;
  }
  
  public final boolean a(e parame, WePkgDiffInfo paramWePkgDiffInfo)
  {
    AppMethodBeat.i(110581);
    if ((!this.rqI) || (Util.isNullOrNil(parame.field_pkgId)))
    {
      AppMethodBeat.o(110581);
      return false;
    }
    if ((paramWePkgDiffInfo != null) && (!Util.isNullOrNil(paramWePkgDiffInfo.downloadUrl)))
    {
      Object localObject = iFe().boa(parame.field_pkgId);
      if ((localObject != null) && (y.ZC(((e)localObject).field_pkgPath)))
      {
        paramWePkgDiffInfo.mtT = ((e)localObject).field_pkgId;
        paramWePkgDiffInfo.oldVersion = ((e)localObject).field_version;
        paramWePkgDiffInfo.XFP = ((e)localObject).field_pkgPath;
        b.iFc().iP(paramWePkgDiffInfo.mtT);
        localObject = b.iFc();
        a locala = new a();
        locala.field_pkgId = paramWePkgDiffInfo.mtT;
        locala.field_oldVersion = paramWePkgDiffInfo.oldVersion;
        locala.field_oldPath = paramWePkgDiffInfo.XFP;
        locala.field_version = paramWePkgDiffInfo.version;
        locala.field_downloadUrl = paramWePkgDiffInfo.downloadUrl;
        locala.field_md5 = paramWePkgDiffInfo.md5;
        locala.field_pkgSize = paramWePkgDiffInfo.fileSize;
        locala.field_downloadNetType = paramWePkgDiffInfo.XFQ;
        ((b)localObject).insert(locala);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertDiffPkg");
      }
    }
    iFe().bnZ(parame.field_pkgId);
    d.iFd().bnZ(parame.field_pkgId);
    parame.field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.currentTime() + parame.field_checkIntervalTime);
    parame.field_createTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
    parame.field_accessTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
    boolean bool = insert(parame);
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertPkgVersion pkgid:%s, version:%s, ret:%s", new Object[] { parame.field_pkgId, parame.field_version, Boolean.valueOf(bool) });
    AppMethodBeat.o(110581);
    return bool;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110580);
    if (!this.rqI)
    {
      AppMethodBeat.o(110580);
      return false;
    }
    e locale = boa(paramString);
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
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool) });
    AppMethodBeat.o(110580);
    return bool;
  }
  
  public final boolean bnZ(String paramString)
  {
    AppMethodBeat.i(110578);
    if ((!this.rqI) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110578);
      return false;
    }
    e locale = new e();
    locale.field_pkgId = paramString;
    boolean bool = super.delete(locale, new String[0]);
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110578);
    return bool;
  }
  
  public final e boa(String paramString)
  {
    AppMethodBeat.i(110573);
    if ((!this.rqI) || (Util.isNullOrNil(paramString)))
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
      Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", new Object[] { paramString.field_pkgId, paramString.field_version });
      AppMethodBeat.o(110573);
      return paramString;
    }
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(110573);
    return null;
  }
  
  public final e bob(String paramString)
  {
    AppMethodBeat.i(110574);
    if ((!this.rqI) || (Util.isNullOrNil(paramString)))
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
      Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", new Object[] { paramString.field_pkgId, paramString.field_version, Boolean.valueOf(paramString.field_disableWvCache), Long.valueOf(paramString.field_clearPkgTime), Long.valueOf(paramString.field_checkIntervalTime), paramString.field_domain, Boolean.valueOf(paramString.field_bigPackageReady), Boolean.valueOf(paramString.field_preloadFilesReady), Boolean.valueOf(paramString.field_preloadFilesAtomic), Boolean.valueOf(paramString.field_disable) });
      paramString.field_accessTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
      super.update(paramString, new String[0]);
      AppMethodBeat.o(110574);
      return paramString;
    }
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(110574);
    return null;
  }
  
  public final boolean boc(String paramString)
  {
    AppMethodBeat.i(110579);
    if (!this.rqI)
    {
      AppMethodBeat.o(110579);
      return false;
    }
    e locale = boa(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110579);
      return false;
    }
    locale.field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.currentTime() + locale.field_checkIntervalTime);
    boolean bool = super.update(locale, new String[0]);
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110579);
    return bool;
  }
  
  public final boolean bod(String paramString)
  {
    AppMethodBeat.i(110584);
    if ((!this.rqI) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110584);
      return false;
    }
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", paramString }))) });
    AppMethodBeat.o(110584);
    return true;
  }
  
  public final boolean boe(String paramString)
  {
    AppMethodBeat.i(110585);
    if ((!this.rqI) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110585);
      return false;
    }
    e locale = boa(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110585);
      return true;
    }
    locale.field_disable = true;
    boolean bool = super.update(locale, new String[0]);
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110585);
    return bool;
  }
  
  public final boolean bof(String paramString)
  {
    AppMethodBeat.i(110586);
    if ((!this.rqI) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110586);
      return false;
    }
    e locale = boa(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110586);
      return false;
    }
    locale.field_createTime = 0L;
    boolean bool = super.update(locale, new String[0]);
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110586);
    return bool;
  }
  
  public final boolean dT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110583);
    if ((!this.rqI) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110583);
      return false;
    }
    e locale = boa(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(110583);
      return false;
    }
    locale.field_preloadFilesReady = paramBoolean;
    boolean bool = super.update(locale, new String[0]);
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    AppMethodBeat.o(110583);
    return bool;
  }
  
  public final List<String> iFf()
  {
    AppMethodBeat.i(110575);
    if (!this.rqI)
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
          if (!Util.isNullOrNil(str)) {
            localArrayList.add(str);
          }
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    AppMethodBeat.o(110575);
    return localArrayList;
  }
  
  public final List<WepkgVersion> iFg()
  {
    AppMethodBeat.i(110577);
    if (!this.rqI)
    {
      AppMethodBeat.o(110577);
      return null;
    }
    Object localObject = String.format("select * from %s where %s < ? - %s", new Object[] { "WepkgVersion", "accessTime", "clearPkgTime" });
    Cursor localCursor = rawQuery((String)localObject, new String[] { String.valueOf(com.tencent.mm.plugin.wepkg.utils.d.currentTime()) });
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", new Object[] { localObject });
    if (localCursor == null)
    {
      Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
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
      Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      AppMethodBeat.o(110577);
      return localObject;
    }
    localCursor.close();
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
    AppMethodBeat.o(110577);
    return null;
  }
  
  public final boolean iFh()
  {
    AppMethodBeat.i(110587);
    if (!this.rqI)
    {
      AppMethodBeat.o(110587);
      return false;
    }
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord clearWepkg ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgVersion", String.format("delete from %s", new Object[] { "WepkgVersion" }))) });
    Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord clearWepkg ret:%s", new Object[] { Boolean.valueOf(execSQL("WepkgPreloadFiles", String.format("delete from %s", new Object[] { "WepkgPreloadFiles" }))) });
    AppMethodBeat.o(110587);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.f
 * JD-Core Version:    0.7.0.1
 */