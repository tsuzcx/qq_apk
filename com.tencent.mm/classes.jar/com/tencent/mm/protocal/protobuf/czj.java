package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class czj
  extends com.tencent.mm.bw.a
{
  public int MEF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207014);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).aM(1, this.MEF);
      AppMethodBeat.o(207014);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MEF);
      AppMethodBeat.o(207014);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(207014);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      czj localczj = (czj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207014);
        return -1;
      }
      localczj.MEF = locala.UbS.zi();
      AppMethodBeat.o(207014);
      return 0;
    }
    AppMethodBeat.o(207014);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czj
 * JD-Core Version:    0.7.0.1
 */