package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.e;

public final class j
{
  static enum a
    implements e<Object, Boolean>
  {
    static
    {
      AppMethodBeat.i(90230);
      OxO = new a("INSTANCE");
      OxP = new a[] { OxO };
      AppMethodBeat.o(90230);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     rx.internal.util.j
 * JD-Core Version:    0.7.0.1
 */