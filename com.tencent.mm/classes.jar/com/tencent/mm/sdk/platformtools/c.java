package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class c
{
  private static final Handler handler;
  private static final WeakHashMap<Bitmap, a> ymy;
  private static boolean ymz;
  
  static
  {
    AppMethodBeat.i(93316);
    ymy = new WeakHashMap();
    HandlerThread localHandlerThread;
    if (!bp.dsd())
    {
      handler = null;
      localHandlerThread = new HandlerThread("BitmapBriefTracer");
      localHandlerThread.start();
      new ap(localHandlerThread.getLooper(), new ap.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(93297);
          c.dsk();
          AppMethodBeat.o(93297);
          return true;
        }
      }, true).ag(120000L, 120000L);
    }
    for (;;)
    {
      ao.a(new ao.c()
      {
        public final void b(String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(93299);
          if (!(paramAnonymousThrowable instanceof OutOfMemoryError))
          {
            AppMethodBeat.o(93299);
            return;
          }
          c.dsl();
          AppMethodBeat.o(93299);
        }
      });
      AppMethodBeat.o(93316);
      return;
      localHandlerThread = new HandlerThread("BitmapTracer");
      localHandlerThread.start();
      handler = new Handler(localHandlerThread.getLooper(), new Handler.Callback()
      {
        boolean ymA = false;
        long ymB = 0L;
        
        /* Error */
        public final boolean handleMessage(android.os.Message paramAnonymousMessage)
        {
          // Byte code:
          //   0: ldc 26
          //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: invokestatic 36	com/tencent/mm/sdk/platformtools/c:Pt	()Z
          //   8: pop
          //   9: invokestatic 42	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
          //   12: astore_1
          //   13: aload_1
          //   14: invokevirtual 46	java/lang/Runtime:totalMemory	()J
          //   17: lstore_2
          //   18: aload_1
          //   19: invokevirtual 49	java/lang/Runtime:freeMemory	()J
          //   22: lstore 4
          //   24: aload_1
          //   25: invokevirtual 52	java/lang/Runtime:maxMemory	()J
          //   28: lstore 6
          //   30: ldc 54
          //   32: ldc 56
          //   34: iconst_3
          //   35: anewarray 4	java/lang/Object
          //   38: dup
          //   39: iconst_0
          //   40: lload_2
          //   41: lload 4
          //   43: lsub
          //   44: invokestatic 60	com/tencent/mm/sdk/platformtools/c:nM	(J)Ljava/lang/String;
          //   47: aastore
          //   48: dup
          //   49: iconst_1
          //   50: lload 4
          //   52: invokestatic 60	com/tencent/mm/sdk/platformtools/c:nM	(J)Ljava/lang/String;
          //   55: aastore
          //   56: dup
          //   57: iconst_2
          //   58: lload 6
          //   60: invokestatic 60	com/tencent/mm/sdk/platformtools/c:nM	(J)Ljava/lang/String;
          //   63: aastore
          //   64: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   67: aload_0
          //   68: getfield 18	com/tencent/mm/sdk/platformtools/c$2:ymA	Z
          //   71: ifne +134 -> 205
          //   74: lload_2
          //   75: lload 4
          //   77: lsub
          //   78: ldc2_w 66
          //   81: lcmp
          //   82: ifle +123 -> 205
          //   85: invokestatic 72	java/lang/System:currentTimeMillis	()J
          //   88: lstore_2
          //   89: lload_2
          //   90: aload_0
          //   91: getfield 20	com/tencent/mm/sdk/platformtools/c$2:ymB	J
          //   94: lsub
          //   95: ldc2_w 73
          //   98: lcmp
          //   99: ifle +18 -> 117
          //   102: invokestatic 77	java/lang/System:gc	()V
          //   105: aload_0
          //   106: lload_2
          //   107: putfield 20	com/tencent/mm/sdk/platformtools/c$2:ymB	J
          //   110: ldc 26
          //   112: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   115: iconst_1
          //   116: ireturn
          //   117: aconst_null
          //   118: astore_1
          //   119: new 82	java/io/PrintWriter
          //   122: dup
          //   123: new 84	java/util/zip/GZIPOutputStream
          //   126: dup
          //   127: new 86	java/io/FileOutputStream
          //   130: dup
          //   131: new 88	java/lang/StringBuilder
          //   134: dup
          //   135: invokespecial 89	java/lang/StringBuilder:<init>	()V
          //   138: getstatic 95	com/tencent/mm/compatible/util/e:eQz	Ljava/lang/String;
          //   141: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   144: ldc 101
          //   146: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   149: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   152: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
          //   155: invokespecial 111	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
          //   158: invokespecial 112	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
          //   161: astore 8
          //   163: aload 8
          //   165: astore_1
          //   166: aload 8
          //   168: invokestatic 116	com/tencent/mm/sdk/platformtools/c:a	(Ljava/io/PrintWriter;)V
          //   171: aload 8
          //   173: invokestatic 122	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
          //   176: new 88	java/lang/StringBuilder
          //   179: dup
          //   180: invokespecial 89	java/lang/StringBuilder:<init>	()V
          //   183: getstatic 95	com/tencent/mm/compatible/util/e:eQz	Ljava/lang/String;
          //   186: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   189: ldc 124
          //   191: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   194: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   197: invokestatic 129	android/os/Debug:dumpHprofData	(Ljava/lang/String;)V
          //   200: aload_0
          //   201: iconst_1
          //   202: putfield 18	com/tencent/mm/sdk/platformtools/c$2:ymA	Z
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
          //   224: ldc 131
          //   226: iconst_0
          //   227: anewarray 4	java/lang/Object
          //   230: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   233: aload 8
          //   235: invokestatic 122	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
          //   238: goto -62 -> 176
          //   241: astore 9
          //   243: aload_1
          //   244: astore 8
          //   246: aload 9
          //   248: astore_1
          //   249: aload 8
          //   251: invokestatic 122	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
          //   254: ldc 26
          //   256: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   259: aload_1
          //   260: athrow
          //   261: astore_1
          //   262: ldc 54
          //   264: aload_1
          //   265: ldc 131
          //   267: iconst_0
          //   268: anewarray 4	java/lang/Object
          //   271: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
          //   17	90	2	l1	long
          //   22	54	4	l2	long
          //   28	31	6	l3	long
          //   161	120	8	localObject1	Object
          //   212	11	9	localException1	java.lang.Exception
          //   241	6	9	localObject2	Object
          //   277	6	9	localObject3	Object
          //   288	1	9	localException2	java.lang.Exception
          // Exception table:
          //   from	to	target	type
          //   119	163	212	java/lang/Exception
          //   119	163	241	finally
          //   176	200	261	java/lang/Exception
          //   166	171	277	finally
          //   220	233	277	finally
          //   166	171	288	java/lang/Exception
        }
      });
    }
  }
  
  private static void K(long paramLong, int paramInt)
  {
    AppMethodBeat.i(93305);
    a(new PrintWriter(new Writer()
    {
      private StringWriter ymC;
      
      public final void close()
      {
        AppMethodBeat.i(93302);
        flush();
        AppMethodBeat.o(93302);
      }
      
      public final void flush()
      {
        AppMethodBeat.i(93301);
        if (this.ymC == null)
        {
          AppMethodBeat.o(93301);
          return;
        }
        String str = this.ymC.toString();
        this.ymC = null;
        ab.w("MicroMsg.BitmapTracer", str);
        AppMethodBeat.o(93301);
      }
      
      public final void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(93300);
        if (this.ymC == null) {
          this.ymC = new StringWriter();
        }
        this.ymC.write(paramAnonymousArrayOfChar, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(93300);
      }
    }, false), paramLong, paramInt);
    AppMethodBeat.o(93305);
  }
  
  private static void a(PrintWriter paramPrintWriter, long paramLong, int paramInt)
  {
    AppMethodBeat.i(93311);
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
      a locala;
      long l5;
      synchronized (ymy)
      {
        for (;;)
        {
          Object localObject1 = new ArrayList();
          try
          {
            ((List)localObject1).addAll(ymy.entrySet());
            Iterator localIterator = ((List)localObject1).iterator();
            localObject4 = null;
            localObject1 = null;
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label294;
              }
              localObject3 = (Map.Entry)localIterator.next();
              localBitmap = (Bitmap)((Map.Entry)localObject3).getKey();
              locala = (a)((Map.Entry)localObject3).getValue();
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
              break label387;
            }
            localObject3 = localObject1;
            if (l5 <= ((Bitmap)localObject1).getAllocationByteCount()) {
              break label399;
            }
          }
          catch (ConcurrentModificationException localConcurrentModificationException)
          {
            long l3;
            paramPrintWriter.print("ConcurrentModificationException occur.");
            paramPrintWriter.flush();
            paramPrintWriter.close();
            AppMethodBeat.o(93311);
            return;
          }
        }
        l2 = l1 + 1L;
        paramPrintWriter.append('#').println(i);
        a(paramPrintWriter, localBitmap, locala, l4);
        l1 = l2;
        localObject1 = localObject3;
        l2 = l3;
        continue;
        label294:
        if ((localConcurrentModificationException != null) && (localObject4 != null))
        {
          paramPrintWriter.append("# Biggest Bitmap");
          a(paramPrintWriter, localConcurrentModificationException, (a)localObject4, l4);
        }
        paramPrintWriter.format("\n\nLiving Bitmaps: %d, %s\n", new Object[] { Integer.valueOf(i), nL(l2) });
        paramPrintWriter.append("Recycled Bitmaps: ").println(j);
        paramPrintWriter.flush();
        paramPrintWriter.close();
        AppMethodBeat.o(93311);
        return;
      }
      label387:
      Object localObject2 = locala;
      Object localObject3 = localBitmap;
      Object localObject4 = localObject2;
      label399:
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
  
  private static void a(PrintWriter paramPrintWriter, Bitmap paramBitmap, a parama, long paramLong)
  {
    AppMethodBeat.i(93312);
    Bitmap.Config localConfig = paramBitmap.getConfig();
    String str = nL(paramBitmap.getAllocationByteCount());
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (localConfig == null) {}
    for (paramBitmap = "UNKNOWN";; paramBitmap = localConfig.name())
    {
      paramPrintWriter.format("\nSize: %s (%d x %d, %s)\n", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), paramBitmap });
      paramPrintWriter.append("Source: ").println(parama.source);
      paramPrintWriter.format("Acquired: %d seconds ago\n", new Object[] { Long.valueOf((paramLong - parama.ymF) / 1000L) });
      paramPrintWriter.print("Stack:\n");
      a(parama.ymD, paramPrintWriter);
      paramPrintWriter.print("=======================================================\n");
      paramPrintWriter.flush();
      AppMethodBeat.o(93312);
      return;
    }
  }
  
  private static void a(StackTraceElement[] paramArrayOfStackTraceElement, PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(93310);
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      paramPrintWriter.append("  at ").println(localStackTraceElement.toString());
      i += 1;
    }
    AppMethodBeat.o(93310);
  }
  
  public static Bitmap ag(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93306);
    paramBitmap = i(paramBitmap, null);
    AppMethodBeat.o(93306);
    return paramBitmap;
  }
  
  public static void dsk()
  {
    AppMethodBeat.i(93304);
    K(2097152L, 3);
    AppMethodBeat.o(93304);
  }
  
  public static Bitmap h(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(93307);
    paramBitmap = i(paramBitmap, paramString);
    AppMethodBeat.o(93307);
    return paramBitmap;
  }
  
  private static Bitmap i(Bitmap paramBitmap, String arg1)
  {
    AppMethodBeat.i(93308);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(93308);
      return null;
    }
    if ((paramBitmap.getAllocationByteCount() < 1048576) && (!bp.dsd()))
    {
      AppMethodBeat.o(93308);
      return paramBitmap;
    }
    a locala = new a(???);
    synchronized (ymy)
    {
      ymy.put(paramBitmap, locala);
      if ((handler != null) && (!ymz))
      {
        handler.sendEmptyMessageDelayed(0, 5000L);
        ymz = true;
      }
      AppMethodBeat.o(93308);
      return paramBitmap;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  private static String nL(long paramLong)
  {
    AppMethodBeat.i(93309);
    if (paramLong >= 1073741824L)
    {
      str = String.format("%.2f GB", new Object[] { Double.valueOf(paramLong / 1073741824.0D) });
      AppMethodBeat.o(93309);
      return str;
    }
    if (paramLong >= 1048576L)
    {
      str = String.format("%.2f MB", new Object[] { Double.valueOf(paramLong / 1048576.0D) });
      AppMethodBeat.o(93309);
      return str;
    }
    if (paramLong >= 1024L)
    {
      str = String.format("%.2f kB", new Object[] { Double.valueOf(paramLong / 1024.0D) });
      AppMethodBeat.o(93309);
      return str;
    }
    String str = String.format("%d bytes", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(93309);
    return str;
  }
  
  static final class a
  {
    final String source;
    final StackTraceElement[] ymD;
    final BitmapFactory.Options ymE;
    final long ymF;
    
    a(String paramString)
    {
      AppMethodBeat.i(93303);
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      this.ymD = ((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, 4, arrayOfStackTraceElement.length));
      this.source = paramString;
      this.ymE = null;
      this.ymF = System.currentTimeMillis();
      AppMethodBeat.o(93303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.c
 * JD-Core Version:    0.7.0.1
 */