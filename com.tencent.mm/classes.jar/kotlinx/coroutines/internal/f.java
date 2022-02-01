package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"})
public final class f
{
  private static final int abyV;
  private static final ReentrantReadWriteLock abyW;
  private static final WeakHashMap<Class<? extends Throwable>, b<Throwable, Throwable>> abyX;
  
  static
  {
    AppMethodBeat.i(205042);
    abyV = c(Throwable.class, -1);
    abyW = new ReentrantReadWriteLock();
    abyX = new WeakHashMap();
    AppMethodBeat.o(205042);
  }
  
  /* Error */
  public static final <E extends Throwable> E J(E paramE)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore_3
    //   11: ldc 89
    //   13: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   16: aload_0
    //   17: instanceof 91
    //   20: ifeq +64 -> 84
    //   23: getstatic 97	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   26: astore 7
    //   28: aload_0
    //   29: checkcast 91	kotlinx/coroutines/ad
    //   32: invokeinterface 101 1 0
    //   37: invokestatic 105	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore_0
    //   41: aload_0
    //   42: astore 7
    //   44: aload_0
    //   45: invokestatic 109	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   48: ifeq +6 -> 54
    //   51: aconst_null
    //   52: astore 7
    //   54: aload 7
    //   56: checkcast 65	java/lang/Throwable
    //   59: astore_0
    //   60: ldc 89
    //   62: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: getstatic 97	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   71: astore 7
    //   73: aload_0
    //   74: invokestatic 115	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   77: invokestatic 105	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore_0
    //   81: goto -40 -> 41
    //   84: getstatic 78	kotlinx/coroutines/internal/f:abyW	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   87: invokevirtual 119	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   90: astore 7
    //   92: aload 7
    //   94: invokevirtual 124	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   97: getstatic 83	kotlinx/coroutines/internal/f:abyX	Ljava/util/WeakHashMap;
    //   100: aload_0
    //   101: invokevirtual 128	java/lang/Object:getClass	()Ljava/lang/Class;
    //   104: invokevirtual 131	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 133	kotlin/g/a/b
    //   110: astore 8
    //   112: aload 7
    //   114: invokevirtual 136	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   117: aload 8
    //   119: ifnull +35 -> 154
    //   122: aload 8
    //   124: aload_0
    //   125: invokeinterface 139 2 0
    //   130: checkcast 65	java/lang/Throwable
    //   133: astore_0
    //   134: ldc 89
    //   136: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: areturn
    //   141: astore_0
    //   142: aload 7
    //   144: invokevirtual 136	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   147: ldc 89
    //   149: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: athrow
    //   154: getstatic 71	kotlinx/coroutines/internal/f:abyV	I
    //   157: aload_0
    //   158: invokevirtual 128	java/lang/Object:getClass	()Ljava/lang/Class;
    //   161: iconst_0
    //   162: invokestatic 69	kotlinx/coroutines/internal/f:c	(Ljava/lang/Class;I)I
    //   165: if_icmpeq +148 -> 313
    //   168: getstatic 78	kotlinx/coroutines/internal/f:abyW	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   171: astore 8
    //   173: aload 8
    //   175: invokevirtual 119	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   178: astore 7
    //   180: aload 8
    //   182: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   185: ifne +28 -> 213
    //   188: aload 8
    //   190: invokevirtual 146	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   193: istore_1
    //   194: iconst_0
    //   195: istore_2
    //   196: iload_2
    //   197: iload_1
    //   198: if_icmpge +20 -> 218
    //   201: aload 7
    //   203: invokevirtual 136	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   206: iload_2
    //   207: iconst_1
    //   208: iadd
    //   209: istore_2
    //   210: goto -14 -> 196
    //   213: iconst_0
    //   214: istore_1
    //   215: goto -21 -> 194
    //   218: aload 8
    //   220: invokevirtual 150	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   223: astore 8
    //   225: aload 8
    //   227: invokevirtual 153	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   230: getstatic 83	kotlinx/coroutines/internal/f:abyX	Ljava/util/WeakHashMap;
    //   233: checkcast 155	java/util/Map
    //   236: aload_0
    //   237: invokevirtual 128	java/lang/Object:getClass	()Ljava/lang/Class;
    //   240: getstatic 159	kotlinx/coroutines/internal/f$f:abyZ	Lkotlinx/coroutines/internal/f$f;
    //   243: invokeinterface 163 3 0
    //   248: pop
    //   249: getstatic 169	kotlin/x:aazN	Lkotlin/x;
    //   252: astore_0
    //   253: iload_3
    //   254: istore_2
    //   255: iload_2
    //   256: iload_1
    //   257: if_icmpge +15 -> 272
    //   260: aload 7
    //   262: invokevirtual 124	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: goto -14 -> 255
    //   272: aload 8
    //   274: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   277: ldc 89
    //   279: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aconst_null
    //   283: areturn
    //   284: iload_2
    //   285: iload_1
    //   286: if_icmpge +15 -> 301
    //   289: aload 7
    //   291: invokevirtual 124	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   294: iload_2
    //   295: iconst_1
    //   296: iadd
    //   297: istore_2
    //   298: goto -14 -> 284
    //   301: aload 8
    //   303: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   306: ldc 89
    //   308: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: aload_0
    //   312: athrow
    //   313: aload_0
    //   314: invokevirtual 128	java/lang/Object:getClass	()Ljava/lang/Class;
    //   317: invokevirtual 176	java/lang/Class:getConstructors	()[Ljava/lang/reflect/Constructor;
    //   320: new 14	kotlinx/coroutines/internal/f$e
    //   323: dup
    //   324: invokespecial 177	kotlinx/coroutines/internal/f$e:<init>	()V
    //   327: checkcast 179	java/util/Comparator
    //   330: invokestatic 185	kotlin/a/e:b	([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;
    //   333: invokeinterface 191 1 0
    //   338: astore 9
    //   340: aconst_null
    //   341: astore 8
    //   343: aload 8
    //   345: astore 7
    //   347: aload 9
    //   349: invokeinterface 197 1 0
    //   354: ifeq +62 -> 416
    //   357: aload 9
    //   359: invokeinterface 201 1 0
    //   364: checkcast 203	java/lang/reflect/Constructor
    //   367: astore 7
    //   369: aload 7
    //   371: invokevirtual 207	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   374: astore 8
    //   376: aload 8
    //   378: arraylength
    //   379: tableswitch	default:+25 -> 404, 0:+195->574, 1:+129->508, 2:+82->461
    //   405: astore 7
    //   407: aload 7
    //   409: astore 8
    //   411: aload 7
    //   413: ifnull -70 -> 343
    //   416: getstatic 78	kotlinx/coroutines/internal/f:abyW	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   419: astore 8
    //   421: aload 8
    //   423: invokevirtual 119	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   426: astore 9
    //   428: aload 8
    //   430: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   433: ifne +158 -> 591
    //   436: aload 8
    //   438: invokevirtual 146	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   441: istore_1
    //   442: iconst_0
    //   443: istore_2
    //   444: iload_2
    //   445: iload_1
    //   446: if_icmpge +150 -> 596
    //   449: aload 9
    //   451: invokevirtual 136	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   454: iload_2
    //   455: iconst_1
    //   456: iadd
    //   457: istore_2
    //   458: goto -14 -> 444
    //   461: aload 8
    //   463: iconst_0
    //   464: aaload
    //   465: ldc 209
    //   467: invokestatic 215	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   470: ifeq +32 -> 502
    //   473: aload 8
    //   475: iconst_1
    //   476: aaload
    //   477: ldc 65
    //   479: invokestatic 215	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   482: ifeq +20 -> 502
    //   485: new 6	kotlinx/coroutines/internal/f$a
    //   488: dup
    //   489: aload 7
    //   491: invokespecial 218	kotlinx/coroutines/internal/f$a:<init>	(Ljava/lang/reflect/Constructor;)V
    //   494: checkcast 133	kotlin/g/a/b
    //   497: astore 7
    //   499: goto -92 -> 407
    //   502: aconst_null
    //   503: astore 7
    //   505: goto -98 -> 407
    //   508: aload 8
    //   510: iconst_0
    //   511: aaload
    //   512: astore 8
    //   514: aload 8
    //   516: ldc 65
    //   518: invokestatic 215	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   521: ifeq +20 -> 541
    //   524: new 8	kotlinx/coroutines/internal/f$b
    //   527: dup
    //   528: aload 7
    //   530: invokespecial 219	kotlinx/coroutines/internal/f$b:<init>	(Ljava/lang/reflect/Constructor;)V
    //   533: checkcast 133	kotlin/g/a/b
    //   536: astore 7
    //   538: goto -131 -> 407
    //   541: aload 8
    //   543: ldc 209
    //   545: invokestatic 215	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   548: ifeq +20 -> 568
    //   551: new 10	kotlinx/coroutines/internal/f$c
    //   554: dup
    //   555: aload 7
    //   557: invokespecial 220	kotlinx/coroutines/internal/f$c:<init>	(Ljava/lang/reflect/Constructor;)V
    //   560: checkcast 133	kotlin/g/a/b
    //   563: astore 7
    //   565: goto -158 -> 407
    //   568: aconst_null
    //   569: astore 7
    //   571: goto -164 -> 407
    //   574: new 12	kotlinx/coroutines/internal/f$d
    //   577: dup
    //   578: aload 7
    //   580: invokespecial 221	kotlinx/coroutines/internal/f$d:<init>	(Ljava/lang/reflect/Constructor;)V
    //   583: checkcast 133	kotlin/g/a/b
    //   586: astore 7
    //   588: goto -181 -> 407
    //   591: iconst_0
    //   592: istore_1
    //   593: goto -151 -> 442
    //   596: aload 8
    //   598: invokevirtual 150	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   601: astore 10
    //   603: aload 10
    //   605: invokevirtual 153	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   608: getstatic 83	kotlinx/coroutines/internal/f:abyX	Ljava/util/WeakHashMap;
    //   611: checkcast 155	java/util/Map
    //   614: astore 11
    //   616: aload_0
    //   617: invokevirtual 128	java/lang/Object:getClass	()Ljava/lang/Class;
    //   620: astore 12
    //   622: aload 7
    //   624: ifnonnull +127 -> 751
    //   627: getstatic 225	kotlinx/coroutines/internal/f$g:abza	Lkotlinx/coroutines/internal/f$g;
    //   630: checkcast 133	kotlin/g/a/b
    //   633: astore 8
    //   635: aload 11
    //   637: aload 12
    //   639: aload 8
    //   641: invokeinterface 163 3 0
    //   646: pop
    //   647: getstatic 169	kotlin/x:aazN	Lkotlin/x;
    //   650: astore 8
    //   652: iload 5
    //   654: istore_2
    //   655: iload_2
    //   656: iload_1
    //   657: if_icmpge +15 -> 672
    //   660: aload 9
    //   662: invokevirtual 124	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   665: iload_2
    //   666: iconst_1
    //   667: iadd
    //   668: istore_2
    //   669: goto -14 -> 655
    //   672: aload 10
    //   674: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   677: aload 7
    //   679: ifnull +51 -> 730
    //   682: aload 7
    //   684: aload_0
    //   685: invokeinterface 139 2 0
    //   690: checkcast 65	java/lang/Throwable
    //   693: astore_0
    //   694: ldc 89
    //   696: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   699: aload_0
    //   700: areturn
    //   701: iload_2
    //   702: iload_1
    //   703: if_icmpge +15 -> 718
    //   706: aload 9
    //   708: invokevirtual 124	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   711: iload_2
    //   712: iconst_1
    //   713: iadd
    //   714: istore_2
    //   715: goto -14 -> 701
    //   718: aload 10
    //   720: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   723: ldc 89
    //   725: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   728: aload_0
    //   729: athrow
    //   730: ldc 89
    //   732: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   735: aconst_null
    //   736: areturn
    //   737: astore_0
    //   738: iload 6
    //   740: istore_2
    //   741: goto -40 -> 701
    //   744: astore_0
    //   745: iload 4
    //   747: istore_2
    //   748: goto -464 -> 284
    //   751: aload 7
    //   753: astore 8
    //   755: goto -120 -> 635
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	paramE	E
    //   193	511	1	i	int
    //   195	553	2	j	int
    //   10	244	3	k	int
    //   1	745	4	m	int
    //   4	649	5	n	int
    //   7	732	6	i1	int
    //   26	726	7	localObject1	Object
    //   110	644	8	localObject2	Object
    //   338	369	9	localObject3	Object
    //   601	118	10	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   614	22	11	localMap	java.util.Map
    //   620	18	12	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   23	41	67	java/lang/Throwable
    //   97	112	141	finally
    //   608	622	737	finally
    //   627	635	737	finally
    //   635	652	737	finally
    //   230	253	744	finally
  }
  
  private static final int c(Class<?> paramClass, int paramInt)
  {
    AppMethodBeat.i(205041);
    kotlin.g.a.bN(paramClass);
    int j;
    int k;
    int n;
    for (;;)
    {
      try
      {
        localObject = Result.Companion;
        int i = 0;
        localObject = paramClass.getDeclaredFields();
        int i1 = localObject.length;
        j = 0;
        k = 0;
        if (j < i1)
        {
          if (Modifier.isStatic(localObject[j].getModifiers())) {
            break label158;
          }
          n = 1;
          break;
        }
        i = k + i;
        paramClass = paramClass.getSuperclass();
        if (paramClass != null) {
          continue;
        }
        paramClass = Result.constructor-impl(Integer.valueOf(i));
      }
      catch (Throwable paramClass)
      {
        Object localObject = Result.Companion;
        paramClass = Result.constructor-impl(ResultKt.createFailure(paramClass));
        continue;
      }
      localObject = paramClass;
      if (Result.isFailure-impl(paramClass)) {
        localObject = Integer.valueOf(paramInt);
      }
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(205041);
      return paramInt;
    }
    for (;;)
    {
      int m = k;
      if (n != 0) {
        m = k + 1;
      }
      j += 1;
      k = m;
      break;
      label158:
      n = 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
  public static final class a
    extends q
    implements b<Throwable, Throwable>
  {
    public a(Constructor paramConstructor)
    {
      super();
    }
    
    private Throwable K(Throwable paramThrowable)
    {
      AppMethodBeat.i(205052);
      Object localObject;
      try
      {
        localObject = Result.Companion;
        paramThrowable = this.abyY.newInstance(new Object[] { paramThrowable.getMessage(), paramThrowable });
        if (paramThrowable == null)
        {
          paramThrowable = new t("null cannot be cast to non-null type kotlin.Throwable");
          AppMethodBeat.o(205052);
          throw paramThrowable;
        }
      }
      catch (Throwable paramThrowable)
      {
        localObject = Result.Companion;
        paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
      }
      for (;;)
      {
        localObject = paramThrowable;
        if (Result.isFailure-impl(paramThrowable)) {
          localObject = null;
        }
        paramThrowable = (Throwable)localObject;
        AppMethodBeat.o(205052);
        return paramThrowable;
        paramThrowable = Result.constructor-impl((Throwable)paramThrowable);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
  public static final class b
    extends q
    implements b<Throwable, Throwable>
  {
    public b(Constructor paramConstructor)
    {
      super();
    }
    
    private Throwable K(Throwable paramThrowable)
    {
      AppMethodBeat.i(204938);
      Object localObject;
      try
      {
        localObject = Result.Companion;
        paramThrowable = this.abyY.newInstance(new Object[] { paramThrowable });
        if (paramThrowable == null)
        {
          paramThrowable = new t("null cannot be cast to non-null type kotlin.Throwable");
          AppMethodBeat.o(204938);
          throw paramThrowable;
        }
      }
      catch (Throwable paramThrowable)
      {
        localObject = Result.Companion;
        paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
      }
      for (;;)
      {
        localObject = paramThrowable;
        if (Result.isFailure-impl(paramThrowable)) {
          localObject = null;
        }
        paramThrowable = (Throwable)localObject;
        AppMethodBeat.o(204938);
        return paramThrowable;
        paramThrowable = Result.constructor-impl((Throwable)paramThrowable);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
  public static final class c
    extends q
    implements b<Throwable, Throwable>
  {
    public c(Constructor paramConstructor)
    {
      super();
    }
    
    private Throwable K(Throwable paramThrowable)
    {
      AppMethodBeat.i(204946);
      Object localObject;
      try
      {
        localObject = Result.Companion;
        localObject = this.abyY.newInstance(new Object[] { paramThrowable.getMessage() });
        if (localObject == null)
        {
          paramThrowable = new t("null cannot be cast to non-null type kotlin.Throwable");
          AppMethodBeat.o(204946);
          throw paramThrowable;
        }
      }
      catch (Throwable paramThrowable)
      {
        localObject = Result.Companion;
        paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
      }
      for (;;)
      {
        localObject = paramThrowable;
        if (Result.isFailure-impl(paramThrowable)) {
          localObject = null;
        }
        paramThrowable = (Throwable)localObject;
        AppMethodBeat.o(204946);
        return paramThrowable;
        localObject = (Throwable)localObject;
        ((Throwable)localObject).initCause(paramThrowable);
        paramThrowable = Result.constructor-impl(localObject);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
  public static final class d
    extends q
    implements b<Throwable, Throwable>
  {
    public d(Constructor paramConstructor)
    {
      super();
    }
    
    private Throwable K(Throwable paramThrowable)
    {
      AppMethodBeat.i(204950);
      Object localObject;
      try
      {
        localObject = Result.Companion;
        localObject = this.abyY.newInstance(new Object[0]);
        if (localObject == null)
        {
          paramThrowable = new t("null cannot be cast to non-null type kotlin.Throwable");
          AppMethodBeat.o(204950);
          throw paramThrowable;
        }
      }
      catch (Throwable paramThrowable)
      {
        localObject = Result.Companion;
        paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
      }
      for (;;)
      {
        localObject = paramThrowable;
        if (Result.isFailure-impl(paramThrowable)) {
          localObject = null;
        }
        paramThrowable = (Throwable)localObject;
        AppMethodBeat.o(204950);
        return paramThrowable;
        localObject = (Throwable)localObject;
        ((Throwable)localObject).initCause(paramThrowable);
        paramThrowable = Result.constructor-impl(localObject);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(205048);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((Constructor)paramT2).getParameterTypes().length), (Comparable)Integer.valueOf(((Constructor)paramT1).getParameterTypes().length));
      AppMethodBeat.o(205048);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "E", "", "it", "invoke"})
  static final class f
    extends q
    implements b
  {
    public static final f abyZ;
    
    static
    {
      AppMethodBeat.i(205110);
      abyZ = new f();
      AppMethodBeat.o(205110);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "E", "", "it", "invoke"})
  static final class g
    extends q
    implements b
  {
    public static final g abza;
    
    static
    {
      AppMethodBeat.i(205091);
      abza = new g();
      AppMethodBeat.o(205091);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.f
 * JD-Core Version:    0.7.0.1
 */