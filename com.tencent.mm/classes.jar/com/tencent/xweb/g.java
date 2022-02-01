package com.tencent.xweb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class g
{
  private static Map<String, Integer> kMT;
  
  static
  {
    AppMethodBeat.i(156755);
    kMT = new HashMap();
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
          int i = d.startMiniQBToLoadUrl(paramContext, paramHashMap, localHashMap, paramValueCallback);
          kMT.put(paramString3 + paramString1, Integer.valueOf(i));
          Log.i("XFilesReaderX5", "loadByMiniQB, ret = " + i + ", isSecondTime = " + String.valueOf(paramBoolean));
          a(paramString2, paramValueCallback1, i, paramInt);
          AppMethodBeat.o(156750);
          return;
        }
        catch (Exception paramContext)
        {
          Log.e("XFilesReaderX5", "loadByMiniQB jsonObject error, isSecondTime = " + String.valueOf(paramBoolean) + ", msg: " + paramContext.getMessage());
          b(paramString2, paramValueCallback1, -100001, paramInt);
          AppMethodBeat.o(156750);
        }
      }
      catch (Exception paramHashMap)
      {
        Log.e("XFilesReaderX5", "loadByMiniQB extraParams error, isSecondTime = " + String.valueOf(paramBoolean) + ", msg: " + paramHashMap.getMessage());
      }
    }
  }
  
  private static void a(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156751);
    f.b(paramString, paramInt1, false, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(paramInt1));
    AppMethodBeat.o(156751);
  }
  
  private static void b(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156752);
    f.b(paramString, paramInt1, true, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(-102));
    AppMethodBeat.o(156752);
  }
  
  public static void e(final int paramInt, final Context paramContext, final String paramString1, String paramString2, final String paramString3, boolean paramBoolean, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, final ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(156748);
    if (paramBoolean)
    {
      Log.i("XFilesReaderX5", "readFile by x5, second time, skip all report except failure, directly go to loadByMiniQB");
      a(paramContext, paramString1, paramString2, paramString3, paramInt, true, paramHashMap, paramValueCallback, paramValueCallback1);
      AppMethodBeat.o(156748);
      return;
    }
    Object localObject2 = new StringBuilder("readFile by x5, fileExt: ");
    if (paramString2 != null) {}
    for (Object localObject1 = paramString2;; localObject1 = "null")
    {
      Log.i("XFilesReaderX5", (String)localObject1);
      f.mY(paramString2, f.a.Mpk.name());
      f.hh(paramString2, paramInt);
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).putOpt("path", paramString1);
        ((JSONObject)localObject1).putOpt("ext", paramString2);
        localObject1 = ((JSONObject)localObject1).toString();
        localObject2 = paramContext.getApplicationContext();
        d.disableAutoCreateX5Webview();
        d.a((Context)localObject2, (String)localObject1, new ValueCallback() {});
        AppMethodBeat.o(156748);
        return;
      }
      catch (JSONException paramContext)
      {
        Log.e("XFilesReaderX5", "readFile jsonObject error" + paramContext.getMessage());
        b(paramString2, paramValueCallback1, -100001, paramInt);
        AppMethodBeat.o(156748);
      }
    }
  }
  
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(156749);
    try
    {
      Integer localInteger = (Integer)kMT.get(paramString1 + paramString2);
      if (localInteger == null)
      {
        AppMethodBeat.o(156749);
        return;
      }
      kMT.remove(paramString1 + paramString2);
      if (localInteger.intValue() == 0)
      {
        Log.i("XFilesReaderX5", "finishReadFile");
        d.closeFileReader(paramContext);
        AppMethodBeat.o(156749);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("XFilesReaderX5", "finishReadFile error: " + paramContext.getMessage());
      AppMethodBeat.o(156749);
      return;
    }
    Log.i("XFilesReaderX5", "finishReadFile ret != 0, skip");
    AppMethodBeat.o(156749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.g
 * JD-Core Version:    0.7.0.1
 */