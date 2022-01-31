package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class h
{
  private static volatile h vyH = null;
  private q vyI = null;
  
  /* Error */
  private static byte[] b(q paramq)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: sipush 26784
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnonnull +11 -> 21
    //   13: sipush 26784
    //   16: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 33	java/io/ByteArrayOutputStream
    //   24: dup
    //   25: invokespecial 34	java/io/ByteArrayOutputStream:<init>	()V
    //   28: astore_1
    //   29: new 36	java/io/ObjectOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 39	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   37: astore 5
    //   39: aload 5
    //   41: astore_3
    //   42: aload_1
    //   43: astore_2
    //   44: aload 5
    //   46: aload_0
    //   47: invokevirtual 43	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   50: aload 5
    //   52: astore_3
    //   53: aload_1
    //   54: astore_2
    //   55: aload 5
    //   57: invokevirtual 46	java/io/ObjectOutputStream:flush	()V
    //   60: aload 5
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload_1
    //   66: invokevirtual 50	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   69: astore_0
    //   70: aload 5
    //   72: invokevirtual 53	java/io/ObjectOutputStream:close	()V
    //   75: aload_1
    //   76: invokevirtual 54	java/io/ByteArrayOutputStream:close	()V
    //   79: sipush 26784
    //   82: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: ldc 56
    //   90: ldc 58
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: aastore
    //   100: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: goto -24 -> 79
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_0
    //   113: astore_3
    //   114: aload_1
    //   115: astore_2
    //   116: ldc 56
    //   118: ldc 66
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload 4
    //   128: aastore
    //   129: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_0
    //   133: ifnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 53	java/io/ObjectOutputStream:close	()V
    //   140: aload 6
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull -65 -> 79
    //   147: aload_1
    //   148: invokevirtual 54	java/io/ByteArrayOutputStream:close	()V
    //   151: aload 6
    //   153: astore_0
    //   154: goto -75 -> 79
    //   157: astore_0
    //   158: ldc 56
    //   160: ldc 58
    //   162: iconst_1
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_0
    //   169: aastore
    //   170: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload 6
    //   175: astore_0
    //   176: goto -97 -> 79
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_3
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_3
    //   185: ifnull +7 -> 192
    //   188: aload_3
    //   189: invokevirtual 53	java/io/ObjectOutputStream:close	()V
    //   192: aload_1
    //   193: ifnull +7 -> 200
    //   196: aload_1
    //   197: invokevirtual 54	java/io/ByteArrayOutputStream:close	()V
    //   200: sipush 26784
    //   203: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_0
    //   207: athrow
    //   208: astore_1
    //   209: ldc 56
    //   211: ldc 58
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload_1
    //   220: aastore
    //   221: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: goto -24 -> 200
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_3
    //   230: goto -46 -> 184
    //   233: astore_0
    //   234: aload_2
    //   235: astore_1
    //   236: goto -52 -> 184
    //   239: astore 4
    //   241: aconst_null
    //   242: astore_0
    //   243: goto -131 -> 112
    //   246: astore 4
    //   248: aload 5
    //   250: astore_0
    //   251: goto -139 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramq	q
    //   28	48	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   87	12	1	localException1	java.lang.Exception
    //   111	86	1	localObject1	Object
    //   208	12	1	localException2	java.lang.Exception
    //   235	1	1	localObject2	Object
    //   43	192	2	localObject3	Object
    //   41	189	3	localObject4	Object
    //   106	21	4	localException3	java.lang.Exception
    //   239	1	4	localException4	java.lang.Exception
    //   246	1	4	localException5	java.lang.Exception
    //   37	212	5	localObjectOutputStream	java.io.ObjectOutputStream
    //   1	173	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   70	79	87	java/lang/Exception
    //   21	29	106	java/lang/Exception
    //   136	140	157	java/lang/Exception
    //   147	151	157	java/lang/Exception
    //   21	29	179	finally
    //   188	192	208	java/lang/Exception
    //   196	200	208	java/lang/Exception
    //   29	39	227	finally
    //   44	50	233	finally
    //   55	60	233	finally
    //   65	70	233	finally
    //   116	132	233	finally
    //   29	39	239	java/lang/Exception
    //   44	50	246	java/lang/Exception
    //   55	60	246	java/lang/Exception
    //   65	70	246	java/lang/Exception
  }
  
  /* Error */
  private static q bI(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 26783
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +8 -> 15
    //   10: aload_0
    //   11: arraylength
    //   12: ifgt +11 -> 23
    //   15: sipush 26783
    //   18: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 70	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 73	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: astore_1
    //   32: new 75	java/io/ObjectInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 78	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_0
    //   41: aload_0
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: aload_0
    //   46: invokevirtual 82	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   49: checkcast 84	com/tencent/mm/plugin/wenote/model/a/q
    //   52: astore 4
    //   54: aload_0
    //   55: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   58: aload_1
    //   59: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   62: aload 4
    //   64: astore_0
    //   65: sipush 26783
    //   68: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_0
    //   72: areturn
    //   73: astore_0
    //   74: ldc 56
    //   76: ldc 88
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: aastore
    //   86: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload 4
    //   91: astore_0
    //   92: goto -27 -> 65
    //   95: astore 4
    //   97: aconst_null
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_0
    //   102: astore_3
    //   103: aload_1
    //   104: astore_2
    //   105: ldc 56
    //   107: ldc 90
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload 4
    //   117: aastore
    //   118: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   137: aconst_null
    //   138: astore_0
    //   139: goto -74 -> 65
    //   142: astore_0
    //   143: ldc 56
    //   145: ldc 88
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_0
    //   154: aastore
    //   155: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: aconst_null
    //   159: astore_0
    //   160: goto -95 -> 65
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_3
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 85	java/io/ObjectInputStream:close	()V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   184: sipush 26783
    //   187: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_0
    //   191: athrow
    //   192: astore_1
    //   193: ldc 56
    //   195: ldc 88
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_1
    //   204: aastore
    //   205: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: goto -24 -> 184
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_3
    //   214: goto -46 -> 168
    //   217: astore_0
    //   218: aload_2
    //   219: astore_1
    //   220: goto -52 -> 168
    //   223: astore 4
    //   225: aconst_null
    //   226: astore_0
    //   227: goto -126 -> 101
    //   230: astore 4
    //   232: goto -131 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramArrayOfByte	byte[]
    //   31	150	1	localByteArrayInputStream1	java.io.ByteArrayInputStream
    //   192	12	1	localException1	java.lang.Exception
    //   219	1	1	localObject	Object
    //   44	175	2	localByteArrayInputStream2	java.io.ByteArrayInputStream
    //   42	172	3	arrayOfByte	byte[]
    //   52	38	4	localq	q
    //   95	21	4	localException2	java.lang.Exception
    //   223	1	4	localException3	java.lang.Exception
    //   230	1	4	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   54	62	73	java/lang/Exception
    //   23	32	95	java/lang/Exception
    //   125	129	142	java/lang/Exception
    //   133	137	142	java/lang/Exception
    //   23	32	163	finally
    //   172	176	192	java/lang/Exception
    //   180	184	192	java/lang/Exception
    //   32	41	211	finally
    //   45	54	217	finally
    //   105	121	217	finally
    //   32	41	223	java/lang/Exception
    //   45	54	230	java/lang/Exception
  }
  
  public static h diI()
  {
    AppMethodBeat.i(26780);
    if (vyH == null) {}
    try
    {
      if (vyH == null) {
        vyH = new h();
      }
      h localh = vyH;
      AppMethodBeat.o(26780);
      return localh;
    }
    finally
    {
      AppMethodBeat.o(26780);
    }
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(26782);
    this.vyI = paramq;
    byte[] arrayOfByte = b(this.vyI);
    String str = "";
    paramq = str;
    if (arrayOfByte != null)
    {
      paramq = str;
      if (arrayOfByte.length > 0) {
        paramq = bo.cg(arrayOfByte);
      }
    }
    if (this.vyI != null) {}
    for (str = this.vyI.dhS();; str = "null")
    {
      ab.i("WNNoteKeepTopManager", "setCurrentTopItem item: %s", new Object[] { str });
      ab.i("WNNoteKeepTopManager", "setCurrentTopItem itemStr: %s", new Object[] { paramq });
      aw.aaz();
      c.Ru().set(ac.a.yGF, bo.nullAsNil(paramq));
      AppMethodBeat.o(26782);
      return;
    }
  }
  
  public final q diJ()
  {
    AppMethodBeat.i(26781);
    if (this.vyI != null)
    {
      localObject = this.vyI;
      AppMethodBeat.o(26781);
      return localObject;
    }
    aw.aaz();
    Object localObject = (String)c.Ru().get(ac.a.yGF, "");
    ab.d("WNNoteKeepTopManager", "getCurrentTopItem itemStr: %s", new Object[] { localObject });
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(26781);
      return null;
    }
    localObject = bo.apQ((String)localObject);
    if (localObject.length <= 0)
    {
      AppMethodBeat.o(26781);
      return null;
    }
    this.vyI = bI((byte[])localObject);
    if (this.vyI != null) {}
    for (localObject = this.vyI.dhS();; localObject = "null")
    {
      ab.d("WNNoteKeepTopManager", "getCurrentTopItem item: %s", new Object[] { localObject });
      localObject = this.vyI;
      AppMethodBeat.o(26781);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.h
 * JD-Core Version:    0.7.0.1
 */