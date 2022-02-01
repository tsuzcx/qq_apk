package kotlinx.coroutines;

import kotlin.a;
import kotlin.d.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.b.i;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelResult", "", "state", "", "cause", "", "cancelResult$kotlinx_coroutines_core", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public abstract class ay<T>
  extends i
{
  public int TUq;
  
  public ay(int paramInt)
  {
    this.TUq = paramInt;
  }
  
  public static Throwable fT(Object paramObject)
  {
    Object localObject = null;
    if (!(paramObject instanceof v)) {
      paramObject = null;
    }
    for (;;)
    {
      v localv = (v)paramObject;
      paramObject = localObject;
      if (localv != null) {
        paramObject = localv.cause;
      }
      return paramObject;
    }
  }
  
  public void a(Object paramObject, Throwable paramThrowable) {}
  
  public final void c(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if ((paramThrowable1 == null) && (paramThrowable2 == null)) {
      return;
    }
    if ((paramThrowable1 != null) && (paramThrowable2 != null)) {
      a.a(paramThrowable1, paramThrowable2);
    }
    if (paramThrowable1 == null) {}
    for (;;)
    {
      paramThrowable1 = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
      if (paramThrowable2 == null) {
        p.hyc();
      }
      paramThrowable1 = new am(paramThrowable1, paramThrowable2);
      af.b(hMz().getContext(), (Throwable)paramThrowable1);
      return;
      paramThrowable2 = paramThrowable1;
    }
  }
  
  public <T> T fP(Object paramObject)
  {
    return paramObject;
  }
  
  public abstract Object hMt();
  
  public abstract d<T> hMz();
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 121	kotlinx/coroutines/ay:TXa	Lkotlinx/coroutines/b/j;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 98	kotlinx/coroutines/ay:hMz	()Lkotlin/d/d;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +41 -> 52
    //   14: new 123	kotlin/t
    //   17: dup
    //   18: ldc 125
    //   20: invokespecial 126	kotlin/t:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_3
    //   25: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   28: astore_1
    //   29: aload_2
    //   30: invokeinterface 137 1 0
    //   35: getstatic 143	kotlin/x:SXb	Lkotlin/x;
    //   38: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_0
    //   43: aload_3
    //   44: aload_1
    //   45: invokestatic 149	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   48: invokevirtual 151	kotlinx/coroutines/ay:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   51: return
    //   52: aload_1
    //   53: checkcast 153	kotlinx/coroutines/av
    //   56: astore_1
    //   57: aload_1
    //   58: getfield 157	kotlinx/coroutines/av:TUn	Lkotlin/d/d;
    //   61: astore 5
    //   63: aload 5
    //   65: invokeinterface 104 1 0
    //   70: astore_3
    //   71: aload_0
    //   72: invokevirtual 159	kotlinx/coroutines/ay:hMt	()Ljava/lang/Object;
    //   75: astore 6
    //   77: aload_3
    //   78: aload_1
    //   79: getfield 163	kotlinx/coroutines/av:TUk	Ljava/lang/Object;
    //   82: invokestatic 168	kotlinx/coroutines/internal/y:a	(Lkotlin/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: astore 4
    //   87: aload 6
    //   89: invokestatic 170	kotlinx/coroutines/ay:fT	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   92: astore 7
    //   94: aload_0
    //   95: getfield 48	kotlinx/coroutines/ay:TUq	I
    //   98: invokestatic 176	kotlinx/coroutines/az:avU	(I)Z
    //   101: ifeq +129 -> 230
    //   104: aload_3
    //   105: getstatic 182	kotlinx/coroutines/bu:TUO	Lkotlinx/coroutines/bu$b;
    //   108: checkcast 184	kotlin/d/f$c
    //   111: invokeinterface 190 2 0
    //   116: checkcast 178	kotlinx/coroutines/bu
    //   119: astore_1
    //   120: aload 7
    //   122: ifnonnull +129 -> 251
    //   125: aload_1
    //   126: ifnull +125 -> 251
    //   129: aload_1
    //   130: invokeinterface 194 1 0
    //   135: ifne +116 -> 251
    //   138: aload_1
    //   139: invokeinterface 198 1 0
    //   144: astore_1
    //   145: aload_0
    //   146: aload 6
    //   148: aload_1
    //   149: checkcast 106	java/lang/Throwable
    //   152: invokevirtual 200	kotlinx/coroutines/ay:a	(Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   155: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   158: astore 6
    //   160: invokestatic 205	kotlinx/coroutines/an:hML	()Z
    //   163: ifeq +11 -> 174
    //   166: aload 5
    //   168: instanceof 207
    //   171: ifne +64 -> 235
    //   174: aload_1
    //   175: checkcast 106	java/lang/Throwable
    //   178: astore_1
    //   179: aload 5
    //   181: aload_1
    //   182: invokestatic 213	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   185: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: invokeinterface 217 2 0
    //   193: getstatic 143	kotlin/x:SXb	Lkotlin/x;
    //   196: astore_1
    //   197: aload_3
    //   198: aload 4
    //   200: invokestatic 220	kotlinx/coroutines/internal/y:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   203: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   206: astore_1
    //   207: aload_2
    //   208: invokeinterface 137 1 0
    //   213: getstatic 143	kotlin/x:SXb	Lkotlin/x;
    //   216: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   219: astore_1
    //   220: aload_0
    //   221: aconst_null
    //   222: aload_1
    //   223: invokestatic 149	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   226: invokevirtual 151	kotlinx/coroutines/ay:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   229: return
    //   230: aconst_null
    //   231: astore_1
    //   232: goto -112 -> 120
    //   235: aload_1
    //   236: checkcast 106	java/lang/Throwable
    //   239: aload 5
    //   241: checkcast 207	kotlin/d/b/a/e
    //   244: invokestatic 225	kotlinx/coroutines/internal/t:a	(Ljava/lang/Throwable;Lkotlin/d/b/a/e;)Ljava/lang/Throwable;
    //   247: astore_1
    //   248: goto -69 -> 179
    //   251: aload 7
    //   253: ifnull +63 -> 316
    //   256: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   259: astore_1
    //   260: aload 5
    //   262: aload 7
    //   264: invokestatic 213	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   267: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   270: invokeinterface 217 2 0
    //   275: goto -82 -> 193
    //   278: astore_1
    //   279: aload_3
    //   280: aload 4
    //   282: invokestatic 220	kotlinx/coroutines/internal/y:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   285: aload_1
    //   286: athrow
    //   287: astore_3
    //   288: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   291: astore_1
    //   292: aload_2
    //   293: invokeinterface 137 1 0
    //   298: getstatic 143	kotlin/x:SXb	Lkotlin/x;
    //   301: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   304: astore_1
    //   305: aload_0
    //   306: aconst_null
    //   307: aload_1
    //   308: invokestatic 149	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   311: invokevirtual 151	kotlinx/coroutines/ay:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   314: aload_3
    //   315: athrow
    //   316: aload_0
    //   317: aload 6
    //   319: invokevirtual 227	kotlinx/coroutines/ay:fP	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: astore_1
    //   323: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   326: astore 6
    //   328: aload 5
    //   330: aload_1
    //   331: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   334: invokeinterface 217 2 0
    //   339: goto -146 -> 193
    //   342: astore_1
    //   343: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   346: astore_2
    //   347: aload_1
    //   348: invokestatic 213	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   351: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   354: astore_1
    //   355: goto -135 -> 220
    //   358: astore_1
    //   359: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   362: astore_2
    //   363: aload_1
    //   364: invokestatic 213	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   367: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   370: astore_1
    //   371: goto -329 -> 42
    //   374: astore_1
    //   375: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   378: astore_2
    //   379: aload_1
    //   380: invokestatic 213	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   383: invokestatic 146	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   386: astore_1
    //   387: goto -82 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	ay
    //   9	251	1	localObject1	Object
    //   278	8	1	localObject2	Object
    //   291	40	1	localObject3	Object
    //   342	6	1	localThrowable1	Throwable
    //   354	1	1	localObject4	Object
    //   358	6	1	localThrowable2	Throwable
    //   370	1	1	localObject5	Object
    //   374	6	1	localThrowable3	Throwable
    //   386	1	1	localObject6	Object
    //   4	375	2	localObject7	Object
    //   24	20	3	localThrowable4	Throwable
    //   70	210	3	localf	kotlin.d.f
    //   287	28	3	localObject8	Object
    //   85	196	4	localObject9	Object
    //   61	268	5	locald	d
    //   75	252	6	localObject10	Object
    //   92	171	7	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	10	24	java/lang/Throwable
    //   14	24	24	java/lang/Throwable
    //   52	87	24	java/lang/Throwable
    //   197	203	24	java/lang/Throwable
    //   279	287	24	java/lang/Throwable
    //   87	120	278	finally
    //   129	174	278	finally
    //   174	179	278	finally
    //   179	193	278	finally
    //   193	197	278	finally
    //   235	248	278	finally
    //   256	275	278	finally
    //   316	339	278	finally
    //   5	10	287	finally
    //   14	24	287	finally
    //   52	87	287	finally
    //   197	203	287	finally
    //   279	287	287	finally
    //   203	220	342	java/lang/Throwable
    //   25	42	358	java/lang/Throwable
    //   288	305	374	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ay
 * JD-Core Version:    0.7.0.1
 */