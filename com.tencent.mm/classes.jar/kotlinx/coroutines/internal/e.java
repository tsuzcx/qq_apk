package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.p;
import d.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"})
public final class e
{
  private static final int NJA;
  private static final ReentrantReadWriteLock NJB;
  private static final WeakHashMap<Class<? extends Throwable>, b<Throwable, Throwable>> NJC;
  
  static
  {
    AppMethodBeat.i(190855);
    NJA = c(Throwable.class, -1);
    NJB = new ReentrantReadWriteLock();
    NJC = new WeakHashMap();
    AppMethodBeat.o(190855);
  }
  
  /* Error */
  public static final <E extends Throwable> E D(E paramE)
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
    //   23: getstatic 97	d/p:MKe	Ld/p$a;
    //   26: astore 7
    //   28: aload_0
    //   29: checkcast 91	kotlinx/coroutines/aa
    //   32: invokeinterface 101 1 0
    //   37: invokestatic 105	d/p:eL	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore_0
    //   41: aload_0
    //   42: astore 7
    //   44: aload_0
    //   45: invokestatic 109	d/p:eJ	(Ljava/lang/Object;)Z
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
    //   68: getstatic 97	d/p:MKe	Ld/p$a;
    //   71: astore 7
    //   73: aload_0
    //   74: invokestatic 114	d/q:o	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   77: invokestatic 105	d/p:eL	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore_0
    //   81: goto -40 -> 41
    //   84: getstatic 78	kotlinx/coroutines/internal/e:NJB	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   87: invokevirtual 118	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   90: astore 7
    //   92: aload 7
    //   94: invokevirtual 123	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   97: getstatic 83	kotlinx/coroutines/internal/e:NJC	Ljava/util/WeakHashMap;
    //   100: aload_0
    //   101: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   104: invokevirtual 130	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 132	d/g/a/b
    //   110: astore 8
    //   112: aload 7
    //   114: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   117: aload 8
    //   119: ifnull +35 -> 154
    //   122: aload 8
    //   124: aload_0
    //   125: invokeinterface 138 2 0
    //   130: checkcast 65	java/lang/Throwable
    //   133: astore_0
    //   134: ldc 89
    //   136: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: areturn
    //   141: astore_0
    //   142: aload 7
    //   144: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   147: ldc 89
    //   149: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: athrow
    //   154: getstatic 71	kotlinx/coroutines/internal/e:NJA	I
    //   157: aload_0
    //   158: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   161: iconst_0
    //   162: invokestatic 69	kotlinx/coroutines/internal/e:c	(Ljava/lang/Class;I)I
    //   165: if_icmpeq +148 -> 313
    //   168: getstatic 78	kotlinx/coroutines/internal/e:NJB	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   171: astore 8
    //   173: aload 8
    //   175: invokevirtual 118	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   178: astore 7
    //   180: aload 8
    //   182: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   185: ifne +28 -> 213
    //   188: aload 8
    //   190: invokevirtual 145	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   193: istore_1
    //   194: iconst_0
    //   195: istore_2
    //   196: iload_2
    //   197: iload_1
    //   198: if_icmpge +20 -> 218
    //   201: aload 7
    //   203: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   206: iload_2
    //   207: iconst_1
    //   208: iadd
    //   209: istore_2
    //   210: goto -14 -> 196
    //   213: iconst_0
    //   214: istore_1
    //   215: goto -21 -> 194
    //   218: aload 8
    //   220: invokevirtual 149	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   223: astore 8
    //   225: aload 8
    //   227: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   230: getstatic 83	kotlinx/coroutines/internal/e:NJC	Ljava/util/WeakHashMap;
    //   233: checkcast 154	java/util/Map
    //   236: aload_0
    //   237: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   240: getstatic 158	kotlinx/coroutines/internal/e$f:NJE	Lkotlinx/coroutines/internal/e$f;
    //   243: invokeinterface 162 3 0
    //   248: pop
    //   249: getstatic 168	d/z:MKo	Ld/z;
    //   252: astore_0
    //   253: iload_3
    //   254: istore_2
    //   255: iload_2
    //   256: iload_1
    //   257: if_icmpge +15 -> 272
    //   260: aload 7
    //   262: invokevirtual 123	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: goto -14 -> 255
    //   272: aload 8
    //   274: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   277: ldc 89
    //   279: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aconst_null
    //   283: areturn
    //   284: iload_2
    //   285: iload_1
    //   286: if_icmpge +15 -> 301
    //   289: aload 7
    //   291: invokevirtual 123	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   294: iload_2
    //   295: iconst_1
    //   296: iadd
    //   297: istore_2
    //   298: goto -14 -> 284
    //   301: aload 8
    //   303: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   306: ldc 89
    //   308: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: aload_0
    //   312: athrow
    //   313: aload_0
    //   314: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   317: invokevirtual 175	java/lang/Class:getConstructors	()[Ljava/lang/reflect/Constructor;
    //   320: new 14	kotlinx/coroutines/internal/e$e
    //   323: dup
    //   324: invokespecial 176	kotlinx/coroutines/internal/e$e:<init>	()V
    //   327: checkcast 178	java/util/Comparator
    //   330: invokestatic 184	d/a/e:b	([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;
    //   333: invokeinterface 190 1 0
    //   338: astore 9
    //   340: aconst_null
    //   341: astore 8
    //   343: aload 8
    //   345: astore 7
    //   347: aload 9
    //   349: invokeinterface 196 1 0
    //   354: ifeq +62 -> 416
    //   357: aload 9
    //   359: invokeinterface 200 1 0
    //   364: checkcast 202	java/lang/reflect/Constructor
    //   367: astore 7
    //   369: aload 7
    //   371: invokevirtual 206	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   374: astore 8
    //   376: aload 8
    //   378: arraylength
    //   379: tableswitch	default:+25 -> 404, 0:+195->574, 1:+129->508, 2:+82->461
    //   405: astore 7
    //   407: aload 7
    //   409: astore 8
    //   411: aload 7
    //   413: ifnull -70 -> 343
    //   416: getstatic 78	kotlinx/coroutines/internal/e:NJB	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   419: astore 8
    //   421: aload 8
    //   423: invokevirtual 118	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   426: astore 9
    //   428: aload 8
    //   430: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   433: ifne +158 -> 591
    //   436: aload 8
    //   438: invokevirtual 145	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   441: istore_1
    //   442: iconst_0
    //   443: istore_2
    //   444: iload_2
    //   445: iload_1
    //   446: if_icmpge +150 -> 596
    //   449: aload 9
    //   451: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   454: iload_2
    //   455: iconst_1
    //   456: iadd
    //   457: istore_2
    //   458: goto -14 -> 444
    //   461: aload 8
    //   463: iconst_0
    //   464: aaload
    //   465: ldc 208
    //   467: invokestatic 213	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   470: ifeq +32 -> 502
    //   473: aload 8
    //   475: iconst_1
    //   476: aaload
    //   477: ldc 65
    //   479: invokestatic 213	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   482: ifeq +20 -> 502
    //   485: new 6	kotlinx/coroutines/internal/e$a
    //   488: dup
    //   489: aload 7
    //   491: invokespecial 216	kotlinx/coroutines/internal/e$a:<init>	(Ljava/lang/reflect/Constructor;)V
    //   494: checkcast 132	d/g/a/b
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
    //   518: invokestatic 213	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   521: ifeq +20 -> 541
    //   524: new 8	kotlinx/coroutines/internal/e$b
    //   527: dup
    //   528: aload 7
    //   530: invokespecial 217	kotlinx/coroutines/internal/e$b:<init>	(Ljava/lang/reflect/Constructor;)V
    //   533: checkcast 132	d/g/a/b
    //   536: astore 7
    //   538: goto -131 -> 407
    //   541: aload 8
    //   543: ldc 208
    //   545: invokestatic 213	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   548: ifeq +20 -> 568
    //   551: new 10	kotlinx/coroutines/internal/e$c
    //   554: dup
    //   555: aload 7
    //   557: invokespecial 218	kotlinx/coroutines/internal/e$c:<init>	(Ljava/lang/reflect/Constructor;)V
    //   560: checkcast 132	d/g/a/b
    //   563: astore 7
    //   565: goto -158 -> 407
    //   568: aconst_null
    //   569: astore 7
    //   571: goto -164 -> 407
    //   574: new 12	kotlinx/coroutines/internal/e$d
    //   577: dup
    //   578: aload 7
    //   580: invokespecial 219	kotlinx/coroutines/internal/e$d:<init>	(Ljava/lang/reflect/Constructor;)V
    //   583: checkcast 132	d/g/a/b
    //   586: astore 7
    //   588: goto -181 -> 407
    //   591: iconst_0
    //   592: istore_1
    //   593: goto -151 -> 442
    //   596: aload 8
    //   598: invokevirtual 149	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   601: astore 10
    //   603: aload 10
    //   605: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   608: getstatic 83	kotlinx/coroutines/internal/e:NJC	Ljava/util/WeakHashMap;
    //   611: checkcast 154	java/util/Map
    //   614: astore 11
    //   616: aload_0
    //   617: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   620: astore 12
    //   622: aload 7
    //   624: ifnonnull +127 -> 751
    //   627: getstatic 223	kotlinx/coroutines/internal/e$g:NJF	Lkotlinx/coroutines/internal/e$g;
    //   630: checkcast 132	d/g/a/b
    //   633: astore 8
    //   635: aload 11
    //   637: aload 12
    //   639: aload 8
    //   641: invokeinterface 162 3 0
    //   646: pop
    //   647: getstatic 168	d/z:MKo	Ld/z;
    //   650: astore 8
    //   652: iload 5
    //   654: istore_2
    //   655: iload_2
    //   656: iload_1
    //   657: if_icmpge +15 -> 672
    //   660: aload 9
    //   662: invokevirtual 123	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   665: iload_2
    //   666: iconst_1
    //   667: iadd
    //   668: istore_2
    //   669: goto -14 -> 655
    //   672: aload 10
    //   674: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   677: aload 7
    //   679: ifnull +51 -> 730
    //   682: aload 7
    //   684: aload_0
    //   685: invokeinterface 138 2 0
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
    //   708: invokevirtual 123	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   711: iload_2
    //   712: iconst_1
    //   713: iadd
    //   714: istore_2
    //   715: goto -14 -> 701
    //   718: aload 10
    //   720: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
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
    AppMethodBeat.i(190854);
    d.g.a.bo(paramClass);
    int j;
    int k;
    int n;
    for (;;)
    {
      try
      {
        localObject = p.MKe;
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
        paramClass = p.eL(Integer.valueOf(i));
      }
      catch (Throwable paramClass)
      {
        Object localObject = p.MKe;
        paramClass = p.eL(d.q.o(paramClass));
        continue;
      }
      localObject = paramClass;
      if (p.eJ(paramClass)) {
        localObject = Integer.valueOf(paramInt);
      }
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(190854);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
  public static final class a
    extends d.g.b.q
    implements b<Throwable, Throwable>
  {
    public a(Constructor paramConstructor)
    {
      super();
    }
    
    private Throwable E(Throwable paramThrowable)
    {
      AppMethodBeat.i(190824);
      Object localObject;
      try
      {
        localObject = p.MKe;
        paramThrowable = this.NJD.newInstance(new Object[] { paramThrowable.getMessage(), paramThrowable });
        if (paramThrowable == null)
        {
          paramThrowable = new v("null cannot be cast to non-null type kotlin.Throwable");
          AppMethodBeat.o(190824);
          throw paramThrowable;
        }
      }
      catch (Throwable paramThrowable)
      {
        localObject = p.MKe;
        paramThrowable = p.eL(d.q.o(paramThrowable));
      }
      for (;;)
      {
        localObject = paramThrowable;
        if (p.eJ(paramThrowable)) {
          localObject = null;
        }
        paramThrowable = (Throwable)localObject;
        AppMethodBeat.o(190824);
        return paramThrowable;
        paramThrowable = p.eL((Throwable)paramThrowable);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
  public static final class b
    extends d.g.b.q
    implements b<Throwable, Throwable>
  {
    public b(Constructor paramConstructor)
    {
      super();
    }
    
    private Throwable E(Throwable paramThrowable)
    {
      AppMethodBeat.i(190852);
      Object localObject;
      try
      {
        localObject = p.MKe;
        paramThrowable = this.NJD.newInstance(new Object[] { paramThrowable });
        if (paramThrowable == null)
        {
          paramThrowable = new v("null cannot be cast to non-null type kotlin.Throwable");
          AppMethodBeat.o(190852);
          throw paramThrowable;
        }
      }
      catch (Throwable paramThrowable)
      {
        localObject = p.MKe;
        paramThrowable = p.eL(d.q.o(paramThrowable));
      }
      for (;;)
      {
        localObject = paramThrowable;
        if (p.eJ(paramThrowable)) {
          localObject = null;
        }
        paramThrowable = (Throwable)localObject;
        AppMethodBeat.o(190852);
        return paramThrowable;
        paramThrowable = p.eL((Throwable)paramThrowable);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
  public static final class c
    extends d.g.b.q
    implements b<Throwable, Throwable>
  {
    public c(Constructor paramConstructor)
    {
      super();
    }
    
    private Throwable E(Throwable paramThrowable)
    {
      AppMethodBeat.i(190813);
      Object localObject;
      try
      {
        localObject = p.MKe;
        localObject = this.NJD.newInstance(new Object[] { paramThrowable.getMessage() });
        if (localObject == null)
        {
          paramThrowable = new v("null cannot be cast to non-null type kotlin.Throwable");
          AppMethodBeat.o(190813);
          throw paramThrowable;
        }
      }
      catch (Throwable paramThrowable)
      {
        localObject = p.MKe;
        paramThrowable = p.eL(d.q.o(paramThrowable));
      }
      for (;;)
      {
        localObject = paramThrowable;
        if (p.eJ(paramThrowable)) {
          localObject = null;
        }
        paramThrowable = (Throwable)localObject;
        AppMethodBeat.o(190813);
        return paramThrowable;
        localObject = (Throwable)localObject;
        ((Throwable)localObject).initCause(paramThrowable);
        paramThrowable = p.eL(localObject);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
  public static final class d
    extends d.g.b.q
    implements b<Throwable, Throwable>
  {
    public d(Constructor paramConstructor)
    {
      super();
    }
    
    private Throwable E(Throwable paramThrowable)
    {
      AppMethodBeat.i(190826);
      Object localObject;
      try
      {
        localObject = p.MKe;
        localObject = this.NJD.newInstance(new Object[0]);
        if (localObject == null)
        {
          paramThrowable = new v("null cannot be cast to non-null type kotlin.Throwable");
          AppMethodBeat.o(190826);
          throw paramThrowable;
        }
      }
      catch (Throwable paramThrowable)
      {
        localObject = p.MKe;
        paramThrowable = p.eL(d.q.o(paramThrowable));
      }
      for (;;)
      {
        localObject = paramThrowable;
        if (p.eJ(paramThrowable)) {
          localObject = null;
        }
        paramThrowable = (Throwable)localObject;
        AppMethodBeat.o(190826);
        return paramThrowable;
        localObject = (Throwable)localObject;
        ((Throwable)localObject).initCause(paramThrowable);
        paramThrowable = p.eL(localObject);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(190817);
      int i = d.b.a.a((Comparable)Integer.valueOf(((Constructor)paramT2).getParameterTypes().length), (Comparable)Integer.valueOf(((Constructor)paramT1).getParameterTypes().length));
      AppMethodBeat.o(190817);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "E", "", "it", "invoke"})
  static final class f
    extends d.g.b.q
    implements b
  {
    public static final f NJE;
    
    static
    {
      AppMethodBeat.i(190842);
      NJE = new f();
      AppMethodBeat.o(190842);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "E", "", "it", "invoke"})
  static final class g
    extends d.g.b.q
    implements b
  {
    public static final g NJF;
    
    static
    {
      AppMethodBeat.i(190816);
      NJF = new g();
      AppMethodBeat.o(190816);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.e
 * JD-Core Version:    0.7.0.1
 */