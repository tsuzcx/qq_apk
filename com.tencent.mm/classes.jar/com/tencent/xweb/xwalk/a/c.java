package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class c
{
  public int BKm = -1;
  
  public c()
  {
    ean();
  }
  
  public final boolean TI(int paramInt)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e("XWalkPlugin", "set ver of " + eak() + " context is null");
      return false;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(eak());
    if (localObject == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "set ver of " + eak() + " sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("availableVersion", paramInt);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    if (bool) {
      this.BKm = paramInt;
    }
    XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "set ver of " + eak() + " to " + paramInt + ", isNow = true, ret = " + bool);
    return bool;
  }
  
  public final String TJ(int paramInt)
  {
    Object localObject;
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e("XWalkPlugin", "get dir of " + eak() + " context is null");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      localObject = XWalkEnvironment.getPluginBaseDir();
      if (((String)localObject).isEmpty())
      {
        Log.e("XWalkPlugin", "get dir of " + eak() + " pluginBaseDir is null");
        return "";
      }
      str = (String)localObject + File.separator + eak() + "_" + paramInt;
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final String TK(int paramInt)
  {
    Object localObject = TJ(paramInt);
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      Log.e("XWalkPlugin", "getCacheDir versionDir is empty");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "cache";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final String TL(int paramInt)
  {
    Object localObject = TJ(paramInt);
    if (((String)localObject).isEmpty())
    {
      Log.e("XWalkPlugin", "getExtractDir versionDir is null");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "extracted";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final String TM(int paramInt)
  {
    Object localObject = TJ(paramInt);
    if (((String)localObject).isEmpty())
    {
      Log.e("XWalkPlugin", "getPatchDir versionDir is null");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "patch_temp";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public abstract int a(d paramd);
  
  public abstract String aP(int paramInt, boolean paramBoolean);
  
  /* Error */
  public final boolean aQ(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 26
    //   2: new 28	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 148
    //   8: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 37	com/tencent/xweb/xwalk/a/c:eak	()Ljava/lang/String;
    //   15: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 150
    //   20: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 153	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: iload_1
    //   34: ifge +12 -> 46
    //   37: ldc 26
    //   39: ldc 155
    //   41: invokestatic 153	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iconst_0
    //   45: ireturn
    //   46: new 108	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: iload_1
    //   52: ldc 157
    //   54: invokevirtual 161	com/tencent/xweb/xwalk/a/c:bX	(ILjava/lang/String;)Ljava/lang/String;
    //   57: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 118	java/io/File:exists	()Z
    //   65: ifne +25 -> 90
    //   68: iload_2
    //   69: ifeq +12 -> 81
    //   72: ldc 26
    //   74: ldc 163
    //   76: invokestatic 153	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iconst_1
    //   80: ireturn
    //   81: ldc 26
    //   83: ldc 165
    //   85: invokestatic 52	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iconst_0
    //   89: ireturn
    //   90: new 167	java/io/BufferedReader
    //   93: dup
    //   94: new 169	java/io/FileReader
    //   97: dup
    //   98: aload_3
    //   99: invokespecial 172	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   102: invokespecial 175	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   105: astore 4
    //   107: aload 4
    //   109: astore_3
    //   110: aload 4
    //   112: invokevirtual 178	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +131 -> 250
    //   122: aload 4
    //   124: astore_3
    //   125: aload 5
    //   127: invokevirtual 103	java/lang/String:isEmpty	()Z
    //   130: ifne -23 -> 107
    //   133: aload 4
    //   135: astore_3
    //   136: aload 5
    //   138: ldc 180
    //   140: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   143: astore 6
    //   145: aload 4
    //   147: astore_3
    //   148: aload 6
    //   150: arraylength
    //   151: iconst_2
    //   152: if_icmpne -45 -> 107
    //   155: aload 6
    //   157: iconst_0
    //   158: aaload
    //   159: ifnull -52 -> 107
    //   162: aload 4
    //   164: astore_3
    //   165: aload 6
    //   167: iconst_0
    //   168: aaload
    //   169: invokevirtual 103	java/lang/String:isEmpty	()Z
    //   172: ifne -65 -> 107
    //   175: aload 6
    //   177: iconst_1
    //   178: aaload
    //   179: ifnull -72 -> 107
    //   182: aload 4
    //   184: astore_3
    //   185: aload 6
    //   187: iconst_1
    //   188: aaload
    //   189: invokevirtual 103	java/lang/String:isEmpty	()Z
    //   192: ifne -85 -> 107
    //   195: aload 6
    //   197: iconst_0
    //   198: aaload
    //   199: astore 5
    //   201: aload 6
    //   203: iconst_1
    //   204: aaload
    //   205: astore 6
    //   207: aload 4
    //   209: astore_3
    //   210: aload_0
    //   211: iload_1
    //   212: aload 5
    //   214: invokevirtual 161	com/tencent/xweb/xwalk/a/c:bX	(ILjava/lang/String;)Ljava/lang/String;
    //   217: aload 6
    //   219: invokestatic 190	com/tencent/xweb/util/d:gP	(Ljava/lang/String;Ljava/lang/String;)Z
    //   222: ifne -115 -> 107
    //   225: aload 4
    //   227: astore_3
    //   228: ldc 26
    //   230: ldc 192
    //   232: aload 5
    //   234: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   237: invokevirtual 200	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokestatic 52	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 4
    //   245: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   248: iconst_0
    //   249: ireturn
    //   250: aload 4
    //   252: astore_3
    //   253: ldc 26
    //   255: ldc 208
    //   257: invokestatic 153	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload 4
    //   262: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   265: iconst_1
    //   266: ireturn
    //   267: astore 5
    //   269: aconst_null
    //   270: astore 4
    //   272: aload 4
    //   274: astore_3
    //   275: ldc 26
    //   277: new 28	java/lang/StringBuilder
    //   280: dup
    //   281: ldc 210
    //   283: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: aload 5
    //   288: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 52	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload 4
    //   302: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   305: iconst_0
    //   306: ireturn
    //   307: astore 4
    //   309: aconst_null
    //   310: astore_3
    //   311: aload_3
    //   312: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   315: aload 4
    //   317: athrow
    //   318: astore 4
    //   320: goto -9 -> 311
    //   323: astore 5
    //   325: goto -53 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	c
    //   0	328	1	paramInt	int
    //   0	328	2	paramBoolean	boolean
    //   60	252	3	localObject1	Object
    //   105	196	4	localBufferedReader	java.io.BufferedReader
    //   307	9	4	localObject2	Object
    //   318	1	4	localObject3	Object
    //   115	118	5	str	String
    //   267	20	5	localException1	java.lang.Exception
    //   323	1	5	localException2	java.lang.Exception
    //   143	75	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   90	107	267	java/lang/Exception
    //   90	107	307	finally
    //   110	117	318	finally
    //   125	133	318	finally
    //   136	145	318	finally
    //   148	155	318	finally
    //   165	175	318	finally
    //   185	195	318	finally
    //   210	225	318	finally
    //   228	243	318	finally
    //   253	260	318	finally
    //   275	300	318	finally
    //   110	117	323	java/lang/Exception
    //   125	133	323	java/lang/Exception
    //   136	145	323	java/lang/Exception
    //   148	155	323	java/lang/Exception
    //   165	175	323	java/lang/Exception
    //   185	195	323	java/lang/Exception
    //   210	225	323	java/lang/Exception
    //   228	243	323	java/lang/Exception
    //   253	260	323	java/lang/Exception
  }
  
  /* Error */
  protected final boolean b(d paramd)
  {
    // Byte code:
    //   0: ldc 26
    //   2: new 28	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 217
    //   8: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 37	com/tencent/xweb/xwalk/a/c:eak	()Ljava/lang/String;
    //   15: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 219
    //   20: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: getfield 224	com/tencent/xweb/xwalk/a/d:version	I
    //   27: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 153	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: new 108	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: getfield 227	com/tencent/xweb/xwalk/a/d:path	Ljava/lang/String;
    //   44: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 5
    //   49: aload_1
    //   50: getfield 227	com/tencent/xweb/xwalk/a/d:path	Ljava/lang/String;
    //   53: aload_1
    //   54: getfield 230	com/tencent/xweb/xwalk/a/d:cqq	Ljava/lang/String;
    //   57: invokestatic 190	com/tencent/xweb/util/d:gP	(Ljava/lang/String;Ljava/lang/String;)Z
    //   60: ifne +30 -> 90
    //   63: ldc 26
    //   65: ldc 232
    //   67: invokestatic 153	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aconst_null
    //   71: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   74: aload 5
    //   76: invokevirtual 118	java/io/File:exists	()Z
    //   79: ifeq +9 -> 88
    //   82: aload 5
    //   84: invokevirtual 235	java/io/File:delete	()Z
    //   87: pop
    //   88: iconst_0
    //   89: ireturn
    //   90: new 237	java/util/zip/ZipFile
    //   93: dup
    //   94: aload_1
    //   95: getfield 227	com/tencent/xweb/xwalk/a/d:path	Ljava/lang/String;
    //   98: invokespecial 238	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   101: astore_3
    //   102: aload_3
    //   103: invokevirtual 242	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   106: astore 6
    //   108: aload 6
    //   110: invokeinterface 247 1 0
    //   115: ifeq +204 -> 319
    //   118: aload 6
    //   120: invokeinterface 251 1 0
    //   125: checkcast 253	java/util/zip/ZipEntry
    //   128: astore 7
    //   130: aload 7
    //   132: invokevirtual 256	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   135: ldc_w 258
    //   138: invokestatic 264	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 4
    //   143: aload 4
    //   145: ldc_w 266
    //   148: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   151: ifne -43 -> 108
    //   154: aload 4
    //   156: ldc_w 272
    //   159: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   162: ifne -54 -> 108
    //   165: aload 7
    //   167: invokevirtual 275	java/util/zip/ZipEntry:isDirectory	()Z
    //   170: ifne -62 -> 108
    //   173: aload_3
    //   174: aload 7
    //   176: invokevirtual 279	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   179: astore 7
    //   181: aload_1
    //   182: getfield 283	com/tencent/xweb/xwalk/a/d:isPatch	Z
    //   185: ifeq +60 -> 245
    //   188: new 108	java/io/File
    //   191: dup
    //   192: aload_0
    //   193: aload_1
    //   194: getfield 224	com/tencent/xweb/xwalk/a/d:version	I
    //   197: aload 4
    //   199: invokevirtual 286	com/tencent/xweb/xwalk/a/c:bY	(ILjava/lang/String;)Ljava/lang/String;
    //   202: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: astore 4
    //   207: aload 7
    //   209: aload 4
    //   211: invokestatic 289	com/tencent/xweb/util/b:a	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   214: ifne -106 -> 108
    //   217: ldc 26
    //   219: ldc_w 291
    //   222: invokestatic 52	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_3
    //   226: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   229: aload 5
    //   231: invokevirtual 118	java/io/File:exists	()Z
    //   234: ifeq +9 -> 243
    //   237: aload 5
    //   239: invokevirtual 235	java/io/File:delete	()Z
    //   242: pop
    //   243: iconst_0
    //   244: ireturn
    //   245: new 108	java/io/File
    //   248: dup
    //   249: aload_0
    //   250: aload_1
    //   251: getfield 224	com/tencent/xweb/xwalk/a/d:version	I
    //   254: aload 4
    //   256: invokevirtual 161	com/tencent/xweb/xwalk/a/c:bX	(ILjava/lang/String;)Ljava/lang/String;
    //   259: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   262: astore 4
    //   264: goto -57 -> 207
    //   267: astore 4
    //   269: aload_3
    //   270: astore_1
    //   271: aload 4
    //   273: astore_3
    //   274: ldc 26
    //   276: new 28	java/lang/StringBuilder
    //   279: dup
    //   280: ldc_w 293
    //   283: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: aload_3
    //   287: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 52	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_1
    //   300: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   303: aload 5
    //   305: invokevirtual 118	java/io/File:exists	()Z
    //   308: ifeq +9 -> 317
    //   311: aload 5
    //   313: invokevirtual 235	java/io/File:delete	()Z
    //   316: pop
    //   317: iconst_0
    //   318: ireturn
    //   319: aload_1
    //   320: getfield 296	com/tencent/xweb/xwalk/a/d:BKp	Z
    //   323: ifne +12 -> 335
    //   326: aload_1
    //   327: getfield 283	com/tencent/xweb/xwalk/a/d:isPatch	Z
    //   330: istore_2
    //   331: iload_2
    //   332: ifeq +23 -> 355
    //   335: aload_3
    //   336: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   339: aload 5
    //   341: invokevirtual 118	java/io/File:exists	()Z
    //   344: ifeq +9 -> 353
    //   347: aload 5
    //   349: invokevirtual 235	java/io/File:delete	()Z
    //   352: pop
    //   353: iconst_1
    //   354: ireturn
    //   355: aload_0
    //   356: aload_1
    //   357: getfield 224	com/tencent/xweb/xwalk/a/d:version	I
    //   360: iconst_0
    //   361: invokevirtual 298	com/tencent/xweb/xwalk/a/c:aQ	(IZ)Z
    //   364: ifne +31 -> 395
    //   367: ldc 26
    //   369: ldc_w 300
    //   372: invokestatic 52	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_3
    //   376: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   379: aload 5
    //   381: invokevirtual 118	java/io/File:exists	()Z
    //   384: ifeq +9 -> 393
    //   387: aload 5
    //   389: invokevirtual 235	java/io/File:delete	()Z
    //   392: pop
    //   393: iconst_0
    //   394: ireturn
    //   395: aload_3
    //   396: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   399: aload 5
    //   401: invokevirtual 118	java/io/File:exists	()Z
    //   404: ifeq +9 -> 413
    //   407: aload 5
    //   409: invokevirtual 235	java/io/File:delete	()Z
    //   412: pop
    //   413: iconst_1
    //   414: ireturn
    //   415: astore_1
    //   416: aconst_null
    //   417: astore_3
    //   418: aload_3
    //   419: invokestatic 206	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   422: aload 5
    //   424: invokevirtual 118	java/io/File:exists	()Z
    //   427: ifeq +9 -> 436
    //   430: aload 5
    //   432: invokevirtual 235	java/io/File:delete	()Z
    //   435: pop
    //   436: aload_1
    //   437: athrow
    //   438: astore_1
    //   439: goto -21 -> 418
    //   442: astore 4
    //   444: aload_1
    //   445: astore_3
    //   446: aload 4
    //   448: astore_1
    //   449: goto -31 -> 418
    //   452: astore_3
    //   453: aconst_null
    //   454: astore_1
    //   455: goto -181 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	c
    //   0	458	1	paramd	d
    //   330	2	2	bool	boolean
    //   101	345	3	localObject1	Object
    //   452	1	3	localException1	java.lang.Exception
    //   141	122	4	localObject2	Object
    //   267	5	4	localException2	java.lang.Exception
    //   442	5	4	localObject3	Object
    //   47	384	5	localFile	File
    //   106	13	6	localEnumeration	java.util.Enumeration
    //   128	80	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   102	108	267	java/lang/Exception
    //   108	207	267	java/lang/Exception
    //   207	225	267	java/lang/Exception
    //   245	264	267	java/lang/Exception
    //   319	331	267	java/lang/Exception
    //   355	375	267	java/lang/Exception
    //   49	70	415	finally
    //   90	102	415	finally
    //   102	108	438	finally
    //   108	207	438	finally
    //   207	225	438	finally
    //   245	264	438	finally
    //   319	331	438	finally
    //   355	375	438	finally
    //   274	299	442	finally
    //   49	70	452	java/lang/Exception
    //   90	102	452	java/lang/Exception
  }
  
  public final String bX(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XWalkPlugin", "getExtractFile fileName is null");
      return "";
    }
    String str = TL(paramInt);
    if (str.isEmpty())
    {
      Log.e("XWalkPlugin", "getExtractFile dir is null");
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public final String bY(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XWalkPlugin", "getPatchFile fileName is null");
      return "";
    }
    String str = TM(paramInt);
    if (str.isEmpty())
    {
      Log.e("XWalkPlugin", "getPatchFile dir is null");
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public abstract String eak();
  
  public abstract boolean eal();
  
  public abstract void eam();
  
  public final void ean()
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e("XWalkPlugin", "load ver of " + eak() + " context is null");
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(eak());
    if (localSharedPreferences == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "load ver of " + eak() + " sp is null");
      return;
    }
    this.BKm = localSharedPreferences.getInt("availableVersion", -1);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "load ver of " + eak() + " ver " + this.BKm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.c
 * JD-Core Version:    0.7.0.1
 */