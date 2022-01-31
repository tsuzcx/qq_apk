package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import java.io.File;

public class a
{
  public static int a(Context paramContext, File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "disable_get_apk_version_switch.txt")) {
        bool1 = true;
      }
    }
    return a(paramContext, paramFile, bool1);
  }
  
  public static int a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    if (paramFile != null) {}
    for (;;)
    {
      try
      {
        if (!paramFile.exists()) {
          break label62;
        }
        if ((Build.VERSION.SDK_INT != 23) && (Build.VERSION.SDK_INT != 25)) {
          break label109;
        }
        if (!Build.MANUFACTURER.toLowerCase().contains("mi")) {
          break label109;
        }
      }
      catch (Throwable localThrowable) {}
      i = b(paramFile);
      if (i > 0) {
        return i;
      }
      label62:
      label109:
      do
      {
        for (;;)
        {
          i = j;
          if (paramFile == null) {
            break;
          }
          i = j;
          if (!paramFile.exists()) {
            break;
          }
          try
          {
            paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
            i = j;
            if (paramContext == null) {
              break;
            }
            i = paramContext.versionCode;
            return i;
          }
          catch (Throwable paramContext)
          {
            return -1;
          }
        }
        i = 0;
        if (paramBoolean) {
          break;
        }
      } while (i == 0);
    }
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: bipush 16
    //   2: newarray char
    //   4: astore 5
    //   6: aload 5
    //   8: dup
    //   9: iconst_0
    //   10: ldc 84
    //   12: castore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 85
    //   17: castore
    //   18: dup
    //   19: iconst_2
    //   20: ldc 86
    //   22: castore
    //   23: dup
    //   24: iconst_3
    //   25: ldc 87
    //   27: castore
    //   28: dup
    //   29: iconst_4
    //   30: ldc 88
    //   32: castore
    //   33: dup
    //   34: iconst_5
    //   35: ldc 89
    //   37: castore
    //   38: dup
    //   39: bipush 6
    //   41: ldc 90
    //   43: castore
    //   44: dup
    //   45: bipush 7
    //   47: ldc 91
    //   49: castore
    //   50: dup
    //   51: bipush 8
    //   53: ldc 92
    //   55: castore
    //   56: dup
    //   57: bipush 9
    //   59: ldc 93
    //   61: castore
    //   62: dup
    //   63: bipush 10
    //   65: ldc 94
    //   67: castore
    //   68: dup
    //   69: bipush 11
    //   71: ldc 95
    //   73: castore
    //   74: dup
    //   75: bipush 12
    //   77: ldc 96
    //   79: castore
    //   80: dup
    //   81: bipush 13
    //   83: ldc 97
    //   85: castore
    //   86: dup
    //   87: bipush 14
    //   89: ldc 98
    //   91: castore
    //   92: dup
    //   93: bipush 15
    //   95: ldc 99
    //   97: castore
    //   98: pop
    //   99: bipush 32
    //   101: newarray char
    //   103: astore 6
    //   105: ldc 101
    //   107: invokestatic 106	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   110: astore 7
    //   112: new 108	java/io/FileInputStream
    //   115: dup
    //   116: aload_0
    //   117: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   120: astore_0
    //   121: sipush 8192
    //   124: newarray byte
    //   126: astore 8
    //   128: aload_0
    //   129: aload 8
    //   131: invokevirtual 116	java/io/FileInputStream:read	([B)I
    //   134: istore_1
    //   135: iload_1
    //   136: iconst_m1
    //   137: if_icmpeq +31 -> 168
    //   140: aload 7
    //   142: aload 8
    //   144: iconst_0
    //   145: iload_1
    //   146: invokevirtual 120	java/security/MessageDigest:update	([BII)V
    //   149: goto -21 -> 128
    //   152: astore 5
    //   154: aload_0
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 124	java/io/FileInputStream:close	()V
    //   162: aconst_null
    //   163: astore 5
    //   165: aload 5
    //   167: areturn
    //   168: aload 7
    //   170: invokevirtual 128	java/security/MessageDigest:digest	()[B
    //   173: astore 7
    //   175: iconst_0
    //   176: istore_1
    //   177: iconst_0
    //   178: istore_2
    //   179: goto +67 -> 246
    //   182: new 44	java/lang/String
    //   185: dup
    //   186: aload 6
    //   188: invokespecial 131	java/lang/String:<init>	([C)V
    //   191: astore 6
    //   193: aload 6
    //   195: astore 5
    //   197: aload_0
    //   198: ifnull -33 -> 165
    //   201: aload_0
    //   202: invokevirtual 124	java/io/FileInputStream:close	()V
    //   205: aload 6
    //   207: areturn
    //   208: astore_0
    //   209: aload 6
    //   211: areturn
    //   212: astore 5
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_0
    //   217: ifnull +7 -> 224
    //   220: aload_0
    //   221: invokevirtual 124	java/io/FileInputStream:close	()V
    //   224: aload 5
    //   226: athrow
    //   227: astore_0
    //   228: goto -66 -> 162
    //   231: astore_0
    //   232: goto -8 -> 224
    //   235: astore 5
    //   237: goto -21 -> 216
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_0
    //   243: goto -89 -> 154
    //   246: iload_1
    //   247: bipush 16
    //   249: if_icmpge -67 -> 182
    //   252: aload 7
    //   254: iload_1
    //   255: baload
    //   256: istore 4
    //   258: iload_2
    //   259: iconst_1
    //   260: iadd
    //   261: istore_3
    //   262: aload 6
    //   264: iload_2
    //   265: aload 5
    //   267: iload 4
    //   269: iconst_4
    //   270: iushr
    //   271: bipush 15
    //   273: iand
    //   274: caload
    //   275: castore
    //   276: aload 6
    //   278: iload_3
    //   279: aload 5
    //   281: iload 4
    //   283: bipush 15
    //   285: iand
    //   286: caload
    //   287: castore
    //   288: iload_1
    //   289: iconst_1
    //   290: iadd
    //   291: istore_1
    //   292: iload_3
    //   293: iconst_1
    //   294: iadd
    //   295: istore_2
    //   296: goto -50 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramFile	File
    //   134	158	1	i	int
    //   178	118	2	j	int
    //   261	34	3	k	int
    //   256	30	4	m	int
    //   4	3	5	arrayOfChar	char[]
    //   152	1	5	localException	Exception
    //   163	33	5	localObject1	Object
    //   212	13	5	localObject2	Object
    //   235	45	5	localObject3	Object
    //   103	174	6	localObject4	Object
    //   110	143	7	localObject5	Object
    //   126	17	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   121	128	152	java/lang/Exception
    //   128	135	152	java/lang/Exception
    //   140	149	152	java/lang/Exception
    //   168	175	152	java/lang/Exception
    //   182	193	152	java/lang/Exception
    //   201	205	208	java/io/IOException
    //   105	121	212	finally
    //   158	162	227	java/io/IOException
    //   220	224	231	java/io/IOException
    //   121	128	235	finally
    //   128	135	235	finally
    //   140	149	235	finally
    //   168	175	235	finally
    //   182	193	235	finally
    //   105	121	240	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return false;
      if ((paramLong <= 0L) || (paramLong == paramFile.length())) {
        try
        {
          if (paramInt == a(paramContext, paramFile))
          {
            boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(paramContext, true, paramFile));
            if (bool) {
              return true;
            }
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
  
  /* Error */
  public static int b(File paramFile)
  {
    // Byte code:
    //   0: new 151	java/util/jar/JarFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 152	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: new 154	java/io/BufferedReader
    //   12: dup
    //   13: new 156	java/io/InputStreamReader
    //   16: dup
    //   17: aload_3
    //   18: aload_3
    //   19: ldc 158
    //   21: invokevirtual 162	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   24: invokevirtual 166	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   27: invokespecial 169	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   30: invokespecial 172	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 175	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +104 -> 144
    //   43: aload_0
    //   44: ldc 177
    //   46: invokevirtual 54	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   49: ifeq -15 -> 34
    //   52: aload_0
    //   53: ldc 179
    //   55: invokevirtual 183	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   58: astore_0
    //   59: aload_0
    //   60: ifnull -26 -> 34
    //   63: aload_0
    //   64: arraylength
    //   65: iconst_2
    //   66: if_icmpne -32 -> 34
    //   69: aload_0
    //   70: iconst_1
    //   71: aaload
    //   72: invokevirtual 186	java/lang/String:trim	()Ljava/lang/String;
    //   75: invokestatic 192	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   78: istore_1
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_2
    //   84: invokevirtual 193	java/io/BufferedReader:close	()V
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokevirtual 194	java/util/jar/JarFile:close	()V
    //   95: iload_1
    //   96: ireturn
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_3
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 193	java/io/BufferedReader:close	()V
    //   110: aload_3
    //   111: ifnull +7 -> 118
    //   114: aload_3
    //   115: invokevirtual 194	java/util/jar/JarFile:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_3
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 193	java/io/BufferedReader:close	()V
    //   133: aload_3
    //   134: ifnull +62 -> 196
    //   137: aload_3
    //   138: invokevirtual 194	java/util/jar/JarFile:close	()V
    //   141: goto +55 -> 196
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 193	java/io/BufferedReader:close	()V
    //   152: aload_3
    //   153: ifnull +43 -> 196
    //   156: aload_3
    //   157: invokevirtual 194	java/util/jar/JarFile:close	()V
    //   160: goto +36 -> 196
    //   163: astore_0
    //   164: goto +32 -> 196
    //   167: astore_0
    //   168: iload_1
    //   169: ireturn
    //   170: astore_2
    //   171: goto -53 -> 118
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -75 -> 102
    //   180: astore_0
    //   181: goto -79 -> 102
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -62 -> 125
    //   190: astore_0
    //   191: aload_2
    //   192: astore_0
    //   193: goto -68 -> 125
    //   196: iconst_m1
    //   197: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramFile	File
    //   78	91	1	i	int
    //   33	116	2	localBufferedReader	java.io.BufferedReader
    //   170	1	2	localException	Exception
    //   176	16	2	localObject	Object
    //   8	149	3	localJarFile	java.util.jar.JarFile
    // Exception table:
    //   from	to	target	type
    //   0	9	97	finally
    //   0	9	120	java/lang/Exception
    //   129	133	163	java/lang/Exception
    //   137	141	163	java/lang/Exception
    //   148	152	163	java/lang/Exception
    //   156	160	163	java/lang/Exception
    //   83	87	167	java/lang/Exception
    //   91	95	167	java/lang/Exception
    //   106	110	170	java/lang/Exception
    //   114	118	170	java/lang/Exception
    //   9	34	174	finally
    //   34	39	180	finally
    //   43	59	180	finally
    //   63	79	180	finally
    //   9	34	184	java/lang/Exception
    //   34	39	190	java/lang/Exception
    //   43	59	190	java/lang/Exception
    //   63	79	190	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.a
 * JD-Core Version:    0.7.0.1
 */