package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.g.a;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final int ajAo;
  private static final ReentrantReadWriteLock ajAp;
  private static final WeakHashMap<Class<? extends Throwable>, b<Throwable, Throwable>> ajAq;
  
  static
  {
    AppMethodBeat.i(189433);
    ajAo = d(Throwable.class, -1);
    ajAp = new ReentrantReadWriteLock();
    ajAq = new WeakHashMap();
    AppMethodBeat.o(189433);
  }
  
  /* Error */
  public static final <E extends Throwable> E Z(E paramE)
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
    //   11: ldc 79
    //   13: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   16: aload_0
    //   17: instanceof 81
    //   20: ifeq +64 -> 84
    //   23: getstatic 87	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   26: astore 7
    //   28: aload_0
    //   29: checkcast 81	kotlinx/coroutines/aj
    //   32: invokeinterface 91 1 0
    //   37: invokestatic 95	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore_0
    //   41: aload_0
    //   42: astore 7
    //   44: aload_0
    //   45: invokestatic 99	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   48: ifeq +6 -> 54
    //   51: aconst_null
    //   52: astore 7
    //   54: aload 7
    //   56: checkcast 55	java/lang/Throwable
    //   59: astore_0
    //   60: ldc 79
    //   62: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: getstatic 87	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   71: astore 7
    //   73: aload_0
    //   74: invokestatic 105	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   77: invokestatic 95	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore_0
    //   81: goto -40 -> 41
    //   84: getstatic 68	kotlinx/coroutines/internal/j:ajAp	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   87: invokevirtual 109	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   90: astore 7
    //   92: aload 7
    //   94: invokevirtual 114	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   97: getstatic 73	kotlinx/coroutines/internal/j:ajAq	Ljava/util/WeakHashMap;
    //   100: aload_0
    //   101: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   104: invokevirtual 121	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 123	kotlin/g/a/b
    //   110: astore 8
    //   112: aload 7
    //   114: invokevirtual 126	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   117: aload 8
    //   119: ifnull +35 -> 154
    //   122: aload 8
    //   124: aload_0
    //   125: invokeinterface 129 2 0
    //   130: checkcast 55	java/lang/Throwable
    //   133: astore_0
    //   134: ldc 79
    //   136: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: areturn
    //   141: astore_0
    //   142: aload 7
    //   144: invokevirtual 126	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   147: ldc 79
    //   149: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: athrow
    //   154: getstatic 61	kotlinx/coroutines/internal/j:ajAo	I
    //   157: aload_0
    //   158: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   161: iconst_0
    //   162: invokestatic 59	kotlinx/coroutines/internal/j:d	(Ljava/lang/Class;I)I
    //   165: if_icmpeq +148 -> 313
    //   168: getstatic 68	kotlinx/coroutines/internal/j:ajAp	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   171: astore 8
    //   173: aload 8
    //   175: invokevirtual 109	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   178: astore 7
    //   180: aload 8
    //   182: invokevirtual 133	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   185: ifne +28 -> 213
    //   188: aload 8
    //   190: invokevirtual 136	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   193: istore_1
    //   194: iconst_0
    //   195: istore_2
    //   196: iload_2
    //   197: iload_1
    //   198: if_icmpge +20 -> 218
    //   201: aload 7
    //   203: invokevirtual 126	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   206: iload_2
    //   207: iconst_1
    //   208: iadd
    //   209: istore_2
    //   210: goto -14 -> 196
    //   213: iconst_0
    //   214: istore_1
    //   215: goto -21 -> 194
    //   218: aload 8
    //   220: invokevirtual 140	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   223: astore 8
    //   225: aload 8
    //   227: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   230: getstatic 73	kotlinx/coroutines/internal/j:ajAq	Ljava/util/WeakHashMap;
    //   233: checkcast 145	java/util/Map
    //   236: aload_0
    //   237: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   240: getstatic 151	kotlinx/coroutines/internal/j$f:ajAs	Lkotlinx/coroutines/internal/j$f;
    //   243: invokeinterface 155 3 0
    //   248: pop
    //   249: getstatic 161	kotlin/ah:aiuX	Lkotlin/ah;
    //   252: astore_0
    //   253: iload_3
    //   254: istore_2
    //   255: iload_2
    //   256: iload_1
    //   257: if_icmpge +15 -> 272
    //   260: aload 7
    //   262: invokevirtual 114	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: goto -14 -> 255
    //   272: aload 8
    //   274: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   277: ldc 79
    //   279: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aconst_null
    //   283: areturn
    //   284: iload_2
    //   285: iload_1
    //   286: if_icmpge +15 -> 301
    //   289: aload 7
    //   291: invokevirtual 114	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   294: iload_2
    //   295: iconst_1
    //   296: iadd
    //   297: istore_2
    //   298: goto -14 -> 284
    //   301: aload 8
    //   303: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   306: ldc 79
    //   308: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: aload_0
    //   312: athrow
    //   313: aload_0
    //   314: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   317: invokevirtual 168	java/lang/Class:getConstructors	()[Ljava/lang/reflect/Constructor;
    //   320: new 170	kotlinx/coroutines/internal/j$e
    //   323: dup
    //   324: invokespecial 171	kotlinx/coroutines/internal/j$e:<init>	()V
    //   327: checkcast 173	java/util/Comparator
    //   330: invokestatic 179	kotlin/a/k:b	([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;
    //   333: invokeinterface 185 1 0
    //   338: astore 9
    //   340: aconst_null
    //   341: astore 8
    //   343: aload 8
    //   345: astore 7
    //   347: aload 9
    //   349: invokeinterface 191 1 0
    //   354: ifeq +62 -> 416
    //   357: aload 9
    //   359: invokeinterface 195 1 0
    //   364: checkcast 197	java/lang/reflect/Constructor
    //   367: astore 7
    //   369: aload 7
    //   371: invokevirtual 201	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   374: astore 8
    //   376: aload 8
    //   378: arraylength
    //   379: tableswitch	default:+25 -> 404, 0:+195->574, 1:+129->508, 2:+82->461
    //   405: astore 7
    //   407: aload 7
    //   409: astore 8
    //   411: aload 7
    //   413: ifnull -70 -> 343
    //   416: getstatic 68	kotlinx/coroutines/internal/j:ajAp	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   419: astore 8
    //   421: aload 8
    //   423: invokevirtual 109	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   426: astore 9
    //   428: aload 8
    //   430: invokevirtual 133	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   433: ifne +158 -> 591
    //   436: aload 8
    //   438: invokevirtual 136	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   441: istore_1
    //   442: iconst_0
    //   443: istore_2
    //   444: iload_2
    //   445: iload_1
    //   446: if_icmpge +150 -> 596
    //   449: aload 9
    //   451: invokevirtual 126	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   454: iload_2
    //   455: iconst_1
    //   456: iadd
    //   457: istore_2
    //   458: goto -14 -> 444
    //   461: aload 8
    //   463: iconst_0
    //   464: aaload
    //   465: ldc 203
    //   467: invokestatic 209	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   470: ifeq +32 -> 502
    //   473: aload 8
    //   475: iconst_1
    //   476: aaload
    //   477: ldc 55
    //   479: invokestatic 209	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   482: ifeq +20 -> 502
    //   485: new 211	kotlinx/coroutines/internal/j$a
    //   488: dup
    //   489: aload 7
    //   491: invokespecial 214	kotlinx/coroutines/internal/j$a:<init>	(Ljava/lang/reflect/Constructor;)V
    //   494: checkcast 123	kotlin/g/a/b
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
    //   516: ldc 55
    //   518: invokestatic 209	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   521: ifeq +20 -> 541
    //   524: new 216	kotlinx/coroutines/internal/j$b
    //   527: dup
    //   528: aload 7
    //   530: invokespecial 217	kotlinx/coroutines/internal/j$b:<init>	(Ljava/lang/reflect/Constructor;)V
    //   533: checkcast 123	kotlin/g/a/b
    //   536: astore 7
    //   538: goto -131 -> 407
    //   541: aload 8
    //   543: ldc 203
    //   545: invokestatic 209	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   548: ifeq +20 -> 568
    //   551: new 219	kotlinx/coroutines/internal/j$c
    //   554: dup
    //   555: aload 7
    //   557: invokespecial 220	kotlinx/coroutines/internal/j$c:<init>	(Ljava/lang/reflect/Constructor;)V
    //   560: checkcast 123	kotlin/g/a/b
    //   563: astore 7
    //   565: goto -158 -> 407
    //   568: aconst_null
    //   569: astore 7
    //   571: goto -164 -> 407
    //   574: new 222	kotlinx/coroutines/internal/j$d
    //   577: dup
    //   578: aload 7
    //   580: invokespecial 223	kotlinx/coroutines/internal/j$d:<init>	(Ljava/lang/reflect/Constructor;)V
    //   583: checkcast 123	kotlin/g/a/b
    //   586: astore 7
    //   588: goto -181 -> 407
    //   591: iconst_0
    //   592: istore_1
    //   593: goto -151 -> 442
    //   596: aload 8
    //   598: invokevirtual 140	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   601: astore 10
    //   603: aload 10
    //   605: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   608: getstatic 73	kotlinx/coroutines/internal/j:ajAq	Ljava/util/WeakHashMap;
    //   611: checkcast 145	java/util/Map
    //   614: astore 11
    //   616: aload_0
    //   617: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   620: astore 12
    //   622: aload 7
    //   624: ifnonnull +48 -> 672
    //   627: getstatic 229	kotlinx/coroutines/internal/j$g:ajAt	Lkotlinx/coroutines/internal/j$g;
    //   630: checkcast 123	kotlin/g/a/b
    //   633: astore 8
    //   635: aload 11
    //   637: aload 12
    //   639: aload 8
    //   641: invokeinterface 155 3 0
    //   646: pop
    //   647: getstatic 161	kotlin/ah:aiuX	Lkotlin/ah;
    //   650: astore 8
    //   652: iload 5
    //   654: istore_2
    //   655: iload_2
    //   656: iload_1
    //   657: if_icmpge +22 -> 679
    //   660: aload 9
    //   662: invokevirtual 114	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   665: iload_2
    //   666: iconst_1
    //   667: iadd
    //   668: istore_2
    //   669: goto -14 -> 655
    //   672: aload 7
    //   674: astore 8
    //   676: goto -41 -> 635
    //   679: aload 10
    //   681: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   684: aload 7
    //   686: ifnonnull +39 -> 725
    //   689: ldc 79
    //   691: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   694: aconst_null
    //   695: areturn
    //   696: iload_2
    //   697: iload_1
    //   698: if_icmpge +15 -> 713
    //   701: aload 9
    //   703: invokevirtual 114	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   706: iload_2
    //   707: iconst_1
    //   708: iadd
    //   709: istore_2
    //   710: goto -14 -> 696
    //   713: aload 10
    //   715: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   718: ldc 79
    //   720: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   723: aload_0
    //   724: athrow
    //   725: aload 7
    //   727: aload_0
    //   728: invokeinterface 129 2 0
    //   733: checkcast 55	java/lang/Throwable
    //   736: astore_0
    //   737: ldc 79
    //   739: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   742: aload_0
    //   743: areturn
    //   744: astore_0
    //   745: iload 6
    //   747: istore_2
    //   748: goto -52 -> 696
    //   751: astore_0
    //   752: iload 4
    //   754: istore_2
    //   755: goto -471 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	paramE	E
    //   193	506	1	i	int
    //   195	560	2	j	int
    //   10	244	3	k	int
    //   1	752	4	m	int
    //   4	649	5	n	int
    //   7	739	6	i1	int
    //   26	700	7	localObject1	Object
    //   110	565	8	localObject2	Object
    //   338	364	9	localObject3	Object
    //   601	113	10	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   614	22	11	localMap	java.util.Map
    //   620	18	12	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   23	41	67	finally
    //   97	112	141	finally
    //   608	622	744	finally
    //   627	635	744	finally
    //   635	652	744	finally
    //   230	253	751	finally
  }
  
  private static final int d(Class<?> paramClass, int paramInt)
  {
    AppMethodBeat.i(189427);
    a.cx(paramClass);
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
      finally
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
      AppMethodBeat.o(189427);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.internal.j
 * JD-Core Version:    0.7.0.1
 */