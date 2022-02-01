package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientUtil
{
  public static HttpClient createHttpClient()
  {
    AppMethodBeat.i(102015);
    Object localObject = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 30000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject, 30000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject, 4096);
    HttpClientParams.setRedirecting((HttpParams)localObject, false);
    localObject = new DefaultHttpClient((HttpParams)localObject);
    AppMethodBeat.o(102015);
    return localObject;
  }
  
  public static void setProxy(HttpClient paramHttpClient)
  {
    AppMethodBeat.i(102014);
    Object localObject = DownloadHelper.getNetStatus();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).equalsIgnoreCase("cmwap")) || (((String)localObject).equalsIgnoreCase("3gwap")) || (((String)localObject).equalsIgnoreCase("uniwap")))
      {
        localObject = new HttpHost("10.0.0.172", 80);
        paramHttpClient.getParams().setParameter("http.route.default-proxy", localObject);
        AppMethodBeat.o(102014);
        return;
      }
      if (((String)localObject).equalsIgnoreCase("ctwap"))
      {
        localObject = new HttpHost("10.0.0.200", 80);
        paramHttpClient.getParams().setParameter("http.route.default-proxy", localObject);
      }
    }
    AppMethodBeat.o(102014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.HttpClientUtil
 * JD-Core Version:    0.7.0.1
 */