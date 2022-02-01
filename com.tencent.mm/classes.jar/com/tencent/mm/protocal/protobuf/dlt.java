package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dlt
  extends com.tencent.mm.bx.a
{
  public long Dea;
  public int EBN;
  public int EBO;
  public int EBP;
  public int EBQ;
  public b EBR;
  public long Erf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Erf);
      paramVarArgs.aG(2, this.Dea);
      paramVarArgs.aR(3, this.EBN);
      paramVarArgs.aR(4, this.EBO);
      paramVarArgs.aR(5, this.EBP);
      paramVarArgs.aR(6, this.EBQ);
      if (this.EBR != null) {
        paramVarArgs.c(7, this.EBR);
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.Erf) + 0 + f.a.a.b.b.a.q(2, this.Dea) + f.a.a.b.b.a.bA(3, this.EBN) + f.a.a.b.b.a.bA(4, this.EBO) + f.a.a.b.b.a.bA(5, this.EBP) + f.a.a.b.b.a.bA(6, this.EBQ);
      paramInt = i;
      if (this.EBR != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.EBR);
      }
      AppMethodBeat.o(125501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dlt localdlt = (dlt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125501);
        return -1;
      case 1: 
        localdlt.Erf = locala.KhF.xT();
        AppMethodBeat.o(125501);
        return 0;
      case 2: 
        localdlt.Dea = locala.KhF.xT();
        AppMethodBeat.o(125501);
        return 0;
      case 3: 
        localdlt.EBN = locala.KhF.xS();
        AppMethodBeat.o(125501);
        return 0;
      case 4: 
        localdlt.EBO = locala.KhF.xS();
        AppMethodBeat.o(125501);
        return 0;
      case 5: 
        localdlt.EBP = locala.KhF.xS();
        AppMethodBeat.o(125501);
        return 0;
      case 6: 
        localdlt.EBQ = locala.KhF.xS();
        AppMethodBeat.o(125501);
        return 0;
      }
      localdlt.EBR = locala.KhF.fMu();
      AppMethodBeat.o(125501);
      return 0;
    }
    AppMethodBeat.o(125501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlt
 * JD-Core Version:    0.7.0.1
 */