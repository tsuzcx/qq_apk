package com.tencent.mm.pluginsdk.k.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public class s
  extends MAutoStorage<r>
{
  private static final String RaT;
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, h.b> RaU;
  private static final String[] SQL_CREATE;
  private final HashMap<String, Object> RaV;
  public final h lvy;
  
  static
  {
    AppMethodBeat.i(152080);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(r.info, "ResDownloaderRecordTable") };
    RaT = ar.Vgb + g.getMessageDigest(String.format(Locale.ENGLISH, "mm%d", new Object[] { Integer.valueOf(-2147483648) }).getBytes()) + "/";
    Object localObject = new HashMap();
    RaU = (HashMap)localObject;
    ((HashMap)localObject).put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(152072);
        String[] arrayOfString = s.hiN();
        AppMethodBeat.o(152072);
        return arrayOfString;
      }
    });
    localObject = q.hiL().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(152080);
  }
  
  private s(h paramh)
  {
    super(paramh, r.info, "ResDownloaderRecordTable", null);
    AppMethodBeat.i(152073);
    this.RaV = new HashMap();
    this.lvy = paramh;
    paramh = q.hiL().iterator();
    while (paramh.hasNext()) {
      paramh.next();
    }
    AppMethodBeat.o(152073);
  }
  
  static s hiM()
  {
    AppMethodBeat.i(152074);
    try
    {
      new File(RaT).mkdirs();
      Object localObject = new h();
      String str1 = RaT + "ResDown.db";
      String str2 = RaT + "EnResDown.db";
      com.tencent.mm.compatible.deviceinfo.q.dR(true);
      if (!((h)localObject).a(str1, str2, -2147483648L, RaU))
      {
        Log.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
        AppMethodBeat.o(152074);
        return null;
      }
      localObject = new s((h)localObject);
      AppMethodBeat.o(152074);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", new Object[] { localException });
      AppMethodBeat.o(152074);
    }
    return null;
  }
  
  public final r bqC(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(152078);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
      AppMethodBeat.o(152078);
      return null;
    }
    r localr = new r();
    localr.field_urlKey_hashcode = paramString.hashCode();
    try
    {
      boolean bool2 = super.get(localr, new String[] { "urlKey_hashcode" });
      if (bool2)
      {
        AppMethodBeat.o(152078);
        return localr;
      }
      AppMethodBeat.o(152078);
      return null;
    }
    catch (com.tencent.wcdb.database.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      if ((this.lvy == null) || (!this.lvy.isOpen())) {
        bool1 = true;
      }
      Log.e("MicroMsg.ResDownloaderStorage", "query with urlKey[%s], db.isClose[%s], dbFile.exists[%b], e=%s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(new File(RaT + "EnResDown.db").exists()), localSQLiteDatabaseCorruptException });
      AppMethodBeat.o(152078);
      return null;
    }
    catch (android.database.sqlite.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException1)
    {
      label83:
      break label83;
    }
  }
  
  public final boolean ho(String paramString)
  {
    AppMethodBeat.i(152075);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
      AppMethodBeat.o(152075);
      return false;
    }
    r localr = new r();
    localr.field_urlKey_hashcode = paramString.hashCode();
    boolean bool = super.delete(localr, new String[] { "urlKey_hashcode" });
    AppMethodBeat.o(152075);
    return bool;
  }
  
  public final boolean i(r paramr)
  {
    AppMethodBeat.i(152076);
    if (Util.isNullOrNil(paramr.field_urlKey))
    {
      AppMethodBeat.o(152076);
      return false;
    }
    paramr.field_urlKey_hashcode = paramr.field_urlKey.hashCode();
    boolean bool = super.update(paramr, new String[] { "urlKey_hashcode" });
    AppMethodBeat.o(152076);
    return bool;
  }
  
  public final boolean j(r paramr)
  {
    AppMethodBeat.i(152077);
    if (Util.isNullOrNil(paramr.field_urlKey))
    {
      AppMethodBeat.o(152077);
      return false;
    }
    paramr.field_urlKey_hashcode = paramr.field_urlKey.hashCode();
    boolean bool = super.insert(paramr);
    AppMethodBeat.o(152077);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.s
 * JD-Core Version:    0.7.0.1
 */