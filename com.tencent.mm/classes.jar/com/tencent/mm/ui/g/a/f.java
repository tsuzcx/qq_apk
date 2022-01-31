package com.tencent.mm.ui.g.a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
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
  private static String G(InputStream paramInputStream)
  {
    AppMethodBeat.i(80327);
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1000);
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(80327);
    return paramInputStream;
  }
  
  public static void L(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(80330);
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.create().show();
    AppMethodBeat.o(80330);
  }
  
  public static String aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(80323);
    if (paramBundle == null)
    {
      AppMethodBeat.o(80323);
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
    AppMethodBeat.o(80323);
    return paramBundle;
  }
  
  private static Bundle auK(String paramString)
  {
    AppMethodBeat.i(80324);
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
    AppMethodBeat.o(80324);
    return localBundle;
  }
  
  public static Bundle auL(String paramString)
  {
    AppMethodBeat.i(80325);
    paramString = paramString.replace("fbconnect", "http");
    try
    {
      paramString = new URL(paramString);
      Bundle localBundle = auK(paramString.getQuery());
      localBundle.putAll(auK(paramString.getRef()));
      AppMethodBeat.o(80325);
      return localBundle;
    }
    catch (MalformedURLException paramString)
    {
      paramString = new Bundle();
      AppMethodBeat.o(80325);
    }
    return paramString;
  }
  
  public static JSONObject auM(String paramString)
  {
    AppMethodBeat.i(80329);
    if (paramString.equals("false"))
    {
      paramString = new e("request failed");
      AppMethodBeat.o(80329);
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
      AppMethodBeat.o(80329);
      throw paramString;
    }
    if ((paramString.has("error_code")) && (paramString.has("error_msg")))
    {
      paramString = new e(paramString.getString("error_msg"), "", Integer.parseInt(paramString.getString("error_code")));
      AppMethodBeat.o(80329);
      throw paramString;
    }
    if (paramString.has("error_code"))
    {
      paramString = new e("request failed", "", Integer.parseInt(paramString.getString("error_code")));
      AppMethodBeat.o(80329);
      throw paramString;
    }
    if (paramString.has("error_msg"))
    {
      paramString = new e(paramString.getString("error_msg"));
      AppMethodBeat.o(80329);
      throw paramString;
    }
    if (paramString.has("error_reason"))
    {
      paramString = new e(paramString.getString("error_reason"));
      AppMethodBeat.o(80329);
      throw paramString;
    }
    AppMethodBeat.o(80329);
    return paramString;
  }
  
  public static String e(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(80326);
    Object localObject1 = paramString1;
    if (paramString2.equals("GET")) {
      localObject1 = paramString1 + "?" + aJ(paramBundle);
    }
    ab.d("Facebook-Util", paramString2 + " URL: " + (String)localObject1);
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
      paramString1 = G(((HttpURLConnection)localObject1).getInputStream());
    }
    catch (FileNotFoundException paramString1)
    {
      try
      {
        for (;;)
        {
          ((HttpURLConnection)localObject1).getInputStream().close();
          ((HttpURLConnection)localObject1).disconnect();
          AppMethodBeat.o(80326);
          return paramString1;
          paramString1 = paramString1;
          paramString1 = G(((HttpURLConnection)localObject1).getErrorStream());
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ab.e("FacebookUtil", paramString2.getMessage());
        }
      }
    }
  }
  
  public static void iy(Context paramContext)
  {
    AppMethodBeat.i(80328);
    c.jQ(paramContext);
    b.dYg().removeAllCookie();
    AppMethodBeat.o(80328);
  }
  
  private static String m(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(80322);
    if (paramBundle == null)
    {
      AppMethodBeat.o(80322);
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
    AppMethodBeat.o(80322);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.f
 * JD-Core Version:    0.7.0.1
 */