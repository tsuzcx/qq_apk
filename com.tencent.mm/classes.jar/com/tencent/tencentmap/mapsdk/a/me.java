package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.lib.util.StringUtil;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class me
  extends AsyncTask<String, Void, Boolean>
{
  private static String a;
  private Context b;
  private WeakReference<me.a> c;
  
  public me(Context paramContext, me.a parama)
  {
    this.b = paramContext;
    a = "https://overseactrl.map.qq.com/?" + a(paramContext);
    this.c = new WeakReference(parama);
  }
  
  private boolean b(String paramString)
  {
    int i = 1;
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    int i1;
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("error", -2147483648) != 0)
        {
          i1 = nb.d() ^ false | false;
          nb.a(false);
          w.a(this.b).a("worldMapEnabled", false);
          localJSONObject = paramString.optJSONObject("info");
          if (localJSONObject != null) {
            break;
          }
          return i1;
        }
      }
      catch (Exception paramString)
      {
        w.a(this.b).a("worldMapProtocolVersion", 0);
        return false;
      }
      i1 = nb.d() ^ true | false;
      nb.a(true);
      w.a(this.b).a("worldMapEnabled", true);
    }
    int n = localJSONObject.optInt("version");
    if (n != nb.f()) {}
    for (;;)
    {
      i1 |= i;
      if (i1 != 0) {
        break;
      }
      return i1;
      i = 0;
    }
    paramString = localJSONObject.optJSONObject("frontier");
    if (paramString != null) {
      a(paramString.optString("path"));
    }
    Object localObject1 = localJSONObject.optJSONObject("tilesrc");
    paramString = null;
    Object localObject2 = new int[0];
    Object localObject3 = "[]";
    int m;
    int k;
    String str;
    if (localObject1 != null)
    {
      m = ((JSONObject)localObject1).optInt("style", 1000);
      k = ((JSONObject)localObject1).optInt("scene", nc.a);
      j = ((JSONObject)localObject1).optInt("version", nc.b);
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
      if ((j != nb.c()) || (m != nb.a())) {
        mw.a(this.b).a(0);
      }
      i = k;
      localObject2 = paramString;
      paramString = str;
      k = j;
    }
    for (int j = m;; j = -1)
    {
      localObject3 = localJSONObject.optJSONArray("detail");
      str = "";
      if (localObject3 != null) {
        str = ((JSONArray)localObject3).toString();
      }
      nb.a(i, j, k, n, paramString, (int[])localObject2, str);
      w.a(this.b).a("worldMapTileUrlRegex", paramString);
      w.a(this.b).a("worldMapTileUrlRangeJson", (String)localObject1);
      w.a(this.b).a("worldMapVersion", k);
      w.a(this.b).a("worldMapStyle", j);
      w.a(this.b).a("worldMapScene", i);
      w.a(this.b).a("worldMapLogoChangeRuleJson", str);
      w.a(this.b).a("worldMapProtocolVersion", n);
      return i1;
      localObject1 = "[]";
      k = -1;
      i = -1;
    }
  }
  
  protected Boolean a(String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        paramVarArgs = (HttpURLConnection)new URL(a).openConnection();
        paramVarArgs.setRequestProperty("Accept-Encoding", "gzip");
        if (paramVarArgs.getResponseCode() == 200)
        {
          String str = paramVarArgs.getHeaderField("Content-Encoding");
          if ((str != null) && (str.length() > 0) && (str.toLowerCase().contains("gzip")))
          {
            i = 1;
            if (i != 0)
            {
              paramVarArgs = new GZIPInputStream(paramVarArgs.getInputStream());
              return Boolean.valueOf(b(new String(v.a(paramVarArgs))));
            }
            paramVarArgs = paramVarArgs.getInputStream();
            continue;
          }
        }
        else
        {
          return Boolean.valueOf(false);
        }
      }
      catch (Throwable paramVarArgs) {}
      int i = 0;
    }
  }
  
  public String a(Context paramContext)
  {
    return String.format("apikey=%s&ver=%s&ctrlver=%s&uk=%s&frontier=%s&ctrlpf=vector&ctrlmb=and", new Object[] { lq.a, "4.1.1", Integer.valueOf(w.a(paramContext).b("worldMapProtocolVersion")), lq.a(), Integer.valueOf(w.a(paramContext).b("worldMapFrontierVersion")) });
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if ((this.c != null) && (this.c.get() != null)) {
      ((me.a)this.c.get()).a(paramBoolean.booleanValue());
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
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
          paramString = new String(v.a(new GZIPInputStream(paramString.getInputStream())));
          int i = my.a().b(paramString);
          w.a(this.b).a("worldMapFrontierVersion", i);
          my.a().a(paramString);
          return;
        }
      }
      catch (Throwable paramString) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.me
 * JD-Core Version:    0.7.0.1
 */