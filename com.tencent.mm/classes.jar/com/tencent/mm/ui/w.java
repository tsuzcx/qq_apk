package com.tencent.mm.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings.Global;
import com.miui.easygo.sdk.EasyGo;
import com.miui.easygo.sdk.module.EasyGoRet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
{
  private static EasyGo adDu = null;
  private static List<Integer> xzc;
  
  public static int a(ContentResolver paramContentResolver)
  {
    int i = 0;
    AppMethodBeat.i(249177);
    try
    {
      int j = Settings.Global.getInt(paramContentResolver, "device_posture", 0);
      i = j;
    }
    catch (Exception paramContentResolver)
    {
      for (;;)
      {
        Log.e("MicroMsg.MIUIUtil", "error occur");
      }
    }
    AppMethodBeat.o(249177);
    return i;
  }
  
  public static int a(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(249165);
    if (paramEasyGo == null)
    {
      AppMethodBeat.o(249165);
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
        AppMethodBeat.o(249165);
        return paramInt;
      }
      finally
      {
        Log.e("EasyGo", paramEasyGo.getMessage());
        AppMethodBeat.o(249165);
      }
      paramEasyGo = paramEasyGo;
      Log.e("EasyGo", paramEasyGo.getMessage());
      AppMethodBeat.o(249165);
      return -1;
    }
  }
  
  /* Error */
  public static void a(EasyGo paramEasyGo, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 121
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +9 -> 15
    //   9: ldc 121
    //   11: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: return
    //   15: new 52	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 55	org/json/JSONObject:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: ldc 57
    //   26: iload_1
    //   27: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_3
    //   32: ldc 123
    //   34: iload_2
    //   35: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   38: pop
    //   39: aload_0
    //   40: ldc 63
    //   42: ldc 125
    //   44: aload_3
    //   45: aconst_null
    //   46: invokevirtual 71	com/miui/easygo/sdk/EasyGo:invokeSync	(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Landroid/os/Bundle;)Lcom/miui/easygo/sdk/module/EasyGoRet;
    //   49: astore_0
    //   50: ldc 73
    //   52: new 75	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   59: aload_0
    //   60: getfield 82	com/miui/easygo/sdk/module/EasyGoRet:code	I
    //   63: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc 121
    //   74: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: astore 4
    //   80: ldc 73
    //   82: aload 4
    //   84: invokevirtual 116	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   87: invokestatic 46	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: goto -51 -> 39
    //   93: astore_0
    //   94: ldc 73
    //   96: aload_0
    //   97: invokevirtual 119	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   100: invokestatic 46	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: ldc 121
    //   105: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramEasyGo	EasyGo
    //   0	109	1	paramInt1	int
    //   0	109	2	paramInt2	int
    //   22	23	3	localJSONObject	JSONObject
    //   78	5	4	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   23	39	78	org/json/JSONException
    //   39	72	93	finally
  }
  
  public static void aAi(int paramInt)
  {
    AppMethodBeat.i(249169);
    if (adDu == null)
    {
      AppMethodBeat.o(249169);
      return;
    }
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("@int:loginStatus", paramInt);
      return;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        localObject1 = adDu.invokeSync("magicwindow", "setLoginStatus", (JSONObject)localObject1, null);
        Log.i("EasyGo", " setLoginStatus ret " + ((EasyGoRet)localObject1).code);
        AppMethodBeat.o(249169);
        return;
      }
      finally
      {
        Log.e("EasyGo", localObject2.getMessage());
        AppMethodBeat.o(249169);
      }
      localJSONException = localJSONException;
      Log.e("EasyGo", localJSONException.getMessage());
      AppMethodBeat.o(249169);
      return;
    }
  }
  
  public static boolean aAj(int paramInt)
  {
    AppMethodBeat.i(249175);
    if (adDu == null)
    {
      AppMethodBeat.o(249175);
      return false;
    }
    if (a(adDu, paramInt) == 2)
    {
      AppMethodBeat.o(249175);
      return true;
    }
    AppMethodBeat.o(249175);
    return false;
  }
  
  public static boolean aAk(int paramInt)
  {
    AppMethodBeat.i(249176);
    if (adDu == null)
    {
      AppMethodBeat.o(249176);
      return false;
    }
    if (a(adDu, paramInt) == 1)
    {
      AppMethodBeat.o(249176);
      return true;
    }
    AppMethodBeat.o(249176);
    return false;
  }
  
  public static boolean b(EasyGo paramEasyGo, int paramInt)
  {
    AppMethodBeat.i(249171);
    if (a(paramEasyGo, paramInt) == -1)
    {
      AppMethodBeat.o(249171);
      return false;
    }
    AppMethodBeat.o(249171);
    return true;
  }
  
  public static boolean jjK()
  {
    AppMethodBeat.i(249155);
    boolean bool;
    if ((xzc != null) && (xzc.size() > 0))
    {
      Log.d("MIUIUtil", "dancy test retList get(0):%s", new Object[] { xzc.get(0) });
      if (((Integer)xzc.get(0)).intValue() == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.d("MIUIUtil", "dancy test flag :%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(249155);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static EasyGo jjL()
  {
    return adDu;
  }
  
  public static void mN(Context paramContext)
  {
    AppMethodBeat.i(249150);
    if ((!aw.jkV()) && (!aw.jla()))
    {
      AppMethodBeat.o(249150);
      return;
    }
    try
    {
      if (adDu == null) {
        adDu = new EasyGo(paramContext);
      }
      xzc = adDu.init(new String[] { "magicwindow" });
      AppMethodBeat.o(249150);
      return;
    }
    finally
    {
      Log.printErrStackTrace("EasyGo", paramContext, null, new Object[0]);
      AppMethodBeat.o(249150);
    }
  }
  
  public static boolean mO(Context paramContext)
  {
    AppMethodBeat.i(249173);
    boolean bool = paramContext.getResources().getConfiguration().toString().contains("miui-magic-windows");
    AppMethodBeat.o(249173);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.w
 * JD-Core Version:    0.7.0.1
 */