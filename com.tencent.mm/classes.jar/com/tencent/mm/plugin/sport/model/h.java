package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static com.tencent.mm.al.g gWw;
  private static long ycl;
  private static JSONObject ycm;
  private static a ycn;
  
  static
  {
    AppMethodBeat.i(149325);
    gWw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        int i = 1;
        AppMethodBeat.i(149318);
        if ((paramAnonymousn instanceof e))
        {
          com.tencent.mm.kernel.g.aeS().b(1947, h.dFD());
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = ((e)paramAnonymousn).ybZ;
            ad.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[] { paramAnonymousString.Cyt });
            h.aqZ(paramAnonymousString.Cyt);
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString = h.dFB();
            if (!l.dFj()) {
              continue;
            }
            paramAnonymousInt1 = i;
            paramAnonymousString.put("checkWeSportInstall", paramAnonymousInt1);
          }
          catch (Exception paramAnonymousString)
          {
            continue;
          }
          paramAnonymousString = h.dFB().toString();
          k.ara(paramAnonymousString);
          ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getDeviceStepManager().aqY(paramAnonymousString);
          if (h.dFE() != null) {
            h.dFE().acz();
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
    ycn = parama;
  }
  
  private static void aI(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(149323);
    try
    {
      if (aj.cbe())
      {
        if (!l.dFj()) {
          break label75;
        }
        i = 1;
        if (paramJSONObject.optInt("checkWeSportInstall", 0) != i) {
          if (!l.dFj()) {
            break label80;
          }
        }
      }
      label75:
      label80:
      for (int i = j;; i = 0)
      {
        paramJSONObject.put("checkWeSportInstall", i);
        k.ara(paramJSONObject.toString());
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(323L, 5L, 1L, false);
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
  
  public static void aqZ(String paramString)
  {
    AppMethodBeat.i(149321);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(149321);
      return;
    }
    try
    {
      ycm = new JSONObject(paramString);
      AppMethodBeat.o(149321);
      return;
    }
    catch (Exception paramString)
    {
      ycm = null;
      AppMethodBeat.o(149321);
    }
  }
  
  public static boolean dFA()
  {
    AppMethodBeat.i(149319);
    if (ycl == 0L) {
      ycl = k.aw(1, 0L);
    }
    if (System.currentTimeMillis() - ycl > 86400000L)
    {
      ycl = System.currentTimeMillis();
      k.ax(1, ycl);
      ad.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
      com.tencent.mm.kernel.g.aeS().a(1947, gWw);
      com.tencent.mm.kernel.g.aeS().a(new e(), 0);
      AppMethodBeat.o(149319);
      return true;
    }
    ad.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[] { l.mz(ycl) });
    AppMethodBeat.o(149319);
    return false;
  }
  
  public static JSONObject dFB()
  {
    AppMethodBeat.i(149322);
    Object localObject;
    if (ycm == null)
    {
      if (!aj.cbe()) {
        break label137;
      }
      localObject = ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getSportFileStorage().getString(2, "");
      if (bt.isNullOrNil((String)localObject)) {
        break label158;
      }
    }
    for (;;)
    {
      label137:
      try
      {
        localObject = new JSONObject((String)localObject);
        ycm = (JSONObject)localObject;
        aI((JSONObject)localObject);
        localObject = "server config";
        if (ycm == null)
        {
          localObject = dFC();
          ycm = (JSONObject)localObject;
          aI((JSONObject)localObject);
          localObject = "asset";
        }
        if (ycm == null)
        {
          ycm = new JSONObject();
          localObject = "new";
        }
        ad.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[] { localObject, ycm.toString() });
        localObject = ycm;
        AppMethodBeat.o(149322);
        return localObject;
      }
      catch (Exception localException) {}
      localObject = new j(com.tencent.mm.plugin.sport.a.a.ybE).getString(2, "");
      break;
      label158:
      String str = "";
    }
  }
  
  private static JSONObject dFC()
  {
    AppMethodBeat.i(149324);
    Object localObject4 = aj.getContext().getAssets();
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
        ad.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", localException, "get assets sport config json", new Object[0]);
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
  
  public static void qA(boolean paramBoolean)
  {
    AppMethodBeat.i(149320);
    Object localObject = dFB();
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
        k.ara((String)localObject);
        ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getDeviceStepManager().aqY((String)localObject);
        if (ycn != null) {
          ycn.acz();
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
    public abstract void acz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.h
 * JD-Core Version:    0.7.0.1
 */