package d.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V>
{
  private static final b<Object, Object> Odr;
  private final d<a<e<K, V>>> Ods;
  private final int size;
  
  static
  {
    AppMethodBeat.i(61428);
    Odr = new b(d.gyZ(), 0);
    AppMethodBeat.o(61428);
  }
  
  private b(d<a<e<K, V>>> paramd, int paramInt)
  {
    this.Ods = paramd;
    this.size = paramInt;
  }
  
  private static <K, V> int a(a<e<K, V>> parama, Object paramObject)
  {
    AppMethodBeat.i(61427);
    int i = 0;
    while ((parama != null) && (parama.size > 0))
    {
      if (((e)parama.first).aIw.equals(paramObject))
      {
        AppMethodBeat.o(61427);
        return i;
      }
      parama = parama.Odp;
      i += 1;
    }
    AppMethodBeat.o(61427);
    return -1;
  }
  
  public static <K, V> b<K, V> gyY()
  {
    AppMethodBeat.i(61424);
    Object localObject = Odr;
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty" }));
      AppMethodBeat.o(61424);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(61424);
    return localObject;
  }
  
  public final b<K, V> U(K paramK, V paramV)
  {
    AppMethodBeat.i(61425);
    a locala2 = amh(paramK.hashCode());
    int i = locala2.size;
    int j = a(locala2, paramK);
    a locala1 = locala2;
    if (j != -1) {
      locala1 = locala2.amf(j);
    }
    paramV = locala1.fG(new e(paramK, paramV));
    paramK = this.Ods.r(paramK.hashCode(), paramV);
    j = this.size;
    paramK = new b(paramK, paramV.size + (j - i));
    AppMethodBeat.o(61425);
    return paramK;
  }
  
  public final a<e<K, V>> amh(int paramInt)
  {
    AppMethodBeat.i(61426);
    a locala = (a)this.Ods.get(paramInt);
    if (locala == null)
    {
      locala = a.gyX();
      AppMethodBeat.o(61426);
      return locala;
    }
    AppMethodBeat.o(61426);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */