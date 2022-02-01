package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bns
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public int DGx;
  public int DKW;
  public int DKX;
  public String DKY;
  public int DKZ;
  public int Scene;
  public String dlB;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147770);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aR(3, this.DGx);
      paramVarArgs.aR(4, this.CHC);
      paramVarArgs.aR(5, this.Scene);
      paramVarArgs.aR(6, this.DKW);
      paramVarArgs.aR(7, this.DKX);
      if (this.DKY != null) {
        paramVarArgs.d(8, this.DKY);
      }
      paramVarArgs.aR(9, this.DKZ);
      AppMethodBeat.o(147770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DGx) + f.a.a.b.b.a.bA(4, this.CHC) + f.a.a.b.b.a.bA(5, this.Scene) + f.a.a.b.b.a.bA(6, this.DKW) + f.a.a.b.b.a.bA(7, this.DKX);
      paramInt = i;
      if (this.DKY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DKY);
      }
      i = f.a.a.b.b.a.bA(9, this.DKZ);
      AppMethodBeat.o(147770);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147770);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bns localbns = (bns)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147770);
          return -1;
        case 1: 
          localbns.dlB = locala.KhF.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 2: 
          localbns.username = locala.KhF.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 3: 
          localbns.DGx = locala.KhF.xS();
          AppMethodBeat.o(147770);
          return 0;
        case 4: 
          localbns.CHC = locala.KhF.xS();
          AppMethodBeat.o(147770);
          return 0;
        case 5: 
          localbns.Scene = locala.KhF.xS();
          AppMethodBeat.o(147770);
          return 0;
        case 6: 
          localbns.DKW = locala.KhF.xS();
          AppMethodBeat.o(147770);
          return 0;
        case 7: 
          localbns.DKX = locala.KhF.xS();
          AppMethodBeat.o(147770);
          return 0;
        case 8: 
          localbns.DKY = locala.KhF.readString();
          AppMethodBeat.o(147770);
          return 0;
        }
        localbns.DKZ = locala.KhF.xS();
        AppMethodBeat.o(147770);
        return 0;
      }
      AppMethodBeat.o(147770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bns
 * JD-Core Version:    0.7.0.1
 */