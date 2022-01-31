import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiDictMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aalb
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private java.lang.ref.WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public aalb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new mqq.util.WeakReference(paramQQAppInterface);
  }
  
  private static aalo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    aalo localaalo = new aalo(null);
    localaalo.jdField_a_of_type_Int = paramJSONObject.optInt("type", -1);
    localaalo.d = paramJSONObject.optString("md5", null);
    localaalo.b = paramJSONObject.optString("url", null);
    localaalo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", null);
    localaalo.c = paramJSONObject.optString("identifier", null);
    if (!localaalo.a())
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "getDictInfoFromJSON, invalid dict info");
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject("diff");
    if (paramJSONObject != null)
    {
      localaalo.e = paramJSONObject.optString("url");
      localaalo.f = paramJSONObject.optString("diff-md5");
      localaalo.g = paramJSONObject.optString("source-md5");
      if (!localaalo.b()) {
        localaalo.a();
      }
    }
    return localaalo;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfByte[i];
        localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(k >> 4 & 0xF)]);
        localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(k & 0xF)]);
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static Map a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      paramJSONObject = new HashMap();
      return paramJSONObject;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("word_dict_list");
    if (localJSONArray == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "getDictInfoFromConfig, 'word_dict_list' field not found");
      return new HashMap();
    }
    HashMap localHashMap = new HashMap();
    int j = localJSONArray.length();
    int i = 0;
    for (;;)
    {
      paramJSONObject = localHashMap;
      if (i >= j) {
        break;
      }
      paramJSONObject = a(localJSONArray.optJSONObject(i));
      if (paramJSONObject == null)
      {
        ArkAppCenter.b("ArkApp.Dict.Update", "getDictInfoFromConfig, invalid dict item");
        return new HashMap();
      }
      localHashMap.put(paramJSONObject.jdField_a_of_type_JavaLangString, paramJSONObject);
      i += 1;
    }
  }
  
  private void a(String paramString, aalo paramaalo1, aalo paramaalo2, aalq paramaalq)
  {
    boolean bool = false;
    aalo localaalo = paramaalo1;
    if (!a(paramaalo1)) {
      localaalo = null;
    }
    if (localaalo == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, local not exists, full update, name=%s", new Object[] { paramaalo2.jdField_a_of_type_JavaLangString }));
      ArkAppDataReport.a(paramaalo2.jdField_a_of_type_JavaLangString, 1);
      a(paramString, paramaalo2, new aalf(this, paramaalo2, paramaalq));
      return;
    }
    if (localaalo.d.equals(paramaalo2.d))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, file not change, copy from origin, name=%s", new Object[] { paramaalo2.jdField_a_of_type_JavaLangString }));
      paramaalo1 = c(localaalo.jdField_a_of_type_JavaLangString);
      paramString = String.format("%s/%s", new Object[] { paramString, paramaalo2.jdField_a_of_type_JavaLangString });
      if (FileUtils.d(paramaalo1, paramString)) {
        break label284;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, copy file fail, %s->%s", new Object[] { paramaalo1, paramString }));
    }
    for (;;)
    {
      paramaalq.a(bool);
      return;
      if ((paramaalo2.b()) && (localaalo.d.equals(paramaalo2.g)))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update, name=%s", new Object[] { paramaalo2.jdField_a_of_type_JavaLangString }));
        ArkAppDataReport.a(paramaalo2.jdField_a_of_type_JavaLangString, 3);
        b(paramString, localaalo, paramaalo2, new aalg(this, paramaalo2, paramaalq, paramString));
        return;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, full update, name=%s", new Object[] { paramaalo2.jdField_a_of_type_JavaLangString }));
      a(paramString, paramaalo2, new aali(this, paramaalq));
      return;
      label284:
      bool = true;
    }
  }
  
  private void a(String paramString, aalo paramaalo, aalq paramaalq)
  {
    a(paramaalo.jdField_a_of_type_JavaLangString, paramaalo.b, new aalj(this, paramaalo, paramString, paramaalq));
  }
  
  private void a(String paramString1, String paramString2, aalp paramaalp)
  {
    aalr localaalr = new aalr(null);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from download");
      return;
    }
    PreDownloadController localPreDownloadController = (PreDownloadController)localQQAppInterface.getManager(192);
    localaalr.jdField_a_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(localPreDownloadController);
    paramaalp = new aall(this, paramString2, localaalr, paramaalp);
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return");
      return;
    }
    localaalr.jdField_a_of_type_Boolean = localPreDownloadController.a();
    if (localaalr.jdField_a_of_type_Boolean)
    {
      localPreDownloadController.a(10022, "prd", paramString1, 0, paramString2, "", 1, 0, false, new RunnableTask(localQQAppInterface, paramString1, paramaalp, 10000L));
      return;
    }
    paramaalp.run();
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("downloadDictFile, not use pre-download, name=%s, URL=%s.", new Object[] { paramString1, paramString2 }));
  }
  
  private void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject2 == null) {
      ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, remote dict config is empty");
    }
    for (;;)
    {
      return;
      if (!a(paramJSONObject2))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, canUpdateDictAtCurrentNetType is false");
        return;
      }
      Object localObject1 = b(paramJSONObject2);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, empty new dict id");
        return;
      }
      String str = b((String)localObject1);
      if (TextUtils.isEmpty(str))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateWordDict, fail to create new dict dir, id=%s", new Object[] { localObject1 }));
        return;
      }
      Object localObject2 = a(paramJSONObject2);
      if ((localObject2 == null) || (((Map)localObject2).size() == 0))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, new dict list is empty");
        return;
      }
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, update in progress, wait current task complete");
          this.b = true;
          return;
        }
      }
      finally {}
      this.jdField_a_of_type_Boolean = true;
      paramJSONObject1 = a(paramJSONObject1);
      localObject1 = new aals(null);
      ((aals)localObject1).jdField_a_of_type_Int = ((Map)localObject2).size();
      ((aals)localObject1).jdField_a_of_type_Boolean = true;
      localObject2 = ((Map)localObject2).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aalo localaalo = (aalo)((Iterator)localObject2).next();
        a(str, (aalo)paramJSONObject1.get(localaalo.jdField_a_of_type_JavaLangString), localaalo, new aald(this, (aals)localObject1, localaalo, str, paramJSONObject2));
      }
    }
  }
  
  private static boolean a(aalo paramaalo)
  {
    if (paramaalo == null) {}
    while (!a(c(paramaalo.jdField_a_of_type_JavaLangString), paramaalo.d)) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 380	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 383	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: invokevirtual 386	java/io/File:isFile	()Z
    //   29: ifeq -15 -> 14
    //   32: sipush 4096
    //   35: newarray byte
    //   37: astore 5
    //   39: ldc_w 388
    //   42: invokestatic 394	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   45: astore 6
    //   47: new 396	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 399	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore 4
    //   57: aload 4
    //   59: astore_0
    //   60: aload 4
    //   62: aload 5
    //   64: invokevirtual 403	java/io/FileInputStream:read	([B)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifgt +50 -> 119
    //   72: aload 4
    //   74: astore_0
    //   75: aload 6
    //   77: invokevirtual 407	java/security/MessageDigest:digest	()[B
    //   80: invokestatic 409	aalb:a	([B)Ljava/lang/String;
    //   83: aload_1
    //   84: invokevirtual 413	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   87: istore_3
    //   88: iload_3
    //   89: ifeq +15 -> 104
    //   92: aload 4
    //   94: ifnull +8 -> 102
    //   97: aload 4
    //   99: invokevirtual 416	java/io/FileInputStream:close	()V
    //   102: iconst_1
    //   103: ireturn
    //   104: aload 4
    //   106: ifnull -92 -> 14
    //   109: aload 4
    //   111: invokevirtual 416	java/io/FileInputStream:close	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_0
    //   117: iconst_0
    //   118: ireturn
    //   119: aload 4
    //   121: astore_0
    //   122: aload 6
    //   124: aload 5
    //   126: iconst_0
    //   127: iload_2
    //   128: invokevirtual 420	java/security/MessageDigest:update	([BII)V
    //   131: goto -74 -> 57
    //   134: astore_0
    //   135: aload 4
    //   137: astore_1
    //   138: aload_0
    //   139: astore 4
    //   141: aload_1
    //   142: astore_0
    //   143: ldc 86
    //   145: ldc_w 422
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 4
    //   156: invokevirtual 425	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 198	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokestatic 93	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_1
    //   167: ifnull -153 -> 14
    //   170: aload_1
    //   171: invokevirtual 416	java/io/FileInputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_0
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_0
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 416	java/io/FileInputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore_0
    //   193: goto -91 -> 102
    //   196: astore_0
    //   197: goto -7 -> 190
    //   200: astore_1
    //   201: goto -19 -> 182
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_1
    //   208: goto -67 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramString1	String
    //   0	211	1	paramString2	String
    //   67	61	2	i	int
    //   87	2	3	bool	boolean
    //   55	100	4	localObject	Object
    //   204	1	4	localException	Exception
    //   37	88	5	arrayOfByte	byte[]
    //   45	78	6	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   109	114	116	java/io/IOException
    //   60	68	134	java/lang/Exception
    //   75	88	134	java/lang/Exception
    //   122	131	134	java/lang/Exception
    //   170	174	176	java/io/IOException
    //   39	57	179	finally
    //   97	102	192	java/io/IOException
    //   186	190	196	java/io/IOException
    //   60	68	200	finally
    //   75	88	200	finally
    //   122	131	200	finally
    //   143	166	200	finally
    //   39	57	204	java/lang/Exception
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    paramJSONObject = paramJSONObject.optString("netType", "");
    if ((TextUtils.isEmpty(paramJSONObject)) || (paramJSONObject.equalsIgnoreCase("wifi")))
    {
      if ((AppNetConnInfo.isNetSupport()) && (AppNetConnInfo.isWifiConn()))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("getNetType, invalid dict info, netType=%s", new Object[] { paramJSONObject }));
        return true;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("getNetType, not judge net Type.", new Object[0]));
      return false;
    }
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("getNetType, netType in not WIFI.", new Object[0]));
    return true;
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +7 -> 17
    //   13: iconst_0
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: new 446	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 447	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: aload_0
    //   33: invokevirtual 451	java/io/FileOutputStream:write	([B)V
    //   36: aload 4
    //   38: ifnull -23 -> 15
    //   41: aload 4
    //   43: invokevirtual 452	java/io/FileOutputStream:close	()V
    //   46: iconst_1
    //   47: ireturn
    //   48: astore_0
    //   49: ldc 86
    //   51: getstatic 458	java/util/Locale:CHINA	Ljava/util/Locale;
    //   54: ldc_w 460
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: invokevirtual 461	java/io/IOException:getMessage	()Ljava/lang/String;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 464	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokestatic 93	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 5
    //   82: aconst_null
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: ldc 86
    //   90: getstatic 458	java/util/Locale:CHINA	Ljava/util/Locale;
    //   93: ldc_w 466
    //   96: iconst_3
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload 5
    //   104: invokevirtual 461	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_0
    //   111: arraylength
    //   112: invokestatic 472	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_2
    //   118: aload_1
    //   119: aastore
    //   120: invokestatic 464	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   123: invokestatic 93	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 4
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: invokevirtual 452	java/io/FileOutputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_0
    //   139: ldc 86
    //   141: getstatic 458	java/util/Locale:CHINA	Ljava/util/Locale;
    //   144: ldc_w 460
    //   147: iconst_2
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_0
    //   154: invokevirtual 461	java/io/IOException:getMessage	()Ljava/lang/String;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload_1
    //   161: aastore
    //   162: invokestatic 464	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   165: invokestatic 93	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto -32 -> 136
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_3
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 452	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_3
    //   185: ldc 86
    //   187: getstatic 458	java/util/Locale:CHINA	Ljava/util/Locale;
    //   190: ldc_w 460
    //   193: iconst_2
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_3
    //   200: invokevirtual 461	java/io/IOException:getMessage	()Ljava/lang/String;
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: aload_1
    //   207: aastore
    //   208: invokestatic 464	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokestatic 93	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: goto -32 -> 182
    //   217: astore_0
    //   218: goto -44 -> 174
    //   221: astore 5
    //   223: goto -138 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramArrayOfByte	byte[]
    //   0	226	1	paramString	String
    //   1	15	2	bool	boolean
    //   29	150	3	localFileOutputStream1	java.io.FileOutputStream
    //   184	16	3	localIOException1	java.io.IOException
    //   25	107	4	localFileOutputStream2	java.io.FileOutputStream
    //   80	23	5	localIOException2	java.io.IOException
    //   221	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   41	46	48	java/io/IOException
    //   17	27	80	java/io/IOException
    //   131	136	138	java/io/IOException
    //   17	27	171	finally
    //   178	182	184	java/io/IOException
    //   30	36	217	finally
    //   88	126	217	finally
    //   30	36	221	java/io/IOException
  }
  
  private static String b(String paramString)
  {
    String str = String.format(Locale.CHINA, "%s-%s-%d", new Object[] { ArkAiDictMgr.a(), paramString, Long.valueOf(System.currentTimeMillis()) });
    File localFile = new File(str);
    localFile.mkdirs();
    paramString = str;
    if (!localFile.isDirectory())
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("getTmpWordDataDirectory, fail to create tmp word data directory, dir=%s", new Object[] { str }));
      paramString = null;
    }
    return paramString;
  }
  
  private static String b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str;
    do
    {
      return null;
      str = paramJSONObject.optString("environment");
      paramJSONObject = paramJSONObject.optString("timestamp");
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramJSONObject)));
    return String.format("%s-%s", new Object[] { str, paramJSONObject });
  }
  
  private static JSONObject b()
  {
    String str = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).getString("ArkAILocalDictConfig", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("getLocalDictConfig, fail to decode config json, err=%s, json=%s", new Object[] { localException.getMessage(), str }));
    }
    return null;
  }
  
  private static JSONObject b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = SharedPreUtils.i(paramQQAppInterface.getApp(), paramQQAppInterface.c());
    if (TextUtils.isEmpty(paramQQAppInterface))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "getRemoteDictConfig, config string is empty");
      return null;
    }
    try
    {
      paramQQAppInterface = new JSONObject(paramQQAppInterface);
      return paramQQAppInterface;
    }
    catch (JSONException paramQQAppInterface)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("getRemoteDictConfig, fail to decode json, err=%s", new Object[] { paramQQAppInterface.getMessage() }));
    }
    return null;
  }
  
  private void b(String paramString, aalo paramaalo1, aalo paramaalo2, aalq paramaalq)
  {
    a(paramaalo2.jdField_a_of_type_JavaLangString, paramaalo2.e, new aalk(this, paramaalo2, paramaalo1, paramString, paramaalq));
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.toString(2);
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).edit();
      localEditor.putString("ArkAILocalDictConfig", paramJSONObject);
      localEditor.apply();
      return;
    }
    catch (Exception paramJSONObject)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("setLocalDictConfig, fail to convert json to string, err=%s", new Object[] { paramJSONObject.getMessage() }));
    }
  }
  
  private static String c(String paramString)
  {
    return String.format("%s/%s", new Object[] { ArkAiDictMgr.a(), paramString });
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "checkLocalDictIntegrity, config is empty, return");
      return;
    }
    Map localMap = a(paramJSONObject);
    if (localMap == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "checkLocalDictIntegrity, local dict list is empty");
      return;
    }
    Iterator localIterator = localMap.values().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (a((aalo)localIterator.next()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ArkAppCenter.b("ArkApp.Dict.Update", "checkLocalDictIntegrity, all files check ok, no update");
        return;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format(Locale.CHINA, "checkLocalDictIntegrity, %d of %d files need update", new Object[] { Integer.valueOf(i), Integer.valueOf(localMap.size()) }));
      a(paramJSONObject, paramJSONObject);
      return;
    }
  }
  
  private static boolean c(String paramString)
  {
    String str1 = ArkAiDictMgr.a();
    String str2 = String.format(Locale.CHINA, "%s-%d", new Object[] { str1, Long.valueOf(System.currentTimeMillis()) });
    if (!FileUtils.c(str1, str2))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("fail to rename dict dir to tmp dir, %s->%s", new Object[] { str1, str2 }));
      return false;
    }
    if (!FileUtils.c(paramString, str1))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("fail to rename new dir to dict dir, %s->%s", new Object[] { paramString, str1 }));
      return false;
    }
    FileUtils.a(str2);
    return true;
  }
  
  private static boolean c(byte[] paramArrayOfByte, String paramString)
  {
    boolean bool1 = true;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = a(MessageDigest.getInstance("MD5").digest(paramArrayOfByte)).equalsIgnoreCase(paramString);
        if (!bool2) {
          return false;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("checkDictMd5, fail compute buffer md5, msg=%s", new Object[] { paramArrayOfByte.getMessage() }));
      }
    }
    return false;
  }
  
  public void a()
  {
    if (ArkAppCenter.a())
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "updateLocalDict, use test dict, no update, return");
      return;
    }
    ArkAppCenter.b("ArkApp.Dict.Update", "updateLocalDict, start");
    ArkRecommendLogic.a().post(new aalc(this));
  }
  
  public boolean a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "getBusinessState, dictConfigJsonString is empty");
      return false;
    }
    boolean bool;
    try
    {
      paramString = new JSONObject(paramString).optString("business_percent");
      if (!TextUtils.isEmpty(paramString))
      {
        long l1 = Long.parseLong(paramString);
        long l2 = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("getBusinessState, business_percent=%s", new Object[] { paramString }));
        if (l2 % 100L > l1) {
          break label147;
        }
        bool = true;
      }
      else
      {
        ArkAppCenter.b("ArkApp.Dict.Update", "getBusinessState, business_percent is empty");
        return false;
      }
    }
    catch (JSONException paramString)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("getBusinessState, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
      return false;
    }
    for (;;)
    {
      return bool;
      label147:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalb
 * JD-Core Version:    0.7.0.1
 */