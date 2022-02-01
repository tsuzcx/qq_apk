package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V>
{
  private static final b<Object, Object> TSl;
  private final d<a<e<K, V>>> TSm;
  private final int size;
  
  static
  {
    AppMethodBeat.i(61428);
    TSl = new b(d.hMc(), 0);
    AppMethodBeat.o(61428);
  }
  
  private b(d<a<e<K, V>>> paramd, int paramInt)
  {
    this.TSm = paramd;
    this.size = paramInt;
  }
  
  private static <K, V> int a(a<e<K, V>> parama, Object paramObject)
  {
    AppMethodBeat.i(61427);
    int i = 0;
    while ((parama != null) && (parama.size > 0))
    {
      if (((e)parama.first).key.equals(paramObject))
      {
        AppMethodBeat.o(61427);
        return i;
      }
      parama = parama.TSj;
      i += 1;
    }
    AppMethodBeat.o(61427);
    return -1;
  }
  
  public static <K, V> b<K, V> hMb()
  {
    AppMethodBeat.i(61424);
    Object localObject = TSl;
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty" }));
      AppMethodBeat.o(61424);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(61424);
    return localObject;
  }
  
  public final b<K, V> X(K paramK, V paramV)
  {
    AppMethodBeat.i(61425);
    a locala2 = avQ(paramK.hashCode());
    int i = locala2.size;
    int j = a(locala2, paramK);
    a locala1 = locala2;
    if (j != -1) {
      locala1 = locala2.avO(j);
    }
    paramV = locala1.fK(new e(paramK, paramV));
    paramK = this.TSm.w(paramK.hashCode(), paramV);
    j = this.size;
    paramK = new b(paramK, paramV.size + (j - i));
    AppMethodBeat.o(61425);
    return paramK;
  }
  
  public final a<e<K, V>> avQ(int paramInt)
  {
    AppMethodBeat.i(61426);
    a locala = (a)this.TSm.get(paramInt);
    if (locala == null)
    {
      locala = a.hMa();
      AppMethodBeat.o(61426);
      return locala;
    }
    AppMethodBeat.o(61426);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */