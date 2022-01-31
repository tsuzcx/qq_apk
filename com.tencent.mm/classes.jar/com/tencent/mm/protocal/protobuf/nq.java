package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nq
  extends com.tencent.mm.bv.a
{
  public int wCH;
  public int wCI;
  public int wCJ;
  public int wCK;
  public int wCL;
  public int wCM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58897);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wCH);
      paramVarArgs.aO(2, this.wCI);
      paramVarArgs.aO(3, this.wCJ);
      paramVarArgs.aO(4, this.wCK);
      paramVarArgs.aO(5, this.wCL);
      paramVarArgs.aO(6, this.wCM);
      AppMethodBeat.o(58897);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wCH);
      int i = e.a.a.b.b.a.bl(2, this.wCI);
      int j = e.a.a.b.b.a.bl(3, this.wCJ);
      int k = e.a.a.b.b.a.bl(4, this.wCK);
      int m = e.a.a.b.b.a.bl(5, this.wCL);
      int n = e.a.a.b.b.a.bl(6, this.wCM);
      AppMethodBeat.o(58897);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(58897);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      nq localnq = (nq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(58897);
        return -1;
      case 1: 
        localnq.wCH = locala.CLY.sl();
        AppMethodBeat.o(58897);
        return 0;
      case 2: 
        localnq.wCI = locala.CLY.sl();
        AppMethodBeat.o(58897);
        return 0;
      case 3: 
        localnq.wCJ = locala.CLY.sl();
        AppMethodBeat.o(58897);
        return 0;
      case 4: 
        localnq.wCK = locala.CLY.sl();
        AppMethodBeat.o(58897);
        return 0;
      case 5: 
        localnq.wCL = locala.CLY.sl();
        AppMethodBeat.o(58897);
        return 0;
      }
      localnq.wCM = locala.CLY.sl();
      AppMethodBeat.o(58897);
      return 0;
    }
    AppMethodBeat.o(58897);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nq
 * JD-Core Version:    0.7.0.1
 */