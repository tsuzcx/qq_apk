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

public final class aw
{
  private static EasyGo easyGoManager = null;
  private static List<Integer> qQz;
  
  public static int a(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(205309);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(205309);
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
      AppMethodBeat.o(205309);
      return paramInt;
    }
    catch (JSONException paramEasyGo)
    {
      Log.e("EasyGo", paramEasyGo.getMessage());
      AppMethodBeat.o(205309);
    }
    return -1;
  }
  
  public static void a(EasyGo paramEasyGo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205310);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(205310);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:taskId", paramInt1);
      localJSONObject.put("@int:targetPosition", paramInt2);
      paramEasyGo = paramEasyGo.invokeSync("magicwindow", "setTaskPosition", localJSONObject, null);
      Log.i("EasyGo", paramEasyGo.code);
      AppMethodBeat.o(205310);
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
  
  public static void aoh(int paramInt)
  {
    AppMethodBeat.i(205311);
    if (easyGoManager == null)
    {
      AppMethodBeat.o(205311);
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:loginStatus", paramInt);
      localObject = easyGoManager.invokeSync("magicwindow", "setLoginStatus", (JSONObject)localObject, null);
      Log.i("EasyGo", " setLoginStatus ret " + ((EasyGoRet)localObject).code);
      AppMethodBeat.o(205311);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("EasyGo", localJSONException.getMessage());
      AppMethodBeat.o(205311);
    }
  }
  
  public static boolean b(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(205312);
    if (a(paramEasyGo, paramInt) == -1)
    {
      AppMethodBeat.o(205312);
      return false;
    }
    AppMethodBeat.o(205312);
    return true;
  }
  
  public static boolean gWx()
  {
    boolean bool2 = false;
    AppMethodBeat.i(205308);
    boolean bool1 = bool2;
    if (qQz != null)
    {
      bool1 = bool2;
      if (qQz.size() > 0)
      {
        Log.d("huaweiUtil", "dancy test retList get(0):%s", new Object[] { qQz.get(0) });
        if (((Integer)qQz.get(0)).intValue() != 0) {
          break label78;
        }
      }
    }
    label78:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(205308);
      return bool1;
    }
  }
  
  public static EasyGo gWy()
  {
    return easyGoManager;
  }
  
  public static void kA(Context paramContext)
  {
    AppMethodBeat.i(205307);
    if (easyGoManager == null) {
      easyGoManager = new EasyGo(paramContext);
    }
    qQz = easyGoManager.init(new String[] { "magicwindow" });
    AppMethodBeat.o(205307);
  }
  
  public static boolean kB(Context paramContext)
  {
    AppMethodBeat.i(205313);
    paramContext = paramContext.getResources().getConfiguration().toString();
    if ((paramContext.contains("hwMultiwindow-magic")) || (paramContext.contains("hw-magic-windows")))
    {
      AppMethodBeat.o(205313);
      return true;
    }
    AppMethodBeat.o(205313);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.aw
 * JD-Core Version:    0.7.0.1
 */