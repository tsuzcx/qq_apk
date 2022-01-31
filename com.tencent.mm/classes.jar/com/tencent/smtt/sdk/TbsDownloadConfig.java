package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TbsDownloadConfig
{
  public static final int CMD_ID_DOWNLOAD_FILE = 101;
  public static final int CMD_ID_FILE_UPLOAD = 100;
  public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400L;
  public static final int ERROR_DOWNLOAD = 2;
  public static final int ERROR_INSTALL = 5;
  public static final int ERROR_LOAD = 6;
  public static final int ERROR_NONE = 1;
  public static final int ERROR_REPORTED = 0;
  public static final int ERROR_UNZIP = 4;
  public static final int ERROR_VERIFY = 3;
  private static TbsDownloadConfig b;
  Map<String, Object> a = new HashMap();
  private Context c;
  public SharedPreferences mPreferences;
  
  private TbsDownloadConfig(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
    this.c = paramContext.getApplicationContext();
    if (this.c == null) {
      this.c = paramContext;
    }
  }
  
  public static TbsDownloadConfig getInstance()
  {
    try
    {
      TbsDownloadConfig localTbsDownloadConfig = b;
      return localTbsDownloadConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadConfig getInstance(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new TbsDownloadConfig(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.a.clear();
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void commit()
  {
    for (;;)
    {
      String str;
      Object localObject2;
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        Iterator localIterator = this.a.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label199;
        }
        str = (String)localIterator.next();
        localObject2 = this.a.get(str);
        if ((localObject2 instanceof String))
        {
          localEditor.putString(str, (String)localObject2);
          continue;
        }
      }
      catch (Exception localException)
      {
        return;
        if ((localObject2 instanceof Boolean))
        {
          localException.putBoolean(str, ((Boolean)localObject2).booleanValue());
          continue;
        }
      }
      finally {}
      if ((localObject2 instanceof Long))
      {
        localObject1.putLong(str, ((Long)localObject2).longValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        localObject1.putInt(str, ((Integer)localObject2).intValue());
      }
      else if ((localObject2 instanceof Float))
      {
        localObject1.putFloat(str, ((Float)localObject2).floatValue());
        continue;
        label199:
        localObject1.commit();
        this.a.clear();
      }
    }
  }
  
  public int getDownloadFailedMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_failed_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 100;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getDownloadInterruptCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: ldc 174
    //   8: invokeinterface 178 2 0
    //   13: istore_3
    //   14: iload_3
    //   15: ifne +124 -> 139
    //   18: new 180	java/io/File
    //   21: dup
    //   22: new 180	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:c	Landroid/content/Context;
    //   30: invokevirtual 184	android/content/Context:getFilesDir	()Ljava/io/File;
    //   33: ldc 186
    //   35: invokespecial 189	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: ldc 51
    //   40: invokespecial 189	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: invokevirtual 192	java/io/File:exists	()Z
    //   46: istore_3
    //   47: iload_3
    //   48: ifne +55 -> 103
    //   51: bipush 159
    //   53: istore_1
    //   54: aload_0
    //   55: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:c	Landroid/content/Context;
    //   58: ifnull +156 -> 214
    //   61: ldc 194
    //   63: aload_0
    //   64: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:c	Landroid/content/Context;
    //   67: invokevirtual 198	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   70: getfield 204	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   73: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifeq +138 -> 214
    //   79: ldc 210
    //   81: invokestatic 216	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   84: invokevirtual 220	java/util/Locale:getCountry	()Ljava/lang/String;
    //   87: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: istore_3
    //   91: iload_3
    //   92: ifne +122 -> 214
    //   95: sipush -320
    //   98: istore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: iload_1
    //   102: ireturn
    //   103: aload_0
    //   104: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   107: ldc 222
    //   109: invokeinterface 178 2 0
    //   114: istore_3
    //   115: iload_3
    //   116: ifne +9 -> 125
    //   119: bipush 160
    //   121: istore_1
    //   122: goto -68 -> 54
    //   125: bipush 155
    //   127: istore_1
    //   128: goto -74 -> 54
    //   131: astore 4
    //   133: bipush 161
    //   135: istore_1
    //   136: goto -82 -> 54
    //   139: aload_0
    //   140: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   143: ldc 174
    //   145: bipush 157
    //   147: invokeinterface 169 3 0
    //   152: istore_1
    //   153: iload_1
    //   154: bipush 137
    //   156: if_icmpeq +11 -> 167
    //   159: iload_1
    //   160: istore_2
    //   161: iload_1
    //   162: bipush 135
    //   164: if_icmpne +17 -> 181
    //   167: aload_0
    //   168: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   171: ldc 224
    //   173: bipush 137
    //   175: invokeinterface 169 3 0
    //   180: istore_2
    //   181: iload_2
    //   182: istore_1
    //   183: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   186: aload_0
    //   187: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   190: ldc 231
    //   192: lconst_0
    //   193: invokeinterface 235 4 0
    //   198: lsub
    //   199: ldc2_w 236
    //   202: lcmp
    //   203: ifle -149 -> 54
    //   206: iload_2
    //   207: ldc 238
    //   209: isub
    //   210: istore_1
    //   211: goto -157 -> 54
    //   214: aload_0
    //   215: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   218: ldc 240
    //   220: iconst_m1
    //   221: invokeinterface 169 3 0
    //   226: istore_2
    //   227: iload_1
    //   228: sipush 1000
    //   231: imul
    //   232: iload_2
    //   233: iadd
    //   234: istore_1
    //   235: goto -136 -> 99
    //   238: astore 4
    //   240: aload_0
    //   241: monitorexit
    //   242: aload 4
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	TbsDownloadConfig
    //   53	182	1	i	int
    //   160	74	2	j	int
    //   13	103	3	bool	boolean
    //   131	1	4	localThrowable	java.lang.Throwable
    //   238	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	47	131	java/lang/Throwable
    //   103	115	131	java/lang/Throwable
    //   2	14	238	finally
    //   18	47	238	finally
    //   54	91	238	finally
    //   103	115	238	finally
    //   139	153	238	finally
    //   167	181	238	finally
    //   183	206	238	finally
    //   214	227	238	finally
  }
  
  public long getDownloadMaxflow()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_maxflow", 0);
      int j = i;
      if (i == 0) {
        j = 20;
      }
      long l = j * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public long getDownloadMinFreeSpace()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc 248
    //   10: iconst_0
    //   11: invokeinterface 169 3 0
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +18 -> 36
    //   21: iload_1
    //   22: sipush 1024
    //   25: imul
    //   26: i2l
    //   27: lstore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: lload_3
    //   31: ldc2_w 244
    //   34: lmul
    //   35: lreturn
    //   36: iload_2
    //   37: istore_1
    //   38: goto -17 -> 21
    //   41: astore 5
    //   43: aload_0
    //   44: monitorexit
    //   45: aload 5
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TbsDownloadConfig
    //   1	37	1	i	int
    //   16	21	2	j	int
    //   27	4	3	l	long
    //   41	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	41	finally
  }
  
  public long getDownloadSingleTimeout()
  {
    try
    {
      long l1 = this.mPreferences.getLong("tbs_single_timeout", 0L);
      long l2 = l1;
      if (l1 == 0L) {
        l2 = 1200000L;
      }
      return l2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getDownloadSuccessMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_success_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 3;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public long getRetryInterval()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 262	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   5: lconst_0
    //   6: lcmp
    //   7: iflt +11 -> 18
    //   10: invokestatic 262	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   13: lstore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: lload_1
    //   17: lreturn
    //   18: aload_0
    //   19: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   22: ldc_w 264
    //   25: ldc2_w 15
    //   28: invokeinterface 235 4 0
    //   33: lstore_1
    //   34: goto -20 -> 14
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TbsDownloadConfig
    //   13	21	1	l	long
    //   37	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	37	finally
    //   18	34	37	finally
  }
  
  /* Error */
  public boolean getTbsCoreLoadRenameFileLockEnable()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc_w 267
    //   11: iconst_1
    //   12: invokeinterface 271 3 0
    //   17: istore_2
    //   18: iload_2
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: astore_3
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_3
    //   28: athrow
    //   29: astore_3
    //   30: goto -10 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadConfig
    //   1	22	1	bool1	boolean
    //   17	2	2	bool2	boolean
    //   24	4	3	localObject	Object
    //   29	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	18	24	finally
    //   4	18	29	java/lang/Exception
  }
  
  /* Error */
  public boolean getTbsCoreLoadRenameFileLockWaitEnable()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc_w 274
    //   11: iconst_1
    //   12: invokeinterface 271 3 0
    //   17: istore_2
    //   18: iload_2
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: astore_3
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_3
    //   28: athrow
    //   29: astore_3
    //   30: goto -10 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadConfig
    //   1	22	1	bool1	boolean
    //   17	2	2	bool2	boolean
    //   24	4	3	localObject	Object
    //   29	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	18	24	finally
    //   4	18	29	java/lang/Exception
  }
  
  public boolean isOverSea()
  {
    try
    {
      boolean bool = this.mPreferences.getBoolean("is_oversea", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setDownloadInterruptCode(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 86 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc 174
    //   15: iload_1
    //   16: invokeinterface 152 3 0
    //   21: pop
    //   22: aload_2
    //   23: ldc 231
    //   25: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   28: invokeinterface 142 4 0
    //   33: pop
    //   34: aload_2
    //   35: invokeinterface 94 1 0
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    //   49: astore_2
    //   50: goto -9 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	TbsDownloadConfig
    //   0	53	1	paramInt	int
    //   11	24	2	localEditor	SharedPreferences.Editor
    //   44	4	2	localObject	Object
    //   49	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
    //   2	41	49	java/lang/Exception
  }
  
  public void setInstallInterruptCode(int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.putInt("tbs_install_interrupt_code", paramInt);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setTbsCoreLoadRenameFileLockEnable(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 86 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 267
    //   16: iload_1
    //   17: invokeinterface 132 3 0
    //   22: pop
    //   23: aload_2
    //   24: invokeinterface 94 1 0
    //   29: pop
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_2
    //   39: goto -9 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TbsDownloadConfig
    //   0	42	1	paramBoolean	boolean
    //   11	13	2	localEditor	SharedPreferences.Editor
    //   33	4	2	localObject	Object
    //   38	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
    //   2	30	38	java/lang/Exception
  }
  
  /* Error */
  public void setTbsCoreLoadRenameFileLockWaitEnable(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 86 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 274
    //   16: iload_1
    //   17: invokeinterface 132 3 0
    //   22: pop
    //   23: aload_2
    //   24: invokeinterface 94 1 0
    //   29: pop
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_2
    //   39: goto -9 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TbsDownloadConfig
    //   0	42	1	paramBoolean	boolean
    //   11	13	2	localEditor	SharedPreferences.Editor
    //   33	4	2	localObject	Object
    //   38	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
    //   2	30	38	java/lang/Exception
  }
  
  /* Error */
  public void uploadDownloadInterruptCodeIfNeeded(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +139 -> 142
    //   6: ldc_w 286
    //   9: aload_1
    //   10: invokevirtual 63	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   13: invokevirtual 198	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   16: getfield 204	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   19: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +120 -> 142
    //   25: iconst_1
    //   26: istore 5
    //   28: aload_0
    //   29: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   32: ldc 174
    //   34: invokeinterface 178 2 0
    //   39: istore 6
    //   41: iload 6
    //   43: ifne +149 -> 192
    //   46: new 180	java/io/File
    //   49: dup
    //   50: new 180	java/io/File
    //   53: dup
    //   54: aload_0
    //   55: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:c	Landroid/content/Context;
    //   58: invokevirtual 184	android/content/Context:getFilesDir	()Ljava/io/File;
    //   61: ldc 186
    //   63: invokespecial 189	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: ldc 51
    //   68: invokespecial 189	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: invokevirtual 192	java/io/File:exists	()Z
    //   74: istore 6
    //   76: iload 6
    //   78: ifne +67 -> 145
    //   81: bipush 159
    //   83: istore_2
    //   84: iload 5
    //   86: istore_3
    //   87: iload_3
    //   88: ifeq +54 -> 142
    //   91: aload_1
    //   92: invokestatic 291	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   95: invokevirtual 295	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   98: astore 7
    //   100: aload 7
    //   102: sipush 128
    //   105: invokevirtual 300	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   108: aload 7
    //   110: new 302	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 304
    //   117: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: iload_2
    //   121: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokevirtual 317	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokestatic 291	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   134: getstatic 323	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   137: aload 7
    //   139: invokevirtual 327	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: aload_0
    //   146: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   149: ldc 222
    //   151: invokeinterface 178 2 0
    //   156: istore 6
    //   158: iload 6
    //   160: ifne +12 -> 172
    //   163: bipush 160
    //   165: istore_2
    //   166: iload 5
    //   168: istore_3
    //   169: goto -82 -> 87
    //   172: bipush 155
    //   174: istore_2
    //   175: iload 5
    //   177: istore_3
    //   178: goto -91 -> 87
    //   181: astore 7
    //   183: bipush 161
    //   185: istore_2
    //   186: iload 5
    //   188: istore_3
    //   189: goto -102 -> 87
    //   192: aload_0
    //   193: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   196: ldc 174
    //   198: bipush 157
    //   200: invokeinterface 169 3 0
    //   205: istore 4
    //   207: iload 4
    //   209: sipush -206
    //   212: if_icmpgt +17 -> 229
    //   215: iload 5
    //   217: istore_3
    //   218: iload 4
    //   220: istore_2
    //   221: iload 4
    //   223: sipush -219
    //   226: if_icmpge -139 -> 87
    //   229: iload 4
    //   231: sipush -302
    //   234: if_icmpgt +17 -> 251
    //   237: iload 5
    //   239: istore_3
    //   240: iload 4
    //   242: istore_2
    //   243: iload 4
    //   245: sipush -316
    //   248: if_icmpge -161 -> 87
    //   251: iload 4
    //   253: sipush -318
    //   256: if_icmpgt +17 -> 273
    //   259: iload 5
    //   261: istore_3
    //   262: iload 4
    //   264: istore_2
    //   265: iload 4
    //   267: sipush -322
    //   270: if_icmpge -183 -> 87
    //   273: iconst_0
    //   274: istore_3
    //   275: iload 4
    //   277: istore_2
    //   278: goto -191 -> 87
    //   281: astore_1
    //   282: aload_0
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: goto -145 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	TbsDownloadConfig
    //   0	290	1	paramContext	Context
    //   83	195	2	i	int
    //   86	189	3	j	int
    //   205	71	4	k	int
    //   26	234	5	m	int
    //   39	120	6	bool	boolean
    //   98	40	7	localTbsLogInfo	TbsLogReport.TbsLogInfo
    //   181	1	7	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   46	76	181	java/lang/Throwable
    //   145	158	181	java/lang/Throwable
    //   6	25	281	finally
    //   28	41	281	finally
    //   46	76	281	finally
    //   91	142	281	finally
    //   145	158	281	finally
    //   192	207	281	finally
    //   6	25	286	java/lang/Throwable
    //   28	41	286	java/lang/Throwable
    //   91	142	286	java/lang/Throwable
    //   192	207	286	java/lang/Throwable
  }
  
  public static abstract interface TbsConfigKey
  {
    public static final String KEY_APP_METADATA = "app_metadata";
    public static final String KEY_APP_VERSIONCODE = "app_versioncode";
    public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
    public static final String KEY_APP_VERSIONNAME = "app_versionname";
    public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
    public static final String KEY_COUNT_REQUEST_FAIL_IN_24HOURS = "count_request_fail_in_24hours";
    public static final String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
    public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
    public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
    public static final String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
    public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
    public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
    public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
    public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
    public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
    public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
    public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
    public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
    public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
    public static final String KEY_FULL_PACKAGE = "request_full_package";
    public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
    public static final String KEY_IS_OVERSEA = "is_oversea";
    public static final String KEY_LAST_CHECK = "last_check";
    public static final String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
    public static final String KEY_LAST_REQUEST_SUCCESS = "last_request_success";
    public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
    public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
    public static final String KEY_REQUEST_FAIL = "request_fail";
    public static final String KEY_RESPONSECODE = "tbs_responsecode";
    public static final String KEY_RETRY_INTERVAL = "retry_interval";
    public static final String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
    public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
    public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
    public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
    public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
    public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
    public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
    public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE = "tbs_core_load_rename_file_lock_enable";
    public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE = "tbs_core_load_rename_file_lock_wait_enable";
    public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
    public static final String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
    public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
    public static final String KEY_USE_BUGLY = "tbs_use_bugly";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadConfig
 * JD-Core Version:    0.7.0.1
 */