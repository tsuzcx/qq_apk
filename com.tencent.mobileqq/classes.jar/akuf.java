import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.math.BigInteger;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;

public class akuf
{
  public static int a;
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "http", "https", "GameRes", "GameSandBox" };
  private static int b;
  private static int c;
  
  public static int a(int paramInt)
  {
    Object localObject = akwd.a(paramInt);
    if (localObject != null)
    {
      localObject = ((akyg)localObject).a();
      if (localObject != null) {
        return ((CmGameInitParams)localObject).mSrc;
      }
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = new JSONObject(paramString).optInt("xyRootSrc");
      return i;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameTool", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("page_id=").append(paramInt1).append("&").append("module_id=").append(paramInt2).append("&").append("action_type=").append(paramInt3).append("&").append("action_id=").append(paramInt4).append("&").append("item_id=").append(paramInt5).append("&").append("action_source=").append(paramInt6).append("&").append("platform=").append("android").append("&").append("ext3=").append(System.currentTimeMillis() / 1000L);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameTool", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  /* Error */
  public static String a(android.graphics.Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_0
    //   6: ifnull +128 -> 134
    //   9: new 125	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 128	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 134	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 140	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 144	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 150	bdfr:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 153	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 153	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 153	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_0
    //   127: goto -23 -> 104
    //   130: astore_0
    //   131: goto -60 -> 71
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_2
    //   137: astore_0
    //   138: goto -95 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramBitmap	android.graphics.Bitmap
    //   0	141	1	paramInt	int
    //   4	56	2	localObject1	Object
    //   61	2	2	localIOException1	java.io.IOException
    //   72	41	2	localObject2	Object
    //   118	19	2	localIOException2	java.io.IOException
    //   19	117	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	77	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	61	java/io/IOException
    //   9	20	68	java/lang/Exception
    //   84	92	94	java/io/IOException
    //   9	20	101	finally
    //   108	116	118	java/io/IOException
    //   22	32	126	finally
    //   34	43	126	finally
    //   73	77	126	finally
    //   22	32	130	java/lang/Exception
    //   34	43	130	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    return aktt.a + "/" + paramString;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      try
      {
        if (paramString1.length() > 4096)
        {
          if (!QLog.isColorLevel()) {
            break label738;
          }
          QLog.d("ApolloGameTool", 2, "[urlToPath] too long " + paramString1.substring(0, 100));
          return null;
        }
        localObject1 = URLDecoder.decode(paramString1, "UTF-8");
        paramString1 = (String)localObject1;
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          int i;
          String str;
          int j;
          label151:
          QLog.e("ApolloGameTool", 1, paramString2, new Object[0]);
          localObject1 = paramString1;
          localObject2 = localObject4;
        }
      }
      try
      {
        i = paramString1.indexOf("://");
        localObject1 = paramString1;
        localObject2 = localObject4;
        if (i == -1) {
          break label577;
        }
        if (!paramBoolean) {
          break label725;
        }
        localObject1 = Uri.parse(paramString1);
        str = ((Uri)localObject1).getHost();
        j = ((Uri)localObject1).getPort();
        if (j == 0) {
          break label719;
        }
        localObject1 = paramString1.replace(":" + j, "");
      }
      catch (Throwable paramString2)
      {
        break label680;
        localObject1 = paramString1;
        break label151;
        break label217;
      }
      paramString1 = (String)localObject1;
      localObject2 = localObject1;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = localObject1;
          paramString1 = str + "/";
          localObject2 = localObject1;
          if (!((String)localObject1).contains(paramString1)) {
            continue;
          }
          localObject2 = localObject1;
          paramString1 = ((String)localObject1).replace(paramString1, "");
        }
        label217:
        localObject1 = paramString1;
        localObject2 = paramString1;
        if (paramString1.contains("?"))
        {
          localObject2 = paramString1;
          j = paramString1.indexOf("?");
          if (j == 0) {
            break;
          }
          localObject1 = paramString1;
          if (j != -1)
          {
            localObject2 = paramString1;
            localObject1 = paramString1.substring(0, j);
          }
        }
        localObject2 = localObject1;
        paramString1 = ((String)localObject1).substring(0, i);
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        localObject3 = jdField_a_of_type_ArrayOfJavaLangString;
        localObject2 = localObject1;
        j = localObject3.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject2 = localObject1;
        if (!paramString1.equals(localObject3[i])) {
          continue;
        }
        localObject2 = localObject1;
        str = a(String.valueOf(paramInt));
        localObject2 = localObject1;
        localObject3 = ((String)localObject1).replace(paramString1 + "://", "");
        paramString1 = (String)localObject3;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject2 = localObject1;
          paramString1 = paramString2 + "/" + (String)localObject3;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        paramString1 = new File(str + "/" + paramString1);
        localObject2 = localObject1;
        paramString2 = new File(str);
        localObject2 = localObject1;
        if (!paramString1.exists()) {
          continue;
        }
        localObject2 = localObject1;
        if (!paramString1.isFile()) {
          continue;
        }
        localObject2 = localObject1;
        paramString2 = paramString2.getCanonicalPath();
        localObject2 = localObject1;
        paramString1 = paramString1.getCanonicalPath();
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        paramBoolean = paramString1.startsWith(paramString2);
        if (!paramBoolean) {
          continue;
        }
        localObject2 = paramString1;
      }
      catch (Throwable paramString2)
      {
        label577:
        paramString1 = (String)localObject2;
        label680:
        continue;
        localObject2 = localObject4;
        continue;
      }
      localObject3 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloGameTool", 2, "[urlToPath] " + (String)localObject1 + " " + (String)localObject2);
      return localObject2;
      localObject2 = localObject1;
      paramString1 = ((String)localObject1).replace(str, "");
      continue;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.d("ApolloGameTool", 2, "[urlToPath] path leak");
      }
      paramString1 = null;
      continue;
      i += 1;
      continue;
      label719:
      label725:
      localObject1 = paramString1;
      localObject2 = localObject4;
    }
    label738:
    return localObject3;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      String str;
      try
      {
        paramString1 = new JSONObject(paramString1);
        String[] arrayOfString = aktu.jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label183;
        }
        str = arrayOfString[i];
        if (!paramString1.has(str)) {
          break label201;
        }
        Object localObject = paramString1.opt(str);
        if ((localObject == null) || (localObject.toString().equals(paramString2))) {
          break label201;
        }
        if ((localObject instanceof String))
        {
          paramString1.put(str, paramString2);
          if (!QLog.isColorLevel()) {
            break label201;
          }
          QLog.e("ApolloGameTool", 2, "[filterSSOPara] " + localObject + " " + paramString2);
          break label201;
        }
        if ((localObject instanceof Integer))
        {
          paramString1.put(str, Integer.parseInt(paramString2));
          continue;
        }
        if (!(localObject instanceof Long)) {
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("ApolloGameTool", 1, new Object[0]);
        return null;
      }
      paramString1.put(str, Long.parseLong(paramString2));
      continue;
      label183:
      paramString1.put("from", "android.H5");
      paramString1 = paramString1.toString();
      return paramString1;
      label201:
      i += 1;
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    b = 0;
    c = 0;
    jdField_a_of_type_Int = 0;
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameTool", 2, "set aio white " + paramInt2);
      }
      if (paramInt2 == 0)
      {
        akts.a("CMGamePlusPanel", -aktt.c);
        return;
      }
    } while (paramInt2 != 1);
    akts.a("CMGamePlusPanel", aktt.c);
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(5894);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ApolloGameTool", 1, "app is null");
    }
    do
    {
      return;
      paramQQAppInterface = (bdug)paramQQAppInterface.a(71);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.d();
  }
  
  public static void a(String paramString, JSONArray paramJSONArray)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ApolloGameTool", 1, "bitmap is null");
    }
    for (;;)
    {
      try
      {
        paramString = new StringBuilder(new BigInteger(paramString).toString(2)).reverse().toString();
        int k = paramString.length();
        int i = 0;
        if (i < 64)
        {
          if (i < k)
          {
            j = paramString.charAt(i) - '0';
            a(i, j, 0);
            i += 1;
          }
        }
        else {
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameTool", 1, paramString, new Object[0]);
      }
      int j = 0;
    }
  }
  
  public static boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        str = paramString.replace("\\", "\\\\").replace("'", "\\'");
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameTool", 1, localThrowable, new Object[0]);
    }
    return paramString;
  }
  
  public static String c(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("extendInfo"))
        {
          paramString = new JSONObject(paramString.optString("extendInfo"));
          if (paramString.has("bk_share_url"))
          {
            paramString = paramString.optString("bk_share_url");
            return paramString;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameTool", 1, paramString, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuf
 * JD-Core Version:    0.7.0.1
 */