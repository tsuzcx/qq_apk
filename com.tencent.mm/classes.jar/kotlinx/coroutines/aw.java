package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.internal.u;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "UNDEFINED$annotations", "executeUnconfined", "", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "kotlinx-coroutines-core"})
public final class aw
{
  private static final u TUo;
  public static final u TUp;
  
  static
  {
    AppMethodBeat.i(192384);
    TUo = new u("UNDEFINED");
    TUp = new u("REUSABLE_CLAIMED");
    AppMethodBeat.o(192384);
  }
  
  /* Error */
  public static final <T> void a(kotlin.d.d<? super T> paramd, Object paramObject)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: instanceof 67
    //   9: ifeq +310 -> 319
    //   12: aload_0
    //   13: checkcast 67	kotlinx/coroutines/av
    //   16: astore 4
    //   18: aload_1
    //   19: invokestatic 73	kotlinx/coroutines/w:fQ	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore 5
    //   24: aload 4
    //   26: getfield 77	kotlinx/coroutines/av:TUm	Lkotlinx/coroutines/ad;
    //   29: astore_0
    //   30: aload 4
    //   32: invokevirtual 81	kotlinx/coroutines/av:getContext	()Lkotlin/d/f;
    //   35: pop
    //   36: aload_0
    //   37: invokevirtual 87	kotlinx/coroutines/ad:hMH	()Z
    //   40: ifeq +40 -> 80
    //   43: aload 4
    //   45: aload 5
    //   47: putfield 91	kotlinx/coroutines/av:_state	Ljava/lang/Object;
    //   50: aload 4
    //   52: iconst_1
    //   53: putfield 95	kotlinx/coroutines/av:TUq	I
    //   56: aload 4
    //   58: getfield 77	kotlinx/coroutines/av:TUm	Lkotlinx/coroutines/ad;
    //   61: aload 4
    //   63: invokevirtual 81	kotlinx/coroutines/av:getContext	()Lkotlin/d/f;
    //   66: aload 4
    //   68: checkcast 97	java/lang/Runnable
    //   71: invokevirtual 100	kotlinx/coroutines/ad:a	(Lkotlin/d/f;Ljava/lang/Runnable;)V
    //   74: ldc 65
    //   76: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: return
    //   80: getstatic 106	kotlinx/coroutines/cp:TVk	Lkotlinx/coroutines/cp;
    //   83: astore_0
    //   84: invokestatic 110	kotlinx/coroutines/cp:hNz	()Lkotlinx/coroutines/bg;
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 115	kotlinx/coroutines/bg:hNb	()Z
    //   92: ifeq +31 -> 123
    //   95: aload 4
    //   97: aload 5
    //   99: putfield 91	kotlinx/coroutines/av:_state	Ljava/lang/Object;
    //   102: aload 4
    //   104: iconst_1
    //   105: putfield 95	kotlinx/coroutines/av:TUq	I
    //   108: aload_0
    //   109: aload 4
    //   111: checkcast 117	kotlinx/coroutines/ay
    //   114: invokevirtual 121	kotlinx/coroutines/bg:b	(Lkotlinx/coroutines/ay;)V
    //   117: ldc 65
    //   119: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: aload 4
    //   125: checkcast 117	kotlinx/coroutines/ay
    //   128: astore 5
    //   130: aload_0
    //   131: iconst_1
    //   132: invokevirtual 125	kotlinx/coroutines/bg:EX	(Z)V
    //   135: aload 4
    //   137: invokevirtual 81	kotlinx/coroutines/av:getContext	()Lkotlin/d/f;
    //   140: getstatic 131	kotlinx/coroutines/bu:TUO	Lkotlinx/coroutines/bu$b;
    //   143: checkcast 133	kotlin/d/f$c
    //   146: invokeinterface 139 2 0
    //   151: checkcast 127	kotlinx/coroutines/bu
    //   154: astore 6
    //   156: aload 6
    //   158: ifnull +111 -> 269
    //   161: aload 6
    //   163: invokeinterface 142 1 0
    //   168: ifne +101 -> 269
    //   171: aload 6
    //   173: invokeinterface 146 1 0
    //   178: checkcast 64	java/lang/Throwable
    //   181: astore 6
    //   183: getstatic 152	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   186: astore 7
    //   188: aload 4
    //   190: aload 6
    //   192: invokestatic 158	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   195: invokestatic 161	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: invokeinterface 167 2 0
    //   203: iconst_1
    //   204: istore_2
    //   205: iload_2
    //   206: ifne +44 -> 250
    //   209: aload 4
    //   211: invokevirtual 81	kotlinx/coroutines/av:getContext	()Lkotlin/d/f;
    //   214: astore 6
    //   216: aload 6
    //   218: aload 4
    //   220: getfield 170	kotlinx/coroutines/av:TUk	Ljava/lang/Object;
    //   223: invokestatic 175	kotlinx/coroutines/internal/y:a	(Lkotlin/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   226: astore 7
    //   228: aload 4
    //   230: getfield 179	kotlinx/coroutines/av:TUn	Lkotlin/d/d;
    //   233: aload_1
    //   234: invokeinterface 167 2 0
    //   239: getstatic 185	kotlin/x:SXb	Lkotlin/x;
    //   242: astore_1
    //   243: aload 6
    //   245: aload 7
    //   247: invokestatic 188	kotlinx/coroutines/internal/y:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   250: aload_0
    //   251: invokevirtual 191	kotlinx/coroutines/bg:hNa	()Z
    //   254: istore_3
    //   255: iload_3
    //   256: ifne -6 -> 250
    //   259: aload_0
    //   260: invokevirtual 194	kotlinx/coroutines/bg:hNd	()V
    //   263: ldc 65
    //   265: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: return
    //   269: iconst_0
    //   270: istore_2
    //   271: goto -66 -> 205
    //   274: astore_1
    //   275: aload 6
    //   277: aload 7
    //   279: invokestatic 188	kotlinx/coroutines/internal/y:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   282: ldc 65
    //   284: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aload_1
    //   288: athrow
    //   289: astore_1
    //   290: aload 5
    //   292: aload_1
    //   293: aconst_null
    //   294: invokevirtual 198	kotlinx/coroutines/ay:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   297: aload_0
    //   298: invokevirtual 194	kotlinx/coroutines/bg:hNd	()V
    //   301: ldc 65
    //   303: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: return
    //   307: astore_1
    //   308: aload_0
    //   309: invokevirtual 194	kotlinx/coroutines/bg:hNd	()V
    //   312: ldc 65
    //   314: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload_1
    //   318: athrow
    //   319: aload_0
    //   320: aload_1
    //   321: invokeinterface 167 2 0
    //   326: ldc 65
    //   328: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramd	kotlin.d.d<? super T>
    //   0	332	1	paramObject	Object
    //   204	67	2	i	int
    //   254	2	3	bool	boolean
    //   16	213	4	localav	av
    //   22	269	5	localObject1	Object
    //   154	122	6	localObject2	Object
    //   186	92	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   228	243	274	finally
    //   135	156	289	java/lang/Throwable
    //   161	203	289	java/lang/Throwable
    //   209	228	289	java/lang/Throwable
    //   243	250	289	java/lang/Throwable
    //   250	255	289	java/lang/Throwable
    //   275	289	289	java/lang/Throwable
    //   135	156	307	finally
    //   161	203	307	finally
    //   209	228	307	finally
    //   243	250	307	finally
    //   250	255	307	finally
    //   275	289	307	finally
    //   290	297	307	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.aw
 * JD-Core Version:    0.7.0.1
 */