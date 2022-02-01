package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c<V>
{
  static final c<Object> abuM;
  private final c<V> abuN;
  private final c<V> abuO;
  private final long key;
  private final int size;
  private final V value;
  
  static
  {
    AppMethodBeat.i(61434);
    abuM = new c();
    AppMethodBeat.o(61434);
  }
  
  private c()
  {
    this.size = 0;
    this.key = 0L;
    this.value = null;
    this.abuN = null;
    this.abuO = null;
  }
  
  private c(long paramLong, V paramV, c<V> paramc1, c<V> paramc2)
  {
    AppMethodBeat.i(61429);
    this.key = paramLong;
    this.value = paramV;
    this.abuN = paramc1;
    this.abuO = paramc2;
    this.size = (paramc1.size + 1 + paramc2.size);
    AppMethodBeat.o(61429);
  }
  
  private c<V> XA(long paramLong)
  {
    AppMethodBeat.i(61430);
    if ((this.size == 0) || (paramLong == this.key))
    {
      AppMethodBeat.o(61430);
      return this;
    }
    c localc = new c(paramLong, this.value, this.abuN, this.abuO);
    AppMethodBeat.o(61430);
    return localc;
  }
  
  private static <V> c<V> a(long paramLong, V paramV, c<V> paramc1, c<V> paramc2)
  {
    AppMethodBeat.i(61433);
    if (paramc1.size + paramc2.size > 1)
    {
      c localc3;
      c localc1;
      c localc2;
      Object localObject;
      if (paramc1.size >= paramc2.size * 5)
      {
        localc3 = paramc1.abuN;
        localc1 = paramc1.abuO;
        if (localc1.size < localc3.size * 2)
        {
          paramV = new c(paramc1.key + paramLong, paramc1.value, localc3, new c(-paramc1.key, paramV, localc1.XA(localc1.key + paramc1.key), paramc2));
          AppMethodBeat.o(61433);
          return paramV;
        }
        c localc4 = localc1.abuN;
        localc2 = localc1.abuO;
        long l1 = localc1.key;
        long l2 = paramc1.key;
        localObject = localc1.value;
        localc3 = new c(-localc1.key, paramc1.value, localc3, localc4.XA(localc4.key + localc1.key));
        long l3 = -paramc1.key;
        long l4 = localc1.key;
        long l5 = localc2.key;
        paramV = new c(l1 + l2 + paramLong, localObject, localc3, new c(l3 - l4, paramV, localc2.XA(localc1.key + l5 + paramc1.key), paramc2));
        AppMethodBeat.o(61433);
        return paramV;
      }
      if (paramc2.size >= paramc1.size * 5)
      {
        localc1 = paramc2.abuN;
        localc2 = paramc2.abuO;
        if (localc1.size < localc2.size * 2)
        {
          paramV = new c(paramc2.key + paramLong, paramc2.value, new c(-paramc2.key, paramV, paramc1, localc1.XA(localc1.key + paramc2.key)), localc2);
          AppMethodBeat.o(61433);
          return paramV;
        }
        localObject = localc1.abuN;
        localc3 = localc1.abuO;
        paramV = new c(localc1.key + paramc2.key + paramLong, localc1.value, new c(-paramc2.key - localc1.key, paramV, paramc1, ((c)localObject).XA(((c)localObject).key + localc1.key + paramc2.key)), new c(-localc1.key, paramc2.value, localc3.XA(localc3.key + localc1.key), localc2));
        AppMethodBeat.o(61433);
        return paramV;
      }
    }
    paramV = new c(paramLong, paramV, paramc1, paramc2);
    AppMethodBeat.o(61433);
    return paramV;
  }
  
  private c<V> a(c<V> paramc1, c<V> paramc2)
  {
    AppMethodBeat.i(61432);
    if ((paramc1 == this.abuN) && (paramc2 == this.abuO))
    {
      AppMethodBeat.o(61432);
      return this;
    }
    paramc1 = a(this.key, this.value, paramc1, paramc2);
    AppMethodBeat.o(61432);
    return paramc1;
  }
  
  final V aX(long paramLong)
  {
    Object localObject = this;
    for (;;)
    {
      if (((c)localObject).size == 0) {
        return null;
      }
      c localc;
      if (paramLong < ((c)localObject).key)
      {
        localc = ((c)localObject).abuN;
        paramLong -= ((c)localObject).key;
        localObject = localc;
      }
      else
      {
        if (paramLong <= ((c)localObject).key) {
          break;
        }
        localc = ((c)localObject).abuO;
        paramLong -= ((c)localObject).key;
        localObject = localc;
      }
    }
    return ((c)localObject).value;
  }
  
  final c<V> g(long paramLong, V paramV)
  {
    AppMethodBeat.i(61431);
    if (this.size == 0)
    {
      paramV = new c(paramLong, paramV, this, this);
      AppMethodBeat.o(61431);
      return paramV;
    }
    if (paramLong < this.key)
    {
      paramV = a(this.abuN.g(paramLong - this.key, paramV), this.abuO);
      AppMethodBeat.o(61431);
      return paramV;
    }
    if (paramLong > this.key)
    {
      paramV = a(this.abuN, this.abuO.g(paramLong - this.key, paramV));
      AppMethodBeat.o(61431);
      return paramV;
    }
    if (paramV == this.value)
    {
      AppMethodBeat.o(61431);
      return this;
    }
    paramV = new c(paramLong, paramV, this.abuN, this.abuO);
    AppMethodBeat.o(61431);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.c.c
 * JD-Core Version:    0.7.0.1
 */