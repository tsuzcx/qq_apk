package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  private final String ToI;
  private final boolean ToJ;
  
  static
  {
    AppMethodBeat.i(57552);
    a locala1 = new a("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
    ToE = locala1;
    a locala2 = new a("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
    ToF = locala2;
    a locala3 = new a("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
    ToG = locala3;
    ToH = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(57552);
  }
  
  private d$a(String paramString, boolean paramBoolean)
  {
    this.ToI = paramString;
    this.ToJ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.d.a
 * JD-Core Version:    0.7.0.1
 */