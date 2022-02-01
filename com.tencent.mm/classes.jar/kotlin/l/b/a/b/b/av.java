package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface av
{
  public static final av aiHu = new av()
  {
    public final aw kpk()
    {
      AppMethodBeat.i(56884);
      Object localObject = aw.aiHv;
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
  
  public abstract aw kpk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.av
 * JD-Core Version:    0.7.0.1
 */