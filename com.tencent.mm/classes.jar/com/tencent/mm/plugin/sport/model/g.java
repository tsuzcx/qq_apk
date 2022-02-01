package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.protobuf.eyc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  private static long FjC;
  private static JSONObject FjD;
  private static a FjE;
  private static com.tencent.mm.ak.i gNh;
  
  static
  {
    AppMethodBeat.i(149325);
    gNh = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        int i = 1;
        AppMethodBeat.i(149318);
        if ((paramAnonymousq instanceof d))
        {
          com.tencent.mm.kernel.g.azz().b(1947, g.fmA());
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = ((d)paramAnonymousq).Fjq;
            Log.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[] { paramAnonymousString.KIn });
            g.aRD(paramAnonymousString.KIn);
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString = g.fmy();
            if (!k.fmg()) {
              continue;
            }
            paramAnonymousInt1 = i;
            paramAnonymousString.put("checkWeSportInstall", paramAnonymousInt1);
          }
          catch (Exception paramAnonymousString)
          {
            continue;
          }
          paramAnonymousString = g.fmy().toString();
          j.aRE(paramAnonymousString);
          ((PluginSport)com.tencent.mm.kernel.g.ah(PluginSport.class)).getDeviceStepManager().aRC(paramAnonymousString);
          if (g.fmB() != null) {
            g.fmB().awp();
          }
          AppMethodBeat.o(149318);
          return;
          paramAnonymousInt1 = 0;
        }
      }
    };
    AppMethodBeat.o(149325);
  }
  
  public static void a(a parama)
  {
    FjE = parama;
  }
  
  public static void aRD(String paramString)
  {
    AppMethodBeat.i(149321);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(149321);
      return;
    }
    try
    {
      FjD = new JSONObject(paramString);
      AppMethodBeat.o(149321);
      return;
    }
    catch (Exception paramString)
    {
      FjD = null;
      AppMethodBeat.o(149321);
    }
  }
  
  private static void bq(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(149323);
    try
    {
      if (MMApplicationContext.isMainProcess())
      {
        if (!k.fmg()) {
          break label75;
        }
        i = 1;
        if (paramJSONObject.optInt("checkWeSportInstall", 0) != i) {
          if (!k.fmg()) {
            break label80;
          }
        }
      }
      label75:
      label80:
      for (int i = j;; i = 0)
      {
        paramJSONObject.put("checkWeSportInstall", i);
        j.aRE(paramJSONObject.toString());
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(323L, 5L, 1L, false);
        AppMethodBeat.o(149323);
        return;
        i = 0;
        break;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(149323);
    }
  }
  
  public static boolean fmx()
  {
    AppMethodBeat.i(149319);
    if (FjC == 0L) {
      FjC = j.aJ(1, 0L);
    }
    if (System.currentTimeMillis() - FjC > 86400000L)
    {
      FjC = System.currentTimeMillis();
      j.aK(1, FjC);
      Log.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
      com.tencent.mm.kernel.g.azz().a(1947, gNh);
      com.tencent.mm.kernel.g.azz().a(new d(), 0);
      AppMethodBeat.o(149319);
      return true;
    }
    Log.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[] { k.AF(FjC) });
    AppMethodBeat.o(149319);
    return false;
  }
  
  public static JSONObject fmy()
  {
    AppMethodBeat.i(149322);
    Object localObject;
    if (FjD == null)
    {
      if (!MMApplicationContext.isMainProcess()) {
        break label137;
      }
      localObject = ((PluginSport)com.tencent.mm.kernel.g.ah(PluginSport.class)).getSportFileStorage().getString(2, "");
      if (Util.isNullOrNil((String)localObject)) {
        break label158;
      }
    }
    for (;;)
    {
      label137:
      try
      {
        localObject = new JSONObject((String)localObject);
        FjD = (JSONObject)localObject;
        bq((JSONObject)localObject);
        localObject = "server config";
        if (FjD == null)
        {
          localObject = fmz();
          FjD = (JSONObject)localObject;
          bq((JSONObject)localObject);
          localObject = "asset";
        }
        if (FjD == null)
        {
          FjD = new JSONObject();
          localObject = "new";
        }
        Log.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[] { localObject, FjD.toString() });
        localObject = FjD;
        AppMethodBeat.o(149322);
        return localObject;
      }
      catch (Exception localException) {}
      localObject = new i(com.tencent.mm.plugin.sport.a.a.FiV).getString(2, "");
      break;
      label158:
      String str = "";
    }
  }
  
  private static JSONObject fmz()
  {
    AppMethodBeat.i(149324);
    Object localObject4 = MMApplicationContext.getContext().getAssets();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = ((AssetManager)localObject4).open("sport_config.json");
      localObject1 = localObject4;
      localObject3 = localObject4;
      localJSONObject2 = new JSONObject(new String(com.tencent.mm.b.e.readFromStream((InputStream)localObject4)));
      localObject3 = localJSONObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        Log.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", localException, "get assets sport config json", new Object[0]);
        localObject3 = localObject1;
        JSONObject localJSONObject1 = new JSONObject();
        localObject3 = localJSONObject1;
        if (localObject1 != null) {
          try
          {
            localObject1.close();
            localObject3 = localJSONObject1;
          }
          catch (IOException localIOException1)
          {
            localObject3 = localJSONObject1;
          }
        }
      }
    }
    finally
    {
      if (localObject3 == null) {}
    }
    try
    {
      ((InputStream)localObject4).close();
      localObject3 = localJSONObject2;
    }
    catch (IOException localIOException2)
    {
      try
      {
        ((InputStream)localObject3).close();
        AppMethodBeat.o(149324);
        throw localObject2;
        localIOException2 = localIOException2;
        localObject3 = localJSONObject2;
      }
      catch (IOException localIOException3)
      {
        break label120;
      }
    }
    AppMethodBeat.o(149324);
    return localObject3;
  }
  
  public static void vH(boolean paramBoolean)
  {
    AppMethodBeat.i(149320);
    Object localObject = fmy();
    int i;
    if (paramBoolean) {
      i = 1;
    }
    try
    {
      for (;;)
      {
        ((JSONObject)localObject).put("checkWeSportInstall", i);
        label23:
        localObject = ((JSONObject)localObject).toString();
        j.aRE((String)localObject);
        ((PluginSport)com.tencent.mm.kernel.g.ah(PluginSport.class)).getDeviceStepManager().aRC((String)localObject);
        if (FjE != null) {
          FjE.awp();
        }
        AppMethodBeat.o(149320);
        return;
        i = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      break label23;
    }
  }
  
  public static abstract interface a
  {
    public abstract void awp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.g
 * JD-Core Version:    0.7.0.1
 */