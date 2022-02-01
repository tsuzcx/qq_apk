package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum a$g
{
  static
  {
    AppMethodBeat.i(9687);
    Ngk = new g("UNKNOWN", 0);
    Ngl = new g("LTR", 1);
    Ngm = new g("RTL", 2);
    Ngn = new g[] { Ngk, Ngl, Ngm };
    AppMethodBeat.o(9687);
  }
  
  private a$g() {}
  
  public static g ajR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Ngk;
    case 1: 
      return Ngm;
    }
    return Ngl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.view.a.g
 * JD-Core Version:    0.7.0.1
 */