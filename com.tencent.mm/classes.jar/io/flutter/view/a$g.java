package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum a$g
{
  static
  {
    AppMethodBeat.i(9687);
    KSi = new g("UNKNOWN", 0);
    KSj = new g("LTR", 1);
    KSk = new g("RTL", 2);
    KSl = new g[] { KSi, KSj, KSk };
    AppMethodBeat.o(9687);
  }
  
  private a$g() {}
  
  public static g agG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return KSi;
    case 1: 
      return KSk;
    }
    return KSj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.view.a.g
 * JD-Core Version:    0.7.0.1
 */