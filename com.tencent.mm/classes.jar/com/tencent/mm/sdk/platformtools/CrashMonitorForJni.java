package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.sdk.a.b;
import com.tencent.recovery.Recovery;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CrashMonitorForJni
{
  private static final String TAG = "MicroMsg.CrashMonitorForJni";
  private static a sCrashExtraMessageGetter;
  
  private static void OnCrash(int paramInt1, int paramInt2, String paramString)
  {
    Recovery.cOt();
    new StringBuilder("OnCrash sig:").append(paramInt1).append("  stack:").append(paramString);
    b.h(paramInt1, paramString);
  }
  
  private static CharSequence getAllThreadJavaStack()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(8192);
    StringBuilder localStringBuilder2 = new StringBuilder(2048);
    Iterator localIterator = Thread.getAllStackTraces().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      Thread localThread = (Thread)((Map.Entry)localObject).getKey();
      localObject = (StackTraceElement[])((Map.Entry)localObject).getValue();
      localStringBuilder2.setLength(0);
      localStringBuilder2.append("\n (").append(localThread.getId()).append(") [").append(localThread.getName()).append("] ************\n");
      int j = 0;
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].toString().startsWith("com.tencent.mm.")) {
          j = 1;
        }
        localStringBuilder2.append("\tat ").append(localObject[i].toString()).append("\n");
        i += 1;
      }
      if (j != 0) {
        localStringBuilder1.append(localStringBuilder2);
      }
    }
    return localStringBuilder1;
  }
  
  public static String getCrashThreadJavaStack()
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    Object localObject = sCrashExtraMessageGetter;
    if (localObject != null)
    {
      localPrintWriter.append("\n");
      localPrintWriter.append(((a)localObject).sX());
      localPrintWriter.append("\n");
    }
    localObject = new Throwable("\n******* Java stack for JNI crash *******");
    StackTraceElement[] arrayOfStackTraceElement1 = ((Throwable)localObject).getStackTrace();
    if (arrayOfStackTraceElement1.length > 1)
    {
      StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[arrayOfStackTraceElement1.length - 1];
      int i = 0;
      while (i < arrayOfStackTraceElement2.length)
      {
        arrayOfStackTraceElement2[i] = arrayOfStackTraceElement1[(i + 1)];
        i += 1;
      }
      ((Throwable)localObject).setStackTrace(arrayOfStackTraceElement2);
    }
    ((Throwable)localObject).printStackTrace(localPrintWriter);
    localPrintWriter.append(getAllThreadJavaStack());
    localPrintWriter.append('\n');
    return localStringWriter.toString();
  }
  
  public static native void setClientVersionMsg(String paramString);
  
  public static void setCrashExtraMessageGetter(a parama)
  {
    sCrashExtraMessageGetter = parama;
  }
  
  public static abstract interface a
  {
    public abstract String sX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.CrashMonitorForJni
 * JD-Core Version:    0.7.0.1
 */