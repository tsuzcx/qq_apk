package com.tencent.mm.plugin.recordvideo.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/RemuxCheckThirdPartyVideo;", "", "()V", "TAG", "", "checkThirdPartyVideo", "Lcom/tencent/mm/plugin/recordvideo/util/RemuxCheckThirdPartyVideo$Result;", "videoPath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Result", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j ObG;
  
  static
  {
    AppMethodBeat.i(279521);
    ObG = new j();
    AppMethodBeat.o(279521);
  }
  
  public static Object o(String paramString, d<? super j.a> paramd)
  {
    AppMethodBeat.i(279515);
    paramString = l.a((f)bg.kCi(), (m)new b(paramString, null), paramd);
    AppMethodBeat.o(279515);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/util/RemuxCheckThirdPartyVideo$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super j.a>, Object>
  {
    int label;
    
    b(String paramString, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(279527);
      paramObject = (d)new b(this.obz, paramd);
      AppMethodBeat.o(279527);
      return paramObject;
    }
    
    /* Error */
    public final Object invokeSuspend(Object paramObject)
    {
      // Byte code:
      //   0: ldc 76
      //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 82	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
      //   8: astore 5
      //   10: aload_0
      //   11: getfield 84	com/tencent/mm/plugin/recordvideo/util/j$b:label	I
      //   14: tableswitch	default:+22 -> 36, 0:+39->53, 1:+249->263
      //   37: nop
      //   38: sastore
      //   39: dup
      //   40: ldc 88
      //   42: invokespecial 91	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   45: astore_1
      //   46: ldc 76
      //   48: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   51: aload_1
      //   52: athrow
      //   53: aload_1
      //   54: invokestatic 97	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   57: aload_0
      //   58: getfield 34	com/tencent/mm/plugin/recordvideo/util/j$b:obz	Ljava/lang/String;
      //   61: invokestatic 103	com/tencent/mm/plugin/sight/base/SightVideoJNI:getVideoMetaData	(Ljava/lang/String;)Ljava/lang/String;
      //   64: astore_1
      //   65: aload_1
      //   66: checkcast 105	java/lang/CharSequence
      //   69: astore 4
      //   71: aload 4
      //   73: ifnull +13 -> 86
      //   76: aload 4
      //   78: invokeinterface 109 1 0
      //   83: ifne +16 -> 99
      //   86: iconst_1
      //   87: istore_2
      //   88: iload_2
      //   89: ifeq +15 -> 104
      //   92: ldc 76
      //   94: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: aconst_null
      //   98: areturn
      //   99: iconst_0
      //   100: istore_2
      //   101: goto -13 -> 88
      //   104: new 111	org/json/JSONObject
      //   107: dup
      //   108: aload_1
      //   109: invokespecial 112	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   112: astore_1
      //   113: aload_1
      //   114: ldc 114
      //   116: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   119: astore_1
      //   120: aload_1
      //   121: ifnonnull +128 -> 249
      //   124: aconst_null
      //   125: astore_1
      //   126: aload_1
      //   127: ldc 119
      //   129: invokestatic 125	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   132: ifeq +175 -> 307
      //   135: invokestatic 131	com/tencent/mm/modelcdntran/k:bHX	()Lcom/tencent/mm/modelcdntran/d;
      //   138: pop
      //   139: aload_0
      //   140: getfield 34	com/tencent/mm/plugin/recordvideo/util/j$b:obz	Ljava/lang/String;
      //   143: invokestatic 136	com/tencent/mm/modelcdntran/d:Nu	(Ljava/lang/String;)Ljava/lang/String;
      //   146: astore_1
      //   147: ldc 138
      //   149: new 140	java/lang/StringBuilder
      //   152: dup
      //   153: ldc 142
      //   155: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   158: aload_1
      //   159: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   162: ldc 149
      //   164: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   167: aload_0
      //   168: getfield 34	com/tencent/mm/plugin/recordvideo/util/j$b:obz	Ljava/lang/String;
      //   171: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   177: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   180: ldc 163
      //   182: invokestatic 169	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   185: checkcast 163	com/tencent/mm/plugin/findersdk/a/cn
      //   188: invokeinterface 173 1 0
      //   193: aload_1
      //   194: invokeinterface 179 2 0
      //   199: astore_1
      //   200: aload_1
      //   201: ldc 181
      //   203: invokestatic 185	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   206: aload_0
      //   207: checkcast 53	kotlin/d/d
      //   210: astore 4
      //   212: aload_0
      //   213: iconst_1
      //   214: putfield 84	com/tencent/mm/plugin/recordvideo/util/j$b:label	I
      //   217: aload_1
      //   218: aload 4
      //   220: invokestatic 191	com/tencent/mm/af/b:a	(Lcom/tencent/mm/am/b;Lkotlin/d/d;)Ljava/lang/Object;
      //   223: astore_1
      //   224: aload_1
      //   225: astore 4
      //   227: aload_1
      //   228: aload 5
      //   230: if_acmpne +40 -> 270
      //   233: ldc 76
      //   235: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   238: aload 5
      //   240: areturn
      //   241: astore_1
      //   242: ldc 76
      //   244: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   247: aconst_null
      //   248: areturn
      //   249: aload_1
      //   250: checkcast 105	java/lang/CharSequence
      //   253: invokestatic 197	kotlin/n/n:bq	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
      //   256: invokevirtual 200	java/lang/Object:toString	()Ljava/lang/String;
      //   259: astore_1
      //   260: goto -134 -> 126
      //   263: aload_1
      //   264: invokestatic 97	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   267: aload_1
      //   268: astore 4
      //   270: aload 4
      //   272: checkcast 202	com/tencent/mm/protocal/protobuf/baj
      //   275: astore_1
      //   276: aload_1
      //   277: ifnonnull +37 -> 314
      //   280: ldc 76
      //   282: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   285: aconst_null
      //   286: areturn
      //   287: astore_1
      //   288: ldc 138
      //   290: aload_1
      //   291: checkcast 204	java/lang/Throwable
      //   294: ldc 206
      //   296: aload_1
      //   297: invokestatic 210	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   300: iconst_0
      //   301: anewarray 199	java/lang/Object
      //   304: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   307: ldc 76
      //   309: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   312: aconst_null
      //   313: areturn
      //   314: ldc 138
      //   316: new 140	java/lang/StringBuilder
      //   319: dup
      //   320: ldc 216
      //   322: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   325: aload_1
      //   326: getfield 220	com/tencent/mm/protocal/protobuf/baj:ieB	Z
      //   329: invokevirtual 223	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   332: ldc 225
      //   334: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   337: aload_1
      //   338: getfield 228	com/tencent/mm/protocal/protobuf/baj:ZLg	Ljava/lang/String;
      //   341: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   344: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   347: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   350: aload_1
      //   351: getfield 220	com/tencent/mm/protocal/protobuf/baj:ieB	Z
      //   354: istore_3
      //   355: aload_1
      //   356: getfield 228	com/tencent/mm/protocal/protobuf/baj:ZLg	Ljava/lang/String;
      //   359: astore 4
      //   361: aload 4
      //   363: astore_1
      //   364: aload 4
      //   366: ifnonnull +6 -> 372
      //   369: ldc 230
      //   371: astore_1
      //   372: new 232	com/tencent/mm/plugin/recordvideo/util/j$a
      //   375: dup
      //   376: iload_3
      //   377: aload_1
      //   378: invokespecial 235	com/tencent/mm/plugin/recordvideo/util/j$a:<init>	(ZLjava/lang/String;)V
      //   381: astore_1
      //   382: ldc 76
      //   384: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   387: aload_1
      //   388: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	389	0	this	b
      //   0	389	1	paramObject	Object
      //   87	14	2	i	int
      //   354	23	3	bool	boolean
      //   69	296	4	localObject	Object
      //   8	231	5	locala	kotlin.d.a.a
      // Exception table:
      //   from	to	target	type
      //   104	113	241	java/lang/Exception
      //   200	224	287	java/lang/Exception
      //   263	267	287	java/lang/Exception
      //   270	276	287	java/lang/Exception
      //   280	285	287	java/lang/Exception
      //   314	361	287	java/lang/Exception
      //   372	387	287	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.j
 * JD-Core Version:    0.7.0.1
 */