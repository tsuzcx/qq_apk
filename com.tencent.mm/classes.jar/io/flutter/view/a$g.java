package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum a$g
{
  static
  {
    AppMethodBeat.i(9687);
    SVU = new g("UNKNOWN", 0);
    SVV = new g("LTR", 1);
    SVW = new g("RTL", 2);
    SVX = new g[] { SVU, SVV, SVW };
    AppMethodBeat.o(9687);
  }
  
  private a$g() {}
  
  public static g atI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return SVU;
    case 1: 
      return SVW;
    }
    return SVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.view.a.g
 * JD-Core Version:    0.7.0.1
 */