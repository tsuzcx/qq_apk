package com.tencent.mm.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings.Global;
import com.huawei.easygo.sdk.EasyGo;
import com.huawei.easygo.sdk.module.EasyGoRet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class bh
{
  private static EasyGo hgI = null;
  private static List<Integer> xzc;
  
  public static int a(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(249395);
    int i = 0;
    try
    {
      int j = Settings.Global.getInt(paramContentResolver, "hw_fold_display_mode_prepare");
      i = j;
    }
    catch (Exception paramContentResolver)
    {
      for (;;)
      {
        Log.e("MicroMsg.huaweiUtil", "error occur");
      }
    }
    AppMethodBeat.o(249395);
    return i;
  }
  
  public static int a(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(249389);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(249389);
      return -1;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:taskId", paramInt);
      paramEasyGo = paramEasyGo.invokeSync("magicwindow", "getTaskPosition", localJSONObject, null);
      Log.i("EasyGo", paramEasyGo.code);
      paramInt = paramEasyGo.result.getInt("int");
      Log.e("EasyGo", "getTaskPosition".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(249389);
      return paramInt;
    }
    catch (JSONException paramEasyGo)
    {
      Log.e("EasyGo", paramEasyGo.getMessage());
      AppMethodBeat.o(249389);
    }
    return -1;
  }
  
  public static void a(EasyGo paramEasyGo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249390);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(249390);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:taskId", paramInt1);
      localJSONObject.put("@int:targetPosition", paramInt2);
      paramEasyGo = paramEasyGo.invokeSync("magicwindow", "setTaskPosition", localJSONObject, null);
      Log.i("EasyGo", paramEasyGo.code);
      AppMethodBeat.o(249390);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("EasyGo", localJSONException.getMessage());
      }
    }
  }
  
  public static void aAi(int paramInt)
  {
    AppMethodBeat.i(249398);
    if (hgI == null)
    {
      AppMethodBeat.o(249398);
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:loginStatus", paramInt);
      localObject = hgI.invokeSync("magicwindow", "setLoginStatus", (JSONObject)localObject, null);
      Log.i("EasyGo", " setLoginStatus ret " + ((EasyGoRet)localObject).code);
      AppMethodBeat.o(249398);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("EasyGo", localJSONException.getMessage());
      AppMethodBeat.o(249398);
    }
  }
  
  public static boolean aAj(int paramInt)
  {
    AppMethodBeat.i(249411);
    if (hgI == null)
    {
      AppMethodBeat.o(249411);
      return false;
    }
    if (a(hgI, paramInt) == 2)
    {
      AppMethodBeat.o(249411);
      return true;
    }
    AppMethodBeat.o(249411);
    return false;
  }
  
  public static boolean aAk(int paramInt)
  {
    AppMethodBeat.i(249413);
    if (hgI == null)
    {
      AppMethodBeat.o(249413);
      return false;
    }
    if (a(hgI, paramInt) == 1)
    {
      AppMethodBeat.o(249413);
      return true;
    }
    AppMethodBeat.o(249413);
    return false;
  }
  
  public static void aDU(int paramInt)
  {
    AppMethodBeat.i(249391);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:landMode", paramInt);
      localObject = hgI.invokeSync("magicwindow", "setLandScapeMode", (JSONObject)localObject, null);
      Log.i("EasyGo", " setLandscapeMode ret " + ((EasyGoRet)localObject).code + " mode: " + paramInt);
      AppMethodBeat.o(249391);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("EasyGo", localJSONException.getMessage());
      AppMethodBeat.o(249391);
    }
  }
  
  public static void aDV(int paramInt)
  {
    AppMethodBeat.i(249393);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:nightMode", paramInt);
      localObject = hgI.invokeSync("magicwindow", "setNightMode", (JSONObject)localObject, null);
      Log.i("EasyGo", " setNightMode ret " + ((EasyGoRet)localObject).code + " mode: " + paramInt);
      AppMethodBeat.o(249393);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("EasyGo", localJSONException.getMessage());
      AppMethodBeat.o(249393);
    }
  }
  
  public static boolean b(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(249403);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(249403);
      return false;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:taskId", paramInt);
      paramEasyGo = paramEasyGo.invokeSync("magicwindow", "isInMagicWindowMode", localJSONObject, null);
      Log.i("EasyGo", paramEasyGo.code);
      boolean bool = paramEasyGo.result.getBoolean("boolean");
      Log.e("EasyGo", "isInMagicWindow".concat(String.valueOf(bool)));
      AppMethodBeat.o(249403);
      return bool;
    }
    catch (JSONException paramEasyGo)
    {
      Log.e("EasyGo", paramEasyGo.getMessage());
      AppMethodBeat.o(249403);
    }
    return false;
  }
  
  public static boolean c(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(249407);
    if (a(paramEasyGo, paramInt) == -1)
    {
      AppMethodBeat.o(249407);
      return false;
    }
    AppMethodBeat.o(249407);
    return true;
  }
  
  public static EasyGo jBC()
  {
    return hgI;
  }
  
  public static boolean jjK()
  {
    AppMethodBeat.i(249384);
    boolean bool;
    if ((xzc != null) && (xzc.size() > 0))
    {
      Log.d("huaweiUtil", "dancy test retList get(0):%s", new Object[] { xzc.get(0) });
      if (((Integer)xzc.get(0)).intValue() == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.huaweiUtil", "initSucceed:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(249384);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static void mN(Context paramContext)
  {
    AppMethodBeat.i(249382);
    if (hgI == null) {
      hgI = new EasyGo(paramContext);
    }
    xzc = hgI.init(new String[] { "magicwindow" });
    AppMethodBeat.o(249382);
  }
  
  public static boolean mO(Context paramContext)
  {
    AppMethodBeat.i(249409);
    paramContext = paramContext.getResources().getConfiguration().toString();
    if ((paramContext.contains("hwMultiwindow-magic")) || (paramContext.contains("hw-magic-windows"))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.huaweiUtil", "isExpandStatus:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(249409);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bh
 * JD-Core Version:    0.7.0.1
 */