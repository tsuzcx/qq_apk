package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum f$a
{
  public final boolean TqF;
  public final boolean TqG;
  
  static
  {
    AppMethodBeat.i(57712);
    TqB = new a("NON_STABLE_DECLARED", 0, false, false);
    TqC = new a("STABLE_DECLARED", 1, true, false);
    TqD = new a("NON_STABLE_SYNTHESIZED", 2, false, true);
    TqE = new a("STABLE_SYNTHESIZED", 3, true, true);
    TqH = new a[] { TqB, TqC, TqD, TqE };
    AppMethodBeat.o(57712);
  }
  
  private f$a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.TqF = paramBoolean1;
    this.TqG = paramBoolean2;
  }
  
  public static a bp(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57711);
    Object localObject;
    if (paramBoolean1) {
      if (paramBoolean2) {
        localObject = TqE;
      }
    }
    while (localObject == null)
    {
      localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get" }));
      AppMethodBeat.o(57711);
      throw ((Throwable)localObject);
      localObject = TqC;
      continue;
      if (paramBoolean2) {
        localObject = TqD;
      } else {
        localObject = TqB;
      }
    }
    AppMethodBeat.o(57711);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */