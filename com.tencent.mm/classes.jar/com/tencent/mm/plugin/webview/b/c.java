package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;

public final class c
  extends j<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(5644);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "WebViewData") };
    AppMethodBeat.o(5644);
  }
  
  public c(e parame)
  {
    super(parame, a.info, "WebViewData", null);
  }
  
  static String av(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(5641);
    paramString1 = paramString1 + paramString3 + paramString2;
    AppMethodBeat.o(5641);
    return paramString1;
  }
  
  private Cursor hm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5638);
    paramString1 = String.format("select * from %s where %s=\"%s\"", new Object[] { "WebViewData", "appIdKey", hn(paramString1, paramString2) });
    ab.d("MicroMsg.WebViewDataStorage", "getData: ".concat(String.valueOf(paramString1)));
    paramString1 = rawQuery(paramString1, new String[0]);
    AppMethodBeat.o(5638);
    return paramString1;
  }
  
  static String hn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5643);
    paramString1 = paramString1 + "_" + paramString2;
    AppMethodBeat.o(5643);
    return paramString1;
  }
  
  public final void agI(String paramString)
  {
    AppMethodBeat.i(5640);
    paramString = String.format("delete from %s where %s=\"%s\"", new Object[] { "WebViewData", "appId", paramString });
    ab.d("MicroMsg.WebViewDataStorage", "cleanAllData: ".concat(String.valueOf(paramString)));
    ab.d("MicroMsg.WebViewDataStorage", "cleanAllData: ".concat(String.valueOf(execSQL("WebViewData", paramString))));
    AppMethodBeat.o(5640);
  }
  
  public final long agJ(String paramString)
  {
    AppMethodBeat.i(5642);
    paramString = String.format("select %s from %s where %s=\"%s\"", new Object[] { "size", "WebViewData", "appIdKey", av(paramString, "###@@@@TOTAL@@@###SIZE####", "_") });
    ab.d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(paramString)));
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
    ab.d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(l2)));
    AppMethodBeat.o(5642);
    return l2;
  }
  
  public final void b(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(5639);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(5639);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          String str = paramJSONArray.getString(i);
          localStringBuilder.append("\"" + hn(paramString, str) + "\",");
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.WebViewDataStorage", "clearData: " + localException.getMessage());
          }
        }
      }
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localStringBuilder.append(")");
    paramString = String.format("delete from %s where %s in %s", new Object[] { "WebViewData", "appIdKey", localStringBuilder.toString() });
    ab.d("MicroMsg.WebViewDataStorage", "deleteData: ".concat(String.valueOf(paramString)));
    ab.d("MicroMsg.WebViewDataStorage", "clearData: ".concat(String.valueOf(execSQL("WebViewData", paramString))));
    AppMethodBeat.o(5639);
  }
  
  public final a hk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5637);
    paramString1 = hm(paramString1, paramString2);
    paramString2 = new a();
    if (paramString1 != null)
    {
      if (paramString1.moveToFirst()) {
        paramString2.convertFrom(paramString1);
      }
      paramString1.close();
    }
    AppMethodBeat.o(5637);
    return paramString2;
  }
  
  public final long hl(String paramString1, String paramString2)
  {
    long l = 0L;
    AppMethodBeat.i(5636);
    paramString1 = rawQuery(String.format("select %s from %s where %s=\"%s\"", new Object[] { "size", "WebViewData", "appIdKey", hn(paramString1, paramString2) }), new String[0]);
    if (paramString1 == null)
    {
      AppMethodBeat.o(5636);
      return 0L;
    }
    if (paramString1.moveToFirst()) {
      l = paramString1.getLong(0);
    }
    paramString1.close();
    AppMethodBeat.o(5636);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.c
 * JD-Core Version:    0.7.0.1
 */