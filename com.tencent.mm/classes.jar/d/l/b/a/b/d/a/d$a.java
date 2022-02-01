package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  private final String JxF;
  private final boolean JxG;
  
  static
  {
    AppMethodBeat.i(57552);
    a locala1 = new a("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
    JxB = locala1;
    a locala2 = new a("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
    JxC = locala2;
    a locala3 = new a("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
    JxD = locala3;
    JxE = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(57552);
  }
  
  private d$a(String paramString, boolean paramBoolean)
  {
    this.JxF = paramString;
    this.JxG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.d.a
 * JD-Core Version:    0.7.0.1
 */