package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public final class a
{
  private static String filename;
  private static Object lock;
  private a Ozo = null;
  private int Ozp = 0;
  private int Ozq = 1;
  private int Ozr = 2;
  private int Ozs = 3;
  
  static
  {
    AppMethodBeat.i(143784);
    filename = "heavy_user_id_mapping.dat";
    lock = new Object();
    AppMethodBeat.o(143784);
  }
  
  public static int ahs(int paramInt)
  {
    AppMethodBeat.i(143783);
    Log.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:".concat(String.valueOf(paramInt)));
    czq localczq = gNN();
    if (localczq == null)
    {
      AppMethodBeat.o(143783);
      return 0;
    }
    paramInt = localczq.aaEW;
    Log.i("MicroMsg.HeavyUserIDMappingStg", "version:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(143783);
    return paramInt;
  }
  
  public static czq gNN()
  {
    AppMethodBeat.i(143782);
    Log.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
    synchronized (lock)
    {
      byte[] arrayOfByte1 = y.bi(at.acHq + filename, 0, -1);
      if (arrayOfByte1 == null)
      {
        Log.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
        AppMethodBeat.o(143782);
        return null;
      }
    }
    ??? = new czq();
    try
    {
      ((czq)???).parseFrom(arrayOfByte2);
      Log.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + ((czq)???).aaEW + ", ret:" + ((czq)???).aaEY + ", size: " + ((czq)???).aaEX.size());
      AppMethodBeat.o(143782);
      return ???;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", localThrowable, "", new Object[0]);
      AppMethodBeat.o(143782);
    }
    return null;
  }
  
  /* Error */
  public final void a(czq paramczq, int paramInt)
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 55
    //   7: ldc 158
    //   9: iload_2
    //   10: invokestatic 63	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   13: invokevirtual 67	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnonnull +16 -> 36
    //   23: ldc 55
    //   25: ldc 160
    //   27: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 156
    //   32: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_0
    //   37: getfield 44	com/tencent/mm/plugin/report/b/a:Ozp	I
    //   40: aload_1
    //   41: getfield 134	com/tencent/mm/protocal/protobuf/czq:aaEY	I
    //   44: if_icmpeq +101 -> 145
    //   47: new 91	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 162
    //   53: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: astore 6
    //   58: aload_1
    //   59: getfield 134	com/tencent/mm/protocal/protobuf/czq:aaEY	I
    //   62: istore_2
    //   63: aload_0
    //   64: getfield 46	com/tencent/mm/plugin/report/b/a:Ozq	I
    //   67: iload_2
    //   68: if_icmpne +40 -> 108
    //   71: ldc 164
    //   73: astore 5
    //   75: ldc 55
    //   77: aload 6
    //   79: aload 5
    //   81: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 166
    //   86: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: getfield 82	com/tencent/mm/protocal/protobuf/czq:aaEW	I
    //   93: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: ldc 156
    //   104: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: aload_0
    //   109: getfield 48	com/tencent/mm/plugin/report/b/a:Ozr	I
    //   112: iload_2
    //   113: if_icmpne +10 -> 123
    //   116: ldc 171
    //   118: astore 5
    //   120: goto -45 -> 75
    //   123: aload_0
    //   124: getfield 50	com/tencent/mm/plugin/report/b/a:Ozs	I
    //   127: iload_2
    //   128: if_icmpne +10 -> 138
    //   131: ldc 173
    //   133: astore 5
    //   135: goto -60 -> 75
    //   138: ldc 175
    //   140: astore 5
    //   142: goto -67 -> 75
    //   145: iload_2
    //   146: invokestatic 177	com/tencent/mm/plugin/report/b/a:ahs	(I)I
    //   149: istore_3
    //   150: aload_1
    //   151: getfield 82	com/tencent/mm/protocal/protobuf/czq:aaEW	I
    //   154: istore 4
    //   156: iload_3
    //   157: iload 4
    //   159: if_icmpne +24 -> 183
    //   162: ldc 55
    //   164: ldc 179
    //   166: iload 4
    //   168: invokestatic 63	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   171: invokevirtual 67	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   174: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: ldc 156
    //   179: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: ldc 55
    //   185: new 91	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 181
    //   191: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: iload_2
    //   195: invokestatic 177	com/tencent/mm/plugin/report/b/a:ahs	(I)I
    //   198: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc 183
    //   203: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload 4
    //   208: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: ldc 55
    //   219: new 91	java/lang/StringBuilder
    //   222: dup
    //   223: ldc 126
    //   225: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload_1
    //   229: getfield 82	com/tencent/mm/protocal/protobuf/czq:aaEW	I
    //   232: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: ldc 131
    //   237: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_1
    //   241: getfield 134	com/tencent/mm/protocal/protobuf/czq:aaEY	I
    //   244: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc 136
    //   249: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: getfield 140	com/tencent/mm/protocal/protobuf/czq:aaEX	Ljava/util/LinkedList;
    //   256: invokevirtual 146	java/util/LinkedList:size	()I
    //   259: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_1
    //   269: invokevirtual 187	com/tencent/mm/protocal/protobuf/czq:toByteArray	()[B
    //   272: astore 6
    //   274: getstatic 36	com/tencent/mm/plugin/report/b/a:lock	Ljava/lang/Object;
    //   277: astore 5
    //   279: aload 5
    //   281: monitorenter
    //   282: ldc 55
    //   284: new 91	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 189
    //   290: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload_1
    //   294: getfield 82	com/tencent/mm/protocal/protobuf/czq:aaEW	I
    //   297: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: new 91	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   313: getstatic 97	com/tencent/mm/storage/at:acHq	Ljava/lang/String;
    //   316: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: getstatic 31	com/tencent/mm/plugin/report/b/a:filename	Ljava/lang/String;
    //   322: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aload 6
    //   330: aload 6
    //   332: arraylength
    //   333: invokestatic 192	com/tencent/mm/vfs/y:e	(Ljava/lang/String;[BI)I
    //   336: pop
    //   337: aload 5
    //   339: monitorexit
    //   340: ldc 156
    //   342: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: return
    //   346: astore_1
    //   347: ldc 55
    //   349: aload_1
    //   350: ldc 148
    //   352: iconst_0
    //   353: anewarray 4	java/lang/Object
    //   356: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: ldc 156
    //   361: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: return
    //   365: astore_1
    //   366: aload 5
    //   368: monitorexit
    //   369: ldc 156
    //   371: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload_1
    //   375: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	a
    //   0	376	1	paramczq	czq
    //   0	376	2	paramInt	int
    //   149	11	3	i	int
    //   154	53	4	j	int
    //   56	275	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   268	274	346	java/io/IOException
    //   282	340	365	finally
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.a
 * JD-Core Version:    0.7.0.1
 */