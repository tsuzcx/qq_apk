package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.Signature;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.security.cert.Certificate;
import java.util.HashMap;

public class ShareSecurityCheck
{
  private static final String TAG = "Tinker.SecurityCheck";
  private static String mPublicKeyMd5 = null;
  private final Context mContext;
  private final HashMap<String, String> metaContentMap;
  private final HashMap<String, String> packageProperties;
  
  public ShareSecurityCheck(Context paramContext)
  {
    this.mContext = paramContext;
    this.metaContentMap = new HashMap();
    this.packageProperties = new HashMap();
    if (mPublicKeyMd5 == null) {
      init(this.mContext);
    }
  }
  
  private boolean check(File paramFile, Certificate[] paramArrayOfCertificate)
  {
    if (paramArrayOfCertificate.length > 0)
    {
      int i = paramArrayOfCertificate.length - 1;
      while (i >= 0) {
        try
        {
          boolean bool = mPublicKeyMd5.equals(SharePatchFileUtil.getMD5(paramArrayOfCertificate[i].getEncoded()));
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
  
  @SuppressLint({"PackageManagerGetSignatures"})
  private void init(Context paramContext)
  {
    try
    {
      paramContext = SharePatchFileUtil.getMD5(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray());
      mPublicKeyMd5 = paramContext;
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
      SharePatchFileUtil.closeQuietly(null);
    }
    SharePatchFileUtil.closeQuietly(null);
  }
  
  public HashMap<String, String> getMetaContentMap()
  {
    return this.metaContentMap;
  }
  
  public HashMap<String, String> getPackagePropertiesIfPresent()
  {
    if (!this.packageProperties.isEmpty()) {
      return this.packageProperties;
    }
    Object localObject = (String)this.metaContentMap.get("assets/package_meta.txt");
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
          this.packageProperties.put(arrayOfString[0].trim(), arrayOfString[1].trim());
        }
      }
      i += 1;
    }
    return this.packageProperties;
  }
  
  /* Error */
  public boolean verifyPatchMetaSignature(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 160	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isLegalFile	(Ljava/io/File;)Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 162	java/util/jar/JarFile
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 165	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 169	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 174 1 0
    //   31: ifeq +103 -> 134
    //   34: aload_3
    //   35: invokeinterface 178 1 0
    //   40: checkcast 180	java/util/jar/JarEntry
    //   43: astore 5
    //   45: aload 5
    //   47: ifnull -22 -> 25
    //   50: aload 5
    //   52: invokevirtual 183	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   55: astore 6
    //   57: aload 6
    //   59: ldc 185
    //   61: invokevirtual 141	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifne -39 -> 25
    //   67: aload 6
    //   69: ldc 187
    //   71: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   74: ifeq -49 -> 25
    //   77: aload_0
    //   78: getfield 31	com/tencent/tinker/loader/shareutil/ShareSecurityCheck:metaContentMap	Ljava/util/HashMap;
    //   81: aload 6
    //   83: aload 4
    //   85: aload 5
    //   87: invokestatic 194	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:loadDigestes	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)Ljava/lang/String;
    //   90: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload 5
    //   96: invokevirtual 198	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   99: astore 5
    //   101: aload 5
    //   103: ifnull +15 -> 118
    //   106: aload_0
    //   107: aload_1
    //   108: aload 5
    //   110: invokespecial 200	com/tencent/tinker/loader/shareutil/ShareSecurityCheck:check	(Ljava/io/File;[Ljava/security/cert/Certificate;)Z
    //   113: istore_2
    //   114: iload_2
    //   115: ifne -90 -> 25
    //   118: aload 4
    //   120: invokevirtual 203	java/util/jar/JarFile:close	()V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore_3
    //   126: aload_1
    //   127: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: pop
    //   131: goto -8 -> 123
    //   134: aload 4
    //   136: invokevirtual 203	java/util/jar/JarFile:close	()V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore_3
    //   142: aload_1
    //   143: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   146: pop
    //   147: goto -8 -> 139
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_3
    //   154: new 95	com/tencent/tinker/loader/TinkerRuntimeException
    //   157: dup
    //   158: ldc 205
    //   160: iconst_2
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_1
    //   167: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload_1
    //   174: invokevirtual 208	java/io/File:length	()J
    //   177: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: aastore
    //   181: invokestatic 218	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   184: aload 4
    //   186: invokespecial 105	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: athrow
    //   190: astore 5
    //   192: aload_3
    //   193: astore 4
    //   195: aload 5
    //   197: astore_3
    //   198: aload 4
    //   200: ifnull +8 -> 208
    //   203: aload 4
    //   205: invokevirtual 203	java/util/jar/JarFile:close	()V
    //   208: aload_3
    //   209: athrow
    //   210: astore 4
    //   212: aload_1
    //   213: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   216: pop
    //   217: goto -9 -> 208
    //   220: astore_3
    //   221: aconst_null
    //   222: astore 4
    //   224: goto -26 -> 198
    //   227: astore_3
    //   228: goto -30 -> 198
    //   231: astore 5
    //   233: aload 4
    //   235: astore_3
    //   236: aload 5
    //   238: astore 4
    //   240: goto -86 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	ShareSecurityCheck
    //   0	243	1	paramFile	File
    //   113	2	2	bool	boolean
    //   24	11	3	localEnumeration	java.util.Enumeration
    //   125	1	3	localIOException1	java.io.IOException
    //   141	1	3	localIOException2	java.io.IOException
    //   153	56	3	localObject1	Object
    //   220	1	3	localObject2	Object
    //   227	1	3	localObject3	Object
    //   235	1	3	localObject4	Object
    //   17	118	4	localJarFile	java.util.jar.JarFile
    //   150	35	4	localException1	Exception
    //   193	11	4	localObject5	Object
    //   210	1	4	localIOException3	java.io.IOException
    //   222	17	4	localObject6	Object
    //   43	66	5	localObject7	Object
    //   190	6	5	localObject8	Object
    //   231	6	5	localException2	Exception
    //   55	27	6	str	String
    // Exception table:
    //   from	to	target	type
    //   118	123	125	java/io/IOException
    //   134	139	141	java/io/IOException
    //   9	19	150	java/lang/Exception
    //   154	190	190	finally
    //   203	208	210	java/io/IOException
    //   9	19	220	finally
    //   19	25	227	finally
    //   25	45	227	finally
    //   50	101	227	finally
    //   106	114	227	finally
    //   19	25	231	java/lang/Exception
    //   25	45	231	java/lang/Exception
    //   50	101	231	java/lang/Exception
    //   106	114	231	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareSecurityCheck
 * JD-Core Version:    0.7.0.1
 */