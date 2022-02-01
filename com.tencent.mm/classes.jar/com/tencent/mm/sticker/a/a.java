package com.tencent.mm.sticker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/model/LensInfoMemCache;", "", "()V", "Expired", "", "TAG", "", "infoMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invalidList", "get", "lensId", "isInvalid", "", "markInvalid", "", "remove", "update", "info", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a acCZ;
  private static final c<String, r<dhp, Long>> acDa;
  private static final c<String, Long> acDb;
  
  static
  {
    AppMethodBeat.i(105959);
    acCZ = new a();
    TAG = "MicroMsg.LensInfoMemCache";
    acDa = new c(100);
    acDb = new c(100);
    AppMethodBeat.o(105959);
  }
  
  /* Error */
  public final dhp buW(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 73
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 74
    //   10: invokestatic 80	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 63	com/tencent/mm/sticker/a/a:acDa	Lcom/tencent/mm/memory/a/c;
    //   16: aload_1
    //   17: invokevirtual 83	com/tencent/mm/memory/a/c:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 85	kotlin/r
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +14 -> 39
    //   28: ldc 73
    //   30: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aload_2
    //   40: getfield 89	kotlin/r:bsD	Ljava/lang/Object;
    //   43: checkcast 91	java/lang/Number
    //   46: invokevirtual 95	java/lang/Number:longValue	()J
    //   49: invokestatic 101	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   52: ldc2_w 102
    //   55: lcmp
    //   56: ifle +61 -> 117
    //   59: getstatic 63	com/tencent/mm/sticker/a/a:acDa	Lcom/tencent/mm/memory/a/c;
    //   62: aload_1
    //   63: invokevirtual 105	com/tencent/mm/memory/a/c:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: getstatic 57	com/tencent/mm/sticker/a/a:TAG	Ljava/lang/String;
    //   70: new 107	java/lang/StringBuilder
    //   73: dup
    //   74: ldc 109
    //   76: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_1
    //   80: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 118
    //   85: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_2
    //   89: getfield 89	kotlin/r:bsD	Ljava/lang/Object;
    //   92: checkcast 91	java/lang/Number
    //   95: invokevirtual 95	java/lang/Number:longValue	()J
    //   98: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   101: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: ldc 73
    //   109: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -79 -> 35
    //   117: getstatic 57	com/tencent/mm/sticker/a/a:TAG	Ljava/lang/String;
    //   120: new 107	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 132
    //   126: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload_1
    //   130: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 118
    //   135: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: getfield 89	kotlin/r:bsD	Ljava/lang/Object;
    //   142: checkcast 91	java/lang/Number
    //   145: invokevirtual 95	java/lang/Number:longValue	()J
    //   148: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   151: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_2
    //   158: getfield 135	kotlin/r:bsC	Ljava/lang/Object;
    //   161: checkcast 137	com/tencent/mm/protocal/protobuf/dhp
    //   164: astore_1
    //   165: ldc 73
    //   167: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: goto -135 -> 35
    //   173: astore_1
    //   174: aload_0
    //   175: monitorexit
    //   176: aload_1
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	a
    //   0	178	1	paramString	String
    //   23	135	2	localr	r
    // Exception table:
    //   from	to	target	type
    //   2	24	173	finally
    //   28	33	173	finally
    //   39	112	173	finally
    //   117	170	173	finally
  }
  
  /* Error */
  public final boolean buX(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 140
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 74
    //   10: invokestatic 80	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 65	com/tencent/mm/sticker/a/a:acDb	Lcom/tencent/mm/memory/a/c;
    //   16: aload_1
    //   17: invokevirtual 83	com/tencent/mm/memory/a/c:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 142	java/lang/Long
    //   23: astore 5
    //   25: aload 5
    //   27: ifnonnull +14 -> 41
    //   30: ldc 140
    //   32: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: istore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_2
    //   40: ireturn
    //   41: aload 5
    //   43: invokevirtual 143	java/lang/Long:longValue	()J
    //   46: lstore_3
    //   47: lload_3
    //   48: invokestatic 101	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   51: ldc2_w 102
    //   54: lcmp
    //   55: ifle +52 -> 107
    //   58: getstatic 65	com/tencent/mm/sticker/a/a:acDb	Lcom/tencent/mm/memory/a/c;
    //   61: aload_1
    //   62: invokevirtual 105	com/tencent/mm/memory/a/c:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: getstatic 57	com/tencent/mm/sticker/a/a:TAG	Ljava/lang/String;
    //   69: new 107	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 145
    //   75: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_1
    //   79: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 118
    //   84: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: lload_3
    //   88: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: ldc 140
    //   99: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iconst_0
    //   103: istore_2
    //   104: goto -67 -> 37
    //   107: getstatic 57	com/tencent/mm/sticker/a/a:TAG	Ljava/lang/String;
    //   110: new 107	java/lang/StringBuilder
    //   113: dup
    //   114: ldc 147
    //   116: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   119: aload_1
    //   120: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 149
    //   125: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: iconst_1
    //   135: istore_2
    //   136: ldc 140
    //   138: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: goto -104 -> 37
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	a
    //   0	149	1	paramString	String
    //   36	100	2	bool	boolean
    //   46	42	3	l	long
    //   23	19	5	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   2	25	144	finally
    //   30	35	144	finally
    //   41	102	144	finally
    //   107	134	144	finally
    //   136	141	144	finally
  }
  
  public final void buY(String paramString)
  {
    try
    {
      AppMethodBeat.i(105958);
      s.u(paramString, "lensId");
      long l = Util.currentTicks();
      Log.i(TAG, "markInvalid: " + paramString + ", " + l);
      acDb.put(paramString, Long.valueOf(l));
      AppMethodBeat.o(105958);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void e(dhp paramdhp)
  {
    try
    {
      AppMethodBeat.i(105955);
      s.u(paramdhp, "info");
      long l = Util.currentTicks();
      r localr2 = (r)acDa.get(paramdhp.LensId);
      r localr1 = localr2;
      if (localr2 == null) {
        localr1 = new r(paramdhp, Long.valueOf(l));
      }
      acDa.put(paramdhp.LensId, localr1);
      Log.i(TAG, "update: " + paramdhp.LensId + ", " + l);
      AppMethodBeat.o(105955);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sticker.a.a
 * JD-Core Version:    0.7.0.1
 */