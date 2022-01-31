package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.t;
import com.tencent.tencentmap.mapsdk.a.u;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class lj
  extends AsyncTask<Object, Void, Boolean>
{
  private static String a;
  private Context b;
  private WeakReference<lj.a> c;
  
  public lj(Context paramContext, lj.a parama)
  {
    AppMethodBeat.i(149160);
    this.b = paramContext;
    a = "https://overseactrl.map.qq.com/?" + a(paramContext);
    this.c = new WeakReference(parama);
    AppMethodBeat.o(149160);
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(149164);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(149164);
      return false;
    }
    boolean bool2;
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("error", -2147483648) != 0)
        {
          bool2 = nn.d() ^ false | false;
          nn.a(false);
          u.a(this.b).a("worldMapEnabled", false);
          localJSONObject = paramString.optJSONObject("info");
          if (localJSONObject != null) {
            break;
          }
          AppMethodBeat.o(149164);
          return bool2;
        }
      }
      catch (Exception paramString)
      {
        u.a(this.b).a("worldMapProtocolVersion", 0);
        AppMethodBeat.o(149164);
        return false;
      }
      bool2 = nn.d() ^ true | false;
      nn.a(true);
      u.a(this.b).a("worldMapEnabled", true);
    }
    int n = localJSONObject.optInt("version");
    if (n != nn.f()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 |= bool1;
      if (bool2) {
        break;
      }
      AppMethodBeat.o(149164);
      return bool2;
    }
    paramString = localJSONObject.optJSONObject("frontier");
    if (paramString != null) {
      a(paramString.optString("path"));
    }
    Object localObject1 = localJSONObject.optJSONObject("tilesrc");
    int j = -1;
    int i = -1;
    int k = -1;
    paramString = null;
    Object localObject2 = new int[0];
    Object localObject3 = "[]";
    String str;
    if (localObject1 != null)
    {
      int m = ((JSONObject)localObject1).optInt("style", 1000);
      k = ((JSONObject)localObject1).optInt("scene", no.a);
      j = ((JSONObject)localObject1).optInt("version", no.b);
      str = ((JSONObject)localObject1).optString("url");
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("range");
      paramString = (String)localObject2;
      localObject1 = localObject3;
      if (!StringUtil.isEmpty(str))
      {
        paramString = (String)localObject2;
        localObject1 = localObject3;
        if (localJSONArray != null)
        {
          localObject1 = localJSONArray.toString();
          paramString = new int[localJSONArray.length()];
          i = 0;
          while (i < paramString.length)
          {
            paramString[i] = localJSONArray.optInt(i);
            i += 1;
          }
        }
      }
      if ((j != nn.c()) || (m != nn.a())) {
        ni.a(this.b).a(0);
      }
      i = k;
      localObject2 = paramString;
      paramString = str;
      k = j;
      j = m;
    }
    for (;;)
    {
      localObject3 = localJSONObject.optJSONArray("detail");
      str = "";
      if (localObject3 != null) {
        str = ((JSONArray)localObject3).toString();
      }
      nn.a(i, j, k, n, paramString, (int[])localObject2, str);
      u.a(this.b).a("worldMapTileUrlRegex", paramString);
      u.a(this.b).a("worldMapTileUrlRangeJson", (String)localObject1);
      u.a(this.b).a("worldMapVersion", k);
      u.a(this.b).a("worldMapStyle", j);
      u.a(this.b).a("worldMapScene", i);
      u.a(this.b).a("worldMapLogoChangeRuleJson", str);
      u.a(this.b).a("worldMapProtocolVersion", n);
      AppMethodBeat.o(149164);
      return bool2;
      localObject1 = "[]";
    }
  }
  
  protected Boolean a(Object... paramVarArgs)
  {
    AppMethodBeat.i(149162);
    try
    {
      paramVarArgs = (HttpURLConnection)new URL(a).openConnection();
      paramVarArgs.setRequestProperty("Accept-Encoding", "gzip");
      if (paramVarArgs.getResponseCode() == 200)
      {
        String str = paramVarArgs.getHeaderField("Content-Encoding");
        int i;
        if ((str != null) && (str.length() > 0) && (str.toLowerCase().contains("gzip")))
        {
          i = 1;
          if (i == 0) {
            break label123;
          }
        }
        label123:
        for (paramVarArgs = new GZIPInputStream(paramVarArgs.getInputStream());; paramVarArgs = paramVarArgs.getInputStream())
        {
          boolean bool = b(new String(t.a(paramVarArgs)));
          AppMethodBeat.o(149162);
          return Boolean.valueOf(bool);
          i = 0;
          break;
        }
      }
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      paramVarArgs = Boolean.FALSE;
      AppMethodBeat.o(149162);
    }
  }
  
  public String a(Context paramContext)
  {
    AppMethodBeat.i(149161);
    paramContext = String.format("apikey=%s&ver=%s&ctrlver=%s&uk=%s&frontier=%s&ctrlpf=vector&ctrlmb=and", new Object[] { ka.a, "4.2.3", Integer.valueOf(u.a(paramContext).b("worldMapProtocolVersion")), ka.a(), Integer.valueOf(u.a(paramContext).b("worldMapFrontierVersion")) });
    AppMethodBeat.o(149161);
    return paramContext;
  }
  
  protected void a(Boolean paramBoolean)
  {
    AppMethodBeat.i(149163);
    super.onPostExecute(paramBoolean);
    if ((this.c != null) && (this.c.get() != null)) {
      ((lj.a)this.c.get()).a(paramBoolean.booleanValue());
    }
    AppMethodBeat.o(149163);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(149165);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(149165);
      return;
    }
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setRequestProperty("Accept-Encoding", "gzip");
      if (paramString.getResponseCode() == 200)
      {
        String str = paramString.getHeaderField("Content-Encoding");
        if ((str != null) && (str.length() > 0)) {
          str.toLowerCase().contains("gzip");
        }
        paramString = new String(t.a(new GZIPInputStream(paramString.getInputStream())));
        int i = nk.a().b(paramString);
        u.a(this.b).a("worldMapFrontierVersion", i);
        nk.a().a(paramString);
      }
      AppMethodBeat.o(149165);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(149165);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lj
 * JD-Core Version:    0.7.0.1
 */