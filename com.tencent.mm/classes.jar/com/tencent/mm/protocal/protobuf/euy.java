package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class euy
  extends com.tencent.mm.cd.a
{
  public int Height;
  public int SvP;
  public String UwJ;
  public String UwK;
  public int UwL;
  public int UwM;
  public int Width;
  public int X;
  public int Y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120960);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.X);
      paramVarArgs.aY(2, this.Y);
      paramVarArgs.aY(3, this.Width);
      paramVarArgs.aY(4, this.Height);
      if (this.UwJ != null) {
        paramVarArgs.f(5, this.UwJ);
      }
      if (this.UwK != null) {
        paramVarArgs.f(6, this.UwK);
      }
      paramVarArgs.aY(7, this.UwL);
      paramVarArgs.aY(8, this.SvP);
      paramVarArgs.aY(9, this.UwM);
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.X) + 0 + g.a.a.b.b.a.bM(2, this.Y) + g.a.a.b.b.a.bM(3, this.Width) + g.a.a.b.b.a.bM(4, this.Height);
      paramInt = i;
      if (this.UwJ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UwJ);
      }
      i = paramInt;
      if (this.UwK != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.UwK);
      }
      paramInt = g.a.a.b.b.a.bM(7, this.UwL);
      int j = g.a.a.b.b.a.bM(8, this.SvP);
      int k = g.a.a.b.b.a.bM(9, this.UwM);
      AppMethodBeat.o(120960);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      euy localeuy = (euy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(120960);
        return -1;
      case 1: 
        localeuy.X = locala.abFh.AK();
        AppMethodBeat.o(120960);
        return 0;
      case 2: 
        localeuy.Y = locala.abFh.AK();
        AppMethodBeat.o(120960);
        return 0;
      case 3: 
        localeuy.Width = locala.abFh.AK();
        AppMethodBeat.o(120960);
        return 0;
      case 4: 
        localeuy.Height = locala.abFh.AK();
        AppMethodBeat.o(120960);
        return 0;
      case 5: 
        localeuy.UwJ = locala.abFh.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 6: 
        localeuy.UwK = locala.abFh.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 7: 
        localeuy.UwL = locala.abFh.AK();
        AppMethodBeat.o(120960);
        return 0;
      case 8: 
        localeuy.SvP = locala.abFh.AK();
        AppMethodBeat.o(120960);
        return 0;
      }
      localeuy.UwM = locala.abFh.AK();
      AppMethodBeat.o(120960);
      return 0;
    }
    AppMethodBeat.o(120960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euy
 * JD-Core Version:    0.7.0.1
 */