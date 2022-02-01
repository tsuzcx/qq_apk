package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aen
  extends com.tencent.mm.bx.a
{
  public int IIs;
  public int Njs;
  public int YRD;
  public int Zmz;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124478);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Njs);
      paramVarArgs.bS(2, this.IIs);
      paramVarArgs.bS(3, this.Zmz);
      paramVarArgs.bS(4, this.vhk);
      paramVarArgs.bS(5, this.YRD);
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Njs);
      int i = i.a.a.b.b.a.cJ(2, this.IIs);
      int j = i.a.a.b.b.a.cJ(3, this.Zmz);
      int k = i.a.a.b.b.a.cJ(4, this.vhk);
      int m = i.a.a.b.b.a.cJ(5, this.YRD);
      AppMethodBeat.o(124478);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aen localaen = (aen)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124478);
        return -1;
      case 1: 
        localaen.Njs = locala.ajGk.aar();
        AppMethodBeat.o(124478);
        return 0;
      case 2: 
        localaen.IIs = locala.ajGk.aar();
        AppMethodBeat.o(124478);
        return 0;
      case 3: 
        localaen.Zmz = locala.ajGk.aar();
        AppMethodBeat.o(124478);
        return 0;
      case 4: 
        localaen.vhk = locala.ajGk.aar();
        AppMethodBeat.o(124478);
        return 0;
      }
      localaen.YRD = locala.ajGk.aar();
      AppMethodBeat.o(124478);
      return 0;
    }
    AppMethodBeat.o(124478);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aen
 * JD-Core Version:    0.7.0.1
 */