package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.io.IOException;
import java.util.LinkedList;

public final class a
{
  private static String filename;
  private static Object lock;
  private a qrP = null;
  private int qrQ = 0;
  private int qrR = 1;
  private int qrS = 2;
  private int qrT = 3;
  
  static
  {
    AppMethodBeat.i(72668);
    filename = "heavy_user_id_mapping.dat";
    lock = new Object();
    AppMethodBeat.o(72668);
  }
  
  public static int Cw(int paramInt)
  {
    AppMethodBeat.i(72667);
    ab.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:".concat(String.valueOf(paramInt)));
    auw localauw = chH();
    if (localauw == null)
    {
      AppMethodBeat.o(72667);
      return 0;
    }
    paramInt = localauw.xkc;
    ab.i("MicroMsg.HeavyUserIDMappingStg", "version:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(72667);
    return paramInt;
  }
  
  public static auw chH()
  {
    AppMethodBeat.i(72666);
    ab.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
    synchronized (lock)
    {
      byte[] arrayOfByte1 = e.j(ac.eQv + filename, 0, -1);
      if (arrayOfByte1 == null)
      {
        ab.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
        AppMethodBeat.o(72666);
        return null;
      }
    }
    ??? = new auw();
    try
    {
      ((auw)???).parseFrom(arrayOfByte2);
      ab.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + ((auw)???).xkc + ", ret:" + ((auw)???).xke + ", size: " + ((auw)???).xkd.size());
      AppMethodBeat.o(72666);
      return ???;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", localIOException, "", new Object[0]);
      AppMethodBeat.o(72666);
    }
    return null;
  }
  
  /* Error */
  public final void a(auw paramauw, int paramInt)
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 55
    //   7: ldc 158
    //   9: iload_2
    //   10: invokestatic 63	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   13: invokevirtual 67	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 86	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnonnull +16 -> 36
    //   23: ldc 55
    //   25: ldc 160
    //   27: invokestatic 121	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 156
    //   32: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_0
    //   37: getfield 44	com/tencent/mm/plugin/report/b/a:qrQ	I
    //   40: aload_1
    //   41: getfield 136	com/tencent/mm/protocal/protobuf/auw:xke	I
    //   44: if_icmpeq +101 -> 145
    //   47: new 93	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 162
    //   53: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: astore 6
    //   58: aload_1
    //   59: getfield 136	com/tencent/mm/protocal/protobuf/auw:xke	I
    //   62: istore_2
    //   63: aload_0
    //   64: getfield 46	com/tencent/mm/plugin/report/b/a:qrR	I
    //   67: iload_2
    //   68: if_icmpne +40 -> 108
    //   71: ldc 164
    //   73: astore 5
    //   75: ldc 55
    //   77: aload 6
    //   79: aload 5
    //   81: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 166
    //   86: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: getfield 82	com/tencent/mm/protocal/protobuf/auw:xkc	I
    //   93: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 169	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: ldc 156
    //   104: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: aload_0
    //   109: getfield 48	com/tencent/mm/plugin/report/b/a:qrS	I
    //   112: iload_2
    //   113: if_icmpne +10 -> 123
    //   116: ldc 171
    //   118: astore 5
    //   120: goto -45 -> 75
    //   123: aload_0
    //   124: getfield 50	com/tencent/mm/plugin/report/b/a:qrT	I
    //   127: iload_2
    //   128: if_icmpne +10 -> 138
    //   131: ldc 173
    //   133: astore 5
    //   135: goto -60 -> 75
    //   138: ldc 175
    //   140: astore 5
    //   142: goto -67 -> 75
    //   145: iload_2
    //   146: invokestatic 177	com/tencent/mm/plugin/report/b/a:Cw	(I)I
    //   149: istore_3
    //   150: aload_1
    //   151: getfield 82	com/tencent/mm/protocal/protobuf/auw:xkc	I
    //   154: istore 4
    //   156: iload_3
    //   157: iload 4
    //   159: if_icmpne +24 -> 183
    //   162: ldc 55
    //   164: ldc 179
    //   166: iload 4
    //   168: invokestatic 63	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   171: invokevirtual 67	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   174: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: ldc 156
    //   179: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: ldc 55
    //   185: new 93	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 181
    //   191: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: iload_2
    //   195: invokestatic 177	com/tencent/mm/plugin/report/b/a:Cw	(I)I
    //   198: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc 183
    //   203: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload 4
    //   208: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 86	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: ldc 55
    //   219: new 93	java/lang/StringBuilder
    //   222: dup
    //   223: ldc 128
    //   225: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload_1
    //   229: getfield 82	com/tencent/mm/protocal/protobuf/auw:xkc	I
    //   232: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: ldc 133
    //   237: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_1
    //   241: getfield 136	com/tencent/mm/protocal/protobuf/auw:xke	I
    //   244: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc 138
    //   249: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: getfield 142	com/tencent/mm/protocal/protobuf/auw:xkd	Ljava/util/LinkedList;
    //   256: invokevirtual 148	java/util/LinkedList:size	()I
    //   259: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 86	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_1
    //   269: invokevirtual 187	com/tencent/mm/protocal/protobuf/auw:toByteArray	()[B
    //   272: astore 6
    //   274: getstatic 36	com/tencent/mm/plugin/report/b/a:lock	Ljava/lang/Object;
    //   277: astore 5
    //   279: aload 5
    //   281: monitorenter
    //   282: ldc 55
    //   284: new 93	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 189
    //   290: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload_1
    //   294: getfield 82	com/tencent/mm/protocal/protobuf/auw:xkc	I
    //   297: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 86	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: getstatic 99	com/tencent/mm/storage/ac:eQv	Ljava/lang/String;
    //   309: getstatic 31	com/tencent/mm/plugin/report/b/a:filename	Ljava/lang/String;
    //   312: aload 6
    //   314: invokestatic 193	com/tencent/mm/a/e:b	(Ljava/lang/String;Ljava/lang/String;[B)I
    //   317: pop
    //   318: aload 5
    //   320: monitorexit
    //   321: ldc 156
    //   323: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: return
    //   327: astore_1
    //   328: ldc 55
    //   330: aload_1
    //   331: ldc 150
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: ldc 156
    //   342: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: return
    //   346: astore_1
    //   347: aload 5
    //   349: monitorexit
    //   350: ldc 156
    //   352: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: aload_1
    //   356: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	a
    //   0	357	1	paramauw	auw
    //   0	357	2	paramInt	int
    //   149	11	3	i	int
    //   154	53	4	j	int
    //   56	257	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   268	274	327	java/io/IOException
    //   282	321	346	finally
    //   347	350	346	finally
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.a
 * JD-Core Version:    0.7.0.1
 */