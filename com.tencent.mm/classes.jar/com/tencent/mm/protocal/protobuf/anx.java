package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anx
  extends com.tencent.mm.cd.a
{
  public int RIr;
  public int RIs;
  public int RIt;
  public int RIu;
  public String RIx;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RIr);
      paramVarArgs.aY(2, this.rVU);
      if (this.RIx != null) {
        paramVarArgs.f(3, this.RIx);
      }
      paramVarArgs.aY(4, this.RIs);
      paramVarArgs.aY(5, this.RIt);
      paramVarArgs.aY(6, this.RIu);
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RIr) + 0 + g.a.a.b.b.a.bM(2, this.rVU);
      paramInt = i;
      if (this.RIx != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RIx);
      }
      i = g.a.a.b.b.a.bM(4, this.RIs);
      int j = g.a.a.b.b.a.bM(5, this.RIt);
      int k = g.a.a.b.b.a.bM(6, this.RIu);
      AppMethodBeat.o(127470);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      anx localanx = (anx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127470);
        return -1;
      case 1: 
        localanx.RIr = locala.abFh.AK();
        AppMethodBeat.o(127470);
        return 0;
      case 2: 
        localanx.rVU = locala.abFh.AK();
        AppMethodBeat.o(127470);
        return 0;
      case 3: 
        localanx.RIx = locala.abFh.readString();
        AppMethodBeat.o(127470);
        return 0;
      case 4: 
        localanx.RIs = locala.abFh.AK();
        AppMethodBeat.o(127470);
        return 0;
      case 5: 
        localanx.RIt = locala.abFh.AK();
        AppMethodBeat.o(127470);
        return 0;
      }
      localanx.RIu = locala.abFh.AK();
      AppMethodBeat.o(127470);
      return 0;
    }
    AppMethodBeat.o(127470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anx
 * JD-Core Version:    0.7.0.1
 */