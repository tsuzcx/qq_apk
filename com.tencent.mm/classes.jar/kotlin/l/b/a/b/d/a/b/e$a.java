package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum e$a
{
  public final boolean aiRA;
  public final boolean aiRB;
  
  static
  {
    AppMethodBeat.i(57712);
    aiRw = new a("NON_STABLE_DECLARED", 0, false, false);
    aiRx = new a("STABLE_DECLARED", 1, true, false);
    aiRy = new a("NON_STABLE_SYNTHESIZED", 2, false, true);
    aiRz = new a("STABLE_SYNTHESIZED", 3, true, true);
    aiRC = new a[] { aiRw, aiRx, aiRy, aiRz };
    AppMethodBeat.o(57712);
  }
  
  private e$a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aiRA = paramBoolean1;
    this.aiRB = paramBoolean2;
  }
  
  public static a ca(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(57711);
    Object localObject;
    if (paramBoolean1) {
      if (paramBoolean2) {
        localObject = aiRz;
      }
    }
    while (localObject == null)
    {
      localObject = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[] { "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get" }));
      AppMethodBeat.o(57711);
      throw ((Throwable)localObject);
      localObject = aiRx;
      continue;
      if (paramBoolean2) {
        localObject = aiRy;
      } else {
        localObject = aiRw;
      }
    }
    AppMethodBeat.o(57711);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.e.a
 * JD-Core Version:    0.7.0.1
 */