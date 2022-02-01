package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.e;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import kotlin.g.b.p;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  private static long Lyg;
  private static JSONObject Lyh;
  private static a Lyi;
  private static com.tencent.mm.an.i jxB;
  
  static
  {
    AppMethodBeat.i(149325);
    jxB = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        int i = 1;
        AppMethodBeat.i(149318);
        if ((paramAnonymousq instanceof d))
        {
          com.tencent.mm.kernel.h.aGY().b(1947, k.gaU());
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = ((d)paramAnonymousq).LxP;
            Log.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[] { paramAnonymousString.RJE });
            k.bcI(paramAnonymousString.RJE);
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousString = k.gaS();
            if (!n.gaC()) {
              continue;
            }
            paramAnonymousInt1 = i;
            paramAnonymousString.put("checkWeSportInstall", paramAnonymousInt1);
          }
          catch (Exception paramAnonymousString)
          {
            continue;
          }
          paramAnonymousString = k.gaS().toString();
          paramAnonymousq = m.Lyn;
          m.ls("KEY_LAST_REQUEST_CONFIG_STRING", paramAnonymousString);
          ((PluginSport)com.tencent.mm.kernel.h.ag(PluginSport.class)).getDeviceStepManager().bcH(paramAnonymousString);
          com.tencent.e.h.ZvG.be(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221392);
              if (k.gaV() != null) {
                k.gaV().bWp();
              }
              AppMethodBeat.o(221392);
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
  
  public static void a(a parama)
  {
    Lyi = parama;
  }
  
  public static void bcI(String paramString)
  {
    AppMethodBeat.i(149321);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(149321);
      return;
    }
    try
    {
      Lyh = new JSONObject(paramString);
      AppMethodBeat.o(149321);
      return;
    }
    catch (Exception paramString)
    {
      Lyh = null;
      AppMethodBeat.o(149321);
    }
  }
  
  private static void bz(JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(149323);
    try
    {
      if (MMApplicationContext.isMainProcess())
      {
        if (!n.gaC()) {
          break label83;
        }
        i = 1;
        if (paramJSONObject.optInt("checkWeSportInstall", 0) != i) {
          if (!n.gaC()) {
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
        m localm = m.Lyn;
        m.ls("KEY_LAST_REQUEST_CONFIG_STRING", paramJSONObject);
        f.Iyx.idkeyStat(323L, 5L, 1L, false);
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
  
  public static boolean gaR()
  {
    AppMethodBeat.i(149319);
    m localm;
    if (Lyg == 0L)
    {
      localm = m.Lyn;
      Lyg = m.bv("KEY_LAST_REQUEST_CONFIG_TIME_LONG", 0L);
    }
    if (System.currentTimeMillis() - Lyg > 86400000L)
    {
      Lyg = System.currentTimeMillis();
      localm = m.Lyn;
      m.bw("KEY_LAST_REQUEST_CONFIG_TIME_LONG", Lyg);
      Log.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
      com.tencent.mm.kernel.h.aGY().a(1947, jxB);
      com.tencent.mm.kernel.h.aGY().a(new d(), 0);
      AppMethodBeat.o(149319);
      return true;
    }
    Log.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[] { n.GN(Lyg) });
    AppMethodBeat.o(149319);
    return false;
  }
  
  public static JSONObject gaS()
  {
    AppMethodBeat.i(149322);
    String str2;
    if (Lyh == null)
    {
      localObject1 = m.Lyn;
      p.k("KEY_LAST_REQUEST_CONFIG_STRING", "key");
      p.k("", "defaultString");
      str2 = m.gaY().decodeString("KEY_LAST_REQUEST_CONFIG_STRING", "");
      p.j(str2, "stepMMKV.decodeString(key, defaultString)");
      str1 = "";
      localObject1 = str1;
      if (Util.isNullOrNil(str2)) {}
    }
    try
    {
      localObject1 = new JSONObject(str2);
      Lyh = (JSONObject)localObject1;
      bz((JSONObject)localObject1);
      localObject1 = "server config";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = str1;
      }
    }
    if (Lyh == null)
    {
      localObject1 = gaT();
      Lyh = (JSONObject)localObject1;
      bz((JSONObject)localObject1);
      localObject1 = "asset";
    }
    if (Lyh == null)
    {
      Lyh = new JSONObject();
      localObject1 = "new";
    }
    Log.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[] { localObject1, Lyh.toString() });
    Object localObject1 = Lyh;
    AppMethodBeat.o(149322);
    return localObject1;
  }
  
  private static JSONObject gaT()
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
        break label120;
      }
    }
    AppMethodBeat.o(149324);
    return localObject3;
  }
  
  public static void zl(boolean paramBoolean)
  {
    AppMethodBeat.i(149320);
    Object localObject = gaS();
    int i;
    if (paramBoolean) {
      i = 1;
    }
    try
    {
      for (;;)
      {
        ((JSONObject)localObject).put("checkWeSportInstall", i);
        label24:
        localObject = ((JSONObject)localObject).toString();
        m localm = m.Lyn;
        m.ls("KEY_LAST_REQUEST_CONFIG_STRING", (String)localObject);
        ((PluginSport)com.tencent.mm.kernel.h.ag(PluginSport.class)).getDeviceStepManager().bcH((String)localObject);
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221693);
            if (k.gaV() != null) {
              k.gaV().bWp();
            }
            AppMethodBeat.o(221693);
          }
        });
        AppMethodBeat.o(149320);
        return;
        i = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      break label24;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bWp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.k
 * JD-Core Version:    0.7.0.1
 */