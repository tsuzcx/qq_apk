package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fcr
  extends com.tencent.mm.cd.a
{
  public int RLs;
  public int RLt;
  public int RLu;
  public int RLv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RLs);
      paramVarArgs.aY(2, this.RLt);
      paramVarArgs.aY(3, this.RLu);
      paramVarArgs.aY(4, this.RLv);
      AppMethodBeat.o(32498);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RLs);
      int i = g.a.a.b.b.a.bM(2, this.RLt);
      int j = g.a.a.b.b.a.bM(3, this.RLu);
      int k = g.a.a.b.b.a.bM(4, this.RLv);
      AppMethodBeat.o(32498);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32498);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fcr localfcr = (fcr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32498);
        return -1;
      case 1: 
        localfcr.RLs = locala.abFh.AK();
        AppMethodBeat.o(32498);
        return 0;
      case 2: 
        localfcr.RLt = locala.abFh.AK();
        AppMethodBeat.o(32498);
        return 0;
      case 3: 
        localfcr.RLu = locala.abFh.AK();
        AppMethodBeat.o(32498);
        return 0;
      }
      localfcr.RLv = locala.abFh.AK();
      AppMethodBeat.o(32498);
      return 0;
    }
    AppMethodBeat.o(32498);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcr
 * JD-Core Version:    0.7.0.1
 */