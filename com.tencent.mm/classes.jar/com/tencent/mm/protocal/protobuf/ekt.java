package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekt
  extends com.tencent.mm.bw.a
{
  public int Height;
  public int Ltr;
  public String Nka;
  public String Nkb;
  public int Nkc;
  public int Nkd;
  public int Width;
  public int X;
  public int Y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120960);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.X);
      paramVarArgs.aM(2, this.Y);
      paramVarArgs.aM(3, this.Width);
      paramVarArgs.aM(4, this.Height);
      if (this.Nka != null) {
        paramVarArgs.e(5, this.Nka);
      }
      if (this.Nkb != null) {
        paramVarArgs.e(6, this.Nkb);
      }
      paramVarArgs.aM(7, this.Nkc);
      paramVarArgs.aM(8, this.Ltr);
      paramVarArgs.aM(9, this.Nkd);
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.X) + 0 + g.a.a.b.b.a.bu(2, this.Y) + g.a.a.b.b.a.bu(3, this.Width) + g.a.a.b.b.a.bu(4, this.Height);
      paramInt = i;
      if (this.Nka != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Nka);
      }
      i = paramInt;
      if (this.Nkb != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Nkb);
      }
      paramInt = g.a.a.b.b.a.bu(7, this.Nkc);
      int j = g.a.a.b.b.a.bu(8, this.Ltr);
      int k = g.a.a.b.b.a.bu(9, this.Nkd);
      AppMethodBeat.o(120960);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ekt localekt = (ekt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(120960);
        return -1;
      case 1: 
        localekt.X = locala.UbS.zi();
        AppMethodBeat.o(120960);
        return 0;
      case 2: 
        localekt.Y = locala.UbS.zi();
        AppMethodBeat.o(120960);
        return 0;
      case 3: 
        localekt.Width = locala.UbS.zi();
        AppMethodBeat.o(120960);
        return 0;
      case 4: 
        localekt.Height = locala.UbS.zi();
        AppMethodBeat.o(120960);
        return 0;
      case 5: 
        localekt.Nka = locala.UbS.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 6: 
        localekt.Nkb = locala.UbS.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 7: 
        localekt.Nkc = locala.UbS.zi();
        AppMethodBeat.o(120960);
        return 0;
      case 8: 
        localekt.Ltr = locala.UbS.zi();
        AppMethodBeat.o(120960);
        return 0;
      }
      localekt.Nkd = locala.UbS.zi();
      AppMethodBeat.o(120960);
      return 0;
    }
    AppMethodBeat.o(120960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekt
 * JD-Core Version:    0.7.0.1
 */