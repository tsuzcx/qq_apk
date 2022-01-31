package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public final class tg
{
  private tg.b a;
  private String b;
  
  public tg(Context paramContext, tg.a parama)
  {
    paramContext = ub.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://overseactrl.map.qq.com/?apikey=");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("&ver=");
    localStringBuilder.append("1.3.2.cb07f1c");
    localStringBuilder.append("&ctrlpf=grid");
    localStringBuilder.append("&ctrlmb=and");
    localStringBuilder.append("&ctrlver=");
    localStringBuilder.append(tp.i());
    this.b = localStringBuilder.toString();
    this.a = new tg.b(this, parama);
  }
  
  private boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("error", -2147483648) != 0)
      {
        tp.a(false);
        ua.a().a("world_map_enable", false);
        paramString = paramString.getJSONObject("info").getJSONArray("detail").toString();
        ua.a().a("world_map_logo_change_rule_json", paramString);
        tp.a(paramString);
        return true;
      }
      tp.a(true);
      ua.a().a("world_map_enable", true);
      paramString = paramString.getJSONObject("info");
      Object localObject = paramString.optJSONObject("frontier");
      int j;
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("path");
        if ((localObject != null) && (((String)localObject).length() != 0)) {}
      }
      else
      {
        j = paramString.getInt("version");
        i = tp.i();
        if (j == i) {
          break label289;
        }
      }
      label289:
      for (int i = 1;; i = 0)
      {
        for (;;)
        {
          if (i != 0) {
            break label294;
          }
          return false;
          try
          {
            localObject = (HttpURLConnection)new URL((String)localObject).openConnection();
            ((HttpURLConnection)localObject).setRequestProperty("Accept-Encoding", "gzip");
            if (((HttpURLConnection)localObject).getResponseCode() != 200) {
              break;
            }
            String str = ((HttpURLConnection)localObject).getHeaderField("Content-Encoding");
            if ((str != null) && (str.length() > 0)) {
              str.toLowerCase().contains("gzip");
            }
            localObject = new String(sx.a(new GZIPInputStream(((HttpURLConnection)localObject).getInputStream())));
            tm.a();
            i = tm.b((String)localObject);
            ua.a().a("", i);
            tm.a().a((String)localObject);
          }
          catch (Throwable localThrowable) {}
        }
        break;
      }
      label294:
      tp.m();
      JSONObject localJSONObject = paramString.getJSONObject("tilesrc");
      i = localJSONObject.optInt("style", 1000);
      int k = localJSONObject.optInt("scene", 0);
      int m = localJSONObject.optInt("version", sq.e);
      if (m != tp.g()) {
        ug.a().a(ue.a.b);
      }
      paramString = paramString.getJSONArray("detail").toString();
      tp.a(k, i, m, j, null, paramString);
      ua.a().a("world_map_tile_url_regex", null);
      ua.a().a("world_map_version", m);
      ua.a().a("world_map_style", i);
      ua.a().a("world_map_scene", k);
      ua.a().a("world_map_logo_change_rule_json", paramString);
      ua.a().a("world_map_protocol_version", j);
      return true;
    }
    catch (Throwable paramString)
    {
      ua.a().a("world_map_protocol_version", 0);
    }
    return false;
  }
  
  public final void a()
  {
    this.a.execute(new String[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tg
 * JD-Core Version:    0.7.0.1
 */