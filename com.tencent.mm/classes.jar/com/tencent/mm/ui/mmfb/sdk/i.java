package com.tencent.mm.ui.mmfb.sdk;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  private static String ac(InputStream paramInputStream)
  {
    AppMethodBeat.i(250216);
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1000);
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(250216);
    return paramInputStream;
  }
  
  public static void al(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(250234);
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.create().show();
    AppMethodBeat.o(250234);
  }
  
  private static Bundle bCn(String paramString)
  {
    AppMethodBeat.i(250192);
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
        i += 1;
      }
    }
    AppMethodBeat.o(250192);
    return localBundle;
  }
  
  public static Bundle bCo(String paramString)
  {
    AppMethodBeat.i(250196);
    paramString = paramString.replace("fbconnect", "http");
    try
    {
      paramString = new URL(paramString);
      Bundle localBundle = bCn(paramString.getQuery());
      localBundle.putAll(bCn(paramString.getRef()));
      AppMethodBeat.o(250196);
      return localBundle;
    }
    catch (MalformedURLException paramString)
    {
      paramString = new Bundle();
      AppMethodBeat.o(250196);
    }
    return paramString;
  }
  
  public static JSONObject bCp(String paramString)
  {
    AppMethodBeat.i(250226);
    if (paramString.equals("false"))
    {
      paramString = new h("request failed");
      AppMethodBeat.o(250226);
      throw paramString;
    }
    String str = paramString;
    if (paramString.equals("true")) {
      str = "{value : true}";
    }
    paramString = new JSONObject(str);
    if (paramString.has("error"))
    {
      paramString = paramString.getJSONObject("error");
      paramString = new h(paramString.getString("message"), paramString.getString("type"), 0);
      AppMethodBeat.o(250226);
      throw paramString;
    }
    if ((paramString.has("error_code")) && (paramString.has("error_msg")))
    {
      paramString = new h(paramString.getString("error_msg"), "", Integer.parseInt(paramString.getString("error_code")));
      AppMethodBeat.o(250226);
      throw paramString;
    }
    if (paramString.has("error_code"))
    {
      paramString = new h("request failed", "", Integer.parseInt(paramString.getString("error_code")));
      AppMethodBeat.o(250226);
      throw paramString;
    }
    if (paramString.has("error_msg"))
    {
      paramString = new h(paramString.getString("error_msg"));
      AppMethodBeat.o(250226);
      throw paramString;
    }
    if (paramString.has("error_reason"))
    {
      paramString = new h(paramString.getString("error_reason"));
      AppMethodBeat.o(250226);
      throw paramString;
    }
    AppMethodBeat.o(250226);
    return paramString;
  }
  
  public static String bZ(Bundle paramBundle)
  {
    AppMethodBeat.i(250187);
    if (paramBundle == null)
    {
      AppMethodBeat.o(250187);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(paramBundle.getString(str)));
        break;
        localStringBuilder.append('&');
      }
    }
    paramBundle = localStringBuilder.toString();
    AppMethodBeat.o(250187);
    return paramBundle;
  }
  
  public static String g(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(250209);
    Object localObject1 = paramString1;
    if (paramString2.equals("GET")) {
      localObject1 = paramString1 + "?" + bZ(paramBundle);
    }
    Log.d("Facebook-Util", paramString2 + " URL: " + (String)localObject1);
    localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
    ((HttpURLConnection)localObject1).setConnectTimeout(20000);
    ((HttpURLConnection)localObject1).setReadTimeout(20000);
    ((HttpURLConnection)localObject1).setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
    if (!paramString2.equals("GET"))
    {
      paramString1 = new Bundle();
      Object localObject2 = paramBundle.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (paramBundle.getByteArray(str) != null) {
          paramString1.putByteArray(str, paramBundle.getByteArray(str));
        }
      }
      if (!paramBundle.containsKey("method")) {
        paramBundle.putString("method", paramString2);
      }
      if (paramBundle.containsKey("access_token")) {
        paramBundle.putString("access_token", URLDecoder.decode(paramBundle.getString("access_token")));
      }
      ((HttpURLConnection)localObject1).setRequestMethod("POST");
      ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", "multipart/form-data;boundary=".concat(String.valueOf("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
      ((HttpURLConnection)localObject1).setDoOutput(true);
      ((HttpURLConnection)localObject1).setDoInput(true);
      ((HttpURLConnection)localObject1).setRequestProperty("Connection", "Keep-Alive");
      ((HttpURLConnection)localObject1).connect();
      paramString2 = new BufferedOutputStream(((HttpURLConnection)localObject1).getOutputStream());
      paramString2.write(("--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
      paramString2.write(m(paramBundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
      paramString2.write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
      if (!paramString1.isEmpty())
      {
        paramBundle = paramString1.keySet().iterator();
        while (paramBundle.hasNext())
        {
          localObject2 = (String)paramBundle.next();
          paramString2.write(("Content-Disposition: form-data; filename=\"" + (String)localObject2 + "\"" + "\r\n").getBytes());
          paramString2.write(("Content-Type: content/unknown" + "\r\n" + "\r\n").getBytes());
          paramString2.write(paramString1.getByteArray((String)localObject2));
          paramString2.write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
        }
      }
      paramString2.flush();
    }
    try
    {
      paramString1 = ac(((HttpURLConnection)localObject1).getInputStream());
    }
    catch (FileNotFoundException paramString1)
    {
      try
      {
        for (;;)
        {
          ((HttpURLConnection)localObject1).getInputStream().close();
          ((HttpURLConnection)localObject1).disconnect();
          AppMethodBeat.o(250209);
          return paramString1;
          paramString1 = paramString1;
          paramString1 = ac(((HttpURLConnection)localObject1).getErrorStream());
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.e("FacebookUtil", paramString2.getMessage());
        }
      }
    }
  }
  
  private static String m(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(250182);
    if (paramBundle == null)
    {
      AppMethodBeat.o(250182);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramBundle.getByteArray(str) == null)
      {
        localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n" + paramBundle.getString(str));
        localStringBuilder.append("\r\n--" + paramString + "\r\n");
      }
    }
    paramBundle = localStringBuilder.toString();
    AppMethodBeat.o(250182);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.i
 * JD-Core Version:    0.7.0.1
 */