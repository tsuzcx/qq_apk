package com.tencent.youtu.ytcommon.auth;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil
{
  private static final String CHARSET_UTF8 = "UTF-8";
  private static final int DEFAULT_TIMEOUT_MILLIS = 10000;
  
  private static HttpURLConnection buildConnection(String paramString, int paramInt)
  {
    AppMethodBeat.i(118055);
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setConnectTimeout(paramInt);
    paramString.setReadTimeout(paramInt);
    AppMethodBeat.o(118055);
    return paramString;
  }
  
  private static String getResponse(HttpURLConnection paramHttpURLConnection, HttpUtil.HttpResponseListener paramHttpResponseListener)
  {
    AppMethodBeat.i(118056);
    int i;
    StringBuilder localStringBuilder;
    try
    {
      i = paramHttpURLConnection.getResponseCode();
      if (i != 200) {
        break label103;
      }
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localStringBuilder = new StringBuilder();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        i = paramHttpURLConnection.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localStringBuilder.append(new String(arrayOfByte, 0, i));
      }
      paramHttpURLConnection.close();
    }
    catch (Exception paramHttpURLConnection)
    {
      AppMethodBeat.o(118056);
      return null;
    }
    paramHttpURLConnection = localStringBuilder.toString();
    if (paramHttpResponseListener != null) {
      paramHttpResponseListener.onSuccess(paramHttpURLConnection);
    }
    AppMethodBeat.o(118056);
    return paramHttpURLConnection;
    label103:
    if (paramHttpResponseListener != null) {
      paramHttpResponseListener.onFail(i);
    }
    AppMethodBeat.o(118056);
    return null;
  }
  
  public static String post(String paramString1, String paramString2, HttpUtil.HttpResponseListener paramHttpResponseListener)
  {
    AppMethodBeat.i(118054);
    paramString1 = buildConnection(paramString1, 10000);
    paramString1.setRequestProperty("Content-Type", "application/json");
    paramString1.setRequestMethod("POST");
    if (!TextUtils.isEmpty(paramString2))
    {
      OutputStream localOutputStream = paramString1.getOutputStream();
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localOutputStream, "UTF-8"));
      localBufferedWriter.write(paramString2);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localOutputStream.close();
    }
    paramString1 = getResponse(paramString1, paramHttpResponseListener);
    AppMethodBeat.o(118054);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.HttpUtil
 * JD-Core Version:    0.7.0.1
 */