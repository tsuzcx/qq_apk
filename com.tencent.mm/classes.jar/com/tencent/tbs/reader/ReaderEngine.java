package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.util.Map;

public class ReaderEngine
{
  private static volatile ReaderEngine b = null;
  protected ITbsReaderEntry a;
  private String c;
  private int d;
  
  public static String getComponentName()
  {
    return "file";
  }
  
  public static ReaderEngine getInstance()
  {
    AppMethodBeat.i(53083);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ReaderEngine();
      }
      ReaderEngine localReaderEngine = b;
      AppMethodBeat.o(53083);
      return localReaderEngine;
    }
    finally
    {
      AppMethodBeat.o(53083);
    }
  }
  
  public ITbsReader createTbsReader(Context paramContext, Integer paramInteger, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(53087);
    if (this.a != null) {}
    for (paramContext = (ITbsReader)this.a.createTbsReader(paramContext, paramInteger, paramITbsReaderCallback);; paramContext = null)
    {
      if (paramContext == null) {
        report(1001, "createTbsReader:".concat(String.valueOf(paramInteger)), null);
      }
      AppMethodBeat.o(53087);
      return paramContext;
    }
  }
  
  public boolean fileEnginePreLoad(Context paramContext, TBSOneCallback paramTBSOneCallback)
  {
    AppMethodBeat.i(187965);
    paramContext = TBSOneManager.getDefaultInstance(paramContext);
    paramContext.setPolicy(TBSOneManager.Policy.BUILTIN_FIRST);
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.isComponentInstalled("file");
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        paramContext.installComponent("file", paramTBSOneCallback);
        bool1 = bool2;
      }
    }
    catch (Throwable paramContext)
    {
      label48:
      break label48;
    }
    AppMethodBeat.o(187965);
    return bool1;
  }
  
  public int getVersionCode()
  {
    return this.d;
  }
  
  public String getVersionName()
  {
    return this.c;
  }
  
  /* Error */
  public boolean initReaderEntry(Context paramContext)
  {
    // Byte code:
    //   0: ldc 104
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 42	com/tencent/tbs/reader/ReaderEngine:a	Lcom/tencent/tbs/reader/ITbsReaderEntry;
    //   9: ifnull +10 -> 19
    //   12: ldc 104
    //   14: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_1
    //   18: ireturn
    //   19: aload_1
    //   20: invokestatic 76	com/tencent/tbs/one/TBSOneManager:getDefaultInstance	(Landroid/content/Context;)Lcom/tencent/tbs/one/TBSOneManager;
    //   23: astore 5
    //   25: aload 5
    //   27: getstatic 82	com/tencent/tbs/one/TBSOneManager$Policy:BUILTIN_FIRST	Lcom/tencent/tbs/one/TBSOneManager$Policy;
    //   30: invokevirtual 86	com/tencent/tbs/one/TBSOneManager:setPolicy	(Lcom/tencent/tbs/one/TBSOneManager$Policy;)V
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 5
    //   38: ldc 24
    //   40: invokevirtual 108	com/tencent/tbs/one/TBSOneManager:loadComponentSync	(Ljava/lang/String;)Lcom/tencent/tbs/one/TBSOneComponent;
    //   43: astore_1
    //   44: aload_0
    //   45: aload_1
    //   46: invokeinterface 112 1 0
    //   51: putfield 101	com/tencent/tbs/reader/ReaderEngine:c	Ljava/lang/String;
    //   54: aload_0
    //   55: aload_1
    //   56: invokeinterface 114 1 0
    //   61: putfield 98	com/tencent/tbs/reader/ReaderEngine:d	I
    //   64: aload_1
    //   65: invokeinterface 118 1 0
    //   70: checkcast 44	com/tencent/tbs/reader/ITbsReaderEntry
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 121 1 0
    //   80: aload_1
    //   81: ifnonnull +49 -> 130
    //   84: aload 5
    //   86: iconst_1
    //   87: invokevirtual 125	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   90: iconst_0
    //   91: istore_2
    //   92: aload_1
    //   93: instanceof 44
    //   96: ifeq +10 -> 106
    //   99: aload_0
    //   100: aload_1
    //   101: putfield 42	com/tencent/tbs/reader/ReaderEngine:a	Lcom/tencent/tbs/reader/ITbsReaderEntry;
    //   104: iconst_1
    //   105: istore_2
    //   106: ldc 104
    //   108: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iload_2
    //   112: ireturn
    //   113: astore_3
    //   114: aload 4
    //   116: astore_1
    //   117: aload_0
    //   118: sipush 1000
    //   121: ldc 126
    //   123: aload_3
    //   124: invokevirtual 65	com/tencent/tbs/reader/ReaderEngine:report	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -47 -> 80
    //   130: aload 5
    //   132: aload_1
    //   133: invokeinterface 130 1 0
    //   138: invokevirtual 125	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   141: goto -51 -> 90
    //   144: astore_3
    //   145: aload 5
    //   147: iconst_1
    //   148: invokevirtual 125	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   151: goto -61 -> 90
    //   154: astore_3
    //   155: goto -65 -> 90
    //   158: astore_3
    //   159: goto -42 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	ReaderEngine
    //   0	162	1	paramContext	Context
    //   91	21	2	bool	boolean
    //   113	11	3	localThrowable1	Throwable
    //   144	1	3	localThrowable2	Throwable
    //   154	1	3	localThrowable3	Throwable
    //   158	1	3	localThrowable4	Throwable
    //   34	81	4	localObject	Object
    //   23	123	5	localTBSOneManager	TBSOneManager
    // Exception table:
    //   from	to	target	type
    //   36	74	113	java/lang/Throwable
    //   84	90	144	java/lang/Throwable
    //   130	141	144	java/lang/Throwable
    //   145	151	154	java/lang/Throwable
    //   74	80	158	java/lang/Throwable
  }
  
  public boolean isSupportCurrentPlatform()
  {
    AppMethodBeat.i(53085);
    boolean bool = false;
    if (this.a != null) {
      bool = this.a.isSupportCurrentPlatform();
    }
    AppMethodBeat.o(53085);
    return bool;
  }
  
  public boolean isSupportExt(int paramInt, String paramString)
  {
    AppMethodBeat.i(53086);
    boolean bool = false;
    if (this.a != null) {
      bool = this.a.isSupportExt(paramInt, paramString);
    }
    if (!bool) {
      report(1002, paramString, null);
    }
    AppMethodBeat.o(53086);
    return bool;
  }
  
  public void report(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(187964);
    try
    {
      StatisticReport localStatisticReport = StatisticReport.create("tbs_sdk_file_stat", paramInt);
      localStatisticReport.setDescription(paramString, paramThrowable);
      localStatisticReport.report();
      AppMethodBeat.o(187964);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(187964);
    }
  }
  
  public void setConfigSetting(Map paramMap)
  {
    AppMethodBeat.i(187966);
    if (this.a != null) {
      this.a.initSettings(paramMap);
    }
    AppMethodBeat.o(187966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderEngine
 * JD-Core Version:    0.7.0.1
 */