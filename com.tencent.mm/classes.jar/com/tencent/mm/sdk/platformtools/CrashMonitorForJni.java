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
    AppMethodBeat.i(126235);
    Recovery.dUi();
    new StringBuilder("OnCrash sig:").append(paramInt1).append("  stack:").append(paramString);
    b.k(paramInt1, paramString);
    AppMethodBeat.o(126235);
  }
  
  private static void OnCrash(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(146058);
    paramString2 = getThreadJavaStack(getThreadByName(paramString2));
    paramString1 = new StringBuilder(paramString1);
    paramString1.append("\n******* Java stack for JNI crash *******\n");
    paramString1.append(paramString2);
    writeStackToFile(paramString1.toString());
    AppMethodBeat.o(146058);
  }
  
  private static CharSequence getAllThreadJavaStack()
  {
    AppMethodBeat.i(126236);
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
    AppMethodBeat.o(126236);
    return localStringBuilder1;
  }
  
  public static native String getCrashFilePath(String paramString);
  
  public static String getCrashThreadJavaStack()
  {
    AppMethodBeat.i(126237);
    Object localObject1 = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject1);
    Object localObject2 = sCrashExtraMessageGetter;
    if (localObject2 != null)
    {
      localPrintWriter.append("\n");
      localPrintWriter.append(((a)localObject2).Bt());
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
    AppMethodBeat.o(126237);
    return localObject1;
  }
  
  public static Thread getThreadByName(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(146061);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(146061);
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
      AppMethodBeat.o(146061);
      return localObject;
    }
  }
  
  public static String getThreadJavaStack(Thread paramThread)
  {
    AppMethodBeat.i(146060);
    if (paramThread == null)
    {
      AppMethodBeat.o(146060);
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
    AppMethodBeat.o(146060);
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
    AppMethodBeat.i(146057);
    mCrashRecordFd = paramParcelFileDescriptor;
    nativeSetCrashRecordLowFd(paramParcelFileDescriptor.getFd());
    AppMethodBeat.o(146057);
  }
  
  /* Error */
  private static void writeStackToFile(String paramString)
  {
    // Byte code:
    //   0: ldc 249
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 19	com/tencent/mm/sdk/platformtools/CrashMonitorForJni:mCrashRecordFd	Landroid/os/ParcelFileDescriptor;
    //   8: ifnull +104 -> 112
    //   11: new 251	java/io/FileOutputStream
    //   14: dup
    //   15: getstatic 19	com/tencent/mm/sdk/platformtools/CrashMonitorForJni:mCrashRecordFd	Landroid/os/ParcelFileDescriptor;
    //   18: invokevirtual 255	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   21: invokespecial 258	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: invokevirtual 262	java/lang/String:getBytes	()[B
    //   30: invokevirtual 266	java/io/FileOutputStream:write	([B)V
    //   33: aload_1
    //   34: invokevirtual 269	java/io/FileOutputStream:flush	()V
    //   37: aload_1
    //   38: ifnull +7 -> 45
    //   41: aload_1
    //   42: invokevirtual 272	java/io/FileOutputStream:close	()V
    //   45: ldc 249
    //   47: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: astore_0
    //   52: ldc 249
    //   54: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 272	java/io/FileOutputStream:close	()V
    //   69: ldc 249
    //   71: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: return
    //   75: astore_0
    //   76: ldc 249
    //   78: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 272	java/io/FileOutputStream:close	()V
    //   93: ldc 249
    //   95: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: athrow
    //   100: astore_1
    //   101: goto -8 -> 93
    //   104: astore_0
    //   105: goto -20 -> 85
    //   108: astore_0
    //   109: goto -48 -> 61
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -77 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   24	66	1	localFileOutputStream	java.io.FileOutputStream
    //   100	1	1	localThrowable	Throwable
    //   113	1	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   41	45	51	java/lang/Throwable
    //   5	25	58	java/lang/Throwable
    //   65	69	75	java/lang/Throwable
    //   5	25	82	finally
    //   89	93	100	java/lang/Throwable
    //   25	37	104	finally
    //   25	37	108	java/lang/Throwable
  }
  
  public static abstract interface a
  {
    public abstract String Bt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.CrashMonitorForJni
 * JD-Core Version:    0.7.0.1
 */