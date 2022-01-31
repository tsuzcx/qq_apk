package com.tencent.mm.ui.f.a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
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

public final class e
{
  public static void B(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.create().show();
  }
  
  private static String F(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1000);
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  private static Bundle aec(String paramString)
  {
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
    return localBundle;
  }
  
  public static Bundle aed(String paramString)
  {
    paramString = paramString.replace("fbconnect", "http");
    try
    {
      paramString = new URL(paramString);
      Bundle localBundle = aec(paramString.getQuery());
      localBundle.putAll(aec(paramString.getRef()));
      return localBundle;
    }
    catch (MalformedURLException paramString) {}
    return new Bundle();
  }
  
  public static JSONObject aee(String paramString)
  {
    if (paramString.equals("false")) {
      throw new d("request failed");
    }
    String str = paramString;
    if (paramString.equals("true")) {
      str = "{value : true}";
    }
    paramString = new JSONObject(str);
    if (paramString.has("error"))
    {
      paramString = paramString.getJSONObject("error");
      throw new d(paramString.getString("message"), paramString.getString("type"), 0);
    }
    if ((paramString.has("error_code")) && (paramString.has("error_msg"))) {
      throw new d(paramString.getString("error_msg"), "", Integer.parseInt(paramString.getString("error_code")));
    }
    if (paramString.has("error_code")) {
      throw new d("request failed", "", Integer.parseInt(paramString.getString("error_code")));
    }
    if (paramString.has("error_msg")) {
      throw new d(paramString.getString("error_msg"));
    }
    if (paramString.has("error_reason")) {
      throw new d(paramString.getString("error_reason"));
    }
    return paramString;
  }
  
  public static String aq(Bundle paramBundle)
  {
    if (paramBundle == null) {
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
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject1 = paramString1;
    if (paramString2.equals("GET")) {
      localObject1 = paramString1 + "?" + aq(paramBundle);
    }
    y.d("Facebook-Util", paramString2 + " URL: " + (String)localObject1);
    paramString1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
    paramString1.setConnectTimeout(20000);
    paramString1.setReadTimeout(20000);
    paramString1.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
    if (!paramString2.equals("GET"))
    {
      localObject1 = new Bundle();
      Object localObject2 = paramBundle.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (paramBundle.getByteArray(str) != null) {
          ((Bundle)localObject1).putByteArray(str, paramBundle.getByteArray(str));
        }
      }
      if (!paramBundle.containsKey("method")) {
        paramBundle.putString("method", paramString2);
      }
      if (paramBundle.containsKey("access_token")) {
        paramBundle.putString("access_token", URLDecoder.decode(paramBundle.getString("access_token")));
      }
      paramString1.setRequestMethod("POST");
      paramString1.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
      paramString1.setDoOutput(true);
      paramString1.setDoInput(true);
      paramString1.setRequestProperty("Connection", "Keep-Alive");
      paramString1.connect();
      paramString2 = new BufferedOutputStream(paramString1.getOutputStream());
      paramString2.write(("--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
      paramString2.write(l(paramBundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
      paramString2.write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
      if (!((Bundle)localObject1).isEmpty())
      {
        paramBundle = ((Bundle)localObject1).keySet().iterator();
        while (paramBundle.hasNext())
        {
          localObject2 = (String)paramBundle.next();
          paramString2.write(("Content-Disposition: form-data; filename=\"" + (String)localObject2 + "\"" + "\r\n").getBytes());
          paramString2.write(("Content-Type: content/unknown" + "\r\n" + "\r\n").getBytes());
          paramString2.write(((Bundle)localObject1).getByteArray((String)localObject2));
          paramString2.write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
        }
      }
      paramString2.flush();
    }
    try
    {
      paramString2 = F(paramString1.getInputStream());
      return paramString2;
    }
    catch (FileNotFoundException paramString2) {}
    return F(paramString1.getErrorStream());
  }
  
  private static String l(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
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
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.f.a.e
 * JD-Core Version:    0.7.0.1
 */