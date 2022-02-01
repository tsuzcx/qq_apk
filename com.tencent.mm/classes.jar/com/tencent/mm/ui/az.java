package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public final class az
{
  private static Object adKY = null;
  private static Method adKZ = null;
  
  public static boolean aAA(int paramInt)
  {
    AppMethodBeat.i(249364);
    if (aAE(paramInt) == -1)
    {
      AppMethodBeat.o(249364);
      return false;
    }
    AppMethodBeat.o(249364);
    return true;
  }
  
  private static int aAE(int paramInt)
  {
    AppMethodBeat.i(249354);
    if (adKZ == null) {
      init();
    }
    if (adKZ == null)
    {
      AppMethodBeat.o(249354);
      return -1;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:taskId", paramInt);
      paramInt = ((Bundle)adKZ.invoke(adKY, new Object[] { "com.tencent.mm", "getTaskPosition", localJSONObject.toString(), null })).getInt("int");
      AppMethodBeat.o(249354);
      return paramInt;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      AppMethodBeat.o(249354);
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label95;
    }
    catch (JSONException localJSONException)
    {
      label95:
      break label95;
    }
  }
  
  public static void aAi(int paramInt)
  {
    AppMethodBeat.i(249357);
    if (adKZ == null) {
      init();
    }
    if (adKZ == null)
    {
      AppMethodBeat.o(249357);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("@int:loginStatus", paramInt);
      adKZ.invoke(adKY, new Object[] { "com.tencent.mm", "setLoginStatus", localJSONObject.toString(), null });
      AppMethodBeat.o(249357);
      return;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(249357);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      AppMethodBeat.o(249357);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      AppMethodBeat.o(249357);
    }
  }
  
  public static boolean aAj(int paramInt)
  {
    AppMethodBeat.i(249366);
    if (adKZ == null)
    {
      AppMethodBeat.o(249366);
      return false;
    }
    if (aAE(paramInt) == 2)
    {
      AppMethodBeat.o(249366);
      return true;
    }
    AppMethodBeat.o(249366);
    return false;
  }
  
  public static boolean aAk(int paramInt)
  {
    AppMethodBeat.i(249368);
    if (adKZ == null)
    {
      AppMethodBeat.o(249368);
      return false;
    }
    if (aAE(paramInt) == 1)
    {
      AppMethodBeat.o(249368);
      return true;
    }
    AppMethodBeat.o(249368);
    return false;
  }
  
  public static boolean init()
  {
    bool1 = false;
    AppMethodBeat.i(249346);
    if (!aw.jlb())
    {
      AppMethodBeat.o(249346);
      return false;
    }
    try
    {
      Object localObject = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "window" });
      adKY = Class.forName("android.view.IWindowManager$Stub").getMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { localObject });
      localObject = Class.forName("android.view.IWindowManager$Stub$Proxy").getMethod("invokeSync", new Class[] { String.class, String.class, String.class, Bundle.class });
      adKZ = (Method)localObject;
      if (localObject == null) {
        break label195;
      }
      boolean bool2 = ((Bundle)adKZ.invoke(adKY, new Object[] { "com.tencent.mm", "isMultiLandsEnable", null, null })).getBoolean("boolean");
      bool1 = bool2;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label172;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label172;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label172;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        label172:
        continue;
        bool1 = false;
      }
    }
    AppMethodBeat.o(249346);
    return bool1;
  }
  
  public static void nZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249350);
    if (adKZ == null) {
      init();
    }
    if (adKZ == null)
    {
      AppMethodBeat.o(249350);
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
          adKZ.invoke(adKY, new Object[] { "com.tencent.mm", "setTaskPosition", localJSONObject.toString(), null });
          AppMethodBeat.o(249350);
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          AppMethodBeat.o(249350);
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          AppMethodBeat.o(249350);
        }
        localJSONException = localJSONException;
        localJSONException.getMessage();
      }
    }
  }
  
  public static boolean nb(Context paramContext)
  {
    AppMethodBeat.i(249361);
    if (paramContext == null)
    {
      AppMethodBeat.o(249361);
      return false;
    }
    if (paramContext.getResources().getConfiguration().toString().contains("multi-landscape"))
    {
      AppMethodBeat.o(249361);
      return true;
    }
    AppMethodBeat.o(249361);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.az
 * JD-Core Version:    0.7.0.1
 */