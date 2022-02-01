package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JNIExceptionHandlerImpl
  extends JNIExceptionHandler
{
  private static final String REPORT_TAG = "RubbishBinProgramException";
  public static final String TAG = "JNIException";
  private byte _hellAccFlag_;
  private Context context;
  private String reportExecutionTag = "";
  
  public JNIExceptionHandlerImpl(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.reportExecutionTag = paramString;
  }
  
  public static void initJNIExceptionHandler(Context paramContext, String paramString)
  {
    AppMethodBeat.i(146668);
    INSTANCE = new JNIExceptionHandlerImpl(paramContext, paramString);
    AppMethodBeat.o(146668);
  }
  
  public void onException(int paramInt, String paramString)
  {
    AppMethodBeat.i(146667);
    Object localObject2 = Thread.getAllStackTraces();
    Object localObject1 = new StringBuilder();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      if (((Thread)((Map.Entry)localObject3).getKey()).getName().equals(this.reportExecutionTag))
      {
        ((StringBuilder)localObject1).append("Java stack trace:\n");
        localObject3 = (StackTraceElement[])((Map.Entry)localObject3).getValue();
        int j = localObject3.length;
        i = 0;
        label105:
        Object localObject4;
        if (i < j)
        {
          localObject4 = localObject3[i];
          if (localObject4.isNativeMethod()) {
            break label185;
          }
          ((StringBuilder)localObject1).append(String.format(Locale.ENGLISH, "at %s.%s(%s:%d)\n", new Object[] { localObject4.getClassName(), localObject4.getMethodName(), localObject4.getFileName(), Integer.valueOf(localObject4.getLineNumber()) }));
        }
        for (;;)
        {
          i += 1;
          break label105;
          break;
          label185:
          ((StringBuilder)localObject1).append(String.format(Locale.ENGLISH, "at %s.%s(%s:%d)(Native Call)\n", new Object[] { localObject4.getClassName(), localObject4.getMethodName(), localObject4.getFileName(), Integer.valueOf(localObject4.getLineNumber()) }));
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString() + "Signal:" + paramInt + ",Native trace\n" + paramString;
    int i = ((String)localObject1).length() / 512 + 1;
    long l = System.nanoTime();
    paramInt = 0;
    if (paramInt < i)
    {
      if ((paramInt + 1) * 512 < ((String)localObject1).length()) {}
      for (paramString = ((String)localObject1).substring(paramInt * 512, (paramInt + 1) * 512);; paramString = ((String)localObject1).substring(paramInt * 512))
      {
        h.OAn.a(17910, true, true, new Object[] { com.tencent.mm.loader.i.a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION, this.reportExecutionTag, Integer.valueOf(0), paramString, Integer.valueOf(1), Integer.valueOf(paramInt + 1), Integer.valueOf(i), Long.valueOf(l) });
        paramInt += 1;
        break;
      }
    }
    if ((this.context instanceof RubbishBinService))
    {
      ((RubbishBinService)this.context).tpF.interrupt();
      ((RubbishBinService)this.context).stopSelf();
    }
    try
    {
      paramInt = ((RubbishBinService)this.context).JJO;
      if (paramInt > 0) {
        Thread.sleep(paramInt);
      }
    }
    catch (Exception paramString)
    {
      label490:
      break label490;
    }
    if (((String)localObject1).contains("pthread_exit"))
    {
      paramString = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      localObject1 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramString.aYi(), "com/tencent/mm/plugin/rubbishbin/JNIExceptionHandlerImpl", "onException", "(ILjava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramString.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/rubbishbin/JNIExceptionHandlerImpl", "onException", "(ILjava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    }
    AppMethodBeat.o(146667);
  }
  
  public void setReportExecutionTag(String paramString)
  {
    this.reportExecutionTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.JNIExceptionHandlerImpl
 * JD-Core Version:    0.7.0.1
 */