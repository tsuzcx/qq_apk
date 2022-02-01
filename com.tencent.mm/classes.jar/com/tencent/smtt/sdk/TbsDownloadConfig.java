package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
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
  private static TbsDownloadConfig a;
  private Context b;
  public SharedPreferences mPreferences;
  public Map<String, Object> mSyncMap;
  
  private TbsDownloadConfig(Context paramContext)
  {
    AppMethodBeat.i(54073);
    this.mSyncMap = new HashMap();
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
    AppMethodBeat.o(54073);
  }
  
  public static TbsDownloadConfig getInstance()
  {
    try
    {
      TbsDownloadConfig localTbsDownloadConfig = a;
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
      AppMethodBeat.i(54074);
      if (a == null) {
        a = new TbsDownloadConfig(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(54074);
      return paramContext;
    }
    finally {}
  }
  
  public void clear()
  {
    AppMethodBeat.i(54090);
    try
    {
      this.mSyncMap.clear();
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.clear();
      localEditor.commit();
      AppMethodBeat.o(54090);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54090);
    }
  }
  
  public void commit()
  {
    for (;;)
    {
      String str;
      Object localObject2;
      try
      {
        AppMethodBeat.i(54089);
        try
        {
          SharedPreferences.Editor localEditor = this.mPreferences.edit();
          Iterator localIterator = this.mSyncMap.keySet().iterator();
          if (!localIterator.hasNext()) {
            break label209;
          }
          str = (String)localIterator.next();
          localObject2 = this.mSyncMap.get(str);
          if (!(localObject2 instanceof String)) {
            continue;
          }
          localEditor.putString(str, (String)localObject2);
          continue;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(54089);
        }
        return;
      }
      finally {}
      if ((localObject2 instanceof Boolean))
      {
        localException.putBoolean(str, ((Boolean)localObject2).booleanValue());
      }
      else if ((localObject2 instanceof Long))
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
        label209:
        localObject1.commit();
        this.mSyncMap.clear();
        AppMethodBeat.o(54089);
      }
    }
  }
  
  /* Error */
  public int getDownloadFailedMaxRetrytimes()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 176
    //   4: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   11: ldc 178
    //   13: iconst_0
    //   14: invokeinterface 182 3 0
    //   19: istore_1
    //   20: iload_1
    //   21: ifne +15 -> 36
    //   24: bipush 100
    //   26: istore_1
    //   27: ldc 176
    //   29: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_1
    //   35: ireturn
    //   36: ldc 176
    //   38: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -9 -> 32
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	TbsDownloadConfig
    //   19	16	1	i	int
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	44	finally
    //   27	32	44	finally
    //   36	41	44	finally
  }
  
  /* Error */
  public int getDownloadInterruptCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 184
    //   4: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   11: ldc 186
    //   13: invokeinterface 190 2 0
    //   18: istore_3
    //   19: iload_3
    //   20: ifne +127 -> 147
    //   23: new 192	java/io/File
    //   26: dup
    //   27: new 192	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: getfield 71	com/tencent/smtt/sdk/TbsDownloadConfig:b	Landroid/content/Context;
    //   35: invokevirtual 196	android/content/Context:getFilesDir	()Ljava/io/File;
    //   38: ldc 198
    //   40: invokespecial 201	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: ldc 57
    //   45: invokespecial 201	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: invokevirtual 204	java/io/File:exists	()Z
    //   51: istore_3
    //   52: iload_3
    //   53: ifne +58 -> 111
    //   56: bipush 159
    //   58: istore_1
    //   59: aload_0
    //   60: getfield 71	com/tencent/smtt/sdk/TbsDownloadConfig:b	Landroid/content/Context;
    //   63: ifnull +159 -> 222
    //   66: ldc 206
    //   68: aload_0
    //   69: getfield 71	com/tencent/smtt/sdk/TbsDownloadConfig:b	Landroid/content/Context;
    //   72: invokevirtual 210	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   75: getfield 216	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   78: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +141 -> 222
    //   84: ldc 222
    //   86: invokestatic 228	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   89: invokevirtual 232	java/util/Locale:getCountry	()Ljava/lang/String;
    //   92: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifne +127 -> 222
    //   98: sipush -320
    //   101: istore_1
    //   102: ldc 184
    //   104: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: monitorexit
    //   109: iload_1
    //   110: ireturn
    //   111: aload_0
    //   112: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   115: ldc 234
    //   117: invokeinterface 190 2 0
    //   122: istore_3
    //   123: iload_3
    //   124: ifne +9 -> 133
    //   127: bipush 160
    //   129: istore_1
    //   130: goto -71 -> 59
    //   133: bipush 155
    //   135: istore_1
    //   136: goto -77 -> 59
    //   139: astore 4
    //   141: bipush 161
    //   143: istore_1
    //   144: goto -85 -> 59
    //   147: aload_0
    //   148: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   151: ldc 186
    //   153: bipush 157
    //   155: invokeinterface 182 3 0
    //   160: istore_1
    //   161: iload_1
    //   162: bipush 137
    //   164: if_icmpeq +11 -> 175
    //   167: iload_1
    //   168: istore_2
    //   169: iload_1
    //   170: bipush 135
    //   172: if_icmpne +17 -> 189
    //   175: aload_0
    //   176: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   179: ldc 236
    //   181: bipush 137
    //   183: invokeinterface 182 3 0
    //   188: istore_2
    //   189: iload_2
    //   190: istore_1
    //   191: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   194: aload_0
    //   195: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   198: ldc 243
    //   200: lconst_0
    //   201: invokeinterface 247 4 0
    //   206: lsub
    //   207: ldc2_w 248
    //   210: lcmp
    //   211: ifle -152 -> 59
    //   214: iload_2
    //   215: ldc 250
    //   217: isub
    //   218: istore_1
    //   219: goto -160 -> 59
    //   222: iload_1
    //   223: sipush 1000
    //   226: imul
    //   227: aload_0
    //   228: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   231: ldc 252
    //   233: iconst_m1
    //   234: invokeinterface 182 3 0
    //   239: iadd
    //   240: istore_1
    //   241: ldc 184
    //   243: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: goto -139 -> 107
    //   249: astore 4
    //   251: aload_0
    //   252: monitorexit
    //   253: aload 4
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	TbsDownloadConfig
    //   58	183	1	i	int
    //   168	50	2	j	int
    //   18	106	3	bool	boolean
    //   139	1	4	localObject1	Object
    //   249	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	52	139	finally
    //   111	123	139	finally
    //   2	19	249	finally
    //   59	98	249	finally
    //   102	107	249	finally
    //   147	161	249	finally
    //   175	189	249	finally
    //   191	214	249	finally
    //   222	246	249	finally
  }
  
  public long getDownloadMaxflow()
  {
    try
    {
      AppMethodBeat.i(54075);
      int j = this.mPreferences.getInt("tbs_download_maxflow", 0);
      int i = j;
      if (j == 0) {
        i = 20;
      }
      long l = i * 1024;
      AppMethodBeat.o(54075);
      return l * 1024L;
    }
    finally {}
  }
  
  /* Error */
  public long getDownloadMinFreeSpace()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 260
    //   7: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   14: ldc_w 262
    //   17: iconst_0
    //   18: invokeinterface 182 3 0
    //   23: istore_2
    //   24: iload_2
    //   25: ifne +24 -> 49
    //   28: iload_1
    //   29: sipush 1024
    //   32: imul
    //   33: i2l
    //   34: lstore_3
    //   35: ldc_w 260
    //   38: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: lload_3
    //   44: ldc2_w 257
    //   47: lmul
    //   48: lreturn
    //   49: iload_2
    //   50: istore_1
    //   51: goto -23 -> 28
    //   54: astore 5
    //   56: aload_0
    //   57: monitorexit
    //   58: aload 5
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	TbsDownloadConfig
    //   1	50	1	i	int
    //   23	27	2	j	int
    //   34	10	3	l	long
    //   54	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	24	54	finally
    //   35	41	54	finally
  }
  
  /* Error */
  public long getDownloadSingleTimeout()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 264
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   12: ldc_w 266
    //   15: lconst_0
    //   16: invokeinterface 247 4 0
    //   21: lstore_1
    //   22: lload_1
    //   23: lconst_0
    //   24: lcmp
    //   25: ifne +17 -> 42
    //   28: ldc2_w 267
    //   31: lstore_1
    //   32: ldc_w 264
    //   35: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: lload_1
    //   41: lreturn
    //   42: ldc_w 264
    //   45: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -10 -> 38
    //   51: astore_3
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	TbsDownloadConfig
    //   21	20	1	l	long
    //   51	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	51	finally
    //   32	38	51	finally
    //   42	48	51	finally
  }
  
  /* Error */
  public int getDownloadSuccessMaxRetrytimes()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 270
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   12: ldc_w 272
    //   15: iconst_0
    //   16: invokeinterface 182 3 0
    //   21: istore_1
    //   22: iload_1
    //   23: ifne +15 -> 38
    //   26: iconst_3
    //   27: istore_1
    //   28: ldc_w 270
    //   31: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: ldc_w 270
    //   41: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -10 -> 34
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TbsDownloadConfig
    //   21	16	1	i	int
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	47	finally
    //   28	34	47	finally
    //   38	44	47	finally
  }
  
  /* Error */
  public long getRetryInterval()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 274
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 279	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: iflt +17 -> 30
    //   16: invokestatic 279	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   19: lstore_1
    //   20: ldc_w 274
    //   23: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: lload_1
    //   29: lreturn
    //   30: aload_0
    //   31: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   34: ldc_w 281
    //   37: ldc2_w 14
    //   40: invokeinterface 247 4 0
    //   45: lstore_1
    //   46: ldc_w 274
    //   49: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -26 -> 26
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TbsDownloadConfig
    //   19	27	1	l	long
    //   55	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	55	finally
    //   30	52	55	finally
  }
  
  public boolean getTbsCoreLoadRenameFileLockEnable()
  {
    boolean bool1 = true;
    boolean bool2;
    label26:
    try
    {
      AppMethodBeat.i(54083);
    }
    finally {}
    try
    {
      bool2 = this.mPreferences.getBoolean("tbs_core_load_rename_file_lock_enable", true);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      break label26;
    }
    AppMethodBeat.o(54083);
    return bool1;
  }
  
  public boolean getTbsCoreLoadRenameFileLockWaitEnable()
  {
    boolean bool1 = true;
    boolean bool2;
    label26:
    try
    {
      AppMethodBeat.i(54084);
    }
    finally {}
    try
    {
      bool2 = this.mPreferences.getBoolean("tbs_core_load_rename_file_lock_wait_enable", true);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      break label26;
    }
    AppMethodBeat.o(54084);
    return bool1;
  }
  
  public boolean isOverSea()
  {
    try
    {
      AppMethodBeat.i(54088);
      boolean bool = this.mPreferences.getBoolean("is_oversea", false);
      AppMethodBeat.o(54088);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setDownloadInterruptCode(int paramInt)
  {
    try
    {
      AppMethodBeat.i(54080);
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        localEditor.putInt("tbs_download_interrupt_code", paramInt);
        localEditor.putLong("tbs_download_interrupt_time", System.currentTimeMillis());
        localEditor.commit();
        AppMethodBeat.o(54080);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppMethodBeat.o(54080);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setInstallInterruptCode(int paramInt)
  {
    try
    {
      AppMethodBeat.i(54091);
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.putInt("tbs_install_interrupt_code", paramInt);
      localEditor.commit();
      AppMethodBeat.o(54091);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTbsCoreLoadRenameFileLockEnable(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(54081);
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        localEditor.putBoolean("tbs_core_load_rename_file_lock_enable", paramBoolean);
        localEditor.commit();
        AppMethodBeat.o(54081);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppMethodBeat.o(54081);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setTbsCoreLoadRenameFileLockWaitEnable(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(54082);
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        localEditor.putBoolean("tbs_core_load_rename_file_lock_wait_enable", paramBoolean);
        localEditor.commit();
        AppMethodBeat.o(54082);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppMethodBeat.o(54082);
        }
      }
      return;
    }
    finally {}
  }
  
  public void uploadDownloadInterruptCodeIfNeeded(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54085);
        if (paramContext != null) {}
        try
        {
          if ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName))
          {
            m = 1;
            bool = this.mPreferences.contains("tbs_download_interrupt_code");
            if (bool) {
              continue;
            }
          }
        }
        finally
        {
          int m;
          boolean bool;
          int i;
          int j;
          TbsLogReport.TbsLogInfo localTbsLogInfo;
          int k;
          AppMethodBeat.o(54085);
          continue;
        }
        try
        {
          bool = new File(new File(this.b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists();
          if (bool) {
            continue;
          }
          i = -97;
          j = m;
        }
        finally
        {
          i = -95;
          j = m;
          continue;
        }
        if (j != 0)
        {
          localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
          localTbsLogInfo.setErrorCode(128);
          localTbsLogInfo.setFailDetail(" ".concat(String.valueOf(i)));
          TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
        }
        AppMethodBeat.o(54085);
        return;
      }
      finally {}
      bool = this.mPreferences.contains("tbs_needdownload");
      if (!bool)
      {
        i = -96;
        j = m;
      }
      else
      {
        i = -101;
        j = m;
        continue;
        k = this.mPreferences.getInt("tbs_download_interrupt_code", -99);
        if (k <= -206)
        {
          i = k;
          j = m;
          if (k >= -219) {}
        }
        else if (k <= -302)
        {
          i = k;
          j = m;
          if (k >= -316) {}
        }
        else if (k <= -318)
        {
          i = k;
          j = m;
          if (k >= -322) {}
        }
        else
        {
          j = 0;
          i = k;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadConfig
 * JD-Core Version:    0.7.0.1
 */