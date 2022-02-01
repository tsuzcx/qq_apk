package kotlinx.coroutines;

import kotlin.a;
import kotlin.d.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.d.i;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelResult", "", "state", "", "cause", "", "cancelResult$kotlinx_coroutines_core", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public abstract class ba<T>
  extends i
{
  public int abwT;
  
  public ba(int paramInt)
  {
    this.abwT = paramInt;
  }
  
  public static Throwable gc(Object paramObject)
  {
    Object localObject = null;
    if (!(paramObject instanceof x)) {
      paramObject = null;
    }
    for (;;)
    {
      x localx = (x)paramObject;
      paramObject = localObject;
      if (localx != null) {
        paramObject = localx.cause;
      }
      return paramObject;
    }
  }
  
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
        p.iCn();
      }
      paramThrowable1 = new ao(paramThrowable1, paramThrowable2);
      ah.b(iQU().getContext(), (Throwable)paramThrowable1);
      return;
      paramThrowable2 = paramThrowable1;
    }
  }
  
  public void fX(Object paramObject) {}
  
  public <T> T fZ(Object paramObject)
  {
    return paramObject;
  }
  
  public abstract Object iQO();
  
  public abstract d<T> iQU();
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	kotlinx/coroutines/ba:abAr	Lkotlinx/coroutines/d/j;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 97	kotlinx/coroutines/ba:iQU	()Lkotlin/d/d;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +41 -> 52
    //   14: new 124	kotlin/t
    //   17: dup
    //   18: ldc 126
    //   20: invokespecial 127	kotlin/t:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_3
    //   25: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   28: astore_1
    //   29: aload_2
    //   30: invokeinterface 138 1 0
    //   35: getstatic 144	kotlin/x:aazN	Lkotlin/x;
    //   38: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_0
    //   43: aload_3
    //   44: aload_1
    //   45: invokestatic 150	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   48: invokevirtual 152	kotlinx/coroutines/ba:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   51: return
    //   52: aload_1
    //   53: checkcast 154	kotlinx/coroutines/ax
    //   56: astore_1
    //   57: aload_1
    //   58: getfield 158	kotlinx/coroutines/ax:abwQ	Lkotlin/d/d;
    //   61: astore 5
    //   63: aload 5
    //   65: invokeinterface 103 1 0
    //   70: astore_3
    //   71: aload_0
    //   72: invokevirtual 160	kotlinx/coroutines/ba:iQO	()Ljava/lang/Object;
    //   75: astore 6
    //   77: aload_3
    //   78: aload_1
    //   79: getfield 164	kotlinx/coroutines/ax:abwN	Ljava/lang/Object;
    //   82: invokestatic 169	kotlinx/coroutines/internal/z:a	(Lkotlin/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: astore 4
    //   87: aload 6
    //   89: invokestatic 171	kotlinx/coroutines/ba:gc	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   92: astore 7
    //   94: aload_0
    //   95: getfield 48	kotlinx/coroutines/ba:abwT	I
    //   98: invokestatic 177	kotlinx/coroutines/bb:aFO	(I)Z
    //   101: ifeq +125 -> 226
    //   104: aload_3
    //   105: getstatic 183	kotlinx/coroutines/by:abxs	Lkotlinx/coroutines/by$b;
    //   108: checkcast 185	kotlin/d/f$c
    //   111: invokeinterface 191 2 0
    //   116: checkcast 179	kotlinx/coroutines/by
    //   119: astore_1
    //   120: aload 7
    //   122: ifnonnull +125 -> 247
    //   125: aload_1
    //   126: ifnull +121 -> 247
    //   129: aload_1
    //   130: invokeinterface 195 1 0
    //   135: ifne +112 -> 247
    //   138: aload_1
    //   139: invokeinterface 199 1 0
    //   144: astore_1
    //   145: aload_0
    //   146: aload 6
    //   148: invokevirtual 201	kotlinx/coroutines/ba:fX	(Ljava/lang/Object;)V
    //   151: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   154: astore 6
    //   156: invokestatic 206	kotlinx/coroutines/ap:iRh	()Z
    //   159: ifeq +11 -> 170
    //   162: aload 5
    //   164: instanceof 208
    //   167: ifne +64 -> 231
    //   170: aload_1
    //   171: checkcast 105	java/lang/Throwable
    //   174: astore_1
    //   175: aload 5
    //   177: aload_1
    //   178: invokestatic 214	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   181: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: invokeinterface 217 2 0
    //   189: getstatic 144	kotlin/x:aazN	Lkotlin/x;
    //   192: astore_1
    //   193: aload_3
    //   194: aload 4
    //   196: invokestatic 220	kotlinx/coroutines/internal/z:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   199: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   202: astore_1
    //   203: aload_2
    //   204: invokeinterface 138 1 0
    //   209: getstatic 144	kotlin/x:aazN	Lkotlin/x;
    //   212: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   215: astore_1
    //   216: aload_0
    //   217: aconst_null
    //   218: aload_1
    //   219: invokestatic 150	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   222: invokevirtual 152	kotlinx/coroutines/ba:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   225: return
    //   226: aconst_null
    //   227: astore_1
    //   228: goto -108 -> 120
    //   231: aload_1
    //   232: checkcast 105	java/lang/Throwable
    //   235: aload 5
    //   237: checkcast 208	kotlin/d/b/a/e
    //   240: invokestatic 225	kotlinx/coroutines/internal/u:a	(Ljava/lang/Throwable;Lkotlin/d/b/a/e;)Ljava/lang/Throwable;
    //   243: astore_1
    //   244: goto -69 -> 175
    //   247: aload 7
    //   249: ifnull +63 -> 312
    //   252: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   255: astore_1
    //   256: aload 5
    //   258: aload 7
    //   260: invokestatic 214	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   263: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   266: invokeinterface 217 2 0
    //   271: goto -82 -> 189
    //   274: astore_1
    //   275: aload_3
    //   276: aload 4
    //   278: invokestatic 220	kotlinx/coroutines/internal/z:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   281: aload_1
    //   282: athrow
    //   283: astore_3
    //   284: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   287: astore_1
    //   288: aload_2
    //   289: invokeinterface 138 1 0
    //   294: getstatic 144	kotlin/x:aazN	Lkotlin/x;
    //   297: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: astore_1
    //   301: aload_0
    //   302: aconst_null
    //   303: aload_1
    //   304: invokestatic 150	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   307: invokevirtual 152	kotlinx/coroutines/ba:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   310: aload_3
    //   311: athrow
    //   312: aload_0
    //   313: aload 6
    //   315: invokevirtual 227	kotlinx/coroutines/ba:fZ	(Ljava/lang/Object;)Ljava/lang/Object;
    //   318: astore_1
    //   319: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   322: astore 6
    //   324: aload 5
    //   326: aload_1
    //   327: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   330: invokeinterface 217 2 0
    //   335: goto -146 -> 189
    //   338: astore_1
    //   339: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   342: astore_2
    //   343: aload_1
    //   344: invokestatic 214	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   347: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   350: astore_1
    //   351: goto -135 -> 216
    //   354: astore_1
    //   355: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   358: astore_2
    //   359: aload_1
    //   360: invokestatic 214	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   363: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   366: astore_1
    //   367: goto -325 -> 42
    //   370: astore_1
    //   371: getstatic 133	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   374: astore_2
    //   375: aload_1
    //   376: invokestatic 214	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   379: invokestatic 147	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   382: astore_1
    //   383: goto -82 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	ba
    //   9	247	1	localObject1	Object
    //   274	8	1	localObject2	Object
    //   287	40	1	localObject3	Object
    //   338	6	1	localThrowable1	Throwable
    //   350	1	1	localObject4	Object
    //   354	6	1	localThrowable2	Throwable
    //   366	1	1	localObject5	Object
    //   370	6	1	localThrowable3	Throwable
    //   382	1	1	localObject6	Object
    //   4	371	2	localObject7	Object
    //   24	20	3	localThrowable4	Throwable
    //   70	206	3	localf	kotlin.d.f
    //   283	28	3	localObject8	Object
    //   85	192	4	localObject9	Object
    //   61	264	5	locald	d
    //   75	248	6	localObject10	Object
    //   92	167	7	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	10	24	java/lang/Throwable
    //   14	24	24	java/lang/Throwable
    //   52	87	24	java/lang/Throwable
    //   193	199	24	java/lang/Throwable
    //   275	283	24	java/lang/Throwable
    //   87	120	274	finally
    //   129	170	274	finally
    //   170	175	274	finally
    //   175	189	274	finally
    //   189	193	274	finally
    //   231	244	274	finally
    //   252	271	274	finally
    //   312	335	274	finally
    //   5	10	283	finally
    //   14	24	283	finally
    //   52	87	283	finally
    //   193	199	283	finally
    //   275	283	283	finally
    //   199	216	338	java/lang/Throwable
    //   25	42	354	java/lang/Throwable
    //   284	301	370	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ba
 * JD-Core Version:    0.7.0.1
 */