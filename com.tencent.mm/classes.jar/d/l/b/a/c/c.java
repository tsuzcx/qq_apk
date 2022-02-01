package d.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c<V>
{
  static final c<Object> KbX;
  private final c<V> KbY;
  private final c<V> KbZ;
  private final long key;
  private final int size;
  private final V value;
  
  static
  {
    AppMethodBeat.i(61434);
    KbX = new c();
    AppMethodBeat.o(61434);
  }
  
  private c()
  {
    this.size = 0;
    this.key = 0L;
    this.value = null;
    this.KbY = null;
    this.KbZ = null;
  }
  
  private c(long paramLong, V paramV, c<V> paramc1, c<V> paramc2)
  {
    AppMethodBeat.i(61429);
    this.key = paramLong;
    this.value = paramV;
    this.KbY = paramc1;
    this.KbZ = paramc2;
    this.size = (paramc1.size + 1 + paramc2.size);
    AppMethodBeat.o(61429);
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
        localc3 = paramc1.KbY;
        localc1 = paramc1.KbZ;
        if (localc1.size < localc3.size * 2)
        {
          paramV = new c(paramc1.key + paramLong, paramc1.value, localc3, new c(-paramc1.key, paramV, localc1.xK(localc1.key + paramc1.key), paramc2));
          AppMethodBeat.o(61433);
          return paramV;
        }
        c localc4 = localc1.KbY;
        localc2 = localc1.KbZ;
        long l1 = localc1.key;
        long l2 = paramc1.key;
        localObject = localc1.value;
        localc3 = new c(-localc1.key, paramc1.value, localc3, localc4.xK(localc4.key + localc1.key));
        long l3 = -paramc1.key;
        long l4 = localc1.key;
        long l5 = localc2.key;
        paramV = new c(l1 + l2 + paramLong, localObject, localc3, new c(l3 - l4, paramV, localc2.xK(localc1.key + l5 + paramc1.key), paramc2));
        AppMethodBeat.o(61433);
        return paramV;
      }
      if (paramc2.size >= paramc1.size * 5)
      {
        localc1 = paramc2.KbY;
        localc2 = paramc2.KbZ;
        if (localc1.size < localc2.size * 2)
        {
          paramV = new c(paramc2.key + paramLong, paramc2.value, new c(-paramc2.key, paramV, paramc1, localc1.xK(localc1.key + paramc2.key)), localc2);
          AppMethodBeat.o(61433);
          return paramV;
        }
        localObject = localc1.KbY;
        localc3 = localc1.KbZ;
        paramV = new c(localc1.key + paramc2.key + paramLong, localc1.value, new c(-paramc2.key - localc1.key, paramV, paramc1, ((c)localObject).xK(((c)localObject).key + localc1.key + paramc2.key)), new c(-localc1.key, paramc2.value, localc3.xK(localc3.key + localc1.key), localc2));
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
    if ((paramc1 == this.KbY) && (paramc2 == this.KbZ))
    {
      AppMethodBeat.o(61432);
      return this;
    }
    paramc1 = a(this.key, this.value, paramc1, paramc2);
    AppMethodBeat.o(61432);
    return paramc1;
  }
  
  private c<V> xK(long paramLong)
  {
    AppMethodBeat.i(61430);
    if ((this.size == 0) || (paramLong == this.key))
    {
      AppMethodBeat.o(61430);
      return this;
    }
    c localc = new c(paramLong, this.value, this.KbY, this.KbZ);
    AppMethodBeat.o(61430);
    return localc;
  }
  
  final c<V> e(long paramLong, V paramV)
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
      paramV = a(this.KbY.e(paramLong - this.key, paramV), this.KbZ);
      AppMethodBeat.o(61431);
      return paramV;
    }
    if (paramLong > this.key)
    {
      paramV = a(this.KbY, this.KbZ.e(paramLong - this.key, paramV));
      AppMethodBeat.o(61431);
      return paramV;
    }
    if (paramV == this.value)
    {
      AppMethodBeat.o(61431);
      return this;
    }
    paramV = new c(paramLong, paramV, this.KbY, this.KbZ);
    AppMethodBeat.o(61431);
    return paramV;
  }
  
  final V get(long paramLong)
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
        localc = ((c)localObject).KbY;
        paramLong -= ((c)localObject).key;
        localObject = localc;
      }
      else
      {
        if (paramLong <= ((c)localObject).key) {
          break;
        }
        localc = ((c)localObject).KbZ;
        paramLong -= ((c)localObject).key;
        localObject = localc;
      }
    }
    return ((c)localObject).value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.c.c
 * JD-Core Version:    0.7.0.1
 */