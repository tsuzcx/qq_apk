package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class g
{
  public int SHU = -1;
  
  public g()
  {
    hvl();
  }
  
  private String atg(int paramInt)
  {
    Object localObject = atd(paramInt);
    if (((String)localObject).isEmpty())
    {
      Log.e(getPluginName(), "getPatchDir, versionDir is empty");
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
  
  private String dB(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e(getPluginName(), "getPatchFile, fileName is empty");
      return "";
    }
    String str = atg(paramInt);
    if (str.isEmpty())
    {
      Log.e(getPluginName(), "getPatchFile, patchDir is null");
      return "";
    }
    return str + File.separator + paramString;
  }
  
  private void hvl()
  {
    if (XWalkEnvironment.getApplicationContext() == null) {
      Log.e(getPluginName(), "loadVer, context is null");
    }
    int i;
    do
    {
      return;
      SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
      if (localSharedPreferences == null)
      {
        Log.e(getPluginName(), "loadVer, sp is null");
        return;
      }
      i = this.SHU;
      this.SHU = localSharedPreferences.getInt("availableVersion", -1);
    } while (this.SHU == i);
    if (i == -1)
    {
      Log.i(getPluginName(), "loadVer, version = " + this.SHU);
      return;
    }
    Log.i(getPluginName(), "loadVer, old version = " + i + ", new version = " + this.SHU);
  }
  
  public abstract int a(com.tencent.xweb.xwalk.updater.c paramc);
  
  public final boolean atc(int paramInt)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(getPluginName(), "setVer, context is null");
      return false;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
    if (localObject == null)
    {
      Log.e(getPluginName(), "setVer, sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("availableVersion", paramInt);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    if (bool) {
      this.SHU = paramInt;
    }
    Log.i(getPluginName(), "setVer, version = " + paramInt + ", isNow = true, ret = " + bool);
    return bool;
  }
  
  public final String atd(int paramInt)
  {
    Object localObject;
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(getPluginName(), "getVersionDir, context is null");
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
        Log.e(getPluginName(), "getVersionDir, pluginBaseDir is null");
        return "";
      }
      str = (String)localObject + File.separator + getPluginName() + "_" + paramInt;
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final String ate(int paramInt)
  {
    Object localObject = atd(paramInt);
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      Log.e(getPluginName(), "getPrivateCacheDir, versionDir is empty");
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
  
  public final String atf(int paramInt)
  {
    Object localObject = atd(paramInt);
    if (((String)localObject).isEmpty())
    {
      Log.e(getPluginName(), "getExtractDir, versionDir is empty");
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
  
  /* Error */
  protected final boolean b(com.tencent.xweb.xwalk.updater.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   4: new 43	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 164
    //   10: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_1
    //   14: getfield 169	com/tencent/xweb/xwalk/updater/c:version	I
    //   17: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: new 50	java/io/File
    //   29: dup
    //   30: aload_1
    //   31: getfield 172	com/tencent/xweb/xwalk/updater/c:path	Ljava/lang/String;
    //   34: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload_1
    //   40: getfield 172	com/tencent/xweb/xwalk/updater/c:path	Ljava/lang/String;
    //   43: aload_1
    //   44: getfield 175	com/tencent/xweb/xwalk/updater/c:SID	Ljava/lang/String;
    //   47: invokestatic 181	com/tencent/xweb/util/d:oi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: ifne +32 -> 82
    //   53: aload_0
    //   54: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   57: ldc 183
    //   59: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aconst_null
    //   63: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   66: aload 5
    //   68: invokevirtual 65	java/io/File:exists	()Z
    //   71: ifeq +9 -> 80
    //   74: aload 5
    //   76: invokevirtual 192	java/io/File:delete	()Z
    //   79: pop
    //   80: iconst_0
    //   81: ireturn
    //   82: new 194	java/util/zip/ZipFile
    //   85: dup
    //   86: aload_1
    //   87: getfield 172	com/tencent/xweb/xwalk/updater/c:path	Ljava/lang/String;
    //   90: invokespecial 195	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 199	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   98: astore 6
    //   100: aload 6
    //   102: invokeinterface 204 1 0
    //   107: ifeq +203 -> 310
    //   110: aload 6
    //   112: invokeinterface 208 1 0
    //   117: checkcast 210	java/util/zip/ZipEntry
    //   120: astore 7
    //   122: aload 7
    //   124: invokevirtual 213	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   127: ldc 215
    //   129: invokestatic 221	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 4
    //   134: aload 4
    //   136: ldc 223
    //   138: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifne -41 -> 100
    //   144: aload 4
    //   146: ldc 229
    //   148: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   151: ifne -51 -> 100
    //   154: aload 7
    //   156: invokevirtual 232	java/util/zip/ZipEntry:isDirectory	()Z
    //   159: ifne -59 -> 100
    //   162: aload_3
    //   163: aload 7
    //   165: invokevirtual 236	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   168: astore 7
    //   170: aload_1
    //   171: getfield 240	com/tencent/xweb/xwalk/updater/c:SJc	Z
    //   174: ifeq +61 -> 235
    //   177: new 50	java/io/File
    //   180: dup
    //   181: aload_0
    //   182: aload_1
    //   183: getfield 169	com/tencent/xweb/xwalk/updater/c:version	I
    //   186: aload 4
    //   188: invokespecial 242	com/tencent/xweb/xwalk/a/g:dB	(ILjava/lang/String;)Ljava/lang/String;
    //   191: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: astore 4
    //   196: aload 7
    //   198: aload 4
    //   200: invokestatic 245	com/tencent/xweb/util/c:b	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   203: ifne -103 -> 100
    //   206: aload_0
    //   207: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   210: ldc 247
    //   212: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_3
    //   216: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   219: aload 5
    //   221: invokevirtual 65	java/io/File:exists	()Z
    //   224: ifeq +9 -> 233
    //   227: aload 5
    //   229: invokevirtual 192	java/io/File:delete	()Z
    //   232: pop
    //   233: iconst_0
    //   234: ireturn
    //   235: new 50	java/io/File
    //   238: dup
    //   239: aload_0
    //   240: aload_1
    //   241: getfield 169	com/tencent/xweb/xwalk/updater/c:version	I
    //   244: aload 4
    //   246: invokevirtual 250	com/tencent/xweb/xwalk/a/g:dA	(ILjava/lang/String;)Ljava/lang/String;
    //   249: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   252: astore 4
    //   254: goto -58 -> 196
    //   257: astore 4
    //   259: aload_3
    //   260: astore_1
    //   261: aload 4
    //   263: astore_3
    //   264: aload_0
    //   265: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   268: new 43	java/lang/StringBuilder
    //   271: dup
    //   272: ldc 252
    //   274: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: aload_3
    //   278: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_1
    //   291: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   294: aload 5
    //   296: invokevirtual 65	java/io/File:exists	()Z
    //   299: ifeq +9 -> 308
    //   302: aload 5
    //   304: invokevirtual 192	java/io/File:delete	()Z
    //   307: pop
    //   308: iconst_0
    //   309: ireturn
    //   310: aload_1
    //   311: getfield 258	com/tencent/xweb/xwalk/updater/c:SJl	Z
    //   314: ifne +12 -> 326
    //   317: aload_1
    //   318: getfield 240	com/tencent/xweb/xwalk/updater/c:SJc	Z
    //   321: istore_2
    //   322: iload_2
    //   323: ifeq +23 -> 346
    //   326: aload_3
    //   327: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   330: aload 5
    //   332: invokevirtual 65	java/io/File:exists	()Z
    //   335: ifeq +9 -> 344
    //   338: aload 5
    //   340: invokevirtual 192	java/io/File:delete	()Z
    //   343: pop
    //   344: iconst_1
    //   345: ireturn
    //   346: aload_0
    //   347: aload_1
    //   348: getfield 169	com/tencent/xweb/xwalk/updater/c:version	I
    //   351: iconst_0
    //   352: invokevirtual 262	com/tencent/xweb/xwalk/a/g:cb	(IZ)Z
    //   355: ifne +33 -> 388
    //   358: aload_0
    //   359: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   362: ldc_w 264
    //   365: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload_3
    //   369: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   372: aload 5
    //   374: invokevirtual 65	java/io/File:exists	()Z
    //   377: ifeq +9 -> 386
    //   380: aload 5
    //   382: invokevirtual 192	java/io/File:delete	()Z
    //   385: pop
    //   386: iconst_0
    //   387: ireturn
    //   388: aload_3
    //   389: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   392: aload 5
    //   394: invokevirtual 65	java/io/File:exists	()Z
    //   397: ifeq +9 -> 406
    //   400: aload 5
    //   402: invokevirtual 192	java/io/File:delete	()Z
    //   405: pop
    //   406: iconst_1
    //   407: ireturn
    //   408: astore_1
    //   409: aconst_null
    //   410: astore_3
    //   411: aload_3
    //   412: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   415: aload 5
    //   417: invokevirtual 65	java/io/File:exists	()Z
    //   420: ifeq +9 -> 429
    //   423: aload 5
    //   425: invokevirtual 192	java/io/File:delete	()Z
    //   428: pop
    //   429: aload_1
    //   430: athrow
    //   431: astore_1
    //   432: goto -21 -> 411
    //   435: astore 4
    //   437: aload_1
    //   438: astore_3
    //   439: aload 4
    //   441: astore_1
    //   442: goto -31 -> 411
    //   445: astore_3
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -184 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	g
    //   0	451	1	paramc	com.tencent.xweb.xwalk.updater.c
    //   321	2	2	bool	boolean
    //   93	346	3	localObject1	Object
    //   445	1	3	localException1	Exception
    //   132	121	4	localObject2	Object
    //   257	5	4	localException2	Exception
    //   435	5	4	localObject3	Object
    //   37	387	5	localFile	File
    //   98	13	6	localEnumeration	java.util.Enumeration
    //   120	77	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   94	100	257	java/lang/Exception
    //   100	196	257	java/lang/Exception
    //   196	215	257	java/lang/Exception
    //   235	254	257	java/lang/Exception
    //   310	322	257	java/lang/Exception
    //   346	368	257	java/lang/Exception
    //   39	62	408	finally
    //   82	94	408	finally
    //   94	100	431	finally
    //   100	196	431	finally
    //   196	215	431	finally
    //   235	254	431	finally
    //   310	322	431	finally
    //   346	368	431	finally
    //   264	290	435	finally
    //   39	62	445	java/lang/Exception
    //   82	94	445	java/lang/Exception
  }
  
  protected final boolean c(com.tencent.xweb.xwalk.updater.c paramc)
  {
    int i = this.SHU;
    Log.i(getPluginName(), "doPatch current version = " + i + ", new version = " + paramc.version);
    if (i < 0)
    {
      Log.e(getPluginName(), "doPatch, current version invalid");
      return false;
    }
    if (!paramc.SJc)
    {
      Log.e(getPluginName(), "doPatch, current download config is not patch");
      return false;
    }
    Object localObject = new File(dB(paramc.version, "patch.config"));
    if (!((File)localObject).exists())
    {
      Log.e(getPluginName(), "doPatch, can not find patch config file");
      return false;
    }
    localObject = i.ao((File)localObject);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      Log.e(getPluginName(), "doPatch, patchConfigList = null");
      return false;
    }
    if (!com.tencent.xweb.util.c.oh(atf(i), atf(paramc.version)))
    {
      Log.e(getPluginName(), "doPatch, copy files failed");
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i.a locala = (i.a)((Iterator)localObject).next();
      if (locala.type == 1) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (!com.tencent.xweb.util.c.copyFile(dB(paramc.version, locala.originalFileName), dA(paramc.version, locala.originalFileName)))
          {
            Log.e(getPluginName(), "doPatch, add file error: ".concat(String.valueOf(locala)));
            return false;
            i = 0;
          }
          else
          {
            Log.i(getPluginName(), "doPatch, add file:".concat(String.valueOf(locala)));
            break;
          }
        }
      }
      if (locala.type == 3) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (!com.tencent.xweb.util.c.deleteFile(dA(paramc.version, locala.originalFileName)))
          {
            Log.e(getPluginName(), "doPatch, delete file error:".concat(String.valueOf(locala)));
            break;
            i = 0;
            continue;
          }
          Log.i(getPluginName(), "doPatch, delete file:".concat(String.valueOf(locala)));
          break;
        }
      }
      if (locala.type == 2) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (BSpatch.bv(dA(paramc.version, locala.originalFileName), dB(paramc.version, locala.patchFileName), dA(paramc.version, locala.originalFileName)) < 0)
          {
            Log.e(getPluginName(), "doPatch, patch file error:".concat(String.valueOf(locala)));
            return false;
            i = 0;
          }
          else
          {
            Log.i(getPluginName(), "doPatch, patch file:".concat(String.valueOf(locala)));
            break;
          }
        }
      }
      Log.e(getPluginName(), "doPatch, unknown op".concat(String.valueOf(locala)));
      return false;
    }
    com.tencent.xweb.util.c.deleteFile(dA(paramc.version, "filelist.config"));
    if (!com.tencent.xweb.util.c.copyFile(dB(paramc.version, "filelist.config"), dA(paramc.version, "filelist.config")))
    {
      Log.e(getPluginName(), "doPatch, copy filelist.config error");
      return false;
    }
    if (!cb(paramc.version, false))
    {
      Log.e(getPluginName(), "doPatch, check md5 failed");
      return false;
    }
    paramc = atg(paramc.version);
    if (!paramc.isEmpty()) {
      com.tencent.xweb.util.c.bsB(paramc);
    }
    return true;
  }
  
  public abstract String ca(int paramInt, boolean paramBoolean);
  
  /* Error */
  public final boolean cb(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   4: ldc_w 367
    //   7: iload_1
    //   8: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   11: invokevirtual 329	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: iload_1
    //   18: ifge +15 -> 33
    //   21: aload_0
    //   22: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   25: ldc_w 371
    //   28: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: new 50	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: iload_1
    //   39: ldc_w 356
    //   42: invokevirtual 250	com/tencent/xweb/xwalk/a/g:dA	(ILjava/lang/String;)Ljava/lang/String;
    //   45: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 65	java/io/File:exists	()Z
    //   53: ifne +31 -> 84
    //   56: iload_2
    //   57: ifeq +15 -> 72
    //   60: aload_0
    //   61: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   64: ldc_w 373
    //   67: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iconst_1
    //   71: ireturn
    //   72: aload_0
    //   73: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   76: ldc_w 375
    //   79: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: iconst_0
    //   83: ireturn
    //   84: new 377	java/io/BufferedReader
    //   87: dup
    //   88: new 379	java/io/FileReader
    //   91: dup
    //   92: aload_3
    //   93: invokespecial 382	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   96: invokespecial 385	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   99: astore 4
    //   101: aload 4
    //   103: astore_3
    //   104: aload 4
    //   106: invokevirtual 388	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +135 -> 248
    //   116: aload 4
    //   118: astore_3
    //   119: aload 5
    //   121: invokevirtual 27	java/lang/String:isEmpty	()Z
    //   124: ifne -23 -> 101
    //   127: aload 4
    //   129: astore_3
    //   130: aload 5
    //   132: ldc_w 390
    //   135: invokevirtual 394	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   138: astore 6
    //   140: aload 4
    //   142: astore_3
    //   143: aload 6
    //   145: arraylength
    //   146: iconst_2
    //   147: if_icmpne -46 -> 101
    //   150: aload 6
    //   152: iconst_0
    //   153: aaload
    //   154: ifnull -53 -> 101
    //   157: aload 4
    //   159: astore_3
    //   160: aload 6
    //   162: iconst_0
    //   163: aaload
    //   164: invokevirtual 27	java/lang/String:isEmpty	()Z
    //   167: ifne -66 -> 101
    //   170: aload 6
    //   172: iconst_1
    //   173: aaload
    //   174: ifnull -73 -> 101
    //   177: aload 4
    //   179: astore_3
    //   180: aload 6
    //   182: iconst_1
    //   183: aaload
    //   184: invokevirtual 27	java/lang/String:isEmpty	()Z
    //   187: ifne -86 -> 101
    //   190: aload 6
    //   192: iconst_0
    //   193: aaload
    //   194: astore 5
    //   196: aload 6
    //   198: iconst_1
    //   199: aaload
    //   200: astore 6
    //   202: aload 4
    //   204: astore_3
    //   205: aload_0
    //   206: iload_1
    //   207: aload 5
    //   209: invokevirtual 250	com/tencent/xweb/xwalk/a/g:dA	(ILjava/lang/String;)Ljava/lang/String;
    //   212: aload 6
    //   214: invokestatic 181	com/tencent/xweb/util/d:oi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   217: ifne -116 -> 101
    //   220: aload 4
    //   222: astore_3
    //   223: aload_0
    //   224: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   227: ldc_w 396
    //   230: aload 5
    //   232: invokestatic 325	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   235: invokevirtual 329	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 4
    //   243: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   246: iconst_0
    //   247: ireturn
    //   248: aload 4
    //   250: astore_3
    //   251: aload_0
    //   252: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   255: ldc_w 398
    //   258: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload 4
    //   263: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   266: iconst_1
    //   267: ireturn
    //   268: astore 5
    //   270: aconst_null
    //   271: astore 4
    //   273: aload 4
    //   275: astore_3
    //   276: aload_0
    //   277: invokevirtual 31	com/tencent/xweb/xwalk/a/g:getPluginName	()Ljava/lang/String;
    //   280: new 43	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 400
    //   287: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 5
    //   292: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 4
    //   306: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   309: iconst_0
    //   310: ireturn
    //   311: astore 4
    //   313: aconst_null
    //   314: astore_3
    //   315: aload_3
    //   316: invokestatic 189	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   319: aload 4
    //   321: athrow
    //   322: astore 4
    //   324: goto -9 -> 315
    //   327: astore 5
    //   329: goto -56 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	g
    //   0	332	1	paramInt	int
    //   0	332	2	paramBoolean	boolean
    //   48	268	3	localObject1	Object
    //   99	206	4	localBufferedReader	java.io.BufferedReader
    //   311	9	4	localObject2	Object
    //   322	1	4	localObject3	Object
    //   109	122	5	str	String
    //   268	23	5	localException1	Exception
    //   327	1	5	localException2	Exception
    //   138	75	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   84	101	268	java/lang/Exception
    //   84	101	311	finally
    //   104	111	322	finally
    //   119	127	322	finally
    //   130	140	322	finally
    //   143	150	322	finally
    //   160	170	322	finally
    //   180	190	322	finally
    //   205	220	322	finally
    //   223	241	322	finally
    //   251	261	322	finally
    //   276	304	322	finally
    //   104	111	327	java/lang/Exception
    //   119	127	327	java/lang/Exception
    //   130	140	327	java/lang/Exception
    //   143	150	327	java/lang/Exception
    //   160	170	327	java/lang/Exception
    //   180	190	327	java/lang/Exception
    //   205	220	327	java/lang/Exception
    //   223	241	327	java/lang/Exception
    //   251	261	327	java/lang/Exception
  }
  
  public final String dA(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e(getPluginName(), "getExtractFile, fileName is empty");
      return "";
    }
    String str = atf(paramInt);
    if (str.isEmpty())
    {
      Log.e(getPluginName(), "getExtractFile, extractDir is empty");
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public abstract String getPluginName();
  
  public abstract boolean hvi();
  
  public abstract void hvj();
  
  public final int hvk()
  {
    hvl();
    return this.SHU;
  }
  
  public final boolean hvm()
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(getPluginName(), "clearPatchDownloadInfo, context is null");
      return false;
    }
    Object localObject1 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
    if (localObject1 == null)
    {
      Log.e(getPluginName(), "clearPatchDownloadInfo, sp is null");
      return false;
    }
    Object localObject2 = ((SharedPreferences)localObject1).getAll();
    if ((localObject2 == null) || (((Map)localObject2).size() == 0)) {
      return true;
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    localObject2 = ((Map)localObject2).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((str != null) && (str.startsWith("patchDownloadCount_")))
      {
        Log.i(getPluginName(), "clearPatchDownloadInfo, remove key ".concat(String.valueOf(str)));
        ((SharedPreferences.Editor)localObject1).remove(str);
      }
    }
    return ((SharedPreferences.Editor)localObject1).commit();
  }
  
  public final void mQ(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      Log.e(getPluginName(), "reportUsingVersion, reportVersion invalid");
    }
    for (;;)
    {
      return;
      Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
      if (localObject == null)
      {
        Log.e(getPluginName(), "reportUsingVersion, sp is null");
        return;
      }
      int i = ((SharedPreferences)localObject).getInt("lastReportVersion", -1);
      String str2 = ((SharedPreferences)localObject).getString("lastReportDate", "");
      try
      {
        String str1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if ((i != paramInt1) || (!str2.equals(str1)))
        {
          i = paramInt1 % 50 + 100;
          Log.d(getPluginName(), "reportUsingVersion, id:" + paramInt2 + ", key:" + i);
          h.s(paramInt2, i, 1L);
          localObject = ((SharedPreferences)localObject).edit();
          if (localObject != null)
          {
            ((SharedPreferences.Editor)localObject).putInt("lastReportVersion", paramInt1);
            ((SharedPreferences.Editor)localObject).putString("lastReportDate", str1);
            ((SharedPreferences.Editor)localObject).commit();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e(getPluginName(), "reportUsingVersion, get cur date error: " + localException.getMessage());
        return;
      }
    }
    Log.e(getPluginName(), "reportUsingVersion, editor is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.g
 * JD-Core Version:    0.7.0.1
 */