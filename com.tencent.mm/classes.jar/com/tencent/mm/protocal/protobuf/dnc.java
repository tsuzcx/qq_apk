package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnc
  extends com.tencent.mm.bx.a
{
  public int EDM;
  public int EDN;
  public int EDO;
  public int EDP;
  public int EDQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115910);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EDM);
      paramVarArgs.aR(2, this.EDN);
      paramVarArgs.aR(3, this.EDO);
      paramVarArgs.aR(4, this.EDP);
      paramVarArgs.aR(5, this.EDQ);
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EDM);
      int i = f.a.a.b.b.a.bA(2, this.EDN);
      int j = f.a.a.b.b.a.bA(3, this.EDO);
      int k = f.a.a.b.b.a.bA(4, this.EDP);
      int m = f.a.a.b.b.a.bA(5, this.EDQ);
      AppMethodBeat.o(115910);
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
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dnc localdnc = (dnc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115910);
        return -1;
      case 1: 
        localdnc.EDM = locala.KhF.xS();
        AppMethodBeat.o(115910);
        return 0;
      case 2: 
        localdnc.EDN = locala.KhF.xS();
        AppMethodBeat.o(115910);
        return 0;
      case 3: 
        localdnc.EDO = locala.KhF.xS();
        AppMethodBeat.o(115910);
        return 0;
      case 4: 
        localdnc.EDP = locala.KhF.xS();
        AppMethodBeat.o(115910);
        return 0;
      }
      localdnc.EDQ = locala.KhF.xS();
      AppMethodBeat.o(115910);
      return 0;
    }
    AppMethodBeat.o(115910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnc
 * JD-Core Version:    0.7.0.1
 */