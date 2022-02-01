package com.tencent.tinker.loader.shareutil;

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
          ShareTinkerLog.e("Tinker.SecurityCheck", paramFile.getAbsolutePath(), new Object[] { localException });
          i -= 1;
        }
      }
    }
    return false;
  }
  
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
    //   1: invokestatic 162	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isLegalFile	(Ljava/io/File;)Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 164	java/util/jar/JarFile
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 167	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: aload 4
    //   24: invokevirtual 171	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   27: astore 5
    //   29: aload 4
    //   31: astore_3
    //   32: aload 5
    //   34: invokeinterface 176 1 0
    //   39: ifeq +137 -> 176
    //   42: aload 4
    //   44: astore_3
    //   45: aload 5
    //   47: invokeinterface 180 1 0
    //   52: checkcast 182	java/util/jar/JarEntry
    //   55: astore 6
    //   57: aload 6
    //   59: ifnull -30 -> 29
    //   62: aload 4
    //   64: astore_3
    //   65: aload 6
    //   67: invokevirtual 185	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   70: astore 7
    //   72: aload 4
    //   74: astore_3
    //   75: aload 7
    //   77: ldc 187
    //   79: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifne -53 -> 29
    //   85: aload 4
    //   87: astore_3
    //   88: aload 7
    //   90: ldc 189
    //   92: invokevirtual 192	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   95: ifeq -66 -> 29
    //   98: aload 4
    //   100: astore_3
    //   101: aload_0
    //   102: getfield 31	com/tencent/tinker/loader/shareutil/ShareSecurityCheck:metaContentMap	Ljava/util/HashMap;
    //   105: aload 7
    //   107: aload 4
    //   109: aload 6
    //   111: invokestatic 196	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:loadDigestes	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)Ljava/lang/String;
    //   114: invokevirtual 155	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: aload 4
    //   120: astore_3
    //   121: aload 6
    //   123: invokevirtual 200	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   126: astore 6
    //   128: aload 6
    //   130: ifnull +18 -> 148
    //   133: aload 4
    //   135: astore_3
    //   136: aload_0
    //   137: aload_1
    //   138: aload 6
    //   140: invokespecial 202	com/tencent/tinker/loader/shareutil/ShareSecurityCheck:check	(Ljava/io/File;[Ljava/security/cert/Certificate;)Z
    //   143: istore_2
    //   144: iload_2
    //   145: ifne -116 -> 29
    //   148: aload 4
    //   150: invokevirtual 205	java/util/jar/JarFile:close	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_3
    //   156: ldc 8
    //   158: aload_1
    //   159: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   162: iconst_1
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_3
    //   169: aastore
    //   170: invokestatic 70	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: goto -20 -> 153
    //   176: aload 4
    //   178: invokevirtual 205	java/util/jar/JarFile:close	()V
    //   181: iconst_1
    //   182: ireturn
    //   183: astore_3
    //   184: ldc 8
    //   186: aload_1
    //   187: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_3
    //   197: aastore
    //   198: invokestatic 70	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: goto -20 -> 181
    //   204: astore 5
    //   206: aconst_null
    //   207: astore_3
    //   208: new 98	com/tencent/tinker/loader/TinkerRuntimeException
    //   211: dup
    //   212: ldc 207
    //   214: iconst_2
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: aload_1
    //   221: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: aload_1
    //   228: invokevirtual 210	java/io/File:length	()J
    //   231: invokestatic 216	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   234: aastore
    //   235: invokestatic 220	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   238: aload 5
    //   240: invokespecial 108	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   243: athrow
    //   244: astore 5
    //   246: aload_3
    //   247: astore 4
    //   249: aload 5
    //   251: astore_3
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 205	java/util/jar/JarFile:close	()V
    //   262: aload_3
    //   263: athrow
    //   264: astore 4
    //   266: ldc 8
    //   268: aload_1
    //   269: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload 4
    //   280: aastore
    //   281: invokestatic 70	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: goto -22 -> 262
    //   287: astore_3
    //   288: aconst_null
    //   289: astore 4
    //   291: goto -39 -> 252
    //   294: astore 5
    //   296: aload 4
    //   298: astore_3
    //   299: goto -91 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	ShareSecurityCheck
    //   0	302	1	paramFile	File
    //   143	2	2	bool	boolean
    //   21	115	3	localObject1	Object
    //   155	14	3	localIOException1	java.io.IOException
    //   183	14	3	localIOException2	java.io.IOException
    //   207	56	3	localObject2	Object
    //   287	1	3	localObject3	Object
    //   298	1	3	localObject4	Object
    //   17	241	4	localObject5	Object
    //   264	15	4	localIOException3	java.io.IOException
    //   289	8	4	localObject6	Object
    //   27	19	5	localEnumeration	java.util.Enumeration
    //   204	35	5	localException1	Exception
    //   244	6	5	localObject7	Object
    //   294	1	5	localException2	Exception
    //   55	84	6	localObject8	Object
    //   70	36	7	str	String
    // Exception table:
    //   from	to	target	type
    //   148	153	155	java/io/IOException
    //   176	181	183	java/io/IOException
    //   9	19	204	java/lang/Exception
    //   22	29	244	finally
    //   32	42	244	finally
    //   45	57	244	finally
    //   65	72	244	finally
    //   75	85	244	finally
    //   88	98	244	finally
    //   101	118	244	finally
    //   121	128	244	finally
    //   136	144	244	finally
    //   208	244	244	finally
    //   257	262	264	java/io/IOException
    //   9	19	287	finally
    //   22	29	294	java/lang/Exception
    //   32	42	294	java/lang/Exception
    //   45	57	294	java/lang/Exception
    //   65	72	294	java/lang/Exception
    //   75	85	294	java/lang/Exception
    //   88	98	294	java/lang/Exception
    //   101	118	294	java/lang/Exception
    //   121	128	294	java/lang/Exception
    //   136	144	294	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareSecurityCheck
 * JD-Core Version:    0.7.0.1
 */