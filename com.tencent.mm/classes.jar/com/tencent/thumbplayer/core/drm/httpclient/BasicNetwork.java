package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BasicNetwork
  implements Network
{
  private static final int MAX_MANUAL_REDIRECTS = 5;
  private final HttpDataSource.Factory mHttpDataSrcFactory;
  
  public BasicNetwork(HttpDataSource.Factory paramFactory)
  {
    this.mHttpDataSrcFactory = paramFactory;
  }
  
  private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException paramInvalidResponseCodeException)
  {
    AppMethodBeat.i(193811);
    paramInvalidResponseCodeException = paramInvalidResponseCodeException.headerFields;
    if (paramInvalidResponseCodeException != null)
    {
      paramInvalidResponseCodeException = (List)paramInvalidResponseCodeException.get("Location");
      if ((paramInvalidResponseCodeException != null) && (!paramInvalidResponseCodeException.isEmpty()))
      {
        paramInvalidResponseCodeException = (String)paramInvalidResponseCodeException.get(0);
        AppMethodBeat.o(193811);
        return paramInvalidResponseCodeException;
      }
    }
    AppMethodBeat.o(193811);
    return null;
  }
  
  public Response performRequest(Request paramRequest)
  {
    AppMethodBeat.i(193810);
    HttpDataSource localHttpDataSource = this.mHttpDataSrcFactory.createDataSource(paramRequest.getTimeoutMs());
    if (paramRequest.getHeaders() != null)
    {
      localObject1 = paramRequest.getHeaders().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localHttpDataSource.setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
    }
    Object localObject1 = paramRequest.getUrl();
    int i = 0;
    Object localObject2 = new DataSourceInputStream(localHttpDataSource, new DataSpec(Uri.parse((String)localObject1), paramRequest.getHttpMethod(), paramRequest.getPostBody(), 0L, 0L, -1L, null, 1));
    for (;;)
    {
      try
      {
        localObject1 = Response.success(Util.toByteArray((InputStream)localObject2), localHttpDataSource.getResponseHeaders());
        return localObject1;
      }
      catch (HttpDataSource.InvalidResponseCodeException localInvalidResponseCodeException)
      {
        if (localInvalidResponseCodeException.responseCode != 307)
        {
          j = i;
          if (localInvalidResponseCodeException.responseCode == 308)
          {
            break label262;
            label200:
            if (j == 0) {
              break label248;
            }
            localObject1 = getRedirectUrl(localInvalidResponseCodeException);
            label211:
            if (localObject1 != null) {
              break label254;
            }
            AppMethodBeat.o(193810);
            throw localInvalidResponseCodeException;
          }
        }
      }
      finally
      {
        Util.closeQuietly((Closeable)localObject2);
        AppMethodBeat.o(193810);
      }
      label248:
      label254:
      do
      {
        k = 0;
        i = j;
        j = k;
        break label200;
        localObject1 = null;
        break label211;
        Util.closeQuietly((Closeable)localObject2);
        break;
        j = i + 1;
      } while (i >= 5);
      label262:
      int k = 1;
      i = j;
      int j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.BasicNetwork
 * JD-Core Version:    0.7.0.1
 */