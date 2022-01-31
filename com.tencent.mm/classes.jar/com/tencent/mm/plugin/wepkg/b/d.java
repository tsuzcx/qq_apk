package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private static volatile d vEN;
  private final h fnw;
  public final boolean hsO;
  
  static
  {
    AppMethodBeat.i(63398);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.fkk, "WepkgPreloadFiles") };
    vEN = null;
    AppMethodBeat.o(63398);
  }
  
  private d(h paramh)
  {
    super(paramh, c.fkk, "WepkgPreloadFiles", c.INDEX_CREATE);
    AppMethodBeat.i(63393);
    this.fnw = paramh;
    if (paramh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.hsO = bool;
      if (!this.hsO) {
        ab.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(63393);
      return;
    }
  }
  
  public static d dkp()
  {
    AppMethodBeat.i(63392);
    d locald;
    if (!g.RG())
    {
      locald = new d(null);
      AppMethodBeat.o(63392);
      return locald;
    }
    if (vEN == null) {}
    try
    {
      if ((vEN == null) || (!vEN.hsO)) {
        vEN = new d(g.RL().eHS);
      }
      locald = vEN;
      AppMethodBeat.o(63392);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(63392);
    }
  }
  
  public final List<WepkgPreloadFile> akm(String paramString)
  {
    AppMethodBeat.i(63395);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63395);
      return null;
    }
    Object localObject = String.format("select * from %s where %s=?", new Object[] { "WepkgPreloadFiles", "pkgId" });
    paramString = rawQuery((String)localObject, new String[] { paramString });
    ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", new Object[] { localObject });
    if (paramString == null)
    {
      ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
      AppMethodBeat.o(63395);
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
      ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      AppMethodBeat.o(63395);
      return localObject;
    }
    paramString.close();
    ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
    AppMethodBeat.o(63395);
    return null;
  }
  
  public final boolean akn(String paramString)
  {
    AppMethodBeat.i(63396);
    if ((!this.hsO) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63396);
      return false;
    }
    c localc = new c();
    localc.field_pkgId = paramString;
    boolean bool = super.delete(localc, new String[] { "pkgId" });
    ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(63396);
    return bool;
  }
  
  public final boolean g(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(63397);
    if ((!this.hsO) || (bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(63397);
      return false;
    }
    c localc = hK(paramString1, paramString2);
    if (localc == null)
    {
      AppMethodBeat.o(63397);
      return false;
    }
    localc.field_completeDownload = paramBoolean;
    localc.field_filePath = paramString3;
    boolean bool = super.update(localc, new String[0]);
    ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), paramString3, Boolean.valueOf(bool) });
    AppMethodBeat.o(63397);
    return bool;
  }
  
  public final c hK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63394);
    if ((!this.hsO) || (bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(63394);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wepkg.utils.d.hQ(paramString1, paramString2);
    localObject = rawQuery(String.format("select * from %s where %s=?", new Object[] { "WepkgPreloadFiles", "key" }), new String[] { localObject });
    if (((Cursor)localObject).moveToFirst())
    {
      paramString1 = new c();
      paramString1.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", new Object[] { paramString1.field_pkgId, paramString1.field_rid, paramString1.field_version });
      AppMethodBeat.o(63394);
      return paramString1;
    }
    ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", new Object[] { paramString1, paramString2 });
    ((Cursor)localObject).close();
    AppMethodBeat.o(63394);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.d
 * JD-Core Version:    0.7.0.1
 */