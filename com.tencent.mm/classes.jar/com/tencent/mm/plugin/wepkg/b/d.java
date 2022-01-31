package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public class d
  extends i<c>
{
  public static final String[] dXp = { i.a(c.dUa, "WepkgVersion") };
  private static volatile d rOd = null;
  private final h dXo;
  public final boolean gaO;
  
  private d(h paramh)
  {
    super(paramh, c.dUa, "WepkgVersion", c.cqY);
    this.dXo = paramh;
    if (paramh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.gaO = bool;
      if (!this.gaO) {
        y.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
      }
      return;
    }
  }
  
  public static d cjN()
  {
    if (!g.DK()) {
      return new d(null);
    }
    if (rOd == null) {}
    try
    {
      if ((rOd == null) || (!rOd.gaO)) {
        rOd = new d(g.DP().dKu);
      }
      return rOd;
    }
    finally {}
  }
  
  public final boolean US(String paramString)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {
      return false;
    }
    c localc = new c();
    localc.field_pkgId = paramString;
    boolean bool = super.a(localc, new String[0]);
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    return bool;
  }
  
  public final c UT(String paramString)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WepkgVersion", "pkgId" }), new String[] { paramString });
    if (localCursor.moveToFirst())
    {
      paramString = new c();
      paramString.d(localCursor);
      localCursor.close();
      y.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", new Object[] { paramString.field_pkgId, paramString.field_version });
      return paramString;
    }
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    return null;
  }
  
  public final c UU(String paramString)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[] { "WepkgVersion", "pkgId", "disable" }), new String[] { paramString });
    if (localCursor.moveToFirst())
    {
      paramString = new c();
      paramString.d(localCursor);
      localCursor.close();
      y.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", new Object[] { paramString.field_pkgId, paramString.field_version, Boolean.valueOf(paramString.field_disableWvCache), Long.valueOf(paramString.field_clearPkgTime), Long.valueOf(paramString.field_checkIntervalTime), paramString.field_domain, Boolean.valueOf(paramString.field_bigPackageReady), Boolean.valueOf(paramString.field_preloadFilesReady), Boolean.valueOf(paramString.field_preloadFilesAtomic), Boolean.valueOf(paramString.field_disable) });
      paramString.field_accessTime = com.tencent.mm.plugin.wepkg.utils.d.aqv();
      super.c(paramString, new String[0]);
      return paramString;
    }
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    return null;
  }
  
  public final boolean UV(String paramString)
  {
    if (!this.gaO) {}
    c localc;
    do
    {
      return false;
      localc = UT(paramString);
    } while (localc == null);
    localc.field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.aqv() + localc.field_checkIntervalTime);
    boolean bool = super.c(localc, new String[0]);
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean UW(String paramString)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {
      return false;
    }
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(gk("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", paramString }))) });
    return true;
  }
  
  public final boolean UX(String paramString)
  {
    boolean bool = true;
    if ((!this.gaO) || (bk.bl(paramString))) {
      bool = false;
    }
    c localc;
    do
    {
      return bool;
      localc = UT(paramString);
    } while (localc == null);
    localc.field_disable = true;
    bool = super.c(localc, new String[0]);
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean UY(String paramString)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {}
    c localc;
    do
    {
      return false;
      localc = UT(paramString);
    } while (localc == null);
    localc.field_createTime = 0L;
    boolean bool = super.c(localc, new String[0]);
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (!this.gaO) {}
    c localc;
    do
    {
      return false;
      localc = UT(paramString);
    } while (localc == null);
    localc.field_disableWvCache = paramBoolean;
    localc.field_clearPkgTime = paramLong1;
    localc.field_nextCheckTime = (localc.field_nextCheckTime - localc.field_checkIntervalTime + paramLong2);
    localc.field_checkIntervalTime = paramLong2;
    localc.field_disable = false;
    boolean bool = super.c(localc, new String[0]);
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean bv(String paramString, boolean paramBoolean)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {}
    c localc;
    do
    {
      return false;
      localc = UT(paramString);
    } while (localc == null);
    localc.field_preloadFilesReady = paramBoolean;
    boolean bool = super.c(localc, new String[0]);
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    return bool;
  }
  
  public final List<String> cjO()
  {
    Object localObject;
    if (!this.gaO) {
      localObject = null;
    }
    Cursor localCursor;
    ArrayList localArrayList;
    do
    {
      return localObject;
      localCursor = rawQuery(String.format("select %s from %s where %s < ? order by %s desc limit 10", new Object[] { "pkgId", "WepkgVersion", "nextCheckTime", "accessTime" }), new String[] { String.valueOf(com.tencent.mm.plugin.wepkg.utils.d.aqv()) });
      localArrayList = new ArrayList();
      localObject = localArrayList;
    } while (localCursor == null);
    if (localCursor.moveToFirst()) {
      do
      {
        localObject = localCursor.getString(0);
        if (!bk.bl((String)localObject)) {
          localArrayList.add(localObject);
        }
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return localArrayList;
  }
  
  public final List<WepkgVersion> cjP()
  {
    if (!this.gaO) {
      return null;
    }
    Object localObject = String.format("select * from %s where %s < ? - %s", new Object[] { "WepkgVersion", "accessTime", "clearPkgTime" });
    Cursor localCursor = rawQuery((String)localObject, new String[] { String.valueOf(com.tencent.mm.plugin.wepkg.utils.d.aqv()) });
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", new Object[] { localObject });
    if (localCursor == null)
    {
      y.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = new ArrayList();
      do
      {
        WepkgVersion localWepkgVersion = new WepkgVersion();
        c localc = new c();
        localc.d(localCursor);
        localWepkgVersion.a(localc);
        ((List)localObject).add(localWepkgVersion);
      } while (localCursor.moveToNext());
      localCursor.close();
      y.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      return localObject;
    }
    localCursor.close();
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
    return null;
  }
  
  public final boolean t(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!this.gaO) || (bk.bl(paramString1))) {}
    c localc;
    do
    {
      return false;
      localc = UT(paramString1);
    } while (localc == null);
    localc.field_bigPackageReady = paramBoolean;
    localc.field_pkgPath = paramString2;
    boolean bool = super.c(localc, new String[0]);
    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.d
 * JD-Core Version:    0.7.0.1
 */