package com.tencent.tencentmap.mapsdk.a;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

final class sm$1
  extends Thread
{
  sm$1(sm paramsm) {}
  
  public final void run()
  {
    sm.a(this.a, true);
    int i = 0;
    for (;;)
    {
      if (i < 2) {}
      try
      {
        Object localObject = (HttpURLConnection)new URL("https://apikey.map.qq.com/mkey/index.php/mkey/check?" + sm.a(this.a).toString()).openConnection();
        ((HttpURLConnection)localObject).setRequestProperty("Accept-Encoding", "gzip");
        if (((HttpURLConnection)localObject).getResponseCode() == 200)
        {
          String str = ((HttpURLConnection)localObject).getHeaderField("Content-Encoding");
          int j;
          if ((str != null) && (str.length() > 0) && (str.toLowerCase().contains("gzip")))
          {
            j = 1;
            if (j == 0) {
              break label170;
            }
          }
          label170:
          for (localObject = new BufferedInputStream(new GZIPInputStream(((HttpURLConnection)localObject).getInputStream()));; localObject = new BufferedInputStream(((HttpURLConnection)localObject).getInputStream()))
          {
            localObject = new String(sx.a((InputStream)localObject));
            sm.a(this.a, (String)localObject);
            sm.a(this.a, false);
            return;
            j = 0;
            break;
          }
        }
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sm.1
 * JD-Core Version:    0.7.0.1
 */