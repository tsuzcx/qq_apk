package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.huawei.easygo.sdk.EasyGo;
import com.huawei.easygo.sdk.module.EasyGoRet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class az
{
  private static EasyGo easyGoManager = null;
  private static List<Integer> usF;
  
  public static int a(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(194755);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(194755);
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
      AppMethodBeat.o(194755);
      return paramInt;
    }
    catch (JSONException paramEasyGo)
    {
      Log.e("EasyGo", paramEasyGo.getMessage());
      AppMethodBeat.o(194755);
    }
    return -1;
  }
  
  public static void a(EasyGo paramEasyGo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194760);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(194760);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:taskId", paramInt1);
      localJSONObject.put("@int:targetPosition", paramInt2);
      paramEasyGo = paramEasyGo.invokeSync("magicwindow", "setTaskPosition", localJSONObject, null);
      Log.i("EasyGo", paramEasyGo.code);
      AppMethodBeat.o(194760);
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
  
  public static void atQ(int paramInt)
  {
    AppMethodBeat.i(194766);
    if (easyGoManager == null)
    {
      AppMethodBeat.o(194766);
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:loginStatus", paramInt);
      localObject = easyGoManager.invokeSync("magicwindow", "setLoginStatus", (JSONObject)localObject, null);
      Log.i("EasyGo", " setLoginStatus ret " + ((EasyGoRet)localObject).code);
      AppMethodBeat.o(194766);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("EasyGo", localJSONException.getMessage());
      AppMethodBeat.o(194766);
    }
  }
  
  public static boolean atR(int paramInt)
  {
    AppMethodBeat.i(194772);
    if (easyGoManager == null)
    {
      AppMethodBeat.o(194772);
      return false;
    }
    if (a(easyGoManager, paramInt) == 2)
    {
      AppMethodBeat.o(194772);
      return true;
    }
    AppMethodBeat.o(194772);
    return false;
  }
  
  public static boolean b(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(293135);
    if (a(paramEasyGo, paramInt) == -1)
    {
      AppMethodBeat.o(293135);
      return false;
    }
    AppMethodBeat.o(293135);
    return true;
  }
  
  public static boolean hHA()
  {
    boolean bool2 = false;
    AppMethodBeat.i(194751);
    boolean bool1 = bool2;
    if (usF != null)
    {
      bool1 = bool2;
      if (usF.size() > 0)
      {
        Log.d("huaweiUtil", "dancy test retList get(0):%s", new Object[] { usF.get(0) });
        if (((Integer)usF.get(0)).intValue() != 0) {
          break label78;
        }
      }
    }
    label78:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(194751);
      return bool1;
    }
  }
  
  public static EasyGo hXf()
  {
    return easyGoManager;
  }
  
  public static void kK(Context paramContext)
  {
    AppMethodBeat.i(194749);
    if (easyGoManager == null) {
      easyGoManager = new EasyGo(paramContext);
    }
    usF = easyGoManager.init(new String[] { "magicwindow" });
    AppMethodBeat.o(194749);
  }
  
  public static boolean kL(Context paramContext)
  {
    AppMethodBeat.i(194768);
    paramContext = paramContext.getResources().getConfiguration().toString();
    if ((paramContext.contains("hwMultiwindow-magic")) || (paramContext.contains("hw-magic-windows")))
    {
      AppMethodBeat.o(194768);
      return true;
    }
    AppMethodBeat.o(194768);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.az
 * JD-Core Version:    0.7.0.1
 */