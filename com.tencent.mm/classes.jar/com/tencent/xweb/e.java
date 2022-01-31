package com.tencent.xweb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class e
{
  private static void a(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(154713);
    Log.i("FileReaderX5", "readFile by x5");
    d.iY(paramString2, d.a.BDc.name());
    d.fj(paramString2, paramInt);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).putOpt("path", paramString1);
      ((JSONObject)localObject).putOpt("ext", paramString2);
      localObject = ((JSONObject)localObject).toString();
      com.tencent.xweb.x5.sdk.d.a(ah.getContext(), (String)localObject, new e.1(paramString2, paramValueCallback1, paramContext, paramString1, paramString3, paramHashMap, paramValueCallback));
      AppMethodBeat.o(154713);
      return;
    }
    catch (JSONException paramContext)
    {
      Log.e("FileReaderX5", "readFile jsonObject error" + paramContext.getMessage());
      a(paramString2, paramValueCallback1, -102);
      AppMethodBeat.o(154713);
    }
  }
  
  static void a(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt)
  {
    AppMethodBeat.i(151407);
    if (paramInt == -102) {
      d.a(paramString, d.a.BDc);
    }
    paramValueCallback.onReceiveValue(Integer.valueOf(paramInt));
    AppMethodBeat.o(151407);
  }
  
  public static void b(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(151405);
    a(paramInt, paramContext, paramString1, paramString2, paramString3, new HashMap(), paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(151405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.e
 * JD-Core Version:    0.7.0.1
 */