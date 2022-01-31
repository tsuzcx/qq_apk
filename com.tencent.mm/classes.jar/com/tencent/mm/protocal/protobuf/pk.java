package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pk
  extends com.tencent.mm.bv.a
{
  public String wGR;
  public String wGS;
  public int wGT;
  public int wGU;
  public int wGV;
  public int wGW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96210);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wGR != null) {
        paramVarArgs.e(1, this.wGR);
      }
      if (this.wGS != null) {
        paramVarArgs.e(2, this.wGS);
      }
      paramVarArgs.aO(3, this.wGT);
      paramVarArgs.aO(4, this.wGU);
      paramVarArgs.aO(5, this.wGV);
      paramVarArgs.aO(6, this.wGW);
      AppMethodBeat.o(96210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wGR == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = e.a.a.b.b.a.f(1, this.wGR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wGS != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wGS);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.wGT);
      int j = e.a.a.b.b.a.bl(4, this.wGU);
      int k = e.a.a.b.b.a.bl(5, this.wGV);
      int m = e.a.a.b.b.a.bl(6, this.wGW);
      AppMethodBeat.o(96210);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96210);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        pk localpk = (pk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96210);
          return -1;
        case 1: 
          localpk.wGR = locala.CLY.readString();
          AppMethodBeat.o(96210);
          return 0;
        case 2: 
          localpk.wGS = locala.CLY.readString();
          AppMethodBeat.o(96210);
          return 0;
        case 3: 
          localpk.wGT = locala.CLY.sl();
          AppMethodBeat.o(96210);
          return 0;
        case 4: 
          localpk.wGU = locala.CLY.sl();
          AppMethodBeat.o(96210);
          return 0;
        case 5: 
          localpk.wGV = locala.CLY.sl();
          AppMethodBeat.o(96210);
          return 0;
        }
        localpk.wGW = locala.CLY.sl();
        AppMethodBeat.o(96210);
        return 0;
      }
      AppMethodBeat.o(96210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pk
 * JD-Core Version:    0.7.0.1
 */