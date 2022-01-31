package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.dUa, "WepkgPreloadFiles") };
  private static volatile b rOc = null;
  private final h dXo;
  public final boolean gaO;
  
  private b(h paramh)
  {
    super(paramh, a.dUa, "WepkgPreloadFiles", a.cqY);
    this.dXo = paramh;
    if (paramh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.gaO = bool;
      if (!this.gaO) {
        y.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
      }
      return;
    }
  }
  
  public static b cjM()
  {
    if (!g.DK()) {
      return new b(null);
    }
    if (rOc == null) {}
    try
    {
      if ((rOc == null) || (!rOc.gaO)) {
        rOc = new b(g.DP().dKu);
      }
      return rOc;
    }
    finally {}
  }
  
  public final List<WepkgPreloadFile> UR(String paramString)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {
      return null;
    }
    Object localObject = String.format("select * from %s where %s=?", new Object[] { "WepkgPreloadFiles", "pkgId" });
    paramString = rawQuery((String)localObject, new String[] { paramString });
    y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", new Object[] { localObject });
    if (paramString == null)
    {
      y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
      return null;
    }
    if (paramString.moveToFirst())
    {
      localObject = new ArrayList();
      do
      {
        WepkgPreloadFile localWepkgPreloadFile = new WepkgPreloadFile();
        a locala = new a();
        locala.d(paramString);
        localWepkgPreloadFile.a(locala);
        ((List)localObject).add(localWepkgPreloadFile);
      } while (paramString.moveToNext());
      paramString.close();
      y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      return localObject;
    }
    paramString.close();
    y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
    return null;
  }
  
  public final boolean US(String paramString)
  {
    if ((!this.gaO) || (bk.bl(paramString))) {
      return false;
    }
    a locala = new a();
    locala.field_pkgId = paramString;
    boolean bool = super.a(locala, new String[] { "pkgId" });
    y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    return bool;
  }
  
  public final a fK(String paramString1, String paramString2)
  {
    if ((!this.gaO) || (bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return null;
    }
    Object localObject = d.fO(paramString1, paramString2);
    localObject = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WepkgPreloadFiles", "key" }), new String[] { localObject });
    if (((Cursor)localObject).moveToFirst())
    {
      paramString1 = new a();
      paramString1.d((Cursor)localObject);
      ((Cursor)localObject).close();
      y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", new Object[] { paramString1.field_pkgId, paramString1.field_rid, paramString1.field_version });
      return paramString1;
    }
    y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", new Object[] { paramString1, paramString2 });
    ((Cursor)localObject).close();
    return null;
  }
  
  public final boolean g(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!this.gaO) || (bk.bl(paramString1)) || (bk.bl(paramString2))) {}
    a locala;
    do
    {
      return false;
      locala = fK(paramString1, paramString2);
    } while (locala == null);
    locala.field_completeDownload = paramBoolean;
    locala.field_filePath = paramString3;
    boolean bool = super.c(locala, new String[0]);
    y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), paramString3, Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.b
 * JD-Core Version:    0.7.0.1
 */