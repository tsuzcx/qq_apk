package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum a$g
{
  static
  {
    AppMethodBeat.i(9687);
    JeH = new g("UNKNOWN", 0);
    JeI = new g("LTR", 1);
    JeJ = new g("RTL", 2);
    JeK = new g[] { JeH, JeI, JeJ };
    AppMethodBeat.o(9687);
  }
  
  private a$g() {}
  
  public static g adK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return JeH;
    case 1: 
      return JeJ;
    }
    return JeI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.view.a.g
 * JD-Core Version:    0.7.0.1
 */