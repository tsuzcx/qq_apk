package com.tencent.mm.ui.i.a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.c;
import com.tencent.xweb.d;
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

public final class f
{
  private static String O(InputStream paramInputStream)
  {
    AppMethodBeat.i(152839);
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1000);
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(152839);
    return paramInputStream;
  }
  
  public static void ag(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152842);
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.create().show();
    AppMethodBeat.o(152842);
  }
  
  private static Bundle bAq(String paramString)
  {
    AppMethodBeat.i(152836);
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
    AppMethodBeat.o(152836);
    return localBundle;
  }
  
  public static Bundle bAr(String paramString)
  {
    AppMethodBeat.i(152837);
    paramString = paramString.replace("fbconnect", "http");
    try
    {
      paramString = new URL(paramString);
      Bundle localBundle = bAq(paramString.getQuery());
      localBundle.putAll(bAq(paramString.getRef()));
      AppMethodBeat.o(152837);
      return localBundle;
    }
    catch (MalformedURLException paramString)
    {
      paramString = new Bundle();
      AppMethodBeat.o(152837);
    }
    return paramString;
  }
  
  public static JSONObject bAs(String paramString)
  {
    AppMethodBeat.i(152841);
    if (paramString.equals("false"))
    {
      paramString = new e("request failed");
      AppMethodBeat.o(152841);
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
      paramString = new e(paramString.getString("message"), paramString.getString("type"), 0);
      AppMethodBeat.o(152841);
      throw paramString;
    }
    if ((paramString.has("error_code")) && (paramString.has("error_msg")))
    {
      paramString = new e(paramString.getString("error_msg"), "", Integer.parseInt(paramString.getString("error_code")));
      AppMethodBeat.o(152841);
      throw paramString;
    }
    if (paramString.has("error_code"))
    {
      paramString = new e("request failed", "", Integer.parseInt(paramString.getString("error_code")));
      AppMethodBeat.o(152841);
      throw paramString;
    }
    if (paramString.has("error_msg"))
    {
      paramString = new e(paramString.getString("error_msg"));
      AppMethodBeat.o(152841);
      throw paramString;
    }
    if (paramString.has("error_reason"))
    {
      paramString = new e(paramString.getString("error_reason"));
      AppMethodBeat.o(152841);
      throw paramString;
    }
    AppMethodBeat.o(152841);
    return paramString;
  }
  
  public static String bt(Bundle paramBundle)
  {
    AppMethodBeat.i(152835);
    if (paramBundle == null)
    {
      AppMethodBeat.o(152835);
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
    AppMethodBeat.o(152835);
    return paramBundle;
  }
  
  public static String e(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(152838);
    Object localObject1 = paramString1;
    if (paramString2.equals("GET")) {
      localObject1 = paramString1 + "?" + bt(paramBundle);
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
      paramString1 = O(((HttpURLConnection)localObject1).getInputStream());
    }
    catch (FileNotFoundException paramString1)
    {
      try
      {
        for (;;)
        {
          ((HttpURLConnection)localObject1).getInputStream().close();
          ((HttpURLConnection)localObject1).disconnect();
          AppMethodBeat.o(152838);
          return paramString1;
          paramString1 = paramString1;
          paramString1 = O(((HttpURLConnection)localObject1).getErrorStream());
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
  
  public static void lw(Context paramContext)
  {
    AppMethodBeat.i(152840);
    d.my(paramContext);
    c.ivX().removeAllCookie();
    AppMethodBeat.o(152840);
  }
  
  private static String m(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(152834);
    if (paramBundle == null)
    {
      AppMethodBeat.o(152834);
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
    AppMethodBeat.o(152834);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.f
 * JD-Core Version:    0.7.0.1
 */