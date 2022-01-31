package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.f.b.j;
import a.l;
import a.p;
import a.p.a;
import a.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.m;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED$annotations", "()V", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeCancellable", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeCancellableWithException", "exception", "", "resumeDirect", "resumeDirectWithException", "yieldUndispatched", "", "Lkotlinx/coroutines/DispatchedContinuation;", "kotlinx-coroutines-core"})
public final class am
{
  private static final m CHP;
  
  static
  {
    AppMethodBeat.i(118583);
    CHP = new m("UNDEFINED");
    AppMethodBeat.o(118583);
  }
  
  /* Error */
  public static final <T> void a(c<? super T> paramc, T paramT)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 64
    //   8: invokestatic 70	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: instanceof 72
    //   15: ifeq +326 -> 341
    //   18: aload_0
    //   19: checkcast 72	kotlinx/coroutines/al
    //   22: astore_3
    //   23: aload_3
    //   24: getfield 76	kotlinx/coroutines/al:CHN	Lkotlinx/coroutines/w;
    //   27: aload_3
    //   28: invokevirtual 80	kotlinx/coroutines/al:eaV	()La/c/e;
    //   31: invokevirtual 86	kotlinx/coroutines/w:b	(La/c/e;)Z
    //   34: ifeq +34 -> 68
    //   37: aload_3
    //   38: aload_1
    //   39: putfield 90	kotlinx/coroutines/al:CHh	Ljava/lang/Object;
    //   42: aload_3
    //   43: iconst_1
    //   44: putfield 94	kotlinx/coroutines/al:CHQ	I
    //   47: aload_3
    //   48: getfield 76	kotlinx/coroutines/al:CHN	Lkotlinx/coroutines/w;
    //   51: aload_3
    //   52: invokevirtual 80	kotlinx/coroutines/al:eaV	()La/c/e;
    //   55: aload_3
    //   56: checkcast 96	java/lang/Runnable
    //   59: invokevirtual 99	kotlinx/coroutines/w:a	(La/c/e;Ljava/lang/Runnable;)V
    //   62: ldc 62
    //   64: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: return
    //   68: getstatic 105	kotlinx/coroutines/bu:CIG	Lkotlinx/coroutines/bu;
    //   71: astore_0
    //   72: getstatic 109	kotlinx/coroutines/bu:CIF	Lkotlinx/coroutines/a/p;
    //   75: invokevirtual 115	kotlinx/coroutines/a/p:get	()Ljava/lang/Object;
    //   78: checkcast 117	kotlinx/coroutines/bu$a
    //   81: astore_0
    //   82: aload_0
    //   83: getfield 121	kotlinx/coroutines/bu$a:isActive	Z
    //   86: ifeq +27 -> 113
    //   89: aload_3
    //   90: aload_1
    //   91: putfield 90	kotlinx/coroutines/al:CHh	Ljava/lang/Object;
    //   94: aload_3
    //   95: iconst_1
    //   96: putfield 94	kotlinx/coroutines/al:CHQ	I
    //   99: aload_0
    //   100: getfield 125	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   103: aload_3
    //   104: invokevirtual 131	kotlinx/coroutines/a/b:addLast	(Ljava/lang/Object;)V
    //   107: ldc 62
    //   109: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: return
    //   113: aload_0
    //   114: ldc 133
    //   116: invokestatic 136	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield 121	kotlinx/coroutines/bu$a:isActive	Z
    //   124: aload_3
    //   125: invokevirtual 80	kotlinx/coroutines/al:eaV	()La/c/e;
    //   128: getstatic 142	kotlinx/coroutines/bc:CIk	Lkotlinx/coroutines/bc$b;
    //   131: checkcast 144	a/c/e$c
    //   134: invokeinterface 149 2 0
    //   139: checkcast 138	kotlinx/coroutines/bc
    //   142: astore 4
    //   144: aload 4
    //   146: ifnull +124 -> 270
    //   149: aload 4
    //   151: invokeinterface 152 1 0
    //   156: ifne +114 -> 270
    //   159: aload 4
    //   161: invokeinterface 156 1 0
    //   166: checkcast 61	java/lang/Throwable
    //   169: astore 4
    //   171: getstatic 162	a/p:BLX	La/p$a;
    //   174: astore 5
    //   176: aload_3
    //   177: aload 4
    //   179: invokestatic 168	a/q:n	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   182: invokestatic 172	a/p:de	(Ljava/lang/Object;)Ljava/lang/Object;
    //   185: invokeinterface 177 2 0
    //   190: iconst_1
    //   191: istore_2
    //   192: iload_2
    //   193: ifne +51 -> 244
    //   196: aload_3
    //   197: invokevirtual 80	kotlinx/coroutines/al:eaV	()La/c/e;
    //   200: astore 4
    //   202: aload 4
    //   204: aload_3
    //   205: getfield 180	kotlinx/coroutines/al:CHM	Ljava/lang/Object;
    //   208: invokestatic 185	kotlinx/coroutines/a/o:b	(La/c/e;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: astore 5
    //   213: aload_3
    //   214: getfield 189	kotlinx/coroutines/al:CHO	La/c/c;
    //   217: astore_3
    //   218: getstatic 162	a/p:BLX	La/p$a;
    //   221: astore 6
    //   223: aload_3
    //   224: aload_1
    //   225: invokestatic 172	a/p:de	(Ljava/lang/Object;)Ljava/lang/Object;
    //   228: invokeinterface 177 2 0
    //   233: getstatic 195	a/y:BMg	La/y;
    //   236: astore_1
    //   237: aload 4
    //   239: aload 5
    //   241: invokestatic 198	kotlinx/coroutines/a/o:a	(La/c/e;Ljava/lang/Object;)V
    //   244: aload_0
    //   245: getfield 125	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   248: invokevirtual 201	kotlinx/coroutines/a/b:eqc	()Ljava/lang/Object;
    //   251: checkcast 96	java/lang/Runnable
    //   254: astore_1
    //   255: aload_1
    //   256: ifnonnull +76 -> 332
    //   259: aload_0
    //   260: iconst_0
    //   261: putfield 121	kotlinx/coroutines/bu$a:isActive	Z
    //   264: ldc 62
    //   266: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: return
    //   270: iconst_0
    //   271: istore_2
    //   272: goto -80 -> 192
    //   275: astore_1
    //   276: aload 4
    //   278: aload 5
    //   280: invokestatic 198	kotlinx/coroutines/a/o:a	(La/c/e;Ljava/lang/Object;)V
    //   283: ldc 62
    //   285: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: aload_1
    //   289: athrow
    //   290: astore_1
    //   291: aload_0
    //   292: getfield 125	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   295: invokevirtual 204	kotlinx/coroutines/a/b:clear	()V
    //   298: new 206	kotlinx/coroutines/ak
    //   301: dup
    //   302: ldc 208
    //   304: aload_1
    //   305: invokespecial 211	kotlinx/coroutines/ak:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: checkcast 61	java/lang/Throwable
    //   311: astore_1
    //   312: ldc 62
    //   314: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload_1
    //   318: athrow
    //   319: astore_1
    //   320: aload_0
    //   321: iconst_0
    //   322: putfield 121	kotlinx/coroutines/bu$a:isActive	Z
    //   325: ldc 62
    //   327: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload_1
    //   331: athrow
    //   332: aload_1
    //   333: invokeinterface 214 1 0
    //   338: goto -94 -> 244
    //   341: getstatic 162	a/p:BLX	La/p$a;
    //   344: astore_3
    //   345: aload_0
    //   346: aload_1
    //   347: invokestatic 172	a/p:de	(Ljava/lang/Object;)Ljava/lang/Object;
    //   350: invokeinterface 177 2 0
    //   355: ldc 62
    //   357: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	paramc	c<? super T>
    //   0	361	1	paramT	T
    //   191	81	2	i	int
    //   22	323	3	localObject1	Object
    //   142	135	4	localObject2	Object
    //   174	105	5	localObject3	Object
    //   221	1	6	locala	p.a
    // Exception table:
    //   from	to	target	type
    //   213	237	275	finally
    //   119	144	290	java/lang/Throwable
    //   149	190	290	java/lang/Throwable
    //   196	213	290	java/lang/Throwable
    //   237	244	290	java/lang/Throwable
    //   244	255	290	java/lang/Throwable
    //   276	290	290	java/lang/Throwable
    //   332	338	290	java/lang/Throwable
    //   119	144	319	finally
    //   149	190	319	finally
    //   196	213	319	finally
    //   237	244	319	finally
    //   244	255	319	finally
    //   276	290	319	finally
    //   291	319	319	finally
    //   332	338	319	finally
  }
  
  /* Error */
  public static final <T> void a(c<? super T> paramc, Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 218
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 64
    //   8: invokestatic 70	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 219
    //   14: invokestatic 70	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_0
    //   18: instanceof 72
    //   21: ifeq +351 -> 372
    //   24: aload_0
    //   25: checkcast 72	kotlinx/coroutines/al
    //   28: astore_3
    //   29: aload_3
    //   30: getfield 189	kotlinx/coroutines/al:CHO	La/c/c;
    //   33: invokeinterface 220 1 0
    //   38: astore_0
    //   39: new 222	kotlinx/coroutines/q
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 225	kotlinx/coroutines/q:<init>	(Ljava/lang/Throwable;)V
    //   47: astore 4
    //   49: aload_3
    //   50: getfield 76	kotlinx/coroutines/al:CHN	Lkotlinx/coroutines/w;
    //   53: aload_0
    //   54: invokevirtual 86	kotlinx/coroutines/w:b	(La/c/e;)Z
    //   57: ifeq +38 -> 95
    //   60: aload_3
    //   61: new 222	kotlinx/coroutines/q
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 225	kotlinx/coroutines/q:<init>	(Ljava/lang/Throwable;)V
    //   69: putfield 90	kotlinx/coroutines/al:CHh	Ljava/lang/Object;
    //   72: aload_3
    //   73: iconst_1
    //   74: putfield 94	kotlinx/coroutines/al:CHQ	I
    //   77: aload_3
    //   78: getfield 76	kotlinx/coroutines/al:CHN	Lkotlinx/coroutines/w;
    //   81: aload_0
    //   82: aload_3
    //   83: checkcast 96	java/lang/Runnable
    //   86: invokevirtual 99	kotlinx/coroutines/w:a	(La/c/e;Ljava/lang/Runnable;)V
    //   89: ldc 218
    //   91: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: getstatic 105	kotlinx/coroutines/bu:CIG	Lkotlinx/coroutines/bu;
    //   98: astore_0
    //   99: getstatic 109	kotlinx/coroutines/bu:CIF	Lkotlinx/coroutines/a/p;
    //   102: invokevirtual 115	kotlinx/coroutines/a/p:get	()Ljava/lang/Object;
    //   105: checkcast 117	kotlinx/coroutines/bu$a
    //   108: astore_0
    //   109: aload_0
    //   110: getfield 121	kotlinx/coroutines/bu$a:isActive	Z
    //   113: ifeq +28 -> 141
    //   116: aload_3
    //   117: aload 4
    //   119: putfield 90	kotlinx/coroutines/al:CHh	Ljava/lang/Object;
    //   122: aload_3
    //   123: iconst_1
    //   124: putfield 94	kotlinx/coroutines/al:CHQ	I
    //   127: aload_0
    //   128: getfield 125	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   131: aload_3
    //   132: invokevirtual 131	kotlinx/coroutines/a/b:addLast	(Ljava/lang/Object;)V
    //   135: ldc 218
    //   137: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: aload_0
    //   142: ldc 133
    //   144: invokestatic 136	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   147: aload_0
    //   148: iconst_1
    //   149: putfield 121	kotlinx/coroutines/bu$a:isActive	Z
    //   152: aload_3
    //   153: invokevirtual 80	kotlinx/coroutines/al:eaV	()La/c/e;
    //   156: getstatic 142	kotlinx/coroutines/bc:CIk	Lkotlinx/coroutines/bc$b;
    //   159: checkcast 144	a/c/e$c
    //   162: invokeinterface 149 2 0
    //   167: checkcast 138	kotlinx/coroutines/bc
    //   170: astore 4
    //   172: aload 4
    //   174: ifnull +127 -> 301
    //   177: aload 4
    //   179: invokeinterface 152 1 0
    //   184: ifne +117 -> 301
    //   187: aload 4
    //   189: invokeinterface 156 1 0
    //   194: checkcast 61	java/lang/Throwable
    //   197: astore 4
    //   199: getstatic 162	a/p:BLX	La/p$a;
    //   202: astore 5
    //   204: aload_3
    //   205: aload 4
    //   207: invokestatic 168	a/q:n	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   210: invokestatic 172	a/p:de	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: invokeinterface 177 2 0
    //   218: iconst_1
    //   219: istore_2
    //   220: iload_2
    //   221: ifne +54 -> 275
    //   224: aload_3
    //   225: invokevirtual 80	kotlinx/coroutines/al:eaV	()La/c/e;
    //   228: astore 4
    //   230: aload 4
    //   232: aload_3
    //   233: getfield 180	kotlinx/coroutines/al:CHM	Ljava/lang/Object;
    //   236: invokestatic 185	kotlinx/coroutines/a/o:b	(La/c/e;Ljava/lang/Object;)Ljava/lang/Object;
    //   239: astore 5
    //   241: aload_3
    //   242: getfield 189	kotlinx/coroutines/al:CHO	La/c/c;
    //   245: astore_3
    //   246: getstatic 162	a/p:BLX	La/p$a;
    //   249: astore 6
    //   251: aload_3
    //   252: aload_1
    //   253: invokestatic 168	a/q:n	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   256: invokestatic 172	a/p:de	(Ljava/lang/Object;)Ljava/lang/Object;
    //   259: invokeinterface 177 2 0
    //   264: getstatic 195	a/y:BMg	La/y;
    //   267: astore_1
    //   268: aload 4
    //   270: aload 5
    //   272: invokestatic 198	kotlinx/coroutines/a/o:a	(La/c/e;Ljava/lang/Object;)V
    //   275: aload_0
    //   276: getfield 125	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   279: invokevirtual 201	kotlinx/coroutines/a/b:eqc	()Ljava/lang/Object;
    //   282: checkcast 96	java/lang/Runnable
    //   285: astore_1
    //   286: aload_1
    //   287: ifnonnull +76 -> 363
    //   290: aload_0
    //   291: iconst_0
    //   292: putfield 121	kotlinx/coroutines/bu$a:isActive	Z
    //   295: ldc 218
    //   297: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: return
    //   301: iconst_0
    //   302: istore_2
    //   303: goto -83 -> 220
    //   306: astore_1
    //   307: aload 4
    //   309: aload 5
    //   311: invokestatic 198	kotlinx/coroutines/a/o:a	(La/c/e;Ljava/lang/Object;)V
    //   314: ldc 218
    //   316: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: aload_1
    //   320: athrow
    //   321: astore_1
    //   322: aload_0
    //   323: getfield 125	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   326: invokevirtual 204	kotlinx/coroutines/a/b:clear	()V
    //   329: new 206	kotlinx/coroutines/ak
    //   332: dup
    //   333: ldc 208
    //   335: aload_1
    //   336: invokespecial 211	kotlinx/coroutines/ak:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   339: checkcast 61	java/lang/Throwable
    //   342: astore_1
    //   343: ldc 218
    //   345: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload_1
    //   349: athrow
    //   350: astore_1
    //   351: aload_0
    //   352: iconst_0
    //   353: putfield 121	kotlinx/coroutines/bu$a:isActive	Z
    //   356: ldc 218
    //   358: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: aload_1
    //   362: athrow
    //   363: aload_1
    //   364: invokeinterface 214 1 0
    //   369: goto -94 -> 275
    //   372: getstatic 162	a/p:BLX	La/p$a;
    //   375: astore_3
    //   376: aload_0
    //   377: aload_1
    //   378: invokestatic 168	a/q:n	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   381: invokestatic 172	a/p:de	(Ljava/lang/Object;)Ljava/lang/Object;
    //   384: invokeinterface 177 2 0
    //   389: ldc 218
    //   391: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramc	c<? super T>
    //   0	395	1	paramThrowable	Throwable
    //   219	84	2	i	int
    //   28	348	3	localObject1	Object
    //   47	261	4	localObject2	Object
    //   202	108	5	localObject3	Object
    //   249	1	6	locala	p.a
    // Exception table:
    //   from	to	target	type
    //   241	268	306	finally
    //   147	172	321	java/lang/Throwable
    //   177	218	321	java/lang/Throwable
    //   224	241	321	java/lang/Throwable
    //   268	275	321	java/lang/Throwable
    //   275	286	321	java/lang/Throwable
    //   307	321	321	java/lang/Throwable
    //   363	369	321	java/lang/Throwable
    //   147	172	350	finally
    //   177	218	350	finally
    //   224	241	350	finally
    //   268	275	350	finally
    //   275	286	350	finally
    //   307	321	350	finally
    //   322	350	350	finally
    //   363	369	350	finally
  }
  
  public static final <T> void a(an<? super T> paraman, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(118581);
    j.q(paraman, "receiver$0");
    Object localObject2 = paraman.epp();
    int i = j;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        break label104;
      }
      i = j;
    }
    while ((i != 0) && ((localObject2 instanceof al)) && (bo.Wg(paramInt) == bo.Wg(paraman.CHQ)))
    {
      Object localObject1 = ((al)localObject2).CHN;
      localObject2 = ((c)localObject2).eaV();
      if (((w)localObject1).b((e)localObject2))
      {
        ((w)localObject1).a((e)localObject2, (Runnable)paraman);
        AppMethodBeat.o(118581);
        return;
        label104:
        i = 0;
      }
      else
      {
        localObject1 = bu.CIG;
        bu.a(paraman);
        AppMethodBeat.o(118581);
        return;
      }
    }
    a(paraman, (c)localObject2, paramInt);
    AppMethodBeat.o(118581);
  }
  
  public static final <T> void a(an<? super T> paraman, c<? super T> paramc, int paramInt)
  {
    AppMethodBeat.i(118582);
    j.q(paraman, "receiver$0");
    j.q(paramc, "delegate");
    Object localObject = paraman.epm();
    Throwable localThrowable = an.eb(localObject);
    if (localThrowable != null)
    {
      bo.a(paramc, localThrowable, paramInt);
      AppMethodBeat.o(118582);
      return;
    }
    bo.a(paramc, paraman.dX(localObject), paramInt);
    AppMethodBeat.o(118582);
  }
  
  public static final <T> void b(c<? super T> paramc, T paramT)
  {
    AppMethodBeat.i(118579);
    j.q(paramc, "receiver$0");
    if ((paramc instanceof al))
    {
      paramc = ((al)paramc).CHO;
      locala = p.BLX;
      paramc.dg(p.de(paramT));
      AppMethodBeat.o(118579);
      return;
    }
    p.a locala = p.BLX;
    paramc.dg(p.de(paramT));
    AppMethodBeat.o(118579);
  }
  
  public static final <T> void b(c<? super T> paramc, Throwable paramThrowable)
  {
    AppMethodBeat.i(118580);
    j.q(paramc, "receiver$0");
    j.q(paramThrowable, "exception");
    if ((paramc instanceof al))
    {
      paramc = ((al)paramc).CHO;
      locala = p.BLX;
      paramc.dg(p.de(q.n(paramThrowable)));
      AppMethodBeat.o(118580);
      return;
    }
    p.a locala = p.BLX;
    paramc.dg(p.de(q.n(paramThrowable)));
    AppMethodBeat.o(118580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.am
 * JD-Core Version:    0.7.0.1
 */