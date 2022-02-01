package com.tencent.mm.timelineedit.a.a;

import com.google.d.bj.d;
import com.google.d.cw;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum p
  implements cw
{
  private static final p[] adqT;
  private static final bj.d<p> dLG;
  private final int value;
  
  static
  {
    AppMethodBeat.i(232124);
    adqP = new p("Custom", 0, 0);
    adqQ = new p("CenterCrop", 1, 1);
    adqR = new p("CenterInside", 2, 2);
    adqS = new p("UNRECOGNIZED", 3, -1);
    adqU = new p[] { adqP, adqQ, adqR, adqS };
    dLG = new bj.d() {};
    adqT = values();
    AppMethodBeat.o(232124);
  }
  
  private p(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static p azA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return adqP;
    case 1: 
      return adqQ;
    }
    return adqR;
  }
  
  public final int getNumber()
  {
    AppMethodBeat.i(232132);
    if (this == adqS)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
      AppMethodBeat.o(232132);
      throw localIllegalArgumentException;
    }
    int i = this.value;
    AppMethodBeat.o(232132);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.p
 * JD-Core Version:    0.7.0.1
 */