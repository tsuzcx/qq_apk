package com.tencent.mm.pluginsdk.res.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.at;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public final class s
  extends MAutoStorage<r>
{
  private static final String[] SQL_CREATE;
  private static final String XWZ;
  private static final HashMap<Integer, h.b> XXa;
  private final HashMap<String, Object> XXb;
  public final h omV;
  
  static
  {
    AppMethodBeat.i(152080);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(r.info, "ResDownloaderRecordTable") };
    XWZ = at.acHq + com.tencent.mm.b.g.getMessageDigest(String.format(Locale.ENGLISH, "mm%d", new Object[] { Integer.valueOf(-2147483648) }).getBytes()) + "/";
    Object localObject = new HashMap();
    XXa = (HashMap)localObject;
    ((HashMap)localObject).put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(152072);
        String[] arrayOfString = s.iJN();
        AppMethodBeat.o(152072);
        return arrayOfString;
      }
    });
    localObject = q.iJL().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((g)((Iterator)localObject).next()).iJj() != null)
      {
        AppMethodBeat.o(152080);
        throw null;
      }
    }
    AppMethodBeat.o(152080);
  }
  
  private s(h paramh)
  {
    super(paramh, r.info, "ResDownloaderRecordTable", null);
    AppMethodBeat.i(152073);
    this.XXb = new HashMap();
    this.omV = paramh;
    paramh = q.iJL().iterator();
    while (paramh.hasNext()) {
      if (((g)paramh.next()).iJj() != null)
      {
        AppMethodBeat.o(152073);
        throw null;
      }
    }
    AppMethodBeat.o(152073);
  }
  
  static s iJM()
  {
    AppMethodBeat.i(152074);
    try
    {
      new File(XWZ).mkdirs();
      Object localObject = new h();
      String str1 = XWZ + "ResDown.db";
      String str2 = XWZ + "EnResDown.db";
      com.tencent.mm.compatible.deviceinfo.q.eD(true);
      if (!((h)localObject).a(str1, str2, -2147483648L, XXa))
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
  
  public final r bqq(String paramString)
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
      if ((this.omV == null) || (!this.omV.isOpen())) {
        bool1 = true;
      }
      Log.e("MicroMsg.ResDownloaderStorage", "query with urlKey[%s], db.isClose[%s], dbFile.exists[%b], e=%s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(new File(XWZ + "EnResDown.db").exists()), localSQLiteDatabaseCorruptException });
      AppMethodBeat.o(152078);
      return null;
    }
    catch (android.database.sqlite.SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException1)
    {
      label83:
      break label83;
    }
  }
  
  /* Error */
  public final java.util.List<r> bqr(String paramString)
  {
    // Byte code:
    //   0: ldc 251
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 155	com/tencent/mm/pluginsdk/res/downloader/model/s:omV	Lcom/tencent/mm/storagebase/h;
    //   9: ldc 39
    //   11: aconst_null
    //   12: getstatic 65	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   15: ldc 253
    //   17: iconst_1
    //   18: anewarray 69	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: ldc 255
    //   25: aastore
    //   26: invokestatic 80	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   29: iconst_1
    //   30: anewarray 31	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: aload_1
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 259	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +21 -> 66
    //   48: aload_3
    //   49: invokeinterface 264 1 0
    //   54: ifne +12 -> 66
    //   57: aload_3
    //   58: invokeinterface 267 1 0
    //   63: ifne +26 -> 89
    //   66: invokestatic 273	java/util/Collections:emptyList	()Ljava/util/List;
    //   69: astore 4
    //   71: aload_3
    //   72: ifnull +9 -> 81
    //   75: aload_3
    //   76: invokeinterface 276 1 0
    //   81: ldc 251
    //   83: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload 4
    //   88: areturn
    //   89: new 278	java/util/LinkedList
    //   92: dup
    //   93: invokespecial 279	java/util/LinkedList:<init>	()V
    //   96: astore 4
    //   98: new 33	com/tencent/mm/pluginsdk/res/downloader/model/r
    //   101: dup
    //   102: invokespecial 225	com/tencent/mm/pluginsdk/res/downloader/model/r:<init>	()V
    //   105: astore 5
    //   107: aload 5
    //   109: aload_3
    //   110: invokevirtual 283	com/tencent/mm/pluginsdk/res/downloader/model/r:convertFrom	(Landroid/database/Cursor;)V
    //   113: aload 4
    //   115: aload 5
    //   117: invokeinterface 289 2 0
    //   122: pop
    //   123: aload_3
    //   124: invokeinterface 292 1 0
    //   129: istore_2
    //   130: iload_2
    //   131: ifne -33 -> 98
    //   134: aload_3
    //   135: ifnull +9 -> 144
    //   138: aload_3
    //   139: invokeinterface 276 1 0
    //   144: ldc 251
    //   146: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 4
    //   151: areturn
    //   152: astore 4
    //   154: aload_3
    //   155: ifnull +9 -> 164
    //   158: aload_3
    //   159: invokeinterface 276 1 0
    //   164: ldc 251
    //   166: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload 4
    //   171: athrow
    //   172: astore_3
    //   173: ldc 189
    //   175: ldc_w 294
    //   178: iconst_2
    //   179: anewarray 69	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_1
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: aload_3
    //   189: aastore
    //   190: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: invokestatic 273	java/util/Collections:emptyList	()Ljava/util/List;
    //   196: astore_1
    //   197: ldc 251
    //   199: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_1
    //   203: areturn
    //   204: astore_3
    //   205: aload 4
    //   207: aload_3
    //   208: invokevirtual 300	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   211: goto -47 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	s
    //   0	214	1	paramString	String
    //   129	2	2	bool	boolean
    //   43	116	3	localCursor	android.database.Cursor
    //   172	17	3	localException	Exception
    //   204	4	3	localThrowable	java.lang.Throwable
    //   69	81	4	localObject1	Object
    //   152	54	4	localObject2	Object
    //   105	11	5	localr	r
    // Exception table:
    //   from	to	target	type
    //   48	66	152	finally
    //   66	71	152	finally
    //   89	98	152	finally
    //   98	130	152	finally
    //   5	44	172	java/lang/Exception
    //   75	81	172	java/lang/Exception
    //   138	144	172	java/lang/Exception
    //   164	172	172	java/lang/Exception
    //   205	211	172	java/lang/Exception
    //   158	164	204	finally
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
  
  public final boolean iP(String paramString)
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
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.s
 * JD-Core Version:    0.7.0.1
 */