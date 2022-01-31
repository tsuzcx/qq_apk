package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static f fur;
  private static long spR;
  private static JSONObject spS;
  private static h.a spT;
  
  static
  {
    AppMethodBeat.i(93683);
    fur = new h.1();
    AppMethodBeat.o(93683);
  }
  
  public static void a(h.a parama)
  {
    spT = parama;
  }
  
  public static void acw(String paramString)
  {
    AppMethodBeat.i(93680);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(93680);
      return;
    }
    try
    {
      spS = new JSONObject(paramString);
      AppMethodBeat.o(93680);
      return;
    }
    catch (Exception paramString)
    {
      spS = null;
      AppMethodBeat.o(93680);
    }
  }
  
  public static boolean cyO()
  {
    AppMethodBeat.i(93678);
    if (spR == 0L) {
      spR = k.ae(1, 0L);
    }
    if (System.currentTimeMillis() - spR > 86400000L)
    {
      spR = System.currentTimeMillis();
      k.af(1, spR);
      ab.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
      g.Rc().a(1947, fur);
      g.Rc().a(new e(), 0);
      AppMethodBeat.o(93678);
      return true;
    }
    ab.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[] { n.ha(spR) });
    AppMethodBeat.o(93678);
    return false;
  }
  
  public static JSONObject cyP()
  {
    AppMethodBeat.i(93681);
    Object localObject;
    if (spS == null)
    {
      if (!ah.brt()) {
        break label177;
      }
      localObject = ((PluginSport)g.G(PluginSport.class)).getSportFileStorage().getString(2, "");
      if (bo.isNullOrNil((String)localObject)) {
        break label203;
      }
    }
    for (;;)
    {
      label177:
      try
      {
        spS = new JSONObject((String)localObject);
        if (ah.brt())
        {
          localObject = spS;
          if (n.cyu())
          {
            i = 1;
            ((JSONObject)localObject).put("checkWeSportInstall", i);
          }
        }
        else
        {
          localObject = "server config";
          if (spS == null) {
            spS = cyQ();
          }
        }
      }
      catch (Exception localException1) {}
      try
      {
        if (ah.brt())
        {
          localObject = spS;
          if (!n.cyu()) {
            break label209;
          }
          i = 1;
          ((JSONObject)localObject).put("checkWeSportInstall", i);
        }
      }
      catch (Exception localException2)
      {
        String str;
        continue;
      }
      localObject = "asset";
      if (spS == null)
      {
        spS = new JSONObject();
        localObject = "new";
      }
      ab.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[] { localObject, spS.toString() });
      localObject = spS;
      AppMethodBeat.o(93681);
      return localObject;
      localObject = new j(com.tencent.mm.plugin.sport.a.a.spj).getString(2, "");
      break;
      int i = 0;
      continue;
      label203:
      str = "";
      continue;
      label209:
      i = 0;
    }
  }
  
  private static JSONObject cyQ()
  {
    AppMethodBeat.i(93682);
    Object localObject4 = ah.getContext().getAssets();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = ((AssetManager)localObject4).open("sport_config.json");
      localObject1 = localObject4;
      localObject3 = localObject4;
      localJSONObject2 = new JSONObject(new String(com.tencent.mm.a.e.m((InputStream)localObject4)));
      localObject3 = localJSONObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        ab.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", localException, "get assets sport config json", new Object[0]);
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
        AppMethodBeat.o(93682);
        throw localObject2;
        localIOException2 = localIOException2;
        localObject3 = localJSONObject2;
      }
      catch (IOException localIOException3)
      {
        break label120;
      }
    }
    AppMethodBeat.o(93682);
    return localObject3;
  }
  
  public static void lL(boolean paramBoolean)
  {
    AppMethodBeat.i(93679);
    Object localObject = cyP();
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
        k.acx((String)localObject);
        ((PluginSport)g.G(PluginSport.class)).getDeviceStepManager().acv((String)localObject);
        if (spT != null) {
          spT.ye();
        }
        AppMethodBeat.o(93679);
        return;
        i = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.h
 * JD-Core Version:    0.7.0.1
 */