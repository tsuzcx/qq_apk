package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public class d
  extends j<c>
{
  private static volatile d BHz;
  public static final String[] SQL_CREATE;
  private final h gPa;
  public final boolean jqw;
  
  static
  {
    AppMethodBeat.i(110569);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.gLr, "WepkgPreloadFiles") };
    BHz = null;
    AppMethodBeat.o(110569);
  }
  
  private d(h paramh)
  {
    super(paramh, c.gLr, "WepkgPreloadFiles", c.INDEX_CREATE);
    AppMethodBeat.i(110564);
    this.gPa = paramh;
    if (paramh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.jqw = bool;
      if (!this.jqw) {
        ad.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(110564);
      return;
    }
  }
  
  public static d etz()
  {
    AppMethodBeat.i(110563);
    d locald;
    if (!g.afw())
    {
      locald = new d(null);
      AppMethodBeat.o(110563);
      return locald;
    }
    if (BHz == null) {}
    try
    {
      if ((BHz == null) || (!BHz.jqw)) {
        BHz = new d(g.afB().gda);
      }
      locald = BHz;
      AppMethodBeat.o(110563);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(110563);
    }
  }
  
  public final List<WepkgPreloadFile> azF(String paramString)
  {
    AppMethodBeat.i(110566);
    if ((!this.jqw) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110566);
      return null;
    }
    Object localObject = String.format("select * from %s where %s=?", new Object[] { "WepkgPreloadFiles", "pkgId" });
    paramString = rawQuery((String)localObject, new String[] { paramString });
    ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", new Object[] { localObject });
    if (paramString == null)
    {
      ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
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
      ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      AppMethodBeat.o(110566);
      return localObject;
    }
    paramString.close();
    ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
    AppMethodBeat.o(110566);
    return null;
  }
  
  public final boolean azG(String paramString)
  {
    AppMethodBeat.i(110567);
    if ((!this.jqw) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110567);
      return false;
    }
    c localc = new c();
    localc.field_pkgId = paramString;
    boolean bool = super.delete(localc, new String[] { "pkgId" });
    ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(110567);
    return bool;
  }
  
  public final boolean f(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(110568);
    if ((!this.jqw) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110568);
      return false;
    }
    c localc = kq(paramString1, paramString2);
    if (localc == null)
    {
      AppMethodBeat.o(110568);
      return false;
    }
    localc.field_completeDownload = paramBoolean;
    localc.field_filePath = paramString3;
    boolean bool = super.update(localc, new String[0]);
    ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), paramString3, Boolean.valueOf(bool) });
    AppMethodBeat.o(110568);
    return bool;
  }
  
  public final c kq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110565);
    if ((!this.jqw) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110565);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wepkg.utils.d.kw(paramString1, paramString2);
    localObject = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WepkgPreloadFiles", "key" }), new String[] { localObject });
    if (((Cursor)localObject).moveToFirst())
    {
      paramString1 = new c();
      paramString1.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", new Object[] { paramString1.field_pkgId, paramString1.field_rid, paramString1.field_version });
      AppMethodBeat.o(110565);
      return paramString1;
    }
    ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", new Object[] { paramString1, paramString2 });
    ((Cursor)localObject).close();
    AppMethodBeat.o(110565);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.d
 * JD-Core Version:    0.7.0.1
 */