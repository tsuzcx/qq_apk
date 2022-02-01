package d.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum f$a
{
  public final boolean JzC;
  public final boolean JzD;
  
  static
  {
    AppMethodBeat.i(57712);
    Jzy = new a("NON_STABLE_DECLARED", 0, false, false);
    Jzz = new a("STABLE_DECLARED", 1, true, false);
    JzA = new a("NON_STABLE_SYNTHESIZED", 2, false, true);
    JzB = new a("STABLE_SYNTHESIZED", 3, true, true);
    JzE = new a[] { Jzy, Jzz, JzA, JzB };
    AppMethodBeat.o(57712);
  }
  
  private f$a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.JzC = paramBoolean1;
    this.JzD = paramBoolean2;
  }
  
  public static a aU(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57711);
    Object localObject;
    if (paramBoolean1) {
      if (paramBoolean2) {
        localObject = JzB;
      }
    }
    while (localObject == null)
    {
      localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get" }));
      AppMethodBeat.o(57711);
      throw ((Throwable)localObject);
      localObject = Jzz;
      continue;
      if (paramBoolean2) {
        localObject = JzA;
      } else {
        localObject = Jzy;
      }
    }
    AppMethodBeat.o(57711);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */