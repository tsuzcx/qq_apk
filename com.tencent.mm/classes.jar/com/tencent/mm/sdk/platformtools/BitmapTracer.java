package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class BitmapTracer
{
  private static final boolean RECORD_STACK_TRACE = true;
  private static final String TAG = "MicroMsg.BitmapTracer";
  private static final WeakHashMap<Bitmap, BitmapTracer.BitmapTraceInfo> bitmapTraces;
  private static boolean checkingScheduled;
  private static final MMHandler handler;
  
  static
  {
    AppMethodBeat.i(156097);
    bitmapTraces = new WeakHashMap();
    if (!WeChatEnvironment.isMonkeyEnv())
    {
      handler = null;
      MTimerHandler localMTimerHandler = new MTimerHandler("BitmapBriefTracer", new MTimerHandler.CallBack()
      {
        public boolean onTimerExpired()
        {
          AppMethodBeat.i(156078);
          BitmapTracer.briefDump();
          AppMethodBeat.o(156078);
          return true;
        }
      }, true);
      localMTimerHandler.startTimer(3600000L);
      localMTimerHandler.setLogging(false);
    }
    for (;;)
    {
      MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
      {
        public void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(244066);
          if (!(paramAnonymousThrowable instanceof OutOfMemoryError))
          {
            AppMethodBeat.o(244066);
            return;
          }
          BitmapTracer.access$300(1048576L, -1);
          AppMethodBeat.o(244066);
        }
      });
      AppMethodBeat.o(156097);
      return;
      handler = new MMHandler("BitmapTracer", new MMHandler.Callback()
      {
        long lastGCTime = 0L;
        boolean traceDumped = false;
        
        /* Error */
        public boolean handleMessage(android.os.Message paramAnonymousMessage)
        {
          // Byte code:
          //   0: ldc 26
          //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: iconst_0
          //   6: invokestatic 36	com/tencent/mm/sdk/platformtools/BitmapTracer:access$002	(Z)Z
          //   9: pop
          //   10: invokestatic 42	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
          //   13: astore_1
          //   14: aload_1
          //   15: invokevirtual 46	java/lang/Runtime:totalMemory	()J
          //   18: lstore_2
          //   19: aload_1
          //   20: invokevirtual 49	java/lang/Runtime:freeMemory	()J
          //   23: lstore 4
          //   25: aload_1
          //   26: invokevirtual 52	java/lang/Runtime:maxMemory	()J
          //   29: lstore 6
          //   31: ldc 54
          //   33: ldc 56
          //   35: iconst_3
          //   36: anewarray 4	java/lang/Object
          //   39: dup
          //   40: iconst_0
          //   41: lload_2
          //   42: lload 4
          //   44: lsub
          //   45: invokestatic 60	com/tencent/mm/sdk/platformtools/BitmapTracer:access$100	(J)Ljava/lang/String;
          //   48: aastore
          //   49: dup
          //   50: iconst_1
          //   51: lload 4
          //   53: invokestatic 60	com/tencent/mm/sdk/platformtools/BitmapTracer:access$100	(J)Ljava/lang/String;
          //   56: aastore
          //   57: dup
          //   58: iconst_2
          //   59: lload 6
          //   61: invokestatic 60	com/tencent/mm/sdk/platformtools/BitmapTracer:access$100	(J)Ljava/lang/String;
          //   64: aastore
          //   65: invokestatic 65	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   68: aload_0
          //   69: getfield 18	com/tencent/mm/sdk/platformtools/BitmapTracer$2:traceDumped	Z
          //   72: ifne +133 -> 205
          //   75: lload_2
          //   76: lload 4
          //   78: lsub
          //   79: ldc2_w 66
          //   82: lcmp
          //   83: ifle +122 -> 205
          //   86: invokestatic 72	java/lang/System:currentTimeMillis	()J
          //   89: lstore_2
          //   90: lload_2
          //   91: aload_0
          //   92: getfield 20	com/tencent/mm/sdk/platformtools/BitmapTracer$2:lastGCTime	J
          //   95: lsub
          //   96: ldc2_w 73
          //   99: lcmp
          //   100: ifle +18 -> 118
          //   103: invokestatic 77	java/lang/System:gc	()V
          //   106: aload_0
          //   107: lload_2
          //   108: putfield 20	com/tencent/mm/sdk/platformtools/BitmapTracer$2:lastGCTime	J
          //   111: ldc 26
          //   113: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   116: iconst_1
          //   117: ireturn
          //   118: aconst_null
          //   119: astore_1
          //   120: new 82	java/io/PrintWriter
          //   123: dup
          //   124: new 84	java/util/zip/GZIPOutputStream
          //   127: dup
          //   128: new 86	java/lang/StringBuilder
          //   131: dup
          //   132: invokespecial 87	java/lang/StringBuilder:<init>	()V
          //   135: invokestatic 93	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
          //   138: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   141: ldc 99
          //   143: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   146: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   149: iconst_0
          //   150: invokestatic 108	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
          //   153: invokespecial 111	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
          //   156: invokespecial 112	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
          //   159: astore 8
          //   161: aload 8
          //   163: astore_1
          //   164: aload 8
          //   166: lconst_0
          //   167: iconst_m1
          //   168: invokestatic 116	com/tencent/mm/sdk/platformtools/BitmapTracer:access$200	(Ljava/io/PrintWriter;JI)V
          //   171: aload 8
          //   173: invokestatic 122	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
          //   176: new 86	java/lang/StringBuilder
          //   179: dup
          //   180: invokespecial 87	java/lang/StringBuilder:<init>	()V
          //   183: invokestatic 93	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
          //   186: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   189: ldc 124
          //   191: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   194: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   197: invokestatic 130	android/os/Debug:dumpHprofData	(Ljava/lang/String;)V
          //   200: aload_0
          //   201: iconst_1
          //   202: putfield 18	com/tencent/mm/sdk/platformtools/BitmapTracer$2:traceDumped	Z
          //   205: ldc 26
          //   207: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   210: iconst_1
          //   211: ireturn
          //   212: astore 9
          //   214: aconst_null
          //   215: astore 8
          //   217: aload 8
          //   219: astore_1
          //   220: ldc 54
          //   222: aload 9
          //   224: ldc 132
          //   226: iconst_0
          //   227: anewarray 4	java/lang/Object
          //   230: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   233: aload 8
          //   235: invokestatic 122	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
          //   238: goto -62 -> 176
          //   241: astore 9
          //   243: aload_1
          //   244: astore 8
          //   246: aload 9
          //   248: astore_1
          //   249: aload 8
          //   251: invokestatic 122	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
          //   254: ldc 26
          //   256: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   259: aload_1
          //   260: athrow
          //   261: astore_1
          //   262: ldc 54
          //   264: aload_1
          //   265: ldc 132
          //   267: iconst_0
          //   268: anewarray 4	java/lang/Object
          //   271: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   274: goto -74 -> 200
          //   277: astore 9
          //   279: aload_1
          //   280: astore 8
          //   282: aload 9
          //   284: astore_1
          //   285: goto -36 -> 249
          //   288: astore 9
          //   290: goto -73 -> 217
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	293	0	this	2
          //   0	293	1	paramAnonymousMessage	android.os.Message
          //   18	90	2	l1	long
          //   23	54	4	l2	long
          //   29	31	6	l3	long
          //   159	122	8	localObject1	Object
          //   212	11	9	localException1	java.lang.Exception
          //   241	6	9	localObject2	Object
          //   277	6	9	localObject3	Object
          //   288	1	9	localException2	java.lang.Exception
          // Exception table:
          //   from	to	target	type
          //   120	161	212	java/lang/Exception
          //   120	161	241	finally
          //   176	200	261	java/lang/Exception
          //   164	171	277	finally
          //   220	233	277	finally
          //   164	171	288	java/lang/Exception
        }
      });
    }
  }
  
  public static void briefDump()
  {
    AppMethodBeat.i(156085);
    dumpReadableLog(2097152L, 3);
    AppMethodBeat.o(156085);
  }
  
  private static void dumpReadableLog(long paramLong, int paramInt)
  {
    AppMethodBeat.i(156086);
    printStatistics(new PrintWriter(new Writer()
    {
      private StringWriter sw;
      
      public void close()
      {
        AppMethodBeat.i(156083);
        flush();
        AppMethodBeat.o(156083);
      }
      
      public void flush()
      {
        AppMethodBeat.i(156082);
        if (this.sw == null)
        {
          AppMethodBeat.o(156082);
          return;
        }
        String str = this.sw.toString();
        this.sw = null;
        Log.w("MicroMsg.BitmapTracer", str);
        AppMethodBeat.o(156082);
      }
      
      public void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(156081);
        if (this.sw == null) {
          this.sw = new StringWriter();
        }
        this.sw.write(paramAnonymousArrayOfChar, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(156081);
      }
    }, false), paramLong, paramInt);
    AppMethodBeat.o(156086);
  }
  
  private static String humanReadableSize(long paramLong)
  {
    AppMethodBeat.i(156090);
    if (paramLong >= 1073741824L)
    {
      str = String.format("%.2f GB", new Object[] { Double.valueOf(paramLong / 1073741824.0D) });
      AppMethodBeat.o(156090);
      return str;
    }
    if (paramLong >= 1048576L)
    {
      str = String.format("%.2f MB", new Object[] { Double.valueOf(paramLong / 1048576.0D) });
      AppMethodBeat.o(156090);
      return str;
    }
    if (paramLong >= 1024L)
    {
      str = String.format("%.2f kB", new Object[] { Double.valueOf(paramLong / 1024.0D) });
      AppMethodBeat.o(156090);
      return str;
    }
    String str = String.format("%d bytes", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(156090);
    return str;
  }
  
  private static void printAllocationStack(PrintWriter paramPrintWriter, Bitmap paramBitmap, BitmapTracer.BitmapTraceInfo paramBitmapTraceInfo, long paramLong)
  {
    AppMethodBeat.i(156093);
    Bitmap.Config localConfig = paramBitmap.getConfig();
    String str = humanReadableSize(paramBitmap.getAllocationByteCount());
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (localConfig == null) {}
    for (paramBitmap = "UNKNOWN";; paramBitmap = localConfig.name())
    {
      paramPrintWriter.format("\nSize: %s (%d x %d, %s)\n", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), paramBitmap });
      paramPrintWriter.append("Source: ").println(paramBitmapTraceInfo.source);
      paramPrintWriter.format("Acquired: %d seconds ago\n", new Object[] { Long.valueOf((paramLong - paramBitmapTraceInfo.acquiredTime) / 1000L) });
      paramPrintWriter.print("Stack:\n");
      printStack(paramBitmapTraceInfo.stack, paramPrintWriter);
      paramPrintWriter.print("=======================================================\n");
      paramPrintWriter.flush();
      AppMethodBeat.o(156093);
      return;
    }
  }
  
  private static void printStack(StackTraceElement[] paramArrayOfStackTraceElement, PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(156091);
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      paramPrintWriter.append("  at ").println(localStackTraceElement.toString());
      i += 1;
    }
    AppMethodBeat.o(156091);
  }
  
  private static void printStatistics(PrintWriter paramPrintWriter, long paramLong, int paramInt)
  {
    AppMethodBeat.i(156092);
    int i;
    int j;
    long l2;
    long l4;
    long l1;
    if (paramLong > 0L)
    {
      paramPrintWriter.format("Statistics for all Bitmaps larger than %.2f MB:\n", new Object[] { Double.valueOf(paramLong / 1048576.0D) });
      paramPrintWriter.flush();
      i = 0;
      j = 0;
      l2 = 0L;
      l4 = System.currentTimeMillis();
      l1 = 0L;
    }
    for (;;)
    {
      Bitmap localBitmap;
      BitmapTracer.BitmapTraceInfo localBitmapTraceInfo;
      long l5;
      synchronized (bitmapTraces)
      {
        for (;;)
        {
          Object localObject1 = new ArrayList();
          try
          {
            ((List)localObject1).addAll(bitmapTraces.entrySet());
            Iterator localIterator = ((List)localObject1).iterator();
            localObject4 = null;
            localObject1 = null;
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label296;
              }
              localObject3 = (Map.Entry)localIterator.next();
              localBitmap = (Bitmap)((Map.Entry)localObject3).getKey();
              localBitmapTraceInfo = (BitmapTracer.BitmapTraceInfo)((Map.Entry)localObject3).getValue();
              if (localBitmap != null)
              {
                boolean bool = localBitmap.isRecycled();
                if (!bool) {
                  break;
                }
                j += 1;
              }
            }
            paramPrintWriter.print("Statistics for all Bitmaps alive:\n");
            break;
            l5 = localBitmap.getAllocationByteCount();
            l3 = l2 + l5;
            i += 1;
            if (localObject1 == null) {
              break label392;
            }
            localObject3 = localObject1;
            if (l5 <= ((Bitmap)localObject1).getAllocationByteCount()) {
              break label404;
            }
          }
          catch (ConcurrentModificationException localConcurrentModificationException)
          {
            long l3;
            paramPrintWriter.print("ConcurrentModificationException occur.");
            paramPrintWriter.flush();
            paramPrintWriter.close();
            AppMethodBeat.o(156092);
            return;
          }
        }
        l2 = l1 + 1L;
        paramPrintWriter.append('#').println(i);
        printAllocationStack(paramPrintWriter, localBitmap, localBitmapTraceInfo, l4);
        l1 = l2;
        localObject1 = localObject3;
        l2 = l3;
        continue;
        label296:
        if ((localConcurrentModificationException != null) && (localObject4 != null))
        {
          paramPrintWriter.append("# Biggest Bitmap");
          printAllocationStack(paramPrintWriter, localConcurrentModificationException, (BitmapTracer.BitmapTraceInfo)localObject4, l4);
        }
        paramPrintWriter.format("\n\nLiving Bitmaps: %d, %s\n", new Object[] { Integer.valueOf(i), humanReadableSize(l2) });
        paramPrintWriter.append("Recycled Bitmaps: ").println(j);
        paramPrintWriter.flush();
        paramPrintWriter.close();
        AppMethodBeat.o(156092);
        return;
      }
      label392:
      Object localObject2 = localBitmapTraceInfo;
      Object localObject3 = localBitmap;
      Object localObject4 = localObject2;
      label404:
      l2 = l1;
      if (l5 >= paramLong) {
        if (paramInt != -1)
        {
          l2 = l1;
          if (l1 >= paramInt) {}
        }
      }
    }
  }
  
  public static Bitmap trace(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156087);
    paramBitmap = trace(paramBitmap, null, null);
    AppMethodBeat.o(156087);
    return paramBitmap;
  }
  
  public static Bitmap trace(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(156088);
    paramBitmap = trace(paramBitmap, paramString, null);
    AppMethodBeat.o(156088);
    return paramBitmap;
  }
  
  public static Bitmap trace(Bitmap paramBitmap, String arg1, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(243405);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(243405);
      return null;
    }
    if ((paramBitmap.getAllocationByteCount() < 1048576) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      AppMethodBeat.o(243405);
      return paramBitmap;
    }
    paramOptions = new BitmapTracer.BitmapTraceInfo(???, paramOptions);
    synchronized (bitmapTraces)
    {
      bitmapTraces.put(paramBitmap, paramOptions);
      if ((handler != null) && (!checkingScheduled))
      {
        handler.sendEmptyMessageDelayed(0, 5000L);
        checkingScheduled = true;
      }
      AppMethodBeat.o(243405);
      return paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BitmapTracer
 * JD-Core Version:    0.7.0.1
 */