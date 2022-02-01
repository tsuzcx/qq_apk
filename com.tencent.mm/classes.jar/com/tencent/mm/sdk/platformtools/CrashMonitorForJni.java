package com.tencent.mm.sdk.platformtools;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.recovery.Recovery;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CrashMonitorForJni
{
  private static final String TAG = "MicroMsg.CrashMonitorForJni";
  private static ParcelFileDescriptor mCrashRecordFd = null;
  private static a sCrashExtraMessageGetter;
  
  private static void OnCrash(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(145683);
    Recovery.crash();
    new StringBuilder("OnCrash sig:").append(paramInt1).append("  stack:").append(paramString);
    b.d(paramInt1, paramString, "CrashMonitor");
    ac.appenderClose();
    AppMethodBeat.o(145683);
  }
  
  private static void OnCrash(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(145684);
    paramString2 = getThreadJavaStack(getThreadByName(paramString2));
    paramString1 = new StringBuilder(paramString1);
    paramString1.append("\n******* Java stack for JNI crash *******\n");
    paramString1.append(paramString2);
    writeStackToFile(paramString1.toString());
    AppMethodBeat.o(145684);
  }
  
  private static CharSequence getAllThreadJavaStack()
  {
    AppMethodBeat.i(145685);
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
    AppMethodBeat.o(145685);
    return localStringBuilder1;
  }
  
  public static native String getCrashFilePath(String paramString);
  
  public static String getCrashThreadJavaStack()
  {
    AppMethodBeat.i(145686);
    Object localObject1 = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject1);
    Object localObject2 = sCrashExtraMessageGetter;
    if (localObject2 != null)
    {
      localPrintWriter.append("\n");
      localPrintWriter.append(((a)localObject2).KB());
      localPrintWriter.append("\n");
    }
    localObject2 = new Throwable("\n******* Java stack for JNI crash *******");
    StackTraceElement[] arrayOfStackTraceElement1 = ((Throwable)localObject2).getStackTrace();
    if (arrayOfStackTraceElement1.length > 1)
    {
      StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[arrayOfStackTraceElement1.length - 1];
      int i = 0;
      while (i < arrayOfStackTraceElement2.length)
      {
        arrayOfStackTraceElement2[i] = arrayOfStackTraceElement1[(i + 1)];
        i += 1;
      }
      ((Throwable)localObject2).setStackTrace(arrayOfStackTraceElement2);
    }
    ((Throwable)localObject2).printStackTrace(localPrintWriter);
    localPrintWriter.append(getAllThreadJavaStack());
    localPrintWriter.append('\n');
    localObject1 = ((StringWriter)localObject1).toString();
    AppMethodBeat.o(145686);
    return localObject1;
  }
  
  public static Thread getThreadByName(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(145689);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(145689);
      return null;
    }
    Set localSet = Thread.getAllStackTraces().keySet();
    Thread[] arrayOfThread = (Thread[])localSet.toArray(new Thread[localSet.size()]);
    int j = arrayOfThread.length;
    int i = 0;
    if (i < j)
    {
      localSet = arrayOfThread[i];
      if (!localSet.getName().equals(paramString)) {
        break label99;
      }
      localObject = localSet;
    }
    label99:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(145689);
      return localObject;
    }
  }
  
  public static String getThreadJavaStack(Thread paramThread)
  {
    AppMethodBeat.i(145688);
    if (paramThread == null)
    {
      AppMethodBeat.o(145688);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramThread = paramThread.getStackTrace();
    int j = paramThread.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramThread[i];
      localStringBuilder.append(localObject.toString() + "\n");
      i += 1;
    }
    paramThread = localStringBuilder.toString();
    AppMethodBeat.o(145688);
    return paramThread;
  }
  
  private static native void nativeSetCrashRecordLowFd(int paramInt);
  
  public static native void nativeStartCrashTest(int paramInt);
  
  public static native void setClientVersionMsg(String paramString);
  
  public static void setCrashExtraMessageGetter(a parama)
  {
    sCrashExtraMessageGetter = parama;
  }
  
  public static void setCrashRecordLowFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(145682);
    mCrashRecordFd = paramParcelFileDescriptor;
    nativeSetCrashRecordLowFd(paramParcelFileDescriptor.getFd());
    AppMethodBeat.o(145682);
  }
  
  /* Error */
  private static void writeStackToFile(String paramString)
  {
    // Byte code:
    //   0: ldc_w 256
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 19	com/tencent/mm/sdk/platformtools/CrashMonitorForJni:mCrashRecordFd	Landroid/os/ParcelFileDescriptor;
    //   9: ifnull +109 -> 118
    //   12: new 258	java/io/FileOutputStream
    //   15: dup
    //   16: getstatic 19	com/tencent/mm/sdk/platformtools/CrashMonitorForJni:mCrashRecordFd	Landroid/os/ParcelFileDescriptor;
    //   19: invokevirtual 262	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   22: invokespecial 265	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   25: astore_1
    //   26: aload_1
    //   27: aload_0
    //   28: invokevirtual 269	java/lang/String:getBytes	()[B
    //   31: invokevirtual 273	java/io/FileOutputStream:write	([B)V
    //   34: aload_1
    //   35: invokevirtual 276	java/io/FileOutputStream:flush	()V
    //   38: aload_1
    //   39: ifnull +7 -> 46
    //   42: aload_1
    //   43: invokevirtual 279	java/io/FileOutputStream:close	()V
    //   46: ldc_w 256
    //   49: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: astore_0
    //   54: ldc_w 256
    //   57: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 279	java/io/FileOutputStream:close	()V
    //   72: ldc_w 256
    //   75: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore_0
    //   80: ldc_w 256
    //   83: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 279	java/io/FileOutputStream:close	()V
    //   98: ldc_w 256
    //   101: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: athrow
    //   106: astore_1
    //   107: goto -9 -> 98
    //   110: astore_0
    //   111: goto -21 -> 90
    //   114: astore_0
    //   115: goto -51 -> 64
    //   118: aconst_null
    //   119: astore_1
    //   120: goto -82 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   25	70	1	localFileOutputStream	java.io.FileOutputStream
    //   106	1	1	localThrowable	Throwable
    //   119	1	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	46	53	java/lang/Throwable
    //   6	26	61	java/lang/Throwable
    //   68	72	79	java/lang/Throwable
    //   6	26	87	finally
    //   94	98	106	java/lang/Throwable
    //   26	38	110	finally
    //   26	38	114	java/lang/Throwable
  }
  
  public static abstract interface a
  {
    public abstract String KB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.CrashMonitorForJni
 * JD-Core Version:    0.7.0.1
 */