package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static long AYI;
  private static JSONObject AYJ;
  private static a AYK;
  private static f ghB;
  
  static
  {
    AppMethodBeat.i(149325);
    ghB = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        int i = 1;
        AppMethodBeat.i(149318);
        if ((paramAnonymousn instanceof e))
        {
          g.ajj().b(1947, h.eka());
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = ((e)paramAnonymousn).AYw;
            ae.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[] { paramAnonymousString.FOF });
            h.aCH(paramAnonymousString.FOF);
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString = h.ejY();
            if (!l.ejG()) {
              continue;
            }
            paramAnonymousInt1 = i;
            paramAnonymousString.put("checkWeSportInstall", paramAnonymousInt1);
          }
          catch (Exception paramAnonymousString)
          {
            continue;
          }
          paramAnonymousString = h.ejY().toString();
          k.aCI(paramAnonymousString);
          ((PluginSport)g.ad(PluginSport.class)).getDeviceStepManager().aCG(paramAnonymousString);
          if (h.ekb() != null) {
            h.ekb().agz();
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
    AYK = parama;
  }
  
  public static void aCH(String paramString)
  {
    AppMethodBeat.i(149321);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(149321);
      return;
    }
    try
    {
      AYJ = new JSONObject(paramString);
      AppMethodBeat.o(149321);
      return;
    }
    catch (Exception paramString)
    {
      AYJ = null;
      AppMethodBeat.o(149321);
    }
  }
  
  private static void aR(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(149323);
    try
    {
      if (ak.coh())
      {
        if (!l.ejG()) {
          break label75;
        }
        i = 1;
        if (paramJSONObject.optInt("checkWeSportInstall", 0) != i) {
          if (!l.ejG()) {
            break label80;
          }
        }
      }
      label75:
      label80:
      for (int i = j;; i = 0)
      {
        paramJSONObject.put("checkWeSportInstall", i);
        k.aCI(paramJSONObject.toString());
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(323L, 5L, 1L, false);
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
  
  public static boolean ejX()
  {
    AppMethodBeat.i(149319);
    if (AYI == 0L) {
      AYI = k.aC(1, 0L);
    }
    if (System.currentTimeMillis() - AYI > 86400000L)
    {
      AYI = System.currentTimeMillis();
      k.aD(1, AYI);
      ae.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
      g.ajj().a(1947, ghB);
      g.ajj().a(new e(), 0);
      AppMethodBeat.o(149319);
      return true;
    }
    ae.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[] { l.sz(AYI) });
    AppMethodBeat.o(149319);
    return false;
  }
  
  public static JSONObject ejY()
  {
    AppMethodBeat.i(149322);
    Object localObject;
    if (AYJ == null)
    {
      if (!ak.coh()) {
        break label137;
      }
      localObject = ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().getString(2, "");
      if (bu.isNullOrNil((String)localObject)) {
        break label158;
      }
    }
    for (;;)
    {
      label137:
      try
      {
        localObject = new JSONObject((String)localObject);
        AYJ = (JSONObject)localObject;
        aR((JSONObject)localObject);
        localObject = "server config";
        if (AYJ == null)
        {
          localObject = ejZ();
          AYJ = (JSONObject)localObject;
          aR((JSONObject)localObject);
          localObject = "asset";
        }
        if (AYJ == null)
        {
          AYJ = new JSONObject();
          localObject = "new";
        }
        ae.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[] { localObject, AYJ.toString() });
        localObject = AYJ;
        AppMethodBeat.o(149322);
        return localObject;
      }
      catch (Exception localException) {}
      localObject = new j(com.tencent.mm.plugin.sport.a.a.AYb).getString(2, "");
      break;
      label158:
      String str = "";
    }
  }
  
  private static JSONObject ejZ()
  {
    AppMethodBeat.i(149324);
    Object localObject4 = ak.getContext().getAssets();
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
        ae.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", localException, "get assets sport config json", new Object[0]);
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
  
  public static void sl(boolean paramBoolean)
  {
    AppMethodBeat.i(149320);
    Object localObject = ejY();
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
        k.aCI((String)localObject);
        ((PluginSport)g.ad(PluginSport.class)).getDeviceStepManager().aCG((String)localObject);
        if (AYK != null) {
          AYK.agz();
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
    public abstract void agz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.h
 * JD-Core Version:    0.7.0.1
 */