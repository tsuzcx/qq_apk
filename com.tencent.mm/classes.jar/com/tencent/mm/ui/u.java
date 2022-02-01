package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.miui.easygo.sdk.EasyGo;
import com.miui.easygo.sdk.module.EasyGoRet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
{
  private static EasyGo VYZ = null;
  private static List<Integer> usF;
  
  public static int a(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(205563);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(205563);
      return -1;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:taskId", paramInt);
      return -1;
    }
    catch (JSONException paramEasyGo)
    {
      try
      {
        paramEasyGo = paramEasyGo.invokeSync("magicwindow", "getTaskPosition", localJSONObject, null);
        Log.i("EasyGo", paramEasyGo.code);
        paramInt = paramEasyGo.result.getInt("int");
        Log.i("EasyGo", "getTaskPosition".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(205563);
        return paramInt;
      }
      catch (Throwable paramEasyGo)
      {
        Log.e("EasyGo", paramEasyGo.getMessage());
        AppMethodBeat.o(205563);
      }
      paramEasyGo = paramEasyGo;
      Log.e("EasyGo", paramEasyGo.getMessage());
      AppMethodBeat.o(205563);
      return -1;
    }
  }
  
  public static void a(EasyGo paramEasyGo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205566);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(205566);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:taskId", paramInt1);
      localJSONObject.put("@int:targetPosition", paramInt2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        try
        {
          paramEasyGo = paramEasyGo.invokeSync("magicwindow", "setTaskPosition", localJSONObject, null);
          Log.i("EasyGo", paramEasyGo.code);
          AppMethodBeat.o(205566);
          return;
        }
        catch (Throwable paramEasyGo)
        {
          Log.e("EasyGo", paramEasyGo.getMessage());
          AppMethodBeat.o(205566);
        }
        localJSONException = localJSONException;
        Log.e("EasyGo", localJSONException.getMessage());
      }
    }
  }
  
  public static void atQ(int paramInt)
  {
    AppMethodBeat.i(205568);
    if (VYZ == null)
    {
      AppMethodBeat.o(205568);
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:loginStatus", paramInt);
      return;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        localObject = VYZ.invokeSync("magicwindow", "setLoginStatus", (JSONObject)localObject, null);
        Log.i("EasyGo", " setLoginStatus ret " + ((EasyGoRet)localObject).code);
        AppMethodBeat.o(205568);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("EasyGo", localThrowable.getMessage());
        AppMethodBeat.o(205568);
      }
      localJSONException = localJSONException;
      Log.e("EasyGo", localJSONException.getMessage());
      AppMethodBeat.o(205568);
      return;
    }
  }
  
  public static boolean atR(int paramInt)
  {
    AppMethodBeat.i(205570);
    if (VYZ == null)
    {
      AppMethodBeat.o(205570);
      return false;
    }
    if (a(VYZ, paramInt) == 2)
    {
      AppMethodBeat.o(205570);
      return true;
    }
    AppMethodBeat.o(205570);
    return false;
  }
  
  public static boolean b(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(293199);
    if (a(paramEasyGo, paramInt) == -1)
    {
      AppMethodBeat.o(293199);
      return false;
    }
    AppMethodBeat.o(293199);
    return true;
  }
  
  public static boolean hHA()
  {
    AppMethodBeat.i(205561);
    boolean bool;
    if ((usF != null) && (usF.size() > 0))
    {
      Log.d("MIUIUtil", "dancy test retList get(0):%s", new Object[] { usF.get(0) });
      if (((Integer)usF.get(0)).intValue() == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.d("MIUIUtil", "dancy test flag :%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(205561);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static EasyGo hHB()
  {
    return VYZ;
  }
  
  public static void kK(Context paramContext)
  {
    AppMethodBeat.i(205559);
    if (!ar.hIJ())
    {
      AppMethodBeat.o(205559);
      return;
    }
    if (VYZ == null) {
      VYZ = new EasyGo(paramContext);
    }
    usF = VYZ.init(new String[] { "magicwindow" });
    AppMethodBeat.o(205559);
  }
  
  public static boolean kL(Context paramContext)
  {
    AppMethodBeat.i(205569);
    boolean bool = paramContext.getResources().getConfiguration().toString().contains("miui-magic-windows");
    AppMethodBeat.o(205569);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.u
 * JD-Core Version:    0.7.0.1
 */