package com.tencent.tencentmap.mapsdk.a;

import android.os.AsyncTask;
import java.io.Closeable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

final class sx$b
  extends AsyncTask<String, Void, Boolean>
{
  private sx.a a;
  
  public sx$b(sx.a parama)
  {
    this.a = parama;
  }
  
  private Boolean a(String... paramVarArgs)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    try
    {
      paramVarArgs = (HttpURLConnection)new URL(paramVarArgs[0]).openConnection();
      localObject2 = localObject3;
      localObject1 = localObject4;
      paramVarArgs.setRequestProperty("Accept-Encoding", "gzip");
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (paramVarArgs.getResponseCode() == 200)
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        String str = paramVarArgs.getHeaderField("Content-Encoding");
        int i;
        if (str != null)
        {
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (str.length() > 0)
          {
            localObject2 = localObject3;
            localObject1 = localObject4;
            if (str.toLowerCase().contains("gzip"))
            {
              i = 1;
              if (i == 0) {
                break label214;
              }
              localObject2 = localObject3;
              localObject1 = localObject4;
            }
          }
        }
        for (paramVarArgs = new GZIPInputStream(paramVarArgs.getInputStream());; paramVarArgs = paramVarArgs.getInputStream())
        {
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          localObject3 = new JSONObject(new String(sx.a(paramVarArgs)));
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          if (((JSONObject)localObject3).optInt("error") == 0) {
            break label230;
          }
          sx.a(paramVarArgs);
          return Boolean.valueOf(false);
          i = 0;
          break;
          label214:
          localObject2 = localObject3;
          localObject1 = localObject4;
        }
        label230:
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        localObject3 = ((JSONObject)localObject3).optJSONObject("info");
        if (localObject3 == null)
        {
          sx.a(paramVarArgs);
          return Boolean.valueOf(false);
        }
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        localObject3 = ((JSONObject)localObject3).optJSONObject("raster");
        if (localObject3 == null)
        {
          sx.a(paramVarArgs);
          return Boolean.valueOf(false);
        }
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        int n = ((JSONObject)localObject3).optInt("style", 1000);
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        int i1 = ((JSONObject)localObject3).optInt("version", sq.a);
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        int i2 = ((JSONObject)localObject3).optInt("sat", sq.c);
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        int i3 = ((JSONObject)localObject3).optInt("cur", sq.b);
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        localObject3 = ua.a();
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        ((ua)localObject3).a("tencent_style", n);
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        ((ua)localObject3).a("tencent_version", i1);
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        ((ua)localObject3).a("sat_version", i2);
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        ((ua)localObject3).a("tencent_clean_cache_version", i3);
        localObject2 = paramVarArgs;
        localObject1 = paramVarArgs;
        boolean bool1;
        boolean bool2;
        label469:
        label506:
        int j;
        label522:
        int k;
        if (tp.c() != i3)
        {
          bool1 = true;
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          if (tp.d() == i2) {
            break label596;
          }
          bool2 = true;
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          new sx.b.1(this, bool1, bool2).start();
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          if (i1 == tp.b()) {
            break label602;
          }
          i = 1;
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          if (n == tp.a()) {
            break label607;
          }
          j = 1;
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          if (i3 == tp.c()) {
            break label612;
          }
          k = 1;
          label539:
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          if (i2 == tp.d()) {
            break label618;
          }
        }
        label596:
        label602:
        label607:
        label612:
        label618:
        for (int m = 1;; m = 0)
        {
          localObject2 = paramVarArgs;
          localObject1 = paramVarArgs;
          tp.a(n, i1, i3, i2);
          sx.a(paramVarArgs);
          return Boolean.valueOf(m | i | j | k);
          bool1 = false;
          break;
          bool2 = false;
          break label469;
          i = 0;
          break label506;
          j = 0;
          break label522;
          k = 0;
          break label539;
        }
      }
      sx.a(null);
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        localObject1 = localObject2;
        new StringBuilder("check version got error:").append(paramVarArgs.getMessage());
        sx.a((Closeable)localObject2);
      }
    }
    finally
    {
      sx.a((Closeable)localObject1);
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sx.b
 * JD-Core Version:    0.7.0.1
 */