package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.d.i;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class bd<T>
  extends i
{
  public int ajvU;
  
  public bd(int paramInt)
  {
    this.ajvU = paramInt;
  }
  
  public void a(Object paramObject, Throwable paramThrowable) {}
  
  public final void c(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if ((paramThrowable1 == null) && (paramThrowable2 == null)) {
      return;
    }
    if ((paramThrowable1 != null) && (paramThrowable2 != null)) {
      b.a(paramThrowable1, paramThrowable2);
    }
    if (paramThrowable1 == null) {}
    for (;;)
    {
      paramThrowable1 = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
      s.checkNotNull(paramThrowable2);
      paramThrowable1 = new at(paramThrowable1, paramThrowable2);
      an.b(kBz().getContext(), (Throwable)paramThrowable1);
      return;
      paramThrowable2 = paramThrowable1;
    }
  }
  
  public <T> T iA(Object paramObject)
  {
    return paramObject;
  }
  
  public Throwable iB(Object paramObject)
  {
    if ((paramObject instanceof ae)) {}
    for (paramObject = (ae)paramObject; paramObject == null; paramObject = null) {
      return null;
    }
    return paramObject.cause;
  }
  
  public abstract Object kBC();
  
  public abstract d<T> kBz();
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: getstatic 127	kotlinx/coroutines/au:ASSERTIONS_ENABLED	Z
    //   3: ifeq +30 -> 33
    //   6: aload_0
    //   7: getfield 51	kotlinx/coroutines/bd:ajvU	I
    //   10: iconst_m1
    //   11: if_icmpeq +17 -> 28
    //   14: iconst_1
    //   15: istore_1
    //   16: iload_1
    //   17: ifne +16 -> 33
    //   20: new 129	java/lang/AssertionError
    //   23: dup
    //   24: invokespecial 130	java/lang/AssertionError:<init>	()V
    //   27: athrow
    //   28: iconst_0
    //   29: istore_1
    //   30: goto -14 -> 16
    //   33: aload_0
    //   34: getfield 134	kotlinx/coroutines/bd:ajBI	Lkotlinx/coroutines/d/j;
    //   37: astore 4
    //   39: aload_0
    //   40: invokevirtual 95	kotlinx/coroutines/bd:kBz	()Lkotlin/d/d;
    //   43: checkcast 136	kotlinx/coroutines/internal/h
    //   46: astore_2
    //   47: aload_2
    //   48: getfield 140	kotlinx/coroutines/internal/h:alw	Lkotlin/d/d;
    //   51: astore 6
    //   53: aload_2
    //   54: getfield 144	kotlinx/coroutines/internal/h:ajAa	Ljava/lang/Object;
    //   57: astore_2
    //   58: aload 6
    //   60: invokeinterface 101 1 0
    //   65: astore 5
    //   67: aload 5
    //   69: aload_2
    //   70: invokestatic 149	kotlinx/coroutines/internal/ag:b	(Lkotlin/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: astore 7
    //   75: aload 7
    //   77: getstatic 153	kotlinx/coroutines/internal/ag:ajAT	Lkotlinx/coroutines/internal/ac;
    //   80: if_acmpeq +184 -> 264
    //   83: aload 6
    //   85: aload 5
    //   87: aload 7
    //   89: invokestatic 158	kotlinx/coroutines/ak:a	(Lkotlin/d/d;Lkotlin/d/f;Ljava/lang/Object;)Lkotlinx/coroutines/de;
    //   92: astore_2
    //   93: aload 6
    //   95: invokeinterface 101 1 0
    //   100: astore_3
    //   101: aload_0
    //   102: invokevirtual 160	kotlinx/coroutines/bd:kBC	()Ljava/lang/Object;
    //   105: astore 8
    //   107: aload_0
    //   108: aload 8
    //   110: invokevirtual 162	kotlinx/coroutines/bd:iB	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   113: astore 9
    //   115: aload 9
    //   117: ifnonnull +152 -> 269
    //   120: aload_0
    //   121: getfield 51	kotlinx/coroutines/bd:ajvU	I
    //   124: invokestatic 168	kotlinx/coroutines/be:aMD	(I)Z
    //   127: ifeq +142 -> 269
    //   130: aload_3
    //   131: getstatic 174	kotlinx/coroutines/cb:ajws	Lkotlinx/coroutines/cb$b;
    //   134: checkcast 176	kotlin/d/f$c
    //   137: invokeinterface 182 2 0
    //   142: checkcast 170	kotlinx/coroutines/cb
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +143 -> 290
    //   150: aload_3
    //   151: invokeinterface 186 1 0
    //   156: ifne +134 -> 290
    //   159: aload_3
    //   160: invokeinterface 190 1 0
    //   165: astore_3
    //   166: aload_0
    //   167: aload 8
    //   169: aload_3
    //   170: checkcast 103	java/lang/Throwable
    //   173: invokevirtual 192	kotlinx/coroutines/bd:a	(Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   176: getstatic 198	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   179: astore 8
    //   181: getstatic 201	kotlinx/coroutines/au:ajvP	Z
    //   184: ifeq +11 -> 195
    //   187: aload 6
    //   189: instanceof 203
    //   192: ifne +82 -> 274
    //   195: aload_3
    //   196: checkcast 103	java/lang/Throwable
    //   199: astore_3
    //   200: aload 6
    //   202: aload_3
    //   203: invokestatic 209	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   206: invokestatic 212	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   209: invokeinterface 215 2 0
    //   214: getstatic 221	kotlin/ah:aiuX	Lkotlin/ah;
    //   217: astore_3
    //   218: aload_2
    //   219: ifnull +10 -> 229
    //   222: aload_2
    //   223: invokevirtual 226	kotlinx/coroutines/de:kCP	()Z
    //   226: ifeq +10 -> 236
    //   229: aload 5
    //   231: aload 7
    //   233: invokestatic 229	kotlinx/coroutines/internal/ag:c	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   236: getstatic 198	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   239: astore_2
    //   240: aload 4
    //   242: invokeinterface 234 1 0
    //   247: getstatic 221	kotlin/ah:aiuX	Lkotlin/ah;
    //   250: invokestatic 212	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   253: astore_2
    //   254: aload_0
    //   255: aconst_null
    //   256: aload_2
    //   257: invokestatic 237	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   260: invokevirtual 239	kotlinx/coroutines/bd:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   263: return
    //   264: aconst_null
    //   265: astore_2
    //   266: goto -173 -> 93
    //   269: aconst_null
    //   270: astore_3
    //   271: goto -125 -> 146
    //   274: aload_3
    //   275: checkcast 103	java/lang/Throwable
    //   278: aload 6
    //   280: checkcast 203	kotlin/d/b/a/e
    //   283: invokestatic 244	kotlinx/coroutines/internal/ab:a	(Ljava/lang/Throwable;Lkotlin/d/b/a/e;)Ljava/lang/Throwable;
    //   286: astore_3
    //   287: goto -87 -> 200
    //   290: aload 9
    //   292: ifnull +75 -> 367
    //   295: getstatic 198	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   298: astore_3
    //   299: aload 6
    //   301: aload 9
    //   303: invokestatic 209	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   306: invokestatic 212	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: invokeinterface 215 2 0
    //   314: goto -100 -> 214
    //   317: astore_3
    //   318: aload_2
    //   319: ifnull +10 -> 329
    //   322: aload_2
    //   323: invokevirtual 226	kotlinx/coroutines/de:kCP	()Z
    //   326: ifeq +10 -> 336
    //   329: aload 5
    //   331: aload 7
    //   333: invokestatic 229	kotlinx/coroutines/internal/ag:c	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   336: aload_3
    //   337: athrow
    //   338: astore_3
    //   339: getstatic 198	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   342: astore_2
    //   343: aload 4
    //   345: invokeinterface 234 1 0
    //   350: getstatic 221	kotlin/ah:aiuX	Lkotlin/ah;
    //   353: invokestatic 212	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   356: astore_2
    //   357: aload_0
    //   358: aload_3
    //   359: aload_2
    //   360: invokestatic 237	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   363: invokevirtual 239	kotlinx/coroutines/bd:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   366: return
    //   367: aload_0
    //   368: aload 8
    //   370: invokevirtual 246	kotlinx/coroutines/bd:iA	(Ljava/lang/Object;)Ljava/lang/Object;
    //   373: astore_3
    //   374: getstatic 198	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   377: astore 8
    //   379: aload 6
    //   381: aload_3
    //   382: invokestatic 212	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   385: invokeinterface 215 2 0
    //   390: goto -176 -> 214
    //   393: astore_2
    //   394: getstatic 198	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   397: astore_3
    //   398: aload_2
    //   399: invokestatic 209	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   402: invokestatic 212	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   405: astore_2
    //   406: goto -152 -> 254
    //   409: astore_2
    //   410: getstatic 198	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   413: astore 4
    //   415: aload_2
    //   416: invokestatic 209	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   419: invokestatic 212	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   422: astore_2
    //   423: goto -66 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	bd
    //   15	15	1	i	int
    //   46	314	2	localObject1	Object
    //   393	6	2	localThrowable1	Throwable
    //   405	1	2	localObject2	Object
    //   409	7	2	localThrowable2	Throwable
    //   422	1	2	localObject3	Object
    //   100	199	3	localObject4	Object
    //   317	20	3	localObject5	Object
    //   338	21	3	localThrowable3	Throwable
    //   373	25	3	localObject6	Object
    //   37	377	4	localObject7	Object
    //   65	265	5	localf	kotlin.d.f
    //   51	329	6	locald	d
    //   73	259	7	localObject8	Object
    //   105	273	8	localObject9	Object
    //   113	189	9	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   93	115	317	finally
    //   120	146	317	finally
    //   150	195	317	finally
    //   195	200	317	finally
    //   200	214	317	finally
    //   214	218	317	finally
    //   274	287	317	finally
    //   295	314	317	finally
    //   367	390	317	finally
    //   39	93	338	finally
    //   222	229	338	finally
    //   229	236	338	finally
    //   322	329	338	finally
    //   329	336	338	finally
    //   336	338	338	finally
    //   236	254	393	finally
    //   339	357	409	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bd
 * JD-Core Version:    0.7.0.1
 */