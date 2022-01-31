package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import android.content.pm.Signature;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.security.cert.Certificate;
import java.util.HashMap;

public class ShareSecurityCheck
{
  private static String hXW = null;
  private final Context mContext;
  public final HashMap<String, String> wZE;
  private final HashMap<String, String> wZF;
  
  public ShareSecurityCheck(Context paramContext)
  {
    this.mContext = paramContext;
    this.wZE = new HashMap();
    this.wZF = new HashMap();
    if (hXW == null)
    {
      paramContext = this.mContext;
      try
      {
        paramContext = SharePatchFileUtil.ac(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray());
        hXW = paramContext;
        if (paramContext == null) {
          throw new TinkerRuntimeException("get public key md5 is null");
        }
      }
      catch (Exception paramContext)
      {
        throw new TinkerRuntimeException("ShareSecurityCheck init public key fail", paramContext);
      }
      finally
      {
        SharePatchFileUtil.S(null);
      }
      SharePatchFileUtil.S(null);
    }
  }
  
  private static boolean a(File paramFile, Certificate[] paramArrayOfCertificate)
  {
    if (paramArrayOfCertificate.length > 0)
    {
      int i = paramArrayOfCertificate.length - 1;
      while (i >= 0) {
        try
        {
          boolean bool = hXW.equals(SharePatchFileUtil.ac(paramArrayOfCertificate[i].getEncoded()));
          if (bool) {
            return true;
          }
        }
        catch (Exception localException)
        {
          paramFile.getAbsolutePath();
          i -= 1;
        }
      }
    }
    return false;
  }
  
  /* Error */
  public final boolean al(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 107	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ae	(Ljava/io/File;)Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 109	java/util/jar/JarFile
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 112	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 116	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 122 1 0
    //   31: ifeq +102 -> 133
    //   34: aload_3
    //   35: invokeinterface 126 1 0
    //   40: checkcast 128	java/util/jar/JarEntry
    //   43: astore 5
    //   45: aload 5
    //   47: ifnull -22 -> 25
    //   50: aload 5
    //   52: invokevirtual 131	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   55: astore 6
    //   57: aload 6
    //   59: ldc 133
    //   61: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifne -39 -> 25
    //   67: aload 6
    //   69: ldc 139
    //   71: invokevirtual 142	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   74: ifeq -49 -> 25
    //   77: aload_0
    //   78: getfield 30	com/tencent/tinker/loader/shareutil/ShareSecurityCheck:wZE	Ljava/util/HashMap;
    //   81: aload 6
    //   83: aload 4
    //   85: aload 5
    //   87: invokestatic 146	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:b	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)Ljava/lang/String;
    //   90: invokevirtual 150	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload 5
    //   96: invokevirtual 154	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   99: astore 5
    //   101: aload 5
    //   103: ifnull +14 -> 117
    //   106: aload_1
    //   107: aload 5
    //   109: invokestatic 156	com/tencent/tinker/loader/shareutil/ShareSecurityCheck:a	(Ljava/io/File;[Ljava/security/cert/Certificate;)Z
    //   112: istore_2
    //   113: iload_2
    //   114: ifne -89 -> 25
    //   117: aload 4
    //   119: invokevirtual 159	java/util/jar/JarFile:close	()V
    //   122: iconst_0
    //   123: ireturn
    //   124: astore_3
    //   125: aload_1
    //   126: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   129: pop
    //   130: goto -8 -> 122
    //   133: aload 4
    //   135: invokevirtual 159	java/util/jar/JarFile:close	()V
    //   138: iconst_1
    //   139: ireturn
    //   140: astore_3
    //   141: aload_1
    //   142: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   145: pop
    //   146: goto -8 -> 138
    //   149: astore 4
    //   151: aconst_null
    //   152: astore_3
    //   153: new 68	com/tencent/tinker/loader/TinkerRuntimeException
    //   156: dup
    //   157: ldc 161
    //   159: iconst_2
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: aload_1
    //   173: invokevirtual 165	java/io/File:length	()J
    //   176: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   179: aastore
    //   180: invokestatic 175	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   183: aload 4
    //   185: invokespecial 78	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: athrow
    //   189: astore 5
    //   191: aload_3
    //   192: astore 4
    //   194: aload 5
    //   196: astore_3
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 159	java/util/jar/JarFile:close	()V
    //   207: aload_3
    //   208: athrow
    //   209: astore 4
    //   211: aload_1
    //   212: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   215: pop
    //   216: goto -9 -> 207
    //   219: astore_3
    //   220: aconst_null
    //   221: astore 4
    //   223: goto -26 -> 197
    //   226: astore_3
    //   227: goto -30 -> 197
    //   230: astore 5
    //   232: aload 4
    //   234: astore_3
    //   235: aload 5
    //   237: astore 4
    //   239: goto -86 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	ShareSecurityCheck
    //   0	242	1	paramFile	File
    //   112	2	2	bool	boolean
    //   24	11	3	localEnumeration	java.util.Enumeration
    //   124	1	3	localIOException1	java.io.IOException
    //   140	1	3	localIOException2	java.io.IOException
    //   152	56	3	localObject1	Object
    //   219	1	3	localObject2	Object
    //   226	1	3	localObject3	Object
    //   234	1	3	localObject4	Object
    //   17	117	4	localJarFile	java.util.jar.JarFile
    //   149	35	4	localException1	Exception
    //   192	11	4	localObject5	Object
    //   209	1	4	localIOException3	java.io.IOException
    //   221	17	4	localObject6	Object
    //   43	65	5	localObject7	Object
    //   189	6	5	localObject8	Object
    //   230	6	5	localException2	Exception
    //   55	27	6	str	String
    // Exception table:
    //   from	to	target	type
    //   117	122	124	java/io/IOException
    //   133	138	140	java/io/IOException
    //   9	19	149	java/lang/Exception
    //   153	189	189	finally
    //   202	207	209	java/io/IOException
    //   9	19	219	finally
    //   19	25	226	finally
    //   25	45	226	finally
    //   50	101	226	finally
    //   106	113	226	finally
    //   19	25	230	java/lang/Exception
    //   25	45	230	java/lang/Exception
    //   50	101	230	java/lang/Exception
    //   106	113	230	java/lang/Exception
  }
  
  public final HashMap<String, String> cQO()
  {
    if (!this.wZF.isEmpty()) {
      return this.wZF;
    }
    Object localObject = (String)this.wZE.get("assets/package_meta.txt");
    if (localObject == null) {
      return null;
    }
    localObject = ((String)localObject).split("\n");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = localObject[i];
      if ((arrayOfString != null) && (arrayOfString.length() > 0) && (!arrayOfString.startsWith("#")))
      {
        arrayOfString = arrayOfString.split("=", 2);
        if ((arrayOfString != null) && (arrayOfString.length >= 2)) {
          this.wZF.put(arrayOfString[0].trim(), arrayOfString[1].trim());
        }
      }
      i += 1;
    }
    return this.wZF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareSecurityCheck
 * JD-Core Version:    0.7.0.1
 */