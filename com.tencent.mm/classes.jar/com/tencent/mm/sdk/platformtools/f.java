package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
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

public final class f
{
  private static final WeakHashMap<Bitmap, a> Ick;
  private static boolean Icl;
  private static final ap handler;
  
  static
  {
    AppMethodBeat.i(156097);
    Ick = new WeakHashMap();
    if (!bu.fjL())
    {
      handler = null;
      av localav = new av("BitmapBriefTracer", new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(156078);
          f.fjW();
          AppMethodBeat.o(156078);
          return true;
        }
      }, true);
      localav.az(120000L, 120000L);
      localav.setLogging(false);
    }
    for (;;)
    {
      au.a(new au.c()
      {
        public final void a(au paramAnonymousau, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(195167);
          if (!(paramAnonymousThrowable instanceof OutOfMemoryError))
          {
            AppMethodBeat.o(195167);
            return;
          }
          f.fjX();
          AppMethodBeat.o(195167);
        }
      });
      AppMethodBeat.o(156097);
      return;
      handler = new ap("BitmapTracer", new ap.a()
      {
        boolean Icm = false;
        long Icn = 0L;
        
        /* Error */
        public final boolean handleMessage(android.os.Message paramAnonymousMessage)
        {
          // Byte code:
          //   0: ldc 26
          //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: invokestatic 36	com/tencent/mm/sdk/platformtools/f:Jy	()Z
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
          //   44: invokestatic 60	com/tencent/mm/sdk/platformtools/f:CT	(J)Ljava/lang/String;
          //   47: aastore
          //   48: dup
          //   49: iconst_1
          //   50: lload 4
          //   52: invokestatic 60	com/tencent/mm/sdk/platformtools/f:CT	(J)Ljava/lang/String;
          //   55: aastore
          //   56: dup
          //   57: iconst_2
          //   58: lload 6
          //   60: invokestatic 60	com/tencent/mm/sdk/platformtools/f:CT	(J)Ljava/lang/String;
          //   63: aastore
          //   64: invokestatic 65	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   67: aload_0
          //   68: getfield 18	com/tencent/mm/sdk/platformtools/f$2:Icm	Z
          //   71: ifne +131 -> 202
          //   74: lload_2
          //   75: lload 4
          //   77: lsub
          //   78: ldc2_w 66
          //   81: lcmp
          //   82: ifle +120 -> 202
          //   85: invokestatic 72	java/lang/System:currentTimeMillis	()J
          //   88: lstore_2
          //   89: lload_2
          //   90: aload_0
          //   91: getfield 20	com/tencent/mm/sdk/platformtools/f$2:Icn	J
          //   94: lsub
          //   95: ldc2_w 73
          //   98: lcmp
          //   99: ifle +18 -> 117
          //   102: invokestatic 77	java/lang/System:gc	()V
          //   105: aload_0
          //   106: lload_2
          //   107: putfield 20	com/tencent/mm/sdk/platformtools/f$2:Icn	J
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
          //   127: new 86	java/lang/StringBuilder
          //   130: dup
          //   131: invokespecial 87	java/lang/StringBuilder:<init>	()V
          //   134: invokestatic 93	com/tencent/mm/loader/j/b:arU	()Ljava/lang/String;
          //   137: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   140: ldc 99
          //   142: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   145: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   148: iconst_0
          //   149: invokestatic 108	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
          //   152: invokespecial 111	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
          //   155: invokespecial 112	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
          //   158: astore 8
          //   160: aload 8
          //   162: astore_1
          //   163: aload 8
          //   165: invokestatic 116	com/tencent/mm/sdk/platformtools/f:a	(Ljava/io/PrintWriter;)V
          //   168: aload 8
          //   170: invokestatic 122	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
          //   173: new 86	java/lang/StringBuilder
          //   176: dup
          //   177: invokespecial 87	java/lang/StringBuilder:<init>	()V
          //   180: invokestatic 93	com/tencent/mm/loader/j/b:arU	()Ljava/lang/String;
          //   183: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   186: ldc 124
          //   188: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   191: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   194: invokestatic 130	android/os/Debug:dumpHprofData	(Ljava/lang/String;)V
          //   197: aload_0
          //   198: iconst_1
          //   199: putfield 18	com/tencent/mm/sdk/platformtools/f$2:Icm	Z
          //   202: ldc 26
          //   204: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   207: iconst_1
          //   208: ireturn
          //   209: astore 9
          //   211: aconst_null
          //   212: astore 8
          //   214: aload 8
          //   216: astore_1
          //   217: ldc 54
          //   219: aload 9
          //   221: ldc 132
          //   223: iconst_0
          //   224: anewarray 4	java/lang/Object
          //   227: invokestatic 136	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   230: aload 8
          //   232: invokestatic 122	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
          //   235: goto -62 -> 173
          //   238: astore 9
          //   240: aload_1
          //   241: astore 8
          //   243: aload 9
          //   245: astore_1
          //   246: aload 8
          //   248: invokestatic 122	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
          //   251: ldc 26
          //   253: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   256: aload_1
          //   257: athrow
          //   258: astore_1
          //   259: ldc 54
          //   261: aload_1
          //   262: ldc 132
          //   264: iconst_0
          //   265: anewarray 4	java/lang/Object
          //   268: invokestatic 136	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   271: goto -74 -> 197
          //   274: astore 9
          //   276: aload_1
          //   277: astore 8
          //   279: aload 9
          //   281: astore_1
          //   282: goto -36 -> 246
          //   285: astore 9
          //   287: goto -73 -> 214
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	290	0	this	2
          //   0	290	1	paramAnonymousMessage	android.os.Message
          //   17	90	2	l1	long
          //   22	54	4	l2	long
          //   28	31	6	l3	long
          //   158	120	8	localObject1	Object
          //   209	11	9	localException1	java.lang.Exception
          //   238	6	9	localObject2	Object
          //   274	6	9	localObject3	Object
          //   285	1	9	localException2	java.lang.Exception
          // Exception table:
          //   from	to	target	type
          //   119	160	209	java/lang/Exception
          //   119	160	238	finally
          //   173	197	258	java/lang/Exception
          //   163	168	274	finally
          //   217	230	274	finally
          //   163	168	285	java/lang/Exception
        }
      });
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  private static String CS(long paramLong)
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
  
  private static void a(PrintWriter paramPrintWriter, long paramLong, int paramInt)
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
      a locala;
      long l5;
      synchronized (Ick)
      {
        for (;;)
        {
          Object localObject1 = new ArrayList();
          try
          {
            ((List)localObject1).addAll(Ick.entrySet());
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
            AppMethodBeat.o(156092);
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
        paramPrintWriter.format("\n\nLiving Bitmaps: %d, %s\n", new Object[] { Integer.valueOf(i), CS(l2) });
        paramPrintWriter.append("Recycled Bitmaps: ").println(j);
        paramPrintWriter.flush();
        paramPrintWriter.close();
        AppMethodBeat.o(156092);
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
    AppMethodBeat.i(156093);
    Bitmap.Config localConfig = paramBitmap.getConfig();
    String str = CS(paramBitmap.getAllocationByteCount());
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (localConfig == null) {}
    for (paramBitmap = "UNKNOWN";; paramBitmap = localConfig.name())
    {
      paramPrintWriter.format("\nSize: %s (%d x %d, %s)\n", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), paramBitmap });
      paramPrintWriter.append("Source: ").println(parama.source);
      paramPrintWriter.format("Acquired: %d seconds ago\n", new Object[] { Long.valueOf((paramLong - parama.Icr) / 1000L) });
      paramPrintWriter.print("Stack:\n");
      a(parama.Icp, paramPrintWriter);
      paramPrintWriter.print("=======================================================\n");
      paramPrintWriter.flush();
      AppMethodBeat.o(156093);
      return;
    }
  }
  
  private static void a(StackTraceElement[] paramArrayOfStackTraceElement, PrintWriter paramPrintWriter)
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
  
  private static void ak(long paramLong, int paramInt)
  {
    AppMethodBeat.i(156086);
    a(new PrintWriter(new Writer()
    {
      private StringWriter Ico;
      
      public final void close()
      {
        AppMethodBeat.i(156083);
        flush();
        AppMethodBeat.o(156083);
      }
      
      public final void flush()
      {
        AppMethodBeat.i(156082);
        if (this.Ico == null)
        {
          AppMethodBeat.o(156082);
          return;
        }
        String str = this.Ico.toString();
        this.Ico = null;
        ad.w("MicroMsg.BitmapTracer", str);
        AppMethodBeat.o(156082);
      }
      
      public final void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(156081);
        if (this.Ico == null) {
          this.Ico = new StringWriter();
        }
        this.Ico.write(paramAnonymousArrayOfChar, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(156081);
      }
    }, false), paramLong, paramInt);
    AppMethodBeat.o(156086);
  }
  
  public static Bitmap ay(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156087);
    paramBitmap = j(paramBitmap, null);
    AppMethodBeat.o(156087);
    return paramBitmap;
  }
  
  public static void fjW()
  {
    AppMethodBeat.i(156085);
    ak(2097152L, 3);
    AppMethodBeat.o(156085);
  }
  
  public static Bitmap i(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(156088);
    paramBitmap = j(paramBitmap, paramString);
    AppMethodBeat.o(156088);
    return paramBitmap;
  }
  
  private static Bitmap j(Bitmap paramBitmap, String arg1)
  {
    AppMethodBeat.i(156089);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(156089);
      return null;
    }
    if ((paramBitmap.getAllocationByteCount() < 1048576) && (!bu.fjL()))
    {
      AppMethodBeat.o(156089);
      return paramBitmap;
    }
    a locala = new a(???);
    synchronized (Ick)
    {
      Ick.put(paramBitmap, locala);
      if ((handler != null) && (!Icl))
      {
        handler.sendEmptyMessageDelayed(0, 5000L);
        Icl = true;
      }
      AppMethodBeat.o(156089);
      return paramBitmap;
    }
  }
  
  static final class a
  {
    final StackTraceElement[] Icp;
    final BitmapFactory.Options Icq;
    final long Icr;
    final String source;
    
    a(String paramString)
    {
      AppMethodBeat.i(156084);
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      this.Icp = ((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, 4, arrayOfStackTraceElement.length));
      this.source = paramString;
      this.Icq = null;
      this.Icr = System.currentTimeMillis();
      AppMethodBeat.o(156084);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.f
 * JD-Core Version:    0.7.0.1
 */