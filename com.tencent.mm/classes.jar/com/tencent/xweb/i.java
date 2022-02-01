package com.tencent.xweb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class i
{
  private static Map<String, Integer> rXP;
  
  static
  {
    AppMethodBeat.i(156755);
    rXP = new HashMap();
    AppMethodBeat.o(156755);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(156750);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("local", "true");
    localHashMap.put("style", "1");
    if (paramHashMap != null) {
      try
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramHashMap.next();
          localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        try
        {
          paramHashMap = new JSONObject();
          paramHashMap.put("path", paramString1);
          paramHashMap.put("ext", paramString2);
          paramHashMap.put("token", paramString3);
          paramHashMap = paramHashMap.toString();
          int i = e.startMiniQBToLoadUrl(paramContext, paramHashMap, localHashMap, paramValueCallback);
          rXP.put(paramString3 + paramString1, Integer.valueOf(i));
          Log.i("FileReaderX5", "loadByMiniQB, ret = " + i + ", isSecondTime = " + String.valueOf(paramBoolean));
          a(paramString2, paramValueCallback1, i, paramInt);
          AppMethodBeat.o(156750);
          return;
        }
        finally
        {
          Log.e("FileReaderX5", "loadByMiniQB jsonObject error, isSecondTime = " + String.valueOf(paramBoolean) + ", msg: " + paramContext.getMessage());
          b(paramString2, paramValueCallback1, -100001, paramInt);
          AppMethodBeat.o(156750);
        }
      }
      finally
      {
        Log.e("FileReaderX5", "loadByMiniQB extraParams error, isSecondTime = " + String.valueOf(paramBoolean) + ", msg: " + paramHashMap.getMessage());
      }
    }
  }
  
  private static void a(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156751);
    h.b(paramString, paramInt1, false, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(paramInt1));
    AppMethodBeat.o(156751);
  }
  
  private static void b(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156752);
    h.b(paramString, paramInt1, true, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(-102));
    AppMethodBeat.o(156752);
  }
  
  public static void e(final int paramInt, final Context paramContext, final String paramString1, String paramString2, final String paramString3, boolean paramBoolean, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, final ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(156748);
    if (paramBoolean)
    {
      Log.i("FileReaderX5", "readFile by x5, second time, skip all report except failure, directly go to loadByMiniQB");
      a(paramContext, paramString1, paramString2, paramString3, paramInt, true, paramHashMap, paramValueCallback, paramValueCallback1);
      AppMethodBeat.o(156748);
      return;
    }
    Object localObject2 = new StringBuilder("readFile by x5, fileExt: ");
    if (paramString2 != null) {}
    for (Object localObject1 = paramString2;; localObject1 = "null")
    {
      Log.i("FileReaderX5", (String)localObject1);
      h.qR(paramString2, h.a.aiev.name());
      h.jH(paramString2, paramInt);
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).putOpt("path", paramString1);
        ((JSONObject)localObject1).putOpt("ext", paramString2);
        localObject1 = ((JSONObject)localObject1).toString();
        localObject2 = paramContext.getApplicationContext();
        e.disableAutoCreateX5Webview();
        e.a((Context)localObject2, (String)localObject1, new ValueCallback() {});
        AppMethodBeat.o(156748);
        return;
      }
      catch (JSONException paramContext)
      {
        Log.e("FileReaderX5", "readFile jsonObject error" + paramContext.getMessage());
        b(paramString2, paramValueCallback1, -100001, paramInt);
        AppMethodBeat.o(156748);
      }
    }
  }
  
  public static void t(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(156749);
    try
    {
      Integer localInteger = (Integer)rXP.get(paramString1 + paramString2);
      if (localInteger == null)
      {
        AppMethodBeat.o(156749);
        return;
      }
      rXP.remove(paramString1 + paramString2);
      if (localInteger.intValue() == 0)
      {
        Log.i("FileReaderX5", "finishReadFile");
        e.closeFileReader(paramContext);
        AppMethodBeat.o(156749);
        return;
      }
    }
    finally
    {
      Log.e("FileReaderX5", "finishReadFile error:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(156749);
      return;
    }
    Log.i("FileReaderX5", "finishReadFile ret != 0, skip");
    AppMethodBeat.o(156749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.i
 * JD-Core Version:    0.7.0.1
 */