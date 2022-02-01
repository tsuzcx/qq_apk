package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjz
  extends com.tencent.mm.cd.a
{
  public int SUX;
  public String config;
  public int expt_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198823);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SUX);
      if (this.config != null) {
        paramVarArgs.f(2, this.config);
      }
      paramVarArgs.aY(3, this.expt_id);
      AppMethodBeat.o(198823);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SUX) + 0;
      paramInt = i;
      if (this.config != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.config);
      }
      i = g.a.a.b.b.a.bM(3, this.expt_id);
      AppMethodBeat.o(198823);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198823);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bjz localbjz = (bjz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198823);
        return -1;
      case 1: 
        localbjz.SUX = locala.abFh.AK();
        AppMethodBeat.o(198823);
        return 0;
      case 2: 
        localbjz.config = locala.abFh.readString();
        AppMethodBeat.o(198823);
        return 0;
      }
      localbjz.expt_id = locala.abFh.AK();
      AppMethodBeat.o(198823);
      return 0;
    }
    AppMethodBeat.o(198823);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjz
 * JD-Core Version:    0.7.0.1
 */