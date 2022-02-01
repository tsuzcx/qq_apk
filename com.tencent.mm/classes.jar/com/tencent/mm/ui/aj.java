package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.f.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class aj
{
  private static com.f.a.a.a adIZ = null;
  
  public static boolean aAA(int paramInt)
  {
    AppMethodBeat.i(249279);
    if (aAz(paramInt) == -1)
    {
      AppMethodBeat.o(249279);
      return false;
    }
    AppMethodBeat.o(249279);
    return true;
  }
  
  public static void aAi(int paramInt)
  {
    AppMethodBeat.i(249259);
    if ((adIZ == null) || (!l.aQm()))
    {
      AppMethodBeat.o(249259);
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:loginStatus", paramInt);
      localObject = adIZ.a("compactWindow", "setLoginStatus", (JSONObject)localObject);
      Log.i("MicroMsg.OPPOUtil", " setLoginStatus ret " + ((com.f.a.b.a)localObject).code);
      AppMethodBeat.o(249259);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.OPPOUtil", localJSONException.getMessage());
      AppMethodBeat.o(249259);
    }
  }
  
  public static boolean aAj(int paramInt)
  {
    AppMethodBeat.i(249282);
    if (adIZ == null)
    {
      AppMethodBeat.o(249282);
      return false;
    }
    if (aAz(paramInt) == 2)
    {
      AppMethodBeat.o(249282);
      return true;
    }
    AppMethodBeat.o(249282);
    return false;
  }
  
  public static boolean aAk(int paramInt)
  {
    AppMethodBeat.i(249285);
    if (adIZ == null)
    {
      AppMethodBeat.o(249285);
      return false;
    }
    if (aAz(paramInt) == 1)
    {
      AppMethodBeat.o(249285);
      return true;
    }
    AppMethodBeat.o(249285);
    return false;
  }
  
  public static boolean aAy(int paramInt)
  {
    AppMethodBeat.i(249265);
    if ((adIZ == null) || (!l.aQm()))
    {
      AppMethodBeat.o(249265);
      return false;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:taskId", paramInt);
      localObject = adIZ.a("compactWindow", "isInCompactWindowMode", (JSONObject)localObject);
      boolean bool = ((com.f.a.b.a)localObject).result.getBoolean("boolean");
      Log.i("MicroMsg.OPPOUtil", " isMagicWindow ret " + ((com.f.a.b.a)localObject).code + "isMagicWindow " + bool);
      AppMethodBeat.o(249265);
      return bool;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.OPPOUtil", localJSONException.getMessage());
      AppMethodBeat.o(249265);
    }
    return false;
  }
  
  public static int aAz(int paramInt)
  {
    AppMethodBeat.i(249273);
    if ((adIZ == null) || (!l.aQm()))
    {
      AppMethodBeat.o(249273);
      return -1;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:taskId", paramInt);
      localObject = adIZ.a("compactWindow", "getTaskPosition", (JSONObject)localObject);
      Log.i("MicroMsg.OPPOUtil", " getTaskPos ret " + ((com.f.a.b.a)localObject).code);
      paramInt = ((com.f.a.b.a)localObject).result.getInt("int");
      Log.e("MicroMsg.OPPOUtil", "getTaskPosition".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(249273);
      return paramInt;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.OPPOUtil", localJSONException.getMessage());
      AppMethodBeat.o(249273);
    }
    return -1;
  }
  
  public static boolean jjK()
  {
    if (adIZ != null)
    {
      com.f.a.a.a locala = adIZ;
      if ((locala.dYq != null) && (locala.dYq.dYt)) {
        return true;
      }
    }
    return false;
  }
  
  public static com.f.a.a.a jkE()
  {
    return adIZ;
  }
  
  public static boolean mO(Context paramContext)
  {
    AppMethodBeat.i(249276);
    boolean bool = paramContext.getResources().getConfiguration().toString().contains("oplus-magic-window");
    AppMethodBeat.o(249276);
    return bool;
  }
  
  public static void mV(Context paramContext)
  {
    AppMethodBeat.i(249252);
    if ((!l.aQm()) || (!aw.jkY()))
    {
      AppMethodBeat.o(249252);
      return;
    }
    if (adIZ == null) {
      adIZ = new com.f.a.a.a(paramContext);
    }
    AppMethodBeat.o(249252);
  }
  
  public static void nX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249270);
    if ((adIZ == null) || (!l.aQm()))
    {
      AppMethodBeat.o(249270);
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("@int:taskId", paramInt1);
      ((JSONObject)localObject).put("@int:targetPosition", paramInt2);
      localObject = adIZ.a("compactWindow", "setTaskPosition", (JSONObject)localObject);
      Log.i("MicroMsg.OPPOUtil", " setTaskPos ret " + ((com.f.a.b.a)localObject).code);
      AppMethodBeat.o(249270);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.OPPOUtil", localJSONException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.aj
 * JD-Core Version:    0.7.0.1
 */