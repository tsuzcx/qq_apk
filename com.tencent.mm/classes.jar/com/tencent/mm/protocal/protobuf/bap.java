package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bap
  extends com.tencent.mm.cd.a
{
  public int SER;
  public int SES;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203920);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(2, this.SER);
      paramVarArgs.aY(3, this.SES);
      AppMethodBeat.o(203920);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(2, this.SER);
      int i = g.a.a.b.b.a.bM(3, this.SES);
      AppMethodBeat.o(203920);
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
      AppMethodBeat.o(203920);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bap localbap = (bap)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203920);
        return -1;
      case 2: 
        localbap.SER = locala.abFh.AK();
        AppMethodBeat.o(203920);
        return 0;
      }
      localbap.SES = locala.abFh.AK();
      AppMethodBeat.o(203920);
      return 0;
    }
    AppMethodBeat.o(203920);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bap
 * JD-Core Version:    0.7.0.1
 */