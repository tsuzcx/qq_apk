package com.unionpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static HashMap a;
  
  static
  {
    AppMethodBeat.i(207387);
    a = new c();
    AppMethodBeat.o(207387);
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(207374);
    str1 = "";
    Object localObject = UPUtils.a(paramContext, "configs");
    String str2 = UPUtils.a(paramContext, "mode");
    String str3 = UPUtils.a(paramContext, "or");
    paramContext = str1;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramContext = str1;
      if (!TextUtils.isEmpty(str2))
      {
        paramContext = str1;
        if (TextUtils.isEmpty(str3)) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        str4 = i.v((JSONObject)localObject, "sign");
      }
      catch (Exception paramContext)
      {
        String str4;
        int i;
        boolean bool;
        int j;
        paramContext = str1;
        continue;
        paramContext = "";
        continue;
      }
      try
      {
        i = Integer.parseInt(str2);
        str2 = new String(Base64.decode(((JSONObject)localObject).getString("configs"), 2));
        paramContext = "";
        if (((JSONObject)localObject).has("sePayConf")) {
          paramContext = new String(Base64.decode(((JSONObject)localObject).getString("sePayConf"), 2));
        }
        localObject = paramContext;
        if (TextUtils.isEmpty(paramContext)) {
          localObject = "";
        }
        paramContext = a(UPUtils.a(str2 + (String)localObject + str3));
        localObject = UPUtils.forConfig(i, str4);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        bool = ((String)localObject).equals(paramContext);
        if (!bool) {
          continue;
        }
        paramContext = str2;
      }
      catch (NumberFormatException paramContext)
      {
        try
        {
          paramContext = new JSONArray(paramContext);
          j = paramContext.length();
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject = i.i(paramContext, i);
          if (localObject == null) {
            continue;
          }
          localObject = (JSONObject)localObject;
          if (!"app".equals(i.v((JSONObject)localObject, "type"))) {
            continue;
          }
          paramContext = new String(Base64.decode(i.v((JSONObject)localObject, "ca"), 2));
          AppMethodBeat.o(207374);
          return paramContext;
        }
        catch (JSONException paramContext)
        {
          AppMethodBeat.o(207374);
          return "";
        }
        paramContext = paramContext;
        i = 0;
        continue;
      }
      i += 1;
    }
    AppMethodBeat.o(207374);
    return "";
  }
  
  public static String a(InputStream paramInputStream, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(207384);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(207384);
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[2048];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      AppMethodBeat.o(207384);
    }
    finally
    {
      paramInputStream = localObject;
    }
    for (;;)
    {
      return paramInputStream;
      paramInputStream = localByteArrayOutputStream.toString(paramString);
    }
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(207360);
    if (paramString == null)
    {
      AppMethodBeat.o(207360);
      return "";
    }
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuilder localStringBuilder = new StringBuilder("");
    paramString = paramString.getBytes();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString[i];
      localStringBuilder.append(arrayOfChar[((k & 0xF0) >> 4)]);
      localStringBuilder.append(arrayOfChar[(k & 0xF)]);
      i += 1;
    }
    paramString = localStringBuilder.toString().trim();
    AppMethodBeat.o(207360);
    return paramString;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207351);
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i]);
      int j = ((String)localObject2).length();
      Object localObject1 = localObject2;
      if (j == 1) {
        localObject1 = "0".concat(String.valueOf(localObject2));
      }
      localObject2 = localObject1;
      if (j > 2) {
        localObject2 = ((String)localObject1).substring(j - 2, j);
      }
      localStringBuilder.append(((String)localObject2).toUpperCase());
      if (i < paramArrayOfByte.length - 1) {
        localStringBuilder.append(':');
      }
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(207351);
    return paramArrayOfByte;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(207330);
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 0);
      bool1 = true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(207330);
    return bool1;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 215
    //   4: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 201	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   11: astore_0
    //   12: aload_0
    //   13: aload_1
    //   14: bipush 64
    //   16: invokevirtual 207	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   19: astore_0
    //   20: new 217	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_0
    //   25: getfield 223	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   28: iconst_0
    //   29: aaload
    //   30: invokevirtual 228	android/content/pm/Signature:toByteArray	()[B
    //   33: invokespecial 229	java/io/ByteArrayInputStream:<init>	([B)V
    //   36: astore_1
    //   37: ldc 231
    //   39: invokestatic 237	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   42: astore_0
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual 241	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   48: checkcast 243	java/security/cert/X509Certificate
    //   51: astore_0
    //   52: ldc 245
    //   54: invokestatic 250	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   57: aload_0
    //   58: invokevirtual 253	java/security/cert/X509Certificate:getEncoded	()[B
    //   61: invokevirtual 257	java/security/MessageDigest:digest	([B)[B
    //   64: invokestatic 259	com/unionpay/utils/b:a	([B)Ljava/lang/String;
    //   67: astore_0
    //   68: aload_0
    //   69: ldc_w 261
    //   72: ldc 36
    //   74: invokevirtual 265	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_0
    //   78: ldc 215
    //   80: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_0
    //   88: goto -68 -> 20
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_0
    //   94: goto -51 -> 43
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_0
    //   100: goto -48 -> 52
    //   103: astore_0
    //   104: ldc 215
    //   106: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: ldc 36
    //   111: areturn
    //   112: astore_0
    //   113: aload_2
    //   114: astore_0
    //   115: goto -47 -> 68
    //   118: astore_0
    //   119: aload_2
    //   120: astore_0
    //   121: goto -53 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramContext	Context
    //   0	124	1	paramString	String
    //   1	119	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	20	85	android/content/pm/PackageManager$NameNotFoundException
    //   37	43	91	java/security/cert/CertificateException
    //   43	52	97	java/security/cert/CertificateException
    //   7	12	103	java/lang/Exception
    //   12	20	103	java/lang/Exception
    //   20	37	103	java/lang/Exception
    //   37	43	103	java/lang/Exception
    //   43	52	103	java/lang/Exception
    //   52	68	103	java/lang/Exception
    //   68	78	103	java/lang/Exception
    //   52	68	112	java/security/cert/CertificateEncodingException
    //   52	68	118	java/security/NoSuchAlgorithmException
  }
  
  public static String b(String paramString)
  {
    AppMethodBeat.i(207381);
    if (!TextUtils.isEmpty((CharSequence)a.get(paramString)))
    {
      paramString = (String)a.get(paramString);
      AppMethodBeat.o(207381);
      return paramString;
    }
    AppMethodBeat.o(207381);
    return paramString;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207365);
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str1 = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName;
      AppMethodBeat.o(207365);
      return str1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        str1 = str2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.utils.b
 * JD-Core Version:    0.7.0.1
 */