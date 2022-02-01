package d.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum f$a
{
  public final boolean NdS;
  public final boolean NdT;
  
  static
  {
    AppMethodBeat.i(57712);
    NdO = new a("NON_STABLE_DECLARED", 0, false, false);
    NdP = new a("STABLE_DECLARED", 1, true, false);
    NdQ = new a("NON_STABLE_SYNTHESIZED", 2, false, true);
    NdR = new a("STABLE_SYNTHESIZED", 3, true, true);
    NdU = new a[] { NdO, NdP, NdQ, NdR };
    AppMethodBeat.o(57712);
  }
  
  private f$a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.NdS = paramBoolean1;
    this.NdT = paramBoolean2;
  }
  
  public static a bg(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57711);
    Object localObject;
    if (paramBoolean1) {
      if (paramBoolean2) {
        localObject = NdR;
      }
    }
    while (localObject == null)
    {
      localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get" }));
      AppMethodBeat.o(57711);
      throw ((Throwable)localObject);
      localObject = NdP;
      continue;
      if (paramBoolean2) {
        localObject = NdQ;
      } else {
        localObject = NdO;
      }
    }
    AppMethodBeat.o(57711);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */