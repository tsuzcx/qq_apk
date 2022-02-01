package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum a$g
{
  static
  {
    AppMethodBeat.i(9687);
    aayG = new g("UNKNOWN", 0);
    aayH = new g("LTR", 1);
    aayI = new g("RTL", 2);
    aayJ = new g[] { aayG, aayH, aayI };
    AppMethodBeat.o(9687);
  }
  
  private a$g() {}
  
  public static g aDC(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return aayG;
    case 1: 
      return aayI;
    }
    return aayH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.view.a.g
 * JD-Core Version:    0.7.0.1
 */