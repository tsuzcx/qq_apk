package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epk
  extends com.tencent.mm.cd.a
{
  public int SoO;
  public int Usi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203891);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SoO);
      paramVarArgs.aY(2, this.Usi);
      AppMethodBeat.o(203891);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SoO);
      int i = g.a.a.b.b.a.bM(2, this.Usi);
      AppMethodBeat.o(203891);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203891);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      epk localepk = (epk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203891);
        return -1;
      case 1: 
        localepk.SoO = locala.abFh.AK();
        AppMethodBeat.o(203891);
        return 0;
      }
      localepk.Usi = locala.abFh.AK();
      AppMethodBeat.o(203891);
      return 0;
    }
    AppMethodBeat.o(203891);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epk
 * JD-Core Version:    0.7.0.1
 */