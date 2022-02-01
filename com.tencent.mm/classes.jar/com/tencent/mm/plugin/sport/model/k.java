package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.protobuf.gff;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  private static long SbT;
  private static JSONObject SbU;
  private static a SbV;
  private static com.tencent.mm.am.h maV;
  
  static
  {
    AppMethodBeat.i(149325);
    maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
      {
        int i = 1;
        AppMethodBeat.i(149318);
        if ((paramAnonymousp instanceof d))
        {
          com.tencent.mm.kernel.h.aZW().b(1947, k.hul());
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = ((d)paramAnonymousp).SbC;
            Log.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[] { paramAnonymousString.YGY });
            k.bbw(paramAnonymousString.YGY);
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString = k.huj();
            if (!p.htT()) {
              continue;
            }
            paramAnonymousInt1 = i;
            paramAnonymousString.put("checkWeSportInstall", paramAnonymousInt1);
          }
          catch (Exception paramAnonymousString)
          {
            continue;
          }
          paramAnonymousString = k.huj().toString();
          paramAnonymousp = n.Scc;
          n.na("KEY_LAST_REQUEST_CONFIG_STRING", paramAnonymousString);
          ((PluginSport)com.tencent.mm.kernel.h.az(PluginSport.class)).getDeviceStepManager().bbv(paramAnonymousString);
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(263942);
              if (k.hum() != null) {
                k.hum().cwC();
              }
              AppMethodBeat.o(263942);
            }
          });
          AppMethodBeat.o(149318);
          return;
          paramAnonymousInt1 = 0;
        }
      }
    };
    AppMethodBeat.o(149325);
  }
  
  public static void EC(boolean paramBoolean)
  {
    AppMethodBeat.i(149320);
    Object localObject = huj();
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
        n localn = n.Scc;
        n.na("KEY_LAST_REQUEST_CONFIG_STRING", (String)localObject);
        ((PluginSport)com.tencent.mm.kernel.h.az(PluginSport.class)).getDeviceStepManager().bbv((String)localObject);
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(263927);
            if (k.hum() != null) {
              k.hum().cwC();
            }
            AppMethodBeat.o(263927);
          }
        });
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
  
  public static void a(a parama)
  {
    SbV = parama;
  }
  
  private static void bR(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(149323);
    try
    {
      if (MMApplicationContext.isMainProcess())
      {
        if (!p.htT()) {
          break label83;
        }
        i = 1;
        if (paramJSONObject.optInt("checkWeSportInstall", 0) != i) {
          if (!p.htT()) {
            break label88;
          }
        }
      }
      label83:
      label88:
      for (int i = j;; i = 0)
      {
        paramJSONObject.put("checkWeSportInstall", i);
        paramJSONObject = paramJSONObject.toString();
        n localn = n.Scc;
        n.na("KEY_LAST_REQUEST_CONFIG_STRING", paramJSONObject);
        f.Ozc.idkeyStat(323L, 5L, 1L, false);
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
  
  public static void bbw(String paramString)
  {
    AppMethodBeat.i(149321);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(149321);
      return;
    }
    try
    {
      SbU = new JSONObject(paramString);
      AppMethodBeat.o(149321);
      return;
    }
    catch (Exception paramString)
    {
      SbU = null;
      AppMethodBeat.o(149321);
    }
  }
  
  public static boolean hui()
  {
    AppMethodBeat.i(149319);
    n localn;
    if (SbT == 0L)
    {
      localn = n.Scc;
      SbT = n.bH("KEY_LAST_REQUEST_CONFIG_TIME_LONG", 0L);
    }
    if (cn.bDw() - SbT > 86400000L)
    {
      SbT = cn.bDw();
      localn = n.Scc;
      n.bI("KEY_LAST_REQUEST_CONFIG_TIME_LONG", SbT);
      Log.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
      com.tencent.mm.kernel.h.aZW().a(1947, maV);
      com.tencent.mm.kernel.h.aZW().a(new d(), 0);
      AppMethodBeat.o(149319);
      return true;
    }
    Log.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[] { p.iY(SbT) });
    AppMethodBeat.o(149319);
    return false;
  }
  
  public static JSONObject huj()
  {
    AppMethodBeat.i(149322);
    String str2;
    if (SbU == null)
    {
      localObject1 = n.Scc;
      kotlin.g.b.s.u("KEY_LAST_REQUEST_CONFIG_STRING", "key");
      kotlin.g.b.s.u("", "defaultString");
      str2 = n.hur().decodeString("KEY_LAST_REQUEST_CONFIG_STRING", "");
      kotlin.g.b.s.s(str2, "stepMMKV.decodeString(key, defaultString)");
      str1 = "";
      localObject1 = str1;
      if (Util.isNullOrNil(str2)) {}
    }
    try
    {
      localObject1 = new JSONObject(str2);
      SbU = (JSONObject)localObject1;
      bR((JSONObject)localObject1);
      localObject1 = "server config";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = str1;
      }
    }
    if (SbU == null)
    {
      localObject1 = huk();
      SbU = (JSONObject)localObject1;
      bR((JSONObject)localObject1);
      localObject1 = "asset";
    }
    if (SbU == null)
    {
      SbU = new JSONObject();
      localObject1 = "new";
    }
    Log.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[] { localObject1, SbU.toString() });
    Object localObject1 = SbU;
    AppMethodBeat.o(149322);
    return localObject1;
  }
  
  private static JSONObject huk()
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
      localJSONObject2 = new JSONObject(new String(e.readFromStream((InputStream)localObject4)));
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
        break label122;
      }
    }
    AppMethodBeat.o(149324);
    return localObject3;
  }
  
  public static abstract interface a
  {
    public abstract void cwC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.k
 * JD-Core Version:    0.7.0.1
 */