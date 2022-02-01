package com.tencent.ytcommon.auth;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class MacAddress
{
  private static String bytesToString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186328);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(186328);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(186328);
    return paramArrayOfByte;
  }
  
  /* Error */
  private static String callCmd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 59
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 61
    //   7: astore_2
    //   8: new 63	java/io/BufferedReader
    //   11: dup
    //   12: new 65	java/io/InputStreamReader
    //   15: dup
    //   16: invokestatic 71	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   19: aload_0
    //   20: invokevirtual 75	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   23: invokevirtual 81	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   26: invokespecial 84	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore 4
    //   34: ldc 61
    //   36: astore_0
    //   37: aload 4
    //   39: invokevirtual 90	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +38 -> 84
    //   49: aload_3
    //   50: astore_2
    //   51: aload_3
    //   52: aload_1
    //   53: invokevirtual 94	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifne +28 -> 84
    //   59: new 23	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   66: aload_0
    //   67: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_3
    //   71: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_2
    //   79: astore_0
    //   80: goto -43 -> 37
    //   83: astore_0
    //   84: ldc 59
    //   86: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_2
    //   90: areturn
    //   91: astore_1
    //   92: aload_0
    //   93: astore_2
    //   94: goto -10 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramString1	String
    //   0	97	1	paramString2	String
    //   7	87	2	localObject	Object
    //   42	29	3	str	String
    //   32	6	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   8	34	83	java/lang/Exception
    //   37	43	91	java/lang/Exception
    //   51	78	91	java/lang/Exception
  }
  
  private static InetAddress getLocalInetAddress()
  {
    AppMethodBeat.i(186325);
    try
    {
      localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      localInetAddress1 = null;
    }
    catch (SocketException localSocketException1)
    {
      for (;;)
      {
        Enumeration localEnumeration1;
        InetAddress localInetAddress1;
        InetAddress localInetAddress2;
        localObject1 = null;
      }
    }
    localInetAddress2 = localInetAddress1;
    for (;;)
    {
      try
      {
        if (!localEnumeration1.hasMoreElements()) {
          continue;
        }
        localInetAddress2 = localInetAddress1;
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        localInetAddress2 = localInetAddress1;
        if (localEnumeration2.hasMoreElements())
        {
          localInetAddress2 = localInetAddress1;
          localInetAddress1 = (InetAddress)localEnumeration2.nextElement();
        }
      }
      catch (SocketException localSocketException2)
      {
        Object localObject1;
        Object localObject2 = localSocketException3;
        continue;
        continue;
      }
      try
      {
        if (!localInetAddress1.isLoopbackAddress())
        {
          int i = localInetAddress1.getHostAddress().indexOf(":");
          if (i == -1) {}
        }
        else
        {
          localInetAddress1 = null;
          continue;
        }
        if (localInetAddress1 == null) {
          break label120;
        }
      }
      catch (SocketException localSocketException3) {}
    }
    AppMethodBeat.o(186325);
    return localInetAddress1;
  }
  
  private static String getLocalIpAddress()
  {
    AppMethodBeat.i(186326);
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      AppMethodBeat.o(186326);
      return localObject;
    }
    catch (SocketException localSocketException)
    {
      AppMethodBeat.o(186326);
    }
    return null;
  }
  
  public static String getLocalMacAddressFromBusybox()
  {
    AppMethodBeat.i(186329);
    String str2 = callCmd("busybox ifconfig", "HWaddr");
    if (str2 == null)
    {
      AppMethodBeat.o(186329);
      return "网络异常";
    }
    String str1 = str2;
    if (str2.length() > 0)
    {
      str1 = str2;
      if (str2.contains("HWaddr") == true) {
        str1 = str2.substring(str2.indexOf("HWaddr") + 6, str2.length() - 1);
      }
    }
    AppMethodBeat.o(186329);
    return str1;
  }
  
  public static String getLocalMacAddressFromWifiInfo(Context paramContext)
  {
    AppMethodBeat.i(186318);
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    AppMethodBeat.o(186318);
    return paramContext;
  }
  
  public static String getMac(Context paramContext)
  {
    AppMethodBeat.i(186317);
    if (Build.VERSION.SDK_INT < 23)
    {
      paramContext = getMachineHardwareAddress();
      AppMethodBeat.o(186317);
      return paramContext;
    }
    if ((Build.VERSION.SDK_INT < 24) && (Build.VERSION.SDK_INT >= 23))
    {
      paramContext = getMacAddress(paramContext);
      AppMethodBeat.o(186317);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (!TextUtils.isEmpty(getMachineHardwareAddress()))
      {
        paramContext = getMachineHardwareAddress();
        AppMethodBeat.o(186317);
        return paramContext;
      }
      if (!TextUtils.isEmpty(getMacAddress()))
      {
        paramContext = getMacAddress();
        AppMethodBeat.o(186317);
        return paramContext;
      }
      paramContext = getLocalMacAddressFromBusybox();
      AppMethodBeat.o(186317);
      return paramContext;
    }
    AppMethodBeat.o(186317);
    return "02:00:00:00:00:00";
  }
  
  public static String getMacAddress()
  {
    AppMethodBeat.i(186324);
    localObject2 = null;
    try
    {
      byte[] arrayOfByte = NetworkInterface.getByInetAddress(getLocalInetAddress()).getHardwareAddress();
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < arrayOfByte.length)
      {
        if (i != 0) {
          localStringBuffer.append(':');
        }
        String str2 = Integer.toHexString(arrayOfByte[i] & 0xFF);
        str1 = str2;
        if (str2.length() == 1) {
          str1 = "0".concat(String.valueOf(str2));
        }
        localStringBuffer.append(str1);
        i += 1;
      }
      str1 = localStringBuffer.toString().toUpperCase();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        Object localObject1 = localObject2;
      }
    }
    AppMethodBeat.o(186324);
    return str1;
  }
  
  public static String getMacAddress(Context paramContext)
  {
    AppMethodBeat.i(186319);
    if (Build.VERSION.SDK_INT < 23)
    {
      paramContext = getMacAddress0(paramContext);
      if (!TextUtils.isEmpty(paramContext))
      {
        AppMethodBeat.o(186319);
        return paramContext;
      }
    }
    Object localObject = "";
    String str = "";
    try
    {
      LineNumberReader localLineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream()));
      do
      {
        paramContext = str;
        if (localObject == null) {
          break;
        }
        paramContext = localLineNumberReader.readLine();
        localObject = paramContext;
      } while (paramContext == null);
      paramContext = paramContext.trim();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          localObject = loadFileAsString("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
          AppMethodBeat.o(186319);
          return localObject;
        }
        catch (Exception localException)
        {
          new StringBuilder("getMacAddress:").append(localException.toString());
        }
        paramContext = paramContext;
        new StringBuilder("getMacAddress:").append(paramContext.toString());
        paramContext = str;
      }
      AppMethodBeat.o(186319);
    }
    if ((paramContext == null) || ("".equals(paramContext))) {}
    return paramContext;
  }
  
  private static String getMacAddress0(Context paramContext)
  {
    AppMethodBeat.i(186320);
    if (isAccessWifiStateAuthorized(paramContext))
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      try
      {
        paramContext = paramContext.getConnectionInfo().getMacAddress();
        AppMethodBeat.o(186320);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        new StringBuilder("getMacAddress0:").append(paramContext.toString());
      }
    }
    AppMethodBeat.o(186320);
    return "";
  }
  
  public static String getMachineHardwareAddress()
  {
    AppMethodBeat.i(186327);
    Enumeration localEnumeration;
    ArrayList localArrayList;
    Object localObject1;
    try
    {
      localEnumeration = NetworkInterface.getNetworkInterfaces();
      if (localEnumeration == null)
      {
        AppMethodBeat.o(186327);
        return null;
      }
    }
    catch (SocketException localSocketException1)
    {
      for (;;)
      {
        localEnumeration = null;
      }
      localArrayList = new ArrayList();
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2;
      if (localEnumeration.hasMoreElements()) {
        localObject2 = (NetworkInterface)localEnumeration.nextElement();
      }
      try
      {
        localObject2 = bytesToString(((NetworkInterface)localObject2).getHardwareAddress());
        localObject1 = localObject2;
        if (localObject1 != null) {}
        try
        {
          localArrayList.add(localObject1);
        }
        catch (SocketException localSocketException2) {}
      }
      catch (SocketException localSocketException3)
      {
        label81:
        break label81;
      }
    }
    Collections.sort(localArrayList);
    if (localArrayList.size() > 0)
    {
      localObject1 = (String)localArrayList.get(localArrayList.size() - 1);
      AppMethodBeat.o(186327);
      return localObject1;
    }
    AppMethodBeat.o(186327);
    return localObject1;
  }
  
  private static boolean isAccessWifiStateAuthorized(Context paramContext)
  {
    AppMethodBeat.i(186321);
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0)
    {
      AppMethodBeat.o(186321);
      return true;
    }
    AppMethodBeat.o(186321);
    return false;
  }
  
  private static String loadFileAsString(String paramString)
  {
    AppMethodBeat.i(186322);
    paramString = new FileReader(paramString);
    String str = loadReaderAsString(paramString);
    paramString.close();
    AppMethodBeat.o(186322);
    return str;
  }
  
  private static String loadReaderAsString(Reader paramReader)
  {
    AppMethodBeat.i(186323);
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = new char[4096];
    for (int i = paramReader.read(arrayOfChar); i >= 0; i = paramReader.read(arrayOfChar)) {
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    paramReader = localStringBuilder.toString();
    AppMethodBeat.o(186323);
    return paramReader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ytcommon.auth.MacAddress
 * JD-Core Version:    0.7.0.1
 */