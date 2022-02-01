package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvd
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public int DGx;
  public int DKW;
  public int DKX;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DGx);
      paramVarArgs.aR(2, this.CHC);
      paramVarArgs.aR(3, this.Scene);
      paramVarArgs.aR(5, this.DKX);
      paramVarArgs.aR(6, this.DKW);
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DGx);
      int i = f.a.a.b.b.a.bA(2, this.CHC);
      int j = f.a.a.b.b.a.bA(3, this.Scene);
      int k = f.a.a.b.b.a.bA(5, this.DKX);
      int m = f.a.a.b.b.a.bA(6, this.DKW);
      AppMethodBeat.o(50118);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvd localdvd = (dvd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      default: 
        AppMethodBeat.o(50118);
        return -1;
      case 1: 
        localdvd.DGx = locala.KhF.xS();
        AppMethodBeat.o(50118);
        return 0;
      case 2: 
        localdvd.CHC = locala.KhF.xS();
        AppMethodBeat.o(50118);
        return 0;
      case 3: 
        localdvd.Scene = locala.KhF.xS();
        AppMethodBeat.o(50118);
        return 0;
      case 5: 
        localdvd.DKX = locala.KhF.xS();
        AppMethodBeat.o(50118);
        return 0;
      }
      localdvd.DKW = locala.KhF.xS();
      AppMethodBeat.o(50118);
      return 0;
    }
    AppMethodBeat.o(50118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvd
 * JD-Core Version:    0.7.0.1
 */