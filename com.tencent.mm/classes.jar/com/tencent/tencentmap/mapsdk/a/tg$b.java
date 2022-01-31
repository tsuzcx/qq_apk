package com.tencent.tencentmap.mapsdk.a;

import android.os.AsyncTask;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

final class tg$b
  extends AsyncTask<String, Void, Boolean>
{
  private WeakReference<tg.a> a;
  
  public tg$b(tg paramtg, tg.a parama)
  {
    this.a = new WeakReference(parama);
  }
  
  private Boolean a(String... paramVarArgs)
  {
    String str1 = null;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localObject = str1;
      for (;;)
      {
        try
        {
          i = ua.a().b("");
          localObject = str1;
          paramVarArgs = (HttpURLConnection)new URL(paramVarArgs[0] + "&frontier=" + i).openConnection();
          localObject = str1;
          paramVarArgs.setRequestProperty("Accept-Encoding", "gzip");
          localObject = str1;
          if (paramVarArgs.getResponseCode() == 200)
          {
            localObject = str1;
            String str2 = paramVarArgs.getHeaderField("Content-Encoding");
            if (str2 != null)
            {
              localObject = str1;
              if (str2.length() > 0)
              {
                localObject = str1;
                if (str2.toLowerCase().contains("gzip"))
                {
                  i = 1;
                  if (i == 0) {
                    continue;
                  }
                  localObject = str1;
                  paramVarArgs = new GZIPInputStream(paramVarArgs.getInputStream());
                  localObject = paramVarArgs;
                }
              }
            }
          }
        }
        catch (Throwable paramVarArgs)
        {
          int i;
          boolean bool;
          paramVarArgs = null;
          sx.a(paramVarArgs);
          continue;
        }
        finally
        {
          sx.a((Closeable)localObject);
        }
        try
        {
          str1 = new String(sx.a(paramVarArgs));
          localObject = paramVarArgs;
          bool = tg.a(this.b, str1);
          sx.a(paramVarArgs);
          return Boolean.valueOf(bool);
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        i = 0;
        continue;
        localObject = str1;
        paramVarArgs = paramVarArgs.getInputStream();
      }
      sx.a(null);
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tg.b
 * JD-Core Version:    0.7.0.1
 */