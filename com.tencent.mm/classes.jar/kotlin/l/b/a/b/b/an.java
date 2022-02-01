package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface an
{
  public static final an ThK = new an()
  {
    public final ao hBu()
    {
      AppMethodBeat.i(56884);
      Object localObject = ao.ThL;
      if (localObject == null)
      {
        localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile" }));
        AppMethodBeat.o(56884);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(56884);
      return localObject;
    }
    
    public final String toString()
    {
      return "NO_SOURCE";
    }
  };
  
  public abstract ao hBu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.an
 * JD-Core Version:    0.7.0.1
 */