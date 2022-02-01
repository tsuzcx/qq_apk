package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;

public enum a$b$b
  implements j.a
{
  private static j.b<b> LtK;
  private final int value;
  
  static
  {
    AppMethodBeat.i(58425);
    Luf = new b("CLASS", 0, 0);
    Lug = new b("INTERFACE", 1, 1);
    Luh = new b("ENUM_CLASS", 2, 2);
    Lui = new b("ENUM_ENTRY", 3, 3);
    Luj = new b("ANNOTATION_CLASS", 4, 4);
    Luk = new b("OBJECT", 5, 5);
    Lul = new b("COMPANION_OBJECT", 6, 6);
    Lum = new b[] { Luf, Lug, Luh, Lui, Luj, Luk, Lul };
    LtK = new j.b() {};
    AppMethodBeat.o(58425);
  }
  
  private a$b$b(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
  }
  
  public static b ahe(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Luf;
    case 1: 
      return Lug;
    case 2: 
      return Luh;
    case 3: 
      return Lui;
    case 4: 
      return Luj;
    case 5: 
      return Luk;
    }
    return Lul;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */