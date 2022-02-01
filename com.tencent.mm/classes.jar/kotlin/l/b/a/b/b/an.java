package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface an
{
  public static final an aaKE = new an()
  {
    public final ao iFJ()
    {
      AppMethodBeat.i(56884);
      Object localObject = ao.aaKF;
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
  
  public abstract ao iFJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.an
 * JD-Core Version:    0.7.0.1
 */