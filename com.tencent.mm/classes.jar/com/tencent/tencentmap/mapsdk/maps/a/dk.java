package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class dk
{
  final do a;
  final dw b;
  private final ThreadLocal<Map<fe<?>, dk.a<?>>> c;
  private final Map<fe<?>, eb<?>> d;
  private final List<ec> e;
  private final ej f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  
  public dk()
  {
    this(ek.a, di.a, Collections.emptyMap(), false, false, false, true, false, false, dz.a, Collections.emptyList());
    AppMethodBeat.i(147467);
    AppMethodBeat.o(147467);
  }
  
  dk(ek paramek, dj paramdj, Map<Type, dm<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, dz paramdz, List<ec> paramList)
  {
    AppMethodBeat.i(147468);
    this.c = new ThreadLocal();
    this.d = Collections.synchronizedMap(new HashMap());
    this.a = new dk.1(this);
    this.b = new dk.2(this);
    this.f = new ej(paramMap);
    this.g = paramBoolean1;
    this.i = paramBoolean3;
    this.h = paramBoolean4;
    this.j = paramBoolean5;
    paramMap = new ArrayList();
    paramMap.add(fd.Q);
    paramMap.add(ey.a);
    paramMap.add(paramek);
    paramMap.addAll(paramList);
    paramMap.add(fd.x);
    paramMap.add(fd.m);
    paramMap.add(fd.g);
    paramMap.add(fd.i);
    paramMap.add(fd.k);
    paramMap.add(fd.a(Long.TYPE, Long.class, a(paramdz)));
    paramMap.add(fd.a(Double.TYPE, Double.class, a(paramBoolean6)));
    paramMap.add(fd.a(Float.TYPE, Float.class, b(paramBoolean6)));
    paramMap.add(fd.r);
    paramMap.add(fd.t);
    paramMap.add(fd.z);
    paramMap.add(fd.B);
    paramMap.add(fd.a(BigDecimal.class, fd.v));
    paramMap.add(fd.a(BigInteger.class, fd.w));
    paramMap.add(fd.D);
    paramMap.add(fd.F);
    paramMap.add(fd.J);
    paramMap.add(fd.O);
    paramMap.add(fd.H);
    paramMap.add(fd.d);
    paramMap.add(eu.a);
    paramMap.add(fd.M);
    paramMap.add(fb.a);
    paramMap.add(fa.a);
    paramMap.add(fd.K);
    paramMap.add(es.a);
    paramMap.add(fd.R);
    paramMap.add(fd.b);
    paramMap.add(new et(this.f));
    paramMap.add(new ex(this.f, paramBoolean2));
    paramMap.add(new ez(this.f, paramdj, paramek));
    this.e = Collections.unmodifiableList(paramMap);
    AppMethodBeat.o(147468);
  }
  
  private eb<Number> a(dz paramdz)
  {
    AppMethodBeat.i(147472);
    if (paramdz == dz.a)
    {
      paramdz = fd.n;
      AppMethodBeat.o(147472);
      return paramdz;
    }
    paramdz = new dk.5(this);
    AppMethodBeat.o(147472);
    return paramdz;
  }
  
  private eb<Number> a(boolean paramBoolean)
  {
    AppMethodBeat.i(147469);
    if (paramBoolean)
    {
      localObject = fd.p;
      AppMethodBeat.o(147469);
      return localObject;
    }
    Object localObject = new eb()
    {
      public Double a(ff paramAnonymousff)
      {
        AppMethodBeat.i(147452);
        if (paramAnonymousff.f() == fg.i)
        {
          paramAnonymousff.j();
          AppMethodBeat.o(147452);
          return null;
        }
        double d = paramAnonymousff.k();
        AppMethodBeat.o(147452);
        return Double.valueOf(d);
      }
      
      public void a(fh paramAnonymousfh, Number paramAnonymousNumber)
      {
        AppMethodBeat.i(147453);
        if (paramAnonymousNumber == null)
        {
          paramAnonymousfh.f();
          AppMethodBeat.o(147453);
          return;
        }
        double d = paramAnonymousNumber.doubleValue();
        dk.a(dk.this, d);
        paramAnonymousfh.a(paramAnonymousNumber);
        AppMethodBeat.o(147453);
      }
    };
    AppMethodBeat.o(147469);
    return localObject;
  }
  
  private void a(double paramDouble)
  {
    AppMethodBeat.i(147471);
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialDoubleValues() method.");
      AppMethodBeat.o(147471);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(147471);
  }
  
  private static void a(Object paramObject, ff paramff)
  {
    AppMethodBeat.i(147479);
    if (paramObject != null) {}
    try
    {
      if (paramff.f() != fg.j)
      {
        paramObject = new dr("JSON document was not fully consumed.");
        AppMethodBeat.o(147479);
        throw paramObject;
      }
    }
    catch (fi paramObject)
    {
      paramObject = new dy(paramObject);
      AppMethodBeat.o(147479);
      throw paramObject;
      AppMethodBeat.o(147479);
      return;
    }
    catch (IOException paramObject)
    {
      paramObject = new dr(paramObject);
      AppMethodBeat.o(147479);
      throw paramObject;
    }
  }
  
  private eb<Number> b(boolean paramBoolean)
  {
    AppMethodBeat.i(147470);
    if (paramBoolean)
    {
      localObject = fd.o;
      AppMethodBeat.o(147470);
      return localObject;
    }
    Object localObject = new dk.4(this);
    AppMethodBeat.o(147470);
    return localObject;
  }
  
  public final <T> eb<T> a(ec paramec, fe<T> paramfe)
  {
    AppMethodBeat.i(147474);
    Iterator localIterator = this.e.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ec)localIterator.next();
      if (k == 0)
      {
        if (localObject == paramec) {
          k = 1;
        }
      }
      else
      {
        localObject = ((ec)localObject).a(this, paramfe);
        if (localObject != null)
        {
          AppMethodBeat.o(147474);
          return localObject;
        }
      }
    }
    paramec = new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(paramfe)));
    AppMethodBeat.o(147474);
    throw paramec;
  }
  
  public final <T> eb<T> a(fe<T> paramfe)
  {
    AppMethodBeat.i(147473);
    Object localObject1 = (eb)this.d.get(paramfe);
    if (localObject1 != null)
    {
      AppMethodBeat.o(147473);
      return localObject1;
    }
    localObject1 = (Map)this.c.get();
    int k = 0;
    if (localObject1 == null)
    {
      localObject1 = new HashMap();
      this.c.set(localObject1);
      k = 1;
    }
    for (;;)
    {
      Object localObject2 = (dk.a)((Map)localObject1).get(paramfe);
      if (localObject2 != null)
      {
        AppMethodBeat.o(147473);
        return localObject2;
      }
      try
      {
        localObject2 = new dk.a();
        ((Map)localObject1).put(paramfe, localObject2);
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          eb localeb = ((ec)localIterator.next()).a(this, paramfe);
          if (localeb != null)
          {
            ((dk.a)localObject2).a(localeb);
            this.d.put(paramfe, localeb);
            return localeb;
          }
        }
        localObject2 = new IllegalArgumentException("GSON cannot handle ".concat(String.valueOf(paramfe)));
        AppMethodBeat.o(147473);
        throw ((Throwable)localObject2);
      }
      finally
      {
        ((Map)localObject1).remove(paramfe);
        if (k != 0) {
          this.c.remove();
        }
        AppMethodBeat.o(147473);
      }
    }
  }
  
  public final <T> eb<T> a(Class<T> paramClass)
  {
    AppMethodBeat.i(147475);
    paramClass = a(fe.b(paramClass));
    AppMethodBeat.o(147475);
    return paramClass;
  }
  
  public final <T> T a(dq paramdq, Type paramType)
  {
    AppMethodBeat.i(147481);
    if (paramdq == null)
    {
      AppMethodBeat.o(147481);
      return null;
    }
    paramdq = a(new ev(paramdq), paramType);
    AppMethodBeat.o(147481);
    return paramdq;
  }
  
  /* Error */
  public final <T> T a(ff paramff, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 433
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokevirtual 435	com/tencent/tencentmap/mapsdk/maps/a/ff:p	()Z
    //   12: istore 4
    //   14: aload_1
    //   15: iconst_1
    //   16: invokevirtual 438	com/tencent/tencentmap/mapsdk/maps/a/ff:a	(Z)V
    //   19: aload_1
    //   20: invokevirtual 319	com/tencent/tencentmap/mapsdk/maps/a/ff:f	()Lcom/tencent/tencentmap/mapsdk/maps/a/fg;
    //   23: pop
    //   24: iconst_0
    //   25: istore_3
    //   26: aload_0
    //   27: aload_2
    //   28: invokestatic 441	com/tencent/tencentmap/mapsdk/maps/a/fe:a	(Ljava/lang/reflect/Type;)Lcom/tencent/tencentmap/mapsdk/maps/a/fe;
    //   31: invokevirtual 416	com/tencent/tencentmap/mapsdk/maps/a/dk:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/fe;)Lcom/tencent/tencentmap/mapsdk/maps/a/eb;
    //   34: aload_1
    //   35: invokevirtual 444	com/tencent/tencentmap/mapsdk/maps/a/eb:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/ff;)Ljava/lang/Object;
    //   38: astore_2
    //   39: aload_1
    //   40: iload 4
    //   42: invokevirtual 438	com/tencent/tencentmap/mapsdk/maps/a/ff:a	(Z)V
    //   45: ldc_w 433
    //   48: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: iload_3
    //   55: ifeq +17 -> 72
    //   58: aload_1
    //   59: iload 4
    //   61: invokevirtual 438	com/tencent/tencentmap/mapsdk/maps/a/ff:a	(Z)V
    //   64: ldc_w 433
    //   67: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: areturn
    //   72: new 331	com/tencent/tencentmap/mapsdk/maps/a/dy
    //   75: dup
    //   76: aload_2
    //   77: invokespecial 334	com/tencent/tencentmap/mapsdk/maps/a/dy:<init>	(Ljava/lang/Throwable;)V
    //   80: astore_2
    //   81: ldc_w 433
    //   84: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_2
    //   88: athrow
    //   89: astore_2
    //   90: aload_1
    //   91: iload 4
    //   93: invokevirtual 438	com/tencent/tencentmap/mapsdk/maps/a/ff:a	(Z)V
    //   96: ldc_w 433
    //   99: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: new 331	com/tencent/tencentmap/mapsdk/maps/a/dy
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 334	com/tencent/tencentmap/mapsdk/maps/a/dy:<init>	(Ljava/lang/Throwable;)V
    //   113: astore_2
    //   114: ldc_w 433
    //   117: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: new 331	com/tencent/tencentmap/mapsdk/maps/a/dy
    //   126: dup
    //   127: aload_2
    //   128: invokespecial 334	com/tencent/tencentmap/mapsdk/maps/a/dy:<init>	(Ljava/lang/Throwable;)V
    //   131: astore_2
    //   132: ldc_w 433
    //   135: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_2
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	dk
    //   0	140	1	paramff	ff
    //   0	140	2	paramType	Type
    //   1	54	3	k	int
    //   12	80	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	24	53	java/io/EOFException
    //   26	39	53	java/io/EOFException
    //   19	24	89	finally
    //   26	39	89	finally
    //   72	89	89	finally
    //   105	122	89	finally
    //   123	140	89	finally
    //   19	24	104	java/lang/IllegalStateException
    //   26	39	104	java/lang/IllegalStateException
    //   19	24	122	java/io/IOException
    //   26	39	122	java/io/IOException
  }
  
  public final <T> T a(Reader paramReader, Type paramType)
  {
    AppMethodBeat.i(147478);
    paramReader = new ff(paramReader);
    paramType = a(paramReader, paramType);
    a(paramType, paramReader);
    AppMethodBeat.o(147478);
    return paramType;
  }
  
  public final <T> T a(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(147476);
    paramString = a(paramString, paramClass);
    paramString = ep.a(paramClass).cast(paramString);
    AppMethodBeat.o(147476);
    return paramString;
  }
  
  public final <T> T a(String paramString, Type paramType)
  {
    AppMethodBeat.i(147477);
    if (paramString == null)
    {
      AppMethodBeat.o(147477);
      return null;
    }
    paramString = a(new StringReader(paramString), paramType);
    AppMethodBeat.o(147477);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147482);
    String str = "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    AppMethodBeat.o(147482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dk
 * JD-Core Version:    0.7.0.1
 */