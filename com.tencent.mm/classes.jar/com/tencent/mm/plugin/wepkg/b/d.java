package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public class d
  extends MAutoStorage<c>
{
  private static volatile d QLo;
  public static final String[] SQL_CREATE;
  private final com.tencent.mm.storagebase.h lvy;
  public final boolean omY;
  
  static
  {
    AppMethodBeat.i(110569);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.lqK, "WepkgPreloadFiles") };
    QLo = null;
    AppMethodBeat.o(110569);
  }
  
  private d(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, c.lqK, "WepkgPreloadFiles", c.INDEX_CREATE);
    AppMethodBeat.i(110564);
    this.lvy = paramh;
    if (paramh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.omY = bool;
      if (!this.omY) {
        Log.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(110564);
      return;
    }
  }
  
  public static d hev()
  {
    AppMethodBeat.i(110563);
    d locald;
    if (!com.tencent.mm.kernel.h.aHB())
    {
      locald = new d(null);
      AppMethodBeat.o(110563);
      return locald;
    }
    if (QLo == null) {}
    try
    {
      if ((QLo == null) || (!QLo.omY)) {
        QLo = new d(com.tencent.mm.kernel.h.aHG().kcF);
      }
      locald = QLo;
      AppMethodBeat.o(110563);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(110563);
    }
  }
  
  public final List<WepkgPreloadFile> bok(String paramString)
  {
    AppMethodBeat.i(110566);
    if ((!this.omY) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110566);
      return null;
    }
    Object localObject = String.format("select * from %s where %s=?", new Object[] { "WepkgPreloadFiles", "pkgId" });
    paramString = rawQuery((String)localObject, new String[] { paramString });
    Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", new Object[] { localObject });
    if (paramString == null)
    {
      Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
      AppMethodBeat.o(110566);
      return null;
    }
    if (paramString.moveToFirst())
    {
      localObject = new ArrayList();
      do
      {
        WepkgPreloadFile localWepkgPreloadFile = new WepkgPreloadFile();
        c localc = new c();
        localc.convertFrom(paramString);
        localWepkgPreloadFile.a(localc);
        ((List)localObject).add(localWepkgPreloadFile);
      } while (paramString.moveToNext());
      paramString.close();
      Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      AppMethodBeat.o(110566);
      return localObject;
    }
    paramString.close();
    Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
    AppMethodBeat.o(110566);
    return null;
  }
  
  public final boolean bol(String paramString)
  {
    AppMethodBeat.i(110567);
    if ((!this.omY) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110567);
      return false;
    }
    c localc = new c();
    localc.field_pkgId = paramString;
    boolean bool = super.delete(localc, new String[] { "pkgId" });
    Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110567);
    return bool;
  }
  
  public final boolean j(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(110568);
    if ((!this.omY) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110568);
      return false;
    }
    c localc = mR(paramString1, paramString2);
    if (localc == null)
    {
      AppMethodBeat.o(110568);
      return false;
    }
    localc.field_completeDownload = paramBoolean;
    localc.field_filePath = paramString3;
    boolean bool = super.update(localc, new String[0]);
    Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), paramString3, Boolean.valueOf(bool) });
    AppMethodBeat.o(110568);
    return bool;
  }
  
  public final c mR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110565);
    if ((!this.omY) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110565);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wepkg.utils.d.mY(paramString1, paramString2);
    localObject = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WepkgPreloadFiles", "key" }), new String[] { localObject });
    if (((Cursor)localObject).moveToFirst())
    {
      paramString1 = new c();
      paramString1.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", new Object[] { paramString1.field_pkgId, paramString1.field_rid, paramString1.field_version });
      AppMethodBeat.o(110565);
      return paramString1;
    }
    Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", new Object[] { paramString1, paramString2 });
    ((Cursor)localObject).close();
    AppMethodBeat.o(110565);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.d
 * JD-Core Version:    0.7.0.1
 */