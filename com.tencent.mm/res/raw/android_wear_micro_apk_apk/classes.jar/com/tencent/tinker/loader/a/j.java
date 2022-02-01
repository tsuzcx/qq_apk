package com.tencent.tinker.loader.a;

import android.content.Context;
import android.content.pm.Signature;
import android.util.Log;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.security.cert.Certificate;
import java.util.HashMap;

public final class j
{
  private static String apW = null;
  private final HashMap<String, String> apX;
  private final HashMap<String, String> apY;
  private final Context mContext;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
    this.apX = new HashMap();
    this.apY = new HashMap();
    if (apW == null)
    {
      paramContext = this.mContext;
      try
      {
        paramContext = f.p(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray());
        apW = paramContext;
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
        f.aa(null);
      }
      f.aa(null);
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
          boolean bool = apW.equals(f.p(paramArrayOfCertificate[i].getEncoded()));
          if (bool) {
            return true;
          }
        }
        catch (Exception localException)
        {
          Log.e("Tinker.SecurityCheck", paramFile.getAbsolutePath(), localException);
          i -= 1;
        }
      }
    }
    return false;
  }
  
  public final HashMap<String, String> oY()
  {
    return this.apX;
  }
  
  public final HashMap<String, String> oZ()
  {
    if (!this.apY.isEmpty()) {
      return this.apY;
    }
    Object localObject = (String)this.apX.get("assets/package_meta.txt");
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
          this.apY.put(arrayOfString[0].trim(), arrayOfString[1].trim());
        }
      }
      i += 1;
    }
    return this.apY;
  }
  
  /* Error */
  public final boolean p(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 157	com/tencent/tinker/loader/a/f:j	(Ljava/io/File;)Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 159	java/util/jar/JarFile
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 162	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 166	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 171 1 0
    //   31: ifeq +108 -> 139
    //   34: aload_3
    //   35: invokeinterface 175 1 0
    //   40: checkcast 177	java/util/jar/JarEntry
    //   43: astore 5
    //   45: aload 5
    //   47: ifnull -22 -> 25
    //   50: aload 5
    //   52: invokevirtual 180	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   55: astore 6
    //   57: aload 6
    //   59: ldc 182
    //   61: invokevirtual 139	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifne -39 -> 25
    //   67: aload 6
    //   69: ldc 184
    //   71: invokevirtual 187	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   74: ifeq -49 -> 25
    //   77: aload_0
    //   78: getfield 30	com/tencent/tinker/loader/a/j:apX	Ljava/util/HashMap;
    //   81: aload 6
    //   83: aload 4
    //   85: aload 5
    //   87: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)Ljava/lang/String;
    //   90: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload 5
    //   96: invokevirtual 194	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   99: astore 5
    //   101: aload 5
    //   103: ifnull +14 -> 117
    //   106: aload_1
    //   107: aload 5
    //   109: invokestatic 196	com/tencent/tinker/loader/a/j:a	(Ljava/io/File;[Ljava/security/cert/Certificate;)Z
    //   112: istore_2
    //   113: iload_2
    //   114: ifne -89 -> 25
    //   117: aload 4
    //   119: invokevirtual 199	java/util/jar/JarFile:close	()V
    //   122: iconst_0
    //   123: ireturn
    //   124: astore_3
    //   125: ldc 97
    //   127: aload_1
    //   128: invokevirtual 102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   131: aload_3
    //   132: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   135: pop
    //   136: goto -14 -> 122
    //   139: aload 4
    //   141: invokevirtual 199	java/util/jar/JarFile:close	()V
    //   144: iconst_1
    //   145: ireturn
    //   146: astore_3
    //   147: ldc 97
    //   149: aload_1
    //   150: invokevirtual 102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   153: aload_3
    //   154: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   157: pop
    //   158: goto -14 -> 144
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_3
    //   165: new 68	com/tencent/tinker/loader/TinkerRuntimeException
    //   168: dup
    //   169: ldc 201
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_1
    //   178: invokevirtual 102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_1
    //   185: invokevirtual 204	java/io/File:length	()J
    //   188: invokestatic 210	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: aastore
    //   192: invokestatic 214	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   195: aload 4
    //   197: invokespecial 78	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: athrow
    //   201: astore 5
    //   203: aload_3
    //   204: astore 4
    //   206: aload 5
    //   208: astore_3
    //   209: aload 4
    //   211: ifnull +8 -> 219
    //   214: aload 4
    //   216: invokevirtual 199	java/util/jar/JarFile:close	()V
    //   219: aload_3
    //   220: athrow
    //   221: astore 4
    //   223: ldc 97
    //   225: aload_1
    //   226: invokevirtual 102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   229: aload 4
    //   231: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   234: pop
    //   235: goto -16 -> 219
    //   238: astore_3
    //   239: aconst_null
    //   240: astore 4
    //   242: goto -33 -> 209
    //   245: astore_3
    //   246: goto -37 -> 209
    //   249: astore 5
    //   251: aload 4
    //   253: astore_3
    //   254: aload 5
    //   256: astore 4
    //   258: goto -93 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	j
    //   0	261	1	paramFile	File
    //   112	2	2	bool	boolean
    //   24	11	3	localEnumeration	java.util.Enumeration
    //   124	8	3	localIOException1	java.io.IOException
    //   146	8	3	localIOException2	java.io.IOException
    //   164	56	3	localObject1	Object
    //   238	1	3	localObject2	Object
    //   245	1	3	localObject3	Object
    //   253	1	3	localObject4	Object
    //   17	123	4	localJarFile	java.util.jar.JarFile
    //   161	35	4	localException1	Exception
    //   204	11	4	localObject5	Object
    //   221	9	4	localIOException3	java.io.IOException
    //   240	17	4	localObject6	Object
    //   43	65	5	localObject7	Object
    //   201	6	5	localObject8	Object
    //   249	6	5	localException2	Exception
    //   55	27	6	str	String
    // Exception table:
    //   from	to	target	type
    //   117	122	124	java/io/IOException
    //   139	144	146	java/io/IOException
    //   9	19	161	java/lang/Exception
    //   165	201	201	finally
    //   214	219	221	java/io/IOException
    //   9	19	238	finally
    //   19	25	245	finally
    //   25	45	245	finally
    //   50	101	245	finally
    //   106	113	245	finally
    //   19	25	249	java/lang/Exception
    //   25	45	249	java/lang/Exception
    //   50	101	249	java/lang/Exception
    //   106	113	249	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.j
 * JD-Core Version:    0.7.0.1
 */