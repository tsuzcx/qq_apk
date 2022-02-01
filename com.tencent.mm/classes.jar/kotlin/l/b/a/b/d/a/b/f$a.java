package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum f$a
{
  public final boolean aaTA;
  public final boolean aaTz;
  
  static
  {
    AppMethodBeat.i(57712);
    aaTv = new a("NON_STABLE_DECLARED", 0, false, false);
    aaTw = new a("STABLE_DECLARED", 1, true, false);
    aaTx = new a("NON_STABLE_SYNTHESIZED", 2, false, true);
    aaTy = new a("STABLE_SYNTHESIZED", 3, true, true);
    aaTB = new a[] { aaTv, aaTw, aaTx, aaTy };
    AppMethodBeat.o(57712);
  }
  
  private f$a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aaTz = paramBoolean1;
    this.aaTA = paramBoolean2;
  }
  
  public static a bz(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57711);
    Object localObject;
    if (paramBoolean1) {
      if (paramBoolean2) {
        localObject = aaTy;
      }
    }
    while (localObject == null)
    {
      localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get" }));
      AppMethodBeat.o(57711);
      throw ((Throwable)localObject);
      localObject = aaTw;
      continue;
      if (paramBoolean2) {
        localObject = aaTx;
      } else {
        localObject = aaTv;
      }
    }
    AppMethodBeat.o(57711);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */