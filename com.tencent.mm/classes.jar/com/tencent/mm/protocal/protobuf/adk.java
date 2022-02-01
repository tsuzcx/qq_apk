package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adk
  extends com.tencent.mm.cd.a
{
  public long SoQ;
  public long SoR;
  public int SpI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SoQ);
      paramVarArgs.bm(2, this.SoR);
      paramVarArgs.aY(3, this.SpI);
      AppMethodBeat.o(203531);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.SoQ);
      int i = g.a.a.b.b.a.p(2, this.SoR);
      int j = g.a.a.b.b.a.bM(3, this.SpI);
      AppMethodBeat.o(203531);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203531);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      adk localadk = (adk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203531);
        return -1;
      case 1: 
        localadk.SoQ = locala.abFh.AN();
        AppMethodBeat.o(203531);
        return 0;
      case 2: 
        localadk.SoR = locala.abFh.AN();
        AppMethodBeat.o(203531);
        return 0;
      }
      localadk.SpI = locala.abFh.AK();
      AppMethodBeat.o(203531);
      return 0;
    }
    AppMethodBeat.o(203531);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adk
 * JD-Core Version:    0.7.0.1
 */