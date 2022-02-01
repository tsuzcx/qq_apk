package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
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
        com.tencent.mm.plugin.report.service.h.wUl.a(17910, true, true, new Object[] { a.gMJ, com.tencent.mm.sdk.platformtools.h.gMJ, this.reportExecutionTag, Integer.valueOf(0), paramString, Integer.valueOf(1), Integer.valueOf(paramInt + 1), Integer.valueOf(i), Long.valueOf(l) });
        paramInt += 1;
        break;
      }
    }
    if ((this.context instanceof RubbishBinService))
    {
      ((RubbishBinService)this.context).gaE.interrupt();
      ((RubbishBinService)this.context).stopSelf();
    }
    try
    {
      paramInt = ((RubbishBinService)this.context).gaC;
      if (paramInt > 0) {
        Thread.sleep(paramInt);
      }
    }
    catch (Exception paramString)
    {
      label490:
      break label490;
    }
    if (((String)localObject1).contains("pthread_exit")) {
      System.exit(0);
    }
    AppMethodBeat.o(146667);
  }
  
  public void setReportExecutionTag(String paramString)
  {
    this.reportExecutionTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.JNIExceptionHandlerImpl
 * JD-Core Version:    0.7.0.1
 */