package com.tencent.mm.plugin.secdata.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/model/SecDataDB;", "", "dbFilePath", "", "(Ljava/lang/String;)V", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "close", "", "collectFinderDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "execSQL", "tableName", "sql", "getDB", "getTableCount", "isTableExist", "", "plugin-sec-data_release"})
public final class a
{
  public final String TAG;
  public h iFy;
  
  public a(String paramString)
  {
    AppMethodBeat.i(219172);
    this.TAG = "MicroMsg.SecData.SecDataDB";
    long l1 = System.currentTimeMillis();
    this.iFy = new h();
    h localh = this.iFy;
    if (localh != null)
    {
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put(Integer.valueOf("SecReportDataInfo".hashCode()), a.CWi);
      if (!localh.a(paramString, localHashMap, true))
      {
        paramString = (Throwable)new RuntimeException("Create SecDataDB Fail!");
        AppMethodBeat.o(219172);
        throw paramString;
      }
    }
    long l2 = System.currentTimeMillis();
    Log.i(this.TAG, "initDB index params %d %s %s", new Object[] { Long.valueOf(l2 - l1), Util.getSizeMB(s.boW(paramString), 100.0D), paramString });
    AppMethodBeat.o(219172);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class a
    implements h.b
  {
    public static final a CWi;
    
    static
    {
      AppMethodBeat.i(219171);
      CWi = new a();
      AppMethodBeat.o(219171);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(219170);
      Object localObject = d.CWm;
      localObject = d.eSq();
      AppMethodBeat.o(219170);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.a.a
 * JD-Core Version:    0.7.0.1
 */