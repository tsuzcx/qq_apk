package com.tencent.mm.pluginsdk.j.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public final class t
  extends j<s>
{
  private static final String Fjx;
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, h.b> Fjy;
  private static final String[] SQL_CREATE;
  private final HashMap<String, Object> Fjz;
  public final h hKK;
  
  static
  {
    AppMethodBeat.i(152080);
    SQL_CREATE = new String[] { j.getCreateSQLs(s.info, "ResDownloaderRecordTable") };
    Fjx = am.IKh + g.getMessageDigest(String.format(Locale.ENGLISH, "mm%d", new Object[] { Integer.valueOf(-2147483648) }).getBytes()) + "/";
    Object localObject = new HashMap();
    Fjy = (HashMap)localObject;
    ((HashMap)localObject).put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(152072);
        String[] arrayOfString = t.feT();
        AppMethodBeat.o(152072);
        return arrayOfString;
      }
    });
    localObject = r.feR().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(152080);
  }
  
  private t(h paramh)
  {
    super(paramh, s.info, "ResDownloaderRecordTable", null);
    AppMethodBeat.i(152073);
    this.Fjz = new HashMap();
    this.hKK = paramh;
    paramh = r.feR().iterator();
    while (paramh.hasNext()) {
      paramh.next();
    }
    AppMethodBeat.o(152073);
  }
  
  static t feS()
  {
    AppMethodBeat.i(152074);
    try
    {
      new File(Fjx).mkdirs();
      Object localObject = new h();
      String str1 = Fjx + "ResDown.db";
      String str2 = Fjx + "EnResDown.db";
      q.cH(true);
      if (!((h)localObject).a(str1, str2, -2147483648L, Fjy))
      {
        ae.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
        AppMethodBeat.o(152074);
        return null;
      }
      localObject = new t((h)localObject);
      AppMethodBeat.o(152074);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", new Object[] { localException });
      AppMethodBeat.o(152074);
    }
    return null;
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(152075);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
      AppMethodBeat.o(152075);
      return false;
    }
    s locals = new s();
    locals.field_urlKey_hashcode = paramString.hashCode();
    boolean bool = super.delete(locals, new String[] { "urlKey_hashcode" });
    AppMethodBeat.o(152075);
    return bool;
  }
  
  public final s aNE(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(152078);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
      AppMethodBeat.o(152078);
      return null;
    }
    s locals = new s();
    locals.field_urlKey_hashcode = paramString.hashCode();
    try
    {
      boolean bool2 = super.get(locals, new String[] { "urlKey_hashcode" });
      if (bool2)
      {
        AppMethodBeat.o(152078);
        return locals;
      }
      AppMethodBeat.o(152078);
      return null;
    }
    catch (com.tencent.wcdb.database.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      if ((this.hKK == null) || (!this.hKK.isOpen())) {
        bool1 = true;
      }
      ae.e("MicroMsg.ResDownloaderStorage", "query with urlKey[%s], db.isClose[%s], dbFile.exists[%b], e=%s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(new File(Fjx + "EnResDown.db").exists()), localSQLiteDatabaseCorruptException });
      AppMethodBeat.o(152078);
      return null;
    }
    catch (android.database.sqlite.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException1)
    {
      label83:
      break label83;
    }
  }
  
  public final boolean i(s params)
  {
    AppMethodBeat.i(152076);
    if (bu.isNullOrNil(params.field_urlKey))
    {
      AppMethodBeat.o(152076);
      return false;
    }
    params.field_urlKey_hashcode = params.field_urlKey.hashCode();
    boolean bool = super.update(params, new String[] { "urlKey_hashcode" });
    AppMethodBeat.o(152076);
    return bool;
  }
  
  public final boolean j(s params)
  {
    AppMethodBeat.i(152077);
    if (bu.isNullOrNil(params.field_urlKey))
    {
      AppMethodBeat.o(152077);
      return false;
    }
    params.field_urlKey_hashcode = params.field_urlKey.hashCode();
    boolean bool = super.insert(params);
    AppMethodBeat.o(152077);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.t
 * JD-Core Version:    0.7.0.1
 */