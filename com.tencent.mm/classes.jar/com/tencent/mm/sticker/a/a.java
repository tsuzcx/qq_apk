package com.tencent.mm.sticker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/model/LensInfoMemCache;", "", "()V", "Expired", "", "TAG", "", "infoMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invalidList", "get", "lensId", "isInvalid", "", "markInvalid", "", "remove", "update", "info", "plugin-sticker_release"})
public final class a
{
  private static final String TAG = "MicroMsg.LensInfoMemCache";
  private static final c<String, o<cqv, Long>> VbI;
  private static final c<String, Long> VbJ;
  public static final a VbK;
  
  static
  {
    AppMethodBeat.i(105959);
    VbK = new a();
    TAG = "MicroMsg.LensInfoMemCache";
    VbI = new c(100);
    VbJ = new c(100);
    AppMethodBeat.o(105959);
  }
  
  /* Error */
  public final cqv buP(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 70
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 71
    //   10: invokestatic 77	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 60	com/tencent/mm/sticker/a/a:VbI	Lcom/tencent/mm/memory/a/c;
    //   16: aload_1
    //   17: invokevirtual 80	com/tencent/mm/memory/a/c:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 82	kotlin/o
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +14 -> 39
    //   28: ldc 70
    //   30: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aload_2
    //   40: getfield 86	kotlin/o:My	Ljava/lang/Object;
    //   43: checkcast 88	java/lang/Number
    //   46: invokevirtual 92	java/lang/Number:longValue	()J
    //   49: invokestatic 98	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   52: ldc2_w 99
    //   55: lcmp
    //   56: ifle +61 -> 117
    //   59: getstatic 60	com/tencent/mm/sticker/a/a:VbI	Lcom/tencent/mm/memory/a/c;
    //   62: aload_1
    //   63: invokevirtual 102	com/tencent/mm/memory/a/c:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: getstatic 54	com/tencent/mm/sticker/a/a:TAG	Ljava/lang/String;
    //   70: new 104	java/lang/StringBuilder
    //   73: dup
    //   74: ldc 106
    //   76: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_1
    //   80: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 115
    //   85: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_2
    //   89: getfield 86	kotlin/o:My	Ljava/lang/Object;
    //   92: checkcast 88	java/lang/Number
    //   95: invokevirtual 92	java/lang/Number:longValue	()J
    //   98: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   101: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: ldc 70
    //   109: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -79 -> 35
    //   117: getstatic 54	com/tencent/mm/sticker/a/a:TAG	Ljava/lang/String;
    //   120: new 104	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 129
    //   126: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload_1
    //   130: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 115
    //   135: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: getfield 86	kotlin/o:My	Ljava/lang/Object;
    //   142: checkcast 88	java/lang/Number
    //   145: invokevirtual 92	java/lang/Number:longValue	()J
    //   148: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   151: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_2
    //   158: getfield 132	kotlin/o:Mx	Ljava/lang/Object;
    //   161: checkcast 134	com/tencent/mm/protocal/protobuf/cqv
    //   164: astore_1
    //   165: ldc 70
    //   167: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   23	135	2	localo	o
    // Exception table:
    //   from	to	target	type
    //   2	24	173	finally
    //   28	33	173	finally
    //   39	112	173	finally
    //   117	170	173	finally
  }
  
  /* Error */
  public final boolean buQ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 137
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 71
    //   10: invokestatic 77	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 62	com/tencent/mm/sticker/a/a:VbJ	Lcom/tencent/mm/memory/a/c;
    //   16: aload_1
    //   17: invokevirtual 80	com/tencent/mm/memory/a/c:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 139	java/lang/Long
    //   23: astore 5
    //   25: aload 5
    //   27: ifnull +72 -> 99
    //   30: aload 5
    //   32: invokevirtual 140	java/lang/Long:longValue	()J
    //   35: lstore_2
    //   36: lload_2
    //   37: invokestatic 98	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   40: ldc2_w 99
    //   43: lcmp
    //   44: ifle +66 -> 110
    //   47: getstatic 62	com/tencent/mm/sticker/a/a:VbJ	Lcom/tencent/mm/memory/a/c;
    //   50: aload_1
    //   51: invokevirtual 102	com/tencent/mm/memory/a/c:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: getstatic 54	com/tencent/mm/sticker/a/a:TAG	Ljava/lang/String;
    //   58: new 104	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 142
    //   64: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_1
    //   68: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 115
    //   73: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload_2
    //   77: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: ldc 137
    //   88: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iconst_0
    //   92: istore 4
    //   94: aload_0
    //   95: monitorexit
    //   96: iload 4
    //   98: ireturn
    //   99: ldc 137
    //   101: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: iconst_0
    //   105: istore 4
    //   107: goto -13 -> 94
    //   110: getstatic 54	com/tencent/mm/sticker/a/a:TAG	Ljava/lang/String;
    //   113: new 104	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 144
    //   119: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 146
    //   128: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iconst_1
    //   138: istore 4
    //   140: ldc 137
    //   142: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: goto -51 -> 94
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	a
    //   0	153	1	paramString	String
    //   35	42	2	l	long
    //   92	47	4	bool	boolean
    //   23	8	5	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   2	25	148	finally
    //   30	91	148	finally
    //   99	104	148	finally
    //   110	137	148	finally
    //   140	145	148	finally
  }
  
  public final void buR(String paramString)
  {
    try
    {
      AppMethodBeat.i(105958);
      p.k(paramString, "lensId");
      long l = Util.currentTicks();
      Log.i(TAG, "markInvalid: " + paramString + ", " + l);
      VbJ.put(paramString, Long.valueOf(l));
      AppMethodBeat.o(105958);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void e(cqv paramcqv)
  {
    try
    {
      AppMethodBeat.i(105955);
      p.k(paramcqv, "info");
      long l = Util.currentTicks();
      o localo2 = (o)VbI.get(paramcqv.LensId);
      o localo1 = localo2;
      if (localo2 == null) {
        localo1 = new o(paramcqv, Long.valueOf(l));
      }
      VbI.put(paramcqv.LensId, localo1);
      Log.i(TAG, "update: " + paramcqv.LensId + ", " + l);
      AppMethodBeat.o(105955);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.a.a
 * JD-Core Version:    0.7.0.1
 */