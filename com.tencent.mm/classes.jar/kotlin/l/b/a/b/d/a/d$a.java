package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  private final String aaRC;
  private final boolean aaRD;
  
  static
  {
    AppMethodBeat.i(57552);
    a locala1 = new a("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
    aaRy = locala1;
    a locala2 = new a("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
    aaRz = locala2;
    a locala3 = new a("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
    aaRA = locala3;
    aaRB = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(57552);
  }
  
  private d$a(String paramString, boolean paramBoolean)
  {
    this.aaRC = paramString;
    this.aaRD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.d.a
 * JD-Core Version:    0.7.0.1
 */