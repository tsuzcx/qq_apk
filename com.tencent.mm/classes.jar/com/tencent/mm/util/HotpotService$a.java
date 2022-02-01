package com.tencent.mm.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

final class HotpotService$a
{
  private static final long agtk;
  private static final long agtl;
  final Handler agtm;
  private long agtn;
  private long agto;
  private int agtp;
  
  static
  {
    AppMethodBeat.i(233994);
    agtk = TimeUnit.SECONDS.toMillis(5L);
    agtl = TimeUnit.SECONDS.toMillis(20L);
    AppMethodBeat.o(233994);
  }
  
  public HotpotService$a(Looper paramLooper)
  {
    AppMethodBeat.i(233972);
    this.agtn = 0L;
    this.agto = 0L;
    this.agtp = 0;
    this.agtm = new Handler(paramLooper)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(233999);
        if (paramAnonymousMessage.what == 1) {
          HotpotService.a.a(HotpotService.a.this);
        }
        AppMethodBeat.o(233999);
      }
    };
    AppMethodBeat.o(233972);
  }
  
  /* Error */
  private boolean jJw()
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 158	java/io/BufferedReader
    //   8: dup
    //   9: new 160	java/io/FileReader
    //   12: dup
    //   13: ldc 162
    //   15: invokespecial 165	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 168	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 5
    //   23: aload 5
    //   25: invokevirtual 172	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: ldc 174
    //   30: invokevirtual 180	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore 6
    //   35: aload 6
    //   37: bipush 13
    //   39: aaload
    //   40: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   43: aload 6
    //   45: bipush 14
    //   47: aaload
    //   48: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   51: ladd
    //   52: aload 6
    //   54: bipush 15
    //   56: aaload
    //   57: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   60: ladd
    //   61: aload 6
    //   63: bipush 16
    //   65: aaload
    //   66: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: ladd
    //   70: lstore_1
    //   71: lload_1
    //   72: aload_0
    //   73: getfield 56	com/tencent/mm/util/HotpotService$a:agtn	J
    //   76: lsub
    //   77: lstore_3
    //   78: aload_0
    //   79: lload_1
    //   80: putfield 56	com/tencent/mm/util/HotpotService$a:agtn	J
    //   83: lload_3
    //   84: ldc2_w 34
    //   87: lcmp
    //   88: ifle +33 -> 121
    //   91: ldc 81
    //   93: ldc 188
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: lload_3
    //   102: invokestatic 191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   105: aastore
    //   106: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload 5
    //   111: invokevirtual 194	java/io/BufferedReader:close	()V
    //   114: ldc 156
    //   116: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: iconst_1
    //   120: ireturn
    //   121: ldc 81
    //   123: ldc 196
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: lload_3
    //   132: invokestatic 191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: aastore
    //   136: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload 5
    //   141: invokevirtual 194	java/io/BufferedReader:close	()V
    //   144: ldc 156
    //   146: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore 6
    //   153: aload 5
    //   155: invokevirtual 194	java/io/BufferedReader:close	()V
    //   158: ldc 156
    //   160: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 6
    //   165: athrow
    //   166: astore 5
    //   168: ldc 81
    //   170: aload 5
    //   172: ldc 200
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: ldc 156
    //   183: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: iconst_1
    //   187: ireturn
    //   188: astore 5
    //   190: aload 6
    //   192: aload 5
    //   194: invokevirtual 210	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   197: goto -39 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	a
    //   70	10	1	l1	long
    //   77	55	3	l2	long
    //   21	133	5	localBufferedReader	java.io.BufferedReader
    //   166	5	5	localThrowable1	java.lang.Throwable
    //   188	5	5	localThrowable2	java.lang.Throwable
    //   33	29	6	arrayOfString	java.lang.String[]
    //   151	40	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	83	151	finally
    //   91	109	151	finally
    //   121	139	151	finally
    //   5	23	166	finally
    //   109	114	166	finally
    //   139	144	166	finally
    //   158	166	166	finally
    //   190	197	166	finally
    //   153	158	188	finally
  }
  
  /* Error */
  private boolean jJx()
  {
    // Byte code:
    //   0: ldc 211
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 158	java/io/BufferedReader
    //   8: dup
    //   9: new 160	java/io/FileReader
    //   12: dup
    //   13: ldc 213
    //   15: invokespecial 165	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 168	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 5
    //   23: aload 5
    //   25: invokevirtual 172	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: pop
    //   29: aload 5
    //   31: invokevirtual 172	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: pop
    //   35: aload 5
    //   37: invokevirtual 172	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 6
    //   42: aload 5
    //   44: invokevirtual 172	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 7
    //   49: aload 6
    //   51: ldc 215
    //   53: invokevirtual 180	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   56: iconst_1
    //   57: aaload
    //   58: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   61: lstore_1
    //   62: aload 7
    //   64: ldc 215
    //   66: invokevirtual 180	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   69: iconst_1
    //   70: aaload
    //   71: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: lload_1
    //   75: ladd
    //   76: lstore_1
    //   77: lload_1
    //   78: aload_0
    //   79: getfield 58	com/tencent/mm/util/HotpotService$a:agto	J
    //   82: lsub
    //   83: lstore_3
    //   84: aload_0
    //   85: lload_1
    //   86: putfield 58	com/tencent/mm/util/HotpotService$a:agto	J
    //   89: lload_3
    //   90: ldc2_w 42
    //   93: lcmp
    //   94: ifle +33 -> 127
    //   97: ldc 81
    //   99: ldc 217
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: lload_3
    //   108: invokestatic 191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: aastore
    //   112: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload 5
    //   117: invokevirtual 194	java/io/BufferedReader:close	()V
    //   120: ldc 211
    //   122: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_1
    //   126: ireturn
    //   127: ldc 81
    //   129: ldc 219
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: lload_3
    //   138: invokestatic 191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: aastore
    //   142: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload 5
    //   147: invokevirtual 194	java/io/BufferedReader:close	()V
    //   150: ldc 211
    //   152: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore 6
    //   159: aload 5
    //   161: invokevirtual 194	java/io/BufferedReader:close	()V
    //   164: ldc 211
    //   166: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload 6
    //   171: athrow
    //   172: astore 5
    //   174: ldc 81
    //   176: aload 5
    //   178: ldc 221
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: ldc 211
    //   189: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: iconst_1
    //   193: ireturn
    //   194: astore 5
    //   196: aload 6
    //   198: aload 5
    //   200: invokevirtual 210	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   203: goto -39 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	a
    //   61	25	1	l1	long
    //   83	55	3	l2	long
    //   21	139	5	localBufferedReader	java.io.BufferedReader
    //   172	5	5	localThrowable1	java.lang.Throwable
    //   194	5	5	localThrowable2	java.lang.Throwable
    //   40	10	6	str1	java.lang.String
    //   157	40	6	localObject	Object
    //   47	16	7	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   23	89	157	finally
    //   97	115	157	finally
    //   127	145	157	finally
    //   5	23	172	finally
    //   115	120	172	finally
    //   145	150	172	finally
    //   164	172	172	finally
    //   196	203	172	finally
    //   159	164	194	finally
  }
  
  public final void jJy()
  {
    AppMethodBeat.i(234000);
    this.agtm.sendEmptyMessageDelayed(1, agtk);
    AppMethodBeat.o(234000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.HotpotService.a
 * JD-Core Version:    0.7.0.1
 */