package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dty
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public int DGx;
  public int DKW;
  public int DKX;
  public String DKY;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123683);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DGx);
      paramVarArgs.aR(2, this.CHC);
      paramVarArgs.aR(3, this.Scene);
      if (this.DKY != null) {
        paramVarArgs.d(4, this.DKY);
      }
      paramVarArgs.aR(5, this.DKX);
      paramVarArgs.aR(6, this.DKW);
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DGx) + 0 + f.a.a.b.b.a.bA(2, this.CHC) + f.a.a.b.b.a.bA(3, this.Scene);
      paramInt = i;
      if (this.DKY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DKY);
      }
      i = f.a.a.b.b.a.bA(5, this.DKX);
      int j = f.a.a.b.b.a.bA(6, this.DKW);
      AppMethodBeat.o(123683);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dty localdty = (dty)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123683);
        return -1;
      case 1: 
        localdty.DGx = locala.KhF.xS();
        AppMethodBeat.o(123683);
        return 0;
      case 2: 
        localdty.CHC = locala.KhF.xS();
        AppMethodBeat.o(123683);
        return 0;
      case 3: 
        localdty.Scene = locala.KhF.xS();
        AppMethodBeat.o(123683);
        return 0;
      case 4: 
        localdty.DKY = locala.KhF.readString();
        AppMethodBeat.o(123683);
        return 0;
      case 5: 
        localdty.DKX = locala.KhF.xS();
        AppMethodBeat.o(123683);
        return 0;
      }
      localdty.DKW = locala.KhF.xS();
      AppMethodBeat.o(123683);
      return 0;
    }
    AppMethodBeat.o(123683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dty
 * JD-Core Version:    0.7.0.1
 */