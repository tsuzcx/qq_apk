package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public final class c
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(77855);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "WebViewData") };
    AppMethodBeat.o(77855);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "WebViewData", null);
  }
  
  private static String bp(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(77851);
    paramString1 = paramString1 + paramString3 + paramString2;
    AppMethodBeat.o(77851);
    return paramString1;
  }
  
  public static String isW()
  {
    AppMethodBeat.i(294587);
    String str = com.tencent.mm.plugin.game.commlib.e.c.fEg() + "datastore/";
    AppMethodBeat.o(294587);
    return str;
  }
  
  private Cursor oe(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77847);
    paramString1 = String.format("select * from %s where %s=\"%s\"", new Object[] { "WebViewData", "appIdKey", of(paramString1, paramString2) });
    Log.d("MicroMsg.WebViewDataStorage", "getData: ".concat(String.valueOf(paramString1)));
    paramString1 = rawQuery(paramString1, new String[0]);
    AppMethodBeat.o(77847);
    return paramString1;
  }
  
  private static String of(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77854);
    paramString1 = paramString1 + "_" + paramString2;
    AppMethodBeat.o(77854);
    return paramString1;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(77844);
    a locala = new a();
    locala.field_appId = paramString1;
    locala.field_appIdKey = of(paramString1, paramString2);
    locala.field_value = paramString3;
    locala.field_weight = paramString4;
    locala.field_expireTime = (System.currentTimeMillis() / 1000L + paramLong);
    locala.field_size = (paramString2.getBytes().length + paramString3.getBytes().length);
    locala.field_timeStamp = (System.currentTimeMillis() / 1000L);
    locala.field_localFile = paramString5;
    Log.d("MicroMsg.WebViewDataStorage", "setData: ".concat(String.valueOf(replace(locala))));
    AppMethodBeat.o(77844);
  }
  
  public final void b(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(77848);
    if ((Util.isNullOrNil(paramString)) || (paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(77848);
      return;
    }
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      ((List)localObject).add(of(paramString, paramJSONArray.optString(i)));
      i += 1;
    }
    paramJSONArray = ((List)localObject).iterator();
    a locala;
    for (long l1 = 0L; paramJSONArray.hasNext(); l1 = locala.field_size + l1)
    {
      localObject = (String)paramJSONArray.next();
      locala = new a();
      locala.field_appIdKey = ((String)localObject);
      super.get(locala, new String[0]);
      if (!Util.isNullOrNil(locala.field_localFile))
      {
        bool = new u(isW() + locala.field_localFile).diJ();
        Log.i("MicroMsg.WebViewDataStorage", "clearData(), delete data file:%s, ret:%b", new Object[] { locala.field_localFile, Boolean.valueOf(bool) });
      }
      boolean bool = super.delete(locala, new String[0]);
      Log.i("MicroMsg.WebViewDataStorage", "clearData(), delete data appIdKey:%s, ret:%b", new Object[] { locala.field_appIdKey, Boolean.valueOf(bool) });
    }
    long l2 = bjA(paramString) - l1;
    Log.i("MicroMsg.WebViewDataStorage", "clearData(), currSize:%d", new Object[] { Long.valueOf(l2) });
    l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    bQ(paramString, l1);
    AppMethodBeat.o(77848);
  }
  
  public final void bQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(77850);
    a locala = new a();
    locala.field_appId = paramString;
    locala.field_appIdKey = bp(paramString, "###@@@@TOTAL@@@###SIZE####", "_");
    locala.field_expireTime = 9223372036854775807L;
    locala.field_size = paramLong;
    Log.d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", new Object[] { Boolean.valueOf(replace(locala)), Long.valueOf(paramLong) });
    AppMethodBeat.o(77850);
  }
  
  public final long bR(String paramString, long paramLong)
  {
    AppMethodBeat.i(77853);
    paramString = String.format("select * from %s where appId='%s' order by weight,timeStamp", new Object[] { "WebViewData", paramString });
    Log.d("MicroMsg.WebViewDataStorage", "deleteSize querySql: ".concat(String.valueOf(paramString)));
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      AppMethodBeat.o(77853);
      return 0L;
    }
    Object localObject1 = new LinkedList();
    Object localObject2;
    long l2;
    if (paramString.moveToFirst())
    {
      long l1 = paramLong;
      do
      {
        localObject2 = paramString.getString(1);
        l2 = paramString.getLong(6);
        ((List)localObject1).add(localObject2);
        l2 = l1 - l2;
        if (!paramString.moveToNext()) {
          break;
        }
        l1 = l2;
      } while (l2 > 0L);
    }
    for (;;)
    {
      paramString.close();
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (String)paramString.next();
        localObject2 = new a();
        ((a)localObject2).field_appIdKey = ((String)localObject1);
        super.get((IAutoDBItem)localObject2, new String[0]);
        if (!Util.isNullOrNil(((a)localObject2).field_localFile))
        {
          bool = new u(isW() + ((a)localObject2).field_localFile).diJ();
          Log.i("MicroMsg.WebViewDataStorage", "deleteSize(), delete data file:%s, size:%d, ret:%b", new Object[] { ((a)localObject2).field_localFile, Long.valueOf(((a)localObject2).field_size), Boolean.valueOf(bool) });
        }
        boolean bool = super.delete((IAutoDBItem)localObject2, new String[0]);
        Log.i("MicroMsg.WebViewDataStorage", "deleteSize(), delete data appIdKey:%s, size:%d, ret:%b", new Object[] { ((a)localObject2).field_appIdKey, Long.valueOf(((a)localObject2).field_size), Boolean.valueOf(bool) });
      }
      AppMethodBeat.o(77853);
      return paramLong - l2;
      l2 = paramLong;
    }
  }
  
  public final long bjA(String paramString)
  {
    AppMethodBeat.i(77852);
    paramString = String.format("select %s from %s where %s=\"%s\"", new Object[] { "size", "WebViewData", "appIdKey", bp(paramString, "###@@@@TOTAL@@@###SIZE####", "_") });
    Log.d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(paramString)));
    long l1 = 0L;
    paramString = rawQuery(paramString, new String[0]);
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.moveToFirst()) {
        l1 = paramString.getLong(0);
      }
      paramString.close();
      l2 = l1;
    }
    Log.d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(l2)));
    AppMethodBeat.o(77852);
    return l2;
  }
  
  public final void bjz(String paramString)
  {
    AppMethodBeat.i(77849);
    paramString = rawQuery(String.format("select * from %s where %s=\"%s\"", new Object[] { "WebViewData", "appId", paramString }), new String[0]);
    if (paramString != null)
    {
      if (paramString.moveToFirst()) {
        do
        {
          a locala = new a();
          locala.convertFrom(paramString);
          if (!Util.isNullOrNil(locala.field_localFile))
          {
            bool = new u(isW() + locala.field_localFile).diJ();
            Log.i("MicroMsg.WebViewDataStorage", "clearAllData(), delete data file:%s, ret:%b", new Object[] { locala.field_localFile, Boolean.valueOf(bool) });
          }
          boolean bool = super.delete(locala, new String[0]);
          Log.i("MicroMsg.WebViewDataStorage", "clearAllData(), delete data appIdKey:%s, ret:%b", new Object[] { locala.field_appIdKey, Boolean.valueOf(bool) });
        } while (paramString.moveToNext());
      }
      paramString.close();
    }
    AppMethodBeat.o(77849);
  }
  
  public final a oc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77846);
    paramString1 = oe(paramString1, paramString2);
    paramString2 = new a();
    if (paramString1 != null)
    {
      if (paramString1.moveToFirst()) {
        paramString2.convertFrom(paramString1);
      }
      paramString1.close();
    }
    AppMethodBeat.o(77846);
    return paramString2;
  }
  
  public final long od(String paramString1, String paramString2)
  {
    long l = 0L;
    AppMethodBeat.i(77845);
    paramString1 = rawQuery(String.format("select %s from %s where %s=\"%s\"", new Object[] { "size", "WebViewData", "appIdKey", of(paramString1, paramString2) }), new String[0]);
    if (paramString1 == null)
    {
      AppMethodBeat.o(77845);
      return 0L;
    }
    if (paramString1.moveToFirst()) {
      l = paramString1.getLong(0);
    }
    paramString1.close();
    AppMethodBeat.o(77845);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.c
 * JD-Core Version:    0.7.0.1
 */