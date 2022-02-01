package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.v;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.h.q;

public abstract interface g
  extends v, a
{
  public abstract q gce();
  
  public abstract c gcf();
  
  public abstract h gcg();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(60456);
      a locala1 = new a("COMPATIBLE", 0);
      LJr = locala1;
      a locala2 = new a("NEEDS_WRAPPER", 1);
      LJs = locala2;
      a locala3 = new a("INCOMPATIBLE", 2);
      LJt = locala3;
      LJu = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(60456);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.g
 * JD-Core Version:    0.7.0.1
 */