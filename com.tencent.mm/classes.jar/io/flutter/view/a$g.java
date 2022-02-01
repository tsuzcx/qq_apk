package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum a$g
{
  static
  {
    AppMethodBeat.i(9687);
    MJh = new g("UNKNOWN", 0);
    MJi = new g("LTR", 1);
    MJj = new g("RTL", 2);
    MJk = new g[] { MJh, MJi, MJj };
    AppMethodBeat.o(9687);
  }
  
  private a$g() {}
  
  public static g ajh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return MJh;
    case 1: 
      return MJj;
    }
    return MJi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.view.a.g
 * JD-Core Version:    0.7.0.1
 */