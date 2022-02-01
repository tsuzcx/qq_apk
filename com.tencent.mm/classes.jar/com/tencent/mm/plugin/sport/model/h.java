package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static com.tencent.mm.ak.g hwV;
  private static long zpl;
  private static JSONObject zpm;
  private static a zpn;
  
  static
  {
    AppMethodBeat.i(149325);
    hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        int i = 1;
        AppMethodBeat.i(149318);
        if ((paramAnonymousn instanceof e))
        {
          com.tencent.mm.kernel.g.agi().b(1947, h.dUe());
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = ((e)paramAnonymousn).zoZ;
            ac.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[] { paramAnonymousString.DQP });
            h.awi(paramAnonymousString.DQP);
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString = h.dUc();
            if (!l.dTK()) {
              continue;
            }
            paramAnonymousInt1 = i;
            paramAnonymousString.put("checkWeSportInstall", paramAnonymousInt1);
          }
          catch (Exception paramAnonymousString)
          {
            continue;
          }
          paramAnonymousString = h.dUc().toString();
          k.awj(paramAnonymousString);
          ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getDeviceStepManager().awh(paramAnonymousString);
          if (h.dUf() != null) {
            h.dUf().adF();
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
    zpn = parama;
  }
  
  private static void aJ(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(149323);
    try
    {
      if (ai.cin())
      {
        if (!l.dTK()) {
          break label75;
        }
        i = 1;
        if (paramJSONObject.optInt("checkWeSportInstall", 0) != i) {
          if (!l.dTK()) {
            break label80;
          }
        }
      }
      label75:
      label80:
      for (int i = j;; i = 0)
      {
        paramJSONObject.put("checkWeSportInstall", i);
        k.awj(paramJSONObject.toString());
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(323L, 5L, 1L, false);
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
  
  public static void awi(String paramString)
  {
    AppMethodBeat.i(149321);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(149321);
      return;
    }
    try
    {
      zpm = new JSONObject(paramString);
      AppMethodBeat.o(149321);
      return;
    }
    catch (Exception paramString)
    {
      zpm = null;
      AppMethodBeat.o(149321);
    }
  }
  
  public static boolean dUb()
  {
    AppMethodBeat.i(149319);
    if (zpl == 0L) {
      zpl = k.av(1, 0L);
    }
    if (System.currentTimeMillis() - zpl > 86400000L)
    {
      zpl = System.currentTimeMillis();
      k.aw(1, zpl);
      ac.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
      com.tencent.mm.kernel.g.agi().a(1947, hwV);
      com.tencent.mm.kernel.g.agi().a(new e(), 0);
      AppMethodBeat.o(149319);
      return true;
    }
    ac.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[] { l.qn(zpl) });
    AppMethodBeat.o(149319);
    return false;
  }
  
  public static JSONObject dUc()
  {
    AppMethodBeat.i(149322);
    Object localObject;
    if (zpm == null)
    {
      if (!ai.cin()) {
        break label137;
      }
      localObject = ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getSportFileStorage().getString(2, "");
      if (bs.isNullOrNil((String)localObject)) {
        break label158;
      }
    }
    for (;;)
    {
      label137:
      try
      {
        localObject = new JSONObject((String)localObject);
        zpm = (JSONObject)localObject;
        aJ((JSONObject)localObject);
        localObject = "server config";
        if (zpm == null)
        {
          localObject = dUd();
          zpm = (JSONObject)localObject;
          aJ((JSONObject)localObject);
          localObject = "asset";
        }
        if (zpm == null)
        {
          zpm = new JSONObject();
          localObject = "new";
        }
        ac.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[] { localObject, zpm.toString() });
        localObject = zpm;
        AppMethodBeat.o(149322);
        return localObject;
      }
      catch (Exception localException) {}
      localObject = new j(com.tencent.mm.plugin.sport.a.a.zoE).getString(2, "");
      break;
      label158:
      String str = "";
    }
  }
  
  private static JSONObject dUd()
  {
    AppMethodBeat.i(149324);
    Object localObject4 = ai.getContext().getAssets();
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
        ac.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", localException, "get assets sport config json", new Object[0]);
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
  
  public static void ry(boolean paramBoolean)
  {
    AppMethodBeat.i(149320);
    Object localObject = dUc();
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
        k.awj((String)localObject);
        ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getDeviceStepManager().awh((String)localObject);
        if (zpn != null) {
          zpn.adF();
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
    public abstract void adF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.h
 * JD-Core Version:    0.7.0.1
 */