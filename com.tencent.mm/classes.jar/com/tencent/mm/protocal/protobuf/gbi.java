package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gbi
  extends com.tencent.mm.bx.a
{
  public int abZI;
  public int abZJ;
  public int abZK;
  public int abZL;
  public int abZM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115910);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abZI);
      paramVarArgs.bS(2, this.abZJ);
      paramVarArgs.bS(3, this.abZK);
      paramVarArgs.bS(4, this.abZL);
      paramVarArgs.bS(5, this.abZM);
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abZI);
      int i = i.a.a.b.b.a.cJ(2, this.abZJ);
      int j = i.a.a.b.b.a.cJ(3, this.abZK);
      int k = i.a.a.b.b.a.cJ(4, this.abZL);
      int m = i.a.a.b.b.a.cJ(5, this.abZM);
      AppMethodBeat.o(115910);
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
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gbi localgbi = (gbi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115910);
        return -1;
      case 1: 
        localgbi.abZI = locala.ajGk.aar();
        AppMethodBeat.o(115910);
        return 0;
      case 2: 
        localgbi.abZJ = locala.ajGk.aar();
        AppMethodBeat.o(115910);
        return 0;
      case 3: 
        localgbi.abZK = locala.ajGk.aar();
        AppMethodBeat.o(115910);
        return 0;
      case 4: 
        localgbi.abZL = locala.ajGk.aar();
        AppMethodBeat.o(115910);
        return 0;
      }
      localgbi.abZM = locala.ajGk.aar();
      AppMethodBeat.o(115910);
      return 0;
    }
    AppMethodBeat.o(115910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbi
 * JD-Core Version:    0.7.0.1
 */