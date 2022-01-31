package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bft
  extends com.tencent.mm.bv.a
{
  public String xuG;
  public String xuH;
  public int xuI;
  public int xuJ;
  public int xuK;
  public int xuL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58915);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xuG != null) {
        paramVarArgs.e(1, this.xuG);
      }
      if (this.xuH != null) {
        paramVarArgs.e(2, this.xuH);
      }
      paramVarArgs.aO(3, this.xuI);
      paramVarArgs.aO(4, this.xuJ);
      paramVarArgs.aO(5, this.xuK);
      paramVarArgs.aO(7, this.xuL);
      AppMethodBeat.o(58915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xuG == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = e.a.a.b.b.a.f(1, this.xuG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xuH != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xuH);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xuI);
      int j = e.a.a.b.b.a.bl(4, this.xuJ);
      int k = e.a.a.b.b.a.bl(5, this.xuK);
      int m = e.a.a.b.b.a.bl(7, this.xuL);
      AppMethodBeat.o(58915);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(58915);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bft localbft = (bft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          AppMethodBeat.o(58915);
          return -1;
        case 1: 
          localbft.xuG = locala.CLY.readString();
          AppMethodBeat.o(58915);
          return 0;
        case 2: 
          localbft.xuH = locala.CLY.readString();
          AppMethodBeat.o(58915);
          return 0;
        case 3: 
          localbft.xuI = locala.CLY.sl();
          AppMethodBeat.o(58915);
          return 0;
        case 4: 
          localbft.xuJ = locala.CLY.sl();
          AppMethodBeat.o(58915);
          return 0;
        case 5: 
          localbft.xuK = locala.CLY.sl();
          AppMethodBeat.o(58915);
          return 0;
        }
        localbft.xuL = locala.CLY.sl();
        AppMethodBeat.o(58915);
        return 0;
      }
      AppMethodBeat.o(58915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bft
 * JD-Core Version:    0.7.0.1
 */