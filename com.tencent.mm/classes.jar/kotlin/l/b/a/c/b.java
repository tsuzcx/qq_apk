package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V>
{
  private static final b<Object, Object> ajtP;
  private final d<a<e<K, V>>> ajtQ;
  private final int size;
  
  static
  {
    AppMethodBeat.i(61428);
    ajtP = new b(d.kBh(), 0);
    AppMethodBeat.o(61428);
  }
  
  private b(d<a<e<K, V>>> paramd, int paramInt)
  {
    this.ajtQ = paramd;
    this.size = paramInt;
  }
  
  private static <K, V> int a(a<e<K, V>> parama, Object paramObject)
  {
    AppMethodBeat.i(61427);
    int i = 0;
    while ((parama != null) && (parama.size > 0))
    {
      if (((e)parama.bsC).key.equals(paramObject))
      {
        AppMethodBeat.o(61427);
        return i;
      }
      parama = parama.ajtN;
      i += 1;
    }
    AppMethodBeat.o(61427);
    return -1;
  }
  
  public static <K, V> b<K, V> kBg()
  {
    AppMethodBeat.i(61424);
    Object localObject = ajtP;
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty" }));
      AppMethodBeat.o(61424);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(61424);
    return localObject;
  }
  
  public final a<e<K, V>> aMx(int paramInt)
  {
    AppMethodBeat.i(61426);
    a locala = (a)this.ajtQ.get(paramInt);
    if (locala == null)
    {
      locala = a.kBf();
      AppMethodBeat.o(61426);
      return locala;
    }
    AppMethodBeat.o(61426);
    return locala;
  }
  
  public final b<K, V> ab(K paramK, V paramV)
  {
    AppMethodBeat.i(61425);
    a locala2 = aMx(paramK.hashCode());
    int i = locala2.size;
    int j = a(locala2, paramK);
    a locala1 = locala2;
    if (j != -1) {
      locala1 = locala2.aMv(j);
    }
    paramV = locala1.is(new e(paramK, paramV));
    paramK = this.ajtQ.W(paramK.hashCode(), paramV);
    j = this.size;
    paramK = new b(paramK, paramV.size + (j - i));
    AppMethodBeat.o(61425);
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */